package com.ttbbank.oneapp.runner.investment;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.scenario.investment.MoreActionTestScenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoreActionRunner extends MoreActionTestScenario {

    private Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_a");
    String reportDate = formatter.format(date);

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);

        ExtentListeners.setDriver(getTtbTestContext().getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter;
        if (getTtbTestContext().isAndroid()) {
            extentReporter = new ExtentHtmlReporter("reports/ui_investment_android_" + reportDate + ".html");
        } else {
            extentReporter = new ExtentHtmlReporter("reports/ui_investment_ios_" + reportDate + ".html");
        }
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("More page");
        setFeature(feature);
        setExtentReports(extentReports);

    }

}
