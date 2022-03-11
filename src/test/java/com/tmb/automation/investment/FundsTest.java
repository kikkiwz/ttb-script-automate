package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.AccountPaymentDetailsPage;
import com.tmb.automation.pages.investment.FillingPage;
import com.tmb.automation.pages.investment.FundsPage;
import com.tmb.automation.pages.investment.PortfolioPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundsTest extends Base {

    @Test(priority = 1)
    public void validateFunds() throws InterruptedException, IOException {

        
        FundsPage fundsPage = new FundsPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(fundsPage.fundCode));

        
        fundsPage.fundCode.click();

    }

}
