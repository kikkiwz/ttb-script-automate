package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FundInfoFromMyMutualTestScenario extends SearchFundFromMyMutualFundTestScenario {

    FundInformationTestScenario fundInformationTestScenario = new FundInformationTestScenario();


    @Test(groups = "Funds Information", priority = 1, dependsOnGroups = {"Click Fund"})
    public void verifyFundDetails() throws InterruptedException, IOException {

        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateInformationTest();

    }

    @Test(groups = "Funds Information", priority = 2, dependsOnGroups = {"Click Fund"})
    public void verifyFundAllocationTab() throws IOException, InterruptedException {
        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateClickFundAllocationTab();
    }

    @Test(groups = "Funds Information", priority = 3, dependsOnGroups = {"Click Fund"})
    public void verifyGeneralInformationTab() throws IOException, InterruptedException {
        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateClickGeneralInfoTab();
    }

    @Test(groups = "Funds Information", priority = 4, dependsOnGroups = {"Click Fund"})
    public void verifyPerformanceTab() throws IOException, InterruptedException {
        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateClickPerformanceTab();
    }


    @Test(groups = "Funds Information", priority = 5, dependsOnGroups = {"Click Fund"})
    public void verifyClickFollowing() throws InterruptedException, IOException {

        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateClickFollowing();

    }

    @Test(groups = "Funds Information", priority = 6, dependsOnGroups = {"Click Fund"})
    public void verifyClickUnFollowing() throws InterruptedException, IOException {

        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateClickUnFollowing();

    }

    @Test(groups = "Click fund face sheet", priority = 6, dependsOnGroups = {"Click Fund"})
    public void verifyClickFundFactSheet() throws InterruptedException, IOException {

        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateInformationTest();
        fundInformationTestScenario.validateClickFundFactSheetLabel();

    }

    @Test(groups = "Buy Fund", dependsOnGroups = {"Click Fund"})
    public void verifyClickBuyButton() throws InterruptedException, IOException {

        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateInformationTest();
        fundInformationTestScenario.validateClickBuyButton();

    }


}
