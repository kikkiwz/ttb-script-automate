package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ChangePinScenario extends BaseScenario {

    @Test(groups = "ChangePin Group", priority = 1)
    public void testSearchChangePinMenuByMainWordSameLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        pressPinLogin("010203");
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("Change PIN");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("Change PIN");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 2)
    public void testSearchChangePinMenuByMainWordDifferentLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("เปลี่ยนรหัส");

            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("เปลี่ยนรหัส");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 3)
    public void testSearchChangePinMenuByOtherWordSameLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("Security");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("Security");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 4)
    public void testSearchChangePinMenuByOtherWordDifferentLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("รหัสผ่าน");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("รหัสผ่าน");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 5)
    public void testSearchChangePinMenuByPartialWordSameLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("curity");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("curity");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 6)
    public void testSearchChangePinMenuByPartialWordDifferentLanguageENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("รหัส");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "Change PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("รหัส");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("Change PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 7)
    public void testSearchChangePinMenuNoResultSameLanguageENShouldShowNoResultFound() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("ODDS TEAM");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_NO_RESULT).getText(), "No results found");
        } else {
            context.getDriver().getKeyboard().sendKeys("ODDS TEAM");

            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "No results found");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 8)
    public void testSearchChangePinMenuNoResultDifferentLanguageENShouldShowNoResultFound() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("ชาวออดส์");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_NO_RESULT).getText(), "No results found");
        } else {
            context.getDriver().getKeyboard().sendKeys("ชาวออดส์");

            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "No results found");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 9)
    public void testCustomerClickChangePinMenuOnSettingScreenENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(4000);
        scrollToBottom();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
    }

    @Test(groups = "ChangePin Group", priority = 10)
    public void testCustomerClickChangePinMenuOnSearchENShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("Change PIN");
            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        } else {
            context.getDriver().getKeyboard().sendKeys("Change PIN");
            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
    }

    @Test(groups = "ChangePin Group", priority = 11)
    public void testChangeLanguageToThai() throws InterruptedException {
        changeLanguage("Language", "THAI");
    }

    @Test(groups = "ChangePin Group", priority = 12)
    public void testSearchChangePinMenuByMainWordSameLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("เปลี่ยนรหัส PIN");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("เปลี่ยนรหัส PIN");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 13)
    public void testSearchChangePinMenuByMainWordDifferentLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("Change PIN");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("Change PIN");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 14)
    public void testSearchChangePinMenuByOtherWordMainLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("รหัส");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("รหัส");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 15)
    public void testSearchChangePinMenuByOtherWordDifferentLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("pin");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("pin");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 16)
    public void testSearchChangePinMenuByPartialWordSameLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("รหั");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("รหั");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 17)
    public void testSearchChangePinMenuByPartialWordDifferentLanguageTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("pi");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText(), "เปลี่ยนรหัส PIN");
        } else {
            context.getDriver().getKeyboard().sendKeys("pi");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_INDEX_1).getText().contains("เปลี่ยนรหัส PIN"));
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 18)
    public void testSearchChangePinMenuNoResultSameLanguageTHShouldShowNoResultFound() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("ลูกออดส์");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_NO_RESULT).getText(), "ไม่พบผลการค้นหา");
        } else {
            context.getDriver().getKeyboard().sendKeys("ลูกออดส์");

            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "ไม่พบผลการค้นหา");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 19)
    public void testSearchChangePinMenuNoResultDifferentLanguageTHShouldShowNoResultFound() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("ODDE");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_SEARCH_NO_RESULT).getText(), "ไม่พบผลการค้นหา");
        } else {
            context.getDriver().getKeyboard().sendKeys("ODDE");

            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT).getText(), "ไม่พบผลการค้นหา");
        }
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_MOBILE_NO_MENU).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.SETTING_EMAIL_MENU).isDisplayed());
    }

    @Test(groups = "ChangePin Group", priority = 20)
    public void testCustomerClickChangePinMenuOnSettingScreenTHShouldShowChangePINMenu() {
        TtbTestContext context = getTtbTestContext();
        scrollToBottom();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "ใส่รหัส PIN ปัจจุบัน");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
    }

    @Test(groups = "ChangePin Group", priority = 21)
    public void testCustomerClickChangePinMenuOnSearchTHShouldShowChangePINMenu() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("เปลี่ยนรหัส PIN");
            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        } else {
            context.getDriver().getKeyboard().sendKeys("เปลี่ยนรหัส PIN");

            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "ใส่รหัส PIN ปัจจุบัน");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
    }

    @Test(groups = "ChangePin Group", priority = 22)
    public void testChangeLanguageToEnglish() throws InterruptedException {
        changeLanguage("ภาษา", "ENG");
    }

    @Test(groups = "ChangePin Group", priority = 23)
    public void testEnterCurrentPinScreenUserClickForgotPinShouldNavigateToPersonalInfoScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        scrollToBottom();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_FORGOT_PIN_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "1 / 4");
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Fill in personal information");
        context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
    }

    @Test(groups = "ChangePin Group", priority = 24)
    public void testEnterCurrentPinScreenUserPressCorrectPinShouldNavigateToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
    }

    @Test(groups = "ChangePin Group", priority = 25)
    public void testSetNewPinScreenUserPressPINRequirementsButtonShouldShowPINRequirementsBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "PIN requirements");
        String bottomSheetDesc = context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        Assert.assertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"));
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "OK, Got it");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON).click();

    }

    @Test(groups = "ChangePin Group", priority = 26)
    public void testSetNewPinScreenUserEnterSequentialNumberShouldDisplayErrorInline() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("123456");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Your PIN does not meet the security requirement. Please try again.");

    }

    @Test(groups = "ChangePin Group", priority = 27)
    public void testSetNewPinScreenUserEnterRepeatNumberShouldDisplayErrorInline() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(4000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("000398");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Your PIN does not meet the security requirement. Please try again.");
    }

    @Test(groups = "ChangePin Group", priority = 28)
    public void testSetNewPinScreenUserEnterNumberSameAsCurrentPinOrSameAs2LastPinShouldDisplayErrorInline() {
        TtbTestContext context = getTtbTestContext();
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "Your PIN cannot be the same as one of your last three PINs. Please try again.");
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 29)
    public void testSetNewPinScreenUserEnterNumberWhichDifferentFromLast3PinShouldNavigateToConfirmSetNewPinScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN("010203");
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("070809");
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 30)
    public void testSetNewPinScreenUserEnterBackwardSequentialNumberShouldNavigateToConfirmSetNewPinScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(4000);
        pressPinChangePIN("654321");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 31)
    public void testSetNewPinScreenUserEnterLessThan3DigitsRepeatNumberShouldNavigateToConfirmSetNewPinScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(4000);
        pressPinChangePIN("112233");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 32)
    public void testSetNewPinScreenUserClickCancelButtonShouldShowConfirmCancelBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 33)
    public void testSetNewPinScreenUserPressStayOnPagePageButtonShouldRemainToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
    }

    @Test(groups = "ChangePin Group", priority = 34)
    public void testSetNewPinScreenUserPressLeavePageButtonShouldNavigateToSettingListsScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 35)
    public void testConfirmNewPinScreenPressDifferentNumberFromSetNewPinScreenShouldDisplayErrorInline() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN("010203");
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("070809");
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        pressPinChangePIN("088088");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText(), "PINs do not match. Please try again.");
    }

    @Test(groups = "ChangePin Group", priority = 36)
    public void testConfirmNewPinScreenClickCancelButtonShouldShowConfirmCancelBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON).click();
    }

    @Test(groups = "ChangePin Group", priority = 37)
    public void testConfirmNewPinScreenClickLeavePageButtonShouldNavigateToSettingListScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
    }

    @Test(groups = "ChangePin Group", priority = 38)
    public void testConfirmNewPinScreenClickStayOnPageButtonShouldRemainToConfirmNewPinScreenThenPressBackShouldNavigateToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("070809");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON).click();
        context.findElement(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
    }

    @Test(groups = "ChangePin Group", priority = 39)
    public void testCompleteScreenCustomerClickReturnToHomeButtonShouldNavigateToHomeScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
        context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN("010203");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN("302010");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        pressPinChangePIN("302010");
        //success page
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "PIN Successfully Changed");
        context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.PAY_BILL_BUTTON).isDisplayed());

    }

    @Test(groups = "ChangePin Group", priority = 40)
    public void testCompleteScreenCustomerClickContinueSettingButtonShouldNavigateToSettingListsScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        String changePin1st = "302010";
        String changePin2nd = "001122";
        context.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        context.findElement(OneAppElementKeys.MORE_BUTTON).click();
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        Thread.sleep(4000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue("Change PIN");
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), "Change PIN");
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        } else {
            context.getDriver().getKeyboard().sendKeys("Change PIN");

            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains("Change PIN"));
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        }
        pressPinChangePIN(changePin1st);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        pressPinChangePIN(changePin2nd);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        pressPinChangePIN(changePin2nd);
        //success page
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "PIN Successfully Changed");
        context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        Thread.sleep(4000);
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
            context.getDriver().getKeyboard().sendKeys("Change PIN");
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
            Thread.sleep(4000);
            pressPinChangePIN("088099");
            Thread.sleep(4000);
            pressPinChangePIN("088099");
            context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON).click();
            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
        }
    }

    @Test(groups = "ChangePin Group", priority = 41)
    public void testEnterCurrentPinScreenPressBackAndroidDeviceShouldGoBackToSettingListScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            scrollToBottom();
            Thread.sleep(4000);
            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
            context.back();
            context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        }
    }

    @Test(groups = "ChangePin Group", priority = 42)
    public void testEnterCurrentPinScreenClickForgotPinBtnThenPressBackAndroidDeviceShouldGoBackToEnterCurrentPinScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
            context.findElement(OneAppElementKeys.CHANGE_PIN_FORGOT_PIN_BUTTON).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "1 / 4");
            Thread.sleep(1000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Fill in personal information");
            context.back();
            context.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_SUB_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
        }
    }

    @Test(groups = "ChangePin Group", priority = 43)
    public void testSetNewPinScreenPressBackAndroidDeviceShouldNotGoToAnyScreen() {
        TtbTestContext context = getTtbTestContext();
        //This PIN should be same as case 40
        String changePin2nd = "001122";
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Enter current PIN");
            pressPinChangePIN(changePin2nd);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        }
    }

    @Test(groups = "ChangePin Group", priority = 44)
    public void testSetNewPinScreenClickPinRequirementBtnThenPressBackAndroidDeviceShouldRemainToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "PIN requirements");
            String bottomSheetDesc = context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
            Assert.assertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"));
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        }
    }

    @Test(groups = "ChangePin Group", priority = 45)
    public void testConfirmNewPinScreenPressBackAndroidDeviceShouldGoBackToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            String changePin3rd = "088099";
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
            pressPinChangePIN(changePin3rd);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
            context.back();
            context.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_SUB_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Set new 6-digit PIN");
        }
    }

    @Test(groups = "ChangePin Group", priority = 46)
    public void testConfirmNewPinScreenClickCancelBtnThenPressBackAndroidDeviceShouldGoBackToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            String changePin3rd = "088099";
            pressPinChangePIN(changePin3rd);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
            context.findElement(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE).getText(), "Confirm to leave");
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUB_TITLE).getText(), "Confirm new PIN");
        }
    }

    @Test(groups = "ChangePin Group", priority = 47)
    public void testChangePinSuccessScreenPressBackAndroidDeviceShouldNotGoToAnyScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            String changePin3rd = "088099";
            pressPinChangePIN(changePin3rd);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "PIN Successfully Changed");
            context.back();
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "PIN Successfully Changed");
            context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON).click();
        }
    }

    @Test(groups = "ChangePin Group", priority = 48)
    public void testChangePinTo010203() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String changePin3rd = "088099";
        String originalPin = "010203";
        context.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_TITLE).getText(), "Settings");
        scrollToBottom();
        context.findElement(OneAppElementKeys.SETTING_CHANGE_PIN_MENU).click();
        pressPinChangePIN(changePin3rd);
        Thread.sleep(4000);
        pressPinChangePIN(originalPin);
        Thread.sleep(4000);
        pressPinChangePIN(originalPin);
        Thread.sleep(4000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "PIN Successfully Changed");
        context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
    }

    public void pressPinLogin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void pressPinChangePIN(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            if (context.isAndroid()) {
                context.findElement("CHANGE_PIN_" + pins.charAt(i) + "_BUTTON").click();
            } else {
                context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
            }
        }
    }

    public void changeLanguage(String currentLanguage, String newLanguage) throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        String searchInput = "com.ttbbank.oneapp.vit:id/searchInput";
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT).click();
        if (context.isAndroid()) {
            MobileElement input = (MobileElement) driver.findElement(By.id(searchInput));
            input.setValue(currentLanguage);
            Thread.sleep(4000);
            Assert.assertEquals(context.findElement(OneAppElementKeys.SETTING_INDEX_0).getText(), currentLanguage);
            context.findElement(OneAppElementKeys.SETTING_INDEX_0).click();
        } else {
            context.getDriver().getKeyboard().sendKeys(currentLanguage);
            Thread.sleep(4000);
            Assert.assertTrue(context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).getText().contains(currentLanguage));
            context.findElement(OneAppElementKeys.SEARCH_SETTINGS_LIST).click();
        }
        context.findElement("CHANGE_LANG_" + newLanguage + "_BUTTON").click();
        context.findElement(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON).click();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON).click();
    }

}
