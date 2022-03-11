package com.ttbbank.oneapp.runner.customerservice.sprint28;

import com.ttbbank.oneapp.scenario.customerservice.sprint28.DeleteButtonHelpCenterScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class DeleteButtonHelpCenterRunner extends DeleteButtonHelpCenterScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
    }
}
