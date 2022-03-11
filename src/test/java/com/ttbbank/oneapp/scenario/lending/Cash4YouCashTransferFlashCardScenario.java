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
import java.nio.file.WatchEvent;

public class Cash4YouCashTransferFlashCardScenario extends BaseScenario {

    @Test(groups = "ฺCash For You Cash Transfer Flash Card")

    public void setAtmPin() throws InterruptedException, IOException {

        //001100000000000000000007398091	3155256002264

        registerCrmByPassOTP("3155256002264");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "ฺCash For You Cash Transfer Flash Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();



        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/ฺCash4YouCT Flash/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Flash Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_FLASH_SELECT_ACCOUNT);
        String getCredit = creDitCard.getText();
        creDitCard.click();

        System.out.println("Wait to data on Product Landing");
        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/ฺCash4YouCT Flash/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate toProduct Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on Block Card
        System.out.println("Click on Cash for you");
        C4YButton.click();
        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(3000);
        String imageNextInfo = "images/Cash4YouCT Flash/.png";
        takeScreenshot(imageNextInfo);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");

        //Click Next on info page
        System.out.println("Click Next");
        nextInfo.click();
        Thread.sleep(3000);
        String imageCash4you = "images/Cash4YouCT Flash/Cash for you page.png";
        takeScreenshot(imageCash4you);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");

        //Click amount
        System.out.println("Click Amount Input");
        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        ckAmount.click();
        Thread.sleep(1000);
        String imAmount = "images/Cash4YouCT Flash/Amount.png";
        takeScreenshot(imAmount);
        scenario.createNode(Given.class, "Click amount input field, App display numeric.").addScreenCaptureFromPath(imAmount).pass("pass");


        //Click out
        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);

        //Input amount less
        System.out.println("Input less than");
        ckAmount.sendKeys("950");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imLess = "images/Cash4YouCT Flash/Input Less.png";
        takeScreenshot(imLess);
        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");

        //Input amount more
        System.out.println("Input more than");
        ckAmount.click();
        Thread.sleep(500);
        ckAmount.sendKeys("800000");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imMore = "images/Cash4YouCT Flash/Input More.png";
        takeScreenshot(imMore);
        scenario.createNode(Given.class, "Input amount more than minimum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");

        //Input correct
        System.out.println("Input in range");
        ckAmount.click();
        Thread.sleep(500);
        ckAmount.sendKeys("6000");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imCorrect = "images/Cash4YouCT Flash/Input amount correct.png";
        takeScreenshot(imCorrect);
        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");

        //swipe
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);

        //Click Cash Transfer
        WebElement selectCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION);
        selectCT.click();
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String imSelectCT = "images/Cash4YouCT Flash/Select Cash Transfer.png";
        takeScreenshot(imSelectCT);
        scenario.createNode(Given.class, "Select option Cash Transfer, App display detail of Cash Transfer").addScreenCaptureFromPath(imSelectCT).pass("pass");


        //Click Next
        System.out.println("Click Next");
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        nextToConfirm.click();

        //scroll down and click confirm
        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
        Thread.sleep(1000);
        String imConfirm = "images/Cash4YouCT Flash/Click Next.png";
        takeScreenshot(imConfirm);
        scenario.createNode(Given.class, "Scroll down and click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");

        //checkbox
        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        checkedBox.click();
        Thread.sleep(300);
        String imChecked = "images/Cash4YouCT Flash/Checked.png";
        takeScreenshot(imChecked);
        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");

        //Click Confirm
        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        confirmBT.click();
        Thread.sleep(1000);
        String imCF = "images/Cash4YouCT Flash/Enter PIN.png";
        takeScreenshot(imCF);
        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");

        //Enter pin
        confirmPin();
        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO);
        String imFinish = "images/Cash4YouCT Flash/Enter PIN.png";
        takeScreenshot(imFinish);
        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");

        // Assert Success screen
        WebElement textFrom = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FROM);
        WebElement textTo = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_TO);
        WebElement textAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_AMOUNT);
        WebElement textPayment = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_PAYMENT);
        WebElement TextFee = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_FEE);
        WebElement textVAT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_VAT);
        WebElement textAnnual = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_ANNUAL);
        WebElement textRef = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_SUCCESS_REF);

        Assert.assertEquals(textFrom.getText(),"From");
        Assert.assertEquals(textTo.getText(),"To");
        Assert.assertEquals(textAmount.getText(),"Amount");
        Assert.assertEquals(textPayment.getText(),"Payment plan");
        Assert.assertEquals(TextFee.getText(),"Fee");
        Assert.assertEquals(textVAT.getText(),"VAT");
        Assert.assertEquals(textAnnual.getText(),"Annual interest rate");
        Assert.assertEquals(textRef.getText(),"Reference No.");

        //Click Back to main page
        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_SO_GOOD);
        backMain.click();
        WebElement checkBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String mainPage = "images/Cash4YouCT Flash/Product Landing main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");

        getExtent().flush();

    }
}
