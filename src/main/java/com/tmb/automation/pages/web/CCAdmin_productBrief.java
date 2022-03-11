package com.tmb.automation.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_productBrief extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_productBrief(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	@FindBy(xpath = "//a[contains(.,'Product')]")
	private WebElement btn_product;
	
	
	@FindBy(xpath="//a[contains(.,'Product Brief')]")
	private WebElement btn_productBrief;
	
	@FindBy(xpath="//button[contains(.,'Wait for Approve')]")
	private WebElement btn_WaitforApproval;
	
	
	@FindBy(xpath="//span[text()='Product Code']")
	private WebElement txt_productCode;
	
	@FindBy(xpath="//span[text()='Name']")
	private WebElement txt_Name;
	
	@FindBy(xpath="//span[text()='ID']")
	private WebElement txt_ID;
	
	@FindBy(xpath="//span[text()='Description']")
	private WebElement txt_Description;
	
	@FindBy(xpath="//span[text()='Channel']")
	private WebElement txt_Channel;
	
	@FindBy(xpath="//span[text()='Publish Date']")
	private WebElement txt_PublishDate;
	
	@FindBy(xpath="//span[text()='Last Update']")
	private WebElement txt_LastUpdate;
	
	@FindBy(xpath="//span[text()='Update By']")
	private WebElement txt_UpdateBy;
	
	@FindBy(xpath="//span[text()='Version']")
	private WebElement txt_Version;
	
	
	
	@FindBy(id = "new-product-brief-button")
	private WebElement btn_new_product_Brief;
	
	@FindBy(id = "productName")
	private WebElement textproduct_Name;
	
	
	
	@FindBy(xpath = "(//table[@id='updatedProductsTermsAndConditionsTable']/tbody/tr/td[2])[1]")
	private WebElement btn_WaitApproveKey;
	
	@FindBy(id = "productId")
	private WebElement textproduct_ID;
	
	@FindBy(id = "productDescription")
	private WebElement textproduct_Description;
	
	@FindBy(id = "channel")
	private WebElement ProductChannel;
	

	@FindBy(id = "product-tc-thai-version")
	private WebElement Content_Thai;
	
	@FindBy(id = "product-brief-image-eng-version-0")
	private WebElement Content_Eng;
	
	@FindBy(xpath = "(//button[text()='Browse'])[1]")
	private WebElement Browse_button1;
	
	@FindBy(xpath = "(//button[text()='Browse'])[2]")
	private WebElement Browse_button2;
	
	@FindBy(xpath = "//div[@id='productCode']/div/div[1]")
	private WebElement text_productcode;
	
	
	@FindBy(xpath = "//div[text()='New Product T&C']")
	private WebElement btn_newproduct_TermsandCondition;
	
	@FindBy(xpath = "//div[contains(text(),'Sorry, the available image is only 1920 x 1080 Pixel. JPG, PNG . and Maximum 3 MB')]")
	private WebElement btn_pdf_3MB_error;
	
	@FindBy(xpath = "//div[text()='Terms_and_Conditions.pdf']")
	private WebElement getUploaded;
	
	@FindBy(xpath = "//div[contains(text(),'Sorry, file name is not properly formatted. Standard names may contain letters a-z, A-Z, 0-9, _ . -')]")
	private WebElement btn_pdf_40_character;
	
	@FindBy(xpath = "//div[@aria-label='Rich Text Editor, main']")
	private WebElement text_rich_text_Editor;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement Save_button;
	
	@FindBy(xpath="//span[text()='*']")
	private List<WebElement> bstn_CreateBriefRedMandatorymark;
	
	@FindBy(xpath="//span[text()='Product brief is Approved successfully.']")
	private WebElement text_Approvepopup;
	
	@FindBy(xpath="//span[text()='Back to product brief list']")
	private WebElement btn_BackProductBrief;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement btn_previous;
	
	@FindBy(xpath="(//div[@data-testid='column'])[13]/span/img")
	private WebElement btn_ProductBriefbinbutton;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btn_next;
	
	@FindBy(xpath="//tr[@role='row']/td[10]")
	private List<WebElement> btn_StatusProduct;
	
	@FindBy(id="appProductBriefYesApprove")
	private WebElement btn_Approvepopup;
	
	
	@FindBy(id="canProductBriefNoApprove")
	private WebElement btn_Approvepopup_cancel;
	
	@FindBy(id="canProductBriefCloseApprove")
	private WebElement btn_Closepopup;
	
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[2]")
	private WebElement btn_secondtab;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[1]")
	private WebElement btn_firsttab;
	
	@FindBy(xpath="(//tr[@role='row']/td[7])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[7])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[7])[3]")
	private WebElement btn_Date3;

	
	@FindBy(id = "edit-product-brief-button")
	private WebElement btn_EditProductBrief;
	
	@FindBy(xpath="(//table[@id='updatedProductBriefTable']/tbody/tr/td[3])[1]")
	private WebElement btn_WaitForApprove_ProductBrief;
	
	public WebElement getbtn_WaitForApprove_ProductBrief() {
		return btn_WaitForApprove_ProductBrief;
	}
	
	
	public WebElement getbtn_ProductBriefbinbutton() {
		return btn_ProductBriefbinbutton;
	}
	
	
	public WebElement getBtn_Date1() {
		return btn_Date1;
	}
	public WebElement getBtn_Date2() {
		return btn_Date2;
	}
	public List<WebElement> getBtn_CreateBriefRedMandatorymark() {
		return bstn_CreateBriefRedMandatorymark;
	}
	
	public WebElement getBtn_Date3() {
		return btn_Date3;
	}
	
	public WebElement getbtn_Approvepopup() {
		return btn_Approvepopup;
	}
	
	public WebElement getbtn_Approvepopup_cancel() {
		return btn_Approvepopup_cancel;
	}
	
	
		
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getBtn_product() {
		return btn_product;
	}
	
	public WebElement getBtn_productBrief() {
		return btn_productBrief;
	}
	
	public WebElement getbtn_next() {
		return btn_next;
	}
	
	public WebElement getBtn_WaitforApproval() throws InterruptedException {
		Thread.sleep(3000);
		return btn_WaitforApproval;
	}
	public WebElement getBtn_Closepopup() {
		return btn_Closepopup;
	}
	
	public WebElement gettxt_productCode() {
		return txt_productCode;
	}
	
	public WebElement gettxt_Name() {
		return txt_Name;
	}
	
	public WebElement gettxt_ID() {
		return txt_ID;
	}
	
	public WebElement gettxt_Description() {
		return txt_Description;
	}
	
	public WebElement gettxt_Channel() {
		return txt_Channel;
	}
	
	public List<WebElement> getBtn_StatusProduct() {
		return btn_StatusProduct;
	}
	
	public WebElement gettxt_PublishDate() {
		return txt_PublishDate;
	}
	
	public WebElement gettxt_LastUpdate() {
		return txt_LastUpdate;
	}
	
	public WebElement gettxt_UpdateBy() {
		return txt_UpdateBy;
	}
	
	public WebElement gettxt_Version() {
		return txt_Version;
	}
	
	
	public WebElement getSave_button() {
		return Save_button;
	}
	public WebElement getBrowse_button1() {
		return Browse_button1;
	}
	
	public WebElement getBrowse_button2() {
		return Browse_button2;
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
	public WebElement gettext_Approvepopup() {
		return text_Approvepopup;
	}
	public WebElement getProductChannel() {
		return ProductChannel;
	}
	public WebElement gettextproduct_Name() {
		return textproduct_Name;
	}
	public WebElement gettextproduct_ID() {
		return textproduct_ID;
	}
	public WebElement getbtn_new_product_Brief() {
		return btn_new_product_Brief;
	}
	public WebElement gettext_productcode() {
		return text_productcode;
	}
	public WebElement getbtn_BackProductBrief() {
		return btn_BackProductBrief;
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
	public WebElement getbtn_EditProductBrief() {
		return btn_EditProductBrief;
	}
	
			}

	
	



	


	





	
	
	
