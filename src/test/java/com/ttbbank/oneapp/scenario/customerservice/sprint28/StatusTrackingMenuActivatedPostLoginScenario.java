package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class StatusTrackingMenuActivatedPostLoginScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();

    @Test(groups = "Customer Service Status Tracking Menu Activated Post Login", dependsOnGroups = {"Enter Home Screen Dev Latest", "Enter Service Screen Dev Latest"})
    public void StatusTrackingMenuActivatedPostLogin() throws InterruptedException, IOException {
        testcase01();
        testcase02();
    }

    public void testcase01() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isIos()) {
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
        } else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login case tracking");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "After login for access application, The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_STATUS_TRACKING = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TAB_STATUS_TRACKING.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        String tabStatusTracking = "images/tabStatusTracking.png";
        takeScreenshot(tabStatusTracking);
        scenario.createNode(Given.class, "The system will navigate to tab status tracking Menu.").addScreenCaptureFromPath(tabStatusTracking).pass("pass");
        WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        STATUS_TRACKING_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_NO_LIST_SCREEN);
        String CST = "images/CST.png";
        takeScreenshot(CST);
        scenario.createNode(Given.class, "After click case tracking button menu, The system  will navigate to the case tracking flow.").addScreenCaptureFromPath(CST).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_NO_LIST_SCREEN_CASE_TRACKING);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebDriver contextName = null;
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login application tracking");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After account summary, the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
        if (ttbTestContext.isIos()) {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        } else {
            contextName = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = contextName.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_STATUS_TRACKING = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TAB_STATUS_TRACKING.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        String tabStatusTracking = "images/tabStatusTracking.png";
        takeScreenshot(tabStatusTracking);
        scenario.createNode(Given.class, "The system will navigate to tab status tracking Menu.").addScreenCaptureFromPath(tabStatusTracking).pass("pass");
        WebElement APPLICATION_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_SERVICE_BUTTON);
        APPLICATION_TRACKING_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_HEADER_APP_TRACKING_LIST_SCREEN);
        String ast = "images/ast.png";
        takeScreenshot(ast);
        scenario.createNode(Given.class, "The system will navigate to the application tracking flow.").addScreenCaptureFromPath(ast).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_NO_LIST_SCREEN_APP_TRACKING);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        getExtent().flush();

    }
}
