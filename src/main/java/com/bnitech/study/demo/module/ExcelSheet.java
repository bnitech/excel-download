package com.bnitech.study.demo.module;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelSheet {
	private final static int DEFAULT_WIDTH_SIZE = 2000;
	private final static int TINY_WIDTH_SIZE = 200;

	private int rowIndex;
	private int columnIndex;

	private Sheet sheet;

	public ExcelSheet(Sheet sheet) {
		this.sheet = sheet;
		this.rowIndex = 0;
		this.columnIndex = 0;
	}

	private Row getRow() {
		return sheet.getRow(rowIndex) == null ? sheet.createRow(rowIndex) : sheet.getRow(rowIndex);
	}

	public ExcelCell createHeader() {
		sheet.setColumnWidth(columnIndex, DEFAULT_WIDTH_SIZE);
		return new ExcelCell(getRow().createCell(columnIndex++)).setBlank();
	}

	public ExcelCell createTinyHeader() {
		sheet.setColumnWidth(columnIndex, TINY_WIDTH_SIZE);
		return new ExcelCell(getRow().createCell(columnIndex++)).setBlank();
	}

	public ExcelCell createHeader(String value) {
		sheet.setColumnWidth(columnIndex, DEFAULT_WIDTH_SIZE);
		return new ExcelCell(getRow().createCell(columnIndex++)).setValue(value);
	}

	public ExcelCell createTinyHeader(String value) {
		sheet.setColumnWidth(columnIndex, TINY_WIDTH_SIZE);
		return new ExcelCell(getRow().createCell(columnIndex++)).setValue(value);
	}

	public void createBodyRow(String... values) {
		newLine();
		for (String value : values) {
			new ExcelCell(sheet.createRow(rowIndex).createCell(columnIndex++)).setValue(value);
		}

	}

	public void newLine() {
		rowIndex++;
		columnIndex = 0;
	}
}