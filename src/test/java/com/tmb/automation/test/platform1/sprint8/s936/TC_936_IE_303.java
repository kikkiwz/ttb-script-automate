package com.tmb.automation.test.platform1.sprint8.s936;

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
TC_OneApp_MB_POC_Verify Email EN_SIT_00012	"Validate screen when customer click on verify email button and display existing email if customer change new email
"
TC_OneApp_MB_POC_Verify Email EN_SIT_00014	"Validate screen when customer click on verify email button and display existing email that registered with bank in email field
"
TC_OneApp_MB_POC_Verify Email EN_SIT_00016	"Check screen when customer edit or change email if customer need
"
TC_OneApp_MB_POC_Verify Email EN_SIT_00018	"Validate screen if email format is incorrect then system display Inline error MSG_01
- Special Character : !@#$%^&*()+

"
TC_OneApp_MB_POC_Verify Email EN_SIT_00020	"Validate screen if email format is incomplete then system display Inline error MSG_02
- Incomplete email
- no @ after email name

"
TC_OneApp_MB_POC_Verify Email EN_SIT_00022	"Validate screen if enter email does not exist
- Email is not exist

"
 */



public class TC_936_IE_303 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000001184383", false);
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_936", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "936"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "936"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.setWebview();
		
		
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00011	\"Validate screen when customer click on verify email button and display existing email if customer change new email");
				hs.click(hs.swBtnHS_VerifyEmail);
//		hs.click(hs.swBtnHS_ChangeEmail);
//		sleep(0.5);
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("010203");
		hs.setWebview();
//		sleep(0.5);
		VerifyEmailpage ver = new VerifyEmailpage(appiumDriver);
		hs.waitVisible(ver.swTxtVerifyEmail_Email);
		String str = hs.fX(ver.swTxtVerifyEmail_Email).getAttribute("value");
		sleep();
		hs.assertTrue(ver.fX(ver.swTxtVerifyEmail_Email).isEnabled());
		hs.assertTrue(ver.fX(ver.swBtnVerifyEmail_VerifyEmail).isEnabled());
		
		
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00013	\"Validate screen when customer click on verify email button and display existing email that registered with bank in email field");
		hs.assertTrue(str.length()>0);
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00015	\"Check screen when customer edit or change email if customer need");
		hs.fX(ver.swTxtVerifyEmail_Email).clear();
		sleep();
		ver.setText2(hs.fX(ver.swTxtVerifyEmail_Email), map("Value1"));
		hs.assertText(hs.fX(ver.swTxtVerifyEmail_Email).getAttribute("value"), map("Value1"));
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00017	\"Validate screen if email format is incorrect then system display Inline error MSG_01");
		hs.fX(ver.swTxtVerifyEmail_Email).clear();
		sleep();
		ver.setText2(ver.fX(ver.swTxtVerifyEmail_Email), map("Value2"));
		hs.click(hs.fX(ver.swBtnVerifyEmail_VerifyEmail));
		hs.assertText(hs.fX(ver.swLbVerifyEmail_EmailErrorMsg).getText(), map("MSG_01"));

		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00019	\"Validate screen if email format is incomplete then system display Inline error MSG_02");
		hs.fX(ver.swTxtVerifyEmail_Email).clear();
		sleep();
		ver.setText2(ver.fX(ver.swTxtVerifyEmail_Email), map("Value3"));
		hs.click(hs.fX(ver.swBtnVerifyEmail_VerifyEmail));
		hs.assertText(hs.fX(ver.swLbVerifyEmail_EmailErrorMsg).getText(), map("MSG_02"));
		
		log("TC_OneApp_MB_POC_Verify Email EN_SIT_00021	\"Validate screen if enter email does not exist");
		hs.fX(ver.swTxtVerifyEmail_Email).clear();
		sleep();
		ver.setText2(ver.fX(ver.swTxtVerifyEmail_Email), map("Value4"));
		hs.click(hs.fX(ver.swBtnVerifyEmail_VerifyEmail));
		hs.assertText(hs.fX(ver.swLbVerifyEmail_EmailErrorMsg).getText(), map("MSG_01"));
	}
}
