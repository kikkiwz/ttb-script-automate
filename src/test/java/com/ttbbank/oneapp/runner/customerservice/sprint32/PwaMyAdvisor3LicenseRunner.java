package com.ttbbank.oneapp.runner.customerservice.sprint32;

import com.ttbbank.oneapp.scenario.customerservice.sprint32.PwaMyAdvisor3LicenseScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class PwaMyAdvisor3LicenseRunner extends PwaMyAdvisor3LicenseScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
    }
}
