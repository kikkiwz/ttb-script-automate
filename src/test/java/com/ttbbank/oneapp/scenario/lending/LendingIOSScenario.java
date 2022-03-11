package com.ttbbank.oneapp.scenario.lending;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * LendingIOSScenario.java
 * Created by Aniwat Ruttanaudom on 04/10/2021
 * Copyright (c)2021 Aniwat R., All rights reserved.
 */

public class LendingIOSScenario extends Lib {
    private static int nCardNo;

    //Common
    @Test(groups = "Activate new flow - Lending")
    public void ActivateFlow() {
        if (!Lib.deviceProfile.toLowerCase().contains("nootp")){
            System.out.println("Start Register TTB Citizen ID");
            if (Lib.deviceProfile.toLowerCase().contains("sim")) {
                if (Lib.deviceProfile.toLowerCase().contains("ios")){
                    Lib.driver.removeApp((String) Lib.driver.getSessionDetails().get("CFBundleIdentifier"));
                    Lib.driver.installApp((String) Lib.driver.getSessionDetails().get("app"));
                    Lib.driver.launchApp();
                } else if (Lib.deviceProfile.toLowerCase().contains("ios")){
                     Lib.driver.removeApp((String) Lib.driver.getSessionDetails().get("appPackage"));
                    Lib.driver.installApp((String) Lib.driver.getSessionDetails().get("app"));
                    Lib.driver.launchApp();
                }

            }
            Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (ttbTestContext.isAndroid()) {
                ExReport.printReportMessage("Register TTB ");
                Lib.waitBy(OneAppElementKeys.REGISTER_TTB_BUTTON);
                Lib.clickBy(OneAppElementKeys.REGISTER_TTB_BUTTON);
                ExReport.printReportMessage("Accept term and condition");

                Lib.clickBy(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX);
                Lib.clickBy(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON);
                Lib.clickBy(OneAppElementKeys.INPUT_RM_FIELD);
                Lib.setTextBy(OneAppElementKeys.INPUT_RM_FIELD, Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".citizen_id"));
                ExReport.printReportMessage("Enter rm="+Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".citizen_id"));
                Lib.clickBy(OneAppElementKeys.INPUT_RM_FIELD);
                Lib.enterPin("010203");
                Lib.waitBy(OneAppElementKeys.OTP_HEADER);
                ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
                Lib.data.getString("Activate Complete");
                Lib.waitBy(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON);
                Lib.waitBy(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
                Lib.waitBy(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
                Lib.waitBy(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);

            } else {
                ExReport.printReportMessage("Register TTB ");
                Lib.waitBy(OneAppElementKeys.ACCOUNT_BUTTON);
                ExReport.printReportMessage("Accept term and condition");
                Lib.clickBy(OneAppElementKeys.ACCOUNT_BUTTON);
                Lib.waitBy(OneAppElementKeys.REGISTER_TTB_BUTTON);
                Lib.clickBy(OneAppElementKeys.REGISTER_TTB_BUTTON);
                Lib.waitBy(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX);
                Lib.clickBy(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX);
//                Lib.clickBy(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON);
                Lib.clickBy(OneAppElementKeys.LD1I_BYP_NEXT);
                Lib.waitBy(OneAppElementKeys.INPUT_RM_FIELD);
                System.out.println("RMID is : " + Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".citizen_id"));
                new TouchAction(ttbTestContext.getDriver()).tap(PointOption.point(Lib.fBy(OneAppElementKeys.INPUT_RM_FIELD).getLocation().getX() * 3,
                        Lib.fBy(OneAppElementKeys.INPUT_RM_FIELD).getLocation().getY())).perform();
                Lib.fBy(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".citizen_id"));
                ExReport.printReportMessage("Enter rm="+Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".citizen_id"));
                Lib.fBy(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
                Lib.enterPin("010203");
                Lib.waitBy(OneAppElementKeys.OTP_HEADER);
                System.out.println("Enter PIN=111111");
                Lib.sleep();
                Lib.driver.getKeyboard().sendKeys("111111");
                Lib.sleep();
                ExReport.printReportMessage("Activate Complete");
                Lib.waitBy(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON);
                Lib.clickBy(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON);
                Lib.clickBy(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON);
                try {
                    Lib.waitBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
                    ExReport.printReportMessage("Home > Guideline Next button");
                    Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
                    Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
                    Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
                } catch (Exception e) {
                }
            }
        } else {
            Lib.driver.resetApp();
            Lib.driver.launchApp();
            System.out.println("Test App with out by passed OTP");
        }
    }

    @Test(groups = "Lending iOS - Open MyAccount Screen",dependsOnGroups = { "Activate new flow - Lending"})//Activate new flow - Lending //Lending iOS - Open HomeScreen//Activate new flow
    public void openMyAccount() {
        System.out.println("openMyAccount()");
        String pin = Lib.data.get("config.pin");

        Lib.waitBy(OneAppElementKeys.LD1I_HOM_ACCOUNT_BTN);
        ExReport.printReportMessage("Home Screen");
        Lib.clickBy(OneAppElementKeys.LD1I_HOM_ACCOUNT_BTN);
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_PIN0, 3);
            Lib.enterPin(pin);
            ExReport.printReportMessage("Homescreen - Enter Pin="+pin);
        } catch (Exception e) {
            System.out.println("No Enter PIN");
        }
    }

    @Test(groups = "Lending iOS - Open Card",dependsOnGroups = { "Lending iOS - Open MyAccount Screen"}) //Lending iOS - Open MyAccount Screen | Lending iOS - Open MyAccount Screen - newFramework
    public void openMyCard() {
        System.out.println("openMyCard()");
        String lbTryAgain = "Retry";
        Lib.sleep(1);
        try {
            Lib.waitBy(OneAppElementKeys.LD1I_ACC_GUIDELINENEXT, 10);
            ExReport.printReportMessage("My Account Guideline Next button");
            Lib.clickBy(OneAppElementKeys.LD1I_ACC_GUIDELINENEXT);
        } catch (Exception e) {Lib.log("Skipped Guide line Next button");}
        Lib.waitBy(OneAppElementKeys.LD1I_ACC_CARD_MENU);
        ExReport.printReportMessage("Display My Account page.");
        Lib.clickBy(OneAppElementKeys.LD1I_ACC_CARD_MENU);
        int count=0;
        while (count<5){
            try {
                Lib.waitBy1(OneAppElementKeys.LD1I_ACC_RETRY, 10);
                Lib.clickBy(OneAppElementKeys.LD1I_ACC_RETRY);
            } catch (Exception e) {}
            try {
                Lib.waitBy(OneAppElementKeys.LD1I_ACC_CARDLIST, 10);
                break;
            } catch (Exception e) {}
            count++;
        }
        ExReport.printReportMessage("My account - Card page");
    }

    @Test(groups = "Lending iOS - Select Card",dependsOnGroups = { "Lending iOS - Open Card"})
    public void selectMyCard() {
        System.out.println("selectMyCard()");
        String lbCardNumber = Lib.data.getString("config."+Lib.data.getString(Lib.dataProfile+".rm")+"."+Lib.data.getString(Lib.dataProfile+".card_number"));
        String lbCardNumberToXpath = Lib.convertAccountToXpath(lbCardNumber).toUpperCase();
        List<WebElement> cards = Lib.fsBy(OneAppElementKeys.LD1I_ACC_CARDLIST);
        int nCount = 0;
        Lib.log("size="+cards.size());
        for (WebElement card : cards) {
            Lib.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            Lib.log("aa="+"XCUIElementTypeStaticText[name=\"" + lbCardNumberToXpath + "\"]");
            if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[value=\"" + lbCardNumberToXpath + "\"]")) {
                Lib.log("Card number = " + card.findElement(By.cssSelector("XCUIElementTypeStaticText[value=\"" + lbCardNumberToXpath + "\"]")).getText());
                ExReport.printReportMessage("Click Card = " + lbCardNumber);
                Lib.click(card);
                Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            }
            else {
                Lib.log("Current Card is not "+lbCardNumber);
            }
            nCount++;
        }
        if (nCount == cards.size()){
            Assert.fail(lbCardNumber + " is not found!");
        }
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }

        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
    }

    @Test(groups = "Lending iOS - Select Card - More",dependsOnGroups = { "Lending iOS - Select Card"})
    public void selectMyCard_More() {
        System.out.println("selectMyCard_More()");
        Lib.sleep(1);
        ExReport.printReportMessage("My Credit Card - Product Landing page");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_CARD_MORE);
        Lib.sleep(1);
        ExReport.printReportMessage("My Credit Card - Product Landing - Click More");
    }

    @Test(groups = "Lending iOS - Open Loan",dependsOnGroups = { "Lending iOS - Open MyAccount Screen"})
    public void openMyLoan() {
        System.out.println("openMyLoan()");
        String lbTryAgain = "Retry";
        try {
            Lib.waitBy(OneAppElementKeys.LD1I_ACC_GUIDELINENEXT, 3);
            Lib.clickBy(OneAppElementKeys.LD1I_ACC_GUIDELINENEXT);
        } catch (Exception e) {Lib.log("Skipped Guide line Next button");}
        Lib.waitBy(OneAppElementKeys.LD1I_ACC_LOAN_MENU);
        ExReport.printReportMessage("Display My Account page.");
        Lib.clickBy(OneAppElementKeys.LD1I_ACC_LOAN_MENU);
//        Lib.waitBy(OneAppElementKeys.LD1I_ACC_APPLYLOAN, 10);
//        Lib.waitBy(OneAppElementKeys.LD1I_ACC_CARDLIST);
        int count=0;
        while (count<5){
            try {
                Lib.waitBy1(OneAppElementKeys.LD1I_ACC_RETRY, 10);
                Lib.clickBy(OneAppElementKeys.LD1I_ACC_RETRY);
            } catch (Exception e) {}
            try {
                Lib.waitBy(OneAppElementKeys.LD1I_ACC_CARDLIST, 10);
                break;
            } catch (Exception e) {}
            count++;
        }
        ExReport.printReportMessage("My account - Card page");
    }

    @Test(groups = "Lending iOS - Select Loan",dependsOnGroups = { "Lending iOS - Open Loan"})
    public void selectMyLoan() {
        System.out.println("selectMyLoan()");
        String lbCardNumber = Lib.data.getString("config."+Lib.data.getString(Lib.dataProfile+".rm")+"."+Lib.data.getString(Lib.dataProfile+".loan_number"));
        String lbCardNumberToXpath = Lib.convertLoanToXpath(lbCardNumber);
        List<WebElement> cards = Lib.fsBy(OneAppElementKeys.LD1I_ACC_CARDLIST);
        int nCount = 0;
        for (WebElement card : cards) {
            Lib.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[name=\"" + lbCardNumberToXpath + "\"]")) {
                Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Lib.log("Click card = " + lbCardNumber);
                ExReport.printReportMessage("Click Card = " + lbCardNumber);
                Lib.click(card);
                Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            }
            else {
                Lib.log("Current Card is not "+lbCardNumber);
            }
            nCount++;
        }
        if (nCount==cards.size()){
            Assert.fail(lbCardNumber + " is not found!");
        }
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_LB);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
    }

    @Test(groups = "Lending_iOS_Setting1",dependsOnGroups = {"Activate new flow - Lending"})
    public void OpenSetting() {
        Lib.log("Lending_iOS_Setting1");
        String pin = Lib.data.get("config.pin");

        Lib.waitBy(OneAppElementKeys.LD1I_HOM_MORE_BTN);
        ExReport.printReportMessage("More Button");
        Lib.clickBy(OneAppElementKeys.LD1I_HOM_MORE_BTN);
        Lib.waitBy(OneAppElementKeys.LD1I_MOR_SETTINGS);
        Lib.clickBy(OneAppElementKeys.LD1I_MOR_SETTINGS);
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_PIN0, 3);
            Lib.enterPin(pin);
            ExReport.printReportMessage("Homescreen - Enter Pin="+pin);
        } catch (Exception e) {
            System.out.println("No Enter PIN");
        }
        Lib.sleep(10);
        Lib.waitBy(OneAppElementKeys.LD1I_SET_FAVORITES);
        Lib.clickBy(OneAppElementKeys.LD1I_SET_FAVORITES);
        Lib.writelog();
        }


    /**
     * **********************
     * 1.Activate Card (PRI)
     * 2.Activate Card (SUP)
     * 2.Activate Card (SSC)
     * **********************
     */

    @Test(groups = "Lending_iOS_Activate_Card_PRI", dependsOnGroups = {"Lending iOS - Open Card"})
    public void LendingActivateCard_PRI() {
        System.out.println("Lending_iOS_Activate_Card_PRI");
        String lbCardNumber = Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + "."+Lib.data.getString(Lib.dataProfile+".card_number"));
        String lbCardNumberToXpath = Lib.convertAccountToXpath(lbCardNumber).toUpperCase();
        List<WebElement> cards = Lib.fsBy(OneAppElementKeys.LD1I_ACC_CARDLIST);
        Boolean isNotActivated = false;
        ExReport.printReportMessage("Card : finding "+lbCardNumber+" is pending");

        for (WebElement card : cards) {
            Lib.log("click the card is not activated.");
            Lib.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[name=\"" + lbCardNumberToXpath + "\"]")){
                if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[name=\"PENDING ACTIVATION\"]")){
                    Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    Lib.sleep(1);
                    Lib.log("Found Pending Activation Card =  "+lbCardNumber);
                    Lib.click(card);
                    isNotActivated = true;
                    break;
                }
            }
        }
        if (!isNotActivated) {Assert.fail("Card "+lbCardNumber+" is not found");}
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }

        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P1_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_TITLE).getText(), "Activate card");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_DESC).getText(), "Welcome, K. , please have your card handy. Activate now to enjoy the privileges and benefits of your So Smart Credit Card card.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_NEXT).getText(), "Enter card number");
        ExReport.printReportMessage("Activate Card Page 1");
        Lib.log("Click next button");
        Lib.clickBy(OneAppElementKeys.LD1W_ACT_P1_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P2_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_TITLE).getText(), "Activate card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_TITLE2).getText(), "Please enter 7th to 12th of card number.");
        Lib.enterCustomNumberKeyboard("111111");

        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_ERROR).getText(), "Card number is incorrect, please enter again.");
        ExReport.printReportMessage("Activate Card Page 2 - Enter Card=111111");
        Lib.sleep(1);
        Lib.enterCustomNumberKeyboard("000000");

        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P3_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_TITLE).getText(), "Activate card");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_TITLE2).getText(), "Please enter 3 digits of CVV number.");
        Lib.enterCustomNumberKeyboard("111");
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_ERROR).getText(), "Incorrect information please try again");
        ExReport.printReportMessage("Activate Card Page 3 - Enter CVV = 111 incorrect");
        String cvv = Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + "."+Lib.data.getString(Lib.dataProfile+".cvv_number"));
        Lib.enterCustomNumberKeyboard(cvv);
        Lib.sleep(1);
        Lib.enterPin("010203");

        try {
            Lib.waitBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_TITLE).getText(), "Successfully Activated Card");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_TITLE2).getText(), "Card number.");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_CARDNUMBER).getText(), "Card number.");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_DESC).getText(), "is already activated");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES).getText(), "Explore Card Features");
            ExReport.printReportMessage("Activate Card - Finish Page");
            Lib.clickBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES);
            Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
            Lib.sleep(10);
            ExReport.printReportMessage("Activate Card - Back to Main Page");
            Lib.sleep();
        } catch (Exception e) {
            Lib.log(e.getStackTrace());
        }
    }


    @Test(groups = "Lending_iOS_Activate_Card_SSC", dependsOnGroups = {"Lending iOS - Open Card"})
    public void LendingActivateCard_SSC() {
        System.out.println("Lending_iOS_Activate_Card_SSC");
        String lbCardNumber = Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + "."+Lib.data.getString(Lib.dataProfile+".card_number"));
        String lbCardNumberToXpath = Lib.convertAccountToXpath(lbCardNumber).toUpperCase();
        List<WebElement> cards = Lib.fsBy(OneAppElementKeys.LD1I_ACC_CARDLIST);
        Boolean isNotActivated = false;
        ExReport.printReportMessage("Card : finding "+lbCardNumber+" is pending");

        for (WebElement card : cards) {
            Lib.log("click the card is not activated.");
            Lib.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[name=\"" + lbCardNumberToXpath + "\"]")){
                if (Lib.isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[name=\"PENDING ACTIVATION\"]")){
                    Lib.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    Lib.sleep(1);
                    Lib.log("Found Pending Activation Card =  "+lbCardNumber);
                    Lib.click(card);
                    isNotActivated = true;
                    break;
                }
            }
        }
        if (!isNotActivated) {Assert.fail("Card "+lbCardNumber+" is not found");}
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P1_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_TITLE).getText(), "Activate card");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_DESC).getText(), "Welcome, K. , please have your card handy. Activate now to enjoy the privileges and benefits of your So Smart Credit Card card.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P1_NEXT).getText(), "Enter card number");
        ExReport.printReportMessage("Activate Card Page 1");
        Lib.log("Click next button");
        Lib.clickBy(OneAppElementKeys.LD1W_ACT_P1_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P2_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_TITLE).getText(), "Activate card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_TITLE2).getText(), "Please enter 7th to 12th of card number.");
        Lib.enterCustomNumberKeyboard("111111");

        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P2_ERROR).getText(), "Card number is incorrect, please enter again.");
        ExReport.printReportMessage("Activate Card Page 2 - Enter Card=111111");
        Lib.sleep(1);
        Lib.enterCustomNumberKeyboard("000000");

        Lib.waitBy(OneAppElementKeys.LD1W_ACT_P3_TITLE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_TITLE).getText(), "Activate card");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_TITLE2).getText(), "Please enter 3 digits of CVV number.");
        Lib.enterCustomNumberKeyboard("111");
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P3_ERROR).getText(), "Incorrect information please try again");
        ExReport.printReportMessage("Activate Card Page 3 - Enter CVV = 111 incorrect");
        String cvv = Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + "."+Lib.data.getString(Lib.dataProfile+".cvv_number"));
        Lib.log("cvv="+cvv);
        Lib.enterCustomNumberKeyboard(cvv);
        Lib.sleep(1);
        Lib.enterPin("010203");

        try {
            Lib.waitBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_TITLE).getText(), "Successfully Activated Card");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_TITLE2).getText(), "Card number.");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_CARDNUMBER).getText(), "Card number.");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_DESC).getText(), "is already activated");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES).getText(), "Explore Card Features");
            ExReport.printReportMessage("Activate Card - Finish Page");
            Lib.clickBy(OneAppElementKeys.LD1W_ACT_P4_EXPLORECARDFEATURES);
            Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
            Lib.sleep(10);
            ExReport.printReportMessage("Activate Card - Back to Main Page");
            Lib.sleep();
        } catch (Exception e) {
            Lib.log(e.getStackTrace());
        }
    }

    /**
     * **********************
     * 3.Set PIN (PRI)
     * 4.Set PIN (SSC)
     * **********************
     */
    @Test(groups = "Lending_iOS_Set_Pin_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingSetPin_PRI() {
        System.out.println("Lending_iOS_Set_Pin_PRI");
        ExReport.printReportMessage("Set Card Pin");
        Lib.clickMore("Set Card Pin");

        Lib.waitBy(OneAppElementKeys.LD1W_PIN_P1_TITLE1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE1).getText(), "Set ATM PIN");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE2).getText(), "Please Set up your 4-digits PIN.");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center

        Lib.enterCustomNumberKeyboard("1111");
        Lib.sleep(1);

        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE2).getText(), "Confirm ATM PIN");
        Lib.enterCustomNumberKeyboard("1234");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_ERROR).getText(), "PIN does not match, please try again.");
        ExReport.printReportMessage("Set Pin - Enter 2nd pin=1234 > get Error message");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center
        Lib.enterCustomNumberKeyboard("1111");
        ExReport.printReportMessage("Set Pin - Enter confirm pin");
        Lib.enterPin(Lib.data.get("config.pin")); // Get Pin value from Test Json data

        Lib.waitBy(OneAppElementKeys.LD1W_PIN_P2_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P2_TITLE).getText(), "Successfully Set Card PIN");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P2_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_CARDNUMBER_VALUE).getText()
                , Lib.data.getString("config."+Lib.data.getString(Lib.dataProfile+".rm")+".card_number1").toLowerCase());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_DESC).getText(), "PIN has been changed.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_BACKTOMAINPAGE).getText(), "Back to Main Page");
        ExReport.printReportMessage("Set Pin page 2- Complete");
        Lib.clickBy(OneAppElementKeys.LD1W_PIN_P1_BACKTOMAINPAGE);
        Lib.sleep();
    }

    @Test(groups = "Lending_iOS_Set_Pin_SSC", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingSetPin_SSC() {
        System.out.println("Lending_iOS_Set_Pin_SSC");
        ExReport.printReportMessage("Set Card Pin");
        Lib.clickMore("Set Card Pin");
        Lib.waitBy(OneAppElementKeys.LD1W_PIN_P1_TITLE1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE1).getText(), "Set ATM PIN");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE2).getText(), "Please Set up your 4-digits PIN.");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center

        Lib.enterCustomNumberKeyboard("1111");
        Lib.sleep(1);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_TITLE2).getText(), "Confirm ATM PIN");
        Lib.enterCustomNumberKeyboard("1234");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_ERROR).getText(), "PIN does not match, please try again.");
        ExReport.printReportMessage("Set Pin - Enter 2nd pin=1234 > get Error message");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING); // Wait Loading screen center
        Lib.enterCustomNumberKeyboard("1111");
        ExReport.printReportMessage("Set Pin - Enter confirm pin");
        Lib.enterPin(Lib.data.get("config.pin")); // Get Pin value from Test Json data
        Lib.waitBy(OneAppElementKeys.LD1W_PIN_P2_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P2_TITLE).getText(), "Successfully Set Card PIN");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P2_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_CARDNUMBER_VALUE).getText()
                , Lib.data.getString("config."+Lib.data.getString(Lib.dataProfile+".rm")+".card_number1").toLowerCase());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_DESC).getText(), "PIN has been changed.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PIN_P1_BACKTOMAINPAGE).getText(), "Back to Main Page");
        ExReport.printReportMessage("Set Pin page 2- Complete");
        Lib.clickBy(OneAppElementKeys.LD1W_PIN_P1_BACKTOMAINPAGE);
        Lib.sleep();
    }

    /**
     * **********************
     * 5.Block Card (PRI)
     * 6.Block Card (SUP)
     * 7.Block Card (SSC)
     * **********************
     */

    @Test(groups = "Lending_iOS_Block_Card_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingBlockCard_PRI() {
        System.out.println("Lending_iOS_Block_Card_PRI");
        ExReport.printReportMessage("Block Card");
        Lib.clickMore("Block Card");
        Lib.waitBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS);
        ExReport.printReportMessage("Block Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_TITLE).getText(), "Block and Issue New Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC1).getText(), "Conditions");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC2).getText(), "The Cardholder shall not be responsible for any liabilities incurred after 5 minutes as from the time the Bank is notified.\n" +
                "If the Bank can prove that any liabilities incurred after the request for blocking card has been authorized by the cardholder, the cardholder shall bear sole responsibility for such liabilities.\n" +
                "All direct debit and autopayment transactions associated with your card shall be automatically cancelled.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC3).getText(), "New card will be sent to your billing address.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS).getText(), "12 ม.-   ถ.- ต.ปลายพระยา   อ.ปลายพระยา กระบี่   81160");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_SMALLINFO).getText(), "To change the address, please contact branches or 1428.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON).getText(), "Confirm");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON);
        Lib.enterPin(Lib.data.get("config.pin"));
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_BLO_P2_DESC1);
        ExReport.printReportMessage("Block Card SUP - Result ");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TITLE).getText(), "Completed");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_DESC1).getText(), "is already blocked.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_LB).getText(), "Transaction Date");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_LB).getText(), "Transaction Time");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE).getText(), "Back to Main Page");
        Lib.clickBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE);
        Lib.sleep(10);
        ExReport.printReportMessage("Back To Main Page");
        try {
            Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOCKED);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOCKED).getText(), "LOCKED");
            ExReport.printReportMessage("CardNumber " + nCardNo + " is Locked");
        } catch (Exception e) {

        }
    }

    @Test(groups = "Lending_iOS_Block_Card_SUP", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingBlockCard_SUP() {
        System.out.println("Lending_iOS_Block_Card_SUP");
        Lib.clickMore("Block Card");
        Lib.waitBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS);
        ExReport.printReportMessage("Block Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_TITLE).getText(), "Block and Issue New Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC1).getText(), "Conditions");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC2).getText(), "The Cardholder shall not be responsible for any liabilities incurred after 5 minutes as from the time the Bank is notified.\n" +
                "If the Bank can prove that any liabilities incurred after the request for blocking card has been authorized by the cardholder, the cardholder shall bear sole responsibility for such liabilities.\n" +
                "All direct debit and autopayment transactions associated with your card shall be automatically cancelled.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC3).getText(), "New card will be sent to your billing address.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS).getText(), "12 ม.-   ถ.- ต.ปลายพระยา   อ.ปลายพระยา กระบี่   81160");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_SMALLINFO).getText(), "To change the address, please contact branches or 1428.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON).getText(), "Confirm");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON);
        Lib.enterPin(Lib.data.get("config.pin"));
        Lib.sleep();
        try {
            Lib.waitBy(OneAppElementKeys.LD1W_BLO_P2_DESC1);
            ExReport.printReportMessage("Block Card SUP - Result ");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TITLE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_DESC1).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_LB).getText(), "Transaction Time");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE).getText(), "Back to Main Page");
            Lib.clickBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE);
            Lib.sleep(10);
            ExReport.printReportMessage("Back To Main Page");

            Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOCKED);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOCKED).getText(), "LOCKED");
            ExReport.printReportMessage("CardNumber " + nCardNo + " is Locked");
        } catch (Exception e) {

        }

    }

    @Test(groups = "Lending_iOS_Block_Card_SSC", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingBlockCard_SSC() {
        System.out.println("Lending_iOS_Block_Card_SSC");
        Lib.waitBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS);
        ExReport.printReportMessage("Block Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_TITLE).getText(), "Block and Issue New Card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC1).getText(), "Conditions");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC2).getText(), "The Cardholder shall not be responsible for any liabilities incurred after 5 minutes as from the time the Bank is notified.\n" +
                "If the Bank can prove that any liabilities incurred after the request for blocking card has been authorized by the cardholder, the cardholder shall bear sole responsibility for such liabilities.\n" +
                "All direct debit and autopayment transactions associated with your card shall be automatically cancelled.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_DESC3).getText(), "New card will be sent to your billing address.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_ADDRESS).getText(), "12 ม.-   ถ.- ต.ปลายพระยา   อ.ปลายพระยา กระบี่   81160");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_SMALLINFO).getText(), "To change the address, please contact branches or 1428.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON).getText(), "Confirm");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_BLO_P1_CONFIRMBUTTON);
        Lib.enterPin(Lib.data.get("config.pin"));
        Lib.sleep();
        try {
            Lib.waitBy(OneAppElementKeys.LD1W_BLO_P2_DESC1);
            ExReport.printReportMessage("Block Card SUP - Result ");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TITLE).getText(), "Completed");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_DESC1).getText(), "is already blocked.");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_LB).getText(), "Transaction Date");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONDATE_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_LB).getText(), "Transaction Time");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_TRANSACTIONTIME_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE).getText(), "Back to Main Page");
            Lib.clickBy(OneAppElementKeys.LD1W_BLO_P2_BACKTOMAINPAGE);
            Lib.sleep(10);
            ExReport.printReportMessage("Back To Main Page");
            Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOCKED);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOCKED).getText(), "LOCKED");
            ExReport.printReportMessage("CardNumber " + nCardNo + " is Locked");
        } catch (Exception e) {

        }
    }


    /**
     * **********************
     * 8.Card product landing (billed, unbilled selection)
     * 9.Loan product landing (details, payment history)
     * **********************
     */
    @Test(groups = "Lending_iOS_PRODUCT_LANDING_CARD", dependsOnGroups = { "Lending iOS - Select Card"})
    public void LendingProductLanding_CreditCardLanding() {
        System.out.println("Lending_iOS_PRODUCT_LANDING_CARD");
        ExReport.printReportMessage("Product Landing - Credit Card Landing");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_CARDNAME).getText(), "absolute");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_CARDNUMBER).getText(), "4308-40xx-xxxx-0128");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_POINTS).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_OUTSTANDING_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_OUTSTANDNG_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_AVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_AVAILABLETOSPEND_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_CREDITLIMIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_MORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_REDEEMPOINT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_CASHFORYOU).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_SOGOOD).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_CARD_MORE);
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LB);

        ExReport.printReportMessage("Product Landing - Credit Card Landing - Click More button");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LB).getText(), "");
        Lib.assertText(Lib.getMore("Redeem Point").getText(), "");
        Lib.assertText(Lib.getMore("Card Details").getText(), "");
        Lib.assertText(Lib.getMore("Cash for You").getText(), "");
        Lib.assertText(Lib.getMore("so goood").getText(), "");

        Lib.assertText(Lib.getMore("Pay Bill").getText(), "");
