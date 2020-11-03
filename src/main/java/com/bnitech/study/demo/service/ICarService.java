package com.bnitech.study.demo.service;

import java.util.List;

import com.bnitech.study.demo.dto.CarExcelDto;

public interface ICarService {
	List<CarExcelDto> getCarInfo();
    void setCarInfo(CarExcelDto carExcelDto, long carId);
}
