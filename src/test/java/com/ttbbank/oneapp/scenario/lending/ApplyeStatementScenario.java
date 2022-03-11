package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
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

public class ApplyeStatementScenario extends BaseScenario {

    @Test(groups = "Apply eStatement Credit Card")
    public void applyeStatement() throws InterruptedException, IOException {

        //001100000000000000000018593707	1800272993728
        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply eStatement Credit Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/ApplyStatementCreditCard/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();
        String creditSum = "images/ApplyStatementCreditCard/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        creDitCard.click();

        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait to data on Product Landing");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(10000);
        String creditCard = "images/ApplyStatementCreditCard/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on more menu");
        moreButton.click();
        Thread.sleep(1000);
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON);
        String moreImage = "images/ApplyStatementCreditCard/more menu.png";
        takeScreenshot(moreImage);
        scenario.createNode(Given.class, "App displayed more menu.").addScreenCaptureFromPath(moreImage).pass("pass");

        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement clickTerm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_CONDITION);
        String imgVerify = "images/ApplyStatementCreditCard/Please Verify.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page and don't have email.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click on Condition");
        clickTerm.click();
        Thread.sleep(1000);
        String ckTerm = "images/ApplyeStatement/Term and Conditions.png";
        takeScreenshot(ckTerm);
        scenario.createNode(Given.class, "Click Term and conditions.").addScreenCaptureFromPath(ckTerm).pass("pass");


        //Click Next on Confirm
        System.out.println("Click Confirm");
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        clickConfirm.click();
        Thread.sleep(5000);
        WebElement textAlready = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_ESTATEMENT);
        WebElement textContain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_TEXT);
        WebElement clickMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_STATEMENT);

        String alreadyHead = "images/ApplyeStatement/Click Confirm.png";
        takeScreenshot(alreadyHead);
        scenario.createNode(Given.class, "Already applied eStatement.").addScreenCaptureFromPath(alreadyHead).pass("pass");

        System.out.println("CLick Back to Main");
        clickMain.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(9000);
        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        String mainPage = "images/ApplyeStatement/Main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page.").addScreenCaptureFromPath(mainPage).pass("pass");

        System.out.println("Click More");
        moreButton2.click();
        Thread.sleep(10000);
        String disappearState = "images/ApplyeStatement/Button Disappear.png";
        takeScreenshot(disappearState);
        scenario.createNode(Given.class, "Apply e-Statement Button Disappear.").addScreenCaptureFromPath(disappearState).pass("pass");
        System.out.println("Finish");


        getExtent().flush();


    }

    @Test(groups = "Apply eStatement Flash Card")
    public void flashCardeStatement() throws InterruptedException, IOException {

        //001100000000000000000007398091	3155256002264

        registerCrmByPassOTP("3155256002264");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply eStatement Flash Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/ApplyStatementFlashCard/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();
        String creditSum = "images/ApplyStatementFlashCard/Account Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");


        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_FLASH_CARD_SELECTED_ACCOUNT);
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
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(2000);
        String creditCard = "images/ApplyStatementFlashCard/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on More button
        System.out.println("Click on More Button");
        moreButton.click();
        Thread.sleep(1000);
        String moreBT = "images/ApplyStatementFlashCard/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");

        System.out.println("Click on Apply eStatement");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_FLASH_CARD_APPLY_ESTATEMENT_BT);
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement clickTerm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_CONDITION);
        String imgVerify = "images/ApplyStatementFlashCard/Apply eSatement page.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click on Condition");
        clickTerm.click();
        Thread.sleep(1000);
        String ckTerm = "images/ApplyStatementFlashCard/Term and Conditions.png";
        takeScreenshot(ckTerm);
        scenario.createNode(Given.class, "Click Term and conditions.").addScreenCaptureFromPath(ckTerm).pass("pass");


        //Click Confirm
        System.out.println("Click Confirm");
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_CONFIRM);
        System.out.println("OK Chrck eStatement");
        Thread.sleep(1000);
        clickConfirm.click();
        Thread.sleep(5000);
        WebElement textAlready = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_ESTATEMENT);
        WebElement textContain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_TEXT);
        WebElement clickMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_STATEMENT);

        String alreadyHead = "images/ApplyStatementFlashCard/Click Confirm.png";
        takeScreenshot(alreadyHead);
        scenario.createNode(Given.class, "Already applied eStatement.").addScreenCaptureFromPath(alreadyHead).pass("pass");

        System.out.println("CLick Back to Main");
        clickMain.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(20000);
        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        String mainPage = "images/ApplyStatementFlashCard/Main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Product Landing Main Page.").addScreenCaptureFromPath(mainPage).pass("pass");

        System.out.println("Click More");
        moreButton2.click();
        Thread.sleep(10000);
        String disappearState = "images/ApplyStatementFlashCard/Button disable.png";
        takeScreenshot(disappearState);
        scenario.createNode(Given.class, "Apply e-Statement Button disable.").addScreenCaptureFromPath(disappearState).pass("pass");
        System.out.println("Finish");


        getExtent().flush();


    }

    @Test(groups = "Loan C2G Apply eStatement Credit Card")
    public void loanC2GApplyeStatement() throws InterruptedException, IOException {

        //001100000000000000000018593707	1800272993728

        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loan C2G Apply eStatement Credit Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.LOAN_HOME_SCREEN_BUTTON);
        String accSum = "images/LoanC2GapplyeStatement/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        System.out.println("Click Loan page");
        cardButton.click();
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CLICK_CARD_LOAN_C2G);
        String creditSum = "images/LoanC2GapplyeStatement/Loan Summary.png";
        takeScreenshot(creditSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Loan Summary Page").addScreenCaptureFromPath(creditSum).pass("pass");


        System.out.println("Click Loan Card");
        creDitCard.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait to data on Product Landing");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/LoanC2GapplyeStatement/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");


        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement clickTerm = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_CONDITION);
        String imgVerify = "images/LoanC2GapplyeStatement/Please Verify.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page and don't have email.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click on Condition");
        clickTerm.click();
        Thread.sleep(1000);
        String ckTerm = "images/LoanC2GapplyeStatement/Term and Conditions.png";
        takeScreenshot(ckTerm);
        scenario.createNode(Given.class, "Click Term and conditions.").addScreenCaptureFromPath(ckTerm).pass("pass");


        //Click Next on Confirm
        System.out.println("Click Confirm");
        WebElement clickConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        clickConfirm.click();
        Thread.sleep(5000);
        WebElement textAlready = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_ESTATEMENT);
        WebElement textContain = ttbTestContext.findElement(OneAppElementKeys.LENDING_ALREADY_APPLY_TEXT);
        WebElement clickMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_STATEMENT);

        String alreadyHead = "images/LoanC2GapplyeStatement/Click Confirm.png";
        takeScreenshot(alreadyHead);
        scenario.createNode(Given.class, "Already applied eStatement.").addScreenCaptureFromPath(alreadyHead).pass("pass");

        System.out.println("CLick Back to Main");
        clickMain.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(9000);
        WebElement moreButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAY_BILL_MENU);
        String disappearState = "images/LoanC2GapplyeStatement/Button Disappear.png";
        takeScreenshot(disappearState);
        scenario.createNode(Given.class, "Apply e-Statement Button Disappear.").addScreenCaptureFromPath(disappearState).pass("pass");
        System.out.println("Finish");


        getExtent().flush();


    }

    @Test(groups = "eStatement Verify email")
    public void eStatementVerifyMail() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565

        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Apply eStatement Verify Email");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/ApplyStatementVerifyEmail/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        creDitCard.click();

        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        System.out.println("Wait to data on Product Landing");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(10000);
        String creditCard = "images/ApplyStatementVerifyEmail/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on more menu");
        moreButton.click();
        Thread.sleep(1000);
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON);
        String moreImage = "images/ApplyStatementVerifyEmail/more menu.png";
        takeScreenshot(moreImage);
        scenario.createNode(Given.class, "App displayed more menu.").addScreenCaptureFromPath(moreImage).pass("pass");

        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement verifyDesc = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_VERIFY_DES);
        String imgVerify = "images/ApplyStatementVerifyEmail/Please Verify.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page and don't have email.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click Verify email");
        WebElement verifyButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        verifyButton.click();
        WebElement manageEmail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgManage = "images/ApplyStatementVerifyEmail/Mange Email.png";
        takeScreenshot(imgManage);
        scenario.createNode(Given.class, "Click verify email, App navigate to Manage Email").addScreenCaptureFromPath(imgManage).pass("pass");


        System.out.println("Click 'X'");
        WebElement clearText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText.click();
        Thread.sleep(1000);
        String imgClear = "images/ApplyStatementVerifyEmail/Clear Text.png";
        takeScreenshot(imgClear);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear).pass("pass");

        System.out.println("Click Input box");
        WebElement inputText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_INPUT);
        inputText.click();
        Thread.sleep(1000);
        String imgInput = "images/ApplyStatementVerifyEmail/Input Text.png";
        takeScreenshot(imgInput);
        scenario.createNode(Given.class, "Click on Input box to input email.").addScreenCaptureFromPath(imgInput).pass("pass");

        System.out.println("Input wrong email");
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja");
        String imgWrongMail = "images/ApplyStatementVerifyEmail/Input wrong Email.png";
        takeScreenshot(imgWrongMail);
        scenario.createNode(Given.class, "Input wrong email.").addScreenCaptureFromPath(imgWrongMail).pass("pass");

        System.out.println("Click Next");
        WebElement nextToError = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        nextToError.click();
        WebElement errorFormat = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgError = "images/ApplyStatementVerifyEmail/Error format.png";
        takeScreenshot(imgError);
        scenario.createNode(Given.class, "Click Next, App displayed error wrong email format").addScreenCaptureFromPath(imgError).pass("pass");

        System.out.println("Clear");
        clearText.click();
        Thread.sleep(1000);
        String imgClear2 = "images/ApplyStatementVerifyEmail/Clear Text 2.png";
        takeScreenshot(imgClear2);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear2).pass("pass");

        System.out.println("Input email");
        inputText.click();
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja619@gmail.com");
        String imgInputMail = "images/ApplyStatementVerifyEmail/Input Email.png";
        takeScreenshot(imgInputMail);
        scenario.createNode(Given.class, "Input email.").addScreenCaptureFromPath(imgInputMail).pass("pass");


        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNext = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNext.click();
        Thread.sleep(500);
        String imgNext = "images/ApplyStatementVerifyEmail/click Next to Enter PIN.png";
        takeScreenshot(imgNext);
        scenario.createNode(Given.class, "Click Next, App navigate to Enter PIN.").addScreenCaptureFromPath(imgNext).pass("pass");

        System.out.println("Confirm PIN");
        confirmPin();
        Thread.sleep(1000);
        WebElement headerMail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_HEADER);
        String imgInputOTP1 = "images/ApplyStatementVerifyEmail/Input OTP.png";
        takeScreenshot(imgInputOTP1);
        scenario.createNode(Given.class, "Input OTP").addScreenCaptureFromPath(imgInputOTP1).pass("pass");


        System.out.println("Enter OTP");
        WebElement inputOTP = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_OTP_1);
        inputOTP.click();
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        String img2digis = "images/ApplyStatementVerifyEmail/Input OTP 2 digits.png";
        takeScreenshot(img2digis);
        scenario.createNode(Given.class, "Input OTP 2 digits").addScreenCaptureFromPath(img2digis).pass("pass");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);

        System.out.println("Success");
        WebElement successBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_BUTTON);
        WebElement titleSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_TITLE);
        WebElement messageSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_MESSAGE);
        Thread.sleep(5000);
        String imgSuccess = "images/ApplyStatementVerifyEmail/Success Verify.png";
        takeScreenshot(imgSuccess);
        scenario.createNode(Given.class, "After Input OTP App navigate to Success page.").addScreenCaptureFromPath(imgSuccess).pass("pass");

        System.out.println("Click success button");
        successBT.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        WebElement changeButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        String imgMange = "images/ApplyStatementVerifyEmail/Mail change.png";
        takeScreenshot(imgMange);
        scenario.createNode(Given.class, "After click success button, App navigate to Manage email page and email that verify should displayed.").addScreenCaptureFromPath(imgMange).pass("pass");


        System.out.println("Finish");
        getExtent().flush();


    }

    @Test(groups = "Loan Apply eStatement Verify email")
    public void LoaneStatementVerifyMail() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565

        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loan Apply eStatement Verify Email");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.LOAN_HOME_SCREEN_BUTTON);
        String accSum = "images/LoanApplyStatementVerifyEmail/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Loan Card");
        // Credit Card Page.
        WebElement loanSum = ttbTestContext.findElement(OneAppElementKeys.LENDING_CLICK_CARD_LOAN_C2G);
        String imgLoanSum = "images/LoanApplyStatementVerifyEmail/Loan summary.png";
        takeScreenshot(imgLoanSum);
        scenario.createNode(Given.class, "Loan Summary").addScreenCaptureFromPath(imgLoanSum).pass("pass");

        loanSum.click();

        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        System.out.println("Wait to data on Product Landing");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/LoanApplyStatementVerifyEmail/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement verifyDesc = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_ESTATEMENT_VERIFY_DES);
        String imgVerify = "images/LoanApplyStatementVerifyEmail/Please Verify.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page and don't have email.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click Verify email");
        WebElement verifyButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        verifyButton.click();
        WebElement manageEmail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgManage = "images/LoanApplyStatementVerifyEmail/Mange Email.png";
        takeScreenshot(imgManage);
        scenario.createNode(Given.class, "Click verify email, App navigate to Manage Email").addScreenCaptureFromPath(imgManage).pass("pass");


        System.out.println("Click 'X'");
        WebElement clearText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText.click();
        Thread.sleep(1000);
        String imgClear = "images/LoanApplyStatementVerifyEmail/Clear Text.png";
        takeScreenshot(imgClear);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear).pass("pass");

        System.out.println("Click Input box");
        WebElement inputText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_INPUT);
        inputText.click();
        Thread.sleep(1000);
        String imgInput = "images/LoanApplyStatementVerifyEmail/Input Text.png";
        takeScreenshot(imgInput);
        scenario.createNode(Given.class, "Click on Input box to input email.").addScreenCaptureFromPath(imgInput).pass("pass");

        System.out.println("Input wrong email");
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja");
        String imgWrongMail = "images/LoanApplyStatementVerifyEmail/Input wrong Email.png";
        takeScreenshot(imgWrongMail);
        scenario.createNode(Given.class, "Input wrong email.").addScreenCaptureFromPath(imgWrongMail).pass("pass");

        System.out.println("Click Next");
        WebElement nextToError = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        nextToError.click();
        WebElement errorFormat = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgError = "images/LoanApplyStatementVerifyEmail/Error format.png";
        takeScreenshot(imgError);
        scenario.createNode(Given.class, "Click Next, App displayed error wrong email format").addScreenCaptureFromPath(imgError).pass("pass");

        System.out.println("Clear");
        clearText.click();
        Thread.sleep(1000);
        String imgClear2 = "images/LoanApplyStatementVerifyEmail/Clear Text 2.png";
        takeScreenshot(imgClear2);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear2).pass("pass");

        System.out.println("Input email");
        inputText.click();
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja620@gmail.com");
        String imgInputMail = "images/LoanApplyStatementVerifyEmail/Input Email.png";
        takeScreenshot(imgInputMail);
        scenario.createNode(Given.class, "Input email.").addScreenCaptureFromPath(imgInputMail).pass("pass");


        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNext = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNext.click();
        Thread.sleep(500);
        String imgNext = "images/LoanApplyStatementVerifyEmail/click Next to Enter PIN.png";
        takeScreenshot(imgNext);
        scenario.createNode(Given.class, "Click Next, App navigate to Enter PIN.").addScreenCaptureFromPath(imgNext).pass("pass");

        System.out.println("Confirm PIN");
        confirmPin();
        Thread.sleep(1000);
        WebElement headerMail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_HEADER);
        String imgInputOTP1 = "images/LoanApplyStatementVerifyEmail/Input OTP.png";
        takeScreenshot(imgInputOTP1);
        scenario.createNode(Given.class, "Input OTP").addScreenCaptureFromPath(imgInputOTP1).pass("pass");


        System.out.println("Enter OTP");
        WebElement inputOTP = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_OTP_1);
        inputOTP.click();
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        String img2digis = "images/LoanApplyStatementVerifyEmail/Input OTP 2 digits.png";
        takeScreenshot(img2digis);
        scenario.createNode(Given.class, "Input OTP 2 digits").addScreenCaptureFromPath(img2digis).pass("pass");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);

        System.out.println("Success");
        WebElement successBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_BUTTON);
        WebElement titleSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_TITLE);
        WebElement messageSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_MESSAGE);
        Thread.sleep(5000);
        String imgSuccess = "images/LoanApplyStatementVerifyEmail/Success Verify.png";
        takeScreenshot(imgSuccess);
        scenario.createNode(Given.class, "After Input OTP App navigate to Success page.").addScreenCaptureFromPath(imgSuccess).pass("pass");

        System.out.println("Click success button");
        successBT.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        WebElement changeButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        String imgMange = "images/LoanApplyStatementVerifyEmail/Mail change.png";
        takeScreenshot(imgMange);
        scenario.createNode(Given.class, "After click success button, App navigate to Manage email page and email that verify should displayed.").addScreenCaptureFromPath(imgMange).pass("pass");


        System.out.println("Finish");
        getExtent().flush();


    }

    @Test(groups = "Change Email")
    public void changeEmail() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565

