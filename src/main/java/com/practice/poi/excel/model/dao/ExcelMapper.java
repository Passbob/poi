package com.practice.poi.excel.model.dao;

import com.practice.poi.excel.model.dto.ExcelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelMapper {
    List<ExcelDTO> getAllTeacherInfo();
}
