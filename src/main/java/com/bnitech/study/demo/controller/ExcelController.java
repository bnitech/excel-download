package com.bnitech.study.demo.controller;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.service.ICarService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/api/v1/excel")
@RestController
@RequiredArgsConstructor
public class ExcelController {

	final private ICarService carService;

	@GetMapping(path = "/car")
	public void downloadCarInfo(HttpServletResponse response) throws IOException {

		// Excel 파일 만듬
		Workbook workbook = new SXSSFWorkbook();

		// Excel 시트 만듬
		Sheet sheet = workbook.createSheet();

		CellStyle greyCellStyle = workbook.createCellStyle();
		applyCellStyle(greyCellStyle, new Color(231, 234, 236));

		CellStyle blueCellStyle = workbook.createCellStyle();
		applyCellStyle(blueCellStyle, new Color(223, 235, 246));

		CellStyle bodyCellStyle = workbook.createCellStyle();
		applyCellStyle(bodyCellStyle, new Color(255, 255, 255));

		// Excel 렌더링에 사용되는 DTO
		List<CarExcelDto> carExcelDtoList = carService.getCarInfo();

		// region Header
		int rowIndex = 0;
		Row headerRow = sheet.createRow(rowIndex++);
		Cell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("회사");
		headerCell1.setCellStyle(greyCellStyle);

		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("차종");
		headerCell2.setCellStyle(greyCellStyle);

		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("가격");
		headerCell3.setCellStyle(blueCellStyle);

		Cell headerCell4 = headerRow.createCell(3);
		headerCell4.setCellValue("평점");
		headerCell4.setCellStyle(blueCellStyle);

		// endregion

		// region Body
		for (CarExcelDto dto : carExcelDtoList) {
			Row bodyRow = sheet.createRow(rowIndex++);

			Cell bodyCell1 = bodyRow.createCell(0);
			bodyCell1.setCellValue(dto.getCompany());
			bodyCell1.setCellStyle(bodyCellStyle);

			Cell bodyCell2 = bodyRow.createCell(1);
			bodyCell2.setCellValue(dto.getName());
			bodyCell2.setCellStyle(bodyCellStyle);

			Cell bodyCell3 = bodyRow.createCell(2);
			bodyCell3.setCellValue(dto.getPrice());
			bodyCell3.setCellStyle(bodyCellStyle);

			Cell bodyCell4 = bodyRow.createCell(3);
			bodyCell4.setCellValue(dto.getRating());
			bodyCell4.setCellStyle(bodyCellStyle);
		}
		// endregion

		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		response.setHeader("Content-Disposition", "attachment; filename=\"Car List.xlsx\"");

		workbook.write(response.getOutputStream());
		workbook.close();
	}

	private void applyCellStyle(CellStyle cellStyle, Color color) {
		XSSFCellStyle xssfCellStyle = (XSSFCellStyle)cellStyle;
		xssfCellStyle.setFillForegroundColor(new XSSFColor(color, new DefaultIndexedColorMap()));
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
	}
}
