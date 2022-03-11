package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.CustomerToMoreDiscoverScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class CustomerToMoreDiscoverRunner extends CustomerToMoreDiscoverScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Customer More Discover Screen");
    }

    @AfterMethod(groups = {"Customer More Screen Group"})
    public  void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"Customer More Screen Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
        getExtent().flush();
    }
}
