package com.bnitech.study.demo.dto;

import com.lannstark.ExcelColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CarExcelDto {

	@ExcelColumn(headerName = "회사")
	private final String company; // 회사

	@ExcelColumn(headerName = "차종")
	private final String name; // 차종

	@ExcelColumn(headerName = "가격")
	private final int price; // 가격

	@ExcelColumn(headerName = "평점")
	private final double rating; // 평점

}
