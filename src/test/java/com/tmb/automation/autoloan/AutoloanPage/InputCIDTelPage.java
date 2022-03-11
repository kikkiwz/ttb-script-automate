package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputCIDTelPage {
    public InputCIDTelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[1]/div/label")
    private WebElement CIDPassportLabel;

    public WebElement getCIDPassportLabel() {

        return CIDPassportLabel;
    }

    @FindBy(id = "al-status-input-id")
    private WebElement InputCIDPassport;

    public WebElement getInputCIDPassport() {

        return InputCIDPassport;
    }

    @FindBy(id = "al-status-input-mobile-number")
    private WebElement inputTell;

    public WebElement getInputTell() {
        return inputTell;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div/div/div[2]/div/label")
    private WebElement TelLabel;

    public WebElement getTelLabel() {
        return TelLabel;
    }

    @FindBy(id = "al-status-note-div")
    private WebElement note;

    public WebElement getNote() {
        return note;
    }

    @FindBy(id = "al-status-next-button")
    private WebElement nextBTN;

    public WebElement getNextBTN() {
        return nextBTN;
    }


}
