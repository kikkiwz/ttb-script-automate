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

public class ActivateCardScenario extends BaseScenario {

    @Test(groups = "Activate Card")
    public void activateCard() throws InterruptedException, IOException {

        //001100000000000000000012021064	2989208507414
//        registerCrmByPassOTP("2989208507414");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();



        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Activate Card/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");


        System.out.println("Click on Card Button");
        cardButton.click();
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CREDIT_CARD_SELECT);
        String cardSum = "images/Activate Card/Credit Card Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Card button, App navigate to Credit Card Summary Page").addScreenCaptureFromPath(accSum).pass("pass");


        System.out.println("Click Activate Credit Card");
        // Credit Card Page.
        creDitCard.click();

        System.out.println("Wait to data on Product Landing");
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 90);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_HEADER);

        Thread.sleep(5000);
        String creditCard = "images/Activate Card/Activate Card.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Select Card that status is inactivate, App navigate to Activate Card Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Tap Enter Card number
        System.out.println("Enter card number");
        WebElement enterCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        enterCard.click();
        Thread.sleep(10000);
        String enterNumber = "images/Activate Card/Enter card number.png";
        takeScreenshot(enterNumber);
        scenario.createNode(Given.class, "Click on Enter card number, App display Enter card number page.").addScreenCaptureFromPath(enterNumber).pass("pass");


        //Enter wrong card number 1
        System.out.println("Enter card number");
        WebElement wrongNumber0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        WebElement wrongNumber1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN1);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(500);

        WebElement textErrorNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_ERROR_ENTER_CARD_NUMBER);
        Assert.assertEquals(textErrorNumber.getText(),"Incorrect card number, please try again.");
        Thread.sleep(2000);
        String wrongNumber = "images/Activate Card/Enter wrong card number.png";
        takeScreenshot(wrongNumber);
        scenario.createNode(Given.class, "Enter wrong card number, App displayed error message.").addScreenCaptureFromPath(wrongNumber).pass("pass");

        //Enter correct card number 1
        System.out.println("Enter correct card number");
        WebElement correctNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        WebElement correctNumber1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN1);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber1.click();
        Thread.sleep(5000);

        WebElement pin0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        String correctCard = "images/Activate Card/Enter correct card number.png";
        takeScreenshot(correctCard);
        scenario.createNode(Given.class, "Enter correct card number, App navigate to Enter CVV page.").addScreenCaptureFromPath(correctCard).pass("pass");

        // Enter wrong CVV
        System.out.println("Enter wrong CVV");
        WebElement wrongCVV = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        wrongCVV.click();
        Thread.sleep(500);
        wrongCVV.click();
        Thread.sleep(500);
        wrongCVV.click();
        Thread.sleep(500);

        WebElement textErrorCVV = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_ERROR_ENTER_CVV);
        Assert.assertEquals(textErrorCVV.getText(),"Incorrect CVV, please try again.");
        String errorCVV = "images/Activate Card/Enter wrong CVV.png";
        takeScreenshot(errorCVV);
        scenario.createNode(Given.class, "Enter wrong CVV, App displayed in-line error.").addScreenCaptureFromPath(errorCVV).pass("pass");


        //Enter Correct CVV
        System.out.println("Enter Correct CVV");
        WebElement correctCVV3 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN3);
        WebElement correctCVV1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN1);
        WebElement correctCVV8 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN8);

        correctCVV3.click();
        Thread.sleep(500);
        correctCVV1.click();
        Thread.sleep(500);
        correctCVV8.click();
        Thread.sleep(500);

        String correctCVV = "images/Activate Card/Enter correct CVV.png";
        takeScreenshot(correctCVV);
        scenario.createNode(Given.class, "Enter correct CVV, App display Enter PIN.").addScreenCaptureFromPath(correctCVV).pass("pass");

        Thread.sleep(5000);
        String enterPIN = "images/Activate Card/Enter PIN.png";
        takeScreenshot(enterPIN);
        scenario.createNode(Given.class, "Enter PIN.").addScreenCaptureFromPath(enterPIN).pass("pass");

        // Confirm PIN
        confirmPin();
        Thread.sleep(5000);

        WebElement textSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_SUCCESSFULLY);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_TEXT_CARD_NUMBER);
        WebElement textCanUse = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_TEXT_CAN_USE);
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_COMPLETE_BUTTON);

        Assert.assertEquals(textSuccess.getText(),"Successfully Activated Card");
        Assert.assertEquals(textCardNumber.getText(),"Card number");
        Assert.assertEquals(textCanUse.getText(),"You can now use this card.");

        String success = "images/Activate Card/Successfully.png";
        takeScreenshot(success);
        scenario.createNode(Given.class, "App displayed Successfully Activated Card.").addScreenCaptureFromPath(success).pass("pass");

        System.out.println("Click Back to Main Page");
        backToMain.click();

        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        System.out.println("Wait to data on Product Landing");
        WebDriverWait wait2 = new WebDriverWait(ttbTestContext.getDriver(), 90);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        Thread.sleep(5000);
        String mainPage = "images/ฺCash4YouCT Credit/Product Landing Page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "App navigate toProduct Landing Page").addScreenCaptureFromPath(mainPage).pass("pass");

        getExtent().flush();

    }

    @Test(groups = "Activate Card SSC Card")
    public void activateCardSSC() throws InterruptedException, IOException {

        //001100000000000000000012021064	2989208507414
//        registerCrmByPassOTP("2989208507414");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();



        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Activate SSC Card/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");


        System.out.println("Click on Card Button");
        cardButton.click();
        Thread.sleep(10000);
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_ACTIVATE_SSC_CARD_SELECTED);
        Thread.sleep(1000);
        String cardSum = "images/Activate SSC Card/Credit Card Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Card button, App navigate to Credit Card Summary Page").addScreenCaptureFromPath(accSum).pass("pass");



        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_SSC_CARD_SELECTED);

        System.out.println("Click Activate Credit Card");
        // Credit Card Page.
        creDitCard.click();

        System.out.println("Wait to data on Product Landing");
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 90);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        WebElement actiHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_HEADER);

        Thread.sleep(5000);
        String creditCard = "images/Activate SSC Card/Activate Card.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Select Card that status is inactivate, App navigate to Activate Card Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Tap Enter Card number
        System.out.println("Enter card number");
        WebElement enterCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        enterCard.click();
        Thread.sleep(10000);
        String enterNumber = "images/Activate SSC Card/Enter card number.png";
        takeScreenshot(enterNumber);
        scenario.createNode(Given.class, "Click on Enter card number, App display Enter card number page.").addScreenCaptureFromPath(enterNumber).pass("pass");


        //Enter wrong card number 1
        System.out.println("Enter card number");
        WebElement wrongNumber0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        WebElement wrongNumber1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN1);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber0.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(500);
        wrongNumber1.click();
        Thread.sleep(5000);

        WebElement textErrorNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_ERROR_ENTER_CARD_NUMBER);
        Assert.assertEquals(textErrorNumber.getText(),"Incorrect card number, please try again.");
        Thread.sleep(2000);
        String wrongNumber = "images/Activate SSC Card/Enter wrong card number.png";
        takeScreenshot(wrongNumber);
        scenario.createNode(Given.class, "Enter wrong card number, App displayed error message.").addScreenCaptureFromPath(wrongNumber).pass("pass");

        //Enter correct card number 1
        System.out.println("Enter correct card number");
        WebElement correctNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        WebElement correctNumber1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN1);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(500);
        correctNumber.click();
        Thread.sleep(5000);

        WebElement pin0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        String correctCard = "images/Activate SSC Card/Enter correct card number.png";
        takeScreenshot(correctCard);
        scenario.createNode(Given.class, "Enter correct card number, App navigate to Enter CVV page.").addScreenCaptureFromPath(correctCard).pass("pass");

        // Enter wrong CVV
        System.out.println("Enter wrong CVV");
        WebElement wrongCVV = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN0);
        wrongCVV.click();
        Thread.sleep(500);
        wrongCVV.click();
        Thread.sleep(500);
        wrongCVV.click();
        Thread.sleep(500);

        WebElement textErrorCVV = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_ERROR_ENTER_CVV);
        Assert.assertEquals(textErrorCVV.getText(),"Incorrect CVV, please try again.");
        String errorCVV = "images/Activate SSC Card/Enter wrong CVV.png";
        takeScreenshot(errorCVV);
        scenario.createNode(Given.class, "Enter wrong CVV, App displayed in-line error.").addScreenCaptureFromPath(errorCVV).pass("pass");


        //Enter Correct CVV
        System.out.println("Enter Correct CVV");
        WebElement correctCVV3 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN2);
        WebElement correctCVV1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN8);
        WebElement correctCVV8 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_ENTER_NUMBER_PIN7);

        correctCVV3.click();
        Thread.sleep(500);
        correctCVV1.click();
        Thread.sleep(500);
        correctCVV8.click();
        Thread.sleep(500);

        String correctCVV = "images/Activate SSC Card/Enter correct CVV.png";
        takeScreenshot(correctCVV);
        scenario.createNode(Given.class, "Enter correct CVV, App display Enter PIN.").addScreenCaptureFromPath(correctCVV).pass("pass");

        Thread.sleep(5000);
        String enterPIN = "images/Activate SSC Card/Enter PIN.png";
        takeScreenshot(enterPIN);
        scenario.createNode(Given.class, "Enter PIN.").addScreenCaptureFromPath(enterPIN).pass("pass");

        // Confirm PIN
        confirmPin();
        Thread.sleep(20000);
        System.out.println("Successfullt");
//        WebElement textSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_SUCCESSFULLY);
//        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_TEXT_CARD_NUMBER);
//        WebElement textCanUse = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_TEXT_CAN_USE);
//
//        Assert.assertEquals(textSuccess.getText(),"Successfully Activated Card");
//        Assert.assertEquals(textCardNumber.getText(),"Card number");
//        Assert.assertEquals(textCanUse.getText(),"You can now use this card.");

        String success = "images/Activate SSC Card/Successfully.png";
        takeScreenshot(success);
        scenario.createNode(Given.class, "App displayed Successfully Activated Card.").addScreenCaptureFromPath(success).pass("pass");

        System.out.println("Click Back to Main Page");
        WebElement backToMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_COMPLETE_BUTTON);
        backToMain.click();
        Thread.sleep(20000);
//        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        System.out.println("Wait to data on Product Landing");
//        WebDriverWait wait2 = new WebDriverWait(ttbTestContext.getDriver(), 90);
//        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        Thread.sleep(20000);
        String mainPage = "images/ฺActivate SSC Card/Product Landing Page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "App navigate to Product Landing Page").addScreenCaptureFromPath(mainPage).pass("pass");



        getExtent().flush();

    }
}
