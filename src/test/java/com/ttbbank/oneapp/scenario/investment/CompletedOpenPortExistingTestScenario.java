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

public class CompletedOpenPortExistingTestScenario extends RiskAssessmentResultOpenPortExistingTestScenario {

    CompletedOpenPortTestScenario completedOpenPortTestScenario = new CompletedOpenPortTestScenario();

    public void verifyCompletedOpenPort() throws InterruptedException, IOException {
        completedOpenPortTestScenario.setTtbTestContext(getTtbTestContext());
        completedOpenPortTestScenario.setExtentReports(getExtent());
        completedOpenPortTestScenario.setFeature(getFeature());
        completedOpenPortTestScenario.validateCompletedOpenPort();

    }

    @Test(groups = "Start To Investment", dependsOnGroups = "Click Confirm Button")
    public void verifyStartToInvestmentButton() throws InterruptedException, IOException {
        verifyCompletedOpenPort();
        completedOpenPortTestScenario.validateStartToInvestmentButton();


    }

    @Test(groups = "Go Back To Investment", dependsOnGroups = "Click Confirm Button")
    public void verifyGoBackToInvestmentButton() throws InterruptedException, IOException {
        verifyCompletedOpenPort();
        completedOpenPortTestScenario.validateGoBackToInvestmentButton();

        Thread.sleep(1000);

    }

}
