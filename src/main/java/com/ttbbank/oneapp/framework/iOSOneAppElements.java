package com.ttbbank.oneapp.framework;

import java.util.HashMap;
import java.util.Map;
import com.ttbbank.oneapp.framework.element.ios.*;

public class iOSOneAppElements implements OneAppElements {

    //Common
    private OneAppElement REGISTER_TTB = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Register ttb touch");
    private OneAppElement AGGREE_TC = new OneAppElement(FindBy.ACCESSIBILITY_ID, "I accept the Terms and Conditions");
    private OneAppElement TC_NEXT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement CITIZEN_ID = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeTextField[@name=\"CID Input Field\"])[1]");
    private OneAppElement CITIZEN_ID_NEXT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement REGISTER_ENTERPIN = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Register enter pin");
    private OneAppElement ENTER_OTP_REGISTER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Verify mobile number\"]/../XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    private OneAppElement REGISTER_SUCCESSFULL = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private OneAppElement QUICK_BALANCE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "QUICK BALANCE");
    private OneAppElement QUICK_BALANCE_THAI = new OneAppElement(FindBy.ACCESSIBILITY_ID, "บัญชีเบสิก");
    private OneAppElement SAUCELABS_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Saucelabs\"]");
    private OneAppElement DEVICE_ID_INPUT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTextField[@value=\"Enter DeviceId\"]");
    private OneAppElement SKIP_INTRO_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"VIT_1.0.0.406-dev.299.VIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther");
    private OneAppElement NEXT_INTRO_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"Dev_1.7.0.406-dev.479.Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private OneAppElement SKIP_INTRO_HOME_SCREE1_BUTTON_DEV = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"Dev_1.0.0.406-dev.480.Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther");
    private OneAppElement NEXT_INTRO_HOME_SCREEN_BUTTON_DEV = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"Dev_1.6.0.406-dev.464.Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
    private OneAppElement NEXT_INTRO_ACCOUNT_SCREEN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"Dev_1.7.0.406-dev.479.Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
    private OneAppElement NEXT_INTRO_SERVICE_SCREEN_BUTTON_DEV = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"Dev_1.0.0.406-dev.335.Dev\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]");
    private OneAppElement DEPOSIT_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Deposit\"])[2]");
    private OneAppElement SERVICE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeOther/XCUIElementTypeButton[3]");
    private OneAppElement TERM_AND_CONDITION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Terms and Conditions\"]");
    private OneAppElement GO_HOME_PROSPECT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Go to Home with prospect\"]");

    private OneAppElement SAVE_DEVICE_ID_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Save");
    private OneAppElement ACCOUNT_TAB = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Account");
    private OneAppElement NEXT_INTRO_HONE_SCREEN_BUTTON = new OneAppElement(FindBy.ID, "//XCUIElementTypeApplication[@name=\"VIT_1.5.0.406-dev.435.VIT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private OneAppElement INTRO_HOME_SCREEN_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");

    private OneAppElement PIN_0_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "0");
    private OneAppElement PIN_1_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private OneAppElement PIN_2_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "2");
    private OneAppElement PIN_3_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "3");

    private OneAppElement ACCOUNT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Account\"]");

    private OneAppElement ACCOUNT_INTRO_SKIP_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");

    private OneAppElement CARD_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Card");
    private OneAppElement SKIP_INTRO_BUTTON = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/skipIntro");
    private OneAppElement CARD_ITEM_0_HOME_SCREEN_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "flash card Double tabs for more details");
    private OneAppElement ALLOW_NOTIFICATION_HOME_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Allow");
    private OneAppElement NEXT_INTRO_HOME_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");

    //confirm Pin (Support Investment)
    private OneAppElement CONFIRM_PIN_0_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "0");
    private OneAppElement CONFIRM_PIN_1_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private OneAppElement CONFIRM_PIN_2_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "2");
    private OneAppElement CONFIRM_PIN_3_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "3");


    // Setting manage widget
    private OneAppElement HOME_WIDGETS_LIST = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"SHORTCUT\"])[2]");
    private OneAppElement MANAGE_HOME_EDIT_WIDGET_HOME = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Manage Homepage");
    private OneAppElement MANAGE_HOME_ADD_WIDGET_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Add Widgets\"]");
    private OneAppElement MANAGE_HOME_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Manage Homepage");
    private OneAppElement MANAGE_HOME_BUTTON_SAVE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Confirm\"]");
    private OneAppElement MANAGE_HOME_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
    private OneAppElement MANAGE_HOME_ICON_DELETE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeButton[@name=\"closePin\"])[2]");
    private OneAppElement MANAGE_HOME_LIST_WIDGET_LIBRARY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]");

    // Home Screen
    private OneAppElement TRANSFER_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Transfer");
    private OneAppElement PAY_BILL_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Pay Bill");
    private OneAppElement WITH_DRAW_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Withdraw");
    private OneAppElement SCAN_QR_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Scan QR");
    private OneAppElement TOP_UP_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Top Up");
    private OneAppElement APPLY_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Apply");
    private OneAppElement INVESTMENT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Investment");
    private OneAppElement INSURANCE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Insurance");
    private OneAppElement QUICK_BALANCE_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "QUICK BALANCE");
    private OneAppElement QUICK_BENEFIT_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Quick Benefit");
    private OneAppElement APPLICATION_TRACKING_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Application Tracking");
    private OneAppElement APPLICATION_TRACKING_START_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "start application-tracking");
    private OneAppElement APPLICATION_TRACKING_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");
    private OneAppElement APPLICATION_TRACKING_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Please Fill in Information\"]");
    private OneAppElement TTB_PRODUCTS_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "All ttb Products");
    private OneAppElement TTB_PRODUCTS_FUND_SEARCH_WIDGET = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeButton");
    private OneAppElement HIGHLIGHT_CAMPAIGN_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Highlight Campaign");
    private OneAppElement EXPAND_QUICK_ACTION_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "expand quick action");
    private OneAppElement COLLAPSE_QUICK_ACTION_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "collapse quick action");
    private OneAppElement BOTTOMSHEET_TITLE_REGISTER = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Only available for ttb touch customer");
    private OneAppElement BOTTOMSHEET_DESCRIPTION_REGISTER = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Please register application to use this function or service");
    private OneAppElement BOTTOMSHEET_CLOSE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Close. Double tabs to activate");
    private OneAppElement QUICK_BALANCE_WIDGET_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "QUICK BALANCE");
    private OneAppElement QUICK_BALANCE_WIDGET_DESCRIPTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Enable this function to check your balance instantly");
    private OneAppElement TERMS_AND_CONDITIONS_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConChevronLeft 24px");
    private OneAppElement MANAGE_HOMEPAGE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Manage Homepage\"]");
    private OneAppElement PERSONALIZED_SCREEN_NEXT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement PERSONALIZED_SCREEN = new OneAppElement(FindBy.ACCESSIBILITY_ID, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton/XCUIElementTypeStaticText");
    private OneAppElement BACKGROUND_HOME_SCREEN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther");
    private OneAppElement TERM_AND_CON_BUTTON_CHANGE_TH_LANGUAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ภาษาไทย\"]");
    private OneAppElement TERM_AND_CON_BUTTON_CHANGE_EN_LANGUAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"English\"]");

    // Home Screen Quick Balance
    private OneAppElement QUICK_BALANCE_DETAIL_TO_ENABLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Enable this function to check your balance instantly");
    private OneAppElement QUICK_BALANCE_ACTIVATE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Action Button");
    private OneAppElement QUICK_BALANCE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Quick Balance");
    private OneAppElement QUICK_BALANCE_PRODUCT_NAME_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Product Name");
    private OneAppElement QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Account Number");
    private OneAppElement QUICK_BALANCE_VIEW_BALANCE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Action Button");
    private OneAppElement QUICK_BALANCE_SHOW_BALANCE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Action Button");
    private OneAppElement ACCOUNT_DETAIL_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");

    // Top Up Screen
    private OneAppElement TOP_UP_AIS_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1-2-Call");
    private OneAppElement TOP_UP_MOBILE_NUMBER_TEXT_FIELDS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private OneAppElement TOP_UP_10_AMOUNT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"10\"]");
    private OneAppElement TOP_UP_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private OneAppElement TOP_UP_CONFIRM_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Confirm\"]");
    private OneAppElement TOP_UP_CONFIRM_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
    private OneAppElement TOP_UP_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "WhiteMedium24PxChevronLeft");
    private OneAppElement SELECT_TOP_UP_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Button\"]");

    // Transfer
    private OneAppElement TRANSFER_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Transfer");
    private OneAppElement OWN_TTB_ACCOUNT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "//XCUIElementTypeButton[@name=\"Account\"]");
    private OneAppElement SELECT_TRANSFER_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Button\"]");

    // Service
    private OneAppElement SERVICE_TITLE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Service\"])[1]");
    private OneAppElement DOCUMENTS_SERVICE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Documents");
    private OneAppElement SERVICE_APPLY_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Apply");
    private OneAppElement SERVICE_APPLY_DEPOSIT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Deposit\"]");
    private OneAppElement SERVICE_APPLY_CARD_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Card\"]");
    private OneAppElement SERVICE_APPLY_INVESTMENT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Investment\"]");
    private OneAppElement SERVICE_APPLY_PERSONAL_LOAN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Personal Loan\"]");
    private OneAppElement SERVICE_APPLY_AUTO_LOAN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Auto Loan\"]");
    private OneAppElement SERVICE_APPLY_INSURANCE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Insurance\"]");
    private OneAppElement SERVICE_STATUS_TRACKING_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Status Tracking");

    //Activation
    private OneAppElement REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Register ttb touch");
    private OneAppElement ACTIVATE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Activate\"]");
    private OneAppElement REGISTER_TTB_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Bottom sheet primary button\"]");
    private OneAppElement ACCEPT_TERM_AND_CON_CHECKBOX = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iconCheck");
    private OneAppElement TERM_AND_CON_NEXT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement INPUT_RM_FIELD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTable[@name=\"Fill in personal information\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField");
    private OneAppElement BOTTOMSHEET_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet title");
    private OneAppElement BOTTOMSHEET_DESCRIPTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet detail");
    private OneAppElement BOTTOMSHEET_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet primary button");
    private OneAppElement ENTER_CID_NEXT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement CANCEL_ENTER_PIN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Cancel\"]");
    private OneAppElement STEPPER_PROGRESS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "StepperProgress");
    private OneAppElement STEPPER_TITLE_SELECT_METHOD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Stepper Title\"]");
    private OneAppElement ACTIVATE_WITH_ACTIVATION_CODE_OPTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Register with activation code");
    private OneAppElement ACTIVATE_OPTION_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private OneAppElement STEPPER_TITLE_ACTIVATION_CODE_INFORMATION = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Stepper Title\"])");
    private OneAppElement ACTIVATION_WITH_CODE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Activation code information");
    private OneAppElement STEPPER_PROGRESS_ACTIVATION_WITH_CODE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"StepperProgress\"])");
    private OneAppElement ACTIVATION_WITH_CODE_FIELD = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Activation code");
    private OneAppElement ACTIVATION_WITH_CODE_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeButton[@name=\"Next\"])");
    private OneAppElement BOTTOMSHEET_TITLE_INCORRECT_ACTIVATION_CODE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Incorrect information");
    private OneAppElement BOTTOMSHEET_DESCRIPTION_INCORRECT_ACTIVATION_CODE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "You entered a wrong activation code. Please check and try again.");
    private OneAppElement BOTTOMSHEET_BUTTON_OK = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"OK\"]");
    private OneAppElement BOTTOMSHEET_BUTTON_LEAVE_PAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Leave Page\"]");
    private OneAppElement OTP_HEADER = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Register ttb touch");
    private OneAppElement ACTIVATE_PUSH_NOTIFICATION_TOGGLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch");
    private OneAppElement ACTIVATE_COMPLETE_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private OneAppElement ACTIVATE_CODE_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConChevronLeft 24px");
    private OneAppElement CANCEL_ACTIVATION_WITH_CODE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Cancel");
    private OneAppElement PIN_REQUIRE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"PIN requirements\"]");

    //OTP Screen
    private OneAppElement FIRST_OTP_INPUT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField1");

    // Account Summary
    private OneAppElement ACCOUNT_SUMMARY_PAGE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "My Account");
    private OneAppElement PRODUCT_INTRO_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Product intro title");
    private OneAppElement PRODUCT_INTRO_DESCRIPTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Product intro description");
    private OneAppElement ACCOUNT_SUMMARY_TAB_DEPOSIT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Deposit\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_TAB_CARD = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Card\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_TAB_INVESTMENT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Investment\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_TAB_LOAN = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Loan\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_TAB_INSURANCE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Insurance\"])[1]");

    //Product Introduction
    private OneAppElement PRODUCT_INTRODUCTION_IMAGE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/imageView");
    private OneAppElement PRODUCT_INTRODUCTION_TITLE = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textTitle");
    private OneAppElement PRODUCT_INTRODUCTION_CONTENT = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/textDescription");
    private OneAppElement PRODUCT_INTRODUCTION_BUTTON_CTA = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/buttonCTA");
    private OneAppElement PRODUCT_INTRODUCTION_HYPER_LINK1 = new OneAppElement(FindBy.ID, "com.ttbbank.oneapp.vit:id/hyperlink1");

    //Product Introduction Prospect
    private OneAppElement PRODUCT_INTRODUCTION_TITLE_PROSPECT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Product intro title\"]");
    private OneAppElement PRODUCT_INTRODUCTION_CONTENT_PROSPECT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Product intro description\"]");
    private OneAppElement PRODUCT_INTRODUCTION_BUTTON_CTA_PROSPECT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Register ttb touch\"]");
    private OneAppElement PRODUCT_INTRODUCTION_BACK_TERM_AND_CONDITION_PROSPECT = new OneAppElement(FindBy.ID, "iConChevronLeft 24px");
    private OneAppElement PRODUCT_INTRODUCTION_IMAGE_PROSPECT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage");

    //Account Summary Card
    private OneAppElement APPLY_NEW_CARD_WEBVIEW_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"บัตรเครดิต\"]");
    private OneAppElement APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON = new OneAppElement(FindBy.ID, "medium-chevron-left");
    private OneAppElement APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"สมัครบัตรกดเงินสด แฟลช\"]");


    private OneAppElement NEXT_INTRO_HONE_SCREEN_DEV479 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");

    //More
	private OneAppElement MORE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeOther/XCUIElementTypeButton[4]");
	private OneAppElement SETTING_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]");
	private OneAppElement LOGOUT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Log Out, Double tabs to logout");
	private OneAppElement CONFIRM_LOGOUT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet primary button");
    private OneAppElement CANCEL_LOGOUT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet socondary button");
    private OneAppElement WIDGET_LIBRARY_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton");
    private OneAppElement WIDGET_LIBRARY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Widgets Library");
    private OneAppElement APPLICATION_TRACKING_WIDGET_ITEM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Application Tracking");
    private OneAppElement TTB_PRODUCTS_WIDGET_ITEM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "All ttb products");
    private OneAppElement HIGHLIGHT_CAMPAIGN_WIDGET_ITEM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Highlight Campaign");
    private OneAppElement FUND_SEARCH_WIDGET_ITEM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Fund Search");
    private OneAppElement WIDGET_LIBRARY_BACK_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"BlueMedium24PxChevronLeft\"]");
    private OneAppElement MORE_HEADER_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Discover More");
    private OneAppElement BOTTOMSHEET_CARD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
    private OneAppElement APP_GUIDE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "App Guide, Double tabs to see more details");
    private OneAppElement CLOSE_APP_GUIDE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "closePin");
    private OneAppElement BOTTOMSHEET_APP_GUIDE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "วิธีการใช้งานแอป ttb touch");
    private OneAppElement MORE_TNC_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Terms and Conditions, Double tabs to see more details");
    private OneAppElement BACK_TNC_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "icon arrow left");
    private OneAppElement MORE_PRIVACY_SECURITY_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Privacy and Security, Double tabs to see more details");
    private OneAppElement BOTTOMSHEET_PRIVACY_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Privacy and Security");
    private OneAppElement BOTTOMSHEET_PRIVACY_X_ICON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "closePin");
    private OneAppElement MORE_HELP_SUPPORT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Help and Support, Double tabs to see more details");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ttb contact center");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"1428\"]");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Other Channels");

    private OneAppElement REGISTER_TTB_BUTTON_MORE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Register ttb touch\"]");
    private OneAppElement BUTTON_ADD_TO_HOMEPAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
    private OneAppElement REGISTER_TTB_BUTTON_WIDGET_LIRBARY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Register ttb touch\"]");
    private OneAppElement APP_GUIDE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "App Guide");
    private OneAppElement APP_GUIDE_START = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"เริ่มต้นใช้งาน\"]");
    private OneAppElement APP_GUIDE_REGISTER_AT_BRANCHES = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"สมัครผ่านสาขา\"]");
    private OneAppElement BUTTON_INSTALLED_WIDGET_LIBRARY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Installed");
    private OneAppElement SERVICE_PAGE_CONTACT_TTB_TAB = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Contact ttb");
    private OneAppElement MORE_LINKAGE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Privacy and Security");
    private OneAppElement BOTTOMSHEET_LOGIN_CLOSE_ICON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "closePin");

    // Deposit
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ALL_FREE_CARD = new OneAppElement(FindBy.ACCESSIBILITY_ID, "All Free Account Double tabs for more details");
    private OneAppElement ACCOUNT_DETAIL_DEPOSIT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Account Details\"]");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Account number\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Available balance number\"])[1]");
    private OneAppElement ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Total available balance");
    private OneAppElement ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Total balance");
    private OneAppElement ACCOUNT_DEPOSIT_SECOND_CARD = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Deposit account\"])[2]");
    private OneAppElement ACCOUNT_DEPOSIT_NAME_CARD = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Deposit account\"])[1]");
    private OneAppElement ACCOUNT_DEPOSIT_DETAIL_BACK = new OneAppElement(FindBy.ACCESSIBILITY_ID, "al-arrow-left");

	// Card
    private OneAppElement ACCOUNT_SUMMARY_CARD_PRI = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"productNickname\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_DETAIL_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Card\"]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_DETAIL_BACK = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");


    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_PENDING = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"PENDING ACTIVATION\"]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_NAME_PENDING = new OneAppElement(FindBy.ACCESSIBILITY_ID, "textProductTitlePending");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"accountNumber\"])[2]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Activate Card\"]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BTN_ENTER_CARD_NUMBER = new OneAppElement(FindBy.ACCESSIBILITY_ID, "aria-label-button");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BACK_BTN = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");

    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_BLOCK = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"cardStatus\"])[3]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"accountNumber\"])[4]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeOther[@name=\"creditSpendLabel\"])[4]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_AVAILABLE_BALANCE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"availableBalance\"])[4]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_TYPE_SUPPLEMENTARY = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"cardType\"])[4]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"cardStatus\"])[3]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"accountNumber\"])[5]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_AVAILABLE_BALANCE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"availableBalance\"])[5]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeOther[@name=\"creditSpendLabel\"])[5]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_SPENDING_THIS_BILL_LESS_THAN_ZERO = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeOther[@name=\"creditSpendLabel\"])[1]");
    private OneAppElement ACCOUNT_SUMMARY_CARD_AVAILABLE_TO_SPEND_LESS_THAN_ZERO = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeOther[@name=\"creditSpendLabel\"])[2]");

    //Login BottomSheet
    private OneAppElement PERSONALZIE_INTRO_NEXT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement BOTTOMSHEET_LOGIN_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Enter PIN");
    private OneAppElement BOTTOMSHEET_LOGIN_ERROR_INLINE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Login Error Inline");
    private OneAppElement PINLOCK_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Your PIN is locked");
    private OneAppElement OTP_TEXTFIELD_1 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField1");
    private OneAppElement OTP_TEXTFIELD_2 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField2");
    private OneAppElement OTP_TEXTFIELD_3 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField3");
    private OneAppElement OTP_TEXTFIELD_4 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField4");
    private OneAppElement OTP_TEXTFIELD_5 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField5");
    private OneAppElement OTP_TEXTFIELD_6 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTPTextField6");
    private OneAppElement TOAST_MSG = new OneAppElement(FindBy.XPATH, "//*[contains(@name, \"OTP code is successfully sent\")]");
    private OneAppElement OTP_REF_CODE = new OneAppElement(FindBy.XPATH, "//*[contains(@label, \"OTP Ref:\")]");
    private OneAppElement PINLOCK_RETURN_TO_HOME_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Return to Home\"]");
    //private OneAppElement TOAST_MSG = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTP code is successfully sent to your mobile number");
    private OneAppElement BOTTOMSHEET_LOGIN_0_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "0");
    private OneAppElement BOTTOMSHEET_LOGIN_1_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private OneAppElement BOTTOMSHEET_LOGIN_2_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "2");
    private OneAppElement BOTTOMSHEET_LOGIN_3_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "3");
    private OneAppElement BOTTOMSHEET_LOGIN_4_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "4");
    private OneAppElement BOTTOMSHEET_LOGIN_5_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "5");
    private OneAppElement BOTTOMSHEET_LOGIN_6_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "6");
    private OneAppElement BOTTOMSHEET_LOGIN_7_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "7");
    private OneAppElement BOTTOMSHEET_LOGIN_8_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "8");
    private OneAppElement BOTTOMSHEET_LOGIN_9_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "9");
    private OneAppElement MORE_TABS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "More");
    private OneAppElement SETTING_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Settings");
    private OneAppElement SETTING_CHANGE_PIN_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[9]");
    private OneAppElement CHANGE_PIN_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Change PIN");
    private OneAppElement CHANGE_PIN_1_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private OneAppElement CHANGE_PIN_2_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "2");
    private OneAppElement CHANGE_PIN_3_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "3");
    private OneAppElement CHANGE_PIN_4_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "4");
    private OneAppElement CHANGE_PIN_5_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "5");
    private OneAppElement CHANGE_PIN_6_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "6");
    private OneAppElement CHANGE_PIN_7_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "7");
    private OneAppElement CHANGE_PIN_8_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "8");
    private OneAppElement CHANGE_PIN_9_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "9");
    private OneAppElement CHANGE_PIN_0_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "0");
    private OneAppElement CHANGE_PIN_ERROR_INLINE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Error Inline");

    // Forgot Pin
    private OneAppElement BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Forgot PIN\"]");
    private OneAppElement STEPPER_TITLE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Stepper Title\"])[1]");
    private OneAppElement FORGOT_PIN_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back.");
    private OneAppElement BUTTON_PASSPORT_NO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTable[@name=\"Step 1 of 1, Step 1 of 1, Fill in personal information\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]");
    private OneAppElement BUTTON_CITIZEN_ID_NO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTable[@name=\"Step 1 of 1, Step 1 of 1, Fill in personal information\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
    private OneAppElement BUTTON_CITIZEN_ID_NO_WITH_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTable[@name=\"Fill in personal information\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
    private OneAppElement VERIFY_MOBILE_NUMBER_PROGRESS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Stepper Title");
    private OneAppElement RESEND_OTP_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Resend OTP\"]");
    private OneAppElement CANCEL_OTP_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Cancel\"]");
    private OneAppElement STAY_ON_PAGE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet socondary button");
    private OneAppElement CANCEL_BOTTOM_SHEET_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet title");
    private OneAppElement CANCEL_BOTTOM_SHEET_DETAIL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet detail");
    private OneAppElement LEAVE_PAGE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet primary button");
    private OneAppElement OTP_ERROR_INLINE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTP Error Inline");
    private OneAppElement OTP_ATTEMPT_LIMIT_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OTP attempt limit reached");
    private OneAppElement OTP_ATTEMPT_LIMIT_DETAIL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "You have reached the maximum number of attempts. Please try again later.");
    private OneAppElement KEYBOARD_DONE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Done");
    private OneAppElement SET_NEW_PIN_REQUIREMENTS_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "PIN Requirements");
    private OneAppElement BOTTOMSHEET_BUTTON_SECOND = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet socondary button");
    private OneAppElement HOME_TAB = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Home\"]");
    private OneAppElement CHANGE_PIN_SUCCESS_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "PIN Successfully Changed");
    private OneAppElement CHANGE_PIN_SUCCESS_OK_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Return to Home\"]");

    // Change Pin
    private OneAppElement CHANGE_PIN_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConChevronLeft 24px");
    private OneAppElement SETTING_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back. Double tabs to activate");
    private OneAppElement CHANGE_PIN_SUB_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Sub title");
    private OneAppElement CHANGE_PIN_FORGOT_PIN_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Forgot PIN");
    private OneAppElement CHANGE_PIN_CANCEL_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Cancel\"]");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet title");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet primary button");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Close.");
    private OneAppElement CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bottom sheet socondary button");
    private OneAppElement CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "//XCUIElementTypeButton[@name=\"Continue Setting\"]");

    // Settings
    private OneAppElement BIOMETRIC_SWITCH = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[11]/XCUIElementTypeSwitch");
    private OneAppElement BIOMETRIC_SCAN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\" \"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther");
    private OneAppElement BOTTOMSHEET_LOGIN_BIOMETRIC_BUTTON = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeButton[@name=\"btn1\"])[10]");
    private OneAppElement SETTING_SEARCH_INPUT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private OneAppElement SETTING_PROFILE_IMAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name='OneApp']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    private OneAppElement SETTING_PROFILE_NAME = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Profile name");
    private OneAppElement SETTING_MOBILE_NO_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[1]");
    private OneAppElement SETTING_EMAIL_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[2]");
    private OneAppElement SETTING_CURRENT_ADDRESS_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[3]");
    private OneAppElement SETTING_INTERNATIONAL_TRANSFER_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[4]");
    private OneAppElement SETTING_MOBILE_NO = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[1]");
    private OneAppElement SETTING_EMAIL_DETAIL = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[2]");
    private OneAppElement SETTING_EMAIL_VERIFY_STATUS = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"toggle detail\"])[2]");
    private OneAppElement SETTING_APPLICATION_SECTION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Application\"]");
    private OneAppElement SETTING_FAVORITES_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[11]");
    private OneAppElement SETTING_MANAGE_HOMEPAGE_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[12]");
    private OneAppElement SETTING_NOTIFICATIONS_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[13]");
    private OneAppElement SETTING_QUICK_BALANCE_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[14]");
    private OneAppElement SETTING_QUICK_BALANCE_TOGGLE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"toggle detail\"])[13]");
    private OneAppElement QUICK_BALANCE_ENABLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Enable Quick Balance");
	private OneAppElement QUICK_BALANCE_SHOW_BALANCE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Show Balance on Homepage");
	private OneAppElement QUICK_BALANCE_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back. Double tabs to activate");
    private OneAppElement QUICK_BALANCE_ENABLE_TOGGLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeSwitch[@name=\"Enable Quick Balance Double tabs to activate\"]");
    private OneAppElement QUICK_BALANCE_CONFIRM_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Confirm Double tabs to activate");
    private OneAppElement SETTING_AUTO_SAVE_SLIP_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[15]");
    private OneAppElement SETTING_CHANGE_LANGUAGE_MENU = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[17]/XCUIElementTypeOther[3]");
    private OneAppElement SETTING_CHANGE_LANGUAGE_VALUE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"toggle detail\"])[15]");
    private OneAppElement CHANGE_LANG_THAI_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ภาษาไทย");
    private OneAppElement CHANGE_LANG_ENG_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "English");
    private OneAppElement CHANGE_LANG_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
    private OneAppElement SETTING_SECURITY_SECTION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Security\"]");
    private OneAppElement SETTING_ACCOUNT_AND_CARD_SECTION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Account and Card\"]");
    private OneAppElement SETTING_MANAGE_ACCOUNT_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[5]");
	private OneAppElement SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]");
	private OneAppElement SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[2]");
	private OneAppElement SETTING_MANAGE_ACCOUNT_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
    private OneAppElement SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private OneAppElement SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_SHOW_ACCOUNT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Account shown. This account will be displayed or used to perform any transactions on ttb touch.");
    private OneAppElement SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_HIDDEN_ACCOUNT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Account hidden. This account will not be displayed or used to perform any transactions on ttb touch.");
    private OneAppElement SETTING_DAILY_TRANSACTION_LIMIT_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[6]");
    private OneAppElement SETTING_PIN_FREE_MENU = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Title setting\"])[7]");
    private OneAppElement SETTING_PAY_WITH_WOW_MENU = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Pay with wow");
    private OneAppElement SETTING_PIN_FREE_FLAG = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"toggle detail\"])[7]");
    private OneAppElement SETTING_PIN_FREE_NOT_ALLOW_RADIO = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Not Allow");
    private OneAppElement SETTING_PIN_FREE_SAVE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Save");
    private OneAppElement SETTING_PIN_FREE_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");
    private OneAppElement SETTING_PIN_FREE_ALLOW_RADIO = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Allow");
    private OneAppElement SETTING_BIOMETRIC_MENU = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Log-in with Biometric");
    private OneAppElement SETTING_PIN_FREE_BACK_TO_HOME_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back to Home");
    private OneAppElement SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Continue to Settings");
    private OneAppElement SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Confirm");
    private OneAppElement SEARCH_SETTINGS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private OneAppElement SETTING_INDEX_0 = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[1]");
    private OneAppElement SETTING_INDEX_1 = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[2]");
    private OneAppElement SETTING_INDEX_4 = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[5]");
    private OneAppElement SETTING_INDEX_5 = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[6]");
    private OneAppElement SETTING_INDEX_6 = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Detail setting list\"])[7]");
    private OneAppElement SEARCH_SETTINGS_DELETE_WORD = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConClose 16px");
    private OneAppElement SETTING_SEARCH_INPUT_X_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConClose 16px");
    private OneAppElement SEARCH_SETTINGS_NO_RESULT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "No results found");
    private OneAppElement SETTING_QUICK_BALANCE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Quick Balance");
    private OneAppElement QUICK_BALANCE_SHOW_BALANCE_TOGGLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeSwitch[@name=\"Show Balance on Homepage Double tabs to activate\"]");
    private OneAppElement QUICK_BALANCE_FIRST_ACCOUNT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Quick balance account\"])[1]");
    private OneAppElement MANAGE_ACCOUNT_HIDDEN_ACCOUNT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "HIDDEN ACCOUNT");
    private OneAppElement SETTING_SEARCH_CLEAR_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConClose 16px");

    // International Address
    private OneAppElement INTERNATIONAL_ADDRESS_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "International Transfer");
    private OneAppElement INTERNATIONAL_ADDRESS_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Yes");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Confirm Address\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_HOUSE_NO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"House No.*\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_ROOM_NO = new OneAppElement(FindBy.XPATH, "///XCUIElementTypeStaticText[@name=\"Room No\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_FLOOR = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Floor\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_MOO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Moo\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_SOI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Soi\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_VILLAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Village/Building\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_ROAD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Road\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_ZIP_CODE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Zip Code*\"]");
    private OneAppElement INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Khlong Kum Bueng Kum Bangkok 10230");
    private OneAppElement INTERNATIONAL_ADDRESS_CONFIRM_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Confirm");
    private OneAppElement INTERNATIONAL_ADDRESS_EDIT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Edit");

    // Daily limit
    private OneAppElement DAILY_TRANSACTION_LIMIT_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Daily Transaction Limit");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeTextField[1]");
    private OneAppElement DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeTextField[2]");
    private OneAppElement DAILY_TRANSACTION_LIMIT_SAVE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Save");
    private OneAppElement DAILY_TRANSACTION_LIMIT_BACK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "medium-chevron-left");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DOMESTIC = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Limit for Domestic Transaction");
    private OneAppElement DAILY_TRANSACTION_LIMIT_INTERNATIONAL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Limit for International Transaction");
    private OneAppElement DAILY_TRANSACTION_LIMIT_DETAIL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "You can set up your daily limit for domestic and international transaction separately.");

    // Pin free
    private OneAppElement PIN_FREE_TRANSACTION_LIMIT_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "PIN-Free Transaction Limit");
    private OneAppElement PIN_FREE_TRANSACTION_LIMIT_DETAIL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Quickly and conveniently make a payment of lower than 5,000 baht without entering PIN.");


	private OneAppElement APP_GUIDE= new OneAppElement(FindBy.ACCESSIBILITY_ID, "App Guide, Double tabs to see more details");
    private OneAppElement TERMS_AND_CONDITIONS= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Terms and Conditions, Double tabs to see more details");
    private OneAppElement PRIVACY_AND_SECURITY= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Privacy and Security, Double tabs to see more details");
    private OneAppElement HELP_AND_SUPPPORT= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Help and Support, Double tabs to see more details");
    private OneAppElement MORE_LINKAGE_CLOSE= new OneAppElement(FindBy.ACCESSIBILITY_ID, "closePin");
    private OneAppElement MORE_LINKAGE_BACK= new OneAppElement(FindBy.ACCESSIBILITY_ID, "icon arrow left");
    private OneAppElement HELP_AND_SUPPPORT_VERIFY= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Services\"]");
    private OneAppElement HELP_AND_SUPPPORT_NEXT= new OneAppElement(FindBy.XPATH,"//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");


	private OneAppElement KYC_PAGE_MISSING_DETAILS= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ปรับปรุงรายละเอียดให้สมบูรณ์\"]");
	private OneAppElement KYC_PAGE_REQUIRED_FILED= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ข้อมูลที่จำเป็นต้องมี\"]");
	private OneAppElement NO_INTERNET_CONNECTION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name='No internet connection found']");
	private OneAppElement NO_INTERNET_CONNECTION_OK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OK");
	private OneAppElement GENERIC_ERROR_TITLE= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name='Unable to proceed further']");
	private OneAppElement GENERIC_ERROR_BODY= new OneAppElement(FindBy.ACCESSIBILITY_ID, "We cannot proceed with your request right now, sorry for your inconvenience. For additional information, please call us on 1428.");
	private OneAppElement GENERIC_ERROR_OK= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"OK\"]");

	private OneAppElement LANGUAGE_BUTTON= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Language");
	private OneAppElement LANGUAGE_BUTTON_THAI= new OneAppElement(FindBy.ACCESSIBILITY_ID, "ภาษา");
	private OneAppElement SELECT_LANGUAGE_PAGE= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Select Your Application Language");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM= new OneAppElement(FindBy.ACCESSIBILITY_ID, "กรุณาเลือกภาษาสำหรับแอปพลิเคชัน");
	private OneAppElement SELECT_LANGUAGE_BACKBUTTON= new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2= new OneAppElement(FindBy.ACCESSIBILITY_ID, "ภาษา");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2= new OneAppElement(FindBy.ACCESSIBILITY_ID, "English");
	private OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back.");
	private OneAppElement LOGGOUT_BUTTON_THAI= new OneAppElement(FindBy.ACCESSIBILITY_ID, "ออกจากระบบ");
	private OneAppElement LOGGOUT_BUTTON_OK_THAI= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ตกลง\"]");
	private OneAppElement LOGGOUT_BUTTON= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Log Out");
	private OneAppElement LOGGOUT_BUTTON_OK= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"OK\"]");
	private OneAppElement MANAGE_ACCOUNT_BACK_BUTTON= new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");

    //Lending
    private OneAppElement LENDING_CASH_FOR_YOU_BUTTON = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Cash for you\"])[1]");
    private OneAppElement LENDING_NEXT_CASH_FOR_YOU_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next");
    private OneAppElement LENDING_AMOUNT_CASH_FOR_YOU_INPUT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeTextField");
    private OneAppElement LENDING_CASH_TRANSFER_PAYMENT_OPTION = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Full/ Minimum/ Partial payment");

    // IT4IT

	private OneAppElement MORE_TAB = new OneAppElement(FindBy.ACCESSIBILITY_ID, "More");
	private OneAppElement MORE_TAB_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"อื่นๆ\"]");
	private OneAppElement SETTING_TAB = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"Settings, Double tabs to see more details\"]");
	private OneAppElement SETTING_TAB_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"ตั้งค่า, แตะสองครั้งเพื่อดูข้อมูลเพิ่มเติม\"]");
	private OneAppElement EXISTING_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"087-696-7496\"]");
	private OneAppElement KYC_PAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ตรวจสอบข้อมูลส่วนตัวของคุณ\"]");
	private OneAppElement KYC_PAGE_DETAILS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"รายละเอียดทั้งหมด\"]");
	private OneAppElement KYC_PAGE_DETAILS_BOTTOM = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ยืนยันข้อมูลทั้งหมดถูกต้อง\"]");
	private OneAppElement KYC_PAGE_DETAILS_BOTTOM_LATER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ต้องการทำภายหลัง\"]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE= new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeButton[@name=\"แก้ไข\"])[8]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"แก้ไขรายละเอียด\"]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"เบอร์โทรศัพท์มือถือ\"]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ปรับปรุงข้อมูล\"]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ติดตามสถานะการสมัคร\"]");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT= new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeTextField[@name=\"One time password input\"])");
	private OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG= new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"รหัส OTP ไม่ถูกต้อง ลองใหม่ได้อีก 2 ครั้ง\"]");

    // Pin Lock
    private OneAppElement PINLOCK_RESET_PIN_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Reset PIN\"]");
    private OneAppElement BUTTON_BACK_VERIFY_PERSONAL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back.");

    //Activate Complete Screen
    private OneAppElement COMPLETE_SCREEN_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Welcome to ttb touch");
    private OneAppElement COMPLETE_SCREEN_SUBTITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Your application is now ready to use.");

    private HashMap<String, OneAppElement> oneAppElementHashMap = new HashMap<>();

    public iOSOneAppElements() {
        AutoLoaniOSOneAppElements.init(oneAppElementHashMap);
        CustomerServiceiOSOneAppElements.init(oneAppElementHashMap);
        InvestmentiOSOneAppElements.init(oneAppElementHashMap);
        It4ItiOSOneAppElements.init(oneAppElementHashMap);
        LendingiOSOneAppElements.init(oneAppElementHashMap);
        Pb1iOSOneAppElements.init(oneAppElementHashMap);
        Pb2iOSOneAppElements.init(oneAppElementHashMap);
        ProtectioniOSOneAppElements.init(oneAppElementHashMap);
        Pb3iOSOneAppElements.init(oneAppElementHashMap);
        Pb7iOSOneAppElements.init(oneAppElementHashMap);

		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_TITLE, GENERIC_ERROR_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_BODY, GENERIC_ERROR_BODY);
		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_OK, GENERIC_ERROR_OK);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB, REGISTER_TTB);
		oneAppElementHashMap.put(OneAppElementKeys.AGGREE_TC, AGGREE_TC);
		oneAppElementHashMap.put(OneAppElementKeys.TC_NEXT, TC_NEXT);
		oneAppElementHashMap.put(OneAppElementKeys.CITIZEN_ID, CITIZEN_ID);
		oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE, QUICK_BALANCE);
		oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_THAI, QUICK_BALANCE_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON_THAI, LOGGOUT_BUTTON_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON_OK_THAI, LOGGOUT_BUTTON_OK_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_SUCCESSFULL, REGISTER_SUCCESSFULL);
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
		oneAppElementHashMap.put(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2, SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2);
		oneAppElementHashMap.put(OneAppElementKeys.MANAGE_ACCOUNT_BACK_BUTTON, MANAGE_ACCOUNT_BACK_BUTTON);

		oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE, APP_GUIDE);
        oneAppElementHashMap.put(OneAppElementKeys.TERMS_AND_CONDITIONS, TERMS_AND_CONDITIONS);
        oneAppElementHashMap.put(OneAppElementKeys.PRIVACY_AND_SECURITY, PRIVACY_AND_SECURITY);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT, HELP_AND_SUPPPORT);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_CLOSE, MORE_LINKAGE_CLOSE);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_BACK, MORE_LINKAGE_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT_VERIFY, HELP_AND_SUPPPORT_VERIFY);
        oneAppElementHashMap.put(OneAppElementKeys.HELP_AND_SUPPPORT_NEXT, HELP_AND_SUPPPORT_NEXT);

		oneAppElementHashMap.put(OneAppElementKeys.NO_INTERNET_CONNECTION, NO_INTERNET_CONNECTION);
		oneAppElementHashMap.put(OneAppElementKeys.NO_INTERNET_CONNECTION_OK_BUTTON, NO_INTERNET_CONNECTION_OK_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CITIZEN_ID_NEXT, CITIZEN_ID_NEXT);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_ENTERPIN, REGISTER_ENTERPIN);
		oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_MISSING_DETAILS, KYC_PAGE_MISSING_DETAILS);
		oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_REQUIRED_FILED, KYC_PAGE_REQUIRED_FILED);
		oneAppElementHashMap.put(OneAppElementKeys.ENTER_OTP_REGISTER, ENTER_OTP_REGISTER);
		oneAppElementHashMap.put(OneAppElementKeys.SAUCELAB_BUTTON, SAUCELABS_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.DEVICE_ID_INPUT, DEVICE_ID_INPUT);
		oneAppElementHashMap.put(OneAppElementKeys.SKIP_INTRO_HOME_SCREEN_BUTTON, SKIP_INTRO_HOME_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HOME_SCREEN_BUTTON, NEXT_INTRO_HOME_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SAVE_DEVICE_ID_BUTTON, SAVE_DEVICE_ID_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.PIN_0_BUTTON, PIN_0_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.PIN_1_BUTTON, PIN_1_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.PIN_2_BUTTON, PIN_2_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.PIN_3_BUTTON, PIN_3_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_BUTTON, ACCOUNT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SKIP_INTRO_BUTTON, SKIP_INTRO_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON, NEXT_INTRO_HONE_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HOME_SCREEN_BUTTON_DEV, NEXT_INTRO_HOME_SCREEN_BUTTON_DEV);
		oneAppElementHashMap.put(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON, DEPOSIT_HOME_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_ACCOUNT_SCREEN_BUTTON, NEXT_INTRO_ACCOUNT_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_BUTTON, SERVICE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_SERVICE_SCREEN_BUTTON_DEV, NEXT_INTRO_SERVICE_SCREEN_BUTTON_DEV);
		oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CONDITION, TERM_AND_CONDITION);
		oneAppElementHashMap.put(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON, CARD_HOME_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CARD_ITEM_0_HOME_SCREEN_BUTTON, CARD_ITEM_0_HOME_SCREEN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.GO_HOME_PROSPECT, GO_HOME_PROSPECT);


        oneAppElementHashMap.put(OneAppElementKeys.INTRO_HOME_SCREEN_NEXT_BUTTON, INTRO_HOME_SCREEN_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_TAB, ACCOUNT_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_INTRO_SKIP_BUTTON, ACCOUNT_INTRO_SKIP_BUTTON);
        // Home Screen
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
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_START_BUTTON, APPLICATION_TRACKING_START_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_BACK_BUTTON, APPLICATION_TRACKING_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_TITLE, APPLICATION_TRACKING_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.TTB_PRODUCTS_WIDGET, TTB_PRODUCTS_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.TTB_PRODUCTS_FUND_SEARCH_WIDGET, TTB_PRODUCTS_FUND_SEARCH_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET, HIGHLIGHT_CAMPAIGN_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.EXPAND_QUICK_ACTION_BUTTON, EXPAND_QUICK_ACTION_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.COLLAPSE_QUICK_ACTION_BUTTON, COLLAPSE_QUICK_ACTION_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_TITLE_REGISTER, BOTTOMSHEET_TITLE_REGISTER);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_REGISTER, BOTTOMSHEET_DESCRIPTION_REGISTER);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_WIDGET_TITLE, QUICK_BALANCE_WIDGET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_WIDGET_DESCRIPTION, QUICK_BALANCE_WIDGET_DESCRIPTION);
        oneAppElementHashMap.put(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON, TERMS_AND_CONDITIONS_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOMEPAGE_BUTTON, MANAGE_HOMEPAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PERSONALIZED_SCREEN_NEXT_BUTTON, PERSONALIZED_SCREEN_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PERSONALIZED_SCREEN, PERSONALIZED_SCREEN);
        oneAppElementHashMap.put(OneAppElementKeys.BACKGROUND_HOME_SCREEN, BACKGROUND_HOME_SCREEN);


        // Home Screen Quick Balance
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_DETAIL_TO_ENABLE, QUICK_BALANCE_DETAIL_TO_ENABLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ACTIVATE_BUTTON, QUICK_BALANCE_ACTIVATE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_TITLE, QUICK_BALANCE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_PRODUCT_NAME_WIDGET, QUICK_BALANCE_PRODUCT_NAME_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET, QUICK_BALANCE_ACCOUNT_NUMBER_WIDGET);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_VIEW_BALANCE_BUTTON, QUICK_BALANCE_VIEW_BALANCE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_BUTTON, QUICK_BALANCE_SHOW_BALANCE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DETAIL_BACK_BUTTON, ACCOUNT_DETAIL_BACK_BUTTON);

		//Confirm PIN (Support Investment)
		oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, CONFIRM_PIN_0_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_1_BUTTON, CONFIRM_PIN_1_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_2_BUTTON, CONFIRM_PIN_2_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_PIN_3_BUTTON, CONFIRM_PIN_3_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON, ALLOW_NOTIFICATION_HOME_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON, NEXT_INTRO_HOME_BUTTON);

		oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_TH_LANGUAGE, TERM_AND_CON_BUTTON_CHANGE_TH_LANGUAGE);
		oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_BUTTON_CHANGE_EN_LANGUAGE, TERM_AND_CON_BUTTON_CHANGE_EN_LANGUAGE);

        // Manage widget
        oneAppElementHashMap.put(OneAppElementKeys.HOME_WIDGETS_LIST, HOME_WIDGETS_LIST);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_EDIT_WIDGET_HOME, MANAGE_HOME_EDIT_WIDGET_HOME);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_ADD_WIDGET_BUTTON, MANAGE_HOME_ADD_WIDGET_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_TITLE, MANAGE_HOME_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_BUTTON_SAVE, MANAGE_HOME_BUTTON_SAVE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_BACK_BUTTON, MANAGE_HOME_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_ICON_DELETE, MANAGE_HOME_ICON_DELETE);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_HOME_LIST_WIDGET_LIBRARY, MANAGE_HOME_LIST_WIDGET_LIBRARY);

        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON, BOTTOMSHEET_CLOSE_BUTTON);

		// Top Up Screen
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_AIS_BUTTON, TOP_UP_AIS_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_MOBILE_NUMBER_TEXT_FIELDS, TOP_UP_MOBILE_NUMBER_TEXT_FIELDS);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_10_AMOUNT_BUTTON, TOP_UP_10_AMOUNT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_NEXT_BUTTON, TOP_UP_NEXT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_CONFIRM_BUTTON, TOP_UP_CONFIRM_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_CONFIRM_BACK_BUTTON, TOP_UP_CONFIRM_BACK_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.TOP_UP_BACK_BUTTON, TOP_UP_BACK_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SELECT_TOP_UP_BACK_BUTTON, SELECT_TOP_UP_BACK_BUTTON);

		// Transfer
		oneAppElementHashMap.put(OneAppElementKeys.TRANSFER_TITLE, TRANSFER_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.OWN_TTB_ACCOUNT_BUTTON, OWN_TTB_ACCOUNT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SELECT_TRANSFER_BACK_BUTTON, SELECT_TRANSFER_BACK_BUTTON);

		//Service
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_TITLE, SERVICE_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.DOCUMENTS_SERVICE_BUTTON, DOCUMENTS_SERVICE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_BUTTON, SERVICE_APPLY_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_DEPOSIT_BUTTON, SERVICE_APPLY_DEPOSIT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_CARD_BUTTON, SERVICE_APPLY_CARD_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_INVESTMENT_BUTTON, SERVICE_APPLY_INVESTMENT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_PERSONAL_LOAN_BUTTON, SERVICE_APPLY_PERSONAL_LOAN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_AUTO_LOAN_BUTTON, SERVICE_APPLY_AUTO_LOAN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_APPLY_INSURANCE_BUTTON, SERVICE_APPLY_INSURANCE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_STATUS_TRACKING_BUTTON, SERVICE_STATUS_TRACKING_BUTTON);

		//Activation
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION, REGISTER_TTB_BUTTON_ON_PRODUCT_INTRODUCTION);
		oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_BUTTON, ACTIVATE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON, REGISTER_TTB_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX, ACCEPT_TERM_AND_CON_CHECKBOX);
		oneAppElementHashMap.put(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON, TERM_AND_CON_NEXT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.INPUT_RM_FIELD, INPUT_RM_FIELD);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_TITLE, BOTTOMSHEET_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION, BOTTOMSHEET_DESCRIPTION);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON, BOTTOMSHEET_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.ENTER_CID_NEXT_BUTTON, ENTER_CID_NEXT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CANCEL_ENTER_PIN, CANCEL_ENTER_PIN);
		oneAppElementHashMap.put(OneAppElementKeys.STEPPER_PROGRESS, STEPPER_PROGRESS);
		oneAppElementHashMap.put(OneAppElementKeys.STEPPER_TITLE_SELECT_METHOD, STEPPER_TITLE_SELECT_METHOD);
		oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_WITH_ACTIVATION_CODE_OPTION, ACTIVATE_WITH_ACTIVATION_CODE_OPTION);
		oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_OPTION_NEXT_BUTTON, ACTIVATE_OPTION_NEXT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_TITLE_INCORRECT_ACTIVATION_CODE, BOTTOMSHEET_TITLE_INCORRECT_ACTIVATION_CODE);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_INCORRECT_ACTIVATION_CODE, BOTTOMSHEET_DESCRIPTION_INCORRECT_ACTIVATION_CODE);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON_OK, BOTTOMSHEET_BUTTON_OK);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON_LEAVE_PAGE, BOTTOMSHEET_BUTTON_LEAVE_PAGE);
		oneAppElementHashMap.put(OneAppElementKeys.OTP_HEADER, OTP_HEADER);
		oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_PUSH_NOTIFICATION_TOGGLE, ACTIVATE_PUSH_NOTIFICATION_TOGGLE);
		oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON, ACTIVATE_COMPLETE_NEXT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_DEV479, NEXT_INTRO_HONE_SCREEN_DEV479);

        //Activate Code
        oneAppElementHashMap.put(OneAppElementKeys.STEPPER_PROGRESS_ACTIVATION_WITH_CODE, STEPPER_PROGRESS_ACTIVATION_WITH_CODE);
        oneAppElementHashMap.put(OneAppElementKeys.STEPPER_TITLE_ACTIVATION_CODE_INFORMATION, STEPPER_TITLE_ACTIVATION_CODE_INFORMATION);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_TITLE, ACTIVATION_WITH_CODE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_FIELD, ACTIVATION_WITH_CODE_FIELD);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATION_WITH_CODE_NEXT_BUTTON, ACTIVATION_WITH_CODE_NEXT_BUTTON);

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


        //Account Summary Card Detail
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_TITLE, APPLY_NEW_CARD_WEBVIEW_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON, APPLY_NEW_CARD_WEBVIEW_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON, APPLY_FLASH_CASH_CARD_WEBVIEW_BUTTON);

        // More
		oneAppElementHashMap.put(OneAppElementKeys.CANCEL_LOGOUT_BUTTON, CANCEL_LOGOUT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_BUTTON, WIDGET_LIBRARY_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY, WIDGET_LIBRARY);
		oneAppElementHashMap.put(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM, APPLICATION_TRACKING_WIDGET_ITEM);
		oneAppElementHashMap.put(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM, TTB_PRODUCTS_WIDGET_ITEM);
		oneAppElementHashMap.put(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM, HIGHLIGHT_CAMPAIGN_WIDGET_ITEM);
		oneAppElementHashMap.put(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM, FUND_SEARCH_WIDGET_ITEM);
		oneAppElementHashMap.put(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON, WIDGET_LIBRARY_BACK_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_HEADER_TITLE, MORE_HEADER_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_CARD, BOTTOMSHEET_CARD);
		oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_BUTTON, APP_GUIDE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.CLOSE_APP_GUIDE_BUTTON, CLOSE_APP_GUIDE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_APP_GUIDE, BOTTOMSHEET_APP_GUIDE);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_TNC_BUTTON, MORE_TNC_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.BACK_TNC_BUTTON, BACK_TNC_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON, MORE_PRIVACY_SECURITY_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE, BOTTOMSHEET_PRIVACY_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON, BOTTOMSHEET_PRIVACY_X_ICON);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_HELP_SUPPORT_BUTTON, MORE_HELP_SUPPORT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TITLE, SERVICE_PAGE_CONTACT_TTB_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER, SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS, SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_MORE, REGISTER_TTB_BUTTON_MORE);
		oneAppElementHashMap.put(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE, BUTTON_ADD_TO_HOMEPAGE);
		oneAppElementHashMap.put(OneAppElementKeys.REGISTER_TTB_BUTTON_WIDGET_LIRBARY, REGISTER_TTB_BUTTON_WIDGET_LIRBARY);
		oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_TITLE, APP_GUIDE_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_START, APP_GUIDE_START);
		oneAppElementHashMap.put(OneAppElementKeys.APP_GUIDE_REGISTER_AT_BRANCHES, APP_GUIDE_REGISTER_AT_BRANCHES);
		oneAppElementHashMap.put(OneAppElementKeys.BUTTON_INSTALLED_WIDGET_LIBRARY, BUTTON_INSTALLED_WIDGET_LIBRARY);
        oneAppElementHashMap.put(OneAppElementKeys.ACTIVATE_CODE_BACK_BUTTON, ACTIVATE_CODE_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_ACTIVATION_WITH_CODE, CANCEL_ACTIVATION_WITH_CODE);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_REQUIRE_BUTTON, PIN_REQUIRE_BUTTON);

        //OTP Screen
        oneAppElementHashMap.put(OneAppElementKeys.FIRST_OTP_INPUT, FIRST_OTP_INPUT);

        // Account Summary
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_PAGE_TITLE, ACCOUNT_SUMMARY_PAGE_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRO_TITLE, PRODUCT_INTRO_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.PRODUCT_INTRO_DESCRIPTION, PRODUCT_INTRO_DESCRIPTION);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_DEPOSIT, ACCOUNT_SUMMARY_TAB_DEPOSIT);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_CARD, ACCOUNT_SUMMARY_TAB_CARD);

        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INVESTMENT, ACCOUNT_SUMMARY_TAB_INVESTMENT);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_LOAN, ACCOUNT_SUMMARY_TAB_LOAN);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_TAB_INSURANCE, ACCOUNT_SUMMARY_TAB_INSURANCE);

        oneAppElementHashMap.put(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TAB, SERVICE_PAGE_CONTACT_TTB_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_LINKAGE_TITLE, MORE_LINKAGE_TITLE);

		// Deposit
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ALL_FREE_CARD, ACCOUNT_SUMMARY_DEPOSIT_ALL_FREE_CARD);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DETAIL_DEPOSIT, ACCOUNT_DETAIL_DEPOSIT);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_NUMBER);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE, ACCOUNT_SUMMARY_DEPOSIT_ACCOUNT_BALANCE);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT, ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_TEXT);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE, ACCOUNT_DEPOSIT_TOTAL_AVAILABLE_BALANCE);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_SECOND_CARD, ACCOUNT_DEPOSIT_SECOND_CARD);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_NAME_CARD, ACCOUNT_DEPOSIT_NAME_CARD);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_DEPOSIT_DETAIL_BACK, ACCOUNT_DEPOSIT_DETAIL_BACK);

		// Card
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_PRI, ACCOUNT_SUMMARY_CARD_PRI);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_DETAIL_TITLE, ACCOUNT_SUMMARY_CARD_DETAIL_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_DETAIL_BACK, ACCOUNT_SUMMARY_CARD_DETAIL_BACK);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING, ACCOUNT_SUMMARY_CARD_STATUS_PENDING);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_NAME_PENDING, ACCOUNT_SUMMARY_CARD_NAME_PENDING);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACCOUNT_NUMBER, ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_TITLE, ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BTN_ENTER_CARD_NUMBER, ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BTN_ENTER_CARD_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BACK_BTN, ACCOUNT_SUMMARY_CARD_STATUS_PENDING_ACTIVATE_CARD_BACK_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK, ACCOUNT_SUMMARY_CARD_STATUS_BLOCK);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_ACCOUNT_NUMBER, ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL, ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_CREDIT_SPEND_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_AVAILABLE_BALANCE, ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_AVAILABLE_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_TYPE_SUPPLEMENTARY, ACCOUNT_SUMMARY_CARD_STATUS_BLOCK_TYPE_SUPPLEMENTARY);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED, ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_ACCOUNT_NUMBER, ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_AVAILABLE_BALANCE, ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_AVAILABLE_BALANCE);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL, ACCOUNT_SUMMARY_CARD_STATUS_TEM_LOCKED_CREDIT_SPEND_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_SPENDING_THIS_BILL_LESS_THAN_ZERO, ACCOUNT_SUMMARY_CARD_SPENDING_THIS_BILL_LESS_THAN_ZERO);
        oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_SUMMARY_CARD_AVAILABLE_TO_SPEND_LESS_THAN_ZERO, ACCOUNT_SUMMARY_CARD_AVAILABLE_TO_SPEND_LESS_THAN_ZERO);

        //Login BottomSheet
        oneAppElementHashMap.put(OneAppElementKeys.PERSONALZIE_INTRO_NEXT_BUTTON, PERSONALZIE_INTRO_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_TITLE, BOTTOMSHEET_LOGIN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_ERROR_INLINE, BOTTOMSHEET_LOGIN_ERROR_INLINE);
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_TITLE, PINLOCK_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_1, OTP_TEXTFIELD_1);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_2, OTP_TEXTFIELD_2);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_3, OTP_TEXTFIELD_3);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_4, OTP_TEXTFIELD_4);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_5, OTP_TEXTFIELD_5);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_TEXTFIELD_6, OTP_TEXTFIELD_6);
        oneAppElementHashMap.put(OneAppElementKeys.TOAST_MSG, TOAST_MSG);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_REF_CODE, OTP_REF_CODE);
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_RETURN_TO_HOME_BUTTON, PINLOCK_RETURN_TO_HOME_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_0_BUTTON, BOTTOMSHEET_LOGIN_0_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_1_BUTTON, BOTTOMSHEET_LOGIN_1_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_2_BUTTON, BOTTOMSHEET_LOGIN_2_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_3_BUTTON, BOTTOMSHEET_LOGIN_3_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_4_BUTTON, BOTTOMSHEET_LOGIN_4_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_5_BUTTON, BOTTOMSHEET_LOGIN_5_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_6_BUTTON, BOTTOMSHEET_LOGIN_6_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_7_BUTTON, BOTTOMSHEET_LOGIN_7_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_8_BUTTON, BOTTOMSHEET_LOGIN_8_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_9_BUTTON, BOTTOMSHEET_LOGIN_9_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.MORE_TABS, MORE_TABS);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_TITLE, SETTING_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_PIN_MENU, SETTING_CHANGE_PIN_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_TITLE, CHANGE_PIN_TITLE);
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
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_ERROR_INLINE, CHANGE_PIN_ERROR_INLINE);

        // Forgot Pin
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON, BOTTOMSHEET_LOGIN_FORGOT_PIN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.STEPPER_TITLE, STEPPER_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.FORGOT_PIN_BACK_BUTTON, FORGOT_PIN_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_PASSPORT_NO, BUTTON_PASSPORT_NO);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_CITIZEN_ID_NO, BUTTON_CITIZEN_ID_NO);
        oneAppElementHashMap.put(OneAppElementKeys.BUTTON_CITIZEN_ID_NO_WITH_TITLE, BUTTON_CITIZEN_ID_NO_WITH_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.VERIFY_MOBILE_NUMBER_PROGRESS, VERIFY_MOBILE_NUMBER_PROGRESS);
        oneAppElementHashMap.put(OneAppElementKeys.RESEND_OTP_BUTTON, RESEND_OTP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_OTP_BUTTON, CANCEL_OTP_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.STAY_ON_PAGE_BUTTON, STAY_ON_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_BOTTOM_SHEET_TITLE, CANCEL_BOTTOM_SHEET_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CANCEL_BOTTOM_SHEET_DETAIL, CANCEL_BOTTOM_SHEET_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.LEAVE_PAGE_BUTTON, LEAVE_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_ERROR_INLINE, OTP_ERROR_INLINE);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_ATTEMPT_LIMIT_TITLE, OTP_ATTEMPT_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.OTP_ATTEMPT_LIMIT_DETAIL, OTP_ATTEMPT_LIMIT_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.KEYBOARD_DONE_BUTTON, KEYBOARD_DONE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SET_NEW_PIN_REQUIREMENTS_BUTTON, SET_NEW_PIN_REQUIREMENTS_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_BUTTON_SECOND, BOTTOMSHEET_BUTTON_SECOND);
        oneAppElementHashMap.put(OneAppElementKeys.HOME_TAB, HOME_TAB);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_TITLE, CHANGE_PIN_SUCCESS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_OK_BUTTON, CHANGE_PIN_SUCCESS_OK_BUTTON);

        // Change Pin
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BACK_BUTTON, CHANGE_PIN_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BACK_BUTTON, SETTING_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUB_TITLE, CHANGE_PIN_SUB_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_FORGOT_PIN_BUTTON, CHANGE_PIN_FORGOT_PIN_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_CANCEL_BUTTON, CHANGE_PIN_CANCEL_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE, CHANGE_PIN_BOTTOMSHEET_CANCEL_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON, CHANGE_PIN_BOTTOMSHEET_LEAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON, CHANGE_PIN_BOTTOMSHEET_CANCEL_CLOSE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON, CHANGE_PIN_BOTTOMSHEET_STAY_ON_PAGE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON, CHANGE_PIN_SUCCESS_CONTINUE_SETTING_BUTTON);

		// Pin Lock
        oneAppElementHashMap.put(OneAppElementKeys.PINLOCK_RESET_PIN_BUTTON, PINLOCK_RESET_PIN_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.BUTTON_BACK_VERIFY_PERSONAL, BUTTON_BACK_VERIFY_PERSONAL);

        // Settings
        oneAppElementHashMap.put(OneAppElementKeys.BIOMETRIC_SWITCH, BIOMETRIC_SWITCH);
        oneAppElementHashMap.put(OneAppElementKeys.BIOMETRIC_SCAN, BIOMETRIC_SCAN);
        oneAppElementHashMap.put(OneAppElementKeys.BOTTOMSHEET_LOGIN_BIOMETRIC_BUTTON, BOTTOMSHEET_LOGIN_BIOMETRIC_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_INPUT, SETTING_SEARCH_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PROFILE_IMAGE, SETTING_PROFILE_IMAGE);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PROFILE_NAME, SETTING_PROFILE_NAME);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MOBILE_NO_MENU, SETTING_MOBILE_NO_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_MENU, SETTING_EMAIL_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CURRENT_ADDRESS_MENU, SETTING_CURRENT_ADDRESS_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INTERNATIONAL_TRANSFER_MENU, SETTING_INTERNATIONAL_TRANSFER_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MOBILE_NO, SETTING_MOBILE_NO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_DETAIL, SETTING_EMAIL_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_EMAIL_VERIFY_STATUS, SETTING_EMAIL_VERIFY_STATUS);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_APPLICATION_SECTION, SETTING_APPLICATION_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_FAVORITES_MENU, SETTING_FAVORITES_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_HOMEPAGE_MENU, SETTING_MANAGE_HOMEPAGE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_NOTIFICATIONS_MENU, SETTING_NOTIFICATIONS_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_MENU, SETTING_QUICK_BALANCE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_TOGGLE, SETTING_QUICK_BALANCE_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ENABLE, QUICK_BALANCE_ENABLE);
		oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE, QUICK_BALANCE_SHOW_BALANCE);
		oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_BACK_BUTTON, QUICK_BALANCE_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_ENABLE_TOGGLE, QUICK_BALANCE_ENABLE_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_CONFIRM_BUTTON, QUICK_BALANCE_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_AUTO_SAVE_SLIP_MENU, SETTING_AUTO_SAVE_SLIP_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_MENU, SETTING_CHANGE_LANGUAGE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_VALUE, SETTING_CHANGE_LANGUAGE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_THAI_BUTTON, CHANGE_LANG_THAI_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_ENG_BUTTON, CHANGE_LANG_ENG_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON, CHANGE_LANG_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SECURITY_SECTION, SETTING_SECURITY_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_ACCOUNT_AND_CARD_SECTION, SETTING_ACCOUNT_AND_CARD_SECTION);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MENU, SETTING_MANAGE_ACCOUNT_MENU);
		oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT, SETTING_MANAGE_ACCOUNT_FIRST_ACCOUNT);
		oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT, SETTING_MANAGE_ACCOUNT_TOGGLE_SHOW_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_SHOW_ACCOUNT, SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_SHOW_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_HIDDEN_ACCOUNT, SETTING_MANAGE_ACCOUNT_MESSAGE_ALERT_HIDDEN_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON, SETTING_MANAGE_ACCOUNT_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH, SETTING_MANAGE_ACCOUNT_BACK_BUTTON_XPATH);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_DAILY_TRANSACTION_LIMIT_MENU, SETTING_DAILY_TRANSACTION_LIMIT_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_MENU, SETTING_PIN_FREE_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PAY_WITH_WOW_MENU, SETTING_PAY_WITH_WOW_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_FLAG, SETTING_PIN_FREE_FLAG);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_NOT_ALLOW_RADIO, SETTING_PIN_FREE_NOT_ALLOW_RADIO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_SAVE_BUTTON, SETTING_PIN_FREE_SAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_BUTTON, SETTING_PIN_FREE_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_ALLOW_RADIO, SETTING_PIN_FREE_ALLOW_RADIO);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BIOMETRIC_MENU, SETTING_BIOMETRIC_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_HOME_BUTTON, SETTING_PIN_FREE_BACK_TO_HOME_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON, SETTING_PIN_FREE_BACK_TO_SETTINGS_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON, SETTING_PIN_FREE_CONFIRM_REVIEW_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS, SEARCH_SETTINGS);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_0, SETTING_INDEX_0);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_1, SETTING_INDEX_1);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_4, SETTING_INDEX_4);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_5, SETTING_INDEX_5);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_INDEX_6, SETTING_INDEX_6);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS_DELETE_WORD, SEARCH_SETTINGS_DELETE_WORD);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_INPUT_X_BUTTON, SETTING_SEARCH_INPUT_X_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SEARCH_SETTINGS_NO_RESULT, SEARCH_SETTINGS_NO_RESULT);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_QUICK_BALANCE_TITLE, SETTING_QUICK_BALANCE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_SHOW_BALANCE_TOGGLE, QUICK_BALANCE_SHOW_BALANCE_TOGGLE);
        oneAppElementHashMap.put(OneAppElementKeys.QUICK_BALANCE_FIRST_ACCOUNT, QUICK_BALANCE_FIRST_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.MANAGE_ACCOUNT_HIDDEN_ACCOUNT, MANAGE_ACCOUNT_HIDDEN_ACCOUNT);
		oneAppElementHashMap.put(OneAppElementKeys.SETTING_SEARCH_CLEAR_BUTTON, SETTING_SEARCH_CLEAR_BUTTON);

        // International Address
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_TITLE, INTERNATIONAL_ADDRESS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_BACK_BUTTON, INTERNATIONAL_ADDRESS_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET, INTERNATIONAL_ADDRESS_CONFIRM_LEAVE_BOTTOMSHEET);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS, INTERNATIONAL_ADDRESS_CONFIRM_ADDRESS);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_HOUSE_NO, INTERNATIONAL_ADDRESS_HOUSE_NO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ROOM_NO, INTERNATIONAL_ADDRESS_ROOM_NO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_FLOOR, INTERNATIONAL_ADDRESS_FLOOR);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_SOI, INTERNATIONAL_ADDRESS_SOI);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_MOO, INTERNATIONAL_ADDRESS_MOO);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ROAD, INTERNATIONAL_ADDRESS_ROAD);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_VILLAGE, INTERNATIONAL_ADDRESS_VILLAGE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ZIP_CODE, INTERNATIONAL_ADDRESS_ZIP_CODE);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT, INTERNATIONAL_ADDRESS_ZIP_CODE_SELECT);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_CONFIRM_BUTTON, INTERNATIONAL_ADDRESS_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.INTERNATIONAL_ADDRESS_EDIT_BUTTON, INTERNATIONAL_ADDRESS_EDIT_BUTTON);

        // Daily limit
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_TITLE, DAILY_TRANSACTION_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DETAIL, DAILY_TRANSACTION_LIMIT_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_BACK_BUTTON, DAILY_TRANSACTION_LIMIT_BACK_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT, DAILY_TRANSACTION_LIMIT_DOMESTIC_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT, DAILY_TRANSACTION_LIMIT_INTERNATIONAL_INPUT);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_SAVE_BUTTON, DAILY_TRANSACTION_LIMIT_SAVE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_DOMESTIC, DAILY_TRANSACTION_LIMIT_DOMESTIC);
        oneAppElementHashMap.put(OneAppElementKeys.DAILY_TRANSACTION_LIMIT_INTERNATIONAL, DAILY_TRANSACTION_LIMIT_INTERNATIONAL);
        // Pin free
        oneAppElementHashMap.put(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_TITLE, PIN_FREE_TRANSACTION_LIMIT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PIN_FREE_TRANSACTION_LIMIT_DETAIL, PIN_FREE_TRANSACTION_LIMIT_DETAIL);

        //more
        oneAppElementHashMap.put(OneAppElementKeys.MORE_BUTTON, MORE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.SETTING_BUTTON, SETTING_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.LOGOUT_BUTTON, LOGOUT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON, CONFIRM_LOGOUT_BUTTON);

        oneAppElementHashMap.put(OneAppElementKeys.COMPLETE_SCREEN_TITLE, COMPLETE_SCREEN_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.COMPLETE_SCREEN_SUBTITLE, COMPLETE_SCREEN_SUBTITLE);

    }

    public OneAppElement get(String elementKey) {
        return oneAppElementHashMap.get(elementKey);
    }
}
