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

public class FundInformationFromSearchFundTestScenario extends SearchFundFromIntroToInvestTestScenario {

    @Test(groups = "Funds Information", dependsOnGroups = {"Click Fund"})
    public void verifyClickBuyButton() throws InterruptedException, IOException {

        FundInformationTestScenario fundInformationTestScenario = new FundInformationTestScenario();
        fundInformationTestScenario.setTtbTestContext(getTtbTestContext());
        fundInformationTestScenario.setExtentReports(getExtent());
        fundInformationTestScenario.setFeature(getFeature());
        fundInformationTestScenario.validateInformationTest();
        fundInformationTestScenario.validateClickBuyButton();

    }


}
