//
//  CommonSprint18
//  OneApp
//
//  Created by Aniwat Ruttanaudom on 17/5/2021 BE.
//  Copyright © 2021 BE TMB. All rights reserved.
//
package com.tmb.automation.test.lending.sprint17;

import java.util.Map;

import com.tmb.automation.helper.Log;
import com.tmb.automation.pages.lending.*;
import com.tmb.automation.util.Base;

import static org.testng.Assert.fail;

public class UI_Lending_Common extends Base {


	public static void navigateToHomeScreen(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setNative();
		log("Click Discovery menu");
		ld.waitVisible(ld.saHS_Discovery_btn);
		sleep();
		ld.click(ld.saHS_Discovery_btn);
		
		ld.setNative();
		log("Enter Pin="+mapData.get("Pin"));
		ld.EnterPin(mapData.get("Pin"));
	}
	
	public static void navigateToHomeScreen_ios(Map<String, String> mapData) {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setNative();
		log("Click Discovery menu");
		ld.waitVisible(ld.siHS_Discovery_btn);
		sleep();
		ld.click(ld.siHS_Discovery_btn);
		
		ld.setNative();
		log("Enter Pin="+mapData.get("Pin"));
		ld.EnterPin(mapData.get("Pin"));
	}
	
	public static void navigateToActivateCard() {
		ActivateCardPage ld = new ActivateCardPage(appiumDriver);
		ld.setContext("WEBVIEW_com.ttbbank.oneapp.vit");
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
		sleep(10);
		ld.writeLog();
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
	
	
	public static void navigateToAdjustUsageLimit(Map<String, String> mapData) {
		ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
		ld.waitVisible(ld.swImg_change2_CardImage);
		ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
		ld.setText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), "55000");
	}
	
	//===== Block Card
	public static void navigateToBlockCard() {
		BlockCardPage ld = new BlockCardPage(appiumDriver);
		ld.setContext("WEBVIEW_com.ttbbank.oneapp.vit");
		sleep();
		ld.waitVisible(ld.swDC_BlockCard_btn);
		log("Click Discover > Block Card");
		ld.click(ld.swDC_BlockCard_btn);
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
	}
	
	public static void navigateToBlockCard_ios() {
		BlockCardPage ld = new BlockCardPage(appiumDriver);
		ld.setWebview();
		ld.waitVisible(ld.swDC_BlockCard_btn);
		log("Click Discover > Block Card");
		ld.click(ld.swDC_BlockCard_btn);
		ld.waitVisible(ld.swLbLD_EnterReferenceNumber);
	}
	

}
