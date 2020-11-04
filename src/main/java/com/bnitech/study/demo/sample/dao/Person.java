package com.bnitech.study.demo.sample.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Person {
    @Id
    private long id;
    private String name;
    private String company;
    private int salary;
}