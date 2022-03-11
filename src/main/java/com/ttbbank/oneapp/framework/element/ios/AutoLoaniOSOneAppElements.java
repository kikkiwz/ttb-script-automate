package com.ttbbank.oneapp.framework.element.ios;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class AutoLoaniOSOneAppElements {
    private AutoLoaniOSOneAppElements() {

    }

    //Auto Loan
    private static final OneAppElement AUTO_LOAN_MY_ACCOUNT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Loan\"])[1]");
    private static final OneAppElement AUTO_LOAN_1ST_ACCOUNT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ttb DRIVE Double tabs to see more details");
    private static final OneAppElement AUTO_LOAN_DETAIL = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Loan Details\"]");
    private static final OneAppElement AUTO_LOAN_INSURANCE_DUE_DATE_LABEL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Insurance Due Date");
    private static final OneAppElement AUTO_LOAN_PAYMENT_HISTORY_BTN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Payment History\"]");
    private static final OneAppElement AUTO_LOAN_INSTALMENT_LABEL = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Installment\"])[1]");
    private static final OneAppElement AUTO_LOAN_PAYMENT_LIST_1ST = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Paid Amount\"])[1]");
    private static final OneAppElement AUTO_LOAN_PAYMENT_RECEIPT_DATE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Receipt Date");
    private static final OneAppElement AUTO_LOAN_PAYMENT_LIST_11ST = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeStaticText[@name=\"Paid Amount\"])[8]");
    private static final OneAppElement AUTO_LOAN_FOR_WAITING_LOAN_ACCOUNT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeOther[@name=\"Basic Account Double tabs for more details\"])[1]");
    private static final OneAppElement AUTO_LOAN_SERVICE_REQUEST_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#shortcut-icon-more");
    private static final OneAppElement AUTO_LOAN_ACCOUNT_DETAIL_HEADER = new OneAppElement(FindBy.XPATH, "#bottom-sheet-header");
    private static final OneAppElement AUTO_LOAN_ACCOUNT_PAYMENT_HISTORY_TAP = new OneAppElement(FindBy.XPATH, "#credit_landing_unbilled_list");
    private static final OneAppElement AUTO_LOAN_ACCOUNT_NUMBER = new OneAppElement(FindBy.CSS_SELECTOR, "#account-number-0");
    private static final OneAppElement AUTO_LOAN_PRODUCT_NAME = new OneAppElement(FindBy.CSS_SELECTOR, "#producr-name-0");
    private static final OneAppElement AUTO_LOAN_EVENT_CARD_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#EVENT-CARD-BUTTON");

    //Auto loan Close account
    private static final OneAppElement AUTO_LOAN_CLOSE_ACCOUNT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#shortcut-icon-7-0");
    private static final OneAppElement AUTO_LOAN_CLOSE_ACCOUNT_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//*[@id=\"al-closing-account-information-next-button\"]");
    private static final OneAppElement AUTO_LOAN_ADD_EMAIL = new OneAppElement(FindBy.XPATH, "//*[@id=\"al-close-hp-account-information-list-container\"]/div[2]/div/button");
    private static final OneAppElement AUTO_LOAN_EMAIL_INPUT_FILED = new OneAppElement(FindBy.ID, "SETTING_MANAGE_EMAIL_INPUT_input");
    private static final OneAppElement AUTO_LOAN_CLOSE_ACCOUNT_INFO_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-close-hp-account-information-next-button");
    private static final OneAppElement AUTO_LOAN_CLOSE_ACCOUNT_SELECT_METHOD_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-select-method-next-button");
    private static final OneAppElement AUTO_LOAN_CLOSE_ACCOUNT_SELECT_RECEIVE_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-select-doc-next-button");
    private static final OneAppElement AUTO_LOAN_CLOSE_SELECT_QR_BARCODE = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_al-select-payment-type-pay-by-qr");
    private static final OneAppElement AUTO_LOAN_CLOSE_SELECT_PAYMENT_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-select-payment-type-next-button");
    private static final OneAppElement AUTO_LOAN_CLOSE_GENERATE_QR_BARCODE_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-close-account-payment-details-next-button");


    //Auto loan Receipt Tax
    private static final OneAppElement AUTO_LOAN_RECEIPT_TAX_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#shortcut-icon-6-0");
    private static final OneAppElement AUTO_LOAN_RECEIPT_INFO_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-receipt-hp-account-next-button");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_TYPE_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-receipt-method-next-button");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_1_CHECKBOX = new OneAppElement(FindBy.CSS_SELECTOR, "#label_0");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_2_CHECKBOX = new OneAppElement(FindBy.CSS_SELECTOR, "#label_1_0");
    private static final OneAppElement AUTO_LOAN_SELECT_RECEIPT_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-receipt-select-receipt-next-button");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_DOC_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-select-doc-receipt-next-button");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_QR_BARCODE = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_al-car-receipt-tax-invoice-pay-by-qr");
    private static final OneAppElement AUTO_LOAN_RECEIPT_SELECT_PAYMENT_NEXT_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-receipt-tax-invoice-next-button");
    private static final OneAppElement AUTO_LOAN_RECEIPT_GENERATE_QR_BARCODE_BUTTON = new OneAppElement(FindBy.CSS_SELECTOR, "#al-receipt-tax-invoice-details-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_REGISTRATION = new OneAppElement(FindBy.XPATH, "//*[@id=\"shortcut-icon-2-0\"]");
    private static final OneAppElement AUTO_LOAN_RECEIPT_FEE_VALUE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTextField[@value=\"100.00\"]");
    private static final OneAppElement AUTO_LOAN_PAY_BILL_HEADER = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Bill Payment");
    private static final OneAppElement AUTO_LOAN_PAY_BILL_NEXT_BTN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private static final OneAppElement AUTO_LOAN_PAY_BILL_CONFIRM_BTN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Confirm\"]");
    private static final OneAppElement AUTO_LOAN_PAY_BILL_AMOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"100.00\"]");
    private static final OneAppElement AUTO_LOAN_PAY_BILL_HEADER_CONFIRM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Review Payment Details");
    //Auto Loan Copy of Contract

    private static final OneAppElement AUTO_LOAN_REQUEST_COPY_CONTRACT = new OneAppElement(FindBy.CSS_SELECTOR, "#shortcut-icon-4-0");
    private static final OneAppElement AUTO_LOAN_COPY_OF_CONTRACT_HEADER_INFO = new OneAppElement(FindBy.CSS_SELECTOR, "#al-copy-of-contract-account-information-header");
    private static final OneAppElement AUTO_LOAN_COPY_OF_CONTRACT_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-copy-of-contract-account-information-next-button");
    private static final OneAppElement AUTO_LOAN_COPY_OF_CONTRACT_HEADER_COMPLETE = new OneAppElement(FindBy.CSS_SELECTOR, "#al-copy-of-contract-complete-header");

    //Auto loan Car Transfer Form
    private static final OneAppElement AUTO_LOAN_CAR_TRANSFER_FORM = new OneAppElement(FindBy.CSS_SELECTOR, "#main-shortcut-icon-2-undefined");
    private static final OneAppElement AUTO_LOAN_CAR_TRANSFER_FORM_INFO = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-transfer-account-information-next-button");

    //AUTO Loan CYC
    private static final OneAppElement AUTO_LOAN_CYC_TOP_MSG2 = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_OFFERING_TEXT_TOP2");
    private static final OneAppElement AUTO_LOAN_CYC_LOGO = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_OFFERING_ALLOWED_IMAGE");
    private static final OneAppElement AUTO_LOAN_CYC_WARNING_OFFER = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_OFFERING_WARNING");
    private static final OneAppElement AUTO_LOAN_CYC_GET_OFFER_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_OFFERING_NEXT_BUTTON");
    private static final OneAppElement AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_SPECIFY_CREDIT_AMOUNT_TITLE");
    private static final OneAppElement AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_SPECIFY_CREDIT_AMOUNT_TEXT_FIELD_input");
    private static final OneAppElement AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_SPECIFY_CREDIT_AMOUNT_TEXT_FIELD_helptext");
    private static final OneAppElement AUTO_LOAN_CYC_84_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_84");
    private static final OneAppElement AUTO_LOAN_CYC_72_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_72");
    private static final OneAppElement AUTO_LOAN_CYC_60_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_60");
    private static final OneAppElement AUTO_LOAN_CYC_48_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_48");
    private static final OneAppElement AUTO_LOAN_CYC_36_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_36");
    private static final OneAppElement AUTO_LOAN_CYC_24_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_24");
    private static final OneAppElement AUTO_LOAN_CYC_12_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#LabelText_12");
    private static final OneAppElement AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_SPECIFY_CREDIT_AMOUNT_NEXT_BUTTON");
    private static final OneAppElement AUTO_LOAN_CYC_CONFIRM_MSG1 = new OneAppElement(FindBy.XPATH, "//*[@id=\"al-cyc-confirm-main-card-container\"]/div[1]/h3");
    private static final OneAppElement AUTO_LOAN_CYC_CONFIRM_AMOUNT = new OneAppElement(FindBy.CSS_SELECTOR, "#3");
    private static final OneAppElement AUTO_LOAN_CYC_CONFIRM_TERM = new OneAppElement(FindBy.CSS_SELECTOR, "#4");
    private static final OneAppElement AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-receipt-hp-account-next-button");
    private static final OneAppElement AUTO_LOAN_CYC_SUCCESS_ICON = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_COMPLETE_ICON");
    private static final OneAppElement AUTO_LOAN_CYC_SUCCESS_TOP_MSG1 = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_CYC_COMPLETE_TEXT_TOP1");
    //Status Tracking
    private static final OneAppElement AUTO_LOAN_REQUEST_STATUS_BTN = new OneAppElement(FindBy.CSS_SELECTOR,"#shortcut-icon-9-0");
    private static final OneAppElement AUTO_LOAN_REQUEST_STATUS_HEADER = new OneAppElement(FindBy.CSS_SELECTOR,"#al_status_detail_for_service_request_pre_header_labe");
    private static final OneAppElement AUTO_LOAN_REQUEST_STATUS_CONTAIN = new OneAppElement(FindBy.CSS_SELECTOR,"#al_status_detail_for_service_request_pre_card_container_1");

    //Other Payment
    private static final OneAppElement AUTO_LOAN_OTHER_PAYMENT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#shortcut-icon-1-0");
    private static final OneAppElement AUTO_LOAN_QR_TAX_PAYMENT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_OTHER_PAYMENT_SELECTION_CARD_ITEM0");
    private static final OneAppElement AUTO_LOAN_QR_FEE_PAYMENT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_OTHER_PAYMENT_SELECTION_CARD_ITEM1");
    private static final OneAppElement AUTO_LOAN_QR_CLOSE_ACCOUNT_PAYMENT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_OTHER_PAYMENT_SELECTION_CARD_ITEM2");
    private static final OneAppElement AUTO_LOAN_HEADER_OTHER_PAYMENT =  new OneAppElement(FindBy.CSS_SELECTOR, "#AL_OTHER_PAYMENT_SELECTION_HEADER");
    private static final OneAppElement AUTO_LOAN_HEADER_QR_OTHER_PAYMENT = new OneAppElement(FindBy.CSS_SELECTOR, "#al_other_payment_detail_text_header");
    private static final OneAppElement AUTO_LOAN_NEXT_OTHER_PAYMENT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#AL_OTHER_PAYMENT_SELECTION_NEXT_BUTTON");

    //Car tax Sign

    private static final OneAppElement AUTO_LOAN_CAR_TAX_LABEL_BTN = new OneAppElement(FindBy.CSS_SELECTOR , "#shortcut-icon-3-0");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_INFO_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-tax-sign-request-information-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_ACCOUNT_INFO_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-tax-sign-account-information-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_DOC_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-select-doc-tax-sign-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_PAYMENT_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-tax-sign-select-payment-type-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_CONFIRM_NEXT_BTN = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-tax-sign-payment-details-next-button");
    private static final OneAppElement AUTO_LOAN_CAR_TAX_FEE_VALUE = new OneAppElement(FindBy.CSS_SELECTOR, "#al-car-tax-sign-fee-value");
    private static final OneAppElement AUTO_LOAN_RECEIPT_FEE_VALUE_CAR_TAX_SIGN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeTextField[@value=\"500.00\"]");

    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {

        //AUTO LOAN
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_MY_ACCOUNT, AUTO_LOAN_MY_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT, AUTO_LOAN_1ST_ACCOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_DETAIL, AUTO_LOAN_DETAIL);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAYMENT_HISTORY_BTN, AUTO_LOAN_PAYMENT_HISTORY_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_INSTALMENT_LABEL, AUTO_LOAN_INSTALMENT_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_INSURANCE_DUE_DATE_LABEL, AUTO_LOAN_INSURANCE_DUE_DATE_LABEL);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAYMENT_LIST_1ST, AUTO_LOAN_PAYMENT_LIST_1ST);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAYMENT_RECEIPT_DATE, AUTO_LOAN_PAYMENT_RECEIPT_DATE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_SERVICE_REQUEST_BUTTON, AUTO_LOAN_SERVICE_REQUEST_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_BUTTON, AUTO_LOAN_CLOSE_ACCOUNT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_NEXT_BUTTON, AUTO_LOAN_CLOSE_ACCOUNT_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_ADD_EMAIL, AUTO_LOAN_ADD_EMAIL);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_EMAIL_INPUT_FILED, AUTO_LOAN_EMAIL_INPUT_FILED);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_INFO_NEXT_BUTTON, AUTO_LOAN_CLOSE_ACCOUNT_INFO_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_METHOD_NEXT_BUTTON, AUTO_LOAN_CLOSE_ACCOUNT_SELECT_METHOD_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_ACCOUNT_SELECT_RECEIVE_NEXT_BUTTON, AUTO_LOAN_CLOSE_ACCOUNT_SELECT_RECEIVE_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_SELECT_QR_BARCODE, AUTO_LOAN_CLOSE_SELECT_QR_BARCODE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_SELECT_PAYMENT_NEXT_BUTTON, AUTO_LOAN_CLOSE_SELECT_PAYMENT_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_TAX_BUTTON, AUTO_LOAN_RECEIPT_TAX_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_INFO_NEXT_BUTTON, AUTO_LOAN_RECEIPT_INFO_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_TYPE_NEXT_BUTTON, AUTO_LOAN_RECEIPT_SELECT_TYPE_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_1_CHECKBOX, AUTO_LOAN_RECEIPT_SELECT_1_CHECKBOX);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_2_CHECKBOX, AUTO_LOAN_RECEIPT_SELECT_2_CHECKBOX);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_SELECT_RECEIPT_NEXT_BUTTON, AUTO_LOAN_SELECT_RECEIPT_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_DOC_NEXT_BUTTON, AUTO_LOAN_RECEIPT_SELECT_DOC_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_QR_BARCODE, AUTO_LOAN_RECEIPT_SELECT_QR_BARCODE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_SELECT_PAYMENT_NEXT_BUTTON, AUTO_LOAN_RECEIPT_SELECT_PAYMENT_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_GENERATE_QR_BARCODE_BUTTON, AUTO_LOAN_RECEIPT_GENERATE_QR_BARCODE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CLOSE_GENERATE_QR_BARCODE_BUTTON, AUTO_LOAN_CLOSE_GENERATE_QR_BARCODE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_ACCOUNT_DETAIL_HEADER, AUTO_LOAN_ACCOUNT_DETAIL_HEADER);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_REGISTRATION, AUTO_LOAN_CAR_REGISTRATION);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME, AUTO_LOAN_PRODUCT_NAME);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_ACCOUNT_PAYMENT_HISTORY_TAP, AUTO_LOAN_ACCOUNT_PAYMENT_HISTORY_TAP);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_ACCOUNT_NUMBER, AUTO_LOAN_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_REQUEST_COPY_CONTRACT, AUTO_LOAN_REQUEST_COPY_CONTRACT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_HEADER_INFO, AUTO_LOAN_COPY_OF_CONTRACT_HEADER_INFO);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_NEXT_BTN, AUTO_LOAN_COPY_OF_CONTRACT_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_COPY_OF_CONTRACT_HEADER_COMPLETE, AUTO_LOAN_COPY_OF_CONTRACT_HEADER_COMPLETE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_EVENT_CARD_BTN, AUTO_LOAN_EVENT_CARD_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TRANSFER_FORM, AUTO_LOAN_CAR_TRANSFER_FORM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TRANSFER_FORM_INFO, AUTO_LOAN_CAR_TRANSFER_FORM_INFO);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_TOP_MSG2, AUTO_LOAN_CYC_TOP_MSG2);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_LOGO, AUTO_LOAN_CYC_LOGO);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_OFFER, AUTO_LOAN_CYC_WARNING_OFFER);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_GET_OFFER_BTN, AUTO_LOAN_CYC_GET_OFFER_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE, AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT, AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT, AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_84_TERM, AUTO_LOAN_CYC_84_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_72_TERM, AUTO_LOAN_CYC_72_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_60_TERM, AUTO_LOAN_CYC_60_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_48_TERM, AUTO_LOAN_CYC_48_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_36_TERM, AUTO_LOAN_CYC_36_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_24_TERM, AUTO_LOAN_CYC_24_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_12_TERM, AUTO_LOAN_CYC_12_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN, AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_MSG1, AUTO_LOAN_CYC_CONFIRM_MSG1);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_AMOUNT, AUTO_LOAN_CYC_CONFIRM_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_TERM, AUTO_LOAN_CYC_CONFIRM_TERM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN, AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_SUCCESS_ICON, AUTO_LOAN_CYC_SUCCESS_ICON);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CYC_SUCCESS_TOP_MSG1, AUTO_LOAN_CYC_SUCCESS_TOP_MSG1);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_BTN, AUTO_LOAN_REQUEST_STATUS_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_HEADER, AUTO_LOAN_REQUEST_STATUS_HEADER);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_REQUEST_STATUS_CONTAIN , AUTO_LOAN_REQUEST_STATUS_CONTAIN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_FEE_VALUE, AUTO_LOAN_RECEIPT_FEE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER, AUTO_LOAN_PAY_BILL_HEADER);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAY_BILL_NEXT_BTN, AUTO_LOAN_PAY_BILL_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAY_BILL_CONFIRM_BTN, AUTO_LOAN_PAY_BILL_CONFIRM_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAY_BILL_AMOUNT, AUTO_LOAN_PAY_BILL_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_PAY_BILL_HEADER_CONFIRM, AUTO_LOAN_PAY_BILL_HEADER_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_OTHER_PAYMENT_BTN, AUTO_LOAN_OTHER_PAYMENT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_QR_TAX_PAYMENT_BTN, AUTO_LOAN_QR_TAX_PAYMENT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_QR_FEE_PAYMENT_BTN, AUTO_LOAN_QR_FEE_PAYMENT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_QR_CLOSE_ACCOUNT_PAYMENT_BTN, AUTO_LOAN_QR_CLOSE_ACCOUNT_PAYMENT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_HEADER_OTHER_PAYMENT, AUTO_LOAN_HEADER_OTHER_PAYMENT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_HEADER_QR_OTHER_PAYMENT, AUTO_LOAN_HEADER_QR_OTHER_PAYMENT);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_NEXT_OTHER_PAYMENT_BTN, AUTO_LOAN_NEXT_OTHER_PAYMENT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_LABEL_BTN, AUTO_LOAN_CAR_TAX_LABEL_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_INFO_NEXT_BTN, AUTO_LOAN_CAR_TAX_INFO_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_ACCOUNT_INFO_NEXT_BTN, AUTO_LOAN_CAR_TAX_ACCOUNT_INFO_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_DOC_NEXT_BTN, AUTO_LOAN_CAR_TAX_DOC_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_PAYMENT_NEXT_BTN, AUTO_LOAN_CAR_TAX_PAYMENT_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_CONFIRM_NEXT_BTN, AUTO_LOAN_CAR_TAX_CONFIRM_NEXT_BTN);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_CAR_TAX_FEE_VALUE, AUTO_LOAN_CAR_TAX_FEE_VALUE);
        oneAppElementHashMap.put(OneAppElementKeys.AUTO_LOAN_RECEIPT_FEE_VALUE_CAR_TAX_SIGN, AUTO_LOAN_RECEIPT_FEE_VALUE_CAR_TAX_SIGN);
    }
}
