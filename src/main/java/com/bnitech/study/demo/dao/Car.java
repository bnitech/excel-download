package com.bnitech.study.demo.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private long id;
	private String company;
	private String name;
	private int price;
	private double rating;

	public Car() {
	}

	public long getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
