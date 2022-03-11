package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_Editproductinfo extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_Editproductinfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	
	@FindBy(xpath = "//a[contains(.,'Products')]")
	private WebElement btn_product;
	
	@FindBy(xpath="//li[text()='Current Product Info']")
	private WebElement btn_CurrentproductInfo;
	
	@FindBy(id="edit-bank-info-button")
	private WebElement btn_editproductInfobutton;
	
	
	@FindBy(xpath="//button[text()='Select Icon']")
	private WebElement btn_editproductSelectIcon;
	
	@FindBy(xpath="(//div[@id='img+checkbox'])[2]/input")
	private WebElement btn_editproductSelectImage;
	
	@FindBy(xpath="(//button[text()='Save'])[2]")
	private WebElement btn_editproductSelectImageSaveButton;
	
	@FindBy(name="ordering_value")
	private WebElement btn_editproductCategory;
	
	@FindBy(id="product_code")
	private WebElement btn_editproduct_code;
	
	@FindBy(id="product_description")
	private WebElement btn_editproduct_description;
	
	@FindBy(id="account_type")
	private WebElement btn_editaccount_type;
	
	@FindBy(id="product_name_en")
	private WebElement btn_editproduct_name_en;
	
	@FindBy(id="product_name_th")
	private WebElement btn_editproduct_name_th;
	
	@FindBy(id="product_category_en")
	private WebElement btn_editproduct_category_en;
	
	@FindBy(id="product_category_th")
	private WebElement btn_editproduct_category_th;
	
	@FindBy(id="account_type_desc_en")
	private WebElement btn_editaccount_type_desc_en;
	
	@FindBy(id="account_type_desc_th")
	private WebElement btn_editaccount_type_desc_th;
	
	@FindBy(id="marketing_concept")
	private WebElement btn_editmarketing_concept;

	
	@FindBy(xpath="(//label[@name='debit_card_flag'])/../label/span")
	private WebElement btn_editdebitcardflag;

	@FindBy(xpath="(//input[@name='debit_card_fee'])")
	private WebElement btn_editdebitcardfee;

	@FindBy(xpath="(//label[@name='allow_to_receive_cash_back'])/../label/span")
	private WebElement btn_editreceivecashback;
	
	@FindBy(xpath="(//label[@name='allow_register_prompt_pay'])/../label/span")
	private WebElement btn_editpromptpay;
	
	@FindBy(xpath="(//label[@name='allow_receive_money_cash_advance'])/../label/span")
	private WebElement btn_editcashadvance;

	@FindBy(xpath="(//label[@name='allow_from_account_cardless_withdraw'])/../label/span")
	private WebElement btn_editcardlessWithdraw;
	
	@FindBy(xpath="(//label[@name='allow_to_receive_money_save_alert'])/../label/span")
	private WebElement btn_editsavealert;
	
	@FindBy(xpath="(//label[@name='allow_to_purchase_ba'])/../label/span")
	private WebElement btn_editpurchaseba;
	
	@FindBy(xpath="(//label[@name='allow_to_create_saving_goal'])/../label/span")
	private WebElement btn_editsavinggoal;

	@FindBy(xpath="(//label[@name='chequeview_return'])/../label/span")
	private WebElement btn_editChequeview;
	
	@FindBy(xpath="(//label[@name='fee_ctrl_no_fee_flag'])/../label/span")
	private WebElement btn_editfeeflag;
	
	@FindBy(xpath="(//label[@name='apply_service_allow_send_to_save_from'])/../label/span")
	private WebElement btn_editsavefrom;

	@FindBy(xpath="(//label[@name='allow_transfer_from_account'])/../label/span")
	private WebElement btn_editallowtransfer;
	@FindBy(xpath="(//label[@name='allow_from_for_bill_pay_top_up_epayment'])/../label/span")
	private WebElement btn_editepayment;
	
	@FindBy(xpath="//a[@id='add-icon']")
	private WebElement btn_editaddIcon;
	
	@FindBy(xpath="(//div[@id='img'])[1]/input")
	private WebElement btn_editaddImage1;
	
	@FindBy(xpath="(//div[@id='img'])[2]/input")
	private WebElement btn_editaddImage2;
	
	@FindBy(xpath="(//div[@id='img'])[3]/input")
	private WebElement btn_editaddImage3;
	
	@FindBy(xpath="(//a[@id='add_product_btn_undefined'])")
	private WebElement btn_editaddIcon2;
	
	@FindBy(xpath="(//button[text()='Save'])[1]")
	private WebElement btn_editfinalsavebutton;
	
	

	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getBtn_editaddIcon2() {
		return btn_editaddIcon2;
	}
	
	public WebElement getBtn_editfinalsavebutton() {
		return btn_editfinalsavebutton;
	}
	
	public WebElement getBtn_editaddIcon() {
		return btn_editaddIcon;
	}

	public WebElement getBtn_editepayment() {
		return btn_editepayment;
	}
	public WebElement getBtn_editaddImage1() {
		return btn_editaddImage1;
	}
	
	public WebElement getBtn_editaddImage2() {
		return btn_editaddImage2;
	}
	
	public WebElement getBtn_editaddImage3() {
		return btn_editaddImage3;
	}
	
	public WebElement getBtn_editallowtransfer() {
		return btn_editallowtransfer;
	}
	
	public WebElement getBtn_editsavefrom() {
		return btn_editsavefrom;
	}
	public WebElement getBtn_editfeeflag() {
		return btn_editfeeflag;
	}
	
	public WebElement getBtn_editChequeview() {
		return btn_editChequeview;
	}
	
	public WebElement getBtn_editsavinggoal() {
		return btn_editsavinggoal;
	}
	
	public WebElement getBtn_editpurchaseba() {
		return btn_editpurchaseba;
	}
	public WebElement getBtn_editsavealert() {
		return btn_editsavealert;
	}
	public WebElement getBtn_editcardlessWithdraw() {
		return btn_editcardlessWithdraw;
	}
	public WebElement getBtn_editcashadvance() {
		return btn_editcashadvance;
	}
	
	public WebElement getBtn_editpromptpay() {
		return btn_editpromptpay;
	}
	public WebElement getBtn_editreceivecashback() {
		return btn_editreceivecashback;
	}
	public WebElement getBtn_editdebitcardfee() {
		return btn_editdebitcardfee;
	}
	
	public WebElement getBtn_editproductCategory() {
		return btn_editproductCategory;
	}
	
	public WebElement getBtn_editdebitcardflag() {
		return btn_editdebitcardflag;
	}
	public WebElement getBtn_editproduct_code() {
		return btn_editproduct_code;
	}
	public WebElement getBtn_editproduct_description() {
		return btn_editproduct_description;
	}
	public WebElement getBtn_editaccount_type() {
		return btn_editaccount_type;
	}
	public WebElement getBtn_editproduct_name_en() {
		return btn_editproduct_name_en;
	}
	public WebElement getBtn_editproduct_name_th() {
		return btn_editproduct_name_th;
	}
	public WebElement getBtn_editproduct_category_en() {
		return btn_editproduct_category_en;
	}
	public WebElement getBtn_editproduct_category_th() {
		return btn_editproduct_category_th;
	}
	public WebElement getBtn_editaccount_type_desc_en() {
		return btn_editaccount_type_desc_en;
	}
	public WebElement getBtn_editaccount_type_desc_th() {
		return btn_editaccount_type_desc_th;
	}
	public WebElement getBtn_editmarketing_concept() {
		return btn_editmarketing_concept;
	}
	
	public WebElement getBtn_CurrentproductInfo() {
		return btn_CurrentproductInfo;
	}
	public WebElement getBtn_editproductSelectImageSaveButton() {
		return btn_editproductSelectImageSaveButton;
	}
	public WebElement getBtn_editproductSelectImage() {
		return btn_editproductSelectImage;
	}
	public WebElement getBtn_editproductInfobutton() {
		return btn_editproductInfobutton;
	}
	public WebElement getBtn_editproductSelectIcon() {
		return btn_editproductSelectIcon;
	}
	
	
	public WebElement getBtn_product() {
		return btn_product;
	}

	
	



	


	





	
	
	
}