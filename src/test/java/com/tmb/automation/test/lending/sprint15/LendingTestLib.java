

package com.tmb.automation.test.lending.sprint15;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.pages.lending.*;
import com.tmb.automation.util.Base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class LendingTestLib extends Base {
//	public static final String PHRASE = "";
	public static void navToHomeScreen(String footer, String pin){
		HomeScreenPage ld = new HomeScreenPage(appiumDriver);
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")){
			ld.waitVisible(ld.saHS_Home_btn);
			ExtentReport4.printScreenshot("HomeScreen");
			if (footer.equalsIgnoreCase("Home")){
				ld.click(ld.saHS_Home_btn);//Click Home menu
			}
			else if (footer.equalsIgnoreCase("Account")){
				ld.click(ld.saHS_Account_btn);//Click Accounts menu
				ld.EnterPin(pin);//"Enter Pin="+pin
				ld.waitInVisible(ld.saBtnHS_Pin1);
			}
			else if (footer.equalsIgnoreCase("Service")){
				ld.click(ld.saHS_Service_btn);//Click Service menu
				ld.EnterPin(pin);//Enter Pin="+pin
				ld.waitInVisible(ld.saBtnHS_Pin1);
			}
			else {
				ld.click(ld.saHS_Discovery_btn);//Click Discovery menu
			}
		}
		else if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")){
			ld.waitVisible(ld.siHS_Home_btn, 90);
			ExtentReport4.printScreenshot("HomeScreen");
			if (footer.equalsIgnoreCase("Home")){
				ld.click(ld.siHS_Home_btn);//Click Home menu
			}
			else if (footer.equalsIgnoreCase("Account")){
				ld.click(ld.siHS_Account_btn);//Click Accounts menu
				ld.EnterPin(pin);//Enter Pin="+pin
				ld.waitInVisible(ld.siBtnHS_Pin1);
			}
			else if (footer.equalsIgnoreCase("Service")){
				ld.click(ld.siHS_Service_btn);//Click Service menu
				ld.EnterPin(pin);//Enter Pin="+pin
				ld.waitInVisible(ld.siBtnHS_Pin1);
			}
			else {
				ld.click(ld.saHS_Discovery_btn);//Click Discovery menu
			}
		}
	}

	public static void navToService(String menu, String pin){
		HomeScreenPage hs = new HomeScreenPage(appiumDriver);
		ExtentReport4.printScreenshot("Enter Pin="+pin);
		ServicePage ld = new ServicePage(appiumDriver);
		ld.setWebview();
		ld.waitVisible(ld.swSV_goToNativePage);
		ExtentReport4.printScreenshot("HomeScreen:");
		if (menu.toLowerCase().equalsIgnoreCase("apply so good")){
			ld.scrollIntoView(ld.swSV_applySoGood);
			ld.clickJS(ld.swSV_applySoGood);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("usage limit")){
			ld.scrollIntoView(ld.swSV_usageLimit);
			ld.clickJS(ld.swSV_usageLimit);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("block credit card")){
			ld.scrollIntoView(ld.fX(ld.swSV_blockCreditCard));
			ld.clickJS(ld.swSV_blockCreditCard);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("working information")){
			ld.scrollIntoView(ld.fX(ld.swSV_workingInformation));
			ld.clickJS(ld.swSV_workingInformation);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("personal information")){
			ld.scrollIntoView(ld.fX(ld.swSV_PersonalInformation));
			ld.clickJS(ld.swSV_PersonalInformation);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("edit address")){
			ld.scrollIntoView(ld.fX(ld.swSV_editAddress));
			ld.clickJS(ld.swSV_editAddress);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("loan")){
			ld.scrollIntoView(ld.fX(ld.swSV_Loan));
			ld.click(ld.swSV_Loan);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("letter of consent")){
			ld.scrollIntoView(ld.fX(ld.swSV_letterOfConsent));
			ld.click(ld.swSV_letterOfConsent);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("flexi loan terms and conditions")){
			ld.scrollIntoView(ld.fX(ld.swSV_flexiLoanTermAndConditions));
			ld.clickJS(ld.swSV_flexiLoanTermAndConditions);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("flexi loan")){
			ld.scrollIntoView(ld.fX(ld.swSV_flexiLoan));
			ld.clickJS(ld.swSV_flexiLoan);
		}
		else if (menu.toLowerCase().equalsIgnoreCase("show contact list")){
			ld.scrollIntoView(ld.fX(ld.swSV_showContactList));
			ld.clickJS(ld.swSV_showContactList);
		}
		else {
			System.out.println(menu + " not found");
		}
	}
	public static void navToAccounts(String menu){
		AccountSummaryPage ld = new AccountSummaryPage(appiumDriver);
		ld.waitVisible(ld.siAS_Card_btn);
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")){
			//click cards tab
			//click a card under cards tab.
		}
		else if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")){

			ExtentReport4.printReportMessage("Click Account > Accounts Page");
			if (menu.toLowerCase().contains("cards")){
				ld.click(ld.siAS_Card_btn);
				ld.waitVisible(ld.siAS_Card1_CardName, 100);
				ExtentReport4.printReportMessage("Click Card tab > List of Cards");
				String account = "4518-21XX-XXXX-0036";
				log(ld.fX("//XCUIElementTypeStaticText[@value=\'4 5 1 8 - 2 1 X X - X X X X - 0 0 3 6 \']").getText());
				log(ld.fX("//XCUIElementTypeStaticText[@value=\'Royal Top Brass Credit Card\']").getText());
				if (ld.isElementPresent("//XCUIElementTypeStaticText[@value=\'4 5 1 8 - 2 1 X X - X X X X - 0 0 3 6 \']")){

					ld.click(ld.fX("//XCUIElementTypeStaticText[@value=\'4 5 1 8 - 2 1 X X - X X X X - 0 0 3 6 \']"));
					sleep(50);
					ExtentReport4.printReportMessage("card webview");
//					ld.setWebview();
//					ld.writeLog();
//					Assert.fail();
				}
				else if (ld.isElementPresent("//XCUIElementTypeStaticText[@value=\'4518-21XX-XXXX-xxxx\']")){
					//....
					//new Actions(appiumDriver).clickAndHold(ld.fX(ld.siAS_Card1_CardName)).perform();
				}

			}
			else if (menu.toLowerCase().contains("loan")){
				ld.click(ld.siAS_Loan_btn);
				ld.waitVisible(ld.siAS_Loan_Card1, 50);
				ExtentReport4.printReportMessage("Click Card tab > List of Cards");
				new Actions(appiumDriver).clickAndHold(ld.fX(ld.siAS_Loan_Card1)).perform();
			}
			else {
				log(menu + " not found!");
			}
		}
	}

	public static void navToMyCreditCard(){
		CreditLandingPage cl = new CreditLandingPage(appiumDriver);
		cl.setWebview();
		cl.waitVisible(cl.swCL_plus_btn, 100);
		ExtentReport4.printReportMessage("Credit Landing Page");
	}

	public static void navToLoanSubmission() {
		CreditLandingPage cl = new CreditLandingPage(appiumDriver);
		cl.clickJS(cl.swCL_plus_btn);
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL0_entryPointToFlexiLoan);
		ExtentReport4.printReportMessage("Select Credit card page");
		fl.scrollIntoView(fl.swFL0_entryPointToFlexiLoan);
		fl.clickJS(fl.swFL0_entryPointToFlexiLoan);
	}

	public static void navigateToHomeScreen(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setContext("ttbbank");
		ld.waitVisible(ld.swBtnLD_CC);
		sleep();
		ld.setNative();
		log("Click Discovery menu");
		ld.waitVisible(ld.saHS_Discovery_btn);
		ld.click(ld.saHS_Discovery_btn);
		log("Enter Pin="+mapData.get("Pin"));
		ld.EnterPin(mapData.get("Pin"));
		ld.waitInVisible(ld.saBtnHS_Pin1);
	}
	public static void navigateToHomeScreen_ios(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setNative();
		log("Click Accounts menu");
		ld.waitVisible(ld.siHS_Accounts_btn);
		ExtentReport4.printReportMessage("Homescreen");
		ld.click(ld.siHS_Accounts_btn);

		ld.setNative();
//		log("Enter Pin="+mapData.get("ui_pin"));
//		ld.EnterPin(mapData.get("ui_pin"));
		log("Enter Pin=010203");
		ld.EnterPin("010203");
		ExtentReport4.printReportMessage("Enter Pin");
	}
	public static void navigateToService_ios(Map<String, Object> data) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
