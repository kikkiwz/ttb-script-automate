package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class ServiceRequestListScenario extends AccountDetailScenario {

    @Test(groups = "serviceRequest", dependsOnGroups = "accountDetail")
    void serviceRequest() throws InterruptedException, IOException {
        ExtentTest scenario = feature.createNode(Scenario.class, "Service Request List");
        Thread.sleep(5000);
        enterServiceRequest();
        Thread.sleep(5000);
        String screenShot = "images/service_request_list_" + getPlatform() + ".png";
        takeScreenshot(screenShot);
        scenario.createNode(Given.class, "Shows Service Request List Screen").addScreenCaptureFromPath(screenShot).pass("pass");
        extent.flush();
    }

}
