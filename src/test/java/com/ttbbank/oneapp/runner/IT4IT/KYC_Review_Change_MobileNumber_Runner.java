package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.KYC_Review_Change_MobileNumberScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class KYC_Review_Change_MobileNumber_Runner extends KYC_Review_Change_MobileNumberScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(groups = "KYC verify with change mobile number")
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
        
    }
}
