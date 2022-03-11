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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class SetLimitTempScenario extends BaseScenario {

    @Test(groups = "Set Limit permanent")
    public void setLimitPermanentPrimary() throws InterruptedException, IOException {
        //  UAT    001100000000000000000025521672   3658829646031
        //001100000000000000000000016716	6936177132244
        registerCrmByPassOTP("3658829646031");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Set Limit permanent");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACCOUNT_BUTTON_UAT);
        accountButton.click();
//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON_UAT);
        skipOnAccount.click();


        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Set Limit permanent/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.            4706-80XX-XXXX-0960
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_LIMIT_PERMANENT_SELECT_CARD);
        String getCredit = creDitCard.getText();
        creDitCard.click();

//        System.out.println("Test Wait invisible by ID");
//        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 90);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("credit_landing_more_id")));
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
        String creditCard = "images/Set Limit permanent/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/Set Limit permanent/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        //Click on Adjust usage limit
        System.out.println("Adjust usage limit");
        WebElement adjustUsage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BUTTON);
        adjustUsage.click();
        Thread.sleep(10000);
        WebElement inputLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_INPUT_FIELD);
        String adjustPage = "images/Set Limit permanent/Adjust usage limit page.png";
        takeScreenshot(adjustPage);
        scenario.createNode(Given.class, "Click on Adjust usage limit button, App navigate to Adjust usage limit page.").addScreenCaptureFromPath(adjustPage).pass("pass");

        // Input 0
        System.out.println("Input 0");
        inputLimit.click();
        Thread.sleep(3000);
        inputLimit.clear();
//        for (int i=0; i< 8; i++) {
//            inputLimit.sendKeys("\b");
//        }
        Thread.sleep(3000);
        WebElement clickHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_HEADER);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textInput0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textInput0.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String input0 = "images/Set Limit permanent/Input 0.png";
        takeScreenshot(input0);
        scenario.createNode(Given.class, "Input amount = 0, App display error message").addScreenCaptureFromPath(input0).pass("pass");


//         Input less than
//        System.out.println("Switch to Webview");
//        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        System.out.println("Input Less Than");
        inputLimit.click();
        Thread.sleep(3000);
        inputLimit.clear();
//        for (int i=0; i< 8; i++) {
//            inputLimit.sendKeys("\b");
//        }
        Thread.sleep(3000);
        inputLimit.sendKeys("5000");
        Thread.sleep(3000);
        clickHead.click();

        Thread.sleep(3000);
        WebElement textLessThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textLessThan.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String lessThan = "images/Set Limit permanent/less than.png";
        takeScreenshot(lessThan);
        scenario.createNode(Given.class, "Input amount less than minimum, App display error message").addScreenCaptureFromPath(lessThan).pass("pass");

        // Input More than
        System.out.println("Input More Than");
        inputLimit.click();
        Thread.sleep(3000);
        inputLimit.clear();
//        for (int i=0; i< 8; i++) {
//            inputLimit.sendKeys("\b");
//        }
        Thread.sleep(3000);
        clickHead.click();
        inputLimit.sendKeys("20000000");
        Thread.sleep(3000);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textMoreThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_MORE_THAN);
        Assert.assertEquals(textMoreThan.getText(),"Usage limit cannot exceed maximum card limit.");
        String moreThan = "images/Set Limit permanent/More than.png";
        takeScreenshot(moreThan);
        scenario.createNode(Given.class, "Input amount more than maximum, App display error message").addScreenCaptureFromPath(moreThan).pass("pass");

        // Input Equal same value
        System.out.println("Input equal same value");
        inputLimit.click();
        Thread.sleep(3000);
        inputLimit.clear();
//        for (int i=0; i< 12; i++) {
//            inputLimit.sendKeys("\b");
//        }
        Thread.sleep(3000);
        inputLimit.sendKeys("550000");
        Thread.sleep(3000);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textSame = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_EQUAL);
        Thread.sleep(1000);
        Assert.assertEquals(textSame.getText(),"You have not adjusted the usage limit.");
        String sameValue = "images/Set Limit permanent/Same Value.png";
        takeScreenshot(sameValue);
        scenario.createNode(Given.class, "Input amount equal same value, App display error message").addScreenCaptureFromPath(sameValue).pass("pass");


        // Input correct
        System.out.println("Input correct");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
//        for (int i=0; i< 8; i++) {
//            inputLimit.sendKeys("\b");
//        }
        Thread.sleep(300);
        inputLimit.sendKeys("1000000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textNewLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_LIMIT);
        WebElement nextButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEXT_BUTTON);

