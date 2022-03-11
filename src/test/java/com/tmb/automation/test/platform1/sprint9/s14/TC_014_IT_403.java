package com.tmb.automation.test.platform1.sprint9.s14;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
TC_OneApp14_MB_Access PIN EN_SIT_00007	 Validate input PIN field If customer input correct PIN and customer email flag as "Y"
 
 */



public class TC_014_IT_403 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_14", this.getClass().getSimpleName());
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
		hs.waitVisible(hs.swLbHS_Message);
		
		log("Set customer email flag as Y ");
		//Send api with email_flag=Y
		//sendApi(email_flag_y);
		
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		hs.setNative();
		hs.waitVisible(hs.siBtnHS_Pin0);
		
		hs.assertText(hs.fX(hs.siLbHS_EnterYourPin).getText(), map("Pin_Title_TH"));
		
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
		
		hs.assertText(hs.fX(hs.siBtnHS_ForgetPIN).getText(), map("ForgetPin_TH"));
		
	}
}
