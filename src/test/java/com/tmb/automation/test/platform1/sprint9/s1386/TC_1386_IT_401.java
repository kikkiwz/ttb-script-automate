package com.tmb.automation.test.platform1.sprint9.s1386;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.pages.platform1.WelcomeScreenPage;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp14_MB_Access PIN TH_SIT_00003	Validate Access Pin screen when channel status is Active and customer already input some PIN number
 */



public class TC_1386_IT_401 extends Base {
	
	@Parameters({  "DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void setUp( @Optional("android.E4") String deviceProfile) throws IOException { //String language, String device
		Helper.CONFIG_PROFILE = deviceProfile;
		Base.appiumCapabilities();
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void teardown() {
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "plaform1", "Sprint8", "935"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		mapData = Helper.getExcelData("TestData_platform1", "TestData_1386", this.getClass().getSimpleName());

		sleep(10);
		WelcomeScreenPage ws = new WelcomeScreenPage(appiumDriver);
		ws.assertText(ws.fX(ws.siLbPagename).getAttribute("name"), map("Pagename"));
		
	}
}
