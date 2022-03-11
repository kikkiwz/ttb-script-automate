package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirsttimeOnboardingScenario extends BaseScenario {

    @Test(groups = "Activate application", dependsOnGroups = {"Activate new flow"}, priority = 1)
    public void accessToInsurance() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement expandMenuButton = context.findElement(OneAppElementKeys.PROTECTION_EXPAND_MENU);
        expandMenuButton.click();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[resource-id='protection-summary']")));
        Thread.sleep(15000);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Access to Insurance feature");
        String protectionActivateApp = "images/Protection_Activate application.png";
        takeScreenshot(protectionActivateApp);
        scenario.createNode(Given.class, "Access to Insurance feature").addScreenCaptureFromPath(protectionActivateApp).pass("PASS");
        getExtent().flush();
    }
}
