package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class CashForYouCTCreditScenario extends BaseScenario {

//    @Test(groups = "Cash for you Cash Transfer")
//    public void cash4youCT() throws InterruptedException, IOException {
//
//        //001100000000000000000000506607	7531564253565
////      registerCrmByPassOTP("7531564253565");
//        TtbTestContext ttbTestContext = getTtbTestContext();
//        System.out.println("Start...");
//
//        ExtentTest scenario = getFeature().createNode(Scenario.class, "Cash for you Cash Transfer Credit Card");
//        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
//        accountButton.click();
//
//        enterPin();
//
////        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
////        skipOnAccount.click();
//
//        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
//        String accSum = "images/Cash4YouCT Credit/Account Summary.png";
//        takeScreenshot(accSum);
//        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");
//
//        cardButton.click();
//
//        System.out.println("Click Credit Card");
//        // Credit Card Page.
//        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
//        creDitCard.click();
//
//        System.out.println("Wait to data on Product Landing");
//
//        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 90);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
//        Thread.sleep(45000);
//
//
//        System.out.println("Search Cash4You");
//        if (ttbTestContext.isAndroid()) {
//            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON, true);
//            Thread.sleep(3000);
//            Set<String> webNames = context.getWindowHandles();
//            for (String s : webNames) {
//                ttbTestContext.getDriver().switchTo().window(s);
//                System.out.println("test : " + s);
//                try {
//                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
//                    break;
//                } catch (Exception e) {
//                    System.out.println("This webview is't to use");
//                }
//            }
//        }
//
//
//
//        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
//        Thread.sleep(10000);
//        String creditCard = "images/Cash4YouCT Credit/Product Landing Page.png";
//        takeScreenshot(creditCard);
//        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");
//
//        //Click on Cash for you
//        System.out.println("Click on Cash for you");
//        C4YButton.click();
//        Thread.sleep(10000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON, false);
//        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
//        Thread.sleep(1000);
//        String imageNextInfo = "images/Cash4YouCT Credit/ccfu.png";
//        takeScreenshot(imageNextInfo);
//        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");
//
//
//        //Click Next on info page
//        System.out.println("Click Next");
//        nextInfo.click();
//        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
//        Thread.sleep(3000);
//        String imageCash4you = "images/Cash4YouCT Credit/Cash for you page.png";
//        takeScreenshot(imageCash4you);
//        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");
//
//        //Click amount
//        System.out.println("Click Amount Input");
//        Thread.sleep(300);
//        ckAmount.click();
//        Thread.sleep(1000);
//        String imAmount = "images/Cash4YouCT Credit/Amount.png";
//        takeScreenshot(imAmount);
//        scenario.createNode(Given.class, "Click amount input field, App display numeric.").addScreenCaptureFromPath(imAmount).pass("pass");
//
//
//        //Click out
//        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);
//
//        //Input amount less
//        System.out.println("Input less than");
//        ckAmount.sendKeys("950");
//        Thread.sleep(500);
//        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
//        Thread.sleep(2000);
//        String imLess = "images/Cash4YouCT Credit/Input Less.png";
//        takeScreenshot(imLess);
//        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");
//
//        //Input amount more
//        System.out.println("Input more than");
//        ckAmount.click();
//        ckAmount.clear();
//        Thread.sleep(500);
//        ttbTestContext.getDriver().getKeyboard().sendKeys("8000000");
////        ckAmount.sendKeys("800000");
//        Thread.sleep(500);
//        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
//        Thread.sleep(2000);
//        String imMore = "images/Cash4YouCT Credit/Input More.png";
//        takeScreenshot(imMore);
//        scenario.createNode(Given.class, "Input amount more than minimum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");
//
//        //Input correct
//        System.out.println("Input in range");
//        ckAmount.click();
//        ckAmount.clear();
//        Thread.sleep(500);
//        ttbTestContext.getDriver().getKeyboard().sendKeys("5012");
////        ckAmount.sendKeys("6000");
//        Thread.sleep(500);
//        ckOut.click();
//        Thread.sleep(8000);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
//        Thread.sleep(2000);
//        String imCorrect = "images/Cash4YouCT Credit/Input amount correct.png";
//        takeScreenshot(imCorrect);
//        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");
//
//        //swipe
//        System.out.println("Swipe");
//        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
//        Thread.sleep(1500);
//
//        //Click Cash Transfer
//        System.out.println("Cash Transfer");
//        WebElement selectCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION);
//        selectCT.click();
//        Thread.sleep(300);
//        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
//        Thread.sleep(300);
//        String imSelectCT = "images/Cash4YouCT Credit/Select Cash Transfer.png";
//        takeScreenshot(imSelectCT);
//        scenario.createNode(Given.class, "Select option Cash Transfer, App display detail of Cash Transfer").addScreenCaptureFromPath(imSelectCT).pass("pass");
//
//
//        //Click Next
//        System.out.println("Click Next");
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
//        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
//        nextToConfirm.click();
//        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
//        Thread.sleep(1000);
//        String imConfirm = "images/Cash4YouCT Credit/Click Next.png";
//        takeScreenshot(imConfirm);
//        scenario.createNode(Given.class, "Scroll down and click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");
//
//        //checkbox
//        System.out.println("Check box");
//        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
//        checkedBox.click();
//        Thread.sleep(1000);
//        String imChecked = "images/Cash4YouCT Credit/Checked.png";
//        takeScreenshot(imChecked);
//        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");
//
//        System.out.println("Swipe to click next");
//        Thread.sleep(1500);
//        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
//        Thread.sleep(1500);
//
//        //Click Confirm
//        System.out.println("Click Confirm");
//        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
//        confirmBT.click();
//        Thread.sleep(3000);
//        String imCF = "images/Cash4YouCT Credit/Enter PIN.png";
//        takeScreenshot(imCF);
//        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");
//
//        //Enter pin
//        System.out.println("Confirm PIN");
//        confirmPin();
//        Thread.sleep(10000);
//        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO);
//        String imFinish = "images/Cash4YouCT Credit/SuccessFully.png";
//        takeScreenshot(imFinish);
//        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");
//
//        // Assert Success screen
//        WebElement textFrom = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FROM);
//        WebElement textTo = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_TO);
//        WebElement textAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_AMOUNT);
////        WebElement textPayment = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_PAYMENT);
//        WebElement TextFee = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FEE);
//        WebElement textVAT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_VAT);
//        WebElement textAnnual = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_ANNUAL);
//        WebElement textRef = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_REF);
//
//        Assert.assertEquals(textFrom.getText(),"From");
//        Assert.assertEquals(textTo.getText(),"To");
//        Assert.assertEquals(textAmount.getText(),"Amount");
////        Assert.assertEquals(textPayment.getText(),"Payment plan");
//        Assert.assertEquals(TextFee.getText(),"Fee");
//        Assert.assertEquals(textVAT.getText(),"VAT");
//        Assert.assertEquals(textAnnual.getText(),"Annual interest rate");
//        Assert.assertEquals(textRef.getText(),"Reference No.");
//
//        //Click Back to main page
//        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
//        backMain.click();
////        WebElement checkBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
////        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
//        Thread.sleep(30000);
//        String mainPage = "images/Cash4YouCT Credit/Product Landing main page.png";
//        takeScreenshot(mainPage);
//        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");
//
//        System.out.println("swipe billed unbilled");
//        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
//        Thread.sleep(5000);
//        String imgSwipeBilled = "images/Cash4YouCT Credit/swipe bill.png";
//        takeScreenshot(imgSwipeBilled);
//        scenario.createNode(Given.class, "Swipe Billed/Unbilled to see transaction.").addScreenCaptureFromPath(imgSwipeBilled).pass("pass");
//
//        getExtent().flush();
//
//
//    }

    @Test(groups = "Cash for you Cash Transfer")
    public void cash4youCT() throws InterruptedException, IOException {

        //001100000000000000000000004608	1637080680771
//        registerCrmByPassOTP("1637080680771");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Cash for you Cash Transfer");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Cash4YouCashTransfer/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        System.out.println("Click Card");
        cardButton.click();
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        String creditSum = "images/Cash4YouCashTransfer/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Credit Card Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");

        System.out.println("Click Credit Card");
        // Credit Card Page.
        creDitCard.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");
        System.out.println("Search Cash4You");

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

        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/Cash4YouCashTransfer/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on Cash for you
        System.out.println("Click on Cash for you");
        C4YButton.click();
        Thread.sleep(10000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON, false);
        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(1000);
        String imageNextInfo = "images/Cash4YouCashTransfer/Info.png";
        takeScreenshot(imageNextInfo);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");

        //Click Next on info page
        System.out.println("Click Next");
        nextInfo.click();
        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        Thread.sleep(3000);
        String imageCash4you = "images/Cash4YouCashTransfer/Cash for you page.png";
        takeScreenshot(imageCash4you);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");

        //Click out
        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);


        //Click amount
        System.out.println("Click Amount Input");
        Thread.sleep(3000);
        ckAmount.click();
        //Input amount less
        Thread.sleep(3000);
        System.out.println("Input less than");
