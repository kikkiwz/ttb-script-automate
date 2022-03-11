package com.tmb.automation.investment;


import com.tmb.automation.helper.Helper;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.gson.Gson;
import com.tmb.automation.investment.config.GetJsonData;
import com.tmb.automation.model.Investment.MyMutualFundModel;
import com.tmb.automation.pages.investment.MorePage;
import com.tmb.automation.pages.investment.MyMutualFundPage;
import com.tmb.automation.pages.investment.TTBSmartPortPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import scala.App;

import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class MyMutualFundTest extends Base {
	

    @Test(priority = 1)
    public void validateMyMutualFund() throws InterruptedException, IOException {
    
        MyMutualFundModel myMutualFundModel = new Gson().fromJson(String.valueOf(GetJsonData.getMyMutualFund().get("TC_OneApp_my_mutual_fund_screen_0001")), MyMutualFundModel.class);

        MyMutualFundPage myMutualFundPage = new MyMutualFundPage(appiumDriverMobile);
        MorePage morePage = new MorePage(appiumDriverMobile);
        TTBSmartPortPage ttbSmartPortPage = new TTBSmartPortPage(appiumDriverMobile);

        wait.until(ExpectedConditions.visibilityOf(myMutualFundPage.assetValue));

       

        String transType = "switchOnFundSummary";
        String fundType = "ttbSmartPort"; // ttbSmartPort , fundByfund

        TouchAction action = new TouchAction(appiumDriverMobile);

        if (fundType.toLowerCase().equals("fundByfund".toLowerCase())) {

            Thread.sleep(1000);

            switch (transType) {
                case "buyNewFund":

                    myMutualFundPage.buyBtn.click();
                    break;

                case "buyHoldingFund":


//                action.press(PointOption.point(160, 1851)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
//                        .moveTo(PointOption.point(160, 100))
//                        .release()
//                        .perform();

                    Thread.sleep(500);

                    wait.until(ExpectedConditions.visibilityOf(myMutualFundPage.fundCodeTMB50));

                    Assert.assertTrue(myMutualFundPage.fundCodeTMB50.isDisplayed());
                    Assert.assertTrue(myMutualFundPage.fundCodeTMB50.getText().toString().toLowerCase().equals("TMB50".toLowerCase()));

                    System.err.println(myMutualFundPage.fundCodeTMB50.getText().toString());

                    myMutualFundPage.fundCodeTMB50.click();
//                myMutualFundPage.fundCode.getLocation();

                    break;

                case "cancelTransactionOnFundSummary":

                    Point lc = myMutualFundPage.fundCodeTESCHINAA.getLocation();
                    System.out.println(lc);

                    action.press(PointOption.point(900, 1900)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                            .moveTo(PointOption.point(900, 400))
                            .release()
                            .perform();

                    myMutualFundPage.fundCodeTESCHINAA.click();

                    break;

                case "cancelTransactionOnHistorical":

                    myMutualFundPage.activityBtn.click();

                    break;
                case "switchOnFundSummary":
                case "sellOnFundSummary":

                    if (Helper.CONFIG_PROFILE.contains("ios")) {
                        action.press(PointOption.point(350, 821)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                                .moveTo(PointOption.point(350, 87))
                                .release()
                                .perform();

                    } else {
                        action.press(PointOption.point(900, 1881)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                                .moveTo(PointOption.point(900, 500))
                                .release()
                                .perform();

                    }

                    Assert.assertTrue(myMutualFundPage.fundCodeTMB50.isDisplayed());
                    System.out.println(myMutualFundPage.fundCodeTMB50.getText().toString().toLowerCase());
                    System.out.flush();
                    Assert.assertTrue(myMutualFundPage.fundCodeTMB50.getText().toString().toLowerCase().equals("TMB50".toLowerCase()));

                    
                    myMutualFundPage.fundCodeTMB50.click();
                    break;

                case "sellOnMyMutual":
                    myMutualFundPage.sellBtn.click();
                    break;

                case "switchOnMyMutual":
                    myMutualFundPage.moreBtn.click();
                    morePage.switchButton.click();
                    break;
            }
        } else {

            if (Helper.CONFIG_PROFILE.contains("ios")) {
                action.press(PointOption.point(390, 240)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                        .moveTo(PointOption.point(80, 240))
                        .release()
                        .perform();
            } else {
                action.press(PointOption.point(980, 600)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                        .moveTo(PointOption.point(180, 600))
                        .release()
                        .perform();
            }
            Assert.assertTrue(ttbSmartPortPage.assetValue.isDisplayed());
        }

    }

}
