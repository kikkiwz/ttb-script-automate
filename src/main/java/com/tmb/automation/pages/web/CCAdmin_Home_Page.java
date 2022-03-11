package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_Home_Page extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_Home_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement in_username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement in_password;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_submit;
	
	
	@FindBy(xpath = "//span [contains(.,'CUSTOMER SEARCH')]")
	private WebElement customersearch;
	
	
	
	
	@FindBy(xpath = "//li[contains(text(),'Bank Info')]")
	private WebElement btn_Bankinfo;
	
	
	@FindBy(xpath = "//img[@class='adminBank_phraseButDiv__eJeiS']")
	private WebElement btn_creatnewbank;
	
	@FindBy(xpath = "//span[contains(.,'ADMIN')]")
	private WebElement btn_Admin;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIn_username() {
		return in_username;
	}

	public WebElement getIn_password() {
		return in_password;
	}

	public WebElement getBtn_submit() {
		return btn_submit;
	}

	public WebElement getCustomersearch() {
		return customersearch;
	}

	public WebElement getBtn_Bankinfo() {
		return btn_Bankinfo;
	}

	public WebElement getBtn_creatnewbank() {
		return btn_creatnewbank;
	}

	public WebElement getBtn_Admin() {
		return btn_Admin;
	}

	
}
