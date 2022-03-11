package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchAppScenario extends BaseScenario {

    @Test(groups = "Launch App Group")
    public void prospectClickBackNavigationShouldGoToHomeScreen() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        ttbTestContext.back();
        Assert.assertEquals("QUICK BALANCE", ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText());

        ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON).click();
        ttbTestContext.back();
        Assert.assertEquals("QUICK BALANCE", ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText());

        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.back();
        Assert.assertEquals("QUICK BALANCE", ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText());

        ttbTestContext.back();
    }
}
