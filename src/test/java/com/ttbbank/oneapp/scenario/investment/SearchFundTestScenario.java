package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.model.investment.FundListModel;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import com.ttbbank.oneapp.scenario.investment.config.GetJsonData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class SearchFundTestScenario extends BaseScenario {
    ExtentTest scenario = null;
    FundListModel fundList = null;
    String transactionPlan = null;
    ArrayList<String> currentContext = new ArrayList<String>();


    public enum SEARCH_TYPE {
        CATEGORY,
        TYPING,
        TAB_LIST
    }

    public void validateSearchFundByTyping(String testcaseName, SEARCH_TYPE searchType, String test) throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        fundList = new Gson().fromJson(String.valueOf(GetJsonData.getFundList().get(testcaseName)), FundListModel.class);

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL, true);

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_SEARCH_TEXT)
                .sendKeys(test);
        scenario = getFeature().createNode(Scenario.class, "Search Fund");
        transactionPlan = "images/" + context.getPlateFormName() + "/Search Fund/" + new Setting().imageFileName() + ".png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Search Fund").addScreenCaptureFromPath(transactionPlan).pass("Search Fund page display correctly");
        Thread.sleep(500);

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_SEARCH_TEXT)
                .clear();
        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_BACK_NAVIGATION_BAR)
                .click();

    }


    public void validateSearchFundByTypeOfFundCategory(String testcaseName, Setting.TYPE_OF_FUND fundHouse, Setting.DURATION duration) {
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FILTER_BUTTON)
                .click();
        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CLEAR_BUTTON)
                .click();

        switch (fundHouse) {
            case REGULAR_MUTUAL_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_REGULAR_MUTUAL_FUND_LABEL)
                        .click();
                break;
            case TRIGGER_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_TRIGGER_FUND_LABEL)
                        .click();
                break;
            case TERM_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_TERM_FUND_LABEL)
                        .click();
                break;

            case LONG_TERM_EQUITY_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_LONG_TERM_EQUITY_FUND_LABEL)
                        .click();
                break;
            case RETIREMENT_MUTUAL_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_RETIREMENT_MUTUAL_FUND_LABEL)
                        .click();
                break;
            case ROLLOVER_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_ROLLOVER_FUND_LABEL)
                        .click();
                break;
        }

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_THE_RESULT_BUTTON)
                .click();

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }
    }

    public void validateSearchFundByAssetClassCategory(String testcaseName, Setting.ASSET_CLASS assetClass, Setting.DURATION duration) {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FILTER_BUTTON)
                .click();
        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CLEAR_BUTTON)
                .click();

        switch (assetClass) {
            case TTB_SMART_PORT:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_TTB_SMART_PORT_LABEL)
                        .click();
                break;
            case FIXED_INCOME:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_FIXED_INCOME_LABEL)
                        .click();
                break;
            case FIF_FIXED_INCOME:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_FIF_FIXED_INCOME_LABEL)
                        .click();
                break;
            case BALANCE:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_BALANCED_LABEL)
                        .click();
                break;
            case EQUITY:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_EQUITY_LABEL)
                        .click();
                break;
            case FIF_EQUITY:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_FIF_EQUITY_LABEL)
                        .click();
                break;
            case OTHER:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_OTHERS_LABEL)
                        .click();
                break;
            case SUPER_SAVINGS_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_SUPER_SAVING_FUND_LABEL)
                        .click();
                break;
            case RETIREMENT_MUTUAL_FUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_RETIREMENT_MUTUAL_FUND_LABEL)
                        .click();
                break;
            case FIF_BALANCE:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_ASSET_CLASSES_FIF_BALANCED_LABEL)
                        .click();
                break;


        }

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_THE_RESULT_BUTTON)
                .click();

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }

    }

    public void validateSearchFundByFundHouseCategory(String testcaseName, Setting.FUND_HOUSE fundHouse, Setting.DURATION duration) {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FILTER_BUTTON)
                .click();
        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CLEAR_BUTTON)
                .click();

        switch (fundHouse) {
            case TMBAM:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_TMBAM_LABEL)
                        .click();
                break;
            case TFUND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_TFUND_LABEL)
                        .click();
                break;
            case TISCOASSET:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_TISCOASSET_LABEL)
                        .click();
                break;
            case UOBAMTH:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_UOBAMTH_LABEL)
                        .click();
                break;
            case PRINCIPAL:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_PRINCECIPAL_LABEL)
                        .click();
                break;
            case ABERDEEN:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_ABERDEEN_LABEL)
                        .click();
                break;
            case KWIAM:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_KWIAM_LABEL)
                        .click();
                break;
            case ONEAM:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_ONEAM_LABEL)
                        .click();
                break;
            case KASSET:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_KASSET_LABEL)
                        .click();
                break;
            case KTAM:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_KTAM_LABEL)
                        .click();
                break;
            case KSAM:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_FUND_HOUSE_KSAM_LABEL)
                        .click();
                break;
        }

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_THE_RESULT_BUTTON)
                .click();

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }

    }

    public void validateSearchFundByCustomCategory(String testcaseName, Setting.CUSTOM custom, Setting.DURATION duration) {

        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FILTER_BUTTON)
                .click();
        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CLEAR_BUTTON)
                .click();

        switch (custom) {
            case EU:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CUSTOM_EU_LABEL)
                        .click();
                break;
            case USA:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CUSTOM_USA_LABEL)
                        .click();
                break;
            case CHINA:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CUSTOM_CHINA_LABEL)
                        .click();
                break;
            case JAPAN:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CUSTOM_JAPAN_LABEL)
                        .click();
                break;
            case THAILAND:
                context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CUSTOM_THAILAND_LABEL)
                        .click();
                break;
        }

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_THE_RESULT_BUTTON)
                .click();

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }


    }

    public void validateSearchFundBySuiteScoreCategory(String testcaseName, Setting.DURATION duration) throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

