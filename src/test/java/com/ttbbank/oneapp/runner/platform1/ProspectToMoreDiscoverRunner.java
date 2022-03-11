package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.ProspectToMoreDiscoverScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class ProspectToMoreDiscoverRunner extends ProspectToMoreDiscoverScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Prospect Discover More");
    }

    @AfterMethod(groups = {"Prospect walk through Group"})
    public void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"Prospect walk through Group"})
    public void afterClass() {
        getExtent().flush();
    }
}
