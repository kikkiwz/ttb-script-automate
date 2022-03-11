package com.tmb.automation.pages.platform2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement userNameTxt;

    @FindBy(id = "password")
    public WebElement passwordTxt;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(id = "incorrectUsernamePasswordSpan")
    public WebElement incorrectUsernamePasswordLbl;

    @FindBy(id = "errorMessageSpan")
    public WebElement errorMessageSpanLbl;

    @FindBy(id = "loginCloseIcon")
    public WebElement loginCloseIcon;

}
