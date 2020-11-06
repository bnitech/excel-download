package com.bnitech.study.demo.module.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target(FIELD)
public @interface Merge {
    int rowSpan() default 0;
    int colSpan() default 0;
}