//        Lib.assertText(Lib.getMore("Apply eStatement").getText(), "");
        Lib.assertText(Lib.getMore("Adjust Usage Limit").getText(), "");
        Lib.assertText(Lib.getMore("Set Card PIN").getText(), "");
        Lib.assertText(Lib.getMore("Block Card").getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_CARD_CLOSE);
        Lib.sleep(1);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_AMOUNTDUED_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_AMOUNTDUED_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_MINIMUM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_MINIMUM_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_DUEDATEON).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_PAYBILL).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_BILLED).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED).getText(), "");

        Lib.touchAndMoveWebView(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_SLIDE_UNBILLED), Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_TITLE));
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_SLIDE_UNBILLED);
        ExReport.printReportMessage("Product Landing - Credit Card Landing - Unbilled button");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_SLIDE_UNBILLED).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_SLIDE_BILLED).getText(), "");
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_PRO_CARD_UNBILLED_SPENDINGAMOUNT_LB)){
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_UNBILLED_SPENDINGAMOUNT_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_CARD_UNBILLED_SPENDINGAMOUNT_VALUE).getText(), "");
            Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_PRO_CARD_UNBILLED_LIST_LB).get(0).getText(), "");
        }
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_CARD_SLIDE_BILLED);

        Lib.sleep();
        ExReport.printReportMessage("Product Landing - Credit Card Landing - Billed button");

    }

    @Test(groups = "Lending_iOS_PRODUCT_LANDING_C2G", dependsOnGroups = { "Lending iOS - Select Loan"})
    public void LendingProductLanding_C2G_Verified() {
        System.out.println("Lending_iOS_PRODUCT_LANDING_C2G");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        ExReport.printReportMessage("My Credit Card - Loan");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_TITLE).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAIDPRINCIPAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAIDPRINCIPAL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_REMAININGPRINCIPAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_REMAINPRINCIPAL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANCREDIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYBILL_BTN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_APPLYESTATEMENT_BTN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_AMOUNTDUE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_AMOUNTDUE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DUEDATE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYBILL_ORANGE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANDETAILS_BTN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMENTHISTORY_BTN).getText(), "");
        Lib.touchAndMoveWebView(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANDETAILS_BTN), Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_TITLE));
        ExReport.printReportMessage("My Credit Card Page - Loan Details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANACCOUNTNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANACCOUNTNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANSUFFIX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANSUFFIX_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ACCOUNTNAME_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ACCOUNTNAME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DIRECTDEBIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DIRECTDEBIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_MONTHLYPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_MONTHLYPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMENTDUEDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMNETDUEDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ANNUALINTERESTRATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ANNUALINTERESTRATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_TENORS_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_TENOS_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_OUTSTANDINGBALANCE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_OUTSTANDINGBALANCE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTSTARTDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTSTARTDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTMATURITYDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTMATURITYDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_NOTE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_LB);
        Lib.sleep();
        ExReport.printReportMessage("My Credit Card Page - Payment History");
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW)){
            Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW);
            Lib.sleep();
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_DESC).getText(), "Payment History");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTPAID_LB).getText(), "Principal amount paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_INTERESTPAID_LB).getText(), "Interest paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_FEEOTHEREXPENSE_LB).getText(), "Fee/Other expenses");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_OUTSTANDINGBALANCE_LB).getText(), "Outstanding balance");
            ExReport.printReportMessage("My Credit card Page - Amount Paid un collapse");
        }
    }

    @Test(groups = "Lending_iOS_PRODUCT_LANDING_BPlus", dependsOnGroups = { "Lending iOS - Select Loan"})
    public void LendingProductLanding_BPlus_Verified() {
        System.out.println("Lending_iOS_PRODUCT_LANDING_BPlus");
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        ExReport.printReportMessage("My Credit Card - Loan");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_TITLE).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_IMAGE).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_LOANNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_LOANNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_PAIDPRINCIPAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_PAIDPRINCIPAL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_REMAININGPRINCIPAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_REMAININGPRINCIPAL).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_LOANCREDIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_BPLUS_PAYBILL_BTN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_AMOUNTDUE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_AMOUNTDUE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DUEDATE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYBILL_ORANGE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANDETAILS_BTN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMENTHISTORY_BTN).getText(), "");
        Lib.touchAndMoveWebView(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANDETAILS_BTN), Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_TITLE));
        ExReport.printReportMessage("My Credit Card Page - Loan Details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANACCOUNTNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANACCOUNTNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANSUFFIX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_LOANSUFFIX_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ACCOUNTNAME_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ACCOUNTNAME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DIRECTDEBIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_DIRECTDEBIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_MONTHLYPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_MONTHLYPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMENTDUEDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_PAYMNETDUEDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ANNUALINTERESTRATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_ANNUALINTERESTRATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_TENORS_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_TENOS_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_OUTSTANDINGBALANCE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_OUTSTANDINGBALANCE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTSTARTDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTSTARTDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTMATURITYDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_CONTRACTMATURITYDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_NOTE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_LB);
        Lib.sleep();
        ExReport.printReportMessage("My Credit Card Page - Payment History");
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW)){
            Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW);
            Lib.sleep();
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_DESC).getText(), "Payment History");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTPAID_LB).getText(), "Principal amount paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_INTERESTPAID_LB).getText(), "Interest paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_FEEOTHEREXPENSE_LB).getText(), "Fee/Other expenses");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_OUTSTANDINGBALANCE_LB).getText(), "Outstanding balance");
            ExReport.printReportMessage("My Credit card Page - Amount Paid un collapse");
        }
    }

    @Test(groups = "Lending_iOS_PRODUCT_LANDING_HomeLoan", dependsOnGroups = { "Lending iOS - Select Loan"})
    public void LendingProductLanding_HomeLoan_Verified() {
        System.out.println("Lending_iOS_PRODUCT_LANDING_HomeLoan");
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTDUED_AMOUNTDUED); // Wait Loading screen center
        ExReport.printReportMessage("My Credit Card - Loan");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTDUED_AMOUNTDUED).getText(), "Amount Dued");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTDUED_DUEDDATEON).getText(), "Amount Dued");;
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTDUED_PAYBILL).getText(), "Pay Bill");
        Lib.touchAndMoveWebView(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_LOANDETAILS), Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_TITLE));


        ExReport.printReportMessage("My Credit Card Page - Loan Details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_LOANDETAILS).getText(), "Loan Details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_LOANACCOUNTNUMBER_LB).getText(), "Loan account number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_LOANSUFFIX_LB).getText(), "Loan suffix");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_ACCOUNTNAME_LB).getText(), "Account name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_DIRECTDEBIT_LB).getText(), "Direct debit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_MONTHLYPAYMENT_LB).getText(), "Monthly payment");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_DUEDATE_LB).getText(), "Due date");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_INTERESTRATEPERYEAR_LB).getText(), "Interest rate (per year)");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_TENORS_LB).getText(), "Tenors");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_CONTRACTSTARTDATE_LB).getText(), "Contract start date");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_CONTRACTEXPIRYDATE_LB).getText(), "Contract expiry date");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_LOAN_REMARK_LB).getText(), "Remark: for loan account closure, please contact 1428.");

        Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_LB);
        Lib.sleep();
        ExReport.printReportMessage("My Credit Card Page - Payment History");
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW)){
            Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_ARROW);
            Lib.sleep();
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_PAYMENTHISTORY_DESC).getText(), "Payment History");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_AMOUNTPAID_LB).getText(), "Principal amount paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_INTERESTPAID_LB).getText(), "Interest paid");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_FEEOTHEREXPENSE_LB).getText(), "Fee/Other expenses");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_PRO_LOAN_OUTSTANDINGBALANCE_LB).getText(), "Outstanding balance");
            ExReport.printReportMessage("My Credit card Page - Amount Paid un collapse");
        }
    }


    /**
     * **********************
     * 10.Card Details (PRI only)
     * 11.Card Details (PRI has SUP Cards)
     * 12.Card Details (SUP)
     * 13.Card Details (SCC)
     * **********************
     */
    @Test(groups = "Lending_iOS_Card_Details_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCardDetails_PRI() {
        System.out.println("Lending_iOS_Card_Details_PRI");
        ExReport.printReportMessage("Apply EStatement - Click More > Card Details");
        Lib.clickMore("Card Details");
        Lib.waitBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT);
        ExReport.printReportMessage("Card Details - Part1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT).getText(), "Account");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_POINTS).getText(), "Points");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDMANAGEMENT).getText(), "Card management");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ADJUSTUSAGELIMIT).getText(), "Adjust usage limit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_BLOCKCARD).getText(), "Block card");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_SETPIN).getText(), "Set PIN");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDDETAILS).getText(), "Card details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PRODUCTNAME_LB).getText(), "Product name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDTYPE_LB).getText(), "Card type");
        Lib.swipeDownToUp();
        Lib.sleep();
        ExReport.printReportMessage("Card Details - Part 2");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDHOLDER_LB).getText(), "Card holder");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDLIMIT_LB).getText(), "Card limit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_TOTALAMOUNTDUE_LB).getText(), "Total amount due");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_MINIMUMAMOUNTDUE_LB).getText(), "Minimum amount due");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_STATEMENTDUE_LB).getText(), "Statement date");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PAYMENTDEUDATE_LB).getText(), "Payment due date");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_POINTDETAILS_LB).getText(), "Card management");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_OUTSTANDINGPOINTS_LB).getText(), "Product name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_EXPIRINGPOINTS_LB).getText(), "Expiring points");
    }

    @Test(groups = "Lending_iOS_Card_Details_PRI_has_SUP", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCardDetails_PRI_Has_SUPCards() {
        System.out.println("Lending_iOS_Card_Details_PRI_has_SUP");
        ExReport.printReportMessage("Apply EStatement - Click More > Card Details");
        Lib.clickMore("Card Details");
        Lib.waitBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT);
        ExReport.printReportMessage("Card Details - Part1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT).getText(), "Account");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDMANAGEMENT).getText(), "Card management");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ADJUSTUSAGELIMIT).getText(), "Adjust usage limit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_BLOCKCARD).getText(), "Block card");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDDETAILS).getText(), "Card details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PRODUCTNAME_LB).getText(), "Product name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDTYPE_LB).getText(), "Card type");
        Lib.swipeDownToUp();
        Lib.sleep();
        ExReport.printReportMessage("Card Details - Part 2");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDHOLDER_LB).getText(), "Card holder");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDLIMIT_LB).getText(), "Card limit");

    }
    @Test(groups = "Lending_iOS_Card_Details_SUP", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCardDetails_SUP() {
        System.out.println("Lending_iOS_Card_Details_SUP");
        ExReport.printReportMessage("Apply EStatement - Click More > Card Details");
        Lib.clickMore("Card Details");
        Lib.waitBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT);
        ExReport.printReportMessage("Card Details - Part1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT).getText(), "Account");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDMANAGEMENT).getText(), "Card management");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ADJUSTUSAGELIMIT).getText(), "Adjust usage limit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_BLOCKCARD).getText(), "Block card");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDDETAILS).getText(), "Card details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PRODUCTNAME_LB).getText(), "Product name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDTYPE_LB).getText(), "Card type");
        Lib.swipeDownToUp();
        Lib.sleep();
        ExReport.printReportMessage("Card Details - Part 2");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDHOLDER_LB).getText(), "Card holder");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDLIMIT_LB).getText(), "Card limit");
    }

    @Test(groups = "Lending_iOS_Card_Details_SSC", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCardDetails_SSC() {
        System.out.println("Lending_iOS_Card_Details_SSC");
        ExReport.printReportMessage("Apply EStatement - Click More > Card Details");
        Lib.clickMore("Card Details");
        Lib.waitBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT);
        ExReport.printReportMessage("Card Details - Part1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_ACCOUNT).getText(), "Account");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDMANAGEMENT).getText(), "Card management");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_BLOCKCARD).getText(), "Block card");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDDETAILS).getText(), "Card details");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PRODUCTNAME_LB).getText(), "Product name");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_PRODUCTNAME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDTYPE_LB).getText(), "Card type");
        Lib.swipeDownToUp();
        Lib.sleep();
        ExReport.printReportMessage("Card Details - Part 2");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDNUMBER_LB).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDNUMBER_VALUE).getText(), "Card number");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDHOLDER_LB).getText(), "Card holder");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDHOLDER_VALUE).getText(), "Card holder");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDLIMIT_LB).getText(), "Card limit");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_DET_CARD_CARDLIMIT_VALUE).getText(), "Card limit");
    }

    /**
     * **********************
     * 14.Change Usage Limit (PRI)
     * 15.Change Usage Limit (SUP)
     * 16.Request Temporary Limit(PRI)
     * **********************
     */
    @Test(groups = "Lending_iOS_Change_Usage_Limit_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingChangeLimit_HomeToChangeLimit() {
        System.out.println("Lending_iOS_Change_Usage_Limit_PRI");
        ExReport.printReportMessage("Lending_iOS_Change_Usage_Limit_PRI");
        Lib.clickMore("Adjust Usage Limit");
        Lib.sleep();

        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P1_TITLE);
        ExReport.printReportMessage("Adjust Usage Limit Page1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_IMAGE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDLIMIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value"), "");
        String currentCardLimit = Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEXT).getText(), "");

        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE));
        Lib.sleep(1);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE), String.valueOf(Integer.parseInt(currentCardLimit.replace(",", ""))-5000));
        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE));
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_VALUE).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page1 - modify limit value");
        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P1_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P2_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_VALUE_).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_VALUE).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page2 - Confirm Page");

        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P2_CONFIRM);
        Lib.enterPin("010203");
        Lib.sleep(10);
        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P3_TITLE);
        ExReport.printReportMessage("Adjust Usage Limit Page3 - Last Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE).getText(), "");
        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE));
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("Adjust Usage Limit - After click Back To Main Page");
    }

    @Test(groups = "Lending_iOS_Change_Usage_Limit_SUP", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingChangeLimit_Success() {
        System.out.println("Lending_iOS_Change_Usage_Limit_SUP");
        ExReport.printReportMessage("Lending iOS - Change Usage Limit - SUP");
        Lib.clickMore("Adjust Usage Limit");
        Lib.sleep();

        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P1_TITLE);
        ExReport.printReportMessage("Adjust Usage Limit Page1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_IMAGE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDLIMIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value"), "");
        String currentCardLimit = Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEXT).getText(), "");

        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE));
        Lib.sleep(1);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE), String.valueOf(Integer.parseInt(currentCardLimit.replace(",", ""))-5000));
        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE));
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_VALUE).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page1 - modify limit value");
        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P1_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P2_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_VALUE_).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_VALUE).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page2 - Confirm Page");

        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P2_CONFIRM);
        Lib.enterPin("010203");
        Lib.sleep(10);
        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P3_TITLE);
        ExReport.printReportMessage("Adjust Usage Limit Page3 - Last Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE).getText(), "");
        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE));
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("Adjust Usage Limit - After click Back To Main Page");
    }

    @Test(groups = "Lending_iOS_Change_Usage_Temp_Limit_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingChangeLimit_Temp() {
        System.out.println("Lending_iOS_Change_Usage_Temp_Limit_PRI");
        ExReport.printReportMessage("Lending_iOS_Change_Usage_Temp_Limit_PRI");
        Lib.clickMore("Adjust Usage Limit");
        Lib.sleep();

        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P1_TITLE);
        ExReport.printReportMessage("Adjust Usage Limit Page1");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_IMAGE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_OUTSTANDINGBALANCE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_AVAILABLETOSPEND_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CARDLIMIT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value"), "");
        String currentCardLimit = Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE).getAttribute("value");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MIN_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_MAX_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEXT).getText(), "");

        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE));
        Lib.sleep(1);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_CURRENTCARDLIMIT_VALUE), String.valueOf(Integer.parseInt(currentCardLimit.replace(",", ""))+5000));
        Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_TITLE));
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P1_NEWAVAILABLETOSPEND_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_ERROR).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page1 - modify limit value");
        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P1_NEXT);
        Lib.sleep();
        //TEMP LIMIT
        Lib.waitBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_TITLE2);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_REASON_LB).getText(), "");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_CALENDAR_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_TERM1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_ITEM1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_ITEM2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_ITEM3).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_NEXT).getText(), "");
        try {
            Lib.selectValue(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_REASON_DDL), "201");
        } catch (Exception e) {}
        try {
            Lib.selectValue(Lib.fBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_REASON_DDL), "201");
        } catch (Exception e) {}

        Lib.setNative();
        Lib.clickBy(OneAppElementKeys.LD1I_LIM_TEMP_P3_CALENDAR);
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.clickBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_TERM1);
        ExReport.printReportMessage("Adjust Usage Limit Page2 - Reason/Expiry date of temporary limit");
        Lib.clickBy(OneAppElementKeys.LD1W_LIM_TEMP_P3_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_LIM_P2_TITLE);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CREDITCARD_VALUE_).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_CARDNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_OLDCREDITLIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P2_NEWCREDITLIMIT_VALUE).getText(), "");
        ExReport.printReportMessage("Adjust Usage Limit Page2 - Confirm Page");

        Lib.clickBy(OneAppElementKeys.LD1W_LIM_P2_CONFIRM);
        Lib.enterPin("010203");
        Lib.sleep(5);
        try {
            Lib.waitBy(OneAppElementKeys.LD1W_LIM_P3_TITLE);
            ExReport.printReportMessage("Adjust Usage Limit Page3 - Last Page");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_TITLE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_DESC1).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_NEWCREDITLIMIT_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_EFFECTIVEDATE_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE).getText(), "");
            Lib.click(Lib.fBy(OneAppElementKeys.LD1W_LIM_P3_BACKTOMAINPAGE));
            Lib.sleep(1);
            Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
            ExReport.printReportMessage("Adjust Usage Limit - After click Back To Main Page");
        } catch (Exception e){

        }
        ExReport.printReportMessage("Adjust Usage Limit - last page");
    }

    /**
     * **********************
     * 17.Apply eStatement (Credit Card)
     * 18.Apply eStatement (Flash Card)
     * 19.Apply eStatement (C2G)
     * **********************
     */
    @Test(groups = "Lending_iOS_Apply_Estatement_CreditCard", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingEStatement_ChangeEmail_CreditCard() {
        System.out.println("Lending_iOS_Apply_Estatement_CreditCard");
        ExReport.printReportMessage("Lending iOS - Apply EStatement - Credit Card");
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LB);
        Lib.click(Lib.getMore("Apply eStatement"));
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        ExReport.printReportMessage("E-Statement - Verified Email - Popup confirm to change email ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);

        String strEmail = "";
        Lib.log("email="+(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value")));
        if (Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value").toLowerCase().contains("tcsqa1@tutanota.com")){
            Lib.log("contains");
            strEmail = "tcs.lending@gmail.com";
        } else {
            Lib.log("not contains");
            strEmail = "tcsqa1@tutanota.com";
        }
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL));
        Lib.sleep(1);
        Lib.log("strEmail="+strEmail);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL), strEmail);
        ExReport.printReportMessage("E-Statement - Change Email with new Email="+strEmail);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_NEXT);
        Lib.enterPin("010203");
        ExReport.printReportMessage("E-Statement - Change Email - Enter PIN ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P3_OTP1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_DESC).getText(), "");
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP1));
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP1), "8");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP2), "8");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP3), "8");
        ExReport.printReportMessage("E-Statement - Enter OTP number ");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP4), "8");
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P4_TITLE);
        ExReport.printReportMessage("E-Statement - Change Email - The last page. ");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_TITLE).getText(), "Email successfully verified");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_DESC).getText(), "This email will be used in all services that you have applied with ttb.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_OK).getText(), "OK");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P4_OK);
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CONFIRM);
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_TITLE);
        ExReport.printReportMessage("E-Statement - Verified Email - The last page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE);
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("E-Statement - After click Back To Main Menu ");
    }

    @Test(groups = "Lending_iOS_Apply_Estatement_FlashCard", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingEStatement_ChangeEmail_FlashCard() {
        System.out.println("Lending_iOS_Apply_Estatement_FlashCard");
        ExReport.printReportMessage("Lending iOS - Apply EStatement - Credit Card");
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LB);
        Lib.click(Lib.getMore("Apply eStatement"));
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        ExReport.printReportMessage("E-Statement - Verified Email - Popup confirm to change email ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);


        String strEmail = "";
        Lib.log("email="+(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value")));
        if (Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value").toLowerCase().contains("tcsqa1@tutanota.com")){
            Lib.log("contains");
            strEmail = "tcs.lending@gmail.com";
        } else {
            Lib.log("not contains");
            strEmail = "tcsqa1@tutanota.com";
        }
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL));
        Lib.sleep(1);
        Lib.log("strEmail="+strEmail);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL), strEmail);
        ExReport.printReportMessage("E-Statement - Change Email with new Email="+strEmail);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_NEXT);
        Lib.enterPin("010203");
        ExReport.printReportMessage("E-Statement - Change Email - Enter PIN ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P3_OTP1);
        Lib.assertText(Lib.fX("//div[@id=\"label_otp_information\"]/div[1]").getText(), "");
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP1));
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP1), "8");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP2), "8");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP3), "8");
        ExReport.printReportMessage("E-Statement - Enter OTP number ");
        Lib.sleep(1);
