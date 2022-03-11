package com.ttbbank.oneapp.scenario.primarybanking7;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class TopUpScheduleOneTwoCallOnceScenario extends PrimaryBanking7Base {
    String fromAccountNumber;
    String scheduleStartDate;

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 1)
    public void testLoginWithPinSuccessWhenClickTopUp() throws IOException {
        setScenario("1. Customer \"Click TopUp\"");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.PB7_TOPUP_HOME).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(),
                "Enter PIN",
                "Show BottomSheet Login"
        );
        createScreenShot("Show BottomSheet Login After Click TopUp", true);
        pressPin("010203");

        setScenario("2. System navigate to topup landing");
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_MENU);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_MENU).getText(),
                "Top Up",
                "Navigated TopUp Landing"
        );
        createScreenShot("Show topup landing", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 2)
    public void testTapOnOneTwoCallMenu() throws InterruptedException, IOException {
        setScenario("2. Customer click 1-2-call menu go to the enter detail screen");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PB7_TOPUP_ONE_TWO_CALL).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE).getText(),
                "Top Up",
                "Validate title is displayed correctly"
        );
        createScreenShot("Show enter detail screen", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 3)
    public void testFilledRef1AndSelectAmountEnterDetail() throws IOException {
        setScenario("3. Customer filled ref1 and amount information correctly");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE);
        fromAccountNumber = context.findElement(OneAppElementKeys.PB7_TOPUP_ENTER_FROM_ACCOUNT_NUMBER).getText();

        evaluateAssertEqual(
                fromAccountNumber,
                fromAccountNumber,
                "Validate from account number is displayed correctly"
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_REF1).click();

        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FOUR).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_EIGHT).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_50).click();

        createScreenShot("Show enter detail screen filled information", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 4)
    public void testToggleSetScheduleAndEnterDetail() throws InterruptedException, IOException {
        setScenario("4. Customer toggle set schedule button and fill information correctly");
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD);
        evaluateAssertEqual(
                OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD,
                OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD,
                "Validate set schedule view is displayed correctly"
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD).click();

        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_SHIFT).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_T_LARGE).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_E_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_S_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_T_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_SPACE).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_MORE).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_ONE).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DATE_PICKER).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();
        scheduleStartDate = context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DATE_PICKER).getText();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NOTE_TEXTFIELD).click();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_O_LARGE).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_N_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_C_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_E_SMALL).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();

        createScreenShot("Show enter detail screen filled information", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 5)
    public void testTapAddScheduleAndNavigateToScheduleReviewScreen() throws IOException {
        setScenario("5. Customer click add schedule button and navigate to schedule review correctly");
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.PB7_TOPUP_ADD_SCHEDULE_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_TITLE).getText(),
                "Review Schedule",
                "Validate schedule review title is displayed correctly"
        );
        createScreenShot("Show schedule review screen information", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 6)
    public void testValidateScheduleReviewInfo() throws InterruptedException, IOException {
        setScenario("6. Customer check schedule review information");
        TtbTestContext context = getTtbTestContext();

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_12CALL_ONCE).getText(),
                "Test 01",
                "Validate schedule name is displayed correctly (the same as in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1).getText(),
                "093-705-2487",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_12CALL_ONCE).getText(),
                "50.00",
                "Validate amount is displayed correctly (the same as in enter detail before)"
        );
        Thread.sleep(1000);

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleStartDate).getText(),
                scheduleStartDate,
                "Validate schedule start date is displayed correctly (the same as review screen)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_FREQUENCY_ONCE).getText(),
                "Once",
                "Validate frequency is displayed correctly (the same as in enter detail before)"
        );

        createScreenShot("Show schedule review screen information", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 7)
    public void testConfirmAndNavigateToScheduleCompleteScreen() throws IOException {
        setScenario("7. Customer click confirm button and enter PIN to navigate to schedule complete screen");
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_CONFIRM).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(),
                "Enter PIN",
                "Show BottomSheet Login"
        );
        createScreenShot("Show BottomSheet Enter PIN After Click Confirm", true);
        pressPin("010203");

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_SCHEDULE_COMPLETE_TITLE);
        createScreenShot("Navigate to schedule complete screen correctly", true);
    }

    @Test(groups = "TopUp schedule 1-2-call once success", priority = 8)
    public void testDataAssertEqualsReviewScreenAndTapOnBackToTopUpLandingSuccess() throws InterruptedException, IOException {
        setScenario("8. Customer is on complete screen and tap done to go to screen before enter detail");
        TtbTestContext context = getTtbTestContext();

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_12CALL_ONCE).getText(),
                "Test 01",
                "Validate schedule name is displayed correctly (the same as in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1).getText(),
                "093-705-2487",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_12CALL_ONCE).getText(),
                "50.00",
                "Validate amount is displayed correctly (the same as in enter detail before)"
        );
        Thread.sleep(1000);

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleStartDate).getText(),
                scheduleStartDate,
                "Validate schedule start date is displayed correctly (the same as review screen)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_FREQUENCY_ONCE).getText(),
                "Once",
                "Validate frequency is displayed correctly (the same as in enter detail before)"
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_DONE_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_MENU);
        createScreenShot("Show topup landing screen", true);
    }
}
