package com.tmb.automation.test.platform1.sprint8.s936;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.pages.platform1.Otp_TutanotaPage;
import com.tmb.automation.pages.platform1.VerifyEmailpage;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp_MB_POC_Verify Email EN_SIT_00001	"Validate screen when click ""Back"" button
"
TC_OneApp_MB_POC_Verify Email EN_SIT_00003	"Check screen customer can see
'- Header is "" Verify Email ""
'- Content details
- Logo
- Verify button
"
 */



public class TC_IP_EN_code_backup extends Base {
	
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void setUp() throws IOException {
		Base.appiumCapabilities();
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "935"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		AppiumLibrary appLib = new AppiumLibrary(appiumDriver);
		HomeScreenpage home = new HomeScreenpage(appiumDriver);
		appLib.alertAction("accept");
		appLib.setContext("webview");
		
		appLib.waitVisible(home.swLbHS_Message);
		appLib.click(home.swBtnHS_VerifyEmail);
		
		sleep();
		appLib.setContext("native");
		appLib.waitVisible(home.siLbHS_EnterYourPin);
		home.EnterPin("010203");
		appLib.setContext("webview");
		VerifyEmailpage verify = new VerifyEmailpage(appiumDriver);
		
		verify.waitVisible(verify.swBtnVerifyEmail_Back);
		
//		appLib.waitVisibleXpath(homePage.swTxtEmail);
		appLib.assertText(appLib.fX(verify.swLbVerifyEmail_Title).getText(), "Verify Email");
		appLib.assertText(appLib.fX(verify.swLbVerifyEmail_Description).getText(), "For using app secure and efficiency please verify your email");
		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Email));
		appLib.assertText(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail).getText(), "Verify");
		
		//Verify Email field validation
		String[] testData = {"aaa", "@", ".", "aa@","aa@.", "aaa@aaa", "aaa@aaa.", "@aaa", "@.", "@aaa.aaa", "tcs.qa.911@tutanota.com"};
		for (int i = 0; i < testData.length-1;i++) {
			log("Enter Email = "+testData[i]);
			appLib.setText(appLib.fX(verify.swTxtVerifyEmail_Email), testData[i]);
			log("Click Verify button");
			appLib.click(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail));
//			Helper.writeLog(appiumDriver.getPageSource());
			appLib.assertText(appLib.fX(verify.swLbVerifyEmail_EmailErrorMsg).getText(), "Email is a wrong format");
			sleep(1);
		}
		
		
		log("Enter Email = "+testData[testData.length-1]);
		appLib.fX(verify.swTxtVerifyEmail_Email).clear();
		appLib.setText(appLib.fX(verify.swTxtVerifyEmail_Email), testData[testData.length-1]);
		log("Click Verify button");
		appLib.click(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail));
		appLib.assertTrue(!appLib.isElementPresent(verify.swLbVerifyEmail_EmailErrorMsg));
		
		
//		sleep(20);
		
		appLib.waitVisible(verify.swLbVerifyEmail_Otp_Ref);
//		//verify screen
		appLib.assertTrue(appLib.isElementPresent(verify.swLbVerifyEmail_Otp_Ref));
//		Helper.writeLog(appiumDriver.getPageSource());
//		
		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin1));
		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin2));
		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin3));
		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin4));
//		
		//Verify invalid PIN
		String otpNumber = "1111";

		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
		sleep(10);
		
		appLib.waitVisible(verify.swLbOTPErrorMsg);
////		sleep();
		appLib.assertText(appLib.fX(verify.swLbOTPErrorMsg).getText()
				, "OTP incorrect");
//		
//		//Verify valid PIN success
		String ref = appLib.fX(verify.swLbVerifyEmail_Otp_Ref).getText();
		ref = ref.substring(ref.indexOf(":")+2, ref.length());
		log("Ref = "+ref);
		otpNumber = Otp_TutanotaPage.getOtpFromEmail(testData[testData.length-1], "Tcs@13579", ref);
		log("OTP Number = "+otpNumber);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
//		
		appLib.waitVisible(verify.swLbOTPSuccessMsg);
////		sleep();
//
		appLib.assertTrue(appLib.isElementPresent(verify.swLbOTPSuccessMsg));
//		
//		
//		//Verify success verify email page
		appLib.assertText(appLib.fX(verify.swLbOTPSuccessTitle).getText(), "Verify Complete!");
		appLib.assertText(appLib.fX(verify.swLbOTPSuccessMsg).getText(), "Your email has been verified.");
		appLib.assertText(appLib.fX(verify.swBtnOTPGoToHome).getText(), "Go to Home");
//		
		appLib.click(appLib.fX(verify.swBtnOTPGoToHome));
//		sleep();
		appLib.assertTrue(appLib.isElementPresent(home.swLbHS_Message));
