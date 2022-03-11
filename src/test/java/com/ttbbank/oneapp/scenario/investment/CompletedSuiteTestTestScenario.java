package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompletedSuiteTestTestScenario extends RiskAssessmentResultNewScenario {


    public void validateCompletedSuitabilityTest() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_CONTENT_LABEL, true);

        WebElement completedIconImage = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_COMPLETE_ICON);
        WebElement completedTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_CONTENT_LABEL);
        WebElement completedDateTimeLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_SCORE_DATE_TIME_LABEL);
        WebElement riskLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_RISK_LEVEL_LABEL);
        WebElement riskLevelValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_SCORE_LEVEL_LABEL);
        WebElement expiryDateLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_EXPIRY_DATE_LABEL);
        WebElement expiryDateValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_EXPIRY_DATE_VALUE_LABEL);
        WebElement backToMyInvestmentPageButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_BACK_TO_INVESTMENT_BUTTON);
        WebElement reTestButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_REASSESS_BUTTON);


        ExtentTest scenario = getFeature().createNode(Scenario.class, "Completed Suitability Test");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Completed Suitability Test/Completed Suitability Test.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Completed Open Portfolio").addScreenCaptureFromPath(transactionPlan).pass("Suitability Test Completly");

        Assert.assertTrue(completedIconImage.isDisplayed());
        Assert.assertTrue(completedTitleLabel.isDisplayed());
        Assert.assertTrue(completedDateTimeLabel.isDisplayed());
        Assert.assertTrue(riskLevelLabel.isDisplayed());
        Assert.assertTrue(riskLevelValueLabel.isDisplayed());
        Assert.assertTrue(expiryDateLabel.isDisplayed());
        Assert.assertTrue(expiryDateValueLabel.isDisplayed());
        Assert.assertTrue(backToMyInvestmentPageButton.isDisplayed());
        Assert.assertTrue(reTestButton.isDisplayed());

    }
    @Test(groups = "Click Back To Investment", dependsOnGroups = "Click Save Button Score Five")
    public void validateClickBackToInvestmentButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        validateCompletedSuitabilityTest();

        WebElement backToMyInvestmentPageButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_BACK_TO_INVESTMENT_BUTTON);
        backToMyInvestmentPageButton.click();

        Thread.sleep(1000);

    }

    @Test(groups = "Click Re Test Score One", dependsOnGroups = "Click Save Button Score One")
    public void validateReTestScoreOneButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateCompletedSuitabilityTest();

        WebElement reTestButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_REASSESS_BUTTON);
        reTestButton.click();

        Thread.sleep(1000);


    }
    @Test(groups = "Click Re Test Score Two", dependsOnGroups = "Click Save Button Score Two")
    public void validateReTestScoreTwoButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateCompletedSuitabilityTest();

        WebElement reTestButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_REASSESS_BUTTON);
        reTestButton.click();

        Thread.sleep(1000);


    }

    @Test(groups = "Click Re Test Score Three", dependsOnGroups = "Click Save Button Score Three")
    public void validateReTestScoreThreeButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateCompletedSuitabilityTest();

        WebElement reTestButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_REASSESS_BUTTON);
        reTestButton.click();

        Thread.sleep(1000);


    }

    @Test(groups = "Click Re Test Score Four", dependsOnGroups = "Click Save Button Score Four")
    public void validateReTestScoreFourButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateCompletedSuitabilityTest();

        WebElement reTestButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_SUIT_SCREEN_REASSESS_BUTTON);
        reTestButton.click();

        Thread.sleep(1000);


    }


}
