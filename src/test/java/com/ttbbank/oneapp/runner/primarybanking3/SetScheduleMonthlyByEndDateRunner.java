package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.setschedule.own.SetScheduleMonthlyByEndDateScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SetScheduleMonthlyByEndDateRunner extends SetScheduleMonthlyByEndDateScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("SetScheduleMonthlyByEndDateScenario");
    }

    @AfterClass(groups = {"Set schedule monthly by end date"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}