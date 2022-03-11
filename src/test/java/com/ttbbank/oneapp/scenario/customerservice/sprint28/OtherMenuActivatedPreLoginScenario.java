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

public class OtherMenuActivatedPreLoginScenario extends BaseScenario {
    @Test(groups = "Customer Service Other Menu Activated Pre Login", dependsOnGroups = {"Open home screen latest dev","Enter Service Screen Dev Latest"})
    public void OtherMenuActivatedPreLogin() throws InterruptedException, IOException {
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
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login prompt pay");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        String tabOtherService = "images/tabOtherService.png";
        takeScreenshot(tabOtherService);
        scenario.createNode(Given.class, "The system will navigate to tab other service Menu.").addScreenCaptureFromPath(tabOtherService).pass("pass");
        WebElement PROMPT_PAY_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        PROMPT_PAY_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        Thread.sleep(10000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PROMPT_PAY_SERVICE);
        String promptPay = "images/promptPay.png";
        takeScreenshot(promptPay);
        scenario.createNode(Given.class, "The system  will navigate to the prompt pay flow.").addScreenCaptureFromPath(promptPay).pass("pass");
        String context = ttbTestContext.getDriver().getContext();
        System.err.println(context);
        if(ttbTestContext.isIos()){
            TouchAction clickMore = new TouchAction(ttbTestContext.getDriver());
            Thread.sleep(2000);
            clickMore.tap(PointOption.point(28,77)).perform();
            System.err.println("IOS2");
        }else{
            WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_PROMPT_PAY_SERVICE_SCREEN);
            BtnArrowBack.click();
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.NDID_SERVICE_BUTTON);
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
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login NDID");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        String tabOtherService = "images/tabOtherService.png";
        takeScreenshot(tabOtherService);
        scenario.createNode(Given.class, "The system will navigate to tab other service Menu.").addScreenCaptureFromPath(tabOtherService).pass("pass");
        WebElement NDID_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        NDID_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        Thread.sleep(10000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_NOT_REGISTER_NDID);
        String ndid = "images/ndid.png";
        takeScreenshot(ndid);
        scenario.createNode(Given.class, "The system  will navigate to the NDID flow.").addScreenCaptureFromPath(ndid).pass("pass");
        if(ttbTestContext.isIos()){
            TouchAction clickMore = new TouchAction(ttbTestContext.getDriver());
            Thread.sleep(2000);
            clickMore.tap(PointOption.point(28,77)).perform();
        }else{
            WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.BACK_TO_MAIN_MENU_NOT_REGISTER_NDID_SCREEN);
            BtnBackToMainMenu.click();
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
