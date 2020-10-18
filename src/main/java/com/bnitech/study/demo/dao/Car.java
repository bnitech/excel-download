package com.bnitech.study.demo.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car {
	@Id
	private long id;
	private String company;
	private String name;
	private int price;
	private double rating;
}
