package com.ttbbank.oneapp.scenario.investment;

import org.testng.annotations.Test;

import java.io.IOException;

public class SearchFundFromKnowTTBSmartPortTestScenario extends KnowTTBSmartPortScenario {

    @Test(groups = "Search Fund", dependsOnGroups = {"Introduction to Investment click search fund"})
    public void verifyClickFund() throws InterruptedException, IOException {
        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.verifyClickFund();

    }


}
