package com.ttbbank.oneapp.framework.element.ios;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class Pb7iOSOneAppElements {
    private Pb7iOSOneAppElements() {

    }

    //Primary banking 7
    private static final OneAppElement PB7_TOPUP_HOME = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Top Up");
    private static final OneAppElement PB7_TOPUP_MENU = new OneAppElement(FindBy.ACCESSIBILITY_ID, "navTitle");
    private static final OneAppElement PB7_TOPUP_ONE_TWO_CALL = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"1-2-Call\"]");
    private static final OneAppElement PB7_TOPUP_TRUE_MONEY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"True Money\"]");
    private static final OneAppElement PB7_TOPUP_EASY_PASS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Easy Pass");
    private static final OneAppElement PB7_TOPUP_TRUEH = new OneAppElement(FindBy.ACCESSIBILITY_ID, "TrueMove H Pre Paid");
    private static final OneAppElement PB7_TOPUP_DTAC = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Dtac Top Up");

    private static final OneAppElement PB7_TOPUP_REF1 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_ENTER_DETAILS_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "navTitle");
    private static final OneAppElement PB7_TOPUP_ENTER_FROM_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"059-2-56847-1\"]");
    private static final OneAppElement PB7_TOPUP_STEP_AMOUNT_50 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"50\"]\n");
    private static final OneAppElement PB7_TOPUP_STEP_AMOUNT_300 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"300\"]\n");
    private static final OneAppElement PB7_TOPUP_STEP_AMOUNT_90 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"90\"]\n");
    private static final OneAppElement PB7_TOPUP_AMOUNT_TEXTFIELD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");

    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ONE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"1\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"2\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"3\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FOUR = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"4\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"5\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SIX = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"6\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"7\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_EIGHT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"8\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_NINE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"9\"]");
    private static final OneAppElement PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeKey[@name=\"0\"]");
    private static final OneAppElement PB7_KEYPAD_DONE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@label='Done']");

    private static final OneAppElement PB7_NOTE_TEXTFIELD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeTextView");
    private static final OneAppElement PB7_KEY_BOARD_O_LARGE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "O");
    private static final OneAppElement PB7_KEY_BOARD_T_LARGE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "T");
    private static final OneAppElement PB7_KEY_BOARD_A_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "a");
    private static final OneAppElement PB7_KEY_BOARD_B_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "b");
    private static final OneAppElement PB7_KEY_BOARD_C_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "c");
    private static final OneAppElement PB7_KEY_BOARD_D_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "d");
    private static final OneAppElement PB7_KEY_BOARD_E_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "e");
    private static final OneAppElement PB7_KEY_BOARD_F_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "f");
    private static final OneAppElement PB7_KEY_BOARD_G_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "g");
    private static final OneAppElement PB7_KEY_BOARD_H_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "h");
    private static final OneAppElement PB7_KEY_BOARD_I_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "i");
    private static final OneAppElement PB7_KEY_BOARD_J_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "j");
    private static final OneAppElement PB7_KEY_BOARD_K_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "k");
    private static final OneAppElement PB7_KEY_BOARD_L_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "l");
    private static final OneAppElement PB7_KEY_BOARD_M_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "m");
    private static final OneAppElement PB7_KEY_BOARD_N_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "n");
    private static final OneAppElement PB7_KEY_BOARD_O_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "o");
    private static final OneAppElement PB7_KEY_BOARD_P_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "p");
    private static final OneAppElement PB7_KEY_BOARD_Q_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "q");
    private static final OneAppElement PB7_KEY_BOARD_R_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "r");
    private static final OneAppElement PB7_KEY_BOARD_S_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "s");
    private static final OneAppElement PB7_KEY_BOARD_T_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "t");
    private static final OneAppElement PB7_KEY_BOARD_U_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "u");
    private static final OneAppElement PB7_KEY_BOARD_V_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "v");
    private static final OneAppElement PB7_KEY_BOARD_W_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "w");
    private static final OneAppElement PB7_KEY_BOARD_X_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "x");
    private static final OneAppElement PB7_KEY_BOARD_Y_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "y");
    private static final OneAppElement PB7_KEY_BOARD_Z_SMALL = new OneAppElement(FindBy.ACCESSIBILITY_ID, "z");
    private static final OneAppElement PB7_KEY_BOARD_SHIFT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "shift");
    private static final OneAppElement PB7_KEY_BOARD_SPACE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "space");
    private static final OneAppElement PB7_KEY_BOARD_MORE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "more");
    private static final OneAppElement PB7_KEY_BOARD_ZERO = new OneAppElement(FindBy.ACCESSIBILITY_ID, "0");
    private static final OneAppElement PB7_KEY_BOARD_ONE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private static final OneAppElement PB7_KEY_BOARD_TWO = new OneAppElement(FindBy.ACCESSIBILITY_ID, "2");
    private static final OneAppElement PB7_KEY_BOARD_THREE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "3");
    private static final OneAppElement PB7_KEY_BOARD_FOUR = new OneAppElement(FindBy.ACCESSIBILITY_ID, "4");
    private static final OneAppElement PB7_KEY_BOARD_FIVE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "5");

    private static final OneAppElement PB7_TOPUP_NEXT_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"Next\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Review Top Up Details");
    private static final OneAppElement PB7_TOPUP_REVIEW_CONFIRM_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Confirm\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"059-2-56847-1\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_AMOUNT_FIFTY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"50.00\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_AMOUNT_300 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"400.00\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_AMOUNT_400 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"300.00\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_NOTE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Note:\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_REF1 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"093-705-2487\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_REF1_TRUE_MONEY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"083-044-3596\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_REF1_EASY_PASS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"2653574791\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_TOPUP_REF_EASY_PASS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Top up ref no:\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_FEE_FIVE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"5.00\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_CUSTOMER_NAME = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"นาย นางสาวสุขสมใจ ยิ้มแย้มสะอาด\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Top Up Successful");
    private static final OneAppElement PB7_TOPUP_COMPLETE_FROM_ACCOUNT_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"059-2-56847-1\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_AMOUNT_FIFTY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"50.00\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_AMOUNT_300 = new OneAppElement(FindBy.XPATH, "///XCUIElementTypeStaticText[@name=\"400.00\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_AMOUNT_400 = new OneAppElement(FindBy.XPATH, "///XCUIElementTypeStaticText[@name=\"300.00\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_NOTE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Note: Top up\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_REF1 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"093-705-2487\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_REF1_TRUE_MONEY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"083-044-3596\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_REF1_EASY_PASS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"2653574791\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_TOPUP_REF_EASY_PASS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"MOBILE220100000151\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_FEE_FIVE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"5.00\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_CUSTOMER_NAME = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"นาย นางสาวสุขสมใจ ยิ้มแย้มสะอาด\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_DONE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Done\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_TOSSED_MESSAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Transaction slip saved on your device.\"]");
    private static final OneAppElement PB7_TOPUP_COMPLETE_BALANCE_AFTER_TOPUP = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Balance after top up:\"]");

    private static final OneAppElement PB7_TOPUP_SCHEDULE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD_AMOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_DATE_PICKER_AMOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_DATE_PICKER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_DATE_PICKER_31 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"31\"]");
    private static final OneAppElement PB7_TOPUP_DATE_PICKER_1 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "1");
    private static final OneAppElement PB7_TOPUP_DATE_PICKER_15 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "15");
    private static final OneAppElement PB7_TOPUP_ADD_SCHEDULE_BUTTON = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Add Schedule\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "navTitle");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_12CALL_ONCE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Test 01\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_12CALL_ONCE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"50.00\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_DATE_12CALL_ONCE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"31 Jan 22\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_FREQUENCY_ONCE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Once\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_SELECT_WEEKLY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Weekly");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_SELECT_MONTHLY= new OneAppElement(FindBy.ACCESSIBILITY_ID, "Monthly");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_ENDDATE_PICKER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_DATE_PICKER_NEXT_MONTH = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Next Month");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_SELECT_AMOUNT_OF_TIMES = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_AMOUNT_OF_TIMES_TEXTFIELD = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Amount of times text field");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_NOTE_TEXTFIELD = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Note (Optional)");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_CONFIRM = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Confirm\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_SCHEDULE_NAME_TRUE_WEEKLY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Test 02\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_100 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"100.00\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUEH_WEEKLY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Test 03\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_90 = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"90.00\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_REF1_TRUEH = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"064-837-1960\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_DTAC_MONTHLY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Test 04\"]");
    private static final OneAppElement PB7_TOPUP_REVIEW_REF1_DTAC = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"065-208-0053\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUE_MONTHLY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Test 05\"]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_COMPLETE_TITLE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Schedule is Successfully Created");
    private static final OneAppElement PB7_TOPUP_TOGGLE_SCHEDULE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_ENDDATE_PICKER_AMOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_DAY_EVERY_AMOUNT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
    private static final OneAppElement PB7_TOPUP_SCHEDULE_END_DATEPICKER_MONTHLY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeApplication[@name=\"OneApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeTextField");

    public static void init(Map<String, OneAppElement> oneAppElementHashMap) {
        //PB7
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_HOME, PB7_TOPUP_HOME);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_MENU, PB7_TOPUP_MENU);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_ONE_TWO_CALL, PB7_TOPUP_ONE_TWO_CALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_TRUE_MONEY, PB7_TOPUP_TRUE_MONEY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_EASY_PASS, PB7_TOPUP_EASY_PASS);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_TRUEH, PB7_TOPUP_TRUEH);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_DTAC, PB7_TOPUP_DTAC);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REF1, PB7_TOPUP_REF1);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_ENTER_DETAILS_TITLE, PB7_TOPUP_ENTER_DETAILS_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_ENTER_FROM_ACCOUNT_NUMBER, PB7_TOPUP_ENTER_FROM_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_50, PB7_TOPUP_STEP_AMOUNT_50);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_300, PB7_TOPUP_STEP_AMOUNT_300);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_STEP_AMOUNT_90, PB7_TOPUP_STEP_AMOUNT_90);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_AMOUNT_TEXTFIELD, PB7_TOPUP_AMOUNT_TEXTFIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_NOTE_TEXTFIELD, PB7_NOTE_TEXTFIELD);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ONE, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ONE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_TWO);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_THREE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FOUR, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FOUR);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_FIVE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SIX, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SIX);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_SEVEN);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_EIGHT, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_EIGHT);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_NINE, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_NINE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO, PB7_ENTER_DETAILS_KEYBOARD_NUMBER_ZERO);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEYPAD_DONE, PB7_KEYPAD_DONE);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_O_LARGE, PB7_KEY_BOARD_O_LARGE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_T_LARGE, PB7_KEY_BOARD_T_LARGE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_A_SMALL, PB7_KEY_BOARD_A_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_B_SMALL, PB7_KEY_BOARD_B_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_C_SMALL, PB7_KEY_BOARD_C_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_D_SMALL, PB7_KEY_BOARD_D_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_E_SMALL, PB7_KEY_BOARD_E_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_F_SMALL, PB7_KEY_BOARD_F_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_G_SMALL, PB7_KEY_BOARD_G_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_H_SMALL, PB7_KEY_BOARD_H_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_I_SMALL, PB7_KEY_BOARD_I_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_J_SMALL, PB7_KEY_BOARD_J_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_K_SMALL, PB7_KEY_BOARD_K_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_L_SMALL, PB7_KEY_BOARD_L_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_M_SMALL, PB7_KEY_BOARD_M_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_N_SMALL, PB7_KEY_BOARD_N_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_O_SMALL, PB7_KEY_BOARD_O_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_P_SMALL, PB7_KEY_BOARD_P_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_Q_SMALL, PB7_KEY_BOARD_Q_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_R_SMALL, PB7_KEY_BOARD_R_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_S_SMALL, PB7_KEY_BOARD_S_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_T_SMALL, PB7_KEY_BOARD_T_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_U_SMALL, PB7_KEY_BOARD_U_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_V_SMALL, PB7_KEY_BOARD_V_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_W_SMALL, PB7_KEY_BOARD_W_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_X_SMALL, PB7_KEY_BOARD_X_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_Y_SMALL, PB7_KEY_BOARD_Y_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_Z_SMALL, PB7_KEY_BOARD_Z_SMALL);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_SHIFT, PB7_KEY_BOARD_SHIFT);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_SPACE, PB7_KEY_BOARD_SPACE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_MORE, PB7_KEY_BOARD_MORE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_ZERO, PB7_KEY_BOARD_ZERO);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_ONE, PB7_KEY_BOARD_ONE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_TWO, PB7_KEY_BOARD_TWO);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_THREE, PB7_KEY_BOARD_THREE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_FOUR, PB7_KEY_BOARD_FOUR);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_KEY_BOARD_FIVE, PB7_KEY_BOARD_FIVE);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_NEXT_BUTTON, PB7_TOPUP_NEXT_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_TITLE, PB7_TOPUP_REVIEW_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD_AMOUNT, PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD_AMOUNT);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_CONFIRM_BUTTON, PB7_TOPUP_REVIEW_CONFIRM_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER, PB7_TOPUP_REVIEW_FROM_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_FIFTY, PB7_TOPUP_REVIEW_AMOUNT_FIFTY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_300, PB7_TOPUP_REVIEW_AMOUNT_300);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_AMOUNT_400, PB7_TOPUP_REVIEW_AMOUNT_400);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_NOTE, PB7_TOPUP_REVIEW_NOTE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1, PB7_TOPUP_REVIEW_REF1);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_TRUE_MONEY, PB7_TOPUP_REVIEW_REF1_TRUE_MONEY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_EASY_PASS, PB7_TOPUP_REVIEW_REF1_EASY_PASS);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_TOPUP_REF_EASY_PASS, PB7_TOPUP_REVIEW_TOPUP_REF_EASY_PASS);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_FEE_FIVE, PB7_TOPUP_REVIEW_FEE_FIVE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_CUSTOMER_NAME, PB7_TOPUP_REVIEW_CUSTOMER_NAME);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_TITLE, PB7_TOPUP_COMPLETE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_FROM_ACCOUNT_NUMBER, PB7_TOPUP_COMPLETE_FROM_ACCOUNT_NUMBER);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_AMOUNT_FIFTY, PB7_TOPUP_COMPLETE_AMOUNT_FIFTY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_AMOUNT_300, PB7_TOPUP_COMPLETE_AMOUNT_300);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_AMOUNT_400, PB7_TOPUP_COMPLETE_AMOUNT_400);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_NOTE, PB7_TOPUP_COMPLETE_NOTE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_REF1, PB7_TOPUP_COMPLETE_REF1);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_REF1_TRUE_MONEY, PB7_TOPUP_COMPLETE_REF1_TRUE_MONEY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_REF1_EASY_PASS, PB7_TOPUP_COMPLETE_REF1_EASY_PASS);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_TOPUP_REF_EASY_PASS, PB7_TOPUP_COMPLETE_TOPUP_REF_EASY_PASS);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_FEE_FIVE, PB7_TOPUP_COMPLETE_FEE_FIVE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_CUSTOMER_NAME, PB7_TOPUP_COMPLETE_CUSTOMER_NAME);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_DONE_BUTTON, PB7_TOPUP_COMPLETE_DONE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_TOSSED_MESSAGE, PB7_TOPUP_COMPLETE_TOSSED_MESSAGE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_COMPLETE_BALANCE_AFTER_TOPUP, PB7_TOPUP_COMPLETE_BALANCE_AFTER_TOPUP);

        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_BUTTON, PB7_TOPUP_SCHEDULE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD, PB7_TOPUP_SCHEDULE_NAME_TEXTFIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DATE_PICKER, PB7_TOPUP_SCHEDULE_DATE_PICKER);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_DATE_PICKER_31, PB7_TOPUP_DATE_PICKER_31);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_ADD_SCHEDULE_BUTTON, PB7_TOPUP_ADD_SCHEDULE_BUTTON);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_TITLE, PB7_TOPUP_SCHEDULE_REVIEW_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_12CALL_ONCE, PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_12CALL_ONCE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_12CALL_ONCE, PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_12CALL_ONCE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_DATE_12CALL_ONCE, PB7_TOPUP_SCHEDULE_REVIEW_DATE_12CALL_ONCE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_FREQUENCY_ONCE, PB7_TOPUP_SCHEDULE_REVIEW_FREQUENCY_ONCE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_DATE_PICKER_1, PB7_TOPUP_DATE_PICKER_1);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_DATE_PICKER_15, PB7_TOPUP_DATE_PICKER_15);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_SELECT_WEEKLY, PB7_TOPUP_SCHEDULE_SELECT_WEEKLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_SELECT_MONTHLY, PB7_TOPUP_SCHEDULE_SELECT_MONTHLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_ENDDATE_PICKER, PB7_TOPUP_SCHEDULE_ENDDATE_PICKER);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_DATE_PICKER_NEXT_MONTH, PB7_TOPUP_DATE_PICKER_NEXT_MONTH);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_SELECT_AMOUNT_OF_TIMES, PB7_TOPUP_SCHEDULE_SELECT_AMOUNT_OF_TIMES);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_AMOUNT_OF_TIMES_TEXTFIELD, PB7_TOPUP_SCHEDULE_AMOUNT_OF_TIMES_TEXTFIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_NOTE_TEXTFIELD, PB7_TOPUP_SCHEDULE_NOTE_TEXTFIELD);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_CONFIRM, PB7_TOPUP_SCHEDULE_CONFIRM);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_SCHEDULE_NAME_TRUE_WEEKLY, PB7_TOPUP_SCHEDULE_SCHEDULE_NAME_TRUE_WEEKLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_100, PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_100);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUEH_WEEKLY, PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUEH_WEEKLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_90, PB7_TOPUP_SCHEDULE_REVIEW_AMOUNT_90);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_TRUEH, PB7_TOPUP_REVIEW_REF1_TRUEH);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_DTAC_MONTHLY, PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_DTAC_MONTHLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_REVIEW_REF1_DTAC, PB7_TOPUP_REVIEW_REF1_DTAC);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUE_MONTHLY, PB7_TOPUP_SCHEDULE_REVIEW_SCHEDULE_NAME_TRUE_MONTHLY);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_COMPLETE_TITLE, PB7_TOPUP_SCHEDULE_COMPLETE_TITLE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_TOGGLE_SCHEDULE, PB7_TOPUP_TOGGLE_SCHEDULE);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DATE_PICKER_AMOUNT, PB7_TOPUP_SCHEDULE_DATE_PICKER_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_ENDDATE_PICKER_AMOUNT, PB7_TOPUP_SCHEDULE_ENDDATE_PICKER_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_DAY_EVERY_AMOUNT, PB7_TOPUP_SCHEDULE_DAY_EVERY_AMOUNT);
        oneAppElementHashMap.put(OneAppElementKeys.PB7_TOPUP_SCHEDULE_END_DATEPICKER_MONTHLY, PB7_TOPUP_SCHEDULE_END_DATEPICKER_MONTHLY);

    }
}

