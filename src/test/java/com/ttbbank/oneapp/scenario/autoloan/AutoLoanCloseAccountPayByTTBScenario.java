package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoLoanCloseAccountPayByTTBScenario extends AutoLoanHomeScenario {

    @Test(groups = "Close Account By TTB account", dependsOnGroups = "Enter Loan Home")
    public void closeAccount() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Request Close account Pay By TTB Account");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON,true);
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
//        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_BUTTON,false);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_BUTTON).click();
        Thread.sleep(2000);
        String request_Close_info_pay_ttb_account_ = "images/request_Close_info_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_info_pay_ttb_account_);
        scenario.createNode(Given.class, "Request close account info screen").addScreenCaptureFromPath(request_Close_info_pay_ttb_account_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_NEXT_BUTTON).click();
//        context.verticalSwipeByPercentages(0.7,0.2,0.5);
        Thread.sleep(2000);
        String request_Close_info2_ = "images/request_Close_info2_pay_ttb_account_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_info2_);
        scenario.createNode(Given.class, "Request close account info screen").addScreenCaptureFromPath(request_Close_info2_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_INFO_NEXT_BUTTON).click();
        Thread.sleep(2000);
        String request_Close_method_pay_ttb_account_ = "images/request_Close_method_pay_ttb_account_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_method_pay_ttb_account_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_method_pay_ttb_account_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_METHOD_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_receive_pay_ttb_account_ = "images/request_Close_receive_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_receive_pay_ttb_account_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_receive_pay_ttb_account_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_RECEIVE_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_payment_pay_ttb_account_ = "images/request_Close_payment_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_payment_pay_ttb_account_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_payment_pay_ttb_account_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_SELECT_PAYMENT_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_detail_ = "images/request_Close_detail_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_detail_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_detail_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_GENERATE_QR_BARCODE_BUTTON).click();
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER, false);
        context.verticalSwipeByPercentages(0.7,0.2,0.5);
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_NEXT_BTN).click();
        Thread.sleep(1500);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER_CONFIRM).getText(), "Review Payment Details");
        String request_receipt_success_TTB = "images/request_receipt_success_pay_by_TTB_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_success_TTB);
        scenario.createNode(Given.class, "Request receipt pay by TBB account confirm screen").addScreenCaptureFromPath(request_receipt_success_TTB).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_CONFIRM_BTN).click();
        getExtent().flush();
    }
}
