package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChangeUsageLimitPage extends AppiumLibrary {
	
	//Homescreen
	public final String saHS_Discovery_btn = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_profile\']";
	public final String siHS_Discovery_btn = "//XCUIElementTypeOther[@name=\'FooterMenu4\']";

	//Discover page
	public final String swDC_UsageLimit_btn = "//span[text()=\'Usage Limit\']";

	//UsageLimit page
	// Enter id for change limit page
	public final String swLb_Change1_title = "//h1[@id=\'refrence-number-header-label\']";
	public final String swLb_Change1_EnterAccountID = "//input[@id=\'refrence-number-text-box\']";
	public final String swLb_Change1_Submit = "//input[@id=\'refrence-number-submit-btn\']";
	public final String swLb_Change1_ErrMsg = "//span[contains(@class, \'activate-cardstyled__ErrorLbl\')]";

	//Adjust usage limit page
	public final String swLb_Change2_title = "//h1[@id=\'change-card-screen-header-lbl\']";
	public final String swImg_change2_CardImage = "//img[contains(@class, \'change-card-limitstyled__CardImage\')]";
	public final String swLb_change2_CardName = "//img[contain(@class, \'change-card-limitstyled__CardName\')]";
	public final String swLb_Change2_CardNumber = "//span[contains(@class, \'change-card-limitstyled__CardNumber\')]";
	public final String swLb_Change2_AmountSpent_desc = "//span[@id=\'change-card-screen-amount-lbl\']";
	public final String swLb_Change2_AmountSpent_value = "//div[contains(@class, \'change-card-limitstyled__CardMiddleLeft\')]/span[2]";

	public final String swLb_Change2_AvailableToSpend_texc = "//span[contains(@class, \'change-card-limitstyled__MiddleTopText\')]";
	public final String swLb_Change2_AvailableToSpend_value = "//span[contains(@class, \'change-card-limitstyled__CardNumber\')]";

	public final String swLb_Change2_CreditLimit = "//span[contains(@class, \'change-card-limitstyled__CreaditLimit\')]";

	public final String swLb_Change2_PleaseChangeUsageLimit = "//p[@id=\'change-card-screen-change-usage-limit-lbl\']";

	public final String swLb_Change2_CurrentCreditLimit_text = "//span[@id=\'change-card-screen-new-creadit-limit\']";
	public final String swLb_Change2_CurrentCreditLimit_value = "//input[@id=\'change-card-screen-input-field\']";

	public final String swLb_Change2_CurrentCreditLimit_ErrMsg = "//span[contains(@class, \'change-card-limitstyled__ErrorLbl\')]/span";
	public final String swPB_Change2_ProgressBar = "";
	public final String swLb_Change2_Min_text = "//div[contains(@class, \'change-card-limitstyled__MinBox\')]/span";
	public final String swLb_Change2_Min_value = "//div[contains(@class, \'change-card-limitstyled__MinBox\')]";
	public final String swLb_Change2_Max_text = "//div[contains(@class, \'change-card-limitstyled__MaxBox\')]/span";
	public final String swLb_Change2_Max_value = "//div[contains(@class, \'change-card-limitstyled__MaxBox\')]";

	public final String swBtn_Change2_Next = "//button[@id=\'change-card-screen-next-button\']";//div[contains(@class, \'change-card-limitstyled__NextButtonBox\')]/button


	// Confirm Adjust Usage Limit page

	public final String swLb_Change3_ConfirmAdjustUsageLimit = "//h1[contains(@class, \'sc-eLgOdN hnsowR\')]";

	public final String swLb_Change3_CardName = "//span[contains(@class, \'sc-bZSQDF djkaC\')]";
	public final String swLb_Change3_CardNumber = "//span[contains(@class, \'sc-dOSReg gDiZHt\')]";
	public final String swLb_Change3_OldCreditLimit_text = "//ul[contains(@class, \'sc-hiSbYr XqbgT\')]/li[3]/span/span";
	public final String swLb_Change3_OldCreditLimit_value = "//ul[contains(@class, \'sc-hiSbYr XqbgT\')]/li[3]/span[2]/span";

	public final String swLb_Change3_NewCreditLimit_text = "//ul[contains(@class, \'sc-hiSbYr XqbgT\')]/li[4]/span/span";
	public final String swLb_Change3_NewCreditLimit_value = "//ul[contains(@class, \'sc-hiSbYr XqbgT\')]/li[4]/span[2]/span";

	public final String swBtn_Change3_Confirm = "//button[contains(@class, \'sc-dlfnbm dSipDN\')]";

	//Adjust usage Limit for Temporary
	public final String swCbx_Change3_Reason = "//input[contains(@class, \'reasonstyled__SelectOption\')]";
	public final String swCbX_Change3_Reason_item1 = "//ul[contains(@class, \'sc-hiSbYr XqbgT\')]/li[1]/span/span";
	public final String swCbx_Change3_Reason_value = "//div[contains(@class, \'reasonstyled__SelectValue\')]";
	public final String swCbx_Change3_ExpiryDate = "//div[@for=\'adjust_usage_limit_expiry_date\']";
	public final String saBtn_Change3_Date20 = "//android.view.View[@index=\'20\']";
	public final String saBtn_Change3_SetCalendar = "//android.widget.Button[@resource-id=\'android:id/button1\']";
	public final String swCbx_Change3_ExpiryDate_value = "//div[contains(@class, \'expiry-datestyled__SelectValue\')]";

	public final String swLb_Change3_Condition = "//div[contains(@class, \'request-temporary-limitstyled__Conditions\')]";
	public final String swBtn_Change3_Next = "//button[@aria-label=\'Next\']";


	//Complete Page
	public final String swLb_Change4_Completed = "//div[contains(@class, \'request-temporary-limitstyled\')]/p[1]";
	public final String swLb_Change4_Details = "//div[contains(@class, \'request-temporary-limitstyled\')]/p[2]";


	public final String swLb_Change4_NewCreditLimit_text = "//div[contains(@class, \'request-temporary-limitstyled__DetailDesc\')]/div[1]/ul[1]/li[1]/span/span";
	public final String swLb_Change4_NewCreditLimit_value = "//div[contains(@class, \'request-temporary-limitstyled__DetailDesc\')]/div[1]/ul[1]/li[1]/span[2]/span";

	public final String swLb_Change4_EffectiveDate_text = "//ul[contains(@class,\'sc-hiSbYr XqbgT\')]/li[2]/span/span";
	public final String swLb_Change4_EffectiveDate_value = "//ul[contains(@class,\'sc-hiSbYr XqbgT\')]/li[2]/span[2]/span";

	public final String swBtn_Change4_BackToMainPage = "//button[contains(@class, \'sc-dlfnbm cpDUSl\')]";
		
		
		//Set 
		//======================================================================================

//		//Enter Refrence Number page
		public final String swLbLD_EnterReferenceNumber = "//h1[@id=\'refrence-number-header-label\']";
//		public final String swTxtLD_EnterReferenceNumber = "//input[@id=\'refrence-number-text-box\']";
//		public final String swBtnLD_EnterRefrenceNumber_Submit = "//div[contains(@class, \'activate-cardstyled__CompleteBottomBox\')]/button";
//		public final String swLbLD_ErrMsg = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
	//	
	//	
//		//Loading
//		public final String swLbLD_ActivateCard_title = "//h1[contains(@class, \'sc-aemoO iOmLqx\')]";
//		public final String swImgLD_ActivateCard = "//img[contains(@class, \'activate-cardstyled__Image\')]";
//		public final String swLbLD_ActivateCard_Description = "//span[contains(@class, \'activate-cardstyled__MiddleText\')]";
//		public final String swBtnLD_ScanCard = "//button[contains(@class, \'ScanButton\')]";
//		public final String swBtnLD_EnterCardNumber = "//button[contains(@class, \'EnterButton\')]";
	//	
//		public final String swLbLD_AV_Loading_title = "//h1[@id=\'tid\']";
//		public final String swImgLD_AV_Loading = "//img[contains(@class, \'activate-cardstyled__Image\')]";
//		public final String swLbLD_AV_Loading_Description = "//span[contains(@class, \'activate-cardstyled__MiddleText\')]";
//		public final String swBtnLD_AV_Loading_ScanButton = "//button[contains(@class, \'ScanButton\')]";
//		public final String swBtnLD_AV_Loading_EnterCardNumber = "//button[contains(@class, \'EnterButton\')]";
	//	
//		//Enter Card
//		public final String swLbLD_ActivateCard2_Title = "//div[contains(@class, \'sc-jHVexB iiHqcD\')]/h1";
//		public final String swLbLD_ActivateCard2_Description = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
//		public final String swTxtLD_ActiveCard2_PleaseEnter1 = "//div[contains(@class, \'creaditstyled__Container\')]/input[1]";
//		public final String swTxtLD_ActiveCard2_PleaseEnter2 = "//div[contains(@class, \'creaditstyled__Container\')]/input[2]";
	//	
//		public final String swLbLD_AV_EnterCard_Title = "//h1[@id=\'credit-card-header-label\']";
//		public final String swLbLD_AV_EnterCard_Description = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
//		public final String swTxtLD_AV_EnterCard_PleaseEnter1 = "//div[contains(@class, \'creaditstyled__Container\')]/input[1]";
//		public final String swTxtLD_AV_EnterCard_PleaseEnter2 = "//div[contains(@class, \'creaditstyled__Container\')]/input[2]";
	//	
	//	
//		//Activate Card page 3 CVV
//		public final String swLbLD_ActivateCard3_Title = "//div[contains(@class, \'sc-jHVexB iiHqcD\')]/h1";
//		public final String swlbLD_ActivateCard3_Description = "//div[contains(@class, \'pin-screenstyled__HeaderBox\')]/span";
//		public final String swImgLD_ActivateCard3_icon = "//div[@id=\'enter-cvv-screen-info-icon\']";
//		public final String swTxtLD_ActivateCard3_Pin1 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[1]";
//		public final String swTxtLD_ActivateCard3_Pin2 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[2]";
//		public final String swTxtLD_ActivateCard3_Pin3 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[3]";
//		public final String swLbLD_ActivateCard3_ErrMsg = "//span[contains(@class, \'activate-cardstyled__ErrorLbl\')]";
	//	
	//	
//		public final String swLbLD_AV_EnterCVV_Title = "//h1[@id=\'enter-cvv-screen-header-label\']";
//		public final String swlbLD_AV_EnterCVV_Description = "//div[contains(@class, \'pin-screenstyled__HeaderBox\')]/span";
//		public final String swImgLD_AV_EnterCVV_icon = "//div[@id=\'enter-cvv-screen-info-icon\']";
//		public final String swTxtLD_AV_EnterCVV_Pin1 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[1]";
//		public final String swTxtLD_AV_EnterCVV_Pin2 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[2]";
//		public final String swTxtLD_AV_EnterCVV_Pin3 = "//div[contains(@class, \'pin-screenstyled__CvvPinBox\')]/div[3]";
//		public final String swLbLD_AV_EnterCVV_ErrMsg = "//span[contains(@class, \'pin-screenstyled__CvvErrorLbl\')]";
	//	
	//	
//		public final String swBtnLD_ActivateCard3_Pin1 = "//button[@aria-label=\'1\']";
//		public final String swBtnLD_ActivateCard3_Pin2 = "//button[@aria-label=\'2\']";
//		public final String swBtnLD_ActivateCard3_Pin3 = "//button[@aria-label=\'3\']";
//		public final String swBtnLD_ActivateCard3_Pin4 = "//button[@aria-label=\'4\']";
//		public final String swBtnLD_ActivateCard3_Pin5 = "//button[@aria-label=\'5\']";
//		public final String swBtnLD_ActivateCard3_Pin6 = "//button[@aria-label=\'6\']";
//		public final String swBtnLD_ActivateCard3_Pin7 = "//button[@aria-label=\'7\']";
//		public final String swBtnLD_ActivateCard3_Pin8 = "//button[@aria-label=\'8\']";
//		public final String swBtnLD_ActivateCard3_Pin9 = "//button[@aria-label=\'9\']";
//		public final String swBtnLD_ActivateCard3_Pin0 = "//button[@aria-label=\'0\']";
	//	
//		public final String swBtnLD_EnterCVV_Pin1 = "//button[@aria-label=\'1\']";
//		public final String swBtnLD_EnterCVV_Pin2 = "//button[@aria-label=\'2\']";
//		public final String swBtnLD_EnterCVV_Pin3 = "//button[@aria-label=\'3\']";
//		public final String swBtnLD_EnterCVV_Pin4 = "//button[@aria-label=\'4\']";
//		public final String swBtnLD_EnterCVV_Pin5 = "//button[@aria-label=\'5\']";
//		public final String swBtnLD_EnterCVV_Pin6 = "//button[@aria-label=\'6\']";
//		public final String swBtnLD_EnterCVV_Pin7 = "//button[@aria-label=\'7\']";
//		public final String swBtnLD_EnterCVV_Pin8 = "//button[@aria-label=\'8\']";
//		public final String swBtnLD_EnterCVV_Pin9 = "//button[@aria-label=\'9\']";
//		public final String swBtnLD_EnterCVV_Pin0 = "//button[@aria-label=\'0\']";
	//	
//		//Activate Card Complete page
//		public final String swLbLD_ActivateCardComplete_title = "//span[contains(@class, \'activate-cardstyled__Complete\')]";
//		public final String swLbLD_ActivateCardComplete_description = "//div[contains(@class, \'activate-cardstyled__CompleteMiddleBox\')]";
//		public final String swBtnLD_ActivateCardComplete_BackToMainPage = "//div[contains(@class, \'activate-cardstyled__CompleteBottomBox\')]/button";
	//	
	public ChangeUsageLimitPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
