
## 개발 환경

- Spring boot
- POI
- JPA
- Hibernate
- H2Database  

## AS-IS (기존 방식의 단점)

아래의 요소들로 인하여 코드의 가독성 낮아질 뿐만 아니라 개발자의 실수를 쉽게 만들어 낸다
- Cell에 대한 row와 column의 index값이 매직넘버로 표현되고 있으며 일일이 관리해 주어야한다.
- Cell style 적용을 위한 CellStyle객체 관리가 까다롭다.
- Cell 객체에 값, 타입, 스타일 설정을 위한 반복적인 코드가 코드 전체를 beautiful 하지 않도록 만든다.
- Column(Header) 구역과 Row(Body) 구역에 대한 구분이 없다.
- Row(body) 입력에 대한 형식(layout)이 존재하지 않는다.

## TO-BE (기대효과)  

필수적인 코드들을 추상화 하고 캡슐화 하여 불필요한 변수 관리를 줄이고 반복되는 공통의 코드를 줄여서 직관적인 기능구현이 가능하도록 한다.

- 이해하기 쉬운 Name (추상화)
  - POI library에서 제공하는 함수들로 실제 추출되는 Excel Data 양식을 상상하는 것은 쉬운일이 아니다.
  - {모듈} 의 함수를 Excel Data 양식을 상상할 수 있도록 네이밍하여 {모듈} 사용자 즉, 개발자가 손쉽게 Excel Data 구조를 설계할 수 있도록 한다.
  - ex>
    - addField(), addRecord(), mergeFields()

- 간결한 코딩 (캡슐화)
  - 불필요하게 노출되어 관리 해줘야만하는 코드들과 반복적인 공통의 코드들을 숨긴다.
  - ex>
    - row와 column의 index를 구현 클래스에 노출시키지 않는다.
    - 전용 Cell Type을 사용
      - Type 맞는 setting과 validation check를 내부적으로 수행한다.
      - Null 값을 핸들링한다. (중복되는 Null 처리 코드 제거)

## 기능
1. 전용 Cell Type 생성
    - Option
      - Color (=Theme)
        - White (font: black, background: white) 
        - Gray (font: bold-black, background: gray)
        - Red (font: white, background: red)
        - Green (font:white, background: green)
      - Data Type
        - String, Number, Date, Blank
      - Size
        - Tiny, Normal, Big
    - 설명
      - 위와 같은 Option은 Type(constant) 형태로 관리되며 기본적인 Type만 제공 하되, 추가  및 커스터마이징이 가능하도록한다.
      - ex> 
        - HIDE_HEADER:
          - Layer: Header
          - Color: Gray
          - Data Type: String
          - Size: Tiny
        - IMPORTANT_VALUE:
          - Layer: Body
          - Color: Red
          - Data Type: String
          - Size: Normal
2. 빈 행/열 추가
3. Merge
4. Line by Line 값(Record) 추가
    - 코드 한줄에 하나의 Record(cell 묶음)입력이 가능하도록 한다.

## Guide Code
~~~ java

@GetMapping("/person/excel")
public void getPersonInfoListByExcel(HttpServletResponse response) throws IOException {

    SXSSFExcelWorkbook workbook = new SXSSFExcelWorkbook(response, "Person List");
    ExcelSheet sheet = workbook.createSheet();

    sheet.addField(DEFAULT_HEADER, "ID");
    sheet.mergeRows(0, 0, 1);
    sheet.addBlankField();
    sheet.addField(DEFAULT_HEADER, "INFO");
    sheet.mergeColumns(0, 2, 4);

    sheet.newLine();
    sheet.addBlankFields(2);
    sheet.addFields(DEFAULT_HEADER, "NAME", "COMPANY", "SALARY");

    List<PersonDto> personDtoList = personService.getPersonList();
    for (PersonDto personDto : personDtoList) {
        Stream<Object> values = Stream.of(personDto.getId(), "", personDto.getName(), personDto.getCompany(), personDto.getSalary());
        sheet.addRecord(DEFAULT_VALUE, values.toArray());
    }

    workbook.writeWorkbook();
}
~~~

## Ver.2 기능 (예정)
- Header의 Field(column)와 Body의 Record(row) 매핑
- Import (Excel to Data)
