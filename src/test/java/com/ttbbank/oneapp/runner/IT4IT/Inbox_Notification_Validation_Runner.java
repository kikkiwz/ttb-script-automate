package com.ttbbank.oneapp.runner.IT4IT;


import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.IT4IT.Inbox_Notification_and_messages_Validation_Scenario;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class Inbox_Notification_Validation_Runner extends Inbox_Notification_and_messages_Validation_Scenario {

	@Parameters({"DeviceProfile"})
	@BeforeTest(groups = "Inbox notification and Messages Validation")
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {
    	Helper.CONFIG_PROFILE =deviceProfile;
        testWithDeviceProfile(deviceProfile);
        Extentreportfeature();
    }
}
