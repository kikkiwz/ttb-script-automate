package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class editbank_info_page extends SeleniumLibrary{

	private WebDriver driver;
	
	
	public editbank_info_page(WebDriver driver)  {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//th[@title='Toggle SortBy'][contains(.,'Bank Code')]")
	private WebElement sort_bankcode;
	
	@FindBy(xpath = "//th[@title='Toggle SortBy'][contains(.,'Display Order')]")
	private WebElement sort_displayorder;
	
	@FindBy(xpath = "//input[@name='bank_shortname']")
	private WebElement in_Bankshortname;
	
	@FindBy(xpath = "//input[@name='bank_name_en']")
	private WebElement in_banknameEN;
	
	@FindBy(xpath = "//input[@name='bank_acct_length']")
	private WebElement in_Accountlength;
	
	
	@FindBy(xpath = "//input[@name='display_order']")
	private WebElement in_displayorder;
	
	@FindBy(xpath = "//button[@label='SAVE']")
	private WebElement btn_savebank;
	
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement in_password;
	
	
	public WebElement getSort_bankcode() {
		return sort_bankcode;
	}


	public WebElement getIn_Bankshortname() {
		return in_Bankshortname;
	}


	public WebElement getIn_banknameEN() {
		return in_banknameEN;
	}


	public WebElement getIn_Accountlength() {
		return in_Accountlength;
	}


	public WebElement getIn_displayorder() {
		return in_displayorder;
	}
	
	public WebElement getbtn_savebank() {
		return btn_savebank;
	}



	
	
	
}
	
