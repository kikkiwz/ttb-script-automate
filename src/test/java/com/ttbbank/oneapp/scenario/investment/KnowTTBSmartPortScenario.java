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

public class KnowTTBSmartPortScenario extends IntroductionToInvestmentScenario {

    public void validateMoreAboutTTBSmartPort() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_SCREEN_TITLE_LABEL, true);

        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_SCREEN_TITLE_LABEL);
        WebElement iconImage = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_ICON_IMAGE);
        WebElement descriptionLabel = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_DESCRIPTION_LABEL);
        WebElement startInvestingButton = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_START_INVESTING_BUTTON);
        WebElement whatIsTTBSmartPortLabel = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_WHAT_IS_TTB_SMART_PORT_LABEL);
        WebElement contentBullet1Label = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_CONTENT_BULLET1_LABEL);
        WebElement contentBullet2Label = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_CONTENT_BULLET2_LABEL);
        WebElement contentBullet3Label = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_CONTENT_BULLET3_LABEL);
        WebElement contentBullet4Label = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_CONTENT_BULLET4_LABEL);
        WebElement contentBullet5Label = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_CONTENT_BULLET5_LABEL);

        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(iconImage.isDisplayed());
        Assert.assertTrue(descriptionLabel.isDisplayed());
        Assert.assertTrue(startInvestingButton.isDisplayed());
        Assert.assertTrue(whatIsTTBSmartPortLabel.isDisplayed());
        Assert.assertTrue(contentBullet1Label.isDisplayed());
        Assert.assertTrue(contentBullet2Label.isDisplayed());
        Assert.assertTrue(contentBullet3Label.isDisplayed());
        Assert.assertTrue(contentBullet4Label.isDisplayed());
        Assert.assertTrue(contentBullet5Label.isDisplayed());

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Learn more about ttb smart port");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Learn more about ttb smart port/Learn more about ttb smart port.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Learn more about ttb smart port").addScreenCaptureFromPath(transactionPlan).pass("Learn more about ttb smart port page display correctly");

    }

    @Test(groups = "Click Start Investing", dependsOnGroups = "Introduction to Investment click know ttb smart port")
    public void verifyClickStartInvesting() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        validateMoreAboutTTBSmartPort();

        WebElement startInvestingButton = context.findElement(OneAppElementKeys.INVESTMENT_KNOW_TTB_SMART_PORT_START_INVESTING_BUTTON);
        startInvestingButton.click();

        Thread.sleep(6000);

    }

}
