## Excel Download Info

- Spring boot
- POI
- JPA
- Hibernate
- H2Database

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