//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Change Email");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/ChangeEmail/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        creDitCard.click();

        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));

        System.out.println("Wait to data on Product Landing");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(10000);
        String creditCard = "images/ChangeEmail/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on more menu");
        moreButton.click();
        Thread.sleep(1000);
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_APPLY_STATEMENT_BUTTON);
        String moreImage = "images/ChangeEmail/more menu.png";
        takeScreenshot(moreImage);
        scenario.createNode(Given.class, "App displayed more menu.").addScreenCaptureFromPath(moreImage).pass("pass");

        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(1000);
        WebElement changeButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_CHANGE_EMAIL_BUTTON);
        String imgVerify = "images/ChangeEmail/Change email.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click Change Email");
        changeButton.click();
        Thread.sleep(1000);
        WebElement confirmToChange = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_CONFIRM_TO_CHANGE_EMAIL);
        String imgConfirm = "images/ChangeEmail/Pop-up Confirm.png";
        takeScreenshot(imgConfirm);
        scenario.createNode(Given.class, "Click verify email, App pop-up displayed Confirm").addScreenCaptureFromPath(imgConfirm).pass("pass");

        System.out.println("Click Confirm to Change");
        confirmToChange.click();
        Thread.sleep(1000);
        WebElement manageEmail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgManage = "images/ChangeEmail/Mange Email.png";
        takeScreenshot(imgManage);
        scenario.createNode(Given.class, "Click verify email, App navigate to Manage Email").addScreenCaptureFromPath(imgManage).pass("pass");


        System.out.println("Click 'X'");
        WebElement clearText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText.click();
        Thread.sleep(1000);
        String imgClear = "images/ChangeEmail/Clear Text.png";
        takeScreenshot(imgClear);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear).pass("pass");

        System.out.println("Click Input box");
        WebElement inputText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_INPUT);
        inputText.click();
        Thread.sleep(1000);
        String imgInput = "images/ChangeEmail/Input Text.png";
        takeScreenshot(imgInput);
        scenario.createNode(Given.class, "Click on Input box to input email.").addScreenCaptureFromPath(imgInput).pass("pass");

        System.out.println("Input wrong email");
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja");
        String imgInputWrong = "images/ChangeEmail/Input Wrong Email.png";
        takeScreenshot(imgInputWrong);
        scenario.createNode(Given.class, "Input wrong email.").addScreenCaptureFromPath(imgInputWrong).pass("pass");

        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNextWrong = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNextWrong.click();
        Thread.sleep(500);
        String imgNextWrong = "images/ChangeEmail/Next to wrong.png";
        takeScreenshot(imgNextWrong);
        scenario.createNode(Given.class, "Click Next, App displayed error.").addScreenCaptureFromPath(imgNextWrong).pass("pass");

        System.out.println("Click 'X'");
        WebElement clearText2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText2.click();
        Thread.sleep(1000);
        String imgClear2 = "images/ChangeEmail/Clear Text 2.png";
        takeScreenshot(imgClear2);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear2).pass("pass");


        System.out.println("Input email");
        Thread.sleep(1000);
        inputText.click();
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja620@gmail.com");
        String imgInputMail = "images/ChangeEmail/Input Email.png";
        takeScreenshot(imgInputMail);
        scenario.createNode(Given.class, "Input email.").addScreenCaptureFromPath(imgInputMail).pass("pass");

        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNext = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNext.click();
        Thread.sleep(500);
        String imgNext = "images/ChangeEmail/click Next to Enter PIN.png";
        takeScreenshot(imgNext);
        scenario.createNode(Given.class, "Click Next, App navigate to Enter PIN.").addScreenCaptureFromPath(imgNext).pass("pass");

        System.out.println("Confirm PIN");
        confirmPin();
        Thread.sleep(1000);
        String imgInputOTP1 = "images/ChangeEmail/Input OTP.png";
        takeScreenshot(imgInputOTP1);
        scenario.createNode(Given.class, "Input OTP").addScreenCaptureFromPath(imgInputOTP1).pass("pass");


        System.out.println("Enter OTP");
        WebElement headerMail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_HEADER);
        WebElement inputOTP = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_OTP_1);
        inputOTP.click();
        Thread.sleep(500);
        System.out.println("Test Click by getKeyboard");
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        String imgOTP2 = "images/ChangeEmail/Input OTP 2 digits.png";
        takeScreenshot(imgOTP2);
        scenario.createNode(Given.class, "Input OTP 2 digits").addScreenCaptureFromPath(imgOTP2).pass("pass");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);

        System.out.println("Outttttttttttttttttt ---------------------------");

        System.out.println("Success");
        WebElement successBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_BUTTON);
        WebElement titleSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_TITLE);
        WebElement messageSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_MESSAGE);
        Thread.sleep(5000);
        String imgSuccess = "images/ChangeEmail/Success Verify.png";
        takeScreenshot(imgSuccess);
        scenario.createNode(Given.class, "After Input OTP App navigate to Success page.").addScreenCaptureFromPath(imgSuccess).pass("pass");

        System.out.println("Click success button");
        successBT.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        WebElement changeButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        String imgMange = "images/ChangeEmail/Mail change.png";
        takeScreenshot(imgMange);
        scenario.createNode(Given.class, "After click success button, App navigate to Manage email page and email that verify should displayed.").addScreenCaptureFromPath(imgMange).pass("pass");


        System.out.println("Finish");
        getExtent().flush();


    }

    @Test(groups = "Loan Change Email")
    public void loanChangeEmail() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565

        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loan Change Email");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        enterPin();

        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.LOAN_HOME_SCREEN_BUTTON);
        String accSum = "images/LoanChangEmail/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Loan Card");
        // Credit Card Page.
        WebElement loanSum = ttbTestContext.findElement(OneAppElementKeys.LENDING_CLICK_CARD_LOAN_C2G);
        String imgLoanSum = "images/LoanChangEmail/Loan summary.png";
        takeScreenshot(imgLoanSum);
        scenario.createNode(Given.class, "Loan Summary").addScreenCaptureFromPath(imgLoanSum).pass("pass");

        loanSum.click();
        Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait round 2");
        Thread.sleep(20000);
        System.out.println("-------------------------------------------------------\n\n\n\n");

        System.out.println(ttbTestContext.getDriver().getPageSource());
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        System.out.println("Wait to data on Product Landing");
        WebElement eStatementBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON);
        Thread.sleep(2000);
        String creditCard = "images/LoanChangEmail/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on Apply eStatement");
        eStatementBT.click();
        Thread.sleep(5000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_ESTATEMENT_CHANGE_EMAIL_BUTTON, false);

        WebElement changeButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_CHANGE_EMAIL_BUTTON);
        String imgVerify = "images/LoanChangEmail/Change email.png";
        takeScreenshot(imgVerify);
        scenario.createNode(Given.class, "Click on apply eStatement button, App navigate to Apply eStatement page.").addScreenCaptureFromPath(imgVerify).pass("pass");

        System.out.println("Click Change Email");
        changeButton.click();
        Thread.sleep(10000);

