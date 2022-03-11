package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class ApplyMenuActivatedPostLoginScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();

    @Test(groups = "Customer Service Apply Menu Activated Post Login", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void ApplyMenuActivatedPostLogin() throws InterruptedException, IOException {
//        testcase01();
        testcase03();
        testcase02();
        testcase04();
        testcase05();
        testcase01();
    }

    public void testcase01() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if (ttbTestContext.isIos()) {
//            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        } else {
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login case tracking");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        WebElement DEPOSIT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
        DEPOSIT_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"titleID\")]")));
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
//        WebElement TitleDepositPage1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_DEPOSIT_PROSPECT);
//        String elTitleDepositPage1 = TitleDepositPage1.getText();
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
//        logOut();
//        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
//        accountButton.click();
//        enterPin();
////        Thread.sleep(5000);
////        ttbTestContext.tapCenter();
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
//        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
//        serviceButton.click();

    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        Thread.sleep(5000);
        WebDriver context = null;
        if (ttbTestContext.isIos()) {
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        } else {
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();

            System.out.println("webNames" + webNames.toString());
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    System.err.println("hhhh = " + ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON).getText());
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
//        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login case tracking");
//        String ServiceMenu = "images/AfterLogin.png";
//        takeScreenshot(ServiceMenu);
//        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        System.err.println("TAB_APPLY = " + TAB_APPLY.getText());
        System.err.println("TAB_APPLY = " + ttbTestContext.getDriver().getPageSource());
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        WebElement CARD_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.CARD_SERVICE_BUTTON);
        CARD_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"titleID\")]")));
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        Assert.assertTrue(url.equals("https://oneapp-vit1.tau2904.com/product-list/credit-card"));
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_CARD_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase03() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if (ttbTestContext.isIos()) {
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        } else {
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            System.out.println("webNames" + webNames.toString());
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login application tracking");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        WebElement INVESTMENT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.INVESTMENT_SERVICE_BUTTON);
        INVESTMENT_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"investment-navbar-introduction-port-title\")]")));
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        Assert.assertTrue(url.equals("https://oneapp-vit1.tau2904.com/investment/port-introduction?referrer=cs"));
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_INVESTMENT_APPLY_MENU);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        ttbTestContext.getDriver().context("NATIVE_APP");
        logOut();
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        Thread.sleep(5000);
        ttbTestContext.tapCenter();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }

    public void testcase04() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if (ttbTestContext.isIos()) {
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        } else {
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
//        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login application tracking");
//        String ServiceMenu = "images/AfterLogin.png";
//        takeScreenshot(ServiceMenu);
//        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        WebElement PERSONAL_LOAN_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PERSONAL_LOAN_SERVICE_BUTTON);
        PERSONAL_LOAN_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"titleID\")]")));
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PERSONAL_LOAN);
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        Assert.assertTrue(url.equals("https://oneapp-vit1.tau2904.com/product-list/loan"));
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_PERSONAL_LOAN_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        ttbTestContext.getDriver().context("NATIVE_APP");
        logOut();
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }

    public void testcase05() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        WebDriver context = null;
        if (ttbTestContext.isIos()) {
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true, currentContext));
        } else {
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Activate Post Login application tracking");
        String ServiceMenu = "images/AfterLogin.png";
        takeScreenshot(ServiceMenu);
        scenario.createNode(Given.class, "The system  will navigate to Service Menu.").addScreenCaptureFromPath(ServiceMenu).pass("pass");
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        WebElement AUTO_LOAN_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_BUTTON);
        AUTO_LOAN_SERVICE_BUTTON.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cs_apply_autoloan_navigation_header_id\")]")));
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        Assert.assertTrue(url.equals("https://oneapp-vit1.tau2904.com/customerservice/autoloan/apply-auto-loan"));
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_AUTO_LOAN_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_SERVICE_BUTTON);
        ttbTestContext.getDriver().context("NATIVE_APP");
        logOut();
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
    }
}
