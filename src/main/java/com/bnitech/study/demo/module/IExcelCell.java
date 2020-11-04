package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelCellTheme;
import com.bnitech.study.demo.module.impl.ExcelCell;

public interface IExcelCell {
    ExcelCell decorateExcelCell(ExcelCellTheme excelCellTheme);

    ExcelCell setExcelCellValue(Object value);
}