//		ld.setNative();

		log("Click Service menu");
//		ld.setWebview();
//		sleep(10);
//		ld.writeLog();
//		Assert.fail();

//		ld.waitVisible(ld.siHS_Service_btn);
//		ExtentReport4.printScreenshot("HomeScreen");
//		ld.click(ld.siHS_Service_btn);
		ld.waitVisible(ld.siHS_Home_btn);
		log("swipe (282, 695, 269, 683)");
		ld.swipe(282, 695, 269, 683);

//		ld.setNative();
		log("Enter Pin="+(String) data.get("ui_pin"));
		ld.EnterPin((String) data.get("ui_pin"));
		ExtentReport4.printScreenshot("Enter Pin");
	}
	public static void navigateToActivateCard() {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setWebview(0);
		ld.waitVisible(ld.swDisc_ActivateCard_btn);
		log("Click Discover > Activate Card");
		ld.click(ld.swDisc_ActivateCard_btn);
	}
	public static void navigateToActivateCard_ios() {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setWebview();
		ld.waitVisible(ld.swDisc_ActivateCard_btn);
		log("Click Discover > Activate Card");
		ld.click(ld.swDisc_ActivateCard_btn);
	}
	public static void navigateToEnterAccountId(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
		log("Enter Reference Number= "+mapData.get("Valid_Ref_number"));
		ld.setText(ld.fX(ld.swTxtLD_EnterReferenceNumber), mapData.get("Valid_Ref_number"));
		ld.assertText(ld.fX(ld.swBtnLD_EnterRefrenceNumber_Submit).getText(), mapData.get("Submit_Button"));
		log("Click Submit button");
		sleep(5);
		ld.click(ld.swBtnLD_EnterRefrenceNumber_Submit);
		sleep();
	}
	public static void navigateToLanding() {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.waitVisible(ld.swBtnLD_AV_Loading_ScanButton);
		log("Click Enter Card Number button");
		ld.click(ld.swBtnLD_AV_Loading_EnterCardNumber);
		sleep();
		ld.waitVisible(ld.swLbLD_ActivateCard2_PreNumber);
	}
	public static void navigateToEnterCardNumber(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.waitVisible(ld.swLbLD_ActivateCard2_PreNumber);
		log("Enter CardNumber1="+mapData.get("Valid_CardNumber1"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter1), mapData.get("Valid_CardNumber1"));
		log("Enter CardNumber2="+mapData.get("Valid_CardNumber2"));
		ld.setText(ld.fX(ld.swTxtLD_AV_EnterCard_PleaseEnter2), mapData.get("Valid_CardNumber2"));
		sleep();
		ld.waitInVisible(ld.swLbLD_ActivateCard3_ErrMsg);
	}
	public static void enterCVV(String strCVV) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		for (int i = 0; i < strCVV.length(); i++) {
			if (strCVV.split("")[i].contentEquals("0")) {
				Log.logger.debug("Click 0");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin0).click();
			}
			else if (strCVV.split("")[i].contentEquals("1")) {
				Log.logger.debug("Click 1");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin1).click();
			}
			else if (strCVV.split("")[i].contentEquals("2")) {
				Log.logger.debug("Click 2");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin2).click();
			}
			else if (strCVV.split("")[i].contentEquals("3")) {
				Log.logger.debug("Click 3");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin3).click();
			}
			else if (strCVV.split("")[i].contentEquals("4")) {
				Log.logger.debug("Click 4");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin4).click();
			}
			else if (strCVV.split("")[i].contentEquals("5")) {
				Log.logger.debug("Click 5");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin5).click();
			}
			else if (strCVV.split("")[i].contentEquals("6")) {
				Log.logger.debug("Click 6");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin6).click();
			}
			else if (strCVV.split("")[i].contentEquals("7")) {
				Log.logger.debug("Click 7");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin7).click();
			}
			else if (strCVV.split("")[i].contentEquals("8")) {
				Log.logger.debug("Click 8");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin8).click();
			}
			else if (strCVV.split("")[i].contentEquals("9")) {
				Log.logger.debug("Click 9");
				ld.fX(ld.swBtnLD_ActivateCard3_Pin9).click();
			}
		}
	}

	//======== Usage Limit
	public static void navigateToUsageLimit() {
		ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
		ld.setContext("WEBVIEW_com.ttbbank.oneapp.vit");
		sleep();
		ld.waitVisible(ld.swDC_UsageLimit_btn);
		log("Click Discover > Usage Limit");
		ld.click(ld.swDC_UsageLimit_btn);
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
	}
	public static void navigateToUsageLimit_ios() {
		ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
		ld.setWebview();
		ld.waitVisible(ld.swDC_UsageLimit_btn);
		log("Click Discover > Usage Limit");
		ld.click(ld.swDC_UsageLimit_btn);
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
	}
	public static void navigateToAccountSummary_ios() {
		AccountSummaryPage ld = new AccountSummaryPage(appiumDriver);
		log("Click Account Summary > Card");
		ld.click(ld.siAS_Card_btn);
		ld.waitVisible("(//XCUIElementTypeCell//XCUIElementTypeStaticText[@name=\'Black Diamond\'])[1]", 50);
		ExtentReport4.printReportMessage("Card No.1");
		log("Click Black Diamond card");
		new Actions(appiumDriver).clickAndHold(ld.fX("(//XCUIElementTypeCell//XCUIElementTypeStaticText[@name=\'Black Diamond\'])[1]")).perform();
		ld.waitVisible(ld.siAS_AmountSpent1, 50);
		ExtentReport4.printReportMessage("Credit Landing page");



		ld.touchAndMove(ld.fX(ld.siAS_AvailableSpent1), ld.fX(ld.siAS_AmountSpent1));
		sleep(7);
		ExtentReport4.printReportMessage("Credit No.2");
		ld.touchAndMove(ld.fX(ld.siAS_AvailableSpent2), ld.fX(ld.siAS_AmountSpent2));
		sleep();
		ExtentReport4.printReportMessage("Credit No.3");
		//-----
		//click bill at first card
		ld.touchAndMove(ld.fX(ld.siAS_Card_Unbilled), ld.fX(ld.siAS_Title1));
		sleep(1);
		ExtentReport4.printReportMessage("Credit No.3 > Unbilled");
		ld.click(ld.fX(ld.siAS_Card_Billed));
		sleep(1);
		ExtentReport4.printReportMessage("Credit No.3 > Billed");
		ld.click(ld.siAS_Card_Billed_Period1);
		ExtentReport4.printReportMessage("Credit No.3 > Period");
		ld.click(ld.siAS_Card_Billed_Period2);
		ld.click(ld.siAS_Card_Billed_ok);
		ExtentReport4.printReportMessage("Credit No.3 > Select Period=May 2022");
		sleep(1);
		ld.touchAndMove(ld.fX(ld.siAS_Card_Billed_UpperButton), ld.fX(ld.siAS_Card_Billed_Download));
		sleep();

		ld.waitVisible(ld.siAS_Card3_More);
		ExtentReport4.printReportMessage("Card No.3 > Details");
	}
	public static void navigateToAdjustUsageLimit(Map<String, String> mapData) {
		ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
		ld.waitVisible(ld.swImg_change2_CardImage);
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		ld.setText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), "55000");
	}
	public static void setATMPin(String strATMPin) {
		AccountSummaryPage ld = new AccountSummaryPage(appiumDriver);
		for (int i = 0; i < strATMPin.length(); i++) {
			if (strATMPin.split("")[i].contentEquals("0")) {
				Log.logger.debug("Click 0");
				ld.fX(ld.siAS_SetATMPin_0).click();
			}
			else if (strATMPin.split("")[i].contentEquals("1")) {
				Log.logger.debug("Click 1");
				ld.fX(ld.siAS_SetATMPin_1).click();
			}
			else if (strATMPin.split("")[i].contentEquals("2")) {
				Log.logger.debug("Click 2");
				ld.fX(ld.siAS_SetATMPin_2).click();
			}
			else if (strATMPin.split("")[i].contentEquals("3")) {
				Log.logger.debug("Click 3");
				ld.fX(ld.siAS_SetATMPin_3).click();
			}
			else if (strATMPin.split("")[i].contentEquals("4")) {
				Log.logger.debug("Click 4");
				ld.fX(ld.siAS_SetATMPin_4).click();
			}
			else if (strATMPin.split("")[i].contentEquals("5")) {
				Log.logger.debug("Click 5");
				ld.fX(ld.siAS_SetATMPin_5).click();
			}
			else if (strATMPin.split("")[i].contentEquals("6")) {
				Log.logger.debug("Click 6");
				ld.fX(ld.siAS_SetATMPin_6).click();
			}
			else if (strATMPin.split("")[i].contentEquals("7")) {
				Log.logger.debug("Click 7");
				ld.fX(ld.siAS_SetATMPin_7).click();
			}
			else if (strATMPin.split("")[i].contentEquals("8")) {
				Log.logger.debug("Click 8");
				ld.fX(ld.siAS_SetATMPin_8).click();
			}
			else if (strATMPin.split("")[i].contentEquals("9")) {
				Log.logger.debug("Click 9");
				ld.fX(ld.siAS_SetATMPin_9).click();
			}
		}
	}

	public static void setConfirmPin(String strATMPin) {
		AccountSummaryPage ld = new AccountSummaryPage(appiumDriver);
		ld.setNative();
		ld.waitVisible(ld.siCF_PIN_0, 100);
		for (int i = 0; i < strATMPin.length(); i++) {
			if (strATMPin.split("")[i].contentEquals("0")) {
				Log.logger.debug("Click 0");
				ld.fX(ld.siCF_PIN_0).click();
			}
			else if (strATMPin.split("")[i].contentEquals("1")) {
				Log.logger.debug("Click 1");
				ld.fX(ld.siCF_PIN_1).click();
			}
			else if (strATMPin.split("")[i].contentEquals("2")) {
				Log.logger.debug("Click 2");
				ld.fX(ld.siCF_PIN_2).click();
			}
			else if (strATMPin.split("")[i].contentEquals("3")) {
				Log.logger.debug("Click 3");
				ld.fX(ld.siCF_PIN_3).click();
			}
			else if (strATMPin.split("")[i].contentEquals("4")) {
				Log.logger.debug("Click 4");
				ld.fX(ld.siCF_PIN_4).click();
			}
			else if (strATMPin.split("")[i].contentEquals("5")) {
				Log.logger.debug("Click 5");
				ld.fX(ld.siCF_PIN_5).click();
			}
			else if (strATMPin.split("")[i].contentEquals("6")) {
				Log.logger.debug("Click 6");
				ld.fX(ld.siCF_PIN_6).click();
			}
			else if (strATMPin.split("")[i].contentEquals("7")) {
				Log.logger.debug("Click 7");
				ld.fX(ld.siCF_PIN_7).click();
			}
			else if (strATMPin.split("")[i].contentEquals("8")) {
				Log.logger.debug("Click 8");
				ld.fX(ld.siCF_PIN_8).click();
			}
			else if (strATMPin.split("")[i].contentEquals("9")) {
				Log.logger.debug("Click 9");
				ld.fX(ld.siCF_PIN_9).click();
			}
		}
	}
	public static void navigateToApplySoGood_ios() {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		log("Click Service > Apply So GooOd");
		ld.waitVisible(ld.siSV_ApplySoGood_link);
		ExtentReport4.printScreenshot("Click Apply So GooOd menu");
		ld.click(ld.siSV_ApplySoGood_link);
		ld.waitVisible(ld.siAG_page1_TextReference_txt);
	}
	public static void navigateToApplySoGood_page1_ios(Map<String, Object> mapData) {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		ld.setText(ld.fX(ld.siAG_page1_TextReference_txt), (String) mapData.get("ui_accountid"));
		ExtentReport4.printScreenshot("Enter Account ID= "+mapData.get("ui_accountid") );
		ld.click(ld.fX("//XCUIElementTypeButton[@name=\'Done\']"));
		sleep();
//		ld.writeLog();
//		Assert.fail();
		ld.click(ld.siAG_page1_Submit_Btn);
		ld.waitVisible(ld.siAG_page1_Next_Btn);
		ld.click(ld.siAG_page1_checkbox1);
		ExtentReport4.printScreenshot("Apply So Goo0d Page1 - Term & Conditions");

//		sleep(10);
//		ld.writeLog();
		log("Click Next button");
//		ld.click(ld.siAG_page1_Next_Btn);
//		ld.tab(ld.fX(ld.siAG_page1_Next_Btn)); //246, 324
//		ld.tabXY(246, 324);
//		sleep(10);
	}
	public static void navigateToApplySoGood_page2_ios(Map<String, String> mapData) {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		ld.waitVisible(ld.siAG_page2_SelectAll);
		ExtentReport4.printScreenshot("Apply So Goo0d Page1 - Select Transaction List");
		//move up select the second checkbox
		ld.touchAndMove(ld.fX(ld.siAG_page2_checkbox1), ld.fX(ld.siAg_page2_Title));
		ExtentReport4.printScreenshot("Select Select checkbox");
		ld.click(ld.siAG_page2_checkboxRandom1);
//		sleep();
		ExtentReport4.printScreenshot("page2");
		log("Click Next button");
		ld.click(ld.siAG_page2_Next);
		ld.waitVisible(ld.siAG_page3_Title2);
	}
	public static void navigateToApplySoGood_page3_ios(Map<String, String> mapData) {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		log("Select Radio 0% 3 Months");
		ld.click(ld.siAG_page3_Cond3);
//		sleep();
		ExtentReport4.printScreenshot("page3");
		ld.click(ld.siAG_page3_Next);
		ld.waitVisible(ld.siAG_page4_Title1);
		ld.assertText(ld.fX(ld.siAG_page4_Title1).getAttribute("label"), "so goood");
		ld.assertText(ld.fX(ld.siAG_page4_Title2).getText(), "Detail of Installment");
		ld.assertText(ld.fX(ld.siAG_page4_Label1).getText(), "Credit Card");
		ld.assertText(ld.fX(ld.siAG_page4_Label2).getText(), "Card Number");
		ld.assertText(ld.fX(ld.siAG_page4_Label3).getText(), "Installment Plan");
		ld.assertText(ld.fX(ld.siAG_page4_Label4).getText(), "First Payment");
		ld.assertText(ld.fX(ld.siAG_page4_Label5).getText(), "Total Interest Amount");
		ld.assertText(ld.fX(ld.siAG_page4_Label6).getText(), "Total Amount");
		ld.assertText(ld.fX(ld.siAG_page4_Label7).getText(), "Selected Transaction");
		sleep();
		log("wait to complete!!!");
	}

	public static void navigateToApplySoGood_page4_Error_ios(Map<String, String> mapData) {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		log("Click Next");
		ExtentReport4.printReportMessage("page4");
		ld.click(ld.siAG_page4_Next);
		ld.waitVisible(ld.siAG_page5_Error_Title);
		ld.assertText(ld.fX(ld.siAG_page5_Error_Title).getText(), "so goood Unsuccessful");
		ld.assertText(ld.fX(ld.siAG_page5_Error_Desc1).getText(), "Please try again");
		ld.assertText(ld.fX(ld.siAG_page5_BackToMain).getText(), "Back to Main Page");
		ExtentReport4.printReportMessage("Error");
		log("Click Back To Main button");
		ld.click(ld.siAG_page5_BackToMain);
		sleep();
	}
	public static void navigateToApplySoGood_page4_Success_ios(Map<String, String> mapData) {
		ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
		log("Click Next");
		ExtentReport4.printScreenshot("page4");
		ld.click(ld.siAG_page4_Next);
//		sleep(20);
//		ld.writeLog();
		ld.waitVisible(ld.siAG_page5_Success_Title);
		ld.assertText(ld.fX(ld.siAG_page5_Success_Title).getText(), "so goood Successful");
		ld.assertText(ld.fX(ld.siAG_page5_Success_CreditCardNo).getText(), "Credit Card no.");
		ld.assertText(ld.fX(ld.siAG_page5_Success_SelectedTransaction).getText(), "Selected Transaction");
		ld.assertText(ld.fX(ld.siAG_page5_Success_TotalInstallmentAmount).getText(), "Total Installment Amount");
		ld.assertText(ld.fX(ld.siAG_page5_Success_InstallMentPlan).getText(), "Installment Plan");
		ld.assertText(ld.fX(ld.siAG_page5_Success_TransactionDate).getText(), "Transaction Date");
		ld.assertText(ld.fX(ld.siAG_page5_Success_TransactionTime).getText(), "Transaction Time");
		ld.assertText(ld.fX(ld.siAG_page5_BackToMain).getText(), "Back to Main Page");
		ExtentReport4.printScreenshot("Success");
		log("Click Back To Main button");
		ld.click(ld.siAG_page5_BackToMain);
		sleep();
	}


	public static void navigateToHomeLoan_ios() {
		HomeLoanPage ld = new HomeLoanPage(appiumDriver);
		ld.touchAndMove(ld.fX(ld.siSV_UsageLimit_Link), ld.fX(ld.siSV_GoToNativePage_Link));
		log("Click Service > HomeLoan");
		ld.click(ld.siSV_Loan_link);
		sleep(10);
		ExtentReport4.printReportMessage("Loan page");
		//verify
		ld.touchAndMove(ld.fX(ld.siHL_Loan_LoanDetails1), ld.fX(ld.siHL_Loan_Title1));
		sleep();
		ExtentReport4.printReportMessage("Loan Details");
		ld.click(ld.siHL_Loan_PaymentHistory1);
		sleep();
		ld.click(ld.siHL_Loan_AmountPaid1);
		sleep();
		ExtentReport4.printReportMessage("Payment History");
		ld.writeLog();
	}
	public static void navigateToLoan(){
		AccountSummaryPage ld = new AccountSummaryPage(appiumDriver);
		log("Click Account Summary > Card");

		ld.click(ld.siAS_Loan_btn);
		ld.waitVisible(ld.siAS_Loan_btn, 50);
		sleep(20);
		ExtentReport4.printReportMessage("Loan tab");
//		log("Click Black Diamond card");
//		new Actions(appiumDriver).clickAndHold(ld.fX("(//XCUIElementTypeCell//XCUIElementTypeStaticText[@name=\'Black Diamond\'])[1]")).perform();
//		ld.waitVisible(ld.siAS_AmountSpent1, 50);
//		ExtentReport4.printReportMessage("Credit Landing page");
	}

	//Flexi Loan
	public static void navToFlexiLoan0(String crmid) {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.setWebview();
		fl.waitVisible(fl.swFL0_crmid_txt);
//		001100000000000000000018593707
//		001100000000000000000018593708
//		001100000000000000000018593709
		fl.setText(fl.fX(fl.swFL0_crmid_txt), crmid);
		sleep();
		ExtentReport4.printScreenshot("Enter "+crmid);
		fl.clickJS(fl.fX(fl.swFL0_next));
		fl.waitInVisible(fl.swFL0_next);
	}
	public static void navToFlexiLoan1(String cardName){
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL1_title, 100);
		ExtentReport4.printScreenshot("Select Flexi Product = "+cardName + ":");
		List<WebElement> creditCardNames = fl.fsXpath(fl.swFL1_list_creditCard);
		List<WebElement> maximumOffers = fl.fsXpath(fl.swFL1_list_maximumOffer);
		WebElement cardElement = null;
		if (cardName.contains("แคชทูโก")){
			cardElement = findCreditCardName(cardName, creditCardNames);
		}
		else if (cardName.contains("แฟลซ")){
			cardElement = findCreditCardName(cardName, creditCardNames);
		}
		else if (cardName.contains("ซิกเนเจอร์")){
			cardElement = findCreditCardName(cardName, creditCardNames);
		}
		else if (cardName.contains("ชิลล์")){
			cardElement = findCreditCardName(cardName, creditCardNames);
		}
		else if (cardName.contains("อินฟินิท")){
			cardElement = findCreditCardName(cardName, creditCardNames);
		}
		else {
			log(cardName + " is not found!!!");
		}
		fl.clickJS(cardElement);
		fl.waitInVisible(cardName, 50);
	}
	public static WebElement findCreditCardName(String cardName, List<WebElement> creditCardNames){
		for (int i = 0; i< creditCardNames.size(); i++){
//			log(i+" "+creditCardNames.get(i).getText().replaceAll(" ", "")+" "+ cardName.replaceAll(" ", ""));
			if (creditCardNames.get(i).getText().contains(cardName)){
//				log(i+" "+creditCardNames.get(i).getText()+" "+ cardName);
				return creditCardNames.get(i);
			}
		}
		log(cardName + " is not found !!!!");
		return null;
	}
	public static void navToFlexiLoan2(){
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL2_applyTMBCreditCard);
		ExtentReport4.printScreenshot("Apply Flexi Laon "+fl.fX(fl.swFL2_title).getText());
		fl.clickJS(fl.fX(fl.swFL2_applyTMBCreditCard));
		fl.waitInVisible(fl.swFL2_applyTMBCreditCard);
		//ver
		fl.assertText(fl.fX(fl.swFL2_SelectLimit_txt).getAttribute("value"), "2,500,000");
		fl.setText(fl.fX(fl.swFL2_SelectLimit_txt), "2100000");
		sleep(1);
		fl.clickJS(fl.fX(fl.getSwFL2_SelectLimit_lb));
		sleep(1);
		fl.assertText(fl.fX(fl.swFL2_SelectLimit_txt).getAttribute("value"), "2,100,000");
		fl.setText(fl.fX(fl.swFL2_SelectLimit_txt), "2500000");
		sleep(1);
		fl.clickJS(fl.fX(fl.getSwFL2_SelectLimit_lb));
		sleep(1);

		//Select InstallmentMonth
		fl.selectIndex(fl.swFL2_installmentMonth,1);
		sleep(1);
		fl.selectIndex(fl.swFL2_installmentMonth,49);
		sleep(1);
		ExtentReport4.printScreenshot("Select Limit and Installment Top :");

		fl.assertText(fl.fX(fl.swFL2_Limit).getText(), "2,500,000.00");
		fl.assertText(fl.fX(fl.swFL2_InstallmentPayment).getText(), "77,900.00");
		fl.assertText(fl.fX(fl.swFL2_Months).getText(), "60 เดือน");
		fl.assertText(fl.fX(fl.swFL2_Interest).getText(), "28%");


		fl.scrollIntoView(fl.fX(fl.swFL2_next));
		ExtentReport4.printScreenshot("Selet Limit and Installment bottom:");
		fl.clickJS(fl.fX(fl.swFL2_next));
		fl.waitInVisible(fl.swFL2_next);
	}

	public static void navToFlexiLoan3(String paymentMethod, String accountReceiveNumber, String debitType){
		//paymentMethod = {"direct debit", "other channel"}
		//accountReceiveNumber = {"111-2-46922-4"}
		//debitType = {"Full", "Minium 5%"}
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL3_list_AccountNameReceive_chb);
		fl.clickJS(fl.fX(fl.swFL3_list_AccountNameReceive_chb));
		ExtentReport4.printScreenshot("Apply Flexi Loan 1:");
		fl.clickJS(fl.fX(fl.swFL3_otherChannel_btn)); //tab other channel
		sleep(1);
		fl.clickJS(fl.fX(fl.swFL3_directdebt_btn)); //tab direct debit
		sleep(1);
		fl.clickJS(fl.fX(fl.swFL3_list_AccountNamePayment_chb));
		fl.clickJS(fl.fX(fl.swFL3_otherChannek_lb));
		Select ddlDateExpired = new Select(fl.fX(fl.swFL3_dueDate_ddl));
		ddlDateExpired.selectByIndex(1);
		sleep(1);
		ddlDateExpired.selectByIndex(2);
		sleep(1);
		ExtentReport4.printScreenshot("Apply TTB Cash2Go");
		fl.scrollIntoView(fl.fX(fl.swFL3_next));
		//question1 - answert1
		fl.clickJS(fl.fX(fl.swFL3_botAnswer1_1));
		sleep(1);
		//question1 - answert2
		fl.clickJS(fl.fX(fl.swFL3_botAnswer1_2));
		sleep(1);
		//question1 - answert3
		fl.clickJS(fl.fX(fl.swFL3_botAnswer1_3));
		sleep(1);
		//question2 - answert1
		fl.clickJS(fl.fX(fl.swFL3_botAnswer2_1));
		sleep(1);
		//question2 - answert2
		fl.clickJS(fl.fX(fl.swFL3_botAnswer2_2));
		sleep(1);
		//question2 - answert3
		fl.clickJS(fl.fX(fl.swFL3_botAnswer2_3));
		sleep(1);
		ExtentReport4.printScreenshot("Apply Flexi Loan 2:");
		fl.clickJS(fl.fX(fl.swFL3_next));
	}

	public static void navToFlexiLoan3_FlashCard(String paymentMethod, String accountReceiveNumber, String debitType){
		//paymentMethod = {"direct debit", "other channel"}
		//accountReceiveNumber = {"111-2-46922-4"}
		//debitType = {"Full", "Minium 5%"}
		log("paymentMethod="+paymentMethod+" accountReceiveNumber="
				+accountReceiveNumber+" debitType="+debitType);
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.getSwFL2_applyTMBFlashCard);
		ExtentReport4.printReportMessage("TTB Flash Card");
		fl.clickJS(fl.getSwFL2_applyTMBFlashCard);//Click Apply TTB Flash Card
		fl.clickJS(fl.swFL3_flash_otherChannel_btn);//Click Tab Other channel
		fl.clickJS(fl.swFL3_flash_directdebt_btn); //Click Tab Direct Debit
		fl.clickJS(fl.swFL3_flash_list_AccountNamePayment_chb); // click account All Free 111-2-46922-4
		fl.clickJS(fl.swFL3_flash_debitFull_chb);//click debit full
		fl.clickJS(fl.swFL3_flash_debit3Percent_chb);//click debit 3%
		fl.scrollIntoView(fl.swFL3_flash_next); //scroll to next button
		fl.clickJS(fl.swFL3_flash_botAnswer1_1);//question1 - answert1
		fl.clickJS(fl.swFL3_flash_botAnswer1_2);//question1 - answert2
		fl.clickJS(fl.swFL3_flash_botAnswer1_3);//question1 - answert3
		fl.clickJS(fl.swFL3_flash_botAnswer2_1);//question2 - answert1
		fl.clickJS(fl.swFL3_flash_botAnswer2_2);//question2 - answert2
		fl.clickJS(fl.swFL3_flash_botAnswer2_3);//question2 - answert3
		ExtentReport4.printScreenshot("Apply Flexi Loan 2:");
		fl.clickJS(fl.swFL3_flash_next);
	}
	public static void navToFlexiLoan4() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL4_fullName_txt, 190);
		fl.assertText(fl.fX(fl.swFL4_stageName).getText(), "ตรวจสอบข้อมูลส่วนตัว");
		fl.assertText(fl.fX(fl.swFL4_personalInformation_lb).getText(), "ข้อมูลส่วนตัว");
		fl.assertText(fl.fX(fl.swFL4_remark1).getText(), "หากต้องการแก้ไข สามารถแก้ไขได้ที่\n" +
				"\"เมนูการตั้งค่า > ข้อมูลของฉัน\" หรือ \"ติดต่อสาขา\"");
		fl.assertText(fl.fX(fl.swFL4_fullName_txt).getText(), "วันแอพหก ทีทีบี");
		fl.assertText(fl.fX(fl.swFL4_birthDate_txt).getText(), "11 ก.พ. 2523");
		fl.assertText(fl.fX(fl.swFL4_citizenId_txt).getText(), "4-1807-04999-01-5");
		fl.assertText(fl.fX(fl.swFL4_expiryDate_txt).getText(), "31 ธ.ค. 3542");
		fl.assertText(fl.fX(fl.swFL4_nationality_txt).getText(), "ไทย");
		ExtentReport4.printScreenshot("Personal Information Top:");
		fl.scrollIntoView(fl.fX(fl.swFL4_contactAddress));
		fl.assertText(fl.fX(fl.swFL4_mobileNumber).getText(), "094-886-9559");
		fl.assertText(fl.fX(fl.swFL4_addressInformation).getText(), "ข้อมูลส่วนตัว");
		fl.assertText(fl.fX(fl.swFL4_contactAddress).getText(), "11/222 4 จุฬา ปรีชา 5 งามวงศ์วาน นนทบุรี เมืองนนทบุรี บางเขน 11000");
		ExtentReport4.printScreenshot("Personal Information Bottom:");
	}
	public static void navToFlexiLoan4_flashCard() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL4_fullName_txt, 190);

		ExtentReport4.printScreenshot("Personal Information Top:");
		fl.scrollIntoView(fl.swFL4_next);
		ExtentReport4.printScreenshot("Personal Information Bottom:");
	}
	public static void navToFlexiLoan4EditAddress(){
		log("navToFlexiLoan4EditAddress");
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.clickJS(fl.swFL4_edit_btn);
		fl.waitVisible(fl.swFL5_houseNo_txt);
		ExtentReport4.printScreenshot("Edit Address Top:");
		List<String> testData = Arrays.asList("");
		List<String> testResult = Arrays.asList("");
		String house1 = fl.fX(fl.swFL5_houseNo_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", house1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter House = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_houseNo_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}

		String room1 = fl.fX(fl.swFL5_roomNo_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", room1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Room = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_roomNo_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String floor1 = fl.fX(fl.swFL5_floorNo_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", floor1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Floor = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_floorNo_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String moo1 = fl.fX(fl.swFL5_moo_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", moo1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Moo = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_moo_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String soi1 = fl.fX(fl.swFL5_soi_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", soi1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Soi = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_soi_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String village1 = fl.fX(fl.swFL5_villageBuilding_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", village1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Building = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_villageBuilding_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String street1 = fl.fX(fl.swFL5_street_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", street1);
		testResult = Arrays.asList("false", "false", "false", "false", "false", "false", "false", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter Street = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_street_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		String zipCode1 = fl.fX(fl.swFL5_zipCode_txt).getAttribute("value");
		testData = Arrays.asList("ABC", "abc", "กขค", "123", "/-", "", " ", zipCode1);
		testResult = Arrays.asList("false", "false", "false", "true", "true", "true", "true", "false");
		for (int i=0; i < testData.size();i++){
			log("Enter ZipCode = "+testData.get(i));
			fl.setText(fl.fX(fl.swFL5_zipCode_txt), testData.get(i));
			fl.assertText(String.valueOf(fl.isElementPresent(fl.swFL5_saveEnabled)), testResult.get(i));
		}
		fl.scrollIntoView(fl.swFL5_save);
		fl.assertText(fl.fX(fl.swFL5_provice_lb).getAttribute("value"), "นนทบุรี");
		fl.assertText(fl.fX(fl.swFL5_district_lb).getAttribute("value"), "เมืองนนทบุรี");
		fl.assertText(fl.fX(fl.swFL5_subDistrict_lb).getAttribute("value"), "บางเขน");
		ExtentReport4.printScreenshot("Edit Address Bottom:");
		fl.clickJS(fl.swFL5_save);
	}
	public static void navToFlexiLoan41() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL4_addressInformation);
		fl.scrollIntoView(fl.swFL4_next);
		ExtentReport4.printScreenshot("Personal Information after Edit Address Bottom :");
		fl.clickJS(fl.swFL4_next);
	}
	public static void navToFlexiLoan41_flashCard() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL4_addressInformation);
		fl.scrollIntoView(fl.swFL4_next);
		ExtentReport4.printScreenshot("Personal Information after Edit Address Bottom :");
		fl.clickJS(fl.swFL4_next);
	}
	public static void navToFlexiLoan6(){
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL6_workStatus_ddl, 100);
		ExtentReport4.printScreenshot("Working Information Top:");
		List<Integer> workStatus = Arrays.asList(1, 2); //2 test data. automation will select 1st and 2nd value!
		for (int i=0; i< workStatus.size();i++){
			fl.selectIndex(fl.fX(fl.swFL6_workStatus_ddl), workStatus.get(i));
			sleep(1);
		}

		List<Integer> occupations = Arrays.asList( 0,1);
		for (int i=0; i< occupations.size();i++){
			log("Enter Occupation="+occupations.get(i));
			fl.selectIndex(fl.fX(fl.swFL6_occpation_ddl), occupations.get(i));
			sleep(1);
		}

		List<Integer> bussinessTypes = Arrays.asList(1,2);
		for (int i=0; i< bussinessTypes.size();i++){
			log("Enter Business Types ="+bussinessTypes.get(i));
			fl.selectIndex(fl.fX(fl.swFL6_bussinessType_ddl), bussinessTypes.get(i));
			sleep(1);
		}

		List<Integer> businessSubTypes = Arrays.asList(1);
		for (int i=0; i< businessSubTypes.size();i++){
			fl.selectIndex(fl.fX(fl.swFL6_businessSubType_ddl), businessSubTypes.get(i));
			sleep(1);
		}

