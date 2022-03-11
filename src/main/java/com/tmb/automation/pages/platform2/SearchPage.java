package com.tmb.automation.pages.platform2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menuTab\"]/div/nav/a[3]/span")
    public WebElement adminMenuTab;

    @FindBy(id = "mobileNumberField")
    public WebElement mobileNumberTxt;

    @FindBy(id = "searchButton")
    public WebElement searchBtn;

    @FindBy(id = "clearButton")
    public WebElement clearBtn;

    @FindBy(id = "accountNumberField")
    public WebElement accountNumberTxt;

    @FindBy(id = "passportNumberField")
    public WebElement passportNumberTxt;

    @FindBy(id = "nameField")
    public WebElement nameTxt;

    @FindBy(id = "surnameField")
    public WebElement surnameTxt;

    @FindBy(id = "userIDField")
    public WebElement userIDTxt;

    @FindBy(id = "rmNoField")
    public WebElement rmNoTxt;

    @FindBy(id = "emailField")
    public WebElement emailTxt;

    @FindBy(id = "idCardField")
    public WebElement idCardTxt;

    @FindBy(id = "resultNotFound")
    public WebElement resultNotFoundLbl;

    @FindBy(id = "searchResultHeader")
    public WebElement searchResultHeaderLbl;

    @FindBy(id = "customerSearchTableBodyRow-0")
    public WebElement customerSearchTableBodyRow0Tbl;

    @FindBy(id = "customerSearchTableRow-0Cell-0")
    public WebElement customerSearchTableRow0Cell0Tbl;

    @FindBy(id = "customerSearchTableRow-0Cell-1")
    public WebElement customerSearchTableRow0Cell1Tbl;

    @FindBy(id = "customerSearchTableRow-0Cell-2")
    public WebElement customerSearchTableRow0Cell2Tbl;

    @FindBy(id = "customerSearchTableRow-0Cell-3")
    public WebElement customerSearchTableRow0Cell3Tbl;

    @FindBy(id = "customerSearchTableRow-0Cell-4")
    public WebElement customerSearchTableRow0Cell4Tbl;

}
