package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplySoGoodPartialScenario extends BaseScenario {

    @Test(groups = "Apply So Good Partial", dependsOnGroups = {"Open home screen VIT latest AD572 iOS435"})

    public void applySoGoodNormally() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply so good partial successful");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CREDIT_CARD_RESERVE);
        creDitCard.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON_SSC);
        String creditCard = "images/ApplySoGoodPartial/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        // Click on Apply So GoooD button
        WebElement applySoGoodBt = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_SO_GOOD_BUTTON_SSC);
        applySoGoodBt.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        String applySoGood = "images/ApplySoGoodPartial/Apply so good first page.png";
        takeScreenshot(applySoGood);
        scenario.createNode(Given.class, "Apply so good Page").addScreenCaptureFromPath(applySoGood).pass("pass");

        //Click on Next to select transaction
        WebElement nextPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_INSTALL_PLAN);
        nextPlan.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SELECT_ALL_TRANSACTION);
        Thread.sleep(3000);
        String transactionPlan = "images/ApplySoGoodPartial/Select Transaction page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Select Transaction installment plan Page").addScreenCaptureFromPath(transactionPlan).pass("pass");


        //Selected transaction
        WebElement transaction1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_1);
        transaction1.click();
        WebElement transaction2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_GET_VALUE_TRANSACTION_2);
        transaction2.click();



        String selectedTran = "images/ApplySoGoodPartial/Selected Transaction.png";
        takeScreenshot(selectedTran);
        scenario.createNode(Given.class, "Selected Transaction installment.").addScreenCaptureFromPath(selectedTran).pass("pass");

        //Next to installment plan
        WebElement nextTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        nextTransaction.click();
        Thread.sleep(3000);
        String installPlan = "images/ApplySoGoodPartial/Installment plan page.png";
        takeScreenshot(installPlan);
        scenario.createNode(Given.class, "Installment plan page.").addScreenCaptureFromPath(installPlan).pass("pass");
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(300);

        WebElement select6Month = ttbTestContext.findElement(OneAppElementKeys.LENDING_SELECT_PLAN_6_MONTH);
        select6Month.click();
        Thread.sleep(300);
        String selectMonth = "images/ApplySoGoodPartial/Selected 6 month.png";
        takeScreenshot(selectMonth);
        scenario.createNode(Given.class, "Selected plan 6 month.").addScreenCaptureFromPath(selectMonth).pass("pass");
        Thread.sleep(300);

        // Click Next to detail installment plan
        nextTransaction.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        String detailPlan = "images/ApplySoGoodPartial/Detail installment plan.png";
        takeScreenshot(detailPlan);
        scenario.createNode(Given.class, "Detail installment plan.").addScreenCaptureFromPath(detailPlan).pass("pass");
        Thread.sleep(300);

        WebElement dataTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_DATA_TRANSACTION);
        dataTransaction.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        String dataSelected = "images/ApplySoGoodPartial/Data selected.png";
        takeScreenshot(dataSelected);
        scenario.createNode(Given.class, "Display transaction that selected.").addScreenCaptureFromPath(dataSelected).pass("pass");
        Thread.sleep(1000);

        // Checked box term and condition
        Thread.sleep(5000);
        WebElement tncChecked = ttbTestContext.findElement(OneAppElementKeys.LENDING_TERM_AND_CONDITION_DETAIL_INSTALLMENT);
        tncChecked.click();
        Thread.sleep(300);
        String checkTnC = "images/ApplySoGoodPartial/checkTnC.png";
        takeScreenshot(checkTnC);
        scenario.createNode(Given.class, "Check box Term and Condition").addScreenCaptureFromPath(checkTnC).pass("pass");


        // Click Next to Successful
        nextTransaction.click();
        WebElement clickSoGood = ttbTestContext.findElement(OneAppElementKeys.LENDING_PARTIAL_SUCCESSFUL);
        WebElement textCreditCard = ttbTestContext.findElement(OneAppElementKeys.LENDIND_WORD_CREDIT_CARD_NO);
        WebElement textSelectTransaction = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_SELECTED_TRANSACTION);
        WebElement textTotalInstallment = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TOTAL_INSTALLMENT);
        WebElement textInstallmentPlan = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_INSTALLMENT_PLAN);
        WebElement textTransactionDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_DATE);
        WebElement textTransactionTime = ttbTestContext.findElement(OneAppElementKeys.LENDING_WORD_TRANSACTION_TIME);

        String successSoGood = "images/ApplySoGoodPartial/Partial successful.png";
        takeScreenshot(successSoGood);
        scenario.createNode(Given.class, "Partial Successful apply so good").addScreenCaptureFromPath(successSoGood).pass("pass");


        System.out.println(clickSoGood.getText());
        Assert.assertEquals(clickSoGood.getText(),"Partial successful");
        Assert.assertEquals(textCreditCard.getText(),"Credit card no.");
        Assert.assertEquals(textSelectTransaction.getText(),"Selected transaction");
        Assert.assertEquals(textTotalInstallment.getText(),"Total installment amount");
        Assert.assertEquals(textInstallmentPlan.getText(),"Installment plan");
        Assert.assertEquals(textTransactionDate.getText(),"Transaction date");
        Assert.assertEquals(textTransactionTime.getText(),"Transaction time");

        WebElement backToMainPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_SO_GOOD);
        backToMainPage.click();

        Thread.sleep(4000);
        String mainPage = "images/ApplySoGoodPartial/mainPage.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page After so good Successfully").addScreenCaptureFromPath(mainPage).pass("pass");

        //Swipe up to displayed unbilled
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MAIN_PAGE_UNBILLED);
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        String unBilled = "images/ApplySoGoodPartial/CheckUnBilled.png";
        takeScreenshot(unBilled);
        scenario.createNode(Given.class, "Check Unbilled displayed").addScreenCaptureFromPath(unBilled).pass("pass");
        getExtent().flush();

    }
}