//        Lib.driver.getKeyboard().sendKeys("8");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP4), "8");
//        Lib.sleep(10);
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P4_TITLE);
        ExReport.printReportMessage("E-Statement - Change Email - The last page. ");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_TITLE).getText(), "Email successfully verified");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_DESC).getText(), "This email will be used in all services that you have applied with ttb.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P4_OK).getText(), "OK");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P4_OK);
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CONFIRM);
        try {
                    Lib.waitBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_TITLE);
        ExReport.printReportMessage("E-Statement - Verified Email - The last page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE);
       Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
//        Lib.sleep(10);
        ExReport.printReportMessage("E-Statement - After click Back To Main Menu ");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_CARD_MORE);
        Lib.sleep(1);
        ExReport.printReportMessage("E-Statement - Estatement button is disappear");
        } catch (Exception e){Lib.log(e.getStackTrace());}

    }

    @Test(groups = "Lending_iOS_Apply_Estatement_C2G", dependsOnGroups = { "Lending iOS - Select Loan"})
    public void LendingEStatement_ChangeEmail_C2G() {
        System.out.println("Lending iOS - EStatement - Change Email - C2G");
        ExReport.printReportMessage("Lending iOS - Change Usage Limit - SUP");
        //Apply eStatement Page-1
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_APPLYESTATEMENT_BTN);
        Lib.log("Click Apply E-Statement");
        Lib.clickBy(OneAppElementKeys.LD1W_PRO_LOAN_C2G_APPLYESTATEMENT_BTN);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_EMAIL).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_EMAIL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_DESC2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_CONFIRM).getText(), "");

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHANGEEMAIL);
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_POPUP_CONFIRM);
        ExReport.printReportMessage("E-Statement - Verified Email - Popup confirm to change email ");
        //Apply eStatement Page-2
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_DESC2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_NEXT).getText(), "");

        String strEmail = "";
        Lib.log("email="+(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value")));
        if (Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL).getAttribute("value").toLowerCase().contains("tcsqa1@tutanota.com")){
            Lib.log("contains");
            strEmail = "tcs.lending@gmail.com";
        } else {
            Lib.log("not contains");
            strEmail = "tcsqa1@tutanota.com";
        }
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_CLOSE);
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL)); //LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_EMAIL_XPATH
        Lib.sleep(1);
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_EMAIL), strEmail);
        ExReport.printReportMessage("E-Statement - Change Email with new Email="+strEmail);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P12_MANAGEEMAIL_NEXT); //LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_NEXT_XPATH
        Lib.sleep();
        Lib.enterPin("010203");
        ExReport.printReportMessage("E-Statement - Change Email - Enter PIN ");
        Lib.waitBy(OneAppElementKeys.LD1W_EST_P3_OTP1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTPINFO).getText(), "");
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_EST_P3_OTP1));
        Lib.driver.getKeyboard().sendKeys("8");
        Lib.sleep(1);
        Lib.driver.getKeyboard().sendKeys("8");
        Lib.sleep(1);
        Lib.driver.getKeyboard().sendKeys("8");
        ExReport.printReportMessage("E-Statement - Enter OTP number ");
        Lib.sleep(1);
        Lib.driver.getKeyboard().sendKeys("8");

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P41_TITLE);
        ExReport.printReportMessage("E-Statement - Change Email - The last page. ");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P41_TITLE).getText(), "Email successfully verified");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P41_DESC).getText(), "This email will be used in all services that you have applied with ttb.");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P41_OK).getText(), "OK");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P41_OK);

        Lib.waitBy(OneAppElementKeys.LD1W_EST_P11_TITLE);
        ExReport.printReportMessage("E-Statement - Verified Email - The last page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_EMAIL).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_EMAIL_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_DESC2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P11_CONFIRM).getText(), "");
        ExReport.printReportMessage("E-Statement - Verified Email ");
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CHECKBOX);
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_EST_P11_CONFIRM);
        Lib.sleep(10);
        ExReport.printReportMessage("Apply E-Statement - After Click Confirm ");
        Lib.writelog();
        try {
            Lib.clickBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_DESC).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_PRODUCT_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_LB).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_EMAIL_VALUE).getText(), "");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_EST_P51_VERIFY_BACKTOMAINPAGE).getText(), "");
            Lib.waitBy(OneAppElementKeys.LD1W_PRO_LOAN_LOANDETAILS);
            ExReport.printReportMessage("E-Statement - After click Back To Main Menu ");
        } catch (Exception e) {

        }
    }

    /**
     * **********************
     * 20.Cash for You (Cash Advance)
     * 21.Cash for You (Cash Transfer)
     * 22.Cash for You (Cash Chill Chill)
     * **********************
     */

    @Test(groups = "Lending_iOS_CashForYou_CashAdvance", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCashForYou_Success() {
        System.out.println("Lending_iOS_CashForYou_CashAdvance");
        ExReport.printReportMessage("Lending iOS - Cash For You - Cash Advance");
        String paymentPlan = "Installment"; // "Full|Installment
        String from = "";
        String to = "";
        String amount = "0";
        String installmentPeriod = "";
        String totalPayment = "0";
        String monthlyPayment = "0";
        String tierMonth = "";
        String fee = "0";
        String vat = "0";
        String annualInterestRate = "0";

        Lib.click(Lib.getMore("Cash for You"));
        //Page1
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P1_TITLE);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Advanced - Page 1");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Advanced - Select Acccount - Page2");
        from = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNAME).getText() +" "+ Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNUMBER).getText();
        to = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_RECEIVING_BASICACCOUNT_RADIO).getText().replaceAll("[\\\r|\\\n]", " ");
        amount = Lib.data.getString(Lib.dataProfile+".cashforyou_amount");
        Lib.setTextBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT, amount);
        Lib.sleep(1);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P2_DESC);
        Lib.swipeDownToUp();

        Lib.sleep(1);
        paymentPlan = Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FULL_LB1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FULL_LB2).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADB_P2_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FULL_LB1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FULL_LB2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FEE_VALUE).getText(), "");
        fee = Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_FEE_VALUE).getText();

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_VAT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_VAT_VALUE).getText(), "");
        vat = Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_VAT_VALUE).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_ANNUAL_VALUE).getText(), "");

        annualInterestRate = Lib.fBy(OneAppElementKeys.LD1W_CAS_ADV_P2_ANNUAL_VALUE).getText();
        ExReport.printReportMessage("Cash For You - Cash Advance - Bottom");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_ADV_P2_NEXT);

        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P3_TITLE);
        ExReport.printReportMessage("Cash For You - Cash Advance - Confirmed Page");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Double.parseDouble(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_FEE_VALUE).getText(), fee);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_VAT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_VAT_VALUE).getText(), vat);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_ANNUAL_VALUE).getText(), annualInterestRate);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_CHECKBOX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_READMORE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CHECKBOX);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM);
        Lib.sleep();
        Lib.enterPin(Lib.data.get("config.pin"));
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P4_IMAGE);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Last Page");

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE2).getText(), from);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE2).getText(), to);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Integer.parseInt(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE2).getText(), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_FEE_VALUE).getText(), fee);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_VAT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_VAT_VALUE).getText(), vat);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_ANNUAL_VALUE).getText(), annualInterestRate);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE);
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        Lib.sleep();
        ExReport.printReportMessage("finish");
    }

    @Test(groups = "Lending_iOS_CashForYou_CashChillChill", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCashForYou_CashChilledChilled() {
        System.out.println("Lending_iOS_CashForYou_CashChillChill");
        String paymentPlan = "Installment"; // "Full|Installment
        String from = "";
        String to = "";
        String amount = "0";
        String installmentPeriod = "";
        String totalPayment = "0";
        String monthlyPayment = "0";
        String tierMonth = "";
        String fee = "0";

        Lib.click(Lib.getMore("Cash for You"));
        //Page1
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P1_TITLE);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Page 1");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Page2");
        from = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNAME).getText() +" "+ Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNUMBER).getText();
        to = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_RECEIVING_BASICACCOUNT_RADIO).getText().replaceAll("[\\\r|\\\n]", " ");
        amount = Lib.data.getString(Lib.dataProfile+".cashforyou_amount");
        Lib.setTextBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT, amount);
        Lib.sleep(1);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P2_DESC);
        Lib.swipeDownToUp();
        fee = "0";
        Lib.sleep(1);
        //Select Installment/Cash Chilled Chilled
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_RDO);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.sleep(5);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_MONTHLYINSTALLMENT_DDL);
         paymentPlan = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_LB).getText().replaceAll("[\\\r|\\\n]", " ");
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Installment");
        installmentPeriod = Lib.data.getString(Lib.dataProfile + ".month")+" Month";
        Lib.selectByVisibleText(OneAppElementKeys.LD1W_CAS_P2_INSTALL_MONTHLYINSTALLMENT_DDL, installmentPeriod);

        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_LB).getText(), installmentPeriod);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_SPECIALINTEREST_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TEIRMONTH_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TEIRMONTH_VALUE).getText(), "");
        tierMonth = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TEIRMONTH_VALUE).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_DESC).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_PAYMENTHISTORY).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TOTALPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TOTALPAYMENT_VALUE).getText(), "");
        totalPayment = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_TOTALPAYMENT_VALUE).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_MONTHLYPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_MONTHLYPAYMENT_VALUE).getText(), "");
        monthlyPayment = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_INSTALL_MONTHLYPAYMENT_VALUE).getText();

        Lib.swipeDownToUp();
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Bottom");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_ADV_P2_NEXT);
        //Page3 - Confirm page
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_LB);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Confirmed Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), from);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), to);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Double.parseDouble(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_NOOFMONTHLYINSTALLMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_NOOFMONTHLYINSTALLMENT_VALUE).getText(), installmentPeriod+"s");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TOTALPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TOTALPAYMENT_VALUE).getText(), totalPayment);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_MONTHLYPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_MONTHLYPAYMENT_VALUE).getText(), monthlyPayment);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FEE_VALUE).getText(), new DecimalFormat("#0.00").format(Double.parseDouble(fee)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_SPECIALINTEREST_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TEIRMONTH_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TEIRMONTH_VALUE).getText(), tierMonth);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_IHAVEANDAGREE_LB).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CHECKBOX);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM).getText(), "");
        Lib.swipeDownToUp();
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM);
        Lib.sleep(1);
        Lib.enterPin(Lib.data.get("config.pin"));
        //Page4 - Last Page
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P4_IMAGE);
        Lib.sleep(1);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Last Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TITLE).getText(),  "Successfully Transferred to Account "+new DecimalFormat("#0,000.00").format(Double.parseDouble(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE1).getText() + " " + Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE1).getText(), from);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE1).getText() + " " + Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE2).getText(), to);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Double.parseDouble(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE1).getText(), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TOTOALPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TOTALPAYMENT_VALUE).getText(), totalPayment);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_MONTHLYPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_MONTHLYPAYMENT_VALUE).getText(), monthlyPayment);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_NUMBEROFMONTH_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_NUMBEROFMONTH_VALUE).getText(), installmentPeriod+"s");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FEE_VALUE).getText(), new DecimalFormat("#0,000.00").format(Double.parseDouble(fee)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_REFNO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_REFNO_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TEIRMONTH_LB).getText(), tierMonth);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TEIRMONTH_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("finish");
    }

    @Test(groups = "Lending_iOS_CashForYou_CashTransfer", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingCashForYou_Failed() {
        System.out.println("Lending_iOS_CashForYou_CashTransfer");

        String paymentPlan = "Installment"; // "Full|Installment
        String from = "";
        String to = "";
        String amount = "0";
//        String installmentPeriod = "";
//        String totalPayment = "0";
//        String monthlyPayment = "0";
//        String tierMonth = "";
        String fee = "0";
        String vat = "0";
        String annualInterestRate = "0";

        Lib.click(Lib.getMore("Cash for You"));
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P1_TITLE);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Page 1");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Page2");
        from = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNAME).getText() +" "+ Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_CARDNUMBER).getText();
        to = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_RECEIVING_BASICACCOUNT_RADIO).getText().replaceAll("[\\\r|\\\n]", " ");
        amount = Lib.data.getString(Lib.dataProfile+".cashforyou_amount");
        Lib.setTextBy(OneAppElementKeys.LD1W_CAS_P2_AMOUNT, amount);
        Lib.sleep(1);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P2_DESC);
        Lib.swipeDownToUp();
        Lib.sleep();
        //Select Full/Cash Transfer
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P2_FULL_RADIO);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.sleep(5);
        paymentPlan = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_LB).getText().replaceAll("[\\\r|\\\n]", " ");
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Full");

        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P2_FULL_FEE_LB);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_FEE_VALUE).getText(), "");
        fee = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_FEE_VALUE).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_VAT_LABEL).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_VAT_VALUE).getText(), "");
        vat = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_VAT_VALUE).getText();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_ANNUAL_VALUE).getText(), "");
        annualInterestRate = Lib.fBy(OneAppElementKeys.LD1W_CAS_P2_FULL_ANNUAL_VALUE).getText();

        Lib.swipeDownToUp();
         ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Select Acccount - Bottom");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_ADV_P2_NEXT); //LENDING_WEB_CASH_TRAN_P2_NEXT_ID

        Lib.clickBy(OneAppElementKeys.LD1W_CAS_ADV_P2_NEXT);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P3_TITLE);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Confirmed Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FROM_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), from);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_TO_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), to);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Double.parseDouble(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_PAYMENTPLAN_VALUE).getText().replaceAll("[\\\r|\\\n]", " "), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_FEE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_FEE_VALUE).getText(), fee);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_VAT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_VAT_VALUE).getText(), vat);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_ANNUAL_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_FULL_ANNUAL_VALUE).getText(), annualInterestRate);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_CHECKBOX_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_READMORE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CHECKBOX);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_CAS_P3_CONFIRM);
        Lib.sleep();
        Lib.enterPin(Lib.data.get("config.pin"));

        Lib.waitBy(OneAppElementKeys.LD1W_CAS_P4_IMAGE);
        ExReport.printReportMessage("Cash For You - Cash Chilled Chilled - Last Page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TITLE).getText(), "Successfully Transferred to Account "+new DecimalFormat("#0,000.00").format(Integer.parseInt(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TITLE2).getText(), "Cash Chill Chill Information");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_LB).getText(), "From");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FROM_VALUE2).getText(), from);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_LB).getText(), "To");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE1)+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_TO_VALUE2).getText(), to);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_LB).getText(), "Amount");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_AMOUNT_VALUE).getText(), new DecimalFormat("#0,000.00").format(Integer.parseInt(amount)));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_LB).getText(), "Payment Plan");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE1).getText()+" "+Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_PAYMENTPLAN_VALUE1).getText(), paymentPlan);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_FEE_LB).getText(), "Fee");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_FEE_VALUE).getText(), fee);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_VAT_LB).getText(), "VAT");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_VAT_VALUE).getText(), vat);
        try {
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_ANNUAL_LB).getText(), "Annual interest rate");
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_FULL_ANNUAL_VALUE).getText(), annualInterestRate);
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE).getText(), "Back to Main Page");
            Lib.clickBy(OneAppElementKeys.LD1W_CAS_P4_BACKTOMAINPAGE);
            Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
            Lib.sleep(20);
            ExReport.printReportMessage("finish");
        } catch (Exception e){

        }

    }

    /**
     * **********************
     * 23.Apply So Good (PRI)
     * 24.Apply So Good (SSC)
     * **********************
     */
    @Test(groups = "Lending_iOS_ApplySoGood_PRI", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingApplySoGood_PRI() {
        System.out.println("Lending_iOS_ApplySoGood_PRI");
         Lib.sleep(5);
        Lib.click(Lib.getMore("so goood"));
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P1_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_NEXT).getText(), "");
        ExReport.printReportMessage("Apply So Good - Page 1");

        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P2_CARDNAME);
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_CARDNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_CARDNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_PLEASESELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_RESULT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB).getText(), "");

        ExReport.printReportMessage("Apply So Good - Page 2");

        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB);
        Lib.sleep();
        ExReport.printReportMessage("Apply so Good - Page 2 - click Select All");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB);
        Lib.sleep();
        ExReport.printReportMessage("Apply so Good - Page 2 - click Unselect All");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(0));
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(1));
        String name1 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONNAMES).get(0).getText();
        String name2 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONNAMES).get(1).getText();
        String value1 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(0).getText();
        String value2 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(1).getText();
        ExReport.printReportMessage("Apply so Good - Page 2 - click 2 Transactions");
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.swipeDownToUp();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_NEXT).getText(), "");
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P2_NEXT);
        ExReport.printReportMessage("Apply So Good - Page2 - Bottom");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        //Case 3 Months
        int index = 0; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        ExReport.printReportMessage("Apply So Good - Page3 - Select Monthly Payment - 3 Months");
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 3 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
        ExReport.printReportMessage("Apply So Good - Page4 - 3 Months- Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        ExReport.printReportMessage("Apply So Good - Page4 - 3 Months - Click Selected Transaction");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);

        //Case 6 months
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_BACK);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        index = 1; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 6 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
       ExReport.printReportMessage("Apply So Good - Page4 - 6 Months - Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        Lib.sleep(1);
        ExReport.printReportMessage("Apply So Good - Page4 - 6 Months - Click Selected Transaction");
         Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);

        //Case 10 months
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_BACK);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        index = 2; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 10 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
       ExReport.printReportMessage("Apply So Good - Page4 - 10 Months - Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page4 - 10 Months - Click Selected Transaction");

        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_NEXT);
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_NEXT);
        Lib.sleep(10);
        Lib.writelog();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_LB);
        ExReport.printReportMessage("Apply So good - Page5 - Final page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_SELECTTRANSACTION_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_SELECTTRANSACTION_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TOTALINSTALLMENTAMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TOTALINSTALLMENTAMOUNT_VALUE).getText(), "0.69% 10 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_INSTALLMENTPLAN_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONTIME_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONTIME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P5_BACKTOMAINPAGE);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("Apply So good - Page5 - After click Back to Main Page");
    }

    @Test(groups = "Lending_iOS_ApplySoGood_SSC", dependsOnGroups = { "Lending iOS - Select Card - More"})
    public void LendingApplySoGood_SSC_3Mos() {
        System.out.println("Lending_iOS_ApplySoGood_SSC");
        Lib.sleep(5);
        Lib.click(Lib.getMore("so goood"));
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P1_TITLE);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_DESC1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P1_NEXT).getText(), "");
        ExReport.printReportMessage("Apply So Good - Page 1");

        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P2_CARDNAME);
        Lib.sleep(1);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_CARDNAME).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_CARDNUMBER).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_PLEASESELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_RESULT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB).getText(), "");

        ExReport.printReportMessage("Apply So Good - Page 2");

        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB);
        Lib.sleep();
        ExReport.printReportMessage("Apply so Good - Page 2 - click Select All");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_SELECTALL_CHB);
        Lib.sleep();
        ExReport.printReportMessage("Apply so Good - Page 2 - click Unselect All");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(0));
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(1));
        String name1 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONNAMES).get(0).getText();
        String name2 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONNAMES).get(1).getText();
        String value1 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(0).getText();
        String value2 = Lib.fsBy(OneAppElementKeys.LD1W_SOG_P2_TRANSACTIONVALUES).get(1).getText();
        ExReport.printReportMessage("Apply so Good - Page 2 - click 2 Transactions");
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.swipeDownToUp();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P2_NEXT).getText(), "");
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P2_NEXT);
        ExReport.printReportMessage("Apply So Good - Page2 - Bottom");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P2_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        //Case 3 Months
        int index = 0; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        ExReport.printReportMessage("Apply So Good - Page3 - Select Monthly Payment - 3 Months");
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 3 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
        ExReport.printReportMessage("Apply So Good - Page4 - 3 Months- Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        ExReport.printReportMessage("Apply So Good - Page4 - 3 Months - Click Selected Transaction");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);

        //Case 6 months
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_BACK);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        index = 1; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 6 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
       ExReport.printReportMessage("Apply So Good - Page4 - 6 Months - Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        Lib.sleep(1);
        ExReport.printReportMessage("Apply So Good - Page4 - 6 Months - Click Selected Transaction");
         Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);

        //Case 10 months
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_BACK);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST);
        index = 2; //Case 3 Moss=0, 6 Mos=1, 10 Mos=2, 99 Mos=3, 4 Mos=5
        Lib.log("Index="+index);
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P3_DESC1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_MONTHLYPAYMENT_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALINTERESTAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_LB).get(index).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_TOTALAMOUNTS_LIST_VALUE).get(index).getText(), "");
        Lib.click(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_INSTALLMENTPLANS_LIST).get(index));
        Lib.swipeDownToUp();
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page3 - 10 Months - Bottom");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P3_NEXT).get(0).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2);
        Lib.sleep();
       ExReport.printReportMessage("Apply So Good - Page4 - 10 Months - Confirm Top");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TITLE2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITCARD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CREDITNUMBER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_INSTALLMENTPLAN_VALUE).getText(), "0% 3 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_FIRSTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALINTERESTPAYMENT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TOTALAMAOUNT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_SELECTTRANSACTION).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONITEMS_ARROW);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB);
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(0).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_LB).get(1).getText(), "");
        Lib.assertText(Lib.fsBy(OneAppElementKeys.LD1W_SOG_P4_TRANSACTIONVALUES_LIST_VALUE).get(1).getText(), "");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX);
        Lib.sleep();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_CHECKBOX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_READMORE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P4_NEXT).getText(), "");
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P3_NEXT);
        ExReport.printReportMessage("Apply So Good - Page4 - 10 Months - Click Selected Transaction");

        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P4_NEXT);
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P4_NEXT);
        Lib.sleep(10);
        Lib.writelog();
        Lib.waitBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_LB);
        ExReport.printReportMessage("Apply So good - Page5 - Final page");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_CREDITCARDNO_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_SELECTTRANSACTION_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_SELECTTRANSACTION_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TOTALINSTALLMENTAMOUNT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TOTALINSTALLMENTAMOUNT_VALUE).getText(), "0.69% 10 Months");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_INSTALLMENTPLAN_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_INSTALLMENTPLAN_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONDATE_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONDATE_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONTIME_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_TRANSACTIONTIME_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_SOG_P5_BACKTOMAINPAGE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_SOG_P5_BACKTOMAINPAGE);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_UNBTILLED);
        ExReport.printReportMessage("Apply So good - Page5 - After click Back to Main Page");
    }

    /**
     * **********************
     * 25.Flexi-loan(Credit Card)
     * 26.Flexi-loan(Flash Card)
     * 27.Flexi-loan(C2G)
     * 28.Flexi-loan(C2G Top Up)
     * **********************
     */
    @Test(groups = "Lending_iOS_FlexiLoan_CreditCard", dependsOnGroups = { "Activate new flow - Lending"})
    public void LendingFlexiLoan_HomeToFlexiLoan() {
        System.out.println("Lending_iOS_FlexiLoan_CreditCard");
        String pin = Lib.data.get("config.pin");
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
        } catch (Exception e) { }
        Lib.waitBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE);
            Lib.sleep(5);
            Lib.tap(Lib.fBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE));
            Lib.sleep(5);
        } catch (Exception e) { }
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
        Lib.sleep();
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_CREDITCARD);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_CREDITCARD);

        try {
            Lib.enterPin(pin);
            ExReport.printReportMessage("Homescreen - Enter Pin=" + pin);
        } catch (Exception e) {
            System.out.println("No Enter PIN");
        }
