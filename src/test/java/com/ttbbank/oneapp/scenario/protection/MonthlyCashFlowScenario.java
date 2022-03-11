package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class MonthlyCashFlowScenario extends BaseScenario {

    @Test(groups = "Monthly Cash Flow", dependsOnGroups = {"Activate new flow"}, priority = 1)
    public void monthlyCashFlow() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement expandMenuButton = context.findElement(OneAppElementKeys.PROTECTION_EXPAND_MENU);
        expandMenuButton.click();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[resource-id='protection-summary']")));
        Thread.sleep(50000);

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_VIEWPREMIUM_MENU, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_VIEWPREMIUM_MENU);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(50000);
        context.findElement(OneAppElementKeys.PROTECTION_VIEWPREMIUM_MENU).click();
        context.getDriver().context("NATIVE_APP");
        System.out.println("Testtttt1");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_TAB);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_TAB).click();
        System.out.println("Testtttt2");
        String premiumPaymentName = context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_PREMIUMPAYMENT_NAME).getText();
        String premiumPayment = context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_PREMIUMPAYMENT_VALUE).getText();
        System.out.println(premiumPaymentName + " : " + premiumPayment);
        Assert.assertTrue(premiumPayment.equals("29,487.84"));
        String monthlyCashFlowWithinNext30day = "images/Protection_Monthly premium amount and Cashback within next 30 days.png";
        takeScreenshot(monthlyCashFlowWithinNext30day);


        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_SELECTYEAR);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();

        String tableForMonthlyProjection = "images/Protection_Monthly premium amount and Cashback table for projection.png";
        takeScreenshot(tableForMonthlyProjection);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_LINKPOLICY_EXPAND, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_LINKPOLICY_EXPAND);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_LINKPOLICY_EXPAND).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String goToPolicyDetails = "images/Protection_See Policy Details.png";
        takeScreenshot(goToPolicyDetails);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_SEEPOLICY_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_SEEPOLICY_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_MONTHLY_SEEPOLICY_BUTTON).click();
        Thread.sleep(10000);
        String policyDetails = "images/Protection_Policy Details.png";
        takeScreenshot(policyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Monthly Cash Flow");
        scenario.createNode(Given.class, "Can display Monthly premium amount and Cashback for each month correctly (within next 30 days)").addScreenCaptureFromPath(monthlyCashFlowWithinNext30day).pass("PASS");
        scenario.createNode(Given.class, "Can display Monthly premium amount and Cashback for each month correctly (Table for Monthly Projection)").addScreenCaptureFromPath(tableForMonthlyProjection).pass("PASS");
        scenario.createNode(Given.class, "Display link button to go to policy details screen").addScreenCaptureFromPath(goToPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click link to go to policy details screen").addScreenCaptureFromPath(policyDetails).pass("PASS");
        getExtent().flush();
    }
}
