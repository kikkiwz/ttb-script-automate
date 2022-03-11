package com.ttbbank.oneapp.runner.primarybanking2;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.primarybanking2.PB2Common;
import com.ttbbank.oneapp.scenario.primarybanking2.UITest.ManageDebitCard.ManageDebitCard1Scenario;
import com.ttbbank.oneapp.scenario.primarybanking2.UITest.SettingPromptpay.Android.SettingPromptPayScenariosForAndroid;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageDebitCardRunner extends ManageDebitCard1Scenario {


    @Parameters({"DeviceProfile", "Language"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(ITestContext ct, @Optional String deviceProfile, @Optional String language) throws IOException {
        log("BeforeTest");
        testWithDeviceProfile(deviceProfile, ct.getName());
//        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        driver = ttbTestContext.getDriver();
        System.out.println("platformName="+driver.getPlatformName());
        ExtentListeners.setDriver(driver);
        PB2Common.deviceProfile = deviceProfile;
        PB2Common.dataProfile = ct.getName();
        PB2Common.language = language.isEmpty()?PB2Common.language:language;
        ExtentReports extentReports = new ExtentReports();
        //"Report_"+ttbTestContext.getPlateFormName()+"_"+ TIMESTAMP1 + "_" + ct.getName();
//        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/"+dataProfile+".html");
        ExtentReporter extentReporter = new ExtentHtmlReporter(
                "reports/"+"PB2_"+ TIMESTAMP + "_"  + ttbTestContext.getPlateFormName() + "_" + ct.getName()+".html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest(ct.getName());
        setFeature(feature);
        setExtentReports(extentReports);
        scenario = getFeature().createNode(Scenario.class, ct.getName());
        //backup reort
        ExReport.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.isSuccess() == true) {
            addReport("PB2 - Manage Debit Card - AfterTest() - Finish");
        } else if (result.isSuccess() == false) {
            Throwable th = result.getThrowable();
            if (th != null) {
                addReport("PB2 - Manage Debit Card - AfterTest:" + result.toString() + " " + th.getMessage());
                result.setThrowable(null);
            }
        }
                if (deviceProfile.toLowerCase().contains("saucelabs")){
            System.out.println("Send status to Saucelabs");
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess()?"passed":"failed"));
        }
    }
    @AfterTest(alwaysRun = true)
    public void afterTest(ITestContext result) {
        PB2Common.log("afterSuite1");
        writelog();
    }

}


