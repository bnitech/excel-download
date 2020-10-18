package com.bnitech.study.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bnitech.study.demo.dao.Car;

@SpringBootTest
class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;

	@Test
	void testFindAll() {
		List<Car> carList = carRepository.findAll();

		Assertions.assertNotNull(carList);
		Assertions.assertFalse(carList.isEmpty());

		for (Car car : carList) {
			// TODO : toString()
			System.out.println(car);
		}
	}
}