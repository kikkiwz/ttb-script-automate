package com.tmb.automation.helper;

import static io.restassured.RestAssured.given;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Tata Consultant Service Thaialand
 *
 * @author Aniwat Ruttanaudom
 * @since 07-Dec-2020
 */

public class Helper {
    private final static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    public static Boolean TEST_STATUS = false;
    public static String LANGUAGE = "English"; // Default enlish
    public static String CONFIG_PROFILE; // Default Android Emulator 1st
//	private final static String jsonPath = "info.json";

    public static void main(String[] args) {
//		String str = getJson(jsonPath).toString(4);
//		System.out.println(str);

//		Map<String, String> map = getExcelData("group_test22", "TC005", "TestData_935");
//		System.out.println(map);
    }

    public static String getProperties(String value) {
        InputStream fis;
        Properties prop = null;
        try {
            prop = new Properties();
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Global.properties");
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propertyValue = prop.getProperty(value);
        if (propertyValue == null) {
            Assert.fail("value of " + value + " is not found in Global.properties");
        }
        return propertyValue;
    }

    public static Map<String, String> testData(String groupTest, String testCaseName) {
        String excelPath = getProperties(groupTest + "_excel_path");
        if (!excelPath.contains("/") || !excelPath.contains("\\")) {
            excelPath = getUserDir() + "/src/main/resources/" + excelPath;
        }

        // read excel from excelPath
        // check type support xls, xlsx, odt
        // 1. read all sheetname to array
        // 2. filter by test case name and select sheet name
        // 3. read as template and put key and value to hashmap variables
        // 4. we got variable as {{"testcase":"AD_T001"}, {"user":"Admin"})
        // check xls and xlsx D:\tmp\test_data.xlsx
//		Log.logger.debug("Excel Path="+excelPath);
        if (!excelPath.contains(".xlsx")) {
            Log.logger.debug("Type of file " + excelPath + " is wrong. It should be .xls or .xlsx");
            Assert.fail("Test data is not found!");
        }
        XSSFWorkbook wBook;
        Map<String, String> cellMap = new LinkedHashMap<String, String>();
        cellMap.put("__group", groupTest);
        cellMap.put("__excelPath", excelPath);
        // Open the Excel file
        try {
            FileInputStream ExcelFile = new FileInputStream(excelPath);
            wBook = new XSSFWorkbook(ExcelFile);
            Boolean flag = false;

            for (int i = 0; i < wBook.getNumberOfSheets(); i++) {
//				Log.logger.debug(wBook.getSheetAt(i).getSheetName());
                if (wBook.getSheetAt(i).getSheetName().trim().equalsIgnoreCase(testCaseName.trim())) {

                    flag = true;
                    XSSFSheet wSheet = wBook.getSheetAt(i);
                    XSSFRow Row = wSheet.getRow(0); // get my Row which start from 0
                    int ColNum = Row.getLastCellNum(); // get last ColNum
                    // Looping over entire row
                    for (int j = 0; j < ColNum; j++) {
                        // row 0 > get cell data
                        Cell cellKey = wSheet.getRow(0).getCell(j);
                        // row 1 > get cell data
                        Cell cellValue = wSheet.getRow(1).getCell(j);
                        String cellKey_value = cellKey.getStringCellValue().trim();
                        String cellValue_value = cellValue.getStringCellValue().trim();
//						Log.logger.debug("key=" + cellKey_value + "  value=" + cellValue_value);
                        // Putting key & value in dataMap
                        cellMap.put(cellKey_value, cellValue_value);
//						Log.logger.debug("cellMap=" + cellMap);
                    }
                    break;
                }
            }
            if (flag == false) {
                Assert.fail("Fail! TestCaseID=" + testCaseName + " is not found in test Data excel file!");
            }
            ExcelFile.close();
        } catch (FileNotFoundException e) {
            Log.logger.debug(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.logger.debug(e.getMessage());
            e.printStackTrace();
        }
//		Log.logger.debug("cellMap=" + cellMap);
        return cellMap;
    }

    public static Map<String, Map<String, String>> testData(String groupTest) {
        // group test
        // excel path per group test
        String propGroupTest = getProperties(groupTest);
        String excelPath = "";
        if (propGroupTest.equalsIgnoreCase("group1")) {
            excelPath = getProperties("excel_path_group1");
//			Log.logger.debug(excelPath);
        } else if (propGroupTest.equalsIgnoreCase("group2")) {
            excelPath = getProperties("excel_path_group2");
            Log.logger.debug(excelPath);
        } else if (propGroupTest.equalsIgnoreCase("group_ios")) {
            excelPath = getUserDir() + "/src/main/resources/" + getProperties("excel_path_group_ios");
        } else {
            Log.logger.debug("Group Test= " + groupTest + " is not found!");
            Assert.fail("Grout test is not found!");
        }
        // read excel from excelPath
        // check type support xls, xlsx, odt
        // 1. read all sheetname to array
        // 2. filter by test case name and select sheet name
        // 3. read as template and put key and value to hashmap variables
        // 4. we got variable as {{"testcase":"AD_T001"}, {"user":"Admin"})
        // check xls and xlsx D:\tmp\test_data.xlsx

        if (!excelPath.contains(".xlsx")) {
            Log.logger.debug("Type of file " + excelPath + " is wrong. It should be .xls or .xlsx");
            Assert.fail("Test Data is not found!");
        }
        // XSSFSheet sheet1;

        /*
         * Ex.... Log.logger.debug(Helper.testData("group1")); Map<String, Map<String,
         * String>> map = Helper.testData("group1");
         * Log.logger.debug("key2="+map.get(this.getClass().getSimpleName()).get("key2")
         * );
         */
        XSSFWorkbook wBook;
        Map<String, Map<String, String>> dataMap = new LinkedHashMap<String, Map<String, String>>();
//		XSSFCell wCell;
        // Open the Excel file
        try {
            FileInputStream ExcelFile = new FileInputStream(excelPath);
            wBook = new XSSFWorkbook(ExcelFile);
            for (int i = 0; i < wBook.getNumberOfSheets(); i++) {
                Map<String, String> cellMap = new LinkedHashMap<String, String>();
//				if (wBook.getSheetAt(i).getSheetName().equalsIgnoreCase(testCaseName)) {
//					Log.logger.debug(wBook.getSheetAt(i).getSheetName());
                XSSFSheet wSheet = wBook.getSheetAt(i);
                XSSFRow Row = wSheet.getRow(0); // get my Row which start from 0
//					int RowNum = wSheet.getPhysicalNumberOfRows();// count my number of Rows
                int ColNum = Row.getLastCellNum(); // get last ColNum
//					Log.logger.debug("Row=" + RowNum + "   Col=" + ColNum);
                // Looping over entire row
                for (int j = 0; j < ColNum; j++) {
                    // row 0 > get cell data
                    Cell cellKey = wSheet.getRow(0).getCell(j);
                    // row 1 > get cell data
                    Cell cellValue = wSheet.getRow(1).getCell(j);
                    String cellKey_value = cellKey.getStringCellValue().trim();
                    String cellValue_value = cellValue.getStringCellValue().trim();
//						Log.logger.debug("key=" + cellKey_value + "  value=" + cellValue_value);
                    // Putting key & value in dataMap
                    cellMap.put(cellKey_value, cellValue_value);
//						Log.logger.debug("cellMap=" + cellMap);
                }
                dataMap.put(wBook.getSheetAt(i).getSheetName(), cellMap);
//					Log.logger.debug("dataMap=" + dataMap);
//				}

            }
            ExcelFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public static String getUserDir() {
        return System.getProperty("user.dir");
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
     * <p>
     * mapData = {TestCaseID=TC004, k1=v1, k2=v2, k3=v3, k4=v4}
     *
     * @param groupTest    The group name is assign in Global.properties
     * @param testCaseName The class name will testing.
     * @return Map<String, String>
     */
    public static Map<String, String> getExcelData(String groupTest, String sheetName, String testCaseName) {
        String excelPath = getProperties(groupTest + "_excel_path");
        if (!excelPath.contains("/") || !excelPath.contains("\\")) {
            excelPath = getUserDir() + "/src/main/resources/" + excelPath;
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

    public static String resetEmail(String crm_id, Boolean flag) {
        String flagY = "{\r\n    \"customer\": {\r\n        \"profile\": {\r\n            \"rm_id\": \"" + crm_id
                + "\"\r\n        },\r\n        \"additional_kyc\": {\r\n            \"email_type\": \"B\",\r\n            \"email_address\": \"mahesh.psr2011@gmail.com\",\r\n            \"email_verify_flag\": \"Y\"\r\n        }\r\n    }\r\n}";
        String flagN = "{\r\n    \"customer\": {\r\n        \"profile\": {\r\n            \"rm_id\": \"" + crm_id
                + "\"\r\n        },\r\n        \"additional_kyc\": {\r\n            \"email_type\": \"B\",\r\n            \"email_address\": \"mahesh.psr2011@gmail.com\"\r\n           \r\n        }\r\n    }\r\n}";
        String flagTotal = "";
        if (flag) {
            flagTotal = flagY;
        } else {
            flagTotal = flagN;
        }
        String Result = given().header("Content-Type", "application/json; charset=UTF-8")
                .header("service-name", "customers-personal-kyc-update")
                .header("request-uid", "c607e37d-9f53-4b64-bf00-d0fcd0b81d5c").header("request-app-id", "MB-INQ")
                .header("request-datetime", "2020-09-21T19:19:33+0700").body(flagTotal).relaxedHTTPSValidation().when()
                .post("https://10.200.115.196:35568/v3.0/internal/customers/personal/kyc/update-kyc").then()
                .statusCode(200).extract().asString();
        return Result;
    }

    public static Object[][] testadataDataprovider(String groupTest, String testCaseName) throws IOException {
        String excelPath = getProperties(groupTest + "_excel_path");
        if (!excelPath.contains("/") || !excelPath.contains("\\")) {
            excelPath = getUserDir() + "/src/main/resources/" + excelPath;
        }

        if (!excelPath.contains(".xlsx")) {
            Log.logger.debug("Type of file " + excelPath + " is wrong. It should be .xls or .xlsx");
            Assert.fail("Test data is not found!");
        }
        DataFormatter formatter = new DataFormatter();
        XSSFWorkbook wBook;
        FileInputStream ExcelFile = new FileInputStream(excelPath);
        wBook = new XSSFWorkbook(ExcelFile);

        // Excel sheet file location get mentioned here
        // workbook = new HSSFWorkbook (fileInputStream); //get my workbook
        XSSFSheet wSheet = wBook.getSheet(testCaseName);// get my sheet from workbook
        XSSFRow Row = wSheet.getRow(0); // get my Row which start from 0

        int RowNum = wSheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum = Row.getLastCellNum(); // get last ColNum

        Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

        for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
        {
            XSSFRow row = wSheet.getRow(i + 1);

            for (int j = 0; j < ColNum; j++) // Loop work for colNum
            {
                if (row == null)
                    Data[i][j] = "";
                else {
                    Cell cell = row.getCell(j);
                    if (cell == null)
                        Data[i][j] = ""; // if it get Null value it pass no data
                    else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
                        // data value
                    }
                }
            }
        }
        return Data;
    }

    //=============Lending========================================
    public static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        byte[] encrypedValue = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypedValue);
    }

    public static String writeJsonResult(String filePath, String className, String jsonString) {
        String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_Result_" + className
                + ".json";
        System.out.println("fileName=" + filePath + fileName);
        try {
            FileWriter file = new FileWriter(filePath + fileName);
            file.write(new org.json.JSONObject(jsonString).toString(4));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


    public static InputStream getInput(String filePath) {
//		String path = filePath;
        InputStream in = null;
        if (filePath.contains("./")) {
            in = Helper.class.getClassLoader().getResourceAsStream(filePath);
        } else {
            try {
                in = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return in;
    }

    //=============Lending==============//
    public static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
