package com.bnitech.study.demo.module.enumeration;

import lombok.Getter;
import org.apache.poi.ss.usermodel.IndexedColors;

import static com.bnitech.study.demo.module.enumeration.ExcelCellDataType.STRING;
import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.NORMAL;
import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.TINY;
import static org.apache.poi.ss.usermodel.IndexedColors.*;

@Getter
public enum ExcelSheetTheme {
    WHITE, DARK
}