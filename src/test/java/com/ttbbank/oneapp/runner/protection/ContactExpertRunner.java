package com.ttbbank.oneapp.runner.protection;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.protection.ContactExpertScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class ContactExpertRunner extends ContactExpertScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);

        TtbTestContext ttbTestContext = getTtbTestContext();
		
		 ExtentListeners.setDriver(ttbTestContext.getDriver()); ExtentReports
		 extentReports = new ExtentReports(); ExtentReporter extentReporter = new
		 ExtentHtmlReporter("reports/Protection Contact an Expert.html");
		 extentReports.attachReporter(extentReporter); ExtentTest feature =
		 extentReports.createTest("Contact an Expert"); setFeature(feature);
		 setExtentReports(extentReports);
		
    }
}
