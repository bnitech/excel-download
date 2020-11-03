package com.bnitech.study.demo.service;

import com.bnitech.study.demo.dto.CarExcelDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class ICarServiceTest {

    private final ICarService carService;

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
            System.out.println(carExcelDto);
        }
    }

    @Test
    void setCarInfo() {
        CarExcelDto carExcelDto = new CarExcelDto("회사", "차종", 500, 3.0, Collections.emptyList());
        carService.setCarInfo(carExcelDto, 100L);
    }
}