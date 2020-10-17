package com.bnitech.study.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.service.ICarService;

@Service
public class CarService implements ICarService {

	@Override
	public List<CarExcelDto> getCarInfo() {
		// TODO Connect DB

		List<CarExcelDto> carExcelDtoList = new ArrayList<>();
		carExcelDtoList.add(new CarExcelDto("현대", "소나타", 100, 4.9));
		carExcelDtoList.add(new CarExcelDto("르노삼성", "QM6", 200, 4.9));
		carExcelDtoList.add(new CarExcelDto("기아", "K7", 300, 4.9));

		return carExcelDtoList;
	}
}
