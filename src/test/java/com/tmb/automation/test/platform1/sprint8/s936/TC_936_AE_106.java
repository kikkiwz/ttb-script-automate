package com.tmb.automation.test.platform1.sprint8.s936;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.pages.platform1.Otp_TutanotaPage;
import com.tmb.automation.pages.platform1.VerifyEmailpage;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00030	Check screen customer can see 
' We have sent verification code to abcd@...."' for existing email

TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00037	"Check personal email when customer can see email detail that system sent email OTP
"
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00041	"Check screen when customer can input email OTP in 4 digits from device 
- Native keyboard
"
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00043	"Validate display on email OTP after input OTP complete
"
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00045	"Validate display on email OTP 
- wrong OTP
"
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00047	"Validate display on email OTP 
- wrong OTP > 1 times
"
TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00049	"Validate display on email OTP 
- wrong OTP > 3 times
"
TC_OneApp_MB_POC_Verify Email Complete EN_SIT_00057	"Check screen when verify email otp complete, So customer can see
'- header is "" Verify Complete!""
'- content of ""Your email has been changed""
- content of ""Thank You!""
- Logo
- ""Go to Home"" button 
"
TC_OneApp_MB_POC_Verify Email Complete EN_SIT_00059	"Validate ""Go to home"" button when customer touch the button
"
 */



public class TC_936_AE_106 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000012027155", false);
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_936", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "936"})
	public void teardown() {
		Base.driverQuit();
	}
	@Test(groups = {"android", "plaform1", "Sprint8", "936"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.setWebview();
		
		log("TC_OneApp_MB_POC_Verify Email OTP EN_SIT_00030	Check screen customer can see  We have sent verification code to abcd@.");
		
		hs.waitVisible(hs.swLbHS_Message);
		hs.click(hs.swBtnHS_VerifyEmail);
		
		sleep();
		hs.setNative();
		hs.waitVisible(hs.saLbHS_EnterYourPin);
		hs.EnterPin("010203");
		hs.setWebview();
		VerifyEmailpage ver = new VerifyEmailpage(appiumDriver);
		
		ver.waitVisible(ver.swBtnVerifyEmail_Back);
		
//		hs.waitVisibleXpath(homePage.swTxtEmail);
		hs.assertText(hs.fX(ver.swLbVerifyEmail_Title).getText(), map("Verify_Title"));
		hs.assertText(hs.fX(ver.swLbVerifyEmail_Description).getText(), map("Verify_Description"));
		hs.assertTrue(hs.isElementPresent(ver.swTxtVerifyEmail_Email));
		hs.assertText(hs.fX(ver.swBtnVerifyEmail_VerifyEmail).getText(), map("Verify_Button"));
		
		//Verify Email field validation
		String[] testData = {"aaa", "@", ".", "aa@","aa@.", "aaa@aaa", "aaa@aaa.", "@aaa", "@.", "@aaa.aaa", "tcs.qa.911@tutanota.com"};
		for (int i = 0; i < testData.length-1;i++) {
			log("Enter Email = "+testData[i]);
			hs.setText2(hs.fX(ver.swTxtVerifyEmail_Email), testData[i]);
			log("Click Verify button");
			hs.click(hs.fX(ver.swBtnVerifyEmail_VerifyEmail));
			sleep();
			
			hs.assertText(hs.fX(ver.swLbVerifyEmail_EmailErrorMsg).getText(), map("Email_ErrorMsg"));
			sleep(1);
		}
		
		
		log("Enter Email = "+testData[testData.length-1]);
		hs.fX(ver.swTxtVerifyEmail_Email).clear();
		sleep();
		hs.setText2(hs.fX(ver.swTxtVerifyEmail_Email), testData[testData.length-1]);
		log("Click Verify button");
		hs.click(hs.fX(ver.swBtnVerifyEmail_VerifyEmail));
		
		hs.assertTrue(!hs.isElementPresent(ver.swLbVerifyEmail_EmailErrorMsg));
		
		
//		sleep(20);
		
		hs.waitVisible(ver.swLbVerifyEmail_Otp_Ref);
//		//verify screen
		hs.assertText(ver.fX(ver.swBtnOTPResendCode).getText(), map("Resend_Button"));
		hs.assertTrue(hs.isElementPresent(ver.swLbVerifyEmail_Otp_Ref));
//		
		hs.assertTrue(hs.isElementPresent(ver.swTxtVerifyEmail_Otp_Pin1));
		hs.assertTrue(hs.isElementPresent(ver.swTxtVerifyEmail_Otp_Pin2));
		hs.assertTrue(hs.isElementPresent(ver.swTxtVerifyEmail_Otp_Pin3));
		hs.assertTrue(hs.isElementPresent(ver.swTxtVerifyEmail_Otp_Pin4));
//		
		//Verify invalid PIN
		String otpNumber = "1111";

		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
		sleep(10);
		
		hs.waitVisible(ver.swLbOTPErrorMsg);
////		sleep();
		hs.assertText(hs.fX(ver.swLbOTPErrorMsg).getText()
				, map("OTP_ErrorMsg"));
//		
//		//Verify valid PIN success
		String ref = hs.fX(ver.swLbVerifyEmail_Otp_Ref).getText();
		ref = ref.substring(ref.indexOf(":")+2, ref.length());
		log("Ref = "+ref);
		otpNumber = Otp_TutanotaPage.getOtpFromEmail(testData[testData.length-1], "Tcs@13579", ref);
		log("OTP Number = "+otpNumber);
		
		hs.assertText(Otp_TutanotaPage.subjectEmail, map("Subject_Email"));
		hs.assertText(Otp_TutanotaPage.titleEmail_EN, map("Title_Email_android"));
		hs.assertText(Otp_TutanotaPage.contentEmail_EN, map("Content_Email"));
		hs.assertText(Otp_TutanotaPage.titleEmail_TH, map("Title_Email_android_TH"));
		hs.assertText(Otp_TutanotaPage.contentEmail_TH, map("Content_Email_TH"));
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin1), otpNumber.split("")[0]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin2), otpNumber.split("")[1]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin3), otpNumber.split("")[2]);
		hs.setTextOTP(hs.fX(ver.swTxtVerifyEmail_Otp_Pin4), otpNumber.split("")[3]);
//		
		hs.waitVisible(ver.swLbOTPSuccessMsg);
////		sleep();
//
		hs.assertTrue(hs.isElementPresent(ver.swLbOTPSuccessMsg));
//		
//		
//		//Verify success verify email page
		hs.assertText(hs.fX(ver.swLbOTPSuccessTitle).getText(), map("OTP_Success_Title"));
		hs.assertText(hs.fX(ver.swLbOTPSuccessMsg).getText(), map("OTP_Success_Msg" ));
		hs.assertText(hs.fX(ver.swBtnOTPGoToHome).getText(), map("OTP_Success_Gotohome"));
//		
		hs.click(hs.fX(ver.swBtnOTPGoToHome));
		sleep();
		hs.assertTrue(hs.isElementPresent(hs.swLbHS_Message));
//		
		hs.assertText(hs.fX(hs.swLbHS_ChangeEmail).getText(), map("ChangeEmail_Button"));
		hs.assertText(hs.fX(hs.swLbHS_ChangeEmail_Content).getText(), map("ChangeEmail_Content"));
		
	}
}
