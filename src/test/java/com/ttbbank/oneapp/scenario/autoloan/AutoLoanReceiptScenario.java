package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoLoanReceiptScenario extends AutoLoanHomeScenario {
    @Test(groups = "Receipt Tax Invoice", dependsOnGroups = "Enter Loan Home")
    public void receiptTaxInvoice() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Request Installment receipt");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(40000);
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON, true);
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
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_QR_BARCODE).click();
        Thread.sleep(4000);
        String request_receipt_select_payment = "images/request_receipt_select_payment_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_select_payment);
        scenario.createNode(Given.class, "Request receipt select Payment").addScreenCaptureFromPath(request_receipt_select_payment).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_PAYMENT_NEXT_BUTTON).click();
        Thread.sleep(4000);
        String request_receipt_request_detail = "images/request_receipt_request_detail_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_request_detail);
        scenario.createNode(Given.class, "Request receipt request detail").addScreenCaptureFromPath(request_receipt_request_detail).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_GENERATE_QR_BARCODE_BUTTON).click();
        Thread.sleep(10000);
        String request_receipt_request_success = "images/request_receipt_request_success_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_request_success);
        scenario.createNode(Given.class, "Request receipt request detail").addScreenCaptureFromPath(request_receipt_request_success).pass("Pass");
        getExtent().flush();
    }
}
