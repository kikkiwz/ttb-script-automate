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

public class iOSCarTransferFromRunner extends CarTransferFormScenario {

	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        init("iOS");
    	ExtentListeners.setDriver(getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter reporterType = new ExtentHtmlReporter("reports/iOS_Car_Transfer_form.html");
        extentReports.attachReporter(reporterType);
        feature = extentReports.createTest("Car Transfer Form");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}
