package com.bnitech.study.demo.module.enumeration;

import lombok.Getter;

@Getter
public enum ExcelCellSize {
    TINY(300), NORMAL(3000), BIG(6000);

    private final int cellWidth;

    ExcelCellSize(int cellWidth) {
        this.cellWidth = cellWidth;
    }

}
