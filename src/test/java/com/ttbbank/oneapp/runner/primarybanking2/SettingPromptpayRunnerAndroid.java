package com.ttbbank.oneapp.runner.primarybanking2;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking2.UITest.SettingPromptpay.Android.SettingPromptPayScenariosForAndroid;
import com.ttbbank.oneapp.scenario.primarybanking2.UITest.SettingPromptpay.IOS.SettingPromptPayScenariosForiOS;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class SettingPromptpayRunnerAndroid extends SettingPromptPayScenariosForAndroid {


    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws IOException {

        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/SettingPromptPay.html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("Setting PromptPay");
        setFeature(feature);
        setExtentReports(extentReports);

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuiteEst() {
        System.out.println(ttbTestContext.getDriver().getPageSource());
    }
}


