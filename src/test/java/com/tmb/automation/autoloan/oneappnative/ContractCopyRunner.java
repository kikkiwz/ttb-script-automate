package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContractCopyRunner extends ContractCopyScenario {


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

        screenShot = "images/contract_copy_confirm_page_" + getPlatform() + ".png";
        takeScreenshot(screenShot);
        scenario.createNode(Given.class, "Shows Account Information Screen to Confirm").addScreenCaptureFromPath(screenShot).pass("pass");
        confirmContractCopy();
        scenario.createNode(Given.class, "Tap Confirm").pass("pass");
        verifyResult();
        screenShot = "images/contract_copy_result_" + getPlatform() + ".png";
        takeScreenshot(screenShot);
        scenario.createNode(Given.class, "Verify Result").addScreenCaptureFromPath(screenShot).pass("pass");
        extent.flush();
    }

}
