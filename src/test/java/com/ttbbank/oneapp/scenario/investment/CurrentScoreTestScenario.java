package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CurrentScoreTestScenario extends BaseScenario {


    public void validateCurrentScore() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SCREEN_TITLE_LABEL, true);

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SCREEN_TITLE_LABEL);
        WebElement backNavigationBar = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_BACK_BUTTON);
        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SCREEN_TITLE_LABEL);
        WebElement myRiskLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_MY_RISK_LEVEL_LABEL);
        WebElement scoreLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SCORE_VALUE_LABEL);
        WebElement scoreLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SCORE_LEVEL_VALUE_LABEL);
        WebElement suggestAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SUGGESTED_ALLOCATION_LABEL);
        WebElement takenDateLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_TAKEN_DATE_LABEL);
        WebElement takenDateValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_TAKEN_DATE_VALUE_LABEL);
        WebElement expiryDateLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_EXPIRY_DATE_LABEL);
        WebElement expiryDateValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_EXPIRY_DATE_VALUE_LABEL);
        WebElement reassessMyRiskButton = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_REASSESS_MY_RISK_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Current Suitability Score");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Current Suitability Score/Current Suitability Score";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Current Suitability Score").addScreenCaptureFromPath(transactionPlan).pass("Current Suitability Score display correctly");

        Assert.assertTrue(backNavigationBar.isDisplayed());
        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(myRiskLevelLabel.isDisplayed());
        Assert.assertTrue(scoreLabel.isDisplayed());
        Assert.assertTrue(scoreLevelLabel.isDisplayed());
        Assert.assertTrue(suggestAllocationLabel.isDisplayed());
        Assert.assertTrue(takenDateLabel.isDisplayed());
        Assert.assertTrue(takenDateValueLabel.isDisplayed());
        Assert.assertTrue(expiryDateLabel.isDisplayed());
        Assert.assertTrue(expiryDateValueLabel.isDisplayed());
        Assert.assertTrue(reassessMyRiskButton.isDisplayed());


    }

    public void validateHyperLinkSeeSuggestedAllocation() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        validateCurrentScore();

        WebElement suggestAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_SUGGESTED_ALLOCATION_LABEL);
        suggestAllocationLabel.click();

    }

    public void validateNextButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        validateCurrentScore();

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_NEXT_BUTTON);
        Assert.assertTrue(nextButton.isDisplayed());
        nextButton.click();

    }

    public void validateReassessMyRiskButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        validateCurrentScore();

        WebElement reassessMyRiskButton = context.findElement(OneAppElementKeys.INVESTMENT_CURRENT_SCORE_REASSESS_MY_RISK_BUTTON);
        reassessMyRiskButton.click();

    }

}
