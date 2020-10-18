package com.bnitech.study.demo.dto;

import java.util.List;

import com.github.ckpoint.toexcel.annotation.ExcelHeader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarExcelDto {

	@ExcelHeader(headerName = "회사")
	private String company; // 회사

	@ExcelHeader(headerName = "차종")
	private String name; // 차종

	@ExcelHeader(headerName = "")
	private Boolean blank = null; // 공백

	private List<UserDto> userList;

	@ExcelHeader(headerName = "가격")
	private int price; // 가격

	@ExcelHeader(headerName = "평점")
	private double rating; // 평점
}
