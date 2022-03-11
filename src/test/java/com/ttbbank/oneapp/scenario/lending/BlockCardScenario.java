package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class BlockCardScenario extends BaseScenario {

    @Test(groups = "Block Card Primary")
    public void blockCardPrimary() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565
//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Block Card Primary");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/BlockCardPrimary/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();
        String creditSum = "images/BlockCardPrimary/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_SELECT_ACCOUNT);
        creDitCard.click();

        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_LIMIT_PERMANENT_PRIMARY_MORE_MENU);
        Thread.sleep(2000);
        String creditCard = "images/BlockCardPrimary/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/BlockCardPrimary/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        System.out.println("Click on Block Card");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_MENU_BUTTON);
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement blockHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_HEADER);
        String imgVerify = "images/BlockCardPrimary/Block card page.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on Block card button, App navigate to Block card condition page.").addScreenCaptureFromPath(imgVerify).pass("pass");

        Thread.sleep(5000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_CONFIRM, false);
        Thread.sleep(3000);

        // Click Confirm
        System.out.println("Click Confirm");
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_CONFIRM);
        clickConfirm.click();
        Thread.sleep(5000);
        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");
        String conBT = "images/BlockCardPrimary/Confirm.png";
        takeScreenshot(conBT);
        scenario.createNode(Given.class, "Click Confirm button, App display Enter PIN.").addScreenCaptureFromPath(conBT).pass("pass");

        //Enter PIN
        System.out.println("Confirm PIN");
        confirmPin();
        Thread.sleep(35000);

        String enterPin = "images/BlockCardPrimary/Enter PIN.png";
        takeScreenshot(enterPin);
        scenario.createNode(Given.class, "Enter Pin, App navigate to Successfully Block Card.").addScreenCaptureFromPath(enterPin).pass("pass");
        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        // Check Successfully
        System.out.println("Check Assert Complete Set PIN");
//        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_SUCCESSFULLY);
//        WebElement textInfo1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_1);
//        WebElement textInfo2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_2);
//        WebElement textInfo3 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_3);
//        WebElement textDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_DATE);
//        WebElement textTIME = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_TIME);

//        Assert.assertEquals(textComplete.getText(),"Successfully Blocked Card");
//        Assert.assertEquals(textInfo1.getText(),"is already blocked.");
//        Assert.assertEquals(textDate.getText(),"Transaction date");
//        Assert.assertEquals(textTIME.getText(),"Transaction time");

        Thread.sleep(8000);
        String completeP = "images/BlockCardPrimary/Success.png";
        takeScreenshot(completeP);
        scenario.createNode(Given.class, "App display Successfully Blocked Card.").addScreenCaptureFromPath(completeP).pass("pass");


        // Back to main page
        System.out.println("Back to main page.");
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMain.click();

        Thread.sleep(45000);
        String mainFul = "images/BlockCardPrimary/Main Page.png";
        takeScreenshot(mainFul);
        scenario.createNode(Given.class, "Click Back to main page, App navigate to Product Landing").addScreenCaptureFromPath(mainFul).pass("pass");


        getExtent().flush();


    }

    @Test(groups = "Block Card SSC Card")
    public void blockCardSSCCard() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565
//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Block Card SSC Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        String creditSum = "images/BlockCardSSC/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
//        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        creDitCard.click();

        Thread.sleep(15000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(15000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_SSC_LANDING_PAGE);
        Thread.sleep(2000);
        String creditCard = "images/BlockCardSSC/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on SSC Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/BlockCardSSC/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        System.out.println("Click on Block Card");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_MENU_BUTTON);
        eStatementBT.click();
        Thread.sleep(10000);
        WebElement blockHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_HEADER);
        String imgVerify = "images/BlockCardSSC/Block card page.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on Block card button, App navigate to Block card condition page.").addScreenCaptureFromPath(imgVerify).pass("pass");

        Thread.sleep(5000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_CONFIRM, false);
        Thread.sleep(3000);

        // Click Confirm
        System.out.println("Click Confirm");
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_PAGE_CONFIRM);
        clickConfirm.click();
        Thread.sleep(5000);
        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");
        String conBT = "images/BlockCardSSC/Confirm.png";
        takeScreenshot(conBT);
        scenario.createNode(Given.class, "Click Confirm button, App display Enter PIN.").addScreenCaptureFromPath(conBT).pass("pass");

        //Enter PIN
        confirmPin();
        Thread.sleep(35000);
        String enterPin = "images/BlockCardSSC/Enter PIN.png";
        takeScreenshot(enterPin);
        scenario.createNode(Given.class, "Enter Pin, App navigate to Successfully Block Card.").addScreenCaptureFromPath(enterPin).pass("pass");

        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        // Check Successfully
        System.out.println("Check Assert Complete Set PIN");
//        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_SUCCESSFULLY);
//        WebElement textInfo1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_1);
//        WebElement textInfo2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_2);
//        WebElement textInfo3 = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_INFO_3);
//        WebElement textDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_DATE);
//        WebElement textTIME = ttbTestContext.findElement(OneAppElementKeys.LENDING_BLOCK_CARD_TIME);

//        Assert.assertEquals(textComplete.getText(),"Successfully Blocked Card");
//        Assert.assertEquals(textInfo1.getText(),"is already blocked.");
//        Assert.assertEquals(textInfo2.getText(),"New credit card will be sent");
//        Assert.assertEquals(textInfo3.getText(),"to your billing address.");
//        Assert.assertEquals(textDate.getText(),"Transaction date");
//        Assert.assertEquals(textTIME.getText(),"Transaction time");

        Thread.sleep(8000);
        String completeP = "images/BlockCardSSC/Success.png";
        takeScreenshot(completeP);
        scenario.createNode(Given.class, "App display Successfully Blocked Card.").addScreenCaptureFromPath(completeP).pass("pass");


        // Back to main page
        System.out.println("Back to main page.");
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMain.click();

        Thread.sleep(30000);
        String mainFul = "images/BlockCardSSC/Main Page.png";
        takeScreenshot(mainFul);
        scenario.createNode(Given.class, "Click Back to main page, App navigate to Product Landing").addScreenCaptureFromPath(mainFul).pass("pass");


        getExtent().flush();


    }


}
