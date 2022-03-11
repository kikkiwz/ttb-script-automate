package com.ttbbank.oneapp.framework;

import com.ttbbank.oneapp.framework.element.android.*;

import java.util.HashMap;
import java.util.Map;

public class AndroidOneAppElements implements OneAppElements {

    //Common
    private OneAppElement REGISTER_TTB = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement CHANGE_LANGUAGE_TC = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/btnChangeLng");
    private OneAppElement AGGREE_TC = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/terms_and_conditions_checkbox");
    private OneAppElement TC_NEXT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/terms_and_conditions_next_btn");
    private OneAppElement CITIZEN_ID = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/edt_component");
    private OneAppElement CITIZEN_ID_NEXT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/next_btn");
    private OneAppElement REGISTER_ENTERPIN = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/access_pin_option_button");
    private OneAppElement ENTER_OTP_REGISTER = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/layout_otp_input\"]");
    private OneAppElement INBOX_MESSAGE = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/img_inbox']");
    private OneAppElement REGISTER_SUCCESSFULL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/complete_next_btn");
    private OneAppElement SAUCELABS_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/btn_skip");
    private OneAppElement DEVICE_ID_INPUT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/appCompatEditText");
    private OneAppElement SAVE_DEVICE_ID_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_ok");
    private OneAppElement SEARCH_BAR = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/searchInput");
    private OneAppElement SEARCH_BAR_X_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_input_end_icon");
    private OneAppElement LANGUAGE_RESULT_VERIFY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/settingMenuName");
    private OneAppElement NO_RESULT_VERIFY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/settingMenuDetail");
    private OneAppElement EXPAND_ARROW = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_action_arrow_ic");
    private OneAppElement INSURANCE_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ประกัน'] ");
    private OneAppElement INSURANCE_ENGLISH = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Insurance']");


    private OneAppElement DEPOSIT_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.TEXT, "Deposit");
    private OneAppElement CARD_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.TEXT, "Card");
    private OneAppElement CARD_ITEM_0_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/creditCard", 0);

    private OneAppElement SKIP_INTRO_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/skipIntro");
    private OneAppElement NEXT_INTRO_HONE_SCREEN_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonNext");
    private OneAppElement NEXT_INTRO_HONE_SCREEN_BUTTON_UAT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/buttonNext");
    private OneAppElement INTRO_HOME_SCREEN_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");
    private OneAppElement NEXT_INTRO_HOME_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:uat/buttonNext");

    private OneAppElement PIN_0_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_00");
    private OneAppElement PIN_1_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_01");
    private OneAppElement PIN_2_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_02");
    private OneAppElement PIN_3_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_03");
    private OneAppElement PIN_4_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_04");
    private OneAppElement PIN_5_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_05");
    private OneAppElement PIN_6_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_06");
    private OneAppElement PIN_7_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_07");
    private OneAppElement PIN_8_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_08");
    private OneAppElement PIN_9_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/key_09");
    private OneAppElement CANCEL_ENTER_PIN = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_cancel_btn");

    private OneAppElement SKIP_INTRO_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/skipIntro");
    private OneAppElement ACCOUNT_TAB = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]");
    private OneAppElement HOME_TAB = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]");

    private OneAppElement ACCOUNT_INTRO_SKIP_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView");

    private OneAppElement ACCOUNT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/ll_tap", 1);
    private OneAppElement LENDING_ACCOUNT_BUTTON_UAT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.uat:id/ll_tap", 1);
    private OneAppElement SERVICE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/ll_tap", 2);

    private OneAppElement DOCUMENTS_SERVICE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "cs_service_tab_documents_label_id");
    private OneAppElement BUTTON_BACK_VERIFY_PERSONAL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back");

    // Home Screen
    private OneAppElement TRANSFER_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    private OneAppElement PAY_BILL_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    private OneAppElement WITH_DRAW_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout");
    private OneAppElement SCAN_QR_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
    private OneAppElement TOP_UP_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    private OneAppElement APPLY_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    private OneAppElement INVESTMENT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout");
    private OneAppElement INSURANCE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout");
    private OneAppElement QUICK_BALANCE_WIDGET = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/widget_quick_balance");
    private OneAppElement QUICK_BENEFIT_WIDGET = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_action_button");
    private OneAppElement APPLICATION_TRACKING_WIDGET = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView");
    private OneAppElement TTB_PRODUCTS_WIDGET = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView");
    private OneAppElement HIGHLIGHT_CAMPAIGN_WIDGET = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.ImageView");
    private OneAppElement EXPAND_QUICK_ACTION_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@content-desc=\"Expand quick action\"]");
    private OneAppElement COLLAPSE_QUICK_ACTION_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@content-desc=\"Collapse quick action\"]");
    private OneAppElement BOTTOMSHEET_TITLE_REGISTER = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_title");
    private OneAppElement BOTTOMSHEET_DESCRIPTION_REGISTER = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_body");
    private OneAppElement QUICK_BALANCE_WIDGET_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/appCompatTextView7");
    private OneAppElement QUICK_BALANCE_WIDGET_DESCRIPTION = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement TERMS_AND_CONDITIONS_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement MANAGE_HOMEPAGE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bgEditWidget");
    private OneAppElement TERM_AND_CONDITION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/terms_and_conditions_title_text");
    private OneAppElement TERM_AND_CON_BUTTON_CHANGE_LANGUAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/btnChangeLng");
    private OneAppElement HEADER_SCREEN_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement HEADER_SCREEN_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_custom_text");
    private OneAppElement APPLICATION_TRACKING_START_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.widget.Button");
    private OneAppElement APPLICATION_TRACKING_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]");
    private OneAppElement APPLICATION_TRACKING_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    private OneAppElement FAVORITE_WIDGET_ITEM_INDEX_1 = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
    private OneAppElement FAVORITE_WIDGET_SEE_ALL_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_see_all");
    private OneAppElement PERSONALIZE_REGISTER_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonView");
    private OneAppElement INBOX_NOTIFICATION_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_mail");
    private OneAppElement AVATAR_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/imageViewProfile");
    private OneAppElement HOME_CONTAINER = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/home_container");

    // Service
    private OneAppElement SERVICE_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View");
    private OneAppElement SERVICE_APPLY_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[1]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_DEPOSIT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[1]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_CARD_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[2]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_INVESTMENT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_PERSONAL_LOAN_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[4]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_AUTO_LOAN_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[5]/android.view.View[2]");
    private OneAppElement SERVICE_APPLY_INSURANCE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.widget.ListView/android.view.View[6]/android.view.View[2]");
    private OneAppElement SERVICE_STATUS_TRACKING_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[3]/android.view.View");

    //More
    private OneAppElement MORE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/ll_tap", 3);
    private OneAppElement SETTING_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 1);
    private OneAppElement APP_GUIDE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    private OneAppElement LOGOUT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/logoutMenu");
    private OneAppElement CONFIRM_LOGOUT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement MORE_HEADER_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/specialH1TextView");
    private OneAppElement CLOSE_APP_GUIDE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/linkage_icon_close");
    private OneAppElement BACK_TNC_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/linkage_icon_back");
    private OneAppElement WIDGET_LIBRARY_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup");

    //Widget library
    private OneAppElement WIDGET_LIBRARY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement WIDGET_LIBRARY_LIST = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/listViewWidget");
    private OneAppElement WIDGET_LIBRARY_CARD_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/textViewWidgetTitle");
    private OneAppElement APPLICATION_TRACKING_WIDGET_ITEM = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement FUND_SEARCH_WIDGET_ITEM = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement TTB_PRODUCTS_WIDGET_ITEM = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement WIDGET_LIBRARY_HIGHLIGHT_CAMPAIGN_WIDGET_ITEM = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement WIDGET_LIBRARY_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/iconBack");
    private OneAppElement WIDGET_LIBRARY_TITLE_CARD = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView[2]");
    private OneAppElement BUTTON_ADD_TO_HOMEPAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonAddWidget");
    private OneAppElement BUTTON_BACK_TNC_WIDGET_LIBRARY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement BUTTON_INSTALLED_WIDGET_LIBRARY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonAddWidget");

    private OneAppElement ACTIVATE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/btn_activate");
    private OneAppElement REGISTER_TTB_BUTTON_MORE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonCTA");
    private OneAppElement REGISTER_TTB_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement REGISTER_TTB_BUTTON_WIDGET_LIRBARY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_btn_container");
    private OneAppElement ACCEPT_TERM_AND_CON_CHECKBOX = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/terms_and_conditions_checkbox");
    private OneAppElement TERM_AND_CON_NEXT_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/terms_and_conditions_next_btn");
    private OneAppElement TERM_AND_CON_TITLE_SCREEN = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_custom_text");
    private OneAppElement INPUT_RM_FIELD = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/edt_component");
    private OneAppElement INPUT_ERROR_INLINE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/txt_error");
    private OneAppElement ENTER_CID_NEXT_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/next_btn");
    private OneAppElement OTP_HEADER = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_text");
    private OneAppElement ACTIVATE_PUSH_NOTIFICATION_TOGGLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/complete_toggle");
    private OneAppElement ACTIVATE_COMPLETE_NEXT_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/complete_next_btn");

    //Bottomsheet
    private OneAppElement BOTTOMSHEET_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_title");
    private OneAppElement BOTTOMSHEET_DESCRIPTION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_body");
    private OneAppElement BOTTOMSHEET_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement BOTTOMSHEET_BUTTON_SECOND = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_ghost_btn");
    private OneAppElement BOTTOMSHEET_CLOSE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/close_bottomsheet_btn");
    private OneAppElement BOTTOMSHEET_CARD = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/design_bottom_sheet");
    private OneAppElement BOTTOMSHEET_WEBVIEW = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/design_bottom_sheet");
    private OneAppElement BOTTOMSHEET_PRIVACY_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
    private OneAppElement BOTTOMSHEET_PRIVACY_X_ICON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageButton[@content-desc=\"Back\"]");

    //Login Bottom sheet
    private OneAppElement BOTTOMSHEET_LOGIN_CLOSE_ICON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/close_pin_pad");
    private OneAppElement BOTTOMSHEET_LOGIN_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_pin");
    private OneAppElement BOTTOMSHEET_LOGIN_ERROR_INLINE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/error_text_show");
    private OneAppElement BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/forgot_pin_text");
    private OneAppElement BOTTOMSHEET_LOGIN_1_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_01");
    private OneAppElement BOTTOMSHEET_LOGIN_2_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_02");
    private OneAppElement BOTTOMSHEET_LOGIN_3_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_03");
    private OneAppElement BOTTOMSHEET_LOGIN_4_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_04");
    private OneAppElement BOTTOMSHEET_LOGIN_5_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_05");
    private OneAppElement BOTTOMSHEET_LOGIN_6_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_06");
    private OneAppElement BOTTOMSHEET_LOGIN_7_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_07");
    private OneAppElement BOTTOMSHEET_LOGIN_8_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_08");
    private OneAppElement BOTTOMSHEET_LOGIN_9_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_09");
    private OneAppElement BOTTOMSHEET_LOGIN_0_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/key_00");
    private OneAppElement BOTTOMSHEET_LOGIN_DELETE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/clear");
    private OneAppElement BIOMETRIC_SCAN = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/bioButton");

    //Confirm Bottomsheet
    private OneAppElement BOTTOMSHEET_CONFIRM_1_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_1");
    private OneAppElement BOTTOMSHEET_CONFIRM_2_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_2");
    private OneAppElement BOTTOMSHEET_CONFIRM_3_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_3");
    private OneAppElement BOTTOMSHEET_CONFIRM_0_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_0");


    //Personalize Intro
    private OneAppElement PERSONALZIE_INTRO_NEXT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/buttonNext");

    //Setting Screen
    private OneAppElement MORE_TABS = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.ImageView");
    private OneAppElement MORE_SETTINGS = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
    private OneAppElement SETTING_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_text");
    private OneAppElement SETTING_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement BIOMETRIC_SWITCH = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingToggle");
    private OneAppElement SETTING_SEARCH_INPUT_X_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/text_input_end_icon");
    private OneAppElement SETTING_SEARCH_INPUT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/searchInput");
    private OneAppElement SETTING_SEARCH_RESULT_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName");
    private OneAppElement SETTING_SEARCH_CLEAR_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_input_end_icon");
    private OneAppElement SETTING_PROFILE_NAME = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textViewProfileName");
    private OneAppElement SETTING_PROFILE_IMAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/imageViewProfile");
    private OneAppElement SETTING_SEARCH_NO_RESULT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuDetail");
    private OneAppElement SETTING_INDEX_0 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 0);
    private OneAppElement SETTING_INDEX_1 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 1);
    private OneAppElement SETTING_INDEX_2 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 2);
    private OneAppElement SETTING_INDEX_3 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 3);
    private OneAppElement SETTING_INDEX_4 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 4);
    private OneAppElement SETTING_INDEX_5 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 5);
    private OneAppElement SETTING_INDEX_6 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 6);
    private OneAppElement SETTING_INDEX_7 = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName", 7);
    private OneAppElement SETTING_MOBILE_NO_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_MOBILE_NO = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_EMAIL_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_EMAIL_DETAIL = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_EMAIL_VERIFY_STATUS = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private OneAppElement SETTING_CURRENT_ADDRESS_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='4']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_INTERNATIONAL_TRANSFER_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='5']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_MANAGE_ACCOUNT_MENU = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.LinearLayout");
    private OneAppElement SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]");
    private OneAppElement SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/viewSwitch");
    private OneAppElement SETTING_MANAGE_ACCOUNT_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/iconBack");
    private OneAppElement SETTING_DAILY_TRANSACTION_LIMIT_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='8']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_PIN_FREE_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='8']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    private OneAppElement SETTING_PIN_FREE_FLAG = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='8']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private OneAppElement SETTING_PAY_WITH_WOW_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='9']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_CHANGE_PIN_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='11']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_BIOMETRIC_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='12']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_LOGIN_WITH_BIOMETRIC_MENU = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_FAVORITES_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='14']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_MANAGE_HOMEPAGE_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='15']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_NOTIFICATIONS_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='16']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_QUICK_BALANCE_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='17']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_AUTO_SAVE_SLIP_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='18']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_CHANGE_LANGUAGE_MENU = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@index='19']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_BIOMETRIC_DETAIL = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement SETTING_QUICK_BALANCE_TOGGLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private OneAppElement SETTING_CHANGE_LANGUAGE_VALUE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private OneAppElement SETTING_APPLICATION_SECTION = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView");
    private OneAppElement SETTING_ACCOUNT_AND_CARD_SECTION = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView");
    private OneAppElement SETTING_SECURITY_SECTION = new OneAppElement(FindBy.XPATH, "//android.view.ViewGroup[@index='10']/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView");
    private OneAppElement SETTING_PIN_FREE_ALLOW_RADIO = new OneAppElement(FindBy.RESOURCE_ID, "allow");
    private OneAppElement SETTING_PIN_FREE_NOT_ALLOW_RADIO = new OneAppElement(FindBy.RESOURCE_ID, "not-allow");
    private OneAppElement SETTING_PIN_FREE_SAVE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_FAVOURITE_BUTTON_SUBMIT");
    private OneAppElement SETTING_PIN_FREE_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button");
    private OneAppElement SETTING_PIN_FREE_BACK_TO_HOME_BUTTON = new OneAppElement(FindBy.ID, "SETTING_FAVOURITE_BUTTON_SUBMIT");
    //    private OneAppElement SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON = new OneAppElement(FindBy.ID, "SETTING_FAVOURITE_BUTTON_SECONDARY");
    private OneAppElement SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.widget.Button[2]");
    private OneAppElement SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_FAVOURITE_BUTTON_SUBMIT");
    private OneAppElement SETTING_PIN_FREE_BACK_ARROW_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    private OneAppElement SETTING_SEARCH_RESULT_RECYCLER_VIEW = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/settingRecyclerView");
    private OneAppElement SEARCH_SETTINGS = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/searchInput");
    private OneAppElement SEARCH_SETTINGS_LIST = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuDetail");
    private OneAppElement SEARCH_SETTINGS_DELETE_WORD = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/text_input_end_icon");
    private OneAppElement SEARCH_SETTINGS_NO_RESULT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuDetail");
    private OneAppElement SETTING_QUICK_BALANCE_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_custom_text");

    //International Address
    private OneAppElement INTERNATIONAL_ADDRESS_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_NAV_TITLE_ID");
    private OneAppElement INTERNATIONAL_ADDRESS_OVERVIEW_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "titleID");
    private OneAppElement INTERNATIONAL_ADDRESS_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_NAV_BTN_BACK_ID");
    private OneAppElement INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "btnID");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET = new OneAppElement(FindBy.RESOURCE_ID, "COMFIRM_ADDR_FORM_POPUP_BTN_CONFIRM_ID");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[1]");
    private OneAppElement INTERNATIONAL_ADDRESS_HOUSE_NO = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_HOUSE_NO_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_ROOM_NO = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_ROOM_NO_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_FLOOR = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_FLOOR_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_MOO = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_MOO_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_SOI = new OneAppElement(FindBy.RESOURCE_ID, "CONFIRM_ADDR_FORM_SOI_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_VILLAGE = new OneAppElement(FindBy.RESOURCE_ID, "COMFIRM_ADDR_FORM_VILLAGE_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_ROAD = new OneAppElement(FindBy.RESOURCE_ID, "COMFIRM_ADDR_FORM_ROAD_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_ZIP_CODE = new OneAppElement(FindBy.RESOURCE_ID, "COMFIRM_ADDR_FORM_ZIPCODE_ID_input");
    private OneAppElement INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View[11]/android.view.View/android.widget.ListView/android.view.View[1]/android.widget.Button");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Button");
    private OneAppElement INTERNATIONAL_ADDRESS_EDIT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "EDIT_BUTTON_ID");

    // Daily limit
    private OneAppElement DAILY_TRANSACTION_LIMIT_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DOMESTIC = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[2]");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT = new OneAppElement(FindBy.RESOURCE_ID, "domestic_input");
    private OneAppElement DAILY_TRANSACTION_LIMIT_INTERNATIONAL = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[9]");
    private OneAppElement DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT = new OneAppElement(FindBy.RESOURCE_ID, "international_input");
    private OneAppElement DAILY_TRANSACTION_LIMIT_SAVE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_FAVOURITE_BUTTON_SUBMIT");
    private OneAppElement DAILY_TRANSACTION_LIMIT_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DETAIL = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]");

    //Setting Transaction Limit
    private OneAppElement TRANSACTION_LIMIT_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]");
    private OneAppElement TRANSACTION_LIMIT_FOR_DOMESTRIC_INPUT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.widget.EditText");
    private OneAppElement TRANSACTION_LIMIT_SAVE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_FAVOURITE_BUTTON_SUBMIT");
    private OneAppElement TRANSACTION_LIMIT_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    private OneAppElement TRANSACTION_LIMIT_FOR_INTERNATIONAL_INPUT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[10]/android.widget.EditText");

    // Pin free
    private OneAppElement PIN_FREE_TRANSACTION_LIMIT_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View");
    private OneAppElement PIN_FREE_TRANSACTION_LIMIT_DETAIL = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]");

    //Manage Account screen
    private OneAppElement MANAGE_ACCOUNT_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");

    //Setting Quick Balance screen
    private OneAppElement QUICK_BALANCE_ENABLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_on_off_text");
    private OneAppElement QUICK_BALANCE_ENABLE_TOGGLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_setup_on_off_toggle");
    private OneAppElement QUICK_BALANCE_SHOW_BALANCE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_setup_show_text");
    private OneAppElement QUICK_BALANCE_SHOW_BALANCE_TOGGLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_setup_show_toggle");
    private OneAppElement QUICK_BALANCE_CONFIRM_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_setup_btn");
    private OneAppElement QUICK_BALANCE_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement QUICK_BALANCE_FIRST_ACCOUNT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/layout_quick_balance_account", 0);

    //Change lang screen
    private OneAppElement CHANGE_LANG_THAI_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/radio_thai");
    private OneAppElement CHANGE_LANG_ENG_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/radio_english");
    private OneAppElement CHANGE_LANG_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/change_language_back_button");

    //Pin Lock Screen
    private OneAppElement PINLOCK_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]\n");
    private OneAppElement PINLOCK_RESET_PIN_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]");
    private OneAppElement PINLOCK_RETURN_TO_HOME_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[4]");
    private OneAppElement VERIFY_MOBILE_NUMBER_PROGRESS = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_stepper_title");
    private OneAppElement RESEND_OTP_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/otp_verify_resend_button");
    private OneAppElement CANCEL_OTP_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_cancel_btn");
    private OneAppElement CANCEL_BOTTOM_SHEET_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_title");
    private OneAppElement CANCEL_BOTTOM_SHEET_DETAIL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_body");
    private OneAppElement LEAVE_PAGE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement STAY_ON_PAGE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_ghost_btn");
    private OneAppElement OTP_ERROR_INLINE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/otp_verify_error_text");


    //Change Pin Screen
    private OneAppElement CHANGE_PIN_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement CHANGE_PIN_CANCEL_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/title_custom_cancel_btn");
    private OneAppElement CHANGE_PIN_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]");
    private OneAppElement CHANGE_PIN_SUB_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView");
    private OneAppElement CHANGE_PIN_FORGOT_PIN_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView");
    private OneAppElement CHANGE_PIN_1_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]");
    private OneAppElement CHANGE_PIN_2_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");
    private OneAppElement CHANGE_PIN_3_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]");
    private OneAppElement CHANGE_PIN_4_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[4]");
    private OneAppElement CHANGE_PIN_5_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[5]");
    private OneAppElement CHANGE_PIN_6_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[6]");
    private OneAppElement CHANGE_PIN_7_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[7]");
    private OneAppElement CHANGE_PIN_8_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[8]");
    private OneAppElement CHANGE_PIN_9_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[9]");
    private OneAppElement CHANGE_PIN_0_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[10]");
    private OneAppElement CHANGE_PIN_DELETE_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@content-desc=\"Delete\"]");
    private OneAppElement CHANGE_PIN_ERROR_INLINE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/close_bottomsheet_btn");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private OneAppElement CHANGE_PIN_SUCCESS_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_title");
    private OneAppElement CHANGE_PIN_SUCCESS_OK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_primary_btn");
    private OneAppElement CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_ghost_btn");

    //Product Activation Option
    private OneAppElement STEPPER_PROGRESS = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_stepper_progress");
    private OneAppElement STEPPER_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_stepper_title");
    private OneAppElement ACTIVATE_WITH_ACTIVATION_CODE_OPTION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/activation_active_option_label");
    private OneAppElement ACTIVATE_OPTION_NEXT_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/activate_option_next_button");

    //Activation with Code
    private OneAppElement ACTIVATION_WITH_CODE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/activation_code_title_edit_text");
    private OneAppElement ACTIVATION_WITH_CODE_FIELD = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_box_layout");
    private OneAppElement ACTIVATION_WITH_CODE_EDIT_FIELD = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/edt_component");
    private OneAppElement ACTIVATION_WITH_CODE_INLINE_ERROR = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/txt_error");
    private OneAppElement ACTIVATION_WITH_CODE_RIGHT_DESCRIPTION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/right_description");
    private OneAppElement ACTIVATION_WITH_CODE_NEXT_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/activate_code_next_button");
    private OneAppElement CANCEL_ACTIVATION_WITH_CODE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_cancel_btn");
    private OneAppElement ACTIVATE_CODE_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");

    //Account Summary
    private OneAppElement ACCOUNT_SUMMARY_PAGE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_account_sum");
    private OneAppElement ACCOUNT_SUMMARY_TAB_DEPOSIT = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@content-desc=\"Deposit\"]/android.widget.TextView\n");
    private OneAppElement ACCOUNT_SUMMARY_TAB_CARD = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@content-desc=\"Card\"]/android.widget.TextView");
    private OneAppElement ACCOUNT_SUMMARY_TAB_INVESTMENT = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@content-desc=\"Investment\"]/android.widget.TextView");
    private OneAppElement ACCOUNT_SUMMARY_TAB_LOAN = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@content-desc=\"Loan\"]/android.widget.TextView");
    private OneAppElement ACCOUNT_SUMMARY_TAB_INSURANCE = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@content-desc=\"Insurance\"]/android.widget.TextView");
    private OneAppElement PRODUCT_INTRO_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement PRODUCT_INTRO_DESCRIPTION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textDescription");
    private OneAppElement REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonCTA");
    private OneAppElement ACCOUNT_SUMMARY_BACK_FROM_TNC = new OneAppElement(FindBy.XPATH, "//android.widget.ImageButton[@content-desc=\"Back\"]");
    private OneAppElement ACCOUNT_DETAIL_DEPOSIT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView");
    private OneAppElement ACCOUNT_DEPOSIT_DETAIL_BACK = new OneAppElement(FindBy.RESOURCE_ID, "adBtn_back_button");
    private OneAppElement ACCOUNT_DEPOSIT_SECOND_CARD = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[@index='1']");
    private OneAppElement ACCOUNT_DEPOSIT_NAME_CARD = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[@index='1']/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[1]");
    private OneAppElement OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW = new OneAppElement(FindBy.RESOURCE_ID, "cs_apply_deposit_account_navigation_header_id");
    private OneAppElement OPEN_DEPOSIT_ACCOUNT_BACK_WEB_VIEW = new OneAppElement(FindBy.RESOURCE_ID, "cs_apply_deposit_account_navigation_icon_id");
    private OneAppElement EXIT_OPEN_DEPOSIT_ACCOUNT_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[2]");

    private OneAppElement ACCOUNT_DEPOSIT_NAME_CARD_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]");
    private OneAppElement ACCOUNT_DEPOSIT_NAME_CARD_SECOND_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textAccountNo");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[3]");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_SECOND_NUMBER_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[3]");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textValueAvailableBalance");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_SECOND_WEB_VIEW = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]/android.view.View");
    private OneAppElement ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/totalAvailableLabel");
    private OneAppElement ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/totalAvailableBalance");
    private OneAppElement ACCOUNT_DEPOSIT_ICON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/iconDeposit");
    private OneAppElement ACCOUNT_DEPOSIT_PRODUCT_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textProductTitle");

    //Product Introduction
    private OneAppElement PRODUCT_INTRODUCTION_IMAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/imageView");
    private OneAppElement PRODUCT_INTRODUCTION_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement PRODUCT_INTRODUCTION_CONTENT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textDescription");
    private OneAppElement PRODUCT_INTRODUCTION_BUTTON_CTA = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonCTA");
    private OneAppElement PRODUCT_INTRODUCTION_HYPER_LINK1 = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/hyperlink1");

    //Product Introduction Prospect
    private OneAppElement PRODUCT_INTRODUCTION_TITLE_PROSPECT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement PRODUCT_INTRODUCTION_CONTENT_PROSPECT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textDescription");
    private OneAppElement PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonCTA");
    private OneAppElement PRODUCT_INTRODUCTION_BACK_TERM_AND_CONDITION_PROSPECT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    private OneAppElement PRODUCT_INTRODUCTION_IMAGE_PROSPECT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/imageView");

    //Account Summary Card
    private OneAppElement APPLY_NEW_CARD_WEBVIEW_TITLE = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View");
    private OneAppElement APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button");
    private OneAppElement APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View");
    private OneAppElement CREDIT_CARD_CARD = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]");

    //Confirm PIN (Support Investment Team)
