package com.eliteguzhva;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


public class XlsxBuilder {
    public boolean build(String filename)
    {
        try {
            createFile(filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void createFile(String filename) throws IOException {
        SXSSFWorkbook wb = new SXSSFWorkbook(10);
        SXSSFSheet sheet1 = wb.createSheet("First sheet");
        SXSSFSheet sheet2 = wb.createSheet("Second sheet");

        CellStyle style = wb.createCellStyle();
        style.setWrapText(true);
        Font font = wb.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short)10);
        style.setFont(font);

        SXSSFRow row;
        SXSSFCell cell;

        // sheet 1
        // row 1
        row = sheet1.createRow(0);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("First value");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(4);
        cell.setCellStyle(style);

        // row 2
        row = sheet1.createRow(1);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Second value");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(6);
        cell.setCellStyle(style);

        // row 3
        row = sheet1.createRow(2);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Sum");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.FORMULA);
        cell.setCellFormula("SUM(B1:B2)");
        cell.setCellStyle(style);

        // sheet 2
        // row 1
        row = sheet2.createRow(0);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("SAMPLE CELL TEXT");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(3298.4);
        cell.setCellStyle(style);

        sheet1.protectSheet("secret");
        sheet2.protectSheet("secret");

        FileOutputStream fos = new FileOutputStream(filename);

        wb.write(fos);
        wb.close();
    }
}
