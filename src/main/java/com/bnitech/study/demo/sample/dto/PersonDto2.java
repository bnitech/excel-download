package com.bnitech.study.demo.sample.dto;

import com.bnitech.study.demo.module.annotation.BlankField;
import com.bnitech.study.demo.module.annotation.Field;
import com.bnitech.study.demo.module.annotation.Merge;
import com.bnitech.study.demo.module.annotation.Sheet;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Sheet(enableMerge = true, enableSetFieldPosition = true)
public class PersonDto2 {

    private long id;

    @Field
    @Merge(rowSpan = 2)
    private final String name;

    @BlankField
    private boolean none;

    @Field(name = "INFO")
    @Merge(colSpan = 2)
    private String info;

    @Field(rowindex = 1, columnIndex = 2)
    private String company;

    @Field(name = "급여", rowindex = 1, columnIndex = 3)
    private int salary;
}