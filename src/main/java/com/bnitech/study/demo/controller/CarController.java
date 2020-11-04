package com.bnitech.study.demo.controller;

import com.bnitech.study.demo.dto.CarExcelDto;
import com.bnitech.study.demo.dto.UserDto;
import com.bnitech.study.demo.module.ExcelSheet;
import com.bnitech.study.demo.module.ExcelWorkbook;
import com.bnitech.study.demo.service.ICarService;
import com.github.ckpoint.toexcel.core.ToWorkBook;
import com.github.ckpoint.toexcel.core.ToWorkSheet;
import com.github.ckpoint.toexcel.core.type.SheetDirection;
import com.github.ckpoint.toexcel.core.type.ToWorkBookType;
import com.lannstark.excel.ExcelFile;
import com.lannstark.excel.onesheet.OneSheetExcelFile;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequestMapping(path = "/api")
@RestController
@RequiredArgsConstructor
public class CarController {

    final private ICarService carService;

    @GetMapping(path = "/car")
    public List<CarExcelDto> getCarInfo() {
        return carService.getCarInfo();
    }

    @GetMapping(path = "/car/excel/v1")
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
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) cellStyle;
        // xssfCellStyle.setFillForegroundColor(new XSSFColor(color, new DefaultIndexedColorMap()));
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
    }

    @GetMapping("/car/excel/v2")
    public void downloadCarInfoByLannstark(HttpServletResponse response) throws IOException {
        List<CarExcelDto> excelDtoList = carService.getCarInfo();
        ExcelFile excelFile = new OneSheetExcelFile<>(excelDtoList, CarExcelDto.class);

        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setHeader("Content-Disposition", "attachment; filename=\"Test List.xlsx\"");

        excelFile.write(response.getOutputStream());
    }

    @GetMapping("/car/excel/v3")
    public void downloadCarInfoByCkpoint(HttpServletResponse response) throws IOException {
        final int USER_NUM = 2;

        ToWorkBook workBook = new ToWorkBook(ToWorkBookType.XSSF);
        ToWorkSheet sheet = workBook.createSheet().updateDirection(SheetDirection.HORIZON);

        List<CarExcelDto> carExcelDtoList = carService.getCarInfo();

        // 첫번째 줄
        sheet.createTitleCell(1, "회사");
        sheet.merge(1, 2);

        sheet.createTitleCell(1, "차종");
        sheet.merge(1, 2);

        // 빈칸
        sheet.createTitleCell(1, "");
        sheet.merge(1, 2);

        sheet.createTitleCell(USER_NUM, "사용자 목록");
        sheet.merge(USER_NUM, 1);

        sheet.createTitleCell(1, "가격");
        sheet.merge(1, 2);

        sheet.createTitleCell(1, "평점");
        sheet.merge(1, 2);

        // 사용자 이름 타이틀 생성
        List<String> userNameTitleList = new ArrayList<>();
        for (int i = 1; i <= USER_NUM; i++) {
            userNameTitleList.add("사용자" + i + "-이름");
        }

        // 두번째 줄
        sheet.newLine();
        sheet.createTitleCell(1, userNameTitleList.toArray(new String[0]));

        // 세번째(나머지) 줄
        for (CarExcelDto carExcelDto : carExcelDtoList) {
            Stream<Object> result = Stream.of(carExcelDto.getCompany(), carExcelDto.getName(), "");
            result = Stream.concat(result, carExcelDto.getUserList().stream().map(UserDto::getName));
            result = Stream.concat(result, Stream.of(carExcelDto.getPrice(), carExcelDto.getRating()));
            sheet.createCellToNewline(result.toArray());
        }

        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setHeader("Content-Disposition", "attachment; filename=\"Test List.xlsx\"");

        workBook.write(response.getOutputStream());
    }

    @GetMapping("/car/excel/v4")
    public void downloadCarInfoByExcelWorkbook(HttpServletResponse response) throws IOException {
//        ExcelWorkbook workbook = new ExcelWorkbook();
//        ExcelSheet sheet = workbook.createSheet();
//
//        // Excel 렌더링에 사용되는 DTO
//        List<CarExcelDto> carExcelDtoList = carService.getCarInfo();
//
//        // region Header
//        sheet.createHeader("회사");
//        sheet.createHeader("차종");
//        sheet.createHeader();
//        sheet.createHeader("가격");
//        sheet.createHeader("평점");
//        // endregion
//
//        // region Body
////        for (CarExcelDto carExcelDto : carExcelDtoList) {
////            System.out.println(carExcelDto);
////            sheet.createBodyRow(
////                    carExcelDto.getCompany(),
////                    carExcelDto.getName(),
////                    "",
////                    String.valueOf(carExcelDto.getPrice()),
////                    String.valueOf(carExcelDto.getRating())
////            );
////        }
//        // endregion
//
//        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
//        response.setHeader("Content-Disposition", "attachment; filename=\"Car List.xlsx\"");
//
//        workbook.write(response.getOutputStream());
    }
}
