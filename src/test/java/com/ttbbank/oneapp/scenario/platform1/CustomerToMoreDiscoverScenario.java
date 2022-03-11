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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomerToMoreDiscoverScenario extends Platform1Base {

    Boolean showApplicationWidgetHome = false;
    Boolean showFundWidgetHome = false;
    Boolean showAllTTBWidgetHome = false;
    Boolean showHighlightWidgetHome = false;

    @Test(groups = "Customer More Screen Group", priority = 1)
    public void testCustomerClickToMoreAfterLoginInAccountSummary() throws IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("1. Customer login complete more screen must have button logout");
        addLogInfo("Customer click tab account for login");

        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        pressPin("010203");
        addLogInfo("Customer click tab more");
        context.findElement(OneAppElementKeys.MORE_TABS).click();

        String moreHeader = context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(moreHeader, "Discover More", "Navigate to More screen");

        addLogInfo("Customer scroll to bottom");
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }

        context.waitUntilVisible(OneAppElementKeys.LOGOUT_BUTTON);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.LOGOUT_BUTTON).isDisplayed(),
                "More screen show button logout"
        );

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 2)
    public void testCustomerClickToMoreAfterLoginClickBackDeviceShouldNavigateToHome() throws IOException {
        TtbTestContext context = getTtbTestContext();

        if (context.isAndroid()) {
            setScenario("1A. Android Customer login complete more screen click back device should navigate to home");
            context.findElement(OneAppElementKeys.MORE_TABS).click();

            addLogInfo("Customer click back on android device");
            context.back();
            context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed(),
                    "Navigate to home Screen"
            );
            context.findElement(OneAppElementKeys.MORE_TABS).click();

            addLogInfo("End Testing");
        }
    }

    @Test(groups = "Customer More Screen Group", priority = 3)
    public void testCustomerClickToMoreBeforeLoginNotShowLogout() throws IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("4. Customer click button more when not login should not display button logout");

        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
        context.findElement(OneAppElementKeys.MORE_TABS).click();

        String moreHeader = context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        Assert.assertEquals(moreHeader, "Discover More");

        addLogInfo("Customer scroll to bottom");
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }

        evaluateAssertTrueWithImg(
                context.ViewElement(OneAppElementKeys.LOGOUT_BUTTON).isEmpty(),
                "Not display logout button"
        );

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 4)
    public void testCustomerLoginClickToMoreAndNavigateToHome() {
        TtbTestContext context = getTtbTestContext();

        setScenario("Customer login go to more screen and go to home for set value widget library");
        addLogInfo("For set value status widget library show in home");

        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        pressPin("010203");
        context.findElement(OneAppElementKeys.MORE_TABS).click();

        String moreHeader = context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        Assert.assertEquals(moreHeader, "Discover More");
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }

        showApplicationWidgetHome = !context.ViewElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET).isEmpty();
        showFundWidgetHome = !context.ViewElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).isEmpty();
        showAllTTBWidgetHome = !context.ViewElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET).isEmpty();
        showHighlightWidgetHome = !context.ViewElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET).isEmpty();

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 5)
    public void testCustomerLoginAndClickToWidgetsLibraryInMoreScreen() throws IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("19.1 Customer login and click widget library check title card widget");

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        addLogInfo("Customer clicks widgets library on More screen");
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();

        String widgetHeader = context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        String applicationTracking = context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).getText();
        String fundSearch = context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).getText();
        String ttbProducts = context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).getText();
        String highlight = context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).getText();

        addLogInfo("Check widget title wording");
        evaluateAssertEqualWithImg(widgetHeader, "Widgets Library", "Display widget library screen");
        evaluateAssertEqual(applicationTracking, "Application Tracking", "Title card must Application Tracking");
        evaluateAssertEqual(fundSearch, "Fund Search", "Title card must Fund Search");
        evaluateAssertEqual(ttbProducts, "All ttb products", "Title card must All ttb products");
        evaluateAssertEqual(highlight, "Highlight Campaign", "Title card must Highlight Campaign");

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 6)
    public void testCustomerClickToWidgetsLibraryInMoreScreenWidgetOrderShouldFollowTCM() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();

        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        setScenario("19.2 Customer login and click widget library check order of widget");

        ArrayList<String> actualOrder = new ArrayList<>();
        ArrayList<String> expectOrder = new ArrayList<>();
        expectOrder.add("Application Tracking");
        expectOrder.add("Fund Search");
        expectOrder.add("All ttb products");
        expectOrder.add("Highlight Campaign");

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY);
        if (context.isAndroid()) {
            WebElement ulElementList = context.findElement(OneAppElementKeys.WIDGET_LIBRARY_LIST);
            List<WebElement> ulElement = ulElementList.findElements(By.id("com.ttbbank.oneapp.vit:id/textViewWidgetTitle"));
            for (WebElement item : ulElement) {
                actualOrder.add(item.getText());
            }

            addLogInfo("Check widgets ordering");
            evaluateAssertEqual(
                    actualOrder.toString(),
                    expectOrder.toString(),
                    "Widget ordering following " +
                            "\n1. Application Tracking " +
                            "\n2. Fund Search " +
                            "\n3. All ttb products " +
                            "\n4. Highlight Campaign"
            );
        } else {
            int positionAppTracking = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).getLocation().getY();
            int positionTtbProduct = ttbTestContext.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).getLocation().getY();
            int positionHighLight = ttbTestContext.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).getLocation().getY();
            int positionFundSearch = ttbTestContext.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).getLocation().getY();
            addLogInfo("Widgets are ordering as");
            evaluateAssertTrue(positionAppTracking < positionTtbProduct, "1. Application Tracking");
            evaluateAssertTrue(positionTtbProduct < positionHighLight, "2. All ttb products");
            evaluateAssertTrue(positionHighLight < positionFundSearch, "3. Highlighted Campaign");
            evaluateAssertTrue(positionHighLight < positionFundSearch, "4. Fund Search");
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 7)
    public void testCustomerLoginAndClickBackFromWidgetLibraryShouldNavigateToMore() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        setScenario("20. Customer click '<' button and back device in widget library should back to more screen");

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        addLogInfo("Customer click widget library on more screen");
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();

        String widgetHeader = context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        evaluateAssertEqualWithImg(
                widgetHeader,
                "Widgets Library",
                "Display Widgets library screen after click widget library button in more screen"
        );

        Thread.sleep(3000);

        addLogInfo("Customer click '<' button");
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).isDisplayed(),
                "Display more screen after click back button from widget library screen"
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
            Assert.assertTrue(context.findElement(OneAppElementKeys.WIDGET_LIBRARY).isDisplayed());
            Thread.sleep(3000);
            addLogInfo("Customer click back on android device on widget library screen");
            context.back();
            evaluateAssertTrue(
                    context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).isDisplayed(),
                    "Display more screen after click back device from widget library screen");
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 8)
    public void testCustomerLoginAndClickToWidgetsLibraryInMoreScreenAndCheckAddToHomepage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();

        setScenario("21. Check button add to homepage in widget library detail screen");
        addLogInfo("Customer click widget library card");

        if (context.isIos()) {
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            Thread.sleep(2000);
            evaluateAssertEqual(
                    context.ViewElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).isEmpty(),
                    !showApplicationWidgetHome,
                    "Button add to homepage in application tracking detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            Thread.sleep(2000);
            evaluateAssertEqual(
                    context.ViewElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).isEmpty(),
                    !showFundWidgetHome,
                    "Button add to homepage in fund search detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
            Thread.sleep(2000);
            evaluateAssertEqual(
                    context.ViewElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).isEmpty(),
                    !showAllTTBWidgetHome,
                    "Button add to homepage in ttb product detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
            Thread.sleep(2000);
            evaluateAssertEqual(
                    context.ViewElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).isEmpty(),
                    !showHighlightWidgetHome,
                    "Button add to homepage in highlight campaign detail"
            );
        } else {
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            Thread.sleep(3000);
            evaluateAssertEqual(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    String.valueOf(!showApplicationWidgetHome),
                    "Button add to homepage in application tracking detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            Thread.sleep(3000);
            evaluateAssertEqual(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    String.valueOf(!showFundWidgetHome),
                    "Button add to homepage in fund search detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
            Thread.sleep(3000);
            evaluateAssertEqual(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    String.valueOf(!showAllTTBWidgetHome),
                    "Button add to homepage in ttb products detail"
            );
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

            context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
            Thread.sleep(3000);
            evaluateAssertEqual(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    String.valueOf(!showHighlightWidgetHome),
                    "Button add to homepage in highlight campaign detail"
            );
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 9)
    public void testClickBackFromWidgetDetailShouldNavigateToWidgetLibrary() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        setScenario("22. Check arrow back button and back device in widget library screen detail");
        addLogInfo("Customer click widget and click '<' button on widget detail screen");

        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        checkWidgetLibraryCard();

        if (context.isAndroid()) {
            addLogInfo("Customer click widget and click back on android device on widget detail screen");
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            Thread.sleep(3000);
            context.back();
            checkWidgetLibraryCard();

            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            Thread.sleep(3000);
            context.back();
            checkWidgetLibraryCard();

            context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
            Thread.sleep(3000);
            context.back();
            checkWidgetLibraryCard();

            context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
            Thread.sleep(3000);
            context.back();
            checkWidgetLibraryCard();
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 10)
    public void testWidgetLibraryDetailClickAddToHomeShouldDisplayBottomSheetAddToHomeButtonDisableAndBackToWidgetScreen() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("28-29 Check in widget library detail screen click add to homepage after click button should disable ,click close bottom sheet and back to widget screen");
        addLogInfo("Customer click 'add to homepage' if button enable after click button will disable");

        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        Thread.sleep(3000);
        checkClickAddToHomeShouldDisplayBottomSheetAndButtonAddToHomeDisable();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
        Thread.sleep(3000);
        checkClickAddToHomeShouldDisplayBottomSheetAndButtonAddToHomeDisable();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
        Thread.sleep(3000);
        checkClickAddToHomeShouldDisplayBottomSheetAndButtonAddToHomeDisable();
        checkWidgetLibraryCard();

        context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
        Thread.sleep(3000);
        checkClickAddToHomeShouldDisplayBottomSheetAndButtonAddToHomeDisable();
        checkWidgetLibraryCard();

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 11)
    public void testWidgetLibraryDetailClickAddToHomeShouldDisplayBottomSheetAndBackDeviceCloseBottomSheet() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        setScenario("29. Check back device after bottom sheet display must close bottom sheet");
        addLogInfo("Customer click 'add to homepage' if button enable after click button will disable");
        addLogInfo("For this case, back to widget screen by back device android");

        if (context.isAndroid()) {
            removeWidgetLibraryFromHomePage();

            context.findElement(OneAppElementKeys.MORE_TAB).click();
            context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            Thread.sleep(3000);
            checkClickAddToHomeShouldDisplayBottomSheetAndBackDevice();

            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            Thread.sleep(3000);
            checkClickAddToHomeShouldDisplayBottomSheetAndBackDevice();

            context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
            Thread.sleep(3000);
            checkClickAddToHomeShouldDisplayBottomSheetAndBackDevice();

            context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).click();
            Thread.sleep(3000);
            checkClickAddToHomeShouldDisplayBottomSheetAndBackDevice();

        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 12)
    public void testWidgetLibraryDetailClickAddToHomeClickReturnToHomeShouldNavigateToHomeScreen() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        setScenario("30. Check click add to home page and click return to home should navigate to home screen");

        addLogInfo("Clear widget library that add to homepage success");
        removeWidgetLibraryFromHomePage();

        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        Thread.sleep(3000);

        addLogInfo("Customer click 'Add to homepage' button");
        context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertTrue(context.findElement(
                        OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                "Display bottom sheet install widget"
        );

        addLogInfo("Customer click 'Return to home' button");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed(),
                "Must show home screen"
        );

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 13)
    public void testWidgetLibraryDetailClickAddToHomeClickExploreOtherShouldNavigateToWidgetLibraryScreen() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("31. Check click add to home page and click explore other widget should navigate to widget library screen");

        addLogInfo("Clear widget library that add to homepage success");
        removeWidgetLibraryFromHomePage();

        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        Thread.sleep(3000);

        addLogInfo("Customer click 'Add to homepage' button");
        context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                "Display bottom sheet install widget library"
        );

        addLogInfo("Customer click 'Explore other widget' button");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY);
        evaluateAssertTrueWithImg(context.findElement(
                        OneAppElementKeys.WIDGET_LIBRARY).isDisplayed(),
                "Display widget library screen"
        );


        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 14)
    public void testCustomerClickSettingShouldDisplayLoginModule() throws IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        setScenario("36. Customer not logged in yet click setting should display login module");

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        addLogInfo("Customer scroll to bottom");
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }

        if (!context.ViewElement(OneAppElementKeys.LOGOUT_BUTTON).isEmpty()) {
            addLogInfo("In case, login success will logout before start test this scenario");
            context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
            context.findElement(OneAppElementKeys.MORE_TABS).click();
        }

        addLogInfo("Customer not logged click tab setting");
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed(),
                "Display login module"
        );


        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 15)
    public void testCustomerClickSettingCheckCloseLoginModule() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON).click();

        setScenario("37. Customer not logged in yet click setting and click 'x' should close login modal");
        addLogInfo("Customer not logged in yet and click setting when close login module should back to more screen");

        context.findElement(OneAppElementKeys.MORE_TABS).click();

        addLogInfo("Customer click setting");
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed(),
                "Display login modal"
        );

        addLogInfo("Customer click 'x' button");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON).click();
        evaluateAssertEqualWithImg(context.ViewElement(
                        OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE),
                Collections.emptyList(),
                "Login module should not display"
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_TAB).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE);
            Thread.sleep(2000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed());

            addLogInfo("Customer click back on android device");
            context.back();
            evaluateAssertEqualWithImg(context.ViewElement(
                            OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE),
                    Collections.emptyList(),
                    "Login module should not display"
            );
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 16)
    public void testCustomerLoginClickSettingShouldNavigateToSettingScreenAndBack() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("38-39. Customer login click setting should navigate to setting screen");

        addLogInfo("Customer click tab account for login");
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        pressPin("010203");
        context.findElement(OneAppElementKeys.MORE_TABS).click();

        addLogInfo("Customer click setting");
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.SETTING_TITLE).getText(),
                "Settings",
                "Display setting screen"
        );

        addLogInfo("Click '<' button");
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).isDisplayed(),
                "Back to more screen display more screen"
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_TAB).click();
            context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
            Thread.sleep(1000);

            addLogInfo("Click back on android device");
            context.back();
            Assert.assertTrue(context.findElement(OneAppElementKeys.MORE_HEADER_TITLE).isDisplayed());
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 24)
    public void testMoreScreenClickLogoutShouldDisplayBottomSheetLogoutAndCloseBottomSheet() throws IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("49-50. Customer click logout button should bottom sheet logout and close bottom sheet");

        addLogInfo("Customer scroll to bottom");
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.waitUntilVisible(OneAppElementKeys.MORE_HEADER_TITLE);
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }

        addLogInfo("Customer click logout button");
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).isDisplayed(),
                "Display logout bottom sheet after click button logout"
        );

        addLogInfo("Customer click cancel button on bottom sheet logout");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        evaluateAssertEqual(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                Collections.emptyList(),
                "Not display bottom sheet logout after click cancel"
        );

        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);

        addLogInfo("Customer click 'x' button on bottom sheet logout");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        evaluateAssertEqual(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                Collections.emptyList(),
                "Not display bottom sheet logout after click close button"
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);

            addLogInfo("Customer click back on android device when bottom sheet logout display");
            context.back();
            evaluateAssertEqual(
                    context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                    Collections.emptyList(),
                    "Not display bottom sheet logout after back android device"
            );
        }

        addLogInfo("End Testing");
    }

    @Test(groups = "Customer More Screen Group", priority = 25)
    public void testMoreScreenClickLogoutShouldNavigateToHomeScreen() throws IOException {
        TtbTestContext context = getTtbTestContext();

        setScenario("51. Customer click logout button should bottom sheet logout and close bottom sheet");

        addLogInfo("Customer scroll to bottom");
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        if (context.isAndroid()) {
            scrollingToBottom(915, 0);
        } else {
            scrollingToBottom(750, 500);
        }
        context.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);

        addLogInfo("Customer click 'OK' button");
        context.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed(),
                "Click 'OK' button Navigate to home screen"
        );

        addLogInfo("Customer click 'Transfer' button");
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).isDisplayed(),
                "Click transfer button in home screen display login module"
        );

        addLogInfo("End Testing");
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

    public void checkWidgetLibraryCard() {
        TtbTestContext context = getTtbTestContext();
        evaluateAssertTrue(context.findElement(
                        OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).isDisplayed(),
                "Display application tracking widget"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).isDisplayed(),
                "Display Fund search widget"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).isDisplayed(),
                "Display ttb product widget"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).isDisplayed(),
                "Display highlight campaign widget"
        );
    }

    public void checkClickAddToHomeShouldDisplayBottomSheetAndButtonAddToHomeDisable() throws IOException {
        TtbTestContext context = getTtbTestContext();
        if (Objects.equals(context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"), "true")) {
            context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
            context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    "false",
                    "Button add to homepage must disable");
        }
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
    }

    public void checkClickAddToHomeShouldDisplayBottomSheetAndBackDevice() throws IOException {
        TtbTestContext context = getTtbTestContext();
        if (Objects.equals(context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"), "true")) {
            context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                    "Display bottom sheet install widget"
            );
            context.back();
            evaluateAssertEqual(context.ViewElement(
                            OneAppElementKeys.BOTTOMSHEET_CARD),
                    Collections.emptyList(),
                    "Bottom sheet not display after back device android"
            );
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY).getAttribute("enabled"),
                    "false",
                    "Button add to home page must disable");
        }
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
    }

    public void removeWidgetLibraryFromHomePage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(3000);
        if (context.isAndroid()) {
            scrollingToBottom(1800, 0);
        } else {
            scrollingToBottom(1000, 500);
        }
        context.findElement(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME).click();
        context.waitUntilVisible(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);

        WebElement ulElementList = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
        List<WebElement> ulElement = ulElementList.findElements(By.className("android.widget.FrameLayout"));

        for (int i = 0; i < ulElement.size(); i++) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).click();
    }
}
