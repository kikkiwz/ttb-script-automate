package com.tmb.automation.test.lending.sprint25Android;

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
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.aventstack.extentreports.MediaEntityBuilder;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class OneApp13698_FlashCard extends Base {
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
    }

    @AfterMethod
    public void teardown() {
        Base.driverQuit();
    }
 

  
    @Test
    public static void CreditCard() throws Exception, ParseException {
       

        System.err.println("Application Started....");

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[3]")));

        // Click to Service page
        MobileElement discover = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[3]"));
        discover.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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


        Thread.sleep(500);
        MobileElement advertising = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/skipIntro"));
        Log.logger.debug(advertising);
        advertising.click();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

     
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Card\"]/android.widget.TextView")));
         // Click on Card
        MobileElement ckCard = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Card\"]/android.widget.TextView"));
        Log.logger.debug(ckCard);
        ckCard.click();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"So Fast Credit Card\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[2]/android.view.ViewGroup")));
       
        // Product landing page
        MobileElement ckProduct = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"So Fast Credit Card\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[2]/android.view.ViewGroup"));
        Log.logger.debug(ckProduct);
        ckProduct.click();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Button")));
        
        // Click add flexi card
        System.out.println("Add Flexi loan product");
        TouchAction clickMore = new TouchAction(driver);
        Thread.sleep(1000);
        /*
        MobileElement ckAdd = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Button"));
        Log.logger.debug(ckAdd);
        ckAdd.click();
         */
        clickMore.tap(PointOption.point(1002,383)).perform();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button")));
        
        // Entry point to Flexi loan
        System.out.println("Add Flexi loan product"); // 532,2039
        Thread.sleep(1000);
        MobileElement entryFlex = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button"));
        entryFlex.click();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]")));
        
        // Chose the product to apply Flash card
        System.out.println("Apply Flash Card");
        MobileElement product = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]"));
        product.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Button")));
        
        // Confirm apply product
        System.out.println("Confirm apply Flash Card");
        MobileElement applyProduct = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Button"));
        applyProduct.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.view.View")));
       
        // Detail Flash card Click account to reduce
        System.out.println("Choose account to reduce");
        MobileElement chooseAccount = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.view.View"));
        chooseAccount.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[11]/android.view.View[1]/android.widget.TextView")));
       
        // เงื่อนไขสำหรับหักบัญชี
        System.out.println("Full Reduce");
        MobileElement reduce = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[11]/android.view.View[1]/android.widget.TextView"));
        reduce.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[11]/android.view.View[1]/android.widget.TextView")));
        
        // swipe up
        // Swipe down
        TouchAction sDown = new TouchAction(driver);
        sDown.longPress(PointOption.point(634, 2097)).moveTo(PointOption.point(634, 180)).release().perform();
        Thread.sleep(500);

        // Click Next
        System.out.println("Click on Next To Personal Info");
        Thread.sleep(1000);
        System.out.println("Question One");
        clickMore.tap(PointOption.point(172,747)).perform();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        Thread.sleep(1000);
        System.out.println("Question Two");
        clickMore.tap(PointOption.point(168,1463)).perform();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[12]/android.widget.Button")));
        
        Thread.sleep(500);
        System.out.println("Click Next to personal information");
        MobileElement next2person = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[12]/android.widget.Button"));
        next2person.click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.TextView[2]")));
        

        // swipe down
        System.err.println("Swipe down");
        MobileElement downNext =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[7]/android.view.View"));
        TouchAction personNext = new TouchAction(driver);
        Log.logger.debug(personNext);
        personNext.longPress(LongPressOptions.longPressOptions().withElement(element(downNext)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 200)).release().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button")));

        // Click Next to Working page
        MobileElement nextToWorking = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.Button"));
        nextToWorking.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView[2]")));
        
        // Swipe down to see button
        System.out.println("Swpie down");
        TouchAction workingPage = new TouchAction(driver);
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();

        // Click to choose receive bill payment
        System.out.println("Choose Receive bill payment");
        MobileElement chooseBill = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[11]/android.view.View/android.view.View[1]/android.widget.TextView"));
        chooseBill.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(300);

        System.out.println("Tik Box");
        MobileElement tikBox = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[11]/android.view.View/android.view.View[1]/android.widget.TextView"));
        tikBox.click();
        Thread.sleep(2000);
        tikBox.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(300);

        // Click Next
        System.out.println("Click Next");
        MobileElement nextToTnC = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View[13]/android.widget.Button"));
        nextToTnC.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.TextView[2]")));
        Thread.sleep(300);
         // Term and Condition
        System.out.println("Click tik box T&C");
        MobileElement tixBox1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.widget.CheckBox"));
        tixBox1.click();
        Thread.sleep(1000);

        MobileElement tixBox2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.widget.CheckBox"));
        tixBox2.click();
        Thread.sleep(1000);

        MobileElement tixBox3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[5]/android.view.View[1]/android.widget.CheckBox"));
        tixBox3.click();
        Thread.sleep(1000);


        System.out.println("Click Next on T&C page.");
        MobileElement tncNext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.widget.Button"));
        tncNext.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.TextView[2]")));
        Thread.sleep(300);
        
        //Swipe down
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();

        // Click  accept
        System.out.println("Click  accept.");
        MobileElement accept = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.widget.Button[2]"));
        accept.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/pin_key_0")));
        Thread.sleep(300);

        // Enter Pin
        MobileElement con01 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(con01);
        con01.click();
        Thread.sleep(500);
        MobileElement con02 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_1"));
        Log.logger.debug(con02);
        con02.click();
        Thread.sleep(500);
        MobileElement con03 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(con03);
        con03.click();
        Thread.sleep(500);
        MobileElement con04 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_2"));
        Log.logger.debug(con04);
        con04.click();
        Thread.sleep(500);
        MobileElement con05 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        Log.logger.debug(con05);
        con05.click();
        Thread.sleep(500);
        MobileElement con06 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_3"));
        Log.logger.debug(con06);
        con06.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[2]")));
        Thread.sleep(300);
        

        // Click Next to complete page.
        Thread.sleep(1500);
        System.out.println("Click  Next.");
        MobileElement nextComplete = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.widget.Button"));
        nextComplete.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView[2]")));
        Thread.sleep(300);
        
        // Click need to apply laon day one.
        Thread.sleep(1500);
        System.out.println("Need to Loan.");
        MobileElement needLoan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[1]/android.widget.TextView"));
        needLoan.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.widget.TextView")));
        Thread.sleep(300);
         // Click Full loan
        Thread.sleep(1500);
        System.out.println("Click  Full loan.");
        MobileElement fullLoan = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.widget.TextView"));
        fullLoan.click();
        Thread.sleep(500);

        // swipe
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();

        // Click on Full amount
        System.out.println("Click pay full amount");
        Thread.sleep(1000);
        clickMore.tap(PointOption.point(450,1127)).perform();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       
        // swipe
        Thread.sleep(500);
        workingPage.longPress(PointOption.point(458, 2133)).moveTo(PointOption.point(427, 266)).release().perform();
        
        // Click Next
        System.out.println("Click on Next");
        Thread.sleep(500);
        clickMore.tap(PointOption.point(540,2117)).perform();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View/android.view.View[4]/android.widget.Button")));
        

        System.err.println("Application End.");


    }
}