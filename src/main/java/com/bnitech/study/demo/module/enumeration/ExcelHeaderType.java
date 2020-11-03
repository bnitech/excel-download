package com.bnitech.study.demo.module.enumeration;

import org.apache.poi.ss.usermodel.CellType;

import java.awt.*;

import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.NORMAL;
import static com.bnitech.study.demo.module.enumeration.ExcelCellSize.TINY;
import static java.awt.Color.*;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public enum ExcelHeaderType {
    DEFAULT_HEADER(BLACK, STRING, NORMAL),
    HIDE_HEADER(GRAY, STRING, TINY),
    IMPORTANT_VALUE(RED, STRING, NORMAL);

    private Color cellColor;
    private CellType dataType;
    private ExcelCellSize cellSize;

    ExcelHeaderType(Color cellColor, CellType dataType, ExcelCellSize cellSize) {
        this.cellColor = cellColor;
        this.dataType = dataType;
        this.cellSize = cellSize;
    }
}