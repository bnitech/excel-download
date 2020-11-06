package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelSheetTheme;

import java.io.IOException;

public interface IExcelSheet<T> {
    IExcelSheet<T> setSheetTheme(ExcelSheetTheme excelSheetTheme);

    void writeWorkbook() throws IOException;
}