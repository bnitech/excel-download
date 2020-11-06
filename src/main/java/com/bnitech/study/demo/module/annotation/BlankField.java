package com.bnitech.study.demo.module.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
public @interface BlankField {
    int num() default 1;
}
