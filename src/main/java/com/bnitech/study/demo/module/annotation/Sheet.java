package com.bnitech.study.demo.module.annotation;

import com.bnitech.study.demo.module.enumeration.ExcelSheetTheme;

import java.lang.annotation.Target;

import static com.bnitech.study.demo.module.enumeration.ExcelSheetTheme.WHITE;
import static java.lang.annotation.ElementType.TYPE;

@Target(TYPE)
public @interface Sheet {
    boolean enableMerge() default false;

    ExcelSheetTheme excelSheetTheme() default WHITE;

    boolean enableSetFieldPosition() default false;
}