//		String workingPlace = "OHO BuRGER";
		fl.assertText(fl.fX(fl.swFL6_officeName_txt).getAttribute("value"), "OHO BURGER");
		fl.scrollIntoView(fl.fX(fl.swFL6_next));
//		String officePhone = "026267222";
		fl.setTextJS(fl.fX(fl.swFL6_officePhone_txt), "026267222");
		fl.assertText(fl.fX(fl.swFL6_officePhone_txt).getAttribute("value"), "026267222");
//		String officePhoneExt = "123";
		fl.setTextJS(fl.fX(fl.swFL6_officePhoneExt_txt), "123");
		fl.assertText(fl.fX(fl.swFL6_officePhoneExt_txt).getAttribute("value"), "123");
		List<Integer> incomePerMonths = Arrays.asList( 1, 2);
		for (int i=0; i< incomePerMonths.size();i++){
			fl.selectIndex(fl.fX(fl.swFL6_incomePerMonth_ddl), incomePerMonths.get(i));
			sleep(1);
		}
		List<Integer> sourceOfIncomes = Arrays.asList(1);
		for (int i=0; i< sourceOfIncomes.size();i++){
			fl.selectIndex(fl.fX(fl.swFL6_sourceOfIncome_ddl), sourceOfIncomes.get(i));
			sleep(1);
		}
		List<Integer> countryOfIncomes = Arrays.asList(1, 2);
		for (int i=0; i< countryOfIncomes.size();i++){
			fl.selectIndex(fl.fX(fl.swFL6_countryOfIncome_ddl), countryOfIncomes.get(i));
			sleep(1);
		}
		fl.assertText(fl.fX(fl.swFL6_statementReceivingInformation_lb).getText(), "ข้อมูลบัญชีรายได้");
		fl.clickJS(fl.swFL6_contactAddress_rdb);
		fl.assertText(fl.fX(fl.swFL6_contactAddress_lb).getText(), "ที่อยู่ที่ติดต่อได้");
		sleep(1);
		fl.clickJS(fl.swFL6_officeAddress_rdb);
		fl.assertText(fl.fX(fl.swFL6_officeAddress_lb).getText(), "ที่อยู่ที่ทำงาน");
		sleep(1);
		fl.clickJS(fl.swFL6_applyEStatement_chb);
		sleep(1);
		fl.clickJS(fl.swFL6_applyEStatement_chb);
		fl.assertText(fl.fX(fl.swFL6_applyEStatement_lb).getText(), "รับใบแจ้งยอดทางอีเมล");
		sleep(1);
		ExtentReport4.printScreenshot("Working Information Bottom:");
		fl.clickJS(fl.swFL6_next);
		fl.waitVisible(fl.swFL6_confirmDesc1);
		sleep(1);
		ExtentReport4.printScreenshot("Terms & Conditions");
		fl.clickJS(fl.swFL6_confirmNext);
	}
	public static void navToFlexiLoan6_flashCard(){
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL6_workStatus_ddl, 100);
		ExtentReport4.printScreenshot("Working Information Top:");

		fl.scrollIntoView(fl.fX(fl.swFL6_next));
