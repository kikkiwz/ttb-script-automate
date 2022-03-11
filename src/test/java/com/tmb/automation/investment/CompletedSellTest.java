package com.tmb.automation.investment;


import com.tmb.automation.pages.investment.CompletedSellPage;
import com.tmb.automation.util.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompletedSellTest extends Base{
	
    @Test(priority = 1)
    public void validateCompletedForSellFund() throws InterruptedException, IOException {
    	
        CompletedSellPage completedSellPage = new CompletedSellPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(completedSellPage.completedIcon));
        Assert.assertTrue(completedSellPage.completedIcon.isDisplayed());
        Assert.assertTrue(completedSellPage.titleLb.isDisplayed());
        Assert.assertTrue(completedSellPage.transactionOrderDateTime.isDisplayed());
        System.err.println(completedSellPage.transactionOrderDateTime.getText().toString());

    }

}
