package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class iOSCalculateClosingAccountRunner extends CalculateClosingAccountScenario {
	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        init("ios");
    	ExtentListeners.setDriver(getDriver());
        ExtentReports extentReport = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/ios-calculate-close account.html");
        extentReport.attachReporter(extentReporter);
        feature = extentReport.createTest("Calculate for close account");
        setFeature(feature);
        setExtentReports(extentReport);
    }
}
