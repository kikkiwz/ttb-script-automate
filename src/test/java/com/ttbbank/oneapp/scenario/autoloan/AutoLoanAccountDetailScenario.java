package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static java.lang.Thread.*;

public class AutoLoanAccountDetailScenario extends AutoLoanHomeScenario {

    @Test( groups = "Auto loan account detail", dependsOnGroups = "Enter Loan Home")
    public void autoLoanAccountDetail() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Auto loan account detail");
        TtbTestContext context = getTtbTestContext();
        
        Thread.sleep(25000);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(35000);
        String loan_account_detail = "images/loan_account_detail"+context.getPlateFormName()+".png";
        takeScreenshot(loan_account_detail);
        scenario.createNode(Given.class, "Request car tax sign info screen").addScreenCaptureFromPath(loan_account_detail).pass("Pass");
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
        context.verticalSwipeByPercentages(0.55,0.4,0.5);
        context.verticalSwipeByPercentages(0.65,0.5,0.5);
        context.verticalSwipeByPercentages(0.75,0.6,0.5);
        context.verticalSwipeByPercentages(0.85,0.7,0.5);
        context.verticalSwipeByPercentages(0.9,0.8,0.5);
        context.verticalSwipeByPercentages(0.95,0.8,0.5);
        String loan_account_detail2 = "images/loan_account_detail"+context.getPlateFormName()+".png";
        takeScreenshot(loan_account_detail2);
        scenario.createNode(Given.class, "Request car tax sign info screen").addScreenCaptureFromPath(loan_account_detail2).pass("Pass");
        Thread.sleep(2000);
//        context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_ACCOUNT_DETAIL_HEADER,true);
//        context.swipeUpByElements(OneAppElementKeys.AUTO_LOAN_ACCOUNT_DETAIL_HEADER,0.3,0.5);
    }

}
