package com.ttbbank.oneapp.scenario.primarybanking3.setschedule.own;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.PrimaryBanking3Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class SetScheduleMonthlyByTimesScenario extends PrimaryBanking3Base {
    String fromAccountNumber;
    String toAccountNumber;
    String scheduleName;
    String scheduleAmountOfTimes;

    @Test(groups = "Set schedule monthly by times", priority = 1)
    public void testLoginWithPinSuccessWhenClickTransfer() throws IOException {
        setScenario("1. Customer click quick action \"Transfer\" and \"Login\" to landing transfer screen");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(),
                "Enter PIN",
                "Show login pin bottom sheet for login"
        );
        pressPin("010203");
        createScreenShot("Show login pin bottom sheet", true);

        context.waitUntilVisible(OneAppElementKeys.PB3_TITLE_TRANSFER_LANDING);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.TRANSFER_TITLE).getText(),
                "Transfer",
                "Validate title is displayed correctly"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_OWN_MENU).getText(),
                "Own ttb account",
                "Validate own transfer menu is displayed correctly"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_OTHER_MENU).getText(),
                "Other Accounts",
                "Validate other transfer menu is displayed correctly"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_PROMPT_PAY_MENU).getText(),
                "Promptpay",
                "Validate promptpay menu is displayed correctly"
        );
        createScreenShot("Show landing transfer screen", true);
    }

    @Test(groups = "Set schedule monthly by times", priority = 2)
    public void testTapOnOwnTransferMenu() throws InterruptedException, IOException {
        setScenario("2. Customer click own ttb account menu go to the enter detail screen");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PB3_TRANSFER_OWN_MENU).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_TITLE).getText(),
                "Transfer",
                "Validate title is displayed correctly"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_TITLE).getText(),
                "Transfer",
                "Validate title on enter detail screen is displayed correctly"
        );
        createScreenShot("Show enter detail screen", true);
    }

    @Test(groups = "Set schedule monthly by times", priority = 3)
    public void testFilledSetscheduleEnterDetailAndNextToReviewScreenSuccess() throws IOException {
        setScenario("3. Customer filled information is correctly and click on next button go to the review screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_TITLE);
        fromAccountNumber = context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_FROM_ACCOUNT_NUMBER).getText();

        evaluateAssertEqual(
                fromAccountNumber,
                fromAccountNumber,
                "Validate from account number is displayed correctly"
        );

        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_SELECT_TO_ACCOUNT_BUTTON).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_TO_ACCOUNT_BOTTOM_SHEET_SELECTED_BUTTON).click();
        toAccountNumber = context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_TO_ACCOUNT_NUMBER).getText();

        evaluateAssertEqual(
                toAccountNumber,
                toAccountNumber,
                "Validate to account number is displayed correctly"
        );

        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_AMOUNT_TEXT_FIELD_BUTTON).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ONE).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_BUTTON).click();
        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_NAME_TEXTFIELD).click();
        randomStringAndPress();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        scheduleName = context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_NAME_TEXTFIELD).getText();

        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_STARTDATE_TEXTFIELD).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB3_SCHEDULE_RADIO_MONTHLY).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_SCHEDULE_MONTHLY_NOTE).getText(),
                "Note: In case a month does not contain your chosen date, your transaction will be completed at the end of that month",
                "Validate Note show when select monthly"
        );

        context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_RADIO).click();
        context.findElement(OneAppElementKeys.PB3_SCHEDULE_AMOUNE_OF_TIMES_TEXTFIELD_MONTHLY).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ONE).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        scheduleAmountOfTimes = context.findElement(OneAppElementKeys.PB3_SCHEDULE_AMOUNE_OF_TIMES_TEXTFIELD_MONTHLY).getText();

        createScreenShot("Show enter detail screen filled information", true);

        context.findElement(OneAppElementKeys.PB3_ADD_SCHEDULE_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB3_REVIEW_TITLE_SCHEDULE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_REVIEW_TITLE_SCHEDULE).getText(),
                "Review Schedule",
                "Validate title on review schedule screen is displayed correctly"
        );
        createScreenShot("Show review schedule screen", true);
    }

    @Test(groups = "Set schedule monthly by times", priority = 4)
    public void testDataAssertEqualsEnterDetailsOnReviewScreenAndTapOnConfirm() throws IOException {
        setScenario("4. Customer is on review screen, validate information is correctly and click confirm button go to the confirm screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB3_REVIEW_TITLE_SCHEDULE);

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleName).getText(),
                scheduleName,
                "Validate schedule name is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_FROM_ACCOUNT_NUMBER_KAI).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_TO_ACCOUNT_NUMBER_KAI).getText(),
                toAccountNumber,
                "Validate to account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_REVIEW_SCHEDULE_AMOUNT).getText(),
                "1.00",
                "Validate amount is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleAmountOfTimes).getText(),
                "1",
                "Validate schedule time is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_REVIEW_SCHEDULE_FEE).getText(),
                "0.00",
                "Validate fee is displayed correctly"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId("Monthly").getText(),
                "Monthly",
                "Validate schedule execute frequency is displayed correctly (the same as entered in enter detail before)"
        );

        context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_CONFIRM).click();
        context.waitUntilVisible(OneAppElementKeys.PB3_SCHEDULE_COMPLETE_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_SCHEDULE_COMPLETE_TITLE).getText(),
                "Schedule is Successfully Created",
                "Validate title on complete screen is displayed correctly"
        );
        createScreenShot("Show complete screen", true);
    }

    @Test(groups = "Set schedule monthly by times", priority = 5)
    public void testDataAssertEqualsReviewScreenAndTapOnBackToTransferLandingSuccess() throws IOException {
        setScenario("5. Customer is on complete screen, validate information is correctly and done button go to landing screen");
        TtbTestContext context = getTtbTestContext();

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleName).getText(),
                scheduleName,
                "Validate schedule name is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_FROM_ACCOUNT_NUMBER_KAI).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_TO_ACCOUNT_NUMBER_KAI).getText(),
                toAccountNumber,
                "Validate to account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_REVIEW_SCHEDULE_AMOUNT).getText(),
                "1.00",
                "Validate amount is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId(scheduleAmountOfTimes).getText(),
                "1",
                "Validate schedule time is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_REVIEW_SCHEDULE_FEE).getText(),
                "0.00",
                "Validate fee is displayed correctly"
        );

        evaluateAssertEqual(
                context.findElementByAccessibilityId("Monthly").getText(),
                "Monthly",
                "Validate schedule execute frequency is displayed correctly (the same as entered in enter detail before)"
        );

        context.findElement(OneAppElementKeys.PB3_COMPLETE_DONE_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        createScreenShot("Show transfer landing screen", true);
    }
}
