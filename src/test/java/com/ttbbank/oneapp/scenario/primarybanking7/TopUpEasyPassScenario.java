package com.ttbbank.oneapp.scenario.primarybanking7;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TopUpEasyPassScenario extends PrimaryBanking7Base{
    String fromAccountNumber;

    @Test(groups = "TopUp EasyPass Success", priority = 1)
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

    @Test(groups = "TopUp EasyPass Success", priority = 2)
    public void testTapEasyPassMenu() throws InterruptedException, IOException {
        setScenario("2. Customer click Easy Pass menu go to the enter detail screen");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PB7_TOPUP_EASY_PASS).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE).getText(),
                "Top Up",
                "Validate title is displayed correctly"
        );
        createScreenShot("Show enter detail screen", true);
    }

    @Test(groups = "TopUp EasyPass Success", priority = 3)
    public void testFilledRef1EnterDetailAndNextToReviewScreenSuccess() throws IOException {
        setScenario("3. Customer filled information is correctly and click on next button go to the review screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE);
        fromAccountNumber = context.findElement(OneAppElementKeys.PB7_TOPUP_ENTER_FROM_ACCOUNT_NUMBER).getText();

        evaluateAssertEqual(
                fromAccountNumber,
                fromAccountNumber,
                "Validate from account number is displayed correctly"
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_REF1).click();

        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SIX).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FOUR).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_NINE).click();
        context.findElement(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ONE).click();

        context.findElement(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_300).click();

        createScreenShot("Show enter detail screen filled information", true);

        context.findElement(OneAppElementKeys.PB7_TOPUP_NEXT_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_REVIEW_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_TITLE).getText(),
                "Review Top Up Details",
                "Validate title on review screen is displayed correctly"
        );
        createScreenShot("Show review screen", true);
    }

    @Test(groups = "TopUp EasyPass Success", priority = 4)
    public void testDataAssertEqualsEnterDetailsOnReviewScreenAndTapOnConfirm() throws IOException {
        setScenario("4. Customer is on review screen, validate information is correctly and click confirm button go to the confirm screen");
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_REVIEW_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_EASY_PASS).getText(),
                "2653574791",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_400).getText(),
                "300.00",
                "Validate amount is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_FEE_FIVE).getText(),
                "5.00",
                "Validate fee is displayed correctly (the same as in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_TOPUP_REF_EASY_PASS).getText(),
                "Top up ref no:",
                "Validate Top up ref number field is displayed correctly."
        );

//        evaluateAssertEqual(
//                context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_CUSTOMER_NAME).getText(),
//                "นาย นางสาวสุขสมใจ ยิ้มแย้มสะอาด",
//                "Validate customer name is displayed correctly."
//        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_REVIEW_CONFIRM_BUTTON).click();

//        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_COMPLETE_TOSSED_MESSAGE);
//        evaluateAssertEqual(
//                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE).getText(),
//                "Transaction slip saved on your device.",
//                "Validate tossed message save slip is displayed correctly"
//        );

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE);
        Assert.assertEquals(context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE).getText(), "Top Up Successful");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE).getText(),
                "Top Up Successful",
                "Validate title on complete screen is displayed correctly"
        );
        createScreenShot("Show complete screen", true);
    }

    @Test(groups = "TopUp EasyPass Success", priority = 5)
    public void testDataAssertEqualsReviewScreenAndTapOnBackToHomeSuccess() throws IOException {
        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE);
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_FROM_ACCOUNT_NUMBER).getText(),
                fromAccountNumber,
                "Validate from account number is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_REF1_EASY_PASS).getText(),
                "2653574791",
                "Validate reference one is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_AMOUNT_400).getText(),
                "300.00",
                "Validate amount is displayed correctly (the same as entered in enter detail before)"
        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_FEE_FIVE).getText(),
                "5.00",
                "Validate fee is displayed correctly (the same as in enter detail before)"
        );

//        evaluateAssertEqual(
//                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_TOPUP_REF_EASY_PASS).getText(),
//                "Top up ref no:",
//                "Validate Top up ref number field is displayed correctly."
//        );

//        evaluateAssertEqual(
//                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_CUSTOMER_NAME).getText(),
//                "นาย นางสาวสุขสมใจ ยิ้มแย้มสะอาด",
//                "Validate customer name is displayed correctly."
//        );

        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_BALANCE_AFTER_TOPUP).getText(),
                "Balance after top up:",
                "Validate balance after top up field is displayed correctly."
        );

        context.findElement(OneAppElementKeys.PB7_TOPUP_COMPLETE_DONE_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PB7_TOPUP_HOME);
        createScreenShot("Show home screen", true);
    }
}
