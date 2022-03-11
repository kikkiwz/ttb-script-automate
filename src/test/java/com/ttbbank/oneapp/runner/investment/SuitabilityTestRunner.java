package com.ttbbank.oneapp.runner.investment;

import com.ttbbank.oneapp.scenario.investment.SellFundScenario;
import com.ttbbank.oneapp.scenario.investment.SuitabilityTestScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;


public class SuitabilityTestRunner extends SuitabilityTestScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);
    }

}
