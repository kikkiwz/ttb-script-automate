package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

public class AutoLoanCarTaxSignScenario extends AutoLoanHomeScenario{

    @Test( groups = "Auto loan Car Tax Label QR code", dependsOnGroups = "Enter Loan Home")
    public void autoLoanAccountDetail() throws InterruptedException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Auto loan account detail");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(25000);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON,true);
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_BUTTON).click();
        Thread.sleep(4000);
    }
}
