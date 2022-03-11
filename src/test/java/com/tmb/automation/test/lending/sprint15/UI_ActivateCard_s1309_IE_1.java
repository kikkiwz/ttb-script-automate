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

 * @author oneapp-qa
 *
 */

public class UI_ActivateCard_s1309_IE_1 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"ios", "lending", "Sprint15", "1309"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
		mapData = Helper.getExcelData("TestData_lending", "TestData_1309", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"ios", "lending", "Sprint15", "1309"})
	public void teardown() {
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "lending", "Sprint15", "1309"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
	
		
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		LendingTestLib.navigateToHomeScreen_ios(mapData);
		LendingTestLib.navigateToActivateCard_ios();
		
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
		log("Enter Reference Number= "+mapData.get("Invalid_Ref_Number"));
		ld.setText(ld.fX(ld.swTxtLD_EnterReferenceNumber), mapData.get("Invalid_Ref_Number"));
		ld.assertText(ld.fX(ld.swBtnLD_EnterRefrenceNumber_Submit).getText(), mapData.get("Submit_Button"));
		log("Click Submit button");
		ld.click(ld.swBtnLD_EnterRefrenceNumber_Submit);
		ld.waitVisible(ld.swLbLD_ErrMsg);
		ld.assertText(ld.fX(ld.swLbLD_ErrMsg).getText(), mapData.get("ErrorMsg1"));
		
		LendingTestLib.navigateToEnterAccountId(mapData);
		
		ld.waitVisible(ld.swBtnLD_AV_Loading_ScanButton, 30);
		
		ld.assertText(ld.fX(ld.swLbLD_AV_Loading_title).getText(), mapData.get("Title"), "Title not match");
		ld.assertContain(ld.fX(ld.swLbLD_AV_Loading_Description).getText(), mapData.get("Description"), "Description is not match");
		ld.assertText(ld.fX(ld.swBtnLD_AV_Loading_ScanButton).getText(), mapData.get("Scan_Button"), "Scan card button is not match");
		ld.assertText(ld.fX(ld.swBtnLD_AV_Loading_EnterCardNumber).getText(), mapData.get("Enter_Button"), "Enter card number button is not match");
		sleep(5);
	}
}
