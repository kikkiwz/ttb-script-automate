package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.ConfirmToSellPage;
import com.tmb.automation.pages.investment.ConfirmToSwitchPage;
import com.tmb.automation.pages.investment.PinAfterConfirmPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfirmationSwitchTest extends Base {

    @Test(priority = 1)
    public void validateSwitchConfirmation() throws InterruptedException, IOException {

        ConfirmToSwitchPage confirmToSwitchPage = new ConfirmToSwitchPage(appiumDriverMobile);

        
        wait.until(ExpectedConditions.visibilityOf(confirmToSwitchPage.titleLb));


        confirmToSwitchPage.riskAcceptance.click();


      
        Assert.assertTrue(confirmToSwitchPage.titleLb.isDisplayed());
        Assert.assertTrue(confirmToSwitchPage.riskAcceptance.isDisplayed());

        confirmToSwitchPage.confirmBtn.click();

        PinAfterConfirmPage pinAfterConfirmPage = new PinAfterConfirmPage(appiumDriverMobile);
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number1Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number2Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number3Btn.click();

    }

}
