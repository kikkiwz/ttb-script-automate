package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_CreateProductShortcut extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_CreateProductShortcut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(xpath="//button[contains(text(),'Wait for Approve')]")
	private WebElement btn_WaitForApprove;
	
	@FindBy(xpath = "//a[contains(.,'Products')]")
	private WebElement btn_product;
	
	@FindBy(xpath="//li[@id='product-shortcut']")
	private WebElement btn_CreateProductShortcut;

	@FindBy(xpath="//button[text()='Save']")
	private WebElement btn_EditShrortcutsavebutton;

	@FindBy(xpath="(//div[@data-testid='column'])[2]/div")
	private WebElement btn_EditShrortcutbinbutton;
	
	
	@FindBy(xpath="//a[@id='edit-product-shortcut-button']")
	private WebElement btn_EditProductShortcut;
	
	@FindBy(xpath="//button[@id='new-product-button']")
	private WebElement btn_newproductshortcut;
	
	@FindBy(xpath="//input[@name='shortcut_id']")
	private WebElement btn_ShortcutID;
	
	@FindBy(xpath="//input[@name='shortcut_name_th']")
	private WebElement btn_ShortcutThaiName;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement btn_previous;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btn_next;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[2]")
	private WebElement btn_secondtab;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[1]")
	private WebElement btn_firsttab;
	
	@FindBy(xpath="//input[@name='shortcut_name_en']")
	private WebElement btn_ShortcutENGName;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement btn_ShortcutDescription;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement btn_CreateShrortcutAddbutton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement btn_CreateShrortcutCancelbutton;
	
	@FindBy(xpath="//input[@id='files']")
	private WebElement btn_CreateShrortcutBrowsebutton;
	
	@FindBy(xpath="//span[text()='*']")
	private WebElement bstn_CreateShrortcutRedMandatorymark;
	
	@FindBy(xpath="//div[contains(text(),'This image is not right')]")
	private WebElement btn_CreateShrortcutBrowsebuttonWrongformat;
	
	@FindBy(xpath = "//span[contains(text(),'Shortcut ID')]")
	private WebElement txt_shortcutID;
	
	@FindBy(xpath = "//span[contains(text(),'Name EN')]")
	private WebElement txt_Name_EN;
	
	
	@FindBy(xpath = "//span[contains(text(),'Name TH')]")
	private WebElement txt_Name_TH;
	
	
	@FindBy(xpath = "//span[contains(text(),'Description')]")
	private WebElement txt_Description;
	
	
	@FindBy(xpath = "//span[contains(text(),'Design')]")
	private WebElement txt_Design;
	
	
	@FindBy(xpath = "//span[contains(text(),'Last Update')]")
	private WebElement txt_Last_Update;
	
	
	@FindBy(xpath = "//span[contains(text(),'Update By')]")
	private WebElement txt_Update_By;
	
	
	@FindBy(xpath = "//span[contains(text(),'Status')]")
	private WebElement txt_Status;
	
	@FindBy(id = "delete-product-shortcut-button")
	private WebElement btn_DeleteProductShortcut;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[3]")
	private WebElement btn_Date3;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div")
	private WebElement btn_Sorting;
	
	@FindBy(xpath = "//p[contains(.,'shortcut English name should not be more than 100 characters')]")
	private WebElement MoreEngChar;
	
	@FindBy(xpath = "//p[contains(.,'shortcut Thai name should not be more than 100 characters')]")
	private WebElement MoreThaiChar;
	
	@FindBy(xpath = "//p[contains(.,'shortcut description should not be more than 255 characters')]")
	private WebElement MoreDescChar;
	
	@FindBy(xpath = "(//table[@id='updatedProductShortcutTable']/tbody/tr/td[1])[1]")
	private WebElement btn_WaitForApprove_ShortcutID;
	
	@FindBy(xpath="(//div[contains(text(),'Back to product shortcut list')])[2]")
	private WebElement btn_BackProductShortcut;
	
	
	public WebElement getbtn_BackProductShortcut() {
		return btn_BackProductShortcut;
	}
	
	public WebElement MoreEngCharError() {
		return MoreEngChar;
	}
	
	public WebElement btn_WaitForApprove_ShortcutIDtext() {
		return btn_WaitForApprove_ShortcutID;
	}
	public WebElement MoreThaiCharError() {
		return MoreThaiChar;
	}
	
	public WebElement MoreDescCharError() {
		return MoreDescChar;
	}
	
	public WebElement getBtn_Date1() {
		return btn_Date1;
	}
	public WebElement getBtn_Date2() {
		return btn_Date2;
	}
	
	public WebElement getBtn_Date3() {
		return btn_Date3;
	}
	
	
	public WebElement getbtn_Sorting() {
		return btn_Sorting;
	}
	
		
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getBtn_EditProductShortcut() {
		return btn_EditProductShortcut;
	}
	public WebElement getBtn_CreateShrortcutRedMandatorymark() {
		return bstn_CreateShrortcutRedMandatorymark;
	}
	public WebElement getBtn_EditShrortcutsavebutton() {
		return btn_EditShrortcutsavebutton;
	}
	
	public WebElement getbtn_DeleteProductShortcut() {
		return btn_DeleteProductShortcut;
	}
	
	public WebElement getBtn_EditShrortcutbinbutton() {
		return btn_EditShrortcutbinbutton;
	}
	
	public WebElement getBtn_CreateShrortcutBrowsebuttonWrongformat() {
		return btn_CreateShrortcutBrowsebuttonWrongformat;
	}
		
	public WebElement getBtn_CreateProductShortcut() {
		return btn_CreateProductShortcut;
	}
	
	public WebElement getBtn_newproductshortcut() {
		return btn_newproductshortcut;
	}
	
	public WebElement getbtn_next() {
		return btn_next;
	}
	public WebElement getBtn_product() {
		return btn_product;
	}
	public WebElement getbtn_firsttab() {
		return btn_firsttab;
	}
	
	public WebElement getbtn_secondtab() {
		return btn_secondtab;
	}
	
	public WebElement getbtn_previous() {
		return btn_previous;
	}

	public WebElement getbtn_WaitForApprove() {
		return btn_WaitForApprove;
	}
	
	public WebElement getBtn_ShortcutID() {
		return btn_ShortcutID;
	}
	public WebElement getBtn_ShortcutThaiName() {
		return btn_ShortcutThaiName;
	}
	public WebElement getBtn_ShortcutENGName() {
		return btn_ShortcutENGName;
	}
	public WebElement getBtn_ShortcutDescription() {
		return btn_ShortcutDescription;
	}
	
	public WebElement getBtn_CreateShrortcutAddbutton() {
		return btn_CreateShrortcutAddbutton;
	}
	
	public WebElement getBtn_CreateShrortcutCancelbutton() {
		return btn_CreateShrortcutCancelbutton;
	}
	public WebElement getBtn_CreateShrortcutBrowsebutton() {
		return btn_CreateShrortcutBrowsebutton;
	}
	
	public WebElement gettxt_ShortcutID() {
		return txt_shortcutID;
	}
	public WebElement gettxt_Name_EN() {
		return txt_Name_EN;
	}
	public WebElement gettxt_Name_TH() {
		return txt_Name_TH;
	}
	public WebElement gettxt_Description() {
		return txt_Description;
	}
	public WebElement gettxt_Design() {
		return txt_Design;
	}
	public WebElement gettxt_Last_Update() {
		return txt_Last_Update;
	}
	public WebElement gettxt_Update_By() {
		return txt_Update_By;
	}
	public WebElement gettxt_Status() {
		return txt_Status;
	}

	
	



	


	





	
	
	
}