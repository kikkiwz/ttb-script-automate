package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.ChangeLanguage_Scenario;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class ChangeLanguage_Runner extends ChangeLanguage_Scenario {

	@Parameters({"DeviceProfile"})
	@BeforeTest(groups = "Change Language from English to thai and Thai to English")
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
		
		Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
        
    }
}
