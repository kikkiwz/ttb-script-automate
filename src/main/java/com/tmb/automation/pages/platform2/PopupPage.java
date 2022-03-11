package com.tmb.automation.pages.platform2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupPage {
    public PopupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertBoxContent")
    public WebElement alertBoxContentLbl;

    @FindBy(id = "alertBoxOKButton")
    public WebElement alertBoxOKBtn;

    @FindBy(id = "alertBoxHeader")
    public WebElement alertBoxHeaderLbl;

    @FindBy(id = "alertBoxClose")
    public WebElement alertBoxCloseIcon;

}
