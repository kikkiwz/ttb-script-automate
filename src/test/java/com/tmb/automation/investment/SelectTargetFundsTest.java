package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.SelectTargetFundsPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectTargetFundsTest extends Base {

    @Test(priority = 1)
    public void validateSelectTargetFunds() throws InterruptedException, IOException {

        SelectTargetFundsPage selectTargetFundsPage = new SelectTargetFundsPage(appiumDriverMobile);

        

        wait.until(ExpectedConditions.visibilityOf(selectTargetFundsPage.fundFullName));

        
        Assert.assertTrue(selectTargetFundsPage.titlePage.isDisplayed());
        Assert.assertTrue(selectTargetFundsPage.fundShortName.isDisplayed());
        Assert.assertTrue(selectTargetFundsPage.fundRiskLevel.isDisplayed());
        Assert.assertTrue(selectTargetFundsPage.navValue.isDisplayed());
        Assert.assertTrue(selectTargetFundsPage.fundFullName.isDisplayed());
        Assert.assertTrue(selectTargetFundsPage.navAsOfCurrentDate.isDisplayed());



        selectTargetFundsPage.fundShortName.click();

        Thread.sleep(10000);

    }

}
