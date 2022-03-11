package com.tmb.automation.pages.platform2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IEPage {
    public IEPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "moreInfoContainer")
    public WebElement moreInfoContainerLbl;

    @FindBy(id = "overridelink")
    public WebElement overrideLinkLbl;

}
