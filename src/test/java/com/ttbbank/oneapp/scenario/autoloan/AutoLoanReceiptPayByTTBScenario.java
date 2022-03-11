package com.ttbbank.oneapp.scenario.autoloan;

import android.webkit.WebView;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class AutoLoanReceiptPayByTTBScenario extends AutoLoanHomeScenario {
    @Test(groups = "Receipt Tax Invoice Pay By TTB account", dependsOnGroups = "Enter Loan Home")
    public void receiptTaxInvoice() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Request Installment receipt ");
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
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_TAX_BUTTON).click();
        Thread.sleep(2000);
        String request_receipt_info = "images/request_receipt_info_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_info);
        scenario.createNode(Given.class, "Request receipt tax info screen").addScreenCaptureFromPath(request_receipt_info).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_INFO_NEXT_BUTTON).click();
        Thread.sleep(2000);
        String request_receipt_type = "images/request_receipt_type_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_type);
        scenario.createNode(Given.class, "Request receipt select type screen").addScreenCaptureFromPath(request_receipt_type).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_TYPE_NEXT_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_1_CHECKBOX).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_2_CHECKBOX).click();
        Thread.sleep(4000);
        String request_receipt_select_bill = "images/request_receipt_select_bill_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_select_bill);
        scenario.createNode(Given.class, "Request receipt select bill").addScreenCaptureFromPath(request_receipt_select_bill).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_SELECT_RECEIPT_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_receipt_select_revive = "images/request_receipt_select_revive_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_select_revive);
        scenario.createNode(Given.class, "Request receipt select type screen").addScreenCaptureFromPath(request_receipt_select_revive).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_DOC_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_receipt_select_payment_TTB = "images/request_receipt_select_payment_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_select_payment_TTB);
        scenario.createNode(Given.class, "Request receipt select Payment").addScreenCaptureFromPath(request_receipt_select_payment_TTB).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_PAYMENT_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_receipt_request_detail_TTB = "images/request_receipt_request_detail_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_request_detail_TTB);
        scenario.createNode(Given.class, "Request receipt request detail").addScreenCaptureFromPath(request_receipt_request_detail_TTB).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_GENERATE_QR_BARCODE_BUTTON).click();
        Thread.sleep(5000);
        String request_receipt_detail_TTB = "images/request_receipt_Detail_success_pay_pay_by_TTB_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_detail_TTB);
        scenario.createNode(Given.class, "Request receipt request detail").addScreenCaptureFromPath(request_receipt_detail_TTB).pass("Pass");
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER, false);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_FEE_VALUE).getText(),"100.00");
        context.verticalSwipeByPercentages(0.7,0.2,0.5);
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_NEXT_BTN).click();
        Thread.sleep(1500);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER_CONFIRM).getText(), "Review Payment Details");
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_AMOUNT).getText(),"100.00");
        String request_receipt_success_TTB = "images/request_receipt_success_pay_by_TTB_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_success_TTB);
        scenario.createNode(Given.class, "Request receipt pay by TBB account confirm screen").addScreenCaptureFromPath(request_receipt_success_TTB).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_CONFIRM_BTN).click();

    }
}
