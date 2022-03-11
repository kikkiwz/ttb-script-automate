package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class InternationalAddressCusotomerScenario extends Platform1Base {

    private final String inter_address = "International Transfer Address";
    private final String found_inter_address = "Found International Address Menu";
    private final String inter_address_thai = "ที่อยู่สำหรับโอนเงินต่างประเทศ";
    private final String daily_transaction_limit = "Daily Transaction Limit";
    private final String found_daily_transaction_limit = "Found Daily Transaction Limit Menu";
    private final String daily_transaction_limit_thai = "วงเงินทำธุรกรรมต่อวัน";
    private final String pin_free = "PIN-Free Transaction Limit";
    private final String found_pin_free = "Found PIN-Free Transaction Limit Menu";
    private final String pin_free_thai = "ทำธุรกรรมโดยไม่ใช้รหัสผ่าน";

    @Test(groups = "International Address Group", priority = 1)
    public void testSearchInternationalAddressSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("International Address: 1,3,5,7,9 search international address menu in English");
        addLogInfo("Start Testing");
        context.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPinLogin("010203");
        Thread.sleep(8000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("International Address");
        addLogInfo("Customer search main word \"International Address\"");
        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("transfer");
        addLogInfo("Customer search partial word \"transfer\"");
        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("personal information");
        addLogInfo("Customer search other word \"personal information\"");
        if (context.isAndroid()) {
            context.back();
            Thread.sleep(2000);
        }
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_4).getText(), inter_address, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("odds");
        addLogInfo("Customer search word \"odds\"");
        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "No results found", "Not Found International Address Menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(2000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());

    }

    @Test(groups = "International Address Group", priority = 2)
    public void testSearchInternationalAddressSettingAndClickFromSearch() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("International Address: 10,11,14 Search international address menu and click");
        addLogInfo("Start Testing");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("International Address");
        addLogInfo("Customer search main word \"International Address\"");
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address, "Found International Address Menu");
        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("Click on search result menu \"International Address\"");
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_EDIT_BUTTON).click();
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_TITLE).getText(), "International Transfer", "Land to international address screen");
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET).click();
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON).click();
        }
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address, "Back to international address screen");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

    }

    @Test(groups = "International Address Group", priority = 3)
    public void testInternationalAddressSettingClickFromSettingListAndBack() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(10000);
        setScenario("International Address: 17,19 click international address menu");
        addLogInfo("Start Testing");
        context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).click();
        addLogInfo("Click on menu \"International Address\" and press back button");
        Thread.sleep(10000);
        if (context.isIos()) {
            evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_TITLE).getText(), "International Transfer", "Land to international address screen");
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
            addLogInfo("Press Back Button");
        }
        if (context.isAndroid()) {
            evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_TITLE).getText(), "International Transfer", "Land to international address screen");
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON).click();
            addLogInfo("Press Back Button");
        }
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).getText(), inter_address, "Back to Settings screen");

    }

    @Test(groups = "International Address Group", priority = 4)
    public void testInternationalAddressSettingClickFromSettingListConfirmAddress() throws Exception {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(10000);
        setScenario("International Address: 15 click international address menu then click edit address button");
        addLogInfo("Start Testing");
        context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).click();
        addLogInfo("Click on menu \"International Address\" ");
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_EDIT_BUTTON).click();
        addLogInfo("click edit button in international address screen");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_TITLE).getText(), "International Transfer", "Land to edit address screen");
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
        addLogInfo("Press back '<' button");
        context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET).click();
        addLogInfo("Press confirm leave button");
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON).click();
        } else {
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
        }
        addLogInfo("Press back '<' button");
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).getText().contains("International Transfer Address"));
    }

    @Test(groups = "International Address Group", priority = 5)
    public void testSearchInternationalAddressSettingInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("International Address: 2,4,6,8 search international address menu in Thai");
        addLogInfo("Start Testing");
        Thread.sleep(2000);
        changeLanguage("Language", "THAI");
        addLogInfo("Changed Language to Thai");
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));

        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ที่อยู่โอนเงินต่างประเทศ");
        } else {
            input.setValue("ที่อยู่โอนเงินต่างประเทศ");
        }
        addLogInfo("Customer search main word \"ที่อยู่โอนเงินต่างประเทศ\"");

        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address_thai, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ต่างประเทศ");
        } else {
            input.setValue("ต่างประเทศ");
        }
        addLogInfo("Customer search partial word \"ต่างประเทศ\"");

        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address_thai, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ตั้งค่า");
        } else {
            input.setValue("ตั้งค่า");
            context.back();
        }
        addLogInfo("Customer search other word \"ตั้งค่า\"");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_4).getText(), inter_address_thai, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ออดส์");
        } else {
            input.setValue("ออดส์");
        }
        addLogInfo("Customer search word \"ออดส์\"");

        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "ไม่พบผลการค้นหา", "Not Found International Address Menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        if (context.isAndroid()) {
            input.clear();
        }

        Thread.sleep(2000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "International Address Group", priority = 6)
    public void testSearchInternationalAddressSettingAndClickFromSearchInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("International Address: 10 search international address menu in Thai and click");
        addLogInfo("Start Testing");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ที่อยู่โอนเงินต่างประเทศ");
        } else {
            input.setValue("ที่อยู่โอนเงินต่างประเทศ");
        }
        addLogInfo("Customer search main word \"ที่อยู่โอนเงินต่างประเทศ\"");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address_thai, found_inter_address);
        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("Click on search result international address menu");
        Thread.sleep(10000);

        if (context.isIos()) {
            evaluateAssertEqualWithImg(context.findElementByAccessibilityId("โอนเงินต่างประเทศ").getText(), "โอนเงินต่างประเทศ", "Land to international address screen");
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON).click();
        } else {
            evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_TITLE).getText(), "โอนเงินต่างประเทศ", "Land to international address screen");
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON).click();
        }
        addLogInfo("Press back button international address menu");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), inter_address_thai, "Back to search result");

        if (context.isAndroid()) {
            input.clear();
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys(" ");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        changeLanguage("ภาษา", "ENG");
        addLogInfo("Change Language to English");

    }

    @Test(groups = "International Address Group", priority = 7)
    public void testClickToDailyTransactionLimitSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Daily Transaction Limit: 23,24 Click daily transaction limit menu and back");
        addLogInfo("Start Testing");
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).click();
        addLogInfo("Click daily transaction limit menu");
        checkPhraseDailyLimit();
        context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON).click();
        addLogInfo("Click back button '<' in daily transaction limit screen");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile no. menu ");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu ");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).isDisplayed(), "Display daily transaction limit menu ");
    }

    @Test(groups = "International Address Group", priority = 8)
    public void testSearchDailyTransactionLimitSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Daily Transaction Limit: 25,27,29,31 search daily transaction limit menu in English");
        addLogInfo("Start Testing");
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();

        context.getDriver().getKeyboard().sendKeys("Daily Limit");
        addLogInfo("Customer search main word \"Daily Limit\"");
        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("Daily");
        addLogInfo("Customer search partial word \"Daily\"");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("set up");
        addLogInfo("Customer search other word \"set up\"");

        if (context.isAndroid()) {
            context.back();
        }
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_4).getText(), daily_transaction_limit, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("odds team");
        addLogInfo("Customer search word \"odds team\"");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "No results found", "Not found daily transaction limit menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        addLogInfo("Clear search input");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu");
    }

    @Test(groups = "International Address Group", priority = 9)
    public void testSearchAndClickToDailyTransactionLimitSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Daily Transaction Limit: 32 search daily transaction limit menu and click");
        addLogInfo("Start Testing");
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("Daily Limit");
        addLogInfo("Customer search main word \"Daily Limit\"");
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).isDisplayed(), "Display Daily Transaction Limit");

        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("Click search result daily transaction limit menu");

        Thread.sleep(3000);
        checkPhraseDailyLimit();

        context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON).click();
        addLogInfo("Press back '<' button on daily transaction limit screen");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).isDisplayed(), "Display Daily Transaction Limit");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

    }

    @Test(groups = "International Address Group", priority = 10)
    public void testClickToDailyTransactionLimitSettingInThai() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Daily Transaction Limit: 33 click daily transaction limit menu then press back");
        addLogInfo("Start Testing");
        Thread.sleep(3000);
        changeLanguage("Language", "THAI");
        addLogInfo("Change language to thai");

        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).click();
        addLogInfo("click daily transaction limit menu");
        Thread.sleep(8000);
        context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON).click();
        addLogInfo("click back '<' button on daily transaction limit menu");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile no. menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).isDisplayed(), "Display Daily Transaction Limit menu");

    }

    @Test(groups = "International Address Group", priority = 11)
    public void testSearchDailyTransactionLimitSettingInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(10000);
        setScenario("Daily Transaction Limit: 26,28,30,31 search daily transaction limit menu in thai");
        addLogInfo("Start Testing");
        String searchInputt = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInputt));
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        addLogInfo("click search box");
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("วงเงินทำธุรกรรม");
        } else {
            input.setValue("วงเงินทำธุรกรรมต่อวัน");
        }
        addLogInfo("Customer search main word \"วงเงินทำธุรกรรมต่อวัน\"");

        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit_thai, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("วงเงิน");
        } else {
            input.setValue("วงเงิน");
        }
        addLogInfo("Customer search partial word \"วงเงิน\"");

        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit_thai, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ตั้งค่า");
        } else {
            input.setValue("ตั้งค่า");
            context.back();
        }
        addLogInfo("Customer search other word \"ตั้งค่า\"");

        Thread.sleep(2000);
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_6).getText(), daily_transaction_limit_thai, found_daily_transaction_limit);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ออดส์");
        } else {
            input.setValue("ออดส์");
        }
        addLogInfo("Customer search word \"ออดส์\"");
        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "ไม่พบผลการค้นหา", "Not Found Daily Transaction Limit Menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile no. menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu");
    }

    @Test(groups = "International Address Group", priority = 12)
    public void testSearchAndClickToDailyTransactionLimitSettingInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Daily Transaction Limit: 33 search daily transaction limit menu in thai and click");
        addLogInfo("Start Testing");
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("วงเงิน");
        } else {
            input.setValue("วงเงิน");
        }
        addLogInfo("Customer search main word \"วงเงิน\"");

        evaluateAssertEqualWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit_thai, "Found Daily Transaction Limit Menu");
        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("Click on search result daily transaction limit menu");

        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON).click();
        addLogInfo("Press back '<' button on daily transaction limit menu screen");
        evaluateAssertEqual(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), daily_transaction_limit_thai, "Found Daily Transaction Limit Menu");

        if (context.isAndroid()) {
            input.clear();
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys(" ");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        addLogInfo("clear search input");

        changeLanguage("ภาษา", "ENG");
        addLogInfo("change language to English");

        if (context.isAndroid()) {
            input.clear();
        }
        Thread.sleep(2000);
    }

    @Test(groups = "International Address Group", priority = 13)
    public void testClickToPinFreeTransactionLimitSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 36 click pin-free menu");
        addLogInfo("Start Testing");
        Thread.sleep(2000);
        if (context.isIos()) {
            scrollingToBottom(750, 600);
        }
        if (context.isAndroid()) {
            scrollingToBottom(750, 0);
        }
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
        addLogInfo("Click pin free menu");
        checkPhrasePinFree();
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON).click();
        addLogInfo("Click back '<' button on pin free screen");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).isDisplayed(), "Display pin-free menu");
    }

    @Test(groups = "International Address Group", priority = 14)
    public void testSearchPinFreeTransactionLimitSetting() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 37,39,41,43 search pin-free in English");
        addLogInfo("Start Testing");
        Thread.sleep(4000);
        if (context.isAndroid()) {
            context.back();
        }
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();

        context.getDriver().getKeyboard().sendKeys("Pin free");
        addLogInfo("Customer search main word \"Pin free\"");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("Pin");
        addLogInfo("Customer search partial word \"Pin\"");

        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("Set up");
        addLogInfo("Customer search other word \"Set up\"");

        if (context.isAndroid()) {
            context.back();
        }
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_5).getText().contains(pin_free), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("odds");
        addLogInfo("Customer search word \"odds\"");

        evaluateAssertEqual(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "No results found", "Not Found pin free menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        addLogInfo("Clear search result");


        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile no. menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu");
    }

    @Test(groups = "International Address Group", priority = 15)
    public void testSearchAndClickToPinFreeTransactionLimitSetting() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 44,45 search pin-free in and click");
        addLogInfo("Start Testing");
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        context.getDriver().getKeyboard().sendKeys("Pin free");
        addLogInfo("search pin free in english");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free), found_pin_free);

        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("click on search result pin-free menu");

        Thread.sleep(5000);
        checkPhrasePinFree();

        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON).click();
        addLogInfo("press back '<' button on search result pin-free menu");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free), found_pin_free);

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys(" ");
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
            addLogInfo("clear search result");
        }
        changeLanguage("Language", "THAI");
        addLogInfo("changed language to thai");

    }

    @Test(groups = "International Address Group", priority = 16)
    public void testClickToPinFreeTransactionLimitSettingInThai() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 36 click pin-free in thai then press back");
        addLogInfo("Start Testing");
        Thread.sleep(4000);
        if (context.isIos()) {
            scrollingToBottom(750, 600);
        } else {
            scrollingToBottom(900, 0);
        }
        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
        addLogInfo("Click pin free menu");

        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON).click();
        addLogInfo("Press back '<' button on pin free screen");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).isDisplayed(), "Display pin free menu");
    }

    @Test(groups = "International Address Group", priority = 17)
    public void testSearchPinFreeTransactionLimitSettingInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 38,40,42,43 search pin-free in thai");
        addLogInfo("Start Testing");
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        Thread.sleep(4000);
        if (context.isAndroid()) {
            context.back();
        }
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Thread.sleep(5000);

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        addLogInfo("Click on search box");

        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));

        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ตั้งค่าการทำธุรกรรม");
        } else {
            input.setValue("ตั้งค่าการทำธุรกรรม");
        }
        addLogInfo("Customer search main word \"ตั้งค่าการทำธุรกรรม\"");

        Thread.sleep(3000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains(pin_free_thai), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ธุรกรรม");
        } else {
            input.setValue("ธุรกรรม");
        }
        addLogInfo("Customer search partial word \"ธุรกรรม\"");

        Thread.sleep(3000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains(pin_free_thai), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ตั้งค่ารหัส");
        } else {
            input.setValue("ตั้งค่ารหัส");
        }
        addLogInfo("Customer search other word \"ตั้งค่ารหัส\"");

        Thread.sleep(2000);
        if (context.isIos()) {
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains(pin_free_thai), found_pin_free);
        }
        if (context.isAndroid()) {
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free_thai), found_pin_free);
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }

        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ออดส์");
        } else {
            input.setValue("ออดส์");
        }
        addLogInfo("Customer search word \"ออดส์\"");

        Thread.sleep(2000);
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText().contains("ไม่พบผลการค้นหา"), "Not Found PIN-Free Transaction Limit Menu");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        if (context.isAndroid()) {
            input.clear();
        }
        addLogInfo("Clear search input");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed(), "Display mobile no. menu");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed(), "Display email menu");
    }

    @Test(groups = "International Address Group", priority = 18)
    public void testSearchAndClickToPinFreeTransactionLimitSettingInThai() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Pin free transaction limit: 40.search pin-free in thai then click");
        addLogInfo("Start Testing");
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        addLogInfo("click on search box");

        if (context.isIos()) {
            context.getDriver().getKeyboard().sendKeys("ตั้งค่ารหัส");
        } else {
            input.setValue("ตั้งค่ารหัส");
        }
        addLogInfo("Customer search main word \"ตั้งค่ารหัส\" ");

        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free_thai), found_pin_free);
        context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        addLogInfo("Click search result pin free menu");

        Thread.sleep(5000);

        context.findElement(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON).click();
        addLogInfo("Press back '<' button on pin free screen");

        Thread.sleep(2000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(pin_free_thai), found_pin_free);

        Thread.sleep(2000);
        if (context.isAndroid()) {
            input.clear();
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys(" ");
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
            addLogInfo("clear search result");
        }
        addLogInfo("Clear search input");

        changeLanguage("ภาษา", "ENG");
        addLogInfo("Changed language to English");

    }

    @Test(groups = "International Address Group", priority = 19)
    public void testClickBackOnAndroidInternationalTransferAddress() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            setScenario("Pin free transaction limit: click back android device in international address screen");
            addLogInfo("Start Testing");
            Thread.sleep(2000);
            context.findElement(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU).click();
            addLogInfo("Click international address menu");
            Thread.sleep(10000);
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_EDIT_BUTTON).click();
            addLogInfo("Click edit button");
            Thread.sleep(10000);
            context.back();
            addLogInfo("Press back on Android device");
            Thread.sleep(5000);
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET).click();
            Thread.sleep(2000);
            context.findElement(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON).click();
            addLogInfo("Click back '<' button");
            Thread.sleep(2000);
        }
    }

    @Test(groups = "International Address Group", priority = 20)
    public void testClickBackOnAndroidDailyLimit() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            setScenario("Pin free transaction limit: click back android device in daily limit screen");
            addLogInfo("Start Testing");
            Thread.sleep(2000);
            context.findElement(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU).click();
            addLogInfo("Click daily transaction limit menu");
            Thread.sleep(10000);
            checkPhraseDailyLimit();
            context.back();
            addLogInfo("Press back on Android device");
        }

    }

    @Test(groups = "International Address Group", priority = 21)
    public void testClickBackOnAndroidPinfree() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            setScenario("Pin free transaction limit: click back android device in Pin free screen");
            addLogInfo("Start Testing");
            Thread.sleep(2000);
            scrollingToBottom(750, 0);
            context.findElement(OneAppElementKeys.SETTING_PIN_FREE_MENU).click();
            addLogInfo("Click Pin free menu");
            Thread.sleep(10000);
            checkPhrasePinFree();
            context.back();
            addLogInfo("Press back on Android device");

        }
    }

    public void checkPhraseDailyLimit() throws IOException {
        TtbTestContext context = getTtbTestContext();
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_TITLE).isDisplayed(), "checked title phrase");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DETAIL).isDisplayed(), "checked detail phrase");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DOMESTIC).isDisplayed(), "checked detail phrase");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_INTERNATIONAL).isDisplayed(), "checked detail phrase");
    }

    public void checkPhrasePinFree() throws IOException {
        TtbTestContext context = getTtbTestContext();
        evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_TITLE).isDisplayed(), "checked title phrase");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_DETAIL).isDisplayed(), "checked detail phrase");
    }

    public void pressPinLogin(String pins) {
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

    public void changeLanguage(String currentLanguage, String newLanguage) throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
        if (context.isAndroid()) {
            input.clear();
            input.setValue(currentLanguage);
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), currentLanguage);
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        } else {
            context.getDriver().getKeyboard().sendKeys(currentLanguage);
            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText().contains(currentLanguage));
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        }
        context.findElement("CHANGE_LANG_" + newLanguage + "_BUTTON").click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON).click();
        Thread.sleep(3000);
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys(" ");
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
            input.clear();
        }
        Thread.sleep(2000);
    }
}
