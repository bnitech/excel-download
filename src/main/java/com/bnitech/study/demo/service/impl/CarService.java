package com.bnitech.study.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnitech.study.demo.dao.Car;
import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.repository.CarRepository;
import com.bnitech.study.demo.service.ICarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

	final private CarRepository carRepository;

	@Override
	public List<CarExcelDto> getCarInfo() {

		List<Car> carList = carRepository.findAll();

		List<CarExcelDto> carExcelDtoList = new ArrayList<>();
		for (Car car : carList) {
			carExcelDtoList.add(new CarExcelDto(
				car.getCompany(),
				car.getName(),
				car.getPrice(),
				car.getRating()
			));
		}

		return carExcelDtoList;
	}
}
