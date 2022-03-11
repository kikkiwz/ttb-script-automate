package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.FundFactSheetPage;
import com.tmb.automation.pages.investment.FundSummaryPage;
import com.tmb.automation.pages.investment.MyMutualFundPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scala.App;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FundFactSheetTest extends Base {

    @Test(priority = 1)
    public void validateFundFactSheet() throws InterruptedException, IOException {

        Properties prop = new Properties();
       // String automationType = "android";

//        try {
//            prop.load(App.class.getClassLoader().getResourceAsStream("Platform2.properties"));
//            automationType = prop.getProperty("mobileOs");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }



        FundFactSheetPage fundFactSheetPage = new FundFactSheetPage(appiumDriverMobile);


       
        if (Helper.CONFIG_PROFILE.contains("ios")) {

            Thread.sleep(20000);
            TouchAction actionNextFundFactsheet = new TouchAction(appiumDriverMobile);

            actionNextFundFactsheet.tap(PointOption.point(212, 882)).perform();
            actionNextFundFactsheet.tap(PointOption.point(212, 882)).perform();

        } else {

            wait.until(ExpectedConditions.visibilityOf(fundFactSheetPage.pdfPage));
            fundFactSheetPage.nextButton.click();

        }


//        fundFactSheetPage.nextButton.click();
//        wait.until(ExpectedConditions.visibilityOf(fundFactSheetPage.nextButton));
//        fundFactSheetPage.nextButton.click();


//        TouchAction action = new TouchAction(appium);
//        action.tap(PointOption.point(216,796)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(30)));
//        action.press(PointOption.point(205,792)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(400)));

    }

}