//        Assert.assertEquals(textNewLimit.getText(),"");
        String correctInput = "images/Set Limit permanent/Correct amount.png";
        takeScreenshot(correctInput);
        scenario.createNode(Given.class, "Input correct amount, App display button Next").addScreenCaptureFromPath(correctInput).pass("pass");

        //Click On Next
        System.out.println("Click Next");
        nextButton.click();
        WebElement textConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_TEXT_CONFIRM_LIMIT);
        Thread.sleep(15000);
        String confirmLimit = "images/Set Limit permanent/Confirm page.png";
        takeScreenshot(confirmLimit);
        scenario.createNode(Given.class, "Click Next Button, App Navigate to Confirm Adjust usage limit").addScreenCaptureFromPath(confirmLimit).pass("pass");

        //Click on Confirm
        System.out.println("Click Confirm");
        WebElement confirmButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_CONFIRM_BUTTON);
        Thread.sleep(2000);
        confirmButton.click();
        Thread.sleep(5000);

        System.out.println("Switch to Native");
        ttbTestContext.getDriver().context("NATIVE_APP");

        String successFull = "images/Set Limit permanent/Enter PIN.png";
        takeScreenshot(successFull);
        scenario.createNode(Given.class, "Click Confirm Button, App display Enter PIN").addScreenCaptureFromPath(successFull).pass("pass");

        //Enter PIN
        System.out.println("Enter PIN");
        confirmPinOnUAT();

        Thread.sleep(35000);
        System.out.println("Switch to Webview");
        WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_ADJUST_LIMIT_COMPLETE, true);
