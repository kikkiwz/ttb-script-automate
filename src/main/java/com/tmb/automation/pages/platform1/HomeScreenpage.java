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

public class HomeScreenpage extends AppiumLibrary {
	
	//HomeScreen.Native
	public final String saBtnHS_footer_Home = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation\']";
	public final String siBtnHS_footer_Home = "//XCUIElementTypeOther[@name=\'FooterMenu0\']/XCUIElementTypeStaticText";
	public final String saLbHS_footer_Home = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation\']/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
	public final String siLbHS_footer_Home = "//XCUIElementTypeOther[@name=\'FooterMenu0\']/XCUIElementTypeStaticText";
	
	
	public final String saBtnHS_footer_Account = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_account\']";
	public final String siBtnHS_footer_Account = "//XCUIElementTypeOther[@name=\'FooterMenu1\']/XCUIElementTypeStaticText";
	public final String saLbHS_footer_Account = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_account\']/android.view.ViewGroup/android.widget.TextView";
	public final String siLbHS_footer_Account = "//XCUIElementTypeOther[@name=\'FooterMenu1\']/XCUIElementTypeStaticText";
	
	public final String saBtnHS_footer_FinancialHealth = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_financial_health\']";
	public final String siBtnHS_footer_FinancialHealth = "//XCUIElementTypeOther[@name=\'FooterMenu2\']/XCUIElementTypeStaticText";
	public final String saLbHS_footer_FinancialHealth = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_financial_health\']/android.view.ViewGroup/android.widget.TextView";
	public final String siLbHS_footer_FinancialHealth = "//XCUIElementTypeOther[@name=\'FooterMenu2\']/XCUIElementTypeStaticText";
	
	public final String saBtnHS_footer_Service = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_service\']";
	public final String siBtnHS_footer_Service = "//XCUIElementTypeOther[@name=\'FooterMenu3\']/XCUIElementTypeStaticText";
	public final String saLbHS_footer_Service = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_service\']/android.view.ViewGroup/android.widget.TextView";
	public final String siLbHS_footer_Service = "//XCUIElementTypeOther[@name=\'FooterMenu3\']/XCUIElementTypeStaticText";
	
	public final String saBtnHS_footer_Profile = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_profile\']";
	public final String siBtnHS_footer_Profile = "//XCUIElementTypeOther[@name=\'FooterMenu4\']/XCUIElementTypeStaticText";
	public final String saLbHS_footer_Profile = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_profile\']/android.view.ViewGroup/android.widget.TextView";
	public final String siLbHS_footer_Profile = "//XCUIElementTypeOther[@name=\'FooterMenu4\']/XCUIElementTypeStaticText";
	
	//HOmeScreen.Webview
	public final String swImgHS_Profile = "//img[@id=\'home-screen-profile_image\']";
	
	public final String swLbHS_Welcome = "//span[@id=\'home-screen-customer-name\']";
	public final String swBtnHS_ShowBalance = "//button[@id=\'home-screen-show-balance\']";
	public final String swImgHS_Bell = "//img[@id=\'home-screen-bell-image\']";
	public final String swImgHS_Robot = "//img[@id=\'home-screen-robot-image\']";
	
	public final String swLbHS_Message = "//span[@id=\'home-screen-message-lbl\']";
	public final String swLbHS_Seeall = "//span[@id=\'home-screen-see-all\']";
	public final String swBtnHS_close = "//div[contains(@class, \'home_cardHeader\')]";
	
	//verify email
	public final String swLbHS_VerifyEmail = "//h1[@id=\'home-screen-verify-email-lbl\']";
	public final String swLbHS_VerifyEmail_Content = "//p[@id=\'home-screen-card-content\']";
	public final String swBtnHS_VerifyEmail = "//button[@id=\'home-screen-verify-email-btn\']";
	public final String swImgHS_VerifyEmail_image = "//div[contains(@class, \'home-card_imageContainer_\')]";	
	
	//change email
	public final String swLbHS_ChangeEmail = "//h1[@id=\'home-screen-change-email-lbl\']";
	public final String swLbHS_ChangeEmail_Content = "//p[@id=\'home-screen-card-content\']";
	public final String swBtnHS_ChangeEmail = "//button[@id=\'home-screen-change-email-btn\']";
	public final String swImgHS_ChangeEmail_image = "//img=[@id=\'home-screen-card-image\']";
	public final String siHS_Service_btn = "//XCUIElementTypeButton[@name=\'Service\']";
	public final String saHS_Service_btn = "(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[3]";
	
	
	
	//Verify PIN
	public final String saBtnHS_Pin1 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_01\']";
	public final String siBtnHS_Pin1 = "//XCUIElementTypeButton[@label=\'1\']";
	
