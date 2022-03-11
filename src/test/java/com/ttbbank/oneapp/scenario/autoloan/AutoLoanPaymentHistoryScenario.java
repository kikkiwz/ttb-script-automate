package com.ttbbank.oneapp.scenario.autoloan;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

public class AutoLoanPaymentHistoryScenario extends AutoLoanHomeScenario {


    @Test(groups = "Payment History", dependsOnGroups = "Enter Loan Home")
    public void paymentHistory() {
        TtbTestContext context = getTtbTestContext();
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
            context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_INSTALMENT_LABEL);
            context.verticalSwipeByPercentages(0.5, .02, 0.5);
            context.verticalSwipeByPercentages(0.7, .06, 0.5);
            context.verticalSwipeByPercentages(0.3, .02, 0.5);
            context.verticalSwipeByPercentages(0.4, .02, 0.5);
            context.findElement(OneAppElementKeys.AUTO_LOAN_PAYMENT_HISTORY_BTN).click();
            context.findElement(OneAppElementKeys.AUTO_LOAN_PAYMENT_LIST_1ST).click();
            return;

        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_PAYMENT_HISTORY_BTN);
        context.swipeUpByElements(OneAppElementKeys.AUTO_LOAN_DETAIL,.05,0.3);
        context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_PAYMENT_HISTORY_BTN);
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAYMENT_HISTORY_BTN).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_PAYMENT_LIST_1ST).click();
    }

}
