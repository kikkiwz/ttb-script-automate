package com.tmb.automation.pages.primarybanking2;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailPageScreen extends AppiumLibrary {
public AccountDetailPageScreen(AppiumDriver<WebElement> driver){
    super( driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    alertAction("accept");
}

//Discovery Menu
public final String adMn_accounts_menu = "//li[@id='11']";

//Service Menu

//Account Details
/*1.All Free Screen + Commons Labels*/
    public final String adBtn_back_button="//button[@id=\"adBtn_back_button\"]/svg";
    public final String adLb_account_details_label ="//h1[@class='sc-eKYRpg jPmoqB']";
    public final String adImg_product_logo_image ="//img[@id=\"adImg_product_logo_image\"]";
    public final String adLb_avaliable_balance_label ="//p[@id=\"adLb_avaliable_balance_label\"]";
    public final String adLb_ledger_balance_label = "//p[@id=\"adLb_ledger_balance_label\"]";
    public final String adMn_transfer_menu ="//div[@id=\"adMn_transfer_menu\"]";
    public final String adMn_bill_menu ="//p[@id=\"adMn_paybill_menu\"]";
    public final String adMn_topup_menu ="//p[@id=\"adMn_topup_menu\"]";
    public final String adMn_more_option_menu ="//p[@id=\"adMn_more_option_menu\"]";
    public final String adTb_activity_tab ="//div[@id=\"adTb_activity_tab\"]";
    public final String adTb_details_tab ="//div[@id=\"adTb_details_tab\"]";
    public final String adBtn_search_button = "//button[@id=\"adBtn_search_button\"]";
    public final String adLb_account_nickname_label ="";
    public final String adLb_account_number_label ="//p[@id=\"adLb_account_number_label\"]";
    public final String adVl_avaliable_balance_value ="//p[@id=\"adVl_avaliable_balance_value\"]";
    public final String adVl_ledger_balance_value ="//*[@id=\"adVl_avaliable_balance_value\"]";
    public final String adSp_swiper_pagination ="//div[@id='adLb_account_box_swiper']/div[1]";
    public final String adLd_loading_box ="//div[@class='loading_loadingBox__2m_2X']";
    //public final String adSp_swiper_pagination ="//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div/div/div/div[1]";
    public final String adTb_expand_tab ="//div[@id=\"adTb_expand_tab\"]";
    public final String adImg_activity_image ="";
    public final String adLb_no_activites_label="//div[@id=\"adLb_no_activites_label\"]";
    public final String adLb_account_type_label="//p[@id=\"adLb_account_type_label\"]";
    public final String adLb_status_label ="//p[@id=\"adLb_status_label\"]";
    public final String adLb_account_name_label ="//p[@id=\"adLb_account_name_label\"]";
    //duplicate locator with adLb_account_name_label waiting for Keshvi fix it (28/3/2021)
    public final String adLb_branch_label ="";
    public final String adLb_virtual_passbook_label ="//li[@id=\"adLb_virtual_passbook_label\"]";
    public final String adLb_my_debit_cards_label ="//li[@id=\"adLb_my_debit_cards_label\"]";
    public final String adLb_all_free_protection ="//li[@id=\"adLb_all_free_protection\"]";
    public final String adLb_annual_fee ="//li[@id=\"adLb_anual_fee\"]";
    public final String adLb_account_type_value_label ="//p[@id=\"adLb_account_type_value_label\"]";
    public final String adLb_status_value_label ="//div[@id=\"adLb_status_value_label\"]";
    public final String adLb_account_name_value_label ="//p[@id=\"adLb_account_name_value_label\"]";
    public final String adLb_branch_value_label ="//p[@id=\"adLb_branch_value_label\"]";
    public final String adLb_more_action_label ="";
    public final String adMn_withdraw_menu ="";
    public final String adMn_statement_menu ="";
    public final String adLb_more_action_close_button ="";
    public final String adLb_first_bullet ="//span[@id=\"swiper-pagination-bullet-1\"]";



   /*2. NoFix Account*/

    public final String adLb_goal_balance_label ="//p[@id=\"adLb_goal_balance_label\"]";
    public final String adLb_goal_balance_value_label ="//p[@id=\"adLb_goal_balance_value_label\"]";
    public final String abDesc_Interest_rate_description ="//p[@id=\"abDesc_interest_rate_description\"]";
    public final String abLb_bonus_interest_rate_label ="//li[@id=\"abLb_bonus_interest_rate_label\"]";


    /*3. Basic Saving Account*/

    public final String adLb_interest_rate_label ="//p[@id=\"adLb_interest_rate_label\"]";
    public final String adLb_cumulative_interest_label ="//p[@id=\"adLb_cumulative_interest_label\"]";
    public final String adLb_interest_rate_value_label ="//p[@id=\"adLb_interest_rate_value_label\"]";
    public final String adLb_cumulative_interest_value_label ="//p[@id=\"adLb_cumulative_interest_value_label\"]";

    /*4. Dream Saving Account*/
    public final String adLb_monthly_saving_label ="//p[@id=\"adLb_monthly_saving_label\"]";
    public final String adLb_linked_account_label ="//p[@id=\"adLb_linked_account_label\"]";
    public final String adLb_transfer_every_months_on_label ="//p[@id=\"adLb_transfer_every_months_on_label\"]";
    public final String adLb_monthly_saving_value_label ="//p[@id=\"adLb_cumulative_interest_value_label\"]";
    public final String adLb_linked_account_value_label ="//p[@id=\"adLb_linked_account_value_label\"]";
    public final String adLb_transfer_every_months_on_value_label ="//p[@id=\"adLb_transfer_every_months_on_value_label\"]";

    /*5. Saving Care Account*/
    public final String abLb_saving_care_protection_label ="//li[@id=\"abLb_saving_care_protection_label\"]";

    /*6. Basic Current Account*/
    public final String abLb_overdraft ="//p[@id=\"abLb_overdraft_label\"]";
    public final String abLb_overdraft_value_label ="//p[@id=\"abLb_overdraft_value_label\"]";
}