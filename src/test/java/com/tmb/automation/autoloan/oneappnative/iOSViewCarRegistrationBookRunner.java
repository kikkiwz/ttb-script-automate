package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class iOSViewCarRegistrationBookRunner extends ViewRegistrationBookScenario{

	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        init("iOS");
    	ExtentListeners.setDriver(getDriver());
        ExtentReports extent = new ExtentReports();
        ExtentReporter reporterType = new ExtentHtmlReporter("reports/iOS-View-Car-Registration-Book.html");
        extent.attachReporter(reporterType);
        feature = extent.createTest(Feature.class, "iOS view car registration book");
        setFeature(feature);
        setExtentReports(extent);
    }
}
