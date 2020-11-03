package com.bnitech.study.demo.service;

import com.bnitech.study.demo.dto.CarExcelDto;

import java.util.List;

public interface ICarService {
    List<CarExcelDto> getCarInfo();

    void setCarInfo(CarExcelDto carExcelDto, long carId);
}
