package com.ttbbank.oneapp.scenario.lending;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CashForYouScenario extends BaseScenario {


    @Test(groups = "Lending Cash for you", dependsOnGroups = {"Enter Home Screen VIT Latest", "Enter Card Screen VIT Latest"})
    public void cashForYou() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement cardItem0Button = ttbTestContext.findElement(OneAppElementKeys.CARD_ITEM_0_HOME_SCREEN_BUTTON);
        cardItem0Button.click();
        WebElement cashForYouButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_FOR_YOU_BUTTON);
        cashForYouButton.click();
        WebElement nextCashForYouButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        nextCashForYouButton.click();
        WebElement amountCashForYouInput = ttbTestContext.findElement(OneAppElementKeys.LENDING_AMOUNT_CASH_FOR_YOU_INPUT);
        amountCashForYouInput.sendKeys("10000");
        ttbTestContext.hideKeyboard();
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION);
        WebElement cashTransferPaymentOption = ttbTestContext.findElement(OneAppElementKeys.LENDING_CASH_TRANSFER_PAYMENT_OPTION);
        cashTransferPaymentOption.click();
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        WebElement nextAfterFillInfoCashForYouButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_NEXT_CASH_FOR_YOU_BUTTON);
        nextAfterFillInfoCashForYouButton.click();

    }


}
