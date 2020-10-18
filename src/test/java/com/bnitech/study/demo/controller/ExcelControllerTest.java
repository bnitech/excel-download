package com.bnitech.study.demo.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.bnitech.study.demo.repository.CarRepository;
import com.bnitech.study.demo.service.ICarService;
import com.bnitech.study.demo.service.impl.CarService;

@SpringBootTest
@AutoConfigureMockMvc
class ExcelControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CarRepository carRepository;

	@InjectMocks
	private ICarService carService;

	@Test
	void downloadCarInfo() {
		// TODO: MOCK MVC
	}
}