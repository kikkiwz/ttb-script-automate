package com.ttbbank.oneapp.runner.customercentric;

import com.ttbbank.oneapp.scenario.customercentric.TestScenario;
import org.testng.annotations.*;

public class TestRunner extends TestScenario {
    
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        testWithDeviceProfile(deviceProfile);
    }

}
