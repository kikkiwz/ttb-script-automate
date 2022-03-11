package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanInputOTPPage {
    public LoanInputOTPPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement header;

    public WebElement getHeader() {
        return header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button")
    private WebElement backBTN;

    public WebElement getBackBTN(){
        return backBTN;
    }


    @FindBy(id = "al-status-otp-head-description")
    private WebElement otpDes;

    public WebElement getOtpDes() {
        return otpDes;
    }

    @FindBy(id = "al-status-otp-head-description")
    private WebElement otpRef;

    public WebElement getOtpRef(){
        return otpRef;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[1]/input")
    private WebElement otp1;

    public WebElement getOtp1() {
        return otp1;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[2]/input")
    private WebElement otp2;

    public WebElement getOtp2() {
        return otp2;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[3]/input")
    private WebElement otp3;

    public WebElement getOtp3() {
        return otp3;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[4]/input")
    private WebElement otp4;

    public WebElement getOtp4() {
        return otp4;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[5]/input")
    private WebElement otp5;


    public WebElement getOtp5() {
        return otp5;
    }

    @FindBy(xpath = "//*[@id=\"al-status-otp-input-container\"]/div/div[6]/input")
    private WebElement otp6;

    public WebElement getOtp6() {
        return otp6;
    }

    @FindBy(id = "al-status-otp-resend-button" )
    private WebElement otpAgain;

    public WebElement getOtpAgain() {
        return otpAgain;
    }
}
