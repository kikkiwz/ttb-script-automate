package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.scenario.customerservice.VirtualPassbookScenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class LaunchApp extends BaseScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
    }
}
