package com.tmb.automation.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_GetAllPhrasesDashboard extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_GetAllPhrasesDashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	
	@FindBy(xpath = "//span[text()='T-Phrase']")
	private WebElement btn_newphrases;
	
	@FindBy(xpath = "(//table[@id='updatedPhrasesTable']/tbody/tr/td[2])[1]")
	private WebElement btn_WaitApproveKey;
	
	@FindBy(xpath="//div[text()='Please select module']")
	private WebElement btn_selectmoduledropdown;
	
	@FindBy(xpath="//div[text()='All']")
	private WebElement btn_selectmoduledropdownAll;
	
	@FindBy(xpath="//div[text()='Alt']")
	private WebElement btn_selectmoduledropdownAlt;
	
	@FindBy(xpath="(//a[@id='edit-phrase-button'])[1]")
	private WebElement btn_EditPhrase;


	@FindBy(xpath="//input[@id='phrase_search']")
	private WebElement btn_SearchKeyword;

	@FindBy(xpath="(//select[@id='module']//option)[1]")
	private WebElement btn_selectmodule;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement btn_Search;
	
	@FindBy(xpath="//button[text()='Clear']")
	private WebElement btn_Clear;
	
	@FindBy(xpath="//button[@id='new-product-button']")
	private WebElement btn_NewPhrase;
	
	@FindBy(xpath="//button[contains(text(),'Wait for Approve')]")
	private WebElement btn_WaitForApproval;
	
	@FindBy(xpath="//span[text()='Module']")
	private WebElement btn_Module;
	
	@FindBy(xpath="//span[text()='Key']")
	private WebElement btn_Key;
	
	@FindBy(xpath="//span[text()='Name EN']")
	private WebElement btn_NameEN;
	
	@FindBy(xpath="//span[text()='Name TH']")
	private WebElement btn_NameTH;
	
	@FindBy(xpath="//span[text()='Last Update']")
	private WebElement btn_LastUpdate;
	
	@FindBy(xpath="//span[text()='Update By']")
	private WebElement btn_UpdateBy;
	
	@FindBy(xpath="//span[text()='Status']")
	private WebElement btn_Status;
	
	@FindBy(xpath="//span[text()='Publish Date']")
	private WebElement btn_Publish_Date;
	
	@FindBy(xpath="//tr[@role='row']/td[7]")
	private List<WebElement> btn_StatusProduct;
	
	@FindBy(xpath="(//tr[@role='row']/td[5])[1]")
	private WebElement btn_Date1;
	
	@FindBy(xpath="(//tr[@role='row']/td[5])[2]")
	private WebElement btn_Date2;
	
	@FindBy(xpath="(//tr[@role='row']/td[5])[3]")
	private WebElement btn_Date3;
	
	
	@FindBy(xpath="//select[@name='moduleNames']")
	private WebElement New_Phrase_ModuleNames;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement btn_cancelPhrase ;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement btn_AddPhrase ;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement btn_SavePhrase ;
	
	@FindBy(xpath="//p[contains(text(),'Key*')]")
	private WebElement btn_PhraseKey ;
	
	@FindBy(xpath="//span[text()='Phrase Thai Name* :']")
	private WebElement btn_ThaiPhrase ;
	
	@FindBy(xpath="//span[text()='Phrase English Name* :']")
	private WebElement btn_EnglishPhrase ;
	
	@FindBy(xpath="//input[@name='phraseKey']")
	private WebElement btn_InputKey ;
	
	@FindBy(xpath="//p[text()='*Key should contains English lowercase alphabets only']")
	private WebElement btn_Err_MSG_01 ;
	
	
	@FindBy(xpath="//p[text()=\"*Please don't put an existing Key\"]")
	private WebElement btn_Err_MSG_02 ;
	
	@FindBy(xpath="(//tr[@role='row'])[2]/td[2]/div")
	private WebElement btn_ExistingKey ;
	
	@FindBy(xpath="//textarea[@name='thPhrase']")
	private WebElement btn_textthPhrase ;
	
	@FindBy(xpath="//textarea[@name='engPhrase']")
	private WebElement btn_textengPhrase ;
	
	@FindBy(xpath="(//div[@class='react-datepicker__input-container']/button)[2]")
	private WebElement btn_DateButton;
	
	@FindBy(xpath="(//div[@class='react-datepicker__input-container']/button)[1]")
	private WebElement btn_DateButton_Approveall;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement btn_previous;
	
	@FindBy(xpath="(//button[text()='Approve'])[1]")
	private WebElement btn_Approve;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btn_next;

	@FindBy(xpath="(//div[@aria-disabled='false'])[1]")
	private WebElement btn_SelectDate;
	
	@FindBy(xpath="(//select[@id='undefined_hourSelect'])[2]")
	private WebElement btn_selecthour;
	
	@FindBy(xpath="(//select[@id='undefined_minuteSelect'])[2]")
	private WebElement btn_selectminute;
	
	@FindBy(xpath="(//select[@id='undefined_hourSelect'])[1]")
	private WebElement btn_selecthourApproveall;
	
	@FindBy(xpath="(//select[@id='undefined_minuteSelect'])[1]")
	private WebElement btn_selectminuteApproveall;
	
	@FindBy(xpath="//span[text()='Phrase is Approved successfully.']")
	private WebElement text_ApprovepopupPhrase;
	
	@FindBy(xpath="//span[text()='Phrases are Approved successfully.']")
	private WebElement text_ApproveallpopupPhrases;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[2]")
	private WebElement btn_secondtab;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/../ul/li)[1]")
	private WebElement btn_firsttab;
	
	@FindBy(xpath="//div[text()='Back to Phrase list']")
	private WebElement btn_BackPhrase;
	
	@FindBy(xpath="//button[contains(.,'Wait for Approve')]")
	private WebElement btn_WaitforApproval;
	
	@FindBy(xpath="//div[contains(text(),'Please select Date & Time')]")
	private WebElement btn_ErrorMessage;
	
	@FindBy(id="canPdiconAppr")
	private WebElement btn_Approvepopup_cancel;
	
	@FindBy(id="appPdiconAppr")
	private WebElement btn_Approvepopup;
		
	
	
	public WebElement getBtn_Approvepopup() {
		return btn_Approvepopup;
	}
	
	public WebElement getbtn_Approvepopup_cancel() {
		return btn_Approvepopup_cancel;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getbtn_DateButton_Approveall() {
		return btn_DateButton_Approveall;
	}
	
	public WebElement getbtn_selecthourApproveall() {
		return btn_selecthourApproveall;
	}
	
	public WebElement getbtn_selectminuteApproveall() {
		return btn_selectminuteApproveall;
	}
	public WebElement getbtn_textengPhrase() {
		return btn_textengPhrase;
	}
	public WebElement gettext_ApprovepopupPhrase() {
		return text_ApprovepopupPhrase;
	}
	public WebElement gettext_ApproveallpopupPhrases() {
		return text_ApproveallpopupPhrases;
	}
	public WebElement getbtn_BackPhrase() {
		return btn_BackPhrase;
	}
	
	public WebElement getBtn_WaitforApproval() throws InterruptedException {
		Thread.sleep(3000);
		return btn_WaitforApproval;
	}
	
	
	public WebElement getBtn_Approve() {
		return btn_Approve;
	}
	
	public WebElement getbtn_SavePhrase() {
		return btn_SavePhrase;
	}
	public WebElement getbtn_WaitApproveKey() {
		return btn_WaitApproveKey;
	}
	
	public WebElement getBtn_ErrorMessage() {
		return btn_ErrorMessage;
	}
	
	public WebElement getbtn_textthPhrase() {
		return btn_textthPhrase;
	}
	
	public WebElement getbtn_EditPhrase() {
		return btn_EditPhrase;
	}
	public WebElement getbtn_ExistingKey() {
		return btn_ExistingKey;
	}
	public WebElement getbtn_Err_MSG_02() {
		return btn_Err_MSG_02;
	}
	public WebElement getbtn_Err_MSG_01() {
		return btn_Err_MSG_01;
	}
	public WebElement getbtn_InputKey() {
		return btn_InputKey;
	}
	public WebElement getbtn_EnglishPhrase() {
		return btn_EnglishPhrase;
	}
	public WebElement getbtn_ThaiPhrase() {
		return btn_ThaiPhrase;
	}
	public WebElement getbtn_PhraseKey() {
		return btn_PhraseKey;
	}
	public WebElement getbtn_Clear() {
		return btn_Clear;
	}
	public WebElement getbtn_AddPhrase() {
		return btn_AddPhrase;
	}
	public WebElement getbtn_cancelPhrase() {
		return btn_cancelPhrase;
	}
	public WebElement getNew_Phrase_ModuleNames() {
		return New_Phrase_ModuleNames;
	}
	public WebElement getBtn_Module() {
		return btn_Module;
	}
	public List<WebElement> getBtn_StatusProduct() {
		return btn_StatusProduct;
	}
	public WebElement getBtn_Key() {
		return btn_Key;
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
	public WebElement getBtn_Date1() {
		return btn_Date1;
	}
	public WebElement getBtn_Date2() {
		return btn_Date2;
	}
	public WebElement getBtn_Date3() {
		return btn_Date3;
	}
	public WebElement getBtn_NameEN() {
		return btn_NameEN;
	}
	public WebElement getBtn_NameTH() {
		return btn_NameTH;
	}
	public WebElement getBtn_LastUpdate() {
		return btn_LastUpdate;
	}
	public WebElement getBtn_UpdateBy() {
		return btn_UpdateBy;
	}
	public WebElement getBtn_Publish_Date() {
		return btn_Publish_Date;
	}
	public WebElement getBtn_Status() {
		return btn_Status;
	}
	public WebElement getbtn_NewPhrase() {
		return btn_NewPhrase;
	}
	public WebElement getbtn_WaitForApproval() {
		return btn_WaitForApproval;
	}
		
	public WebElement getbtn_Search() {
		return btn_Search;
	}
	
	public WebElement getBtn_SearchKeyword() {
		return btn_SearchKeyword;
	}
	
	
	public WebElement getBtn_newphrases() {
		return btn_newphrases;
	}
	
	public WebElement getBtn_Selectmoduledropdown() {
		return btn_selectmoduledropdown;
	}
	
	public WebElement getBtn_SelectmoduledropdownAll() {
		return btn_selectmoduledropdownAll;
	}
	
	public WebElement getBtn_SelectmoduledropdownAlt() {
		return btn_selectmoduledropdownAlt;
	}
	
	public WebElement getBtn_Selectmoduledropdownfirstoption() {
		return btn_SearchKeyword;
	}
	
	public WebElement getBtn_selecthour() {
		return btn_selecthour;
	}
	public WebElement getBtn_selectminute() {
		return btn_selectminute;
	}
	public WebElement getBtn_DateButton() {
		return btn_DateButton;
	}
	
	public WebElement getBtn_selectdate() {
		return btn_SelectDate;
	}

	
		}

	
	



	


	





	
	
	
