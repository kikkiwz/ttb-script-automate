package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPinScenario extends BaseScenario {

    @Test(groups = "Protection Login PIN", dependsOnGroups = {"Open home screen VIT latest"}, priority = 1)
    public void loginPin() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement expandMenuButton = context.findElement(OneAppElementKeys.PROTECTION_EXPAND_MENU);
        expandMenuButton.click();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        enterPin();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
        Thread.sleep(3000);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Access to Insurance feature");
        String protectionLoginPin = "images/Protection_loginPin.png";
        takeScreenshot(protectionLoginPin);
        scenario.createNode(Given.class, "Access to Insurance feature").addScreenCaptureFromPath(protectionLoginPin).pass("pass");
        getExtent().flush();

    }

}
