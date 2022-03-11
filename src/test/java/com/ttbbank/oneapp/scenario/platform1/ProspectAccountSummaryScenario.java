package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProspectAccountSummaryScenario extends Platform1Base {

    @Test(groups = "AccountSummary Group", priority = 1)
    public void testAccountSummaryTabDeposit() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Account Summary: Tab Deposit");
        addLogInfo("Start Testing");

        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).getText(),
                "Deposit"
        );

        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText(),
                "ttb deposit account"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION).getText(),
                "A day-to-day savings account to help you save money, with high interest from the first baht you put in."
        );

        onClickBtnRegisterTTB();
        addLogInfo("End Testing");
    }

    @Test(groups = "AccountSummary Group", priority = 2)
    public void testAccountSummaryTabCard() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Account Summary: Tab Card");
        addLogInfo("Start Testing");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).getText(),
                "Card"
        );

        evaluateAssertEqual(
                OneAppElementKeys.PRODUCT_INTRO_TITLE,
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText(),
                "ttb card"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION).getText(),
                "Apply ttb credit card & flash cash card"
        );

        onClickBtnRegisterTTB();
        addLogInfo("End Testing");
    }

    @Test(groups = "AccountSummary Group", priority = 3)
    public void testAccountSummaryTabInvestment() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Account Summary: Tab Investment");
        addLogInfo("Start Testing");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INVESTMENT).getText(),
                "Investment"
        );

        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INVESTMENT).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText(),
                "ttb investment account"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION).getText(),
                "Create wealth opportunities with mutual funds from 11 leading AMCs."
        );

        onClickBtnRegisterTTB();
        addLogInfo("End Testing");
    }

    @Test(groups = "AccountSummary Group", priority = 4)
    public void testAccountSummaryTabLoan() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Account Summary: Tab Loan");
        addLogInfo("Start Testing");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_LOAN).getText(),
                "Loan"
        );

        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_LOAN).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText(),
                "ttb loan account"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION).getText(),
                "Special interest rates just for you, because we value you."
        );

        onClickBtnRegisterTTB();
        addLogInfo("End Testing");
    }

    @Test(groups = "AccountSummary Group", priority = 5)
    public void testAccountSummaryTabInsurance() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("Account Summary: Tab Insurance");
        addLogInfo("Start Testing");
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INSURANCE).getText(),
                "Insurance"
        );

        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INSURANCE).click();
        evaluateAssertEqual(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_TITLE).getText(),
                "ttb insurance"
        );
        evaluateAssertEqualWithImg(
                context.findElement(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION).getText(),
                "Let’s explore the right insurance coverage with ttb"
        );

        onClickBtnRegisterTTB();
        addLogInfo("End Testing");
    }

    public void onClickBtnRegisterTTB() {
        TtbTestContext context = getTtbTestContext();
        Assert.assertEquals(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText(), "My Account");
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION).getText();
        Assert.assertTrue(registerButtonText.contains("Register ttb touch"));
        context.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION).click();
        if (context.isAndroid()) {
            Assert.assertEquals(context.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText(), "Terms and Conditions");
            context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_BACK_FROM_TNC);
            context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_BACK_FROM_TNC).click();
            context.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION).click();
            context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_BACK_FROM_TNC);
            context.back();
        } else {
            Assert.assertEquals(context.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText(), "Terms and Conditions");
            context.waitUntilVisible(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON);
            context.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON).click();
        }
    }

}
