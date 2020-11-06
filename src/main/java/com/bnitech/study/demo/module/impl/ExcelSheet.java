package com.bnitech.study.demo.module.impl;

import com.bnitech.study.demo.module.ExcelWorkbook;
import com.bnitech.study.demo.module.IExcelSheet;
import com.bnitech.study.demo.module.enumeration.ExcelSheetTheme;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;

public class ExcelSheet<T> implements IExcelSheet<T> {

    private static final SpreadsheetVersion excelVersion = SpreadsheetVersion.EXCEL2007;

    private final Sheet sheet;
    private final ExcelWorkbook<T> workbook;

    private int rowIndex;
    private int columnIndex;

    public ExcelSheet(Sheet sheet, ExcelWorkbook<T> workbook) {
        this.sheet = sheet;
        this.workbook = workbook;

        initSheet();
    }

    private void initSheet() {
        this.rowIndex = 0;
        this.columnIndex = 0;
    }

    @Override
    public ExcelSheet<T> setSheetTheme(ExcelSheetTheme excelSheetTheme) {
        return this;
    }

    @Override
    public void writeWorkbook() throws IOException {
        workbook.write();
    }
}