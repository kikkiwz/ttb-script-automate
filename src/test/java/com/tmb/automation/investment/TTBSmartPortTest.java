package com.tmb.automation.investment;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import scala.App;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TTBSmartPortTest extends Base {

    @Test(priority = 1)
    public void validateMyMutualFund() throws InterruptedException, IOException {

//        MyMutualFundModel myMutualFundModel = new Gson().fromJson(String.valueOf(GetJsonData.getMyMutualFund().get("TC_OneApp_my_mutual_fund_screen_0001")), MyMutualFundModel.class);

        TTBSmartPortPage ttbSmartPortPage = new TTBSmartPortPage(appiumDriverMobile);
        MorePage morePage = new MorePage(appiumDriverMobile);

        Properties prop = new Properties();
        String automationType = "android";

        try {
            prop.load(App.class.getClassLoader().getResourceAsStream("Platform2.properties"));
            automationType = prop.getProperty("mobileOs");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        wait.until(ExpectedConditions.visibilityOf(ttbSmartPortPage.assetValue));

        //parentReport = extent.createTest(myMutualFundModel.ScenarioName, myMutualFundModel.Description);

        String transType = "buyHoldingFund";

        TouchAction action = new TouchAction(appiumDriverMobile);

        Thread.sleep(1000);

        switch (transType) {
            case "buyNewFund":

                ttbSmartPortPage.buyBtn.click();
                break;

            case "buyHoldingFund":


//                action.press(PointOption.point(160, 1851)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
//                        .moveTo(PointOption.point(160, 100))
//                        .release()
//                        .perform();

                Thread.sleep(500);

                wait.until(ExpectedConditions.visibilityOf(ttbSmartPortPage.fundCodeModel1));

                Assert.assertTrue(ttbSmartPortPage.fundCodeModel1.isDisplayed());
                Assert.assertTrue(ttbSmartPortPage.fundCodeModel1.getText().toString().toLowerCase().equals("MODEL1".toLowerCase()));

                System.err.println(ttbSmartPortPage.fundCodeModel1.getText().toString());

                ttbSmartPortPage.fundCodeModel1.click();

//                myMutualFundPage.fundCode.getLocation();

                break;

            case "cancelTransactionOnFundSummary":

//                Point lc = myMutualFundPage.fundCodeTESCHINAA.getLocation();
//                System.out.println(lc);
//
//                action.press(PointOption.point(900, 1900)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
//                        .moveTo(PointOption.point(900, 400))
//                        .release()
//                        .perform();

                ttbSmartPortPage.fundCodeModel1.click();

                break;

            case "cancelTransactionOnHistorical":

                ttbSmartPortPage.activityBtn.click();

                break;
            case "switchOnFundSummary":
            case "sellOnFundSummary":

                if (automationType.equalsIgnoreCase("ios")) {
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


                break;

            case "sellOnMyMutual":
                break;

            case "switchOnMyMutual":
                ttbSmartPortPage.moreBtn.click();
                morePage.switchButton.click();
                break;

        }

    }

}
