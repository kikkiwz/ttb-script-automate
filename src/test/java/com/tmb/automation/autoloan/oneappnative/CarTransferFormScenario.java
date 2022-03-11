package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class CarTransferFormScenario extends ServiceRequestListScenario {
    @Test(groups = "Car Transfer Form", dependsOnGroups = "serviceRequest")
    public void carTransferForm() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class, "Car transfer form ");
        Thread.sleep(2000);

        enterCarTransferForm();
        String carTransferFormInfo = "image/Car transfer form info" + getPlatform() + ".png";
        Thread.sleep(1000);
        takeScreenshot(carTransferFormInfo);
        scenario.createNode(Given.class, "Enter Car transfer form info").addScreenCaptureFromPath(carTransferFormInfo).pass("Pass");
        tapAddEmail();
        String addEmailScreenCartransfer = "image/Add Email for car Transfer" + getPlatform() + ".png";
        Thread.sleep(1000);
        takeScreenshot(addEmailScreenCartransfer);
        scenario.createNode(Given.class, "Open add Email screen").addScreenCaptureFromPath(addEmailScreenCartransfer).pass("Pass");
        inputInvalidEmail();
        tapSaveEmail();
        String invalidEmailCartransfer = "image/Waring MSG for invalid Email" + getPlatform() + ".png";
        takeScreenshot(invalidEmailCartransfer);
        scenario.createNode(Given.class, "Enter invalid email and tap save displaying warning MSG").addScreenCaptureFromPath(invalidEmailCartransfer).pass("Pass");
        inputValidEmail();
        String enterValidEmail = "image/Enter Valid Email" + getPlatform() + ".png";
        takeScreenshot(enterValidEmail);
        scenario.createNode(Given.class, "Enter Valid Email").addScreenCaptureFromPath(enterValidEmail).pass("Pass");
        tapSaveEmail();
        String tapSaveBTN = "image/Enter valid email and tap save" + getPlatform() + ".png";
        takeScreenshot(tapSaveBTN);
        scenario.createNode(Given.class, "Tap save").addScreenCaptureFromPath(tapSaveBTN).pass("Pass");
        tapNext();
        requestSuccessFul();
        String reqSuccess = "image/Car Transfer Request Success" + getPlatform() + ".png";
        takeScreenshot(reqSuccess);
        scenario.createNode(Given.class, "Car Transfer Form Request successful").addScreenCaptureFromPath(reqSuccess).pass("Pass");
        extent.flush();
    }
}

