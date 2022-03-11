package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PreviewTaxDocumentTestScenario extends TaxDocumentTestScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;

    @Test(groups = "Tax document", priority = 1, dependsOnGroups = "Tax Summary")
    public void validateDisplayTaxDocument() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        Thread.sleep(10000);

        scenario = getFeature().createNode(Scenario.class, "Preview Tax Document");
        transactionPlan = "images/" + context.getPlateFormName() + "/PreviewTaxDocument/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Preview Tax Document").addScreenCaptureFromPath(transactionPlan).pass("Display PDF file Correctly");

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL, true);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL).isDisplayed());


    }

//    @Test(groups = "Tax document", priority = 2, dependsOnGroups = "Tax Summary")
//    public void validateClickShareIcon() throws IOException {
//        TtbTestContext context = getTtbTestContext();
//
//        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SHARE_ICON_IMAGE)
//                .click();
//
////        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_TITLE_LABEL).isDisplayed());
//        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SAVE_FILE_BUTTON).isDisplayed());
//        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SHARE_SHARE_FILE_BUTTON).isDisplayed());
//
//        transactionPlan = "images/" + context.getPlateFormName() + "/PreviewTaxDocument/" + new Setting().imageFileName() + ".png";
//        takeScreenshot(transactionPlan);
//        scenario.createNode(Given.class, "Click Share file icon").addScreenCaptureFromPath(transactionPlan).pass("Should display popup correctly");
//
//    }

    @Test(groups = "Tax document", priority = 2, dependsOnGroups = "Tax Summary")
    public void validateClickSaveFie() throws IOException {
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SAVE_FILE_BUTTON)
                .click();


        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL, false);

        transactionPlan = "images/" + context.getPlateFormName() + "/PreviewTaxDocument/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Save File Button").addScreenCaptureFromPath(transactionPlan).pass("Able to save file successfully");

        context.back();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL, true);


    }

    @Test(groups = "Tax document", priority = 3, dependsOnGroups = "Tax Summary")
    public void validateClickShare() throws IOException {
        TtbTestContext context = getTtbTestContext();

//        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SHARE_ICON_IMAGE)
//                .click();

        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SHARE_SHARE_FILE_BUTTON)
                .click();


        transactionPlan = "images/" + context.getPlateFormName() + "/PreviewTaxDocument/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Share File Button").addScreenCaptureFromPath(transactionPlan).pass("Able to share file successfully");

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL, false);

        context.back();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_FUND_NAME_LABEL, true);
    }

//    @Test(groups = "Tax document", priority = 5, dependsOnGroups = "Tax Summary")
//    public void validateClickClose() throws IOException {
//        TtbTestContext context = getTtbTestContext();
//
//        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_SHARE_ICON_IMAGE)
//                .click();
//
//        context.findElement(OneAppElementKeys.INVESTMENT_TAX_PREVIEW_CLOSE_BUTTON)
//                .click();
//
//        transactionPlan = "images/" + context.getPlateFormName() + "/PreviewTaxDocument/" + new Setting().imageFileName() + ".png";
//        takeScreenshot(transactionPlan);
//        scenario.createNode(Given.class, "Click Close popup Button").addScreenCaptureFromPath(transactionPlan).pass("Able to close successfully");
//
//
//    }

}
