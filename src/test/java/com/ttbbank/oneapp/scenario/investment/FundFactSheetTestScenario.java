package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class FundFactSheetTestScenario extends SearchFundTestScenario {

    ExtentTest scenario = null;

    public void validateFundFactSheet() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CODE_LABEL, true);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CODE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_SHARE_IMAGE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_FUND_CONTENT_IMAGE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_BUY_BUTTON).isDisplayed());

        scenario = getFeature().createNode(Scenario.class, "Fund Fact Sheet");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Fund Fact Sheet/Fund Fact Sheet.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Fund Fact Sheet").addScreenCaptureFromPath(transactionPlan).pass("Fund Fact Sheet is display correctly");

    }

    public void verifyClickBuyButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_BUY_BUTTON);
        buyButton.click();


    }

    public void validateClickShareIcon() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement shareIconImage = context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_SHARE_IMAGE);
        shareIconImage.click();

        String transactionPlan = "images/" + context.getPlateFormName() + "/Fund Fact Sheet/Fund Fact Sheet Share Icon.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Share Icon on Fund Fact Sheet").addScreenCaptureFromPath(transactionPlan).pass("Able to click Share Icon and system should be display bottom sheet");

    }


    public void validateClickSaveButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement saveButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_SAVE_FILE_BUTTON);
        saveButton.click();


        String transactionPlan = "images/" + context.getPlateFormName() + "/Fund Fact Sheet/Fund Fact Sheet Save Button.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Save Button on Fund Fact Sheet").addScreenCaptureFromPath(transactionPlan).pass("Able to click Save button successfully");


    }

    public void validateClickShareButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement shareButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_SHARE_FILE_BUTTON);
        shareButton.click();

        String transactionPlan = "images/" + context.getPlateFormName() + "/Fund Fact Sheet/Fund Fact Sheet Share Button.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Save Share on Fund Fact Sheet").addScreenCaptureFromPath(transactionPlan).pass("Able to click Share button successfully");

    }


}
