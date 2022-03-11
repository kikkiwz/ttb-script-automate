package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivationScenario extends BaseScenario {

    @Test(groups = "Reactivation Group")
    public void testCustomerActiveUserRememberPinReactivateWithPushNotificationOn() {
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
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
        }
    }

    @Test(groups = "Reactivation Group")
    public void testCustomerActiveUserRememberPinReactivateWithPushNotificationOff() {
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
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_PUSH_NOTIFICATION_TOGGLE).click();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
        }
    }

    @Test(groups = "Reactivation Group")
    public void testCustomerCancelReactivationOnEnterCurrentPinShouldShowScreenThatClickRegister() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_LEAVE_PAGE).click();
        }

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText();
        Assert.assertEquals(pageTitle, "My Account");
        String productIntroTitle = ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText();
        Assert.assertEquals(productIntroTitle, "ttb deposit account");
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION).getText();
        Assert.assertTrue(registerButtonText.contains("Register ttb touch"));
    }

    @Test(groups = "Activation Group")
    public void testActivationShouldDisplayDisableWifiBottomSheetWhenWifiIsOn() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("4366443376021");
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Disable wifi");
        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Please disable wifi and enable mobile data to continue in this process.");
        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Go to Wifi settings");
    }
}
