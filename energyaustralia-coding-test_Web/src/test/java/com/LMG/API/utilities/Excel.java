package com.LMG.API.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Excel {
    public String getExcelData(String sheetName, int rowNum,int colNum) throws IOException {
        String retVal=null;
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/"+"Book2.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        Sheet s=wb.getSheet(sheetName);
        Row r=s.getRow(rowNum);
        Cell c=r.getCell(colNum);
        retVal=c.getStringCellValue();

        return  retVal;
    }
    public String getTimeValue(String sheetName, int rowNum, int colNum) throws IOException, ParseException {
        Date d;
        String l;
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/"+"Book2.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        Sheet s=wb.getSheet(sheetName);
        Row r=s.getRow(rowNum);
        Cell c=r.getCell(colNum);
        d=c.getDateCellValue();
        int a=d.getHours();
        int b=d.getMinutes();
        int c1=d.getSeconds();
        l=a+":"+b+":"+c1;
        return  l;
    }

    public int getLasRowNumber(String sheetName) throws IOException {
        int retVal=0;
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/"+"Book2.xlsx");
        Workbook wb=WorkbookFactory.create(fis);
        Sheet s=wb.getSheet(sheetName);
        retVal=s.getLastRowNum();
        return  retVal;
    }
}
