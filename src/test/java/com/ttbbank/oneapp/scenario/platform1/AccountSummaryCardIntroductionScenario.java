package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountSummaryCardIntroductionScenario extends Platform1Base {
    @Test(groups = "Account Summary Card Product Introduction Group", priority = 1)
    public void testCustomerLoginToAccountSummary() {
        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT);
    }

    @Test(groups = "Account Summary Card Product Introduction Group", priority = 2)
    public void testCustomerSelectCardOnMenuTab() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("10. Customer select \"Card\" or swipe to \"Card\" on header menu bar.");
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText().equals("My Account"), "Show Account Summary screen");
        if (context.isAndroid()) {
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected(), "Display header menu bar and highlight \"Card\" menu");
        }
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_IMAGE).isDisplayed(), "Display Product Introduction Icon");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb card"), "Display Text title to announce that customer not have product yet.");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_CONTENT).getText().equals("Fulfill your lifestyle needs with a ttb credit card & flash cash card."), "Display Text content");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA).getText().contains("Apply Credit Card"), "Display apply for a credit card\" button");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_HYPER_LINK1).getText().contains("Apply flash cash card"), "Display apply for a flash cash card\" hyper link");
        createScreenShot("Show Product Introduction Screen", true);
    }

    @Test(groups = "Account Summary Card Product Introduction Group", priority = 3)
    public void testCustomerClickApplyCreditCardButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("11. Click on \"Apply Credit Card\" button");
        context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA).click();
        context.waitUntilVisible(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_TITLE);
        String applyCreditCardTitleLabel = "บัตรเครดิต";
        Thread.sleep(3000);
        createScreenShot("System navigate to Credit card product list screen and  Display language in Thai.", ttbTestContext.findElement(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_TITLE).getText().equals(applyCreditCardTitleLabel));
    }

    @Test(groups = "Account Summary Card Product Introduction Group", priority = 4)
    public void testCustomerPressBackButtonFromCreditCardProductListScreen() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("12. Customer press back button from Credit card product list screen");
        context.findElement(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD);
        if (context.isIos()) {
            boolean isDisplayCardIntroduction = context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb card");
            createScreenShot("System navigate back to Account summary card introduction screen and highlight Card on header menu bar.", isDisplayCardIntroduction);
        }
         if (context.isAndroid()) {
             boolean isSelectedTabCard = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected();
             boolean isDisplayCardIntroduction = context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb card");
             createScreenShot("System navigate back to Account summary card introduction screen and highlight Card on header menu bar.", isSelectedTabCard && isDisplayCardIntroduction);
         }
    }

    @Test(groups = "Account Summary Card Product Introduction Group", priority = 5)
    public void testCustomerClickApplyFlashCashCardButton() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("13. Click on \"Apply flash cash card\" button");
        context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_HYPER_LINK1).click();
        context.waitUntilVisible(OneAppElementKeys.APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON);
        WebElement applyFlashCashCardActualTitleLabel = context.findElement(OneAppElementKeys.APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON);
        Thread.sleep(3000);
        createScreenShot("System navigate to Flash card product detail screen and  Display language in Thai.", applyFlashCashCardActualTitleLabel.getText().equals("สมัครบัตรกดเงินสด แฟลช"));
    }

    @Test(groups = "Account Summary Card Product Introduction Group", priority = 6)
    public void testCustomerPressBackButtonFromFlashCashCardProductDetailScreen() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("14. Customer press back button from Flash card product detail screen");
        context.findElement(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD);
        if (context.isIos()) {
            boolean isDisplayCardIntroduction = context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb card");
            createScreenShot("System navigate back to Account summary card introduction screen and highlight Card on header menu bar.",isDisplayCardIntroduction);
        }
        if (context.isAndroid()) {
            boolean isSelectedTabCard = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected();
            boolean isDisplayCardIntroduction = context.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE).getText().equals("You don't have a ttb card");
            createScreenShot("System navigate back to Account summary card introduction screen and highlight Card on header menu bar.", isSelectedTabCard && isDisplayCardIntroduction);
        }
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }
}
