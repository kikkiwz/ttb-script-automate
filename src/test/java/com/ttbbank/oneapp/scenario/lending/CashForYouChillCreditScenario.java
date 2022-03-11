package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CashForYouChillCreditScenario extends BaseScenario {

    @Test(groups = "CashForYouChill Credit")

    public void setAtmPin() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565

//        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Cash for you Cash Chill chill Credit Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();

        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        String accSum = "images/Cash4YouCC Credit/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Tap on Account button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        cardButton.click();

        System.out.println("Click Credit Card");
        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_CREDIT_SELECT_ACCOUNT);
        creDitCard.click();

        System.out.println("Wait to data on Product Landing");
        WebElement C4YButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String creditCard = "images/Cash4YouCC Credit/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate toProduct Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        //Click on Cash for you
        System.out.println("Click on Cash for you");
        C4YButton.click();
        WebElement nextInfo  = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        Thread.sleep(3000);
        String imageNextInfo = "images/Cash4YouCC Credit/.png";
        takeScreenshot(imageNextInfo);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to info cash for you page.").addScreenCaptureFromPath(imageNextInfo).pass("pass");

        //Click Next on info page
        System.out.println("Click Next");
        nextInfo.click();
        WebElement ckAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        Thread.sleep(3000);
        String imageCash4you = "images/Cash4YouCC Credit/Cash for you page.png";
        takeScreenshot(imageCash4you);
        scenario.createNode(Given.class, "Click menu Cash for you, App navigate to Cash for you page.").addScreenCaptureFromPath(imageCash4you).pass("pass");

        //Click amount
        System.out.println("Click Amount Input");
        Thread.sleep(300);
        ckAmount.click();
        Thread.sleep(1000);
        String imAmount = "images/Cash4YouCC Credit/Amount.png";
        takeScreenshot(imAmount);
        scenario.createNode(Given.class, "Click amount input field, App display numeric.").addScreenCaptureFromPath(imAmount).pass("pass");


        //Click out
        WebElement ckOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CLICK_OUT);

        //Input amount less
        System.out.println("Input less than");
//        ttbTestContext.getDriver().getKeyboard().sendKeys("950");
        ckAmount.sendKeys("950");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imLess = "images/Cash4YouCC Credit/Input Less.png";
        takeScreenshot(imLess);
        scenario.createNode(Given.class, "Input amount less than minimum, App displayed inline-error").addScreenCaptureFromPath(imLess).pass("pass");

        //Input amount more
        System.out.println("Input more than");
        ckAmount.click();
        Thread.sleep(500);

        ttbTestContext.getDriver().getKeyboard().sendKeys("8000000");
//        ckAmount.sendKeys("800000");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imMore = "images/Cash4YouCC Credit/Input More.png";
        takeScreenshot(imMore);
        scenario.createNode(Given.class, "Input amount more than minimum, App displayed inline-error").addScreenCaptureFromPath(imMore).pass("pass");


        //Input correct
        System.out.println("Input in range");
        ckAmount.click();
        Thread.sleep(500);
        ttbTestContext.getDriver().getKeyboard().sendKeys("6000");
