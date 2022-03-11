package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectMailingAddressTestScenario extends InformationOpenPortTestScenario {

    @Test(groups = "Funds Information", dependsOnGroups = {"Funds","Introduction to Investment click search fund","My Mutual Fund Menu"})
    public void validateSearchFund() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL,true);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_CLASS_NAME_LABEL).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_FUND_FULL_NAME_LABEL).isDisplayed());

        WebElement buyButton = context.findElement(OneAppElementKeys.INVESTMENT_FUND_INFO_BUY_BUTTON);
        buyButton.click();
    }


}
