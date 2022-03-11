package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TAndCOpenPortFromMoreTestScenario extends MoreActionTestScenario {

    TAndCOpenPortTestScenario tAndCOpenPortTestScenario = new TAndCOpenPortTestScenario();

    public void validateDisplayTAndCOpenPort() throws InterruptedException, IOException {

        tAndCOpenPortTestScenario.setTtbTestContext(getTtbTestContext());
        tAndCOpenPortTestScenario.setExtentReports(getExtent());
        tAndCOpenPortTestScenario.setFeature(getFeature());
        tAndCOpenPortTestScenario.validateDisplayTAndCOpenPort();

    }

    @Test(groups = "Terms and Conditions Open Portfolio", priority = 1, dependsOnGroups = "More Menu")
    public void validateTermAndConditionOpenPort() throws InterruptedException, IOException {
        validateDisplayTAndCOpenPort();
        tAndCOpenPortTestScenario.validateTermAndConditionOpenPort();
    }


    @Test(groups = "Terms and Conditions Open Portfolio", priority = 2, dependsOnGroups = "More Menu")
    public void verifyUnCheckAcceptanceTest() throws InterruptedException, IOException {

        tAndCOpenPortTestScenario.unCheckAcceptanceTest();

    }

    @Test(groups = "Terms and Conditions Open Portfolio", priority = 3, dependsOnGroups = "More Menu")
    public void verifyCheckAcceptanceTest() throws InterruptedException, IOException {

        tAndCOpenPortTestScenario.checkAcceptanceTest();

    }

}
