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
 * "Validate CVV less than 3 digit
1. Input cvv 2 digit "	1. System is still current page.
 * @author oneapp-qa
 *
 */
public class UI_ActivateCard_s3144_IE_2 extends Base {
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
		LendingTestLib.navigateToHomeScreen_ios(mapData);
		LendingTestLib.navigateToActivateCard_ios();
		LendingTestLib.navigateToEnterAccountId(mapData);
		LendingTestLib.navigateToLanding();

		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter1), mapData.get("Invalid_CardNumber1"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter2), mapData.get("Invalid_CardNumber2"));
		ld.assertText(ld.fX(ld.swLbLD_ActivateCard3_ErrMsg).getText(), mapData.get("ErrorMsg2"));
		sleep();
		
		LendingTestLib.navigateToEnterCardNumber(mapData);
		
		ld.waitVisible(ld.swImgLD_AV_EnterCVV_icon);
		
		ld.assertText(ld.fX(ld.swLbLD_AV_EnterCVV_Title).getText(), mapData.get("CVV_Title"));
		ld.assertText(ld.fX(ld.swlbLD_AV_EnterCVV_Description).getText(), mapData.get("CVV_Description"));
		
		LendingTestLib.enterCVV(mapData.get("Invalid_CVV_PIN"));
		
		ld.waitVisible(ld.swLbLD_AV_EnterCVV_ErrMsg);
		ld.assertText(ld.fX(ld.swLbLD_AV_EnterCVV_ErrMsg).getText(),  mapData.get("ErrorMsg3"));
		
		LendingTestLib.enterCVV(mapData.get("Valid_CVV_PIN"));
		sleep(1);
		ld.setNative();
		ld.writeLog();
		log("Enter Pin="+mapData.get("Pin"));
		ld.EnterConfirmPin(mapData.get("Pin"));
		ld.waitInVisible(ld.siBtnCF_Pin1);
		sleep();
		ld.setWebview();
//		ld.waitInVisible(ld.swLbLD_AV_EnterCVV_ErrMsg);
		
//		sleep(5);
		
		ld.waitVisible(ld.swLbLD_ActivateCardComplete_title);
		ld.assertText(ld.fX(ld.swLbLD_ActivateCardComplete_title).getText(), "Completed.");
//		log(ld.fX(ld.swLbLD_ActivateCardComplete_description).getText().replaceAll("", ""));
//		ld.assertText(ld.fX(ld.swLbLD_ActivateCardComplete_description).getText(), "Card number. "+
//				"4770 - 2700 - 0000 - 0215"+
//				"is already activated");
//		ld.assertContain(ld.swLbLD_ActivateCardComplete_description).getText(), "is already activated");
		ld.assertText(ld.fX(ld.swBtnLD_ActivateCardComplete_BackToMainPage).getText(), "Back to Main Page");
		sleep(15);
		ld.click(ld.swBtnLD_ActivateCardComplete_BackToMainPage);
	}
}
