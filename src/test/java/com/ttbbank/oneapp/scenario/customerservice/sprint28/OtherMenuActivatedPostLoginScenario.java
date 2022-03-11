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

public class OtherMenuActivatedPostLoginScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();

    @Test(groups = "Customer Service Other Menu Activated Post Login", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void OtherMenuActivatedPostLogin() throws InterruptedException, IOException {
        testcase01();
        testcase02();
    }

    public void testcase01() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
//        System.out.println(ttbTestContext.getDriver().getPageSource());
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        if (ttbTestContext.isIos()) {
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
        } else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        WebElement PROMPT_PAY_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        PROMPT_PAY_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PROMPT_PAY_SERVICE);
        System.err.println("url 1 : " + ttbTestContext.getDriver().getCurrentUrl());
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Show Account Detail");
        String accountDetailFileName = "images/test_.png";
        takeScreenshot(accountDetailFileName);
        scenario.createNode(Given.class, "Shows Auto Loan Account Detail Screen").addScreenCaptureFromPath(accountDetailFileName).pass("pass");
        WebElement TitlePromptPay = ttbTestContext.findElement(OneAppElementKeys.TITLE_PROMPT_PAY_SERVICE);
        String elTitlePromptPay = TitlePromptPay.getText();
        System.err.println("elTitlePromptPay : " + elTitlePromptPay);
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_PROMPT_PAY_SERVICE_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();

    }

    public void testcase02() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebDriver contextName = null;
        if (ttbTestContext.isIos()) {
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
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
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        WebElement NDID_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        NDID_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_NOT_REGISTER_NDID);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Show Account Detail2");
        String accountDetailFileName = "images/test_2.png";
        takeScreenshot(accountDetailFileName);
        scenario.createNode(Given.class, "Shows Auto Loan Account Detail Screen2").addScreenCaptureFromPath(accountDetailFileName).fail("pass");
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.BACK_TO_MAIN_MENU_NOT_REGISTER_NDID_SCREEN);
        BtnArrowBack.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        ttbTestContext.setContextToWebView(OneAppElementKeys.MORE_BUTTON, false);
        logOut();
    }
}
