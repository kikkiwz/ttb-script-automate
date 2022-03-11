package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.ActivationScenario;
import org.testng.annotations.*;

public class ActivationRunner extends ActivationScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

    @AfterMethod(groups = {"Activation Group", "Reactivation Group"})
    public void tearDown() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().resetApp();
    }

    @AfterClass(groups = {"Activation Group", "Reactivation Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
