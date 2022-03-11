package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_ReviewMange_page extends SeleniumLibrary{

	private WebDriver driver;
	
	
	public CCAdmin_ReviewMange_page(WebDriver driver)  {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement in_username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement in_password;
	
	
}
