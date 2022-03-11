package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class SetAtmPinScenario extends BaseScenario {

    @Test(groups = "SET ATM PIN Primary")
    public void setAtmPin() throws InterruptedException, IOException {

        //001100000000000000000000016716	6936177132244
        registerCrmByPassOTP("6936177132244");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "SET ATM PIN Primary Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();


        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Set ATM Primary Card/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_ACCOUNT);
        String getCredit = creDitCard.getText();
        String imgACC = "images/Set ATM Primary Card/Account Summary.png";
        takeScreenshot(imgACC);
        scenario.createNode(Given.class, "Credit Card Summary Page").addScreenCaptureFromPath(imgACC).pass("pass");

        creDitCard.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

//        System.out.println(ttbTestContext.getDriver().getPageSource());
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_SET_ATM_PIM_PRIMARY_MORE_MENU, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SET_ATM_PIM_PRIMARY_MORE_MENU);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIM_PRIMARY_MORE_MENU);
        Thread.sleep(2000);
        String creditCard = "images/Set ATM Primary Card/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/Set ATM Primary Card/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        //Click on Set PIN
        System.out.println("Click on Set Pin");
        WebElement setPin = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_MENU_BUTTON);
        setPin.click();
        WebElement setPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_PAGE);
        Thread.sleep(1000);
        String cardDetailBT = "images/Set ATM Primary Card/Set atm page Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Set ATM PIN page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Enter PIN
        System.out.println("Enter Pin 1111");
        WebElement getInfoSet = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_INFO_LABEL);
        Thread.sleep(5000);
//        Assert.assertEquals(getInfoSet.getText(), "Please Set up your 4-digit PIN.");
        WebElement press1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        String confirmPin = "images/Set ATM Primary Card/Confirm PIN Page.png";
        takeScreenshot(confirmPin);
        scenario.createNode(Given.class, "Confirm PIN Page.").addScreenCaptureFromPath(confirmPin).pass("pass");


        // Confirm PIN
        System.out.println("Enter Pin 1122 Wrong Pin");
        WebElement getInfoConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_INFO_LABEL);
        Thread.sleep(3000);
        Assert.assertEquals(getInfoConfirm.getText(), "Confirm Card PIN");

        WebElement con1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        con1.click();
        Thread.sleep(1000);
        con1.click();
        WebElement con2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN2);
        con2.click();
        Thread.sleep(1000);
        con2.click();
        Thread.sleep(1000);
        String errorPin = "images/Set ATM Primary Card/Wrong PIN Page.png";
        takeScreenshot(errorPin);
        scenario.createNode(Given.class, "Check display error when confirm wrong PIN.").addScreenCaptureFromPath(errorPin).pass("pass");


        //Check error
        System.out.println("Enter Confirm pin Correct");
        WebElement getError = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ERROR);
        Thread.sleep(2000);
//        Assert.assertEquals(getError.getText(), "PIN does not match, please try again.");
        WebElement conEr1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        Thread.sleep(2000);
        conEr1.click();
        conEr1.click();
        conEr1.click();
        conEr1.click();

        Thread.sleep(10000);
        String enterPin = "images/Set ATM Primary Card/Enter PIN.png";
        takeScreenshot(enterPin);
        scenario.createNode(Given.class, "Enter correct PIN, app display Enter PIN to Set ATM Pin.").addScreenCaptureFromPath(enterPin).pass("pass");

        Thread.sleep(10000);
        System.out.println("Set Not Webview to Confirm PIN");
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);
        Thread.sleep(3000);

        confirmPin();

        Thread.sleep(30000);
        System.out.println("Set to Webview");
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, true);

        // Check Successfully
        System.out.println("Check Assert Complete Set PIN");
        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_COMPLETE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_CARD_NUMBER);
        WebElement textChanged = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_CHANGED);

        Assert.assertEquals(textComplete.getText(), "Successfully Set Card PIN");
        Assert.assertEquals(textCardNumber.getText(), "Card number");
        Assert.assertEquals(textChanged.getText(), "PIN has been changed.");

        Thread.sleep(8000);
        String completeP = "images/Set ATM Primary Card/Success.png";
        takeScreenshot(completeP);
        scenario.createNode(Given.class, "App display Complete PIN has been changed.").addScreenCaptureFromPath(completeP).pass("pass");


        // Back to main page
        System.out.println("Back to main page.");
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_BACK_TO_MAIN);
        backToMain.click();

        System.out.println("Waiting");
        Thread.sleep(30000);
        WebElement backMore = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIM_PRIMARY_MORE_MENU);
        Thread.sleep(10000);
        String imgMore = "images/Set ATM Primary Card/Back to main page.png";
        takeScreenshot(imgMore);
        scenario.createNode(Given.class, "Click on Back to Main Page, App navigate to Product Landing Page").addScreenCaptureFromPath(imgMore).pass("pass");

        getExtent().flush();

    }


    @Test(groups = "SET ATM SSC CARD")
    public void setAtmSSC() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565