//        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL, true);

        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FILTER_BUTTON)
                .click();

        Thread.sleep(10000);
//        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SCREEN_TITLE_LABEL, true);
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_LABEL, true);

        System.out.println(context.getDriver().getPageSource());

        Thread.sleep(50000);

        System.out.println(context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_TYPE_OF_FUND_LABEL).getText());


        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_CLEAR_BUTTON)
                .click();

        context.scrollDownToElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_ONLY_FUND_CHECKBOX);

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_ONLY_FUND_CHECKBOX)
                .click();

        context.findElement(OneAppElementKeys.INVESTMENT_FILTER_OPTION_SHOW_THE_RESULT_BUTTON)
                .click();

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }


    }

    public void validateSearchFundBySelectedTab(String testcaseName, Setting.FUND_FLAG fundFlag, Setting.DURATION duration) throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

//        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB, true);
//
//        System.err.println(context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB)
//                .getLocation().getY());
//
//        Point p1 = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB).getLocation();
//        Point p2 = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TTB_SMART_PORT_TAB).getLocation();
//
//        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB, false);

//
//        new TouchAction<>(context.getDriver()).longPress(PointOption.point(p1))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//                .moveTo(PointOption.point(p2))
//                .perform();


//        context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB)
//                .getLocation().getY();


        switch (fundFlag) {
            case ALL:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_ALL_TAB)
                        .click();
                break;
            case BOUGHT:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_BOUGHT_TAB)
                        .click();
                break;
            case RECOMMENDED:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_RECOMMENDED_TAB)
                        .click();
                break;
            case WATCHLIST:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_WATCHLIST_TAB)
                        .click();
                break;
            case IPO:
                try {
                    context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_IPO_TAB)
                            .click();
                } catch (Exception ex) {
                    context.swipeLeftToElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_ALL_TAB);
                    context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_IPO_TAB)
                            .click();
                }
                break;
            case TTB_SMART_PORT:
                try {
                    context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TTB_SMART_PORT_TAB)
                            .click();
                } catch (Exception ex) {
                    context.swipeLeftToElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_BOUGHT_TAB);
                    context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TTB_SMART_PORT_TAB)
                            .click();
                }
                break;

        }

        switch (duration) {
            case ONE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_MONTH);
                break;
            case THREE_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_MONTH);
                break;
            case SIX_MONTH:
                validateSearchFundByDurationTab(Setting.DURATION.SIX_MONTH);
                break;
            case YTD:
                validateSearchFundByDurationTab(Setting.DURATION.YTD);
                break;
            case ONE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_YEAR);
                break;
            case THREE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.THREE_YEAR);
                break;
            case FIVE_YEAR:
                validateSearchFundByDurationTab(Setting.DURATION.FIVE_YEAR);
                break;
            case ONE_DAY:
                validateSearchFundByDurationTab(Setting.DURATION.ONE_DAY);
                break;
        }

    }

    public void validateSearchFundByDurationTab(Setting.DURATION duration) {
        TtbTestContext context = getTtbTestContext();

        switch (duration) {
            case ONE_DAY:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_1D_TAB)
                        .click();
                break;
            case ONE_MONTH:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_1M_TAB)
                        .click();
                break;
            case THREE_MONTH:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_3M_TAB)
                        .click();
                break;
            case SIX_MONTH:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_6M_TAB)
                        .click();
                break;
            case YTD:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_YTD_TAB)
                        .click();
                break;
            case ONE_YEAR:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_1Y_TAB)
                        .click();
                break;
            case THREE_YEAR:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_3Y_TAB)
                        .click();
                break;
            case FIVE_YEAR:
                context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_5Y_TAB)
                        .click();
                break;


        }

    }


    public void verifyClickFund() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebElement fundNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_FUND_NAME_LABEL);
        fundNameLabel.click();

        Thread.sleep(1000);

    }


}
