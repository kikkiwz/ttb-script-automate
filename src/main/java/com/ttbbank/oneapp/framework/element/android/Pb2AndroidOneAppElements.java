package com.ttbbank.oneapp.framework.element.android;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class Pb2AndroidOneAppElements {
    private Pb2AndroidOneAppElements() {

    }

    //PB2
    private static final OneAppElement PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/itemCardDepositLayout'][1]");
    private static final OneAppElement PRIMARY_BANKING2_ACCOUNT_NICKNAME = new OneAppElement(FindBy.RESOURCE_ID, "adLb_account_nickname_label");
    private static final OneAppElement PRIMARY_BANKING2_SEARCH_ACTIVITY = new OneAppElement(FindBy.RESOURCE_ID, "adBtn_search_button");
    private static final OneAppElement PRIMARY_BANKING2_SEARCH_FIELD = new OneAppElement(FindBy.RESOURCE_ID, "search-transaction");
    private static final OneAppElement PRIMARY_BANKING2_SEARCH_BUTTON = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[3]");
    private static final OneAppElement PRIMARY_BANKING2_ACTIVITY_DATE_TITLE = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View");
    private static final OneAppElement PRIMARY_BANKING2_EXPEND_ACTIVITY = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]");
    private static final OneAppElement PRIMARY_BANKING2_ACTIVITY_TRANSFER_TITLE = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_BEFOREAMOUNT = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_AMOUNT = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_DATE = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_FROMAC = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.TextView");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_TOAC = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.TextView[2]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_CHANNEL = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.TextView[3]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFEROUT_SEEDETAILS = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.Button");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFERIN_BEFOREAMOUNT = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFERIN_AMOUNT = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFERIN_DATE = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFERIN_CHANNEL = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.TextView");
    private static final OneAppElement PRIMARY_BANKING2_TRANSFERIN_SEEDETAILS = new OneAppElement(FindBy.XPATH, "//android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.Button");
    private static final OneAppElement PRIMARY_BANKING2_ACTIVITY_BACKBUTTON = new OneAppElement(FindBy.XPATH, "//*[@text='Back ButtonBack']");

    private static final OneAppElement PRIMARY_BANKING2_MORE_MENU = new OneAppElement(FindBy.RESOURCE_ID, "adMn_more_option_menu");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_MENU = new OneAppElement(FindBy.RESOURCE_ID, "adLb_more_action_label");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "adMn_statement_menu");
    private static final OneAppElement PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "rsLb_request_statement_label");
    private static final OneAppElement PRIMARY_BANKING2_SELECT_LANGUAGE_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "rsLb_select_language_label");
    private static final OneAppElement PRIMARY_BANKING2_SELECT_LANGUAGE_TH_RADIO_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsRb_thai_language_radio_button");
    private static final OneAppElement PRIMARY_BANKING2_SELECT_LANGUAGE_EN_RADIO_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsRb_english_language_radio_button");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_CONDENSED_STATEMENT_RADIO_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsRb_consensed_statement");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_DETAILS_STATEMENT_RADIO_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsRb_detailed_statement");
    private static final OneAppElement PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsLs_statement_from_list");
    private static final OneAppElement PRIMARY_BANKING2_TRANSACTION_PERIOD_TO_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsLs_statement_to_list");
    private static final OneAppElement PRIMARY_BANKING2_SELECT_MONTH7 = new OneAppElement(FindBy.XPATH, "//*[@resource-id='android:id/text1'][7]");
    private static final OneAppElement PRIMARY_BANKING2_SELECT_MONTH6 = new OneAppElement(FindBy.XPATH, "//*[@resource-id='android:id/text1'][6]");
    private static final OneAppElement PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsBtn_generate_statement_button");
    private static final OneAppElement PRIMARY_BANKING2_EXCEEDS_6MONTHS_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "rsLb_exceeds_6_month_label");
    private static final OneAppElement PRIMARY_BANKING2_EXCEEDS_6MONTHS_DETAILS = new OneAppElement(FindBy.RESOURCE_ID, "rsdesp_exceeds_6_month_description");
    private static final OneAppElement PRIMARY_BANKING2_EXCEEDS_6MONTHS_OK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsBtn_ok_button");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_PAGE_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "rsLb_request_statement_label");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsBtn_save_button");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsBtn_share_button");
    private static final OneAppElement PRIMARY_BANKING2_STATEMENT_BACKBUTTON = new OneAppElement(FindBy.RESOURCE_ID, "rsBtn_back_to_menu_button");
    private static final OneAppElement PRIMARY_BANKING2_KEYPAD_DONE = new OneAppElement(FindBy.ID, "Done");

    //PB2 - Setting PromptPay
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_EXAMPlE_SCREEN = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonNext");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_OTHER_SERVICES_MENU = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Other Services");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY = new OneAppElement(FindBy.CSS_SELECTOR, "#cs_other_service_prompt_pay_id");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON = new OneAppElement(FindBy.XPATH, "//button[@id=\"spBtn_register_button\"]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button/svg");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_OPEN_ACCOUNT_TITLE = new OneAppElement(FindBy.XPATH, "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/div[2]/div");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_FOR_PROMPTPAY_TITLE = new OneAppElement(FindBy.XPATH,"//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/div[2]/h1");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_REGISTER_PROMPTPAY_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]/button/svg");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON = new OneAppElement(FindBy.XPATH, "(//button[@id='spBtn_register_button'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL = new OneAppElement(FindBy.XPATH,"//*[@id=\"spLb_mobile_number_label\"]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_MASKED_LABEL = new OneAppElement(FindBy.XPATH, "//p[@id='spLb_mobile_number_value_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='spLb_mobile_no_not_registered_yet_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON = new OneAppElement(FindBy.XPATH,"//*[@id=\"promptpay-not-registered-citizen-id\"]/div/div[3]/button");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL= new OneAppElement(FindBy.XPATH,"//p[@id=\'spLb_citizen_id_label\']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_MASKED_LABEL = new OneAppElement(FindBy.XPATH,"//p[@id='spLb_citizen_id_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_NOT_REGISTERED_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='spLb_citizen_id_not_registered_yet_label']");

    //PB2 - Setting PromptPay (Select Account screen)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id=\'spLb_mobile_no_select_account_label\']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id=\'spLb_citizen_id_select_account_label\']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_1_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-1']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_2_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-2']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_3_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-3']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_4_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-4']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_5_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-5']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_6_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-6']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_7_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-7']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_8_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-8']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_9_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-9']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_10_CHECK_BOX_BUTTON = new OneAppElement(FindBy.XPATH,"//form[@id = 'promptpay-radio-button-account-select']//label[@id='promptpay-account-number-10']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_CLOSE_BUTTON = new OneAppElement(FindBy.XPATH,"//div[@id=\'spBtn_popup_close_button\']/svg");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON = new OneAppElement(FindBy.XPATH,"//button[@id=\'spBtn_next_button\']");


    //PB2 - Setting PromptPay (Confirm MobileNo and CitizenID screen)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_BACK_BUTTON = new OneAppElement(FindBy.XPATH,"//*[@id=\"spBtn_navbar_back_button\"]/svg");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_SCREEN_TITLE = new OneAppElement(FindBy.XPATH,"//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/div[2]/h1");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_ICON = new OneAppElement(FindBy.XPATH,"//div[@id='spLg_mobile_number_logo']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL = new OneAppElement(FindBy.XPATH,"//span[@id='spLb_mobile_number_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_VALUE = new OneAppElement(FindBy.XPATH,"//*[@id=\"spLb_mobile_number_value_label\"]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NICKNAME_LABEL = new OneAppElement(FindBy.XPATH,"//span[@id='spLb_account_name_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NO_VALUE = new OneAppElement(FindBy.XPATH,"//span[@id=\"spLb_account_number_value_label\"]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON = new OneAppElement(FindBy.XPATH,"//*[@id=\"spBtn_edit_account_button\"]/svg");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON = new OneAppElement(FindBy.XPATH,"//button[@id=\'spBtn_next_button\']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_ICON = new OneAppElement(FindBy.XPATH,"//span[@id='spLg_citizen_id_logo']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_VALUE = new OneAppElement(FindBy.XPATH,"//span[@id='spLb_citizen_id_value_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_LABEL = new OneAppElement(FindBy.XPATH,"//span[@id='spLb_citizen_id_label']");


    //PB2 - Setting PromptPay (Success register MobileNo and CitizenID screen)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_TITLE = new OneAppElement(FindBy.XPATH, "//*[@id='__next']/div[1]/div[1]/div/div/div[2]/h1");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL = new OneAppElement(FindBy.XPATH,"//*[@id='spLb_register_promptpay_is_ready_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-mobile-no']/label/div/span/span[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-mobile-no']/label/div/span/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-mobile-no']/label/label/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/div/span/span[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/div/span/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/label/span[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/label/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CONTACT_LABEL = new OneAppElement(FindBy.XPATH,"//label[@id='spLb_footer_description_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON = new OneAppElement(FindBy.XPATH,"//button[@id='spBtn_done_button']");


    //PB2 - Setting PromptPay (Confirm to Deregister screen)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='spLb_deregister_confirm_description_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMFIRM_NOTE_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='spLb_deregister_confirm_note_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON = new OneAppElement(FindBy.XPATH,"//*[@id='spBtn_deregister_confirm_button']");////div[@id='spBtn_deregister_confirm_button']
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CANCEL_BUTTON = new OneAppElement(FindBy.XPATH,"//div[@id='spBtn_cancel_button']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CLOSE_BUTTON = new OneAppElement(FindBy.XPATH,"//div[@id='spBtn_popup_close_button']");



    //PB2 - Setting PromptPay (Deregister Success with MobileNo and CitizenID)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL = new OneAppElement(FindBy.XPATH,"//p[@id='spLb_deregister_completed_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_PROMPTPAY_LABEL = new OneAppElement(FindBy.XPATH,"//*[@id=\'__next\']/div/div[1]/div[1]/div/div/div[2]/h1");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-mobile-no']/label/div/span/span[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-mobile-no']/label/div/span/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_LABEL = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/div/span/span[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_VALUE = new OneAppElement(FindBy.XPATH,"//div[@id='promptpay-banner-result-citizen-id']/label/div/span/span[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_FOOTER_DESCRIPTION_LABEL = new OneAppElement(FindBy.XPATH,"//label[@id='spLb_footer_description_label']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON = new OneAppElement(FindBy.XPATH,"//button[@id='spBtn_done_button']");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_PAPER_CLIP_LOGO = new OneAppElement(FindBy.XPATH,"//div[@id='spLg_deregister_paper_clip_logo']");



    //PB2 - Setting PromptPay (PP list after register)
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_MOBILE_GREEN_LOGO = new OneAppElement(FindBy.XPATH,"(//div[@id='spLb_signed_up_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_CITIZEN_ID_GREEN_LOGO = new OneAppElement(FindBy.XPATH,"(//div[@id='spLb_signed_up_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL = new OneAppElement(FindBy.XPATH,"(//p[@id='spLb_bank_desc_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON = new OneAppElement(FindBy.XPATH,"//*[@id='promptpay-own-bank-citizen-id']/div/button");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON = new OneAppElement(FindBy.XPATH,"//*[@id='promptpay-own-bank-mobile-no']/div/button");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL = new OneAppElement(FindBy.XPATH,"(//p[@id='spLb_bank_desc_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_NAME_LABEL = new OneAppElement(FindBy.XPATH,"(//span[@id='spLb_account_name_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_VALUE_LABEL = new OneAppElement(FindBy.XPATH,"(//span[@id='spLb_account_number_value_label'])[1]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_NAME_LABEL = new OneAppElement(FindBy.XPATH,"(//span[@id='spLb_account_name_label'])[2]");
    private static final OneAppElement PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_VALUE_LABEL = new OneAppElement(FindBy.XPATH,"(//span[@id='spLb_account_number_value_label'])[2]");

	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     //PB2 - Manage Debit Card
    private static final OneAppElement PB2_REG_P2_THAI = FR("com.ttbbank.oneapp.vit:id/btnChangeLng");
    private static final OneAppElement PB2_REG_P2_NEXT = FX("//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/layout_otp_input\"]/android.widget.TextView[1]");
    private static final OneAppElement PB2_REG_P2_INPUT_FIELD = FR("com.ttbbank.oneapp.vit:id/edt_component");
    private static final OneAppElement PB2_REG_P3_NEXT = FR("com.ttbbank.oneapp.vit:id/next_btn");
    private static final OneAppElement PB2_REG_P4_OTP1 = FX("//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/layout_otp_input\"]/android.widget.TextView[1]");
    private static final OneAppElement PB2_REG_P5_NOTI_ALLOW = FA("Allow");
    private static final OneAppElement PB2_HOM_GUIDELINE_NEXT = FI("com.ttbbank.oneapp.vit:id/buttonNext");
    private static final OneAppElement PB2_ACC_GUIDELINE_DONE = FI("com.ttbbank.oneapp.vit:id/buttonNext");
    private static final OneAppElement PB2_PIN1 = FR("com.ttbbank.oneapp.vit:id/key_01");
    private static final OneAppElement PB2_PIN2 = FR("com.ttbbank.oneapp.vit:id/key_02");
    private static final OneAppElement PB2_PIN3 = FR("com.ttbbank.oneapp.vit:id/key_03");
    private static final OneAppElement PB2_PIN4 = FR("com.ttbbank.oneapp.vit:id/key_04");
    private static final OneAppElement PB2_PIN5 = FR("com.ttbbank.oneapp.vit:id/key_05");
    private static final OneAppElement PB2_PIN6 = FR("com.ttbbank.oneapp.vit:id/key_06");
    private static final OneAppElement PB2_PIN7 = FR("com.ttbbank.oneapp.vit:id/key_07");
    private static final OneAppElement PB2_PIN8 = FR("com.ttbbank.oneapp.vit:id/key_08");
    private static final OneAppElement PB2_PIN9 = FR("com.ttbbank.oneapp.vit:id/key_09");
    private static final OneAppElement PB2_PIN0 = FR("com.ttbbank.oneapp.vit:id/key_00");
    private static final OneAppElement PB2_CONFIRM_PIN1 = FR("com.ttbbank.oneapp.vit:id/pin_key_1");
    private static final OneAppElement PB2_CONFIRM_PIN2 = FR("com.ttbbank.oneapp.vit:id/pin_key_2");
    private static final OneAppElement PB2_CONFIRM_PIN3 = FR("com.ttbbank.oneapp.vit:id/pin_key_3");
    private static final OneAppElement PB2_CONFIRM_PIN4 = FR("com.ttbbank.oneapp.vit:id/pin_key_4");
    private static final OneAppElement PB2_CONFIRM_PIN5 = FR("com.ttbbank.oneapp.vit:id/pin_key_5");
    private static final OneAppElement PB2_CONFIRM_PIN6 = FR("com.ttbbank.oneapp.vit:id/pin_key_6");
    private static final OneAppElement PB2_CONFIRM_PIN7 = FR("com.ttbbank.oneapp.vit:id/pin_key_7");
    private static final OneAppElement PB2_CONFIRM_PIN8 = FR("com.ttbbank.oneapp.vit:id/pin_key_8");
    private static final OneAppElement PB2_CONFIRM_PIN9 = FR("com.ttbbank.oneapp.vit:id/pin_key_9");
    private static final OneAppElement PB2_CONFIRM_PIN0 = FR("com.ttbbank.oneapp.vit:id/pin_key_0");
    private static final OneAppElement PB2_ACC_ACCOUNTS = FC("androidx.recyclerview.widget.RecyclerView android.widget.FrameLayout");

    private static final OneAppElement PB2W_DET_LOADING = FC(".loading_loadingBox__2m_2X");
    private static final OneAppElement PB2W_DET_IMG = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div/div/img");
    private static final OneAppElement PB2W_DET_TITLE = FX("//div[contains(@class, \"style__NavigationWrapper\")]/div[1]/div[1]/div[2]/div[1]");
    private static final OneAppElement PB2W_DET_ACCOUNTNAME_LB = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div/div/div[1]/div[1]/p");
    private static final OneAppElement PB2W_DET_ACCOUNTNAME_EDIT = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div/div/div[1]/div[1]/div[1]");
    private static final OneAppElement PB2W_DET_ACCOUNTNUMBER = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div/div/div[1]/p");
    private static final OneAppElement PB2W_DET_AVAILABLE_BALANCE_LB = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[1]/li[1]/p[1]");
    private static final OneAppElement PB2W_DET_AVAILABLE_BALANCE_VALUE = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[1]/li[1]/p[2]");
    private static final OneAppElement PB2W_DET_LEDGER_BALANCE_LB = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[1]/li[2]/p[1]");
    private static final OneAppElement PB2W_DET_LEDGER_BALANCE_VALUE = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[1]/li[2]/p[2]");
    private static final OneAppElement PB2W_DET_TRANSFER = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[2]/li[1]/p[1]");
    private static final OneAppElement PB2W_DET_BILL = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[2]/li[2]/p[1]");
    private static final OneAppElement PB2W_DET_TOPUP = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[2]/li[3]/p[1]");
    private static final OneAppElement PB2W_DET_MORE = FX("//div[contains(@class, \"swiper-slide-active\")]/div/div[1]/ul[2]/li[4]/p[1]");
    private static final OneAppElement PB2W_DET_ACTIVITY = FX("//*[@id=\"adTb_activity_tab\"]/p");
    private static final OneAppElement PB2W_DET_DETAILS = FX("//*[@id=\"adTb_details_tab\"]/p");
    private static final OneAppElement PB2W_DET_ACT_CHOOSEMONTHYACTIVITY = FC("#netive_select_label_id");
    private static final OneAppElement PB2W_DET_ACT_MONTHS = FI("netive_select_label_id");
    private static final OneAppElement PB2W_DET_ACT_SEARCH = FX("//*[@id=\"adBtn_search_button\"]/div/label");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTDETAILS_LB = FX("//div[contains(@class, \"homestyled__TabDetails\")]/div[1]/h2");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTTYPE_LB = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[2]/div[1]/div[1]");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTTYPE_VALUE = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[2]/div[2]/p");
    private static final OneAppElement PB2W_DET_DET_STATUS_LB = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[4]/div[1]/div[1]");
    private static final OneAppElement PB2W_DET_DET_STATUS_VALUE = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[4]/div[2]/p");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTNAME_LB = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[6]/div[1]/div[1]");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTNAME_VALUE = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[6]/div[2]/p");
    private static final OneAppElement PB2W_DET_DET_BRANCH_LB = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[8]/div[1]/div[1]");
    private static final OneAppElement PB2W_DET_DET_BRANCH_VALUE = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[8]/div[2]/p");
    private static final OneAppElement PB2W_DET_DET_ACCOUNTMANAGEMENT_LB = FX("//div[contains(@class, \"ContentsDetail\")]/div[1]/div[10]/h2");
    private static final OneAppElement PB2W_DET_DET_VIRUTALPASSBOOK = FC("#adLb_virtual_passbook_label");
    private static final OneAppElement PB2W_DET_DET_MYDEBITCARDS = FC("#adLb_my_debit_cards_label");
    private static final OneAppElement PB2W_DET_DET_ALLFREEDEBITCARDANNUALFEE = FC("#adLb_annual_fee");

    private static final OneAppElement PB2W_MDC_TITLE = FX("#debit_card_list_title");
    private static final OneAppElement PB2W_MDC_ALLFREEDIGITALCARD_LB = FC("#all_free_digital_card_label");
    private static final OneAppElement PB2W_MDC_CARD_DIGITALCARD_LIST = FX("//div[contains(@class, \"debit-cardstyled__BoxCardManage\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_IMG = FX("//p[contains(@id, \"all_free_digital_img_card\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_ACCOUNTNUMBER_LIST = FX("//p[contains(@id, \"digital_card_no_masked_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_ACCOUNT_LB_LIST = FX("//p[contains(@id, \"digital_card_account_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_ACCOUNTNAME_LIST = FX("//p[contains(@id, \"digital_card_account_value\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_EXPIRY_LB_LIST = FX("//p[contains(@id, \"digital_card_expiry_date_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DIGITAL_EXPIRY_VALUE_LIST = FX("//p[contains(@id, \"digital_card_expiry_date_value\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_LIST = FX("//div[@title=\"all free debit card\"]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_IMG = FX("//p[contains(@id, \"all_free_debit_img_card\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST = FX("//p[contains(@id, \"debit_card_no_masked_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_ACCOUNT_LB_LIST = FX("//p[contains(@id, \"debit_card_account_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_ACCOUNTNAME_LIST = FX("//p[contains(@id, \"debit_card_account_value\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_EXPIRY_LB_LIST = FX("//p[contains(@id, \"debit_card_expiry_date_label\")]");
    private static final OneAppElement PB2W_MDC_CARD_DEBIT_EXPIRY_VALUE_LIST = FX("//p[contains(@id, \"debit_card_expiry_date_value\")]");
    private static final OneAppElement PB2W_MDC_CARD_BLOCKED_LIST = FX("//div[contains(@id, \"debit_card_status_text\")]");
    private static final OneAppElement PB2W_MDC_ALLFREEDEBITCARD_LB = FC("#all_free_debit_card_label");

    private static final OneAppElement PB2W_MDC_DETAIL_Back = FC("#debit_card_back_button");
    private static final OneAppElement PB2W_MDC_DETAIL_TITLE = FC("#debit_card_detail_title");
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWDETAILS = FC("#debit_card_detil_show_details_button");
    private static final OneAppElement PB2W_MDC_DETAIL_IMG = FC("#debit_card_detail_img");
    private static final OneAppElement PB2W_MDC_DETAIL_IMG_SHOWDETAILS = FX("");
    private static final OneAppElement PB2W_MDC_DETAIL_ACCOUNT_LB = FX("//div[contains(@class, \"debit-card-detailstyled__AccountBox\")]/div[1]/div[1]/div[1]");
    private static final OneAppElement PB2W_MDC_DETAIL_ACCOUNT_VALUE1 = FX("//div[contains(@class, \"debit-card-detailstyled__AccountBox\")]/div[1]/div[1]/div[2]");
    private static final OneAppElement PB2W_MDC_DETAIL_ACCOUNT_VALUE2 = FX("//div[contains(@class, \"debit-card-detailstyled__AccountBox\")]/div[1]/div[2]//p[1]");

    private static final OneAppElement PB2W_MDC_DETAIL_TURNONOFF_LB = FX("//div[contains(@class, \"debit-card-detailstyled__ToggleLabel\")]/p[1]");
    private static final OneAppElement PB2W_MDC_DETAIL_TURNONOFF_VALUE = FC("#debit_card_detail_toggle"); //input -> attribute=checked
    private static final OneAppElement PB2W_MDC_DETAIL_TURNONOFF_DESC = FX("//p[contains(@class, \"debit-card-detailstyled__LabelSub\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_LIMITUSAGE = FC("#debit_card_detail_limit_usage_menu");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKCARD = FC("#debit_card_detail_block_card_menu");
    private static final OneAppElement PB2W_MDC_DETAIL_PAYWITHWOW = FC("#debit_card_detail_pay_with_wow_menu");

    //showcard
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWCARD_ACCNUMBER = FX("//div[contains(@class, \"debit-card-detailstyled__ImageBackCardAcNumber\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWCARD_CARDEXPIRE = FX("//div[contains(@class, \"debit-card-detailstyled__CardExpireDate\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWCARD_CVVNUMBER = FX("//div[contains(@class, \"debit-card-detailstyled__ImageBackCardCvvNumber\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWCARD_HOLDERNAME = FX("//div[contains(@class, \"debit-card-detailstyled__HolderName\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_SHOWCARD_COPYCARDNUMBER = FX("//div[contains(@class, \"debit-card-detailstyled__SectionCopy\")]/button[1]/div[1]/label[1]");

    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_BACK = FC("#debit_card_detail_back_button");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_TITLE = FC("#debit_card_detail_title");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_IMAGE = FC("#debit_card_detail_img");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_IMAGE_NUMBER = FX("//div[contains(@class, \"debit-card-detailstyled__ImageCardAcNumber\")]");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_BLOCKED_LB = FX("//*[@id=\"test-id\"]");
    private static final OneAppElement PB2W_MDC_DETAIL_BLOCKED_DESC = FX("//p[contains(@class, \"debit-card-detailstyled__StatusDesc\")]");
    //Limit Usage
    private static final OneAppElement PB2W_MDC_LIMIT_P1_TITLE = FC("#limit_usage_title");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB = FC("#cash_withdrawal_limit_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB = FC("#cash_withdrawal_limit_new_limit_label_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE = FC("#cash_withdrawal_limit_new_limit_label_input");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB = FC("#cash_withdrawal_limit_min_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE = FC("#cash_withdrawal_limit_min_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB = FC("#cash_withdrawal_limit_max_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE = FC("#cash_withdrawal_limit_max_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_LB = FC("#spending_limit_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB = FC("#spending_limit_new_limit_label_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE = FC("#spending_limit_new_limit_label_input");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB = FC("#spending_limit_min_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE = FC("#spending_limit_min_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB = FC("#spending_limit_max_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE = FC("#spending_limit_max_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_PERMISSIONS_LB = FC("#limit_usage_permission_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB = FC("#allow_for_overseas_usage_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE = FC("#allow_for_overseas_usage_toggle");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_LB = FC("#allow_for_paywave_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE = FC("#allow_for_paywave_toggle");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB = FC("#allow_for_oneline_shopping_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE = FC("#allow_for_oneline_shopping_toggle");
    private static final OneAppElement PB2W_MDC_LIMIT_P1_SAVE = FX("//div[contains(@class, \"sharedstyled__ButtonPrimary\")]/button[1]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_TITLE = FC("#limit_usage_review_changes_title");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_LB = FC("#title-id-0");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_VALUE = FC("#title-right-value-id-0");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_LB = FC("#title-id-1");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_VALUE = FC("#title-right-value-id-1");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_LB = FC("#title-id-2");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_VALUE = FC("#title-right-value-id-2");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_LB = FC("#title-id-3");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_VALUE = FC("#title-right-value-id-3");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFORONLINESHOPPING_LB = FC("#title-id-4");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_ALLOWFORONELINESHOPPING_VALUE = FC("#title-right-value-id-4");
    //digital card case
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_LB = FX("//li[@id=\"limit_usage_review_spending_limit_label0\"]/span[1]/div[1]/span[1]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_VALUE = FX("//li[@id=\"limit_usage_review_spending_limit_label0\"]/span[1]/div[1]/span[2]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_LB = FX("//li[@id=\"limit_usage_review_allow_overseas_usage_label1\"]/span[1]/div[1]/span[1]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_VALUE = FX("//li[@id=\"limit_usage_review_allow_overseas_usage_label1\"]/span[1]/div[1]/span[2]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONLINESHOPPING_LB = FX("//li[@id=\"limit_usage_review_allow_os_label2\"]/span[1]/div[1]/span[1]");
    private static final OneAppElement PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONELINESHOPPING_VALUE = FX("//li[@id=\"limit_usage_review_allow_os_label2\"]/span[1]/div[1]/span[2]");

    private static final OneAppElement PB2W_MDC_LIMIT_P2_SAVE = FC("#limit_usage_confirm_button");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_IMG = FC("#limit_usage_success_passes_img");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_TITLE1 = FC("#limit_usage_success_title");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_TITLE2 = FC("#limit_usage_success_description");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_LB = FC("#limit_usage_success_card_withdrawal_limit_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_VALUE = FC("#limit_usage_success_card_withdrawal_limit_label_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_LB = FC("#limit_usage_success_spending_limit_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_VALUE = FC("#limit_usage_success_spending_limit_label_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_LB = FC("#limit_usage_success_allow_overseas_usage_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_VALUE = FC("#limit_usage_success_allow_overseas_usage_label_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_LB = FC("#limit_usage_success_allow_pw_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_VALUE = FC("#limit_usage_success_allow_pw_label_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_LB = FC("#limit_usage_success_allow_os_label");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_VALUE = FC("#limit_usage_success_allow_os_label_value");
    private static final OneAppElement PB2W_MDC_LIMIT_P3_DONE = FC("#debit_card_done_button");

    private static final OneAppElement PB2W_MDC_TEMPBLOCK_P2_IMG = FC("#temp_block_passes_img");
    private static final OneAppElement PB2W_MDC_TEMPBLOCK_P2_TITLE = FC("#temp_block_success_label");
    private static final OneAppElement PB2W_MDC_TEMPBLOCK_P2_DESC1 = FC("#temp_block_success_description");
    private static final OneAppElement PB2W_MDC_TEMPBLOCK_P2_DONE = FC("#debit_card_done_button");


    ////div[contains(@class, \"ContentsDetail\")]

    ////div[contains(@class, \"swiper-slide-active\")]/div/div/div/img


    private static OneAppElement FX(String s) {return new OneAppElement(FindBy.XPATH, s); }
    private static OneAppElement FC(String s) {return new OneAppElement(FindBy.CSS_SELECTOR, s);}
    private static OneAppElement FA(String s) {return new OneAppElement(FindBy.ACCESSIBILITY_ID, s); }
    private static OneAppElement FI(String s) {return new OneAppElement(FindBy.ID, s);}
    private static OneAppElement FR(String s) {return new OneAppElement(FindBy.RESOURCE_ID, s);}

    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {

        //PB2
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST, PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_ACCOUNT_NICKNAME, PRIMARY_BANKING2_ACCOUNT_NICKNAME);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_ACTIVITY, PRIMARY_BANKING2_SEARCH_ACTIVITY);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD, PRIMARY_BANKING2_SEARCH_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_BUTTON, PRIMARY_BANKING2_SEARCH_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_DATE_TITLE, PRIMARY_BANKING2_ACTIVITY_DATE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_EXPEND_ACTIVITY, PRIMARY_BANKING2_EXPEND_ACTIVITY);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_TRANSFER_TITLE, PRIMARY_BANKING2_ACTIVITY_TRANSFER_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_BEFOREAMOUNT, PRIMARY_BANKING2_TRANSFEROUT_BEFOREAMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_AMOUNT, PRIMARY_BANKING2_TRANSFEROUT_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_DATE, PRIMARY_BANKING2_TRANSFEROUT_DATE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_FROMAC, PRIMARY_BANKING2_TRANSFEROUT_FROMAC);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_TOAC, PRIMARY_BANKING2_TRANSFEROUT_TOAC);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_CHANNEL, PRIMARY_BANKING2_TRANSFEROUT_CHANNEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_SEEDETAILS, PRIMARY_BANKING2_TRANSFEROUT_SEEDETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_BEFOREAMOUNT, PRIMARY_BANKING2_TRANSFERIN_BEFOREAMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_AMOUNT, PRIMARY_BANKING2_TRANSFERIN_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_DATE, PRIMARY_BANKING2_TRANSFERIN_DATE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_CHANNEL, PRIMARY_BANKING2_TRANSFERIN_CHANNEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_SEEDETAILS, PRIMARY_BANKING2_TRANSFERIN_SEEDETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_BACKBUTTON, PRIMARY_BANKING2_ACTIVITY_BACKBUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_MORE_MENU, PRIMARY_BANKING2_MORE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_MENU, PRIMARY_BANKING2_STATEMENT_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_BUTTON, PRIMARY_BANKING2_STATEMENT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE, PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_LABEL, PRIMARY_BANKING2_SELECT_LANGUAGE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_TH_RADIO_BUTTON, PRIMARY_BANKING2_SELECT_LANGUAGE_TH_RADIO_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_EN_RADIO_BUTTON, PRIMARY_BANKING2_SELECT_LANGUAGE_EN_RADIO_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_CONDENSED_STATEMENT_RADIO_BUTTON, PRIMARY_BANKING2_STATEMENT_CONDENSED_STATEMENT_RADIO_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_DETAILS_STATEMENT_RADIO_BUTTON, PRIMARY_BANKING2_STATEMENT_DETAILS_STATEMENT_RADIO_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON, PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_TO_BUTTON, PRIMARY_BANKING2_TRANSACTION_PERIOD_TO_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH7, PRIMARY_BANKING2_SELECT_MONTH7);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH6, PRIMARY_BANKING2_SELECT_MONTH6);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON, PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_TITLE, PRIMARY_BANKING2_EXCEEDS_6MONTHS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_DETAILS, PRIMARY_BANKING2_EXCEEDS_6MONTHS_DETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_OK_BUTTON, PRIMARY_BANKING2_EXCEEDS_6MONTHS_OK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL, PRIMARY_BANKING2_STATEMENT_PAGE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON, PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON, PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_BACKBUTTON, PRIMARY_BANKING2_STATEMENT_BACKBUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_KEYPAD_DONE, PRIMARY_BANKING2_KEYPAD_DONE);

        //PB2 - Setting Promptpay
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_EXAMPlE_SCREEN, PRIMARY_BANKING2_PROMPTPAY_EXAMPlE_SCREEN);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_OTHER_SERVICES_MENU, PRIMARY_BANKING2_PROMPTPAY_OTHER_SERVICES_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY, PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_BACK_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_OPEN_ACCOUNT_TITLE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_OPEN_ACCOUNT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_FOR_PROMPTPAY_TITLE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_FOR_PROMPTPAY_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_REGISTER_PROMPTPAY_BACK_BUTTON, PRIMARY_BANKING2_PROMPTPAY_REGISTER_PROMPTPAY_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL, PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL, PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL, PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_MASKED_LABEL, PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_MASKED_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_NOT_REGISTERED_LABEL, PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_NOT_REGISTERED_LABEL);



        //PB2 - Setting PromptPay (Select Account screen)
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL, PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL, PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_1_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_1_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_2_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_2_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_3_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_3_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_4_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_4_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_5_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_5_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_6_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_6_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_7_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_7_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_8_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_8_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_9_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_9_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_10_CHECK_BOX_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_10_CHECK_BOX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_CLOSE_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_CLOSE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON);


        //PB2 - Setting PromptPay (Confirm MobileNo and CitizenID screen)
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_BACK_BUTTON, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_SCREEN_TITLE, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_ICON, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_VALUE, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NICKNAME_LABEL, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NICKNAME_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NO_VALUE, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_ACCOUNT_NO_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_ICON, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_VALUE, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_LABEL, PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_LABEL);



        //PB2 - Setting PromptPay (Success register MobileNo and CitizenID screen)
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_TITLE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_LABEL, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE,PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_LABEL, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_LABEL, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CONTACT_LABEL, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CONTACT_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON, PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON);





        //PB2 - Setting PromptPay (Confirm to Deregister screen)
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL,PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMFIRM_NOTE_LABEL,PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMFIRM_NOTE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON,PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CANCEL_BUTTON,PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CANCEL_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CLOSE_BUTTON,PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CLOSE_BUTTON);


        //PB2 - Setting PromptPay (Deregister screen with MobileNo and CitizenID)

        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL,PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_PROMPTPAY_LABEL,PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_PROMPTPAY_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_LABEL, PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_VALUE, PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_LABEL, PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_VALUE, PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_FOOTER_DESCRIPTION_LABEL,PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_FOOTER_DESCRIPTION_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON,PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_PAPER_CLIP_LOGO, PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_PAPER_CLIP_LOGO);




        //PB2 - Setting PromptPay (PP list after register)
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON,PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON,PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_MOBILE_GREEN_LOGO, PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_MOBILE_GREEN_LOGO);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_CITIZEN_ID_GREEN_LOGO, PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_CITIZEN_ID_GREEN_LOGO);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL,PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL,PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_NAME_LABEL, PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_NAME_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_VALUE_LABEL, PRIMARY_BANKING2_PROMPTPAY_MOBILE_ACCOUNT_VALUE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_NAME_LABEL, PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_NAME_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_VALUE_LABEL, PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ACCOUNT_VALUE_LABEL);

oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P2_THAI, PB2_REG_P2_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P2_NEXT, PB2_REG_P2_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P2_INPUT_FIELD, PB2_REG_P2_INPUT_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P3_NEXT, PB2_REG_P3_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P4_OTP1, PB2_REG_P4_OTP1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_REG_P5_NOTI_ALLOW, PB2_REG_P5_NOTI_ALLOW);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_HOM_GUIDELINE_NEXT, PB2_HOM_GUIDELINE_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_ACC_GUIDELINE_DONE, PB2_ACC_GUIDELINE_DONE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN1, PB2_PIN1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN2, PB2_PIN2);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN3, PB2_PIN3);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN4, PB2_PIN4);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN5, PB2_PIN5);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN6, PB2_PIN6);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN7, PB2_PIN7);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN8, PB2_PIN8);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN9, PB2_PIN9);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_PIN0, PB2_PIN0);

        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN1, PB2_CONFIRM_PIN1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN2, PB2_CONFIRM_PIN2);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN3, PB2_CONFIRM_PIN3);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN4, PB2_CONFIRM_PIN4);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN5, PB2_CONFIRM_PIN5);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN6, PB2_CONFIRM_PIN6);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN7, PB2_CONFIRM_PIN7);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN8, PB2_CONFIRM_PIN8);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN9, PB2_CONFIRM_PIN9);
        oneAppElementHashMap.put(OneAppElementKeys.PB2_CONFIRM_PIN0, PB2_CONFIRM_PIN0);

        oneAppElementHashMap.put(OneAppElementKeys.PB2_ACC_ACCOUNTS, PB2_ACC_ACCOUNTS);

        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_LOADING, PB2W_DET_LOADING);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_IMG, PB2W_DET_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_TITLE, PB2W_DET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACCOUNTNAME_LB, PB2W_DET_ACCOUNTNAME_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACCOUNTNAME_EDIT, PB2W_DET_ACCOUNTNAME_EDIT);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACCOUNTNUMBER, PB2W_DET_ACCOUNTNUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_AVAILABLE_BALANCE_LB, PB2W_DET_AVAILABLE_BALANCE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_AVAILABLE_BALANCE_VALUE, PB2W_DET_AVAILABLE_BALANCE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_LEDGER_BALANCE_LB, PB2W_DET_LEDGER_BALANCE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_LEDGER_BALANCE_VALUE, PB2W_DET_LEDGER_BALANCE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_TRANSFER, PB2W_DET_TRANSFER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_BILL, PB2W_DET_BILL);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_TOPUP, PB2W_DET_TOPUP);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_MORE, PB2W_DET_MORE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACTIVITY, PB2W_DET_ACTIVITY);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DETAILS, PB2W_DET_DETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACT_CHOOSEMONTHYACTIVITY, PB2W_DET_ACT_CHOOSEMONTHYACTIVITY);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACT_MONTHS, PB2W_DET_ACT_MONTHS);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_ACT_SEARCH, PB2W_DET_ACT_SEARCH);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTDETAILS_LB, PB2W_DET_DET_ACCOUNTDETAILS_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTTYPE_LB, PB2W_DET_DET_ACCOUNTTYPE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTTYPE_VALUE, PB2W_DET_DET_ACCOUNTTYPE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_STATUS_LB, PB2W_DET_DET_STATUS_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_STATUS_VALUE, PB2W_DET_DET_STATUS_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTNAME_LB, PB2W_DET_DET_ACCOUNTNAME_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTNAME_VALUE, PB2W_DET_DET_ACCOUNTNAME_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_BRANCH_LB, PB2W_DET_DET_BRANCH_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_BRANCH_VALUE, PB2W_DET_DET_BRANCH_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ACCOUNTMANAGEMENT_LB, PB2W_DET_DET_ACCOUNTMANAGEMENT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_VIRUTALPASSBOOK, PB2W_DET_DET_VIRUTALPASSBOOK);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_MYDEBITCARDS, PB2W_DET_DET_MYDEBITCARDS);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_DET_DET_ALLFREEDEBITCARDANNUALFEE, PB2W_DET_DET_ALLFREEDEBITCARDANNUALFEE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_ALLFREEDIGITALCARD_LB, PB2W_MDC_ALLFREEDIGITALCARD_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_TITLE, PB2W_MDC_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITALCARD_LIST, PB2W_MDC_CARD_DIGITALCARD_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_IMG, PB2W_MDC_CARD_DIGITAL_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_ACCOUNTNUMBER_LIST, PB2W_MDC_CARD_DIGITAL_ACCOUNTNUMBER_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_ACCOUNT_LB_LIST, PB2W_MDC_CARD_DIGITAL_ACCOUNT_LB_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_ACCOUNTNAME_LIST, PB2W_MDC_CARD_DIGITAL_ACCOUNTNAME_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_EXPIRY_LB_LIST, PB2W_MDC_CARD_DIGITAL_EXPIRY_LB_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_EXPIRY_VALUE_LIST, PB2W_MDC_CARD_DIGITAL_EXPIRY_VALUE_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_LIST, PB2W_MDC_CARD_DEBIT_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_IMG, PB2W_MDC_CARD_DEBIT_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST, PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNT_LB_LIST, PB2W_MDC_CARD_DEBIT_ACCOUNT_LB_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNAME_LIST, PB2W_MDC_CARD_DEBIT_ACCOUNTNAME_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_EXPIRY_LB_LIST, PB2W_MDC_CARD_DEBIT_EXPIRY_LB_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_EXPIRY_VALUE_LIST, PB2W_MDC_CARD_DEBIT_EXPIRY_VALUE_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_CARD_BLOCKED_LIST, PB2W_MDC_CARD_BLOCKED_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_ALLFREEDEBITCARD_LB, PB2W_MDC_ALLFREEDEBITCARD_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_Back, PB2W_MDC_DETAIL_Back);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_TITLE, PB2W_MDC_DETAIL_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWDETAILS, PB2W_MDC_DETAIL_SHOWDETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_IMG, PB2W_MDC_DETAIL_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_IMG_SHOWDETAILS, PB2W_MDC_DETAIL_IMG_SHOWDETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_LB, PB2W_MDC_DETAIL_ACCOUNT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE1, PB2W_MDC_DETAIL_ACCOUNT_VALUE1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE2, PB2W_MDC_DETAIL_ACCOUNT_VALUE2);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB, PB2W_MDC_DETAIL_TURNONOFF_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE, PB2W_MDC_DETAIL_TURNONOFF_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_DESC, PB2W_MDC_DETAIL_TURNONOFF_DESC);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE, PB2W_MDC_DETAIL_LIMITUSAGE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKCARD, PB2W_MDC_DETAIL_BLOCKCARD);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_PAYWITHWOW, PB2W_MDC_DETAIL_PAYWITHWOW);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_ACCNUMBER, PB2W_MDC_DETAIL_SHOWCARD_ACCNUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_CARDEXPIRE, PB2W_MDC_DETAIL_SHOWCARD_CARDEXPIRE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_CVVNUMBER, PB2W_MDC_DETAIL_SHOWCARD_CVVNUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_HOLDERNAME, PB2W_MDC_DETAIL_SHOWCARD_HOLDERNAME);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_COPYCARDNUMBER, PB2W_MDC_DETAIL_SHOWCARD_COPYCARDNUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_BACK, PB2W_MDC_DETAIL_BLOCKED_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_TITLE, PB2W_MDC_DETAIL_BLOCKED_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_IMAGE, PB2W_MDC_DETAIL_BLOCKED_IMAGE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_IMAGE_NUMBER, PB2W_MDC_DETAIL_BLOCKED_IMAGE_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_BLOCKED_LB, PB2W_MDC_DETAIL_BLOCKED_BLOCKED_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_DESC, PB2W_MDC_DETAIL_BLOCKED_DESC);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_TITLE, PB2W_MDC_LIMIT_P1_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE, PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB, PB2W_MDC_LIMIT_P1_SPENDING_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB, PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE, PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB, PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE, PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB, PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE, PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_PERMISSIONS_LB, PB2W_MDC_LIMIT_P1_PERMISSIONS_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB, PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE, PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_LB, PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE, PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB, PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE, PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SAVE, PB2W_MDC_LIMIT_P1_SAVE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_TITLE, PB2W_MDC_LIMIT_P2_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_LB, PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_VALUE, PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_LB, PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_VALUE, PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_LB, PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_VALUE, PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_LB, PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_VALUE, PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORONLINESHOPPING_LB, PB2W_MDC_LIMIT_P2_ALLOWFORONLINESHOPPING_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORONELINESHOPPING_VALUE, PB2W_MDC_LIMIT_P2_ALLOWFORONELINESHOPPING_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_LB, PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_VALUE, PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_LB, PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_VALUE, PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONLINESHOPPING_LB, PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONLINESHOPPING_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONELINESHOPPING_VALUE, PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONELINESHOPPING_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SAVE, PB2W_MDC_LIMIT_P2_SAVE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_IMG, PB2W_MDC_LIMIT_P3_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE1, PB2W_MDC_LIMIT_P3_TITLE1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE2, PB2W_MDC_LIMIT_P3_TITLE2);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_LB, PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_VALUE, PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_LB, PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_VALUE, PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_LB, PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_VALUE, PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_LB, PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_VALUE, PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_LB, PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_LB);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_VALUE, PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_LIMIT_P3_DONE, PB2W_MDC_LIMIT_P3_DONE);

        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE, PB2W_MDC_TEMPBLOCK_P2_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_IMG, PB2W_MDC_TEMPBLOCK_P2_IMG);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DESC1, PB2W_MDC_TEMPBLOCK_P2_DESC1);
        oneAppElementHashMap.put(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE, PB2W_MDC_TEMPBLOCK_P2_DONE);

    }
}
