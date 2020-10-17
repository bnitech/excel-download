package com.bnitech.study.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.service.ICarService;

@RequestMapping(path = "/api/v1/excel")
@RestController
public class ExcelController {

	private ICarService carService;

	@Autowired
	ExcelController(ICarService carService) {
		this.carService = carService;
	}

	@GetMapping(path = "/car")
	public void downloadCarInfo(HttpServletResponse response) throws IOException {

		// Excel 파일 만듬
		Workbook workbook = new SXSSFWorkbook();

		// Excel 시트 만듬
		Sheet sheet = workbook.createSheet();

		// Excel 렌더링에 사용되는 DTO
		List<CarExcelDto> carExcelDtoList = carService.getCarInfo();

		// region Header
		int rowIndex = 0;
		Row headerRow = sheet.createRow(rowIndex++);
		Cell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("회사");

		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("차종");

		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("가격");

		Cell headerCell4 = headerRow.createCell(3);
		headerCell4.setCellValue("평점");
		// endregion

		// region Body
		for (CarExcelDto dto : carExcelDtoList) {
			Row bodyRow = sheet.createRow(rowIndex++);

			Cell bodyCell1 = bodyRow.createCell(0);
			bodyCell1.setCellValue(dto.getCompany());

			Cell bodyCell2 = bodyRow.createCell(1);
			bodyCell2.setCellValue(dto.getName());

			Cell bodyCell3 = bodyRow.createCell(2);
			bodyCell3.setCellValue(dto.getPrice());

			Cell bodyCell4 = bodyRow.createCell(3);
			bodyCell4.setCellValue(dto.getRating());
		}
		// endregion

		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		response.setHeader("Content-Disposition", "attachment; filename=\"Car List.xlsx\"");

		workbook.write(response.getOutputStream());
		workbook.close();
	}
}
