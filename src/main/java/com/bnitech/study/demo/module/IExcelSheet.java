package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelCellTheme;
import com.bnitech.study.demo.module.impl.ExcelCell;

import java.util.List;

public interface IExcelSheet {
    int addField(ExcelCellTheme excelCellTheme, Object value);

    int addFields(ExcelCellTheme excelCellTheme, Object... values);

    int addBlankField();

    int addBlankFields(int fieldNum);

    void addRecord(ExcelCellTheme excelCellTheme, Object... values);

    void mergeRows(int columnIndex, int frontIndex, int rearIndex);

    void mergeColumns(int rowIndex, int frontIndex, int rearIndex);

    void newLine();

    void setFieldWidth(int columnIndex, int columnWidth);

    List<ExcelCell> getExcelFieldList();
}