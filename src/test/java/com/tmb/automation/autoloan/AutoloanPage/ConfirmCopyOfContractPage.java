package com.tmb.automation.autoloan.AutoloanPage;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.mail.Header;

public class ConfirmCopyOfContractPage {
    public ConfirmCopyOfContractPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement Header;

    public WebElement getHeader() {
        return Header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button/svg")
    private WebElement BackBTN;

    public WebElement getBackBTN() {
        return BackBTN;
    }

    @FindBy(id = "al-copy-of-contract-confirm-header-label")
    private WebElement SubHeader;

    public WebElement getSubHeader() {
        return SubHeader;
    }
    @FindBy(xpath = "//*[@id=\"00\"]/span/span[1]")
    private WebElement AccountNickName;

    public WebElement getAccountNickName() {
        return AccountNickName;
    }

    @FindBy(xpath = "//*[@id=\"00\"]/span/span[2]")
    private WebElement AccountNickNameLabel;

    public WebElement getAccountNickNameLabel() {
        return AccountNickNameLabel;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[1]")
    private WebElement AccountNO;

    public WebElement getAccountNO() {
        return AccountNO;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[2]")
    private WebElement AccountNoLabel;

    public WebElement getAccountNoLabel() {
        return AccountNoLabel;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[1]")
    private WebElement LicensePlate;


    public WebElement getLicensePlate(){
        return LicensePlate;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[2]")
    private WebElement LicensePlateLabel;

    public WebElement getLicensePlateLabel(){
        return LicensePlateLabel;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[4]/div/label")
    private WebElement EmailLabel;

    public WebElement getEmailLabel(){
        return EmailLabel;
    }

    @FindBy(xpath = "//*[@id=\"al-copy-of-contract-confirm-request-email\"]")
    private WebElement EmailAddress;

    public WebElement getEmailAddress(){
        return EmailAddress;
    }

    @FindBy(id = "al-copy-of-contract-confirm-request-confirm-button")
    private WebElement nextBTN;

    public WebElement getNextBTN(){
        return nextBTN;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[4]/span")
    private WebElement emptyEmail;

    public WebElement getEmptyEmail() {
        return emptyEmail;
    }
}
