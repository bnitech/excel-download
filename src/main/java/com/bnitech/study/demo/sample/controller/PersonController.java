package com.bnitech.study.demo.sample.controller;

import com.bnitech.study.demo.module.ExcelSheet;
import com.bnitech.study.demo.module.ExcelWorkbook;
import com.bnitech.study.demo.sample.dto.PersonDto;
import com.bnitech.study.demo.sample.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setHeader("Content-Disposition", "attachment; filename=\"Car List.xlsx\"");

        ExcelWorkbook workbook = new ExcelWorkbook(response.getOutputStream(), PersonDto.class);
        ExcelSheet sheet = workbook.createSheet();

        workbook.write();
    }
}