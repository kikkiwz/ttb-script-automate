package com.ttbbank.oneapp.scenario.autoloan;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class AutoLoanCarRegistrationScenario extends AutoLoanHomeScenario {

    @Test(groups = "CarRegistrationBook", dependsOnGroups = "Enter Loan Home")
    public void CarRegistrationBook() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "CarRegistrationBook");
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
        context.findElement(OneAppElementKeys.AUTO_LOAN_CAR_REGISTRATION).click();
        Thread.sleep(5000);

    }
}
