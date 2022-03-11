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

public class IOSContractCopyRunner extends CopyOfContractScenario {

	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        init("ios");
    	ExtentListeners.setDriver(getDriver());
        ExtentReports extent = new ExtentReports();
        ExtentReporter reporterType = new ExtentHtmlReporter("reports/ios-copy-of-contract.html");
        extent.attachReporter(reporterType);
        feature = extent.createTest(Feature.class, "iOS Contract Copy");
        setFeature(feature);
        setExtentReports(extent);
    }
}
