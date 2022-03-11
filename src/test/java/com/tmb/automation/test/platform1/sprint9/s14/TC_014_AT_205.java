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
import static io.restassured.RestAssured.given;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp14_MB_Invalid PIN EN_SIT_00001	Validate enter invalid PIN on fist time 
 */



public class TC_014_AT_205 extends Base {
	
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
		
		log("TC_OneApp14_MB_Access PIN TH_SIT_00009	 Validate input PIN field "
				+ "If customer input correct PIN and customer email flag as \"N\"");
		
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		hs.setNative();
		hs.waitVisible(hs.saBtnHS_Pin0);
		
		hs.EnterPin("010204");
		sleep();
		hs.waitVisible(hs.saLbHS_TextShow);
		hs.assertText(hs.fX(hs.saLbHS_TextShow).getText(), map( "Error_Text_Show1_TH"));
		
		hs.EnterPin("010204");
		sleep();
		hs.waitVisible(hs.saLbHS_TextShow);
		hs.assertText(hs.fX(hs.saLbHS_TextShow).getText(), map( "Error_Text_Show2_TH"));
		
		//
		hs.EnterPin("010204");
		sleep(5);
		
		hs.waitVisible(hs.saLbPinLock_Title, 100);
		hs.assertText(hs.fX(hs.saLbPinLock_Title).getText()
				,map("PinLock_Title_TH"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Message).getText()
				, map("PinLock_Message_TH"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Description).getText()
				, map("PinLock_Description_TH"));
		
		hs.assertText(hs.fX(hs.saBtnPinLock_SetNewPin).getText()
				, map("SetNewPin_TH"));
	}
}
