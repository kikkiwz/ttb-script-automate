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

public class InvestmentHomeScenario extends BaseScenario {


    @Test(groups = "Enter Investment Home", dependsOnGroups = "Enter Home Screen Dev Latest By Investment")
    public void enterInvestmentHome() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement investmentAccount = context.findElement(OneAppElementKeys.INVESTMENT_ACCOUNTS_TAB);
        investmentAccount.click();

        WebElement mutualFundsCard = context.findElement(OneAppElementKeys.INVESTMENT_MUTUAL_FUNDS_ITEM);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Account Service");

        String transactionPlan = "images/" + context.getPlateFormName() + "/Account Service/Account Service.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Account Service").addScreenCaptureFromPath(transactionPlan).pass("Account Service Display Correctly");

        Assert.assertTrue(mutualFundsCard.isDisplayed());

        mutualFundsCard.click();


    }

}
