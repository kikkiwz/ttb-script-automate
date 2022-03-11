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

public class OnBoardingTestScenario extends FundFactSheetFromFundInfoTestScenario {

    public void validateOnBoarding() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_PORT_SCREEN_TITLE_LABEL, true);

        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_PORT_SCREEN_TITLE_LABEL);
        WebElement iconImage = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_PORT_ICON_IMAGE);
        WebElement messageLineLabel = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_MESSAGE_LABEL);
        WebElement messageLine1Label = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_MESSAGE1_LABEL);
        WebElement messageLine2Label = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_MESSAGE2_LABEL);
        WebElement messageLine3Label = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_OPEN_MESSAGE3_LABEL);
        WebElement startButton = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_START_BUTTON);

        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(iconImage.isDisplayed());
        Assert.assertTrue(messageLineLabel.isDisplayed());
        Assert.assertTrue(messageLine1Label.isDisplayed());
        Assert.assertTrue(messageLine2Label.isDisplayed());
        Assert.assertTrue(messageLine3Label.isDisplayed());
        Assert.assertTrue(startButton.isDisplayed());

        ExtentTest scenario = getFeature().createNode(Scenario.class, "On Boarding Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/On Boarding Open Portfolio/On Boarding Open Portfolio.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "On Boarding Open Portfolio").addScreenCaptureFromPath(transactionPlan).pass("On Boarding Open Portfolio display correctly");
    }

    @Test(groups = "Start Open Portfolio", dependsOnGroups = "Fund Fact Sheet")
    public void verifyClickStartButton() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();

        validateOnBoarding();

        WebElement searchFundButton = context.findElement(OneAppElementKeys.INVESTMENT_ONBOARDING_START_BUTTON);
        searchFundButton.click();

        Thread.sleep(1000);

    }


}
