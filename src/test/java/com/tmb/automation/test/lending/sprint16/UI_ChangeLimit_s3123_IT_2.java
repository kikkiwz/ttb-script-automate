package com.tmb.automation.test.lending.sprint16;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
import com.tmb.automation.util.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * "Validate Screen load
1. Validate screen label.
2. Click back iCon
3. Click Enter card number button"

====
"1. System display
     1.1. System display static taxt ""Activate card""
     1.2 System display static taxt ""Welcome, K.$customerNameEN, please have your card handy. Activate now to enjoy the privileges and benefits of your $productNameEN card.""
      1.3 System display Back icon as ""<"" on the upper left of screen
      1.4 System display button with static text as ""Scan card"" 
      1.5 System display button with static text as ""Enter card number"" 
2.System navigate back to 'Home' screen
3. System navigate back to ""Enter Card Numbe"" screen successfully"

 * @author oneapp-qa
 *
 */

public class UI_ChangeLimit_s3123_IT_2 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "lending", "Sprint15", "3123"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE =deviceProfile;
		Base.appiumCapabilities();
		ExtentListeners.setDriver(appiumDriver);
		mapData = Helper.getExcelData("TestData_lending", "TestData_3123", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "lending", "Sprint15", "3123"})
	public void teardown() {
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "lending", "Sprint15", "3123"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
	
		ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
		UI_Lending_Common.navigateToHomeScreen_ios(mapData);
		UI_Lending_Common.navigateToUsageLimit_ios();
		UI_Lending_Common.navigateToEnterAccountId(mapData);
		

//		TC_Lending_Common.navigateToAdjustUsageLimit(mapData);
		ld.waitVisible(ld.swImg_change2_CardImage, 50);
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		String value1 = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replaceAll(",", "")));
		log("value1="+value1);
		
		log("case New Credit Limit="+ String.valueOf((int)Double.parseDouble(mapData.get("NewCreditLimit").replaceAll(",", ""))));
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf((int)Double.parseDouble(mapData.get("NewCreditLimit").replaceAll(",", ""))));
		String value2 = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replaceAll(",", "")));
		ld.click(ld.swLb_Change2_CurrentCreditLimit_text);
		sleep();
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);


		
//		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), "Usage limit cannot be less than amount spent");
		sleep();

		
		log("Click Next button");
		ld.click(ld.swBtn_Change2_Next);
		sleep();
//		ld.writeLog();
		ld.waitVisible(ld.swCbx_Change3_Reason);
		log("Click Reason");
		ld.click(ld.swCbx_Change3_Reason);
		ld.waitVisible(ld.swCbX_Change3_Reason_item1);
		log("Click Reason = For Oversea emergency");
		ld.click(ld.swCbX_Change3_Reason_item1);
		sleep();
		ld.assertText(ld.fX(ld.swCbx_Change3_Reason_value).getText(), mapData.get("Reason"));
		
		ld.click(ld.swCbx_Change3_ExpiryDate);
		sleep();
		ld.setNative();
		ld.writeLog();
		

		WebElement el1 = ld.fX("//XCUIElementTypeStaticText[@value=\'27\']");
		WebElement el2 = ld.fX("//XCUIElementTypeStaticText[@value=\'26\']");
		ld.touchAndMove(el1, el2);
		WebElement el3 = ld.fX("//XCUIElementTypeStaticText[@value=\'2564\']");
		WebElement el4 = ld.fX("//XCUIElementTypeStaticText[@value=\'2563\']");
		ld.touchAndMove(el3, el4);
		
		ld.click(ld.fX("//XCUIElementTypeStaticText[@name=\'Done\']"));
		
		
		sleep();
		ld.setWebview();
		ld.assertText(ld.fX(ld.swCbx_Change3_ExpiryDate_value).getText(), mapData.get("ExpiryDate"));
		ld.click(ld.swBtn_Change3_Next);
		sleep();
		
		// Confirm Adjust Usage Limit page
		ld.waitVisible(ld.swLb_Change3_ConfirmAdjustUsageLimit);
		// check title
		ld.assertText(ld.fX(ld.swLb_Change3_ConfirmAdjustUsageLimit).getText(), mapData.get("ConfirmAdjustUsageLimit"));
		//check credit card name
		ld.assertText(ld.fX(ld.swLb_Change3_CardName).getText(), mapData.get("CardName"));
		//check credit card number
		ld.assertContain(ld.fX(ld.swLb_Change3_CardNumber).getText(), mapData.get("CardNumber"));
		//check old credit limit Long.valueOf(bigNumber.replaceAll(",", "").toString())
		
//		String OldCreditLimit = ld.fX(ld.swLb_Change3_OldCreditLimit_value).getText();
		String OldCreditLimit = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change3_OldCreditLimit_value).getText().replaceAll(",", "")));
		ld.assertText(OldCreditLimit, value1);
		//check new credit limit swLb_Change3_NewCreditLimit_value
		String NewCreditLimit = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change3_NewCreditLimit_value).getText().replaceAll(",", "")));
		ld.assertText(NewCreditLimit, value2);
		//check confirm menu
		ld.assertText(ld.fX(ld.swBtn_Change3_Confirm).getText(), mapData.get("Confirm"));
		sleep();
		log("Click Next button");
		ld.click(ld.swBtn_Change3_Confirm);
		sleep();
//		Lending_ActivateCardPage la = new Lending_ActivateCardPage(appiumDriver);
//		sleep(1);
//		ld.setNative();
//		ld.writeLog();
//		log("Enter Pin="+mapData.get("Pin"));
//		ld.EnterConfirmPin(mapData.get("Pin"));
//		ld.waitInVisible(la.siBtnCF_Pin1);
//		sleep(1);
//		ld.setWebview();
//		
//		//Complete page
//		
//		ld.waitVisible(ld.swBtn_Change4_BackToMainPage);
//		//check Complete title
//		ld.assertText(ld.fX(ld.swLb_Change4_Completed).getText(), mapData.get("Complete_title"));
//		//check details 
//		ld.assertText(ld.fX(ld.swLb_Change4_Details).getText(), mapData.get("Details"));
//		//lcheck new credit limit text
//		ld.assertText(ld.fX(ld.swLb_Change4_NewCreditLimit_text).getText(), mapData.get("NewCreditLimitText"));
//		//check new credit limit value  swLb_Change4_NewCreditLimit_value
//		ld.assertText(String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change4_NewCreditLimit_value).getText().replaceAll(",", ""))), value2);
//		//check Effective date text
//		ld.assertText(ld.fX(ld.swLb_Change4_EffectiveDate_text).getText(), mapData.get("EffectiveDateText"));
//		//check Effective date value
////		ld.assertText(ld.fX(ld.swLb_Change4_EffectiveDate_value).getText(), mapData.get("EffectiveDateValue"));
//		//check swBtn_Change4_BackToMainPage
//		ld.assertText(ld.fX(ld.swBtn_Change4_BackToMainPage).getText(), mapData.get("BackToMainPage"));
//		sleep(10);
//		ld.click(ld.swBtn_Change4_BackToMainPage);
//		sleep();
		
	}
}
