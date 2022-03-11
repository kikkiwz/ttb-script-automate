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
TC_OneApp_MB_POC_Verify Email EN_SIT_00002	"Validate screen when click ""Back"" button

TC_OneApp_MB_POC_Verify Email EN_SIT_00004	"Check screen customer can see
'- Header is "" Verify Email ""
'- Content details
- Logo
- Verify button

 */



public class TC_937_IE_301 extends Base {
	
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
		
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00002	\"Validate screen when click \"\"Back\"\" button\"");
//				hs.click(hs.swBtnHS_VerifyEmail);
		hs.click(hs.swBtnHS_ChangeEmail);
		sleep(0.5);
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("010203");
		hs.setWebview();
		sleep(0.5);
		VerifyEmailpage verify = new VerifyEmailpage(appiumDriver);
		hs.waitVisible(verify.swBtnVerifyEmail_Back);
		hs.click(verify.swBtnVerifyEmail_Back);
		hs.waitVisible(hs.swLbHS_Message);
		hs.assertTrue(hs.swLbHS_Message);
		
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00003	\"Check screen customer can see");
		
//		hs.waitVisible(hs.swBtnHS_VerifyEmail);
		hs.waitVisible(hs.swBtnHS_ChangeEmail);
		hs.assertText(hs.fX(hs.swLbHS_Message).getText(), map("Text1"));
		hs.assertText(hs.fX(hs.swLbHS_Seeall).getText(), map("Text2"));
		hs.assertText(hs.fX(hs.swLbHS_ChangeEmail).getText(), map("Text3"));
		hs.assertText(hs.fX(hs.swLbHS_ChangeEmail_Content).getText(), map("Text4"));
		
//		hs.click(hs.swBtnHS_VerifyEmail);
		hs.click(hs.swBtnHS_ChangeEmail);
		VerifyEmailpage ver = new VerifyEmailpage(appiumDriver);
		hs.waitVisible(ver.swLbVerifyEmail_Title);
		hs.assertText(hs.fX(ver.swLbVerifyEmail_Title).getText(), map("Text5"));
		hs.assertText(hs.fX(ver.swLbVerifyEmail_Description).getText(), map("Text6"));
		hs.assertText(hs.fX(ver.swBtnVerifyEmail_VerifyEmail).getText(), map("Text7"));
		hs.assertTrue(ver.swImgVerifyEmail_Image);
		
	}
}
