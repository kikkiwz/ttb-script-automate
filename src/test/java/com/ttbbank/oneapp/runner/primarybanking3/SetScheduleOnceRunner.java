package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.setschedule.own.SetScheduleOnceScenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SetScheduleOnceRunner extends SetScheduleOnceScenario {
        @Parameters({"DeviceProfile"})
        @BeforeTest(alwaysRun = true)
        public void BeforeTest(@Optional String deviceProfile) {
            initialContext(deviceProfile);
            createReport("SetscheduleOnceScenario");
        }

        @AfterClass(groups = {"Set schedule once"})
        public void afterClass() {
            TtbTestContext ttbTestContext = getTtbTestContext();
            ttbTestContext.getDriver().closeApp();
        }
}
