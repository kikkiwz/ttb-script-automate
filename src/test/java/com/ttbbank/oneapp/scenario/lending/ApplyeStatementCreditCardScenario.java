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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplyeStatementCreditCardScenario extends BaseScenario {

    @Test(groups = "Apply e-Statement Credit Card")

    public void applySoGoodNormally() throws InterruptedException, IOException {
        //001100000000000000000018593707	1800272993728

        registerCrmByPassOTP("1800272993728");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start..");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Card Detail");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        try {
            WebElement tryAgain = ttbTestContext.findElement(OneAppElementKeys.LENDING_TRY_AGAIN_ACCOUNT_SUMMARY);
            System.out.println("Try Again Display");
            tryAgain.click();
        } catch (Exception e) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        }

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();

        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CREDIT_CARD_SO_FAST);
        creDitCard.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        String creditCard = "images/ApplyeStatement/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click On more");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        moreButton.click();
        Thread.sleep(1000);


        WebElement eStatement = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON);

        Thread.sleep(500);
        String moreBT = "images/ApplyeStatement/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");


        //Click on Apply e-statement
        eStatement.click();
        WebElement clickTerm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_TERM_CONDITION);
        Thread.sleep(1000);
        String cardDetailBT = "images/ApplyeStatement/Apply e-statement.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Apply e-statement.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        //Click on term and condition
        clickTerm.click();
        Thread.sleep(1000);
        String ckTerm = "images/ApplyeStatement/Term and Conditions.png";
        takeScreenshot(ckTerm);
        scenario.createNode(Given.class, "Click Term and conditions.").addScreenCaptureFromPath(ckTerm).pass("pass");

        //Click Next on Confirm
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_CONFIRM);
        clickConfirm.click();
        WebElement textAlready = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_ESTATEMENT);
        String alreadyHead = "images/ApplyeStatement/Click Confirm.png";
        takeScreenshot(alreadyHead);
        scenario.createNode(Given.class, "Already applied eStatement.").addScreenCaptureFromPath(alreadyHead).pass("pass");

        WebElement textContain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_TEXT);
        WebElement textProduct = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_FINISH_PRODUCT);
        WebElement textType = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_FINISH_TYPE);
        WebElement textMail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_FINISH_EMAIL);

        Assert.assertEquals(textAlready.getText(),"Already applied eStatement.");
        Assert.assertEquals(textContain.getText(),"Every eStatement of you credit cards will be sent to your email starting from next billing cycle.");
        Assert.assertEquals(textProduct.getText(),"Product");
        Assert.assertEquals(textType.getText(),"Credit card");
        Assert.assertEquals(textMail.getText(),"Email");


        WebElement clickMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_STATEMENT);
        clickMain.click();
        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(9000);
        String mainPage = "images/ApplyeStatement/Main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page.").addScreenCaptureFromPath(mainPage).pass("pass");

        //Click More to check
        System.out.println("Click More");
        moreButton2.click();

        System.out.println("Check Button");
        try {
            if (ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON).isDisplayed())
            {
                System.out.println("Assert False");
                Assert.assertFalse(ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON).isDisplayed());

            }

        } catch (Exception e) {
            System.out.println("Assert False");
            System.out.println("Check disappear");
            String disappearState = "images/ApplyeStatement/Button Disappear.png";
            takeScreenshot(disappearState);
            scenario.createNode(Given.class, "Apply e-Statement Button Disappear.").addScreenCaptureFromPath(disappearState).pass("pass");

        }

        getExtent().flush();


    }
}
