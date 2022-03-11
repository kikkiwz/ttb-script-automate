package com.tmb.automation.util.platform2;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.GetJsonData;
import com.tmb.automation.util.TextColor;

import com.tmb.automation.util.ReporterApi;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class Common {


    public void exportExcelToTestcase(String description, String[] expectedResult, int statusCode, String body, String response, String logMongoDB, boolean isPass) throws IOException, DocumentException {
        ReporterApi.dataTestcase.put(
                ReporterApi.indexTestCase++,
                new Object[]{ReporterApi.indexTestCase,
                        description,
                        Arrays.toString(expectedResult),
                        body,
                        statusCode,
                        response,
                        logMongoDB,
                        getDateTime(),
                        isPass(isPass)});
    }

    public void addInputDataToReport(Map<String, Object> mapData) throws IOException, DocumentException {
        for (Map.Entry<String, Object> inputData : mapData.entrySet()) {
            if (inputData.getValue() != null) {
                ReporterApi.childReport.log(Status.INFO, inputData.getKey() + ": " + TextColor.blueColor(inputData.getValue() == null ? "" : inputData.getValue().toString()));
            }
        }
    }

    public void addResponseKeyDataToReport(Map<String, Object> mapData) throws IOException, DocumentException {
        for (Map.Entry<String, Object> inputData : mapData.entrySet()) {
            ReporterApi.childReport.log(Status.PASS, Setting.KEY_REPORT_RESPONSE_DATA + inputData.getKey() + ": " + TextColor.blueColor(inputData.getValue() == null ? "" : inputData.getValue().toString()));
        }
    }

    public void addUrlApiPathToReport(String apiPath) throws IOException, DocumentException {
        ReporterApi.childReport.log(Status.INFO, Setting.API_PATH + TextColor.blueColor(apiPath));
    }

    public void addScenarioNameToReport(Boolean isScenario, String ScenarioName) throws IOException, DocumentException {
        if (isScenario) ReporterApi.parentReport = ReporterApi.extent.createTest(ScenarioName, ScenarioName);
    }

    public void addDescriptionToReport(String description) throws IOException, DocumentException {
        ReporterApi.childReport = ReporterApi.parentReport.createNode(description);
    }

    public void addTokenToReport() throws IOException, DocumentException {
        ReporterApi.childReport.log(Status.INFO, Setting.KEY_REPORT_AUTHORIZATION + TextColor.blueColor(Setting.TOKEN));
    }

    public void addHttpRequestHeader(Map<String, Object> mapData) throws IOException, DocumentException {
//        for (Map.Entry<String, Object> inputData : mapData.entrySet()) {
//            Base.httpRequest.header(inputData.getKey().replace("_","-"), inputData.getValue() == null ? "" : inputData.getValue().toString());
//        }
    }

    public void screenCaptureFromBase64(WebDriver driver) throws IOException, DocumentException {
        ReporterApi.childReport.info(Setting.KEY_REPORT_INPUT_DATA + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(encodeFileToBase64Binary(driver)).build());
    }

    public void screenCaptureFromBase64() throws IOException, DocumentException, AWTException {
        ReporterApi.childReport.info(Setting.KEY_REPORT_INPUT_DATA + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(rootEncodeFileToBase64Binary()).build());
    }

    public void addLogsEmployeeToReport(String logs) throws IOException, DocumentException {
        ReporterApi.childReport.log(Status.PASS, Setting.KEY_REPORT_COLUMN_EXCEL_LOGS_MONGO_DB + " Employee Activity Log: <pre> " + TextColor.greenColor(ConvertStringToJson.jsonFormatArray(logs)) + "</pre>");
    }

    public void addLogsCustomerToReport(String logs) throws IOException, DocumentException {
        ReporterApi.childReport.log(Status.PASS, Setting.KEY_REPORT_COLUMN_EXCEL_LOGS_MONGO_DB + " Customer Activity Log: <pre>" + TextColor.greenColor(ConvertStringToJson.jsonFormatArray(logs)) + "</pre>");
    }

    public void addExpectedResultToReport(String[] expectedResult) throws IOException, DocumentException {
        for (String actualResult : expectedResult) {
            ReporterApi.childReport.log(Status.PASS, Setting.KEY_REPORT_EXPECTED_RESULT + TextColor.greenColor(actualResult));
        }
    }

    public void addRequestBodyApiToReport(String body) throws IOException, DocumentException {
        ReporterApi.childReport.log(Status.INFO, Setting.KEY_REPORT_REQUEST_DATA + " <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(body) + "</pre>"));
    }

    public void addResponseApiToReport(Boolean isOK, String response) throws IOException, DocumentException {
        ReporterApi.childReport.log(isOK==true?Status.PASS:Status.FAIL, Setting.KEY_REPORT_RESPONSE_DATA + " <pre> " + TextColor.resultColor(isOK, response==""?"":ConvertStringToJson.jsonFormat(response) + "</pre>"));
    }

    public String getItemFromLocalStorage(String key, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", key));
    }

    public Boolean isDisabled(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return arguments[0].hasAttribute(\"disabled\");", element);
    }


//    public void getUserId(String testCaseID) {
//        LoginModel loginModel = new Gson().fromJson(String.valueOf(GetJsonData.getLoginTestCase().get(testCaseID)), LoginModel.class);
//        Setting.USER_ID = loginModel.TestData.username;
//    }

    public static String isPass(boolean pass) {
        return pass ? "PASS" : "FAILED";
    }

    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm ss a").format(new Date());
    }

    private String encodeFileToBase64Binary(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    private String rootEncodeFileToBase64Binary() throws IOException, AWTException {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        byte[] encoded = Base64.encodeBase64(os.toByteArray());
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public static void main(String[] arg) {
        EnvironmentModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getEnvironment()), EnvironmentModel.class);
        System.err.println(dataModel.server.dev);
        System.err.println(dataModel.mongodb.employee.dev.client_url);
        System.err.println(dataModel.mongodb.customer.dev.collection_name);

//        System.err.println(isPass(false));
    }


}
