package com.tmb.automation.test.platform1.sprint9.s14;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp14_MB_Access PIN TH_SIT_00003	Validate Access Pin screen when channel status is Active and customer already input some PIN number
 */



public class TC_014_AE_101 extends Base {
	
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
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		
		log("TC_OneApp14_MB_Access PIN TH_SIT_00001	Validate Access Pin screen when channel status is Active and not yet enter PIN");
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		hs.setNative();
		hs.waitVisible(hs.saBtnHS_Pin0);
		
		hs.assertText(hs.fX(hs.saLbHS_EnterYourPin).getText(), map("Pin_Title"));
		
		hs.assertText(hs.fX(hs.saBtnHS_Pin0).getText(), map("Pin0"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin1).getText(), map("Pin1"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin2).getText(), map("Pin2"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin3).getText(), map("Pin3"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin4).getText(), map("Pin4"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin5).getText(), map("Pin5"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin6).getText(), map("Pin6"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin7).getText(), map("Pin7"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin8).getText(), map("Pin8"));
		hs.assertText(hs.fX(hs.saBtnHS_Pin9).getText(), map("Pin9"));
		
		hs.assertText(hs.fX(hs.saBtnHS_ForgetPIN).getText(), map("ForgetPin"));
		
	}
}
