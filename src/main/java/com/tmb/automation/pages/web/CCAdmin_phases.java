package com.tmb.automation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.automation.util.SeleniumLibrary;

public class CCAdmin_phases extends SeleniumLibrary {

	private WebDriver driver;

	public CCAdmin_phases(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Phrase')]")
	private WebElement btn_phase;
	
	@FindBy(xpath = "//div[contains(text(),'Select...')]")
	private WebElement btn_selectpahese;
	
	
	@FindBy(xpath = "//button[contains(text(),'Review')]")
	private WebElement btn_Review;
	
	@FindBy(xpath = "//img[@alt='fireSpot'][@class='admin_phraseButDiv__1r4e6']")
	private WebElement btn_creat_phrases;
	
	@FindBy(xpath = "((//div[@class=' css-1hwfws3'])[2]//div[1])[1]")
	private WebElement btn_module_newphrase;
	
	
	@FindBy(xpath = "//h1[contains(.,'KEY')]//..//..//following::div//div//input[1]")
	private WebElement in_key;
	
	
	@FindBy(xpath = "//h1[contains(text(),'TH')]//..//..//following::div[1]//div//textarea")
	private WebElement in_Thaiphrase;
	
	
	@FindBy(xpath = "//h1[contains(text(),'EN')]//..//..//following::div[1]//div//textarea")
	private WebElement in_En_phrase;
	
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btn_ok_creatphases;
	
	
	@FindBy(xpath = "//button[contains(.,'Close')]")
	private WebElement btn_Review_close;
	
	
	@FindBy(xpath = "//th[contains(.,'Last Updated')]")
	private WebElement btn_Sortby_Latestupdate;
	
	
	@FindBy(xpath = "//div[contains(text(),'Select...')]//..//input")
	private WebElement in_select_phrases;
	
	
	@FindBy(xpath = "//button[contains(.,'Close')]")
	private WebElement btn_Review_close3;
	
	
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	private WebElement btn_Save;
	

	

	@FindBy(xpath = "//h1[contains(.,'KEY')]//..//..//following::div//div[2]//p[1]")
	private WebElement err_message_capitalkey;
	
	

	public WebElement getBtn_Review() {
		return btn_Review;
	}

	
	








	public WebElement getBtn_selectpahese() {
		return btn_selectpahese;
	}


	public WebElement getBtn_phase() {
		return btn_phase;
	}





	public WebElement getBtn_creat_phrases() {
		return btn_creat_phrases;
	}





	public WebElement getBtn_module_newphrase() {
		return btn_module_newphrase;
	}





	public WebElement getIn_key() {
		return in_key;
	}





	public WebElement getIn_Thaiphrase() {
		return in_Thaiphrase;
	}





	public WebElement getIn_En_phrase() {
		return in_En_phrase;
	}





	public WebElement getBtn_ok_creatphases() {
		return btn_ok_creatphases;
	}





	public WebElement getBtn_Sortby_Latestupdate() {
		return btn_Sortby_Latestupdate;
	}











	public WebElement getIn_in_select_phrases() {
		return in_select_phrases;
	}




	public WebElement getBtn_Review_close() {
		return btn_Review_close;
	}











	public WebElement getErr_message_capitalkey() {
		return err_message_capitalkey;
	}











	public void setErr_message_capitalkey(WebElement err_message_capitalkey) {
		this.err_message_capitalkey = err_message_capitalkey;
	}











	public WebElement getBtn_Save() {
		return btn_Save;
	}











	public void setBtn_Save(WebElement btn_Save) {
		this.btn_Save = btn_Save;
	}









	

}
