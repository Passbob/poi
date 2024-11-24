package com.practice.poi.excel.model.service;

import com.practice.poi.excel.model.dao.ExcelMapper;
import com.practice.poi.excel.model.dto.ExcelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService {

    private final ExcelMapper excelMapper;

    @Autowired
    public ExcelService(ExcelMapper excelMapper) {
        this.excelMapper = excelMapper;
    }

    public List<ExcelDTO> getAllTeacherInfo() {

        return excelMapper.getAllTeacherInfo();
    }
}