//		String officePhone = "026267222";
		fl.setText(fl.fX(fl.swFL6_officePhone_txt), "026267222");
//		fl.assertText(fl.fX(fl.swFL6_officePhone_txt).getAttribute("value"), "026267222");
//		String officePhoneExt = "123";
		fl.setText(fl.fX(fl.swFL6_officePhoneExt_txt), "123");
//		fl.assertText(fl.fX(fl.swFL6_officePhoneExt_txt).getAttribute("value"), "123");

		fl.clickJS(fl.swFL6_contactAddress_rdb);
//		fl.assertText(fl.fX(fl.swFL6_contactAddress_lb).getText(), "ที่อยู่ที่ติดต่อได้");
		sleep(1);
		fl.clickJS(fl.swFL6_officeAddress_rdb);
//		fl.assertText(fl.fX(fl.swFL6_officeAddress_lb).getText(), "ที่อยู่ที่ทำงาน");
		sleep(1);
		fl.clickJS(fl.swFL6_applyEStatement_chb);
		sleep(1);
		fl.clickJS(fl.swFL6_applyEStatement_chb);
//		fl.assertText(fl.fX(fl.swFL6_applyEStatement_lb).getText(), "รับใบแจ้งยอดทางอีเมล");
		sleep(1);
		ExtentReport4.printScreenshot("Working Information Bottom:");
		fl.clickJS(fl.swFL6_next);
