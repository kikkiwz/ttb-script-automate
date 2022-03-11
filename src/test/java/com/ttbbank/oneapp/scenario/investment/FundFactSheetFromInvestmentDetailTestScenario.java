package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class FundFactSheetFromInvestmentDetailTestScenario extends FundFactSheetTestScenario {

    public void validateFundFactSheet() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CODE_LABEL, true);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CODE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_SHARE_IMAGE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CONTENT_IMAGE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_BUY_BUTTON).isDisplayed());

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Fund Fact Sheet");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Fund Fact Sheet/Fund Fact Sheet.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Fund Fact Sheet").addScreenCaptureFromPath(transactionPlan).pass("Fund Fact Sheet is display correctly");

    }

    public void validateClickBuyButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_BUY_BUTTON);
        buyButton.click();

        Thread.sleep(1000);


    }

    public void validateClickShareIcon() throws InterruptedException, IOException {

    }


    public void validateClickSaveButton() throws InterruptedException, IOException {


    }

    public void validateClickShareButton() throws InterruptedException, IOException {

    }


}
