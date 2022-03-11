package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends AppiumLibrary {

	//Homescreen
//	public final String siAS_Card_btn = "//XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Card\']]/XCUIElementTypeStaticText[1]";
	public final String siAS_Card_btn = "(//XCUIElementTypeStaticText[@name=\'Card\'])[1]";
	public final String siAS_Card_SoFastCreditCard_lb = "//XCUIElementTypeStaticText[@name=\"So Fast Credit Card\"]";
	public final String siAS_Card_BlackDiamond = "(//XCUIElementTypeCell//XCUIElementTypeStaticText[@name=\'Black Diamond\'])[1]";

	//Loan tab
	public final String siAS_Loan_btn = "(//XCUIElementTypeStaticText[@name=\'Loan\'])[1]";
	public final String siAS_Loan_Card1 = "";
	public final String siAS_Loan_Card2 = "";
	public final String siAS_Loan_Card3 = "";

	//click card sline number2
	public final String siAS_Card2 = "//XCUIElementTypeStaticText[@name=\'So Fast Credit Card\']";
	public final String siAS_Card1 = "//XCUIElementTypeStaticText[@name=\"ABSOLUTE Credit Card\"])[1]";
	public final String siAS_AvailableSpent1 = "(//XCUIElementTypeStaticText[@name=\'Available to spend\'])[1]";
	public final String siAS_AmountSpent1 = "(//XCUIElementTypeStaticText[@name=\'Amount spent\'])[1]";
	public final String siAS_More1 = "(//XCUIElementTypeStaticText[@name=\'More\'])[1]";
	public final String siAS_SetPin1 = "(//XCUIElementTypeStaticText[@name=\'Set pin\'])[1]";

	public final String siAS_Title1 = "//XCUIElementTypeOther[@name=\'My Credit Card\']";
	public final String siAS_Card1_image = "(//XCUIElementTypeImage)[1]";
	public final String siAS_Card1_CardName = "(//XCUIElementTypeCell)[1]";
	public final String siAS_Card1_CardID = "//XCUIElementTypeStaticText[@name=\'4762-81xx-xxxx-0372\']";
	public final String siAS_Card1_AmountSpent = "(//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Amount spent\']]]]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	public final String siAS_Card1_AvailableSpend ="(//XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'Amount spent\']]]]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeStaticText)[2]";
	public final String siAS_Card1_CreditLimit = "";
	public final String siAS_Card1_RedeemPoint = "";
	public final String siAS_Card1_CashForYou = "";
	public final String siAS_Card1_ApplySoGood = "";
	public final String siAS_Card1_More = "(//XCUIElementTypeStaticText[@name=\'More\'])[1]";

	public final String siAS_Title2 = "//XCUIElementTypeOther[@name=\'My Credit Card\']";
	public final String siAS_Card2_image = "(//XCUIElementTypeImage)[1]";
	public final String siAS_Card2_CardName = "//XCUIElementTypeStaticText[@name=\'ABSOLUTE Credit Card\']";
	public final String siAS_Card2_CardID = "";
	public final String siAS_Card2_AmountSpent = "";
	public final String siAS_Card2_AvailableSpend ="";
	public final String siAS_Card2_CreditLimit = "";
	public final String siAS_Card2_RedeemPoint = "";
	public final String siAS_Card2_CashForYou = "";
	public final String siAS_Card2_ApplySoGood = "";
	public final String siAS_Card2_More = "(//XCUIElementTypeStaticText[@name=\'More\'])[2]";
	//Mainfeatures
	public final String siAS_Card2_MainFeatures = "//XCUIElementTypeStaticText[@name=\'Main Features\' ]";
	public final String siAS_Card2_More_RedeemPoint = "(//XCUIElementTypeStaticText[@name=\'Redeem point\'])[5]";
	public final String siAS_Card2_More_CashForYou = "(//XCUIElementTypeStaticText[@name=\'Cash for you\'])[5]";
	public final String siAS_Card2_More_ApplySoGood = "(//XCUIElementTypeStaticText[@name=\'Apply So GooOD\'])[5]";
	public final String siAS_Card2_More_CardDetails = "//XCUIElementTypeStaticText[@name=\'Card details\']";
	public final String siAS_Card2_More_BillPayment = "//XCUIElementTypeStaticText[@name=\'Bill payment\']";
	public final String siAS_Card2_More_Topup = "//XCUIElementTypeStaticText[@name=\'Top-up\']";
	public final String siAS_Card2_More_Paybill = "//XCUIElementTypeStaticText[@name=\'Pay bill\']";
	public final String siAS_Card2_More_ManageCard = "//XCUIElementTypeStaticText[@name=\'Manage Card\']";
	public final String siAS_Card2_More_AdjustUsageLimit = "//XCUIElementTypeStaticText[@name=\'Adjust usage limit\']";
	public final String siAS_Card2_More_ApplyEStatement = "//XCUIElementTypeStaticText[@name=\'Apply e-statement\']";
	public final String siAS_Card2_More_SetPin = "//XCUIElementTypeStaticText[@name=\'Set pin\']";
	public final String siAS_Card2_More_BlockCard = "//XCUIElementTypeStaticText[@name=\'Block card\']";

	public final String siAS_Title3 = "//XCUIElementTypeOther[@name=\'My Credit Card\']";
	public final String siAS_AvailableSpent2 = "(//XCUIElementTypeStaticText[@name=\'Available to spend\'])[2]";
	public final String siAS_AmountSpent2 = "(//XCUIElementTypeStaticText[@name=\'Amount spent\'])[2]";
	public final String siAS_Card3_More = "(//XCUIElementTypeStaticText[@name=\'More\'])[3]";
//	public final String siAS_Card3_More_SetPin = "(//XCUIElementTypeStaticText[@name=\'Set pin\'])[3]";

	public final String siAS_Card_Billed = "//XCUIElementTypeStaticText[@name=\'Billed\']";
	public final String siAS_Card_Unbilled = "//XCUIElementTypeStaticText[@name=\'Unbilled\']";
	public final String siAS_Card_Billed_Period1 = "//XCUIElementTypeStaticText[@name=\'June 2022\']";
	public final String siAS_Card_Billed_Period2 = "//XCUIElementTypeStaticText[@name=\'May 22\']";
	public final String siAS_Card_Billed_ok = "//XCUIElementTypeButton[@name=\'OK\']";
	public final String siAS_Card_Billed_Download = "//XCUIElementTypeButton[@name=\'Download Document\']";
	public final String siAS_Card_Billed_UpperButton = "(//XCUIElementTypeButton[@type=\'XCUIElementTypeButton\'])[1]";

	public final String siAS_SetATMPin_1 = "//XCUIElementTypeButton[@name=\'1\']";
	public final String siAS_SetATMPin_2 = "//XCUIElementTypeButton[@name=\'2\']";
	public final String siAS_SetATMPin_3 = "//XCUIElementTypeButton[@name=\'3\']";
	public final String siAS_SetATMPin_4 = "//XCUIElementTypeButton[@name=\'4\']";
	public final String siAS_SetATMPin_5 = "//XCUIElementTypeButton[@name=\'5\']";
	public final String siAS_SetATMPin_6 = "//XCUIElementTypeButton[@name=\'6\']";
	public final String siAS_SetATMPin_7 = "//XCUIElementTypeButton[@name=\'7\']";
	public final String siAS_SetATMPin_8 = "//XCUIElementTypeButton[@name=\'8\']";
	public final String siAS_SetATMPin_9 = "//XCUIElementTypeButton[@name=\'9\']";
	public final String siAS_SetATMPin_0 = "//XCUIElementTypeButton[@name=\'0\']";

	//set ATM PIN
	public final String siAS_SetATMPin_Title = "//XCUIElementTypeStaticText[@name=\'Set ATM PIN\']";
	public final String siAS_SetATMPin_Description = "//XCUIElementTypeStaticText[@name=\'Please Set up your 4-digits PIN\']";
	public final String siAS_SetATMPin_msg = "//XCUIElementTypeStaticText[@name=\'Confirm ATM PIN\']";
	public final String siAS_SetATMPin_Error1 = "//XCUIElementTypeStaticText[@name=\'ATM PIN does not match, Please try again\']";

	public final String siAS_SetATMPin_Complete_Title = "//XCUIElementTypeStaticText[@name=\'Complete\']";
	public final String siAS_SetATMPin_Complete_Description1 = "//XCUIElementTypeStaticText[@name=\'Card Number\']";
	public final String siAS_SetATMPin_Complete_Description2 = "//XCUIElementTypeStaticText[@name=\'PIN has been changed\']";
	public final String siAS_SetATMPin_Complete_BackToMain_Btn = "//XCUIElementTypeButton[@name=\'Back to Main Page\']";

	public final String siCF_PIN_1 = "//XCUIElementTypeStaticText[@name=\'1\']";
	public final String siCF_PIN_2 = "//XCUIElementTypeStaticText[@name=\'2\']";
	public final String siCF_PIN_3 = "//XCUIElementTypeStaticText[@name=\'3\']";
	public final String siCF_PIN_4 = "//XCUIElementTypeStaticText[@name=\'4\']";
	public final String siCF_PIN_5 = "//XCUIElementTypeStaticText[@name=\'5\']";
	public final String siCF_PIN_6 = "//XCUIElementTypeStaticText[@name=\'6\']";
	public final String siCF_PIN_7 = "//XCUIElementTypeStaticText[@name=\'7\']";
	public final String siCF_PIN_8 = "//XCUIElementTypeStaticText[@name=\'8\']";
	public final String siCF_PIN_9 = "//XCUIElementTypeStaticText[@name=\'9\']";
	public final String siCF_PIN_0 = "//XCUIElementTypeStaticText[@name=\'0\']";

	public AccountSummaryPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
