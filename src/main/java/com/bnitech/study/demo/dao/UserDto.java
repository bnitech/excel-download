package com.bnitech.study.demo.dao;

import com.lannstark.ExcelColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	@ExcelColumn(headerName = "사용자 이름")
	private String name;

	@ExcelColumn
	private int age;
}
