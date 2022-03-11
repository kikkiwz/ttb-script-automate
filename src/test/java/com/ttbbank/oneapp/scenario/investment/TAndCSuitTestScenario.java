package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TAndCSuitTestScenario extends BaseScenario {

    public void validateDisplayTAndCSuitabilityTest() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_SCREEN_TITLE_LABEL, true);

        WebElement backIconImage = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_BACK_NAVIGATION_BAR);
        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_SCREEN_TITLE_LABEL);
        WebElement acceptanceCheckBox = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_ACCEPTANCE_CHECKBOX);
        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_NEXT_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Terms And Conditions Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Terms And Condition/Term And Conditions Suitability Test.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Not acceptance Terms and Conditions").addScreenCaptureFromPath(transactionPlan).pass("Display Terms and Conditions Suitability Test Correctly");

        Assert.assertTrue(backIconImage.isDisplayed());
        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(acceptanceCheckBox.isDisplayed());
        Assert.assertFalse(nextButton.isEnabled());
    }

    public void validateTermAndConditionSuitabilityTest() throws InterruptedException, IOException {
        validateDisplayTAndCSuitabilityTest();
    }


    public void unCheckAcceptanceSuitTest() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_NEXT_BUTTON);
        nextButton.click();

    }

    public void checkAcceptanceSuitTest() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement acceptanceCheckbox = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_ACCEPTANCE_CHECKBOX);
        acceptanceCheckbox.click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Terms And Conditions Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Terms And Condition/Accept Terms And Conditions Suitability Test.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Acceptance Terms and Conditions").addScreenCaptureFromPath(transactionPlan).pass("Display Terms and Conditions Suitability Test Correctly and able to Accept");

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_TERMS_AND_CONDITIONS_SUIT_TEST_NEXT_BUTTON);
        nextButton.click();

    }

}
