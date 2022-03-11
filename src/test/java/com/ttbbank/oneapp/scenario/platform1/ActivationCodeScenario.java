package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

public class ActivationCodeScenario extends Platform1Base {
    String newPin = "010203";

    @Test(groups = "Activation Code Group", priority = 1)
    public void testCustomerAcceptTnCShouldNavigateToVerifyPersonalScreen() throws IOException, InterruptedException {
        setScenario("1. Prospect user clicks on any button that requires registration");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
        evaluateAssertTrueWithImg(
                ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).isDisplayed(),
                "Display register ttb bottom sheet"
        );
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();

        addLogInfo("📝 Need to capture activity log");
        evaluateAssertTrueWithImg(
                ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).isDisplayed(),
                "Navigate to accept T&C screen"
        );

        // init app in english
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_LANGUAGE).click();
            evaluateAssertEqual(
                    ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_LANGUAGE).getText(),
                    "English",
                    "Changed languages to Thai"
            );
        } else {
            ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_TH_LANGUAGE).click();
            evaluateAssertEqual(
                    ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_EN_LANGUAGE).getText(),
                    "English",
                    "Changed languages to Thai"
            );
        }

        Thread.sleep(3000);
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_LANGUAGE).click();
            evaluateAssertEqual(
                    ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_LANGUAGE).getText(),
                    "ภาษาไทย",
                    "Changed languages to English"
            );
        } else {
            ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_EN_LANGUAGE).click();
            evaluateAssertEqual(
                    ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_TH_LANGUAGE).getText(),
                    "English",
                    "Changed languages to Thai"
            );
        }

        Thread.sleep(3000);
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        addLogInfo("📝 Need to capture activity log");
        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrueWithImg(
                    ttbTestContext.findElement(OneAppElementKeys.BUTTON_CITIZEN_ID_NO).getAttribute("checked").equals("true"),
                    "Display Enter Personal Information screen and Default Tab on screen is enter citizen ID"
            );
        }
    }

    @Test(groups = "Activation Code Group", priority = 2)
    public void testCustomerClickBackButtonOnTncShouldNavigateToPreviousScreen() throws IOException {
        setScenario("3. Click back button on T&C screen");
        ttbTestContext.findElement(OneAppElementKeys.BUTTON_BACK_VERIFY_PERSONAL).click();
        ttbTestContext.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON).click();
        evaluateAssertTrueWithImg(
                ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).isDisplayed(),
                "Navigate to previous screen"
        );
    }

    @Test(groups = "Activation Code Group", priority = 3)
    public void testCustomerVerifyPersonalByCitizenIDShouldNavigateToProductActivationOptionScreen() throws InterruptedException, IOException {
        setScenario("5. Verify personal information : citizen ID matches with RM");
        navigateToActivationScreen(OneAppElementKeys.TRANSFER_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();

        Thread.sleep(3000);
        addLogInfo("📝 Need to capture activity log");
        boolean isNavigateToProductActivationOption;
        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("1 / 5"), "Step of progress indicator is \"1/5\"");
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Select registration method"), "Title of progress indicator is \"Select registration method\"");
            isNavigateToProductActivationOption = ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).isDisplayed();
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION);
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD).getText().equals("Select registration method"), "Title of progress indicator is Select registration method");
            isNavigateToProductActivationOption = ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD).isDisplayed();
        }
        createScreenShot("Navigate to Product Activation Option Screen", isNavigateToProductActivationOption);
    }

    @Test(groups = "Activation Code Group", priority = 4)
    public void testCustomerSelectActivationOptionWithActivationCodeShouldNavigateToActivationCodeScreenWithCorrectInformation() throws InterruptedException, IOException {
        setScenario("10. Select option : Register with activation code");
        selectActivationCodeOption();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);

        evaluateAssertTrueWithImg((ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE).isDisplayed()), "Navigate to Activation code information screen");
        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_EDIT_FIELD).getText().equals("Activation code"), "Display Activation code input field with placeholder \"Activation code\" ");
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_EDIT_FIELD).sendKeys("12345678");
        } else {
            evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE_ACTIVATION_CODE_INFORMATION).getText(), "Fill in the information");
            evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE).getText(), "Activation code information");
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).sendKeys("12345678");
        }

        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE).click();
        Thread.sleep(5000);
        createScreenShot("Next button will be enable when customer enter till 8 digits", ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON).isEnabled());
    }

    @Test(groups = "Activation Code Group", priority = 5)
    public void testCustomerClickCancelOnActivationCodeShouldDisplayConfirmToLeaveBottomSheet() throws IOException {
        setScenario("11. Click cancel button on Activation code information screen");
        WebElement cancelButton = ttbTestContext.findElement(OneAppElementKeys.CANCEL_ACTIVATION_WITH_CODE);
        cancelButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        String cancelBottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText();
        evaluateAssertEqual(cancelBottomSheetTitle, "Are you sure you want to leave this page?");
        createScreenShot("Display Confirm to Leave Bottom Sheet", cancelBottomSheetTitle.equals("Are you sure you want to leave this page?"));

        WebElement stayOnPageButton = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND);
        stayOnPageButton.click();
    }

    @Test(groups = "Activation Code Group", priority = 6)
    public void testClickBackOnActivationCodeShouldBackToProductActivationOptionScreen() throws InterruptedException, IOException {
        setScenario("12. Click back on Activation code screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_CODE_BACK_BUTTON).click();
        if (ttbTestContext.isIos()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION);
            evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD).getText().equals("Select registration method"), "Navigate to Product option screen");
        } else {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("1 / 5"), "Step of progress indicator is \"1/5\" ");
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Select registration method"), "Title of progress indicator is \"Select registration method\" ");
        }
        createScreenShot("Navigate to product option screen", ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).isDisplayed());

        selectActivationCodeOption();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);
        setScenario("13. Click back device in Android on Enter activation code screen");
        //click back from back device on android
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.back();
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("1 / 5"), "Step of progress indicator is \"1/5\" ");
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Select registration method"), "Title of progress indicator is \"Select registration method\" ");
            evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).getText(), "Register with activation code");
            createScreenShot("Navigate to product option screen", ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).isDisplayed());
            selectActivationCodeOption();
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);
        }
    }

    @Test(groups = "Activation Code Group", priority = 7)
    public void testClickStayOnPageShouldStillStayOnActivationCodeScreen() throws IOException {
        setScenario("14. Click \"Stay on Page\" in bottom sheet");
        WebElement cancelButton = ttbTestContext.findElement(OneAppElementKeys.CANCEL_ACTIVATION_WITH_CODE);
        cancelButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement stayOnPageButton = ttbTestContext.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON);
        evaluateAssertEqual(stayOnPageButton.getText(), "Stay on Page");
        stayOnPageButton.click();
        evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).equals(Collections.emptyList()), "Dismiss confirm to leave bottom sheet");
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE).isDisplayed(), "System stays on Activation code information screen ");
    }

    @Test(groups = "Activation Code Group", priority = 8)
    public void testClickConfirmToLeaveButtonShouldNavigateToOriginalFlowScreen() throws IOException {
        setScenario("15. Click \"Confirm to leave\" in bottom sheet");
        WebElement cancelButton = ttbTestContext.findElement(OneAppElementKeys.CANCEL_ACTIVATION_WITH_CODE);
        cancelButton.click();
        WebElement leavePageButton = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertEqual(leavePageButton.getText(), "Leave Page");
        leavePageButton.click();
        testNavigateToOriginalFlow();
    }

    @Test(groups = "Activation Code Group", priority = 9)
    public void testCustomerEnterActivateCodeLessThanEightDigitsShouldDisplayInlineErrorAndDisableNextButton() throws IOException, InterruptedException {
        navigateToActivationCodeScreen();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);
        setScenario("18. Enter Activation code less than 8 digits and leave field");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).click();

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_EDIT_FIELD).sendKeys("1234567");
        } else {
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).sendKeys("1234567");
        }
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE).click();
        WebElement nextButton = ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON);
        if (ttbTestContext.isAndroid()) {
            WebElement inlineError = ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_INLINE_ERROR);
            Boolean expectedConditionForPass = (inlineError.getText().equals("Incorrect code, please try again.") && !nextButton.isEnabled());
            evaluateAssertTrue(inlineError.getText().equals("Incorrect code, please try again."), "Show inline error");
            createScreenShot("Show inline error and next button is disable", expectedConditionForPass);
        }

        evaluateAssertTrue(!nextButton.isEnabled(), "Next button is disable ");
    }

    @Test(groups = "Activation Code Group", priority = 10)
    public void testActivationShouldNavigateToVerifyOTPScreenWhenEnteredCorrectActivationCode() throws IOException {
        setScenario("30. Verify activation code correct  within 4 attemps \n" +
                "Display OTP screen");
        enterActivationCodeToTextField("88888888");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);
        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("3 / 5"), "Step of progress indicator is \"3/5\" ");
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Verify mobile number"), "Title of progress indicator is \"Verify mobile number\" ");
        }

        addLogInfo("📝 Need to capture activity log");
        createScreenShot("Navigate to Verify OTP Screen", true);
    }

    @Test(groups = "Activation Code Group", priority = 11)
    public void testVerifyOtpIncorrectThirdAttemptShouldDisplayBlockScreen() throws InterruptedException, IOException {
        setScenario("31. Enter OTP incorrect in 1st and 2nd attempts");
        ttbTestContext.getDriver().getKeyboard().sendKeys("123456");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText().equals("Incorrect OTP. You have 2 attempts left."), "Display Incorrect OTP. You have 2 attempts left.");
        addLogInfo("📝 Need to capture activity log");

        ttbTestContext.getDriver().getKeyboard().sendKeys("123123");
        Thread.sleep(1000);
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.OTP_ERROR_INLINE).getText().equals("Incorrect OTP. You have 1 attempt left."), "Display Incorrect OTP. You have 1 attempt left.");
        addLogInfo("📝 Need to capture activity log");

        setScenario("33. Verify activation code correct and OTP incorrect in 3rd attempts");
        ttbTestContext.getDriver().getKeyboard().sendKeys("654321");
        addLogInfo("📝 Need to capture activity log");

        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.BLOCK_SCREEN_BODY).getText().equals("You have reached the maximum number of attempts. Please try again later."), "Navigate to Block Screen");
            ttbTestContext.findElement(OneAppElementKeys.BLOCK_SCREEN_BUTTON).click();
        }
        if (ttbTestContext.isIos()) {
            evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.OTP_ATTEMPT_LIMIT_DETAIL).getText().equals("You have reached the maximum number of attempts. Please try again later."), "Navigate to Block Screen");
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK).click();
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.HOME_TAB);
        String activateButtonText = ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).getText();
        evaluateAssertTrueWithImg(activateButtonText.equals("Activate"), "Click OK system will navigate to the first screen of the original flow ");
    }

    @Test(groups = "Activation Code Group", priority = 12)
    public void testCancelInVerifyOTPScreenShouldDisplayBottomSheetToConfirmToLeave() throws InterruptedException, IOException {
        navigateToActivationCodeScreen();
        enterActivationCodeToTextField("88888888");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON).click();
        setScenario("38. Click cancel button on OTP screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Are you sure you want to leave this page?");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        createScreenShot("Display bottom sheet to confirm to leave page", ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText().equals("Are you sure you want to leave this page?"));
    }

    @Test(groups = "Activation Code Group", priority = 13)
    public void testStayOnPageShouldDismissBottomSheetToConfirmToLeave() {
        setScenario("40. Dismiss the bottom sheet to stay on OTP screen");
        // click stay on page button
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement stayOnPageButton = ttbTestContext.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON);
        stayOnPageButton.click();
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText().equals("Verify mobile number"), "Click Stay on page button ,still stay on verify otp screen");

        //swipe down
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        scrollingToBottom(500, 750);
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText().equals("Verify mobile number"), "Swipe the bottom sheet down, still stay on verify otp screen");

        //click close icon
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement closeButton = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON);
        closeButton.click();
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS).getText().equals("Verify mobile number"), "Click close icon, still stay on verify otp screen");
    }

    @Test(groups = "Activation Code Group", priority = 14)
    public void testClickLeavePageButtonOnVerifyOTPScreenShouldNavigateToOriginalFlow() throws IOException {
        setScenario("39. Click \"Leave Page\" on bottom sheet on OTP screen");
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_OTP_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement leavePageButton = ttbTestContext.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON);
        leavePageButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.HOME_TAB);
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).getText();
        evaluateAssertTrueWithImg(registerButtonText.equals("Activate"), "System will navigate to the first screen of the original flow as Prospect.");
    }

    @Test(groups = "Activation Code Group", priority = 15)
    public void testEnterCorrectActivationCodeAndVerifyOTPCorrectShouldNavigateToSetNewPin() throws InterruptedException, IOException {
        setScenario("32. Verify activation code correct and OTP Correct within 3 attempts");
        navigateToActivationOptionScreen();
        enterActivationCodeToTextField("88888888");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);
        ttbTestContext.getDriver().getKeyboard().pressKey("111111");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
        if (ttbTestContext.isAndroid()) {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("4 / 5"), "Step of progress indicator is \"4/5\" ");
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.PIN_REQUIRE_BUTTON);
        }
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Set new 6-digit PIN"), "Title of progress indicator is \"Set new 6-digit PIN\" ");
        createScreenShot("Navigate to set new pin screen", ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Set new 6-digit PIN"));
    }

    @Test(groups = "Activation Code Group", priority = 16)
    public void testSetNewPinClickButtonPinRequirementShouldDisplayBottomSheet() throws IOException {
        setScenario("43. On set PIN screen , click \"PIN Requirement\" button");
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.PIN_REQUIRE_BUTTON);
            ttbTestContext.findElement(OneAppElementKeys.PIN_REQUIRE_BUTTON).click();
        }
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText().equals("PIN requirements"), "Display PIN requirements bottom sheet");
        String bottomSheetDesc = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        evaluateAssertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"), "Display detail of pin requirements");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "OK");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
    }

    @Test(groups = "Activation Code Group", priority = 17)
    public void testSetNewPinClickCancelButtonShouldDisplayBottomSheetToConfirmToLeave() throws IOException {
        setScenario("47. Click cancel button on Set PIN screen");
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "Are you sure you want to leave this page?");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON).getText(), "Leave Page");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON).getText(), "Stay on Page");
        createScreenShot("Display bottom sheet to confirm to leave page", ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText().equals("Are you sure you want to leave this page?"));
    }

    @Test(groups = "Activation Code Group", priority = 18)
    public void testSetNewPinClickStayOnPageButtonOrCloseIconShouldDismissBottomSheetToConfirmToLeave() {
        setScenario("49. Dismiss the bottom sheet to stay on Set PIN screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        //click stay on page
        WebElement stayOnPageButton = ttbTestContext.findElement(OneAppElementKeys.STAY_ON_PAGE_BUTTON);
        stayOnPageButton.click();
        evaluateAssertTrue(checkStayOnPageAndDismissBottomSheet(OneAppElementKeys.STEPPER_TITLE, "Set new 6-digit PIN"), "Click stay on page, still stay on set new pin screen and dismiss bottom sheet");

        //click close icon
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement closeButton = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON);
        closeButton.click();
        evaluateAssertTrue(checkStayOnPageAndDismissBottomSheet(OneAppElementKeys.STEPPER_TITLE, "Set new 6-digit PIN"), "Click close icon, still stay on set new pin screen and dismiss bottom sheet");

        //swipe down
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        scrollingToBottom(500, 750);
        evaluateAssertTrue(checkStayOnPageAndDismissBottomSheet(OneAppElementKeys.STEPPER_TITLE, "Set new 6-digit PIN"), "Swipe the bottom sheet down, still stay on set new pin screen and dismiss bottom sheet");

        //back device on android
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            ttbTestContext.back();
            evaluateAssertTrue(checkStayOnPageAndDismissBottomSheet(OneAppElementKeys.STEPPER_TITLE, "Set new 6-digit PIN"), "Click back on android device, still stay on set new pin screen and dismiss bottom sheet");
        }
    }

    @Test(groups = "Activation Code Group", priority = 19)
    public void testSetNewPinClickLeavePageButtonShouldNavigateToOriginalFlowScreen() throws IOException {
        setScenario("48. Click \"Leave Page\" on bottom sheet on Set PIN screen");
        ttbTestContext.findElement(OneAppElementKeys.CANCEL_ENTER_PIN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        WebElement leavePageButton = ttbTestContext.findElement(OneAppElementKeys.LEAVE_PAGE_BUTTON);
        leavePageButton.click();
        testNavigateToOriginalFlow();
    }

    @Test(groups = "Activation Code Group", priority = 20)
    public void testSetNewPinWithPinThatNotMeetPinRequirementShouldDisplayInlineError() throws InterruptedException, IOException {
        setScenario("45. Set PIN that doesn't meet PIN requirement");
        navigateToSetNewPin();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.PIN_REQUIRE_BUTTON);
            ttbTestContext.findElement(OneAppElementKeys.PIN_REQUIRE_BUTTON).click();
        }
        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText(), "PIN requirements");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION);
        String bottomSheetDesc = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        if (ttbTestContext.isAndroid()) {
            Assert.assertTrue(bottomSheetDesc.contains("1\uFEFF. PIN cannot be 3\uFEFF or more sequential numbers such as"));
        } else {
            Assert.assertEquals(bottomSheetDesc, "1. PIN cannot be 3 or more sequential numbers such as “123456”\n" +
                    "\n" +
                    "2. PIN cannot contain 3 or more repeated numbers such as “111222”");
        }

        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).getText(), "OK");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            ttbTestContext.back();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
            Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_ENTERPIN).click();
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        }
        Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
    }

    @Test(groups = "Activation Code Group", priority = 21)
    public void testSetNewPinThatMeetPinRequirementShouldNavigateToConfirmNewPinScreen() throws IOException {
        setScenario("44. Set PIN that meets PIN requirement");
        pressPin(newPin);
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_PROGRESS).getText().equals("5 / 5"), "Step of progress indicator is \"5/5\" ");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Confirm new PIN"), "Title of progress indicator is \"Confirm new PIN\" ");
        createScreenShot("Navigate to confirm new pin screen", ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Confirm new PIN"));
    }

    @Test(groups = "Activation Code Group", priority = 22)
    public void testConfirmNewPinNotMatchShouldDisplayErrorInline() throws IOException {
        setScenario("52. Enter confirm PIN doesn't match with set PIN");
        pressPin("070809");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE);
        String errorInline = ttbTestContext.findElement(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE).getText();
        evaluateAssertTrueWithImg(errorInline.equals("PINs do not match. Please try again."), "Display inline error message PINs do not match. Please try again.");
    }

    @Test(groups = "Activation Code Group", priority = 23)
    public void testConfirmNewPinClickBackDeviceShouldNavigateBackToSetNewPinScreen() throws InterruptedException {
        setScenario("53. Go back to Set PIN screen from Confirm PIN screen");

        //click back android device
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.back();
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Set new 6-digit PIN"), "Click back on android device, go back to set new pin screen");
            //press new pin for navigate to confirm pin
            pressPin(newPin);
        }

        //click back from arrow
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_BACK_BUTTON).click();
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Set new 6-digit PIN"), "Click back from arrow , go back to set new pin screen");
        } else {
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_CODE_BACK_BUTTON).click();
            Thread.sleep(500);
            Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText(), "Set new 6-digit PIN");
        }
    }

    @Test(groups = "Activation Code Group", priority = 24)
    public void testSetNewPinAndConfirmNewPinSuccessShouldNavigateToCompleteScreen() throws IOException {
        setScenario("54. Set PIN and Confirm PIN success");
        pressPin(newPin);
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.STEPPER_TITLE).getText().equals("Confirm new PIN"), "Navigate to confirm new pin screen");

        pressPin(newPin);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.COMPLETE_SCREEN_TITLE);
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.COMPLETE_SCREEN_TITLE).getText(), "Welcome to ttb touch");
        evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.COMPLETE_SCREEN_SUBTITLE).getText(), "Your application is now ready to use.");
        createScreenShot("Navigate to complete screen", ttbTestContext.findElement(OneAppElementKeys.COMPLETE_SCREEN_TITLE).isDisplayed());
    }

    @Test(groups = "Activation Code Group", priority = 25)
    public void testClickNextOnActivateCompleteScreenShouldNavigateToHomeScreen() throws InterruptedException, IOException {
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
        if (ttbTestContext.isIos()) {
            ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
        }
        Thread.sleep(2000);
        if (ttbTestContext.isAndroid()) {
            for (int i = 0; i < 3; i++) {
                ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
            }
        }
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.TRANSFER_BUTTON).isDisplayed(), "Display quick action Transfer");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PAY_BILL_BUTTON).isDisplayed(), "Display quick action Pay Bill");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.WITH_DRAW_BUTTON).isDisplayed(), "Display quick action Withdraw");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.SCAN_QR_BUTTON).isDisplayed(), "Display quick action Scan QR");
        evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.TOP_UP_BUTTON).equals(Collections.emptyList()), "No Display quick action Top up");
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        testUserPressLogoutButton();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.SETTING_BUTTON).click();
        }
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText().equals("Enter PIN"), "Display bottom sheet Login with Pin");
        Thread.sleep(2000);
        pressPin(newPin);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.SETTING_TITLE);
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.SETTING_TITLE).getText().equals("Settings"), "Navigate to setting after login with new pin success");
    }

    private void navigateToActivationOptionScreen() throws InterruptedException {
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        selectActivationCodeOption();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE);
    }

    public void selectActivationCodeOption() throws InterruptedException {
        if (ttbTestContext.isAndroid()) {
            // case activation option has multiple options on android
            int i = 1;
            String activationLabel;
            int indexIsActivationCode = 0;
            while (!ttbTestContext.viewElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.TextView").isEmpty()) {
                activationLabel = ttbTestContext.findElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.TextView").getText();
                Thread.sleep(1000);
                if (activationLabel.contains("Register with activation code")) {
                    indexIsActivationCode = i;
                }
                i++;
            }
            if (indexIsActivationCode > 1) {
                WebElement activateCodeOption = ttbTestContext.findElementByXPATH("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + indexIsActivationCode + "]/android.widget.LinearLayout/android.widget.TextView");
                activateCodeOption.click();
            } else {
                evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).getText(), "Register with activation code");
                ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).click();
            }
        }
        if (ttbTestContext.isIos()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION);
            evaluateAssertEqual(ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).getText(), "Register with activation code");
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION).click();
        }
    }

    public void enterActivationCodeToTextField(String activationCode) {
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).click();
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_EDIT_FIELD).sendKeys(activationCode);
        } else {
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).click();
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).clear();
            ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD).sendKeys(activationCode);
        }
    }

    public void testNavigateToOriginalFlow() throws IOException {
        ttbTestContext.waitUntilVisible(OneAppElementKeys.HOME_TAB);
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).getText();
        evaluateAssertTrueWithImg(registerButtonText.equals("Activate"), "System navigates to the first screen of the original flow");
    }

    public void scrollingToBottom(int yOffsetpress, int yOffsetmoveto) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, yOffsetpress)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffsetmoveto)).release().perform();
    }

    private void navigateToSetNewPin() throws InterruptedException {
        navigateToActivationCodeScreen();
        enterActivationCodeToTextField("88888888");
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.RESEND_OTP_BUTTON);
        ttbTestContext.getDriver().getKeyboard().pressKey("111111");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void navigateToActivationScreen(String item) {
        ttbTestContext.findElement(item).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
    }

    public void navigateToActivationCodeScreen() throws InterruptedException {
        ttbTestContext.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
        ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
        selectActivationCodeOption();
        ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON).click();
    }

    public Boolean checkStayOnPageAndDismissBottomSheet(String titleKey, String pageTitle) {
        Boolean isDismissBottomSheet = ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).equals(Collections.emptyList());
        Boolean isStayOnPage = ttbTestContext.findElement(titleKey).getText().equals(pageTitle);
        return isDismissBottomSheet && isStayOnPage;
    }

    public void testUserPressLogoutButton() throws IOException {
        if (ttbTestContext.isAndroid()) {
            scrollingToBottom(915, 0);
        }
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.LOGOUT_BUTTON).isDisplayed(), "Display logout button");
        ttbTestContext.findElement(OneAppElementKeys.LOGOUT_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        }
    }
}