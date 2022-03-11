package com.ttbbank.oneapp.scenario.primarybanking7;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class TopUpScheduleDtacMonthlyTimesScenario extends PrimaryBanking7Base{
    String fromAccountNumber;
    String scheduleStartDate;
    String scheduleAmountOfTimes;

    @Test(groups = "Topup schedule dtac monthly times success", priority = 1)
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

    @Test(groups = "Topup schedule dtac monthly times success", priority = 2)
    public void testTapDtacMenu() throws InterruptedException, IOException {
        setScenario("2. Customer click TrueH menu go to the enter detail screen");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PB7_TOPUP_DTAC).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE).getText(),
                "Top Up",
                "Validate title is displayed correctly"
        );
        createScreenShot("Show enter detail screen", true);
    }

    @Test(groups = "Topup schedule dtac monthly times success", priority = 3)
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

        context.findElement(OneAppElementKeys.PB7_TOPUP_REF1).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SIX).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_EIGHT).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_50).click();

        createScreenShot("Show enter detail screen filled information", true);
    }

    @Test(groups = "Topup schedule dtac monthly times success", priority = 4)
    public void testToggleSetScheduleAndEnterDetail() throws IOException {
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
        context.findElement(OneAppElementKeys.PB7_KEY_BOARD_FOUR).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DATE_PICKER).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_SELECT_MONTHLY).click();
        context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_RADIO).click();
        context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_AMOUNT_OF_TIMES_TEXTFIELD).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ONE).click();
        context.findElement(OneAppElementKeys.PB7_KEYPAD_DONE).click();
        scheduleAmountOfTimes = context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_AMOUNT_OF_TIMES_TEXTFIELD).getText();

        createScreenShot("Show enter detail screen filled information", true);
    }

    @Test(groups = "Topup schedule dtac monthly times success", priority = 5)
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

    @Test(groups = "Topup schedule dtac monthly times success", priority = 6)
    public void testValidateScheduleReviewInfo() throws IOException {
        setScenario("6. Customer check schedule review information and click confirm button");
        TtbTestContext context = getTtbTestContext();

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_DTAC_MONTHLY).getText(),
                "Test 04",
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_DTAC).getText(),
                "065-208-0053",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_FIFTY).getText(),
                "50.00",
                "Validate amount is displayed correctly (the same as in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleAmountOfTimes).getText(),
                "1",
                "Validate schedule time is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId("Monthly").getText(),
                "Monthly",
                "Validate schedule execute frequency is displayed correctly (the same as entered in enter detail before)"
        );

        createScreenShot("Show schedule review screen information", true);
    }

    @Test(groups = "Topup schedule dtac monthly times success", priority = 7)
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

    @Test(groups = "Topup schedule dtac monthly times success", priority = 8)
    public void testDataAssertEqualsReviewScreenAndTapOnBackToTopUpLandingSuccess() throws InterruptedException, IOException {
        setScenario("8. Customer is on complete screen and tap done to go to screen before enter detail");
        TtbTestContext context = getTtbTestContext();

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_DTAC_MONTHLY).getText(),
                "Test 04",
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_DTAC).getText(),
                "065-208-0053",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_FIFTY).getText(),
                "50.00",
                "Validate amount is displayed correctly (the same as in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleAmountOfTimes).getText(),
                "1",
                "Validate schedule time is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId("Monthly").getText(),
                "Monthly",
                "Validate schedule execute frequency is displayed correctly (the same as entered in enter detail before)"
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_DONE_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_MENU);
        createScreenShot("Show topup landing screen", true);
    }
}
