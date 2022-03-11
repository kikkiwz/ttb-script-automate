package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectMethodCloseByBankScenario extends ClosingAccountStartingPageScenario{
    @Test(groups = "Select Method By Bank",dependsOnGroups = "Closing Account")
    public void selectMethodByBank() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class,"Select method");
        Thread.sleep(2000);
        tapProcessByBank();
        String tapProcessByBank = "image/Tap Process by Bank"+getPlatform()+".png";
        takeScreenshot(tapProcessByBank);
        scenario.createNode(Given.class,"Tap select Process By Bank").addScreenCaptureFromPath(tapProcessByBank).pass("Pass");
        tapNext();
        String selectReceiveDocScreen = "image/Receive Document screen"+getPlatform()+".png";
        takeScreenshot(selectReceiveDocScreen);
        scenario.createNode(Given.class,"Select receive document screen").addScreenCaptureFromPath(selectReceiveDocScreen).pass("Pass");
        extent.flush();
    }
}
