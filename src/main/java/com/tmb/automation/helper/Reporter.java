package com.tmb.automation.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.tmb.automation.model.ExportPdfTestcaseModel;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.platform2.DateTime;
import com.tmb.automation.util.platform2.LogsFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.WriterOutputStream;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import java.util.*;

public class Reporter {
    public static ExtentHtmlReporter htmlReporter;
    public static FileOutputStream exportExcelTestcase;
    public static ExtentReports extent;
    public static ExtentTest parentReport;
    public static ExtentTest childReport;
    public Response response;
    public static int indexTestCase = 0;
    public static Map<Integer, Object[]> dataTestcase;
    public static StringWriter requestWrite;
    public static PrintStream requestCapture;
    public static LogsFilter logsFilter;
    public static Document document;
    public static byte[] imagePage;
    public static Font fontSukhumvit50;
    public static Font fontSukhumvit20;
    public static Font fontSukhumvit18;
    public static Font fontSukhumvit16;
    public static Font fontSukhumvit14;
    public static Font fontSukhumvit12;
    public static Font fontSukhumvit12White;
    public static Font fontSukhumvit10;
    public static Font fontSukhumvit9;
    public static Font fontSukhumvit9Red;
    public static Font fontSukhumvit9Green;
    public static Font fontSukhumvit9Yellow;
    public static Font fontSukhumvit8;
    public static String sukhumvitT = System.getProperty("user.dir") + "/src/main/resources/fonts/SukhumvitSet-Thin.ttf";
    public static String sukhumvitBold = System.getProperty("user.dir") + "/src/main/resources/fonts/SukhumvitSet-SemiBold.ttf";
    public static String logoTmb = System.getProperty("user.dir") + "/src/main/resources/tmb_logo.jpg";
    public static Font fontSukhumvitBold;
    private static String FILE = "test-output/platform2/UI_IMAGE_PDF.pdf";
    private static String date;
    public static String uiReportName = "";
    public static Paragraph paragraphDemoStep;
    public static Paragraph paragraphSummaryCase;
    public static ArrayList<ExportPdfTestcaseModel> testcaseResultList = new ArrayList<ExportPdfTestcaseModel>();

    @BeforeSuite
    public void beforeSuite() throws IOException, DocumentException {

        configuration();
        String date = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());

        switch (Setting.AUTOMATE) {
            case API:
                uiReportName = "API-" + date + ".html";
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/platform2/"+uiReportName);
                dataTestcase = new TreeMap<Integer, Object[]>();
                dataTestcase.put(-1, new Object[]{"No", "TestcaseName", "Request", "Response", "Logs in MongoDB", "Status"});
                exportExcelTestcase = new FileOutputStream(new File(System.getProperty("user.dir") + "/test-output/platform2/API-" + date + ".xlsx"));
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
                FILE = System.getProperty("user.dir") + "/test-output/platform2/UI-" + Setting.BROWSER.toString() + "-" + date + ".pdf";
                uiReportName = "UI-" + Setting.BROWSER.toString() + "-" + date + ".html";
                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/platform2/"+uiReportName);
                addDocument();
                break;
        }

        extent = new ExtentReports();
        extent.setSystemInfo("OS", System.getProperty("os.name").toLowerCase());
        extent.setSystemInfo("Project", Setting.PROJECT_NAME);
        extent.setSystemInfo("Team", Setting.TEAM_NAME);
        extent.setSystemInfo("URL", Setting.BASE_URL_UI);
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
            if (Setting.AUTOMATE == Setting.AUTOMATE_TYPE.API) return;
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
        if (Setting.AUTOMATE == Setting.AUTOMATE_TYPE.UI) return;
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

        Properties prop = new Properties();
        try {

            prop.load(App.class.getClassLoader().getResourceAsStream("Platform2.properties"));
            if (prop.getProperty("browser").equals("ie")) {
                Setting.BROWSER = Setting.BROWSER_TYPE.IE;
            }else if (prop.getProperty("browser").equals("edge")) {
                Setting.BROWSER = Setting.BROWSER_TYPE.MICROSOFT_EDGE;
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
                    Setting.MONGO_COLLECTION_NAME = DateTime.getMongoCollectionName(Setting.MONGO_COLLECTION_NAME_DEV);
                    Setting.MONGO_SORTS_BY_COLUMN = Setting.MONGO_SORTS_BY_COLUMN_DEV;
                    break;
                case "vit":
                    Setting.SERVER = "dev";
                    Setting.BASE_URL_UI = Setting.BASE_URL_UI_VIT;
                    Setting.BASE_URL_API = Setting.BASE_URL_API_VIT;
                    Setting.MONGO_CLIENT_URL = Setting.MONGO_CLIENT_URL_VIT;
                    Setting.MONGO_DATABASE_NAME = Setting.MONGO_DATABASE_NAME_VIT;
                    Setting.MONGO_COLLECTION_NAME = DateTime.getMongoCollectionName(Setting.MONGO_COLLECTION_NAME_VIT);
                    Setting.MONGO_SORTS_BY_COLUMN = Setting.MONGO_SORTS_BY_COLUMN_VIT;
                    break;
                case "sit":
                    Setting.SERVER = "sit";
                    break;
                case "uat":
                    Setting.SERVER = "uat";
                    break;
            }
            Setting.Config.IS_SEND_EMAIL = Boolean.parseBoolean(prop.getProperty("isSendEmail").toString());
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

    public void isSkipTest(boolean isSkip, String description) {
        if (isSkip) {
            dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                    description,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "skip"});
            throw new SkipException("Skipping this exception");
        } else {
            return;
        }
    }

    public void addDocument() throws IOException, DocumentException {
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        addMetaData(document);
        setFont();
    }

    private static void addMetaData(Document document) {
        document.addTitle(Setting.ExportPdfKey.TITLE_FILE);
        document.addSubject(Setting.ExportPdfKey.SUBJECT);
        document.addKeywords(Setting.ExportPdfKey.KEYWORDS);
        document.addAuthor(Setting.ExportPdfKey.AUTHOR);
        document.addCreator(Setting.ExportPdfKey.CREATOR);
    }

    private static void setFont() throws IOException, DocumentException {
        fontSukhumvit50 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 55);
        fontSukhumvit20 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 26);
        fontSukhumvit18 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 18);
        fontSukhumvit16 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 16);
        fontSukhumvit14 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 14);
        fontSukhumvit12 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12);
        fontSukhumvit12White = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12);
        fontSukhumvit10 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 10);
        fontSukhumvit9 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 9);
        fontSukhumvit9Red = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 9);
        fontSukhumvit9Green = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 9);
        fontSukhumvit9Yellow = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 9);
        fontSukhumvit8 = new Font(BaseFont.createFont(sukhumvitT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 8);
        fontSukhumvitBold = new Font(BaseFont.createFont(sukhumvitBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 50);
        fontSukhumvit50.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit20.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit18.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit16.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit14.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit12.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit12White.setColor(BaseColor.WHITE);
        fontSukhumvit10.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit9.setColor(BaseColor.DARK_GRAY);
        fontSukhumvit9Red.setColor(BaseColor.RED);
        fontSukhumvit9Green.setColor(BaseColor.GREEN);
        fontSukhumvit9Yellow.setColor(BaseColor.BLUE);
        fontSukhumvit8.setColor(BaseColor.DARK_GRAY);
        fontSukhumvitBold.setColor(BaseColor.DARK_GRAY);
    }

    public static byte[] encodeByte(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) BasePlatform2.driver).getScreenshotAs(OutputType.FILE);
        return FileUtils.readFileToByteArray(file);
    }
}