//		
		appLib.assertText(appLib.fX(home.swLbHS_ChangeEmail).getText(), "Change Email");
		appLib.assertText(appLib.fX(home.swLbHS_ChangeEmail_Content).getText(), "Your email is verified. Let enjoy our email service");
		
		
		//=========================
		

//		appLib.waitVisibleXpath(home.swLbHS_Message);
//		appLib.click(home.swBtnHS_ChangeEmail);
//		
//		sleep();
//		appLib.setContext("native");
//		appLib.waitVisibleXpath(home.siLbHS_EnterYourPin);
//		home.EnterPin("010203");
//		appLib.setContext("webview");
//		VerifyEmailpage verify = new VerifyEmailpage(appiumDriver);
//		
//		verify.waitVisibleXpath(verify.swBtnVerifyEmail_Back);
//		
////		appLib.waitVisibleXpath(homePage.swTxtEmail);
//		appLib.assertText(appLib.fX(verify.swLbVerifyEmail_Title).getText(), "Verify Email");
//		appLib.assertText(appLib.fX(verify.swLbVerifyEmail_Description).getText(), "For using app secure and efficiency please verify your email to right recieve notofication messgae and News");
//		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Email));
//		appLib.assertText(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail).getText(), "Verify");
//		
//		//Verify Email field validation
//		String[] testData = {"aaa", "@", ".", "aa@","aa@.", "aaa@aaa", "aaa@aaa.", "@aaa", "@.", "@aaa.aaa", "tcs.qa.911@tutanota.com"};
//		for (int i = 0; i < testData.length-1;i++) {
//			log("Enter Email = "+testData[i]);
//			appLib.setText(appLib.fX(verify.swTxtVerifyEmail_Email), testData[i]);
//			log("Click Verify button");
//			appLib.click(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail));
////			Helper.writeLog(appiumDriver.getPageSource());
//			appLib.assertText(appLib.fX(verify.swLbVerifyEmail_EmailErrorMsg).getText(), "Email is a wrong format");
//			sleep(1);
//		}
//		
//		
//		log("Enter Email = "+testData[testData.length-1]);
//		appLib.fX(verify.swTxtVerifyEmail_Email).clear();
//		appLib.setText(appLib.fX(verify.swTxtVerifyEmail_Email), testData[testData.length-1]);
//		log("Click Verify button");
//		appLib.click(appLib.fX(verify.swBtnVerifyEmail_VerifyEmail));
//		appLib.assertTrue(!appLib.isElementPresent(verify.swLbVerifyEmail_EmailErrorMsg));
//		
//		
////		sleep(20);
//		
//		appLib.waitVisibleXpath(verify.swLbVerifyEmail_Otp_Ref);
////		//verify screen
//		appLib.assertTrue(appLib.isElementPresent(verify.swLbVerifyEmail_Otp_Ref));
////		Helper.writeLog(appiumDriver.getPageSource());
////		
//		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin1));
//		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin2));
//		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin3));
//		appLib.assertTrue(appLib.isElementPresent(verify.swTxtVerifyEmail_Otp_Pin4));
////		
//		//Verify invalid PIN
//		String otpNumber = "1111";
//
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
//		sleep(10);
//		
//		appLib.waitVisibleXpath(verify.swLbOTPErrorMsg);
//////		sleep();
//		appLib.assertText(appLib.fX(verify.swLbOTPErrorMsg).getText()
//				, "OTP incorrect");
////		
////		//Verify valid PIN success
//		String ref = appLib.fX(verify.swLbVerifyEmail_Otp_Ref).getText();
//		ref = ref.substring(ref.indexOf(":")+2, ref.length());
//		log("Ref = "+ref);
//		otpNumber = Otp_TutanotaPage.getOtpFromEmail(testData[testData.length-1], "Tcs@13579", ref);
//		log("OTP Number = "+otpNumber);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
//		appLib.setTextOTP(appLib.fX(verify.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
////		
//		appLib.waitVisibleXpath(verify.swLbOTPSuccessMsg);
//////		sleep();
////
//		appLib.assertTrue(appLib.isElementPresent(verify.swLbOTPSuccessMsg));
////		
////		
////		//Verify success verify email page
//		appLib.assertText(appLib.fX(verify.swLbOTPSuccessTitle).getText(), "Verify Complete!");
//		appLib.assertText(appLib.fX(verify.swLbOTPSuccessMsg).getText(), "Your email has been verified.");
//		appLib.assertText(appLib.fX(verify.swBtnOTPGoToHome).getText(), "Go to Home");
////		
//		appLib.click(appLib.fX(verify.swBtnOTPGoToHome));
////		sleep();
//		appLib.assertTrue(appLib.isElementPresent(home.swLbHS_Message));
////		
//		appLib.assertText(appLib.fX(home.swLbHS_ChangeEmail).getText(), "Change Email");
//		appLib.assertText(appLib.fX(home.swLbHS_ChangeEmail_Content).getText(), "Your email is verified. Let enjoy our email service");
//		

	}
}
