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



public class TC_935_IT_405 extends Base {
	
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
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00006	Verify input PIN field on enter PIN screen");
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.assertText(hs.fX(hs.siLbHS_EnterYourPin).getText()
				, map("Text1_TH"));
		hs.click(hs.fX(hs.siBtnHS_PinClose));
		sleep();
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00008	Verify enter PIN static on enter PIN screen");
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.assertText(hs.fX(hs.siLbHS_EnterYourPin).getText()
				, map("Text2_TH"));
		hs.click(hs.siBtnHS_PinClose);
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00010	Verify number pad on enter PIN screen");
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);

		
		hs.assertText(hs.fX(hs.siBtnHS_Pin0).getText(), map("Pin0"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin1).getText(), map("Pin1"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin2).getText(), map("Pin2"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin3).getText(), map("Pin3"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin4).getText(), map("Pin4"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin5).getText(), map("Pin5"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin6).getText(), map("Pin6"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin7).getText(), map("Pin7"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin8).getText(), map("Pin8"));
		hs.assertText(hs.fX(hs.siBtnHS_Pin9).getText(), map("Pin9"));
		hs.click(hs.siBtnHS_PinClose);
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00012	Verify delete icon on enter PIN screen");
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("123");
		hs.assertTrue(hs.siBtnHS_PinClear);
		hs.click(hs.siBtnHS_PinClose);
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00014	Verify forgot PIN icon on enter PIN screen");
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siLbHS_EnterYourPin);
		hs.EnterPin("123");
		hs.assertText(hs.fX(hs.siBtnHS_ForgetPIN).getText(), map("Text3_TH"));
		hs.click(hs.siBtnHS_PinClose);
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00002	Verify tab bar on enter PIN screen ");
		hs.setWebview();
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.siBtnHS_ForgetPIN);
		hs.EnterPin(map("PinSuccess"));
		sleep();
		hs.setWebview();
//		sleep(15);
//		Helper.writeLog(appiumDriver.getPageSource());
		hs.waitVisible(hs.swLbHS_CustName);
		hs.assertTrue(hs.swLbHS_CustName);
		
		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00004	Verify profile picture on enter PIN screen");
		hs.waitVisible(hs.swImgHS_Profile);
		hs.assertTrue(hs.swImgHS_Profile);
	}
}
