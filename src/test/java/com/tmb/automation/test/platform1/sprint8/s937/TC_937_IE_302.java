package com.tmb.automation.test.platform1.sprint8.s937;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.pages.platform1.VerifyEmailpage;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp_MB_POC_Verify Email EN_SIT_00006	"Check screen customer can see existing email that registered with bank in email field
"
 */



public class TC_937_IE_302 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000001184383", true);
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_937", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "937"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "937"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.setWebview();
	
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00005	\"Check screen customer can see existing email that registered with bank in email field");
		
//		hs.click(hs.swBtnHS_VerifyEmail);
		hs.click(hs.swBtnHS_ChangeEmail);
//		sleep(0.5);
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("010203");
		hs.setWebview();
//		sleep(0.5);
		VerifyEmailpage ver = new VerifyEmailpage(appiumDriver);
		hs.waitVisible(ver.swBtnVerifyEmail_Back);

		hs.assertTrue(ver.swTxtVerifyEmail_Email);
		hs.assertTrue(hs.fX(ver.swTxtVerifyEmail_Email).getAttribute("value").length()>0);
		
		
		
	}
}
