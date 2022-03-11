package com.tmb.automation.pages.customerservice;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStatusTrackingPage {
    public CaseStatusTrackingPage(AppiumDriver<WebElement> driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "service-screen-button-passbook")
    public WebElement userNameTxt;
}
