package com.ttbbank.oneapp.scenario.investment;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountScenario extends BaseScenario {


    public void verifyMyAccount() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        WebElement accountTab = context.findElement(OneAppElementKeys.ACCOUNT_TAB);
        accountTab.click();

        WebElement accountNextIntroButton = context.findElement(OneAppElementKeys.ACCOUNT_INTRO_SKIP_BUTTON);
        accountNextIntroButton.click();

        context.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);


        context.findElement(OneAppElementKeys.INVESTMENT_ACCOUNTS_TAB)
                .click();

        Thread.sleep(5000);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Account Service");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Account Service/Account Service.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Account Service").addScreenCaptureFromPath(transactionPlan).pass("Account Service Display Correctly");

    }

    @Test(groups = "Click My Mutual Fund", dependsOnGroups = "Activate new flow")
    public void verifyClickMyMutualFund() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        verifyMyAccount();

        WebElement mutualFundsCard = context.findElement(OneAppElementKeys.INVESTMENT_MUTUAL_FUNDS_ITEM);
        mutualFundsCard.click();

    }

    @Test(groups = "Click ttb Smart Port", dependsOnGroups = "Activate new flow")
    public void verifyClickTTBSmartPort() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        verifyMyAccount();

        WebElement smartPortCard = context.findElement(OneAppElementKeys.INVESTMENT_FUNDS_SMART_PORT_TAB);
        smartPortCard.click();


    }

    @Test(groups = "Click Start Investing With ttb", dependsOnGroups = "Activate new flow")
    public void verifyClickStartInvestingWithTTB() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        verifyMyAccount();

        WebElement startInvestingButton = context.findElement(OneAppElementKeys.INVESTMENT_START_INVESTING_WITH_TTB_BUTTON);
        startInvestingButton.click();

        Thread.sleep(1000);

    }

    @Test(groups = "Click View Eastspring investment account ", dependsOnGroups = "Activate new flow")
    public void verifyClickViewEastspringInvestmentAccount() throws IOException {

        TtbTestContext context = getTtbTestContext();

    }

    @Test(groups = "Click Fund Information", dependsOnGroups = "Activate new flow")
    public void verifyClickFundInformation() throws IOException {

        TtbTestContext context = getTtbTestContext();


    }

    @Test(groups = "Click Market Insight", dependsOnGroups = "Activate new flow")
    public void verifyClickMarketInsight() throws IOException {

        TtbTestContext context = getTtbTestContext();


    }


}
