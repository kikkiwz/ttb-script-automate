package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchFundFromMyMutualFundTestScenario extends MyMutualFundTestScenario {


//    @Test(groups = "Search Fund", priority = 0, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 1, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 2, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 3, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 4, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 5, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 6, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 7, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRegularMutualFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.REGULAR_MUTUAL_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 8, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 9, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 10, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 11, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 12, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 13, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 14, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 15, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTriggerFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TRIGGER_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 16, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 17, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 18, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 19, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 20, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 21, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 22, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 23, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsTermFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.TERM_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 24, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 25, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 26, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 27, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 28, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 29, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 30, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 31, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsLongTermEquityFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.LONG_TERM_EQUITY_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 32, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 33, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 34, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 35, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 36, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 37, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 38, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 39, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRetirementMutualFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.RETIREMENT_MUTUAL_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 40, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 41, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.ONE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 42, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 43, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 44, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 45, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 46, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 47, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateTypeOfFundIsRollOverFundFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByTypeOfFundCategory("test", Setting.TYPE_OF_FUND.ROLLOVER_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 48, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 49, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 50, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 51, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 52, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortFundYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 53, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 54, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 55, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsTTBSmartPortFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.TTB_SMART_PORT, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 56, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 57, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 58, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 59, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 60, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 61, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 62, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 63, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFixedIncomeFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIXED_INCOME, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 64, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 65, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 66, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 67, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 68, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 69, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 70, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 71, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifFixedIncomeFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_FIXED_INCOME, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 72, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 73, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 74, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 75, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 76, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 77, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 78, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 79, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsBalanceFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.BALANCE, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 80, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 81, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 82, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 83, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquitySixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 84, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 85, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 86, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 87, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsEquityFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.EQUITY, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 88, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 89, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 90, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 91, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquitySixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 92, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 93, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 94, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 95, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifEquityFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_EQUITY, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 96, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 97, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 98, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 99, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 100, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 101, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 102, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 103, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsOtherFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.OTHER, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 104, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 105, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 106, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 107, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 108, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 109, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 110, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 111, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsSSFFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.SUPER_SAVINGS_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 112, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 113, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 114, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 115, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 116, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 117, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 118, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 119, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsRMFFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.RETIREMENT_MUTUAL_FUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 120, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 121, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 122, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 123, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 124, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 125, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 126, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 127, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateAssetClassIsFifBalanceFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByAssetClassCategory("test", Setting.ASSET_CLASS.FIF_BALANCE, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 128, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 129, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 130, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 131, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 132, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 133, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 134, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 135, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTMBAMFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TMBAM, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 136, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 137, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 138, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 139, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 140, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 141, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 142, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 143, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTFUNDFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TFUND, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 144, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 145, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 146, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 147, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 148, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 149, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 150, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 151, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsTiscoAssetFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.TISCOASSET, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 152, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 153, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 154, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 155, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 156, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 157, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 158, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 159, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsUOBAMTHFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.UOBAMTH, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 160, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 161, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 162, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 163, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 164, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 165, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 166, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 167, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsPrincipalFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.PRINCIPAL, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 168, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 169, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 170, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 171, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 172, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 173, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 174, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 175, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsAberdeenFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ABERDEEN, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 176, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 177, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 178, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 179, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 180, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 181, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 182, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 183, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKWIAMFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KWIAM, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 184, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 185, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 186, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 187, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 188, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 189, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 190, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 191, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsONEAMFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.ONEAM, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 192, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 193, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 194, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 195, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 196, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 197, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 198, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 199, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKASSETFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KASSET, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 200, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 201, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 202, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 203, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 204, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 205, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 206, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 207, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKTAMFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KTAM, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 208, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 209, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 230, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 231, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 232, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 233, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 234, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 235, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateFundHouseIsKSAMFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByFundHouseCategory("test", Setting.FUND_HOUSE.KSAM, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 236, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 237, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 238, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 239, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 240, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 241, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 242, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 243, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsEUFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.EU, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 244, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 245, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 246, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 247, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSASixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 248, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 249, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 250, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 251, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsUSAFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.USA, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 252, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 253, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 254, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 255, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 256, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 257, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 258, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 259, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsChinaFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.CHINA, Setting.DURATION.FIVE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 260, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 261, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 262, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 263, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 264, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 265, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 266, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 267, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsJapanFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.JAPAN, Setting.DURATION.FIVE_YEAR);
//    }
//
//
//    @Test(groups = "Search Fund", priority = 268, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandOneDay() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.ONE_DAY);
//    }
//
//    @Test(groups = "Search Fund", priority = 269, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandOneMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.ONE_MONTH);
//
//    }
//
//    @Test(groups = "Search Fund", priority = 270, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandThreeMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.THREE_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 271, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandSixMonth() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.SIX_MONTH);
//    }
//
//    @Test(groups = "Search Fund", priority = 272, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandYTD() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.YTD);
//    }
//
//    @Test(groups = "Search Fund", priority = 273, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandOneYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.ONE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 274, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandThreeYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.THREE_YEAR);
//    }
//
//    @Test(groups = "Search Fund", priority = 275, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCateCustomIsThailandFiveYear() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFundByCustomCategory("test", Setting.CUSTOM.THAILAND, Setting.DURATION.FIVE_YEAR);
//    }


    @Test(groups = "Search Fund", priority = 1, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 2, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.ONE_MONTH);

    }

    @Test(groups = "Search Fund", priority = 3, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 4, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 5, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 6, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 7, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 8, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 9, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 10, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 11, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 12, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllTSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 13, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllTYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 14, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllTOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 15, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 16, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabAllFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.ALL, Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 17, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 18, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 19, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 20, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 21, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 22, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 23, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 24, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabBoughtFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.BOUGHT, Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 25, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 26, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 27, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 28, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 29, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 30, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 31, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 32, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabRecommendedFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.RECOMMENDED, Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 33, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 34, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 35, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 36, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 37, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 38, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 39, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 40, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabWatchListFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.WATCHLIST, Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 41, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 42, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 43, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 44, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 45, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 46, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 47, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 48, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabIPOFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.IPO, Setting.DURATION.FIVE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 49, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.ONE_DAY);
    }

    @Test(groups = "Search Fund", priority = 50, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortOneMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.ONE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 51, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortThreeMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.THREE_MONTH);
    }

    @Test(groups = "Search Fund", priority = 52, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortSixMonth() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.SIX_MONTH);
    }

    @Test(groups = "Search Fund", priority = 53, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortYTD() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.YTD);
    }

    @Test(groups = "Search Fund", priority = 54, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortOneYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.ONE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 55, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortThreeYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.THREE_YEAR);
    }

    @Test(groups = "Search Fund", priority = 56, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundByTabTTBSmartPortFiveYear() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySelectedTab("test", Setting.FUND_FLAG.TTB_SMART_PORT, Setting.DURATION.FIVE_YEAR);
    }

    //
