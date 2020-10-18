package com.bnitech.study.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CarExcelDto {
	private final String company; // 회사
	private final String name; // 차종
	private final int price; // 가격
	private final double rating; // 평점
}
