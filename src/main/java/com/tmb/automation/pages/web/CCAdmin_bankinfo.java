package com.tmb.automation.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_bankinfo extends SeleniumLibrary{

	private WebDriver driver;
	
	
	public CCAdmin_bankinfo(WebDriver driver)  {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

	
	@FindBy(xpath = "//span[contains(text(),'New Bank Info')]")
	private WebElement btn_Bankinfo;
	
	@FindBy(xpath = "//span[contains(text(),'Order No.')]")
	private WebElement btn_orderNumber;
	
	@FindBy(xpath = "//span[contains(text(),'Bank Code')]")
	private WebElement btn_BankCode;
	
	@FindBy(xpath = "//span[contains(text(),'Short name')]")
	private WebElement btn_Shortname;
	
	@FindBy(xpath = "//span[contains(text(),'Name TH')]")
	private WebElement btn_nameTH;
	
	@FindBy(xpath = "//span[contains(text(),'Name EN')]")
	private WebElement btn_nameEN;
	
	@FindBy(xpath = "//span[contains(text(),'Logo')]")
	private WebElement btn_Logo;
	
	@FindBy(xpath = "//tr[@role='row']/td[7]")
	private List<WebElement> current_bankStatus;
	
	@FindBy(xpath = "//tr[@role='row']/td[11]")
	private List<WebElement> current_Status;
	
	@FindBy(xpath = "//span[contains(text(),'Bank Status')]")
	private WebElement btn_BankStatus;
	
	@FindBy(xpath = "//span[contains(text(),'Promptpay Status')]")
	private WebElement btn_Promptpaystatus;
	
	@FindBy(xpath = "//span[contains(text(),'Last Update')]")
	private WebElement btn_lastupdate;
	
	@FindBy(xpath = "//span[contains(text(),'Update By')]")
	private WebElement btn_updateby;
	
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement btn_status;
	
	@FindBy(xpath = "//span[contains(text(),'New Bank')]")
	private WebElement btn_newBank;
	
	@FindBy(xpath = "//div[contains(text(),'New Bank')]")
	private WebElement btn_newCreateBank;
	
	@FindBy(id = "edit-bank-info-button")
	private WebElement btn_editbankinfo;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit / Add Bank Information')]")
	private WebElement txt_Edit_Add_Bankinfo;
	
	@FindBy(xpath = "//p[contains(text(),'Duplicate bank code, Please try another one')]")
	private List<WebElement> txt_BankCode_Duplicate_Error_msg;
	
	
	@FindBy(xpath = "//div[contains(text(),'< Back to Bank Information  list')]")
	private WebElement txt_back_to_dashboard;
	
	@FindBy(xpath = "//p[contains(text(),'This field is required')]")
	private WebElement txt_EmptyErrormsg;
	
	
	@FindBy(xpath = "//img[@class='adminBank_phraseButDiv__eJeiS']")
	private WebElement btn_creatnewbank;
	
	@FindBy(xpath = "//input[@name='bank_cd']")
	private WebElement in_bankcd;
	
	
	@FindBy(xpath = "//input[@name='bank_shortname']")
	private WebElement in_bankShortname;
	
	
	@FindBy(xpath = "//input[@name='bank_name_en']")
	private WebElement in_banknameEN;
	
	
	@FindBy(xpath = "//input[@name='bank_name_th']")
	private WebElement in_banknameTH;
	
	
	@FindBy(id = "bank_status")
	private WebElement in_bankStatus;
	
	@FindBy(xpath = "//input[@name='bank_acct_length']")
	private WebElement in_Accountlength;
	
	@FindBy(xpath = "//input[@name='display_order']")
	private WebElement in_displayorder;
	
	@FindBy(xpath = "//input[@name='bank_logo_file']")
	private WebElement upload_chosebanklogo;
	
	@FindBy(xpath = "//div[text()='This image is not right format, Please try again']")
	private WebElement upload_chosebanklogoErrormsg;
	
	
	@FindBy(xpath = "//button[@label='Upload']")
	private WebElement btn_uploadbanklogo;
	
	@FindBy(id = "promptpay_status")
	private WebElement sel_promptpayStatus;
	
	@FindBy(xpath="(//tr[@role='row']/td[9])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[1])[1]")
	private WebElement btn_DisplayOrder1;
	
	@FindBy(xpath="(//tr[@role='row']/td[1])[2]")
	private WebElement btn_DisplayOrder2;
	
	
	@FindBy(xpath="(//tr[@role='row']/td[1])[3]")
	private WebElement btn_DisplayOrder3;
	
	@FindBy(xpath="(//tr[@role='row']/td[9])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[9])[3]")
	private WebElement btn_Date3;
	
	
	@FindBy(xpath = "//span[contains(.,'Effective Date')]/../div")
	private WebElement in_Effectivedate;
	
	@FindBy(xpath = "//span[contains(.,'Expire Date')]/../div")
	private WebElement in_Expiredate;
	
	@FindBy(xpath = "//div[@class='react-datepicker__week']/div")
	private List<WebElement> in_date_promptpay;
	
		
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btn_savebank;

	
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]")
	private WebElement txt_EffectiveDate;

	
	@FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[2]")
	private WebElement txt_ExpireDate;


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement gettxt_Edit_Add_Bankinfo() {
		return txt_Edit_Add_Bankinfo;
	}
	
	public List<WebElement> gettxt_BankCode_Duplicate_Error_msg() {
		return txt_BankCode_Duplicate_Error_msg;
	}
	
	public WebElement getBtn_Bankinfo() {
		return btn_Bankinfo;
	}
	
	public WebElement getbtn_orderNumber() {
		return btn_orderNumber;
	}
	
	
	public WebElement gettxt_back_to_dashboard() {
		return txt_back_to_dashboard;
	}
	
	public WebElement getin_bankStatus() {
		return in_bankStatus;
	}
	public WebElement getbtn_newCreateBank() {
		return btn_newCreateBank;
	}
	
	public WebElement gettxt_EmptyErrormsg() {
		return txt_EmptyErrormsg;
	}
	
	
	public WebElement getupload_chosebanklogoErrormsg() {
		return upload_chosebanklogoErrormsg;
	}
	
	public WebElement getbtn_BankCode() {
		return btn_BankCode;
	}
	
	public WebElement getbtn_DisplayOrder1() {
		return btn_DisplayOrder1;
	}
	
	public WebElement getbtn_DisplayOrder2() {
		return btn_DisplayOrder2;
	}
	public WebElement getbtn_DisplayOrder3() {
		return btn_DisplayOrder3;
	}
	
	public WebElement getbtn_editbankinfo() {
		return btn_editbankinfo;
	}
	
	public List<WebElement> getCurrent_BankStatus() {
		return current_bankStatus;
	}
	
	public List<WebElement> getCurrent_Status() {
		return current_Status;
	}
	
	public WebElement getbtn_Shortname() {
		return btn_Shortname;
	}
	
	public List<WebElement> getin_date_promptpay() {
		return in_date_promptpay;
	}
	
	
	public WebElement getbtn_nameTH() {
		return btn_nameTH;
	}
	
	public WebElement getbtn_newBank() {
		return btn_newBank;
	}
	
	public WebElement getbtn_nameEN() {
		return btn_nameEN;
	}
	
	public WebElement getbtn_Logo() {
		return btn_Logo;
	}
	
	public WebElement getbtn_BankStatus() {
		return btn_BankStatus;
	}
	
	public WebElement getbtn_Promptpaystatus() {
		return btn_Promptpaystatus;
	}
	
	public WebElement getbtn_lastupdate() {
		return btn_lastupdate;
	}
	
	public WebElement getbtn_updateby() {
		return btn_updateby;
	}
	
	public WebElement getbtn_status() {
		return btn_status;
	}
	
	

	public WebElement getBtn_creatnewbank() {
		return btn_creatnewbank;
	}

	public WebElement getIn_bankcd() {
		return in_bankcd;
	}
	
	public WebElement getBtn_Date1() {
		return btn_Date1;
	}
	public WebElement getBtn_Date2() {
		return btn_Date2;
	}
	
	public WebElement getBtn_EffectiveDate() {
		return txt_EffectiveDate;
	}
	public WebElement getBtn_ExpireDate() {
		return txt_ExpireDate;
	}
	public WebElement getBtn_Date3() {
		return btn_Date3;
	}

	public WebElement getIn_bankShortname() {
		return in_bankShortname;
	}

	public WebElement getIn_banknameEN() {
		return in_banknameEN;
	}

	public WebElement getIn_banknameTH() {
		return in_banknameTH;
	}

	public WebElement getIn_Accountlength() {
		return in_Accountlength;
	}

	public WebElement getIn_displayorder() {
		return in_displayorder;
	}

	public WebElement getUpload_chosebanklogo() {
		return upload_chosebanklogo;
	}

	public WebElement getbtn_uploadbanklogo() {
		return btn_uploadbanklogo;
	}

	public WebElement getSel_promptpayStatus() {
		return sel_promptpayStatus;
	}

	public WebElement getIn_Effectivedate() {
		return in_Effectivedate;
	}

	public WebElement getIn_Expiredate() {
		return in_Expiredate;
	}

	

	public WebElement getbtn_savebank() {
		return btn_savebank;
	}



	


	
	
	
}
