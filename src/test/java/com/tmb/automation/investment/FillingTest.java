package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.AccountPaymentDetailsPage;
import com.tmb.automation.pages.investment.FillingPage;
import com.tmb.automation.pages.investment.MyMutualFundPage;
import com.tmb.automation.pages.investment.PortfolioPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class FillingTest extends Base {

    @Test(priority = 1)
    public void validateFilling() throws InterruptedException, IOException {

//        Thread.sleep(2000);
        
        FillingPage fillingPage = new FillingPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(fillingPage.fundCard));


        String trnType = "buyHoldingFund";
        switch (trnType) {
            case "buyNewfund":
                fillingPage.selectPortNumber.click();
                PortfolioPage portfolioPage = new PortfolioPage(appiumDriverMobile);
//                portfolioPage.enterPortNumber.click();
                break;

            case "buyHoldingFund":
                fillingPage.paymentDetails.click();
                break;
        }

        AccountPaymentDetailsPage accountPaymentDetailsPage = new AccountPaymentDetailsPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(accountPaymentDetailsPage.accountName));
        accountPaymentDetailsPage.accountNumber.click();
//        fillingPage.paymentDetails.sendKeys("111-2-46916-6");
//        wait.until(ExpectedConditions.visibilityOf(fillingPage.outStandingBalancelb));

//        fillingPage.amount.click();
        fillingPage.enterAmount.sendKeys("1201.30");
//        fillingPage.amountDone.click();


        fillingPage.selectCalendar.click();
        fillingPage.enterDate.click();
//        fillingPage.closeCalendar.click();
        wait.until(ExpectedConditions.visibilityOf(fillingPage.effectiveTransaction));


       
        fillingPage.purchaseButton.click();

        try {
            wait.until(ExpectedConditions.visibilityOf(fillingPage.continueButton));

           
            fillingPage.continueButton.click();

        } catch (Exception e) {
        }

    }

}
