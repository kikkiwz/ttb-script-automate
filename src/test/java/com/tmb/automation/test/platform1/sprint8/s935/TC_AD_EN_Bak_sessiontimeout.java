package com.tmb.automation.test.platform1.sprint8.s935;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
TC_OneApp935_MB_POC_Enter PIN_VIT_00030	Validate screen when time out to enter PIN
 */



public class TC_AD_EN_Bak_sessiontimeout extends Base {
	
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void setUp() throws IOException {
		Base.androidCapabilities();
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "935"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		mapData = Helper.testData("group_sprint10_935", this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.alertAction("accept");
		hs.setWebview();

		log("TC_OneApp935_MB_POC_Enter PIN_VIT_00030	Validate screen when time out to enter PIN");
		hs.waitVisible(hs.swBtnHS_ShowBalance);
		hs.click(hs.swBtnHS_ShowBalance);
		sleep();
		hs.setNative();
		hs.waitVisible(hs.saLbHS_EnterYourPin);
		hs.EnterPin("010203");
		sleep();
		hs.setWebview();
		hs.waitVisible(hs.swLbHS_CustName);
		hs.assertTrue(hs.swLbHS_CustName);
		sleep(310000);
		hs.click(hs.saBtnHS_footer_Profile);
		hs.assertText(hs.fX("/hierarchy/android.widget.Toast").getText(), map("Text1"));

	}
}
