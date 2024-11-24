package com.practice.poi.excel.controller;

import com.practice.poi.excel.model.dto.ExcelDTO;
import com.practice.poi.excel.model.service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("api/excel/teacher")
    public void downloadTeacher(HttpServletResponse response) {

//        엑셀 파일 생성
        Workbook wb = new XSSFWorkbook();

//        엘셀 파일 내부에 Sheet 하나 생성
        Sheet sheet = wb.createSheet();

//        엑셀 렌더링에 필요한 DTO 가져오기
        List<ExcelDTO> excelDTO = excelService.getAllTeacherInfo();
        System.out.println("excelDTO = " + excelDTO);

//        헤더 생성 -> rowIndex로 컨트롤 각 헤더마다 이름을 기입해야하는데 간결하게 할 수 있을까?



    }

}
