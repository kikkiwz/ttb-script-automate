package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BlockCardPage extends AppiumLibrary {
	
	public final String swDC_BlockCard_btn = "//span[text()=\'Block Credit Card\']";
	
	//Enter Refrence Number page
	public final String swLbLD_EnterReferenceNumber = "//h1[@id=\'refrence-number-header-label\']";
	public final String swTxtLD_EnterReferenceNumber = "//input[@id=\'refrence-number-text-box\']";
	public final String swBtnLD_EnterRefrenceNumber_Submit = "//div[contains(@class, \'activate-cardstyled__CompleteBottomBox\')]/button";
	public final String swLbLD_ErrMsg = "//div[contains(@class, \'activate-cardstyled__CardEnterMiddleContainer\')]/span";
	
	//Block Card page
	
	public final String swLbBC_Title = "//div[contains(@class, \'sc-hlTvYk bkPOGA\')]/h1";
	
	public final String swLbBC_Desc1 = "//div[contains(@class, \'block-cardstyled__MiddleContainer\')]/span";
	
	public final String swLbBC_Desc2 = "//div[contains(@class, \'block-cardstyled__MiddleContainer\')]/ul";
	public final String swLbBC_Desc3 = "//div[contains(@class, \'block-cardstyled__MiddleContainer\')]/span[2]";
	public final String swLbBC_Address = "//div[contains(@class, \'block-cardstyled__AddressBox\')]/div/p";
	public final String swLbBC_Info = "//p[contains(@class, \'block-cardstyled__SmallInfo\')]";
	public final String swBtnBC_Confirm = "//div[contains(@class, \'block-cardstyled__BottomContainer\')]/button";
	
	//Finish block card
	
	//completed
	public final String swLbBC_FinishComplete_Title = "//div[contains(@class, \'block-cardstyled__TextDesc-\')]/p";
	public final String swLbBC_FinishComplete_Desc1 = "//div[contains(@class, \'block-cardstyled__TextDesc-\')]/div/div[1]";
	public final String swLbBC_FinishComplete_Desc2 = "//div[contains(@class, \'block-cardstyled__ContentSuccess\')]/div/div[2]";
	public final String swLbBC_FinishComplete_TransactionDate = "//div[contains(@class, \'block-cardstyled__DetailDesc\')]/div[1]/ul[1]/li[1]/span[2]/span";
	public final String swLbBC_FinishComplete_TransactionTime = "//div[contains(@class, \'block-cardstyled__DetailDesc\')]/div[1]/ul[1]/li[2]/span[2]/span";

	//failed
	public final String swLbBC_Finish_Title = "//div[contains(@class, \'block-cardstyled__TextDesc\')]/p"; //Unable to Complete
	public final String swLbBC_Finish_BacktoMainPage = "//div[contains(@class, \'block-cardstyled__Footer\')]/button";
	
	public BlockCardPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		alertAction("accept");
	}
}
