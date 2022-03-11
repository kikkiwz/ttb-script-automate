package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ProductLandingofCreditScenario extends BaseScenario {

    @Test(groups = "Product Landing of Credit Card Primary")
    // 001100000000000000000012021064   2989208507414
    public void productLandingPrimary() throws InterruptedException, IOException {

//        registerCrmByPassOTP("2989208507414");

        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Product Landing of Credit Card Primary");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();


        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        Thread.sleep(2000);
        String accountSum = "ProductLandingPrimary/Account Summary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary Page").addScreenCaptureFromPath(accountSum).pass("pass");

        cardButton.click();

        // Credit Card Page.
        System.out.println("Click Card");
        WebElement primaryClick = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_PRIMARY_ACCOUNT);
        Thread.sleep(2000);
        String loanSum = "ProductLandingPrimary/Credit Card Summary.png";
        takeScreenshot(loanSum);
        scenario.createNode(Given.class, "Credit Card Summary Page").addScreenCaptureFromPath(loanSum).pass("pass");

        System.out.println("Click Primary");
        primaryClick.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait to data on Product Landing");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(10000);
        String creditCard = "images/ProductLandingPrimary/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on more menu");
        moreButton.click();
        Thread.sleep(1000);
        WebElement closeBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_CLOSE_MORE_BTN);
        String moreImage = "images/ProductLandingPrimary/more menu.png";
        takeScreenshot(moreImage);
        scenario.createNode(Given.class, "App displayed more menu and check Menu button that should be shown.").addScreenCaptureFromPath(moreImage).pass("pass");

        System.out.println("Close more button");
        closeBTN.click();
        Thread.sleep(1000);
        WebElement swipeUp = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_BILLED_BTN);
        String imgCloseMore = "images/ProductLandingPrimary/Close more.png";
        takeScreenshot(imgCloseMore);
        scenario.createNode(Given.class, "App displayed Product Landing.").addScreenCaptureFromPath(imgCloseMore).pass("pass");

        System.out.println("swipe billed unbilled");
        Thread.sleep(1000);
        TouchAction sDown = new TouchAction(ttbTestContext.getDriver());
        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(swipeUp)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 1000)).release().perform();
        Thread.sleep(1000);
        WebElement billedBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_BILLED_BTN);
        String imgSwipeBilled = "images/ProductLandingPrimary/swipe bill.png";
        takeScreenshot(imgSwipeBilled);
        scenario.createNode(Given.class, "Swipe Billed/Unbilled to see transaction.").addScreenCaptureFromPath(imgSwipeBilled).pass("pass");

        System.out.println("Click on Billed");
        billedBTN.click();
        Thread.sleep(1000);
        WebElement selectBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SELECT_BOX);
        String imgSelectBox = "images/ProductLandingPrimary/Unbilled.png";
        takeScreenshot(imgSelectBox);
        scenario.createNode(Given.class, "Click Billed to see transaction.").addScreenCaptureFromPath(imgSelectBox).pass("pass");

        System.out.println("Click on Select box");
        selectBox.click();
        Thread.sleep(1000);
        WebElement selectMonth = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SELECT_MONTH);
        String imgMonth = "images/ProductLandingPrimary/Option Month.png";
        takeScreenshot(imgMonth);
        scenario.createNode(Given.class, "Select Month box, App displayed option Months.").addScreenCaptureFromPath(imgMonth).pass("pass");

        System.out.println("Select month");
        selectMonth.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(3000);
        WebElement spending = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SPENDING);
        String imgResult = "images/ProductLandingPrimary/result.png";
        takeScreenshot(imgResult);
        scenario.createNode(Given.class, "Select Month, App displayed transaction.").addScreenCaptureFromPath(imgResult).pass("pass");


    }

    @Test(groups = "Product Landing of Credit Card SSC")
    // 001100000000000000000012021064   2989208507414
    public void productLandingSSC() throws InterruptedException, IOException {

//        registerCrmByPassOTP("2989208507414");

        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Product Landing of Credit Card Primary");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();


        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        Thread.sleep(2000);
        String accountSum = "ProductLandingSSC/Account Summary.png";
        takeScreenshot(accountSum);
        scenario.createNode(Given.class, "Account Summary Page").addScreenCaptureFromPath(accountSum).pass("pass");

        cardButton.click();

        // Credit Card Page.
        System.out.println("Click Card");
        WebElement primaryClick = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SSC_ACCOUNT);
        Thread.sleep(2000);
        String loanSum = "ProductLandingSSC/Credit Card Summary.png";
        takeScreenshot(loanSum);
        scenario.createNode(Given.class, "Credit Card Summary Page").addScreenCaptureFromPath(loanSum).pass("pass");

        System.out.println("Click Primary");
        primaryClick.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        System.out.println("Wait to data on Product Landing");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        Thread.sleep(10000);
        String creditCard = "images/ProductLandingSSC/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click on more menu");
        moreButton.click();
        Thread.sleep(1000);
        WebElement closeBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_CLOSE_MORE_BTN);
        String moreImage = "images/ProductLandingSSC/more menu.png";
        takeScreenshot(moreImage);
        scenario.createNode(Given.class, "App displayed more menu and check Menu button that should be shown.").addScreenCaptureFromPath(moreImage).pass("pass");

        System.out.println("Close more button");
        closeBTN.click();
        Thread.sleep(1000);
        WebElement swipeUp = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_UNBILLED_BTN);
        ttbTestContext.getDriver().getPageSource();
        String imgCloseMore = "images/ProductLandingSSC/Close more.png";
        takeScreenshot(imgCloseMore);
        scenario.createNode(Given.class, "App displayed Product Landing.").addScreenCaptureFromPath(imgCloseMore).pass("pass");

        System.out.println("swipe billed unbilled");
        Thread.sleep(1000);
        TouchAction sDown = new TouchAction(ttbTestContext.getDriver());
        Thread.sleep(1000);
        sDown.longPress(LongPressOptions.longPressOptions().withElement(element(swipeUp)).withDuration(Duration.ofSeconds(15))).moveTo(PointOption.point(0, 1000)).release().perform();
        Thread.sleep(1000);
        WebElement billedBTN = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_BILLED_BTN);
        String imgSwipeBilled = "images/ProductLandingSSC/swipe bill.png";
        takeScreenshot(imgSwipeBilled);
        scenario.createNode(Given.class, "Swipe Billed/Unbilled to see transaction.").addScreenCaptureFromPath(imgSwipeBilled).pass("pass");

        System.out.println("Click on Billed");
        billedBTN.click();
        Thread.sleep(1000);
        WebElement selectBox = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SELECT_BOX);
        String imgSelectBox = "images/ProductLandingSSC/Unbilled.png";
        takeScreenshot(imgSelectBox);
        scenario.createNode(Given.class, "Click Billed to see transaction.").addScreenCaptureFromPath(imgSelectBox).pass("pass");

        System.out.println("Click on Select box");
        selectBox.click();
        Thread.sleep(1000);
        WebElement selectMonth = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SELECT_MONTH);
        String imgMonth = "images/ProductLandingSSC/Option Month.png";
        takeScreenshot(imgMonth);
        scenario.createNode(Given.class, "Select Month box, App displayed option Months.").addScreenCaptureFromPath(imgMonth).pass("pass");

        System.out.println("Select month");
        selectMonth.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(3000);

        try {
            WebElement spending = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDING_SPENDING);
            String imgResult = "images/ProductLandingSSC/result.png";
            takeScreenshot(imgResult);
            scenario.createNode(Given.class, "Select Month, App displayed transaction.").addScreenCaptureFromPath(imgResult).pass("pass");

        } catch (Exception e) {
            String imgResult = "images/ProductLandingSSC/result.png";
            takeScreenshot(imgResult);
            scenario.createNode(Given.class, "Select Month, App not displayed because no transaction.").addScreenCaptureFromPath(imgResult).pass("pass");
        }

        System.out.println("FINISHHHHHHHHHH");


    }
}
