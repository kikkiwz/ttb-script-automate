package com.tmb.automation.test.platform1.sprint8.s935;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.pages.platform1.VerifyEmailpage;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
 * TC_OneApp935_MB_POC_Profilepicture_VIT_00002
 * "1. Open OneApp success
 2. Check Home screen"	"- Show profile picture correctly
- The system show the layout, color and size of profile picture is correctly."
 */



public class TC_935_IT_408 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000001184383", false);
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_935", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "935"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.setWebview();

		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00034	Validate screen when tab on back button (in case able to click)");
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("010203");
		sleep();
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_VerifyEmail);
		hs.click(hs.swBtnHS_VerifyEmail);
//		hs.waitVisibleXpath(hs.swBtnHS_ChangeEmail);
//		hs.click(hs.swBtnHS_ChangeEmail);
		VerifyEmailpage verify = new VerifyEmailpage(appiumDriver);
		hs.waitVisible(verify.swBtnVerifyEmail_Back);
		hs.click(verify.swBtnVerifyEmail_Back);
		hs.waitVisible(hs.swLbHS_Message);
		hs.assertTrue(hs.swLbHS_Message);
	}
}