	public final String saBtnHS_Pin2 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_02\']";
	public final String siBtnHS_Pin2 = "//XCUIElementTypeButton[@label=\'2\']";
	
	public final String saBtnHS_Pin3 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_03\']";
	public final String siBtnHS_Pin3 = "//XCUIElementTypeButton[@label=\'3\']";
	
	public final String saBtnHS_Pin4 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_04\']";
	public final String siBtnHS_Pin4 = "//XCUIElementTypeButton[@label=\'4\']";
	
	public final String saBtnHS_Pin5 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_05\']";
	public final String siBtnHS_Pin5 = "//XCUIElementTypeButton[@label=\'5\']";
	
	public final String saBtnHS_Pin6 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_06\']";
	public final String siBtnHS_Pin6 = "//XCUIElementTypeButton[@label=\'6\']";
	
	public final String saBtnHS_Pin7 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_07\']";
	public final String siBtnHS_Pin7 = "//XCUIElementTypeButton[@label=\'7\']";
	
	public final String saBtnHS_Pin8 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_08\']";
	public final String siBtnHS_Pin8 = "//XCUIElementTypeButton[@label=\'8\']";
	
	public final String saBtnHS_Pin9 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_09\']";
	public final String siBtnHS_Pin9 = "//XCUIElementTypeButton[@label=\'9\']";
	
	public final String saBtnHS_Pin0 = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/key_00\']";
	public final String siBtnHS_Pin0 = "//XCUIElementTypeButton[@label=\'0\']";
	
	public final String saBtnBackSpace = "//android.widget.ImageView[@resource-id=\'com.ttbbank.oneapp.vit:id/clear]\']";
	public final String siBtnBackSpace = "//XCUIElementTypeButton[@name=\'iconBackspace\']";
	
	public final String saLbHS_EnterYourPin = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/title_pin\']";
	public final String siLbHS_EnterYourPin = "//XCUIElementTypeOther[XCUIElementTypeButton[@name=\'iconCrossMulticolor\']]/XCUIElementTypeStaticText[1]";
	
	public final String saBtnHS_ForgetPIN = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/forgot_pin_text\']";
	public final String siBtnHS_ForgetPIN = "//XCUIElementTypeOther[XCUIElementTypeButton[@name=\'iconCrossMulticolor\']]/XCUIElementTypeButton[2]/XCUIElementTypeStaticText";
	
	public final String saBtnHS_PinClose = "//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']";
	public final String siBtnHS_PinClose = "//XCUIElementTypeButton[@name=\'iconCrossMulticolor\']";
	
	public final String saBtnHS_PinClear = "//android.widget.ImageView[@resource-id=\'com.ttbbank.oneapp.vit:id/clear\']";
	public final String siBtnHS_PinClear = "//XCUIElementTypeButton[@name=\'btnBackSpace\']";
	
	public final String saLbHS_TextShow = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/error_text_show\']";
	public final String siLbHS_TextShow = "//XCUIElementTypeOther[XCUIElementTypeButton[@name=\'iconCrossMulticolor\']]/XCUIElementTypeStaticText[2]";
	
	//after enter valid pin
	public final String swLbHS_CustName = "//span[@id=\'home-screen-customer-name\']";
	public final String swLbHS_AccountName = "//div[contains(@class,\'home_balanceContainer\')]/p";
	public final String swLbHS_AccountBalance = "//span[@id=\'home-screen-account-balance\']";
			//"//div[contains(@class, \'home_balanceContainer\')]/div/span";
	
	
	public final String saLbCustName = "//span[contains(@class, \'home_custName\')]";
	public final String siLbCustName = "//span[contains(@class, \'home_custName\')]";
	
	public final String saAccountType = "";
	public final String siAccountType = "//div[contains(@class, \'home_balanceContainer\')]/p";
	
	public final String sibalanceAmount = "";
	public final String sibalanceAmount1 = "//div[contains(@class, \'balance_accountBalance\')]";
	public final String sibalanceAmount2 = "//span[contains(@class, \'balance_small\')]";
	public final String sibalanceAmount3 = "//span[contains(@class, \'balance_currency\')]";
	