//    private OneAppElement CONFIRM_PIN_0_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']");
//    private OneAppElement CONFIRM_PIN_1_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_1']");
//    private OneAppElement CONFIRM_PIN_2_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_2']");
//    private OneAppElement CONFIRM_PIN_3_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_3']");

    private OneAppElement CONFIRM_PIN_0_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_0");
    private OneAppElement CONFIRM_PIN_1_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_1");
    private OneAppElement CONFIRM_PIN_2_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_2");
    private OneAppElement CONFIRM_PIN_3_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_3");
    private OneAppElement CONFIRM_PIN_4_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_4");
    private OneAppElement CONFIRM_PIN_5_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_5");
    private OneAppElement CONFIRM_PIN_6_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_6");
    private OneAppElement CONFIRM_PIN_7_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_7");
    private OneAppElement CONFIRM_PIN_8_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_8");
    private OneAppElement CONFIRM_PIN_9_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/pin_key_9");

    private OneAppElement CONFIRM_PIN_0_BUTTON_UAT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/pin_key_0");
    private OneAppElement CONFIRM_PIN_1_BUTTON_UAT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/pin_key_1");
    private OneAppElement CONFIRM_PIN_2_BUTTON_UAT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/pin_key_2");
    private OneAppElement CONFIRM_PIN_3_BUTTON_UAT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.uat:id/pin_key_3");

    //Topup Screen
    private OneAppElement TOP_UP_AIS_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat\n");
    private OneAppElement TOP_UP_10_AMOUNT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
    private OneAppElement TOP_UP_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]");
    private OneAppElement TOP_UP_CONFIRM_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/btn_confirm");
    private OneAppElement TOP_UP_MOBILE_NUMBER_TEXT_FIELDS = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/edt_mobile_no");
    private OneAppElement TOP_UP_CONFIRM_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/icon_back_navigation");
    private OneAppElement TOP_UP_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@content-desc=\"background\"]");
    private OneAppElement SELECT_TOP_UP_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@content-desc=\"background\"]");


    //IT4IT

    private static final OneAppElement EXPLORE_NOW = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textViewLink");
    private static final OneAppElement WIDGET_LIBRARY_MORE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private static final OneAppElement WIDGET_LIBRARY_MORE_ID = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textViewWidgetTitle");
    private static final OneAppElement HIGHLIGHT_CAMP = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Highlight Campaign']");
    private static final OneAppElement ALL_TTB_PRODUCT = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='All ttb products']");
    private static final OneAppElement FUND_SEARCH = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Fund Search']");
    private static final OneAppElement MANAGE_CAR = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Manage Everything About Your Car']");
    private static final OneAppElement HIGHLIGHT_CAMP_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='แคมเปญแนะนำ']");
    private static final OneAppElement ALL_TTB_PRODUCT_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ค้นหากองทุน']");
    private static final OneAppElement FUND_SEARCH_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='สถานะการสมัคร']");
    private static final OneAppElement MANAGE_CAR_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='จัดการทุกอย่างเกี่ยวกับรถของคุณ']");

    private static final OneAppElement WIDGET_INSTALLED = new OneAppElement(FindBy.XPATH, "//android.view.View[@resource-id='test-id']");
    private static final OneAppElement ADD_TO_HOME_PAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonAddWidget");
    private static final OneAppElement WIDGET_BACK = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/iconBack");
    private static final OneAppElement VERIFY_LANDED_WIDGET_PAGE = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='img']");
    private static final OneAppElement SUCCESSFULLY_ADDED = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_title");
    private static final OneAppElement RETURN_HOME = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private static final OneAppElement EXPLORE_OTHER_WIDGET = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_ghost_btn");
    private static final OneAppElement PIN_CANCEL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/close_pin_pad");
    private OneAppElement HOME_TAB_1 = new OneAppElement(FindBy.XPATH, "(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[1]");
    private OneAppElement DISCOVERY = new OneAppElement(FindBy.XPATH, "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]");
    private OneAppElement APP_GUIDE = new OneAppElement(FindBy.XPATH, "(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuName'])[2]");
    private OneAppElement TERMS_AND_CONDITIONS = new OneAppElement(FindBy.XPATH, "(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuName'])[3]");
    private OneAppElement PRIVACY_AND_SECURITY = new OneAppElement(FindBy.XPATH, "(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuName'])[4]");
    private OneAppElement HELP_AND_SUPPPORT = new OneAppElement(FindBy.XPATH, "(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuName'])[5]");
    private OneAppElement MORE_LINKAGE_CLOSE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_icon_close");
    private OneAppElement MORE_LINKAGE_BACK = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_icon_back");
    private OneAppElement HELP_AND_SUPPPORT_VERIFY = new OneAppElement(FindBy.XPATH, "//android.view.View[@resource-id='cs_service_title_label_id']");
    private OneAppElement MORE_LINKAGE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_custom_text");
    private OneAppElement HELP_AND_SUPPPORT_NEXT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonNext");
    private OneAppElement APP_GUIDE_VERIFY = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='ค้นหาตามหมวดหมู่']");
    private OneAppElement PRIVACY_AND_SECURITY_VERIFY = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='Customer Privacy Policy']");
    private OneAppElement PRIVACY_AND_SECURITY_VERIFY_THAI = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='นโยบายความเป็นส่วนตัวของลูกค้า']");
    private OneAppElement LANGUAGE_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Language']");
    private OneAppElement LANGUAGE_BUTTON_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ภาษา']");
    private OneAppElement SELECT_LANGUAGE_PAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/change_language_description_body");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH = new OneAppElement(FindBy.XPATH, "//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_english']");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_thai']");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ภาษา']");
    private OneAppElement SELECT_LANGUAGE_BACKBUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageButton[@resource-id='com.ttbbank.oneapp.vit:id/change_language_back_button']");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2 = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ไทย']");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2 = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='English']");
    private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingIconBack']");
    private OneAppElement LOGGOUT_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']");
    private OneAppElement LOGGOUT_BUTTON_OK = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_primary_btn']");
    private OneAppElement QUICK_BALANCE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_title_quick_balance");

    //Platform More Screen
    private OneAppElement MORE_TNC_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout");
    private OneAppElement MORE_HELP_SUPPORT_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout");
    private OneAppElement MORE_PRIVACY_SECURITY_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View[1]");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_TITLE = new OneAppElement(FindBy.RESOURCE_ID, "cs_service_title_label_id");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS = new OneAppElement(FindBy.RESOURCE_ID, "cs_contact_ttb_card_social_title_label_id");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_TAB = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[4]");
    private OneAppElement APP_GUIDE_START = new OneAppElement(FindBy.ACCESSIBILITY_ID, "เริ่มต้นใช้งาน");
    private OneAppElement APP_GUIDE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_custom_text");
    private OneAppElement APP_GUIDE_REGISTER_AT_BRANCHES = new OneAppElement(FindBy.ACCESSIBILITY_ID, "สมัครผ่านสาขา");

    //Verify Personal Info Screen
    private OneAppElement BUTTON_CITIZEN_ID_NO = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.RadioGroup/android.widget.RadioButton[1]");
    private OneAppElement BUTTON_PASSPORT_NO = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.RadioGroup/android.widget.RadioButton[2]");
    private OneAppElement VERIFY_PERSONAL_LAYOUT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/layout_container");
    private OneAppElement CITIZEN_PANEL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/verify_citizen_id_panel");


    //System Wifi setting
    private OneAppElement SYSTEM_TOGGLE_WIFI_SETTING = new OneAppElement(FindBy.ID, "android:id/switch_widget");


    //Transfer
    private OneAppElement TRANSFER_TITLE = new OneAppElement(FindBy.XPATH, "//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_title']");
    private OneAppElement OWN_TTB_ACCOUNT_BUTTON = new OneAppElement(FindBy.XPATH, "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");

    //Manage Home
    private OneAppElement MANAGE_HOME_LIST_WIDGET_LIBRARY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/listEditable");
    private OneAppElement MANAGE_HOME_BUTTON_SAVE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonSave");
    private OneAppElement MANAGE_HOME_EDIT_WIDGET_HOME = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bgEditWidget");
    private OneAppElement MANAGE_HOME_ICON_DELETE = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/iconDelete");
    private OneAppElement INBOX_ICON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_mail");
    private OneAppElement MESSAGE_COUNT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_read_more");
    private OneAppElement MESSAGE_COUNT_MESSAGE_TAB = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_view_personalize_bg");
    private OneAppElement INBOX_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/txt_title");
    private OneAppElement INBOX_READ_MESSAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_read");
    private OneAppElement INBOX_UNREAD_MESSAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_unread");
    private OneAppElement PAST_MESSAGES = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_date_group");
    private OneAppElement INBOX_MESSAGE_DELETE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_delete");
    private OneAppElement INBOX_MESSAGE_DELETE_MESSAGE_TAB = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_personalize_delete");
    private OneAppElement INBOX_MESSAGE_READ_MORE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/img_read_more");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/checkbox_read");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_CANCEL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_cancel");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_delete_selected");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_DELETE_ALL = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_delete_all");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_title");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private OneAppElement INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_ghost_btn");
    private OneAppElement HOME_WIDGETS_LIST = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/listWidgets");
    private OneAppElement MANAGE_HOME_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement MANAGE_HOME_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back");
    private OneAppElement MANAGE_HOME_ADD_WIDGET_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/addWidget");
    private OneAppElement MANAGE_HOME_UNEDITABLE_ICON = new OneAppElement(FindBy.XPATH, "//android.widget.FrameLayout[@resource-id='com.ttbbank.oneapp.vit:id/layoutWidgetUnEditable']/android.view.ViewGroup/android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iconDragUnEditable']");
    private OneAppElement MANAGE_HOME_FIRST_ITEM_TITLE = new OneAppElement(FindBy.XPATH, "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
    private OneAppElement MANAGE_HOME_FIRST_ITEM_ICON = new OneAppElement(FindBy.XPATH, "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[1]");
    private OneAppElement MANAGE_HOME_SECOND_ITEM_TITLE = new OneAppElement(FindBy.XPATH, "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView");
    private OneAppElement MANAGE_HOME_SECOND_ITEM_ICON = new OneAppElement(FindBy.XPATH, "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[1]");

    //OTP Screen
    private OneAppElement FIRST_OTP_INPUT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.TextView[1]");

    //Block Screen
    private OneAppElement BLOCK_SCREEN_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_title");
    private OneAppElement BLOCK_SCREEN_BODY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_body");
    private OneAppElement BLOCK_SCREEN_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/dialog_primary_btn");

    //Activate Complete Screen
    private OneAppElement COMPLETE_SCREEN_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/complete_title");
    private OneAppElement COMPLETE_SCREEN_SUBTITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/complete_subtitle");

    //Confirm pin
    private OneAppElement CONFIRM_PIN_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_icon_back");
    // UAT ENTER PIN
    private OneAppElement PIN_0_BUTTON_UAT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.uat:id/key_00");
    private OneAppElement PIN_1_BUTTON_UAT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.uat:id/key_01");
    private OneAppElement PIN_2_BUTTON_UAT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.uat:id/key_02");
    private OneAppElement PIN_3_BUTTON_UAT = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.uat:id/key_03");

    private Map<String, OneAppElement> oneAppElementHashMap = new HashMap<>();

    public AndroidOneAppElements() {

        AutoLoanAndroidOneAppElements.init(oneAppElementHashMap);
        CustomerServiceAndroidOneAppElements.init(oneAppElementHashMap);
        InvestmentAndroidOneAppElements.init(oneAppElementHashMap);
        It4ItAndroidOneAppElements.init(oneAppElementHashMap);
        LendingAndroidOneAppElements.init(oneAppElementHashMap);
        Pb1AndroidOneAppElements.init(oneAppElementHashMap);
        Pb2AndroidOneAppElements.init(oneAppElementHashMap);
        ProtectionAndroidOneAppElements.init(oneAppElementHashMap);
        Platform1AndroidOneAppElements.init(oneAppElementHashMap);

        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB, REGISTER_TTB);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANGUAGE_TC, CHANGE_LANGUAGE_TC);
        oneAppElementHashMap.put(OneAppElementKeys.AGGREE_TC, AGGREE_TC);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_SUCCESSFULL, REGISTER_SUCCESSFULL);
        oneAppElementHashMap.put(OneAppElementKeys.TC_NEXT, TC_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_DELETE_MESSAGE_TAB, INBOX_MESSAGE_DELETE_MESSAGE_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.MESSAGE_COUNT_MESSAGE_TAB, MESSAGE_COUNT_MESSAGE_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_ICON, INBOX_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.MESSAGE_COUNT, MESSAGE_COUNT);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_TITLE, INBOX_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_READ_MESSAGE, INBOX_READ_MESSAGE);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_UNREAD_MESSAGE, INBOX_UNREAD_MESSAGE);
        oneAppElementHashMap.put(OneAppElementKeys.PAST_MESSAGES, PAST_MESSAGES);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_READ_MORE, INBOX_MESSAGE_READ_MORE);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_DELETE, INBOX_MESSAGE_DELETE);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ, INBOX_MESSAGE_CHECKBOX_READ);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CANCEL, INBOX_MESSAGE_CHECKBOX_READ_CANCEL);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED, INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_ALL, INBOX_MESSAGE_CHECKBOX_READ_DELETE_ALL);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_TITLE, INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON, INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON, INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE, APP_GUIDE);
        oneAppElementHashMap.put(OneAppElementKeys.TERMS_AND_CONDITIONS, TERMS_AND_CONDITIONS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIVACY_AND_SECURITY, PRIVACY_AND_SECURITY);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT, HELP_AND_SUPPPORT);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_CLOSE, MORE_LINKAGE_CLOSE);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_BACK, MORE_LINKAGE_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_TITLE, MORE_LINKAGE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT_VERIFY, HELP_AND_SUPPPORT_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT_NEXT, HELP_AND_SUPPPORT_NEXT);

        oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_BUTTON, LANGUAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_BUTTON_THAI, LANGUAGE_BUTTON_THAI);

        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_PAGE, SELECT_LANGUAGE_PAGE);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH, SELECT_LANGUAGE_RADIOBUTTON_ENGLISH);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI, SELECT_LANGUAGE_RADIOBUTTON_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM, SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_BACKBUTTON, SELECT_LANGUAGE_BACKBUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2, SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK, SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON, LOGGOUT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON_OK, LOGGOUT_BUTTON_OK);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE, QUICK_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2, SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2);
        oneAppElementHashMap.put(OneAppElementKeys.CITIZEN_ID, CITIZEN_ID);
        oneAppElementHashMap.put(OneAppElementKeys.CITIZEN_ID_NEXT, CITIZEN_ID_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_ENTERPIN, REGISTER_ENTERPIN);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_MESSAGE, INBOX_MESSAGE);
        oneAppElementHashMap.put(OneAppElementKeys.ENTER_OTP_REGISTER, ENTER_OTP_REGISTER);
        oneAppElementHashMap.put(OneAppElementKeys.SAUCELAB_BUTTON, SAUCELABS_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DEVICE_ID_INPUT, DEVICE_ID_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.SKIP_INTRO_HOME_SCREEN_BUTTON, SKIP_INTRO_HOME_SCREEN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON, NEXT_INTRO_HOME_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SAVE_DEVICE_ID_BUTTON, SAVE_DEVICE_ID_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_0_BUTTON, PIN_0_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_1_BUTTON, PIN_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_2_BUTTON, PIN_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_3_BUTTON, PIN_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_4_BUTTON, PIN_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_5_BUTTON, PIN_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_6_BUTTON, PIN_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_7_BUTTON, PIN_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_8_BUTTON, PIN_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_9_BUTTON, PIN_9_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_ENTER_PIN, CANCEL_ENTER_PIN);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_BUTTON, ACCOUNT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LENDING_ACCOUNT_BUTTON_UAT, LENDING_ACCOUNT_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.DISCOVERY, DISCOVERY);


        oneAppElementHashMap.put(OneAppElementKeys.SKIP_INTRO_BUTTON, SKIP_INTRO_BUTTON);
