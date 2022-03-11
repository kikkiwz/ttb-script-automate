package com.tmb.automation.test.lending.sprint18Android;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.parser.ParseException;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import com.tmb.automation.helper.Setting;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.util.TextColor;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.charset.StandardCharsets;

import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.aventstack.extentreports.MediaEntityBuilder;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class SetPIN extends Base {
    static AppiumDriver<MobileElement> driver;
    
    @Parameters({"DeviceProfile" })
    @BeforeMethod 
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        driver= Base.appiumCapabilitiesMobileElement();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExtentListeners.setDriver(driver);
//        mapData = Helper.getExcelData("TestData_lending", "TestData_7604", this.getClass().getSimpleName());
    }

    @AfterMethod
    public void teardown() {
        Base.driverQuit();
    }
 

  
    @Test
    public static void SetPIN() throws Exception, ParseException {


        // Click to Account page
        MobileElement discover = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[2]"));
        discover.click();
        Thread.sleep(3000);

        // Click via PIN
        MobileElement pin01 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin01);
        pin01.click();
        Thread.sleep(500);
        MobileElement pin02 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_01"));
        Log.logger.debug(pin02);
        pin02.click();
        Thread.sleep(500);
        MobileElement pin03 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin03);
        pin03.click();
        Thread.sleep(500);
        MobileElement pin04 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_02"));
        Log.logger.debug(pin04);
        pin04.click();
        Thread.sleep(500);
        MobileElement pin05 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin05);
        pin05.click();
        Thread.sleep(500);
        MobileElement pin06 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_03"));
        Log.logger.debug(pin06);
        pin06.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/appCompatTextView")));
       
        // Click on Card Account Summary
        System.err.println("Click Card on My Account Summary");
        MobileElement as = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Card\"]"));
        Log.logger.debug(as);
        as.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"ABSOLUTE Visa Infinite Credit Card\"]")));
       
        // Click Card image
        System.out.println("Click on Card image");
        MobileElement bl = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"ABSOLUTE Visa Infinite Credit Card\"]"));
        Log.logger.debug(bl);
        bl.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[1]")));
      
        // Swipe tap Unbilled to show transaction
        System.err.println("Swipe bill/unbill to show transaction");
        MobileElement swipeBill =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[1]"));
        TouchAction bill = new TouchAction(driver);
        Log.logger.debug(bill);
        bill.longPress(LongPressOptions.longPressOptions().withElement(element(swipeBill)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 200)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")));
     
        // Swipe tap Unbilled to show more transaction
        System.err.println("Swipe Down to show more transaction");
        MobileElement swipeTrB =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[1]"));
        TouchAction traB = new TouchAction(driver);
        traB.longPress(LongPressOptions.longPressOptions().withElement(element(swipeTrB)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 200)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[6]/android.view.View[1]")));
      
        // Tap on Billed to show transaction
        System.out.println("Click Billed menu");
        MobileElement billMenu = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]"));
        billMenu.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")));
         // Swipe down transaction to show transaction on the top
        System.err.println("Swipe Down billed transaction.");
        MobileElement swipedown =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]"));
        TouchAction sDown = new TouchAction(driver);
        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(swipedown)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 2000)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button")));
       

        // Swipe down to close transaction.
        System.err.println("Swipe down to close transaction.");
        MobileElement transdown =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button"));
        TouchAction ts = new TouchAction(driver);
        ts.longPress(LongPressOptions.longPressOptions().withElement(element(transdown)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 2050)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")));
       
        // swipe to change credit card
        System.err.println("Swipe to change credit card.");
        MobileElement changeCard =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]"));
        TouchAction chCard = new TouchAction(driver);
        chCard.longPress(LongPressOptions.longPressOptions().withElement(element(changeCard)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(70, 875)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")));
        


        // Click More
        System.out.println("Click on More");
        TouchAction clickMore = new TouchAction(driver);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(810,1068)).perform();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[3]/android.widget.Image")));
       
        //Click Set PIN
        System.out.println("Click on Set PIN");
        MobileElement setPIN = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[3]/android.widget.Image"));
        Log.logger.debug(setPIN);
        setPIN.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View")));
         // Click via PIN
        System.out.println("Enter Set ATM Pin");
        MobileElement set01 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[9]"));
        Log.logger.debug(set01);
        set01.click();
        Thread.sleep(500);
        MobileElement set02 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]"));
        Log.logger.debug(set02);
        set02.click();
        Thread.sleep(500);
        MobileElement set03 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]"));
        Log.logger.debug(set03);
        set03.click();
        Thread.sleep(500);
        MobileElement set04 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[7]"));
        Log.logger.debug(set04);
        set04.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]")));
          //Confirm Set PIN
        System.out.println("Enter Confirm to Set ATM Pin");
        MobileElement pin1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[9]"));
        Log.logger.debug(pin01);
        pin1.click();
        Thread.sleep(500);
        MobileElement pin2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]"));
        Log.logger.debug(pin2);
        pin2.click();
        Thread.sleep(500);
        MobileElement pin3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[2]"));
        Log.logger.debug(pin3);
        pin3.click();
        Thread.sleep(500);
        MobileElement pin4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[7]"));
        Log.logger.debug(pin4);
        pin4.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/title_pin")));
         // Click via PIN
        System.out.println("Enter PIN");
        MobileElement epin01 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(epin01);
        epin01.click();
        Thread.sleep(500);
        MobileElement epin02 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_1"));
        Log.logger.debug(epin02);
        epin02.click();
        Thread.sleep(500);
        MobileElement epin03 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(epin03);
        epin03.click();
        Thread.sleep(500);
        MobileElement epin04 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_2"));
        Log.logger.debug(epin04);
        epin04.click();
        Thread.sleep(500);
        MobileElement epin05 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(epin05);
        epin05.click();
        Thread.sleep(500);
        MobileElement epin06 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_3"));
        Log.logger.debug(epin06);
        epin06.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.Button")));
        // Click back to main page
        System.out.println("Back to main page");
        MobileElement btmp = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.Button"));
        Log.logger.debug(btmp);
        btmp.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]")));
 

        System.err.println("Application End.");


    }
}