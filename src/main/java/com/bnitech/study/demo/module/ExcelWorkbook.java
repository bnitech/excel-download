package com.bnitech.study.demo.module;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

public class ExcelWorkbook {

    private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;

    private SXSSFWorkbook wb;
    private OutputStream outputStream;
    private Class<?> aClass;

    public ExcelWorkbook() {
        wb = new SXSSFWorkbook();
    }

    public ExcelWorkbook(OutputStream stream, Class<?> aClass) {
        this();
        this.outputStream = stream;
        this.aClass = aClass;
    }

    public ExcelSheet createSheet() {
        return new ExcelSheet(wb.createSheet());
    }

    public ExcelSheet createSheet(String name) {
        return new ExcelSheet(wb.createSheet(name));
    }

    public void write(OutputStream stream) throws IOException {
        wb.write(stream);
        wb.close();
        wb.dispose();
        stream.close();
    }

    public void write() throws IOException {
        wb.write(outputStream);
        wb.close();
        wb.dispose();
        outputStream.close();
    }
}
