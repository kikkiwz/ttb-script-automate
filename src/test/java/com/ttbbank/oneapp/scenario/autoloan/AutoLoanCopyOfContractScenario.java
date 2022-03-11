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

public class AutoLoanCopyOfContractScenario extends AutoLoanHomeScenario{

    @Test(groups = "Request Copy of Contract", dependsOnGroups = "Enter Loan Home")
    public void CopyOfContract() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "CopyOfContract");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(5000);
        WebDriver webview = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME,true);
        if (context.isAndroid()) {
            Set<String> webNames = webview.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_REQUEST_COPY_CONTRACT).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_HEADER_INFO).getText(),"Hire Purchase Contract Copy");
        String Copy_of_contract_info_ = "images/request_Copy_Of_Contract_"+context.getPlateFormName()+".png";
        takeScreenshot(Copy_of_contract_info_);
        scenario.createNode(Given.class, "Request Copy 0f Contract info screen").addScreenCaptureFromPath(Copy_of_contract_info_).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_NEXT_BTN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_HEADER_COMPLETE).getText(),"Request Successful");
        String Copy_of_contract_Success_ = "images/request_Copy_Of_Contract_"+context.getPlateFormName()+".png";
        takeScreenshot(Copy_of_contract_Success_);
        scenario.createNode(Given.class, "Request Copy 0f Contract info screen").addScreenCaptureFromPath(Copy_of_contract_Success_).pass("Pass");
        getExtent().flush();

    }
}
