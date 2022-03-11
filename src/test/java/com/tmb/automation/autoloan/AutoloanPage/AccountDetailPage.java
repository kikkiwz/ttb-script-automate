package com.tmb.automation.autoloan.AutoloanPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailPage {

    public AccountDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")
    private WebElement Header;

    public WebElement getHeader() {
        return Header;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[1]")
    private WebElement TermOfPaid;

    public WebElement getTermOfPaid() {
        return TermOfPaid;
    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[2]")
    private WebElement ProgressBar;

    public WebElement getProgressBar() {
        return ProgressBar;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[3]")
    private WebElement TotalTerm;

    public WebElement getTotalTerm() {
        return TotalTerm;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div[1]")
    private WebElement AccountNickname;

    public WebElement getAccountNickname() {
        return AccountNickname;
    }

    @FindBy(xpath = "//*[@id=\"al-hp-label\"]")
    private WebElement AccNo;

    public WebElement getAccNo() {
        return AccNo;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]")
    private WebElement HPLabel;

    public WebElement getHPLabel() {
        return HPLabel;
    }

    @FindBy(id = "al-remaining-balance-label")
    private WebElement balance;

    public WebElement getBalance() {
        return balance;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]")
    private WebElement balanceLabel;

    public WebElement getBalanceLabel() {
        return balanceLabel;
    }

    @FindBy(id = "al-hp-detail-label")
    private WebElement hpDetailLabel;

    public WebElement getHpDetailLabel() {
        return hpDetailLabel;
    }

    @FindBy(id = "al-installment-label")
    private WebElement installment;

    public WebElement getInstallment() {
        return installment;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]")
    private WebElement instalmentLabel;

    public WebElement getInstalmentLabel() {
        return instalmentLabel;
    }

    @FindBy(id = "al-every-date-label")
    private WebElement dueDate;

    public WebElement getDueDate() {
        return dueDate;
    }

    @FindBy(id = "al-due-date-label")
    private WebElement dueDateLabel;

    public WebElement getDueDateLabel() {
        return dueDateLabel;
    }

    @FindBy(id = "al-next-pay-date-label")
    private WebElement nextPayDate;

    public WebElement getNextPayDate() {
        return nextPayDate;
    }

    @FindBy(id = "al-blue-car-img")
    private WebElement blueCar;

    public WebElement getBlueCar() {
        return blueCar;
    }

    @FindBy(id = "al-black-car-img")
    private WebElement carLogo;

    public WebElement getCarLogo() {
        return carLogo;
    }

    @FindBy(id = "al-other-service-button")
    private WebElement ServiceRequestBTN;


    public WebElement getServiceRequestBTN() {
        return ServiceRequestBTN;
    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[2]/div[4]/div[2]/div[2]")
    private WebElement nextPayLabel;

    public WebElement getNextPayLabel() {
        return nextPayLabel;
    }

    @FindBy(id = "al-last-pay-date-label")
    private WebElement lastPay;

    public WebElement getLastPay() {
        return lastPay;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[2]/div[4]/div[2]/div[2]")
    private WebElement lastPayLabel;

    public WebElement getLastPayLabel() {
        return lastPayLabel;
    }

    @FindBy(id = "al-pay-bill-button")
    private WebElement payBillBTN;

    public WebElement getPayBillBTN() {
        return payBillBTN;
    }

    @FindBy(id = "al-history-button")
    private WebElement paymentHisBTN;

    public WebElement getPaymentHisBTN() {
        return paymentHisBTN;
    }

    @FindBy(id = "al-car-detail-label")
    private WebElement carDetailLabel;

    public WebElement getCarDetailLabel() {
        return carDetailLabel;
    }

    @FindBy(id = "al-brand-model-label")
    private WebElement brandModel;

    public WebElement getBrandModel() {
        return brandModel;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[3]/div[2]/div[1]/div[2]")
    private WebElement brandModelLabel;

    public WebElement getBrandModelLabel() {
        return brandModelLabel;
    }

    @FindBy(id = "al-lc-plate")
    private WebElement licensePlate;

    public WebElement getLicensePlate() {
        return licensePlate;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[3]/div[2]/div[2]/div[2]")
    private WebElement licensePlateLabel;

    public WebElement getLicensePlateLabel() {
        return licensePlateLabel;
    }

    @FindBy(id = "al-tax-due")
    private WebElement taxDueDate;

    public WebElement getTaxDueDate() {
        return taxDueDate;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[3]/div[4]/div[1]/div[2]")
    private WebElement taxDueDateLabel;

    public WebElement getTaxDueDateLabel() {
        return taxDueDateLabel;
    }

    @FindBy(id = "al-insurance-due-date-label")
    private WebElement insuranceDueDate;

    public WebElement getInsuranceDueDate() {
        return insuranceDueDate;
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[3]/div[3]/div[4]/div[2]/div[2]")
    private WebElement insuranceDueDateLabel;

    public WebElement getInsuranceDueDateLabel() {
        return insuranceDueDateLabel;
    }

    @FindBy(id = "al-view-car-book-button")
    private WebElement regisBookBTN;

    public WebElement getRegisBookBTN() {
        return regisBookBTN;
    }
}
