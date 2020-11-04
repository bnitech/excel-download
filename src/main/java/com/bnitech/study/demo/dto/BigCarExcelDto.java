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
public class BigCarExcelDto extends CarExcelDto {

    @ExcelHeader(headerName = "BIG")
    private String company; // 회사

    @ExcelHeader(headerName = "BIG")
    private String name; // 차종

    @ExcelHeader(headerName = "BIG")
    private int price; // 가격

    @ExcelHeader(headerName = "BIG")
    private double rating; // 평점

    private List<UserDto> userList;
}
