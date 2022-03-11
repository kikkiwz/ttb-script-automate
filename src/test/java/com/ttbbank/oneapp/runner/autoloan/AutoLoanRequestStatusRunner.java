package com.ttbbank.oneapp.runner.autoloan;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.autoloan.AutoLoanReceiptScenario;
import com.ttbbank.oneapp.scenario.autoloan.AutoLoanRequestStatusScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AutoLoanRequestStatusRunner extends AutoLoanRequestStatusScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/RequestStatus_"+ttbTestContext.getPlateFormName()+".html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("RequestStatus");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}
