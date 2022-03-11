package com.tmb.automation.api.investment.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.platform2.LogsFilter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import scala.App;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class ReportInvestment {
    public static ExtentHtmlReporter htmlReporter;
    public static FileOutputStream exportExcelTestcase;
    public static ExtentReports extent;
    public static ExtentTest parentReport;
    public static ExtentTest childReport;
    public RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
    public JSONObject requestParams = new JSONObject();
    public static int indexTestCase = 0;
    public static Map<Integer, Object[]> dataTestcase;
    public static StringWriter requestWrite;
    public static PrintStream requestCapture;
    public static LogsFilter logsFilter;

    @BeforeSuite
    public void beforeSuite() throws IOException {

        configuration();
        String date = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());

        switch (Setting.AUTOMATE) {
            case API:
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/investment/API-" + date + ".html");
                dataTestcase = new TreeMap<Integer, Object[]>();
                dataTestcase.put(-1, new Object[]{"No", "TestcaseName", "Request", "Response", "Logs in MongoDB", "Status"});
                exportExcelTestcase = new FileOutputStream(new File(System.getProperty("user.dir") + "/test-output/investment/API-" + date + ".xlsx"));
                logsFilter = new LogsFilter();
                dataTestcase.put(-1, new Object[]{Setting.KEY_REPORT_COLUMN_EXCEL_NO,
                        Setting.KEY_REPORT_COLUMN_EXCEL_NAME,
                        Setting.KEY_REPORT_COLUMN_EXCEL_EXPECTED_RESULT,
                        Setting.KEY_REPORT_COLUMN_EXCEL_REQUEST,
                        Setting.KEY_REPORT_COLUMN_EXCEL_HTTP_CODE,
                        Setting.KEY_REPORT_COLUMN_EXCEL_RESPONSE,
                        Setting.KEY_REPORT_COLUMN_EXCEL_LOGS_MONGO_DB,
                        Setting.KEY_REPORT_COLUMN_EXCEL_DATE_TIME,
                        Setting.KEY_REPORT_COLUMN_EXCEL_STATUS
                });
                break;
            case UI:
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/investment/UI-" + Setting.BROWSER.toString() + "-" + date + ".html");
                break;
        }

        extent = new ExtentReports();
        extent.setSystemInfo("OS", System.getProperty("os.name").toLowerCase());
        extent.setSystemInfo("Project", Setting.PROJECT_NAME);
        extent.setSystemInfo("Team", Setting.TEAM_NAME);
        extent.setSystemInfo("URL", Setting.BASE_URL_INVESTMENT);
        extent.setSystemInfo("Server", Setting.SERVER);
        extent.setSystemInfo("Test Version", "1.0.0");
        extent.setSystemInfo("Date Time", Setting.DATE_TIME);
        htmlReporter.config().enableTimeline(true);
        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        htmlReporter.config().setCSS("css-string");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJS("js-string");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setReportName(Setting.TEAM_NAME + " Application Report build: " + Setting.DATE_TIME);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void setUpLogs() {
        logsFilter = new LogsFilter();
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            childReport.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            childReport.fail(result.getThrowable());
            if (Setting.AUTOMATE == Setting.AUTOMATE_TYPE.API)
                return;
            childReport.info("Error: ", MediaEntityBuilder.createScreenCaptureFromBase64String(encodeFileToBase64Binary()).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            childReport.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            childReport.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            childReport.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void afterSuite() {
//        extent.flush();
        if (Setting.AUTOMATE == Setting.AUTOMATE_TYPE.UI)
            return;
        ExportExcelTestcase exportExcelTestcase = new ExportExcelTestcase();
        exportExcelTestcase.exportTestcase(dataTestcase);
    }

    public static String encodeFileToBase64Binary() throws IOException {
        File file = ((TakesScreenshot) BasePlatform2.driver).getScreenshotAs(OutputType.FILE);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm ss a").format(new Date());
    }

    public void configuration() {
//        requestWrite = new StringWriter();
//        requestCapture = new PrintStream(new WriterOutputStream(requestWrite), true);
        Properties prop = new Properties();
        try {

            prop.load(App.class.getClassLoader().getResourceAsStream("Platform2.properties"));
            if (prop.getProperty("browser").equals("ie")) {
                Setting.BROWSER = Setting.BROWSER_TYPE.IE;
            } else {
                Setting.BROWSER = Setting.BROWSER_TYPE.CHROME;
            }

            if (prop.getProperty("automateType").equals("api")) {
                Setting.AUTOMATE = Setting.AUTOMATE_TYPE.API;
                Setting.BROWSER = Setting.BROWSER_TYPE.NON;
            } else {
                Setting.AUTOMATE = Setting.AUTOMATE_TYPE.UI;
            }

            switch (prop.getProperty("server").toString()) {
                case "dev":
                    Setting.SERVER = "dev";
                    Setting.BASE_URL_UI = Setting.BASE_URL_UI_DEV;
                    Setting.BASE_URL_API = Setting.BASE_URL_API_DEV;
                    Setting.MONGO_CLIENT_URL = Setting.MONGO_CLIENT_URL_DEV;
                    Setting.MONGO_DATABASE_NAME = Setting.MONGO_DATABASE_NAME_DEV;
                    Setting.MONGO_COLLECTION_NAME = Setting.MONGO_COLLECTION_NAME_DEV;
                    Setting.MONGO_SORTS_BY_COLUMN = Setting.MONGO_SORTS_BY_COLUMN_DEV;
                    break;
                case "vit":
                    Setting.SERVER = "vit";
                    Setting.BASE_URL_UI = Setting.BASE_URL_UI_VIT;
                    Setting.BASE_URL_API = Setting.BASE_URL_API_VIT;
                    Setting.MONGO_CLIENT_URL = Setting.MONGO_CLIENT_URL_VIT;
                    Setting.MONGO_DATABASE_NAME = Setting.MONGO_DATABASE_NAME_VIT;
                    Setting.MONGO_COLLECTION_NAME = Setting.MONGO_COLLECTION_NAME_VIT;
                    Setting.MONGO_SORTS_BY_COLUMN = Setting.MONGO_SORTS_BY_COLUMN_VIT;
                    break;
                case "sit":
                    Setting.SERVER = "sit";
                    break;
                case "uat":
                    Setting.SERVER = "uat";
                    break;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String isPass(boolean pass) {
        if (pass) {
            return "PASS";
        } else {
            return "FAILED";
        }
    }

    public void isSkipTest(boolean isSkip) {
        if (isSkip) {
            throw new SkipException("Skipping this exception");
        } else {
            return;
        }
    }
//    public void addExcelReport(Object object){
//        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
//                object.Description, Arrays.toString(searchActivityLogTestCasesModel.ExpectedResult),
//                logsFilter.getRequestBuilder().toString(),
//                response.getStatusCode(),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(response.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
//                "ConvertStringToJson.jsonFormatArray(listData.toString())",
//                getDateTime(),
//                isPass(isOK)});
//    }
}


