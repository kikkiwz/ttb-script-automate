package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarTransferInfoPage {
    public CarTransferInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
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

    @FindBy(xpath = "//*[@id=\"al-car-transfer-info-label\"]")
    private WebElement body;

    public WebElement getBody(){
        return body;
    }

    @FindBy(xpath = "//*[@id=\"al-car-transfer-confirm-info-next-button\"]")
    private  WebElement nextBTN;

    public WebElement getNextBTN(){
        return nextBTN;
    }
}