//        ttbTestContext.getDriver().getKeyboard().sendKeys("950");
        ckAmount.sendKeys("950");
        Thread.sleep(2000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imLess = "images/Cash4YouCashTransfer/Input Less.png";
        takeScreenshot(imLess);
        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");

        //Input amount more
        System.out.println("Input more than");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 5; i++) {
            ckAmount.sendKeys("\b");
        }
//        ttbTestContext.getDriver().getKeyboard().sendKeys("\b");
//        Thread.sleep(1000);
//        System.out.println("Delete");
//        ckAmount.sendKeys(Keys.DELETE);
        Thread.sleep(3000);
        ckAmount.sendKeys("8000000");
        Thread.sleep(3000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imMore = "images/Cash4YouCashTransfer/Input More.png";
        takeScreenshot(imMore);
        scenario.createNode(Given.class, "Input amount more than maximum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");

        System.out.println("Not Input");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 8; i++) {
            ckAmount.sendKeys("\b");
        }
        Thread.sleep(3000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imgNotIn = "images/Cash4YouCashTransfer/Not input.png";
        takeScreenshot(imgNotIn);
        scenario.createNode(Given.class, "Not input amount, App displayed inline-error").addScreenCaptureFromPath(imgNotIn).pass("pass");


        //Input correct
        System.out.println("Input in range");
        ckAmount.click();
        Thread.sleep(3000);
        ckAmount.clear();
        Thread.sleep(3000);
        ckAmount.sendKeys("5200");
        Thread.sleep(3000);
        ckOut.click();
        Thread.sleep(8000);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(2000);
        String imCorrect = "images/Cash4YouCashTransfer/Input amount correct.png";
        takeScreenshot(imCorrect);
        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");


        System.out.println("Scroll up");
        ttbTestContext.verticalSwipeByPercentages(0.7,0.3,0.5);
        Thread.sleep(2000);
        String imgDisable = "images/Cash4YouCashTransfer/Select Payment Plan.png";
        takeScreenshot(imgDisable);
        scenario.createNode(Given.class, "Select Payment Plan").addScreenCaptureFromPath(imgDisable).pass("pass");

        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION, true);

        System.out.println("Cash Transfer");
        WebElement selectCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION);
        selectCT.click();
        Thread.sleep(3000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(3000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON,true);
        String imSelectCT = "images/Cash4YouCashTransfer/Select Cash Transfer.png";
        takeScreenshot(imSelectCT);
        scenario.createNode(Given.class, "Select option Cash Transfer, App display detail of Cash Transfer").addScreenCaptureFromPath(imSelectCT).pass("pass");

        //Click Next
        System.out.println("Click Next");
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(3000);
        String imPlan = "images/Cash4YouCashTransfer/Payment Plan.png";
        takeScreenshot(imPlan);
        scenario.createNode(Given.class, "Swipe down to see detail Payment Plan and Next button enable").addScreenCaptureFromPath(imPlan).pass("pass");
        Thread.sleep(300);
        nextToConfirm.click();

        //scroll down and click confirm
//        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        Thread.sleep(1000);
        String imConfirm = "images/Cash4YouCashTransfer/Click Next.png";
        takeScreenshot(imConfirm);
        scenario.createNode(Given.class, "Click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");

        //checkbox
        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        checkedBox.click();
        Thread.sleep(1000);
        String imChecked = "images/Cash4YouCashTransfer/Checked.png";
        takeScreenshot(imChecked);
        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");

//        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        Thread.sleep(5000);

        //Click Confirm
        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        confirmBT.click();
        Thread.sleep(5000);
        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        String imCF = "images/Cash4YouCashTransfer/Enter PIN.png";
        takeScreenshot(imCF);
        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");

        //Enter pin
        confirmPin();
        Thread.sleep(35000);

        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");


        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO);
        String imFinish = "images/Cash4YouCashTransfer/SuccessFully.png";
        takeScreenshot(imFinish);
        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");

        // Assert Success screen
        WebElement textFrom = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FROM);
        WebElement textTo = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_TO);
        WebElement textAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_AMOUNT);
