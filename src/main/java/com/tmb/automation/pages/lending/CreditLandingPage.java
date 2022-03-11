package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreditLandingPage extends AppiumLibrary {
	
	//Homescreen
	public final String swImgHS_Robot = "//img[@id=\'home-screen-robot-image\']";
	public final String saHS_Discovery_btn = "//android.widget.FrameLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/navigation_profile\']";
	public final String siHS_Discovery_btn = "//XCUIElementTypeOther[@name=\'FooterMenu4\']";
	//Discover page
	public final String swDisc_ActivateCard_btn = "//span[text()=\'Activate Card\']";
	//Enter Refrence Number page
	public final String swImgCL_CreditCardImage = "";

	//Webview
	public final String swCL_applySoGood1 = "(//p[text()=\'Apply So GooOD\'])[1]";
	public final String swCL_list_accountNumber = "//p[@id=\"account-number\"]";
	public final String swCL_list_cardName = "//span[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div[1]/div/span";
	public final String swCL_list_amountSpent = "//p[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/ul[1]/li[2]/p[1]";
	public final String swCL_list_availableToSpend = "//*[@id=\"ledger-balance-value\"]";
	public final String swCL_list_creditLimit = "//p[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/p";
	public final String swCL_list_applySoGood = "//p[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/ul[2]/li[3]/p";

	public String swCL_plus_btn = "//div[contains(@class, \"creditstyled__IconPlusDiv\")]/button";

	public CreditLandingPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
