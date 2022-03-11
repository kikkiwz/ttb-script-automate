package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.SelectSourceFundsPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectSourceFundsTest extends Base {

    @Test(priority = 1)
    public void validateSelectSourceFunds() throws InterruptedException, IOException {

        SelectSourceFundsPage selectSourceFundsPage = new SelectSourceFundsPage(appiumDriverMobile);


       

        wait.until(ExpectedConditions.visibilityOf(selectSourceFundsPage.fundShortName));

        
        Assert.assertTrue(selectSourceFundsPage.titlePage.isDisplayed());
        Assert.assertTrue(selectSourceFundsPage.fundShortName.isDisplayed());
        Assert.assertTrue(selectSourceFundsPage.availableInvestmentValue.isDisplayed());
        Assert.assertTrue(selectSourceFundsPage.portNumber.isDisplayed());
        Assert.assertTrue(selectSourceFundsPage.profitLoss.isDisplayed());
        Assert.assertTrue(selectSourceFundsPage.navAsOfCurrentDate.isDisplayed());

        selectSourceFundsPage.fundShortName.click();
    }

}
