package com.ttbbank.oneapp.scenario.investment;

import org.testng.annotations.Test;

import java.io.IOException;

public class RiskAssessmentResultNewScenario extends SuitabilityTestNewTestScenario {

    RiskAssessmentResultTestScenario riskAssessmentResultTestScenario = new RiskAssessmentResultTestScenario();

    public void validateRiskAssessmentResult() throws InterruptedException, IOException {

        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();

    }

    @Test(groups = "Click Save Button Score One", dependsOnGroups = "Suitability Test Score One")
    public void verifyClickSaveButton() throws InterruptedException, IOException {
        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickSaveButton();

    }

    @Test(groups = "Click Save Button Score Two", dependsOnGroups = "Suitability Test Score Two")
    public void verifyClickSaveScoreTwoButton() throws InterruptedException, IOException {
        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickSaveButton();

    }

    @Test(groups = "Click Save Button Score Three", dependsOnGroups = "Suitability Test Score Three")
    public void verifyClickSaveScoreThreeButton() throws InterruptedException, IOException {
        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickSaveButton();

    }
    @Test(groups = "Click Save Button Score Four", dependsOnGroups = "Suitability Test Score Four")
    public void verifyClickSaveScoreFourButton() throws InterruptedException, IOException {
        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickSaveButton();

    }

    @Test(groups = "Click Save Button Score Five", dependsOnGroups = "Suitability Test Score Five")
    public void verifyClickSaveScoreFiveButton() throws InterruptedException, IOException {
        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateNewRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickSaveButton();

    }

}
