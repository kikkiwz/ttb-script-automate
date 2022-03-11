package com.ttbbank.oneapp.framework.element.android;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class Platform1AndroidOneAppElements {
    private Platform1AndroidOneAppElements() {

    }

    //Platform1
    private static final OneAppElement QUICK_BALANCE_DETAIL_TO_ENABLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/widget_quick_balance");
    private static final OneAppElement QUICK_BALANCE_ACTIVATE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/btn_activate");
    private static final OneAppElement QUICK_BALANCE_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/title_custom_text");
    private static final OneAppElement QUICK_BALANCE_VIEW_BALANCE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/button_view_balance");
    private static final OneAppElement QUICK_BALANCE_PRODUCT_NAME_WIDGET = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_account_name");
    private static final OneAppElement QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_account_number");
    private static final OneAppElement QUICK_BALANCE_VALUE_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/text_balance");
    private static final OneAppElement QUICK_BALANCE_CONFIRM_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/quick_balance_setup_btn");

    private static final OneAppElement ACCOUNT_DETAIL_BACK_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "adBtn_back_button");

    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_1_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_1");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_2_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_2");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_3_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_3");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_4_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_4");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_5_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_5");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_6_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_6");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_7_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_7");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_8_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_8");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_9_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_9");
    private static final OneAppElement BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_0_BUTTON = new OneAppElement(FindBy.RESOURCE_ID, "com.ttbbank.oneapp.vit:id/pin_key_0");



    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE, QUICK_BALANCE_DETAIL_TO_ENABLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON, QUICK_BALANCE_ACTIVATE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_TITLE, QUICK_BALANCE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON, QUICK_BALANCE_VIEW_BALANCE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET, QUICK_BALANCE_PRODUCT_NAME_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET, QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_VALUE_BUTTON, QUICK_BALANCE_VALUE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON, QUICK_BALANCE_CONFIRM_BUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DETAIL_BACK_BUTTON, ACCOUNT_DETAIL_BACK_BUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_1_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_2_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_3_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_4_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_5_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_6_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_7_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_8_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_9_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_9_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_0_BUTTON, BOTTOMSHEET_LOGIN_MANAGE_ACCOUNT_0_BUTTON);

    }
}
