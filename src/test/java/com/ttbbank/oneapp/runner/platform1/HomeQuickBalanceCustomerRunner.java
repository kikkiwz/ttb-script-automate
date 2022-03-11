package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.HomeQuickBalanceCustomerScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class HomeQuickBalanceCustomerRunner extends HomeQuickBalanceCustomerScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Home Quick Balance Group");
    }

    @AfterMethod(groups = {"Home Quick Balance Group"})
    public  void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"Home Quick Balance Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
        getExtent().flush();
    }
}
