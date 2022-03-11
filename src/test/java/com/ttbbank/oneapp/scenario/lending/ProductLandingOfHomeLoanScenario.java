package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ProductLandingOfHomeLoanScenario extends BaseScenario {

    @Test(groups = "Product Landing of home loan")
    // 001100000000000000000011004078	3850200487792
    public void productLandingHomeLoan() throws InterruptedException, IOException {

//        registerCrmByPassOTP("3850200487792");

        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Product Landing of C2G");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.LOAN_HOME_SCREEN_BUTTON);
        Thread.sleep(2000);
        String accountSum = "Home Loan/Account Summary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary Page").addScreenCaptureFromPath(accountSum).pass("pass");

        cardButton.click();

        // Credit Card Page.
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CLICK_CARD_HOME_LOAN);
        Thread.sleep(1000);
        WebElement homeLoanCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CLICK_CARD_HOME_LOAN);
        Thread.sleep(2000);
        String loanSum = "Home Loan/Loan Summary.png";
        takeScreenshot(loanSum);
        scenario.createNode(Given.class, "Loan Summary Page").addScreenCaptureFromPath(loanSum).pass("pass");
        System.out.println("Click Home Loan");
        homeLoanCard.click();

        System.out.println("Check Assert");
//        WebElement textPayBill =  ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAY_BILL_MENU);
//        WebElement textPaid = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAID_TEXT);
//        WebElement textOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_OUT_STANDING_TEXT);

        WebElement sheetHeader = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_BOTTOM_SHEET_HEADER);
        Thread.sleep(2000);
//        Assert.assertEquals(textPaid.getText(),"Paid");
//        Assert.assertEquals(textOut.getText(),"Outstanding");
//        Assert.assertEquals(textPayBill.getText(),"Pay bill");

        String loanBPlus = "Home Loan/Product Landing of Home Loan.png";
        takeScreenshot(loanBPlus);
        scenario.createNode(Given.class, "Product Landing of Home Loan").addScreenCaptureFromPath(loanBPlus).pass("pass");


        System.out.println("Swipe sheet bar up");
        TouchAction sDown = new TouchAction(ttbTestContext.getDriver());
        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(sheetHeader)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 1500)).release().perform();

        WebElement textAccNo = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_ACCOUNT_NUMBER);
        WebElement textLoanSuffix = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_LOAN_SUFFIX);
        WebElement textAccName = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_ACCOUNT_NAME);
        WebElement textMonthly = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_MONTHLY_PAYMENT);
        WebElement textDueDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_DUE_DATE);
        WebElement textInterest = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_INTEREST);
//        WebElement textTenors = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_TENORS);
//        WebElement textStartDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_START_DATE);
//        WebElement textExpiryDate = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_EXPIRY_DATE);

        Assert.assertEquals(textAccNo.getText(),"Loan account number");
        Assert.assertEquals(textLoanSuffix.getText(),"Loan suffix");
        Assert.assertEquals(textAccName.getText(),"Account name");
        Assert.assertEquals(textMonthly.getText(),"Monthly payment");
        Assert.assertEquals(textDueDate.getText(),"Due date");
        Assert.assertEquals(textInterest.getText(),"Interest rate (per year)");
//        Assert.assertEquals(textTenors.getText(),"Tenors");
//        Assert.assertEquals(textStartDate.getText(),"Contract start date");
//        Assert.assertEquals(textExpiryDate.getText(),"Contract expiry date");

        String loanDetail = "Home Loan/Loan Detail.png";
        takeScreenshot(loanDetail);
        scenario.createNode(Given.class, "Loan Detail").addScreenCaptureFromPath(loanDetail).pass("pass");

        WebElement paymentHistory = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAYMENT_HISTORY);
        paymentHistory.click();

        WebElement payDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_PAYMENT);
        Assert.assertEquals(payDetail.getText(),"Payment details will be shown on the next day if you pay via other methods");


        String paymentDetail = "Home Loan/Payment Detail.png";
        takeScreenshot(paymentDetail);
        scenario.createNode(Given.class, "Payment Detail").addScreenCaptureFromPath(paymentDetail).pass("pass");
        getExtent().flush();


    }
}
