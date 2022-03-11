package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplyMenuActivatedPreLoginScenario extends BaseScenario {
    @Test(groups = "Customer Service Apply Menu Activated Pre Login", dependsOnGroups = {"Activate new flow","Enter Service Screen Dev Latest"})
    public void ApplyMenuActivatedPreLogin() throws InterruptedException, IOException {
        testcase01();
        testcase02();
    }

    public void testcase01() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
//        if(ttbTestContext.isIos()){
//            //iOS DEFECT, have to click apply and come back then we can click passbook item.
//            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.APPLY_SERVICE_PAGE_BUTTON);
//            applyServicePageButton.click();
//            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_APPLY_SERVICE_PAGE_BUTTON);
//            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
//            documentServicePageButton.click();
//        }
//        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login case tracking");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        String tabStatusTracking = "images/tabStatusTracking.png";
        takeScreenshot(tabStatusTracking);
        scenario.createNode(Given.class, "The system will navigate to tab apply Menu.").addScreenCaptureFromPath(tabStatusTracking).pass("pass");
        WebElement CARD_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.CARD_SERVICE_BUTTON);
        CARD_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click card button menu, the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_CARD);
        String Card = "images/Card.png";
        takeScreenshot(Card);
        scenario.createNode(Given.class, "After click card button menu, The system  will navigate to card flow.").addScreenCaptureFromPath(Card).pass("pass");
        if(ttbTestContext.isIos()){
            TouchAction clickMore = new TouchAction(ttbTestContext.getDriver());
            Thread.sleep(2000);
            clickMore.tap(PointOption.point(28,77)).perform();
            System.err.println("IOS2");
        }else{
            WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_CARD_SCREEN);
            BtnArrowBack.click();
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
//        if(ttbTestContext.isIos()){
//            //iOS DEFECT, have to click apply and come back then we can click passbook item.
//            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.APPLY_SERVICE_PAGE_BUTTON);
//            applyServicePageButton.click();
//            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_APPLY_SERVICE_PAGE_BUTTON);
//            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
//            documentServicePageButton.click();
//        }
//        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login application tracking");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_STATUS_TRACKING = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TAB_STATUS_TRACKING.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        String tabStatusTracking = "images/tabApply.png";
        takeScreenshot(tabStatusTracking);
        scenario.createNode(Given.class, "The system will navigate to tab apply Menu.").addScreenCaptureFromPath(tabStatusTracking).pass("pass");
        WebElement APPLICATION_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_SERVICE_BUTTON);
        APPLICATION_TRACKING_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click personal loan, the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_HEADER_APP_TRACKING_LIST_SCREEN);
        String ast = "images/ast.png";
        takeScreenshot(ast);
        scenario.createNode(Given.class, "The system  will navigate to the application tracking flow.").addScreenCaptureFromPath(ast).pass("pass");
        if(ttbTestContext.isIos()){
            TouchAction clickMore = new TouchAction(ttbTestContext.getDriver());
            Thread.sleep(2000);
            clickMore.tap(PointOption.point(28,77)).perform();
        }else{
            WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_NO_LIST_SCREEN_APP_TRACKING);
            BtnArrowBack.click();
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
        getExtent().flush();

    }
}