//        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
////            Lib.enterPin(pin);
//            Lib.setWebview(0);
//        } else {
//            Lib.setWebview(1);
//        }
        Lib.setWebview(OneAppElementKeys.LD1W_FLX_P1_TTBRESERVEINFINIT);



        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_TTBRESERVEINFINIT);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBRESERVEINFINIT_VALUE).getText(), "ttb reserve infinite");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBRESERVESIGNATURE_VALUE).getText(), "ttb reserve signature");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBABSOLUTE_VALUE).getText(), "ttb absolute");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOFAST_VALUE).getText(), "ttb so fast");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOSMART_VALUE).getText(), "ttb so smart");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOCHILL_VALUE).getText(), "ttb so chill");

        String cardName = "absolute";
        if (cardName.toLowerCase().contains("infinite")){
            //click so smart
            Lib.log("Click TTB Reserve Infinite");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_TTBRESERVEINFINIT_VALUE);
        }
        else if (cardName.toLowerCase().contains("signature")){
            Lib.log("Click TTB Reserve Signature");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBRESERVESIGNNATURE);
        }
        else if (cardName.toLowerCase().contains("absolute")){
            Lib.log("Click TTB Absolute");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBABSOLUTE);
        }
        else if (cardName.toLowerCase().contains("fast")){
            Lib.log("Click TTB So Fast");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOFAST);
        }
        else if (cardName.toLowerCase().contains("smart")){
            Lib.log("Click TTB Smart");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOSMART);
        }
        else if (cardName.toLowerCase().contains("chill")){
            Lib.log("Click TTB Smart");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOSMART);
        } else {
            Lib.log(cardName+" is not found!");
        }

        Lib.sleep(10);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION)){
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION).getText(), "");
            Assert.fail("ทำรายการต่อ ????");
        }

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_ACCOUNTBASIC1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_ACCOUNTBASIC1);
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_DEBITBULL_CHB);
        Lib.sleep(1);
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.sleep(10);
        Lib.swipeDownToUp();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P2_ADDRESS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P2_NEXT);

