package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.CompletedPage;
import com.tmb.automation.pages.investment.ConfirmationPage;
import com.tmb.automation.pages.investment.PinPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompletedTest extends Base{

    @Test(priority = 1)
    public void validateCompleted() throws InterruptedException, IOException {

        CompletedPage completedPage = new CompletedPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(completedPage.completeCard));

        
        Thread.sleep(10000);

    }

}
