package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.platform1.ActivationScenario;
import com.ttbbank.oneapp.scenario.platform1.HomeScreenProspectScenario;
import org.testng.annotations.*;

public class HomeScreenProspectRunner extends HomeScreenProspectScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

    @AfterMethod(groups = {"HomeScreen Prospect Group"})
    public void tearDown() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().resetApp();
    }

    @AfterClass(groups = {"HomeScreen Prospect Group"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
