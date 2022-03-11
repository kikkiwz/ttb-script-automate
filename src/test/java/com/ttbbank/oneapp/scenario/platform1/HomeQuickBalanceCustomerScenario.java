package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class HomeQuickBalanceCustomerScenario extends Platform1Base {

    @Test(groups = "Home Quick Balance Group", priority = 1)
    public void testCustomerNavigateToHomeScreenAndDisplayDefaultQuickBalance() throws IOException {
        // set quick balance off ,off toggle
        setScenario("1-2. Customer not set quick balance or account status inactive Should display default stage of quick balance");
        TtbTestContext context = getTtbTestContext();
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(),
                "Display Quick balance title"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(),
                "Display Quick balance detail"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(),
                "Activate",
                "System displays default stage of Quick balance"
        );
    }

    @Test(groups = "Home Quick Balance Group", priority = 2)
    public void testClickActivateAndChangeOnActivateOffShowQuickBalance() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("15. Customer did not log in and click 'Activate' button should populates login module");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed(), "Display login module");
        pressPinLogin("010203");
        addLogInfo("need capture activity log📄");
        Thread.sleep(5000);

        setScenario("9. Customer set toggle on to activate quick balance and toggle off to show balance should system displays default stage of quick balance");
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(),
                "Display quick balance title"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(),
                "Display enable quick balance"
        );
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT).isDisplayed(),
                "Display first account"
        );
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(3000);

        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(),
                "System displays default stage of Quick balance"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).getText(),
                "View Balance",
                "Button in widget quick balance display text 'View Balance'"
        );
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name");
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"),
                "Display account number with format"
        );
    }


    @Test(groups = "Home Quick Balance Group", priority = 3)
    public void testTabViewBalanceAtQuickBalanceWidget() throws InterruptedException, IOException {
        setScenario("10. Customer tabs 'View Balance' in quick balance should display balance value");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).getText(),
                "View Balance",
                "Button display text 'View Balance'"
        );

        context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).click();
        Thread.sleep(15000);
        if (context.isIos()) {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(
                    valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance value with format"
            );
        } else {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(
                    valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance value with format"
            );
        }
    }

    @Test(groups = "Home Quick Balance Group", priority = 4)
    public void testTabBalanceButtonAtQuickBalanceWidget() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("11. Customer tabs balance value should display 'View balance' button");
        if (context.isIos()) {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance with format"
            );
            context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).click();
        } else {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance with format"
            );
            context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON).click();
        }
        Thread.sleep(15000);
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).getText(),
                "View Balance",
                "System display 'View balance' button , but does not display balance value"
        );
    }

    @Test(groups = "Home Quick Balance Group", priority = 5)
    public void testClickActivateAndChangeOnActivateOnShowQuickBalance() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("12. Custom set up active quick balance and show balance toggle on quick balance widget should display account nickname, account no. and balance value");
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(10000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(), "Display setting title");
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed(), "Display setting quick balance");
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(3000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display quick balance widget");
        if (context.isIos()) {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON).isDisplayed());
        } else {
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON).isDisplayed());
        }
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"), "Display account no. with format");
        Thread.sleep(10000);
        if (context.isIos()) {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance value with format"
            );
        } else {
            context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance value with format"
            );
        }
    }

    @Test(groups = "Home Quick Balance Group", priority = 6)
    public void testTabOtherPartInWidgetGoToAccountDetails() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("13. Customer tabs other parts of the widget should navigate to account detail screen");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).click();
        Thread.sleep(10000);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT).isDisplayed(),
                "Navigate to account detail screen"
        );
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_BACK_BUTTON).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display quick balance widget");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"), "Display account no.");
    }

    @Test(groups = "Home Quick Balance Group", priority = 7)
    public void testTabOtherPartInWidgetGoToAccountDetailsWithoutLogin() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        scrollingToBottom(1050, 500);
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        Thread.sleep(3000);
        setScenario("14. Customer tabs other parts of the widget without login should display login module and navigate to account detail screen");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed(),
                "System display module login"
        );
        pressPinLogin("010203");
        addLogInfo("need capture activity log📄");
        Thread.sleep(10000);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT).isDisplayed(),
                "Navigate to account detail screen after login success"
        );
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.ACCOUNT_DETAIL_BACK_BUTTON).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display quick balance widget");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"), "Display account no.");
    }

    @Test(groups = "Home Quick Balance Group", priority = 8)
    public void testQuickBalanceOffActivateAndClickActivateToQuickBalanceScreen() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setDefaultQuickBalance();
        setScenario("17, 20. Customer click 'Active' button and not set up Quick balance or set up Toggle OFF should navigate to quick balance setup");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(), "Display setup quick balance screen title");
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(), "Display 'Enable Quick balance'");
        evaluateAssertFalseWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).isSelected(), "System displays Turn on/off quick balance toggle = OFF");
        evaluateAssertFalseWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).isSelected(), "System displays and disables 'Show Balance on Homepage' toggle = OFF");
        evaluateAssertFalseWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled(), "System disables Confirm button");
    }

    @Test(groups = "Home Quick Balance Group", priority = 9)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceEnableToggleShowEnableConfirm() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("18. Customer makes changes in set up quick balance screen button confirm should set to enable state");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        Thread.sleep(3000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled(), "System enables Confirm button");
    }

    @Test(groups = "Home Quick Balance Group", priority = 10)
    public void testQuickBalanceOffActivateAndUnchangeQuickBalanceToggleAndNotShowEnableConfirm() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("19. Customer set enable quick balance off and click 'Active' button in widget button confirm should set to disable state");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(3000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(), "Navigate to setup quick balance screen");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(), "Display 'Enable quick balance'");
        evaluateAssertFalseWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled(), "System disable Confirm button");
    }

    @Test(groups = "Home Quick Balance Group", priority = 11)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceEnableAndShowQuickBalanceThenEnableConfirm() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("26. Customer turns Quick balance toggle = ON and 'Show Balance on Homepage' toggle = ON");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        Thread.sleep(3000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).isEnabled(), "System enables Confirm button");
    }

    @Test(groups = "Home Quick Balance Group", priority = 12)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceConfirmToHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("29. Customer clicks confirm in Quick balance set up screen should navigate to home");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        addLogInfo("need capture activity log📄");
        Thread.sleep(3000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display quick balance widget");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"), "Display account no.");
        Thread.sleep(10000);
        if (context.isIos()) {
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrue(valueBalance.isDisplayed(), "Display balance value");
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance with format"
            );
        } else {
            WebElement valueBalance = context.findElement(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON);
            int lengthValue = valueBalance.getText().length();
            evaluateAssertTrue(valueBalance.isDisplayed(), "Display balance value");
            evaluateAssertTrueWithImg(valueBalance.getText().substring(lengthValue - 3).matches(".\\d{2}"),
                    "Display balance with format"
            );
        }
    }

    @Test(groups = "Home Quick Balance Group", priority = 13)
    public void testQuickBalanceOffActivateAndUnchangeQuickBalanceAndBackToHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setDefaultQuickBalance();

        setScenario("39. Customer does not make any changes in Set up Quick balance screen and click back should navigate to home");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();

        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "System navigate to home screen and display quick balance widget,");
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(), "Display quick balance widget detail");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(), "Activate", "Display 'Active' button in quick balance widget");

        if (context.isAndroid()) {
            setScenario("40. Customer does not make any changes in Set up Quick balance screen and click back device should navigate to home");
            context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
            Thread.sleep(5000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed());
            context.back();

            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "System navigate to home screen and display quick balance widget");
        }
    }

    @Test(groups = "Home Quick Balance Group", priority = 14)
    public void testQuickBalancChangeQuickBalanceDisplayBottomSheet() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("41. Customer makes changes in Set up Quick balance screen and click back should display bottom sheet");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(), "Display setup quick balance screen title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(), "Display 'Enable Quick balance'");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Display Confirm bottom sheet.");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();

        if (context.isAndroid()) {
            setScenario("42. Customer makes changes in Set up Quick balance screen and click back device should display bottom sheet");
            context.back();
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Display Confirm bottom sheet.");
        }
        setScenario("42. Customer makes changes in Set up Quick balance screen and click back device should display bottom sheet");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
    }

    @Test(groups = "Home Quick Balance Group", priority = 15)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceAndBackCancelConfirmToHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("53. Customer makes changes in Set up Quick balance screen and click back display bottom sheet confirm click back should navigate to home");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(), "Display setup quick balance screen title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(), "Display 'Enable Quick balance'");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();

        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display Quick balance title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(), "Display Quick balance detail");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(), "Activate", "System does not save all changes and navigates back to Home screen");
    }

    @Test(groups = "Home Quick Balance Group", priority = 16)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceBackCloseAndSwipeDownConfirm() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("54-56. Customer makes changes in Set up Quick balance screen and click back should display bottom sheet");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed());
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Display bottom confirm");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        evaluateAssertTrue(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "System dismisses Confirm bottom sheet and remains in Set up Quick balance screen");
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed());

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Display bottom confirm");
            context.back();
            evaluateAssertTrue(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "System dismisses Confirm bottom sheet and remains in Set up Quick balance screen");
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed());
            Assert.assertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed());
        }
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
    }

    @Test(groups = "Home Quick Balance Group", priority = 17)
    public void testQuickBalanceOffActivateAndChangeQuickBalanceAndBackConfirmToHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("43.Customer click confirm in bottom sheet should navigate back to Home screen with updated quick balance widget");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_TITLE).isDisplayed(), "Display quick balance title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE).isDisplayed(), "Display 'Enable Quick Balance'");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        addLogInfo("need capture activity log📄");
        Thread.sleep(3000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Navigate back to Home screen with updated quick balance widget");
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET).isDisplayed(), "Display account name in quick balance widget");
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET).getText().matches("XXX-X-XX\\d{3}-\\d{1}"), "Display account no. with format");

    }

    @Test(groups = "Home Quick Balance Group", priority = 18)
    public void testOnEnableOffShowBalanceSetHideAccountGoHomeShowDefaultQuickBalance() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("5. Customer set enable on, show balance off and set hide account widget quick balance should display default state");
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(30000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT).click();
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_HIDDEN_ACCOUNT).click();
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        }
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH).click();
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display Quick balance title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(), "Display Quick balance detail");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(), "Activate", "System does not save all changes and navigates back to Home screen");
    }

    @Test(groups = "Home Quick Balance Group", priority = 19)
    public void testClickActivateQuickBalanceWidgetWhenNotEligibleAccount() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("16. Customer not have eligible account and clicks 'Activate' in Quick balance widget should display bottom sheet");
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).click();
        Thread.sleep(5000);
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Cannot use this service",
                "System populates Error message 'Cannot use this service' in Bottom sheet"
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
    }

    @Test(groups = "Home Quick Balance Group", priority = 20)
    public void testOnEnableOffShowBalanceSetHideAccountGoHomeShowDefaultQuickBalanceAndUnhide() throws InterruptedException, IOException {
        setScenario("7. Customer set enable on, show balance off and set hide account widget quick balance should display default state quick balance");
        unhideFirstManageAccount();
    }

    @Test(groups = "Home Quick Balance Group", priority = 21)
    public void testOnEnableOnShowBalanceSetHideAccountGoHomeShowDefaultQuickBalance() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("6. Customer set enable on, show balance on and set hide account widget quick balance should display default state");
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(30000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed());
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE).click();
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(30000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed());
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT).click();
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_HIDDEN_ACCOUNT).click();
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        }
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH).click();
        }
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display Quick balance title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(), "Display Quick balance detail");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(), "Activate", "System does not save all changes and navigates back to Home screen");
    }

    @Test(groups = "Home Quick Balance Group", priority = 22)
    public void testOnEnableOnShowBalanceSetHideAccountGoHomeShowDefaultQuickBalanceAndUnhide() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("8. Customer set enable on, show balance on and set hide account widget quick balance should display default state quick balance");
        unhideFirstManageAccount();
    }

    public void unhideFirstManageAccount() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(15000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(), "Display setting title");
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT).click();
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT).click();
        if (context.isIos()) {
            pressPinLogin("010203");
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_SHOW_ACCOUNT).click();
        } else {
            pressPinLoginManageAccount("010203");
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON).click();
        }
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH).click();
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(5000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_WIDGET).isDisplayed(), "Display Quick balance title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE).isDisplayed(), "Display Quick balance detail");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON).getText(), "Activate", "System does not save all changes and navigates back to Home screen");
    }

    public void setDefaultQuickBalance() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(15000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed());
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).isDisplayed());
        context.findElement(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(5000);
    }

    public void pressPinLogin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void pressPinLoginManageAccount(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_" + pins.charAt(i) + "_BUTTON").click();
        }
    }


    public void scrollingToBottom(int yOffsetpress, int yOffsetmoveto) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, yOffsetpress)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffsetmoveto)).release().perform();
    }
}
