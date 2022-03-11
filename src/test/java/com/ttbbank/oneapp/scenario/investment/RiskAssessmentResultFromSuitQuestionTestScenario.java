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

public class RiskAssessmentResultFromSuitQuestionTestScenario extends SuitabilityTestFromOpenPortTestScenario {

    RiskAssessmentResultTestScenario riskAssessmentResultTestScenario = new RiskAssessmentResultTestScenario();

    public void validateRiskAssessmentResult() throws InterruptedException, IOException {

        riskAssessmentResultTestScenario.setTtbTestContext(getTtbTestContext());
        riskAssessmentResultTestScenario.setExtentReports(getExtent());
        riskAssessmentResultTestScenario.setFeature(getFeature());
        riskAssessmentResultTestScenario.validateRiskAssessmentResult();

    }

    @Test(groups = "Click Confirm Button", dependsOnGroups = "Suitability Test")
    public void verifyClickConfirmButton() throws InterruptedException, IOException {
        validateRiskAssessmentResult();
        riskAssessmentResultTestScenario.validateClickConfirmButton();

    }

}
