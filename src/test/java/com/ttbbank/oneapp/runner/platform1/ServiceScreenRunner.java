package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.ServiceScreenProspectScenario;
import org.testng.annotations.*;

public class ServiceScreenRunner extends ServiceScreenProspectScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

    @AfterMethod(groups = {"ServiceScreen Prospect Group"})
    public void tearDown() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().resetApp();
    }

    @AfterClass(groups = {"ServiceScreen Prospect Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
