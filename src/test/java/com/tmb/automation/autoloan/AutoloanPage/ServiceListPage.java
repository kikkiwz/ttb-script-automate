package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceListPage {

    public ServiceListPage (WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "al-request-list-header-label")
    private WebElement ServiceList_header;

    public WebElement getServiceList_header() {
        return ServiceList_header;
    }

    @FindBy(xpath = "//*[@id=\"al_service_request_list_item-44\"]")
    private WebElement CopyOfContact_BTN;

    public WebElement getCopyOfContact_BTN() {
        return CopyOfContact_BTN;
    }

    @FindBy(id = "al_service_request_list_item-22")
    private WebElement carTransferBTn;

    public WebElement getCarTransferBTn(){
        return carTransferBTn;
    }
}

