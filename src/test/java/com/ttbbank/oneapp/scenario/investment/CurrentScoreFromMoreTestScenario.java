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

public class CurrentScoreFromMoreTestScenario extends MoreActionTestScenario {


    CurrentScoreTestScenario currentScoreTestScenario = new CurrentScoreTestScenario();

    public void verifyCurrentScore() throws InterruptedException, IOException {
        currentScoreTestScenario.setTtbTestContext(getTtbTestContext());
        currentScoreTestScenario.setExtentReports(getExtent());
        currentScoreTestScenario.setFeature(getFeature());
        currentScoreTestScenario.validateCurrentScore();
    }

    @Test(groups = "Click See Suggested Allocation", dependsOnGroups = "More Menu")
    public void verifyHyperLinkSeeSuggestedAllocation() throws InterruptedException, IOException {
        verifyCurrentScore();
        currentScoreTestScenario.validateHyperLinkSeeSuggestedAllocation();


    }

    @Test(groups = "Click Reassess My Risk", dependsOnGroups = "More Menu")
    public void verifyReassessMyRiskButton() throws InterruptedException, IOException {
        verifyCurrentScore();
        currentScoreTestScenario.validateReassessMyRiskButton();

    }

}
