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

public class AutoLoanRequestStatusScenario extends AutoLoanHomeScenario{

    @Test(groups = "Request Status", dependsOnGroups = "Enter Loan Home")
    public void RequestStatus() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Request Status");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        WebDriver webView = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME,true);
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
        Boolean productName = context.findElement(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME).isDisplayed();
        Assert.assertTrue(productName);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME).getText(),"ttb DRIVE");
        String RequestStatusLoanDetail = "images/Request_Status_Loan_Detail"+context.getPlateFormName()+".png";
        takeScreenshot(RequestStatusLoanDetail);
        scenario.createNode(Given.class, "Request Status Loan Detail screen").addScreenCaptureFromPath(RequestStatusLoanDetail).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_BTN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_HEADER).getText(),"Service Request Status");
        Boolean requestStatusContain = context.findElement(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_CONTAIN).isDisplayed();
        if(requestStatusContain == true){
            Boolean requestStatusContainCheck = context.findElement(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_CONTAIN).isDisplayed();
            Assert.assertTrue(requestStatusContainCheck);
            String RequestStatusScreen = "images/Request_Status_Screen"+context.getPlateFormName()+".png";
            takeScreenshot(RequestStatusScreen);
            scenario.createNode(Given.class, "Request Status screen").addScreenCaptureFromPath(RequestStatusScreen).pass("Pass");
        }else {

        }

    }
}
