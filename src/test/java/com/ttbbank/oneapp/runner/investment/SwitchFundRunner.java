package com.ttbbank.oneapp.runner.investment;

import com.ttbbank.oneapp.scenario.investment.SwitchFundScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class SwitchFundRunner extends SwitchFundScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile("investment-android-oneapp-455-dev-hauwie");
    }

}
