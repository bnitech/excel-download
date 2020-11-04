package com.bnitech.study.demo.module.enumeration;

import lombok.Getter;
import org.apache.poi.ss.usermodel.IndexedColors;

import static com.bnitech.study.demo.module.enumeration.ExcelCellDataType.STRING;
import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.NORMAL;
import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.TINY;
import static org.apache.poi.ss.usermodel.IndexedColors.*;

@Getter
public enum ExcelCellTheme {
    DEFAULT_HEADER(GREY_25_PERCENT, STRING, NORMAL),
    HIDE_HEADER(GREY_25_PERCENT, STRING, TINY),
    DEFAULT_VALUE(WHITE, STRING, NORMAL),
    IMPORTANT_VALUE(RED, STRING, NORMAL),
    BLANK(BLACK, STRING, NORMAL);

    private IndexedColors cellColor;
    private ExcelCellDataType dataType;
    private ExcelCellSize cellSize;

    ExcelCellTheme(IndexedColors cellColor, ExcelCellDataType dataType, ExcelCellSize cellSize) {
        this.cellColor = cellColor;
        this.dataType = dataType;
        this.cellSize = cellSize;
    }
}