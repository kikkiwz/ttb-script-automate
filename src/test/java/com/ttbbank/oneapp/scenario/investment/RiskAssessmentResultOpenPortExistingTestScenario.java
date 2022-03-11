package com.ttbbank.oneapp.scenario.investment;

import org.testng.annotations.Test;

import java.io.IOException;

public class RiskAssessmentResultOpenPortExistingTestScenario extends CurrentScoreOpenPortExistingTestScenario {

    RiskAssessmentResultTestScenario riskAssessmentResultTestScenario = new RiskAssessmentResultTestScenario();

    public void validateRiskAssessmentResult() throws InterruptedException, IOException {

        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateRiskAssessmentResult();

    }

    @Test(groups = "Click Confirm Button", dependsOnGroups = "Click Next Button")
    public void verifyClickConfirmButton() throws InterruptedException, IOException {
        validateRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickConfirmButton();

    }

}
