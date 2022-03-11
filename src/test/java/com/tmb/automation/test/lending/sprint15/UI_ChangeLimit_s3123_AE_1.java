package com.tmb.automation.test.lending.sprint15;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
import com.tmb.automation.util.Base;
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

public class UI_ChangeLimit_s3123_AE_1 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "lending", "Sprint15", "3123"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
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
		LendingTestLib.navigateToHomeScreen(mapData);
		LendingTestLib.navigateToUsageLimit();
		LendingTestLib.navigateToEnterAccountId(mapData);
		

//		TC_Lending_Common.navigateToAdjustUsageLimit(mapData);
		ld.waitVisible(ld.swImg_change2_CardImage, 50);
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		String value1 = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replaceAll(",", "")));
		log("value1="+value1);
		
		log("Case min");
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		log("Enter CreditLimit = "+mapData.get("Min_Value"));
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), mapData.get("Min_Value"));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), mapData.get("Min_ErrorMsg"));
		
		log("Case max");
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		log("Enter CreditLimit = "+mapData.get("Max_Value"));
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), mapData.get("Max_Value"));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), mapData.get("Max_ErrorMsg"));
		
		log("case right value");
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		log("Enter CreditLimit = "+String.valueOf((int)Double.parseDouble(value1)-1000));
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf((int)Double.parseDouble(value1)-1000));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
//		log("value plus = "+ ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));
//		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), "Usage limit cannot be less than amount spent");
		
		log("case left value");
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		log("Enter CreditLimit = "+String.valueOf((int)Double.parseDouble(value1)+2000));
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf((int)Double.parseDouble(value1)+2000));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
//		log("value minus = "+ ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));
		String value2 = String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replaceAll(",", "")));
		ld.click(ld.swLb_Change2_CurrentCreditLimit_text);
		sleep();

		
//		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), "Usage limit cannot be less than amount spent");

		
		log("Click Next button");
		ld.click(ld.swBtn_Change2_Next);
		sleep();
		
		// Confirm Adjust Usage Limit page
		ld.waitVisible(ld.swLb_Change3_ConfirmAdjustUsageLimit);
		// check title
		ld.assertText(ld.fX(ld.swLb_Change3_ConfirmAdjustUsageLimit).getText(), mapData.get("ConfirmAdjustUsageLimit"));
		//check credit card name
		ld.assertText(ld.fX(ld.swLb_Change3_CardName).getText(), mapData.get("CardName"));
		//check credit card number
		ld.assertText(ld.fX(ld.swLb_Change3_CardNumber).getText(), mapData.get("CardNumber"));
		//check old credit limit Long.valueOf(bigNumber.replaceAll(",", "").toString())
		
//		ld.writeLog();
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
		
		//Complete page
		
		ld.waitVisible(ld.swBtn_Change4_BackToMainPage);
		//check Complete title
		ld.assertText(ld.fX(ld.swLb_Change4_Completed).getText(), mapData.get("Complete_title"));
		//check details 
		ld.assertText(ld.fX(ld.swLb_Change4_Details).getText(), mapData.get("Details"));
		//lcheck new credit limit text
		ld.assertText(ld.fX(ld.swLb_Change4_NewCreditLimit_text).getText(), mapData.get("NewCreditLimitText"));
		//check new credit limit value  swLb_Change4_NewCreditLimit_value
		ld.assertText(String.valueOf((int)Double.parseDouble(ld.fX(ld.swLb_Change4_NewCreditLimit_value).getText().replaceAll(",", ""))), value2);
		//check Effective date text
		ld.assertText(ld.fX(ld.swLb_Change4_EffectiveDate_text).getText(), mapData.get("EffectiveDateText"));
		//check Effective date value
//		ld.assertText(ld.fX(ld.swLb_Change4_EffectiveDate_value).getText(), mapData.get("EffectiveDateValue"));
		//check swBtn_Change4_BackToMainPage
		ld.assertText(ld.fX(ld.swBtn_Change4_BackToMainPage).getText(), mapData.get("BackToMainPage"));
		ld.click(ld.swBtn_Change4_BackToMainPage);
		sleep(10);
		
	}
}
