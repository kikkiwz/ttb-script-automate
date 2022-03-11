package com.tmb.automation.helper;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.automation.util.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ExtentReport4 implements ITestListener {

    private static String fileName = Helper.getUserDir() + "/target/reports/"
            + "Report_"+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
    public static ExtentReports extent = createInstance(fileName);
    public static ExtentReports extent1;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static WebDriver driver;

    public void onTestStart(ITestResult result) {
        ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(child);
    }

    public void onTestSuccess(ITestResult result) {
        String description = result.getMethod().getDescription();
        String logText = "<b>" + "TEST CASE:- " + description.toUpperCase() + " PASSED" + "</b>";
        // extent.createTest(logText);
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ((ExtentTest) test.get()).pass(m);
    }

    public void onTestFailure(ITestResult result) {
        String excepionMessage = "<b>"+result.getThrowable().getMessage()+"</b>"+"<em>"+Arrays.toString(result.getThrowable().getStackTrace())+"</em>";
        test.get()
                .fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                        + "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
                        + " \n");
        if (ExtentReport4.getDriver()!=null){
            try {
                test.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>"
                        , MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
            } catch (Exception e) {
                e.printStackTrace();
                Log.logger.debug(e.getStackTrace());
            }
        }else {
            Log.logger.debug("ExtentReport4 > Driver is null. Ex. ExtentReport4.setDriver(appiumDriver)");
        }
        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        test.get().log(Status.FAIL, m);
    }

    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        test.get().skip(m);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        System.out.println(context.getAllTestMethods().length);
        ExtentTest parent = extent.createTest(context.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
        System.out.println("class name " + getClass().getName());
        extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        parentTest.set(parent);
    }

    public synchronized void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
            Log.logger.debug("Report Created "+fileName);
            if (Boolean.parseBoolean(Helper.getProperties("flag_open_report"))) {
                File htmlFile = new File(fileName);
                try {
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } catch (Exception e) {e.printStackTrace();}
            }
            System.out.println(".");
        }
    }

    /**
     * Print message and Screenshot as base64 type to Report
     * @param message
     */
    public static void printReportMessage(String message) {
        try {
            if (ExtentReport4.getDriver()!=null){
                test.get().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
            } else {
                test.get().pass(message);
            }
            Log.logger.debug(message);
        } catch (Exception e) {
        }
    }

    /**
     * Print message and Screenshot as base64 type to Report
     * @param message
     */
    public static void printScreenshot(String message) {
        try {
            if (ExtentReport4.getDriver()!=null){
                test.get().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
            } else {
                test.get().pass(message);
            }
            Log.logger.debug(message);
        } catch (Exception e) {
            e.printStackTrace();
            Log.logger.debug(e.getStackTrace());
        }
    }

    /**
     * priont JSON format to report
     * @param json
     */
    public static void printReportMessageJson(String json){
        test.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    /**
     * print Message with Yellow color to report
     * @param message
     */
    public void printPassGreen(String message) {
        test.get().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
        Log.logger.debug(message);
    }

    /**
     * print message in fail case and Red color to report
     * @param message
     */
    public void printFailRed(String message) { test.get().pass(MarkupHelper.createLabel(message, ExtentColor.RED));
        Log.logger.debug(message);}

    /**
     * print Message with Yellow color to report
     * @param message
     */
    public void printInfoYellow(String message) { test.get().pass(MarkupHelper.createLabel(message, ExtentColor.YELLOW));
        Log.logger.debug(message);}

    /**
     * priont JSON format to report
     * @param jsonMessage
     */
    public void printInfoJson(String jsonMessage){
        test.get().info(MarkupHelper.createCodeBlock(jsonMessage, CodeLanguage.JSON));
    }

    /**
     * print XML format to report
     * @param xmlMessage
     */
    public void passInfoXml(String xmlMessage){
        test.get().info(MarkupHelper.createCodeBlock(xmlMessage, CodeLanguage.XML));
    }

    public synchronized static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent1 = new ExtentReports();
        extent1.attachReporter(htmlReporter);
        extent1.setSystemInfo("Automation Tester", "Aniwat.r@tcs.com");
        try {
            extent1.setSystemInfo("Computer Name", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e){}
        extent1.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        extent1.setSystemInfo("Machine", System.getProperty("os.name"));
        extent1.setSystemInfo("Selenium", "3.14.59");
        extent1.setSystemInfo("Maven", "3.5.2");
        extent1.setSystemInfo("Java Version", System.getProperty("java.version"));
        return extent1;
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Log.logger.debug("ExtentReport4.driver = driver");
        ExtentReport4.driver = driver;
    }
}
