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

public class iOSByYourselfRunner extends selectMethodCloseByYourself{
	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        init("ios");
    	ExtentListeners.setDriver(getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/iOS_process_by_bank.html");
        extentReports.attachReporter(extentReporter);
        feature = extentReports.createTest("Select Process By Bank");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}
