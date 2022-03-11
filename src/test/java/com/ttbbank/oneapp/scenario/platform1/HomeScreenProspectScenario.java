package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;

public class HomeScreenProspectScenario extends BaseScenario {

    @Test(groups = "HomeScreen Prospect Group", priority = 1)
    public void testHomeScreenProspectClickTransferlQuickAction() {
        checkElementBottomSheetRegister(OneAppElementKeys.TRANSFER_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 2)
    public void testHomeScreenProspectClickPayBillQuickAction() {
        checkElementBottomSheetRegister(OneAppElementKeys.PAY_BILL_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 3)
    public void testHomeScreenProspectClickWithDrawQuickAction() {
        checkElementBottomSheetRegister(OneAppElementKeys.WITH_DRAW_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 4)
    public void testHomeScreenProspectClickScanQRQuickAction() {
        checkElementBottomSheetRegister(OneAppElementKeys.SCAN_QR_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 5)
    public void testHomeScreenProspectClickTopUpQuickAction() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        checkElementBottomSheetRegister(OneAppElementKeys.TOP_UP_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 6)
    public void testHomeScreenProspectClickApplyQuickAction() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.APPLY_BUTTON).click();
        checkElementApplyTabInServiceScreen();
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 7)
    public void testHomeScreenProspectClickInvestmentQuickAction() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        checkElementBottomSheetRegister(OneAppElementKeys.INVESTMENT_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 8)
    public void testHomeScreenProspectClickInsuranceQuickAction() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        checkElementBottomSheetRegister(OneAppElementKeys.INSURANCE_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 9)
    public void testHomeScreenProspectClickQuickBalance() {
        checkElementBottomSheetRegister(OneAppElementKeys.QUICK_BALANCE_WIDGET);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 10)
    public void testHomeScreenProspectClickQuickBenefit() {
        checkElementBottomSheetRegister(OneAppElementKeys.QUICK_BENEFIT_WIDGET);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 11)
    public void testHomeScreenProspectClickApplicationTracking() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            androidScrollToBottom();
        }
        if (ttbTestContext.isIos()) {
            scrollFindElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET);
        }
        ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET).click();
        ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_START_BUTTON).click();
        String applicationTrackTitleText = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_TITLE).getText();
        Assert.assertTrue(applicationTrackTitleText.contains("Please Fill in Information"));
        ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_BACK_BUTTON).click();
        String applicationTrackText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(applicationTrackText.contains("QUICK BALANCE"));
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 12)
    public void testHomeScreenProspectClickAllTTBProducts() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            androidScrollToBottom();
        }
        if (ttbTestContext.isIos()) {
            scrollFindElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET);
        }

        ttbTestContext.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET).click();
        checkElementApplyTabInServiceScreen();
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 13)
    public void testHomeScreenProspectClickHighlightCampaign() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            androidScrollToBottom();
        }
        if (ttbTestContext.isIos()) {
            scrollFindElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET);
        }
        checkElementBottomSheetRegister(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 14)
    public void testHomeScreenProspectClickManageHomepage() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            androidScrollToBottom();
        }
        if (ttbTestContext.isIos()) {
            scrollFindElement("Manage Homepage");
            ttbTestContext.findElement(OneAppElementKeys.MANAGE_HOMEPAGE_BUTTON).click();
        }
        checkElementBottomSheetRegister(OneAppElementKeys.MANAGE_HOMEPAGE_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 15)
    public void testHomeScreenNoInternetConnectionQuickAction() throws InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
            enableDataNetWorkAndroid(false);
            Thread.sleep(5000);
            Assert.assertNotEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.TRANSFER_BUTTON);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.PAY_BILL_BUTTON);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.WITH_DRAW_BUTTON);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.SCAN_QR_BUTTON);

            enableDataNetWorkAndroid(true);
            Thread.sleep(5000);
            Assert.assertEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
        }
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 19)
    public void testHomeScreenNoInternetConnectionQuickActionExpand() throws InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
            enableDataNetWorkAndroid(false);
            Thread.sleep(5000);
            Assert.assertNotEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.TOP_UP_BUTTON);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.INVESTMENT_BUTTON);
            checkElementBottomSheetRegisterNoInternet(OneAppElementKeys.INSURANCE_BUTTON);
            enableDataNetWorkAndroid(true);
            Thread.sleep(5000);
            Assert.assertEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
        }
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 20)
    public void testHomeScreenClickAvatarButton() {
        checkElementBottomSheetRegister(OneAppElementKeys.AVATAR_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 21)
    public void testHomeScreenClickInboxNotificationButton() {
        checkElementBottomSheetRegister(OneAppElementKeys.INBOX_NOTIFICATION_BUTTON);
    }

    @Test(groups = "HomeScreen Prospect Group", priority = 22)
    public void testHomeScreenClickPersonalizeRegisterButton() {
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PERSONALIZE_REGISTER_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PERSONALIZE_REGISTER_BUTTON).click();
        String tncTitleText = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText();
        Assert.assertTrue(tncTitleText.contains("Terms and Conditions"));
        ttbTestContext.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON).click();
        Boolean transferButton = ttbTestContext.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed();
        Assert.assertTrue(transferButton);
    }

    public void checkElementApplyTabInServiceScreen() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        Boolean depositButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_DEPOSIT_BUTTON).isDisplayed();
        Boolean cardButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_CARD_BUTTON).isDisplayed();
        Boolean investmentButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_INVESTMENT_BUTTON).isDisplayed();
        Boolean personalButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_PERSONAL_LOAN_BUTTON).isDisplayed();
        Boolean autoButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_AUTO_LOAN_BUTTON).isDisplayed();
        Boolean insuranceButtonText = ttbTestContext.findElement(OneAppElementKeys.SERVICE_APPLY_INSURANCE_BUTTON).isDisplayed();
        Assert.assertTrue(depositButtonText);
        Assert.assertTrue(cardButtonText);
        Assert.assertTrue(investmentButtonText);
        Assert.assertTrue(personalButtonText);
        Assert.assertTrue(autoButtonText);
        Assert.assertTrue(insuranceButtonText);
    }

    public void checkElementBottomSheetRegister(String item) {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(item).click();

        String registerTitleText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE_REGISTER).getText();
        Assert.assertTrue(registerTitleText.contains("Only available for ttb touch customer"));
        String registerDescriptionText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_REGISTER).getText();
        Assert.assertTrue(registerDescriptionText.contains("Please register application to use this function or service"));
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).getText();
        Assert.assertTrue(registerButtonText.contains("Register ttb touch"));
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();

        if (ttbTestContext.isIos()) {
            ttbTestContext.findElement(item).click();
            swipeDown(item);
            String transferButtonText = ttbTestContext.findElement(OneAppElementKeys.TRANSFER_BUTTON).getText();
            Assert.assertTrue(transferButtonText.contains("Transfer"));
            String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
            Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
            String quickBalanceDescText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_DESCRIPTION).getText();
            Assert.assertTrue(quickBalanceDescText.contains("Enable this function to check your balance instantly"));
        }

        ttbTestContext.findElement(item).click();
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        String tncTitleText = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText();
        Assert.assertTrue(tncTitleText.contains("Terms and Conditions"));
        ttbTestContext.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON).click();
        Boolean transferButton = ttbTestContext.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed();
        Assert.assertTrue(transferButton);
    }

    public void checkElementBottomSheetRegisterNoInternet(String item) throws InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ttbTestContext.findElement(item).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        String bottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText();
        String bottomSheetDesc = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        Assert.assertEquals(bottomSheetTitle, "No internet connection found");
        Assert.assertEquals(bottomSheetDesc, "Please check your connection and try again.");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
    }

    public void scrollFindElement(String accessibilityId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + accessibilityId + "'");
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void swipeDown(String accessibilityId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + accessibilityId + "'");
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);
    }

    public void androidScrollToBottom() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.QUICK_BENEFIT_WIDGET);
        scrollToBottom();
    }

}
