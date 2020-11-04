package com.bnitech.study.demo.module.impl;

import com.bnitech.study.demo.module.ExcelWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class SXSSFExcelWorkbook extends ExcelWorkbook {

    public SXSSFExcelWorkbook(OutputStream outputStream) {
        super(new SXSSFWorkbook(), outputStream);
    }

    public SXSSFExcelWorkbook(HttpServletResponse response, String fileName) throws IOException {
        super(new SXSSFWorkbook(), response.getOutputStream());

        if (StringUtils.isEmpty(fileName)) fileName = "No Name";
        fileName += ".xlsx";

        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    }
}
