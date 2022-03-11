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

public class YearlyCashFlowScenario extends BaseScenario {

    @Test(groups = "Yearly Cash Flow", dependsOnGroups = {"Activate new flow"}, priority = 1)
    public void yearlyCashFlow() throws InterruptedException, IOException {

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

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_TAB);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_TAB).click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));

        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_GRAPH);
        String yearlyCashFlowGraph = "images/Protection_Yearly Cash Flow graph.png";
        takeScreenshot(yearlyCashFlowGraph);

        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_TAB).click();
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_VIEWTABLE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_VIEWTABLE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_VIEWTABLE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(5000);
        String yearlyCashFlowViewTableButton = "images/Protection_Yearly view protection table.png";
        takeScreenshot(yearlyCashFlowViewTableButton);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_VIEWTABLE_BUTTON).click();


        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        Thread.sleep(5000);
        String yearlyCashFlowTable = "images/Protection_Yearly protection table.png";
        takeScreenshot(yearlyCashFlowTable);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_LINKPOLICY_EXPAND).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_LINKPOLICY_EXPAND, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_LINKPOLICY_EXPAND);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(5000);
        String yearlyCashFlowSeePolicy = "images/Protection_Yearly see policy details.png";
        takeScreenshot(yearlyCashFlowSeePolicy);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMANDCASHINFLOW_YEARLY_SEEPOLICY_BUTTON).click();

        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        Thread.sleep(5000);
        String yearlyCashFlowPolicyDetails = "images/Protection_Yearly policy details.png";
        takeScreenshot(yearlyCashFlowPolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Yearly Cash Flow");
        scenario.createNode(Given.class, "Can display yearly cash flow graph correctly").addScreenCaptureFromPath(yearlyCashFlowGraph).pass("PASS");
        scenario.createNode(Given.class, "Can click view projection table screen").addScreenCaptureFromPath(yearlyCashFlowViewTableButton).pass("PASS");
        scenario.createNode(Given.class, "Can view yearly projection table screen").addScreenCaptureFromPath(yearlyCashFlowTable).pass("PASS");
        scenario.createNode(Given.class, "Display link button to go to policy details screen").addScreenCaptureFromPath(yearlyCashFlowSeePolicy).pass("PASS");
        scenario.createNode(Given.class, "Can click link to go to policy details screen").addScreenCaptureFromPath(yearlyCashFlowPolicyDetails).pass("PASS");
        getExtent().flush();
    }
}
