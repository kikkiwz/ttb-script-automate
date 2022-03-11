package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class MoreDiscoverToSettingScenario extends BaseScenario {
    @Test(groups = "Setting list Group", priority = 1)
    public void testNavigateFromMoreDiscoverToSettingListScreen() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPinLogin("070809");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
    }

    @Test(groups = "Setting list Group", priority = 2)
    public void testSettingListScreenSearchInput() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.SETTING_SEARCH_INPUT);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(), "Search");
    }

    @Test(groups = "Setting list Group", priority = 3)
    public void testSettingListScreenPersonalInformation() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.SETTING_PROFILE_IMAGE);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_PROFILE_IMAGE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_PROFILE_NAME).isDisplayed());
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).getText(), "Mobile No.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).getText(), "Email");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_CURRENT_ADDRESS_MENU).getText(), "Current Address");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).getText(), "International Transfer Address");

        String phoneNumber = context.findElement(OneAppElementKeys.SETTING_MOBILE_NO).getText();
        if (phoneNumber.contains("-")) {
            Assert.assertEquals(StringUtils.countMatches(phoneNumber, "-"), 2);
        } else {
            Assert.assertEquals(phoneNumber, "Add mobile no.");
        }

        String email = context.findElement(OneAppElementKeys.SETTING_EMAIL_DETAIL).getText();
        if (email.contains("@")) {
            String verify = context.findElement(OneAppElementKeys.SETTING_EMAIL_VERIFY_STATUS).getText();
            if (verify.contains("Not")) {
                Assert.assertEquals(verify, "Not verified");
            } else {
                Assert.assertEquals(verify, "Verified");
            }
        } else {
            Assert.assertTrue(email.contains("Add email"));
        }
    }

    @Test(groups = "Setting list Group", priority = 5)
    public void testSettingScreenDisplayMenuManageAccountCorrectly() {
        TtbTestContext context = getTtbTestContext();
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_SECURITY_SECTION);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_ACCOUNT_AND_CARD_SECTION).getText(), "Account and Card");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).getText(), "Manage Account");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).getText(), "Daily Transaction Limit");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).getText(), "PIN-Free Transaction Limit");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PAY_WITH_WOW_MENU).getText(), "Pay with wow");
    }

    @Test(groups = "Setting list Group", priority = 6)
    public void testSettingScreenOnPinFreeCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String pinFreeFlag = context.findElement(OneAppElementKeys.SETTING_PIN_FREE_FLAG).getText();

        if (pinFreeFlag.equals("On")) {
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_NOT_ALLOW_RADIO).click();
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_SAVE_BUTTON).click();
            if (context.isAndroid()) {
                pressPinVerify("070809");
            } else {
                pressPinLogin("070809");
                Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_HOME_BUTTON).getText(), "Back to Home");
            }
            context.waitUntilVisible(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON);
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON).click();
            if (context.isAndroid()) {
                context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_ARROW_BUTTON).click();
            }
            Assert.assertEquals("Off", context.findElement(OneAppElementKeys.SETTING_PIN_FREE_FLAG).getText());
        }
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_ALLOW_RADIO).click();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_SAVE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON).click();
        if (context.isAndroid()) {
            pressPinVerify("070809");
        } else {
            pressPinLogin("070809");
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_HOME_BUTTON).getText(), "Back to Home");
        }
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_ARROW_BUTTON).click();
        }
        context.waitUntilVisible(OneAppElementKeys.SETTING_PIN_FREE_FLAG);
        Assert.assertEquals("On", context.findElement(OneAppElementKeys.SETTING_PIN_FREE_FLAG).getText());
    }

    @Test(groups = "Setting list Group", priority = 7)
    public void testSettingScreenOffPinFreeCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_NOT_ALLOW_RADIO).click();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_SAVE_BUTTON).click();
        if (context.isAndroid()) {
            pressPinVerify("070809");
        } else {
            pressPinLogin("070809");
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_HOME_BUTTON).getText(), "Back to Home");
        }
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_ARROW_BUTTON).click();
        }
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_FLAG).getText(), "Off");
    }

    @Test(groups = "Setting list Group", priority = 8)
    public void testSettingScreenDisplayChangePinCorrectly() {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_SECURITY_SECTION).getText();
        Assert.assertEquals(applicationSection, "Security");
        String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).getText();
        Assert.assertEquals(favoritesMenu, "Change PIN");
    }

    @Test(groups = "Setting list Group", priority = 9)
    public void testSettingScreenDisplayBiometricCorrectly() {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_SECURITY_SECTION).getText();
        Assert.assertEquals(applicationSection, "Security");
        String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_BIOMETRIC_MENU).getText();
        Assert.assertEquals(favoritesMenu, "Log-in with Biometric");
    }

    //     @Test(groups = "Setting list Group", priority = 10)
    public void testSettingOnBiometric() {
        TtbTestContext context = getTtbTestContext();

        boolean bioFlag = Boolean.parseBoolean(context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).getAttribute("checked"));
        if (bioFlag) {
            context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).click();
            Assert.assertFalse(Boolean.parseBoolean(context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).getAttribute("checked")));
        }
        context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).click();
        Assert.assertTrue(Boolean.parseBoolean(context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).getAttribute("checked")));
    }

    //     @Test(groups = "Setting list Group", priority = 11)
    public void testSettingOffBiometric() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).click();
        Assert.assertFalse(Boolean.parseBoolean(context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).getAttribute("checked")));
    }

    @Test(groups = "Setting list Group", priority = 12)
    public void testSettingScreenDisplayMenuFavoritesCorrectly() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);

            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            context.back();
            context.waitUntilVisible(OneAppElementKeys.SETTING_CHANGE_PIN_MENU);
        } else {
            scrollingToBottom(750, 0);
        }

        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals(applicationSection, "Application");
        String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_FAVORITES_MENU).getText();
        Assert.assertEquals(favoritesMenu, "Favorites");
    }

    @Test(groups = "Setting list Group", priority = 13)
    public void testSettingScreenDisplayMenuManageHomepageCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals(applicationSection, "Application");
        Thread.sleep(2000);
        String manageHomepageMenu = context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).getText();
        Assert.assertEquals(manageHomepageMenu, "Manage Homepage");
    }

    @Test(groups = "Setting list Group", priority = 14)
    public void testSettingScreenDisplayMenuNotificationsCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals(applicationSection, "Application");
        Thread.sleep(2000);
        String notificationsMenu = context.findElement(OneAppElementKeys.SETTING_NOTIFICATIONS_MENU).getText();
        Assert.assertEquals(notificationsMenu, "Notifications");
    }

    @Test(groups = "Setting list Group", priority = 15)
    public void testSettingScreenDisplayMenuQuickBalanceTurnOff() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals(applicationSection, "Application");
        Thread.sleep(2000);
        if (context.isIos()) {
            String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText();
            Assert.assertTrue(favoritesMenu.contains("Quick Balance"));
        }
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText(), "Quick Balance");
        }
        Thread.sleep(2000);
        String quickBalanceFlag = context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText();

        if (quickBalanceFlag.equals("On")) {
            context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_ENABLE);
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
            context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        }
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
    }

    @Test(groups = "Setting list Group", priority = 16)
    public void testSettingScreenDisplayMenuQuickBalanceTurnOn() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals("Application", applicationSection);
        Thread.sleep(2000);
        if (context.isIos()) {
            String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText();
            Assert.assertTrue(favoritesMenu.contains("Quick Balance"));
        }
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText(), "Quick Balance");
        }
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_ENABLE);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(2000);
        String quickBalanceOn = context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText();
        Assert.assertEquals(quickBalanceOn, "On");
    }

    @Test(groups = "Setting list Group", priority = 17)
    public void testSettingScreenDisplayMenuAutoSaveSlipCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals("Application", applicationSection);
        Thread.sleep(2000);
        String autoSaveSlipMenu = context.findElement(OneAppElementKeys.SETTING_AUTO_SAVE_SLIP_MENU).getText();
        Assert.assertEquals("Auto Save E-Slip", autoSaveSlipMenu);
    }

    @Test(groups = "Setting list Group", priority = 18)
    public void testSettingScreenDisplayMenuLanguageInThaiCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String applicationSection = context.findElement(OneAppElementKeys.SETTING_APPLICATION_SECTION).getText();
        Assert.assertEquals("Application", applicationSection);
        Thread.sleep(2000);
        scrollingToBottom(915, 0);
        String favoritesMenu = context.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_MENU).getText();
        Assert.assertEquals(favoritesMenu, "Language");
        context.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_MENU).click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_THAI_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON).click();
        Thread.sleep(2000);
        String langTH = context.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_VALUE).getText();
        Assert.assertTrue(langTH.contains("ไทย"));
    }

    @Test(groups = "Setting list Group", priority = 19)
    public void testSettingScreenDisplayMenuLanguageInEnglishCorrectly() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_THAI_MENU).click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_ENG_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON).click();
        Thread.sleep(2000);
        String langEN = context.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_VALUE).getText();
        Assert.assertTrue(langEN.contains("English"));
        Thread.sleep(3000);
    }

    @Test(groups = "Setting list Group", priority = 20)
    public void testUserPressLogoutButton() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        scrollingToBottom(915, 0);
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
    }

    @Test(groups = "Setting list Group", priority = 21)
    public void testUserNotAlreadyLoginThenPressSettingsBtnShouldShowBottomSheetLogin() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON).click();
    }

    @Test(groups = "Setting list Group", priority = 22)
    public void testUserLoginToSettingsPage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPinLogin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
    }

    @Test(groups = "Setting list Group", priority = 23)
    public void testUserAlreadyLoginThenPressSettingsBtnShouldGoToSettingsPage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
    }

    @Test(groups = "Setting list Group", priority = 24)
    public void testPressAndroidDeviceInSettingsPageShouldGoBackToMorePage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            Thread.sleep(2000);
            context.back();
            Thread.sleep(2000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText(), "Discover More");
        }
    }


    public void pressPinLogin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void pressPinVerify(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_CONFIRM_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void scrollingToBottom(int yOffsetpress, int yOffsetmoveto) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, yOffsetpress)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffsetmoveto)).release().perform();
    }

}
