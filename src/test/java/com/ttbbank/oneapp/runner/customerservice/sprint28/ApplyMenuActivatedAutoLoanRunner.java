package com.ttbbank.oneapp.runner.customerservice.sprint28;

import com.ttbbank.oneapp.scenario.customerservice.sprint28.ApplyMenuActivatedAutoLoanScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class ApplyMenuActivatedAutoLoanRunner extends ApplyMenuActivatedAutoLoanScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
        testWithDeviceProfile(deviceProfile);
    }
}
