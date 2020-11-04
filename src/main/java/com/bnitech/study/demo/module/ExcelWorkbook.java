package com.bnitech.study.demo.module;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;

public abstract class ExcelWorkbook {

    protected Workbook workbook;
    protected OutputStream outputStream;

    public ExcelWorkbook(Workbook workbook, OutputStream outputStream) {
        this.workbook = workbook;
        this.outputStream = outputStream;
    }

    public ExcelSheet createSheet() {
        return new ExcelSheet(workbook, workbook.createSheet());
    }

    public ExcelSheet createSheet(String name) {
        return new ExcelSheet(workbook, workbook.createSheet(name));
    }

    public void write() throws IOException {
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
