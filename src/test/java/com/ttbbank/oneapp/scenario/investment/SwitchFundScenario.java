package com.ttbbank.oneapp.scenario.investment;


import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwitchFundScenario extends InvestmentHomeScenario {

    @Test(groups = "Switch Fund", dependsOnGroups = "Enter Investment Home")
    public void switchFound() {

        TtbTestContext context = getTtbTestContext();
        WebElement moreButton = context.findElement(OneAppElementKeys.INVESTMENT_MY_MUTUAL_FUND_MORE_BUTTON);
        moreButton.click();

        WebElement switchButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SWITCH_BUTTON);
        switchButton.click();

        WebElement sourceFundCode = context.findElement(OneAppElementKeys.INVESTMENT_SOURCE_FUND_CODE);
        sourceFundCode.click();

        WebElement targetFundCode = context.findElement(OneAppElementKeys.INVESTMENT_TARGET_FUND_CODE);
        targetFundCode.click();

//        WebElement contextAgreement = context.findElement(OneAppElementKeys.INVESTMENT_CONTENT_AGREEMENT);
//        contextAgreement.click();
//
//        context.scrollTillElementIntoDisplay("//android.widget.Button[@resource-id='fund-fact-sheet-next-button']");

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_NEXT_BUTTON);
        System.err.println(nextButton.getText());
        nextButton.click();

        WebElement amountTextArea = context.findElement(OneAppElementKeys.INVESTMENT_AMOUNT_TEXT_AREA);
        amountTextArea.sendKeys("100.00");

        WebElement switchNextButton = context.findElement(OneAppElementKeys.INVESTMENT_SWITCH_NEXT_BUTTON);
        switchNextButton.click();

        WebElement agreeMentAccept = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_AGREEMENT_LABEL);
        agreeMentAccept.click();

        WebElement confirmNextButton = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_NEXT_BUTTON);
        confirmNextButton.click();

    }
}
