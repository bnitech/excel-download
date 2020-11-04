package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.impl.ExcelSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;

public abstract class ExcelWorkbook {

    protected final Workbook workbook;
    protected final OutputStream outputStream;

    public ExcelWorkbook(Workbook workbook, OutputStream outputStream) {
        this.workbook = workbook;
        this.outputStream = outputStream;
    }

    public ExcelSheet createSheet() {
        return new ExcelSheet(workbook.createSheet(), this);
    }

    public ExcelSheet createSheet(String name) {
        return new ExcelSheet(workbook.createSheet(name), this);
    }

    public CellStyle createCellStyle() {
        return workbook.createCellStyle();
    }

    public Font createCellFont() {
        return workbook.createFont();
    }

    public void writeWorkbook() throws IOException {
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
