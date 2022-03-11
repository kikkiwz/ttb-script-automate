package com.tmb.automation.pages.primarybanking2;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Log;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
public class AccountDetails extends AppiumLibrary {

    HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
    AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);


    public AccountDetails(AppiumDriver<WebElement> driver) {
        super((AppiumDriver<WebElement>) driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        alertAction("accept");
    }

//    public static void swipeToRight(String accountNumber) {
//        HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
//        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
//
//        WebElement element = adps.fX(adps.adSp_swiper_pagination);
//        List<WebElement> elements = element.findElements(By.xpath("./child::*"));
//        System.out.println("Elements total are:" + elements.size());
//
//        for (int i = 0; i <= elements.size(); i++) {
//
//            if (hs.isElementPresent(elements.get(i))) {
//                adps.click(elements.get(i));
//                adps.waitInVisible(adps.adLd_loading_box, 10);
//                Log.logger.debug(">>>>>>>>>>>>>> Actual: " + " " + hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText() + " " + "expected:" + accountNumber);
//                if (!hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText().equalsIgnoreCase(accountNumber)) {
//
//                    adps.click(elements.get(i));
//                    adps.waitInVisible(adps.adLd_loading_box, 10);
//                    //Log.logger.info("-------------------------------{} account_number" + " " + hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText());
//                    adps.assertText(hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText(), accountNumber);
//
//                } else {
//                    adps.assertText(hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText(), accountNumber);
//                    Log.logger.info(">>>>>>>>>>>>>>>>>{} Account Number Matched!!!!!");
//                    break;
//                }
//            } else {
//
//                break;
//
//
//            }
//
//        }
//
//    }

//    public static void swipeToLeftTest(String accountNumber) {
//        HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
//        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
//
//        WebElement element = adps.fX(adps.adSp_swiper_pagination);
//        List<WebElement> elements = element.findElements(By.xpath("./child::*"));
//        System.out.println("Elements total are:" + elements.size());
//
//        for (int i = elements.size() - 1; i >= 0; i--) {
//
//            if (hs.isElementPresent(elements.get(i))) {
//                adps.click(elements.get(i));
//                adps.waitInVisible(adps.adLd_loading_box, 20);
//                Log.logger.debug(">>>>>>>>>>>>>> Actual: " + " " + hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText() + " " + "expected:" + accountNumber);
//                if (!hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText().equalsIgnoreCase(accountNumber)) {
//
//                    adps.click(elements.get(i));
//                    adps.waitInVisible(adps.adLd_loading_box, 20);
//                    //Log.logger.info("-------------------------------{} account_number" + " " + hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText());
//                    adps.assertText(hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText(), accountNumber);
//
//                } else {
//                    adps.assertText(hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText(), accountNumber);
//                    Log.logger.info(">>>>>>>>>>>>>>>>>{} Account Number Matched!!!!!");
//                    break;
//                }
//            } else {
//
//                break;
//
//
//            }
//
//        }
//
//    }

    public enum ACCOUNT {
        All_Free_Account,
        No_Fix_Account,
        Dream_Saving_Account,
        Basic_Saving_Account,
        Basic_Current_Account,
        Saving_Care_Account,
        Basic_Term_Deposite
    }

    public enum ACCOUNT_TYPE {
        SDA, CDA, DDA
    }


    public static void verifyAllFreeAccount(ACCOUNT_TYPE accountType) {
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
        //verify all free account
        Log.logger.debug("Verifying ----->{}" + accountType);
        adps.assertText(adps.fX(adps.adLb_account_type_value_label).getText(), "Saving (TMB All Free Account)");
        adps.assertText(adps.fX(adps.adLb_account_name_value_label).getText(), "NAME TEST");
        adps.assertText(adps.fX(adps.adLb_status_value_label).getText(), "ACTIVE");
        adps.assertText(adps.fX(adps.adLb_branch_value_label).getText(), "SANAM PAO");
        adps.isElementPresent(adps.adLb_virtual_passbook_label);
        adps.isElementPresent(adps.adLb_my_debit_cards_label);
        adps.isElementPresent(adps.adLb_all_free_protection);
        adps.isElementPresent(adps.adLb_annual_fee);
        Log.logger.debug("Verify ----->{}" + accountType + "finish.");
        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_activity_tab);
    }


    void verifyNoFixAccount(ACCOUNT_TYPE accountType) {
        clickExpandTab();
        Log.logger.debug("Verifying ----->{}" + accountType);
        adps.assertText(adps.fX(adps.adLb_goal_balance_value_label).getText(), "0");
        adps.assertText(adps.fX(adps.adLb_account_type_value_label).getText(), "Saving (No Fix Account)");
        adps.assertText(adps.fX(adps.adLb_account_name_value_label).getText(), "NAME TEST");
        adps.assertText(adps.fX(adps.adLb_status_value_label).getText(), "ACTIVE");
        adps.assertText(adps.fX(adps.adLb_branch_value_label).getText(), "SRIYAN");
        adps.assertText(adps.fX(adps.adLb_interest_rate_value_label).getText(), "0.300%");
        adps.assertText(adps.fX(adps.adLb_cumulative_interest_value_label).getText(), "991..73");

        adps.isElementPresent(adps.adLb_virtual_passbook_label);
        adps.isElementPresent(adps.abLb_bonus_interest_rate_label);
        adps.isElementPresent(adps.abDesc_Interest_rate_description);

        Log.logger.debug("Verify ----->{}" + accountType + "finish.");

        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_activity_tab);

    }

    void verifyDreamSavingAccount(ACCOUNT_TYPE accountType) {
        Log.logger.debug("");

    }

    void verifyBasicSavingAccount(ACCOUNT_TYPE accountType) {
        clickExpandTab();
        Log.logger.debug("Verifying ----->{}" + accountType);
        adps.assertText(adps.fX(adps.abLb_overdraft).getText(), "0");
        adps.assertText(adps.fX(adps.adLb_account_type_value_label).getText(), "Saving (Basic Account)");
        adps.assertText(adps.fX(adps.adLb_account_name_value_label).getText(), "NAME TEST NAME TEST2");
        adps.assertText(adps.fX(adps.adLb_status_value_label).getText(), "ACTIVE");
        adps.assertText(adps.fX(adps.adLb_branch_value_label).getText(), "SRIYAN");
        adps.assertText(adps.fX(adps.adLb_interest_rate_value_label).getText(), "0.125%");
        adps.assertText(adps.fX(adps.adLb_cumulative_interest_value_label).getText(), "74.21");

        adps.isElementPresent(adps.adLb_virtual_passbook_label);
        adps.isElementPresent(adps.adLb_my_debit_cards_label);

        Log.logger.debug("Verify ----->{}" + accountType + "finish.");

        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_activity_tab);


    }

    void verifyBasicCurrentAccount(ACCOUNT_TYPE accountType) {
        clickExpandTab();
        Log.logger.debug("Verifying ----->{}" + accountType);
        adps.assertText(adps.fX(adps.abLb_overdraft).getText(), "0");
        adps.assertText(adps.fX(adps.adLb_account_type_value_label).getText(), "Saving (TMB All Free Account)");
        adps.assertText(adps.fX(adps.adLb_account_name_value_label).getText(), "นาย NAMEO TESTO");
        adps.assertText(adps.fX(adps.adLb_status_value_label).getText(), "ACTIVE");
        adps.assertText(adps.fX(adps.adLb_branch_value_label).getText(), "PHAHONYOTHIN");


        adps.isElementPresent(adps.adLb_my_debit_cards_label);

        Log.logger.debug("Verify ----->{}" + accountType + "finish.");

        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_activity_tab);


    }

    void verifyBasicTermDeposite(ACCOUNT_TYPE accountType) {

        clickExpandTab();
        Log.logger.debug("");

    }


    public static void goToAccountDetails() throws InterruptedException {
        HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
        AccountDetailPageScreen ad = new AccountDetailPageScreen(Base.appiumDriver);


        hs.waitVisible(hs.saLbHS_footer_Service, 10);
       // ExtentListeners.printReportMessage("Main Menu");
        hs.click(hs.saLbHS_footer_Service);
        hs.EnterPin("010203");
        //hs.printContext();
        Thread.sleep(3000);
        hs.printContext();
       // ExtentListeners.printReportMessage("Discover Page");
        hs.setContext("WEBVIEW_com.ttbbank.oneapp.vit");
        ad.waitVisible(ad.adMn_accounts_menu, 5);
        ad.click(ad.adMn_accounts_menu);
        ad.waitVisible(ad.adLb_account_details_label, 5);
       // ExtentListeners.printReportMessage("Account Details");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        ad.writeLog();

    }


    public static void clickExpandTab(String message) {
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
        adps.waitVisible(adps.adTb_activity_tab, 3);
        adps.waitVisible(adps.adTb_details_tab, 3);
        adps.waitVisible(adps.adTb_expand_tab, 3);
        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_details_tab);
       // Base.sleep(10);
        ExtentReport4.printReportMessage(message);
    }


    public static void clickExpandTab() {
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
        adps.waitVisible(adps.adTb_activity_tab, 3);
        adps.waitVisible(adps.adTb_details_tab, 3);
        adps.waitVisible(adps.adTb_expand_tab, 3);
        adps.click(adps.adTb_expand_tab);
        adps.click(adps.adTb_details_tab);
    }

    public static void touchActionSwipeLeft() {
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);
        ;
        TouchAction action = new TouchAction(Base.appiumDriver);
        action.press(PointOption.point(300, 527))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(1036, 527)).release().perform();

    }

    public static void touchActionSwipeRight(String accountNumber) {
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);

        WebElement element = adps.fX(adps.adSp_swiper_pagination);
        List<WebElement> elements = element.findElements(By.xpath("./child::*"));
        System.out.println("List of elements are :" + elements.size());

        try {
            for (int i = 0; i < elements.size(); i++) {
                if (!adps.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText().equalsIgnoreCase(accountNumber)) {
                    adps.waitVisible("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]",20);
                    adps.assertText(adps.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText(), accountNumber);
                    Log.logger.info(">>>>>>>>>>>>>>>>>{} Account Number Not Match !!!!!");

                    TouchAction action = new TouchAction(Base.appiumDriver);
                    action.press(PointOption.point(398, 209))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                            .moveTo(PointOption.point(150, 209)).release().perform();
                    adps.waitInVisible(adps.adLd_loading_box, 10);


                } else {
                    adps.assertText(adps.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText(), accountNumber);
                    Log.logger.info(">>>>>>>>>>>>>>>>>{} Account Number Matched  !!!!!");

                    break;
                }
            }

        } catch (NoSuchElementException e) {

        }


    }


    public static void TestSwipeToLeft(String accountNumber) {

        HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
        AccountDetailPageScreen adps = new AccountDetailPageScreen(Base.appiumDriver);

        WebElement element = adps.fX(adps.adSp_swiper_pagination);
        List<WebElement> elements = element.findElements(By.xpath("./child::*"));
        System.out.println("Elements total are:" + elements.size());
        for (int i = elements.size(); i >= 0; i--) {
            if (!adps.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText().equalsIgnoreCase(accountNumber)) {
                touchActionSwipeLeft();
                adps.waitInVisible(adps.adLd_loading_box, 20);
                adps.assertText(adps.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i - 1) + "]").getText(), accountNumber);
                Log.logger.info("-------------------------------{} account_number" + " " + hs.fX("(//p[@id=\"adLb_account_number_label\"])[" + (i + 1) + "]").getText());
            } else {
                Log.logger.info("------------------------------------------->{} : Account Number Matched" + " " + accountNumber + " " + "!!!!!!!");
                break;
            }

        }
    }
public static void goToAccountDetailsNewVersion() throws InterruptedException{
    HomeScreenpage hs = new HomeScreenpage(Base.appiumDriver);
    AccountDetailPageScreen ad = new AccountDetailPageScreen(Base.appiumDriver);


    hs.waitVisible(hs.siHS_Service_btn, 10);
    ExtentReport4.printReportMessage("Main Menu");
    hs.click(hs.siHS_Service_btn);
    //hs.EnterPin("010203");
    //hs.printContext();
    Thread.sleep(3000);
    hs.setWebview();
    //System.out.println("Context is: " );
    //hs.printContext();
    //Base.sleep(10);
    ExtentReport4.printReportMessage("Discover Page");
//    hs.setContext("WEBVIEW_17933.3");
    ad.waitVisible(ad.adMn_accounts_menu, 10);
    ad.click(ad.adMn_accounts_menu);
   // Base.sleep(10);
    ExtentReport4.printReportMessage("Account Details");

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {

    }
    ad.writeLog();


}


}