//        ckAmount.sendKeys("6000");
        Thread.sleep(500);
        ckOut.click();
        Thread.sleep(500);
        String imCorrect = "images/Cash4YouCC Credit/Input amount correct.png";
        takeScreenshot(imCorrect);
        scenario.createNode(Given.class, "Input amount correct").addScreenCaptureFromPath(imCorrect).pass("pass");

        //swipe
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);

        //Click Cash Chill Chill
        WebElement selectCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_CHILL_PAYMENT_OPTION);
        selectCT.click();
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String imSelectCT = "images/Cash4YouCC Credit/Select Cash Chill.png";
        takeScreenshot(imSelectCT);
        scenario.createNode(Given.class, "Select option Cash Chill Chill, App display detail of Cash Transfer").addScreenCaptureFromPath(imSelectCT).pass("pass");

        //Click select box
        WebElement stBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_SELECT_BOX_MONTH);
        stBox.click();
        Thread.sleep(300);
        String imSelectBox = "images/Cash4YouCC Credit/Select box.png";
        takeScreenshot(imSelectBox);
        scenario.createNode(Given.class, "Select box to choose month.").addScreenCaptureFromPath(imSelectBox).pass("pass");

        //Select 12month
        WebElement stMonth = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_SELECT_12_MONTH);
        stMonth.click();
        Thread.sleep(300);
        String imMonth = "images/Cash4YouCC Credit/Select month.png";
        takeScreenshot(imMonth);
        scenario.createNode(Given.class, "Choose 12month.").addScreenCaptureFromPath(imMonth).pass("pass");

        //Check FEE
        WebElement tier1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_1_TO_10);
        WebElement tier11 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TIER_11_TO_CHOOSE);
        WebElement feeTier1 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_FEE_TIER_1);
        WebElement feeTier2 = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_FEE_TIER_2);
        WebElement more12Tier = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MORE_THAN_11_MONTH);
        WebElement summary = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_PAYMENT_SUMMARY);
        WebElement total = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_TOTAL_PAYMENT);
        WebElement monthly = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_CHILL_MONTHLY_PAYMENT);

        Assert.assertEquals(tier1.getText(),"Tier month 1-10");
        Assert.assertEquals(tier11.getText(),"Tier month 11-12");
        Assert.assertEquals(feeTier1.getText(),"7.99%");
        Assert.assertEquals(feeTier2.getText(),"14.40%");
        Assert.assertEquals(more12Tier.getText(),"Interest will be calculated as effective rate.");
        Assert.assertEquals(summary.getText(),"Payment summary");
        Assert.assertEquals(total.getText(),"Total payment");
        Assert.assertEquals(monthly.getText(),"Monthly payment");


        //Click Next
        System.out.println("Click Next");
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        WebElement nextToConfirm = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        nextToConfirm.click();

        //scroll down and click confirm
        WebElement confirmPage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_PAGE);
        Thread.sleep(1000);
        String imConfirm = "images/Cash4YouCC Credit/Click Next.png";
        takeScreenshot(imConfirm);
        scenario.createNode(Given.class, "Scroll down and click next, App navigate to Confirm Page").addScreenCaptureFromPath(imConfirm).pass("pass");

        //checkbox
        WebElement checkedBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CHECKED_BOX_CONFIRM);
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        checkedBox.click();
        Thread.sleep(300);
        String imChecked = "images/Cash4YouCC Credit/Checked.png";
        takeScreenshot(imChecked);
        scenario.createNode(Given.class, "Checked box, Confirm button enable").addScreenCaptureFromPath(imChecked).pass("pass");

        //Click Confirm
        WebElement confirmBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CONFIRM_BUTTON);
        confirmBT.click();
        Thread.sleep(1000);
        String imCF = "images/Cash4YouCC Credit/Enter PIN.png";
        takeScreenshot(imCF);
        scenario.createNode(Given.class, "Click Confirm, App displayed Enter PIN").addScreenCaptureFromPath(imCF).pass("pass");

        //Enter pin
        confirmPin();
        WebElement infoCT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH4YOU_CASH_TRANSFER_INFO);
        String imFinish = "images/Cash4YouCC Credit/Enter PIN.png";
        takeScreenshot(imFinish);
        scenario.createNode(Given.class, "Enter PIN success, App Navigate to Success Transfer").addScreenCaptureFromPath(imFinish).pass("pass");

        // Assert Success screen
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


        Assert.assertEquals(textChill.getText(),"Cash chill chill information");
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
        Assert.assertEquals(textTier1.getText(),"Tier month 1-10");
        Assert.assertEquals(textTier11.getText(),"Tier month 11-12");


        //Click Back to main page
        WebElement backMain = ttbTestContext.findElement(OneAppElementKeys.LENDING_BACK_TO_MAIN_PAGE_SO_GOOD);
        backMain.click();
        WebElement checkBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        Thread.sleep(10000);
        String mainPage = "images/Cash4YouCC Credit/Product Landing main page.png";
        takeScreenshot(mainPage);
        scenario.createNode(Given.class, "Click Back to Main page, App Navigate to Product Landing main page").addScreenCaptureFromPath(mainPage).pass("pass");

        getExtent().flush();


    }
}
