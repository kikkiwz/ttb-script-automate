package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.MoreDiscoverToSettingScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MoreDiscoverToSettingRunner extends MoreDiscoverToSettingScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
    }

}
