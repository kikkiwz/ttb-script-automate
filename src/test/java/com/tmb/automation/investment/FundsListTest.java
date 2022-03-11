package com.tmb.automation.investment;


import com.tmb.automation.pages.investment.FundListPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundsListTest extends Base {

    @Test(priority = 1)
    public void validateFundsList() throws InterruptedException, IOException {


        FundListPage fundList = new FundListPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(fundList.fundCode));


         fundList.fundCode.click();


    }

}
