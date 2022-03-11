package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.SettingManageWidgetScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

class SettingManageWidgetRunner extends SettingManageWidgetScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Setting Manage Widget");
    }

    @AfterMethod(groups = {"Setting Manage Widget Group"})
    public  void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"Setting Manage Widget Group"})
    public void afterClass() {
        getExtent().flush();
    }
}