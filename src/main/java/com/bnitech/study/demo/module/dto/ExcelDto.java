package com.bnitech.study.demo.module.dto;

import com.bnitech.study.demo.module.ExcelHeader;

public abstract class ExcelDto {

    protected ExcelHeader excelHeader;

    abstract protected void setExcelHeader(ExcelHeader excelHeader);

    abstract protected int getExcelValue();
}

