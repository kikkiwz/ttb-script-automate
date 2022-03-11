package com.ttbbank.oneapp.scenario.primarybanking7;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.ITestResult;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

public class PrimaryBanking7Base extends BaseScenario {
    private ExtentTest scenario;
    private ExtentTest scnLog;
    private Boolean scenarioIsFail = false;

    private String testName;
    private String pathToReport = "reports/pb7";
    private String pathToImage = "images/pb7";
    private Boolean addDateInReportFileExtension = false;

    private String infoNote = "<b><font color='blue'>Info:</font></b>";
    private String passNote = "<b><font color='green'>Pass:</font></b>";
    private String failNote = "<b><font color='red'>Fail:</font></b>";

    public void createReport(String testName) {
        this.testName = testName;
        ExtentListeners.setDriver(getTtbTestContext().getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter(createReportPath());
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest(testName);
        setFeature(feature);
        setExtentReports(extentReports);
    }

    private String createReportPath() {
        if (addDateInReportFileExtension) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_a");
            String reportDate = formatter.format(date);
            return pathToReport + "_" + getTtbTestContext().getDriver().getPlatformName() + reportDate + ".html";
        } else  {
            return pathToReport + "_" + getTtbTestContext().getDriver().getPlatformName() + ".html";
        }
    }

    public void setScenario(String scenarioName) {
        scenarioIsFail = false;
        scenario = getFeature().createNode(Scenario.class, scenarioName);
        scnLog = scenario.createNode(Given.class, "Test Steps");
        System.out.println("Scenario: " + scenarioName);
    }

    public  ExtentTest getScenarios() {
        return  scenario;
    }

    public void addLogInfo(String msg) {
        String newMsg = infoNote + " " + msg;
        System.out.println("Info: " + msg);
        scnLog.log(Status.INFO, newMsg);
    }

    public void evaluateAssertEqual(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("Pass: checking" + expected);
            scnLog.log(Status.PASS, passNote + " found \"" + expected + "\"");
        } catch (AssertionError e) {
            scenarioIsFail = true;
            System.err.println("Fail: checking" + expected);
            scnLog.log(Status.FAIL, failNote + " not found \"" + expected + "\"");
        }
    }

    public void evaluateAssertEqual(String actual, String expected, String msg) {
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
        } catch (AssertionError e) {
            scenarioIsFail = true;
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
        }
    }

    public void evaluateAssertEqual(Collection<?> actual, Collection<?> expected, String msg) {
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
        } catch (AssertionError e) {
            scenarioIsFail = true;
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
        }
    }

    public void evaluateAssertEqualWithImg(String actual, String expected) throws IOException {
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("Pass: checking" + expected);
            scnLog.log(Status.PASS, passNote + " found \"" + expected + "\"");
            createScreenShot(actual, true);
        } catch (AssertionError | IOException e) {
            scenarioIsFail = true;
            System.err.println("Fail: checking" + expected);
            scnLog.log(Status.FAIL, failNote + " not found \"" + expected + "\"");
            createScreenShot(actual, false);
        }
    }

    public void evaluateAssertEqualWithImg(String actual, String expected, String msg) throws IOException {
        try {
            Assert.assertEquals(actual, expected);
            createScreenShot(msg, true);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
        } catch (AssertionError e) {
            scenarioIsFail = true;
            createScreenShot(msg, false);
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
        }
    }

    public void evaluateAssertTrue(Boolean expected, String msg) {
        try {
            Assert.assertTrue(expected);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
        } catch (AssertionError e) {
            scenarioIsFail = true;
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
        }
    }

    public void evaluateAssertTrueWithImg(Boolean expected, String msg) throws IOException {
        try {
            Assert.assertTrue(expected);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
            createScreenShot(msg, true);
        } catch (AssertionError | IOException e) {
            scenarioIsFail = true;
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
            createScreenShot(msg, false);
        }
    }

    public void evaluateAssertFalseWithImg(Boolean expected, String msg) throws IOException {
        try {
            Assert.assertFalse(expected);
            System.out.println("Pass: " + msg);
            scnLog.log(Status.PASS, passNote + " \"" + msg + "\"");
            createScreenShot(msg, true);
        } catch (AssertionError | IOException e) {
            scenarioIsFail = true;
            System.err.println("Fail: " + msg);
            scnLog.log(Status.FAIL, failNote + " \"" + msg + "\"");
            createScreenShot(msg, false);
        }
    }

    public void createScreenShot(String imgName, Boolean statusIsPassed) throws IOException {
        String randomId = UUID.randomUUID().toString();
        String path = pathToImage + "_" + getTtbTestContext().getDriver().getPlatformName() + "_" + imgName + "_" + randomId + ".png";
        takeScreenshot(path);
        if (statusIsPassed == true) {
            scenario.createNode(Given.class, imgName).addScreenCaptureFromPath(path).pass("Pass");
        } else {
            scenario.createNode(Given.class, imgName).addScreenCaptureFromPath(path).fail("Fail");
        }
    }

    /*
    This method helps to handle when one of the test is fail due to timeout
    due to enable to find one of the registered element.
     */
    public void handleAfterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE ||
                result.getStatus() == ITestResult.SKIP) {
            scnLog.log(Status.FAIL, failNote + " " + scenario.getStatus().name() + "-" + result.getThrowable());
            scenario.fail("Fail");
        } else {
            getFeature().pass(testName);
        }
    }

    /*
    This method can be used to stop the test as soon as one of the test scenarios
    fails.
     */
    public  void handleForceStopWhenTestFailAtAfterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE ||
                result.getStatus() == ITestResult.SKIP) {
            scenario.fail("Fail");
            getFeature().fail(result.getThrowable());
        } else {
            getFeature().pass(testName);
        }
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void randomStringAndPress() {
        TtbTestContext context = getTtbTestContext();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int length = 7;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            context.findElement("PB3_KEY_BOARD_" + Character.toUpperCase(randomChar) + "_BUTTON").click();
        }
    }
}
