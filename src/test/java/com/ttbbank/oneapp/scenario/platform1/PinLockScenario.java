package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class PinLockScenario extends BaseScenario {

    @Test(groups = "PinLock Group", priority = 1)
    public void testPinLockOnLoginModuleInAccountSummary() {
        TtbTestContext context = getTtbTestContext();
        skipPersonalizeIntro();
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        if (context.isAndroid()) {
            context.back();
            context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressIncorrectPin123456();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        pressIncorrectPin555555();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");

        //press incorrect pin third times
        pressIncorrectPin555555();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        testBackDeviceInAndroidOnPinLockScreen();
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    @Ignore
    @Test(groups = "PinLock Group", priority = 2)
    public void testPinLockOnEnterCurrentPINModuleInChangePinMenu() {
        TtbTestContext context = getTtbTestContext();
        goToChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        pressIncorrectPin888888inChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");

        //press incorrect pin third times
        pressIncorrectPin888888inChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    @Ignore
    @Test(groups = "PinLock Group", priority = 3)
    public void testPinLockOnEnterCurrentPINInQuickActionHomeScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_BUTTON).click();
        pressCorrectPin010203();
        context.findElement(OneAppElementKeys.TOP_UP_AIS_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS).click();
        context.findElement(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS).sendKeys("0937052488");
        context.findElement(OneAppElementKeys.TOP_UP_10_AMOUNT_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_NEXT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON);
        context.findElement(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON).click();

        if (context.isIos()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
            pressIncorrectPin123456();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
            pressIncorrectPin555555();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");
        } else {
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
            pressIncorrectPinInConfirmScreen();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
            pressIncorrectPinInConfirmScreen111222();
        }

        pressIncorrectPin555555();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    @Test(groups = "PinLock Group", priority = 4)
    public void testPinLockOnEnterCurrentPINInChangePinAndIncorrectFromQuickActionHomeScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_BUTTON).click();
        pressCorrectPin010203();
        context.findElement(OneAppElementKeys.TOP_UP_AIS_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS).click();
        context.findElement(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS).sendKeys("0937052488");
        context.findElement(OneAppElementKeys.TOP_UP_10_AMOUNT_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_NEXT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON);
        context.findElement(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        if (context.isIos()) {
            pressIncorrectPin123456();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
            pressIncorrectPin555555();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");
        } else {
            pressIncorrectPinInConfirmScreen();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
            pressIncorrectPinInConfirmScreen111222();
        }

        context.findElement(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON).click();
        context.findElement(OneAppElementKeys.TOP_UP_CONFIRM_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.TOP_UP_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SELECT_TOP_UP_BACK_BUTTON).click();

        // Home Screen
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        scrollToBottom();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_TITLE).getText(), "Change PIN");
        pressIncorrectPin123456inChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        pressIncorrectPin888888inChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");

        pressIncorrectPin888888inChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        testBackDeviceInAndroidOnPinLockScreen();
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    @Ignore
    @Test(groups = "PinLock Group", priority = 5)
    public void testPinLockOnEnterCurrentPINMixWithLoginBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        goToChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        scrollToLogout(150);
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_TAB);
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        if (context.isAndroid()) {
            context.back();
            context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        }
        pressIncorrectPin123456();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");

        //press incorrect pin third times
        pressIncorrectPin555555();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        testBackDeviceInAndroidOnPinLockScreen();
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    @Ignore
    @Test(groups = "PinLock Group", priority = 6)
    public void testPinLockOnConfirmPinMixWithEnterCurrentPINMixWithLoginBottomSheet() {
        TtbTestContext context = getTtbTestContext();

        //enterCurrentPin
        goToChangePinScreen();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();

        //confirmPin
        goToDailyTransactionLimitScreen();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();

        //logout
        scrollToLogout(150);
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();

        //press incorrect pin third times
        pressIncorrectPin555555();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        testBackDeviceInAndroidOnPinLockScreen();
        context.findElement(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON).click();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).getText(), "Forgot PIN");
        String quickBalanceTitleText = ttbTestContext.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE).getText();
        Assert.assertTrue(quickBalanceTitleText.contains("QUICK BALANCE"));
    }

    public void goToChangePinScreen() {
        TtbTestContext context = getTtbTestContext();
        skipPersonalizeIntro();
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        pressCorrectPin010203();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        scrollToLogout(0);
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_TITLE).getText(), "Change PIN");
        pressIncorrectPin123456inChangePinScreen();
    }

    public void goToDailyTransactionLimitScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).click();
        context.findElement(OneAppElementKeys.TRANSACTION_LIMIT_FOR_DOMESTRIC_INPUT).clear();
        context.findElement(OneAppElementKeys.TRANSACTION_LIMIT_FOR_DOMESTRIC_INPUT).sendKeys("200000");
        context.findElement(OneAppElementKeys.TRANSACTION_LIMIT_SAVE_BUTTON).click();
        pressIncorrectPin555555();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON).click();
        context.findElement(OneAppElementKeys.TRANSACTION_LIMIT_BACK_BUTTON).click();
    }

    public void pressIncorrectPin123456() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_3_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_4_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_5_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_6_BUTTON).click();
    }

    public void pressIncorrectPinInConfirmScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_3_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_3_BUTTON).click();
    }

    public void pressIncorrectPinInConfirmScreen111222() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON).click();
    }

    public void pressIncorrectPin555555() {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_5_BUTTON).click();
        }
    }

    public void pressCorrectPin010203() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_0_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_1_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_0_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_2_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_0_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_3_BUTTON).click();
    }

    public void pressIncorrectPin123456inChangePinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CHANGE_PIN_1_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_2_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_3_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_4_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_5_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_6_BUTTON).click();
    }

    public void pressIncorrectPin888888inChangePinScreen() {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement(OneAppElementKeys.CHANGE_PIN_8_BUTTON).click();
        }
    }

    public void skipPersonalizeIntro() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            for (int i = 0; i < 3; i++) {
                context.findElement(OneAppElementKeys.PERSONALZIE_INTRO_NEXT_BUTTON).click();
            }
        }
    }

    public void testBackDeviceInAndroidOnPinLockScreen() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        }
    }

    public void scrollToLogout(int yOffset) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, 915)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffset)).release().perform();
    }

}
