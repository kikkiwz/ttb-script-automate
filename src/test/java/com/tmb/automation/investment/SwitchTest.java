package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.SellPage;
import com.tmb.automation.pages.investment.SwitchPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SwitchTest extends Base {

    @Test(priority = 1)
    public void validateSwitch() throws InterruptedException, IOException {

        
        SwitchPage switchPage = new SwitchPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(switchPage.sourceFundShortName));

        switchPage.typingArea.click();
        switchPage.typingArea.clear();
        switchPage.typingArea.sendKeys("1000.00");

        
        Assert.assertTrue(switchPage.titlePage.isDisplayed());
        Assert.assertTrue(switchPage.navAsOfCurrentDate.isDisplayed());
        Assert.assertTrue(switchPage.portfolioCode.isDisplayed());
        Assert.assertTrue(switchPage.sourceFundShortName.isDisplayed());
        Assert.assertTrue(switchPage.fundFullName.isDisplayed());
        Assert.assertTrue(switchPage.targetFund.isDisplayed());
        Assert.assertTrue(switchPage.targetFundShortName.isDisplayed());
        Assert.assertTrue(switchPage.intUnit.isDisplayed());
        Assert.assertTrue(switchPage.intUnitLb.isDisplayed());
        Assert.assertTrue(switchPage.intValue.isDisplayed());

        switchPage.frontendFeeLb.click();
        switchPage.nextBtn.click();


    }

}
