package com.bnitech.study.demo.dto;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.bnitech.study.demo.dao.UserDto;
import com.lannstark.ExcelColumn;
import com.lannstark.ExcelColumnStyle;
import com.lannstark.style.NoExcelCellStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarExcelDto {

	@ExcelColumn(headerName = "회사")
	private String company; // 회사

	@ExcelColumn(headerName = "차종")
	private String name; // 차종

	@ExcelColumn(headerName = "")
	private Boolean blank1 = null; // 공백

	@ExcelColumn
	private List<UserDto> userList; // 가격

	@ExcelColumn(headerName = "가격")
	private int price; // 가격

	@ExcelColumn(headerName = "평점")
	private double rating; // 평점
}
