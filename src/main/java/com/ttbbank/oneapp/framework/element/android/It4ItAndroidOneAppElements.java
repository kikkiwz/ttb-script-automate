package com.ttbbank.oneapp.framework.element.android;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class It4ItAndroidOneAppElements {
    private It4ItAndroidOneAppElements() {

    }

    //IT4IT
    private static final OneAppElement KYC_PAGE_MISSING_DETAILS = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='ข้อมูลที่จำเป็นต้องมี']");
    private static final OneAppElement KYC_PAGE_REQUIRED_FILED = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='ชื่อ (ภาษาไทย)']");
  
    private static final OneAppElement CHANGE_LANGUAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/btnChangeLng");
    private static final OneAppElement MORE_TAB = new OneAppElement(FindBy.XPATH, "(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]");
    private static final OneAppElement SETTING_TAB = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']");
    private static final OneAppElement NO_INTERNET_CONNECTION = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='No internet connection found']");
    private static final OneAppElement NO_INTERNET_CONNECTION_OK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");
    private static final OneAppElement EXISTING_NUMBER = new OneAppElement(FindBy.XPATH, "(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]");
    private static final OneAppElement KYC_PAGE = new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='ตรวจสอบข้อมูลส่วนตัว']");
    private static final OneAppElement KYC_PAGE_NEXT= new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='ถัดไป']");
    private static final OneAppElement KYC_PAGE_CANCEL = new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='ตรวจสอบภายหลัง']");
    private static final OneAppElement KYC_PAGE_CANCEL_CONFIRM = new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='ยืนยัน']");
    private static final OneAppElement KYC_PAGE_DETAILS = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='ตรวจสอบข้อมูลส่วนตัว']");
    private static final OneAppElement KYC_PAGE_DETAILS_BOTTOM = new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='ยืนยันข้อมูลส่วนตัว']");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE = new OneAppElement(FindBy.XPATH, "(//android.widget.Button[@text='แก้ไข'])[2]");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='เบอร์มือถือ']");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='เบอร์มือถือ']");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM = new OneAppElement(FindBy.XPATH, "//android.widget.Button[@text='บันทึก']");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='ยืนยัน OTP']");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeTextField[@name=\"One time password input\"])");
    private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='รหัส OTP ไม่ถูกต้อง ลองใหม่ได้อีก 2 ครั้ง']");
    private static final OneAppElement NOTIFICATION_TAB = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Notifications']");
    private static final OneAppElement PUSH_NOTIFICATION_TAB = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_push_notifications");
    private static final OneAppElement GENERIC_ERROR_TITLE = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Unable to proceed further']");
    private static final OneAppElement GENERIC_ERROR_BODY = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/bottomsheet_body");
    private static final OneAppElement GENERIC_ERROR_OK = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/full_width_primary_btn");

    private static final OneAppElement APP_GUIDE = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='App Guide']");
    private static final OneAppElement TERMS_AND_CONDITIONS = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Terms and Conditions']");
    private static final OneAppElement PRIVACY_AND_SECURITY = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Privacy and Security']");
    private static final OneAppElement HELP_AND_SUPPPORT = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Help and Support']");
    private static final OneAppElement MORE_LINKAGE_CLOSE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_icon_close");
    private static final OneAppElement MORE_LINKAGE_BACK = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/linkage_icon_back");
    private static final OneAppElement HELP_AND_SUPPPORT_VERIFY = new OneAppElement(FindBy.XPATH, "//android.view.View[@text='Services']");
    private static final OneAppElement HELP_AND_SUPPPORT_NEXT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonNext");


    private static final OneAppElement LANGUAGE_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Language']");
    private static final OneAppElement LANGUAGE_BUTTON_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ภาษา']");
    private static final OneAppElement SELECT_LANGUAGE_PAGE = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='Select your application language']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH = new OneAppElement(FindBy.XPATH, "//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_english']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI = new OneAppElement(FindBy.XPATH, "//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_thai']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ภาษา']");
    private static final OneAppElement SELECT_LANGUAGE_BACKBUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.ImageButton[@resource-id='com.ttbbank.oneapp.vit:id/change_language_back_button']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2 = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='ไทย']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2 = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@text='English']");
    private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK = new OneAppElement(FindBy.XPATH, "//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingIconBack']");
    private static final OneAppElement LOGGOUT_BUTTON = new OneAppElement(FindBy.XPATH, "//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']");
    private static final OneAppElement LOGGOUT_BUTTON_OK = new OneAppElement(FindBy.XPATH, "//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_primary_btn']");
    private static final OneAppElement QUICK_BALANCE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_title_quick_balance");
    private static final OneAppElement MESSAGES_TAB = new OneAppElement(FindBy.XPATH, "(//android.widget.RadioButton)[2]");
    private static final OneAppElement INBOX_BACK_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/icon_back_navigation");    
    private static final OneAppElement INBOX_DATE= new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_message_executed_date");
    private static final OneAppElement DELETE_ALL= new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_delete_all");
    private static final OneAppElement NO_MESSAGE_VIEW= new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/tv_no_message");
    
    
    
    
    
    
    
    
    
    
    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {
        
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_MISSING_DETAILS, KYC_PAGE_MISSING_DETAILS);     
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_REQUIRED_FILED, KYC_PAGE_REQUIRED_FILED);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANGUAGE, CHANGE_LANGUAGE);     
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_NEXT, KYC_PAGE_NEXT);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_CANCEL, KYC_PAGE_CANCEL);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_CANCEL_CONFIRM, KYC_PAGE_CANCEL_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.DELETE_ALL, DELETE_ALL);
        oneAppElementHashMap.put(OneAppElementKeys.NO_MESSAGE_VIEW, NO_MESSAGE_VIEW);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_DATE, INBOX_DATE);



  


        oneAppElementHashMap.put(OneAppElementKeys.MORE_TAB, MORE_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.MESSAGES_TAB, MESSAGES_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.INBOX_BACK_BUTTON, INBOX_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_TAB, SETTING_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.EXISTING_NUMBER, EXISTING_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE, KYC_PAGE);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS, KYC_PAGE_DETAILS);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_BOTTOM, KYC_PAGE_DETAILS_BOTTOM);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE, KYC_PAGE_DETAILS_EDIT_MOBILE);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER, KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT, KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM, KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM, KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT, KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG, KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG);
        oneAppElementHashMap.put(OneAppElementKeys.NOTIFICATION_TAB, NOTIFICATION_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.PUSH_NOTIFICATION_TAB, PUSH_NOTIFICATION_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_TITLE, GENERIC_ERROR_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_BODY, GENERIC_ERROR_BODY);
        oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_OK, GENERIC_ERROR_OK);
        oneAppElementHashMap.put(OneAppElementKeys.NO_INTERNET_CONNECTION_OK_BUTTON, NO_INTERNET_CONNECTION_OK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.NO_INTERNET_CONNECTION, NO_INTERNET_CONNECTION);
        oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE, APP_GUIDE);
        oneAppElementHashMap.put(OneAppElementKeys.TERMS_AND_CONDITIONS, TERMS_AND_CONDITIONS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIVACY_AND_SECURITY, PRIVACY_AND_SECURITY);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT, HELP_AND_SUPPPORT);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_CLOSE, MORE_LINKAGE_CLOSE);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_BACK, MORE_LINKAGE_BACK);
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

    }
}
