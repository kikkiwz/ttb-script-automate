package com.ttbbank.oneapp.scenario.primarybanking3.validation;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.PrimaryBanking3Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OwnTransferCaseValidateEnterDetailsScenario extends PrimaryBanking3Base {
    @Test(groups = "Transfer Own TTB Validate Flow", priority = 1)
    public void testLoginWithPinSuccessWhenClickTransfer() throws IOException {
        setScenario("1. Customer \"Click Transfer\"");
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.TRANSFER_BUTTON).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE).getText(),
                "Enter PIN",
                "Show BottomSheet Login"
        );
        createScreenShot("Show BottomSheet Login After Click Transfer", true);
        pressPin("010203");

        setScenario("2. System navigate to transfer landing");
        context.waitUntilVisible(OneAppElementKeys.PB3_TITLE_TRANSFER_LANDING);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.TRANSFER_TITLE).getText(),
                "Transfer",
                "Navigated Transfer Landing"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_OWN_MENU).getText(),
                "Own ttb account",
                "Is Show Own Menu"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_OTHER_MENU).getText(),
                "Other Accounts",
                "Is Show Other Accounts"
        );
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_PROMPT_PAY_MENU).getText(),
                "Promptpay",
                "Is Show PromptPay"
        );
        createScreenShot("Show transfer landing", true);
    }

    @Test(groups = "Transfer Own TTB Validate Flow", priority = 2)
    public void testTapOnOwnTransferMenu() throws InterruptedException, IOException {
        setScenario("3. Customer click \"Own ttb account\"");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PB3_TRANSFER_OWN_MENU).click();
        context.waitUntilVisible(OneAppElementKeys.PB3_ENTER_DETAILS_SELECT_TO_ACCOUNT_BUTTON);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_TRANSFER_ENTER_DETAILS_TITLE).getText(),
                "Transfer",
                "Is Show Enter Details Own TTB"
        );
        createScreenShot("System Navigate to Enter Details Own TTB", true);
    }

    @Test(groups = "Transfer Own TTB Validate Flow", priority = 3)
    public void testValidateToAccountCaseEmpty() throws IOException {
        setScenario("4. Customer can't select account show error inline");
        TtbTestContext context = getTtbTestContext();

        addLogInfo("Customer click to account text field");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_SELECT_TO_ACCOUNT_BUTTON).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAIL_TO_ACCOUNT_BOTTOM_SHEET_CLOSE_ICON).click();
        addLogInfo("Customer click close bottom sheet");
        context.waitUntilVisible(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_SELECTED_TO_ACCOUNT);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_SELECTED_TO_ACCOUNT).getText(),
                "Please select destination account.",
                "Is Show Error Inline Please select destination account."
        );
        createScreenShot("Show Error Inline ToAccount TextField", true);
    }

    @Test(groups = "Transfer Own TTB Validate Flow", priority = 4)
    public void testEnterAmountEmptyShouldShowErrorInline() throws IOException {
        setScenario("5. Customer can't enter amount should show error inline");
        TtbTestContext context = getTtbTestContext();

        addLogInfo("Customer click enter amount text field");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_AMOUNT_TEXT_FIELD_BUTTON).click();
        addLogInfo("Customer click done text field");
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.waitUntilVisible(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_FILLED_AMOUNT);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_FILLED_AMOUNT).getText(),
                "Please enter an amount.",
                "Is Show Error Inline Please enter an amount."
        );
        createScreenShot("Show Error Inline Please enter an amount", true);
    }

    @Test(groups = "Transfer Own TTB Validate Flow", priority = 5)
    public void testEnterZeroAmountShouldShowErrorInline() throws IOException {
        setScenario("6. Customer enter amount zero should show error inline");
        TtbTestContext context = getTtbTestContext();

        addLogInfo("Customer click enter amount text field");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_AMOUNT_TEXT_FIELD_BUTTON).click();
        addLogInfo("Customer enter amount 0");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO).click();
        addLogInfo("Customer click done text field");
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.waitUntilVisible(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_FILLED_AMOUNT);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_NO_FILLED_AMOUNT).getText(),
                "Please enter an amount.",
                "Is Show Error Inline Please enter an amount."
        );
        createScreenShot("Show Error Inline Please enter an amount", true);
    }

    @Test(groups = "Transfer Own TTB Validate Flow", priority = 6)
    public void testEnterAmountGreaterThanCurrentAmountShouldShowErrorInline() throws IOException {
        setScenario("7. Customer enter amount greater than current amount should show error inline");
        TtbTestContext context = getTtbTestContext();

        addLogInfo("Customer click enter amount text field");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_AMOUNT_TEXT_FIELD_BUTTON).click();
        addLogInfo("Customer enter amount 999999999");
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB3_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        addLogInfo("Customer click done text field");
        context.findElement(OneAppElementKeys.PB3_KEYPAD_DONE).click();

        context.waitUntilVisible(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_INSUFFICIENT_FOUNDS);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB3_ENTER_DETAIL_ERROR_INSUFFICIENT_FOUNDS).getText(),
                "Your account has insufficient funds for this transaction.",
                "Is Show Error Inline Your account has insufficient funds for this transaction."
        );

        createScreenShot("Show Error Inline Your account has insufficient funds for this transaction.", true);
    }
}
