package com.ttbbank.oneapp.runner.primarybanking7;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking7.TopUpScheduleOneTwoCallOnceScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TopUpScheduleOneTwoCallOnceRunner extends TopUpScheduleOneTwoCallOnceScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("TopUpScheduleOneTwoCallOnceSuccess");
    }

    @AfterClass(groups = {"TopUp schedule 1-2-call once success"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
