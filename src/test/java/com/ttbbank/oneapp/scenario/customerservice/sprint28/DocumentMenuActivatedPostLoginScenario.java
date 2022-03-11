package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class DocumentMenuActivatedPostLoginScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();
    @Test(groups = "Customer Service Document Menu Activated Post Login", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void DocumentMenuActivatedPostLogin() throws InterruptedException, IOException {
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
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login Virtual Passbook");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_DOCUMENTS = ttbTestContext.findElement(OneAppElementKeys.TAB_DOCUMENTS);
        TAB_DOCUMENTS.click();
        WebElement PASSBOOK_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        PASSBOOK_SERVICE_BUTTON.click();
        try{
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elTitleTutorial = titleTutorial.getText();
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.TUTORIAL_DETAIL_SCREEN_VIRTUAL_PASSBOOK);
            String elTutorialDetail = tutorialDetail.getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elBtnStart = btnStart.getText();

            System.out.println("elTitleTutorial : " + elTitleTutorial);
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            System.out.println("elBtnStart : " + elBtnStart);
            Thread.sleep(5000);
            String tutorial = "images/VirtualPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "Tutorial Passbook Screen").addScreenCaptureFromPath(tutorial).pass("Pass");
            btnStart.click();
        }catch (Exception e){
            String tutorial = "images/VirtualPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to select the account screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1_PASSBOOK);
        String Passbook = "images/Passbook.png";
        takeScreenshot(Passbook);
        scenario.createNode(Given.class, "The system will navigate to the passbook flow.").addScreenCaptureFromPath(Passbook).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_SELECT_ACC_PASSBOOK_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        Thread.sleep(5000);
        ttbTestContext.tapCenter();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if(ttbTestContext.isIos()){
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        }else{
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login Statement");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement STATEMENT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        System.err.println("STATEMENT_SERVICE_BUTTON : " + STATEMENT_SERVICE_BUTTON.getText());
        STATEMENT_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#LabelText_deposit_0")));
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1);
        WebElement ACCOUNT_NAME_1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1);
        String account1 = ACCOUNT_NAME_1.getText();
        System.err.println("account1 : " + account1);
        String Statement = "images/Statement.png";
        takeScreenshot(Statement);
        scenario.createNode(Given.class, "The system  will navigate to the statement flow.").addScreenCaptureFromPath(Statement).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SELECT_ACC_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut2.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }

    public void testcase03() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if(ttbTestContext.isIos()){
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true, currentContext));
        }else{
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login Financial certificate");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement FINANCIAL_CERTIFICATE_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        FINANCIAL_CERTIFICATE_SERVICE_BUTTON.click();
        try {
            String TitleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE).getText();
            String DetailTutorial = ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_STATEMENT_FINANCIAL_CERTIFICATE).getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
            String elBtnStart = btnStart.getText();
            System.out.println("TitleTutorial : " + TitleTutorial);
            System.out.println("DetailTutorial : " + DetailTutorial);
            System.out.println("elBtnStart : " + elBtnStart);
            btnStart.click();
        } catch (Exception e) { }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_DETAIL_BULLET_3);
        String Financial = "images/Financial.png";
        takeScreenshot(Financial);
        scenario.createNode(Given.class, "The system  will navigate to the financial certificate flow.").addScreenCaptureFromPath(Financial).pass("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SERVICE_DETAIL_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        String LogOut = "images/LogOut3.png";
        takeScreenshot(LogOut);
        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        String pin = "images/pin.png";
        takeScreenshot(pin);
        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase04() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if(ttbTestContext.isIos()){
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON, true, currentContext));
        }else{
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
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
//        (new WebDriverWait(ttbTestContext.getDriver(), 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON)));
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login NCB Report");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement NCB_REPORT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
        NCB_REPORT_SERVICE_BUTTON.click();
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
        ttbTestContext.waitUntilVisible(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
//        logOut();
//        String LogOut = "images/LogOut4.png";
//        takeScreenshot(LogOut);
//        scenario.createNode(Given.class, "Log out").addScreenCaptureFromPath(LogOut).pass("pass");
//        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
//        accountButton.click();
//        String pin = "images/pin.png";
//        takeScreenshot(pin);
//        scenario.createNode(Given.class, "After click account summary the system display access pin screen").addScreenCaptureFromPath(pin).pass("pass");
//        enterPin();
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
//        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
//        serviceButton.click();
        getExtent().flush();

    }
}
