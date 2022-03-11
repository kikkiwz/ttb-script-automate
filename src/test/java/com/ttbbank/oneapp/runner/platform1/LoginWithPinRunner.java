package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.LoginWithPinScenario;
import org.testng.annotations.*;

public class LoginWithPinRunner extends LoginWithPinScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

    @AfterMethod(groups = {"Login With Pin Group"})
    public void tearDown() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.getDriver().closeApp();
            ttbTestContext.getDriver().launchApp();
        } else {
            ttbTestContext.getDriver().resetApp();
        }
    }

    @AfterClass(groups = {"Login With Pin Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
