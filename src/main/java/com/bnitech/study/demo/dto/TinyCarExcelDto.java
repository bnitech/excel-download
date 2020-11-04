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
public class TinyCarExcelDto extends CarExcelDto {

    @ExcelHeader(headerName = "TINY")
    private String company; // 회사

    @ExcelHeader(headerName = "TINY")
    private String name; // 차종

    @ExcelHeader(headerName = "TINY")
    private int price; // 가격

    @ExcelHeader(headerName = "TINY")
    private double rating; // 평점

    private List<UserDto> userList;

}
