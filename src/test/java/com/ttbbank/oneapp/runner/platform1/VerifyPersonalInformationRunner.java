package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.ActivationScenario;
import com.ttbbank.oneapp.scenario.platform1.VerifyPersonalInformationScenario;
import org.testng.annotations.*;

public class VerifyPersonalInformationRunner extends VerifyPersonalInformationScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

    @AfterClass(groups = {"Verify Personal Information Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
