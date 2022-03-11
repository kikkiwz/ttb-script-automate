package com.tmb.automation.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	private static XSSFSheet ExcelWSheet = null;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row = null;

//	private static XSSFRow Row;
	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception {
		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startCol = 1;
			int ci = 0, cj = 0;
			int totalRows = 1;
			int totalCols = 2;
			tabArray = new String[totalRows][totalCols];
			for (int j = startCol; j <= totalCols; j++, cj++) {
				tabArray[ci][cj] = getCellData(iTestCaseRow, j);
//				System.out.println(tabArray[ci][cj]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
//			System.out.println("testcasename="+value);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public static HashMap<String, String> getRowDataIntoMap(int rowNum) throws Exception {
		int colCount = getColumnCount();
		HashMap<String, String> testDataMap = new HashMap<String, String>();
		for (int i = 0; i <= colCount; i++) {
			String colName = getCellData(0, i);
			String cellValue = getCellData(rowNum, i);
			testDataMap.put(colName, cellValue);
		}
		return testDataMap;

	}

	public static List<String> getColumnDataIntoMap(int colnum) throws Exception {
		int rowCount = getRowCount();
		List<String> testDataMap = new ArrayList<>();
		for (int i = 1; i < rowCount; i++) {
			String cellValue = getCellData(i, colnum);
			testDataMap.add(cellValue);
		}
		return testDataMap;

	}

	public static int getColumnCount() {
		Row = ExcelWSheet.getRow(0);
		if (Row == null)
			return -1;
		return Row.getLastCellNum();
	}

	public static int getRowCount() {
		int number = ExcelWSheet.getLastRowNum() + 1;
		return number;
	}

	public static int getColNumberByColName(String colName) throws Exception {

		// int rowCount = getRowCount();
		int colCount = getColumnCount();
		int resVal = -1;
		for (int Col = 0; Col <= colCount - 1; Col++) {
			String resColName = getCellData(0, Col);
			// log.info(resColName +" ; "+colName)
			// log.info(resColName.equalsIgnoreCase(colName))
			if (resColName.equalsIgnoreCase(colName)) {
				resVal = Col;
				// log.info(resVal)
			}
		}
		return resVal;
	}
}