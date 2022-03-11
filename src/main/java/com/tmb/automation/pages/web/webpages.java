package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class webpages extends SeleniumLibrary {
	private WebDriver driver;

	public webpages(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// Initialise Elements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@class='btn topBtnLogin']//font)[1]")
	private WebElement login;
	@FindBy(xpath = "(//a[@class='btn topBtnOpenAccount']//font)[1]")
	private WebElement createaccount;

	@FindBy(xpath = "//a[@title='Close']")
	private WebElement close;

	@FindBy(xpath = "//a[contains(.,'Input Forms')]")
	private WebElement inputtab;

	@FindBy(xpath = "(//a[contains(text(),'Simple Form Demo')])[1]")
	private WebElement simpleinputform;

	@FindBy(xpath="//input[@id='user-message']")
	private WebElement messagebox;
	
	@FindBy(xpath="//span[@id='display']")
	private WebElement  displaytext;
	
	

	public WebElement getLogin() {
		return login;
	}

	public WebElement getCreateaccount() {
		return createaccount;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getInputtab() {
		return inputtab;
	}

	public WebElement getSimpleinputform() {
		return simpleinputform;
	}
	public WebElement getMessagebox() {
		return messagebox;
	}
	
	public WebElement getDisplaytext() {
		return displaytext;
	}
	
	
}
