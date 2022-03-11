package com.ttbbank.oneapp.framework.element.ios;

import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

import java.util.Map;

public class It4ItiOSOneAppElements {
	private It4ItiOSOneAppElements() {

	}

	// IT4IT
	private static final OneAppElement MORE_TAB = new OneAppElement(FindBy.ACCESSIBILITY_ID, "More");
	private static final OneAppElement ACCOUNT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Account");
	private static final OneAppElement SERVICE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Service");
	private static final OneAppElement MORE_TAB_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"อื่นๆ\"]");
	private static final OneAppElement SETTING_TAB = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"Settings, Double tabs to see more details\"]");
	private static final OneAppElement SETTING_TAB_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"ตั้งค่า, แตะสองครั้งเพื่อดูข้อมูลเพิ่มเติม\"]");
	private static final OneAppElement EXISTING_NUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
	private static final OneAppElement KYC_PAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ตรวจสอบข้อมูลส่วนตัวของคุณ\"]");
	private static final OneAppElement KYC_PAGE_DETAILS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"รายละเอียดทั้งหมด\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_BOTTOM = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ยืนยันข้อมูลทั้งหมดถูกต้อง\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_BOTTOM_LATER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ต้องการทำภายหลัง\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeButton[@name=\"แก้ไข\"])[8]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"แก้ไขรายละเอียด\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeOther[@name=\"เบอร์โทรศัพท์มือถือ\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ปรับปรุงข้อมูล\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ติดตามสถานะการสมัคร\"]");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT = new OneAppElement(FindBy.XPATH, "(//XCUIElementTypeTextField[@name=\"One time password input\"])");
	private static final OneAppElement KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"รหัส OTP ไม่ถูกต้อง ลองใหม่ได้อีก 2 ครั้ง\"]");

	private static final OneAppElement CHANGE_LANGUAGE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ภาษาไทย\"]");
	private static final OneAppElement SEARCH_BAR = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
	private static final OneAppElement LANGUAGE_RESULT_VERIFY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Title setting\"]");
	private static final OneAppElement NO_RESULT_VERIFY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "No results found");
	private static final OneAppElement SEARCH_BAR_X_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "iConClose 16px");
	private static final OneAppElement EXPAND_ARROW_EN = new OneAppElement(FindBy.ACCESSIBILITY_ID, "expand quick action");
	private static final OneAppElement EXPAND_ARROW_TH = new OneAppElement(FindBy.ACCESSIBILITY_ID, "เพิ่มการแสดงปุ่มควิกแอคชั่น");
	private static final OneAppElement INSURANCE_THAI = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ประกัน");
	private static final OneAppElement INSURANCE_ENGLISH = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Insurance");
	
	
	
	private static final OneAppElement APP_GUIDE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "App Guide, Double tabs to see more details");
	private static final OneAppElement TERMS_AND_CONDITIONS = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Terms and Conditions, Double tabs to see more details");
	private static final OneAppElement PRIVACY_AND_SECURITY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Privacy and Security, Double tabs to see more details");
	private static final OneAppElement HELP_AND_SUPPPORT = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Help and Support, Double tabs to see more details");
	private static final OneAppElement MORE_LINKAGE_CLOSE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "closePin");
	private static final OneAppElement MORE_LINKAGE_BACK = new OneAppElement(FindBy.ACCESSIBILITY_ID, "icon arrow left");
	private static final OneAppElement HELP_AND_SUPPPORT_VERIFY = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"Services\"]");
	private static final OneAppElement HELP_AND_SUPPPORT_NEXT = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
	private static final OneAppElement KYC_PAGE_MISSING_DETAILS = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ปรับปรุงรายละเอียดให้สมบูรณ์\"]");
	private static final OneAppElement KYC_PAGE_REQUIRED_FILED = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name=\"ข้อมูลที่จำเป็นต้องมี\"]");
	private static final OneAppElement NO_INTERNET_CONNECTION = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name='No internet connection found']");
	private static final OneAppElement NO_INTERNET_CONNECTION_OK_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "OK");
	private static final OneAppElement GENERIC_ERROR_TITLE = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeStaticText[@name='Unable to proceed further']");
	private static final OneAppElement GENERIC_ERROR_BODY = new OneAppElement(FindBy.ACCESSIBILITY_ID, "We cannot proceed with your request right now, sorry for your inconvenience. For additional information, please call us on 1428.");
	private static final OneAppElement GENERIC_ERROR_OK = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"OK\"]");
	private static final OneAppElement LANGUAGE_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Language");
	private static final OneAppElement LANGUAGE_BUTTON_THAI = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ภาษา");
	private static final OneAppElement SELECT_LANGUAGE_PAGE = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Select your application language");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM = new OneAppElement(FindBy.ACCESSIBILITY_ID, "กรุณาเลือกภาษาสำหรับแอปพลิเคชัน");
	private static final OneAppElement SELECT_LANGUAGE_BACKBUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "BlueMedium24PxChevronLeft");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ภาษา");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2 = new OneAppElement(FindBy.ACCESSIBILITY_ID, "English");
	private static final OneAppElement SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Back.");
	private static final OneAppElement LOGGOUT_BUTTON_THAI = new OneAppElement(FindBy.ACCESSIBILITY_ID, "ออกจากระบบ");
	private static final OneAppElement LOGGOUT_BUTTON_OK_THAI = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"ตกลง\"]");
	private static final OneAppElement LOGGOUT_BUTTON = new OneAppElement(FindBy.ACCESSIBILITY_ID, "Log Out");
	private static final OneAppElement LOGGOUT_BUTTON_OK = new OneAppElement(FindBy.XPATH, "//XCUIElementTypeButton[@name=\"OK\"]");

	public static void init(Map<String, OneAppElement> oneAppElementHashMap) {
		oneAppElementHashMap.put(OneAppElementKeys.SEARCH_BAR, SEARCH_BAR);
		oneAppElementHashMap.put(OneAppElementKeys.CHANGE_LANGUAGE, CHANGE_LANGUAGE);
		oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_RESULT_VERIFY, LANGUAGE_RESULT_VERIFY);
		oneAppElementHashMap.put(OneAppElementKeys.NO_RESULT_VERIFY, NO_RESULT_VERIFY);
		oneAppElementHashMap.put(OneAppElementKeys.SEARCH_BAR_X_BUTTON, SEARCH_BAR_X_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.EXPAND_ARROW_EN, EXPAND_ARROW_EN);
		oneAppElementHashMap.put(OneAppElementKeys.EXPAND_ARROW_TH, EXPAND_ARROW_TH);
		oneAppElementHashMap.put(OneAppElementKeys.INSURANCE_THAI, INSURANCE_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.INSURANCE_ENGLISH, INSURANCE_ENGLISH);
		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_TITLE, GENERIC_ERROR_TITLE);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_TAB_THAI, MORE_TAB_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_BODY, GENERIC_ERROR_BODY);
		oneAppElementHashMap.put(OneAppElementKeys.GENERIC_ERROR_OK, GENERIC_ERROR_OK);
		oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON_THAI, LOGGOUT_BUTTON_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.LOGGOUT_BUTTON_OK_THAI, LOGGOUT_BUTTON_OK_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_BUTTON, LANGUAGE_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.LANGUAGE_BUTTON_THAI, LANGUAGE_BUTTON_THAI);
		oneAppElementHashMap.put(OneAppElementKeys.SETTING_TAB_THAI, SETTING_TAB_THAI);
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
		oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_MISSING_DETAILS, KYC_PAGE_MISSING_DETAILS);
		oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_REQUIRED_FILED, KYC_PAGE_REQUIRED_FILED);
		oneAppElementHashMap.put(OneAppElementKeys.KYC_PAGE_DETAILS_BOTTOM_LATER, KYC_PAGE_DETAILS_BOTTOM_LATER);
		oneAppElementHashMap.put(OneAppElementKeys.MORE_TAB, MORE_TAB);
		oneAppElementHashMap.put(OneAppElementKeys.ACCOUNT_BUTTON, ACCOUNT_BUTTON);
		oneAppElementHashMap.put(OneAppElementKeys.SERVICE_BUTTON, SERVICE_BUTTON);
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
	}
}
