package com.cybertek.library.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelSetUp {

    public static FileInputStream fileInputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet excelSheet;

    public static XSSFSheet readSetUp(String path, String sheet) {

        try {
            String excelPath = path;
            fileInputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fileInputStream);
            excelSheet = workbook.getSheet(sheet);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return excelSheet;
    }
    }
