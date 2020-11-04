package com.bnitech.study.demo.module.impl;

import com.bnitech.study.demo.module.ExcelWorkbook;
import com.bnitech.study.demo.module.IExcelSheet;
import com.bnitech.study.demo.module.enumeration.ExcelCellTheme;
import lombok.Getter;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.LinkedList;
import java.util.List;

import static com.bnitech.study.demo.module.enumeration.ExcelCellTheme.BLANK;

public class ExcelSheet implements IExcelSheet {

    private static final SpreadsheetVersion excelVersion = SpreadsheetVersion.EXCEL2007;

    private final Sheet sheet;
    private final ExcelWorkbook workbook;

    @Getter
    private final List<ExcelCell> excelFieldList;

    private int rowIndex;
    private int columnIndex;

    public ExcelSheet(Sheet sheet, ExcelWorkbook workbook) {
        this.sheet = sheet;
        this.workbook = workbook;
        this.excelFieldList = new LinkedList<>();
        this.rowIndex = 0;
        this.columnIndex = 0;
    }

    @Override
    public int addField(ExcelCellTheme excelCellTheme, Object value) {
        excelFieldList.add(createExcelCell().decorateExcelCell(excelCellTheme).setExcelCellValue(value));
        return rowIndex;
    }

    @Override
    public int addFields(ExcelCellTheme excelCellTheme, Object... values) {
        for (Object value : values) {
            excelFieldList.add(createExcelCell().decorateExcelCell(excelCellTheme).setExcelCellValue(value));
        }
        return rowIndex;
    }

    @Override
    public int addBlankField() {
        excelFieldList.add(createExcelCell().decorateExcelCell(BLANK));
        return rowIndex;
    }

    @Override
    public int addBlankFields(int fieldNum) {
        while (fieldNum-- > 0) {
            excelFieldList.add(createExcelCell().decorateExcelCell(BLANK));
        }
        return rowIndex;
    }

    @Override
    public void addRecord(ExcelCellTheme excelCellTheme, Object... values) {
        newLine();
        for (Object value : values) {
            createExcelCell().decorateExcelCell(excelCellTheme).setExcelCellValue(value);
        }
    }

    @Override
    public void mergeRows(int columnIndex, int frontIndex, int rearIndex) {
        sheet.addMergedRegion(new CellRangeAddress(frontIndex, rearIndex, columnIndex, columnIndex));
    }

    @Override
    public void mergeColumns(int rowIndex, int frontIndex, int rearIndex) {
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, frontIndex, rearIndex));
    }

    @Override
    public void newLine() {
        rowIndex++;
        columnIndex = 0;
    }

    @Override
    public void setFieldWidth(int columnIndex, int columnWidth) {
        sheet.setColumnWidth(columnIndex, columnWidth);
    }

    private Row getRow(int rowIndex) {
        return sheet.getRow(rowIndex) == null ? sheet.createRow(rowIndex) : sheet.getRow(rowIndex);
    }

    private ExcelCell createExcelCell() {
        return new ExcelCell(createCell(), this, workbook.createCellStyle(), workbook.createCellFont());
    }

    private Cell createCell() {
        return getRow(rowIndex).createCell(columnIndex++);
    }
}