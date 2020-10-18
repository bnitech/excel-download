package com.bnitech.study.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bnitech.study.demo.dao.Car;
import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.dto.UserDto;
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
			CarExcelDto carExcelDto = new CarExcelDto();
			carExcelDto.setCompany(car.getCompany());
			carExcelDto.setName(car.getName());

			List<UserDto> userDtoList = new ArrayList<>();

			UserDto userDto1 = new UserDto();
			userDto1.setName("A");
			userDto1.setAge(123);
			userDtoList.add(userDto1);
			UserDto userDto2 = new UserDto();
			userDto2.setName("A");
			userDto2.setAge(123);
			userDtoList.add(userDto2);
			carExcelDto.setUserList(userDtoList);

			carExcelDto.setPrice(car.getPrice());
			carExcelDto.setRating(car.getRating());
			carExcelDtoList.add(carExcelDto);
		}

		return carExcelDtoList;
	}
}
