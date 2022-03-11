package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActivateCardPage extends AppiumLibrary {
	
	//Homescreen
	public final String swImgHS_Robot = "//img[@id=\'home-screen-robot-image\']";
	public final String siHS_Home_btn = "//XCUIElementTypeStaticText[@name=\'Home\']";
	public final String siHS_Accounts_btn = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Home\']]]/XCUIElementTypeOther[2]";
	public final String saHS_Accounts_btn = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_account\']";
	public final String siHS_Service_btn = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Home\']]]/XCUIElementTypeOther[4]/XCUIElementTypeImage";
	public final String saHS_Service_btn = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_service\']";
	public final String saHS_Discovery_btn = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_profile\']";
	public final String siHS_Discovery_btn = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Home\']]]/XCUIElementTypeOther[5]";
	
	//Discover page
	public final String swDisc_ActivateCard_btn = "//span[text()=\'Activate Card\']";
	//HomeScreen.WebView
	public final String swBtnLD_CC = "//div[contains(@class, \'home_bottomBox\')]/button";
	//Pin page
//	public final String saBtnHS_Pin1 = "//android.widget.TextView[contains(@resource-id, \'key_01\')]";
//	public final String siBtnHS_Pin1 = "//XCUIElementTypeButton[@label=\'1\']";

	//Enter Refrence Number page
	public final String swLbLD_EnterReferenceNumber = "//h1[@id=\'refrence-number-header-label\']";
	public final String swTxtLD_EnterReferenceNumber = "//input[@id=\'refrence-number-text-box\']";
	public final String swBtnLD_EnterRefrenceNumber_Submit = "//div[contains(@class, \'activate-cardstyled__CompleteBottomBox\')]/button";
	public final String swLbLD_ErrMsg = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
	
	
	//Loading
	public final String swLbLD_ActivateCard_title = "//h1[contains(@class, \'sc-aemoO iOmLqx\')]";
	public final String swImgLD_ActivateCard = "//img[contains(@class, \'activate-cardstyled__Image\')]";
	public final String swLbLD_ActivateCard_Description = "//span[contains(@class, \'activate-cardstyled__MiddleText\')]";
	public final String swBtnLD_ScanCard = "//button[contains(@class, \'ScanButton\')]";
	public final String swBtnLD_EnterCardNumber = "//button[contains(@class, \'EnterButton\')]";
	
	public final String swLbLD_AV_Loading_title = "//h1[@id=\'tid\']";
	public final String swImgLD_AV_Loading = "//img[contains(@class, \'activate-cardstyled__Image\')]";
	public final String swLbLD_AV_Loading_Description = "//span[contains(@class, \'activate-cardstyled__MiddleText\')]";
	public final String swBtnLD_AV_Loading_ScanButton = "//button[contains(@class, \'ScanButton\')]";
	public final String swBtnLD_AV_Loading_EnterCardNumber = "//button[contains(@class, \'EnterButton\')]";
	
	//Enter Card
	public final String swLbLD_ActivateCard2_Title = "//div[contains(@class, \'sc-jHVexB iiHqcD\')]/h1";
	public final String swLbLD_ActivateCard2_Description = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
	public final String swLbLD_ActivateCard2_PreNumber = "//div[contains(@class, \'creaditstyled__PreNumber\')]";
	public final String swTxtLD_ActiveCard2_PleaseEnter1 = "//div[contains(@class, \'creaditstyled__Container\')]/input[1]";
	public final String swTxtLD_ActiveCard2_PleaseEnter2 = "//div[contains(@class, \'creaditstyled__Container\')]/input[2]";
	
	public final String swLbLD_AV_EnterCard_Title = "//h1[@id=\'credit-card-header-label\']";
	public final String swLbLD_AV_EnterCard_Description = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
	public final String swTxtLD_AV_EnterCard_PleaseEnter1 = "//input[@id=\'credit-card-two-text-box\']";
	public final String swTxtLD_AV_EnterCard_PleaseEnter2 = "//input[@id=\'credit-card-four-text-box\']";
	
	
	//Activate Card page 3 CVV
	public final String swLbLD_ActivateCard3_Title = "//div[contains(@class, \'sc-jHVexB iiHqcD\')]/h1";
	public final String swlbLD_ActivateCard3_Description = "//div[contains(@class, \'pin-screenstyled__HeaderBox\')]/span";
	public final String swImgLD_ActivateCard3_icon = "//div[@id=\'enter-cvv-screen-info-icon\']";
	public final String swTxtLD_ActivateCard3_Pin1 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[1]";
	public final String swTxtLD_ActivateCard3_Pin2 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[2]";
	public final String swTxtLD_ActivateCard3_Pin3 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[3]";
	public final String swLbLD_ActivateCard3_ErrMsg = "//span[contains(@class, \'activate-cardstyled__ErrorLbl\')]";
	
	
	public final String swLbLD_AV_EnterCVV_Title = "//h1[@id=\'enter-cvv-screen-header-label\']";
	public final String swlbLD_AV_EnterCVV_Description = "//div[contains(@class, \'pin-screenstyled__HeaderBox\')]/span";
	public final String swImgLD_AV_EnterCVV_icon = "//div[@id=\'enter-cvv-screen-info-icon\']";
	public final String swTxtLD_AV_EnterCVV_Pin1 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[1]";
	public final String swTxtLD_AV_EnterCVV_Pin2 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[2]";
	public final String swTxtLD_AV_EnterCVV_Pin3 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[3]";
	public final String swLbLD_AV_EnterCVV_ErrMsg = "//span[contains(@class, \'pin-screenstyled__CvvErrorLbl\')]";
	
	
	public final String swBtnLD_ActivateCard3_Pin1 = "//button[@aria-label=\'1\']";
	public final String swBtnLD_ActivateCard3_Pin2 = "//button[@aria-label=\'2\']";
	public final String swBtnLD_ActivateCard3_Pin3 = "//button[@aria-label=\'3\']";
	public final String swBtnLD_ActivateCard3_Pin4 = "//button[@aria-label=\'4\']";
	public final String swBtnLD_ActivateCard3_Pin5 = "//button[@aria-label=\'5\']";
	public final String swBtnLD_ActivateCard3_Pin6 = "//button[@aria-label=\'6\']";
	public final String swBtnLD_ActivateCard3_Pin7 = "//button[@aria-label=\'7\']";
	public final String swBtnLD_ActivateCard3_Pin8 = "//button[@aria-label=\'8\']";
	public final String swBtnLD_ActivateCard3_Pin9 = "//button[@aria-label=\'9\']";
	public final String swBtnLD_ActivateCard3_Pin0 = "//button[@aria-label=\'0\']";
	
	public final String swBtnLD_EnterCVV_Pin1 = "//button[@aria-label=\'1\']";
	public final String swBtnLD_EnterCVV_Pin2 = "//button[@aria-label=\'2\']";
	public final String swBtnLD_EnterCVV_Pin3 = "//button[@aria-label=\'3\']";
	public final String swBtnLD_EnterCVV_Pin4 = "//button[@aria-label=\'4\']";
	public final String swBtnLD_EnterCVV_Pin5 = "//button[@aria-label=\'5\']";
	public final String swBtnLD_EnterCVV_Pin6 = "//button[@aria-label=\'6\']";
	public final String swBtnLD_EnterCVV_Pin7 = "//button[@aria-label=\'7\']";
	public final String swBtnLD_EnterCVV_Pin8 = "//button[@aria-label=\'8\']";
	public final String swBtnLD_EnterCVV_Pin9 = "//button[@aria-label=\'9\']";
	public final String swBtnLD_EnterCVV_Pin0 = "//button[@aria-label=\'0\']";
	
	//Activate Card Complete page
	public final String swLbLD_ActivateCardComplete_title = "//span[contains(@class, \'activate-cardstyled__Complete\')]";
	public final String swLbLD_ActivateCardComplete_description = "//div[contains(@class, \'activate-cardstyled__CompleteMiddleBox\')]";
	public final String swBtnLD_ActivateCardComplete_BackToMainPage = "//div[contains(@class, \'activate-cardstyled__CompleteBottomBox\')]/button";
	
	//Set PIN on
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
	
	//Set PIN on=====================
	
	public final String saBtnCF_Pin1 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_1\']";
	public final String siBtnCF_Pin1 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]";
	
	public final String saBtnCF_Pin2 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_2\']";
	public final String siBtnCF_Pin2 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]";
	
	public final String saBtnCF_Pin3 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_3\']";
	public final String siBtnCF_Pin3 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[1]/XCUIElementTypeButton[3]";
	
	public final String saBtnCF_Pin4 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_4\']";
	public final String siBtnCF_Pin4 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]";
	
	public final String saBtnCF_Pin5 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_5\']";
	public final String siBtnCF_Pin5 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]";
	
	public final String saBtnCF_Pin6 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_6\']";
	public final String siBtnCF_Pin6 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[2]/XCUIElementTypeButton[3]";
	
	public final String saBtnCF_Pin7 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_7\']";
	public final String siBtnCF_Pin7 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[3]/XCUIElementTypeButton[1]";
	
	public final String saBtnCF_Pin8 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_8\']";
	public final String siBtnCF_Pin8 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[3]/XCUIElementTypeButton[2]";
	
	public final String saBtnCF_Pin9 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_9\']";
	public final String siBtnCF_Pin9 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[3]/XCUIElementTypeButton[3]";
	
	public final String saBtnCF_Pin0 = "//android.widget.Button[@resource-id=\'com.ttbbank.oneapp.vit:id/pin_key_0\']";
	public final String siBtnCF_Pin0 = "//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeButton[@name=\'btnBackSpace\']]]/XCUIElementTypeOther[4]/XCUIElementTypeButton[2]";
	
	public final String saBtnCF_BackSpace = "//android.widget.ImageView[@resource-id=\'com.ttbbank.oneapp.vit:id/clear]\']";
	public final String siBtnCF_BackSpace = "//XCUIElementTypeButton[@name=\'iconBackspace\']";

	public ActivateCardPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
