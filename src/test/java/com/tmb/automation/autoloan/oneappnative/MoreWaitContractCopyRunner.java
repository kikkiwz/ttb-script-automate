package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.function.Function;

public class MoreWaitContractCopyRunner extends ContractCopyScenario {


    @Test(groups = "contractCopy", dependsOnGroups = "serviceRequest")
    void contractCopy() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class, "Contract Copy");
        enterContractCopy();
        scenario.createNode(Given.class, "Tap Contract Copy Item").pass("pass");
        String screenShot = "images/contract_copy_information_" + getPlatform() + ".png";
        takeScreenshot(screenShot);
        scenario.createNode(Given.class, "Shows Contract Copy Detail Screen").addScreenCaptureFromPath(screenShot).pass("pass");
        nextContractCopy();
        Thread.sleep(1000);
        scenario.createNode(Given.class, "Tap Next from Information  Screen").pass("pass");

        try{
            Thread.sleep(8000);
            screenShot = "images/contract_copy_confirm_page_" + getPlatform() + ".png";
            takeScreenshot(screenShot);
            scenario.createNode(Given.class, "Shows Account Information Screen to Confirm").addScreenCaptureFromPath(screenShot).pass("pass");
            confirmContractCopy();
            scenario.createNode(Given.class, "Tap Confirm").pass("pass");
            WebDriverWait wait = new WebDriverWait(getDriver(), 10, 300);
            Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
                getDriver().findElementByAccessibilityId("checked");
                return true;
            };
            wait.until(func);
            scenario.createNode(Given.class, "Verify Result").pass("pass");
        }catch (Exception e){
            screenShot = "images/contract_copy_failed_" + getPlatform() + ".png";
            takeScreenshot(screenShot);
            scenario.createNode(Given.class, "Verify Result").addScreenCaptureFromPath(screenShot).fail("failed");
        }
        extent.flush();
    }

}
