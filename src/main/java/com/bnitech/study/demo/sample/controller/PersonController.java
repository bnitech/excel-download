package com.bnitech.study.demo.sample.controller;

import com.bnitech.study.demo.module.impl.ExcelSheet;
import com.bnitech.study.demo.module.impl.SXSSFExcelWorkbook;
import com.bnitech.study.demo.sample.dto.PersonDto;
import com.bnitech.study.demo.sample.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.bnitech.study.demo.module.enumeration.ExcelSheetTheme.DARK;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService personService;

    @GetMapping("/person/all")
    public List<PersonDto> getPersonInfoList() {
        return personService.getPersonList();
    }

    @GetMapping("/person/excel")
    public void getPersonInfoListByExcel(HttpServletResponse response) throws IOException {

        ExcelSheet<PersonDto> sheet = new SXSSFExcelWorkbook<PersonDto>(response)
                .setExcelFileName("설문 참여 조사")
                .setWorkbookTheme(DARK)
                .setData(personService.getPersonList())
                .createSheet("1차 조사")
                .setSheetTheme(DARK);

        sheet.writeWorkbook();
    }
}