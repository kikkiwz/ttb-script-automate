package com.tmb.automation.investment;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.investment.DiscoveryPage;
import com.tmb.automation.pages.investment.PinPage;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import scala.App;

import java.io.IOException;
import java.util.Properties;

public class DiscoveryTest extends Base {


    @Test(priority = 1)
    public void validateClickItem() throws InterruptedException, IOException {


        DiscoveryPage listOfServicePage = new DiscoveryPage(appiumDriverMobile);

//        if (Helper.CONFIG_PROFILE.contains("Android")) {
//            wait.until(ExpectedConditions.visibilityOf(listOfServicePage.tutorialSkipBtn));
//            listOfServicePage.tutorialSkipBtn.click();
//        }
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfServicePage.investmentItem));
        listOfServicePage.investmentItem.click();
//        PinPage pinPage = new PinPage(appiumDriverMobile);
//        wait.until(ExpectedConditions.visibilityOfAllElements(pinPage.number0Btn));
//        pinPage.number0Btn.click();
//        pinPage.number1Btn.click();
//        pinPage.number0Btn.click();
//        pinPage.number2Btn.click();
//        pinPage.number0Btn.click();
//        pinPage.number3Btn.click();

    }
}