//        Lib.waitVisible(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_TITLE2_XPATH);
//        //Business Type
//        Lib.selectVisibleText(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_BUSINESSTYPE_SELECT_XPATH, "C - การผลิต");
//        Lib.swipeDownToUp();
//        Lib.click(Lib.fId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_PHONENUMBER_TXT_ID));
//        Lib.sleep();
//        Lib.setText(Lib.fId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_PHONENUMBER_TXT_ID), "026267222");
//        Lib.setText(Lib.fId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_EXTENSION_TXT_ID), "1234");
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P3_TITLE2);
        //Business Type
        Lib.selectByVisibleText(OneAppElementKeys.LD1W_FLX_P3_BUSINESSTYPE_SELECT, "C - การผลิต");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER);
        Lib.sleep();
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER), "026267222");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_EXTENSION), "1234");


//        Lib.clickJS(Lib.fX("//*[@id=\"__next\"]/div[1]/div/div[11]/h3"));
//        Lib.swipeDownToUp();
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_CONTACTADDRESS_RD_XPATH);
//        Lib.sleep();
//        Lib.click(Lib.fId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_NEXT_ID));
//        Lib.waitVisibleId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_TITLE2_ID);
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX1_XPATH);
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX2_XPATH);
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX3_XPATH);
//        Lib.click(Lib.fId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_NEXT_ID));
//
//        Lib.waitVisible(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE5_CANCEL_XPATH);
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE5_ACCEPT_XPATH);
//        Lib.enterPin(pin);
//
//        Lib.waitVisible(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_TITLE2);
//        Lib.assertText(Lib.fX(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_NAME_LB_XPATH).getText(), "");
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_NEXT_XPATH);
//
//        Lib.waitVisibleId(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_TITLE2_ID);
//        Lib.assertText(Lib.fX(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CREDITLIMIT_LB_XPATH).getText(), "");
//        Lib.assertText(Lib.fX(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CREDITLIMIT_VALUE_XPATH).getText(), "");
//        Lib.click(Lib.LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CANCEL_XPATH);
//        Lib.sleep(20);
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_CONTACTADDRESS_RD);
        Lib.sleep();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P4_TITLE2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX3);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_CANCEL);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P5_ACCEPT);
        Lib.enterPin(pin);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P6_NAME_LB).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P6_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P7_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_VALUE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P7_CANCEL);
        Lib.sleep(20);
    }

    @Test(groups = "Lending_iOS_FlexiLoan_C2G", dependsOnGroups = { "Activate new flow - Lending"})
    public void LendingFlexiLoan_C2G() {
        System.out.println("Lending_iOS_FlexiLoan_C2G");
        String pin = Lib.data.get("config.pin");
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
        } catch (Exception e) { }
        Lib.waitBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE);
            Lib.sleep(5);
            Lib.tap(Lib.fBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE));
            Lib.sleep(5);
        } catch (Exception e) { }
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
//        Lib.sleep();
        Lib.log("Click Personal Loan");
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_PERSONALLOAN);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_PERSONALLOAN);

        try {
            Lib.enterPin(pin);
            ExReport.printReportMessage("Homescreen - Enter Pin=" + pin);
        } catch (Exception e) {
            System.out.println("No Enter PIN");
        }
        Lib.sleep(10);
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
//        setWebview(1);
/*        try {
            Lib.setWebviewFast(OneAppElementKeys.LD1W_FLX_P0_AGREE);
            Lib.waitBy1(OneAppElementKeys.LD1W_FLX_P0_AGREE, 20);
            Lib.swipeDownToUp();
            Lib.sleep(1);
            Lib.swipeDownToUp();
            Lib.sleep(1);
            Lib.swipeDownToUp();
            Lib.sleep(1);
            Lib.swipeDownToUp();
            Lib.log("Click Agree");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P0_AGREE);
            Lib.sleep(1);
            Lib.log("Click Next");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P0_NEXT);

        } catch (Exception e) {

        }
        Lib.setWebviewFast(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE2);*/

        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE2).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_IMAGE1).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TITLE2).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_IMAGE1).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB2).getText(), "");

        String applyLoan = "c2g";
        if (applyLoan.toLowerCase().contains("c2g")){
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB1);
        } else if (applyLoan.toLowerCase().contains("flash")){
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB1);
        } else {
            Lib.log(applyLoan +" is not found!");
        }

        try {
            Lib.waitBy1(OneAppElementKeys.LD1W_FLX_C2G_P1_CLOSE, 10);
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P1_CLOSE);
        } catch(Exception e) {}

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);

        Lib.sleep(5);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION)){
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION).getText(), "");
            Assert.fail("ทำรายการต่อ ????");
        }
        Lib.sleep();
        Lib.log("สมัครบัตรเคดิต");
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);

        Lib.log("page 1/7");
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_C2G_P3_STEP1_7);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_STEP1_7).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_STEP_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TEXT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_MIN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_MAX).getText(), "");
//        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TITLE).getText(), "");
//        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TRANSFER_LB).getText(), "");
//        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TRANSFER_VALUE).getText(), "");
//        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_OLD_LB).getText(), "");
//        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_OLD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_DESC).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_PAYMONTHT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_PAYMONTHT_SELECT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_LIMIT_PAY).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_LIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_PAY_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_PAY_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_MONTH_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_MONTH_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_INT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_INT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_NOTE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_NEXT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_MORELIMIT).getText(), "");

        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TEXT));
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TEXT), "500000");
        Lib.tap(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_TITLE));
        Lib.selectIndex(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_PAYMONTHT_SELECT), 1);
        ExReport.printReportMessage("Flexi Loan - C2G - set Limit=500,000 and Installment=13 months");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P3_NEXT);
        Lib.sleep(10);


        Assert.fail();



        /*Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_TTBRESERVEINFINIT);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBRESERVEINFINIT_VALUE).getText(), "ttb reserve infinite");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBRESERVESIGNATURE_VALUE).getText(), "ttb reserve signature");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBABSOLUTE_VALUE).getText(), "ttb absolute");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOFAST_VALUE).getText(), "ttb so fast");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOSMART_VALUE).getText(), "ttb so smart");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_TTBSOCHILL_VALUE).getText(), "ttb so chill");

        String cardName = "absolute";
        if (cardName.toLowerCase().contains("infinite")){
            //click so smart
            Lib.log("Click TTB Reserve Infinite");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_TTBRESERVEINFINIT_VALUE);
        }
        else if (cardName.toLowerCase().contains("signature")){
            Lib.log("Click TTB Reserve Signature");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBRESERVESIGNNATURE);
        }
        else if (cardName.toLowerCase().contains("absolute")){
            Lib.log("Click TTB Absolute");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBABSOLUTE);
        }
        else if (cardName.toLowerCase().contains("fast")){
            Lib.log("Click TTB So Fast");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOFAST);
        }
        else if (cardName.toLowerCase().contains("smart")){
            Lib.log("Click TTB Smart");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOSMART);
        }
        else if (cardName.toLowerCase().contains("chill")){
            Lib.log("Click TTB Smart");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_TTBSOSMART);
        } else {
            Lib.log(cardName+" is not found!");
        }

        Lib.sleep(5);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION)){
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION).getText(), "");
            Assert.fail("ทำรายการต่อ ????");
        }

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_APPLYCREDIT);
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_ACCOUNTBASIC1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_ACCOUNTBASIC1);
        Lib.sleep(1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_DEBITBULL_CHB);
        Lib.sleep(1);
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.sleep(10);
        Lib.swipeDownToUp();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P2_ADDRESS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P2_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P3_TITLE2);
        //Business Type
        Lib.selectByVisibleText(OneAppElementKeys.LD1W_FLX_P3_BUSINESSTYPE_SELECT, "C - การผลิต");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER);
        Lib.sleep();
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER), "026267222");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_EXTENSION), "1234");

        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_CONTACTADDRESS_RD);
        Lib.sleep();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P4_TITLE2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX3);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_CANCEL);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P5_ACCEPT);
        Lib.enterPin(pin);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P6_NAME_LB).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P6_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P7_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_VALUE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P7_CANCEL);
        Lib.sleep(20);
*/
    }

        @Test(groups = "Lending_iOS_FlexiLoan_FlashCard", dependsOnGroups = { "Activate new flow - Lending"})
    public void LendingFlexiLoan_FlashCard() {
        System.out.println("Lending_iOS_FlexiLoan_FlashCard");
        String pin = Lib.data.get("config.pin");
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_HOMEGUIDLINENEXT);
        } catch (Exception e) { }
        Lib.waitBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICE_BTN);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        try {
            Lib.waitBy1(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE, 10);
            Lib.clickBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE);
            Lib.sleep(5);
            Lib.tap(Lib.fBy(OneAppElementKeys.LD1I_HOM_SERVICEGUIDELINE));
            Lib.sleep(5);
        } catch (Exception e) { }
        if (Lib.deviceProfile.toLowerCase().contains("nootp")){
            Lib.setWebview(0);
        } else {
            Lib.setWebview(1);
        }
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_APPLY);
//        Lib.sleep();
        Lib.log("Click Personal Loan");
        Lib.waitBy(OneAppElementKeys.LD1W_SERVICE_PERSONALLOAN);
        Lib.clickBy(OneAppElementKeys.LD1W_SERVICE_PERSONALLOAN);

        try {
            Lib.enterPin(pin);
            ExReport.printReportMessage("Homescreen - Enter Pin=" + pin);
        } catch (Exception e) {
            System.out.println("No Enter PIN");
        }
        Lib.sleep(10);
        Lib.setWebview(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TITLE2).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_IMAGE1).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB2).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TITLE2).getText(), "");
        Lib.assertTrue(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_IMAGE1).isDisplayed());
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB1).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB2).getText(), "");

        String applyLoan = "flash";
        if (applyLoan.toLowerCase().contains("c2g")){
            Lib.log("Click Apply C2G");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P1_TTBC2G_LB1);
        } else if (applyLoan.toLowerCase().contains("flash")){
            Lib.log("Click Apply Flash");
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_FLA_P1_TTBFLASHCARD_LB1);
        } else {
            Lib.log(applyLoan +" is not found!");
        }


        try {
            Lib.waitBy1(OneAppElementKeys.LD1W_FLX_C2G_P1_CLOSE, 10);
            Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P1_CLOSE);
        } catch(Exception e) {}

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);

        Lib.sleep(5);
        Lib.waitInVisibleBy(OneAppElementKeys.LD1W_PRO_CARD_LOADING);
        if (Lib.isElementPresentBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION)){
            Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P1_CONTINUETRANSACTION).getText(), "");
            Assert.fail("ทำรายการต่อ ????");
        }

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P2_APPLYPERSONALLOAN);
        Lib.sleep(1);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TITLE);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TITLE);
        Lib.sleep(1);

        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_STEP1_7).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_STEP_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_TEXT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_MIN).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_LIMIT_MAX).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TRANSFER_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_TRANSFER_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_OLD_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYRECEIVED_OLD_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_DESC).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_PAYMONTHT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SELECTPAYMENT_PAYMONTHT_SELECT).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_TITLE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_LIMIT_PAY).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_LIMIT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_PAY_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_PAY_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_MONTH_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_MONTH_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_INT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_SUMMARYPAY_INT_VALUE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_NOTE).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_C2G_P3_NEXT).getText(), "");

        Assert.fail();

        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_DEBITBULL_CHB);
        Lib.sleep(1);
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P1_NEXT);
        Lib.sleep(10);
        Lib.swipeDownToUp();
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P2_ADDRESS).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P2_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P3_TITLE2);
        //Business Type
        Lib.selectByVisibleText(OneAppElementKeys.LD1W_FLX_P3_BUSINESSTYPE_SELECT, "C - การผลิต");
        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER);
        Lib.sleep();
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_PHONENUMBER), "026267222");
        Lib.setText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P3_EXTENSION), "1234");

        Lib.swipeDownToUp();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_CONTACTADDRESS_RD);
        Lib.sleep();
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P3_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P4_TITLE2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX1);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX2);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_CHECKBOX3);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P4_NEXT);
        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_CANCEL);
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P5_ACCEPT);
        Lib.enterPin(pin);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P5_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P6_NAME_LB).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P6_NEXT);

        Lib.waitBy(OneAppElementKeys.LD1W_FLX_P7_TITLE2);
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_LB).getText(), "");
        Lib.assertText(Lib.fBy(OneAppElementKeys.LD1W_FLX_P7_CREDITLIMIT_VALUE).getText(), "");
        Lib.clickBy(OneAppElementKeys.LD1W_FLX_P7_CANCEL);
        Lib.sleep(20);
    }
}
