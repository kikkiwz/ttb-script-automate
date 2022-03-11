package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RiskAssessmentResultTestScenario extends BaseScenario {


    public void validateRiskAssessmentResult() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_SCORE_LABEL, true);

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_SCORE_LABEL);

        WebElement backNavigationBar = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_BACK_NAVIGATION_BAR);
        WebElement screenTitle = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_LEVEL_LABEL);
        WebElement myRiskLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_LEVEL_LABEL);
        WebElement myRiskScoreLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_SCORE_LABEL);
        WebElement myRiskScoreLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_MY_RISK_SCORE_VALUE_LABEL);
        WebElement seeSuggestAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_SEE_SUGGESTED_ALLOCATION_LABEL);
        WebElement nickNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_NICKNAME_LABEL);
        WebElement nickNameValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_NICKNAME_VALUE_LABEL);
        WebElement purPoseLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_PURPOSE_OF_INVESTMENT_LABEL);
        WebElement purPoseValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_PURPOSE_OF_INVESTMENT_VALUE_LABEL);
        WebElement occupationLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_OCCUPATION_LABEL);
        WebElement occupationValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_OCCUPATION_VALUE_LABEL);
        WebElement positionLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_POSITION_LABEL);
        WebElement positionValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_POSITION_VALUE_LABEL);
        WebElement accountRedeemLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_ACCOUNT_REDEEM_LABEL);
        WebElement accountRedeemValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_ACCOUNT_REDEEM_VALUE_LABEL);
        WebElement addressLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_ADDRESS_LABEL);
        WebElement addressValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_ADDRESS_VALUE_LABEL);
        WebElement confirmButton = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_CONFIRM_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Risk Assessment Result");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Risk Assessment Result/Risk Assessment Result";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Risk Assessment Result").addScreenCaptureFromPath(transactionPlan).pass("Risk Assessment Result display correctly");


        Assert.assertTrue(backNavigationBar.isDisplayed());
        Assert.assertTrue(screenTitle.isDisplayed());
        Assert.assertTrue(myRiskLevelLabel.isDisplayed());
        Assert.assertTrue(myRiskScoreLabel.isDisplayed());
        Assert.assertTrue(myRiskScoreLevelLabel.isDisplayed());
        Assert.assertTrue(seeSuggestAllocationLabel.isDisplayed());
        Assert.assertTrue(nickNameLabel.isDisplayed());
        Assert.assertTrue(nickNameValueLabel.isDisplayed());
        Assert.assertTrue(purPoseLabel.isDisplayed());
        Assert.assertTrue(purPoseValueLabel.isDisplayed());
        Assert.assertTrue(occupationLabel.isDisplayed());
        Assert.assertTrue(occupationValueLabel.isDisplayed());
        Assert.assertTrue(positionLabel.isDisplayed());
        Assert.assertTrue(positionValueLabel.isDisplayed());
        Assert.assertTrue(accountRedeemLabel.isDisplayed());
        Assert.assertTrue(accountRedeemValueLabel.isDisplayed());
        Assert.assertTrue(addressLabel.isDisplayed());
        Assert.assertTrue(addressValueLabel.isDisplayed());
        Assert.assertTrue(confirmButton.isDisplayed());

    }

    public void validateNewRiskAssessmentResult() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_NEW_SCORE_SCREEN_TITLE_LABEL, true);


        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_NEW_SCORE_SCORE_VALUE_LABEL);

        WebElement screenTitle = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SCREEN_TITLE_LABEL);
        WebElement myRiskLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_MY_RISK_LEVEL_LABEL);
        WebElement myRiskScoreLabel = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SCORE_VALUE_LABEL);
        WebElement myRiskScoreLevelLabel = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SCORE_LEVEL_VALUE_LABEL);
        WebElement seeSuggestAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SUGGESTED_ALLOCATION_LABEL);
        WebElement saveButton = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SAVE_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Risk Assessment Result");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Risk Assessment Result/Risk Assessment Result";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Risk Assessment Result").addScreenCaptureFromPath(transactionPlan).pass("Risk Assessment Result display correctly");

        if (context.isIos()) {
            Thread.sleep(1000);
        }

        System.out.println(screenTitle.getText());
        System.out.println(myRiskLevelLabel.getText());
        System.out.println(myRiskScoreLabel.getText());
        System.out.println(myRiskScoreLevelLabel.getText());
        System.out.println(seeSuggestAllocationLabel.getText());
        System.out.println(saveButton.getText());

        Assert.assertTrue(screenTitle.isDisplayed());
        Assert.assertTrue(myRiskLevelLabel.isDisplayed());
        Assert.assertTrue(myRiskScoreLabel.isDisplayed());
        Assert.assertTrue(myRiskScoreLevelLabel.isDisplayed());
        Assert.assertTrue(seeSuggestAllocationLabel.isDisplayed());
        Assert.assertTrue(saveButton.isDisplayed());


    }


    public void validateClickSaveButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        WebElement saveButton = context.findElement(OneAppElementKeys.INVESTMENT_NEW_SCORE_SAVE_BUTTON);
        saveButton.click();

    }

    public void validateClickConfirmButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        WebElement confirmButton = context.findElement(OneAppElementKeys.INVESTMENT_RISK_ASSESSMENT_RESULT_CONFIRM_BUTTON);
        confirmButton.click();

        confirmPin();
    }

}
