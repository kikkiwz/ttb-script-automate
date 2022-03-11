package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyPersonalInformationScenario extends BaseScenario {

    @Test(groups = "Verify Personal Information Group", priority = 2)
    public void testEnterIncorrectCitizenFotomat() {
        navigateToActivationScreen(OneAppElementKeys.TRANSFER_BUTTON);

        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();

        enterValueToTextField("111111");
        Assert.assertFalse(ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).isEnabled());

        enterValueToTextField("1111111111111");
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        Assert.assertEquals(getText(OneAppElementKeys.BOTTOMSHEET_TITLE), "Incorrect citizen ID number");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(getText(OneAppElementKeys.INPUT_RM_FIELD), "Citizen ID number");
        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.INPUT_ERROR_INLINE).isDisplayed());
    }

//    @Test(groups = "Verify Personal Information Group", priority = 2)
//    public void testActivateShouldNavigateToProductOptionWhenCustomerStatusInactive() {
//        navigateToActivationScreen(OneAppElementKeys.TRANSFER_BUTTON);
//
//        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
//        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
//
//        enterValueToTextField(OneAppElementKeys.INPUT_RM_FIELD, "111111");
//        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
//    }

    @Test(groups = "Verify Personal Information Group", priority = 1)
    public void testActivateShouldNavigateToPassportBlockScreen() {
        navigateToActivationScreen(OneAppElementKeys.TRANSFER_BUTTON);

        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();

        ttbTestContext.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        enterValueToTextField("passport");
        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).isEnabled());
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE);
        Assert.assertEquals(getText(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE), "Registration Failed");
        ttbTestContext.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.HOME_CONTAINER);
    }

    public void navigateToActivationScreen(String item) {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ttbTestContext.findElement(item).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
    }

    private void enterValueToTextField(String value) {
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(value);
        ttbTestContext.findElement(OneAppElementKeys.HEADER_SCREEN_TITLE).click();
    }

    private String getText(String elementName) {
        return ttbTestContext.findElement(elementName).getText();
    }

}
