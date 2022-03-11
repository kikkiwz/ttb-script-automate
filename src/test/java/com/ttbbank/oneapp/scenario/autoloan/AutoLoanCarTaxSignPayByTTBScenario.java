package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoLoanCarTaxSignPayByTTBScenario extends AutoLoanHomeScenario {

    @Test( groups = "Auto loan Car Tax Label Pay by TTB", dependsOnGroups = "Enter Loan Home")
    public void autoLoanAccountDetail() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Autoloan request car tax sign pay by TTB"+ttbTestContext.getPlateFormName());
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON,true);
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        Thread.sleep(2000);
        String open_service_request = "images/car_tax_sign_info_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(open_service_request);
        scenario.createNode(Given.class, "Request close Service request screen").addScreenCaptureFromPath(open_service_request).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_LABEL_BTN).click();
        Thread.sleep(2000);
        String request_Car_tax_info_pay_by_ttb= "images/car_tax_sign_info_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(request_Car_tax_info_pay_by_ttb);
        scenario.createNode(Given.class, "Request car tax sign info screen").addScreenCaptureFromPath(request_Car_tax_info_pay_by_ttb).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_INFO_NEXT_BTN).click();
        Thread.sleep(2000);
        String request_Car_tax_account_info_pay_by_ttb= "images/car_tax_sign_account_info_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(request_Car_tax_account_info_pay_by_ttb);
        scenario.createNode(Given.class, "Request car tax sign account info screen").addScreenCaptureFromPath(request_Car_tax_account_info_pay_by_ttb).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_ACCOUNT_INFO_NEXT_BTN).click();
        Thread.sleep(2000);
        String request_car_tax_doc_pay_by_ttb= "images/car_tax_sign_doc_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(request_car_tax_doc_pay_by_ttb);
        scenario.createNode(Given.class, "Request car tax sign document process screen").addScreenCaptureFromPath(request_car_tax_doc_pay_by_ttb).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_DOC_NEXT_BTN).click();
        Thread.sleep(20000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_FEE_VALUE).getText(),"500.00");
        String request_car_tax_payment_pay_by_ttb= "images/car_tax_sign_payment_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(request_car_tax_payment_pay_by_ttb);
        scenario.createNode(Given.class, "Request car tax sign payment process screen").addScreenCaptureFromPath(request_car_tax_payment_pay_by_ttb).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_PAYMENT_NEXT_BTN).click();
        Thread.sleep(2000);
        String request_car_tax_confirm_pay_by_ttb = "images/car_tax_sign_payment_TTB"+context.getPlateFormName()+".png";
        takeScreenshot(request_car_tax_confirm_pay_by_ttb);
        scenario.createNode(Given.class, "Request car tax sign payment process screen").addScreenCaptureFromPath(request_car_tax_confirm_pay_by_ttb).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TAX_CONFIRM_NEXT_BTN).click();
        Thread.sleep(4000);
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER_CONFIRM, false);
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_RECEIPT_FEE_VALUE_CAR_TAX_SIGN).getText(),"500.00");
        context.verticalSwipeByPercentages(0.5,0.2,0.5);
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_NEXT_BTN).click();
        Thread.sleep(1500);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER_CONFIRM).getText(), "Review Payment Details");
        Thread.sleep(3000);
        String request_car_tax_confirm_payment_TTB = "images/request_car_tax_Confirm_pay_by_TTB_"+context.getPlateFormName()+".png";
        takeScreenshot(request_car_tax_confirm_payment_TTB);
        scenario.createNode(Given.class, "Request car tax pay by TBB account confirm screen").addScreenCaptureFromPath(request_car_tax_confirm_payment_TTB).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAY_BILL_CONFIRM_BTN).click();
        Thread.sleep(10000);
        String request_car_tax_payment_success_TTB = "images/request_receipt_success_pay_by_TTB_"+context.getPlateFormName()+".png";
        takeScreenshot(request_car_tax_payment_success_TTB);
        scenario.createNode(Given.class, "Request car tax pay by TBB account complete screen").addScreenCaptureFromPath(request_car_tax_payment_success_TTB).pass("Pass");
        getExtent().flush();
    }
}


