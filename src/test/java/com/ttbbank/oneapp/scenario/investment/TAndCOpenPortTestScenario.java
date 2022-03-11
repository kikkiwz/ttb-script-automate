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

public class TAndCOpenPortTestScenario extends MoreActionTestScenario {


    public void validateDisplayTAndCOpenPort() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_BACK_NAVIGATION_BAR, true);

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_ACCEPTANCE_CHECKBOX);

        WebElement backIconImage = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_BACK_NAVIGATION_BAR);
        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_SCREEN_TITLE_LABEL);
        WebElement acceptanceCheckBox = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_ACCEPTANCE_CHECKBOX);
        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_NEXT_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Terms And Conditions Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Terms And Condition/Term And Conditions Open Portfolio.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Not acceptance Terms and Conditions").addScreenCaptureFromPath(transactionPlan).pass("Display Terms and Conditions Open Port Correctly");

        Assert.assertTrue(backIconImage.isDisplayed());
        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(acceptanceCheckBox.isDisplayed());
        Assert.assertFalse(nextButton.isEnabled());

    }

    public void validateTermAndConditionOpenPort() throws InterruptedException, IOException {
        validateDisplayTAndCOpenPort();
    }


    public void unCheckAcceptanceTest() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_NEXT_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Terms And Conditions Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Terms And Condition/Not accept Terms And Conditions Open Portfolio.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Not acceptance Terms and Conditions").addScreenCaptureFromPath(transactionPlan).pass("Display Terms and Conditions Open Port Correctly and cannot click next");

        Assert.assertFalse(nextButton.isEnabled());

    }

    public void checkAcceptanceTest() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement acceptanceCheckbox = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_ACCEPTANCE_CHECKBOX);
        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_T_AND_C_OPEN_PORT_NEXT_BUTTON);

        acceptanceCheckbox.click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Terms And Conditions Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Terms And Condition/Accept Terms And Conditions Open Portfolio.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Acceptance Terms and Conditions").addScreenCaptureFromPath(transactionPlan).pass("Display Terms and Conditions Open Port Correctly and able to Accept");

        Assert.assertTrue(nextButton.isEnabled());
        nextButton.click();

    }

}
