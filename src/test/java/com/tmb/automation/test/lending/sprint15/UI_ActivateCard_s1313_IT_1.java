package com.tmb.automation.test.lending.sprint15;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ActivateCardPage;
import com.tmb.automation.util.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * "Validate Enter Card Number Screen 
1. Validate screen label.
2. Validate Back iCon.
3.Validate credit card number
4. Validate numeric keypad "

"1. System display
     1.1. System display static taxt ""เปิดใช้งานบัตร""
     1.2 System display static taxt ""กรุณาระบุหมายเลขบัตรตำแหน่งที่ 7 - 12 ""
2.System display Back icon as ""<"" on the upper left of screen
3.System display as label 1234-56__-____-1234  7th-12th digit is blank
4.System display  numeric keypad  0-9 "


 * @author oneapp-qa
 *
 */

public class UI_ActivateCard_s1313_IT_1 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "lending", "Sprint15", "1309"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
		mapData = Helper.getExcelData("TestData_lending", "TestData_1309", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "lending", "Sprint15", "1309"})
	public void teardown() {
		com.tmb.automation.util.Base.driverQuit();
	}
	
	@Test(groups = {"android", "lending", "Sprint15", "1309"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
	
		
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		LendingTestLib.navigateToHomeScreen_ios(mapData);
		LendingTestLib.navigateToActivateCard_ios();
		LendingTestLib.navigateToEnterAccountId(mapData);
		LendingTestLib.navigateToLanding();
		
		ld.assertText(ld.fX(ld.swLbLD_AV_EnterCard_Title).getText(), mapData.get("Title"), "Title not match");
		ld.assertText(ld.fX(ld.swLbLD_AV_EnterCard_Description).getText(), mapData.get("Description"), "Description is not match");
		sleep();
	}
}
