package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeLoanPage extends AppiumLibrary {
	//Service page
	public final String siSV_UsageLimit_Link = "(//XCUIElementTypeStaticText[@name=\'Usage Limit\'])[1]";
	public final String siSV_GoToNativePage_Link = "(//XCUIElementTypeStaticText[@name=\'Go to Native page\'])[1]";

	public final String siSV_Loan_link= "(//XCUIElementTypeStaticText[@name=\'Loan\'])[1]";
	public final String siHL_page1_TextReference_txt = "//XCUIElementTypeTextField[@value=\'Enter Refrence Number\']";
	public final String siHL_page1_Submit_Btn = "//XCUIElementTypeButton[@name=\'Submit\']";

	//Loan page1
	public final String siHL_Loan_Title1 = "//XCUIElementTypeStaticText[@name=\'Loan\']";
	public final String siHL_Loan_Title2 = "//XCUIElementTypeStaticText[@name=\'Cash 2 Go Loan\']";
	public final String siHL_Loan_More1 = "//XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\'More\']]";

	public final String siHL_Loan_LoanDetails1 = "//XCUIElementTypeStaticText[@name=\'Loan Detail\']";
	public final String siHL_Loan_PaymentHistory1 = "//XCUIElementTypeStaticText[@name=\'Payment History\']";

	public final String siHL_Loan_AmountPaid1 = "//XCUIElementTypeStaticText[@name=\'Amount Paid\']";

	//Account > Loan - Card1
	public final String siHL_Loan_CardName = "(//XCUIElementTypeStaticText[@name=\'Cash 2 Go Loan\'])[1]";
	public final String siHL_Loan_Paid = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
//	public final String siHL_Loan_Outstanding = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	public final String siHL_Loan_PayBill = "//XCUIElementTypeOther[@name=\'Pay bill Double tabs to activate\']";
	public final String siHL_Loan_Topup = "//XCUIElementTypeOther[@name=\'Top up Double tabs to activate\']";

	//Account > Loan - Card2
	public final String siHL_Loan_card2_CardName = "(//XCUIElementTypeStaticText[@name=\'Cash 2 Go Loan\'])[2]";
	public final String siHL_Loan_card2_Paid = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	//	public final String siHL_Loan_Outstanding = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	public final String siHL_Loan_card2_PayBill = "//XCUIElementTypeOther[@name=\'Pay bill Double tabs to activate\']";
	public final String siHL_Loan_card2_Topup = "//XCUIElementTypeOther[@name=\'Top up Double tabs to activate\']";

	//Account > Loan - Card3
	public final String siHL_Loan_card3_CardName = "//XCUIElementTypeStaticText[@name=\'SME Step up\']";
	public final String siHL_Loan_card3_Paid = "(//XCUIElementTypeOther[@name=\'Paid18,426.24Outstanding2,505,447.43\'])[1]";
	//	public final String siHL_Loan_Outstanding = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	public final String siHL_Loan_card3_PayBill = "//XCUIElementTypeOther[@name=\'Pay bill Double tabs to activate\']";
	public final String siHL_Loan_card3_Topup = "//XCUIElementTypeOther[@name=\'Top up Double tabs to activate\']";

	//Account > Loan - Card4
	public final String siHL_Loan_card4_CardName = "//XCUIElementTypeStaticText[@name=\'Home Loan Refinance \']";
	public final String siHL_Loan_card4_Paid = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	//	public final String siHL_Loan_Outstanding = "(//XCUIElementTypeOther[@name=\'Paid310,582.21Outstanding120,469.24\'])[1]";
	public final String siHL_Loan_card4_PayBill = "//XCUIElementTypeOther[@name=\'Pay bill Double tabs to activate\']";
	public final String siHL_Loan_card4_Topup = "//XCUIElementTypeOther[@name=\'Top up Double tabs to activate\']";

	public HomeLoanPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