//        WebElement textPayment = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_PAYMENT);
        WebElement TextFee = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FEE);
        WebElement textVAT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_VAT);
        WebElement textAnnual = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_ANNUAL);
        WebElement textRef = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_REF);

        Assert.assertEquals(textFrom.getText(), "From");
        Assert.assertEquals(textTo.getText(), "To");
        Assert.assertEquals(textAmount.getText(), "Amount");
//        Assert.assertEquals(textPayment.getText(),"Payment plan");
        Assert.assertEquals(TextFee.getText(), "Fee");
        Assert.assertEquals(textVAT.getText(), "VAT");
        Assert.assertEquals(textAnnual.getText(), "Annual interest rate");
        Assert.assertEquals(textRef.getText(), "Reference No.");

        //Click Back to main page
        System.out.println("Click Back to Main");
        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_ADVANCE_BACK_TO_MAIN);
        backMain.click();
//        WebElement checkBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(40000);
        String mainPage = "images/Cash4YouCashTransfer/Product Landing main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");

        System.out.println("swipe billed unbilled");
        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        Thread.sleep(2000);

//        WebElement swipeUp = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_UNBILLED_BTN);
//        Thread.sleep(1000);
//        TouchAction sDown = new TouchAction(ttbTestContext.getDriver());
//        Thread.sleep(1000);
//        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(swipeUp)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 1000)).release().perform();
//        Thread.sleep(1000);
//        WebElement billedBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_BILLED_BTN);

        String imgSwipeBilled = "images/Cash4YouCashTransfer/swipe bill.png";
        takeScreenshot(imgSwipeBilled);
        scenario.createNode(Given.class, "Swipe Billed/Unbilled to see transaction.").addScreenCaptureFromPath(imgSwipeBilled).pass("pass");


        getExtent().flush();
    }

    @Test(groups = "Cash For You Cash Advance")
    public void cash4youCA() throws InterruptedException, IOException {

        //001100000000000000000000016716	6936177132244
//        registerCrmByPassOTP("6936177132244");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Cash For You Cash Advance");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Cash4YouAdvance/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        System.out.println("Click Card");
        cardButton.click();
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_ADVANCE_SELECT_ACCOUNT);
        String creditSum = "images/Cash4YouAdvance/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Credit Card Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");

        System.out.println("Click Credit Card");
        // Credit Card Page.
        creDitCard.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");
        System.out.println("Search Cash4You");

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

        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/Cash4YouAdvance/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on Cash for you
        System.out.println("Click on Cash for you");
        C4YButton.click();
        Thread.sleep(10000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON, false);
        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(1000);
        String imageNextInfo = "images/Cash4YouAdvance/.png";
        takeScreenshot(imageNextInfo);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");

        //Click Next on info page
        System.out.println("Click Next");
        nextInfo.click();
        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        Thread.sleep(3000);
        String imageCash4you = "images/Cash4YouAdvance/Cash for you page.png";
        takeScreenshot(imageCash4you);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");

        //Click out
        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);

        /*
        System.out.println("Scroll down to see Payment Plan");
        ttbTestContext.verticalSwipeByPercentages(0.7,0.3,0.5);
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(1000);
        String imgPlanEmpty = "images/Cash4YouAdvance/Empty payment plan.png";
        takeScreenshot(imgPlanEmpty);
        scenario.createNode(Given.class, "Scroll down to see payment plan is empty.").addScreenCaptureFromPath(imgPlanEmpty).pass("pass");
         */

