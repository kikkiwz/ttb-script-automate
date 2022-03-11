package com.ttbbank.oneapp.runner.platform2.ui;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.lending.ProductLandingOfC2GScenario;
import com.ttbbank.oneapp.scenario.platform2.ChangeEmailScenario;
import com.ttbbank.oneapp.scenario.platform2.ChangeEmailScenario2;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class ChangeEmailRunner extends ChangeEmailScenario {

    @Parameters({"DeviceProfile","scenarioTestName"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String deviceProfile,@Optional String scenarioTestName) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile,scenarioTestName);
    }

}