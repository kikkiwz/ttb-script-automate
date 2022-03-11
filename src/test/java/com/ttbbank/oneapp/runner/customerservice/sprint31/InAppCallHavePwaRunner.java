package com.ttbbank.oneapp.runner.customerservice.sprint31;

import com.ttbbank.oneapp.scenario.customerservice.sprint31.InAppCallHavePwaScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class InAppCallHavePwaRunner extends InAppCallHavePwaScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
    }
}
