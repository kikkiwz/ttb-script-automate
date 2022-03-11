package com.ttbbank.oneapp.runner.lending;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.lending.ApplyeStatementScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class ApplyeStatementRunner extends ApplyeStatementScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Apply eStatement Flash Card.html");
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Apply eStatement Verify email.html");
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Loan Apply eStatement Verify email.html");
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Change Email.html");
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Loan Change Email.html");
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Apply eStatement Credit Card.HTML");

        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("Apply eStatement Flash Card");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}