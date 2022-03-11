package com.tmb.automation.test.it4it.sprint8;
//package com.automation.test.sprint8;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.openqa.selenium.Keys;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import com.tmb.automation.helper.Helper;
//import com.tmb.automation.pages.sprint8.HomeScreenpage;
//import com.tmb.automation.pages.sprint8.Otp_TutanotaPage;
//import com.tmb.automation.util.AppiumLibrary;
//import com.tmb.automation.util.Base;
//
///**
// * Verify The Change Email
// * @author Admin
// *
// */
//public class AD_SP8_TC020 extends Base {
////	@BeforeSuite(groups= {"android", "sprint8"})
////	public void BeforeSuite() {
////		startEmulator();
////		startServer();
////	}
////	@AfterSuite(groups = {"android", "sprint8"})
////	public void AfterSuite() {
////		stopServer();
////		stopEmulator();
////	}
//	
//	@BeforeClass(groups={"android", "sprint8"})
//	public void setUp() throws IOException {
//		Base.androidCapabilities();
//	}
//
//	@AfterClass(groups={"android", "sprint8"})
//	public void teardown() {
//		appiumDriver.quit();
//	}
//	@Test(groups = {"android", "sprint8"})
//	public void IPTest() throws IOException {
//		log("--------------"+this.getClass().getSimpleName());
//		AppiumLibrary appLib = new AppiumLibrary(appiumDriver);
//		HomeScreenpage homePage = new HomeScreenpage(appiumDriver);
//		homePage.skipSplashScreen();
//		appLib.alertAction("accept");
//		appLib.setContext("webview");
//		
//		appLib.waitVisibleXpath(homePage.swLbVerifyEmailTitle);
//		
////		//Verify Verify Email
//		appLib.assertText(appLib.fXpath(homePage.swLbVerifyEmailTitle).getText(), "Change Email");
//		appLib.assertText(appLib.fXpath(homePage.swLbVerifyEmailDescription).getText(), "Your email is verified. Let enjoy our email service");
////		
//		appLib.click(appLib.fXpath(homePage.swBtnVerifyEmail));
////		sleep();
//		appLib.setContext("native");
//		appLib.waitVisibleXpath(homePage.saBtnPin0);
//		homePage.EnterPinAndroid("010203");
////		sleep(15);
//		appLib.waitInVisibleXpath(homePage.saBtnPin0);
//		appLib.setContext("webview");
////		sleep();
//
//
//		
//		//Verify Fields
//		appLib.waitVisibleXpath(homePage.swTxtEmail);
//		appLib.assertText(appLib.fXpath(homePage.swLbTitle).getText(), "Change Email");
//		appLib.assertText(appLib.fXpath(homePage.swLbDescription).getText(), "Your email is verified. Let enjoy our email service");
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtEmail));
//		appLib.assertText(appLib.fXpath(homePage.swBtnVerify).getText(), "Verify Email");
//		
//		//Verify Email field validation
//		String[] testData = {"aaa", "@", ".", "aa@","aa@.", "aaa@aaa", "aaa@aaa.", "@aaa", "@.", "@aaa.aaa", "tcs.qa.911@tutanota.com"};
//		for (int i = 0; i < testData.length-1;i++) {
//			log("Enter Email = "+testData[i]);
//			appLib.setText(appLib.fXpath(homePage.swTxtEmail), testData[i]);
//			log("Click Verify button");
//			appLib.click(appLib.fXpath(homePage.swBtnVerify));
//			appLib.assertText(appLib.fXpath(homePage.swLbEmailErrorMsg).getText(), "Invalid email format");
//			
//		}
//		log("Enter Email = "+testData[testData.length-1]);
//		appLib.setText(appLib.fXpath(homePage.swTxtEmail), testData[testData.length-1]);
//		log("Click Verify button");
//		appLib.click(appLib.fXpath(homePage.swBtnVerify));
//		appLib.assertTrue(!appLib.isElementPresent(homePage.swLbEmailErrorMsg));
//		
////		sleep(20);
//		appLib.waitVisibleXpath(homePage.swLbOTPRef);
//		//verify screen
//		appLib.assertTrue(appLib.isElementPresent(homePage.swLbOTPRef));
//		Helper.writeLog(appiumDriver.getPageSource());
//		
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin1));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin2));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin3));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin4));
//		
//		//Verify invalid PIN
//		String otpNumber = "1111";
//
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin1), otpNumber.split("")[0]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin2), otpNumber.split("")[1]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin3), otpNumber.split("")[2]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin4), otpNumber.split("")[3]);
//		sleep();
//		appLib.waitVisibleXpath(homePage.swLbOTPErrorMsg);
////		sleep();
//		appLib.assertText(appLib.fXpath(homePage.swLbOTPErrorMsg).getText()
//				, "OTP verification failed");
//		
//		//Verify valid PIN success
//		String refNumber = appLib.fXpath(homePage.swLbOTPRef).getText();
//		log("Ref = "+refNumber);
//		otpNumber = Otp_TutanotaPage.getOtpFromEmail(testData[testData.length-1], "Tcs@13579", refNumber);
//		log("OTP Number = "+otpNumber);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin1), otpNumber.split("")[0]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin2), otpNumber.split("")[1]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin3), otpNumber.split("")[2]);
//		appLib.setTextOTP(appLib.fXpath(homePage.swTxtOTPPin4), otpNumber.split("")[3]);
//		
//		appLib.waitVisibleXpath(homePage.swLbOTPSuccessMsg);
////		sleep();
//
//		appLib.assertTrue(appLib.isElementPresent(homePage.swLbOTPSuccessMsg));
//		
//		
//		//Verify success verify email page
//		appLib.assertText(appLib.fXpath(homePage.swLbOTPSuccessTitle).getText(), "Verify Complete!");
//		appLib.assertText(appLib.fXpath(homePage.swLbOTPSuccessMsg).getText(), "Your email has been verified.");
//		appLib.assertText(appLib.fXpath(homePage.swBtnOTPGoToHome).getText(), "Go To Home");
//		
//		appLib.click(appLib.fXpath(homePage.swBtnOTPGoToHome));
//		sleep();
//		appLib.assertTrue(appLib.isElementPresent(homePage.swImgProfile));
//		
//	}
//}
