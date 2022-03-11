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

public class ProductLandingOfC2GScenario extends BaseScenario {

    @Test(groups = "Product Landing of C2G")
    // 001100000000000000000000506607	7531564253565
    public void productLandingC2G() throws InterruptedException, IOException {

//        registerCrmByPassOTP("7531564253565");

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
        String accountSum = "C2G/Account Summary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary Page").addScreenCaptureFromPath(accountSum).pass("pass");

        cardButton.click();

        // Credit Card Page.
        WebElement loanCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CLICK_CARD_LOAN_C2G);
        Thread.sleep(2000);
        String loanSum = "C2G/Loan Summary.png";
        takeScreenshot(loanSum);
        scenario.createNode(Given.class, "Loan Summary Page").addScreenCaptureFromPath(loanSum).pass("pass");

        loanCard.click();

        System.out.println("Check Assert");
        WebElement textPayBill =  ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAY_BILL_MENU);
        WebElement textPaid = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAID_TEXT);
        WebElement textOut = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_OUT_STANDING_TEXT);
//        WebElement textTopUp = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_TOP_UP_MENU);

        Thread.sleep(2000);
        Assert.assertEquals(textPaid.getText(),"Paid");
        Assert.assertEquals(textOut.getText(),"Outstanding");
        Assert.assertEquals(textPayBill.getText(),"Pay bill");
//        Assert.assertEquals(textTopUp.getText(),"Top up");

        try {
            System.out.println("Check Apply e-Statement");
            WebElement textEStatement = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_ESTATEMENT_MENU);
            Assert.assertEquals(textEStatement.getText(),"Apply estatement");
            String loanBPlus = "C2G/Product Landing Loan C2G.png";
        takeScreenshot(loanBPlus);
        scenario.createNode(Given.class, "Product Landing Of C2G").addScreenCaptureFromPath(loanBPlus).pass("pass");
        scenario.createNode(Given.class,"Flag apply e-statement is True").pass("Apply e-Statement Button display.");


        } catch (Exception e) {
            String loanBPlus = "C2G/Product Landing Loan C2G.png";
        takeScreenshot(loanBPlus);
        scenario.createNode(Given.class, "Product Landing Of C2G").addScreenCaptureFromPath(loanBPlus).pass("pass");
        scenario.createNode(Given.class,"Flag apply e-statement is False").pass("Apply e-Statement Button not display.");

        }



        System.out.println("Swipe sheet bar up");
        WebElement sheetHeader = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_BOTTOM_SHEET_HEADER);
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
//        WebElement textRemark = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_REMARK);

        Assert.assertEquals(textAccNo.getText(),"Loan account number");
        Assert.assertEquals(textLoanSuffix.getText(),"Loan suffix");
        Assert.assertEquals(textAccName.getText(),"Account name");
        Assert.assertEquals(textMonthly.getText(),"Monthly payment");
        Assert.assertEquals(textDueDate.getText(),"Due date");
        Assert.assertEquals(textInterest.getText(),"Interest rate (per year)");
//        Assert.assertEquals(textTenors.getText(),"Tenors");
//        Assert.assertEquals(textStartDate.getText(),"Contract start date");
//        Assert.assertEquals(textExpiryDate.getText(),"Contract expiry date");
//        Assert.assertEquals(textRemark.getText(),"Remark: for loan account closure, please contact 1428.");

        String loanDetail = "C2G/Loan Detail.png";
        takeScreenshot(loanDetail);
        scenario.createNode(Given.class, "Loan Detail").addScreenCaptureFromPath(loanDetail).pass("pass");

        WebElement paymentHistory = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_PAYMENT_HISTORY);
        paymentHistory.click();

        WebElement payDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_LOAN_DETAIL_PAYMENT);
        Assert.assertEquals(payDetail.getText(),"Payment details will be shown on the next day if you pay via other methods");

        String paymentDetail = "C2G/Payment Detail.png";
        takeScreenshot(paymentDetail);
        scenario.createNode(Given.class, "Payment Detail").addScreenCaptureFromPath(paymentDetail).pass("pass");
        getExtent().flush();


    }
}
