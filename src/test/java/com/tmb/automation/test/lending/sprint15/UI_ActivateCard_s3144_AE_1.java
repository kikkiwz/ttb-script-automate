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
 * "Validate CVV screen 
1. Validate screen label.
2. Click           (CVV Info) in bottom sheet
"	"1. System display
    1.1. System display static taxt ""Activate card""
    1.2 System display static taxt ""Please enter 3 digits of CVV number.""
    1.3 System display key pad.
2. System display
     2.1  System display static image and text ""What is credit card CVV""
     2.2  System display detail as below ""The CVV number (""Card Verification Value"") is a 3 digits number on the back of credit and debit cards"""
 * @author oneapp-qa
 *
 */

public class UI_ActivateCard_s3144_AE_1 extends Base {
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
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "lending", "Sprint15", "1309"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		LendingTestLib.navigateToHomeScreen(mapData);
		LendingTestLib.navigateToActivateCard();
		LendingTestLib.navigateToEnterAccountId(mapData);
		LendingTestLib.navigateToLanding();
		

		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter1), mapData.get("Invalid_CardNumber1"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter2), mapData.get("Invalid_CardNumber2"));
		ld.assertText(ld.fX(ld.swLbLD_ActivateCard3_ErrMsg).getText(), mapData.get("ErrorMsg2"));
		sleep();
		log("Enter CardNumber1="+mapData.get("Valid_CardNumber1"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter1), mapData.get("Valid_CardNumber1"));
		log("Enter CardNumber2="+mapData.get("Valid_CardNumber2"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter2), mapData.get("Valid_CardNumber2"));
		ld.waitInVisible(ld.swLbLD_ActivateCard3_ErrMsg);
		sleep();
	}
}