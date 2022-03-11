package com.ttbbank.oneapp.framework.element.android;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;


import java.util.Map;

public class Platform2AndroidOneAppElements {
    private Platform2AndroidOneAppElements() {

    }

    private static final OneAppElement PLATFORM2_MENU_MORE_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[4]");
    private static final OneAppElement PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private static final OneAppElement PLATFORM2_MENU_SETTING_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/settingMenuName");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_INPUT_TEXT = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_MANAGE_EMAIL_INPUT_input");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "button_submit_change_email");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_ERROR_INFORMATION_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "SETTING_MANAGE_EMAIL_INPUT_helptext");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "informative_desc");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_CLEAR_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "MANAGE_EMAIL_CLEAR_INPUT_BUTTON");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "error_message_text");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "RESEND_VERIFICATION_CODE_BUTTON");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_ONE_DIGIT_TEXT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.EditText[1]");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_TITLE_SUCCESS_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "title_success");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_OK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "button_manage_email_success_confirm");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_ATTEMPT_TITLE_LABEL = new OneAppElement(FindBy.RESOURCE_ID, "title_limit_verify_email_attemps");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_ATTEMPT_OK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "button_limit_email_attemp_confirm");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]");
    private static final OneAppElement PLATFORM2_CHANGE_EMAIL_VERIFICATION_CODE_ฺBACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "VERIFICATION_CODE_INPUT_NAVBAR_BUTTON_ID");
    private static final OneAppElement PLATFORM2_MENU_SETTING_CHANGE_EMAIL_STATUS_LABEL = new OneAppElement(FindBy.XPATH, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");

    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_MENU_MORE_BUTTON, PLATFORM2_MENU_MORE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON, PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_MENU_SETTING_BUTTON, PLATFORM2_MENU_SETTING_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT, PLATFORM2_CHANGE_EMAIL_INPUT_TEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON, PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL, PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_CLEAR_BUTTON, PLATFORM2_CHANGE_EMAIL_CLEAR_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_INFORMATION_LABEL, PLATFORM2_CHANGE_EMAIL_ERROR_INFORMATION_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL, PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON, PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_ONE_DIGIT_TEXT, PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_ONE_DIGIT_TEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_TITLE_SUCCESS_LABEL, PLATFORM2_CHANGE_EMAIL_TITLE_SUCCESS_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON, PLATFORM2_CHANGE_EMAIL_OK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ATTEMPT_TITLE_LABEL, PLATFORM2_CHANGE_EMAIL_ATTEMPT_TITLE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ATTEMPT_OK_BUTTON, PLATFORM2_CHANGE_EMAIL_ATTEMPT_OK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT, PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_VERIFICATION_CODE_ฺBACK_BUTTON, PLATFORM2_CHANGE_EMAIL_VERIFICATION_CODE_ฺBACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_STATUS_LABEL, PLATFORM2_MENU_SETTING_CHANGE_EMAIL_STATUS_LABEL);
    }
}
