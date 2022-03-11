package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class selectMethodCloseByYourself extends ClosingAccountStartingPageScenario{
    @Test(groups = "By Yourself",dependsOnGroups = "Closing Account")
    public void selectMethodByYourself () throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class,"Select Method By yourself");
        Thread.sleep(1000);
        tapProcessByYourself();
        String tapProcessByBank = "image/Tap Process by yourself"+getPlatform()+".png";
        takeScreenshot(tapProcessByBank);
        scenario.createNode(Given.class,"Tap select Process By Yourself").addScreenCaptureFromPath(tapProcessByBank).pass("Pass");
        tapNext();
        String selectReceiveDocScreen = "image/Receive Document screen"+getPlatform()+".png";
        takeScreenshot(selectReceiveDocScreen);
        scenario.createNode(Given.class,"Select receive document screen").addScreenCaptureFromPath(selectReceiveDocScreen).pass("Pass");
        extent.flush();
    }
}
