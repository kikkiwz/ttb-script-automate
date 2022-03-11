package com.tmb.automation.test.platform1.sprint8.s935;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;

public class TC__Setup extends Base{

	@Parameters({"DeviceProfile" })
	@BeforeTest(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		startEmulator();
		startServer();
	}
	@AfterTest(groups = {"android", "plaform1", "Sprint8", "935"})
	public void AfterTest() {
		stopServer();
		stopEmulator();
	}
}
