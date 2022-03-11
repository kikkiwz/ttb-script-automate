package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplateCopyOfCartransferPage {
    public ComplateCopyOfCartransferPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "al-car-transfer-confirm-comeplete-header")
    private WebElement headerComPlateCarTransfer;

    public WebElement getHeaderComPlateCarTransfer() {
        return headerComPlateCarTransfer;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]")
    private WebElement correctSymbol;

    public WebElement getCorrectSymbol(){
        return correctSymbol;
    }

    @FindBy(id = "al-car-transHfer-complete-description")
    private WebElement bodyComPlateOfCarTransfer;

    public WebElement getBodyComPlateOfCarTransfer() {
        return bodyComPlateOfCarTransfer;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/p")
    private WebElement headerOfBody;

    public WebElement getHeaderOfBody() {
        return headerOfBody;
    }

    @FindBy(xpath = "//*[@id=\"22\"]/span/span[1]")
    private WebElement Email;

    public WebElement getEmail() {
        return Email;
    }


    @FindBy(xpath = "//*[@id=\"al-car-transfer-confirm-complete-done-button\"]")
    private WebElement backToServiceReq;

    public WebElement getBackToServiceReq() {
        return backToServiceReq;
    }


}
