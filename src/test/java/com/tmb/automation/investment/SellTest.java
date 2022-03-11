package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.FundsPage;
import com.tmb.automation.pages.investment.SellPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class SellTest extends Base {

    @Test(priority = 1)
    public void validateSell() throws InterruptedException, IOException {

        
        SellPage sellPage = new SellPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(sellPage.fundShortName));

        sellPage.typingArea.click();
        sellPage.typingArea.clear();
        sellPage.typingArea.sendKeys("1000.00");

        sellPage.frontEndFee.click();
        sellPage.nextButton.click();


    }

}
