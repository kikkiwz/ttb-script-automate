package com.ttbbank.oneapp.runner.primarybanking7;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking7.TopUpScheduleTrueMonthlyEndDateScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TopUpScheduleTrueMonthlyEndDateRunner extends TopUpScheduleTrueMonthlyEndDateScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("TopUpScheduleTrueMonthlyEndDateSuccess");
    }

    @AfterClass(groups = {"Topup schedule true monthly end date success"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
