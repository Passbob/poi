package com.practice.poi.excel.model.dto;

public class ExcelDTO {


    private int teacherNo;
    private String teacherName;
    private int teacherPrice;
    private String className;

    public ExcelDTO(){}

    public ExcelDTO(int teacherNo, String teacherName, int teacherPrice, String className) {
        this.teacherNo = teacherNo;
        this.teacherName = teacherName;
        this.teacherPrice = teacherPrice;
        this.className = className;
    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherPrice() {
        return teacherPrice;
    }

    public void setTeacherPrice(int teacherPrice) {
        this.teacherPrice = teacherPrice;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ExcelDTO{" +
                "teacherNo=" + teacherNo +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPrice=" + teacherPrice +
                ", className='" + className + '\'' +
                '}';
    }
}