//    @Test(groups = "Search Fund", priority = 1, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputTwoChar() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "te");
//    }
//
//    @Test(groups = "Search Fund", priority = 2, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputThreeCharNotFound() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "tem");
//    }
//
//    @Test(groups = "Search Fund", priority = 3, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputSpecialChar() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "!@$#$");
//    }
//
//    @Test(groups = "Search Fund", priority = 4, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputThreeChar() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "tes");
//    }
//
//    @Test(groups = "Search Fund", priority = 5, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputFundCode() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "TESCHINAA");
//    }
//
//    @Test(groups = "Search Fund", priority = 6, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputFundName() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "T-ES-CHINA A");
//    }
//
//    @Test(groups = "Search Fund", priority = 7, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundInputFundFullName() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.TYPING, "Thanachart Eastspring China A Active Fund");
//    }

//    @Test(groups = "Search Fund", priority = 2, dependsOnGroups = {"My Mutual Fund Menu"})
//    public void verifySearchFundByCategory() throws InterruptedException, IOException {
//
//        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
//        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
//        searchFundTestScenario.setExtentReports(getExtent());
//        searchFundTestScenario.setFeature(getFeature());
//        searchFundTestScenario.validateSearchFund("test", SearchFundTestScenario.SEARCH_TYPE.CATEGORY);
//    }


    @Test(groups = "Click Fund", dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifyClickFund() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.ttbTestContext = getTtbTestContext();
        searchFundTestScenario.verifyClickFund();
    }


}
