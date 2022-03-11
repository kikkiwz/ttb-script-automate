package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.ChangeLanguage_Scenario;
import com.ttbbank.oneapp.scenario.IT4IT.FirstTimeUserScenario;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class FirstTimeUserRunner extends FirstTimeUserScenario {

	@Parameters({"DeviceProfile"})
	@BeforeTest(groups = "First Time User validation")
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
		
		Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
        
    }
}
