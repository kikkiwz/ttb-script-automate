package com.ttbbank.oneapp.runner.platform2.ui;

import com.ttbbank.oneapp.scenario.platform2.ChangeEmailEmptyScenario;
import com.ttbbank.oneapp.scenario.platform2.ChangeEmailFlagNScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class ChangeEmailFlagNRunner extends ChangeEmailFlagNScenario {

    @Parameters({"DeviceProfile","scenarioTestName"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String deviceProfile,@Optional String scenarioTestName) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile,scenarioTestName);
    }

}