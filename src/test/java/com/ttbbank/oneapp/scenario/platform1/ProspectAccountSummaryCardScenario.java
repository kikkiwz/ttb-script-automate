package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProspectAccountSummaryCardScenario extends Platform1Base {
    @Test(groups = "Prospect Account Summary Card Group", priority = 1)
    public void testCustomerClickAccountSummary() {
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
    }

    @Test(groups = "Prospect Account Summary Card Group", priority = 2)
    public void testCustomerSelectCardOnMenuTabProspect() throws IOException {
        setScenario("39. Customer select \"Card\" or swipe to \"Card\" on header menu bar.");
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).click();
        if (ttbTestContext.isAndroid()) {
            boolean isSelectedTabCard = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected();
            boolean isDisplayCardIntroduction = ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT).getText().equals("ttb card");
            createScreenShot("System navigate to Account summary card introduction screen and highlight Card on header menu bar.", isSelectedTabCard && isDisplayCardIntroduction);
        } else {
            boolean isDisplayCardIntroduction = ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT).getText().equals("ttb card");
            createScreenShot("System navigate to Account summary card introduction screen and highlight Card on header menu bar.", isDisplayCardIntroduction);
        }
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText().equals("My Account"), "Show Account Summary screen");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_IMAGE_PROSPECT).isDisplayed(), "Display Image Product");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT).getText().equals("ttb card"), "Display Text title\"ttb card\"");
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_CONTENT_PROSPECT).getText().equals("Fulfil your lifestyle needs with a ttb credit card & flash cash card."), "Display Text content");
        System.out.println("Print CTA " + ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT).getText());
        evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT).getText().contains("Register ttb touch"), "Display Register ttb touch\"button\"");
        createScreenShot("Show Product Introduction Screen", true);
    }

    @Test(groups = "Prospect Account Summary Card Group", priority = 3)
    public void testCustomerClickRegisterTTBTouchButtonProspect() throws InterruptedException, IOException {
        setScenario("40. Click on \"Register ttb touch\" button");
        ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
        String applyCreditCardTitleLabel = "Terms and Conditions";
        Thread.sleep(3000);
        createScreenShot("System navigate to Terms and Conditions screen and  Display language as per app sitting.", ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText().equals(applyCreditCardTitleLabel));
    }

    @Test(groups = "Prospect Account Summary Card Group", priority = 4)
    public void testCustomerPressBackButtonFromTermAndConditionScreenProspect() throws IOException {
        setScenario("41. Customer press back button from Term And Condition screen");
        ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_BACK_TERM_AND_CONDITION_PROSPECT).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD);
        if (ttbTestContext.isAndroid()) {
            boolean isSelectedTabCard = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected();
            boolean isDisplayCardIntroduction = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText().equals("My Account");
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT).getText().equals("ttb card"), "Display header menu bar and highlight \"Card\" menu");
            createScreenShot("System navigate back to Account summary card introduction screen and highlight Card on header menu bar.", isSelectedTabCard && isDisplayCardIntroduction);
        } else {
            evaluateAssertTrue(ttbTestContext.findElement(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT).getText().equals("ttb card"), "Display header menu bar and highlight \"Card\" menu");
        }
    }
}