//        oneAppElementHashMap.put(OneAppElementKeys.SKIP_INTRO_BUTTON_UAT, SKIP_INTRO_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON, NEXT_INTRO_HONE_SCREEN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON_UAT, NEXT_INTRO_HONE_SCREEN_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON, DEPOSIT_HOME_SCREEN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_BUTTON, SERVICE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_BUTTON, MORE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DOCUMENTS_SERVICE_BUTTON, DOCUMENTS_SERVICE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON, CARD_HOME_SCREEN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CARD_ITEM_0_HOME_SCREEN_BUTTON, CARD_ITEM_0_HOME_SCREEN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BUTTON, SETTING_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_BUTTON, APP_GUIDE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LOGOUT_BUTTON, LOGOUT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_BACK_VERIFY_PERSONAL, BUTTON_BACK_VERIFY_PERSONAL);

        //Service
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_TITLE, SERVICE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_BUTTON, SERVICE_APPLY_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_DEPOSIT_BUTTON, SERVICE_APPLY_DEPOSIT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_CARD_BUTTON, SERVICE_APPLY_CARD_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_INVESTMENT_BUTTON, SERVICE_APPLY_INVESTMENT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_PERSONAL_LOAN_BUTTON, SERVICE_APPLY_PERSONAL_LOAN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_AUTO_LOAN_BUTTON, SERVICE_APPLY_AUTO_LOAN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_INSURANCE_BUTTON, SERVICE_APPLY_INSURANCE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_STATUS_TRACKING_BUTTON, SERVICE_STATUS_TRACKING_BUTTON);

        // More Screen
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON, CONFIRM_LOGOUT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.HEADER_SCREEN_BACK_BUTTON, HEADER_SCREEN_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.HEADER_SCREEN_TITLE, HEADER_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_HEADER_TITLE, MORE_HEADER_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CLOSE_APP_GUIDE_BUTTON, CLOSE_APP_GUIDE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BACK_TNC_BUTTON, BACK_TNC_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_BUTTON, WIDGET_LIBRARY_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_TNC_BUTTON, MORE_TNC_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_HELP_SUPPORT_BUTTON, MORE_HELP_SUPPORT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON, MORE_PRIVACY_SECURITY_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TITLE, SERVICE_PAGE_CONTACT_TTB_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER, SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS, SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS);
        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TAB, SERVICE_PAGE_CONTACT_TTB_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_START, APP_GUIDE_START);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_TITLE, APP_GUIDE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_REGISTER_AT_BRANCHES, APP_GUIDE_REGISTER_AT_BRANCHES);

        oneAppElementHashMap.put(OneAppElementKeys.INTRO_HOME_SCREEN_NEXT_BUTTON, INTRO_HOME_SCREEN_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_TAB, ACCOUNT_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.HOME_TAB, HOME_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_INTRO_SKIP_BUTTON, ACCOUNT_INTRO_SKIP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_BUTTON, ACTIVATE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_MORE, REGISTER_TTB_BUTTON_MORE);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON, REGISTER_TTB_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_WIDGET_LIRBARY, REGISTER_TTB_BUTTON_WIDGET_LIRBARY);
        oneAppElementHashMap.put(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX, ACCEPT_TERM_AND_CON_CHECKBOX);
        oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON, TERM_AND_CON_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN, TERM_AND_CON_TITLE_SCREEN);
        oneAppElementHashMap.put(OneAppElementKeys.INPUT_RM_FIELD, INPUT_RM_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.INPUT_ERROR_INLINE, INPUT_ERROR_INLINE);
        oneAppElementHashMap.put(OneAppElementKeys.ENTER_CID_NEXT_BUTTON, ENTER_CID_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_HEADER, OTP_HEADER);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_PUSH_NOTIFICATION_TOGGLE, ACTIVATE_PUSH_NOTIFICATION_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON, ACTIVATE_COMPLETE_NEXT_BUTTON);

        //Bottomsheet
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_TITLE, BOTTOMSHEET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION, BOTTOMSHEET_DESCRIPTION);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON, BOTTOMSHEET_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND, BOTTOMSHEET_BUTTON_SECOND);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON, BOTTOMSHEET_CLOSE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CARD, BOTTOMSHEET_CARD);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_WEBVIEW, BOTTOMSHEET_WEBVIEW);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE, BOTTOMSHEET_PRIVACY_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON, BOTTOMSHEET_PRIVACY_X_ICON);

        //Product Activation Option
        oneAppElementHashMap.put(OneAppElementKeys.STEPPER_PROGRESS, STEPPER_PROGRESS);
        oneAppElementHashMap.put(OneAppElementKeys.STEPPER_TITLE, STEPPER_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION, ACTIVATE_WITH_ACTIVATION_CODE_OPTION);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON, ACTIVATE_OPTION_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_ACTIVATION_WITH_CODE, CANCEL_ACTIVATION_WITH_CODE);

        //Activation with code
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE, ACTIVATION_WITH_CODE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD, ACTIVATION_WITH_CODE_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_EDIT_FIELD, ACTIVATION_WITH_CODE_EDIT_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON, ACTIVATION_WITH_CODE_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_INLINE_ERROR, ACTIVATION_WITH_CODE_INLINE_ERROR);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_RIGHT_DESCRIPTION, ACTIVATION_WITH_CODE_RIGHT_DESCRIPTION);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_CODE_BACK_BUTTON, ACTIVATE_CODE_BACK_BUTTON);

        //Home
        oneAppElementHashMap.put(OneAppElementKeys.TRANSFER_BUTTON, TRANSFER_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PAY_BILL_BUTTON, PAY_BILL_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.WITH_DRAW_BUTTON, WITH_DRAW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SCAN_QR_BUTTON, SCAN_QR_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_BUTTON, TOP_UP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_BUTTON, APPLY_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INVESTMENT_BUTTON, INVESTMENT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INSURANCE_BUTTON, INSURANCE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_WIDGET, QUICK_BALANCE_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BENEFIT_WIDGET, QUICK_BENEFIT_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_WIDGET, APPLICATION_TRACKING_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.TTB_PRODUCTS_WIDGET, TTB_PRODUCTS_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET, HIGHLIGHT_CAMPAIGN_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON, EXPAND_QUICK_ACTION_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.COLLAPSE_QUICK_ACTION_BUTTON, COLLAPSE_QUICK_ACTION_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_TITLE_REGISTER, BOTTOMSHEET_TITLE_REGISTER);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_REGISTER, BOTTOMSHEET_DESCRIPTION_REGISTER);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE, QUICK_BALANCE_WIDGET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_WIDGET_DESCRIPTION, QUICK_BALANCE_WIDGET_DESCRIPTION);
        oneAppElementHashMap.put(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON, TERMS_AND_CONDITIONS_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOMEPAGE_BUTTON, MANAGE_HOMEPAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CONDITION, TERM_AND_CONDITION);
        oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_LANGUAGE, TERM_AND_CON_BUTTON_CHANGE_LANGUAGE);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_START_BUTTON, APPLICATION_TRACKING_START_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_TITLE, APPLICATION_TRACKING_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_BACK_BUTTON, APPLICATION_TRACKING_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.FAVORITE_WIDGET_ITEM_INDEX_1, FAVORITE_WIDGET_ITEM_INDEX_1);
        oneAppElementHashMap.put(OneAppElementKeys.FAVORITE_WIDGET_SEE_ALL_BUTTON, FAVORITE_WIDGET_SEE_ALL_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PERSONALIZE_REGISTER_BUTTON, PERSONALIZE_REGISTER_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_NOTIFICATION_BUTTON, INBOX_NOTIFICATION_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AVATAR_BUTTON, AVATAR_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.HOME_CONTAINER, HOME_CONTAINER);

        //Login BottomSheet
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_CLOSE_ICON, BOTTOMSHEET_LOGIN_CLOSE_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE, BOTTOMSHEET_LOGIN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE, BOTTOMSHEET_LOGIN_ERROR_INLINE);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON, BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_1_BUTTON, BOTTOMSHEET_LOGIN_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_2_BUTTON, BOTTOMSHEET_LOGIN_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_3_BUTTON, BOTTOMSHEET_LOGIN_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_4_BUTTON, BOTTOMSHEET_LOGIN_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_5_BUTTON, BOTTOMSHEET_LOGIN_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_6_BUTTON, BOTTOMSHEET_LOGIN_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_7_BUTTON, BOTTOMSHEET_LOGIN_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_8_BUTTON, BOTTOMSHEET_LOGIN_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_9_BUTTON, BOTTOMSHEET_LOGIN_9_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_0_BUTTON, BOTTOMSHEET_LOGIN_0_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_DELETE_BUTTON, BOTTOMSHEET_LOGIN_DELETE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BIOMETRIC_SCAN, BIOMETRIC_SCAN);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CONFIRM_1_BUTTON, BOTTOMSHEET_CONFIRM_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CONFIRM_2_BUTTON, BOTTOMSHEET_CONFIRM_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CONFIRM_3_BUTTON, BOTTOMSHEET_CONFIRM_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CONFIRM_0_BUTTON, BOTTOMSHEET_CONFIRM_0_BUTTON);

        //Pin Lock Screen
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_TITLE, PINLOCK_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON, PINLOCK_RESET_PIN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON, PINLOCK_RETURN_TO_HOME_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS, VERIFY_MOBILE_NUMBER_PROGRESS);
        oneAppElementHashMap.put(OneAppElementKeys.RESEND_OTP_BUTTON, RESEND_OTP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_OTP_BUTTON, CANCEL_OTP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE, CANCEL_BOTTOM_SHEET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL, CANCEL_BOTTOM_SHEET_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.LEAVE_PAGE_BUTTON, LEAVE_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.STAY_ON_PAGE_BUTTON, STAY_ON_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_ERROR_INLINE, OTP_ERROR_INLINE);

        //Personalize Intro
        oneAppElementHashMap.put(OneAppElementKeys.PERSONALZIE_INTRO_NEXT_BUTTON, PERSONALZIE_INTRO_NEXT_BUTTON);

        //Setting Screen
        oneAppElementHashMap.put(OneAppElementKeys.HOME_TAB_1, HOME_TAB_1);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_TABS, MORE_TABS);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_SETTINGS, MORE_SETTINGS);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_TITLE, SETTING_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BACK_BUTTON, SETTING_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BIOMETRIC_SWITCH, BIOMETRIC_SWITCH);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PROFILE_NAME, SETTING_PROFILE_NAME);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PROFILE_IMAGE, SETTING_PROFILE_IMAGE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_INPUT, SETTING_SEARCH_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_RESULT_TITLE, SETTING_SEARCH_RESULT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_CLEAR_BUTTON, SETTING_SEARCH_CLEAR_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON, SETTING_SEARCH_INPUT_X_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_NO_RESULT, SETTING_SEARCH_NO_RESULT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_0, SETTING_INDEX_0);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_1, SETTING_INDEX_1);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_2, SETTING_INDEX_2);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_3, SETTING_INDEX_3);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_4, SETTING_INDEX_4);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_5, SETTING_INDEX_5);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_6, SETTING_INDEX_6);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_7, SETTING_INDEX_7);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MOBILE_NO_MENU, SETTING_MOBILE_NO_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MOBILE_NO, SETTING_MOBILE_NO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_MENU, SETTING_EMAIL_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_DETAIL, SETTING_EMAIL_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_VERIFY_STATUS, SETTING_EMAIL_VERIFY_STATUS);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CURRENT_ADDRESS_MENU, SETTING_CURRENT_ADDRESS_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU, SETTING_INTERNATIONAL_TRANSFER_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU, SETTING_MANAGE_ACCOUNT_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT, SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT, SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON, SETTING_MANAGE_ACCOUNT_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU, SETTING_DAILY_TRANSACTION_LIMIT_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_MENU, SETTING_PIN_FREE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_FLAG, SETTING_PIN_FREE_FLAG);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PAY_WITH_WOW_MENU, SETTING_PAY_WITH_WOW_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_PIN_MENU, SETTING_CHANGE_PIN_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BIOMETRIC_MENU, SETTING_BIOMETRIC_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_LOGIN_WITH_BIOMETRIC_MENU, SETTING_LOGIN_WITH_BIOMETRIC_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_FAVORITES_MENU, SETTING_FAVORITES_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU, SETTING_MANAGE_HOMEPAGE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_NOTIFICATIONS_MENU, SETTING_NOTIFICATIONS_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU, SETTING_QUICK_BALANCE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_AUTO_SAVE_SLIP_MENU, SETTING_AUTO_SAVE_SLIP_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_MENU, SETTING_CHANGE_LANGUAGE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BIOMETRIC_DETAIL, SETTING_BIOMETRIC_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE, SETTING_QUICK_BALANCE_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_VALUE, SETTING_CHANGE_LANGUAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_APPLICATION_SECTION, SETTING_APPLICATION_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_ACCOUNT_AND_CARD_SECTION, SETTING_ACCOUNT_AND_CARD_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SECURITY_SECTION, SETTING_SECURITY_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_ALLOW_RADIO, SETTING_PIN_FREE_ALLOW_RADIO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_NOT_ALLOW_RADIO, SETTING_PIN_FREE_NOT_ALLOW_RADIO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_SAVE_BUTTON, SETTING_PIN_FREE_SAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON, SETTING_PIN_FREE_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_HOME_BUTTON, SETTING_PIN_FREE_BACK_TO_HOME_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON, SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON, SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_ARROW_BUTTON, SETTING_PIN_FREE_BACK_ARROW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_RESULT_RECYCLER_VIEW, SETTING_SEARCH_RESULT_RECYCLER_VIEW);

        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS, SEARCH_SETTINGS);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS_LIST, SEARCH_SETTINGS_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD, SEARCH_SETTINGS_DELETE_WORD);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT, SEARCH_SETTINGS_NO_RESULT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_TITLE, SETTING_QUICK_BALANCE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE, QUICK_BALANCE_SHOW_BALANCE_TOGGLE);

        //International Address
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_TITLE, INTERNATIONAL_ADDRESS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_TITLE, INTERNATIONAL_ADDRESS_OVERVIEW_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON, INTERNATIONAL_ADDRESS_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON, INTERNATIONAL_ADDRESS_OVERVIEW_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET, INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS, INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_HOUSE_NO, INTERNATIONAL_ADDRESS_HOUSE_NO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ROOM_NO, INTERNATIONAL_ADDRESS_ROOM_NO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_FLOOR, INTERNATIONAL_ADDRESS_FLOOR);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_MOO, INTERNATIONAL_ADDRESS_MOO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_SOI, INTERNATIONAL_ADDRESS_SOI);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_VILLAGE, INTERNATIONAL_ADDRESS_VILLAGE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ROAD, INTERNATIONAL_ADDRESS_ROAD);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ZIP_CODE, INTERNATIONAL_ADDRESS_ZIP_CODE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT, INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_BUTTON, INTERNATIONAL_ADDRESS_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_EDIT_BUTTON, INTERNATIONAL_ADDRESS_EDIT_BUTTON);

        // Daily limit
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_TITLE, DAILY_TRANSACTION_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DOMESTIC, DAILY_TRANSACTION_LIMIT_DOMESTIC);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT, DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_INTERNATIONAL, DAILY_TRANSACTION_LIMIT_INTERNATIONAL);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT, DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_SAVE_BUTTON, DAILY_TRANSACTION_LIMIT_SAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON, DAILY_TRANSACTION_LIMIT_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DETAIL, DAILY_TRANSACTION_LIMIT_DETAIL);

        // Pin free
        oneAppElementHashMap.put(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_TITLE, PIN_FREE_TRANSACTION_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_DETAIL, PIN_FREE_TRANSACTION_LIMIT_DETAIL);

        //Manage Account screen
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_ACCOUNT_TITLE, MANAGE_ACCOUNT_TITLE);
        //Setting Quick balance screen
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ENABLE, QUICK_BALANCE_ENABLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE, QUICK_BALANCE_ENABLE_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE, QUICK_BALANCE_SHOW_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON, QUICK_BALANCE_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON, QUICK_BALANCE_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT, QUICK_BALANCE_FIRST_ACCOUNT);

        // Change lang screen
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_THAI_BUTTON, CHANGE_LANG_THAI_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_ENG_BUTTON, CHANGE_LANG_ENG_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON, CHANGE_LANG_BACK_BUTTON);

        //Setting Transaction Limit
        oneAppElementHashMap.put(OneAppElementKeys.TRANSACTION_LIMIT_TITLE, TRANSACTION_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.TRANSACTION_LIMIT_FOR_DOMESTRIC_INPUT, TRANSACTION_LIMIT_FOR_DOMESTRIC_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.TRANSACTION_LIMIT_FOR_INTERNATIONAL_INPUT, TRANSACTION_LIMIT_FOR_INTERNATIONAL_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.TRANSACTION_LIMIT_BACK_BUTTON, TRANSACTION_LIMIT_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TRANSACTION_LIMIT_SAVE_BUTTON, TRANSACTION_LIMIT_SAVE_BUTTON);

        //Change Pin Screen
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON, CHANGE_PIN_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON, CHANGE_PIN_CANCEL_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_TITLE, CHANGE_PIN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUB_TITLE, CHANGE_PIN_SUB_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_FORGOT_PIN_BUTTON, CHANGE_PIN_FORGOT_PIN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_1_BUTTON, CHANGE_PIN_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_2_BUTTON, CHANGE_PIN_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_3_BUTTON, CHANGE_PIN_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_4_BUTTON, CHANGE_PIN_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_5_BUTTON, CHANGE_PIN_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_6_BUTTON, CHANGE_PIN_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_7_BUTTON, CHANGE_PIN_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_8_BUTTON, CHANGE_PIN_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_9_BUTTON, CHANGE_PIN_9_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_0_BUTTON, CHANGE_PIN_0_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_DELETE_BUTTON, CHANGE_PIN_DELETE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE, CHANGE_PIN_ERROR_INLINE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON, CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE, CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON, CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON, CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE, CHANGE_PIN_SUCCESS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON, CHANGE_PIN_SUCCESS_OK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON, CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON);

        //Account Summary
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE, ACCOUNT_SUMMARY_PAGE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT, ACCOUNT_SUMMARY_TAB_DEPOSIT);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD, ACCOUNT_SUMMARY_TAB_CARD);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INVESTMENT, ACCOUNT_SUMMARY_TAB_INVESTMENT);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_LOAN, ACCOUNT_SUMMARY_TAB_LOAN);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INSURANCE, ACCOUNT_SUMMARY_TAB_INSURANCE);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRO_TITLE, PRODUCT_INTRO_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION, PRODUCT_INTRO_DESCRIPTION);
        oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION, REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_BACK_FROM_TNC, ACCOUNT_SUMMARY_BACK_FROM_TNC);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER_WEB_VIEW, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_SECOND_NUMBER_WEB_VIEW, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_SECOND_NUMBER_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_WEB_VIEW, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_SECOND_WEB_VIEW, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE_SECOND_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT, ACCOUNT_DETAIL_DEPOSIT);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_DETAIL_BACK, ACCOUNT_DEPOSIT_DETAIL_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_SECOND_CARD, ACCOUNT_DEPOSIT_SECOND_CARD);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD, ACCOUNT_DEPOSIT_NAME_CARD);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD_WEB_VIEW, ACCOUNT_DEPOSIT_NAME_CARD_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD_SECOND_WEB_VIEW, ACCOUNT_DEPOSIT_NAME_CARD_SECOND_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT, ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE, ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_ICON, ACCOUNT_DEPOSIT_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_PRODUCT_TITLE, ACCOUNT_DEPOSIT_PRODUCT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW, OPEN_DEPOSIT_ACCOUNT_TITLE_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.OPEN_DEPOSIT_ACCOUNT_BACK_WEB_VIEW, OPEN_DEPOSIT_ACCOUNT_BACK_WEB_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.EXIT_OPEN_DEPOSIT_ACCOUNT_WEB_VIEW, EXIT_OPEN_DEPOSIT_ACCOUNT_WEB_VIEW);

        //Product Introduction
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_IMAGE, PRODUCT_INTRODUCTION_IMAGE);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE, PRODUCT_INTRODUCTION_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_CONTENT, PRODUCT_INTRODUCTION_CONTENT);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA, PRODUCT_INTRODUCTION_BUTTON_CTA);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_HYPER_LINK1, PRODUCT_INTRODUCTION_HYPER_LINK1);

        //Product Introduction Prospect
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_TITLE_PROSPECT, PRODUCT_INTRODUCTION_TITLE_PROSPECT);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_CONTENT_PROSPECT, PRODUCT_INTRODUCTION_CONTENT_PROSPECT);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT, PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_BACK_TERM_AND_CONDITION_PROSPECT, PRODUCT_INTRODUCTION_BACK_TERM_AND_CONDITION_PROSPECT);
        oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRODUCTION_IMAGE_PROSPECT, PRODUCT_INTRODUCTION_IMAGE_PROSPECT);

        //Account Summary Card
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_TITLE, APPLY_NEW_CARD_WEBVIEW_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON, APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON, APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CREDIT_CARD_CARD, CREDIT_CARD_CARD);

        //Confirm PIN (Support Investment)
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, CONFIRM_PIN_0_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_1_BUTTON, CONFIRM_PIN_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_2_BUTTON, CONFIRM_PIN_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_3_BUTTON, CONFIRM_PIN_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_4_BUTTON, CONFIRM_PIN_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_5_BUTTON, CONFIRM_PIN_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_6_BUTTON, CONFIRM_PIN_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_7_BUTTON, CONFIRM_PIN_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_8_BUTTON, CONFIRM_PIN_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_9_BUTTON, CONFIRM_PIN_9_BUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_0_BUTTON_UAT, CONFIRM_PIN_0_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_1_BUTTON_UAT, CONFIRM_PIN_1_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_2_BUTTON_UAT, CONFIRM_PIN_2_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_3_BUTTON_UAT, CONFIRM_PIN_3_BUTTON_UAT);

        // Top Up Screen
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_AIS_BUTTON, TOP_UP_AIS_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS, TOP_UP_MOBILE_NUMBER_TEXT_FIELDS);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_10_AMOUNT_BUTTON, TOP_UP_10_AMOUNT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_NEXT_BUTTON, TOP_UP_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON, TOP_UP_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_CONFIRM_BACK_BUTTON, TOP_UP_CONFIRM_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_BACK_BUTTON, TOP_UP_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SELECT_TOP_UP_BACK_BUTTON, SELECT_TOP_UP_BACK_BUTTON);


        //Widget Library Screen
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY, WIDGET_LIBRARY);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_LIST, WIDGET_LIBRARY_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_CARD_TITLE, WIDGET_LIBRARY_CARD_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM, APPLICATION_TRACKING_WIDGET_ITEM);
        oneAppElementHashMap.put(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM, TTB_PRODUCTS_WIDGET_ITEM);
        oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM, WIDGET_LIBRARY_HIGHLIGHT_CAMPAIGN_WIDGET_ITEM);
        oneAppElementHashMap.put(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM, FUND_SEARCH_WIDGET_ITEM);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON, WIDGET_LIBRARY_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_TITLE_CARD, WIDGET_LIBRARY_TITLE_CARD);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE, BUTTON_ADD_TO_HOMEPAGE);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_BACK_TNC_WIDGET_LIBRARY, BUTTON_BACK_TNC_WIDGET_LIBRARY);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY, BUTTON_INSTALLED_WIDGET_LIBRARY);

        //Verify Personal Info Screen
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_PASSPORT_NO, BUTTON_PASSPORT_NO);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_CITIZEN_ID_NO, BUTTON_CITIZEN_ID_NO);
        oneAppElementHashMap.put(OneAppElementKeys.VERIFY_PERSONAL_LAYOUT, VERIFY_PERSONAL_LAYOUT);
        oneAppElementHashMap.put(OneAppElementKeys.CITIZEN_PANEL, CITIZEN_PANEL);

        //System Wifi setting
        oneAppElementHashMap.put(OneAppElementKeys.SYSTEM_TOGGLE_WIFI_SETTING, SYSTEM_TOGGLE_WIFI_SETTING);
        //Transfer
        oneAppElementHashMap.put(OneAppElementKeys.TRANSFER_TITLE, TRANSFER_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.OWN_TTB_ACCOUNT_BUTTON, OWN_TTB_ACCOUNT_BUTTON);

        //OTP Screen
        oneAppElementHashMap.put(OneAppElementKeys.FIRST_OTP_INPUT, FIRST_OTP_INPUT);

        //Block Screen
        oneAppElementHashMap.put(OneAppElementKeys.BLOCK_SCREEN_TITLE, BLOCK_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.BLOCK_SCREEN_BODY, BLOCK_SCREEN_BODY);
        oneAppElementHashMap.put(OneAppElementKeys.BLOCK_SCREEN_BUTTON, BLOCK_SCREEN_BUTTON);

        //Activate Complete Screen
        oneAppElementHashMap.put(OneAppElementKeys.COMPLETE_SCREEN_TITLE, COMPLETE_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.COMPLETE_SCREEN_SUBTITLE, COMPLETE_SCREEN_SUBTITLE);

        //Confirm Pin
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_BACK_BUTTON, CONFIRM_PIN_BACK_BUTTON);

        //Manage Homepage
        oneAppElementHashMap.put(OneAppElementKeys.HOME_WIDGETS_LIST, HOME_WIDGETS_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_TITLE, MANAGE_HOME_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY, MANAGE_HOME_LIST_WIDGET_LIBRARY);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE, MANAGE_HOME_BUTTON_SAVE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME, MANAGE_HOME_EDIT_WIDGET_HOME);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_ICON_DELETE, MANAGE_HOME_ICON_DELETE);

        oneAppElementHashMap.put(OneAppElementKeys.EXPLORE_NOW, EXPLORE_NOW);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_MORE, WIDGET_LIBRARY_MORE);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_MORE_ID, WIDGET_LIBRARY_MORE_ID);
        oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMP, HIGHLIGHT_CAMP);
        oneAppElementHashMap.put(OneAppElementKeys.ALL_TTB_PRODUCT, ALL_TTB_PRODUCT);
        oneAppElementHashMap.put(OneAppElementKeys.FUND_SEARCH, FUND_SEARCH);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_CAR, MANAGE_CAR);
        oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMP_THAI, HIGHLIGHT_CAMP_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.ALL_TTB_PRODUCT_THAI, ALL_TTB_PRODUCT_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.FUND_SEARCH_THAI, FUND_SEARCH_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_CAR_THAI, MANAGE_CAR_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_INSTALLED, WIDGET_INSTALLED);
        oneAppElementHashMap.put(OneAppElementKeys.ADD_TO_HOME_PAGE, ADD_TO_HOME_PAGE);
        oneAppElementHashMap.put(OneAppElementKeys.WIDGET_BACK, WIDGET_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.VERIFY_LANDED_WIDGET_PAGE, VERIFY_LANDED_WIDGET_PAGE);
        oneAppElementHashMap.put(OneAppElementKeys.SUCCESSFULLY_ADDED, SUCCESSFULLY_ADDED);
        oneAppElementHashMap.put(OneAppElementKeys.RETURN_HOME, RETURN_HOME);
        oneAppElementHashMap.put(OneAppElementKeys.EXPLORE_OTHER_WIDGET, EXPLORE_OTHER_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_CANCEL, PIN_CANCEL);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_VERIFY, APP_GUIDE_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.PRIVACY_AND_SECURITY_VERIFY, PRIVACY_AND_SECURITY_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.PRIVACY_AND_SECURITY_VERIFY_THAI, PRIVACY_AND_SECURITY_VERIFY_THAI);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_BAR, SEARCH_BAR);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_BAR_X_BUTTON, SEARCH_BAR_X_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_RESULT_VERIFY, LANGUAGE_RESULT_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.NO_RESULT_VERIFY, NO_RESULT_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.EXPAND_ARROW, EXPAND_ARROW);
        oneAppElementHashMap.put(OneAppElementKeys.INSURANCE_ENGLISH, INSURANCE_ENGLISH);
        oneAppElementHashMap.put(OneAppElementKeys.INSURANCE_THAI, INSURANCE_THAI);

        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON, MANAGE_HOME_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON, MANAGE_HOME_ADD_WIDGET_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_UNEDITABLE_ICON, MANAGE_HOME_UNEDITABLE_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_FIRST_ITEM_TITLE, MANAGE_HOME_FIRST_ITEM_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_FIRST_ITEM_ICON, MANAGE_HOME_FIRST_ITEM_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_SECOND_ITEM_TITLE, MANAGE_HOME_SECOND_ITEM_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_SECOND_ITEM_ICON, MANAGE_HOME_SECOND_ITEM_ICON);
        //Enter PIN UAT
        oneAppElementHashMap.put(OneAppElementKeys.PIN_0_BUTTON_UAT, PIN_0_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_1_BUTTON_UAT, PIN_1_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_2_BUTTON_UAT, PIN_2_BUTTON_UAT);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_3_BUTTON_UAT, PIN_3_BUTTON_UAT);

    }

    public OneAppElement get(String elementKey) {
        return oneAppElementHashMap.get(elementKey);
    }
}

