package com.ttbbank.oneapp.runner.IT4IT;


import com.itextpdf.text.log.SysoCounter;
import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.More_Button_Validation_Scenario;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class More_Button_Validation_Runner extends More_Button_Validation_Scenario {

	@Parameters({"DeviceProfile"})
	@BeforeTest(groups = "More Button Validation")
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException, InterruptedException {
		Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
    }
}
