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

import java.time.Duration;

public class SettingToQuickBalanceScenario extends BaseScenario {

    @Test(groups = "Setting to Quick Balance Group", priority = 1)
    public void testSearchQuickBalanceInSetting() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            skipPersonalizeIntro();
        }
        context.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPinLogin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();

        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("fast");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();

        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();

        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("find");
        Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText().contains("No results found"));
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 2)
    public void testSearchQuickBalanceInSettingAndClearText() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("test");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS).getText(), "Search");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 3)
    public void testSearchQuickBalanceClickToQuickBalanceAndBackUnchanged() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            //Thread.sleep(20000);
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
            context.getDriver().getKeyboard().sendKeys("Quick balance");
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
            context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        }
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS).click();
        context.getDriver().getKeyboard().sendKeys("Quick balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TITLE).getText(), "Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).getText(), "Enable Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE).getText(), "Show Balance on Homepage");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS).getText(), "Quick balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");

    }

    @Test(groups = "Setting to Quick Balance Group", priority = 4)
    public void testSearchQuickBalanceClickToQuickBalanceAndBackChanged() {
        // turn OFF
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS).getText(), "Quick balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 5)
    public void testSearchQuickBalanceClickToQuickBalanceAndBackChangedCancel() {
        TtbTestContext context = getTtbTestContext();
        //Turn On but still Off
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS).getText(), "Quick balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText(), "Application > Quick Balance");
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
    }


    @Test(groups = "Setting to Quick Balance Group", priority = 6)
    public void testSearchQuickBalanceClickToQuickBalanceAndBackChangedSwipeDown() {
        TtbTestContext context = getTtbTestContext();
        // wanna turn On but still Off
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        scrollingToBottom(750, 600);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TITLE).getText(), "Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).getText(), "Enable Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE).getText(), "Show Balance on Homepage");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 7)
    public void testSearchQuickBalanceClickToQuickBalanceAndBackChangedCloseButton() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        // still Off
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        }

        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TITLE).getText(), "Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).getText(), "Enable Quick Balance");
        Assert.assertEquals(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE).getText(), "Show Balance on Homepage");

        //turn on
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 8)
    public void testClickToQuickBalanceAndBackUnchangedShowOff() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            scrollingToBottom(750, 0);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed());

        }
        if (context.isAndroid()) {
            Thread.sleep(5000);
            scrollingToBottom(900, 0);
            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText(), "Quick Balance");
        }

        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 9)
    public void testClickToQuickBalanceSetOnEnableQuickBalanceShouldShowOn() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 10)
    public void testQuickBalanceOnAndHideAccountShouldShowOff() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
            scrollingToBottom(100, 750);
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
            Thread.sleep(1000);
            context.findElement(OneAppElementKeys.MORE_SETTINGS).click();
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        if (context.isIos()) {
            Thread.sleep(3000);
            scrollingToBottom(750, 100);
            Thread.sleep(3000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed());
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
            Thread.sleep(1000);
            context.findElement(OneAppElementKeys.MORE_SETTINGS).click();
            Thread.sleep(10000);
            scrollingToBottom(900, 0);
            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText(), "Quick Balance");
        }
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 11)
    public void testChangeShowAccountShouldShowQuickBalanceOff() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            scrollingToBottom(100, 750);
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
            Thread.sleep(1000);
            context.findElement(OneAppElementKeys.MORE_SETTINGS).click();
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT).click();
        if (context.isIos()) {
            Thread.sleep(3000);
            pressPinLogin("010203");
            Thread.sleep(10000);
        }
        if (context.isAndroid()) {
            pressPinConfirm("010203");
        }
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        if (context.isIos()) {
            Thread.sleep(3000);
            scrollingToBottom(750, 0);
            Thread.sleep(3000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed());
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
            Thread.sleep(1000);
            context.findElement(OneAppElementKeys.MORE_SETTINGS).click();
            Thread.sleep(10000);
            scrollingToBottom(900, 0);
            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
            Thread.sleep(3000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).getText(), "Quick Balance");
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
    }


    @Test(groups = "Setting to Quick Balance Group", priority = 12)
    public void testQuickBalanceUnchangedOffToggleShouldDisableConfirmButton() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());

        Thread.sleep(3000);
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 13)
    public void testQuickBalanceChangedOnToggleShouldEnableConfirmButton() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();

        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        Thread.sleep(3000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());

        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 14)
    public void testQuickBalanceDefaultOnEnableOffDisplayUnchangedConfirmButtonDisable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
        }
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 15)
    public void testQuickBalanceDefaultOnEnableOffDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
        }
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();

        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 16)
    public void testQuickBalanceDefaultOnEnableOnDisplayUnchangedConfirmButtonDisable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isEnabled());
        }
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 17)
    public void testQuickBalanceDefaultOnEnableOnDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isEnabled());
        }
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();

        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 18)
    public void testQuickBalanceOffEnableOffDisplayToOnEnableOffDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isEnabled());
        }
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 19)
    public void testQuickBalanceOffEnableOffDisplayToOnEnableOnDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());

        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isEnabled());

        }

        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());

        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 20)
    public void testQuickBalanceOnEnableOffDisplayToOffEnableOffDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        }

        if (context.isIos()) {
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        }

        if (context.isAndroid()) {
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
            Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        }

        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 21)
    public void testQuickBalanceOnEnableOnDisplayToOffEnableOffDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isEnabled());
        }
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();

        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());

        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());
        }
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isEnabled());

        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 22)
    public void testQuickBalanceOffEnableToOnEnableOffDisplayChangedConfirmButtonEnable() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();

        Assert.assertFalse(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected());
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isSelected());
        }
        if (context.isAndroid()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isEnabled());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isEnabled());
        }

        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 23)
    public void testQuickBalanceClickBackButtonWhenUnchanged() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 24)
    public void testQuickBalanceClickBackButtonWhenChangedShowBottomSheetAndClickConfirm() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "On");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 25)
    public void testQuickBalanceClickBackButtonWhenChangedShowBottomSheetAndClickCancel() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
    }

    @Test(groups = "Setting to Quick Balance Group", priority = 26)
    public void testQuickBalanceClickBackButtonWhenChangedShowBottomSheetAndSwipeDown() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE).getText(), "Off");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();

        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Your changes have not been saved");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Click \"Confirm\" if you would like to save your changes.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Confirm");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).getText(), "Cancel");
        scrollingToBottom(750, 600);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
    }

    public void pressPinLogin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void pressPinConfirm(String pins) {
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

    public void skipPersonalizeIntro() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            for (int i = 0; i < 3; i++) {
                context.findElement(OneAppElementKeys.PERSONALZIE_INTRO_NEXT_BUTTON).click();
            }
        }
    }

}
