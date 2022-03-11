package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.setschedule.validation.ValidateSetScheduleOwnTransferScenario;
import org.testng.annotations.*;

public class ValidateSetScheduleOwnTransferRunner extends ValidateSetScheduleOwnTransferScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("ValidateSetScheduleOwnTransferScenario");
    }

    @AfterClass(groups = {"Validate SetSchedule OwnTransfer"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
