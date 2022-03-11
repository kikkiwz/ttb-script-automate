package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

public class ReceiptTaxInvoiceCopyScenarioRunner extends ReceiptTaxInvoiceCopyScenario{

    @Test(groups = "receiptTaxInvoiceCopy", dependsOnGroups = "serviceRequest")
    void receiptTaxInvoiceCopy() throws InterruptedException {
        ExtentTest scenario = feature.createNode(Scenario.class, "Receipt / Tax Invoice Copy");
        enterReceiptTaxInvoiceCopy();
        scenario.createNode(Given.class, "Receipt / Tax Invoice Copy").pass("pass");
        nextFromInformationScreen();
        scenario.createNode(Given.class, "Tap Next from Information Screen").pass("pass");
        Thread.sleep(1000);
        nextFromSelectTypeOfReceipt();
        scenario.createNode(Given.class, "Tap Next from Selecting Type of Receipt").pass("pass");
        verifyResult();
        scenario.createNode(Given.class, "Verify Result").fail("No Data");
        extent.flush();
    }
}
