package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class DocumentMenuActivatedPreLoginScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();

    @Test(groups = "Customer Service Document Menu Activated Pre Login", dependsOnGroups = { "Enter Service Screen Dev Latest"})
    public void DocumentMenuActivatedPreLogin() throws InterruptedException, IOException {
        testcase01();
        testcase02();
        testcase03();
        testcase04();
    }

    public void testcase01() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login Virtual Passbook");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
        WebElement TAB_DOCUMENTS = ttbTestContext.findElement(OneAppElementKeys.TAB_DOCUMENTS);
        TAB_DOCUMENTS.click();
        WebElement PASSBOOK_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        PASSBOOK_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        enterPin();
        if(ttbTestContext.isIos()){
            ttbTestContext.getDriver().context(currentContext.get(1));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1_PASSBOOK);
        String Passbook = "images/Passbook.png";
        takeScreenshot(Passbook);
        scenario.createNode(Given.class, "The system  will navigate to the passbook flow.").addScreenCaptureFromPath(Passbook).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_SELECT_ACC_PASSBOOK_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login Statement");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement STATEMENT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        STATEMENT_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        enterPin();
        if(ttbTestContext.isIos()){
            ttbTestContext.getDriver().context(currentContext.get(2));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1);
        String Statement = "images/Statement.png";
        takeScreenshot(Statement);
        scenario.createNode(Given.class, "The system  will navigate to the statement flow.").addScreenCaptureFromPath(Statement).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SELECT_ACC_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase03() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true, currentContext));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login Financial certificate");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement FINANCIAL_CERTIFICATE_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        FINANCIAL_CERTIFICATE_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        enterPin();
        if(ttbTestContext.isIos()){
            ttbTestContext.getDriver().context(currentContext.get(3));
        }else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_DETAIL_BULLET_3);
        String Financial = "images/Financial.png";
        takeScreenshot(Financial);
        scenario.createNode(Given.class, "The system  will navigate to the financial certificate flow.").addScreenCaptureFromPath(Financial).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SERVICE_DETAIL_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase04() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true, currentContext));
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Pre Login NCB");
        String ServiceMenu = "images/Service Menu.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement NCB_REPORT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
        NCB_REPORT_SERVICE_BUTTON.click();
        Thread.sleep(1000);
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        enterPin();
        if(ttbTestContext.isIos()){
            ttbTestContext.getDriver().context(currentContext.get(4));
        }else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB);
        System.err.println("" + ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_NCB).getText());
        System.err.println("" + ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_NCB).getText());
        System.err.println("" + ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB).getText());
        WebElement START_BUTTON_TUTORIAL_SCREEN_NCB = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB);
        START_BUTTON_TUTORIAL_SCREEN_NCB.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_BY_EMAIL);
        String NCB = "images/NCB.png";
        takeScreenshot(NCB);
        scenario.createNode(Given.class, "The system  will navigate to the NCB flow.").addScreenCaptureFromPath(NCB).pass("pass");
        System.err.println("" + ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_1_NCB).getText());
        System.err.println("" + ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_2_NCB).getText());
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_PROCESS_1_NCB);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        getExtent().flush();

    }
}
