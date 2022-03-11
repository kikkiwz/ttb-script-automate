package com.ttbbank.oneapp.scenario.investment;


import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SellFundScenario extends InvestmentHomeScenario {

    @Test(groups = "Sell Fund", dependsOnGroups = "Enter Investment Home")
    public void sellFund() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        WebElement moreButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_MORE_BUTTON);
        moreButton.click();

        WebElement switchButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SWITCH_BUTTON);
        switchButton.click();


        WebElement sellButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_SELL_BUTTON);
        sellButton.click();

        WebElement sellFund = context.findElement(OneAppElementKeys.INVESTMENT_SELECTED_FUND_CODE);
        sellFund.click();

        WebElement enterAmount = context.findElement(OneAppElementKeys.INVESTMENT_SELL_INPUT_AMOUNT_TEXT);
        enterAmount.clear();
        Thread.sleep(500);
        enterAmount.sendKeys("100.00");

        WebElement frontEndFee = context.findElement(OneAppElementKeys.INVESTMENT_SELL_FRONT_END_FEE_LABEL);
        frontEndFee.click();

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_SELL_NEXT_BUTTON);
        nextButton.click();

        WebElement confirmRiskAccept = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_RISK_ACCEPT_CHECKBOX);
        confirmRiskAccept.click();

        WebElement confirmButton = context.findElement(OneAppElementKeys.INVESTMENT_SELL_CONFIRM_CONFIRM_BUTTON);
        confirmButton.click();

        enterPin();

        WebElement backToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETE_BACK_TO_INVESTMENT_BUTTON);
        backToInvestmentButton.click();

    }
}
