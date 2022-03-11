package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.setschedule.other.SetScheduleOtherToOwnAccountWeeklyByTimesScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SetScheduleOtherToOwnAccountWeeklyByTimesRunner extends SetScheduleOtherToOwnAccountWeeklyByTimesScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("SetScheduleOtherToOwnAccountWeeklyByAmountOfTimesScenario");
    }

    @AfterClass(groups = {"Set schedule other transfer to own account by amount of times frequency weekly"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
