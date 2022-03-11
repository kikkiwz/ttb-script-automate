package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSaleSheetPage {

    public ViewSaleSheetPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button")
    private WebElement BackBTN;

    public WebElement getBackBTN() {
        return BackBTN;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement Header;

    public WebElement getHeader() {
        return Header;
    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div/label")
    private WebElement EnterEmail_Label;

    public WebElement getEnterEmail_Label() {
        return EnterEmail_Label;
    }

    @FindBy(xpath = "//*[@id=\"al-sale-sheet-input-field\"]")
    private WebElement EnterEmail_Input;

    public WebElement getEnterEmail_Input() {
        return EnterEmail_Input;
    }

    @FindBy(id = "al-sale-sheet-email-button")
    private WebElement SendEmail_BTN;

    public WebElement getSendEmail_BTN() {
        return SendEmail_BTN;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/span")
    private   WebElement EmailIncorrect_Warning;

    public WebElement getEmailIncorrect_Warning(){
        return EmailIncorrect_Warning;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div")
    private WebElement SendEmailSuccess_POPUP;

    public WebElement getSendEmailSuccess_POPUP() {
        return SendEmailSuccess_POPUP;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[1]/div[2]")
    private WebElement SendEmailSuccess_POPUP_Header;

    public WebElement getSendEmailSuccess_POPUP_Header() {
        return SendEmailSuccess_POPUP_Header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[1]/div[3]")
    private WebElement SendEmailSuccess_POPUP_Body;

    public WebElement getSendEmailSuccess_POPUP_Body() {
        return SendEmailSuccess_POPUP_Body;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[2]/div")
    private WebElement SendEmailSuccess_POPUP_OKBTN;

    public WebElement getSendEmailSuccess_POPUP_OKBTN() {
        return SendEmailSuccess_POPUP_OKBTN;
    }
}
