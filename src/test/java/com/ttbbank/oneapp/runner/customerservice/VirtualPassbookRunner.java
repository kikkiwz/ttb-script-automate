package com.ttbbank.oneapp.runner.customerservice;

import com.ttbbank.oneapp.scenario.customerservice.VirtualPassbookScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class VirtualPassbookRunner extends VirtualPassbookScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
    }

}