//		fl.waitVisible(fl.swFL6_confirmDesc1, 100);
//		sleep(1);
//		ExtentReport4.printScreenshot("Terms & Conditions");
//		fl.clickJS(fl.swFL6_confirmNext);
	}
	public static void navToFlexiLoan7() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL7_condition1, 100);
		fl.assertText(fl.fX(fl.swFL7_condition1).getText(), "ข้าพเจ้าได้อ่านเงื่อนไขสินเชื่อบุคคลแล้ว");
		fl.clickJS(fl.swFL7_condition1);
		fl.assertText(fl.fX(fl.swFL7_condition2).getText(), "ข้าพเจ้ายอมรับเงื่อนไขการสมัครและทำธุรกรรมผ่านระบบอินเทอร์เน็ต");
		fl.clickJS(fl.swFL7_condition2);
		fl.assertText(fl.fX(fl.swFL7_condition3).getText(), "ข้าพเจ้ายินยอมให้ข้อมูลแก่ธนาคารเพื่อจัดทำแบบจำลองด้านเครดิต");
		fl.clickJS(fl.swFL7_condition3);
		ExtentReport4.printScreenshot("Term&Conditions:");
		fl.clickJS(fl.fX(fl.swFL7_next));
	}

	public static void navToFlexiLoan7_flashCard() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL7_condition1, 100);
		fl.assertText(fl.fX(fl.swFL7_condition1).getText(), "ข้าพเจ้าได้อ่านเงื่อนไขบัตรกดเงินสดแล้ว");
		fl.clickJS(fl.swFL7_condition1);
		fl.assertText(fl.fX(fl.swFL7_condition2).getText(), "ข้าพเจ้ายอมรับเงื่อนไขการสมัครและทำธุรกรรมผ่านระบบอินเทอร์เน็ต");
		fl.clickJS(fl.swFL7_condition2);
		fl.assertText(fl.fX(fl.swFL7_condition3).getText(), "ข้าพเจ้ายินยอมให้ข้อมูลแก่ธนาคารเพื่อจัดทำแบบจำลองด้านเครดิต");
		fl.clickJS(fl.swFL7_condition3);
		ExtentReport4.printScreenshot("Term&Conditions:");
		sleep();
		fl.clickJS(fl.fX(fl.swFL7_next));
	}
	public static void navToFlexiLoan8() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL8_name_lb, 100);
		sleep();
		ExtentReport4.printScreenshot("Letter Of Consent Top:");
		fl.scrollIntoView(fl.fX(fl.swFL8_Accepted_btn));
