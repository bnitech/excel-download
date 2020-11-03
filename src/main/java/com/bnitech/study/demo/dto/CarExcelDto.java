package com.bnitech.study.demo.dto;

import com.github.ckpoint.toexcel.annotation.ExcelHeader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    @ExcelHeader(headerName = "가격")
    private int price; // 가격

    @ExcelHeader(headerName = "평점")
    private double rating; // 평점

    private List<UserDto> userList;

    public CarExcelDto(String company, String name, int price, double rating, List<UserDto> userList) {
        this.company = company;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.userList = userList;
    }
}
