package com.ttbbank.oneapp.runner.autoloan;

import com.ttbbank.oneapp.scenario.autoloan.AutoLoanPaymentHistoryScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AutoLoanPaymentHistoryRunner extends AutoLoanPaymentHistoryScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);
    }
}
