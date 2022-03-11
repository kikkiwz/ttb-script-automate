package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ForgotPinScenario extends BaseScenario {

    String correctPin = "070809";
    String duplicate3lastPin = "010203";
    String citizenId = "";

    public void getCitizenId() {
        citizenId = (String) getTtbTestContext().getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
    }

    @Test(groups = "Forgot pin Group", priority = 1)
    public void testCustomerClickForgotPinInModalLogin() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        getCitizenId();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "1 / 4");
        }
        Thread.sleep(1000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Fill in personal information");

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
        } else {
            context.findElement(OneAppElementKeys.FORGOT_PIN_BACK_BUTTON).click();
        }

        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();

        if (context.isAndroid()) {
            context.back();
            context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
            context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();
        }
    }

    @Test(groups = "Forgot pin Group", priority = 2)
    public void testIncorrectCitizen() {
        checkInputCitizenIdNo("1111111111111");
    }

    @Test(groups = "Forgot pin Group", priority = 3)
    public void testCorrectCitizenNotMatchRMInDevice() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        closeBottomSheetUnableProceed();
        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        checkInputCitizenIdNo("4016655325041");
    }

    @Test(groups = "Forgot pin Group", priority = 4)
    public void testIncorrectPassport() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("A12345");
            if (context.isAndroid()) {
                context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
            }
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            String bottomSheetTitle = context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText();
            Assert.assertEquals(bottomSheetTitle, "Incorrect passport number");
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("A12345");
            if (context.isAndroid()) {
                context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
            } else {
                context.findElement(OneAppElementKeys.KEYBOARD_DONE_BUTTON).click();
            }
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
            Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

            if (context.isAndroid()) {
                context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
                context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("A12345");
                context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
                context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
                context.waitUntilVisible(OneAppElementKeys.BOTTOM_SHEET_TITLE);
                context.back();
                Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            }
        }
    }

    @Test(groups = "Forgot pin Group", priority = 5)
    public void testCorrectCitizenNavigateToOtpScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        closeBottomSheetUnableProceed();

        String citizenId = (String) context.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "2 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
            context.back();
        } else {
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        }
        Thread.sleep(2000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
    }


    @Test(groups = "Forgot pin Group", priority = 6)
    public void testForgotPinShowVerifyOTPScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText(), "Verify mobile number");
        Assert.assertEquals(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).getText(), "Resend OTP");
    }

    @Test(groups = "Forgot pin Group", priority = 7)
    public void testForgotPinShouldCancelInVerifyOTPScreenAndStayOnPage() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).click();

        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE).getText(), "Confirm to leave");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL).getText(), "Any unsaved changes will be lost, are you sure you want to leave this page?");
        Assert.assertEquals(context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        Assert.assertEquals(context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText(), "Verify mobile number");
        Assert.assertEquals(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).getText(), "Resend OTP");

    }

    @Test(groups = "Forgot pin Group", priority = 8)
    public void testForgotPinShouldCancelInVerifyOTPScreenAndLeavePage() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE).getText(), "Confirm to leave");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL).getText(), "Any unsaved changes will be lost, are you sure you want to leave this page?");
        Assert.assertEquals(context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        Assert.assertEquals(context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.PAY_BILL_BUTTON).isDisplayed());
    }

    @Test(groups = "Forgot pin Group", priority = 9)
    public void testCheckErrorInlineWhenFillsWrongOtpAndShowMaxAttemptScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();
        getCitizenId();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.STEPPER_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
        }
        if (context.isIos()) {
            context.findElement(OneAppElementKeys.OTP_HEADER);
        }
        context.getDriver().getKeyboard().sendKeys("123456");
        Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(), "Incorrect OTP. You have 2 attempts left.");
        context.getDriver().getKeyboard().sendKeys("444444");
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(), "Incorrect OTP. You have 1 attempt left.");
        context.getDriver().getKeyboard().sendKeys("555555");
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(), "OTP attempt limit reached");
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).getText(), "OK");
            context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
        }
        if (context.isIos()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ATTEMPT_LIMIT_TITLE).getText(), "OTP attempt limit reached");
            Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ATTEMPT_LIMIT_DETAIL).getText(), "You have reached the maximum number of attempts. Please try again later.");
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK).getText(), "OK");
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK).click();
        }
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
        Assert.assertTrue(context.findElement(OneAppElementKeys.PAY_BILL_BUTTON).isDisplayed());
    }

    // take time too much
    @Test(groups = "Forgot pin Group", priority = 10)
    public void testCheckErrorInlineWhenOTPHasExpired() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);

        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        Thread.sleep(35000);
        context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(40000);
        context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().sendKeys("2");
        Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(), "OTP code has expired.");

    }

    @Test(groups = "Forgot pin Group", priority = 11)
    public void testClickResendOTPThirdTimesAndDisabledResendButton() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);
        Thread.sleep(35000);
        context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled());

        Thread.sleep(35000);
        context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled());

        Thread.sleep(35000);
        context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).click();
        Assert.assertFalse(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled());

        Thread.sleep(35000);
        Assert.assertFalse(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled());
    }

    @Test(groups = "Forgot pin Group", priority = 12)
    public void testSetNewPinClickCancelShouldDisplayBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).click();
        navigateFromHomeToSetNewPinScreen();
        context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");

        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            context.back();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Forgot pin Group", priority = 13)
    public void testSetPinClickButtonPinRequirementShouldDisplayBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
            context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        } else {
            context.waitUntilVisible(OneAppElementKeys.SET_NEW_PIN_REQUIREMENTS_BUTTON);
            context.findElement(OneAppElementKeys.SET_NEW_PIN_REQUIREMENTS_BUTTON).click();
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "PIN Requirements");
        String bottomSheetDesc = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        Assert.assertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"));
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "OK, Got it");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            context.back();
        } else {
            context.findElement(OneAppElementKeys.SET_NEW_PIN_REQUIREMENTS_BUTTON).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Forgot pin Group", priority = 14)
    public void testSetPinConfirmLeavePageShouldNavigateToFirstScreen() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.HOME_TAB).isDisplayed());
        navigateFromHomeToSetNewPinScreen();
    }

    @Test(groups = "Forgot pin Group", priority = 15)
    public void testSetPinDoNotAlignPinRequirement() {
        TtbTestContext context = getTtbTestContext();
        pressPin("123456");
        context.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE);
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "Your PIN does not meet the security requirement. Please try again.");
    }

    @Test(groups = "Forgot pin Group", priority = 16)
    public void testSetPinNavigateToConfirmPinScreen() {
        TtbTestContext context = getTtbTestContext();
        pressPin(correctPin);
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "4 / 4");
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Confirm new PIN");
    }

    @Test(groups = "Forgot pin Group", priority = 17)
    public void testConfirmPinClickCancelShouldDisplayBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            context.back();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Forgot pin Group", priority = 18)
    public void testConfirmPinClickBackOrArrowBackShouldNavigateToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
        }
        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");
        pressPin(correctPin);
    }

    @Test(groups = "Forgot pin Group", priority = 19)
    public void testConfirmPinConfirmLeavePageShouldNavigateToHomeAndNavigateToConfirmPinWithPIN070809() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.HOME_TAB).isDisplayed());
        navigateFromHomeToConfirmPinScreen();
    }

    @Test(groups = "Forgot pin Group", priority = 20)
    public void testConfirmNewPinEnterPinDifferenceFromSetNewPin() {
        TtbTestContext context = getTtbTestContext();
        pressPin("123456");
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "PINs do not match. Please try again.");
        context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
    }

    @Test(groups = "Forgot pin Group", priority = 21)
    public void testConfirmNewPinEnterPinDuplicate3lastPin() {
        TtbTestContext context = getTtbTestContext();
        pressPin(duplicate3lastPin);
        pressPin(duplicate3lastPin);
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "Your PIN cannot be the same as one of your last three PINs. Please try again.");
    }

    @Test(groups = "Forgot pin Group", priority = 22)
    public void testConfirmNewPinEnterPinMatchWithSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        pressPin(correctPin);
        pressPin(correctPin);
        String changePinCompleteTitle = context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText();
        Assert.assertEquals(changePinCompleteTitle, "PIN Successfully Changed");
    }

    @Test(groups = "Forgot pin Group", priority = 23)
    public void testSuccessScreenToHome() {
        TtbTestContext context = getTtbTestContext();
        String changePinCompleteTitle = context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText();
        Assert.assertEquals(changePinCompleteTitle, "PIN Successfully Changed");
        context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
    }

    public void checkInputCitizenIdNo(String citizen) {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        String bottomSheetTitle = context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText();
        Assert.assertEquals(bottomSheetTitle, "Incorrect citizen ID number");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        if (context.isAndroid()) {
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            Assert.assertEquals(context.findElement(OneAppElementKeys.INPUT_ERROR_INLINE).getText(), "Incorrect citizen ID number, please try again");
        }

        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        if (context.isAndroid()) {
            Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOM_SHEET_TITLE);
            context.back();
            Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    public void testCancelButtonDisplayBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Confirm to leave");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Any unsaved changes will be lost, are you sure you want to leave this page?");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Leave Page");
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void closeBottomSheetUnableProceed() {
        TtbTestContext context = getTtbTestContext();
        List<WebElement> bottomSheet = context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD);
        if (!bottomSheet.isEmpty()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(), "Unable to proceed further");
            context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        }
    }

    public void navigateFromHomeToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(), "Enter PIN");
        context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON).click();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        context.waitUntilVisible(OneAppElementKeys.INPUT_RM_FIELD);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
            context.waitUntilVisible(OneAppElementKeys.STEPPER_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "2 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
            context.getDriver().getKeyboard().sendKeys("111111");
            context.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
        } else {
            context.findElement(OneAppElementKeys.KEYBOARD_DONE_BUTTON).click();
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
            context.getDriver().getKeyboard().sendKeys("111111");
            context.waitUntilVisible(OneAppElementKeys.SET_NEW_PIN_REQUIREMENTS_BUTTON);
        }
    }

    public void navigateFromHomeToConfirmPinScreen() {
        navigateFromHomeToSetNewPinScreen();
        pressPin(correctPin);
    }

    public void selectDataOnlyInternetConnection() throws InterruptedException {
        long connectType = ((AndroidDriver<?>) driver).getConnection().getBitMask();
        switch ((int) connectType) {
            case 0:
            case 1:
                enableDataNetWorkAndroid(true);
                break;
            case 2:
                enableWifiAndroid(false);
                enableDataNetWorkAndroid(true);
            case 4:
            case 6:
                enableWifiAndroid(false);
                enableDataNetWorkAndroid(true);
        }
    }

}
