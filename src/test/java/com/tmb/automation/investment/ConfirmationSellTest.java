package com.tmb.automation.investment;


import com.tmb.automation.pages.investment.*;
import com.tmb.automation.util.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfirmationSellTest extends Base {

    @Test(priority = 1)
    public void validateSellConfirmation() throws InterruptedException, IOException {

        ConfirmToSellPage confirmToSellPage = new ConfirmToSellPage(appiumDriverMobile);
       wait.until(ExpectedConditions.visibilityOf(confirmToSellPage.screenTitle));
        confirmToSellPage.riskAcceptance.click();
       confirmToSellPage.confirmationBtn.click();
        PinAfterConfirmPage pinAfterConfirmPage = new PinAfterConfirmPage(appiumDriverMobile);
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number1Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number2Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number3Btn.click();

    }

}
