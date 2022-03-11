package com.ttbbank.oneapp.scenario.platform1;

import android.inputmethodservice.Keyboard;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnlockPinScenario extends Platform1Base {

    String citizenId = "";

    public void getCitizenId() {
        citizenId = (String) getTtbTestContext().getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        System.out.println("Get citizen ID: " + citizenId);
    }

    @Test(groups = "Unlock pin Group", priority = 1, enabled = false)
    public void testClickResetPinOnPinLockScreen() throws IOException {
        setScenario("1. Customer clicks \"Reset PIN\"");
        TtbTestContext context = getTtbTestContext();
        //getCitizenId();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();
        if (context.isAndroid()) {
            evaluateAssertEqual(OneAppElementKeys.STEPPER_PROGRESS, "1 / 4");
        }
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(),
                "Fill in personal information",
                "Navigate to reset PIN flow"
        );

        evaluateAssertTrue(
                context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).isEnabled(),
                "'Next' button is disable"
        );

        createScreenShot("ENTER_CID_NEXT_BUTTON", true);

        setScenario("2. Customer click '<'");
        context.findElement(OneAppElementKeys.BUTTON_BACK_VERIFY_PERSONAL).click();
        evaluateAssertTrueWithImg(
                context.findElement(OneAppElementKeys.PINLOCK_TITLE).isDisplayed(),
                "Back to PIN lock screen (full page)"
        );

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
            context.back();
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.PINLOCK_TITLE).isDisplayed(), "PINLOCK_TITLE");
        }
    }

    @Test(groups = "Unlock pin Group", priority = 2, enabled = false)
    public void testIncorrectCitizen() throws InterruptedException, IOException {
        setScenario("3. Test incorrect citizen Id");
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON);
        context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();
        checkInputCitizenIdNo("1111111111111");
    }

    @Test(groups = "Unlock pin Group", priority = 3, enabled = false)
    public void testCorrectCitizenNotMatchRMInDevice() throws InterruptedException, IOException {
        setScenario("4. Test citizen Id not match with RM");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        if (context.isAndroid()) {
            selectDataOnlyInternetConnection();
        }
        checkInputCitizenIdNo("4062655748851");
    }

    @Test(groups = "Unlock pin Group", priority = 4, enabled = false)
    public void testIncorrectPassport() throws InterruptedException, IOException {
        setScenario("34. test incorrect passport?");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("AA2000211");
        if (context.isAndroid()) {
            selectDataOnlyInternetConnection();
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
        } else {
            context.findElement(OneAppElementKeys.KEYBOARD_DONE_BUTTON).click();
        }

        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Incorrect passport number",
                "Found incorrect passport number"
        );

        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());

        addLogInfo("Take screen capture inline error!");
        createScreenShot("Display inline error message", true);

        //context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        /*
            Do we need this?
        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("787878aa");
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
        } else {
            context.findElement(OneAppElementKeys.KEYBOARD_DONE_BUTTON).click();
        }
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        */

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("A12345");
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOM_SHEET_TITLE);
            context.back();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Unlock pin Group", priority = 5, enabled = false)
    public void testPassportWifiEnableShouldDisplayDisableWifi() throws InterruptedException, IOException {
        setScenario("35. Check wifi");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            enableWifiAndroid(true);
        }
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        touchVerifyPersonalInfoTextField(context);
        //context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("a1234");
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();
        } else {
            context.findElement(OneAppElementKeys.KEYBOARD_DONE_BUTTON).click();
        }
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(),
                "Disable wifi",
                "Display bottom sheet to disable wifi"
        );

        //Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Disable wifi");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText(), "Please disable wifi and enable mobile data to continue in this process.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "Go to Wifi settings");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        //Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        evaluateAssertEqual(
                context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD),
                Collections.emptyList(),
                "Back to fill in personal information screen"
        );

        createScreenShot("Back to fill in personal information", true);

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys("aa2000211");
            context.findElement(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT).click();

            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            context.back();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Unlock pin Group", priority = 7, enabled = false)
    public void testCorrectCitizenNavigateToOtpScreen() throws InterruptedException, IOException {
        setScenario("10. Navigate to OTP screen");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        closeBottomSheetUnableProceed();
        if (context.isAndroid()) {
            selectDataOnlyInternetConnection();
        }
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "2 / 4");
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(),
                    "Verify mobile number",
                    "Navigate to enter OTP screen"
            );
        } else {
            Thread.sleep(3000); // Note: cannot use waitUnitVisible
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText(),
                    "Verify mobile number",
                    "Navigate to enter OTP screen"
            );
        }
        Thread.sleep(3000);
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");

        addLogInfo("Test with simulator cannot receive OTP via SMS!");

        if (context.isAndroid()) {
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
        }
    }

    @Test(groups = "Unlock pin Group", priority = 8, enabled = false)
    public void testUnlockPinShowVerifyOTPScreen() throws InterruptedException, IOException {
        setScenario("11. Click back when in OTP screen (Android only)");
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            addLogInfo("Need to confirm by Android");
            context.getDriver().navigate().back();
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText(), "Verify mobile number");
        Assert.assertEquals(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).getText(), "Resend OTP");

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).getText(),
                "Resend OTP",
                "Remain in OTP screen after click back button"
        );
    }

    @Test(groups = "Unlock pin Group", priority = 9, enabled = false)
    public void testUnlockPinShouldCancelInVerifyOTPScreenAndStayOnPage() throws InterruptedException, IOException {
        setScenario("12. Display bottom sheet confirm to exit OTP");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).click();

        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        //Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE).getText(), "Confirm to leave");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL).getText(), "Any unsaved changes will be lost, are you sure you want to leave this page?");
        Assert.assertEquals(context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        Assert.assertEquals(context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE).getText(),
                "Confirm to leave",
                "Display bottom sheet confirm t leave the page"
        );

        context.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
        Assert.assertEquals(context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).getText(), "Resend OTP");
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText(),
                "Verify mobile number",
                "Back to OTP screen"
        );
    }

    @Test(groups = "Unlock pin Group", priority = 10, enabled = false)
    public void testUnlockPinShouldCancelInVerifyOTPScreenAndLeavePage() throws InterruptedException, IOException {
        setScenario("13. Navigate to first screen of the original flow");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE).getText(), "Confirm to leave");
        Assert.assertEquals(context.findElement(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL).getText(), "Any unsaved changes will be lost, are you sure you want to leave this page?");
        Assert.assertEquals(context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        Assert.assertEquals(context.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        context.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).click();
        if (context.isAndroid()) {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(),
                    "Your PIN is locked",
                    "Back t the first screen of the original flow"
            );
        }
        if (context.isIos()) {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(),
                    "Your PIN is locked",
                    "Back t the first screen of the original flow"
            );
        }
    }

    @Test(groups = "Unlock pin Group", priority = 11, enabled = false)
    public void testCheckErrorInlineWhenFillsWrongOtpAndShowMaxAttemptScreen() throws InterruptedException, IOException {
        setScenario("14. Verify OTP: check inline errors and max attempt screen");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();
        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.STEPPER_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
        }

        addLogInfo("OTP-1st");
        Thread.sleep(3000);
        context.getDriver().getKeyboard().pressKey("123456");
        //context.getDriver().getKeyboard().sendKeys("123456");
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(),
                "Incorrect OTP. You have 2 attempts left.",
                "Display inline error message"
        );

        addLogInfo("OTP-2nd");
        context.getDriver().getKeyboard().pressKey("444444");
        //context.getDriver().getKeyboard().sendKeys("444444");
        Thread.sleep(3000);
        //Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(), "Incorrect OTP. You have 1 attempt left.");
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(),
                "Incorrect OTP. You have 1 attempt left.",
                "Display inline error message"
        );

        addLogInfo("OTP-3rd");
        context.getDriver().getKeyboard().pressKey("555555");
        //context.getDriver().getKeyboard().sendKeys("555555");
        if (context.isAndroid()) {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText(),
                    "OTP attempt limit reached",
                    "Navigate to OTP max attempt screen"
            );
            Assert.assertEquals(context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).getText(), "OK");
            context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
        }
        if (context.isIos()) {
            evaluateAssertEqualWithImg(
                    context.findElement(OneAppElementKeys.OTP_ATTEMPT_LIMIT_TITLE).getText(),
                    "OTP attempt limit reached",
                    "Navigate to OTP max attempt screen"
            );
            Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ATTEMPT_LIMIT_DETAIL).getText(), "You have reached the maximum number of attempts. Please try again later.");
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK).getText(), "OK");
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK).click();
            context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        }

        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
    }

    // take time too much
    @Test(groups = "Unlock pin Group", priority = 12, enabled = false)
    public void testCheckErrorInlineWhenOTPHasExpired() throws InterruptedException, IOException {
        setScenario("15. Verify OTP: check inline error when OTP expired");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();

        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        Thread.sleep(35000);
        context.getDriver().getKeyboard().pressKey("1");
        //context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().pressKey("1");
        //context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().pressKey("1");
        //context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().pressKey("1");
        //context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(40000);
        context.getDriver().getKeyboard().pressKey("1");
        //context.getDriver().getKeyboard().sendKeys("1");
        Thread.sleep(35000);
        context.getDriver().getKeyboard().pressKey("2");
        //context.getDriver().getKeyboard().sendKeys("2");
        Assert.assertEquals(context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(), "OTP code has expired.");

        addLogInfo("Verify: OTP fields are empty!");
        boolean isOTPFieldsEmpty = true;
        String[] otps = {
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_1).getText(),
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_2).getText(),
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_3).getText(),
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_4).getText(),
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_5).getText(),
                context.findElement(OneAppElementKeys.OTP_TEXTFIELD_6).getText()
        };
        for (String str : otps) {
            if(!str.isEmpty()) {
                isOTPFieldsEmpty = false;
            }
        }
        createScreenShot(
                isOTPFieldsEmpty ? "OTP Field is empty" : "OTP Field is not empty",
                isOTPFieldsEmpty
        );

        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText(),
                "OTP code has expired.",
                "Display inline error message"
        );
    }

    @Test(groups = "Unlock pin Group", priority = 13, enabled = false)
    public void testClickResendOTPThirdTimesAndDisabledResendButton() throws InterruptedException, IOException {
        setScenario("16. Verify OTP: test resend button");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);

        for(int i = 0; i < 3; i++) {
            addLogInfo("Press resend button flow: " + (i+1));
            pressResendButton(context);
        }

        System.out.println("Wait for 35 seconds");
        Thread.sleep(35000);
        evaluateAssertFalseWithImg(
                context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled(),
                "Resend button will be disable after 3rd pressed"
        );
    }

    private void pressResendButton(TtbTestContext context) throws InterruptedException, IOException {
        // fetch current Ref code
        String refCodePrev = context.findElement(OneAppElementKeys.OTP_REF_CODE).getText();
        System.out.println("Wait for 35 seconds");
        Thread.sleep(35000);

        boolean isResendButtonEnabled = context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).isEnabled();
        if(isResendButtonEnabled == false) {
            Assert.fail("Resend button shall be enabled");
        }

        System.out.println("Press resend button");
        context.findElement(OneAppElementKeys.RESEND_OTP_BUTTON).click();

        // Validate toast message!
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.TOAST_MSG).getText(),
                "OTP code is successfully sent to your mobile number.",
                "Display toast message"
        );

        // compare new ref code
        System.out.println("Prepare to compare ref code!");
        String refCodeNow = context.findElement(OneAppElementKeys.OTP_REF_CODE).getText();
        if(refCodePrev == refCodeNow) {
            createScreenShot("Display new screen", false);
        } else {
            createScreenShot("Display new screen", true);
        }
    }

    @Test(groups = "Unlock pin Group", priority = 14)
    public void testVerifyOTPCorrectAndNavigateToSetNewPin() throws InterruptedException {
        setScenario("17. Verify OTP: enter correct OTP");
        addLogInfo("📝 Need to capture activity log");
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.STEPPER_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");

        context.getDriver().getKeyboard().sendKeys("111111");
    }

    @Test(groups = "Unlock pin Group", priority = 15, enabled = false)
    public void testSetNewPinClickCancelShouldDisplayBottomSheet() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        context.getDriver().getKeyboard().sendKeys("111111");
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
        }
        Thread.sleep(20000);
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

    @Test(groups = "Unlock pin Group", priority = 16, enabled = false)
    public void testSetPinClickButtonPinRequirementShouldDisplayBottomSheet() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
        context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "PIN Requirements");
        String bottomSheetDesc = context.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        Assert.assertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"));
        Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "OK, Got it");
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        }
    }

    @Test(groups = "Unlock pin Group", priority = 17, enabled = false)
    public void testSetPinConfirmLeavePageShouldNavigateToPinLock() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        navigateFromPinLockToSetNewPinScreen();
    }

    @Test(groups = "Unlock pin Group", priority = 18, enabled = false)
    public void testSetPinDoNotAlignPinRequirement() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3000);
        pressPin("123456");
        context.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE);
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "Your PIN does not meet the security requirement. Please try again.");
    }

    @Test(groups = "Unlock pin Group", priority = 19, enabled = false)
    public void testSetPinNavigateToConfirmPinScreen() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        pressPin("070809");
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "4 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Confirm new PIN");
        } else {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD).getText(), "Confirm new PIN");
        }
        Thread.sleep(20000);
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

    @Test(groups = "Unlock pin Group", priority = 21, enabled = false)
    public void testConfirmPinClickBackOrArrowBackShouldNavigateToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");
        } else {
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD).getText(), "Set new 6-digit PIN");
        }
        pressPin("070809");
        if (context.isAndroid()) {
            context.back();
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "3 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");
            pressPin("070809");
        }
    }

    @Test(groups = "Unlock pin Group", priority = 22, enabled = false)
    public void testConfirmPinConfirmLeavePageShouldNavigateToPinLockAndNavigateToConfirmPinWithPIN070809() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        testCancelButtonDisplayBottomSheet();
        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.PINLOCK_TITLE).getText(), "Your PIN is locked");
        navigateFromPinLockToConfirmPinScreen();
    }

    @Test(groups = "Unlock pin Group", priority = 23, enabled = false)
    public void testConfirmNewPinEnterPinDifferenceFromSetNewPin() throws InterruptedException {
        TtbTestContext context = getTtbTestContext();
        navigateFromPinLockToConfirmPinScreen();
        Thread.sleep(2000);
        pressPin("123456");
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "PINs do not match. Please try again.");
        context.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON).click();
    }

    @Test(groups = "Unlock pin Group", priority = 24, enabled = false)
    public void testConfirmNewPinEnterPinDuplicate3lastPin() {
        TtbTestContext context = getTtbTestContext();
        pressPin("010203");
        String errorInline = context.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        Assert.assertEquals(errorInline, "Your PIN cannot be the same as one of your last three PINs. Please try again.");
    }

    @Test(groups = "Unlock pin Group", priority = 25, enabled = false)
    public void testConfirmNewPinEnterPinMatchWithSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        pressPin("070809");
        String changePinCompleteTitle = context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText();
        Assert.assertEquals(changePinCompleteTitle, "PIN Successfully Changed");
    }

    @Test(groups = "Unlock pin Group", priority = 26, enabled = false)
    public void testSuccessScreenToHome() {
        TtbTestContext context = getTtbTestContext();
        String changePinCompleteTitle = context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE).getText();
        Assert.assertEquals(changePinCompleteTitle, "PIN Successfully Changed");
        context.findElement(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON).click();
        Assert.assertTrue(context.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed());
    }

    public void navigateFromPinLockToSetNewPinScreen() {
        TtbTestContext context = getTtbTestContext();
        context.waitUntilVisible(OneAppElementKeys.PINLOCK_TITLE);
        context.findElement(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.INPUT_RM_FIELD);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.STEPPER_PROGRESS);
            context.waitUntilVisible(OneAppElementKeys.STEPPER_TITLE);
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText(), "2 / 4");
            Assert.assertEquals(context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Verify mobile number");
        }
        context.getDriver().getKeyboard().sendKeys("111111");
        context.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
    }

    public void navigateFromPinLockToConfirmPinScreen() {
        navigateFromPinLockToSetNewPinScreen();
        pressPin("070809");
    }

    public void closeBottomSheetUnableProceed() {
        TtbTestContext context = getTtbTestContext();
        List<WebElement> bottomSheet = context.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD);
        if (!bottomSheet.isEmpty()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(), "Unable to proceed further");
            context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();
        }
    }

    public void checkInputCitizenIdNo(String citizen) throws IOException {
        TtbTestContext context = getTtbTestContext();
        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE).getText(),
                "Incorrect citizen ID number",
                "Display bottom sheet incorrect citizen ID"
        );

        context.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        // Assert.assertFalse(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());

        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.STEPPER_TITLE).getText(),
                "Fill in personal information",
                "Back to fill in personal info screen"
        );


        touchVerifyPersonalInfoTextField(context);
        context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
        context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        context.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON).click();

        addLogInfo("Take screen capture inline error!");
        createScreenShot("Display inline error message", true);

        context.findElement(OneAppElementKeys.BUTTON_PASSPORT_NO).click();
        context.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).click();

        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizen);
            context.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
            context.waitUntilVisible(OneAppElementKeys.BOTTOM_SHEET_TITLE);
            context.back();
            Assert.assertFalse(context.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed());
        }
    }

    private void touchVerifyPersonalInfoTextField(TtbTestContext context) {
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        } else {
            Point objPoint = context.findElement(OneAppElementKeys.INPUT_RM_FIELD).getLocation();
            TouchAction action = new TouchAction(context.getDriver());
            action.press(PointOption.point(objPoint.x + 100, objPoint.y + 20)).release().perform();
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
