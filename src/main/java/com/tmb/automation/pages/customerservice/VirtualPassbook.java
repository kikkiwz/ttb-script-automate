package com.tmb.automation.pages.customerservice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VirtualPassbook {
    public VirtualPassbook(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "home-screen-robot-image")
    public WebElement homeScreen;
}
