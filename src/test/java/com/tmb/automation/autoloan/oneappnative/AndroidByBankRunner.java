package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AndroidByBankRunner extends SelectMethodCloseByBankScenario{
	@Parameters({"DeviceProfile" })
	@BeforeTest
    public void BeforeTest(String deviceProfile ) throws MalformedURLException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Helper.CONFIG_PROFILE =deviceProfile;   	
        init("android");
        ExtentListeners.setDriver(getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/android_process_by_bank.html");
        extentReports.attachReporter(extentReporter);
        feature = extentReports.createTest("Select Process By Bank");
        setFeature(feature);
        setExtentReports(extentReports);
        
    }
	@AfterTest
	public void Teardown() {
		getDriver().quit();
		
	}
	
}