//		sleep();
//		ExtentReport4.printScreenshot("Letter Of Consent Bottom:");
//		fl.clickJS(fl.fX(fl.swFL8_notAccepted_btn));
//		sleep();
//		fl.waitVisible(fl.swFL8_notAccepted_desc1);
//		ExtentReport4.printScreenshot("Letter of consent> Not Accepted");
//		fl.clickJS(fl.fX(fl.swFL8_notAccepted_cancel));
//		sleep();
		fl.clickJS(fl.swFL8_Accepted_btn);
		sleep();
		ExtentReport4.printScreenshot("Letter of consent>Accepted");

		setConfirmPin("010203");
		sleep(1);
		ExtentReport4.printScreenshot("Enter Confirm Pin=010203");
	}
	public static void navToFlexiLoan9() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.setWebview();
		fl.waitVisible(fl.swFL9_name, 100);
		sleep(1);
		ExtentReport4.printScreenshot("Confirm page:");

		fl.assertText(fl.fX(fl.swFL9_name).getText(), "วันแอพหก ทีทีบี");
		fl.assertText(fl.fX(fl.swFL9_idCard).getText(), "4-1807-04999-01-5");
		fl.assertText(fl.fX(fl.swFL9_birthDate).getText(), "20 ธันวาคม 2530");
		fl.assertText(fl.fX(fl.swFL9_mobilePhone).getText(), "094-886-9559");
		fl.assertText(fl.fX(fl.swFL9_loanType).getText(), "สินเชื่อบุคคล (05)");
