package com.ttbbank.oneapp.scenario.investment;

import org.testng.annotations.Test;

import java.io.IOException;

public class CurrentScoreOpenPortExistingTestScenario extends InformationOpenPortExistingTestScenario {

    CurrentScoreTestScenario currentScoreTestScenario = new CurrentScoreTestScenario();

    public void verifyCurrentScore() throws InterruptedException, IOException {
        currentScoreTestScenario.setTtbTestContext(getTtbTestContext());
        currentScoreTestScenario.setExtentReports(getExtent());
        currentScoreTestScenario.setFeature(getFeature());
        currentScoreTestScenario.validateCurrentScore();
    }

    @Test(groups = "Click See Suggested Allocation", dependsOnGroups = "Information Open Port click Next Button")
    public void verifyHyperLinkSeeSuggestedAllocation() throws InterruptedException, IOException {
        verifyCurrentScore();
        currentScoreTestScenario.validateHyperLinkSeeSuggestedAllocation();


    }

    @Test(groups = "Click Next Button", dependsOnGroups = "Information Open Port click Next Button")
    public void verifyCurrentScoreNextButton() throws InterruptedException, IOException {
        verifyCurrentScore();
        currentScoreTestScenario.validateNextButton();


    }

    @Test(groups = "Click Reassess My Risk", dependsOnGroups = "Information Open Port click Next Button")
    public void verifyReassessMyRiskButton() throws InterruptedException, IOException {
        verifyCurrentScore();
        currentScoreTestScenario.validateReassessMyRiskButton();

    }

}
