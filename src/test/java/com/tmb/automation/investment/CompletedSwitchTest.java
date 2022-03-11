package com.tmb.automation.investment;


import com.tmb.automation.pages.investment.CompleteSwitchPage;
import com.tmb.automation.util.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompletedSwitchTest extends Base {

    @Test(priority = 1)
    public void validateCompletedForSwitchFund() throws InterruptedException, IOException {


        CompleteSwitchPage completeSwitchPage = new CompleteSwitchPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(completeSwitchPage.completeIcon));
        Assert.assertTrue(completeSwitchPage.completeIcon.isDisplayed());
        Assert.assertTrue(completeSwitchPage.titleLb.isDisplayed());
        Assert.assertTrue(completeSwitchPage.transactionOrderdateTime.isDisplayed());
        System.err.println(completeSwitchPage.transactionOrderdateTime.getText().toString());

    }

}
