package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class AutoLoanOtherPaymentCloseAccountScenario extends AutoLoanHomeScenario {
    @Test(groups = "Other Payment For Close Account", dependsOnGroups = "Enter Loan Home")
    public void receiptTaxInvoice() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "OtherPayment Close Account ");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(40000);
        WebDriver webView = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME, true);
        if (context.isAndroid()) {
            Set<String> webNames = webView.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_OTHER_PAYMENT_BTN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_HEADER_OTHER_PAYMENT).getText(),"Select payment item to generate QR/Barcode to pay at payment counter");
        String OtherPayment_info = "images/OtherPayment Info"+context.getPlateFormName()+".png";
        takeScreenshot(OtherPayment_info);
        scenario.createNode(Given.class, "Other Payment info screen").addScreenCaptureFromPath(OtherPayment_info).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_QR_CLOSE_ACCOUNT_PAYMENT_BTN).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_NEXT_OTHER_PAYMENT_BTN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_HEADER_QR_OTHER_PAYMENT).getText(), "Show this QR/Barcode to payment counter");
        String QR_TAX = "images/OtherPayment Success"+context.getPlateFormName()+".png";
        takeScreenshot(QR_TAX);
        scenario.createNode(Given.class, "Generate QR Payment for Tax Success").addScreenCaptureFromPath(QR_TAX).pass("Pass");
    }
}
