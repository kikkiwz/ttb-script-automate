package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.ForgotPinScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ForgotPinRunner extends ForgotPinScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }
}