//        System.out.println("Scroll up");
//        ttbTestContext.verticalSwipeByPercentages(0.3,0.7,0.5);

        //Click amount
        System.out.println("Click Amount Input");
        Thread.sleep(3000);
        ckAmount.click();
        //Input amount less
        Thread.sleep(3000);
        System.out.println("Input less than");
//        ttbTestContext.getDriver().getKeyboard().sendKeys("950");
        ckAmount.sendKeys("950");
        Thread.sleep(2000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imLess = "images/Cash4YouAdvance/Input Less.png";
        takeScreenshot(imLess);
        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");

        //Input amount more
        System.out.println("Input more than");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 5; i++) {
            ckAmount.sendKeys("\b");
        }
//        ttbTestContext.getDriver().getKeyboard().sendKeys("\b");
//        Thread.sleep(1000);
//        System.out.println("Delete");
//        ckAmount.sendKeys(Keys.DELETE);
        Thread.sleep(3000);
        ckAmount.sendKeys("8000000");
        Thread.sleep(3000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imMore = "images/Cash4YouAdvance/Input More.png";
        takeScreenshot(imMore);
        scenario.createNode(Given.class, "Input amount more than maximum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");

        System.out.println("Not Input");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 8; i++) {
            ckAmount.sendKeys("\b");
        }
        Thread.sleep(3000);
        ckOut.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String imgNotIn = "images/Cash4YouAdvance/Not input.png";
        takeScreenshot(imgNotIn);
        scenario.createNode(Given.class, "Not input amount, App displayed inline-error").addScreenCaptureFromPath(imgNotIn).pass("pass");


        //Input correct
        System.out.println("Input in range");
        ckAmount.click();
        Thread.sleep(3000);
        ckAmount.clear();
        Thread.sleep(3000);
        ckAmount.sendKeys("5222");
        Thread.sleep(3000);
        ckOut.click();
        Thread.sleep(8000);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(2000);
        String imCorrect = "images/Cash4YouAdvance/Input amount correct.png";
        takeScreenshot(imCorrect);
        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");

        //Click Next
        System.out.println("Click Next");
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(3000);
        String imPlan = "images/Cash4YouAdvance/Payment Plan.png";
        takeScreenshot(imPlan);
        scenario.createNode(Given.class, "Swipe down to see detail Payment Plan and Next button enable").addScreenCaptureFromPath(imPlan).pass("pass");
        Thread.sleep(300);
        nextToConfirm.click();

        //scroll down and click confirm
