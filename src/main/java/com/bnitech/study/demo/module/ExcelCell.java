package com.bnitech.study.demo.module;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelCell {
	private Cell cell;

	public ExcelCell(Cell cell){
		this.cell = cell;
	}

	public ExcelCell setValue(String value){
		cell.setCellValue(value);
		return this;
	}

	public ExcelCell setBlank(){
		cell.setBlank();
		return this;
	}
}
