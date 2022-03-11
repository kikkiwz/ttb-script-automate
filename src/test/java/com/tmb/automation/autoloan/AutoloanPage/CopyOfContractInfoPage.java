package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyOfContractInfoPage {
    public CopyOfContractInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "al-copy-of-contract-info-header-label")
    private WebElement Header;

    public WebElement getHeader() {
        return Header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button")
    private WebElement BackBTn;

    public WebElement getBackBTn() {
        return BackBTn;
    }

    @FindBy(id = "al-copy-of-contract-info-label")
    private WebElement Body;

    public WebElement getBody() {
        return Body;
    }

    @FindBy(id = "al-copy-of-contract-info-next-button")
    private WebElement NextBTn;

    public WebElement getNextBTn(){
        return NextBTn;
    }
}