//        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        Thread.sleep(1000);
        String imConfirm = "images/Cash4YouAdvance/Click Next.png";
        takeScreenshot(imConfirm);
        scenario.createNode(Given.class, "Click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");

        //checkbox
        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        checkedBox.click();
        Thread.sleep(1000);
        String imChecked = "images/Cash4YouAdvance/Checked.png";
        takeScreenshot(imChecked);
        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");

//        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        Thread.sleep(5000);

        //Click Confirm
        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        confirmBT.click();
        Thread.sleep(5000);
        String imCF = "images/Cash4YouAdvance/Enter PIN.png";
        takeScreenshot(imCF);
        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");

        System.out.println("Switch to Native");
        Thread.sleep(2000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);
        Thread.sleep(10000);
        //Enter pin
        confirmPin();
        Thread.sleep(35000);

        System.out.println("Switch to Webview");
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO, true);

        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO);
        String imFinish = "images/Cash4YouAdvance/SuccessFully.png";
        takeScreenshot(imFinish);
        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");

        // Assert Success screen
        WebElement textFrom = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FROM);
        WebElement textTo = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_TO);
        WebElement textAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_AMOUNT);
//        WebElement textPayment = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_PAYMENT);
        WebElement TextFee = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FEE);
        WebElement textVAT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_VAT);
        WebElement textAnnual = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_ANNUAL);
        WebElement textRef = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_REF);

        Assert.assertEquals(textFrom.getText(), "From");
        Assert.assertEquals(textTo.getText(), "To");
        Assert.assertEquals(textAmount.getText(), "Amount");
