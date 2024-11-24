package com.practice.poi.excel.controller;

import com.practice.poi.excel.model.dto.ExcelDTO;
import com.practice.poi.excel.model.service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("api/excel/teacher")
    public void downloadTeacher(HttpServletResponse response) throws IOException {

//        엑셀 파일 생성
        Workbook wb = new XSSFWorkbook();

//        엘셀 파일 내부에 Sheet 하나 생성
        Sheet sheet = wb.createSheet();

//        엑셀 렌더링에 필요한 DTO 가져오기
        List<ExcelDTO> excelDTO = excelService.getAllTeacherInfo();
        System.out.println("excelDTO = " + excelDTO);

//        헤더 생성 -> rowIndex로 컨트롤 각 헤더마다 이름을 기입해야하는데 간결하게 할 수 있을까?
        int rowIndex = 0;

        Row headerRow = sheet.createRow(rowIndex++);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("선생님번호");

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("선생님이름");

        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("가격");

        Cell headerCell4 = headerRow.createCell(3);
        headerCell4.setCellValue("클래스명");

        for(ExcelDTO excel : excelDTO) {
            Row body = sheet.createRow(rowIndex++);

            Cell bodyCell1 = body.createCell(0);
            bodyCell1.setCellValue(excel.getTeacherNo());

            Cell bodyCell2 = body.createCell(1);
            bodyCell2.setCellValue(excel.getTeacherName());

            Cell bodyCell3 = body.createCell(2);
            bodyCell3.setCellValue(excel.getTeacherPrice());

            Cell bodyCell4 = body.createCell(3);
            bodyCell4.setCellValue(excel.getClassName());
        }

//        엑셀 파일 생성 시 Excel 형식 및 이름을 정하고 다운받도록 하는데 한글이 들어갈 수 없다.
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=teacherList.xls");

//        엑셀 파일 생성시 IOException throws 해야함 그리고 클로즈까지
        wb.write(response.getOutputStream());
        wb.close();
    }

}
