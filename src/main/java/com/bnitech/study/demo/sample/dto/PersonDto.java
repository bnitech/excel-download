package com.bnitech.study.demo.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonDto {
    private long id;
    private String name;
    private String company;
    private int salary;
}