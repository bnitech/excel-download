package com.bnitech.study.demo.module.impl;

import com.bnitech.study.demo.module.ExcelWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class SXSSFExcelWorkbook<T> extends ExcelWorkbook<T> {

    public SXSSFExcelWorkbook(OutputStream outputStream) {
        super(new SXSSFWorkbook(), outputStream);
    }

    public SXSSFExcelWorkbook(HttpServletResponse response) throws IOException {
        super(new SXSSFWorkbook(), response.getOutputStream());
    }
}