//        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
        System.out.println("Check Wording");

        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_COMPLETE);
        WebElement textInfo = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_DETAIL_INFO);
        WebElement textNewCredit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_CREDIT);
        WebElement textEffective = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_EFFECTIVE_DATE);
        Assert.assertEquals(textNewCredit.getText(),"New card limit");
        Assert.assertEquals(textEffective.getText(),"Effective date");

        Thread.sleep(1000);
        String enterPIN = "images/Set Limit permanent/Complete Page.png";
        takeScreenshot(enterPIN);
        scenario.createNode(Given.class, "Enter confirm PIN, App Navigate to Complete Adjust usage limit").addScreenCaptureFromPath(enterPIN).pass("pass");


        //Click to Main Page
        System.out.println("Click Back to main Page");
        WebElement backToMainButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMainButton.click();
        Thread.sleep(35000);
        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_LIMIT_PERMANENT_PRIMARY_MORE_MENU);
        Thread.sleep(5000);
        String backToMain = "images/Set Limit permanent/Back to Main.png";
        takeScreenshot(backToMain);
        scenario.createNode(Given.class, "Click Back to main page Button, App Navigate to Main Page").addScreenCaptureFromPath(backToMain).pass("pass");

        getExtent().flush();

    }

    @Test(groups = "Set Limit Temporary")
    public void setLimitTemp() throws InterruptedException, IOException {

//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.DATE, 57);
//        Date d = c.getTime();
//
//        System.out.println("30 days after today is: " + d);
//
//        Format formatter = new SimpleDateFormat("dd MMMM YYYY");
//        String notplus = formatter.format(new Date());
//        String testDate = formatter.format(c.getTime());
//        System.out.println("Not plus "+notplus+" should show now");
//
//        System.out.println(testDate);

//        System.out.println("----------------------------------------");

        //001100000000000000000000506607	7531564253565

//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Set Limit Temporary");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Set Limit Temp/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
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
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(2000);
        String creditCard = "images/Set Limit Temp/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/Set Limit Temp/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        //Click on Adjust usage limit
        System.out.println("Adjust usage limit");
        WebElement adjustUsage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BUTTON);
        adjustUsage.click();
        Thread.sleep(10000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_ADJUST_LIMIT_INPUT_FIELD, false);
        Thread.sleep(3000);
        WebElement inputLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_INPUT_FIELD);
        String adjustPage = "images/Set Limit Temp/Adjust usage limit page.png";
        takeScreenshot(adjustPage);
        scenario.createNode(Given.class, "Click on Adjust usage limit button, App navigate to Adjust usage limit page.").addScreenCaptureFromPath(adjustPage).pass("pass");

        // Input 0
        System.out.println("Input 0");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        WebElement clickHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_HEADER);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textInput0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textInput0.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String input0 = "images/Set Limit Temp/less than.png";
        takeScreenshot(input0);
        scenario.createNode(Given.class, "Input amount = 0, App display error message").addScreenCaptureFromPath(input0).pass("pass");


        // Input less than
        System.out.println("Input Less Than");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("5000");
        Thread.sleep(300);
        clickHead.click();

        Thread.sleep(3000);
        WebElement textLessThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textLessThan.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String lessThan = "images/Set Limit Temp/less than.png";
        takeScreenshot(lessThan);
        scenario.createNode(Given.class, "Input amount less than minimum, App display error message").addScreenCaptureFromPath(lessThan).pass("pass");

        // Input More than
        System.out.println("Input More Than");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("20000000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textMoreThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_MORE_THAN);
        Assert.assertEquals(textMoreThan.getText(),"Usage limit cannot exceed maximum card limit.");
        String moreThan = "images/Set Limit Temp/More than.png";
        takeScreenshot(moreThan);
        scenario.createNode(Given.class, "Input amount more than maximum, App display error message").addScreenCaptureFromPath(moreThan).pass("pass");

        // Input Equal same value
        System.out.println("Input equal same value");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("300000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textSame = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_EQUAL);
        Thread.sleep(1000);
        Assert.assertEquals(textSame.getText(),"You have not adjusted the usage limit.");
        String sameValue = "images/Set Limit Temp/Same Value.png";
        takeScreenshot(sameValue);
        scenario.createNode(Given.class, "Input amount equal same value, App display error message").addScreenCaptureFromPath(sameValue).pass("pass");


        // Input correct
        System.out.println("Input correct");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("310000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textNewLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_LIMIT);
        WebElement nextButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEXT_BUTTON);

//        Assert.assertEquals(textNewLimit.getText(),"");
        String correctInput = "images/Set Limit Temp/Correct amount.png";
        takeScreenshot(correctInput);
        scenario.createNode(Given.class, "Input correct amount, App display Message temporary limit and enable Next button").addScreenCaptureFromPath(correctInput).pass("pass");

        //Click On Next
        System.out.println("Click Next");
        nextButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        WebElement selectBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_LIMIT_SELECT_BOX);
        Thread.sleep(1000);
        String confirmLimit = "images/Set Limit Temp/Reason.png";
        takeScreenshot(confirmLimit);
        scenario.createNode(Given.class, "Click Next Button, App Navigate to Reason for request page.").addScreenCaptureFromPath(confirmLimit).pass("pass");

        System.out.println("Select Box");
        selectBox.click();
        Thread.sleep(2000);
        WebElement educatiobSel = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_LIMIT_EDUCATION);
        Thread.sleep(1000);
        String imgEdu = "images/Set Limit Temp/Select option.png";
        takeScreenshot(imgEdu);
        scenario.createNode(Given.class, "Click select box to choose reason for requesting temporary").addScreenCaptureFromPath(imgEdu).pass("pass");

        System.out.println("Select Education");
        educatiobSel.click();
        Thread.sleep(2000);
        WebElement expiryDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_EXPIRY_DATE);
        Thread.sleep(1000);
        String imgSelected = "images/Set Limit Temp/Select education.png";
        takeScreenshot(imgSelected);
        scenario.createNode(Given.class, "Choose 'For Education' and displayed on select box").addScreenCaptureFromPath(imgSelected).pass("pass");

        System.out.println("Click Expiry");
        expiryDate.click();
        Thread.sleep(3000);
        String imgExp = "images/Set Limit Temp/Click expiry.png";
        takeScreenshot(imgExp);
        scenario.createNode(Given.class, "Click Expiry date to select date.").addScreenCaptureFromPath(imgExp).pass("pass");


        System.out.println("Swipe");
         ttbTestContext.horizontalSwipeByPercentage(0.7, 0.1, 0.5);
        Thread.sleep(3000);

        ttbTestContext.horizontalSwipeByPercentage(0.7, 0.1, 0.5);
        Thread.sleep(3000);
        String imgSwDate = "images/Set Limit Temp/Swipe select date.png";
        takeScreenshot(imgSwDate);
        scenario.createNode(Given.class, "Swipe select date").addScreenCaptureFromPath(imgSwDate).pass("pass");

        Thread.sleep(10000);
        System.out.println("Click Date");
        WebElement selectedDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_SELECTED_DATE);
        Thread.sleep(1000);
        selectedDate.click();
        Thread.sleep(1000);
        String imgClickDate = "images/Set Limit Temp/Click Date.png";
        takeScreenshot(imgClickDate);
        scenario.createNode(Given.class, "Click date").addScreenCaptureFromPath(imgClickDate).pass("pass");


        System.out.println("CLick SET");
        WebElement ckSet = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_CLICK_SET);
        ckSet.click();
        Thread.sleep(5000);
        String imgSet = "images/Set Limit Temp/Click Set.png";
        takeScreenshot(imgSet);
        scenario.createNode(Given.class, "Click on Set button, App displayed expiry date that selected").addScreenCaptureFromPath(imgSet).pass("pass");

        System.out.println("Click Next");
        WebElement ckNexet = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_BUTTON_TRANSACTION);
        ckNexet.click();
        Thread.sleep(10000);
        String imgNext = "images/Set Limit Temp/Confirm page.png";
        takeScreenshot(imgNext);
        scenario.createNode(Given.class, "Click on Next, App navigate to Confirm Page.").addScreenCaptureFromPath(imgNext).pass("pass");

        //Click on Confirm
        System.out.println("Click Confirm");
        WebElement confirmButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_CONFIRM_BUTTON);
        Thread.sleep(2000);
        confirmButton.click();
        Thread.sleep(5000);
        String imgEnterPIN = "images/Set Limit Temp/Enter PIN.png";
        takeScreenshot(imgEnterPIN);
        scenario.createNode(Given.class, "Click Confirm Button, App display Enter PIN").addScreenCaptureFromPath(imgEnterPIN).pass("pass");

        //Enter PIN
        Thread.sleep(1000);
        System.out.println("Enter PIN");
        confirmPin();
        Thread.sleep(20000);

        System.out.println("Check Alphabet");
