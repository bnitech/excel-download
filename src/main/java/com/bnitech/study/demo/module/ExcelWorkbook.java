package com.bnitech.study.demo.module;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelWorkbook {

	private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;

	private SXSSFWorkbook wb;

	public ExcelWorkbook() {
		wb = new SXSSFWorkbook();
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
}
