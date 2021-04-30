package com.cybertek.library.Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelTest {

    @Test
    public void addBooks() throws IOException {

        String path = "TestApache.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("NewBooks");

        //row starts from 0, BUT we need to skip 0 because it has column names
        //cell starts from 0








    }

}
