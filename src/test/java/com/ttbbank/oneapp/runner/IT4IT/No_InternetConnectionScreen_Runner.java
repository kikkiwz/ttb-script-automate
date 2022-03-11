package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.No_InternetConnectionScreen_Scenario;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class No_InternetConnectionScreen_Runner extends No_InternetConnectionScreen_Scenario {

	@Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        
    }
}
