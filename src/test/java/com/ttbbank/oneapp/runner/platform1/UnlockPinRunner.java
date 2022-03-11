package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.UnlockPinScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class UnlockPinRunner extends UnlockPinScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Unlock pin");
    }

    @BeforeMethod(groups = {"Unlock pin Group"})
    public  void beforeMethod() {
        getCitizenId();
    }

    @AfterMethod(groups = {"Unlock pin Group"})
    public  void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"Unlock pin Group"})
    public void afterClass() {
        getExtent().flush();
    }

}
