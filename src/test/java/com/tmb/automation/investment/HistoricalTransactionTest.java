package com.tmb.automation.investment;

import com.tmb.automation.helper.Helper;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.pages.investment.HistoricalTransactionPage;
import com.tmb.automation.pages.investment.PinAfterConfirmPage;
import com.tmb.automation.pages.investment.PinPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class HistoricalTransactionTest extends Base {

    @Test(priority = 1)
    public void validateHistoricalTransaction() throws InterruptedException, IOException {

        HistoricalTransactionPage historicalTransactionPage = new HistoricalTransactionPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(historicalTransactionPage.title));

        
        String actionType = "cancelTnx";
        //String automationType = "android";

        switch (actionType) {
            case "cancelTnx":

                historicalTransactionPage.search.sendKeys("TESCHINAA");
                historicalTransactionPage.searchResult.click();
                historicalTransactionPage.pendingSts.click();
                historicalTransactionPage.cancelTransaction.click();

                wait.until(ExpectedConditions.visibilityOf(historicalTransactionPage.confirmationQuestion));
                historicalTransactionPage.yesBtn.click();

                if (Helper.CONFIG_PROFILE.contains("Android")) {
                    PinAfterConfirmPage pinAfterConfirmPage = new PinAfterConfirmPage(appiumDriverMobile);
                    pinAfterConfirmPage.number0Btn.click();
                    pinAfterConfirmPage.number1Btn.click();
                    pinAfterConfirmPage.number0Btn.click();
                    pinAfterConfirmPage.number2Btn.click();
                    pinAfterConfirmPage.number0Btn.click();
                    pinAfterConfirmPage.number3Btn.click();
                } else {
                    PinPage pinPage = new PinPage(appiumDriverMobile);
                    wait.until(ExpectedConditions.visibilityOfAllElements(pinPage.number0Btn));
                    pinPage.number0Btn.click();
                    pinPage.number1Btn.click();
                    pinPage.number0Btn.click();
                    pinPage.number2Btn.click();
                    pinPage.number0Btn.click();
                    pinPage.number3Btn.click();
                }

                wait.until(ExpectedConditions.visibilityOf(historicalTransactionPage.toastNoti));
                
                Thread.sleep(1000);

        }


    }

}
