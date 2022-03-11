package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.ProspectAccountSummaryScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class ProspectAccountSummaryRunner extends ProspectAccountSummaryScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Prospect Account Summary");
    }

    @AfterMethod(groups = {"AccountSummary Group"})
    public  void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"AccountSummary Group"})
    public  void  afterClass() {
        getExtent().flush();
    }

}
