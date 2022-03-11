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
    1.1. System display static taxt ""เปิดใช้งานบัตร""
    1.2 System display static taxt ""กรุณาใส่รหัส 3 ตัว หลังบัตรในช่องด้านล่าง""
    1.3 System display key pad.
2. System display
     2.1  System display static image and text ""หมายเลข CVV คืออะไร""
     2.2  System display detail as below ""หมายเลข CVV คือหมายเลข 3 หลักที่อยู่ด้านหลังของบัตร"""
 * @author oneapp-qa
 *
 */
public class UI_ActivateCard_s3144_IT_1 extends Base {
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
		sleep(1);
		log("Enter CardNumber1="+mapData.get("Valid_CardNumber1"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter1), mapData.get("Valid_CardNumber1"));
		log("Enter CardNumber2="+mapData.get("Valid_CardNumber2"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter2), mapData.get("Valid_CardNumber2"));
		ld.waitInVisible(ld.swLbLD_ActivateCard3_ErrMsg);
	}
}
