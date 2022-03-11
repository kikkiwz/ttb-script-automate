package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class CompletedOpenPortTestScenario extends RiskAssessmentResultTestScenario {


    public void validateCompletedOpenPort() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_COMPLETED_ICON_IMAGE, true);

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_COMPLETED_ICON_IMAGE);

        WebElement completeIconImage = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_COMPLETED_ICON_IMAGE);
        WebElement completeLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_COMPLETED_LABEL);
        WebElement dateTimeLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_DATE_TIME_LABEL);
        WebElement portNumberLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_PORT_NUMBER_LABEL);
        WebElement portNumberValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_PORT_NUMBER_VALUE_LABEL);
        WebElement nickNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_PORT_NICKNAME_LABEL);
        WebElement nickNameValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_PORT_NICKNAME_VALUE_LABEL);
        WebElement startToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_START_TO_INVESTMENT_BUTTON);
        WebElement goBackToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_GO_BACK_TO_INVESTMENT_PAGE_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Completed Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Completed Open Portfolio/Completed Open Portfolio.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Completed Open Portfolio").addScreenCaptureFromPath(transactionPlan).pass("Open Portfolio Completely");

        Assert.assertTrue(completeIconImage.isDisplayed());
        Assert.assertTrue(completeLabel.isDisplayed());
        Assert.assertTrue(dateTimeLabel.isDisplayed());
        Assert.assertTrue(portNumberLabel.isDisplayed());
        Assert.assertTrue(portNumberValueLabel.isDisplayed());
        Assert.assertTrue(nickNameLabel.isDisplayed());
        Assert.assertTrue(nickNameValueLabel.isDisplayed());
        Assert.assertTrue(startToInvestmentButton.isDisplayed());
        Assert.assertTrue(goBackToInvestmentButton.isDisplayed());

    }

    public void validateStartToInvestmentButton() {
        TtbTestContext context = getTtbTestContext();

        WebElement startToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_START_TO_INVESTMENT_BUTTON);
        startToInvestmentButton.click();
    }

    public void validateGoBackToInvestmentButton() {

        TtbTestContext context = getTtbTestContext();

        WebElement backToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_OPEN_PORT_GO_BACK_TO_INVESTMENT_PAGE_BUTTON);
        backToInvestmentButton.click();

    }

}