//        Assert.assertEquals(textPayment.getText(),"Payment plan");
        Assert.assertEquals(TextFee.getText(), "Fee");
        Assert.assertEquals(textVAT.getText(), "VAT");
        Assert.assertEquals(textAnnual.getText(), "Annual interest rate");
        Assert.assertEquals(textRef.getText(), "Reference No.");

        //Click Back to main page
        System.out.println("Click Back to Main");
        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_ADVANCE_BACK_TO_MAIN);
        backMain.click();
//        WebElement checkBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(40000);
        String mainPage = "images/Cash4YouAdvance/Product Landing main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");

//        System.out.println("swipe billed unbilled");
//        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
//        Thread.sleep(5000);

//        WebElement swipeUp = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_UNBILLED_BTN);
//        Thread.sleep(1000);
//        TouchAction sDown = new TouchAction(ttbTestContext.getDriver());
//        Thread.sleep(1000);
//        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(swipeUp)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 1000)).release().perform();
//        Thread.sleep(1000);
//        WebElement billedBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_BILLED_BTN);

//        String imgSwipeBilled = "images/ProductLandingSSC/swipe bill.png";
//        takeScreenshot(imgSwipeBilled);
//        scenario.createNode(Given.class, "Swipe Billed/Unbilled to see transaction.").addScreenCaptureFromPath(imgSwipeBilled).pass("pass");


        getExtent().flush();
    }

    @Test(groups = "Cash for you Cash Chill Chill")
    public void cashChillChill() throws InterruptedException, IOException {
//        001100000000000000000007398091	3155256002264
//        registerCrmByPassOTP("3155256002264");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Cash for you Cash Chill chill Credit Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Cash4YouCashChill/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        creDitCard.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 90);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        Thread.sleep(35000);
        System.out.println("Search Cash4You");
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }


        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/Cash4YouCashChill/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on Cash for you
        System.out.println("Click on Cash for you");
        C4YButton.click();
        Thread.sleep(10000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON, false);
        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(1000);
        String imageNextInfo = "images/Cash4YouCashChill/ccfu.png";
        takeScreenshot(imageNextInfo);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");


        //Click Next on info page
        System.out.println("Click Next");
        nextInfo.click();
        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        Thread.sleep(3000);
        String imageCash4you = "images/Cash4YouCashChill/Cash for you page.png";
        takeScreenshot(imageCash4you);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");

        //Click amount
        System.out.println("Click Amount Input");
        Thread.sleep(3000);
        ckAmount.click();
        Thread.sleep(3000);
        String imAmount = "images/Cash4YouCashChill/Amount.png";
        takeScreenshot(imAmount);
        scenario.createNode(Given.class, "Click amount input field, App display numeric.").addScreenCaptureFromPath(imAmount).pass("pass");

        //Click out
        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);

        //Input amount less
        System.out.println("Input less than");
        ckAmount.sendKeys("950");
        Thread.sleep(3000);
        ckOut.click();
        Thread.sleep(3000);
        String imLess = "images/Cash4YouCashChill/Input Less.png";
        takeScreenshot(imLess);
        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");

        //Input amount more
        System.out.println("Input more than");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 5; i++) {
            ckAmount.sendKeys("\b");
        }
        Thread.sleep(1000);
        ckAmount.sendKeys("800000");
        Thread.sleep(3000);
        ckOut.click();
        Thread.sleep(3000);
        String imMore = "images/Cash4YouCashChill/Input More.png";
        takeScreenshot(imMore);
        scenario.createNode(Given.class, "Input amount more than minimum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");


        //Input correct
        System.out.println("Input in range");
        ckAmount.click();
        Thread.sleep(3000);
        for (int i=0; i< 8; i++) {
            ckAmount.sendKeys("\b");
        }
        Thread.sleep(1000);
        ckAmount.sendKeys("6029");
        Thread.sleep(3000);
        ckOut.click();
        Thread.sleep(10000);
        String imCorrect = "images/Cash4YouCashChill/Input amount correct.png";
        takeScreenshot(imCorrect);
        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");

        //swipe
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(1000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CASH_CHILL_CHILL_PAYMENT_OPTION, true);

        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");

        //Click Cash Chill Chill
        WebElement selectCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_CHILL_PAYMENT_OPTION);
        selectCT.click();
        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(1000);
        String imSelectCT = "images/Cash4YouCashChill/Select Cash Chill.png";
        takeScreenshot(imSelectCT);
        scenario.createNode(Given.class, "Select option Cash Chill Chill, App display detail of Cash Transfer").addScreenCaptureFromPath(imSelectCT).pass("pass");

        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");

        //Click select box
        WebElement stBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_SELECT_BOX_MONTH);
        stBox.click();
        Thread.sleep(3000);
        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");
        Thread.sleep(1000);
        String imSelectBox = "images/Cash4YouCashChill/Select box.png";
        takeScreenshot(imSelectBox);
        scenario.createNode(Given.class, "Select box to choose month.").addScreenCaptureFromPath(imSelectBox).pass("pass");

        //Select 12month
        System.out.println("Select 12 month");
        WebElement stMonth = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_SELECT_12_MONTH);
        stMonth.click();
        Thread.sleep(300);
        String imMonth = "images/Cash4YouCashChill/Select month.png";
        takeScreenshot(imMonth);
        scenario.createNode(Given.class, "Choose 12month.").addScreenCaptureFromPath(imMonth).pass("pass");

        Thread.sleep(1000);
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        String scrollD = "images/Cash4YouCashChill/Scroll.png";
        takeScreenshot(scrollD);
        scenario.createNode(Given.class, "Scroll Down.").addScreenCaptureFromPath(scrollD).pass("pass");


        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        System.out.println("Check Wording");
        //Check FEE
        WebElement tier1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_1_TO_10);
        WebElement tier11 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_11_TO_CHOOSE);
