package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyOfContractComplate {
    public CopyOfContractComplate(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "al-copy-of-contract-complete-header")
    private WebElement complateHeader;

    public WebElement getComplateHeader(){
        return complateHeader;
    }

    @FindBy( xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/div")
    private WebElement SuccessICon;

    public WebElement getSuccessICon() {
        return SuccessICon;
    }

    @FindBy( id = "al-copy-of-contract-complete-description")
    private WebElement body;

    public WebElement getBody() {
        return body;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/p")
    private WebElement ContractReqLable;

    public WebElement getContractReqLable(){
        return ContractReqLable;
    }

    @FindBy(xpath = "//*[@id=\"00\"]/span/span[1]")
    private WebElement ReqNo;

    public WebElement getReqNo() {
        return ReqNo;
    }

    @FindBy(xpath = "//*[@id=\"00\"]/span/span[2]")
    private WebElement ReqNoLable;

    public WebElement getReqNoLable() {
        return ReqNoLable;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[1]")
    private WebElement AccNO;

    public WebElement getAccNO() {
        return AccNO;
    }

    @FindBy(xpath = "//*[@id=\"11\"]/span/span[2]")
    private WebElement AccNOLabel;

    public WebElement getAccNOLabel() {
        return AccNOLabel;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[1]")
    private WebElement emailAdrress;

    public WebElement getEmailAdrress() {
        return emailAdrress;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[2]")
    private WebElement emailAddressLabel;


    public WebElement getEmailAddressLabel() {
        return emailAddressLabel;
    }

    @FindBy(id = "al-copy-of-contract-complete-done-button")
    private WebElement backToSerBTN;

    public WebElement getBackToSerBTN() {
        return backToSerBTN;
    }
}
