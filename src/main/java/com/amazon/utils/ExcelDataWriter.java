package com.amazon.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelDataWriter {

    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet = workbook.createSheet("Amazon Products");
    private static int rowCount = 1;

    static {

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Product Name");
        header.createCell(1).setCellValue("Price");
        header.createCell(2).setCellValue("Rating");
    }

    public static void writeProduct(String name, String price, String rating) {

        Row row = sheet.createRow(rowCount++);

        row.createCell(0).setCellValue(name);
        row.createCell(1).setCellValue(price);
        row.createCell(2).setCellValue(rating);

    }

    public static void saveWorkbook() {

        try {

            FileOutputStream fos =
                    new FileOutputStream("testdata/output.xlsx");

            workbook.write(fos);

            fos.close();

            workbook.close();

            System.out.println("Excel File Saved Successfully.");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}