package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import org.testng.annotations.Test;

import java.io.IOException;

public class CopyOfContractScenario extends ServiceRequestListScenario{

    @Test(groups = "Copy Of Contract", dependsOnGroups = "serviceRequest")
    public void CopyOfContract() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Given.class,"Copy Of Contract");
        Thread.sleep(1000);
        enterCopyOfContract();
        String copyOfContractScreen = "image/Copy of Contract Detail Screen"+getPlatform()+".png";
        takeScreenshot(copyOfContractScreen);
        scenario.createNode(Given.class,"Display Copy of contract Detail screen").addScreenCaptureFromPath(copyOfContractScreen).pass("Pass");
        tapAddEmail();
        String addEmailScreen = "image/Add email for Copy of contract"+getPlatform()+".png";
        takeScreenshot(addEmailScreen);
        scenario.createNode(Given.class,"Add Email Screen Display").addScreenCaptureFromPath(addEmailScreen).pass("Pass");
        Thread.sleep(1000);
        inputInvalidEmail();
        tapSaveEmail();
        String warningMSGForInvalidEmail = "image/Display Warning after enter invalid email format"+getPlatform()+".png";
        takeScreenshot(warningMSGForInvalidEmail);
        scenario.createNode(Given.class,"Display Warning after enter invalid email format").addScreenCaptureFromPath(warningMSGForInvalidEmail).pass("Pass");
        inputValidEmail();
        String enterValidEmail = "image/Enter Valid Email"+getPlatform()+".png";
        takeScreenshot(enterValidEmail);
        scenario.createNode(Given.class,"Enter Valid Email").addScreenCaptureFromPath(enterValidEmail).pass("Pass");
        tapSaveEmail();
        String copyOfContractwithEmail = "image/Display Copy of Contract Detail with Email"+getPlatform()+".png";
        takeScreenshot(copyOfContractwithEmail);
        scenario.createNode(Given.class,"Display Copy of Contract Detail with Email").addScreenCaptureFromPath(copyOfContractwithEmail).pass("Pass");
        tapNext();
        requestSuccessFul();
        String sendRequestSuccess = "image/Send Request Successful"+getPlatform()+".png";
        takeScreenshot(sendRequestSuccess);
        scenario.createNode(Given.class,"Copy of contract sent request successful").addScreenCaptureFromPath(sendRequestSuccess).pass("Pass");
        extent.flush();
    }
}
