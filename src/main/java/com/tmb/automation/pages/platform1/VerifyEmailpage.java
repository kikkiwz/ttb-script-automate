package com.tmb.automation.pages.platform1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VerifyEmailpage extends AppiumLibrary {

	
	//Verify Email
	public final String swLbVerifyEmail_Title = "//div[contains(@class, \'verify-change-email_navBarNative\')]/div/div/div[2]/h1";
	public final String swBtnVerifyEmail_Back = "//div[contains(@class, \'verify-change-email_navBarNative\')]/div/div/div[1]/button";
	public final String swLbVerifyEmail_Description = "//p[@id=\'verify-email-screen-header-content\']";
	public final String swImgVerifyEmail_Image = "//img[@id=\'verify-email-screen-image\']";
	public final String swTxtVerifyEmail_Email = "//input[@id=\'verify-email-screen-text-field\']";
	public final String swLbVerifyEmail_Email = "//label[@for=\'verify-email-screen-text-field\']";
	public final String swBtnVerifyEmail_VerifyEmail = "//button[@id=\'verify-email-screen-verify-button\']";
	
	public final String swLbVerifyEmail_Otp_Header = "//div[contains(@class, \'otp-email_navBarNative\')]/div/div/div[2]/h1";
	public final String swLbVerifyEmail_Otp_Content = "//div[@id=\'otp-email-screen-header-verify-content\']";
	public final String swBtnVerifyEmail_Otp_Back = "//div[contains(@class, \'otp-email_navBarNative\')]/div/div/div[1]/button";
	public final String swLbVerifyEmail_Otp_Email = "//div[@id=\'otp-email-screen-email-id\']";
	public final String swLbVerifyEmail_Otp_Ref = "//div[@id=\'otp-email-screen-enter-pac-value\']";
	
	public final String swTxtVerifyEmail_Otp_Pin1 = "//div[@id=\'otp-email-screen-otp-input\']/div/div[1]/input";
	public final String swTxtVerifyEmail_Otp_Pin2 = "//div[@id=\'otp-email-screen-otp-input\']/div/div[2]/input";
	public final String swTxtVerifyEmail_Otp_Pin3 = "//div[@id=\'otp-email-screen-otp-input\']/div/div[3]/input";
	public final String swTxtVerifyEmail_Otp_Pin4 = "//div[@id=\'otp-email-screen-otp-input\']/div/div[4]/input";
	public final String swBtnVerifyEmail_Otp_Resend = "//div[contains(@class,\'otp-email_noResend_\')]";
	public final String swLbVerifyEmail_EmailErrorMsg = "//div[contains(@class, \'verify-change-email_emailDiv\')]/form/span[1]";
	//	
//	//Pendo popup
	public final String saBtnClosePendo = "//android.view.View[@index=\'0\'] ";

	
//	//Change Email
//	public final String swLbTitle = "//div[contains(@class, \'verify-change-email_navBarNative\')]/div/div/div[2]/h1";
//	public final String swLbDescription = "//div[contains(@class, \'verify-change-email_staticText\')]/p[1]";
//	public final String swTxtEmail = "//div[contains(@class, \'verify-change-email_email\')]/form/div/input";
//	public final String swBtnVerify = "//div[contains(@class, \'verify-change-email_button\')]/button[1]";
//	
//	public final String swLbEmailErrorMsg = "//div[contains(@class, \'verify-change-email_emailDiv\')]/form/span[1]";
//
//	
//	//Change Email OTP
//	
//	public final String swLbOTPTitle = "//div[contains(@class, \'otp-email_content\')]/div[1]";
//	public final String swLbOTPEmail = "//div[contains(@class, \'otp-email_content\')]/div[2]";
//	public final String swLbOTPRef = "//div[contains(@class, \'otp-email_pac\')]";
//	public final String swTxtOTPPin1 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[1]/input[1]";
//	public final String swTxtOTPPin2 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[2]/input[1]";
//	public final String swTxtOTPPin3 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[3]/input[1]";
//	public final String swTxtOTPPin4 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[4]/input[1]";
//	
	public final String swBtnOTPResendCode = "//span[@id=\'otp-email-screen-resend-link\']";
	
	public final String swLbOTPErrorMsg = "//div[@id=\'otp-email-screen-error-lbl\']";
	
	public final String swLbOTPSuccessTitle= "//div[contains(@class, \'otp-success_navBar\')]/div/div/div/h1";
	
	public final String swLbOTPSuccessMsg= "//div[contains(@class, \'otp-success_content\')]/div";
	
	public final String swBtnOTPGoToHome = "//div[contains(@class, \'otp-success_footerButton\')]/button";
	
	public VerifyEmailpage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

}
