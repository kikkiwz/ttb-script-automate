package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class MyMutualFundTestScenario extends AccountScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;

    @Test(groups = "My Mutual Fund", dependsOnGroups = "Click My Mutual Fund")
    public void validateMyMutualFundCard() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        Thread.sleep(5000);

        if (context.isIos()) {
            System.err.println("test test");
            Thread.sleep(5000);
            context.horizontalSwipeByPercentage(0.2, 0.8, .2);
        }

        WebDriver webView = context.setContextToWebView(OneAppElementKeys.INVESTMENT_MY_MUTUAL_TYPE_OF_FUND_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webView.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_MY_MUTUAL_TYPE_OF_FUND_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }


        WebElement iconImage = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ICON_IMAGE);
        WebElement typeOfFundLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_TYPE_OF_FUND_LABEL);
        WebElement assetValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ASSET_VALUE_LABEL);
        WebElement totalAssetValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_TOTAL_ASSET_VALUE_LABEL);
        WebElement profitLossLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_PROFIT_LOST_THB_LABEL);
        WebElement annualReturnButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ANNUAL_RETURN_BUTTON);
        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_BUY_BUTTON);
        WebElement buyLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_BUY_LABEL);
        WebElement sellButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_SELL_BUTTON);
        WebElement sellLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_SELL_LABEL);
        WebElement activityButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_ACTIVITY_BUTTON);
        WebElement activityLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_ACTIVITY_LABEL);


        scenario = getFeature().createNode(Scenario.class, "My Mutual Fund");
        transactionPlan = "images/" + context.getPlateFormName() + "/MyMutualFund/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "My Mutual Fund").addScreenCaptureFromPath(transactionPlan).pass("pass");


        Assert.assertTrue(iconImage.isDisplayed());
        Assert.assertTrue(typeOfFundLabel.isDisplayed());
        Assert.assertTrue(assetValueLabel.isDisplayed());
        Assert.assertTrue(totalAssetValueLabel.isDisplayed());
        Assert.assertTrue(profitLossLabel.isDisplayed());
        Assert.assertTrue(annualReturnButton.isDisplayed());
        Assert.assertTrue(buyButton.isDisplayed());
        Assert.assertTrue(buyLabel.isDisplayed());
        Assert.assertTrue(sellButton.isDisplayed());
        Assert.assertTrue(sellLabel.isDisplayed());
        Assert.assertTrue(activityButton.isDisplayed());
        Assert.assertTrue(activityLabel.isDisplayed());

    }

    @Test(groups = "My Mutual Fund Event Card", dependsOnGroups = "My Mutual Fund")
    public void validateEventCard() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();

        WebElement orderPendingLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_EVENT_CARD_TITLE_LABEL);
        WebElement orderNoOfTransactLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_EVENT_CARD_NO_OF_TRANSACTION_LABEL);
        WebElement orderPendingButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_EVENT_CARD_ALL_PENDING_TRANSACTION_BUTTON);

        Assert.assertTrue(orderPendingLabel.isDisplayed());
        Assert.assertTrue(orderNoOfTransactLabel.isDisplayed());
        Assert.assertTrue(orderPendingButton.isDisplayed());

    }

    @Test(groups = "My Mutual Fund Holding", dependsOnGroups = "My Mutual Fund")
    public void validateHoldingFund() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        WebElement assetClassTab = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ASSET_CLASS_TAB);
        WebElement portfolioTab = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_PORTFOLIO_TAB);
        WebElement assetAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ASSET_ALLOCATION_LABEL);
        WebElement suggestOfAllocationLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_SUGGEST_OF_ASSET_ALLOCATION_LABEL);
        WebElement donutChartImage = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_DONUT_CHART);
        WebElement assetClassLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_ASSET_CLASSES_LABEL);
        WebElement portionLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_PORTION_LABEL);
        WebElement fundCodeLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_NAME_LABEL);
        WebElement portfolioLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_PORTFOLIO_NICK_NAME_LABEL);
        WebElement investmentValueLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_INVESTMENT_VALUE_LABEL);
        WebElement unrealizedLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_UNREALIZED_PROFIT_VALUE_LABEL);
        WebElement navDateLabel = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_NAV_DATE_LABEL);

        Assert.assertTrue(assetClassTab.isDisplayed());
        Assert.assertTrue(portfolioTab.isDisplayed());
        Assert.assertTrue(assetAllocationLabel.isDisplayed());
        Assert.assertTrue(suggestOfAllocationLabel.isDisplayed());
        Assert.assertTrue(donutChartImage.isDisplayed());
        Assert.assertTrue(assetClassLabel.isDisplayed());
        Assert.assertTrue(portionLabel.isDisplayed());
        Assert.assertTrue(fundCodeLabel.isDisplayed());
        Assert.assertTrue(portfolioLabel.isDisplayed());
        Assert.assertTrue(investmentValueLabel.isDisplayed());
        Assert.assertTrue(unrealizedLabel.isDisplayed());
        Assert.assertTrue(navDateLabel.isDisplayed());

    }

    @Parameters({"mutualFundMenuItem"})
    @Test(groups = "My Mutual Fund Menu", dependsOnGroups = "My Mutual Fund")
    public void validateClickMenuAction(String menuItem) {

        TtbTestContext context = getTtbTestContext();

        WebElement menuItemButton = null;

        switch (menuItem) {
            case "buy":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_BUY_BUTTON);
                break;
            case "sell":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_SELL_BUTTON);
                break;
            case "activity":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_ACTIVITY_BUTTON);
                break;
            case "more":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_MORE_BUTTON);
                break;
        }
        menuItemButton.click();

    }

}
