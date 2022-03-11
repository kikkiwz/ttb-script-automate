package com.tmb.automation.test.lending.sprint17;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ActivateCardPage;
import com.tmb.automation.pages.lending.BlockCardPage;
import com.tmb.automation.util.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 
 * @author oneapp-qa
 *
 */

public class UI_BlockCard_s4938_AE_2 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "lending", "Sprint15", "4938"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE =deviceProfile;
		Base.appiumCapabilities();
		ExtentListeners.setDriver(appiumDriver);
		mapData = Helper.getExcelData("TestData_lending", "TestData_4938", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "lending", "Sprint15", "4938"})
	public void teardown() {
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "lending", "Sprint15", "4938"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		BlockCardPage ld = new BlockCardPage(appiumDriver);
		UI_Lending_Common.navigateToHomeScreen(mapData);
		UI_Lending_Common.navigateToBlockCard();
		UI_Lending_Common.navigateToEnterAccountId(mapData);
		sleep();

		ld.setWebview();
		ld.waitVisible(ld.swLbBC_Title);
		ld.assertText(ld.fX(ld.swLbBC_Title).getText(), mapData.get("Title"));
		ld.assertText(ld.fX(ld.swLbBC_Desc1).getText(), mapData.get("Desc1"));
		ld.assertText(ld.fX(ld.swLbBC_Desc2).getText(), mapData.get("Desc2"));
		ld.assertText(ld.fX(ld.swLbBC_Desc3).getText(), mapData.get("Desc3"));
//		ld.assertText(ld.fX(ld.swLbBC_Address).getText(), mapData.get("Address"));
		ld.assertText(ld.fX(ld.swLbBC_Info).getText(), mapData.get("Info"));
		ld.assertText(ld.fX(ld.swBtnBC_Confirm).getText(), mapData.get("Confirm"));
		log("Click Confirm button");
		ld.click(ld.swBtnBC_Confirm);
		
		sleep(1);
		ActivateCardPage la = new ActivateCardPage(appiumDriver);
		sleep(1);
		ld.setNative();
		ld.writeLog();
		log("Enter Pin="+mapData.get("Pin"));
		ld.EnterConfirmPin(mapData.get("Pin"));
		ld.waitInVisible(la.siBtnCF_Pin1);
		sleep(1);
		ld.setWebview();
		ld.waitVisible(ld.swLbBC_Finish_Title);
		ld.assertText(ld.fX(ld.swLbBC_Finish_Title).getText(), mapData.get("FinishComplete_Title"));
		ld.click(ld.swLbBC_Finish_BacktoMainPage);
		sleep(1);
		
	}
}