	//Verify Email
	public final String swLbVerifyEmailTitle = "//div[contains(@class, \'home-card_mainContainer\')]/div[1]/button";
	public final String swLbVerifyEmailDescription = "//div[contains(@class, \'home-card_mainContainer\')]/div[1]/p";
	public final String swBtnVerifyEmail = "//div[contains(@class, \'home-card_mainContainer\')]/div[1]/button";
	public final String swBtnChangeEmail = "//button[@class=\'sc-bdfBwQ deCMOW\']";
	
	
	
//	
//	//Pendo popup
	public final String saBtnClosePendo = "//android.view.View[@index=\'0\'] ";

	
	//Change Email
	public final String swLbTitle = "//div[contains(@class, \'verify-change-email_navBarNative\')]/div/div/div[2]/h1";
	public final String swLbDescription = "//div[contains(@class, \'verify-change-email_staticText\')]/p[1]";
	public final String swTxtEmail = "//div[contains(@class, \'verify-change-email_email\')]/form/div/input";
	public final String swBtnVerify = "//div[contains(@class, \'verify-change-email_button\')]/button[1]";
	
	public final String swLbEmailErrorMsg = "//div[contains(@class, \'verify-change-email_emailDiv\')]/form/span[1]";

	
	//Change Email OTP
	
	public final String swLbOTPTitle = "//div[contains(@class, \'otp-email_content\')]/div[1]";
	public final String swLbOTPEmail = "//div[contains(@class, \'otp-email_content\')]/div[2]";
	public final String swLbOTPRef = "//div[contains(@class, \'otp-email_pac\')]";
	public final String swTxtOTPPin1 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[1]/input[1]";
	public final String swTxtOTPPin2 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[2]/input[1]";
	public final String swTxtOTPPin3 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[3]/input[1]";
	public final String swTxtOTPPin4 = "//div[contains(@class, \'otp-email_otpInput\')]/div/div[4]/input[1]";
	
	public final String swBtnOTPResendCode = "//div[contains(@class, \'otp-email_resend\')]/span";
	
	public final String swLbOTPErrorMsg = "//div[contains(@class, \'otp-email_error\')]";
	
	public final String swLbOTPSuccessTitle= "//div[contains(@class, \'otp-success_navBar\')]/div/div/div/h1";
	
	public final String swLbOTPSuccessMsg= "//div[contains(@class, \'otp-success_content\')]/div";
	
	public final String swBtnOTPGoToHome = "//div[contains(@class, \'otp-success_footerButton\')]/button";
	
	//Story14 - PIN Lock
	//Title
	public final String siLbPinLock_Title = "//XCUIElementTypeStaticText[@name=\'labelPinLocked\']";
	public final String saLbPinLock_Title = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/title_pin_lock\']";
	//Close button
	public final String siBtnPinLock_close = "//XCUIElementTypeButton[@name=\'btnClose\']";
	public final String saBtnPinLock_close = "//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']";
	//image
	public final String siImgPinLock_1 = "//XCUIElementTypeImage[@name=\'gifImage\']";
	public final String saImgPinLock_1 = "//android.widget.Image[@resource-id=\'home-screen-bell-image\']";
	//message
	public final String siLbPinLock_Message = "//XCUIElementTypeStaticText[@name=\'labelPinLockedMsg\']";
	public final String saLbPinLock_Message = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_lock_body\']";
	//Description
	public final String siLbPinLock_Description = "//XCUIElementTypeStaticText[@name=\'LabelLockedDesc\']";
	public final String saLbPinLock_Description = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_lock_description\']";
	//New PIN Button
	public final String siBtnPinLock_SetNewPin = "//XCUIElementTypeButton[@name=\'btnSetNewPin\']";
	public final String saBtnPinLock_SetNewPin = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/set_new_pin\']";
	//Label on New PIN Button
	public final String siLbPinLock_SetNewPin = "//XCUIElementTypeStaticText[@name=\'Set new PIN\']";
	public final String saLbPinLock_SetNewPin = "";
	
	public HomeScreenpage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		alertAction("accept");
	}
	
	public void EnterPin(String pinNumber) {
		if (Base.getMobileOS().equalsIgnoreCase("ios")) {
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(siBtnHS_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(siBtnHS_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(siBtnHS_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(siBtnHS_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(siBtnHS_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(siBtnHS_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(siBtnHS_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(siBtnHS_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(siBtnHS_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(siBtnHS_Pin9).click();
				}
			}
		}else if (Base.getMobileOS().equalsIgnoreCase("android")) {
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(saBtnHS_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(saBtnHS_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(saBtnHS_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(saBtnHS_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(saBtnHS_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(saBtnHS_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(saBtnHS_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(saBtnHS_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(saBtnHS_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(saBtnHS_Pin9).click();
				}
			}
		}
	}
	public void skipSplashScreen() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (isElementPresent(saBtnClosePendo)) {
			Log.logger.debug("click Close Pend button");
			click(fX(saBtnClosePendo));
		}
		Log.logger.debug("Before - check close PIN pad");
		if (isElementPresent("//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']")) {
			Log.logger.debug("Click close PIN Lock");
			click(fX("//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']"));
		}
		Log.logger.debug("After - check close PIN pad");
	}

}
