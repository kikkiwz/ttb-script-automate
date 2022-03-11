package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class ApplySoGoodNormallyScenario extends BaseScenario {

    /*
    @Test(groups = "Apply So Good Normally 3 month Primary Card")
    // 001100000000000000000000506607       7531564253565
    public void soGood3MonthPrimary() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 3 month");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        String accountSum = "images/SoGood3MonthPrimary/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");

        // Credit Card Page.
        System.out.println("Click on Card");
        creDitCard.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Check so goood button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/SoGood3MonthPrimary/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        applySoGoodBt.click();
        Thread.sleep(1000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGood3MonthPrimary/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        Thread.sleep(2000);
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGood3MonthPrimary/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGood3MonthPrimary/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGood3MonthPrimary/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
//        transaction2.click();
        Thread.sleep(1000);

        String tnx1 = "-"+transaction1.getText();
        String tnx2 = "-"+transaction2.getText();
        System.out.println(tnx1+" + "+tnx2);

        String selectedTran = "images/SoGood3MonthPrimary/Selected 2 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 2 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select3Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_3_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGood3MonthPrimary/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 3 month");
        Thread.sleep(1000);
        select3Month.click();
        Thread.sleep(1000);
        String selectMonth = "images/SoGood3MonthPrimary/Selected 3 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 3 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGood3MonthPrimary/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(1000);
        String dataSelected = "images/SoGood3MonthPrimary/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGood3MonthPrimary/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(10000);
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGood3MonthPrimary/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);

        System.out.println("Click Back to Main Page");
        backToMainPage.click();

        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String mainPage = "images/SoGood3MonthPrimary/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/SoGood3MonthPrimary/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

    @Test(groups = "Apply So Good Normally 6 month Primary Card")
    // 001100000000000000000000506607       7531564253565
    public void soGood6MonthPrimary() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 6 month");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        String accountSum = "images/SoGood6MonthPrimary/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");

        // Credit Card Page.
        System.out.println("Click on Card");
        creDitCard.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Check so goood button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/SoGood6MonthPrimary/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        applySoGoodBt.click();
        Thread.sleep(1000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGood6MonthPrimary/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        Thread.sleep(2000);
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGood6MonthPrimary/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGood6MonthPrimary/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGood6MonthPrimary/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
//        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
//        transaction2.click();
        Thread.sleep(1000);

        String tnx1 = "-"+transaction1.getText();
//        String tnx2 = "-"+transaction2.getText();
        System.out.println(tnx1);

        String selectedTran = "images/SoGood6MonthPrimary/Selected 2 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 2 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select6Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_6_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGood6MonthPrimary/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 3 month");
        Thread.sleep(1000);
        select6Month.click();
        Thread.sleep(1000);
        String selectMonth = "images/SoGood6MonthPrimary/Selected 6 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 6 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGood6MonthPrimary/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(1000);
        String dataSelected = "images/SoGood6MonthPrimary/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGood6MonthPrimary/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(10000);
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGood6MonthPrimary/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);

        System.out.println("Click Back to Main Page");
        backToMainPage.click();

        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String mainPage = "images/SoGood6MonthPrimary/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/SoGood6MonthPrimary/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

    @Test(groups = "Apply So Good Normally 10 month Primary Card")
    // 001100000000000000000000506607       7531564253565
    public void soGood10MonthPrimary() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 10 month");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        String accountSum = "images/SoGood10MonthPrimary/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");

        // Credit Card Page.
        System.out.println("Click on Card");
        creDitCard.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Check so goood button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/SoGood10MonthPrimary/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        applySoGoodBt.click();
        Thread.sleep(1000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGood10MonthPrimary/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        Thread.sleep(2000);
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGood10MonthPrimary/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGood10MonthPrimary/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGood10MonthPrimary/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
//        transaction2.click();
        Thread.sleep(1000);

        String tnx1 = "-"+transaction1.getText();
        String tnx2 = "-"+transaction2.getText();
        System.out.println(tnx1+" + "+tnx2);

        String selectedTran = "images/SoGood10MonthPrimary/Selected 2 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 2 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select10Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_10_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGood10MonthPrimary/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 3 month");
        Thread.sleep(1000);
        select10Month.click();
        Thread.sleep(1000);
        String selectMonth = "images/SoGood10MonthPrimary/Selected 10 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 10 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(1000);
        String selectMonthSwipe = "images/SoGood10MonthPrimary/Selected 10 month swipe.png";
        takeScreenshot(selectMonthSwipe);
        scenario.createNode(Given.class, "Selected plan 10 month and Next button enable.").addScreenCaptureFromPath(selectMonthSwipe).pass("pass");
        Thread.sleep(300);


        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGood10MonthPrimary/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(1000);
        String dataSelected = "images/SoGood10MonthPrimary/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGood10MonthPrimary/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(10000);
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGood10MonthPrimary/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);

        System.out.println("Click Back to Main Page");
        backToMainPage.click();

        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String mainPage = "images/SoGood10MonthPrimary/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/SoGood10MonthPrimary/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

     */

    @Test(groups = "Apply So Good Normally 3 month SSC Card")

    public void soGood3MonthSSC() throws InterruptedException, IOException {
        //001100000000000000000000506607	7531564253565
//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 3 month");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        String accountSum = "images/SoGoodSSC3month/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
        creDitCard.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

//        System.out.println(ttbTestContext.getDriver().getPageSource());
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_MORE_BUTTON_SSC_LANDING_PAGE, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_SSC_LANDING_PAGE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_SSC_LANDING_PAGE);
        Thread.sleep(2000);
        String creditCard = "images/SoGoodSSC3month/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/SoGoodSSC3month/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON_SSC);
        applySoGoodBt.click();
        Thread.sleep(10000);
//           ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN, false);
        Thread.sleep(3000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGoodSSC3month/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGoodSSC3month/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        System.out.println("Click ALL");
        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGoodSSC3month/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        System.out.println("Click ALL2");
        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGoodSSC3month/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        System.out.println("Select Transactions");
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
//        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_TRANSACTION_2);
//        transaction2.click();

        String tnx1 = "-"+transaction1.getText();
//        String tnx2 = "-"+transaction2.getText();
//        System.out.println(tnx1+" + "+tnx2);

        String selectedTran = "images/SoGoodSSC3month/Selected 1 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 1 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select3Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_3_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGoodSSC3month/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 3 month");
        Thread.sleep(1000);
        select3Month.click();
        Thread.sleep(300);
        String selectMonth = "images/SoGoodSSC3month/Selected 3 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 3 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        Thread.sleep(2000);

        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        Thread.sleep(5000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN, false);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGoodSSC3month/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        String dataSelected = "images/SoGoodSSC3month/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGoodSSC3month/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(30000);
//        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
//        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
//        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
//        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
//        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
//        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
//        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGoodSSC3month/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");
        System.out.println("Click Back to Main Page");
        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMainPage.click();

        System.out.println("Wait Product Landing");
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(40000);
        String mainPage = "images/SoGoodSSC3month/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        String unBilled = "images/SoGoodSSC3month/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

    /*
    @Test(groups = "Apply So Good Normally 6 month SSC Card")
    // 001100000000000000000012021064       2989208507414
    public void soGood6monthSSC() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 6 month SSC Card");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CREDIT_CARD_RESERVE);
        String accountSum = "images/SoGood6MonthSSC/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");

        // Credit Card Page.
        System.out.println("Click on Card");
        creDitCard.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Check so goood button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/SoGood6MonthSSC/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        applySoGoodBt.click();
        Thread.sleep(1000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGood6MonthSSC/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGood6MonthSSC/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGood6MonthSSC/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGood6MonthSSC/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
//        transaction2.click();

        String tnx1 = "-"+transaction1.getText();
        String tnx2 = "-"+transaction2.getText();
        System.out.println(tnx1+" + "+tnx2);

        String selectedTran = "images/SoGood6MonthSSC/Selected 2 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 2 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select6Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_6_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGood6MonthSSC/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 6 month");
        Thread.sleep(1000);
        select6Month.click();
        Thread.sleep(300);
        String selectMonth = "images/SoGood6MonthSSC/Selected 6 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 6 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGood6MonthSSC/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        String dataSelected = "images/SoGood6MonthSSC/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGood6MonthSSC/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(10000);
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGood6MonthSSC/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);

        System.out.println("Click Back to Main Page");
        backToMainPage.click();

        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String mainPage = "images/SoGood6MonthSSC/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/SoGood6MonthSSC/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

    @Test(groups = "Apply So Good Normally 10 month SSC Card")
    // 001100000000000000000012021064       2989208507414
    public void soGood10monthSSC() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good normally 6 month SSC Card");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        System.out.println("Click Credit summary");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        String accountSum = "images/SoGood10MonthSSC/Account Sumaary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary").addScreenCaptureFromPath(accountSum).pass("pass");

        // Credit Card Page.
        System.out.println("Click on Card");
        creDitCard.click();
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Check so goood button");
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/SoGood10MonthSSC/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        System.out.println("Click so good button");
        applySoGoodBt.click();
        Thread.sleep(1000);
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/SoGood10MonthSSC/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        System.out.println("Click Next to select transaction");
        nextPlan.click();
        WebElement selectAll = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/SoGood10MonthSSC/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll = "images/SoGood10MonthSSC/Select All.png";
        takeScreenshot(imgAll);
        scenario.createNode(Given.class, "Select All Transaction").addScreenCaptureFromPath(imgAll).pass("pass");

        selectAll.click();
        Thread.sleep(2000);
        String imgAll2 = "images/SoGood10MonthSSC/Select All 2.png";
        takeScreenshot(imgAll2);
        scenario.createNode(Given.class, "Select All Transaction to clear").addScreenCaptureFromPath(imgAll2).pass("pass");

        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        Thread.sleep(1000);
        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
        transaction2.click();

        String tnx1 = "-"+transaction1.getText();
        String tnx2 = "-"+transaction2.getText();
        System.out.println(tnx1+" + "+tnx2);

        String selectedTran = "images/SoGood10MonthSSC/Selected 2 Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected 2 Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        System.out.println("Click Next to installment plan");
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(1000);
        WebElement select10Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_10_MONTH);
        WebElement selectInstall =  ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SELECT_INSTALLMENT_PLAN);
        Thread.sleep(1000);
        String installPlan = "images/SoGood10MonthSSC/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Select installment 10 month");
        Thread.sleep(1000);
        select10Month.click();
        Thread.sleep(300);
        String selectMonth = "images/SoGood10MonthSSC/Selected 10 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 10 month and Next button enable.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        String img10Month = "images/SoGood10MonthSSC/10 month.png";
        takeScreenshot(img10Month);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(img10Month).pass("pass");
        Thread.sleep(1000);

        // Click Next to detail installment plan
        System.out.println("Click Next to confirm");
        WebElement nextToCinfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextToCinfirm.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SO_GOOD_DETAIL_OF_INSTALLMENT_PLAN);
        String detailPlan = "images/SoGood10MonthSSC/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        System.out.println("Click selected transaction");
        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        String dataSelected = "images/SoGood10MonthSSC/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        System.out.println("Checked box");
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(1000);
        WebElement confirmBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_CONFIRM_BTN);
        String checkTnC = "images/SoGood10MonthSSC/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click confirm
        System.out.println("Click Confirm");
        confirmBTN.click();
        Thread.sleep(10000);
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_SO_GOOD_SUCCESFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/SoGood10MonthSSC/successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);

        System.out.println("Click Back to Main Page");
        backToMainPage.click();

        System.out.println("Wait Product Landing");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Unbilled display");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String mainPage = "images/SoGood10MonthSSC/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/SoGood10MonthSSC/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }

     */
}
