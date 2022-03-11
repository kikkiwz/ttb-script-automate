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
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class OtherInsuranceServiceScenario extends BaseScenario {

    @Test(groups = "Other Insurance Service", dependsOnGroups = {"Activate new flow"}, priority = 1)
    public void otherInsuranceService() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement expandMenuButton = context.findElement(OneAppElementKeys.PROTECTION_EXPAND_MENU);
        expandMenuButton.click();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[resource-id='protection-summary']")));
        Thread.sleep(50000);

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        Thread.sleep(5000);
        String otherInsuranceServices = "images/Protection_Other insurance services.png";
        takeScreenshot(otherInsuranceServices);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();
        Thread.sleep(5000);
        String otherHeathCareCard = "images/Protection_Other insurance services Heath care card.png";
        takeScreenshot(otherHeathCareCard);

        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_TAXPLANNER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_TAXPLANNER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_TAXPLANNER).click();
        Thread.sleep(5000);
        String otherTaxPlanner = "images/Protection_Other insurance services Tax planner.png";
        takeScreenshot(otherTaxPlanner);
        Thread.sleep(5000);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Other Insurance Services");
        scenario.createNode(Given.class, "Can display Other insurance services correctly").addScreenCaptureFromPath(otherInsuranceServices).pass("PASS");
        scenario.createNode(Given.class, "Can view Heath care card screen ").addScreenCaptureFromPath(otherHeathCareCard).pass("PASS");
        scenario.createNode(Given.class, "Can view Tax planner screen").addScreenCaptureFromPath(otherTaxPlanner).pass("PASS");
        getExtent().flush();
    }
}
