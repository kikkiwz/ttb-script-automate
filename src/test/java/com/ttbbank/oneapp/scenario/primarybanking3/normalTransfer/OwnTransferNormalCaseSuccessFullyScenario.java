package com.ttbbank.oneapp.scenario.primarybanking3.normalTransfer;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.PrimaryBanking3Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OwnTransferNormalCaseSuccessFullyScenario extends PrimaryBanking3Base {

    String fromAccountNumber;
    String toAccountNumber;

    @Test(groups = "Transfer Own TTB", priority = 1)
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

    @Test(groups = "Transfer Own TTB", priority = 2)
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

    @Test(groups = "Transfer Own TTB", priority = 3)
    public void testFilledOwnTransferEnterDetailAndNextToReviewScreenSuccess() throws IOException {
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
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();
        context.findElement(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_NOTE_BUTTON).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_N).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_O).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_T).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_E).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_D).click();
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_CATEGORY_BUTTON).click();
        createScreenShot("Show enter detail screen filled information", true);

        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_NEXT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_REVIEW_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_TITLE).getText(),
                "Review Transfer Details",
                "Validate title on review screen is displayed correctly"
        );
        createScreenShot("Show review screen", true);
    }

    @Test(groups = "Transfer Own TTB", priority = 4)
    public void testDataAssertEqualsEnterDetailsOnReviewScreenAndTapOnConfirm() throws IOException {
        setScenario("4. Customer is on review screen, validate information is correctly and click confirm button go to the confirm screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_REVIEW_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_TO_ACCOUNT_NUMBER).getText(),
                toAccountNumber,
                "Validate to account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_AMOUNT).getText(),
                "1,000.00",
                "Validate amount is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_NOTE).getText(),
                "Noted",
                "Validate note is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_CATEGORY).getText(),
                "Savings & Investment",
                "Validate category is displayed correctly (the same as entered in enter detail before)"
        );

        context.findElement(OneAppElementKeys.PB3_TRANSFER_REVIEW_CONFIRM).click();
        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_COMPLETE_TRANSFER_SUCCESSFULLY);
        Assert.assertEquals(context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_TRANSFER_SUCCESSFULLY).getText(), "Transfer Successful");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_TRANSFER_SUCCESSFULLY).getText(),
                "Transfer Successful",
                "Validate title on complete screen is displayed correctly"
        );
        createScreenShot("Show complete screen", true);
    }

    @Test(groups = "Transfer Own TTB", priority = 5)
    public void testDataAssertEqualsReviewScreenAndTapOnBackToHomeSuccess() throws IOException {
        setScenario("5. Customer is on complete screen, validate information is correctly and done button go to the home screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB3_TRANSFER_COMPLETE_TRANSFER_SUCCESSFULLY);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as review screen)"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_TO_ACCOUNT_NUMBER).getText(),
                toAccountNumber,
                "Validate to account number is displayed correctly (the same as review screen)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_AMOUNT_VALUE).getText(),
                "1,000.00",
                "Validate amount is displayed correctly (the same as review screen)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_NOTE).getText(),
                "Note: Noted",
                "Validate note is displayed correctly (the same as review screen)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_CATEGORY).getText(),
                "Category: Savings & Investment",
                "Validate category is displayed correctly (the same as review screen)"
        );
        context.findElement(OneAppElementKeys.PB3_TRANSFER_COMPLETE_BACK_TO_HOME).click();
        context.waitUntilVisible(OneAppElementKeys.TRANSFER_BUTTON);
        createScreenShot("Show home screen", true);
    }
}
