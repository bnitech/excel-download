package com.bnitech.study.demo.module;

import com.bnitech.study.demo.module.enumeration.ExcelHeaderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.bnitech.study.demo.module.enumeration.ExcelHeaderType.DEFAULT_HEADER;

@Getter
@Setter
@AllArgsConstructor
public class ExcelHeader {
    private ExcelHeaderType headerType = DEFAULT_HEADER;
    private String headerTitle;
}
