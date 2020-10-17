package com.bnitech.study.demo.dto;

public class CarExcelDto {
	private final String company; // 회사
	private final String name; // 차종
	private final int price; // 가격
	private final double rating; // 평점

	public CarExcelDto(String company, String name, int price, double rating) {
		this.company = company;
		this.name = name;
		this.price = price;
		this.rating = rating;
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
}
