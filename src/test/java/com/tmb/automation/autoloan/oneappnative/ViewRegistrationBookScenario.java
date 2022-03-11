package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewRegistrationBookScenario extends AccountDetailScenario {

    @Test(groups = "ViewRegistrationBook", dependsOnGroups = "accountDetail")
    void viewCarRegis() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class, "View RegistrationsBook");
        Thread.sleep(3000);
        enterViewRegistrationBook();
        Thread.sleep(3000);

        String screenShot = "images/view_registration_book" + getPlatform() + ".png";
        takeScreenshot(screenShot);
        scenario.createNode(Given.class, "Open Car registration book").addScreenCaptureFromPath(screenShot).pass("pass");
        extent.flush();
    }

}