//        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_SUCCESSFULLY);
//        WebElement textInfo = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_TEMPORARY_INFO_SUCCESS);
        WebElement textExpiry = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_TEMP_EXPIRY_DATE);
        WebElement textNewCredit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_CREDIT);
        WebElement textEffective = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_EFFECTIVE_DATE);
        Assert.assertEquals(textNewCredit.getText(),"New card limit");
        Assert.assertEquals(textEffective.getText(),"Effective date");
        Assert.assertEquals(textExpiry.getText(),"Expiry date");

        Thread.sleep(1000);
        String enterPIN = "images/Set Limit Temp/Complete Page.png";
        takeScreenshot(enterPIN);
        scenario.createNode(Given.class, "Enter confirm PIN, App Navigate to Complete Adjust usage limit").addScreenCaptureFromPath(enterPIN).pass("pass");


        //Click to Main Page
        System.out.println("Click Back to main Page");
        WebElement backToMainButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMainButton.click();
//        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(30000);
        String backToMain = "images/Set Limit Temp/Back to Main.png";
        takeScreenshot(backToMain);
        scenario.createNode(Given.class, "Click Back to main page Button, App Navigate to Main Page").addScreenCaptureFromPath(backToMain).pass("pass");

        getExtent().flush();



    }

    @Test(groups = "Set Limit SUP Card")
    public void setLimitSUP() throws InterruptedException, IOException {

        //001100000000000000000011004078	9446753669299
//        registerCrmByPassOTP("9446753669299");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Set Limit SUP Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();

//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/SetLimitSUP/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");
        String imgAcc = "images/SetLimitSUP/Acc.png";
        takeScreenshot(imgAcc);
        scenario.createNode(Given.class, "Acc page.").addScreenCaptureFromPath(imgAcc).pass("pass");


        cardButton.click();
        Thread.sleep(10000);
//        System.out.println("Swipe to find Card");
//        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CARD_DETAIL_SUP_CARD);
//        Thread.sleep(2000);
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_LIMIT_SUP_CARD_SELECTED);
        String imgCardSUP = "images/SetLimitSUP/SUP Card.png";
        takeScreenshot(imgCardSUP);
        scenario.createNode(Given.class, "SUP Card").addScreenCaptureFromPath(imgCardSUP).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
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
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_SETLIMIT_SUP_MORE_BT_SUP_CARD, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_SETLIMIT_SUP_MORE_BT_SUP_CARD);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_SETLIMIT_SUP_MORE_BT_SUP_CARD);
        Thread.sleep(2000);
        String creditCard = "images/SetLimitSUP/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/SetLimitSUP/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        //Click on Adjust usage limit
        System.out.println("Adjust usage limit");
        WebElement adjustUsage = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BUTTON);
        adjustUsage.click();
        Thread.sleep(10000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_ADJUST_LIMIT_INPUT_FIELD, false);
        Thread.sleep(3000);
        WebElement inputLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_INPUT_FIELD);
        String adjustPage = "images/SetLimitSUP/Adjust usage limit page.png";
        takeScreenshot(adjustPage);
        scenario.createNode(Given.class, "Click on Adjust usage limit button, App navigate to Adjust usage limit page.").addScreenCaptureFromPath(adjustPage).pass("pass");

        // Input 0
        System.out.println("Input 0");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        WebElement clickHead = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_HEADER);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textInput0 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textInput0.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String input0 = "images/SetLimitSUP/Input 0.png";
        takeScreenshot(input0);
        scenario.createNode(Given.class, "Input amount = 0, App display error message").addScreenCaptureFromPath(input0).pass("pass");


        // Input less than
        System.out.println("Input Less Than");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("5000");
        Thread.sleep(300);
        clickHead.click();

        Thread.sleep(3000);
        WebElement textLessThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_LESS_THAN);
        Assert.assertEquals(textLessThan.getText(),"Usage limit cannot be less than outstanding balance or minimum credit limit.");
        String lessThan = "images/SetLimitSUP/less than.png";
        takeScreenshot(lessThan);
        scenario.createNode(Given.class, "Input amount less than minimum, App display error message").addScreenCaptureFromPath(lessThan).pass("pass");

        // Input More than
        System.out.println("Input More Than");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("20000000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textMoreThan = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_MORE_THAN);
        Assert.assertEquals(textMoreThan.getText(),"Usage limit cannot exceed maximum card limit.");
        String moreThan = "images/SetLimitSUP/More than.png";
        takeScreenshot(moreThan);
        scenario.createNode(Given.class, "Input amount more than maximum, App display error message").addScreenCaptureFromPath(moreThan).pass("pass");

        // Input Equal same value
        System.out.println("Input equal same value");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("1000000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textSame = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_ERROR_EQUAL);
        Thread.sleep(1000);
        Assert.assertEquals(textSame.getText(),"You have not adjusted the usage limit.");
        String sameValue = "images/SetLimitSUP/Same Value.png";
        takeScreenshot(sameValue);
        scenario.createNode(Given.class, "Input amount equal same value, App display error message").addScreenCaptureFromPath(sameValue).pass("pass");


        // Input correct
        System.out.println("Input correct");
        inputLimit.click();
        Thread.sleep(300);
        inputLimit.clear();
        Thread.sleep(300);
        inputLimit.sendKeys("500000");
        Thread.sleep(300);
        clickHead.click();
        Thread.sleep(3000);
        WebElement textNewLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_LIMIT);
        WebElement nextButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEXT_BUTTON);

        Assert.assertEquals(textNewLimit.getText(),"New available to spend");
        String correctInput = "images/SetLimitSUP/Correct amount.png";
        takeScreenshot(correctInput);
        scenario.createNode(Given.class, "Input correct amount, App display button Next").addScreenCaptureFromPath(correctInput).pass("pass");

        //Click On Next
        System.out.println("Click Next");
        nextButton.click();
        WebElement textConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_TEXT_CONFIRM_LIMIT);
        Thread.sleep(1000);
        String confirmLimit = "images/SetLimitSUP/Confirm page.png";
        takeScreenshot(confirmLimit);
        scenario.createNode(Given.class, "Click Next Button, App Navigate to Confirm Adjust usage limit").addScreenCaptureFromPath(confirmLimit).pass("pass");

        //Click on Confirm
        System.out.println("Click Confirm");
        WebElement confirmButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_CONFIRM_BUTTON);
        Thread.sleep(2000);
        confirmButton.click();

        Thread.sleep(1000);
        String successFull = "images/SetLimitSUP/Enter PIN.png";
        takeScreenshot(successFull);
        scenario.createNode(Given.class, "Click Confirm Button, App display Enter PIN").addScreenCaptureFromPath(successFull).pass("pass");

        //Enter PIN
        System.out.println("Enter PIN");
        confirmPin();

        WebElement textComplete = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_COMPLETE);
        WebElement textInfo = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_DETAIL_INFO);
        WebElement textNewCredit = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_NEW_CREDIT);
        WebElement textEffective = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_EFFECTIVE_DATE);
        Assert.assertEquals(textNewCredit.getText(),"New card limit");
        Assert.assertEquals(textEffective.getText(),"Effective date");

        Thread.sleep(1000);
        String enterPIN = "images/SetLimitSUP/Complete Page.png";
        takeScreenshot(enterPIN);
        scenario.createNode(Given.class, "Enter confirm PIN, App Navigate to Complete Adjust usage limit").addScreenCaptureFromPath(enterPIN).pass("pass");


        //Click to Main Page
        System.out.println("Click Back to main Page");
        WebElement backToMainButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ADJUST_LIMIT_BACK_TO_MAIN_PAGE);
        backToMainButton.click();
        Thread.sleep(30000);
        String backToMain = "images/SetLimitSUP/Back to Main.png";
        takeScreenshot(backToMain);
        scenario.createNode(Given.class, "Click Back to main page Button, App Navigate to Main Page").addScreenCaptureFromPath(backToMain).pass("pass");

        getExtent().flush();
    }

}
