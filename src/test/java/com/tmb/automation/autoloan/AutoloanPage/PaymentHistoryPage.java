package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentHistoryPage {
    public PaymentHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

