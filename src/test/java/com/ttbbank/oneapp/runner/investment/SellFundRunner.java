package com.ttbbank.oneapp.runner.investment;


import com.ttbbank.oneapp.scenario.investment.SellFundScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class SellFundRunner extends SellFundScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile("investment-android-oneapp-455-dev-hauwie");
    }

}
