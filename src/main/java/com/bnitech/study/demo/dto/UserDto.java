package com.bnitech.study.demo.dto;

import com.github.ckpoint.toexcel.annotation.ExcelHeader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	@ExcelHeader(headerName = "이름")
	private String name;

	@ExcelHeader(headerName = "나이")
	private int age;
}