//		fl.assertText(fl.fX(fl.swFL9_refNo).getText(), "MIB026PL64000455");
//		fl.assertText(fl.fX(fl.swFL9_dateConsent).getText(), "4 มิถุนายน 2564 11:52:41");
		fl.assertText(fl.fX(fl.swFL9_channel).getText(), "ttb touch");
		fl.assertText(fl.fX(fl.swFL9_desc1).getText(), "Access Pin");
		fl.assertText(fl.fX(fl.swFL9_desc2).getText(), "เงื่อนไขในการให้ความยินยอมเปิดเผยข้อมูลผ่านระบบอินเทอร์เน็ต");
		fl.scrollIntoView(fl.fX(fl.swFL9_next));
		fl.clickJS(fl.fX(fl.swFL9_next));
	}

	public static void navToFlexiLoan10_LoanDay1() {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		fl.waitVisible(fl.swFL10_title1_lb, 100);
		fl.assertText(fl.fX(fl.swFL10_viewStatement_lb).getText(), "เปลี่ยนวงเงินในบัตรเป็นเงินสด");
		fl.assertText(fl.fX(fl.swFL10_title1_lb).getText(), "บริการรับเงินก้อนทันใจ ได้ตั้งแต่วันที่บัตรอนุมัติฯ");
		fl.assertText(fl.fX(fl.swFL10_title2_lb).getText(), "ต้องการรับเงินสดทันที ณ วันที่บัตรอนุมัติหรือไม่");
		fl.assertText(fl.fX(fl.swFL10_want_chb).getText(), "ต้องการ");
		fl.assertText(fl.fX(fl.swFL10_noWant_chb).getText(), "ยังไม่ต้องการตอนนี้");
		ExtentReport4.printReportMessage("Apply Flash Card 1:");
		fl.clickJS(fl.swFL10_want_chb);

		fl.waitVisible(fl.swFL10_want_creditRecieveTransfer, 100);
		//เต็มวงเงิน + ชำระขั้นต่ำหรือเต็มจำนวน
		fl.scrollIntoView(fl.swFL10_want_payAmountFull);
		fl.clickJS(fl.swFL10_want_payAmountFull);
		sleep();
		fl.waitVisible(fl.swFL10_want_fee);
		fl.scrollIntoView(fl.swFL10_want_interestYear);
		fl.assertText(fl.fX(fl.swFL10_want_fee).getText(), "50,000 บาท");
		fl.assertText(fl.fX(fl.swFL10_want_vat).getText(), "3,500.00 บาท");
		fl.assertText(fl.fX(fl.swFL10_want_interestYear).getText(), "16.00%");
		fl.scrollIntoView(fl.swFL10_want_accountReceived);
		fl.assertText(fl.fX(fl.swFL10_want_loanLimit).getText(), "700,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_totalAmountWant).getText(), "500,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_paymentPlan).getText(), "ชำระขั้นต่ำหรือเต็มจำนวน");
		fl.assertText(fl.fX(fl.swFL10_want_installmentTime).getText(), "-");
		fl.assertText(fl.fX(fl.swFL10_want_accountReceived).getText(), "ทีทีบี 111-2-46922-4");

		//เต็มวงเงิน + แบ่งชำระรายเดือน 24 เดือน
		fl.scrollIntoView(fl.swFL10_want_payAmountFull);
		fl.clickJS(fl.swFL10_want_payAmountMonthly);
		fl.selectValue(fl.fX(fl.swFL10_want_payAmountMonthly), "24 เดือน");
		fl.assertText(new Select(fl.fX(fl.swFL10_want_payAmountMonthly)).getFirstSelectedOption().getText(), "24 เดือน");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth1).getText(), "1.73%");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth2).getText(), "12.00%");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth3).getText(), "23.00%");
		fl.scrollIntoView(fl.swFL10_want_accountReceived);
		fl.assertText(fl.fX(fl.swFL10_want_loanLimit).getText(), "700,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_totalAmountWant).getText(), "500,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_paymentPlan).getText(), "แบ่งขำระรายเดือน");
		fl.assertText(fl.fX(fl.swFL10_want_installmentTime).getText(), "24 เดือน");
		fl.assertText(fl.fX(fl.swFL10_want_accountReceived).getText(), "ทีทีบี 111-2-46922-4");

		//ระบุรงเงิน + ชำระขั้นต่ำหรือเต็มจำนวน
		fl.scrollIntoView(fl.swFL10_want_creditLimit);
		fl.clickJS(fl.swFL10_want_creditLimit);
