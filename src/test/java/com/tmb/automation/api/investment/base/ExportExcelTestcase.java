package com.tmb.automation.api.investment.base;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;
import java.util.Set;

public class ExportExcelTestcase {
    public void exportTestcase(Map<Integer, Object[]> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Testcase");
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 12000);
        sheet.setColumnWidth(2, 12000);
        sheet.setColumnWidth(3, 15000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 15000);
        sheet.setColumnWidth(6, 15000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);
        sheet.setDisplayGridlines(true);
        Font fontH = workbook.createFont();
        fontH.setFontHeightInPoints((short) 11);
        fontH.setFontName("Courier New");
        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        cs.setAlignment(HorizontalAlignment.LEFT);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cs.setFont(fontH);

        sheet.setHorizontallyCenter(true);
        Set<Integer> keyset = data.keySet();
        int rownum = 0;
        for (int key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellStyle(cs);
                if ((row.getRowNum() == 0)) {
                    CellStyle style = workbook.createCellStyle();
                    Font font = workbook.createFont();
                    font.setFontName("Courier New");
                    font.setFontHeightInPoints((short) 18);
                    style.setAlignment(HorizontalAlignment.CENTER);
                    style.setVerticalAlignment(VerticalAlignment.CENTER);
                    style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style.setFont(font);
                    style.setWrapText(true);
                    cell.setCellStyle(style);
                } else {
                    CellStyle style = workbook.createCellStyle();
                    Font font = workbook.createFont();
                    font.setFontName("Courier New");
                    style.setFont(font);
                    style.setWrapText(true);
                    font.setFontHeightInPoints((short) 12);
                    style.setAlignment(HorizontalAlignment.LEFT);
                    style.setVerticalAlignment(VerticalAlignment.CENTER);
                    style.setBorderBottom(BorderStyle.THIN);
                    style.setBottomBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    style.setBorderRight(BorderStyle.THIN);
                    style.setRightBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    style.setBorderTop(BorderStyle.THIN);
                    style.setTopBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    cell.setCellStyle(style);
                    if (((row.getRowNum() % 2) == 0)) {
                        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
                        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        cell.setCellStyle(style);
                    } else {
                        style.setFillForegroundColor(IndexedColors.WHITE.index);
                        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    }
                }
                if (obj instanceof String) {
                    CellStyle style = workbook.createCellStyle();
                    style.setBorderBottom(BorderStyle.THIN);
                    style.setBottomBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    style.setBorderRight(BorderStyle.THIN);
                    style.setRightBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    style.setBorderTop(BorderStyle.THIN);
                    style.setTopBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());
                    if (row.getRowNum() != 0 && cellNum == 9) {
                        if (((String) obj).toLowerCase().equals("pass")) {
                            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        } else {
                            style.setFillForegroundColor(IndexedColors.CORAL.index);
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        }
                        style.setAlignment(HorizontalAlignment.CENTER);
                        style.setVerticalAlignment(VerticalAlignment.CENTER);
                        cell.setCellStyle(style);
                    } else if (row.getRowNum() != 0 && (cellNum == 1 || cellNum == 5 || cellNum == 8)) {
                        style.setAlignment(HorizontalAlignment.CENTER);
                        style.setVerticalAlignment(VerticalAlignment.CENTER);
                        Font font = workbook.createFont();
                        font.setFontName("Courier New");
                        style.setFont(font);
                        style.setWrapText(true);
                        cell.setCellStyle(style);
                    }

                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer)
//                    if(row.getRowNum() != 0 && (cellNum==1||cellNum==5||cellNum==8)){
//                        CellStyle style = workbook.createCellStyle();
//                        Font font = workbook.createFont();
//                        font.setFontName("Courier New");
//                        style.setFont(font);
//                        style.setWrapText(true);
//                        font.setFontHeightInPoints((short) 11);
//                        cell.setCellStyle(style);
//                    }
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            workbook.write(ReportInvestment.exportExcelTestcase);
            ReportInvestment.exportExcelTestcase.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
