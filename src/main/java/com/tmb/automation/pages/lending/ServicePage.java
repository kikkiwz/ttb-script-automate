package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ServicePage extends AppiumLibrary {
	//Webview
	public String swSV_goToNativePage = "(//span[text()=\'Go to Native page\'])[1]";
	public String swSV_applySoGood = "//span[text()=\'apply so good\']";
	public String swSV_usageLimit = "//span[text()=\'Usage Limit\']";
	public String swSV_blockCreditCard = "//span[text()=\'Block Credit Card\']";
	public String swSV_workingInformation = "//span[text()=\'Working Information\']";
	public String swSV_PersonalInformation = "//span[text()=\'Personal Information\']";
	public String swSV_editAddress = "//span[text()=\'Edit Address\']";
	public String swSV_Loan = "//span[text()=\'Loan\']";
	public String swSV_letterOfConsent = "//span[text()=\'Letter Of Consent\']";
	public String swSV_flexiLoanTermAndConditions = "//span[text()=\'flexi loan terms and conditions\']";
	public String swSV_flexiLoan = "(//span[text()=\'Flexi Loan\'])[1]";
	public String swSV_showContactList = "//span[text()=\'Show contact list\']";

	public ServicePage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
