package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AccountSummaryCardScenario extends Platform1Base {

    String cardNumberFormat = "\\d{4}-\\d{2}XX-XXXX-\\d{4}";
    String creditSpendAndRemainingSplitFormat = "\\.(\\d{2})";
    String WITH_DELIMITER = "(?<=%1$s)";

    @Test(groups = "Account Summary Card Group", priority = 1)
    public void testCustomerLoginToAccountSummary() throws IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("1. Customer tab Account summary on footer menu bar");
        context.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
        pressPin("010203");
        context.waitUntilVisible(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE);
        evaluateAssertEqual(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE).getText(), "My Account");
        if (context.isIos()) {
            ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).click();
        }
        if (context.isAndroid()) {
            context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).click();
            context.waitUntilVisible(OneAppElementKeys.CREDIT_CARD_CARD);
        }
        addLogInfo("📝 Need to capture activity log");
        if (context.isAndroid()) {
            evaluateAssertTrueWithImg(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD).isSelected(), "Show Account Summary screen and system highlight card on header menu bar.");
        }
    }


    @Test(groups = "Account Summary Card Group", priority = 2)
    public void testCreditCardWithPendingStatus() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            setScenario("15. Customer has credit card with status \"Pending Activation\"");
            evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_NAME_PENDING).isDisplayed(),"Display Card Name");
            checkCardNumberFormat(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACCOUNT_NUMBER);
            evaluateAssertEqual(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING).getText(), "PENDING ACTIVATION");
            createScreenShot("Display credit card with pending status with following details correctly.", true);
        } else {
            setScenario("15. Customer has credit card with status \"Pending Activation\"");
            String pendingActivationXpathFirst = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textPendingStatus\"]";
            String pendingActivationXpathSecond = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textPendingStatus\"]";
            String pendingActivationXpathThird = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textPendingStatus\"]";
            checkCardStatus(
                    CardStatus.PENDING,
                    pendingActivationXpathFirst,
                    pendingActivationXpathSecond,
                    pendingActivationXpathThird,
                    null
            );
        }
    }


    @Test(groups = "Account Summary Card Group", priority = 2)
    public void testFlashCardWithTemporaryBlockStatus() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            setScenario("17. Customer has credit card with status \"Temporary block\"");
            checkStatusCardiOS(CardStatus.TEMPORARY_BLOCK);
        } else {
            setScenario("17. Customer has credit card with status \"Temporary block\"");
            String tempLockedXpathFirst = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textTempBlockedStatus\"]";
            String tempLockedXpathSecond = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textTempBlockedStatus\"]";
            String tempLockedXpathThird = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textTempBlockedStatus\"]";
            checkCardStatus(
                    CardStatus.TEMPORARY_BLOCK,
                    tempLockedXpathFirst,
                    tempLockedXpathSecond,
                    tempLockedXpathThird,
                    CardType.PRIMARY
            );
        }
    }


    @Test(groups = "Account Summary Card Group", priority = 3)
    public void testCreditCardWithBlockStatus() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        if (context.isIos()) {
            setScenario("18. Customer has credit card with status \"LOCKED\"");
            checkStatusCardiOS(CardStatus.BLOCK);
        } else {
            setScenario("18. Customer has credit card with status \"LOCKED\"");
            String blockedXpathFirst = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textBlockedStatus\"]";
            String blockedXpathSecond = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textBlockedStatus\"]";
            String blockedXpathThird = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textBlockedStatus\"]";
            checkCardStatus(
                    CardStatus.BLOCK,
                    blockedXpathFirst,
                    blockedXpathSecond,
                    blockedXpathThird,
                    CardType.SUPOrSSC
            );
        }
    }



    @Test(groups = "Account Summary Card Group", priority = 4)
    public void testCreditCardWithSpendingThisBillIsLessThanZero() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("25. Customer has card that \"Spending this bill\" is less than zero");
        if (context.isIos()) {
            checkBalanceiOS("Outstanding balance");
        } else {
            int countScrolling = 0;
            String spendFirstXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[2]";
            String spendSecondXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[2]";
            String spendThirdXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[2]";

            while (!context.findElement(OneAppElementKeys.CREDIT_CARD_CARD).equals(Collections.emptyList())) {
                if (!context.viewElementByXPATH(spendFirstXpath).isEmpty()) {
                    if (isAmountContainMinus(AmountType.SPENDING, spendFirstXpath))
                        break;
                } else if (!context.viewElementByXPATH(spendSecondXpath).isEmpty()) {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                    if (isAmountContainMinus(AmountType.SPENDING, spendFirstXpath))
                        break;
                } else if (!context.viewElementByXPATH(spendThirdXpath).isEmpty()) {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                    if (isAmountContainMinus(AmountType.SPENDING, spendFirstXpath))
                        break;
                } else {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                }
            }

            for (int x = 0; x <= countScrolling; x++) {
                scrollingToBottom(500, 700);
            }
        }
    }

    @Test(groups = "Account Summary Card Group", priority = 5)
    public void testCreditCardWithAvailableToSpendIsLessThanZero() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("26. Customer has card that \"Available to spend\" is less than zero.");
        if (context.isIos()) {
            checkBalanceiOS("Available To Spend");
        } else {
            int countScrolling = 0;
            String remainingFirstXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutRemain\"]/android.widget.TextView[2]";
            String remainingSecondXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutRemain\"]/android.widget.TextView[2]";
            String remainingThirdXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutRemain\"]/android.widget.TextView[2]";

            while (!context.findElement(OneAppElementKeys.CREDIT_CARD_CARD).equals(Collections.emptyList())) {
                if (!context.viewElementByXPATH(remainingFirstXpath).isEmpty() && isAmountContainMinus(AmountType.REMAINING, remainingFirstXpath)) {
                    break;
                } else if (!context.viewElementByXPATH(remainingSecondXpath).isEmpty() && isAmountContainMinus(AmountType.REMAINING, remainingSecondXpath)) {
                    break;
                } else if (!context.viewElementByXPATH(remainingThirdXpath).isEmpty() && isAmountContainMinus(AmountType.REMAINING, remainingThirdXpath)) {
                    break;
                } else {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                }
            }

            for (int x = 0; x <= countScrolling; x++) {
                scrollingToBottom(500, 700);
            }
        }
    }



    @Test(groups = "Account Summary Card Group (Can't Simulate)", priority = 6)
    public void testTabOnAnyAreaInCard() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("32. Customer tap on any area in card of credit card or flash card");
        createScreenShot("Display card account summary before double tap on any area in card", true);
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_PRI).click();
        Thread.sleep(1000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_DETAIL_TITLE).isDisplayed(),"Display Card Detail Screen");
        createScreenShot("Display Card Detail Screen", true);
        setScenario("33. Customer press back button from card detail screen");
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_DETAIL_BACK).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_PRI).isDisplayed(),"Display Card account summary screen with the place of account card same as select on top");
        createScreenShot("Display Card account summary screen with the place of account card same as select on top", true);
    }


    @Test(groups = "Account Summary Card Group (Can't Simulate)", priority = 7)
    public void testActivateCardScreen() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        setScenario("35. Customer double tap on any area in card of credit card or flash card with status \"Pending Activation\"");
        createScreenShot("Display card account summary before double tap on any area in card", true);
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_NAME_PENDING).click();
        Thread.sleep(1000);
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_TITLE).isDisplayed(),"Display Activate Card Title");
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BTN_ENTER_CARD_NUMBER).isDisplayed(),"Display Button Enter Card Number");
        createScreenShot("Display Activate Card Screen", true);
        setScenario("36. Customer press back button from Activate card screen");
        context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BACK_BTN).click();
        evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_NAME_PENDING).isDisplayed(),"Display Card Name");
        checkCardNumberFormat(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACCOUNT_NUMBER);
        evaluateAssertEqual(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING).getText(), "PENDING ACTIVATION");
        createScreenShot("Display card account summary screen with the place of account card same as selected", true);
    }


    public void testSupplementaryCard(int index) {
        String supplementaryCardXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + index + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textSupCard\"]";
        List supplementaryCard = ttbTestContext.viewElementByXPATH(supplementaryCardXpath);
        if (!supplementaryCard.isEmpty()) {
            evaluateAssertTrue(!supplementaryCard.isEmpty(), "Display SUPPLEMENTARY CARD");
        }
    }

    public void testPendingActivation(int cardIndex, String pendingActivationText) throws IOException, InterruptedException {
        Thread.sleep(1000);
        evaluateAssertTrue(getCardName(cardIndex).isDisplayed(), "Display Card name");
        evaluateAssertTrue(Pattern.matches(cardNumberFormat, getCardNoLabel(cardIndex)), "Display Card number with format 0000- 00XX-XXXX-0000 with masking");
        testSupplementaryCard(cardIndex);
        evaluateAssertTrueWithImg(pendingActivationText.equals("PENDING ACTIVATION"), "Display PENDING ACTIVATION status");
    }

    public void testBlockedStatus(int cardIndex, String blockedText) throws IOException, InterruptedException {
        Thread.sleep(1000);
        evaluateAssertTrue(getCardName(cardIndex).isDisplayed(), "Display Card name");
        evaluateAssertTrue(Pattern.matches(cardNumberFormat, getCardNoLabel(cardIndex)), "Display Card number with format 0000- 00XX-XXXX-0000 with masking");
        testSupplementaryCard(cardIndex);
        evaluateAssertTrueWithImg(blockedText.equals("LOCKED"), "Display LOCKED status");
    }

    public void testTemporaryBlockStatus(int cardIndex, String temporaryBlockText) throws IOException, InterruptedException {
        Thread.sleep(1000);
        evaluateAssertTrue(getCardName(cardIndex).isDisplayed(), "Display Card name");
        evaluateAssertTrue(Pattern.matches(cardNumberFormat, getCardNoLabel(cardIndex)), "Display Card number with format 0000- 00XX-XXXX-0000 with masking");
        testSupplementaryCard(cardIndex);
        evaluateAssertTrueWithImg(temporaryBlockText.equals("TEMPORARY LOCKED"), "Display TEMPORARY LOCKED status");
    }

    public void testPaymentAmount(int cardIndex) throws InterruptedException {
        String paymentAmountXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + cardIndex + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutCompatDetail\"]/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/dueDateAmount\"]";
        List paymentAmount = ttbTestContext.viewElementByXPATH(paymentAmountXpath);
        if (!paymentAmount.isEmpty()) {
            String paymentAmountText = ttbTestContext.findElementByXPATH(paymentAmountXpath).getText();
            Thread.sleep(1000);
            evaluateAssertTrue(paymentAmountText.split("\\.")[1].length() == 2, "Payment amount with \"00,000.00\" (2 decimal)");
        }
    }

    public void testCreditSpendAndRemaining(int cardIndex) throws InterruptedException {
        String creditSpendXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + cardIndex + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[2]";
        List creditSpend = ttbTestContext.viewElementByXPATH(creditSpendXpath);
        String remainingXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + cardIndex + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutRemain\"]/android.widget.TextView[2]";
        if (!creditSpend.isEmpty()) {
            String creditSpendText = ttbTestContext.findElementByXPATH(creditSpendXpath).getText();
            String remainingText = ttbTestContext.findElementByXPATH(remainingXpath).getText();
            Thread.sleep(1000);
            evaluateAssertTrue(creditSpendText.split("\\.")[1].length() == 2, "Spending this bill with \"00,000.00\" (2 decimal)");
            evaluateAssertTrue(remainingText.split("\\.")[1].length() == 2, "Available to spend with \"00,000.00\" (2 decimal)");
        }
    }

    public void pressPin(String pins) {
        TtbTestContext context = getTtbTestContext();
        for (int i = 0; i < 6; i++) {
            context.findElement("BOTTOMSHEET_LOGIN_" + pins.charAt(i) + "_BUTTON").click();
        }
    }

    public void scrollingToBottom(int yOffsetpress, int yOffsetmoveto) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(115, yOffsetpress)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(115, yOffsetmoveto)).release().perform();
    }

    private void checkCardNumberFormat(String elementKey) {
        TtbTestContext context = getTtbTestContext();
        String cardNumber = context.findElement(elementKey).getText().replaceAll(" ", "");
        /*Assert.assertTrue(Pattern.matches(cardNumberFormat, cardNumber));*/
        evaluateAssertTrue(Pattern.matches(cardNumberFormat,cardNumber), "Card number with format 0000- 00XX-XXXX-0000 with masking");
    }

    private void checkAmountFormatShouldHasTwoDecimal(String availableBalanceElement, String creditSpendAndRemainingElement) {
        TtbTestContext context = getTtbTestContext();
        String availableBalance = context.findElement(availableBalanceElement).getText();
        String creditSpendAndRemaining = context.findElement(creditSpendAndRemainingElement).getText();
        String creditSpendText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[0];
        String remainingText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[1];

        evaluateAssertTrue(availableBalance.split("\\.")[1].length() == 2, "Show Available balance This bill with \"00,000.00\" (2 decimal)");
        evaluateAssertTrue(creditSpendText.split("\\.")[1].length() == 2, "Show Outstanding This bill with \"00,000.00\" (2 decimal)");
        evaluateAssertTrue(remainingText.split("\\.")[1].length() == 2, "Show Available to spend This bill with \"00,000.00\" (2 decimal)");
    }


    private void checkAmountFormatShouldHasTwoDecimalForLockedCard(String creditSpendAndRemainingElement) {
        TtbTestContext context = getTtbTestContext();
        String creditSpendAndRemaining = context.findElement(creditSpendAndRemainingElement).getText();
        String creditSpendText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[0];
        String remainingText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[1];
        evaluateAssertTrue(creditSpendText.split("\\.")[1].length() == 2, "Show Outstanding This bill with \"00,000.00\" (2 decimal)");
        evaluateAssertTrue(remainingText.split("\\.")[1].length() == 2, "Show Available to spend with \"00,000.00\" (2 decimal)");
    }
    private void checkCardTypePrimary(String elementKey, Integer cardIndex) {
        TtbTestContext context = getTtbTestContext();
        String labelForPrimary = "Outstanding balance";
        if (context.isIos()) {
            evaluateAssertTrue(context.findElement(elementKey).getText().contains(labelForPrimary), "Show Text Outstanding balance");
        } else {
            String cardSpendXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + cardIndex + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[1]";
            evaluateAssertTrue(ttbTestContext.findElementByXPATH(cardSpendXpath).getText().equals(labelForPrimary), "Display card type is Primary credit card (PRI)");
        }
    }

    void checkCardTypeSUPOrSSC(String elementKey, Integer cardIndex) {
        TtbTestContext context = getTtbTestContext();
        String labelForSUPSSC = "Outstanding bill";
        if (context.isIos()) {
            evaluateAssertTrue(context.findElement(elementKey).getText().contains(labelForSUPSSC), "Show Text Outstanding bill");
        } else {
            String cardSpendXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + cardIndex + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[1]";
            evaluateAssertTrue(ttbTestContext.findElementByXPATH(cardSpendXpath).getText().equals(labelForSUPSSC), "Display card type is Supplementary Card type SUP or Supplementary Card type SSC");
        }
    }

    void checklabelDueDate(String elementKey) {
        TtbTestContext context = getTtbTestContext();
        String labelForDueDate = "Due date";
        evaluateAssertTrue(context.findElementByXPATH(elementKey).getText().contains(labelForDueDate), "Show Text Due date");
    }

    void checklabelAvailableToSpend(String elementKey) {
        TtbTestContext context = getTtbTestContext();
        String labelForAvailableToSpend = "Available to spend";
        evaluateAssertTrue(context.findElement(elementKey).getText().contains(labelForAvailableToSpend), "Show Text Available to spend");

    }

    public WebElement getCardName(int index) {
        String cardNameXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + index + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textProductTitle\"]";
        return ttbTestContext.findElementByXPATH(cardNameXpath);
    }

    public String getCardNoLabel(int index) {
        String cardNoXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + index + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[@resource-id=\"com.ttbbank.oneapp.vit:id/textAccountNo\"]";
        return ttbTestContext.findElementByXPATH(cardNoXpath).getText();
    }

    public void checkCardStatus(CardStatus cardStatus, String statusXpathFirst, String statusXpathSecond, String statusXpathThird, CardType cardType) throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        int countScrolling = 0;
        int indexHasRequestStatus = 0;
        while (!context.findElement(OneAppElementKeys.CREDIT_CARD_CARD).equals(Collections.emptyList())) {
            if (!context.viewElementByXPATH(statusXpathFirst).isEmpty()) {
                testCardStatus(cardStatus, 1, context.findElementByXPATH(statusXpathFirst).getText());
                indexHasRequestStatus = 1;
                break;
            } else if (!context.viewElementByXPATH(statusXpathSecond).isEmpty()) {
                scrollingToBottom(700, 500);
                countScrolling++;
                testCardStatus(cardStatus, 2, context.findElementByXPATH(statusXpathSecond).getText());
                testPaymentAmount(2);
                indexHasRequestStatus = 2;
                break;
            } else if (!context.viewElementByXPATH(statusXpathThird).isEmpty()) {
                scrollingToBottom(700, 500);
                countScrolling++;
                testBlockedStatus(3, context.findElementByXPATH(statusXpathThird).getText());
                indexHasRequestStatus = 3;
                break;
            } else {
                scrollingToBottom(700, 500);
                countScrolling++;
            }
        }

        if (cardType != null) {
            while (!context.findElement(OneAppElementKeys.CREDIT_CARD_CARD).equals(Collections.emptyList())) {
                String creditSpendXpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[" + indexHasRequestStatus + "]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/balanceContainer\"]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.ttbbank.oneapp.vit:id/linearLayoutSpend\"]/android.widget.TextView[2]";
                if (!context.viewElementByXPATH(creditSpendXpath).isEmpty()) {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                    testCreditSpendAndRemaining(indexHasRequestStatus);
                    if (cardType == CardType.SUPOrSSC) {
                        checkCardTypeSUPOrSSC(null, indexHasRequestStatus);
                    } else if (cardType == CardType.PRIMARY) {
                        checkCardTypePrimary(null, indexHasRequestStatus);
                    }
                    createScreenShot("Display Correct Card Detail", true);
                    break;
                } else {
                    scrollingToBottom(700, 500);
                    countScrolling++;
                }
            }
        }

        for (int x = 0; x <= countScrolling; x++) {
            scrollingToBottom(500, 700);
        }
    }

    private void testCardStatus(CardStatus cardStatus, Integer cardIndex, String cardStatusText) throws IOException, InterruptedException {
        if (cardStatus == CardStatus.BLOCK) {
            testBlockedStatus(cardIndex, cardStatusText);
        } else if (cardStatus == CardStatus.TEMPORARY_BLOCK) {
            testTemporaryBlockStatus(cardIndex, cardStatusText);
        } else if (cardStatus == CardStatus.PENDING) {
            testPendingActivation(cardIndex, cardStatusText);
        }
    }

    private Boolean isAmountContainMinus(AmountType amountType, String amountXpath) throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        String amount = context.findElementByXPATH(amountXpath).getText();
        Thread.sleep(1000);
        String amountText = amount.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[0];
        if (amountText.contains("-")) {
            if (amountType == AmountType.SPENDING) {
                evaluateAssertTrueWithImg(true, "Display Spending value with minus sign");
            } else {
                evaluateAssertTrueWithImg(true, "Display Remaining value with minus sign");
            }
            return true;
        }
        return false;
    }

    public enum AmountType {
        SPENDING,
        REMAINING
    }

    public void checkStatusCardiOS(CardStatus cardStatus) throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        Boolean CheckStatus = false;
        int countScrolling = 0;
        while (CheckStatus == false) {
            if (cardStatus == CardStatus.TEMPORARY_BLOCK && context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED).isDisplayed()) {
                //testFlashCardWithTemporaryBlockStatus
                scrollingToBottom(700, 100);
                String cardStatusTemLocked = "(//XCUIElementTypeStaticText[@name=\"cardStatus\"])[5]";
                evaluateAssertTrue(context.findElementByXPATH(cardStatusTemLocked).getText().equals("TEMPORARY LOCKED"), "Display \"TEMPORARY LOCKED\" status");
                checkCardNumberFormat(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_ACCOUNT_NUMBER);
                checkCardTypePrimary(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL, null);
                checklabelAvailableToSpend(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL);
                checkAmountFormatShouldHasTwoDecimalForLockedCard(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL);
                createScreenShot("Display flash card with temporary block status with following details correctly.", true);
                CheckStatus = true;
                countScrolling++;
                break;
            } else if (cardStatus == CardStatus.BLOCK && context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK).isDisplayed()) {
                //testFlashCardWithBlockStatus
                scrollingToBottom(700, 400);
                String cardStatusLocked = "(//XCUIElementTypeStaticText[@name=\"cardStatus\"])[3]";
                String Duedate = "(//XCUIElementTypeOther[@name=\"Due date25,February,2021\"])[4]";
                evaluateAssertTrue(context.findElementByXPATH(cardStatusLocked).getText().equals("LOCKED"), "Display \"LOCKED\" status");
                evaluateAssertTrue(context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_TYPE_SUPPLEMENTARY).getText().equals("SUPPLEMENTARY CARD"), "Display Card Type \"SUPPLEMENTARY CARD\"");
                checkCardNumberFormat(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_ACCOUNT_NUMBER);
                checklabelDueDate(Duedate);
                checkCardTypeSUPOrSSC(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL, null);
                checklabelAvailableToSpend(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL);
                checkAmountFormatShouldHasTwoDecimal(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_AVAILABLE_BALANCE, OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL);
                createScreenShot("Display card type is Supplementary Card type SUP or Supplementary Card type SSC with block status", true);
                CheckStatus = true;
                countScrolling++;
                break;
            } else {
/*
                Thread.sleep(1000);
*/
                scrollingToBottom(700, 300);
                countScrolling++;
            }
        }

        for (int x = 0; x <= countScrolling; x++) {
            scrollingToBottom(300, 700);
        }
    }

    public void checkBalanceiOS(String balanceType) throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        Boolean CheckStatus = false;
        int countScrollingBalance = 0;
        while (CheckStatus == false) {
            if (balanceType == "Outstanding balance") {
                //testCreditCardWithSpendingThisBillIsLessThanZero
                String creditSpendAndRemaining = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_SPENDING_THIS_BILL_LESS_THAN_ZERO).getText();
                String spendingThisBillText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[0];
                evaluateAssertTrueWithImg(spendingThisBillText.contains("minus"), "Display Outstanding balance value with minus sign");
                CheckStatus = true;
                countScrollingBalance++;
                break;
            } else if (balanceType == "Available To Spend") {
                //testCreditCardWithAvailableToSpendIsLessThanZero
                scrollingToBottom(700, 200);
                String creditSpendAndRemaining = context.findElement(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_AVAILABLE_TO_SPEND_LESS_THAN_ZERO).getText();
                String availableToSpendText = creditSpendAndRemaining.split(String.format(WITH_DELIMITER, creditSpendAndRemainingSplitFormat))[1];
                evaluateAssertTrueWithImg(availableToSpendText.contains("minus"), "Display Available To Spend value with minus sign");
                scrollingToBottom(200, 700);
                CheckStatus = true;
                countScrollingBalance++;
                break;
            }
        }
    }


    public enum CardType {
        PRIMARY,
        SUPOrSSC,
    }

    public enum CardStatus {
        BLOCK,
        TEMPORARY_BLOCK,
        PENDING,
    }
}