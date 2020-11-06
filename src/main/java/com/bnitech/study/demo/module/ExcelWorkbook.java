package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelSheetTheme;
import com.bnitech.study.demo.module.impl.ExcelSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class ExcelWorkbook<T> {

    protected final Workbook workbook;
    protected final CellStyle cellStyle;
    protected final Font font;

    protected HttpServletResponse response;
    protected OutputStream outputStream;

    public ExcelWorkbook(Workbook workbook) {
        this.workbook = workbook;
        this.cellStyle = workbook.createCellStyle();
        this.font = workbook.createFont();
    }

    public ExcelWorkbook(Workbook workbook, OutputStream outputStream) {
        this(workbook);
        this.outputStream = outputStream;
    }

    public ExcelWorkbook(Workbook workbook, HttpServletResponse response) throws IOException {
        this(workbook, response.getOutputStream());
        this.response = response;
    }

    public ExcelWorkbook<T> setExcelFileName(String fileName) {
        if (response == null) return this;

        if (StringUtils.isEmpty(fileName)) fileName = "No Name";

        if (workbook instanceof SXSSFWorkbook) {
            fileName += ".xlsx";
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return this;
    }

    public ExcelWorkbook<T> setData(List<T> dataList) {
        if (dataList.isEmpty()) return this;
        else {

        }
        return this;
    }

    public ExcelWorkbook<T> setWorkbookTheme(ExcelSheetTheme excelSheetTheme) {
        return this;
    }

    public ExcelSheet<T> createSheet() {
        return new ExcelSheet<T>(workbook.createSheet(), this);
    }

    public ExcelSheet<T> createSheet(String name) {
        return new ExcelSheet<T>(workbook.createSheet(name), this);
    }

    public void write() throws IOException {
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
