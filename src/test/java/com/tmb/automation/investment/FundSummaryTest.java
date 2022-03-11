package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.gson.Gson;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.investment.config.GetJsonData;
import com.tmb.automation.model.Investment.FundSummaryModel;
import com.tmb.automation.pages.investment.FundSummaryPage;
import com.tmb.automation.pages.investment.PinAfterConfirmPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class FundSummaryTest extends Base {

    @Test(priority = 1)
    public void validateFundSummary() throws InterruptedException, IOException {

        FundSummaryModel fundSummaryModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundSummary().get("TC_OneApp_Fund_Summary_Screen_0002")), FundSummaryModel.class);

        FundSummaryPage fundSummaryPage = new FundSummaryPage(appiumDriverMobile);
        wait.until(ExpectedConditions.visibilityOf(fundSummaryPage.transactionHistoryTab));

       
        String transType = fundSummaryModel.TestData.Transaction_Type;

        Assert.assertTrue(fundSummaryPage.fundSummaryTitle.isDisplayed());
        Assert.assertTrue(fundSummaryPage.fundCode.getText().toString().toLowerCase().equals(fundSummaryModel.TestData.Fund_Name.toLowerCase()));
        Assert.assertTrue(fundSummaryPage.fundFullName.getText().toString().toLowerCase().equals(fundSummaryModel.TestData.Fund_Full_Name_EN.toLowerCase())||fundSummaryPage.fundFullName.getText().toLowerCase().equals(fundSummaryModel.TestData.Fund_Full_Name_TH.toLowerCase()));
//        Assert.assertTrue(fundSummaryPage.portNo.getText().toString().toLowerCase().equals(fundSummaryModel.TestData.Portfolio.toLowerCase()));
        Assert.assertTrue(fundSummaryPage.riskOfFund.isDisplayed());

        switch (transType) {

            case "buy":

                fundSummaryPage.purchaseButton.click();

                break;

            case "cancel":

                TouchAction action = new TouchAction(appiumDriverMobile);
                action.press(PointOption.point(160, 780)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                        .moveTo(PointOption.point(160, 662))
                        .release()
                        .perform();


                fundSummaryPage.cancelTransactionBtn.click();
                wait.until(ExpectedConditions.visibilityOf(fundSummaryPage.confirmationPopUp));

                 fundSummaryPage.yesBtn.click();

                PinAfterConfirmPage pinAfterConfirmPage = new PinAfterConfirmPage(appiumDriverMobile);
                pinAfterConfirmPage.number0Btn.click();
                pinAfterConfirmPage.number1Btn.click();
                pinAfterConfirmPage.number0Btn.click();
                pinAfterConfirmPage.number2Btn.click();
                pinAfterConfirmPage.number0Btn.click();
                pinAfterConfirmPage.number3Btn.click();

                wait.until(ExpectedConditions.visibilityOf(fundSummaryPage.toastNoti));

                break;

            case "sell":
                fundSummaryPage.redeemButton.click();

            case "switch":
                fundSummaryPage.switchButton.click();
        }

    }

}
