package com.tmb.automation.investment;


import com.tmb.automation.pages.investment.FundDetailPage;
import com.tmb.automation.util.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundsDetailsTest extends Base {

    @Test(priority = 1)
    public void validateFundsList() throws InterruptedException, IOException {


        FundDetailPage fundDetail = new FundDetailPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(fundDetail.purchaseButton));

       
        fundDetail.purchaseButton.click();

    }

}