//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "SET ATM PIN SSC Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();


        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Set ATM SSC Card/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        String getCredit = creDitCard.getText();
        creDitCard.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

//        System.out.println(ttbTestContext.getDriver().getPageSource());
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_SET_ATM_SSC_MORE_BUTTON, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SET_ATM_SSC_MORE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_SSC_MORE_BUTTON);
        Thread.sleep(2000);
        String creditCard = "images/Set ATM SSC Card/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/Set ATM SSC Card/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        //Click on Set PIN
        System.out.println("Click on Set Pin");
        WebElement setPin = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_MENU_BUTTON);
        setPin.click();
        WebElement setPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_PAGE);
        Thread.sleep(1000);
        String cardDetailBT = "images/Set ATM SSC Card/Set atm page Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Set ATM PIN page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Enter PIN
        System.out.println("Enter Pin 1111");
        WebElement getInfoSet = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_INFO_LABEL);
        Thread.sleep(5000);
//        Assert.assertEquals(getInfoSet.getText(), "Please Set up your 4-digit PIN.");
        WebElement press1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        press1.click();
        Thread.sleep(1000);
        String confirmPin = "images/Set ATM SSC Card/Confirm PIN Page.png";
        takeScreenshot(confirmPin);
        scenario.createNode(Given.class, "Confirm PIN Page.").addScreenCaptureFromPath(confirmPin).pass("pass");


        // Confirm PIN
        System.out.println("Enter Pin 1122 Wrong Pin");
        WebElement getInfoConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_INFO_LABEL);
        Thread.sleep(3000);
        Assert.assertEquals(getInfoConfirm.getText(), "Confirm Card PIN");

        WebElement con1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        con1.click();
        Thread.sleep(1000);
        con1.click();
        WebElement con2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN2);
        con2.click();
        Thread.sleep(1000);
        con2.click();
        Thread.sleep(1000);
        String errorPin = "images/Set ATM SSC Card/Wrong PIN Page.png";
        takeScreenshot(errorPin);
        scenario.createNode(Given.class, "Check display error when confirm wrong PIN.").addScreenCaptureFromPath(errorPin).pass("pass");


        //Check error
        System.out.println("Enter Confirm pin Correct");
        WebElement getError = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ERROR);
        Thread.sleep(2000);
//        Assert.assertEquals(getError.getText(), "PIN does not match, please try again.");
        WebElement conEr1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_ENTER_PIN);
        Thread.sleep(2000);
        conEr1.click();
        conEr1.click();
        conEr1.click();
        conEr1.click();

        Thread.sleep(10000);
        String enterPin = "images/Set ATM SSC Card/Enter PIN.png";
        takeScreenshot(enterPin);
        scenario.createNode(Given.class, "Enter correct PIN, app display Enter PIN to Set ATM Pin.").addScreenCaptureFromPath(enterPin).pass("pass");

        Thread.sleep(10000);
        System.out.println("Set Not Webview to Confirm PIN");
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);
        Thread.sleep(3000);

        confirmPin();

        Thread.sleep(30000);
        System.out.println("Set to Webview");
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, true);

        // Check Successfully
        System.out.println("Check Assert Complete Set PIN");
        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_COMPLETE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_CARD_NUMBER);
        WebElement textChanged = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_CHANGED);

        Assert.assertEquals(textComplete.getText(), "Successfully Set Card PIN");
        Assert.assertEquals(textCardNumber.getText(), "Card number");
        Assert.assertEquals(textChanged.getText(), "PIN has been changed.");

        Thread.sleep(8000);
        String completeP = "images/Set ATM SSC Card/Success.png";
        takeScreenshot(completeP);
        scenario.createNode(Given.class, "App display Complete PIN has been changed.").addScreenCaptureFromPath(completeP).pass("pass");


        // Back to main page
        System.out.println("Back to main page.");
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_BACK_TO_MAIN);
        backToMain.click();

        System.out.println("Waiting");
        Thread.sleep(30000);
        WebElement backMore = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_SSC_MORE_BUTTON);
        Thread.sleep(10000);
        String imgMore = "images/Set ATM SSC Card/Back to main page.png";
        takeScreenshot(imgMore);
        scenario.createNode(Given.class, "Click on Back to Main Page, App navigate to Product Landing Page").addScreenCaptureFromPath(imgMore).pass("pass");

        getExtent().flush();

    }


}