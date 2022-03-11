package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class HistoricalTransactionTestScenario extends BaseScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;


    public void validateHistoricalTransactionTest() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_HISTORICAL_SCREEN_TITLE_LABEL, true);


        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_SCREEN_TITLE_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_SEARCH_TEXT).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_FUND_TYPE_FILTER_TEXT).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_FILTER_TEXT).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_COMPLETED_TAB).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_PENDING_TAB).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_CANCELED_TAB).isDisplayed());

        scenario = getFeature().createNode(Scenario.class, "Transaction Historical");
        transactionPlan = "images/" + context.getPlateFormName() + "/Transaction Historical/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Transaction Historical").addScreenCaptureFromPath(transactionPlan).pass("Historical Transaction display correctly");

    }

    public void validateSearchActivity(String inputCharacter) throws IOException {

        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_SEARCH_TEXT).click();
        context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_SEARCH_TEXT).sendKeys(inputCharacter);

        transactionPlan = "images/" + context.getPlateFormName() + "/Transaction Historical/" + new Setting().imageFileName() + ".png";
    }

    public void validateSelectedFundType(Setting.FUND_TYPE fundType) throws IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_FUND_TYPE_FILTER_TEXT).click();

        switch (fundType) {
            case ALL:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_FUND_TYPE_ALL_LABEL).click();
                break;
            case MUTUAL_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_FUND_TYPE_MUTUAL_FUND_LABEL).click();
                break;
            case TTB_SMART_PORT:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_FUND_TYPE_TTB_SMART_PORT_LABEL).click();
                break;
        }


        transactionPlan = "images/" + context.getPlateFormName() + "/Transaction Historical/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);

        File file = ((TakesScreenshot) context.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));

        new String(encoded, StandardCharsets.US_ASCII);

        scenario.createNode(Given.class, "Transaction Historical").addScreenCaptureFromPath(transactionPlan).pass("Historical Transaction display correctly");
        scenario.createNode(Given.class, "Transaction Historical2").addScreenCaptureFromBase64String(String.valueOf(MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build())).pass("Historical Transaction display correctly");


    }


    public void validateSelectedTransactionType(Setting.TRANSACTION_TYPE transactionType) throws IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_FILTER_TEXT).click();

        boolean isPass = false;

        switch (transactionType) {
            case ALL:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_ALL_TYPE_LABEL).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("buy")
                        || context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("sell")
                        || context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("switch in")
                        || context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("switch out");
                break;
            case BUY:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_BUY_LABEL).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("buy");
                break;
            case SELL:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_SELL_LABEL).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("sell");
                break;
            case SWITCH:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_SWITCH_LABEL).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("switch in") || context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TYPE_LABEL).getText()
                        .equalsIgnoreCase("switch out");
                break;
            case DCA:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_DCA_LABEL).click();
                break;
            case DIVIDEND:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_DIVIDEND_LABEL).click();
                break;
            case AUTO_REDEMPTION:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_TYPE_AUTO_REDEMPTION_LABEL).click();
                break;

        }

        transactionPlan = "images/" + context.getPlateFormName() + "/Transaction Historical/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Transaction Historical").addScreenCaptureFromPath(transactionPlan).pass("Historical Transaction display correctly");

    }

    public void validateTransactionStatusTab(Setting.TRANSACTION_STATUS transactionStatus) throws IOException {
        TtbTestContext context = getTtbTestContext();

        boolean isPass = false;

        switch (transactionStatus) {
            case COMPLETED:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_COMPLETED_TAB).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TRANSACTION_STATUS_TAG_LABEL).getText()
                        .equalsIgnoreCase("completed");
                break;
            case PROCESSING:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_PENDING_TAB).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TRANSACTION_STATUS_TAG_LABEL).getText()
                        .equalsIgnoreCase("pending");
                break;
            case CANCELED:
                context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_CANCELED_TAB).click();
                isPass = context.findElement(OneAppElementKeys.INVESTMENT_HISTORICAL_TRANSACTION_NO1_TRANSACTION_STATUS_TAG_LABEL).getText()
                        .equalsIgnoreCase("cancelled");
                break;
        }

        Assert.assertTrue(isPass);

        transactionPlan = "images/" + context.getPlateFormName() + "/Transaction Historical/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Transaction Historical").addScreenCaptureFromPath(transactionPlan).pass("Historical Transaction display correctly");

    }


}
