package com.ttbbank.oneapp.runner.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.autoloan.AutoLoanAccountDetailScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AutoLoanAccountDetailRunner extends AutoLoanAccountDetailScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
//        ExtentReports extentReports = new ExtentReports();
//
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/AccountDetail"+ttbTestContext.getPlateFormName()+".html");
//        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("Auto loan account detail");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}
