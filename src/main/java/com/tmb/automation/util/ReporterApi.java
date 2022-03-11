package com.tmb.automation.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.platform2.ExportExcelTestcase;
import com.tmb.automation.util.platform2.LogsFilter;
import com.tmb.automation.util.platform2.TmbConfiguration;
import io.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ReporterApi {
    public static ExtentHtmlReporter htmlReporter;
    public static FileOutputStream exportExcelTestcase;
    public static ExtentReports extent;
    public static ExtentTest parentReport;
    public static ExtentTest childReport;
    public Response response;
    public static int indexTestCase = 0;
    public static Map<Integer, Object[]> dataTestcase;
    public static LogsFilter logsFilter;
    public static Document document;
    public static byte[] imagePage;
    public static String uiReportName = "";
    public static String docReportName = "";
    public static Paragraph paragraphSummaryCase;

    @Parameters({"environment","generateExportExcelFile","sendExportEmail","projectName","teamName" })
    @BeforeSuite
    public void beforeSuite(String environment,Boolean isGenerateExportExcelFile,Boolean isSendExportEmail,String projectName,String teamName) throws IOException, DocumentException {

        TmbConfiguration.setup(environment,isGenerateExportExcelFile,isSendExportEmail);
        String date = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());

        uiReportName = "API-" + date + ".html";
        docReportName = "API-" + date + ".xlsx";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/"+teamName+"/" + uiReportName);
        dataTestcase = new TreeMap<Integer, Object[]>();
        exportExcelTestcase = new FileOutputStream(new File(System.getProperty("user.dir") + "/test-output/"+teamName+"/" + docReportName));
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

        extent = new ExtentReports();
        extent.setSystemInfo("OS", System.getProperty("os.name").toLowerCase());
        extent.setSystemInfo("Project", projectName);
        extent.setSystemInfo("Team", teamName);
        extent.setSystemInfo("URL", Setting.baseUrlUi);
        extent.setSystemInfo("Build number", System.getProperty("buildNumber"));
        extent.setSystemInfo("Test Version", "1.1.0");
        extent.setSystemInfo("Date Time", Setting.DATE_TIME);
        htmlReporter.config().enableTimeline(true);
        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        htmlReporter.config().setCSS("css-string");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJS("js-string");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setReportName(teamName + " Application Report build: " + Setting.DATE_TIME);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        extent.attachReporter(htmlReporter);
    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            childReport.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            childReport.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            childReport.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            childReport.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            childReport.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        if (Setting.Config.IS_EXPORT_EXCEL) {
            ExportExcelTestcase exportExcelTestcase = new ExportExcelTestcase();
            exportExcelTestcase.exportTestcase(dataTestcase);
        }
    }


    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm ss a").format(new Date());
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
            dataTestcase.put(indexTestCase++, new Object[]{indexTestCase, description, "", "", "", "", "", "", "SKIP"});
            throw new SkipException("Skipping this exception");
        } else {
            return;
        }
    }


}


