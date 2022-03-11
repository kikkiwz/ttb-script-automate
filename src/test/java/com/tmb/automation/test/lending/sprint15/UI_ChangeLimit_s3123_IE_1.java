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

public class UI_ChangeLimit_s3123_IE_1 extends Base {
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
		sleep(20);
		ld.writeLog();
		LendingTestLib.navigateToHomeScreen_ios(mapData);
		LendingTestLib.navigateToUsageLimit_ios();
		LendingTestLib.navigateToEnterAccountId(mapData);
		

//		TC_Lending_Common.navigateToAdjustUsageLimit(mapData);
		ld.waitVisible(ld.swImg_change2_CardImage, 50);
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		String value1 = ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replace(",","");
//		log("value1="+value1);
		
		log("case right value");
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf(Integer.parseInt(value1)+1000));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
		log("value plus = "+ ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));
		
		
		log("case left value");
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf(Integer.parseInt(value1)-2000));
		ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
		log("value minus = "+ ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));
		ld.click(ld.swLb_Change2_CurrentCreditLimit_text);
		sleep();
		ld.writeLog();

		
//		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), "Usage limit cannot be less than amount spent");
		sleep();
		log("Click Next button");
		ld.click(ld.swBtn_Change2_Next);
		sleep();
		
		// Confirm Adjust Usage Limit page
		ld.waitVisible(ld.swLb_Change3_ConfirmAdjustUsageLimit);
		// check title
		ld.assertText(ld.fX(ld.swLb_Change3_ConfirmAdjustUsageLimit).getText(), "aa");
		//check credit card name
		ld.assertText(ld.fX(ld.swLb_Change3_CardName).getText(), "aa");
		//check credit card number
		ld.assertText(ld.fX(ld.swLb_Change3_CardNumber).getText(), "aa");
		//check old credit limit
		ld.assertText(ld.fX(ld.swLb_Change3_OldCreditLimit_value).getText(), "aa");
		//check new credit limit
		ld.assertText(ld.fX(ld.swLb_Change3_NewCreditLimit_value).getText(), "aa");
		//check confirm menu
		ld.assertText(ld.fX(ld.swBtn_Change3_Confirm).getText(), "Confirm");
		sleep();
		log("Click Next button");
		
		//Complete page
		
		

//		ld.click(ld.swBtn_Change3_Confirm);
//		ld.waitVisible(ld.swLb_Change4_Completed);
//		
//		//check details 
//		ld.assertText(ld.fX(ld.swLb_Change4_Details).getText(), "aa");
//		//check New Credit Limit Text
//		ld.assertText(ld.fX(ld.swLb_Change4_NewCreditLimit_text).getText(), "aa");
//		//check New Credit Limit Value
//		ld.assertText(ld.fX(ld.swLb_Change4_NewCreditLimit_value).getText(), "aa");
//		//check Effective date text
//		ld.assertText(ld.fX(ld.swLb_Change4_EffectiveDate_text).getText(), "aa");
//		ld.writeLog();
//		
		

		
//		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
//		log("Enter Reference Number= "+mapData.get("Invalid_Ref_Number"));
//		ld.setText(ld.fX(ld.swTxtLD_EnterReferenceNumber), mapData.get("Invalid_Ref_Number"));
//		ld.assertText(ld.fX(ld.swBtnLD_EnterRefrenceNumber_Submit).getText(), mapData.get("Submit_Button"));
//		log("Click Submit button");
//		ld.click(ld.swBtnLD_EnterRefrenceNumber_Submit);
//		ld.waitVisible(ld.swLbLD_ErrMsg);
//		ld.assertText(ld.fX(ld.swLbLD_ErrMsg).getText(), mapData.get("ErrorMsg1"));
//		
//		TC_Lending_Common.navigateToEnterAccountId(mapData);
//		
//		ld.waitVisible(ld.swBtnLD_AV_Loading_ScanButton, 30);
//		
//		ld.assertText(ld.fX(ld.swLbLD_AV_Loading_title).getText(), mapData.get("Title"), "Title not match");
//		ld.assertContain(ld.fX(ld.swLbLD_AV_Loading_Description).getText(), mapData.get("Description"), "Description is not match");
//		ld.assertText(ld.fX(ld.swBtnLD_AV_Loading_ScanButton).getText(), mapData.get("Scan_Button"), "Scan card button is not match");
//		ld.assertText(ld.fX(ld.swBtnLD_AV_Loading_EnterCardNumber).getText(), mapData.get("Enter_Button"), "Enter card number button is not match");
//		sleep(5);
	}
}
