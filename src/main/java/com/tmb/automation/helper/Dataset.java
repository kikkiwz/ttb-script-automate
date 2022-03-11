package com.tmb.automation.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataset {

	public static Map<String, String> setMapData(String sheetname) throws IOException {
//		String path = "C:\\Users\\Admin\\Documents\\automation-testing\\Automation_Testing\\testdata\\testdata.xlsx";
		String path = Helper.getUserDir()+"/testdata/"+"testdata.xlsx";

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();
		Row r = sheet.getRow(0);
		int cn = r.getLastCellNum();
		System.out.println(cn);

		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

		Map<String, String> dataMap = new HashMap<String, String>();
		for (int j = 0; j < cn; j++) {

			// Looping over entire row
			for (int i = 1; i <= lastRow; i++) {

				Row row = sheet.getRow(0);
				Row rownext = sheet.getRow(i);

				// 1st Cell as Value
				Cell valueCell = rownext.getCell(j);

				// 0th Cell as Key
				Cell keyCell = row.getCell(j);

				String value = valueCell.getStringCellValue().trim();
				System.out.println(value);
				String key = keyCell.getStringCellValue().trim();
				System.out.println(key);

				// Putting key & value in dataMap
				dataMap.put(key, value);

				// Putting dataMap to excelFileMap

			}
		}

		// Returning excelFileMap
		return dataMap;

	}
}
