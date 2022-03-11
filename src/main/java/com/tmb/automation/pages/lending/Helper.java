package com.tmb.automation.pages.lending;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

//import com.tmb.automation.helper.Helper;

public class Helper {
	private final static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	public static Boolean TEST_STATUS = false;
	public static String LANGUAGE = "English"; // Default enlish
	public static String CONFIG_PROFILE; // Default Android Emulator 1st

	public Helper() {
		// TODO Auto-generated constructor stub
	}

	public static String getProperties(String value) {
		InputStream fis;
		Properties prop = null;
		try {
			fis = Helper.class.getClassLoader().getResourceAsStream("./LendingResources/Lending.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String propertyValue = prop.getProperty(value);
//		if (propertyValue == null) {
//			Assert.fail("value of " + value + " is not found in properties");
//		}
		return propertyValue;
	}
	public static void writeLog(String value) {
		if (Boolean.parseBoolean(Helper.getProperties("flag_writelog"))) {
			FileOutputStream fos;
			String dir = getUserDir() + "/target/run/";
			value = "\r\n" + value + "\r\n";
			try {
				File directory = new File(dir);
				if (!directory.exists()) {
					directory.mkdir();
				}
				fos = new FileOutputStream(getUserDir() + "/target/run/" + TIMESTAMP + "_.log", true);
				fos.write(value.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static JSONObject getJson(String fileName) {
		InputStream is = Helper.class.getClassLoader().getResourceAsStream(fileName);
		if (is == null) {
			throw new NullPointerException("Cannot find resource file " + fileName);
		}
		JSONTokener tokener = new JSONTokener(is);
		JSONObject jo = new JSONObject(tokener);
		return jo;
	}

	/**
	 * getExcelData for get key and value as multiple test data value from excel Ex.
	 * TestCaseID | k1 | k2 TC001 | v1 | v2 | k3 | k4 | v3 | v4
	 * 
	 * mapData = {TestCaseID=TC004, k1=v1, k2=v2, k3=v3, k4=v4}
	 * 
	 * @param groupTest    The group name is assign in Global.properties
	 * @param testCaseName The class name will testing.
	 * @return Map<String, String>
	 */
	public static Map<String, String> getExcelData(String groupTest, String sheetName, String testCaseName) {
		String excelPath = getProperties(groupTest + "_excel_path");
		if (!excelPath.contains("/") || !excelPath.contains("\\")) {
			excelPath = getUserDir() + "/src/main/resources" + excelPath;
		}
		if (!excelPath.contains(".xlsx")) {
			Assert.fail("Type of file " + excelPath + " is wrong. It should be .xls or .xlsx");
		}
		XSSFWorkbook wBook;
		Map<String, Map<String, String>> dataMap = new LinkedHashMap<String, Map<String, String>>();
		try {
			FileInputStream ExcelFile = new FileInputStream(excelPath);// Open the Excel file
			wBook = new XSSFWorkbook(ExcelFile);

			XSSFSheet wSheet = wBook.getSheet(sheetName);
			XSSFRow Row = wSheet.getRow(0); // get my Row which start from 0
			int ColNum = Row.getLastCellNum(); // get last ColNum
			int RowNum = wSheet.getPhysicalNumberOfRows();
			Map<String, String> cellMap = new LinkedHashMap<String, String>();
			for (int m = 0; m < RowNum; m++) {
				for (int j = 0; j < ColNum; j++) {
					if (wSheet.getRow(m) != null && wSheet.getRow(m + 1) != null) {
						if (wSheet.getRow(m).getCell(j) != null && wSheet.getRow(m + 1).getCell(j) != null) {
							Cell cellKey = wSheet.getRow(m).getCell(j); // row 0 > get cell data
							Cell cellValue = wSheet.getRow(m + 1).getCell(j);// row 1 > get cell data
							String cellKey_value = getCellValue(cellKey);
							String cellValue_value = getCellValue(cellValue);
							// check the 2nd record of test case id is found in loop on excel sheet
							if (cellMap.get("TestCaseID") != null && cellKey_value.equalsIgnoreCase("TestCaseID")) {
								dataMap.put(cellMap.get("TestCaseID"), cellMap); // add all data to dataMap
								cellMap = new LinkedHashMap<String, String>(); // let cellMap is initialize
							}
							// check cell data is blank or null event it not first row!
							if (!cellKey_value.trim().isEmpty()) {
								cellMap.put(cellKey_value, cellValue_value);// Putting key & value in dataMap
							}
						}
					}
				}
				m++; // focus on an even row (row m = key, row m+1=value. I will do m+2 in this loop
			}
			dataMap.put(cellMap.get("TestCaseID"), cellMap); // call add the last test data
			ExcelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (dataMap.get(testCaseName) == null) { // check case test case name is null or not found!
			Assert.fail("Test case ID = " + testCaseName + " is not found in Excel sheet!");
		}
		return dataMap.get(testCaseName);
	}

	private static String getCellValue(Cell cell) {
		String strValue = "";
		if (cell == null || cell.getCellType() == CellType.BLANK) {
			strValue = "";
		} else if (cell.getCellType() == CellType.STRING) {
			strValue = cell.getStringCellValue().trim();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			strValue = String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			strValue = String.valueOf(cell.getBooleanCellValue());
		} else {
			strValue = "";
		}
		return strValue;
	}
	
	public static String getUserDir() {
		return System.getProperty("user.dir");
	}

	public static Map<String, Object> convertJsonToMap(String jsonPath){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=null;
		try {
			map = mapper.readValue(new File(
							System.getProperty("user.dir")+"/src/main/resources/"+jsonPath)
					, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static void convertMapToJson(Map<String, Object> map, String jsonPath){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("result.json"), map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Map<String, String> convertStringToHashMap(String value){
		value = value.substring(1, value.length()-1);           //remove curly brackets
		String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
		Map<String,String> map = new HashMap<>();
		for(String pair : keyValuePairs) {
			String[] entry = pair.split("=");                   //split the pairs to get key and value
			try {
				map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
			} catch (ArrayIndexOutOfBoundsException e){
				map.put(entry[0].trim(), "");
			}

		}
		return map;
	}

	public static void setAndroid() {
		CONFIG_PROFILE = Helper.getProperties("deviceProfile_Android");
	}
	public static void setiOS() {
		CONFIG_PROFILE = Helper.getProperties("deviceProfile_iOS");
	}
}

