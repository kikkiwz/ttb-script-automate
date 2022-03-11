package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCarTransferPage {
    public ConfirmCarTransferPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement header;

    public WebElement getHeader() {
        return header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button")
    private WebElement backBTN;

    public WebElement getBackBTN() {
        return backBTN;
    }

    @FindBy(id = "al-car-transfer-confirm-header-label")
    private WebElement transferFormLabel;

    public WebElement getTransferFormLabel() {
        return transferFormLabel;
    }

    @FindBy(xpath = "//*[@id=\"00\"]/span/span[1]")
    private WebElement AccNickName;

    public WebElement getAccNickName() {
        return AccNickName;
    }

    @FindBy(xpath = "//*[@id=\"00\"]/span/span[2]")
    private WebElement AccNickNameLabel;

    public WebElement getAccNickNameLabel(){
        return AccNickNameLabel;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[1]")
    private  WebElement AccName;

    public WebElement getAccName(){
        return AccName;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[2]")
    private WebElement AccNameLabel;

    public WebElement getAccNameLabel(){
        return AccNameLabel;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[1]")
    private WebElement LicensePlate;

    public WebElement getLicensePlate() {
        return LicensePlate;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[2]")
    private WebElement LicensePlateLabel;

    public WebElement getLicensePlateLabel(){
        return LicensePlateLabel;
    }

    @FindBy(id = "al-car-transfer-confirm-request-confirm-email")
    private WebElement inPutEmail;

    public WebElement getInPutEmail() {
        return inPutEmail;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[4]/div/label")
    private WebElement EmailLabel;

    public WebElement getEmailLabel() {
        return EmailLabel;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[6]")
    private WebElement disclaimer;

    public WebElement getDisclaimer() {
        return disclaimer;
    }

    @FindBy(id = "al-car-transfer-confirm-request-confirm-button")
    private WebElement confirmBTN;

    public WebElement getConfirmBTN() {
        return confirmBTN;
    }


}