//        WebElement feeTier1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_FEE_TIER_1);
//        WebElement feeTier2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_FEE_TIER_2);
        WebElement more12Tier = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MORE_THAN_11_MONTH);
        WebElement summary = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_PAYMENT_SUMMARY);
        WebElement total = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TOTAL_PAYMENT);
        WebElement monthly = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MONTHLY_PAYMENT);

        Assert.assertEquals(tier1.getText(),"Tier month 1-6");
        Assert.assertEquals(tier11.getText(),"Tier month 7-12");
//        Assert.assertEquals(feeTier1.getText(),"12.99%");
//        Assert.assertEquals(feeTier2.getText(),"22.00%");
        Assert.assertEquals(more12Tier.getText(),"Interest will be calculated as a effective rate.");
        Assert.assertEquals(summary.getText(),"Payment summary");
        Assert.assertEquals(total.getText(),"Total payment");
        Assert.assertEquals(monthly.getText(),"Monthly payment");


        //Click Next
        System.out.println("Click Next");
        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        nextToConfirm.click();
        Thread.sleep(5000);
        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
        Thread.sleep(5000);
        String imConfirm = "images/Cash4YouCashChill/Click Next.png";
        takeScreenshot(imConfirm);
        scenario.createNode(Given.class, "Click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");

        System.out.println("Swipe");
        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        Thread.sleep(1000);
        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        //checkbox
        System.out.println("Click checkbox");
        Thread.sleep(1000);
        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        checkedBox.click();
        Thread.sleep(1000);
        String imChecked = "images/Cash4YouCashChill/Checked.png";
        takeScreenshot(imChecked);
        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");



        //Click Confirm
        System.out.println("Click Confirm");
        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        confirmBT.click();
        Thread.sleep(5000);
        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");
        String imCF = "images/Cash4YouCashChill/Enter PIN.png";
        takeScreenshot(imCF);
        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");

        //Enter pin
        System.out.println("Enter PIN");
        Thread.sleep(1000);
        confirmPin();
        Thread.sleep(40000);
        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        Thread.sleep(1000);
        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_CHILL_INFO);
        String imFinish = "images/Cash4YouCashChill/Success.png";
        takeScreenshot(imFinish);
        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");

        System.out.println("Swipe");
        ttbTestContext.verticalSwipeByPercentages(0.7,0.1,0.5);
        System.out.println("Switch to Webview");
        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");

        // Assert Success screen
        System.out.println("Check Assert");
        WebElement textChill = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_CHILL_INFO);
        WebElement textFrom = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FROM);
        WebElement textTo = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_TO);
        WebElement textAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_AMOUNT);
        WebElement textPayment = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_PAYMENT);
        WebElement textTotal = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TOTAL_PAYMENT);
        WebElement textMonthly = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MONTHLY_PAYMENT);
        WebElement textMonthInstall = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MONTH_INSTALLMENT);
        WebElement TextFee = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FEE);
        WebElement textRef = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_REF);
        WebElement textAnnual = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_ANNUAL);
        WebElement textTier1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_1_TO_10);
        WebElement textTier11 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_11_TO_CHOOSE);


        Assert.assertEquals(textChill.getText(),"Cash Chill Chill Information");
        Assert.assertEquals(textFrom.getText(),"From");
        Assert.assertEquals(textTo.getText(),"To");
        Assert.assertEquals(textAmount.getText(),"Amount");
        Assert.assertEquals(textPayment.getText(),"Payment plan");
        Assert.assertEquals(textTotal.getText(),"Total payment");
        Assert.assertEquals(textMonthly.getText(),"Monthly payment");
        Assert.assertEquals(textMonthInstall.getText(),"No. of monthly installments");
        Assert.assertEquals(TextFee.getText(),"Fee");
        Assert.assertEquals(textRef.getText(),"Reference No.");
        Assert.assertEquals(textAnnual.getText(),"Annual interest rate");
        Assert.assertEquals(textTier1.getText(),"Tier month 1-6");
        Assert.assertEquals(textTier11.getText(),"Tier month 7-12");


        //scroll to see back button
//        System.out.println("Swipe");
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
//        Thread.sleep(3000);
//        String backButton = "images/Cash4YouCC Credit/Back Button.png";
//        takeScreenshot(backButton);
//        scenario.createNode(Given.class, "Scroll down to see Back to Main Page button.").addScreenCaptureFromPath(backButton).pass("pass");


        //Click Back to main page
        System.out.println("Click Back to Main Page");
        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_ADVANCE_BACK_TO_MAIN);
        backMain.click();
        Thread.sleep(35000);
        String mainPage = "images/Cash4YouCashChill/Product Landing main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");

        System.out.println("Bill Unbill");
        ttbTestContext.verticalSwipeByPercentages(0.7, 0.1, 0.5);
        Thread.sleep(3000);
        String imgBill = "images/Cash4YouCashChill/Swipe Bill Unbilled.png";
        takeScreenshot(imgBill);
        scenario.createNode(Given.class, "Swipe billed/Unbilled").addScreenCaptureFromPath(imgBill).pass("pass");


        getExtent().flush();

    }
}
