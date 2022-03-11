package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoLoanCloseAccountScenario extends AutoLoanHomeScenario {

    @Test(groups = "Close Account", dependsOnGroups = "Enter Loan Home")
    public void closeAccount() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Request Close account QR BarCode");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON,true);
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_info_ = "images/request_Close_info_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_info_);
        scenario.createNode(Given.class, "Request close account info screen").addScreenCaptureFromPath(request_Close_info_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_NEXT_BUTTON).click();
        context.verticalSwipeByPercentages(0.7,0.2,0.5);
        Thread.sleep(4000);
        String request_Close_info2_ = "images/request_Close_info2_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_info2_);
        scenario.createNode(Given.class, "Request close account info screen").addScreenCaptureFromPath(request_Close_info2_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_INFO_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_method_ = "images/request_Close_method_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_method_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_method_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_METHOD_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_receive_ = "images/request_Close_receive_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_receive_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_receive_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_RECEIVE_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_payment_ = "images/request_Close_payment_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_payment_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_payment_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_SELECT_QR_BARCODE).click();
        context.verticalSwipeByPercentages(0.7,0.2,0.5);
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_SELECT_PAYMENT_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_detail_ = "images/request_Close_detail_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_detail_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_detail_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_GENERATE_QR_BARCODE_BUTTON).click();
        Thread.sleep(4000);
        String request_Close_success_ = "images/request_Close_success_"+context.getPlateFormName()+".png";
        takeScreenshot(request_Close_success_);
        scenario.createNode(Given.class, "Request close account method screen").addScreenCaptureFromPath(request_Close_success_).pass("Pass");
        getExtent().flush();
    }
}
