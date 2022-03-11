package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FlexiLoanScenario extends BaseScenario {

    @Test(groups = "Flexi - Loan Credit Card")
    public void flexiLoanCreditCard() throws InterruptedException, IOException {

        //001100000000000000000000031557	1451500040066

//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "SET ATM PIN Primary Card");
        WebElement serviceBTN = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceBTN.click();
        Thread.sleep(6000);
//        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();


        WebElement applyBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_APPLY_BUTTON);
        String servicePage = "images/FlexiLoanCreditCard/Service home page.png";
        takeScreenshot(servicePage);
        scenario.createNode(Given.class, "Service home page.").addScreenCaptureFromPath(servicePage).pass("pass");

        System.out.println("Click Apply");
        applyBTN.click();
        WebElement creditCardMenu = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_CREDIT_CARD_MENU);
        String imgApplyMenu = "images/FlexiLoanCreditCard/Apply menu.png";
        takeScreenshot(imgApplyMenu);
        scenario.createNode(Given.class, "displayed menu for apply credit card.").addScreenCaptureFromPath(imgApplyMenu).pass("pass");

        System.out.println("Click on Credit Card");
        creditCardMenu.click();
        Thread.sleep(5000);
        String imgEnterPin = "images/FlexiLoanCreditCard/Enter Pin.png";
        takeScreenshot(imgEnterPin);
        scenario.createNode(Given.class, "Click Credit Card, App displayed Enter PIN.").addScreenCaptureFromPath(imgEnterPin).pass("pass");

        System.out.println("Enter PIN");
        enterPin();
        WebElement soSmartCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_SELECTED_SO_SMART);
        Thread.sleep(2000);
        String imgListCredit = "images/FlexiLoanCreditCard/List Credit.png";
        takeScreenshot(imgListCredit);
        scenario.createNode(Given.class, "Enter PIN. App displayed List credit card").addScreenCaptureFromPath(imgListCredit).pass("pass");

        System.out.println("Click So Smart");
        soSmartCard.click();
        WebElement applyCredit = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_APPLY_CREDIT);
        String imgApplyCredit = "images/FlexiLoanCreditCard/Apply Credit.png";
        takeScreenshot(imgApplyCredit);
        scenario.createNode(Given.class, "Click on So Smart credit card, App navigate to Apply Credit card page.").addScreenCaptureFromPath(imgApplyCredit).pass("pass");

        System.out.println("Click apply");
        applyCredit.click();
        WebElement confirmApply = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_APPLY_CREDIT);
        String imgConfirmApply = "images/FlexiLoanCreditCard/Confirm Apply.png";
        takeScreenshot(imgConfirmApply);
        scenario.createNode(Given.class, "Confirm Apply Page.").addScreenCaptureFromPath(imgConfirmApply).pass("pass");

        System.out.println("Click on confirm");
        confirmApply.click();
        WebElement incomeDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLEXI_LOAN_APPLY_CREDIT);
        String imgIncomeDetail = "images/FlexiLoanCreditCard/Income Detail.png";
        takeScreenshot(imgIncomeDetail);
        scenario.createNode(Given.class, "Click on Confirm, App navigate to Income Detail page.").addScreenCaptureFromPath(imgIncomeDetail).pass("pass");


        getExtent().flush();

    }




}