//        ttbTestContext.getDriver().context("WEBVIEW_com.ttbbank.oneapp.vit");
//        if (ttbTestContext.isAndroid()) {
//            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON, true);
//            Thread.sleep(3000);
//            Set<String> webNames = context.getWindowHandles();
//            for (String s : webNames) {
//                ttbTestContext.getDriver().switchTo().window(s);
//                System.out.println("test : " + s);
//                try {
//                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_LOAN_APPLY_STATEMENT_BUTTON);
//                    break;
//                } catch (Exception e) {
//                    System.out.println("This webview is't to use");
//                }
//            }
//        }

        Thread.sleep(1000);
        WebElement confirmToChange = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_CONFIRM_TO_CHANGE_EMAIL2);
        String imgConfirm = "images/LoanChangEmail/Pop-up Confirm.png";
        takeScreenshot(imgConfirm);
        scenario.createNode(Given.class, "Click verify email, App pop-up displayed Confirm").addScreenCaptureFromPath(imgConfirm).pass("pass");

        System.out.println("Click Confirm to Change");
        confirmToChange.click();
        Thread.sleep(1000);

        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL, false);

        WebElement manageEmail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_EMAIL);
        String imgManage = "images/LoanChangEmail/Mange Email.png";
        takeScreenshot(imgManage);
        scenario.createNode(Given.class, "Click verify email, App navigate to Manage Email").addScreenCaptureFromPath(imgManage).pass("pass");


        System.out.println("Click 'X'");
        WebElement clearText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText.click();
        Thread.sleep(1000);
        String imgClear = "images/LoanChangEmail/Clear Text.png";
        takeScreenshot(imgClear);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear).pass("pass");

        System.out.println("Click Input box");
        WebElement inputText = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_INPUT);
        inputText.click();
        Thread.sleep(1000);
        String imgInput = "images/LoanChangEmail/Input Text.png";
        takeScreenshot(imgInput);
        scenario.createNode(Given.class, "Click on Input box to input email.").addScreenCaptureFromPath(imgInput).pass("pass");

        System.out.println("Input wrong email");
        Thread.sleep(1000);
        inputText.sendKeys("peaceninja");
        String imgInputWrong = "images/LoanChangEmail/Input Wrong Email.png";
        takeScreenshot(imgInputWrong);
        scenario.createNode(Given.class, "Input wrong email.").addScreenCaptureFromPath(imgInputWrong).pass("pass");

        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNextWrong = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNextWrong.click();
        Thread.sleep(500);
        String imgNextWrong = "images/LoanChangEmail/Next to wrong.png";
        takeScreenshot(imgNextWrong);
        scenario.createNode(Given.class, "Click Next, App displayed error.").addScreenCaptureFromPath(imgNextWrong).pass("pass");

        System.out.println("Click 'X'");
        WebElement clearText2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_CLEAR);
        clearText2.click();
        Thread.sleep(1000);
        String imgClear2 = "images/LoanChangEmail/Clear Text 2.png";
        takeScreenshot(imgClear2);
        scenario.createNode(Given.class, "Click on X to clear text on input box.").addScreenCaptureFromPath(imgClear2).pass("pass");


        System.out.println("Input email");
        Thread.sleep(1000);
        inputText.click();
        Thread.sleep(1000);
        inputText.sendKeys("peaceChangeEmail@gmail.com");
        String imgInputMail = "images/LoanChangEmail/Input Email.png";
        takeScreenshot(imgInputMail);
        scenario.createNode(Given.class, "Input email.").addScreenCaptureFromPath(imgInputMail).pass("pass");

        System.out.println("Click Next");
        Thread.sleep(500);
        WebElement clickNext = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_NEXT);
        clickNext.click();
        Thread.sleep(500);
        String imgNext = "images/LoanChangEmail/click Next to Enter PIN.png";
        takeScreenshot(imgNext);
        scenario.createNode(Given.class, "Click Next, App navigate to Enter PIN.").addScreenCaptureFromPath(imgNext).pass("pass");

        System.out.println("Confirm PIN");
        confirmPin();
        Thread.sleep(1000);
        WebElement headerMail = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_HEADER);
        String imgInputOTP1 = "images/LoanChangEmail/Input OTP.png";
        takeScreenshot(imgInputOTP1);
        scenario.createNode(Given.class, "Input OTP").addScreenCaptureFromPath(imgInputOTP1).pass("pass");


        System.out.println("Enter OTP");
        WebElement inputOTP = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_MANAGE_MAIL_OTP_1);
        inputOTP.click();
        Thread.sleep(500);
        System.out.println("Test Click by getKeyboard");
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        String imgOTP2 = "images/LoanChangEmail/Input OTP 2 digits.png";
        takeScreenshot(imgOTP2);
        scenario.createNode(Given.class, "Input OTP 2 digits").addScreenCaptureFromPath(imgOTP2).pass("pass");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("8");
        Thread.sleep(1000);

        System.out.println("Outttttttttttttttttt ---------------------------");

        System.out.println("Success");
        WebElement successBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_BUTTON);
        WebElement titleSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_TITLE);
        WebElement messageSuccess = ttbTestContext.findElement(OneAppElementKeys.LENDING_ESTATEMENT_VERIFY_EMAIL_SUCCESS_MESSAGE);
        Thread.sleep(5000);
        String imgSuccess = "images/LoanChangEmail/Success Verify.png";
        takeScreenshot(imgSuccess);
        scenario.createNode(Given.class, "After Input OTP App navigate to Success page.").addScreenCaptureFromPath(imgSuccess).pass("pass");

        System.out.println("Click success button");
        successBT.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        WebElement changeButton2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_ACTIVATE_CARD_PRIMARY_ENTER_CARD_NUMBER);
        String imgMange = "images/LoanChangEmail/Mail change.png";
        takeScreenshot(imgMange);
        scenario.createNode(Given.class, "After click success button, App navigate to Manage email page and email that verify should displayed.").addScreenCaptureFromPath(imgMange).pass("pass");


        System.out.println("Finish");
        getExtent().flush();


    }

}
