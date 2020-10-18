package com.bnitech.study.demo.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnitech.study.demo.dto.CarExcelDto;

@SpringBootTest
class ICarServiceTest {

	private ICarService carService;

	@Autowired
	public ICarServiceTest(ICarService carService) {
		this.carService = carService;
	}

	@Test
	void getCarInfo() {
		List<CarExcelDto> carExcelDtoList = carService.getCarInfo();

		Assertions.assertNotNull(carExcelDtoList);
		Assertions.assertFalse(carExcelDtoList.isEmpty());

		for (CarExcelDto carExcelDto : carExcelDtoList) {
			System.out.println(carExcelDto.getName());
		}

	}
}