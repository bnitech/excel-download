package com.bnitech.study.demo.module.impl;

import com.bnitech.study.demo.module.ExcelWorkbook;
import com.bnitech.study.demo.module.IExcelCell;
import com.bnitech.study.demo.module.IExcelSheet;
import com.bnitech.study.demo.module.enumeration.ExcelCellDataType;
import com.bnitech.study.demo.module.enumeration.ExcelCellSize;
import com.bnitech.study.demo.module.enumeration.ExcelCellTheme;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * Cell의 생성과 세팅을 담당한다.
 */
public class ExcelCell implements IExcelCell {

    private final Cell cell;
    private final IExcelSheet sheet;
    private final XSSFCellStyle cellStyle;
    private final Font font;

    public ExcelCell(Cell cell, IExcelSheet sheet, CellStyle cellStyle, Font font) {
        this.cell = cell;
        this.sheet = sheet;
        this.cellStyle = (XSSFCellStyle) cellStyle;
        this.font = font;
    }

    /**
     * {@link ExcelCellTheme}을 활용해 Cell 속성 세팅
     */
    @Override
    public ExcelCell decorateExcelCell(ExcelCellTheme excelCellTheme) {
        if (excelCellTheme == ExcelCellTheme.BLANK) {
            cell.setBlank();
            return this;
        }

        setCellStyle(excelCellTheme);
        setCellSize(excelCellTheme.getCellSize());
        setCellDataType(excelCellTheme.getDataType());
        return this;
    }

    @Override
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

    /**
     * Cell Style 적용
     */
    private void setCellStyle(ExcelCellTheme excelCellTheme) {

        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        cellStyle.setFillForegroundColor(excelCellTheme.getCellColor().getIndex());

        switch (excelCellTheme) {
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

    /**
     * Cell Width Size 조절
     */
    private void setCellSize(ExcelCellSize excelCellSize) {
        sheet.setFieldWidth(cell.getColumnIndex(), excelCellSize.getCellWidth());
    }

    /**
     * Cell Date Type 세팅
     */
    private void setCellDataType(ExcelCellDataType excelCellDataType) {
    }
}
