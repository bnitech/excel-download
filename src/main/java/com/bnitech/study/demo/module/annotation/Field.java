package com.bnitech.study.demo.module.annotation;

import com.bnitech.study.demo.module.enumeration.ExcelCellTheme;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
public @interface Field {
    String name() default ""; // default 변수 명

    ExcelCellTheme theme() default ExcelCellTheme.DEFAULT_HEADER;

    int rowindex() default 0;

    int columnIndex() default 0;
}
