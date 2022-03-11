package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.KYC_AfterLogin_Flag_I_Scenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class KYC_AfterLogin_Flag_I_Runner extends KYC_AfterLogin_Flag_I_Scenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
    }
}
