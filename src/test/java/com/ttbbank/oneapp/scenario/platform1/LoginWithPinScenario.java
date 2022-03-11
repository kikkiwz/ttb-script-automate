package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginWithPinScenario extends BaseScenario {

    @Test(groups = "Login With Pin Group", priority = 1)
    public void testLoginWithPinSuccessWhenClickTransfer() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPin("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.TRANSFER_TITLE).getText(), "Transfer");
        Assert.assertEquals(context.findElement(OneAppElementKeys.OWN_TTB_ACCOUNT_BUTTON).getText(), "Own ttb account");
    }

    @Test(groups = "Login With Pin Group", priority = 2)
    public void testLoginWithWrongAccessPinWhenClickTransfer() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPin("123456");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 2 attempts left.");
        pressPin("555555");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE).getText(), "Incorrect PIN. You have 1 attempt left.");
        pressPin("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.TRANSFER_TITLE).getText(), "Transfer");
        Assert.assertEquals(context.findElement(OneAppElementKeys.OWN_TTB_ACCOUNT_BUTTON).getText(), "Own ttb account");
    }

    @Test(groups = "Login With Pin Group", priority = 3)
    public void testDismissLoginBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON).click();
        } else {
            context.findElement(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON).click();
        }

        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        if (context.isAndroid()) {
            ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
            context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
            context.back();
        } else {
            swipeDown(OneAppElementKeys.TRANSFER_BUTTON);
        }
    }

    @Test(groups = "Login With Pin Group", priority = 4)
    public void testLoginWithBiometricAndShowBiometricAuthenticationDialog() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) return;

        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        scrollToBottom();
        context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        scrollToBottom();
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_TAB);
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        context.findElement(OneAppElementKeys.BIOMETRIC_SCAN).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_BIOMETRIC_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.BIOMETRIC_SCAN).isDisplayed());
    }

    @Test(groups = "Login With Pin Group", priority = 5)
    public void testLoginWithBiometricOffAndNotShowBiometricAuthenInLogin() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) return;

        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.findElement(OneAppElementKeys.BIOMETRIC_SCAN).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        scrollToBottom();
        context.findElement(OneAppElementKeys.BIOMETRIC_SWITCH).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        scrollToBottom();
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_TAB);
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_BIOMETRIC_BUTTON).isDisplayed());
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void activation() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        enterPin();
        ttbTestContext.findElement(OneAppElementKeys.OTP_HEADER);
        ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
        }
    }

    public void swipeDown(String accessibilityId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + accessibilityId + "'");
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);
    }
}
