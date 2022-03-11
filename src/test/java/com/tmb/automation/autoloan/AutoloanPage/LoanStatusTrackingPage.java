package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanStatusTrackingPage {
    public LoanStatusTrackingPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement  LoanStatus_Header;

    public WebElement getLoanStatus_Header() {

        return this.LoanStatus_Header;

    }

    @FindBy(id = "al-view-sale-sheet-button")
    private WebElement ViewSaleSheet_BTN;

    public WebElement getViewSaleSheet_BTN() {
        return ViewSaleSheet_BTN;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button/svg")
    private WebElement Back_BTN;


    public WebElement getBack_BTN() {
        return Back_BTN;
    }

    @FindBy(id = "al-status-list-button-0")
    private WebElement ViewLoanStatusBTN0;

    public WebElement getViewLoanStatusBTN0() {
        return ViewLoanStatusBTN0;
    }

    @FindBy(id = "al-status-list-button-1")
    private WebElement ViewLoanStatusBTN1;

    public WebElement getViewLoanStatusBTN1() {
        return ViewLoanStatusBTN1;
    }

    @FindBy(id = "al-status-list-button-2")
    private WebElement ViewLoanStatusBTN2;

    public WebElement getViewLoanStatusBTN2() {
        return ViewLoanStatusBTN2;
    }

    @FindBy(id = "al-status-list-button-3")
    private WebElement ViewLoanStatusBTN3;

    public WebElement getViewLoanStatusBTN3() {
        return ViewLoanStatusBTN3;
    }

    

    @FindBy(id = "al-status-list-button-4")
    private WebElement ViewLoanStatusBTN4;

    public WebElement getViewLoanStatusBTN4() {
        return ViewLoanStatusBTN4;
    }


}
