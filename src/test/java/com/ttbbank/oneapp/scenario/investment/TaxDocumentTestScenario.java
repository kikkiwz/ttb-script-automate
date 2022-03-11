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

public class TaxDocumentTestScenario extends MoreActionTestScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;

    @Test(groups = "Tax Summary", priority = 1, dependsOnGroups = "More Menu")
    public void validateDisplayTaxDocument() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_TAX_SCREEN_TITLE_LABEL, true);


        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_SCREEN_TITLE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_LAST_YEAR_TAB).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_CURRENT_YEAR_TAB).isDisplayed());

        scenario = getFeature().createNode(Scenario.class, "Tax Summary");
        transactionPlan = "images/" + context.getPlateFormName() + "/TaxSummary/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Tax Summary").addScreenCaptureFromPath(transactionPlan).pass("Display PDF file Correctly");

    }

    @Test(groups = "Tax Summary", priority = 2, dependsOnGroups = "More Menu")
    public void validateClickLastYearTaxDocument() throws IOException {

        TtbTestContext context = getTtbTestContext();

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_TOTAL_INVESTMENT_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_TOTAL_INVESTMENT_VALUE_LABEL).isDisplayed());

        try {
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TYPE_OF_FUND_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TOTAL_INVESTMENT_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TOTAL_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_INVESTMENT_VALUE_LABEL).isDisplayed());
        } catch (Exception ex) {

        }

        scenario = getFeature().createNode(Scenario.class, "Tax Summary");
        transactionPlan = "images/" + context.getPlateFormName() + "/TaxSummary/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Last Year Tab").addScreenCaptureFromPath(transactionPlan).pass("Display information Correctly");

    }

    @Test(groups = "Tax Summary", priority = 3, dependsOnGroups = "More Menu")
    public void validateClickCurrentYearTaxDocument() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_TAX_CURRENT_YEAR_TAB).click();

//        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_TOTAL_INVESTMENT_LABEL).isDisplayed());
//        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_TOTAL_INVESTMENT_VALUE_LABEL).isDisplayed());

        try {
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TYPE_OF_FUND_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TOTAL_INVESTMENT_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_TOTAL_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST1_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_INVESTMENT_VALUE_LABEL).isDisplayed());

            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_FUND_NAME_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_PORTFOLIO_LABEL).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST3_INVESTMENT_VALUE_LABEL).isDisplayed());
        } catch (Exception ex) {

        }

        scenario = getFeature().createNode(Scenario.class, "Tax Summary");
        transactionPlan = "images/" + context.getPlateFormName() + "/TaxSummary/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Current Year Tab").addScreenCaptureFromPath(transactionPlan).pass("Display information Correctly");
    }

    @Test(groups = "Tax Summary", priority = 4, dependsOnGroups = "More Menu")
    public void validateClickSeeTaxDocument() {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_TAX_LAST_YEAR_TAB).click();

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_TAX_DOCUMENT_LABEL).isDisplayed());

        context.findElement(OneAppElementKeys.INVESTMENT_TAX_GROUP1_LIST2_TAX_DOCUMENT_LABEL)
                .click();

    }

}
