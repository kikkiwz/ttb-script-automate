package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class TAndCSuitFromMoreTestScenario extends CurrentScoreFromMoreTestScenario {

    TAndCSuitTestScenario tAndCSuitTestScenario = new TAndCSuitTestScenario();


    public void validateDisplayTAndCSuitabilityTest() throws InterruptedException, IOException {
        tAndCSuitTestScenario.setTtbTestContext(getTtbTestContext());
        tAndCSuitTestScenario.setExtentReports(getExtent());
        tAndCSuitTestScenario.setFeature(getFeature());
        tAndCSuitTestScenario.validateDisplayTAndCSuitabilityTest();
    }

    @Test(groups = "Terms and Conditions Suitability test", priority = 1, dependsOnGroups = "Click Reassess My Risk")
    public void validateTermAndConditionSuitabilityTest() throws InterruptedException, IOException {
        validateDisplayTAndCSuitabilityTest();
        tAndCSuitTestScenario.validateTermAndConditionSuitabilityTest();
    }


    @Test(groups = "Terms and Conditions Suitability test", priority = 2, dependsOnGroups = "Click Reassess My Risk")
    public void verifyUnCheckAcceptanceSuitTest() throws InterruptedException {
        tAndCSuitTestScenario.unCheckAcceptanceSuitTest();
    }

    @Test(groups = "Terms and Conditions Suitability test", priority = 3, dependsOnGroups = "Click Reassess My Risk")
    public void verifyCheckAcceptanceSuitTest() throws InterruptedException, IOException {

        tAndCSuitTestScenario.checkAcceptanceSuitTest();

    }

}
