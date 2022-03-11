package com.tmb.automation.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_ProductTermsandConditions extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_ProductTermsandConditions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	
	@FindBy(id = "admin-terms-product")
	private WebElement btn_product_TermsandCondition;
	
	@FindBy(id = "productName")
	private WebElement textproduct_Name;
	
	@FindBy(xpath = "(//table[@id='updatedProductsTermsAndConditionsTable']/tbody/tr/td[2])[1]")
	private WebElement btn_WaitApproveKey;
	
	@FindBy(id = "productTCId")
	private WebElement textproduct_TCID;
	
	@FindBy(id = "productDescription")
	private WebElement textproduct_Description;
	
	@FindBy(id = "channel")
	private WebElement ProductChannel;
	

	@FindBy(id = "product-tc-thai-version")
	private WebElement Content_Thai;
	
	@FindBy(id = "product-tc-eng-version")
	private WebElement Content_Eng;
	
	@FindBy(xpath = "//button[text()='Browse']")
	private WebElement Browse_button;
	
	@FindBy(xpath = "//div[@id=\"productCode\"]/div/div[1]")
	private WebElement text_productcode;
	
	
	@FindBy(xpath = "//div[text()='New Product T&C']")
	private WebElement btn_newproduct_TermsandCondition;
	
	@FindBy(xpath = "//div[contains(text(),'Sorry, the available file is only PDF and Maximum 3 MB')]")
	private WebElement btn_pdf_3MB_error;
	
	@FindBy(xpath = "//div[text()='Terms_and_Conditions.pdf']")
	private WebElement getUploaded;
	
	@FindBy(xpath = "//div[contains(text(),'Sorry, file name is not properly formatted. Standard names may contain letters a-z, A-Z, 0-9, _ . -')]")
	private WebElement btn_pdf_40_character;
	
	@FindBy(xpath = "//div[@aria-label='Rich Text Editor, main']")
	private WebElement text_rich_text_Editor;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement Save_button;
	
	@FindBy(xpath="//span[text()='Product Terms and Conditions is Approved successfully.']")
	private WebElement text_ApprovepopupTermsandConditions;
	
	@FindBy(xpath="//div[text()='Back to Product Terms and Conditions list']")
	private WebElement btn_BackTermsandCondition;
	
		
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSave_button() {
		return Save_button;
	}
	public WebElement getBrowse_button() {
		return Browse_button;
	}
	public WebElement gettext_rich_text_Editor() {
		return text_rich_text_Editor;
	}
	public WebElement btngetUploaded() {
		return getUploaded;
	}
	public WebElement getbtn_pdf_3MB_error() {
		return btn_pdf_3MB_error;
	}
	public WebElement getbtn_WaitApproveKey() {
		return btn_WaitApproveKey;
	}
	public WebElement getbtn_pdf_40_character() {
		return btn_pdf_40_character;
	}
	public WebElement getBtn_newproduct_TermsandCondition() {
		return btn_newproduct_TermsandCondition;
	}
	public WebElement gettextproduct_Description() {
		return textproduct_Description;
	}
	public WebElement getContent_Thai() {
		return Content_Thai;
	}
	public WebElement getContent_Eng() {
		return Content_Eng;
	}
	public WebElement gettext_ApprovepopupTermsandCond() {
		return text_ApprovepopupTermsandConditions;
	}
	public WebElement getProductChannel() {
		return ProductChannel;
	}
	public WebElement gettextproduct_Name() {
		return textproduct_Name;
	}
	public WebElement gettextproduct_TCID() {
		return textproduct_TCID;
	}
	public WebElement getBtn_product_TermsandCondition() {
		return btn_product_TermsandCondition;
	}
	public WebElement gettext_productcode() {
		return text_productcode;
	}
	public WebElement getbtn_BackTermsandCondition() {
		return btn_BackTermsandCondition;
	}
	
	
	
	
			}

	
	



	


	





	
	
	
