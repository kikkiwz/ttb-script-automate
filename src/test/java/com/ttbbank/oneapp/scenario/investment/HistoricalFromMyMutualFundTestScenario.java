package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.investment.Setting;
import org.testng.annotations.Test;

import java.io.IOException;

public class HistoricalFromMyMutualFundTestScenario extends MyMutualFundTestScenario {


    @Test(groups = "Search Fund", priority = 1, dependsOnGroups = {"My Mutual Fund Menu"})
    public void verifySearchFundBySuiteScoreOneDay() throws InterruptedException, IOException {

        SearchFundTestScenario searchFundTestScenario = new SearchFundTestScenario();
        searchFundTestScenario.setTtbTestContext(getTtbTestContext());
        searchFundTestScenario.setExtentReports(getExtent());
        searchFundTestScenario.setFeature(getFeature());
        searchFundTestScenario.validateSearchFundBySuiteScoreCategory("test", Setting.DURATION.ONE_DAY);
    }


}
