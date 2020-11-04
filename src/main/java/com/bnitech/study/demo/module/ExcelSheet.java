package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelCellType;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static com.bnitech.study.demo.module.enumeration.ExcelCellType.BLANK;

public class ExcelSheet {

    private static final SpreadsheetVersion supplyExcelVersion = SpreadsheetVersion.EXCEL2007;

    private final Workbook workbook;
    private final Sheet sheet;
    private final List<ExcelCell> excelFieldList;

    private int rowIndex;
    private int columnIndex;

    public ExcelSheet(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.excelFieldList = new LinkedList<>();

        this.rowIndex = 0;
        this.columnIndex = 0;
    }

    public int addField(ExcelCellType excelCellType, Object value) {
        excelFieldList.add(createExcelCell().setExcelCellType(excelCellType).setExcelCellValue(value));
        return rowIndex;
    }

    public int addFields(ExcelCellType excelCellType, Object... values) {
        for (Object value : values) {
            excelFieldList.add(createExcelCell().setExcelCellType(excelCellType).setExcelCellValue(value));
        }
        return rowIndex;
    }

    public int addBlankField() {
        excelFieldList.add(createExcelCell().setExcelCellType(BLANK));
        return rowIndex;
    }

    public int addBlankFields(int fieldNum) {
        while (fieldNum-- > 0) {
            excelFieldList.add(createExcelCell().setExcelCellType(BLANK));
        }
        return rowIndex;
    }

    public void addRecord(ExcelCellType excelCellType, Object... values) {
        newLine();
        for (Object value : values) {
            createExcelCell().setExcelCellType(excelCellType).setExcelCellValue(value);
        }
    }

    public void mergeRows(int columnIndex, int frontIndex, int rearIndex) {
        sheet.addMergedRegion(new CellRangeAddress(frontIndex, rearIndex, columnIndex, columnIndex));
    }

    public void mergeColumns(int rowIndex, int frontIndex, int rearIndex) {
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, frontIndex, rearIndex));
    }

    public void newLine() {
        rowIndex++;
        columnIndex = 0;
    }

    private ExcelCell createExcelCell() {
        return new ExcelCell(workbook, sheet, rowIndex, columnIndex++);
    }
}