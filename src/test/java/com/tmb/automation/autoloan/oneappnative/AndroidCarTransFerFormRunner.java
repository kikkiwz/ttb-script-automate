package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AndroidCarTransFerFormRunner extends CarTransferFormScenario {
	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile ) throws MalformedURLException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Helper.CONFIG_PROFILE =deviceProfile;   	
        init("android");
        ExtentListeners.setDriver(getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/Android_Car_Transfer_Form.html");
        extentReports.attachReporter(extentReporter);
        feature = extentReports.createTest("Android Car Transfer");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}
