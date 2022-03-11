package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.setschedule.other.SetScheduleOtherTTBMonthlyByTimesScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SetScheduleOtherTTBMonthlyByTimesRunner extends SetScheduleOtherTTBMonthlyByTimesScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("SetScheduleTransferOtherToOtherTTBAccountMonthlyByTimesScenario");
    }

    @AfterClass(groups = {"SetScheduleTransferOtherToOtherTTBAccountMonthlyByTimesScenario"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
