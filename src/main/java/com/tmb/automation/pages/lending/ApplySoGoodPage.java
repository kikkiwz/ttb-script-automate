package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApplySoGoodPage extends AppiumLibrary {
	//Native----------
	//Service page
	public final String siSV_ApplySoGood_link= "(//XCUIElementTypeStaticText[@name=\'Apply So good\'])[1]";
	public final String siAG_page1_TextReference_txt = "//XCUIElementTypeTextField[@value=\'Enter Refrence Number\']";
	public final String siAG_page1_Submit_Btn = "//XCUIElementTypeButton[@name=\'Submit\']";

	//ApplySoGood Page 1 enter reference number
	public final String siAG_page1_Title = "";
	public final String siAG_page1_Title2 = "";
	public final String siAG_page1_Desc1 = "";
	public final String siAG_page1_Desc2 = "";
	public final String SiAG_page1_Desc3 = "";

//	public final String siAG_page1_checkbox1 = "//XCUIElementTypeStaticText[@name=\'I have read and accept\']";
	public final String siAG_page1_checkbox1 = "//XCUIElementTypeSwitch";
	public final String siAG_page1_Next_Btn = "//XCUIElementTypeButton[@name=\'Next\']";

	//XCUIElementTypeOther[XCUIElementTypeButton[@name=\'Next\']]/XCUIElementTypeButton

	//ApplySoGood Page2
	public final String siAg_page2_Title = "//XCUIElementTypeStaticText[@name=\'so goood\']";
	public final String siAG_page2_checkbox1 = "//XCUIElementTypeStaticText[@name=\'ONLINE PAYMENT VIA MIB/ IB TH\']";
	public final String siAG_page2_Next = "//XCUIElementTypeButton[@name=\'Next\']";
	public final String siAG_page2_SelectAll = "//XCUIElementTypeStaticText[@name=\'Select all\']";
	public final String siAG_page2_checkboxRandom1 = "(//XCUIElementTypeStaticText[@name=\'ONLINE PAYMENT VIA MIB/ IB TH\'])[2]";

	//ApplySoGood Page3
	public final String siAG_page3_Title2 = "//XCUIElementTypeStaticText[@name=\'Select Installment Plan\']";
	public final String siAG_page3_Cond3 = "//XCUIElementTypeStaticText[@name=\'0% 3 Months\']";
	public final String siAG_page3_Next = "//XCUIElementTypeButton[@name=\'Next\']";

	//ApplySoGood Page4
	public final String siAG_page4_Title1 = "//XCUIElementTypeStaticText[@name=\'so goood\']";
	public final String siAG_page4_Title2 = "//XCUIElementTypeStaticText[@name=\'Detail of Installment\']";
	public final String siAG_page4_Label1 = "//XCUIElementTypeStaticText[@name=\'Credit Card\']";
	public final String siAG_page4_Label2 = "//XCUIElementTypeStaticText[@name=\'Card number\']";
	public final String siAG_page4_Label3 = "//XCUIElementTypeStaticText[@name=\'Installment plan\']";
	public final String siAG_page4_Label4 = "//XCUIElementTypeStaticText[@name=\'First Payment\']";
	public final String siAG_page4_Label5 = "//XCUIElementTypeStaticText[@name=\'Total Interest Amount\']";
	public final String siAG_page4_Label6 = "//XCUIElementTypeStaticText[@name=\'Total Amount\']";
	public final String siAG_page4_Label7 = "//XCUIElementTypeStaticText[@name=\'Selected Transaction\']";
	public final String siAG_page4_Next = "//XCUIElementTypeButton[@name=\'Next\']";

	//AoplySoGood page5 - Error
	public final String siAG_page5_Error_Title = "//XCUIElementTypeStaticText[@name=\'so goood Unsuccessful\']";
	public final String siAG_page5_Error_Desc1 = "//XCUIElementTypeStaticText[@name=\'Please try again\']";
	public final String siAG_page5_BackToMain = "//XCUIElementTypeButton[@name=\'Back to Main Page\']";

	//Apply So Good page5 - Success
	public final String siAG_page5_Success_Title = "//XCUIElementTypeStaticText[@name=\'so goood Successful\']";
	public final String siAG_page5_Success_CreditCardNo = "//XCUIElementTypeStaticText[@name=\'Credit Card no.\']";
	public final String siAG_page5_Success_SelectedTransaction = "//XCUIElementTypeStaticText[@name=\'Selected Transaction']";
	public final String siAG_page5_Success_TotalInstallmentAmount = "//XCUIElementTypeStaticText[@name=\'Total Installment Amount\']";
	public final String siAG_page5_Success_InstallMentPlan = "//XCUIElementTypeStaticText[@name=\'Installment Plan\']";
	public final String siAG_page5_Success_TransactionDate = "//XCUIElementTypeStaticText[@name=\'Transaction Date\']";
	public final String siAG_page5_Success_TransactionTime = "//XCUIElementTypeStaticText[@name=\'Transaction Time\']";


	/*
	* Webview
	 */
	//Page1 Terms and condition
	public String swAP1_title = "//h1[@id=\'enter-cvv-screen-header-label\']"; //ex. so Good
	public String swAP1_title2 = "//p[contains(@class,\'so-goodstyled__HeaderBox\')]"; //About So Good
	public String swAP1_desc1 = "(//div[contains(@class, \'so-goodstyled__ContentBox\')]/span[2])[1]"; //Spend1
	public String swAP1_desc2 = "(//div[contains(@class, \'so-goodstyled__ContentBox\')]/span[2])[2]";  //Spend2
	public String swAP1_checkbox1 = "//input[contains(@class, \'CheckInput\')]";
	public String swAP1_iHaveRead = "//span[contains(@class, \'so-goodstyled__checkInputLabel\')]";
	public String swAP1_termsAndCondition = "//span[contains(@class, \'so-goodstyled__soGoodTermCondition\')]";
	public String swAP1_next = "//button[contains(@class, \'NextButton\')]";

	//Page2 Select Transaction
	public String swAP2_title = "//h1[@id=\'enter-cvv-screen-header-label\']";
	public String swAP2_imageCard = "//div[contains(@class, \'so-goodstyled__CradImage\')]";
	public String swAP2_cardName = "//div[contains(@class, \'so-goodstyled__CradNameNumberBox\')]/span[1]";
	public String swAP2_cardNumber = "//div[contains(@class, \'so-goodstyled__CradNameNumberBox\')]/span[2]";
	public String swAP2_topic1 = "//span[contains(@class, \'so-goodstyled__TopHeader\')]";
	public String swAP2_results = "//span[contains(@class, \'so-goodstyled__ResultCount\')]";
	public String swAP2_searchBox = "//div[contains(@class, \'goodstyled__SearchIconBox\')]";
	public String swAP2_searchButton = "//div[contains(@class, \'so-goodstyled__SearchIconBox\')]";
	public String swAP2_selectAll = "(//*[@id=\"cid\"]/div[1]/div)[0]";
	public String swAP2_list_transactionDates = "//span[contains(@class, \'so-goodstyled__DateText\')]";
	public String swAP2_list_transactionNames = "//*[@id=\"cid\"]/div[1]/div";
	public String swAP2_list_transactionValues = "//*[@id=\"cid\"]/div[2]/span";
	public String swAP2_next = "//button[contains(@class, \'NextButton\')]";

	//Page3 select plan
	public String swAP3_title = "//h1[@id=\'enter-cvv-screen-header-label\']";
	public String swAP3_title2 = "//span[contains(@class, \'so-goodstyled__TopHeader\')]"; //Select Installment Type
	public String swAP3_desc1 = "//span[contains(@class, \'so-goodstyled__InstallMentPlanLabel-\')]";
	public String swAP3_installmentPlans_chb = "//div[contains(@class, \'so-goodstyled__CheckedB-\')]";
	public String swAP3_list_installMmentPlans_lb = "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div/label/div[1]/span[1]";
	public String swAP3_list_monthlyPayments_lb = "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div/label/div[2]/span[2]";
	public String swAP3_list_totalInterestAmounts_lb = "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div/label/div[3]/span[2]";
	public String swAP3_list_totalAmounts_lb = "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div/label/div[4]/span[2]";
	public String swAP3_next = "//button[contains(@class, \'NextButton\')]";
	public String swAP3_MonthlyPlayment1_chb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[1]/input[1]";
	public String swAP3_MonthlyPlayment2_chb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[2]/input[1]";
	public String swAP3_MonthlyPlayment3_chb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[3]/input[1]";
	public String swAP3_MonthlyPlayment1_lb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[1]/label[1]/div[1]/span[1]";
	public String swAP3_MonthlyPlayment2_lb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[2]/label[1]/div[1]/span[1]";
	public String swAP3_MonthlyPlayment3_lb= "//form[contains(@class, \'so-goodstyled__RadioGroup\')]/div[3]/label[1]/div[1]/span[1]";

	//Page4
	public String swAP4_title = "//h1[@id=\'enter-cvv-screen-header-label\']";
	public String swAP4_title2 = "//span[contains(@class, \'so-goodstyled__TopHeader\')]";
	public String swAP4_creditCard = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[1]/span/div[1]/span[2]";
	public String swAP4_creditNumber = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[2]/span/div[1]/span[2]";
	public String swAP4_installmentPlan = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[3]/span/div[1]/span[2]";
	public String swAP4_firstPayment = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[4]/span/div[1]/span[2]";
	public String swAP4_TotalInterestPayment = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[5]/span/div[1]/span[2]";
	public String swAP4_TotalAmount = "//div[contains(@class,\'so-goodstyled__InvestmentDetailBox\')]/div[1]/ul/li[6]/span/div[1]/span[2]";
	public String swAP4_selectedTransaction_btn = "//div[contains(@class, \'so-goodstyled__TopTable-\')]/div[1]/div[2]/div[1]";
	public String swAP4_list_transactionItems = "//div[div[div[div[text()=\'Selected transaction\']]]]/div[2]/div/div[2]/div/div[1]/div";
	public String swAP4_list_transactionValues = "//div[div[div[div[text()=\'Selected transaction\']]]]/div[2]/div/div[2]/div/div[2]";
	public String swAP4_next = "//button[contains(@class, \'NextButton\')]";
	public String swAP4_back = "//*[@id=\"enter-cvv-screen-back-btn\"]/svg/path[1]";

	//page5 - finish - success
	public String swAP5_title = "//p[contains(@class, \'so-goodstyled__HeaderText\')]";
	public String swAP5_creditCardNo = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[1]/div[2]/span";//4762-81xx-xxxx-0372
	public String swAP5_selectedTransaction = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[2]/div[2]/span"; //1 item
	public String swAP5_totalInstallmentAmount = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[3]/div[2]/span";
	public String swAP5_installmentPlan = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[4]/div[2]/span";
	public String swAP5_transactionDate = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[5]/div[2]/span";
	public String swAP5_transactionTime = "//div[contains(@class, \'so-goodstyled__NewDataTable\')]/div[6]/div[2]/span";
	public String swAP5_backToMainPage = "//div[contains(@class, \'so-goodstyled__SuccessFooter\')]/button";

	public String swAP5_unSuccessfulTransaction = "//div[contains(@class, \'so-goodstyled__FailedTransaction\')]/div[1]/div[1]/";
	public String swAP5_errorDate = "//div[contains(@class, \'so-goodstyled__DateLabel\')]";// 28 May 2021
	public String swAP5_errorTransaction = "//div[contains(@class, \'so-goodstyled__ErrorTransaction\')]/div[1]/div[1]/div[1]/label/div[1]/div[1]";
	public String swAP5_errorValue = "//div[contains(@class, \'so-goodstyled__ErrorTransaction\')]/div[1]/div[1]/div[1]/label/div[2]/span[1]";

	//page5 - finish - partial

	public ApplySoGoodPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
