package com.bnitech.study.demo.sample.dto;

import com.bnitech.study.demo.module.ExcelHeader;
import com.bnitech.study.demo.module.dto.ExcelDto;

public class PersonDto extends ExcelDto {

    @Override
    protected void setExcelHeader(ExcelHeader excelHeader) {
        super.excelHeader = excelHeader;
    }

    @Override
    protected int getExcelValue() {
        return 0;
    }
}