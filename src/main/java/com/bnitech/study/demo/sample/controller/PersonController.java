package com.bnitech.study.demo.sample.controller;

import com.bnitech.study.demo.module.ExcelSheet;
import com.bnitech.study.demo.module.SXSSFExcelWorkbook;
import com.bnitech.study.demo.sample.dto.PersonDto;
import com.bnitech.study.demo.sample.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static com.bnitech.study.demo.module.enumeration.ExcelCellType.*;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService personService;

    @GetMapping("/person/all")
    public List<PersonDto> getPersonInfoList() {
        return personService.getPersonList();
    }

    @GetMapping("/person/{personId}")
    public PersonDto getPersonInfo(@PathVariable long personId) {
        return personService.getPerson(personId);
    }

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

        workbook.write();
    }
}