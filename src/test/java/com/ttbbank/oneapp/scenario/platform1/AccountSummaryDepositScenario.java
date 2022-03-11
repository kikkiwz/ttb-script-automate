package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AccountSummaryDepositScenario extends Platform1Base {

    int countAccountHide = 0;
    int countAccountAll = 1;
    int visibleDepositAccount = 0;
    List<String> expectAccountOrder = new ArrayList<>();
    String depositNumberFormat = "\\d{3}-\\d{1}-\\d{5}-\\d{1}";

    @Test(groups = "Account Summary Deposit Group", priority = 1)
    public void testCustomerLoginToAccountSummaryAndFocusDepositTab() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("2. Customer tab Account summary on footer menu bar");
        context.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT);
        evaluateAssertEqual(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText(), "My Account");
        evaluateAssertEqual(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).getText(), "Deposit");
        createScreenShot("Show Account Summary screen and highlight Deposit on header menu bar", context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).isSelected());
    }

    @Test(groups = "Account Summary Deposit Group", priority = 2)
    public void testCustomerNoHasDepositAccount() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (!isShowProductIntroduction()) return;
        setScenario("3. Customer no has deposit account and click on \"View Product Details\"");
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT);
        boolean isSelectedDeposit = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).isSelected();
        if (!isSelectedDeposit) {
            context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).click();
        }
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText().equals("My Account"), "Show Account Summary screen");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).isSelected(), "Display header menu bar and highlight \"Deposit\" menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_IMAGE).isDisplayed(), "Display Product Introduction Icon");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb deposit account"), "Display Text title to announce that customer not have product yet.");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_CONTENT).getText().equals("A day-to-day savings account to help you save money, with high interest from the first baht you put in."), "Display Text content");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA).getText().equals("View Product Details"), "Display view product details button");
        createScreenShot("Show Product Introduction Screen", true);

        // Click exit icon
        context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA).click();
        context.waitUntilVisible(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW);
        Thread.sleep(3000);
        createScreenShot("Navigate to open deposit account webview", context.findElement(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW).isDisplayed());
        context.findElement(OneAppElementKeys.EXIT_OPEN_DEPOSIT_ACCOUNT_WEB_VIEW).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb deposit account"), "Navigate back to account summary deposit from click exit icon in WebView");

        //Click back icon
        context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA).click();
        context.waitUntilVisible(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_BACK_WEB_VIEW).click();
        Thread.sleep(3000);
        createScreenShot("Navigate back to account summary deposit from click back icon in WebView", context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb deposit account"));
    }

    @Test(groups = "Account Summary Deposit Group", priority = 3)
    public void testCheckAccountDepositHideFromSettings() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (isShowProductIntroduction()) return;
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.MORE_SETTINGS).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        setScenario("4. Customer has deposit account that user set hide");

        if (context.isIos()) {
            Thread.sleep(3000);
            int i = 1;
            while (!context.viewElementByXPATH("(//XCUIElementTypeStaticText[@name=\"Status Account\"])[" + i + "]").isEmpty()) {
                countAccountHide = i;
                i++;
            }

            int j = 1;
            while (!context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[" + j + "]").isEmpty()) {
                countAccountAll = j;
                j++;
            }
            createScreenShot("account order in manage account", true);
            context.findElement(OneAppElementKeys.MANAGE_ACCOUNT_BACK_BUTTON).click();
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        } else {
            context.waitUntilVisible(OneAppElementKeys.MANAGE_ACCOUNT_TITLE);
            Thread.sleep(3000);
            int j = 1;
            while (!context.viewElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + j + "]/android.widget.TextView[1]").isEmpty()) {
                if (context.viewElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + j + "]/android.widget.TextView[3]").isEmpty()) {
                    visibleDepositAccount += 1;
                    String accountName = context.findElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + j + "]/android.widget.TextView[1]").getText();
                    Thread.sleep(1000);
                    expectAccountOrder.add(accountName);
                }
                j++;
            }
            createScreenShot("account order in manage account", true);
            context.back();
            Thread.sleep(1000);
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        }

        context.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();

        if (context.isIos()) {
            Thread.sleep(3000);
            int countAccountDeposit = 0;
            int i = 2;
            while (!context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[" + i + "]").isEmpty()) {
                countAccountDeposit = i - 1;
                i++;

                if (i % 4 == 0) {
                    scrollingToBottom(750, 500);
                }
            }
            evaluateAssertTrueWithImg(countAccountDeposit == (countAccountAll - countAccountHide), "number of showed account is match with manage account");
        } else {
            List<String> actualAccountOrder = new ArrayList<>();
            List<WebElement> depositAccountDisplayingList = context.findElements(OneAppElementKeys.ACCOUNT_DEPOSIT_PRODUCT_TITLE);
            for (int i = 0; i < depositAccountDisplayingList.size(); i++) {
                actualAccountOrder.add(depositAccountDisplayingList.get(i).getText());
            }
            evaluateAssertTrue(depositAccountDisplayingList.size() == expectAccountOrder.size(), "number of showed account is match with manage account");
            evaluateAssertTrueWithImg(actualAccountOrder.equals(expectAccountOrder), "Display deposit account sorting as following order from manage account");
        }
        scrollingToBottom(500, 750);
    }

    @Test(groups = "Account Summary Deposit Group", priority = 4)
    public void testCheckDisplayCorrectDepositDetailInAccountSummary() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (isShowProductIntroduction()) return;
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).click();
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).click();
        if (context.ViewElement(OneAppElementKeys.ACCOUNT_DEPOSIT_SECOND_CARD).isEmpty()) {
            setScenario("5. Customer has deposit 1 account.");
            evaluateAssertTrue(context.ViewElement(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT).isEmpty(), "No display header total available balance");
            evaluateAssertTrue(context.ViewElement(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE).isEmpty(), "No display total available balance");
        } else {
            setScenario("6. Customer has multiple accounts");
            String availableBalance = context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE).getText();
            evaluateAssertTrue(availableBalance.split("\\.")[1].length() == 2, "Show total available balance with \"00,000.00\" (2 decimal)");
            evaluateAssertTrue(!context.ViewElement(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT).isEmpty(), "Display header total available balance");
            evaluateAssertTrue(!context.ViewElement(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE).isEmpty(), "Display total available balance");
        }
        String depositNumber = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER).getText();
        String depositBalance = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE).getText();
        List<WebElement> depositAccountDisplayingList = context.findElements(OneAppElementKeys.ACCOUNT_DEPOSIT_PRODUCT_TITLE);
        for (int i = 0; i < depositAccountDisplayingList.size(); i++) {
            String depositProductTitle = depositAccountDisplayingList.get(i).getText();
            Thread.sleep(1000);
            if (!context.viewElementByXPATH("//android.widget.FrameLayout[@content-desc=\"" + depositProductTitle + "\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.TextView[3]").isEmpty()) {
                String depositStatus = context.findElementByXPATH("//android.widget.FrameLayout[@content-desc=\"" + depositProductTitle + "\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.TextView[3]").getText();
                Thread.sleep(1000);
                evaluateAssertTrue(depositStatus.equals("DORMANT"), "Display account status is Dormant");
            }
        }
        evaluateAssertTrue(Pattern.matches(depositNumberFormat, depositNumber), "Show account number with format \"000-0-00000-0\"");
        evaluateAssertTrue(depositBalance.split("\\.")[1].length() == 2, "Show available balance with \"00,000.00\" (2 decimal)");
        createScreenShot("Display deposit account with following details correctly.", true);
    }

    @Test(groups = "Account Summary Deposit Group", priority = 5)
    public void testAccountSummaryClickToAccountDetailDataShouldMatchWithCardThatClick() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (isShowProductIntroduction()) return;
        setScenario("7. Customer tap on any area in card of deposit account.");
        String depositName = context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD).getText();
        String depositNumber = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER).getText().replaceAll(" ", "");
        String depositBalance = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE).getText();
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER).click();
        Thread.sleep(10000);
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT);
        if (context.isIos()) {
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT).toString().contains("Account Details"), "System navigate to account detail screen");
            Thread.sleep(10000);
            evaluateAssertTrue(context.findElementByAccessibilityId(depositName).isDisplayed(), "Deposit account name is match with account that customer tap on account summary screen.");
            evaluateAssertTrue(context.findElementByAccessibilityId(depositNumber).isDisplayed(), "Deposit account number is match with account that customer tap on account summary screen.");
            evaluateAssertTrue(context.findElementByXPATH("(//XCUIElementTypeStaticText[@name=\"" + depositBalance + "\"])[1]").isDisplayed(), "Balance is match with account that customer tap on account summary screen.");
        } else {
            Thread.sleep(10000);
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT).getText().equals("Account Details"), "System navigate to account detail screen");
            // for case account multiple account but can't use with one account
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD_WEB_VIEW).getText().equals(depositName), "Deposit account name is match with account that customer tap on account summary screen.");
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER_WEB_VIEW).getText().equals(depositNumber), "Deposit account number is match with account that customer tap on account summary screen.");
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_WEB_VIEW).getText().equals(depositBalance), "Balance is match with account that customer tap on account summary screen.");
        }
        createScreenShot("System navigate to account detail screen and focus on deposit account details that customer tap on account summary screen", true);
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_DETAIL_BACK).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE);
        if (context.isAndroid()) {
            List<WebElement> depositAccountDisplayingList = context.findElements(OneAppElementKeys.ACCOUNT_DEPOSIT_PRODUCT_TITLE);
            if (depositAccountDisplayingList.size() > 1) {
                String depositNameSecond = context.findElements(OneAppElementKeys.ACCOUNT_DEPOSIT_PRODUCT_TITLE).get(1).getText();
                String depositNumberSecond = context.findElements(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER).get(1).getText().replaceAll(" ", "");
                String depositBalanceSecond = context.findElements(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE).get(1).getText();
                Boolean isDisplayIcon = context.findElements(OneAppElementKeys.ACCOUNT_DEPOSIT_ICON).get(1).isDisplayed();
                depositAccountDisplayingList.get(1).click();
                Thread.sleep(10000);
                context.waitUntilVisible(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT);
                Thread.sleep(10000);
                evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT).getText().equals("Account Details"), "System navigate to account detail screen");
                // for case account multiple account but can't use with one account
                evaluateAssertTrue(isDisplayIcon, "Display second account deposit icon");
                evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD_SECOND_WEB_VIEW).getText().equals(depositNameSecond), "Deposit account 2nd's name is match with account that customer tap on account summary screen.");
                evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_SECOND_NUMBER_WEB_VIEW).getText().equals(depositNumberSecond), "Deposit account 2nd's number is match with account that customer tap on account summary screen.");
                evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_SECOND_WEB_VIEW).getText().equals(depositBalanceSecond), "Balance is match with second account that customer tap on account summary screen.");
                createScreenShot("System navigate to second account detail screen and focus on deposit account details that customer tap on account summary screen", true);
            }
        }
        context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_DETAIL_BACK).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE);
        boolean isHighlightDepositTab = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).isSelected();
        boolean isDisplayAccountSummaryPage = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).isDisplayed();
        createScreenShot("System navigate back to account summary screen and highlight Deposit on header menu bar.", isDisplayAccountSummaryPage && isHighlightDepositTab);
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD).click();
            context.waitUntilVisible(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT);
            Thread.sleep(5000);
            context.back();
        }
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE);
        if (context.isAndroid()) {
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).isDisplayed(), "System navigate back to account summary scree from back android device");
        }
        createScreenShot("System navigate back by android device to account summary screen and highlight Deposit on header menu bar.", isDisplayAccountSummaryPage && isHighlightDepositTab);
    }

    @Test(groups = "Account Summary Deposit Group", priority = 6)
    public void testCheckAccountDepositIcon() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (isShowProductIntroduction()) return;

        if (context.isIos()) {
            Thread.sleep(3000);
            int i = 2;
            while (!context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[" + i + "]").isEmpty()) {
                Assert.assertTrue(context.findElementByXPATH("(//XCUIElementTypeImage[@name=\"Deposit icon\"])[" + (i - 1) + "]").isDisplayed());
                i++;

                if (i % 4 == 0) {
                    scrollingToBottom(750, 500);
                }
            }
        }
        scrollingToBottom(500, 750);
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void scrollingToBottom(int yOffsetpress, int yOffsetmoveto) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, yOffsetpress)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffsetmoveto)).release().perform();
    }

    public boolean isShowProductIntroduction() {
        return !ttbTestContext.ViewElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).equals(Collections.emptyList());
    }
}