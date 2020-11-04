package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelCellDataType;
import com.bnitech.study.demo.module.enumeration.ExcelCellSize;
import com.bnitech.study.demo.module.enumeration.ExcelCellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class ExcelCell {

    private final Sheet sheet;
    private final Cell cell;
    private final XSSFCellStyle cellStyle;
    private final Font font;

    public ExcelCell(Workbook workbook, Sheet sheet, int rowIndex, int columnIndex) {
        this.sheet = sheet;
        this.cell = createCell(rowIndex, columnIndex);
        this.cellStyle = (XSSFCellStyle) workbook.createCellStyle();
        this.font = workbook.createFont();
    }

    private Cell createCell(int rowIndex, int columnIndex) {
        return getRow(rowIndex).createCell(columnIndex);
    }

    private Row getRow(int rowIndex) {
        return sheet.getRow(rowIndex) == null ? sheet.createRow(rowIndex) : sheet.getRow(rowIndex);
    }

    public ExcelCell setExcelCellType(ExcelCellType excelCellType) {
        if(excelCellType == ExcelCellType.BLANK){
            cell.setBlank();
            return this;
        }

        setCellStyle(excelCellType);
        setCellSize(excelCellType.getCellSize());
        setCellDataType(excelCellType.getDataType());
        return this;
    }

    private void setCellStyle(ExcelCellType excelCellType) {

        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        cellStyle.setFillForegroundColor(excelCellType.getCellColor().getIndex());

        switch (excelCellType) {
            case DEFAULT_HEADER:
            case HIDE_HEADER:
                font.setBold(true);
                break;
            case IMPORTANT_VALUE:
            default:
                font.setBold(false);
                break;
        }

        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
    }

    private void setCellSize(ExcelCellSize excelCellSize) {
        sheet.setColumnWidth(cell.getColumnIndex(), excelCellSize.getCellWidth());
    }

    private void setCellDataType(ExcelCellDataType excelCellDataType) {
    }

    public ExcelCell setExcelCellValue(Object value) {
        if (cell == null) return this;

        if (value instanceof String) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Integer) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Long) {
            cell.setCellValue(String.valueOf(value));
        }

        return this;
    }

}