//		fl.waitVisible()
//		sleep(20);
		fl.waitVisible(fl.swFL10_want_creditLimit_text);
		fl.clickJS(fl.swFL10_want_payAmountFull);
		sleep(10);
		fl.assertText(fl.fX(fl.swFL10_want_creditLimit_errorMessage).getText(), "จำนวนเงินขั้นต่ำต้องไม่น้อยกว่า");
		fl.setTextJS(fl.fX(fl.swFL10_want_creditLimit_text), "10000");
		fl.clickJS(fl.swFL10_want_payAmountFull);
		sleep(10);
		fl.scrollIntoView(fl.swFL10_want_interestYear);
		fl.assertText(fl.fX(fl.swFL10_want_fee).getText(), "1,000,000 บาท");
		fl.assertText(fl.fX(fl.swFL10_want_vat).getText(), "70.00 บาท");
		fl.assertText(fl.fX(fl.swFL10_want_interestYear).getText(), "16.00%");
		fl.scrollIntoView(fl.swFL10_want_accountReceived);
		fl.assertText(fl.fX(fl.swFL10_want_loanLimit).getText(), "700,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_totalAmountWant).getText(), "10,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_paymentPlan).getText(), "ชำระขั้นต่ำหรือเต็มจำนวน");
		fl.assertText(fl.fX(fl.swFL10_want_installmentTime).getText(), "-");
		fl.assertText(fl.fX(fl.swFL10_want_accountReceived).getText(), "ทีทีบี 111-2-46922-4");

		//ระบุรงเงิน + แบ่งขำระรายเดือน
		fl.scrollIntoView(fl.swFL10_want_creditLimit);
		fl.clickJS(fl.swFL10_want_creditLimit);
		sleep(20);
		fl.clickJS(fl.swFL10_want_payAmountMonthly);
		fl.assertText(new Select(fl.fX(fl.swFL10_want_payAmountMonthly)).getFirstSelectedOption().getText(), "24 เดือน");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth1).getText(), "1.73%");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth2).getText(), "12.00%");
		fl.assertText(fl.fX(fl.swFL10_want_interestMonth3).getText(), "23.00%");
		fl.scrollIntoView(fl.swFL10_want_accountReceived);
		fl.assertText(fl.fX(fl.swFL10_want_loanLimit).getText(), "700,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_totalAmountWant).getText(), "10,000.00");
		fl.assertText(fl.fX(fl.swFL10_want_paymentPlan).getText(), "แบ่งขำระรายเดือน");
		fl.assertText(fl.fX(fl.swFL10_want_installmentTime).getText(), "24 เดือน");
		fl.assertText(fl.fX(fl.swFL10_want_accountReceived).getText(), "ทีทีบี 111-2-46922-4");

		//click  ถัดไป
		fl.clickJS(fl.fX(fl.swFL10_want_Next));
		fl.waitVisible(fl.swFL11_applyFlashCard);
		fl.assertText(fl.fX(fl.swFL11_applyFlashCard).getText(), "");
		fl.assertText(fl.fX(fl.swFL11_desc).getText(), "");
	}

	public static void navToFlexiLoan10_underconstruction(String cond) {
		FlexiLoanPage fl = new FlexiLoanPage(appiumDriver);
		if (cond.equalsIgnoreCase("want")){
			fl.waitVisible(fl.swFL10_want_chb, 100);

			fl.clickJS(fl.swFL10_want_chb);
			ExtentReport4.printReportMessage("Apply Flash Card - Want");
			fl.waitVisible(fl.swFL10_understruction_title);
			fl.assertText(fl.fX(fl.swFL10_understruction_title).getText(), "");
			fl.assertText(fl.fX(fl.swFL10_understruction_desc).getText(), "");
			ExtentReport4.printReportMessage("Service UnderConstructions");
			fl.clickJS(fl.swFL10_understruction_ok);
		}
		else {
			fl.waitVisible(fl.swFL10_noWant_chb);
			fl.clickJS(fl.swFL10_noWant_chb);
			sleep(20);
			fl.clickJS(fl.swFL10_next);
			ExtentReport4.printReportMessage("Apply Flash Card - Dont Want");
			fl.waitVisible(fl.swFL11_applyFlashCard);
			fl.assertText(fl.fX(fl.swFL11_applyFlashCard).getText(), "");
			fl.assertText(fl.fX(fl.swFL11_desc).getText(), "");
			ExtentReport4.printReportMessage("Wait 1-2 minutes");
		}
	}


	/**
	 * API Get Token
	 * @param filePath
	 * @return
	 */
	public static String getToken(String filePath) {
		JsonPath dataP = new JsonPath(com.tmb.automation.helper.Helper.getInput(filePath));
		Response response_getToken = given().relaxedHTTPSValidation().auth().preemptive()
				.basic(dataP.get("token.key"), dataP.get("token.Authorization"))
				.headers(dataP.getMap("token.headers"))
				.formParams(dataP.getMap("token.body"))
				.when()
				.post(dataP.getString("token.hostname") + dataP.getString("token.path"))
				.then().assertThat().statusCode(200).extract().response();
		return response_getToken.jsonPath().getString("data.access_token");
	}

	public static Map<String, Object> convertJsonToMap(String jsonPath){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=null;
		try {
			map = mapper.readValue(new File(
							System.getProperty("user.dir")+"/src/main/resources/"+jsonPath)
					, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String, Object> convertJsonToMap2(String jsonPath){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=null;
		try {
			map = mapper.readValue(new File(jsonPath)
					, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, Object> JsonToMap(String jsonString){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=null;
		try {
			map = new ObjectMapper().readValue(jsonString.replaceAll("\\\\","")
					, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, Object> JsonToMap(JSONObject jsonObject){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=null;
		try {
			map = new ObjectMapper().readValue(jsonObject.toString().replaceAll("\\\\","")
					, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void convertMapToJson(Map<String, Object> map, String jsonPath){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("result.json"), map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Map<String, String> convertStringToHashMap(String value){
		value = value.substring(1, value.length()-1);           //remove curly brackets
		String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
		Map<String,String> map = new HashMap<>();
		for(String pair : keyValuePairs) {
			String[] entry = pair.split("=");                   //split the pairs to get key and value
			try {
				map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
			} catch (ArrayIndexOutOfBoundsException e){
				map.put(entry[0].trim(), "");
			}

		}
		return map;
	}

	public static org.json.simple.JSONObject getJsonObect(String jsonPath) {
		org.json.simple.JSONObject jsonObject = null;
		try {
			jsonObject = (org.json.simple.JSONObject) (new JSONParser()).parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/"+jsonPath));
		} catch (IOException | ParseException e) {}
		return jsonObject;
	}

	public static void setAndroid() {
		Helper.CONFIG_PROFILE = Helper.getProperties("deviceProfile_Android");
	}
	public static void setiOS() {
		Helper.CONFIG_PROFILE = Helper.getProperties("deviceProfile_iOS");
	}

	public static JSONObject readJson(String filePath){
		JSONObject dataJson = new JSONObject();
		try {
			dataJson = (JSONObject) new JSONParser().parse(new FileReader(filePath));
		}catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return  dataJson;
	}

	public static String toStr(String jsonString){
		return jsonString.replaceAll("\\\\","");
	}
}
