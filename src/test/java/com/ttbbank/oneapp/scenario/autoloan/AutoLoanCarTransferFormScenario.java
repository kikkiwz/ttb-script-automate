package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoLoanCarTransferFormScenario extends AutoLoanHomeScenario{
    @Test(groups = "Car Transfer Form", dependsOnGroups = "Enter Loan Home")
    public void CarTransferForm() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Car Transfer Form");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(40000);
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON, true);
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TRANSFER_FORM).click();
        Thread.sleep(30000);
        String request_receipt_info = "images/request_car_transfer_form_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_info);
        scenario.createNode(Given.class, "Request car transfer form screen").addScreenCaptureFromPath(request_receipt_info).pass("Pass");

        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_TRANSFER_FORM_INFO).click();
        Thread.sleep(50000);
        String request_receipt_type = "images/request_car_transfer_form_info_"+context.getPlateFormName()+".png";
        takeScreenshot(request_receipt_type);
        scenario.createNode(Given.class, "Request car transfer form info screen").addScreenCaptureFromPath(request_receipt_type).pass("Pass");

        getExtent().flush();
    }

}
