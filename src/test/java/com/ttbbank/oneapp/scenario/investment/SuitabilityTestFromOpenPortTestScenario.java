package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SuitabilityTestFromOpenPortTestScenario extends TAndCSuitFromInfoOpenPortScenario {

    SuitabilityTestScenario suitabilityTestScenario = new SuitabilityTestScenario();

    @Test(groups = "Suitability Test", dependsOnGroups = "Terms and Conditions Suitability test")
    public void verifySuitabilityTestIsScoreTwo() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsTwo();

    }

}
