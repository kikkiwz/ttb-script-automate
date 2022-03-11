package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SettingManageWidgetScenario extends Platform1Base {

    @Test(groups = "Setting Manage Widget Group", priority = 0)
    public void prepareData() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME);

        if (context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME).click();
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 1)
    public void testSearchSettingManageInSameLanguageShouldDisplayManageWidgetInSearchResult() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 1
        // navigate to setting screen
        setScenario("1. Customer search Manage homepage menu with main word/other word/partial word same language with app setting in Search section");

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);

        //   search
        String mainWord = "Manage Homepage";
        String[] otherWord = {"Manage", "widget", "set up widget", "widget setup", "Change Widget", "Manage homepage", "Home"};

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys(mainWord);
        testSearchResult(mainWord, mainWord);
        Thread.sleep(3000);

        for (String element : otherWord) {
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys(element);
            testSearchResult(mainWord, element);
            Thread.sleep(1500);
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 2)
    public void testSearchSettingManageInDiffLanguageShouldDisplayManageWidgetInSearchResult() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 2
        setScenario("2. Customer search Manage homepage menu with main word/other word/partial word (different language with app setting) in Search section on Settings screen");
        String mainWordTh = "ปรับแต่งหน้าหลัก";
        String mainWordEn = "Manage Homepage";
        String[] otherWordTh = {"ตั้งค่าวิดเจ็ด", "ตั้งค่า", "วิดเจ็ด", "ตั้งค่าหน้าแรก", "เรียงวิดเจ็ต", "ตั้งค่าหน้าหลัก", "เรียงวิดเจ็ต", "ปรับแต่งหน้าหลัก"};

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys(mainWordTh);
        testSearchResult(mainWordEn, mainWordTh);
        Thread.sleep(3000);

        for (String element : otherWordTh) {
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys(element);
            testSearchResult(mainWordEn, element);
            Thread.sleep(1500);
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 3)
    public void testClearSearchClickXButtonShouldClearSearchAndDisplayAllSetting() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 3
        setScenario("3. Customer presses X button on search box when search in search section on settings screen");
        String mainWord = "Manage Homepage";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys(mainWord);
        context.waitUntilVisible(OneAppElementKeys.SETTING_SEARCH_CLEAR_BUTTON);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_CLEAR_BUTTON).click();

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(),
                "Search",
                "System clear search section and reset screen to display all setting list."
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_PROFILE_IMAGE).isDisplayed(),
                "Display setting menu profile image"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_PROFILE_NAME).isDisplayed(),
                "Display setting menu profile name"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).getText(),
                "Mobile No."
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).getText(),
                "Email"
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 4)
    public void testSearchNoResultSameLanguageShouldDisplayNoResultsFoundMassage() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 4
        setScenario("4. Customer search Manage homepage menu not found when search with same language as app setting in Search section");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys("search random word");
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> ulElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuDetail"));

            evaluateAssertEqualWithImg(
                    ulElement.get(0).getText(),
                    "No results found",
                    "Display 'No results found' message in search result area"
            );
            evaluateAssertEqual(
                    ulElement.get(0).getAttribute("clickable"),
                    "false",
                    "System can not allow to click on 'No results found' message"
            );
        } else {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(),
                    "No results found",
                    "Display 'No results found' message in search result area"
            );
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 5)
    public void testSearchNoResultDiffLanguageShouldDisplayNoResultsFoundMassage() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 5
        setScenario("5. Customer search Manage homepage menu not found when search with Different language as app setting in Search section");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys("ค้นหาด้วยคำสุ่ม");

        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> ulElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuDetail"));

            evaluateAssertEqualWithImg(
                    ulElement.get(0).getText(),
                    "No results found",
                    "Display 'No results found' message in search result area"
            );
            evaluateAssertEqual(
                    ulElement.get(0).getAttribute("clickable"),
                    "false",
                    "System can not allow to click on 'No results found' message"
            );
        } else {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(),
                    "No results found",
                    "Display 'No results found' message in search result area"
            );
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 6)
    public void testSearchManageHomepageAndClickShouldNavigateToManageHomepage() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 6
        setScenario("6. Customer search Manage homepage clicks 'Manage Homepage' in search result list.");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys("Manage Homepage");
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> settingElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            settingElement.get(0).click();
        } else {
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }
        context.waitUntilVisible(OneAppElementKeys.MANAGE_HOME_TITLE);

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                "Manage Homepage",
                "Navigate to Manage Homepage screen"
        );
        if (context.isAndroid()){
            evaluateAssertTrue(
                    context.findElement(OneAppElementKeys.MANAGE_HOME_UNEDITABLE_ICON).isDisplayed(),
                    "Display Quick balance, My benefit, Favorite can't be reorder or delete"
            );
        }
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).getAttribute("enabled"),
                "false",
                "Button 'confirm' display disable state"
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 7)
    public void testSearchBackFromManageHomepageToSettingShouldDisplaySearchWithResult() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 7
        setScenario("7. Customer search Manage homepage clicks 'Manage Homepage' and click '<' on Manage Homepage screen.");
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        addLogInfo("Click back button from manage homepage");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> ulElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            evaluateAssertEqualWithImg(
                    ulElement.get(0).getText(),
                    "Manage Homepage",
                    "Display search result Manage Homepage"
            );
        } else {
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains("Manage Homepage"),
                    "Display search result Manage Homepage"
            );
        }

        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(), "Manage Homepage");
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(),
                "Manage Homepage",
                "Back to Setting screen with Search section(value in Search section textfield same like customer input before)"
        );

        if (context.isAndroid()) {
            addLogInfo("Click back on Android Device");
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> ulElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            ulElement.get(0).click();
            context.waitUntilVisible(OneAppElementKeys.MANAGE_HOME_TITLE);
            context.back();

            Assert.assertEquals(ulElement.get(0).getText(), "Manage Homepage");
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(), "Manage Homepage");
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).getText(),
                    "Manage Homepage",
                    "Back to Setting screen with Search section(value in Search section textfield same like customer input before)"
            );
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 8)
    public void testSearchManageHomepageChangSomethingAndClickBackShouldDisplayBottomSheetNotBeenSave() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 8
        setScenario("8. Customer search Manage homepage and customer have any changes in Manage Homepage screen and click back");
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> settingElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            settingElement.get(0).click();
        } else {
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }

        // must have widget install in homepage
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Show bottom sheet 'Your changes have not been saved'"
        );

    }

    @Test(groups = "Setting Manage Widget Group", priority = 9)
    public void testSearchManageHomepageChangSomethingAndClickConfirmOrderWidgetInHomeShouldOrderingFollowManageHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();

        // scenario 9
        setScenario("9. Customer search Manage homepage and customer has any changes in Manage Homepage screen and click 'Confirm' on bottom sheet \"Your changes have not been saved\"");
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> settingElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            settingElement.get(0).click();
        } else {
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }
        addLogInfo("📝 need capture activity log ID 101800200: status = success, Widget Action = Reorder/Delete.");
        testChangeSomethingAndCheckOrderingInManageHomeAndManageShouldOrderSame();
    }

    @Test(groups = "Setting Manage Widget Group", priority = 10)
    public void testSearchManageHomepageChangSomethingAndClickCancelShouldNavigateSettingWithResult() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 10

        if (context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME).click();
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        }

        setScenario("10. Customer search Manage homepage and customer has any changes in Manage Homepage click 'Cancel' on bottom sheet \"Your changes have not been saved\"");
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys("Manage HomePage");
        Thread.sleep(2000);
        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> settingElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            Thread.sleep(1000);
            settingElement.get(0).click();
        } else {
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }

        // get expect
        ArrayList<String> expectOrder = new ArrayList<>();
        if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty() && context.isAndroid()) {
            WebElement manageHome = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElement = manageHome.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
            for (WebElement item : ulElement) {
                expectOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    expectOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }
        createScreenShot("Manage Homepage screen before change something", true);
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Display bottom sheet 'Your changes have not been saved' after click back button"
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        Thread.sleep(3000);

        ArrayList<String> actualOrder = new ArrayList<>();
        if (!context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty() && context.isAndroid()) {
            WebElement homeWidgetList = context.findElement(OneAppElementKeys.HOME_WIDGETS_LIST);
            List<WebElement> homeElements = homeWidgetList.findElements(By.id("com.ttbbank.oneapp.vit:id/textViewWidgetTitle"));
            for (WebElement item : homeElements) {
                actualOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    actualOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }
        createScreenShot("Home screen widget list", true);
        System.out.println(actualOrder);
        System.out.println(expectOrder);
        evaluateAssertEqual(
                actualOrder,
                expectOrder,
                "Widget which customer has changes in Manage Homepage screen will not save."
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 11)
    public void testSearchManageHomepageChangSomethingAndClickXOrBackDeviceShouldCloseBottomSheet() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 11
        setScenario("11. Customer search Manage homepage and customer has any changes click '<'");
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).sendKeys("Manage HomePage");

        if (context.isAndroid()) {
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> settingElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));
            settingElement.get(0).click();
        } else {
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();

        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                "Display Your changes have not been saved."
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                Collections.emptyList(),
                "Back to Manage Homepage screen."
        );

        if (context.isAndroid()) {
            context.back();
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                    "Display Your changes have not been saved."
            );
            context.back();
            evaluateAssertEqualWithImg(
                    context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                    Collections.emptyList(),
                    "Back to Manage Homepage screen."
            );
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
    }

    @Test(groups = "Setting Manage Widget Group", priority = 12)
    public void testClickManageHomepageInSettingScreenShouldNavigateToManageHomepage() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 22
        setScenario("22. Customer clicks 'Manage Homepage' menu on Setting screen.");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_CLEAR_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_MOBILE_NO_MENU);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU);

        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                "Manage Homepage",
                "Navigate to Manage Homepage screen."
        );
        if(context.isAndroid()){
            Assert.assertTrue(context.findElement(OneAppElementKeys.MANAGE_HOME_UNEDITABLE_ICON).isDisplayed());
        }
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).getAttribute("enabled"),
                "false",
                "Confirm button is disable."
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 13)
    public void testClickBackInManageHomepageShouldNavigateToSettingScreen() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 23
        // has problem
        setScenario("23. Customer clicks 'Manage Homepage' menu on Setting screen and click '<' or back device.");
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();

        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(),
                "Back to Setting screen."
        );
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).isDisplayed(),
                "Display the same screen position/scroll location when there is a transition between screens"
        );

        if (context.isAndroid()) {
            addLogInfo("click back device android.");
            Thread.sleep(3000);
            context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(), "Manage Homepage");
            // wait solution testcase drag for reorder
            Assert.assertEquals(context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).getAttribute("enabled"), "false");
            context.back();
            evaluateAssertTrue(
                    context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(),
                    "Back to Setting screen."
            );
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).isDisplayed(),
                    "Back device display the same screen position/scroll location when there is a transition between screens"
            );
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 14)
    public void testClickManageHomepageChangSomethingAndClickBackShouldDisplayBottomSheetNotBeenSave() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 24
        setScenario("24. Customer click manage homepage, customer has any change and click '<' or back android device");
        // must have widget install in homepage
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Show bottom sheet 'Your changes have not been' saved"
        );

    }

    @Test(groups = "Setting Manage Widget Group", priority = 15)
    public void testManageHomepageChangSomethingAndClickConfirmOrderWidgetInHomeShouldOrderingFollowManageHome() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        // scenario 25
        setScenario("25. Customer has any changes in Manage Homepage screen and Click 'Confirm' on bottom sheet 'Your changes have not been saved'");
        // has problem
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        addLogInfo("📝 need capture activity log ID 101800200: status = success, Widget Action = Reorder/Delete.");
        testChangeSomethingAndCheckOrderingInManageHomeAndManageShouldOrderSame();
    }

    @Test(groups = "Setting Manage Widget Group", priority = 16)
    public void testManageHomepageChangSomethingAndClickCancelWidgetShouldNotChangeBackToSetting() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 26

        if (context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME).click();
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).click();
            context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        }

        setScenario("26. Customer has any changes in Manage Homepage screen and Click 'Cancle' on bottom sheet 'Your changes have not been saved'");
        // has problem
        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_MOBILE_NO);
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        Thread.sleep(3000);
        ArrayList<String> expectOrder = new ArrayList<>();
        ArrayList<String> actualOrder = new ArrayList<>();
        if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty() && context.isAndroid()) {
            WebElement manageHome = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElement = manageHome.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
            for (WebElement item : ulElement) {
                expectOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    expectOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Show bottom sheet 'Your changes have not been saved'"
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(),
                "Back to Setting screen"
        );
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).isDisplayed(),
                "Display the same screen position/scroll location when there is a transition between screens"
        );
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).getText(), "Manage Homepage");
        Thread.sleep(4000);
        scrollingToBottom(930, 0);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        Thread.sleep(3000);
        if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty() && context.isAndroid()) {
            WebElement manageHome = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElement = manageHome.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
            for (WebElement item : ulElement) {
                actualOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    actualOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }
        System.out.println(actualOrder);
        System.out.println(expectOrder);
        evaluateAssertEqual(actualOrder, expectOrder, "Widget order not change");
    }

    @Test(groups = "Setting Manage Widget Group", priority = 17)
    public void testManageHomepageChangSomethingAndClickXOrBackDeviceShouldCloseBottomSheetBackToManageHome() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 27
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();

        setScenario("27. Customer has any changes in Manage Homepage screen and click 'X' button");
        Thread.sleep(10000);
        scrollingToBottom(930, 0);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();

        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                "Show bottom sheet 'Your changes have not been saved'");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                Collections.emptyList(),
                "Bottom sheet 'Your changes have not been saved' must not display"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                "Manage Homepage",
                "Back to Manage Homepage screen."
        );

        if (context.isAndroid()) {
            context.back();
            Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
            context.back();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                    "Manage Homepage",
                    "Back to Manage Homepage screen."
            );
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 18)
    public void testManageHomepageDragDropWidgetButtonAddShouldEnable() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 34
        setScenario("34. Customer drag and drop 'Drag and drop' icon any widget on Manage Homepage screen");
        // wait for drag and drop
        while (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).isEmpty()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
            Thread.sleep(5000);
        }
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();

        context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
        context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();

        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        Thread.sleep(2000);
        createScreenShot("Before drag and drop widget", true);
        evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_FIRST_ITEM_TITLE).getText(), "My Car");
        evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_SECOND_ITEM_TITLE).getText(), "Fund Search");

        moveItemUp(context.findElement(OneAppElementKeys.MANAGE_HOME_SECOND_ITEM_ICON));
        createScreenShot("After drag and drop widget", true);
        evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_FIRST_ITEM_TITLE).getText(), "Fund Search");
        evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_SECOND_ITEM_TITLE).getText(), "My Car");

    }

    @Test(groups = "Setting Manage Widget Group", priority = 19)
    public void testManageHomepageClickXWidgetShouldDisappearAndButtonAddMustEnable() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 35

        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        Thread.sleep(10000);

        setScenario("35. Customer click 'x' icon on any widget in Manage Homepage screen.");
        int expectSize;
        int actualSize = 0;
        scrollingToBottom(930, 0);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();

        if (context.isAndroid()) {
            WebElement ulElementListBefore = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElementBefore = ulElementListBefore.findElements(By.className("android.widget.FrameLayout"));
            expectSize = ulElementBefore.size();
            context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();

            if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty()) {
                WebElement ulElementListAfter = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
                List<WebElement> ulElementAfter = ulElementListAfter.findElements(By.className("android.widget.FrameLayout"));
                actualSize = ulElementAfter.size();
            }
        } else {
            expectSize = context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]").size();
            context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
            if (!context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]").isEmpty()) {
                actualSize = context.viewElementByXPATH("//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]").size();
            }
        }

        evaluateAssertNotEqualWithImg(
                actualSize,
                expectSize,
                "Widget which customer click delete will disappear and next widget will replace."
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).getAttribute("enabled"),
                "true",
                "'Confirm' button on Manage Homepage screen will enable."
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 20)
    public void testManageHomepageChangeSomethingClickConfirmShouldNavigateToSetting() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();
        // scenario 36
        setScenario("36. Customer click 'Confirm' button in Manage Homepage screen.");
        addLogInfo("📝 need capture activity log ID 101800200: status = success, Widget Action = Reorder/Delete.");
        context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).click();
        Thread.sleep(5000);
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.SETTING_TITLE).isDisplayed(),
                "Navigate to Setting list screen"
        );
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).isDisplayed(),
                "display the same screen position/scroll location when there is a transition between screens"
        );
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).getText(), "Manage Homepage");
    }

    @Test(groups = "Setting Manage Widget Group", priority = 21)
    public void testManageHomepageClickAddWidgetShouldNavigateToManageHomepageAndOrdering() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 37
        // has problem click mange setting
        Thread.sleep(5000);
        setScenario("37. Customer Click '+ Add widgets' on Manage Homepage.");
        scrollingToBottom(930, 0);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).isDisplayed());
        Assert.assertEquals(context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).getText(), "Add Widgets");
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                "Manage Homepage",
                "Navigate to Widgets Library screen."
        );

        //check ordering
        testOrderingWidgetsLibrary();
    }

    @Test(groups = "Setting Manage Widget Group", priority = 22)
    public void testManageHomepageAddWidgetShouldDisplayBottomSheetYourChange() throws IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 38
        setScenario("38. Customer Click '+ Add widgets' on Manage Homepage screen.");
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.waitUntilVisible(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON);
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();

        Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Show bottom sheet 'Your changes have not been save'"
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 23)
    public void testManageChangeSomethingClickAddWidgetAndConfirmShouldDisplayBottomSheetAndNavigateToWidgetLibrary() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        // scenario 39
        setScenario("39. Customer click '+ Add widgets' on Manage Homepage screen and click 'Confirm' on bottom sheet");
        // change something check display bottom sheet
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(), "Your changes have not been saved");

        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        addLogInfo("📝 need capture activity log ID 101800200: status = success, Widget Action = Reorder/Delete.");
        // check navigate to widget library and order in widget screen
        if (context.isAndroid()) {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(),
                    "Manage Homepage",
                    "Navigate to Widgets Library screen."
            );
        } else {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.MANAGE_HOME_TITLE).getText(),
                    "Manage Homepage",
                    "Navigate to Widgets Library screen."
            );
        }
        testOrderingWidgetsLibrary();

        // back to manage home check ordering home and manage
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        ArrayList<String> expectOrder = new ArrayList<>();
        ArrayList<String> actualOrder = new ArrayList<>();

        if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty() && context.isAndroid()) {
            WebElement manageHome = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElement = manageHome.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
            for (WebElement item : ulElement) {
                expectOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    expectOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.HOME_TAB).click();

        if (!context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty() && context.isAndroid()) {
            WebElement homeWidgetList = context.findElement(OneAppElementKeys.HOME_WIDGETS_LIST);
            List<WebElement> homeElements = homeWidgetList.findElements(By.id("com.ttbbank.oneapp.vit:id/textViewWidgetTitle"));
            for (WebElement item : homeElements) {
                actualOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    expectOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }

        System.out.println(actualOrder);
        System.out.println(expectOrder);
        evaluateAssertEqual(
                actualOrder,
                expectOrder,
                "Widget in Home screen will display ordering follows customer change Manage Home page"
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 24)
    public void testManageHomePageCancelSaveChangeShouldNotChangeAnythings() throws IOException, InterruptedException {
        // scenario 40
        setScenario("40. Customer click '+ Add widgets' on Manage Homepage screen and click cancel on bottom sheet");
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.MORE_TABS).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();

        WebElement ulElementList = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
        List<WebElement> expectItemList = ulElementList.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
        ArrayList<String> expectOrder = new ArrayList<>();
        for (WebElement item : expectItemList) {
            expectOrder.add(item.getText());
        }

        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();

        Assert.assertTrue(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        List<WebElement> actualItemList = ulElementList.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
        ArrayList<String> actualOrder = new ArrayList<>();
        for (WebElement item : actualItemList) {
            actualOrder.add(item.getText());
        }

        evaluateAssertEqualWithImg(
                expectOrder,
                actualOrder,
                "Widget which customer has changes in Manage Homepage screen will not save."
        );
    }

    @Test(groups = "Setting Manage Widget Group", priority = 25)
    public void testManageHomePageCloseBottomSheetShouldCloseBottomSheet() throws IOException {
        // scenario 41
        setScenario("41. Change something and click '+Add Widgets' should display bottom sheet");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();

        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                "Display bottom sheet 'Your changes have not been saved'"
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        evaluateAssertTrueWithImg(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(),
                "click 'x' button back to Manage Homepage screen."
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            evaluateAssertTrueWithImg(
                    context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(),
                    "Display bottom sheet 'Your changes have not been saved'"
            );
            context.back();
            evaluateAssertTrueWithImg(
                    context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(),
                    "Click back device android back to Manage Homepage screen."
            );
        }
    }

    @Test(groups = "Setting Manage Widget Group", priority = 26)
    public void testManageHomePageClickMyCarWidgetDetailShouldNavigateToDetailScreen() throws IOException, InterruptedException {
        // scenario 52.1
        setScenario("52.1 Customer click '+ Add widgets' and click '<' or back");
        TtbTestContext context = getTtbTestContext();

        while (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).isEmpty()) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();
        }
        if (context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).getAttribute("enabled").equals("true")) {
            context.findElement(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE).click();
            context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        }

        Thread.sleep(5000);
        scrollingToBottom(930, 0);
        context.findElement(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU).click();
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).getAttribute("enabled"),
                "true",
                "Button 'Add to homepage' is enable"

        );

        // scenario 53.1
        setScenario("53.1 Customer click '+ Add widgets' and click widgets that installed");
        context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).getAttribute("enabled"),
                "false",
                "Button 'Add to homepage' is disable"
        );

        // scenario 54.1
        setScenario("54.1 Customer click '<' or back device (android) in widget detail screen");
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(),
                "Manage Homepage",
                "Back to widget library screen"
        );

        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(),
                "Manage Homepage",
                "Back to widget library screen"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).getText(),
                "Add Widgets");

        if (context.isAndroid()) {
            addLogInfo("In case click back device android");
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            context.back();
            evaluateAssertEqual(context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(), "Manage Homepage");
            context.back();
            evaluateAssertEqual(context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(), "Manage Homepage");
            evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).getText(), "Add Widgets");
        }

    }

    @Test(groups = "Setting Manage Widget Group", priority = 27)
    public void testManageHomePageClickAllTTProductsBWidgetDetailShouldNavigateToDetailScreen() throws IOException {
        // scenario 52.2
        TtbTestContext context = getTtbTestContext();
        setScenario("52.2 Customer click '+ Add widgets' and click widget that not installed button add to homepage should enabled");
        context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
        context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).getAttribute("enabled"),
                "true",
                "Button 'Add to homepage' is enable"

        );

        // scenario 53.2
        setScenario("53.2 Customer click '+ Add widgets' and click widget that installed button add to homepage should enabled false");
        context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).getAttribute("enabled"),
                "false",
                "Button 'Add to homepage' is disable"
        );

        // scenario 54.2
        setScenario("54.2 Customer click back icon button should navigate to widget library screen");
        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(),
                "Manage Homepage",
                "Back to widget library screen"
        );

        context.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(),
                "Manage Homepage",
                "Back to widget library screen"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).getText(),
                "Add Widgets",
                "Display '+Add Widgets' button"
        );

        if (context.isAndroid()) {
            addLogInfo("In case click back device android");
            context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).click();
            context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).click();
            context.back();
            evaluateAssertEqual(context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(), "Manage Homepage");
            context.back();
            evaluateAssertEqual(context.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText(), "Manage Homepage");
            evaluateAssertEqual(context.findElement(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON).getText(), "Add Widgets");
        }
    }

    public void testSearchResult(String mainWord, String word) throws IOException {
        TtbTestContext context = getTtbTestContext();

        if (context.isAndroid()) {
            scrollingToBottom(930, 0);
            WebElement searchResult = context.findElement(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW);
            List<WebElement> ulElement = searchResult.findElements(By.id("com.ttbbank.oneapp.vit:id/settingMenuName"));

            List<String> result = new ArrayList<>();
            for (WebElement item : ulElement) {
                result.add(item.getText());
            }
            evaluateAssertTrueWithImg(
                    result.contains(mainWord),
                    "Display Manage widget menu when search with " + word
            );
        } else {
            if (mainWord.equals("ตั้งค่า")) {
                scrollingToBottom(750, 500);
            }
            int i = 1;
            while (context.findElementByXPATH("(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[" + i + "]").isDisplayed()) {
                String textSearch = context.findElementByXPATH("(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[" + i + "]").getText();
                if (textSearch.contains("Manage Homepage")) {
                    evaluateAssertTrueWithImg(
                            context.findElementByXPATH("(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[" + i + "]").isDisplayed(),
                            "Display Manage widget menu in search with " + word
                    );
                    break;
                } else {
                    i++;
                }
            }
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD).click();
        }
    }

    public void testChangeSomethingAndCheckOrderingInManageHomeAndManageShouldOrderSame() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.MANAGE_HOME_ICON_DELETE).click();

        ArrayList<String> expectOrder = new ArrayList<>();
        if (!context.ViewElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY).isEmpty() && context.isAndroid()) {
            WebElement manageHome = context.findElement(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY);
            List<WebElement> ulElement = manageHome.findElements(By.id("com.ttbbank.oneapp.vit:id/textWidgetName"));
            for (WebElement item : ulElement) {
                expectOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    expectOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }
        createScreenShot("Widget list in Manage Home", true);
        context.findElement(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON).click();
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Your changes have not been saved",
                "Display bottom sheet 'Your changes have not been saved' after click back button"
        );
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.HOME_TAB).click();
        createScreenShot("Widget list in home screen", true);
        ArrayList<String> actualOrder = new ArrayList<>();
        if (!context.ViewElement(OneAppElementKeys.HOME_WIDGETS_LIST).isEmpty() && context.isAndroid()) {
            WebElement homeWidgetList = context.findElement(OneAppElementKeys.HOME_WIDGETS_LIST);
            List<WebElement> homeElements = homeWidgetList.findElements(By.id("com.ttbbank.oneapp.vit:id/textViewWidgetTitle"));
            for (WebElement item : homeElements) {
                actualOrder.add(item.getText());
            }
        } else if (context.isIos()) {
            String[] widgetList = {"All car management needs at your fingertips", "Highlight Campaign", "Fund Search", "Application Tracking", "All ttb products"};

            for (String element : widgetList) {
                if (!context.viewElementByAcessibilityId(element).isEmpty()) {
                    actualOrder.add(context.findElementByAccessibilityId(element).getText());
                }
            }
        }

        System.out.println(actualOrder);
        System.out.println(expectOrder);
        evaluateAssertEqual(
                actualOrder,
                expectOrder,
                "Widget in Home screen will display ordering follows customer change Manage Home page screen."
        );
    }

    public void testOrderingWidgetsLibrary() throws IOException {
        TtbTestContext context = getTtbTestContext();
        ArrayList<String> actualOrder = new ArrayList<>();
        ArrayList<String> expectOrder = new ArrayList<>();
        expectOrder.add("Application Tracking");
        expectOrder.add("Fund Search");
        expectOrder.add("All ttb products");
        expectOrder.add("Highlight Campaign");

        if (context.isAndroid()) {
            WebElement ulElementList = context.findElement(OneAppElementKeys.WIDGET_LIBRARY_LIST);
            List<WebElement> ulElement = ulElementList.findElements(By.id("com.ttbbank.oneapp.vit:id/textViewWidgetTitle"));
            for (WebElement item : ulElement) {
                actualOrder.add(item.getText());
            }

            evaluateAssertEqualWithImg(
                    actualOrder,
                    expectOrder,
                    "Widget ordering following 1. Application Tracking 2. Fund Search 3. All ttb products 4. Highlight Campaign"
            );
        } else {
            int positionAppTracking = context.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).getLocation().getY();
            int positionTtbProduct = context.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).getLocation().getY();
            int positionHighLight = context.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).getLocation().getY();
            int positionFundSearch = context.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).getLocation().getY();
            evaluateAssertTrueWithImg(positionAppTracking < positionTtbProduct, "1. Application Tracking");
            evaluateAssertTrueWithImg(positionTtbProduct < positionHighLight, "2. All ttb products");
            evaluateAssertTrueWithImg(positionHighLight < positionFundSearch, "3. Highlighted Campaign");
        }
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

    public void moveItemUp(WebElement element) {
        Dimension dimension = driver.manage().window().getSize();
        double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = (int) scrollHeightEnd;

        new TouchAction(driver).longPress(PointOption.point(element.getLocation().getX(), element.getLocation().getY()))
                .moveTo(PointOption.point(0, scrollEnd)).release()
                .perform();
    }
}
