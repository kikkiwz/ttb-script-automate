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

public class SearchFundFromSmartPortIntroTestScenario extends KnowTTBSmartPortScenario {

    @Test(groups = "Search Fund", dependsOnGroups = {"Click Start Investing"})
    public void validateSearchFund() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL, true);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FUND_NAME_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FUND_FULL_NAME_LABEL).isDisplayed());

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Search Fund");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Search Fund/Search Fund.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Search Fund").addScreenCaptureFromPath(transactionPlan).pass("Search Fund page display correctly");

        WebElement fundNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FUND_NAME_LABEL);
        fundNameLabel.click();
    }

    @Test(groups = "Click Fund", dependsOnGroups = {"Search Fund"})
    public void verifyClickFund() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateSearchFund();

        WebElement fundNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FUND_NAME_LABEL);
        fundNameLabel.click();
    }


}
