package com.ttbbank.oneapp.scenario.investment;

import org.testng.annotations.Test;

import java.io.IOException;

public class SuitabilityTestNewTestScenario extends TAndCSuitFromMoreTestScenario {

    SuitabilityTestScenario suitabilityTestScenario = new SuitabilityTestScenario();

    @Test(groups = "Suitability Test Score One", dependsOnGroups = "Terms and Conditions Suitability test")
    public void verifySuitabilityTestScoreIsOne() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsOne();

    }

    @Test(groups = "Suitability Test Score Two", dependsOnGroups = "Click Re Test Score One")
    public void verifySuitabilityTestScoreIsTwo() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsTwo();

    }

    @Test(groups = "Suitability Test Score Three", dependsOnGroups = "Click Re Test Score Two")
    public void verifySuitabilityTestScoreIsThree() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsThree();

    }

    @Test(groups = "Suitability Test Score Four", dependsOnGroups = "Click Re Test Score Three")
    public void verifySuitabilityTestScoreIsFour() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsFour();

    }

    @Test(groups = "Suitability Test Score Five", dependsOnGroups = "Click Re Test Score Four")
    public void verifySuitabilityTestScoreIsFive() throws IOException {

        suitabilityTestScenario.setTtbTestContext(getTtbTestContext());
        suitabilityTestScenario.setExtentReports(getExtent());
        suitabilityTestScenario.setFeature(getFeature());
        suitabilityTestScenario.suitabilityTestScoreIsFive();

    }

}
