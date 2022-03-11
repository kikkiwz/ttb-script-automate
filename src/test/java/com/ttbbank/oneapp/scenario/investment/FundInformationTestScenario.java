package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;


public class FundInformationTestScenario extends BaseScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;


    public void validateInformationTest() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_SCREEN_TITLE_LABEL, true);


        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_SCREEN_TITLE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_CLASS_NAME_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_FULL_NAME_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FOLLOWING_ICON).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_TAB).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TAB).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_INFORMATION_TAB).isDisplayed());

        scenario = getFeature().createNode(Scenario.class, "Fund Detail");
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Fund Detail").addScreenCaptureFromPath(transactionPlan).pass("Fund Detail display correctly");

    }

    public void validateClickFollowing() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FOLLOWING_ICON);
        buyButton.click();

        Thread.sleep(1000);

        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click Favorite Fund").addScreenCaptureFromPath(transactionPlan).pass("Able to click favorite successfully");

    }

    public void validateClickUnFollowing() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FOLLOWING_ICON);
        buyButton.click();

        Thread.sleep(1000);

        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click unfavorite Fund").addScreenCaptureFromPath(transactionPlan).pass("Able to click unfavorite successfully");

    }

    public void validateClickFundAllocationTab() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement assetAllocationTab = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TAB);
        assetAllocationTab.click();


        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Top 10 Holding section").addScreenCaptureFromPath(transactionPlan).pass("The information display correctly");


        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_BY_ASSET_CLASS_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Asset class section").addScreenCaptureFromPath(transactionPlan).pass("The information display correctly");


        try {
            context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_BY_INDUSTRY_LABEL);
            transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
            takeScreenshot(transactionPlan);
            scenario.createNode(Given.class, "Industry section").addScreenCaptureFromPath(transactionPlan).pass("The information display correctly");

        } catch (Exception ex) {

        }
        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_BY_REGION_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Region section").addScreenCaptureFromPath(transactionPlan).pass("The information display correctly");

        context.scrollUpToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL);
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL, false);
        context.scrollUp();
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL, true);


    }

    public void validateClickGeneralInfoTab() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement generalInfoTab = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_INFORMATION_TAB);
        generalInfoTab.click();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL, false);
        context.scrollDown();

        Thread.sleep(5000);

        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab General Information").addScreenCaptureFromPath(transactionPlan).pass("The information display correctly");

        context.scrollUp();
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL, true);

    }

    public void validateClickPerformanceTab() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();


        WebElement performanceTab = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_TAB);
        performanceTab.click();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_TAB, true);


        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_DATE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_PRICE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE).isDisplayed());


        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_1D_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 1D.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 1D").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");


        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_1M_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 1M";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 1M").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_3M_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 3M";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 3M").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_6M_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 6M";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 6M").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_YTD_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab YTD";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab YTD").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.getDriver().executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(-100%)\";", context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_1D_TAB));

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_1Y_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 1Y";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 1Y").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.getDriver().executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(-100%)\";", context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_1M_TAB));
        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_3Y_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 3Y";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 3Y").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.getDriver().executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(-100%)\";", context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_3M_TAB));
        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_5Y_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab 5Y";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab 5Y").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");

        context.getDriver().executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(-100%)\";", context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_6M_TAB));
        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_DURATION_ALL_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_NAV_GRAPH_IMAGE);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Fund Detail tab All";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Click tab All").addScreenCaptureFromPath(transactionPlan).pass("The graph display correctly");


        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_RETURN_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Return";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Return").addScreenCaptureFromPath(transactionPlan).pass("The table return display correctly");

        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_STANDARD_DEVIATION_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Return";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Standard Deviation").addScreenCaptureFromPath(transactionPlan).pass("The table standard deviation display correctly");

        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_MAX_DRAW_DOWN_LABEL);
        transactionPlan = "images/" + context.getPlateFormName() + "/Fund Detail/Return";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Max Draw down").addScreenCaptureFromPath(transactionPlan).pass("The Max Draw down display correctly");

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_MAX_DRAW_DOWN_LABEL, false);
        context.scrollUp();
        context.scrollUp();
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_PERFORMANCE_TAB, true);
    }

    public void validateClickFundFactSheetLabel() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_INFORMATION_TAB)
                .click();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_INFO_ASSET_ALLOCATION_TOP_TEN_HOLDING_LABEL, false);
        context.scrollDown();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_INFORMATION_FUND_FACT_SHEET_LABEL)
                .click();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_FACT_SHEET_BACK_NAVIGATE_BAR)
                .click();

    }

    public void validateClickBuyButton() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_BUY_BUTTON);
        buyButton.click();


    }


}
