package com.tmb.automation.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_productinfo extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_productinfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//a[contains(.,'Products')]")
	private WebElement btn_product;
	
	
	@FindBy(xpath="//a[contains(.,'Products Info')]")
	private WebElement btn_productInfo;
	
	@FindBy(id="test-id")
	private WebElement btn_SearchProduct;
	
	@FindBy(xpath="//button[contains(.,'Search')]")
	private WebElement btn_Search;
	
	@FindBy(xpath="//button[contains(.,'Clear')]")
	private WebElement btn_clear;
	
	@FindBy(xpath="//button[contains(.,'Wait for Approve')]")
	private WebElement btn_WaitforApproval;

	@FindBy(xpath="(//div[@class='react-datepicker__input-container']/button)[1]")
	private WebElement btn_DateButton;

	@FindBy(xpath="(//div[@aria-disabled='false'])[1]")
	private WebElement btn_SelectDate;
	
	@FindBy(xpath="(//table[@id='currentProductInfoTable']/tbody/tr/td[1])[1]")
	private WebElement btn_Productcode;
	
	@FindBy(xpath="//div[contains(text(),'Please select Date & Time')]")
	private WebElement btn_ErrorMessage;
	
	@FindBy(xpath="(//select[@id='undefined_hourSelect'])[1]")
	private WebElement btn_selecthour;
	
	@FindBy(xpath="(//select[@id='undefined_minuteSelect'])[1]")
	private WebElement btn_selectminute;
	
	@FindBy(id="appPdiconAppr")
	private WebElement btn_Approvepopup;
	
	@FindBy(id="canPdiconAppr")
	private WebElement btn_Approvepopup_cancel;
	
	@FindBy(xpath="//span[@aria-label='Close']")
	private WebElement btn_Approvepopup_close;
	
	@FindBy(xpath="//img[@alt='icon-image']")
	private WebElement img_icon;
	
	@FindBy(xpath="//div[@id='image']")
	private WebElement img_productshortcut;
	
	@FindBy(id="canPdiconAppr")
	private WebElement btn_Closepopup;
	
	@FindBy(id="product_status")
	private WebElement btn_ProductStatus;
	
	@FindBy(xpath="//span[text()='Product info is Approved successfully.']")
	private WebElement text_Approvepopup;
	
	@FindBy(xpath="//li[text()='Current Product Info']")
	private WebElement btn_CurrentproductInfo;
	
	@FindBy(xpath="(//button[text()='Approve'])[1]")
	private WebElement btn_Approve;
	
	@FindBy(xpath="(//button[text()='Approve All'])[1]")
	private WebElement btn_Approveall;


	@FindBy(xpath="//li[text()='New Feed Product Info']")
	private WebElement btn_NewFeedproductInfo;
	
	@FindBy(xpath = "//span[contains(text(),'Product Code')]")
	private WebElement txt_Product_Code;
	
	@FindBy(xpath = "//span[contains(text(),'Name EN')]")
	private WebElement txt_Name_EN;
	
	
	@FindBy(xpath = "//span[contains(text(),'Name TH')]")
	private WebElement txt_Name_TH;
	
	
	@FindBy(xpath = "//span[contains(text(),'Description')]")
	private WebElement txt_Description;
	
	
	@FindBy(xpath = "//span[contains(text(),'Product Category')]")
	private WebElement txt_Product_Category;
	
	
	@FindBy(xpath = "//span[contains(text(),'Last Update')]")
	private WebElement txt_Last_Update;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Status')]")
	private WebElement txt_Status;
	
	
	
	@FindBy(id="edit-bank-info-button")
	private WebElement btn_editproductInfobutton;
	
	
	@FindBy(xpath="//button[text()='Select Icon']")
	private WebElement btn_editproductSelectIcon;
	
	@FindBy(xpath="(//div[@id='img+checkbox'])[2]/input")
	private WebElement btn_editproductSelectImage;
	
	@FindBy(xpath="(//button[text()='Save'])[2]")
	private WebElement btn_editproductSelectImageSaveButton;
	
	
	@FindBy(xpath="(//button[text()='Cancel'])")
	private WebElement btn_editproductInfoCancel;
	
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

	@FindBy(xpath = "//tr[@role='row']/td[7]")
	private List<WebElement> New_info_Status;
	
	@FindBy(xpath="(//label[@name='debit_card_flag'])/../label/span")
	private WebElement btn_editdebitcardflag;

	@FindBy(xpath="(//input[@name='debit_card_fee'])")
	private WebElement btn_editdebitcardfee;
	
	@FindBy(xpath="(//div[contains(text(),'Back to product info list')])[2]")
	private WebElement btn_BackProductinfo;

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
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement btn_previous;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btn_next;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[2]")
	private WebElement btn_secondtab;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[1]")
	private WebElement btn_firsttab;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[6])[3]")
	private WebElement btn_Date3;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div")
	private WebElement btn_Sorting;

	
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getBtn_Date1() {
		return btn_Date1;
	}
	
	public WebElement getbtn_editproductInfoCancel() {
		return btn_editproductInfoCancel;
	}
	public WebElement getBtn_Date2() {
		return btn_Date2;
	}
	
	public WebElement getBtn_Date3() {
		return btn_Date3;
	}
	
	public WebElement getimg_icon() {
		return img_icon;
	}
	
	public WebElement getimg_productshortcut() {
		return img_productshortcut;
	}
	
	
	public WebElement getbtn_Sorting() {
		return btn_Sorting;
	}
	
	public WebElement getbtn_next() {
		return btn_next;
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
	
	public WebElement getbtn_Search() {
		return btn_Search;
	}
	
	public WebElement getbtn_Clear() {
		return btn_clear;
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
	
	public List<WebElement> getNew_info_Status() {
		return New_info_Status;
	}
	
	public WebElement getBtn_editaddImage1() {
		return btn_editaddImage1;
	}
	
	public WebElement getBtn_editaddImage2() {
		return btn_editaddImage2;
	}
	
	
	public WebElement getbtn_SearchProduct() {
		return btn_SearchProduct;
	}
	
	public WebElement getbtn_ProductStatus() {
		return btn_ProductStatus;
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
	
	public WebElement getBtn_Approve() {
		return btn_Approve;
	}
	public WebElement getBtn_Approveall() {
		return btn_Approveall;
	}
	
	public WebElement getBtn_NewFeedproductInfo() {
		return btn_NewFeedproductInfo;
	}
	public WebElement getbtn_Approvepopup_cancel() {
		return btn_Approvepopup_cancel;
	}
	
	public WebElement getbtn_Approvepopup_close() {
		return btn_Approvepopup_close;
	}
	
	public WebElement getBtn_Closepopup() {
		return btn_Closepopup;
	}

	public WebElement getBtn_Approvepopup() {
		return btn_Approvepopup;
	}
	public WebElement getBtn_CurrentproductInfo() {
		return btn_CurrentproductInfo;
	}
	
	public WebElement gettext_Approvepopup() {
		return text_Approvepopup;
	}
	public WebElement getBtn_selecthour() {
		return btn_selecthour;
	}
	public WebElement getBtn_selectminute() {
		return btn_selectminute;
	}

	public WebElement getBtn_ErrorMessage() {
		return btn_ErrorMessage;
	}

	public WebElement getBtn_product() {
		return btn_product;
	}
	public WebElement getBtn_Productcode() {
		return btn_Productcode;
	}

	public WebElement getBtn_productInfo() {
		return btn_productInfo;
	}
	
	public WebElement getBtn_WaitforApproval() throws InterruptedException {
		Thread.sleep(3000);
		return btn_WaitforApproval;
	}
	
	public WebElement getBtn_DateButton() {
		return btn_DateButton;
	}
	
	public WebElement getbtn_BackProductinfo() {
		return btn_BackProductinfo;
	}
	
	public WebElement getBtn_selectdate() {
		return btn_SelectDate;
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
	public WebElement gettxt_Last_Update() {
		return txt_Last_Update;
	}
	public WebElement gettxt_Product_Code() {
		return txt_Product_Code;
	}
	public WebElement gettxt_Status() {
		return txt_Status;
	}
	
	public WebElement gettxt_Product_Category() {
		return txt_Product_Category;
	}



	


	





	
	
	
}
