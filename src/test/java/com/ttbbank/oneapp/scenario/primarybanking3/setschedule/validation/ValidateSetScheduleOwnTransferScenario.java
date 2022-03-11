package com.ttbbank.oneapp.scenario.primarybanking3.setschedule.validation;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.PrimaryBanking3Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateSetScheduleOwnTransferScenario extends PrimaryBanking3Base {
    @Test(groups = "Validate SetSchedule OwnTransfer", priority = 1)
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

    @Test(groups = "Validate SetSchedule OwnTransfer", priority = 2)
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

    @Test(groups = "Validate SetSchedule OwnTransfer", priority = 3)
    public void testValidateScheduleName() throws IOException, InterruptedException {
        setScenario("3. Validate schedule name when customer leave fill no value show error");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_TITLE);

        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_BUTTON).click();

        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_NAME_TEXTFIELD).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_MESSAGE_ERROR_SCHEDULE_NAME_PLEASE_ENTER).getText(),
                "Please enter a schedule name",
                "Is Show Error Inline Please enter a schedule name"
        );
        createScreenShot("System Show Error Inline Please Enter A Schedule Name", true);
        Thread.sleep(500);

        context.findElement(OneAppElementKeys.PB3_SET_SCHEDULE_NAME_TEXTFIELD).click();
        pressKeyBoardWithString("qa");
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_MESSAGE_ERROR_SCHEDULE_NAME_MUST_BE_BETWEEN).getText(),
                "Must be between 3-70 Characters.",
                "Is Show Error Inline Must be between 3-70 Characters."
        );
        createScreenShot("System Show Error Inline Must be between 3-70 Characters.", true);
        Thread.sleep(500);
    }

    @Test(groups = "Validate SetSchedule OwnTransfer", priority = 4)
    public void testValidateAmountOfTimeWhenNotFillAmount() throws IOException, InterruptedException {
        setScenario("4. Validate amount of time when customer leave fill no value show error");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.PB3_SCHEDULE_RADIO_MONTHLY).click();
        context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_RADIO).click();

        context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_TEXTFIELD).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_TEXTFIELD).getText(),
                "0",
                "When customer not select amount of time value system auto fill zero"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_SCHEDULE_ERROR_AMOUNT_OF_TIME).getText(),
                "Time must be from 1 to 999.",
                "System will show error banner amount of time"
        );
        Thread.sleep(1000);
        createScreenShot("System show error banner amount of time", true);
    }

    @Test(groups = "Validate SetSchedule OwnTransfer", priority = 5)
    public void testValidateAmountOfTimeWhenAmountOverNineHundredNinetyNine() throws IOException {
        setScenario("5. Validate amount of time when customer fill amount of time over 999");
        TtbTestContext context = getTtbTestContext();

        context.findElement(OneAppElementKeys.PB3_SCHEDULE_FREQUENCY_AMOUNTOFTIMES_TEXTFIELD).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ONE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_SCHEDULE_ERROR_AMOUNT_OF_TIME).getText(),
                "Time must be from 1 to 999.",
                "System will show error banner amount of time"
        );

        createScreenShot("System show error banner amount of time", true);
    }
}
