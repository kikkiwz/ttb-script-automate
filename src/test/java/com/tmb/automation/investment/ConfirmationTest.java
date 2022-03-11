package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.*;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfirmationTest extends Base{

    @Test(priority = 1)
    public void validateConfirmation() throws InterruptedException, IOException {

        ConfirmationPage confirmationPage = new ConfirmationPage(appiumDriverMobile);
        confirmationPage.agrement1.click();
        confirmationPage.agrement2.click();
        wait.until(ExpectedConditions.visibilityOf(confirmationPage.confirmButton));
        confirmationPage.confirmButton.click();

        
        PinAfterConfirmPage pinAfterConfirmPage = new PinAfterConfirmPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(pinAfterConfirmPage.number0Btn));
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number1Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number2Btn.click();
        pinAfterConfirmPage.number0Btn.click();
        pinAfterConfirmPage.number3Btn.click();

    }

}
