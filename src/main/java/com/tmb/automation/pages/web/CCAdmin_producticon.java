package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_producticon extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_producticon(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//a[contains(.,'Products')]")
	private WebElement btn_product;
	
	@FindBy(xpath="//a[contains(.,'Product Icon')]")
	private WebElement btn_productIcon;
	
	
	@FindBy(xpath="//div[contains(text(),'New Product Icon')]")
	private WebElement btn_NewproductIcon;
	
	@FindBy(xpath="//button[contains(text(),'Wait for Approve')]")
	private WebElement btn_WaitForApprove;
	
	
	
	@FindBy(xpath = "//img[@class='productIcons_phraseButDiv__1dwIg']")
	private WebElement btn_createproductICON;
	
	
	@FindBy(xpath = "//input[@name='iconId']")
	private WebElement in_iconid;
	

	@FindBy(xpath = "//input[@name='iconName']")
	private WebElement in_iconname;
	
	

	@FindBy(xpath = "//textarea[@name='iconDescription']")
	private WebElement in_iconDescription;
	
	
	

	@FindBy(xpath = "//input[@name='product_logo_img']")
	private WebElement in_imglogo;
	
	
	
	
	@FindBy(xpath = "//span[@class='createProductIcon_spanDiv__3sCE6']//img")
	private WebElement img_imgUploadlogo;
	

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_iconSave;
	
	

	@FindBy(xpath = "//button[@type='button']")
	private WebElement btn_cancel;

	
	//p[contains(.,'Image Resolution must be 240 X 240 ')]
	
	

	@FindBy(xpath = "//p[contains(.,'Image Resolution must be 240 X 240 ')]")
	private WebElement tag_imageerror;
	
	@FindBy(xpath = "//span[contains(text(),'Icon ID')]")
	private WebElement txt_iconID;
	
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
	
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement btn_previous;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btn_next;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[2]")
	private WebElement btn_secondtab;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[1]")
	private WebElement btn_firsttab;
	
	
	@FindBy(id = "delete-product-icon-button")
	private WebElement btn_DeleteProductIcon;
	
	
	@FindBy(id = "edit-product-icon-button")
	private WebElement btn_EditProductIcon;
	
	@FindBy(id = "delete icon")
	private WebElement btn_bin;
	
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[3]")
	private WebElement btn_Date3;
	
	@FindBy(xpath="//input[@name='icon_id']")
	private WebElement btn_iconID;
	
	@FindBy(xpath="//input[@name='icon_name_th']")
	private WebElement btn_iconThaiName;
	
	@FindBy(xpath="//input[@name='icon_name_en']")
	private WebElement btn_iconENGName;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement btn_iconDescription;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement btn_CreateiconAddbutton;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement btn_Createiconsavebutton;
	
	
	@FindBy(xpath="//div[contains(text(),'Add new product icon')]")
	private WebElement btn_CreateiconPageverification;
	
	@FindBy(xpath="//div[contains(text(),'Edit product icon')]")
	private WebElement btn_EditiconPageverification;

	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement btn_CreateiconCancelbutton;
	
	@FindBy(xpath="//input[@name='product_logo_img']")
	private WebElement btn_CreateiconBrowsebutton;
	
	@FindBy(xpath="//span[text()='*']")
	private WebElement bstn_CreateiconRedMandatorymark;
	
	@FindBy(xpath="//div[contains(text(),'Sorry, the available picture is only 240x240 .PNG')]")
	private WebElement btn_CreateiconBrowsebuttonWrongformat;
	

	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement btn_CreateShrortcutCancelbutton;
	
	
	@FindBy(xpath="(//table[@id='currentProductIconTable']/tr/td[1])[1]")
	private WebElement btn_WaitForApprove_iconID;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div")
	private WebElement btn_Sorting;
	

	
	public WebElement getbtn_CreateiconPageverification() {
		return btn_CreateiconPageverification;
	}
	
	public WebElement getbtn_EditiconPageverification() {
		return btn_EditiconPageverification;
	}
	public WebElement getBtn_CreateShrortcutRedMandatorymark() {
		return bstn_CreateiconRedMandatorymark;
	}
	
	public WebElement getbtn_Sorting() {
		return btn_Sorting;
	}
	
	public WebElement getbtn_bin() {
		return btn_bin;
	}
	
	
	public WebElement getBtn_CreateIconBrowsebuttonWrongformat() {
		return btn_CreateiconBrowsebuttonWrongformat;
	}
	
	public WebElement getbtn_CreateiconAddbutton() {
		return btn_CreateiconAddbutton;
	}
	
	public WebElement getbtn_Createiconsavebutton() {
		return btn_Createiconsavebutton;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getbtn_next() {
		return btn_next;
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
	
	public WebElement getbtn_firsttab() {
		return btn_firsttab;
	}
	
	public WebElement getbtn_secondtab() {
		return btn_secondtab;
	}
	
	public WebElement getbtn_previous() {
		return btn_previous;
	}


	public WebElement getBtn_product() {
		return btn_product;
	}
	
	public WebElement getbtn_DeleteProductIcon() {
		return btn_DeleteProductIcon;
	}
	public WebElement getbtn_EditProductIcon() {
		return btn_EditProductIcon;
	}
	
	public WebElement gettxt_iconID() {
		return txt_iconID;
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
	
	public WebElement getbtn_NewproductIcon() {
		return btn_NewproductIcon;
	}
	public WebElement getbtn_WaitForApprove() {
		return btn_WaitForApprove;
	}
	
	public WebElement getbtn_WaitForApprove_IconID() {
		return btn_WaitForApprove_iconID;
	}



	public WebElement getBtn_productIcon() {
		return btn_productIcon;
	}



	public WebElement getBtn_createproductICON() {
		return btn_createproductICON;
	}



	public WebElement getIn_iconid() {
		return in_iconid;
	}



	public WebElement getIn_iconname() {
		return in_iconname;
	}



	public WebElement getIn_iconDescription() {
		return in_iconDescription;
	}



	public WebElement getIn_imglogo() {
		return in_imglogo;
	}



	public WebElement getBtn_iconSave() {
		return btn_iconSave;
	}



	public WebElement getBtn_cancel() {
		return btn_cancel;
	}



	public WebElement getImg_imgUploadlogo() {
		return img_imgUploadlogo;
	}



	public WebElement getTag_imageerror() {
		return tag_imageerror;
	}
	
	public WebElement getBtn_iconID() {
		return btn_iconID;
	}
	public WebElement getBtn_iconThaiName() {
		return btn_iconThaiName;
	}
	public WebElement getBtn_iconENGName() {
		return btn_iconENGName;
	}
	public WebElement getBtn_iconDescription() {
		return btn_iconDescription;
	}
	
	
	
	public WebElement getBtn_CreateShrortcutCancelbutton() {
		return btn_CreateShrortcutCancelbutton;
	}
	public WebElement getBtn_CreateIconBrowsebutton() {
		return btn_CreateiconBrowsebutton;
	}
	
	
	
}