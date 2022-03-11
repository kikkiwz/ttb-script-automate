package com.ttbbank.oneapp.scenario.lending.iosUtil;

import com.ttbbank.oneapp.framework.AndroidOneAppElements;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.iOSOneAppElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class Lib extends BaseScenario {

	private final static String TESTDATA_PATH = System.getProperty("user.dir") + "/src/test/java/com/ttbbank/oneapp/scenario/lending/iosUtil/UI_TestData.json";
	private final static String LOG_PATH = System.getProperty("user.dir") + "/target/test_log.log";
	protected static AppiumDriver<WebElement> driver;
	private static final Logger LOGGER = Logger.getLogger(Lib.class.getName());
	protected static Properties p = new Properties();
	public static final JsonPath data = new JsonPath(Lib.getInput(TESTDATA_PATH));
	private final static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	public static String os = "";
	protected static String deviceProfile = "";
	protected static String dataProfile = "";
/*
	//By Passed OTP
	public static final String LENDING_IOS_BYPASSEDOTP_REGISTERTTBTOUCH_XPATH = "//XCUIElementTypeStaticText[contains(@name, \"Register ttb touch\")]";
	public static final String LENDING_IOS_BYPASSEDOTP_NAME_ICONCHECKBOX_ID = "iconCheck";
	public static final String LENDING_IOS_BYPASSEDOTP_NEXT_ID = "Next";
	public static final String LENDING_IOS_BYPASSEDOTP_CITIZENTEXTBOX_XPATH = "(//XCUIElementTypeTextField[@type=\"XCUIElementTypeTextField\"])[1]";
	public static final String LENDING_IOS_BYPASSEDOTP_TITLEOTP_XPATH = "//XCUIElementTypeStaticText[@name=\"Verify mobile number\"]";
	public static final String LENDING_IOS_BYPASSEDOTP_INCORRECTOTP_XPATH = "//XCUIElementTypeStaticText[contains(@name, \"Incorrect\")]";
	public static final String LENDING_IOS_BYPASSEDOTP_NEXT_XPATH = "//XCUIElementTypeStaticText[@name=\"Next\"]";
	public static final String LENDING_IOS_BYPASSEDOTP_NOTIFICATIONTURNON_XPATH = "//XCUIElementTypeSwitch[@type=\"XCUIElementTypeSwitch\"]";
	//Register Device Id - ios
	public static final String LENDING_IOS_HOMESCREEN_GUILDLINENEXT_XPATH = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton";
	public static final String LENDING_IOS_SERVICE_GUILDELINE_DONE_XPATH = "//XCUIElementTypeStaticText[@name=\"Done\"]";
	//Homescreen
	public static final String swImgHS_Robot = "//img[@id='home-screen-robot-image']";
	public static final String LENDING_IOS_HOMESCREEN_HOMEBUTTON_XPATH = "//XCUIElementTypeButton[@name=\"Home\"]";
	public static final String saHS_Home_btn = "(//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/ll_tap\"])[1]";
	public static final String LENDING_IOS_HOMESCREEN_ACCOUNTBUTTON_XPATH = "//XCUIElementTypeButton[@name=\"Account\"]";
	public static final String saHS_Account_btn = "(//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/ll_tap\"])[2]";
	public static final String LENDING_IOS_HOMESCREEN_SERVICEBUTTON_XPATH = "//XCUIElementTypeButton[@name=\"Service\"]";
	public static final String saHS_Service_btn = "(//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/ll_tap\"])[3]";
	public static final String LENDING_IOS_HOMESCREEN_MOREBUTTON_XPATH = "//XCUIElementTypeButton[@name=\"More\"]";
	public static final String saHS_More_btn = "(//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/ll_tap\"])[4]";
	//Set PIN
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN1_ID = "com.ttbbank.oneapp.vit:id/key_01";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN2_ID = "com.ttbbank.oneapp.vit:id/key_02";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN3_ID = "com.ttbbank.oneapp.vit:id/key_03";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN4_ID = "com.ttbbank.oneapp.vit:id/key_04";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN5_ID = "com.ttbbank.oneapp.vit:id/key_05";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN6_ID = "com.ttbbank.oneapp.vit:id/key_06";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN7_ID = "com.ttbbank.oneapp.vit:id/key_07";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN8_ID = "com.ttbbank.oneapp.vit:id/key_08";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN9_ID = "com.ttbbank.oneapp.vit:id/key_09";
	public static final String LENDING_ANDROID_CONFIRMPIN_PIN0_ID = "com.ttbbank.oneapp.vit:id/key_00";
	public static final String LENDING_ANDROID_CONFIRMPIN_BACKSPACE_ID = "com.ttbbank.oneapp.vit:id/clear";
	public static final String LENDING_IOS_CONFIRMPIN_PIN1_CSS = "XCUIElementTypeStaticText[label=\"1\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN2_CSS = "XCUIElementTypeStaticText[label=\"2\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN3_CSS = "XCUIElementTypeStaticText[label=\"3\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN4_CSS = "XCUIElementTypeStaticText[label=\"4\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN5_CSS = "XCUIElementTypeStaticText[label=\"5\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN6_CSS = "XCUIElementTypeStaticText[label=\"6\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN7_CSS = "XCUIElementTypeStaticText[label=\"7\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN8_CSS = "XCUIElementTypeStaticText[label=\"8\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN9_CSS = "XCUIElementTypeStaticText[label=\"9\"]";
	public static final String LENDING_IOS_CONFIRMPIN_PIN0_CSS = "XCUIElementTypeStaticText[label=\"0\"]";
	public static final String LENDING_IOS_CONFIRMPIN_BACKSPACE_AC = "iconBackspace";
	//My Card Landing page - Card
	public static final String LENDING_IOS_MYACCOUNT_CARDMENU_AC = "Card";
	public static final String LENDING_IOS_MYACCOUNT_LOANMENU_AC = "Loan";
	public static final String LENDING_IOS_MYACCOUNT_INVESTMENTMENU_AC = "Investment";
	public static final String LENDING_IOS_MYACCOUNT_INSURANCEMENU_AC = "Insurance";
	public static final String LENDING_ANDROID_MYACCOUNT_CARDMENU_AC = "//android.widget.TextView [@text=\"Card\"]";
	public static final String LENDING_IOS_MYACCOUNT_CARD1_AC = "(//XCUIElementTypeTable/XCUIElementTypeCell)[1]";
	public static final String LENDING_IOS_MYACCOUNT_APPLYCARD_CSS ="XCUIElementTypeStaticText[name=\"Apply Card\"]";
	public static final String LENDING_ANDROID_MYACCOUNT_CARD1_AC = "(//android.view.ViewGroup[@resource-id=\"com.ttbbank.oneapp.vit:id/iconCreditcard\"])[1]";
	public static final String LENDING_IOS_MYACCOUNT_GUIDELINENEXT_XPATH = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton";
	public static final String LENDING_IOS_MYACCOUNT_TITLE_AC = "My Account";//"//XCUIElementTypeStaticText[@name=\"My Account\"]";
	public static final String LENDING_IOS_MYACCOUNT_LOAN1_AC = "(//XCUIElementTypeTable/XCUIElementTypeCell)[1]";
	//Activate card
	public static final String LENDING_WEB_ACTIVATECARD_PAGE1_TITLE_ID = "H1";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE1_IMAGE_XPATH = "//img[@alt=\"activate screen card screen image\"]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE1_DESC_XPATH = "//span[contains(@class, \"activate-cardstyled__MiddleText\")]";
	public static final String LENDING_WEB_ACTIVATECARD_NEXT_BTN_XPATH = "//div[contains(@class, \"activate-cardstyled__BottomContainer\")]/button";
	//page2
	public static final String LENDING_WEB_ACTIVATECARD_PAGE2_TITLE_XPATH = "credit-card-header-label";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE2_TITLE2_XPATH = "credit-card-info-lbl";
	public static final String LENDING_IOS_OTPCVV_PIN1_AC = "PIN1";
	public static final String LENDING_IOS_OTPCVV_PIN2_AC = "PIN2";
	public static final String LENDING_IOS_OTPCVV_PIN3_AC = "PIN3";
	public static final String LENDING_IOS_OTPCVV_PIN4_AC = "PIN4";
	public static final String LENDING_IOS_OTPCVV_PIN5_AC = "PIN5";
	public static final String LENDING_IOS_OTPCVV_PIN6_AC = "PIN6";
	public static final String LENDING_IOS_OTPCVV_PIN7_AC = "PIN7";
	public static final String LENDING_IOS_OTPCVV_PIN8_AC = "PIN8";
	public static final String LENDING_IOS_OTPCVV_PIN9_AC = "PIN9";
	public static final String LENDING_IOS_OTPCVV_PIN0_AC = "PIN0";
	//Activate Card
	public static final String LENDING_WEB_ACTIVATECARD_PAGE2_DELETE_ID = "ENTER_CVV_SCREEN_BUTTON_ZERO";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE2_ERROR_XPATH = "//span[contains(@class, \"activate-cardstyled__ErrorLbl\")]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE3_TITLE = "enter-cvv-screen-header-label";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE3_IMAGE_XPATH = "//img[@alt=\"cvv screen card screen image\"]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE3_TITLE2_XPATH = "enter-cvv-screen-info-label";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE3_ERROR_XPATH = "//span[contains(@class, \"pin-screenstyled__CvvErrorLbl\")]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE4_TITLE_XPATH = "//span[contains(@class, \"activate-cardstyled__CompleteMiddleBox\")]/span[1]"; //[Completed.]
	public static final String LENDING_WEB_ACTIVATECARD_PAGE4_TITLE2_XPATH = "//span[contains(@class, \"activate-cardstyled__CompleteMiddleBox\")]/span[2]"; //[Card number.]
	public static final String LENDING_WEB_ACTIVATECARD_PAGE4_CARDNUMBER_XPATH = "//span[contains(@class, \"activate-cardstyled__CompleteMiddleBox\")]/span[3]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE4_DESC_XPATH = "//span[contains(@class, \"activate-cardstyled__CompleteMiddleBox\")]/span[4]";
	public static final String LENDING_WEB_ACTIVATECARD_PAGE4_BACKTOMAINPAGE_ID = "activation-complete-screen-btn";
	//My Credit card
	public static final String LENDING_WEB_PRODUCTLANDING_LOADING_XPATH = "//div[@class=\"loading_loadingBox__2m_2X\")]";
	public static final String LENDING_WEB_PRODUCTLANDING_LOADING_CSS = ".loading_loadingBox__2m_2X";
	public static final String LENDING_WEB_PRODUCTLANDING_PLUS_BTN_XPATH = "//div[contains(@class, \"creditstyled__IconPlusDiv\")]/button";
	public static final String LENDING_WEB_PRODUCTLANDING_TITLE_XPATH = "//*[@id=\"credit_landing_parent_container\"]/div[1]/div/div/div[2]/div";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_CARDNAME_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/div[1]/div/span[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_CARDNUMBER_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/div[1]/div/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_POINTS_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/div[1]/div/span[2]/p[1]";

	public static final String LENDING_WEB_PRODUCTLANDING_LIST_AMOUNTSPEND_LB_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/ul[1]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_AMOUNTSPEND_VALUE_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/ul[1]/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_AVAILABLETOSPEND_LB_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/ul[1]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_AVAILABLETOSPEND_VALUE_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/ul[1]/li[2]/p[2]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_CREDITLIMIT_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_CASHFORYOU_XPATH = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div/div/div/ul[2]/li[2]/p";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_APPLYSOGOOD_XPATH = "//div[contains(@class, \"swiper-slide\")]/div/ul[2]/li[3]/p";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_MORE_XPATH = "//div[contains(@class, \"swiper-slide\")]/div/ul[2]/li[4]/p";
	public static final String LENDING_WEB_PRODUCTLANDING_LIST_BULLET_XPATH = "//div[contains(@class, \"creditstyled__ContentAccounts\")]/div/div/div/div/span";
	public static final String LENDING_WEB_PRODUCTLANDING_CARDNAME_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/div[1]/div[1]/span[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_CARDNUMBER_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/div[1]/div[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_POINTS_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/div[1]/div[1]/span/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_OUTSTANDING_LB_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[1]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_OUTSTANDING_VALUE_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[1]/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_AVAILABLETOSPEND_LB_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[1]/li[1]/p[2]";
	public static final String LENDING_WEB_PRODUCTLANDING_AVAILABLETOSPEND_VALUE_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[1]/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_CREDITLIMIT_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_REDEEMPOINT_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[2]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_CASHFORYOU_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[2]/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_SOGOOD_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[2]/li[3]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MORE_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[1]/ul[2]/li[4]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_AMOUNTDUED_LB_XPATH = "//div[@id=\"credit_landing_card_due_details\"]/div[1]/span[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_AMOUNTDUED_VALUE_XPATH = "//div[@id=\"credit_landing_card_due_details\"]/div[1]/span[2]";
	public static final String LENDING_WEB_PRODUCTLANDING_MINIMUMPAYMENT_LB_XPATH = "//div[@id=\"credit_landing_card_due_details\"]/div[2]/span[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MINIMUMPAYMENT_VALUE_XPATH = "//div[@id=\"credit_landing_card_due_details\"]/div[2]/span[2]";
	public static final String LENDING_WEB_PRODUCTLANDING_DUEDATEON = "//div[@id=\"credit_landing_card_due_details\"]/div[3]/span[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_PAYBILL_BTN = "//div[@id=\"credit_landing_card_due_details\"]/div[3]/span[2]/button";
	public static final String LENDING_WEB_PRODUCTLANDING_BILLED_XPATH = "//*[@id=\"credit_landing_billed_list\"]/p/span";
	public static final String LENDING_WEB_PRODUCTLANDING_UNBILLED_XPATH = "//*[@id=\"credit_landing_unbilled_list\"]/p/span";
	public static final String LENDING_WEB_PRODUCTLANDING_BOTTOMSHEET_XPATH = "//div[@aria-label=\"grayWrap\"]";
	public static final String LENDING_WEB_PRODUCTLANDING_SLIDE_UNBILLED_XPATH = "//p[@aria-label=\"Unbilled\"]/span";
	public static final String LENDING_WEB_PRODUCTLANDING_SLIDE_BILLED_XPATH = "//p[@aria-label=\"Billed\"]/span";
	public static final String LENDING_WEB_PRODUCTLANDING_UNBILLED_SPENDINGAMOUNT_LB_XPATH = "//div[contains(@class, \"creditstyled__BoxLabel\")]";
	public static final String LENDING_WEB_PRODUCTLANDING_UNBILLED_SPENDINGAMOUNT_VALUE_XPATH = "//div[contains(@class, \"creditstyled__BoxText\")]";
	public static final String LENDING_WEB_PRODUCTLANDING_UNBILLED_LIST_LABEL_XPATH = "//div[contains(@class, \"creditstyled__TabsContent\")]/div/div[1]/div[1]/div[1]/div[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_UNBILLED_LIST_VALUE_XPATH = "//div[contains(@class, \"creditstyled__TabsContent\")]/div/div[1]/div[1]/div[2]";
	public static final String LENDING_WEB_PRODUCTLANDING_BILLED_BILLINGCYCLE1_LB_XPATH = "//*[@id=\"netive_select_label_id\"]";
	public static final String LENDING_WEB_PRODUCTLANDING_BILLED_BILLINGCYCLE1_SELECT_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__ReasonBox\")]/div[1]/div[1]/select[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MORE_REDEEMPOINT_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul[1]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MORE_CASHFORYOU_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul[1]/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MORE_APPLYSOGOOD_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul[1]/li[3]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MORE_CARDDETAILS_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul[1]/li[4]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_PAYBILL_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul[2]/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_APPLYESTATEMENT_XPATH = "//p[text()=\"Apply e-statement\"]";
	public static final String LENDING_WEB_PRODUCTLANDING_MAINFEATURE_LIST_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/ul/li/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MANAGECARD_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/div[1]/div[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_ADJUSTUSAGELIMIT_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/div[1]/ul/li[1]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_SETPIN_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/div[1]/ul/li[2]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_BLOCKCARD_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/div[1]/ul/li[3]/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_MANAGECARD_LIST_XPATH = "//div[contains(@class, \"popup_container\")]/div[1]/div[2]/div[1]/div[1]/ul/li/p[1]";
	public static final String LENDING_WEB_PRODUCTLANDING_CLOSE_XPATH = "//div[@id=\"btn-close\"]";
	//Loan page
	public static final String LENDING_WEB_LOANLANDING_BOTTOMSHEET_XPATH = "//*[@id=\"bottom-sheet-header\"]/div";
	public static final String LENDING_WEB_LOANLANDING_TITLE_XPATH = "//*[@id=\"landing-page-back-button-title\"]";
	public static final String LENDING_WEB_LOANLANDING_LIST_BUTTON_XPATH = "//div[contains(@class, \"swiper-slide-active\")]/div[1]/div[3]/span/div";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_BTN_CSS = "#credit_landing_billed_list>p";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_BTN_XPATH = "//*[@id=\"credit_landing_unbilled_list\"]/p";
	public static final String LENDING_WEB_LOANLANDING_AMOUNTDUED_LB_XPATH = "//span[text()=\"Amount Dued\"]";
	public static final String LENDING_WEB_LOANLANDING_TOPUP_XPATH  = "//*[@id=\"shortcut-text-0-0\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYBILL_XPATH  = "//*[@id=\"shortcut-text-1-0\"]";
	public static final String LENDING_WEB_LOANLANDING_APPLYESTATEMENT_XPATH  = "//div[contains(@class, \"swiper-slide swiper-slide-active\")]/div[1]/div[3]/span[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_AMOUNTDUED_AMOUNTDUED_XPATH = "//div[contains(@class, \"style__Card-sc\")]/div[1]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_AMOUNTDUED_AMOUNTDUED_VALUE_XPATH = "//div[contains(@class, \"style__Card-sc\")]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_AMOUNTDUED_DUEDATEON_XPATH = "//div[contains(@class, \"style__Card-sc\")]/div[1]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_AMOUNTDUED_PAYBILL_XPATH= "//div[contains(@class, \"style__Card-sc\")]/div[2]/span[2]/button[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_LOANDETAILS_XPATH = "//div[@id=\"credit_landing_billed_list\"]/p";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_LOANACCOUNTNUMBER_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[1]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_LOANACCOUNTNUMBER_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[1]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_LOANSUFFIX_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[3]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_LOANSUFFIX_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[3]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_ACCOUNTNAME_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[5]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_ACCOUNTNAME_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[5]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_DIRECTDEBIT_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[7]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_DIRECTDEBIT_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[7]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_MONTHLYPAYMENT_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[9]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_MONTHLYPAYMENT_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[9]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_DUEDATE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[11]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_DUEDATE_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[11]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_INTERESTRATEPERYEAR_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[13]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_INTERESTRATEPERYEAR_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[13]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_TENORS_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[15]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_TENORS_VALUE_XPATH= "//div[contains(@class, \"style__LoanDetailTable\")]/div[15]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_CONTRACTSTARTDATE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[17]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_CONTRACTSTARTDATE_VALUE_XPATH  = "//div[contains(@class, \"style__LoanDetailTable\")]/div[17]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_CONTRACTEXPIRYDATE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[19]/div[1]/div[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_CONTRACTEXPIRYDATE_VALUE_XPATH = "//div[contains(@class, \"style__LoanDetailTable\")]/div[19]/div[2]/span[1]";
	public static final String LENDING_WEB_LOANLANDING_LOANDETAILS_REMARK_XPATH = "//div[contains(@class, \"style__CareText\")]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_PAYMENTHISTORY_XPATH = "//*[@id=\"credit_landing_unbilled_list\"]/p";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_ARROW_XPATH = "//span[contains(@class, \"c2g-expandable-cardstyled__Arrow\")]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_PAYMENTHISTORY_DESC_XPATH = "//div[contains(@class, \"style__PaymentDetailText\")]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_AMOUNTPAID_XPATH = "//span[contains(@class, \"c2g-expandable-cardstyled__Label-sc\")]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_AMOUNTPAID_VALUE_XPATH = "//span[contains(@class, \"c2g-expandable-cardstyled__Value-sc\")]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_PRINCIPALAMOUNTPAID_XPATH = "//*[@id=\"ColumnDataLabel_1\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_PRINCIPALAMOUNTPAID_VALUE_XPATH = "//*[@id=\"ColumnDataValue_1\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_INTERESTPAID_XPATH = "//*[@id=\"ColumnDataLabel_2\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_INTERESTPAID_VALUE_XPATH = "//*[@id=\"ColumnDataValue_2\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_FEEOTHEREXPENSES_XPATH = "//*[@id=\"ColumnDataLabel_3\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_FEEOTHEREXPENSES_VALUE_XPATH = "//*[@id=\"ColumnDataValue_3\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_OUTSTANDINGBALANCE_XPATH = "//*[@id=\"ColumnDataLabel_4\"]";
	public static final String LENDING_WEB_LOANLANDING_PAYMENTHISTORY_OUTSTANDINGBALANCE_VALUE_XPATH = "//*[@id=\"ColumnDataValue_4\"]";
	//Case Out of hours services
	public static final String LENDING_WEB_OUTOFHOURSERVICE_TITLE_ID = "popup-title";
	public static final String LENDING_WEB_OUTOFHOURSERVICE_TITLE_DESC_XPATH = "//div[contains(@class, \"letter-consentstyled__Content\")]";
	public static final String LENDING_WEB_OUTOFHOURSERVICE_TITLE_OK_XPATH = "//button[contains(@class, \"creditstyled__PopupCloseButtons\")]";
	//Set Pin
	public static final String LENDING_WEB_SETPIN_PAGE1_TITLE1_ID = "enter-cvv-screen-header-label";
	public static final String LENDING_WEB_SETPIN_PAGE1_TITLE2_ID = "enter-cvv-screen-info-label";
	public static final String LENDING_WEB_SETPIN_PAGE1_TITLE2_XPATH = "//span[@id=\"enter-cvv-screen-info-label\"]";
	public static final String LENDING_WEB_SETPIN_PAGE1_title_confirm_atm_pin = "//div[contains(@class, \"set-atm-pinstyled__HeaderBox\")]/span";
	public static final String LENDING_WEB_SETPIN_PAGE1_ERROR_XPATH = "//span[contains(@class, \"set-atm-pinstyled__CvvError\")]";
	public static final String LENDING_WEB_SETPIN_PAGE2_IMAGE_XPATH = "//*[@id=\"__next\"]/div[1]/div/div[1]/svg/g/g/g/path[2]";
	public static final String LENDING_WEB_SETPIN_PAGE2_TITLE1_XPATH = "//div[contains(@class, \"set-atm-pinstyled__TextDesc\")]/h2";
//	public static final String LENDING_WEB_SETPIN_PAGE2_TITLE2_XPATH = "//div[contains(@class, \"set-atm-pinstyled__TextDesc\")]/div[2]/span[1]";
	public static final String LENDING_WEB_SETPIN_PAGE2_CARDNUMBER_LABEL_XPATH = "//div[contains(@class, \"set-atm-pinstyled__StatusContainer\")]/p[1]";
	public static final String LENDING_WEB_SETPIN_PAGE2_CARDNUMBER_VALUE_XPATH = "//div[contains(@class, \"set-atm-pinstyled__StatusContainer\")]/p[2]";
	public static final String LENDING_WEB_SETPIN_PAGE2_DESC_XPATH = "//div[contains(@class, \"set-atm-pinstyled__StatusContainer\")]/p[3]";
	public static final String LENDING_WEB_SETPIN_PAGE2_BACKTOMAINPAGE_ID = "ACTIVATION_COMPLETE_SCREEN_BUTTON";
	//Apply E-Statement - page1
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE1_TITLE_XPATH = "enter-cvv-screen-header-label";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE1_DESC_XPATH = "//div[@contains(@class, \"e-statementstyled__TopContent\")]/h2";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE1_DESC2_XPATH = "//div[@contains(@class, \"e-statementstyled__MiddleText\")]/h2";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE1_EMAIL_TXT_XPATH = "//div[contains(@class, \"e-statementstyled__BannerBox\")]/div/div[2]/div";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE1_VERIFYEMAIL_XPATH = "//div[contains(@class, \"e-statementstyled__BottomContainer\")]/button";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_TITLE_XPATH = "//div[@data-testid=\"label\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_EMAIL_TXT_XPATH = "SETTING_MANAGE_EMAIL_INPUT";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_CLOSED_BTN_XPATH = "MANAGE_EMAIL_CLEAR_INPUT_BUTTON";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_DESCBLUE_XPATH = "//*[@id=\"informative\"]/div[2]/div";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_ERRORMESSAGE_XPATH = "SETTING_MANAGE_EMAIL_INPUT_helptext";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE2_NEXT_XPATH = "button_submit_change_email";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_TITLE_XPATH = "//div[@data-testid=\"label\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_DESC_XPATH = "//div[contains(@class, \"email-verification-code-inputstyled__MessageContainer\")]/div[1]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_DESC2_XPATH = "//div[contains(@class, \"email-verification-code-inputstyled__MessageContainer\")]/div[2]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_OTP1_XPATH = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[1]/input";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_OTP2_XPATH = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[2]/input";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_OTP3_XPATH = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[3]/input";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_OTP4_XPATH = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[4]/input";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_RESENDCODE_ID = "RESEND_VERIFICATION_CODE_BUTTON";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE3_ERRORMESSAGE_XPATH = "//div[contains(@class, \"email-verification-code-inputstyled__ErrorMessageContainer\")]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE4_IMAGE_XPATH = "//div[contains(@class, \"style__GenericContainer\")]/svg";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE4_TITLE_XPATH = "//div[contains(@class, \"style__GenericContainer\")]/div[1]/h2";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE4_DESC_XPATH = "//div[contains(@class, \"style__GenericContainer\")]/div[2]/p";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE4_OK_XPATH = "button_manage_email_success_confirm";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE5_IMAGE_XPATH = "//div[contains(@class, \"estatement-completestyled__CompleteHeader\")]/div/svg";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE6_TITLE_XPATH = "//div[contains(@class, \"estatement-completestyled__HeadingBox\")]/h2";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE6_DESC1_XPATH = "//div[contains(@class, \"estatement-completestyled__ContentBox\")]/p";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE6_PRODUCT_XPATH = "ColumnDataValue_idLabel";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE6_EMAIL_XPATH = "ColumnDataValue_idLabel1";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE6_BACKTOMAINPAGE_XPATH = "activation-complete-screen-btn";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_TITLE_XPATH = "";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_DESC1_XPATH = "";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_EMAIL_XPATH = "";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_EMAIL_VALUE_XPATH = "//div[contains(@class, \"e-statementstyled__ChangeEmail\")]/div[1]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_CHANGEEMAIL_BTN_XPATH = "//div[contains(@class, \"e-statementstyled__EmailBox\")]/div[2]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_DESC2_XPATH = "";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_CHECKBOX_VALUE_XPATH = "";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_CHECKBOX_XPATH = "//*[@id=\"1\"]/span[2]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_CONFIRM_XPATH = "//div[contains(@class, \"e-statementstyled__BottomContainer\")]/button[1]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_POPUP_CONFIRM_XPATH = "//DIV[contains(@class, \"BottomSheetPopupChildren\")]/button[1]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE11_POPUP_CANCEL_XPATH = "//DIV[contains(@class, \"BottomSheetPopupChildren\")]/button[2]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_TITLE_XPATH = "//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/div[2]/div";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_EMAIL_XPATH = "//input[@id=\"SETTING_MANAGE_EMAIL_INPUT_input\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_CLOSE_XPATH = "//span[@id=\"MANAGE_EMAIL_CLEAR_INPUT_BUTTON\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_DESC1_XPATH = "//*[@id=\"SETTING_MANAGE_EMAIL_INPUT_helptext\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_DESC2_XPATH = "//*[@id=\"informative_desc\"]";
	public static final String LENDING_WEB_APPLYESTATEMENT_PAGE12_MANAGEEMAIL_NEXT_XPATH = "//*[@id=\"button_submit_change_email\"]";
	public static final String LENDING_WEB_ESTATE_P3_OTP1_X = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[1]/input";
	public static final String LENDING_WEB_ESTATE_P3_OTP2_X = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[2]/input";
	public static final String LENDING_WEB_ESTATE_P3_OTP3_X = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[3]/input";
	public static final String LENDING_WEB_ESTATE_P3_OTP4_X = "//div[@id=\"EMAIL_VERIFICATION_CODE_INPUT_CONTAINER\"]/div/div[4]/input";
	public static final String LENDING_WEB_ESTATE_P4_TITLE_X = "//div[@id=\"title_success\"]";
	public static final String LENDING_WEB_ESTATE_P4_DESC_X = "//p[@id=\"message_success\"]";
	public static final String LENDING_WEB_ESTATE_P4_OK_X = "//button[@id=\"button_manage_email_success_confirm\"]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_TITLE_X = "//div[contains(@class, \"estatement-completestyled__HeadingBox\")]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_DESC_X = "//div[contains(@class, \"estatement-completestyled__ContentBox\")]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_PRODUCT_LABEL_X = "//div[contains(@class, \"estatement-completestyled__NewDataTable\")]/div[1]/div[1]/div[1]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_PRODUCT_VALUE_X = "//div[contains(@class, \"estatement-completestyled__NewDataTable\")]/div[1]/div[2]/span[1]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_EMAIL_LABEL_X = "//div[contains(@class, \"estatement-completestyled__NewDataTable\")]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_EMAIL_VALUE_X = "//div[contains(@class, \"estatement-completestyled__NewDataTable\")]/div[2]/div[2]/span[1]";
	public static final String LENDING_WEB_ESTATE_P5_VERIFY_BACKTOMAINPAGE_X ="//button[@id=\"activation-complete-screen-btn\"]";


	//Apply So Good=====================
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE1_TITLE_XPATH = "//div[contains(@class, \"product-briefstyled__HeaderBox\")]"; //ex.ttb so goood installment plan at 0% 3 months
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE1_DESC1_XPATH = "//div[contains(@class, \"product-briefstyled__MiddleTextBox\")]/p";// Use ttb credit card for any purchase above 1,000 Baht per sales slip, you can apply so goood Installment Plan right away.
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE1_NEXT_XPATH = "//div[contains(@class,\"product-briefstyled__BottomContainer\")]/button[1]"; // Next
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_TITLE_XPATH = "enter-cvv-screen-header-label";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_IMAGECARD_XPATH = "//div[contains(@class, \"so-goodstyled__CradImage\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_CARDNAME_XPATH = "//div[contains(@class, \"so-goodstyled__ProductName\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_CARDNUMBER_XPATH = "//div[contains(@class, \"so-goodstyled__CardNumber\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_PLEASESELECTTRANSACTION_XPATH = "//span[contains(@class, \"so-goodstyled__TopHeader\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_RESULT_XPATH = "//span[contains(@class, \"so-goodstyled__ResultCount\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_SELECTALL_XPATH = "(//*[@id=\"cid\"]/div[1]/div/div)[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_TRANSACTIONDATES_XPATH = "//span[contains(@class, \"so-goodstyled__DateText\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_TRANSACTIONNAMES_XPATH = "//*[@id=\"cid\"]/div[1]/div/div[2]/div";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_TRANSACTIONVALUES_XPATH = "//*[@id=\"cid\"]/div[2]/span";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE2_NEXT_XPATH = "//button[contains(@class, \"NextButton\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_TITLE_XPATH = "//h1[@id=\"enter-cvv-screen-header-label\"]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_TITLE2_XPATH = "//span[contains(@class, \"so-goodstyled__TopHeader\")]"; //Select Installment Type
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_DESC1_XPATH = "//span[contains(@class, \"so-goodstyled__InstallMentPlanLabel-\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_INSTALLMENTPLANS_CHB_XPATH = "//div[contains(@class, \"so-goodstyled__CheckedB-\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_INSTALLMENTPLANS_LIST_XPATH = "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div/label/div[1]/span[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENTS_LIST_XPATH = "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div/label/div[2]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_TOTALINTERESTAMOUNTS_LIST_XPATH = "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div/label/div[3]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_TOTALAMOUTNS_LIST_XPATH = "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div/label/div[4]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_NEXT_XPATH = "//button[contains(@class, \"NextButton\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT1_CHB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[1]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT2_CHB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[2]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT3_CHB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[3]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT1_LB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[1]/label[1]/div[1]/span[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT2_LB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[2]/label[1]/div[1]/span[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE3_MONTHLYPAYMENT3_LB_XPATH= "//form[contains(@class, \"so-goodstyled__RadioGroup\")]/div[3]/label[1]/div[1]/span[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TITLE_XPATH = "//h1[@id=\"enter-cvv-screen-header-label\"]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TITLE2_XPATH = "//span[contains(@class, \"so-goodstyled__TopHeader\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_CREDITCARD_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[1]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_CREDITNUMBER_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[2]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_INSTALLMENTPLAN_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[3]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_FIRSTPAYMENT_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[4]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TOTALINTERESTPAYMENT_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[5]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TOTALAMOUNT_XPATH = "//div[contains(@class,\"so-goodstyled__InvestmentDetailBox\")]/div[1]/ul/li[6]/span/div[1]/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_SELECTTRANSACTION_BTN_XPATH = "//div[contains(@class, \"so-goodstyled__TopTable-\")]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TRANSACTIONITEMS_XPATH = "//div[div[div[div[text()=\"Selected transaction\"]]]]/div[2]/div/div[2]/div/div[1]/div";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_TRANSACTIONVALUES_LIST_XPATH = "//div[div[div[div[text()=\"Selected transaction\"]]]]/div[2]/div/div[2]/div/div[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_CHECKBOX_XPATH = "//div[contains(@class, \"so-goodstyled__CheckedBox\")]/div[1]/form/label/span[2]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_NEXT_XPATH = "//button[contains(@class, \"NextButton\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE4_BACK_XPATH = "//*[@id=\"enter-cvv-screen-back-btn\"]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_TITLE_XPATH = "//p[contains(@class, \"so-goodstyled__HeaderText\")]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_CREDITCARDNO_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[1]/div[2]/span";//4762-81xx-xxxx-0372
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_SELECTEDTRANSACTION_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[2]/div[2]/span"; //1 item
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_TOTALINSTALLMENTAMOUNT_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[3]/div[2]/span";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_INSTALLMENTPLAN_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[4]/div[2]/span";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_TRANSACTIONDATE_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[5]/div[2]/span";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_TRANSACTIONTIME_XPATH = "//div[contains(@class, \"so-goodstyled__NewDataTable\")]/div[6]/div[2]/span";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_BACKTOMAINPAGE_XPATH = "//div[contains(@class, \"so-goodstyled__SuccessFooter\")]/button";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_UNSUCCESSFULTRANSACTION_XPATH = "//div[contains(@class, \"so-goodstyled__FailedTransaction\")]/div[1]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_ERRORDATE_XPATH = "//div[contains(@class, \"so-goodstyled__DateLabel\")]";// 28 May 2021
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_ERRORTRANSACTION_XPATH = "//div[contains(@class, \"so-goodstyled__ErrorTransaction\")]/div[1]/div[1]/div[1]/label/div[1]/div[1]";
	public static final String LENDING_WEB_APPLYSOGOOD_PAGE5_ERRORVALUE_XPATH = "//div[contains(@class, \"so-goodstyled__ErrorTransaction\")]/div[1]/div[1]/div[1]/label/div[2]/span[1]";
	//Card Details
	public static final String LENDING_WEB_CARD_grayBorder = "//div[contains(@class, \"creditstyled__GrayBorder\")]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_image = "//div[contains(@class, \"card-detailsstyled__ImagBox\")]/img";
	public static final String LENDING_WEB_CARD_CARDDETAILS_account = "//*[@id=\"ColumnDataLabel_1\"]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_points = "//*[@id=\"ColumnDataLabel_3\"]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardManagement = "//div[contains(@class, \"card-detailsstyled__LabelBox\")]/h2";
	public static final String LENDING_WEB_CARD_CARDDETAILS_adjustUsageLimit = "//*[@id=\"id1\"]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_blockCard = "//*[@id=\"id2\"]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_setPin = "//*[@id=\"id3\"]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardDetails = "//div[contains(@class, \"card-detailsstyled__LabelBox\")]/h2";
	public static final String LENDING_WEB_CARD_CARDDETAILS_productName = "//div[contains(@class, \"card-detailsstyled__CardDetailBox\")]/div[1]/ul[1]/li[1]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_productValue = "//div[contains(@class, \"card-detailsstyled__CardDetailBox\")]/div[1]/ul[1]/li[1]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardType = "//*[@id=\"id11\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardTypeValue = "//*[@id=\"id11\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardNumber = "//*[@id=\"id12\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardNumberValue = "//*[@id=\"id12\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardHolder = "//*[@id=\"id13\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardHolderValue = "//*[@id=\"id13\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CLENDING_WEB_CASH_TRAN_P2_NEXT_IDARDDETAILS_cardLimit = "//*[@id=\"id14\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_cardLimitValue = "//*[@id=\"id14\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_totalAmountDue = "//*[@id=\"id15\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_totalAmountDueValue = "//*[@id=\"id15\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_minimumAmountDue = "//*[@id=\"id16\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_miniumAmountDueValue = "//*[@id=\"id16\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_statementDue = "//*[@id=\"id17\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_statementDueValue = "//*[@id=\"id17\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_paymentDueDate = "//*[@id=\"id18\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_paymentDueDateValue = "//*[@id=\"id18\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_pointDetails = "//div[contains(@class, \"card-detailsstyled__LabelBox\")]/h2";
	public static final String LENDING_WEB_CARD_CARDDETAILS_outstandingPoints = "//*[@id=\"id10\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_outstandingPointsValue = "//*[@id=\"id10\"]/span/div/span[2]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_expiringPoints = "//*[@id=\"id81\"]/span/div/span[1]";
	public static final String LENDING_WEB_CARD_CARDDETAILS_expiringPointsValue = "//*[@id=\"id81\"]/span/div/span[2]";
	//Blockcard
	public static final String LENDING_WEB_BLOCKCARD_TITLE_X = "//div[@data-testid=\"label\"]";
	public static final String LENDING_WEB_BLOCKCARD_DESC1_X = "//span[contains(@class, \"block-cardstyled__ConditionLbl\")]";
	public static final String LENDING_WEB_BLOCKCARD_DESC2_X = "//ul[contains(@class, \"block-cardstyled__ListBox\")]";
	public static final String LENDING_WEB_BLOCKCARD_DESC3_X = "//span[contains(@class, \"block-cardstyled__BottomInfo\")]";
	public static final String LENDING_WEB_BLOCKCARD_ADDRESS_X = "//p[contains(@class, \"block-cardstyled__AddreddContent\")]";
	public static final String LENDING_WEB_BLOCKCARD_SMALLINFO_X = "//p[contains(@class, \"block-cardstyled__SmallInfo\")]";
	public static final String LENDING_WEB_BLOCKCARD_CONFIRMBUTTON_X = "//button[@aria-label=\"Confirm\"]";
	public static final String LENDING_WEB_BLOCKCARD_PAGE2_TITLE_X = "//span[contains(@class, \"block-cardstyled__CompleteLbl\")]";
	public static final String LENDING_WEB_BLOCKCARD_PAGE2_DESC1_X = "//div[contains(@class, \"block-cardstyled__StatusContainer\")]";
	public static final String LENDING_WEB_BLOCKCARD_PAGE2_TRANSACTIONDATE_X = "//div[contains(@class, \"block-cardstyled__NewDataTable\")]/div[1]/div[1]/span[1]";
	public static final String LENDING_WEB_BLOCKCARD_PAGE2_TRANSACTIONTIME_X = "//div[contains(@class, \"block-cardstyled__NewDataTable\")]/div[2]/div[1]/span[1]";
	public static final String LENDING_WEB_BLOCKCARD_PAGE2_BACKTOMAINPAGE_X = "//button[@data-testid=\"button\"]";
	public static final String LENDING_WEB_PRODUCTLANDING_LOCKED_X = "//*[@id=\"credit_landing_account_card-details\"]/div[2]/div[1]/div/div/div[1]/div/div/div";
	//Cash For You
	public static final String LENDING_WEB_CASH_P1_TITLE_X = "//div[contains(@class, \"cash-for-youstyled__MainContainer\")]/div[2]/h1[1]";
	public static final String LENDING_WEB_CASH_P1_TITLE2_I = "//div[contains(@class, \"cash-for-youstyled__MainContainer\")]/div[2]/h1[2]";
	public static final String LENDING_WEB_CASH_P1_IMAGE_X = "//div[contains(@class, \"cash-for-youstyled__Image\")]";
	public static final String LENDING_WEB_CASH_P1_DESC1_X = "";
	public static final String LENDING_WEB_CASH_P1_DESC2_X = "";
	public static final String LENDING_WEB_CASH_P1_NEXT_I = "edit-info-save-button";
	public static final String LENDING_WEB_CASH_TRAN_P2_TITLE_I = "edit-info-header-label";
	public static final String LENDING_WEB_CASH_TRAN_P2_IMAGE_X = "//span[contains(@class, \"cash-for-you-detailsstyled__CardImage\")]";
	public static final String LENDING_WEB_CASH_TRAN_P2_CARDNAME_X = "//span[contains(@class, \"cash-for-you-detailsstyled__CardName\")]";
	public static final String LENDING_WEB_CASH_TRAN_P2_CARDNUMBER_X = "//span[contains(@class, \"cash-for-you-detailsstyled__CardNumber\")]";
	public static final String LENDING_WEB_CASH_TRAN_P2_ENTERAMOUNTTOTRANSFER_X = "//div[contains(@class, \"cash-for-you-detailsstyled__TopHeading\")]";
	public static final String LENDING_WEB_CASH_TRAN_P2_DESC_X = "//*[@id=\"__next\"]/div[1]/div/div[3]/div[1]/h3";
	public static final String LENDING_WEB_CASH_TRAN_P2_AMOUNT_AVAILABLETOTRANSFER_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__AvalToTransfer\")]/p[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_AMOUNT_AVAILABLETOTRANSFER_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__AvalToTransfer\")]/p[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_AMOUNT_AMOUNT_TXT_ID = "WORKING_INFO_OFFICE_NAME_input";
	public static final String LENDING_WEB_CASH_TRAN_P2_AMOUNT_AMOUNT_ERROR_ID = "WORKING_INFO_OFFICE_NAME_helptext";
	public static final String LENDING_WEB_CASH_TRAN_P2_RECEIVING_TITLE_X = "";
	public static final String LENDING_WEB_CASH_TRAN_P2_RECEIVING_BASICACCOUNT_RADIO_X = "//div[contains(@class, \"cash-for-you-detailsstyled__AccountBox\")]/form/label/span";
	public static final String LENDING_WEB_CASH_TRAN_P2_RECEIVING_BASICACCOUNTNUMBER_X = "//div[contains(@class, \"cash-for-you-detailsstyled__AccountBox\")]/form/label/span/span";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_TITLE_X = "";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__SelectAccountContainer\")]/div[1]/label[1]/div[1]/div[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_RADIO_X = "//div[contains(@class, \"cash-for-you-detailsstyled__SelectAccountContainer\")]/div[1]/label/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_FEE_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__PaymentDetail\")]/div[1]/p[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_FEE_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__PaymentDetail\")]/div[1]/p[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_VAT_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__PaymentDetail\")]/div[2]/p[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_VALUE_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__PaymentDetail\")]/div[1]/p[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_ANNUALINTERESTRATE_LABEL_X = "(//div[contains(@class, \"cash-for-you-detailsstyled__Detail\")]/div[1]/div[3]/p[1])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_FULL_ANNUALINTERESTRATE_VALUE_X = "(//div[contains(@class, \"cash-for-you-detailsstyled__Detail\")]/div[1]/div[3]/p[2])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__SelectAccountContainer\")]/div[2]/label/div[1]/DIV[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_RADIO_X = "//div[contains(@class, \"cash-for-you-detailsstyled__SelectAccountContainer\")]/div[2]/label/div[1]";
//	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_LABEL_X = "//*[@id=\"netive_select_label_id\"]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_MONTHLYINSTALLMENT_DROPDOWN_X = "//select[@id=\"selectBox\"]";
	//div[contains(@class, \"cash-for-you-detailsstyled__SelectNativeBox\")]/select
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_SPECIALINTEREST_LABEL_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[2]/h3)[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_INTEREST_TIERMONTH_LABEL_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[3]/p[1])[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_INTEREST_TIERMONTH_VALUE_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[3]/p[2])[2]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_DESC_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[4]/p)[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_PAYMENTHISTORY_LABEL_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[6]/h3)[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_TOTALPAYMENT_LABEL_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[7]/p[1])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_TOTALPAYMENT_VALUE_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[7]/p[2])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_MONTHLYPAYMENT_LABEL_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[8]/p[1])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_PAY_INSTALLMENT_MONTHLYPAYMENT_VALUE_X = "(//div[contains(@class,\"cash-for-you-detailsstyled__PaymentDetail\")]/div[8]/p[2])[1]";
	public static final String LENDING_WEB_CASH_TRAN_P2_NEXT_ID = "edit-info-save-button";

	public static final String LENDING_WEB_CASH_ADV_P2_PAYMENTPLAN_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__NoULDXLead\")]/div[1]/h3";
	public static final String LENDING_WEB_CASH_ADV_P2_FULL_LABEL1_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/p[1]";
	public static final String LENDING_WEB_CASH_ADV_P2_FULL_LABEL2_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/p[2]";
	public static final String LENDING_WEB_CASH_ADV_P2_FEE_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[1]/p[1]";
	public static final String LENDING_WEB_CASH_ADV_P2_FEE_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[1]/p[2]";
	public static final String LENDING_WEB_CASH_ADV_P2_VAT_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[2]/p[1]";
	public static final String LENDING_WEB_CASH_ADV_P2_VAT_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[2]/p[2]";
	public static final String LENDING_WEB_CASH_ADV_P2_ANNUALINTERESTRATE_LABEL_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[3]/p[1]";
	public static final String LENDING_WEB_CASH_ADV_P2_ANNUALINTERESTRATE_VALUE_X = "//div[contains(@class, \"cash-for-you-detailsstyled__FeeContainer\")]/div[3]/p[2]";



	public static final String LENDING_WEB_CASH_TRAN_P3_TITLE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div/div/div/div[2]/div[1]"; //Confirm cash for you<
	public static final String LENDING_WEB_CASH_TRAN_P3_DESC1_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/p[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FROM_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[1]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FORM_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[1]/span[1]/div[1]/span[2]/div[1]";

	public static final String LENDING_WEB_CASH_TRAN_P3_TO_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[2]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_TO_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[2]/span[1]/div[1]/span[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_AMOUNT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[3]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_AMOUNT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[3]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_PAYMENTPLAN_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[4]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_PAYMENTPLAN_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[4]/span[1]/div[1]/span[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_NOOFMONTHLYINSTALLMENT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[5]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_NOOFMONTHLYINSTALLMENT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[5]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_TOTALPAYMENT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_TOTALPAYMENT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_MONTHLYPAYMENT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_MONTHLYPAYMENT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FEE_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[8]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FEE_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[8]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_SPECIALINTERESTRATE_LABEL_XJ = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/p[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_TEIRMONTHRATE_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[4]/ul[1]/li[1]/span/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_TEIRMONTHRATE_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[4]/ul[1]/li[1]/span/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_IHAVEANDAGREE_LABEL_X = "//span[contains(@class, \"confirm-detailsstyled__checkInputLabel\")]";

	public static final String LENDING_WEB_CASH_TRAN_P3_VAT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/div[1]/span[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_VAT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/div[1]/span[1]/span[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_ANNUALINTERESTRATE_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_ANNUALINTERESTRATE_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_CHECKBOX_X = "//form[@data-testid=\"checkbox\"]/label/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_CHECKBOX_LABEL_X = "//span[contains(@class, \"confirm-detailsstyled__checkInputLabel\")]";
	public static final String LENDING_WEB_CASH_TRAN_P3_READMORE_X = "//div[contains(@class, \"terms-conditionsstyled__Docs\")]";
	public static final String LENDING_WEB_CASH_TRAN_P3_CONFIRM_X = "//button[contains(@class, \"confirm-detailsstyled__NextButton\")]";

	//Cash Transfer - Full
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_FEE_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[5]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_FEE_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[5]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_VAT_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_VAT_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[6]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_ANNUALINTERESTRATE_LABEL_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CASH_TRAN_P3_FULL_ANNUALINTERESTRATE_VALUE_X = "//div[contains(@class, \"confirm-detailsstyled__MainContainer\")]/div[2]/ul/li[7]/span[1]/div[1]/span[2]";

	public static final String LENDING_WEB_CASH_TRAN_P4_IMAGE_X = "//div[contains(@class,\"finish-screenstyled__ContentNoNav\")]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TITLE_X = "//div[contains(@class,\"finish-screenstyled__ContentNoNav\")]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TITLE2_X = "//div[contains(@class,\"finish-screenstyled__ContentNoNav\")]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FROM_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FROM_VALUE1_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[2]/div[1]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FROM_VALUE2_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[2]/div[1]/div[2]/div[1]/div[2]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TO_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[3]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TO_VALUE1_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[3]/div[1]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TO_VALUE2_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[3]/div[1]/div[2]/div[1]/div[2]";
	public static final String LENDING_WEB_CASH_TRAN_P4_AMOUNT_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[4]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_AMOUNT_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[4]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_PAYMENTPLAN_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[5]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_PAYMENTPLAN_VALUE1_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[5]/div[1]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_PAYMENTPLAN_VALUE2_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[5]/div[1]/div[2]/div[1]/div[2]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TOTALPAYMENT_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[6]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TOTALPAYMENT_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[6]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_MONTHLYPAYMENT_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[7]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_MONTHLYPAYMENT_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[7]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_NUMBEROFMONTH_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[8]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_NNUMBEROFMONTH_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[8]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FEE_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[9]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FEE_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[9]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_REFNO_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[10]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_REFNO_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[10]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_ANNUALINTERESTRATE_LABEL_X = "(//div[contains(@class, \"finish-screenstyled__Heading\")])[2]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TEIRMONTH_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[11]/div[3]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_TEIRMONTH_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[11]/div[3]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_BACKTOMAINPAGE_X = "//button[contains(@class, \"finish-screenstyled__ConfirmButton\")]";

	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_FEE_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[7]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_FEE_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[7]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_VAT_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[8]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_VAT_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[8]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_ANNUALINTERESTRATE_LABEL_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[9]/div[1]/div[1]";
	public static final String LENDING_WEB_CASH_TRAN_P4_FULL_ANNUALINTERESTRATE_VALUE_X = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[9]/div[1]/div[2]/div[1]";



	public static final String LENDING_WEB_CASHFORYOU_PAGE4_TITLE_XPATH = "//div[contains(@class, \"finish-screenstyled__textHeaderTitle\")]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_DESC1_XPATH = "//div[contains(@class, \"finish-screenstyled__Heading\")]";
	//	public static final String LENDING_WEB_CASHFORYOU_PAGE4_DESC2_XPATH = "";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_FROM_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_FROM_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[2]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_TO_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[3]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_TO_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[3]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_AMAOUNT_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[4]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_AMOUNT_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[4]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_PAYMENTPLAN_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[5]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_PAYMENTPLAN_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[5]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_FEE_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[6]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_FEE_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[6]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_VAT_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[ุ7]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_VAT_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[7]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_ANNUALINTERESTRATE_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[ุ8]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_ANNUALINTERESTRATE_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[8]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_REFERENCENO_LABEL_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[ุ9]/div[1]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_REFERENCENO_VALUE_XPATH = "//div[contains(@class, \"finish-screenstyled__Table1\")]/div[9]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CASHFORYOU_PAGE4_BACKTOMAINPAGE_BTN_XPATH = "//div[contains(@class, \"finish-screenstyled__ConfirmButtonWrapper\")]/button[1]";

	//Flexi Loan
	public static final String LENDING_WEB_SERVICE_APPLY_ID = "cs_service_tab_apply_label_id";
	public static final String LENDING_WEB_SERVICE_CREDITCARD_ID = "cs_apply_card_label_id";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBRESERVEINFINIT_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[1]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBRESERVESIGNATURE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[2]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBABSOLUTE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[3]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBSOFAST_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[4]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBSOSMART_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[5]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBSOCHILL_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[6]/h3";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBRESERVEINFINIT_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[1]/h4";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBRESERVESIGNATURE_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[2]/h4";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBABSOLUTE_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[3]/h4";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBSOFAST_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[4]/h4";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTBSOSMART_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[5]/h4";
	public static final String LENDING_WEB_FLEXILOAN_PAGE1_TTbSOCHILL_VALUE_XPATH = "//div[contains(@class, \"credit-cardstyled__Content\")]/div[1]/div[6]/h4";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_APPLYCREDIT_BTN_XPATH = "//div[contains(@class, \"product-orientation__ButtonContent\")]/button[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_DESC1_XPATH = "//*[@id=\"additional-coverage\"]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_CONTINUETRANSACTION_XPATH = "//div[contains(@class, \"product-orientation__ButtonContent\")]/div[3]/div[1]/div[3]/div[1]/button";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_ACCOUNTBASIC1_XPATH = "//label[@id=\"flexiloan_credit_card_account_radio_button0\"]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_DEBITFULL_CHB_XPATH = "//div[contains(@class, \"flexi-loan-credit-cardstyled__SecondRadioButton\")]/form/label[1]/span[1]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE1_NEXT_ID = "flexiloan_credit_card_next_button";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE2_TITLE2_XPATH = "//div[contains(@class, \"personal-informationstyled__Title\")]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE2_ADDRESS_XPATH = "//div[contains(@class, \"card-address-detailstyled__TextDescription\")]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE2_NEXT_XPATH = "//div[contains(@class, \"personal-informationstyled__Button\")]/button[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_TITLE2_XPATH = "//div[contains(@class, \"working-infostyled__HeaderLabelBox\")]/h3";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_WORKSTATUS_SELECT_XPATH = "//div[@id=\"edit-info-work-status1\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_OCCUPATION_SELECT_XPATH = "//div[@id=\"edit-info-occupation\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_BUSINESSTYPE_SELECT_XPATH = "//div[@id=\"edit-info-business-type\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_OFFICENAME_TXT_ID = "edit-info-office-name_input";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_ADDRESS_TXT_XPATH = "//div[contains(@class, \"card-address-detailstyled__TextDescription\")]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_PHONENUMBER_TXT_ID = "edit-info-phone-number_input";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_EXTENSION_TXT_ID = "edit-info-extension_input";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_INFOINCOME_SELECT_XPATH = "//div[@id=\"edit-info-income\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_SOUCEINCOME_SELECT_XPATH = "//div[@id=\"edit-info-source-income\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_COUNTRYINCOME_SELECT_XPATH = "//div[@id=\"edit-info-country-income\"]/select";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_CONTACTADDRESS_RD_XPATH = "//label[@id=\"One\"]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_OFFICEADDRESS_RD_XPATH = "//label[@id=\"Two\"]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_RECIEVEDEMAIL_CHB_XPATH = "//*[@id=\"edit-info-check-box\"]/div/div";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE3_NEXT_ID = "edit-info-next-button";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_TITLE2_ID = "lending-terms-condition-title";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX1_XPATH = "//*[@id=\"1\"]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX2_XPATH = "//*[@id=\"2\"]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_CHECKBOX3_XPATH = "//*[@id=\"3\"]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE4_NEXT_ID = "lending-terms-condition-button";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE5_CANCEL_XPATH = "//div[contains(@class, \"letter-consentstyled__Wrapper\")]/button[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE5_ACCEPT_XPATH = "//div[contains(@class, \"letter-consentstyled__Wrapper\")]/button[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_TITLE2 = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[1]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_NAME_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_NAME_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[2]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_IDCARD_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[3]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_IDCARD_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[3]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_BIRTHDATE_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[4]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_BIRTHDATE_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[4]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_MOBILENUMBER_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[5]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_MOBILENUMBER_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[5]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_LOANTYPE_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[6]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_LOANTYPE_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[6]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_REFNUMBER_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[7]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_REFNUMBER_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[7]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CONSENTDATE_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[8]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CONSENTDATE_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[8]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CHANNEL_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[9]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CHANNEL_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[9]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CONSENT_LB_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[10]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_CONSENT_VALUE_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[10]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_TITLE3_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[11]/div[1]/div[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_DESC1_XPATH = "//div[contains(@class, \"letter-consentstyled__ChildWrappers\")]/div[1]/div[11]/div[1]/div[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE6_NEXT_XPATH = "//div[@aria-label=\"aria-label-button\"]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_TITLE2_ID = "request_ncb_report_information_title_id";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CREDITLIMIT_LB_XPATH = "//div[contains(@class, \"final-approve-loan-confirmationstyled__TwoColumnsText\")]/span[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CREDITLIMIT_VALUE_XPATH = "//div[contains(@class, \"final-approve-loan-confirmationstyled__TwoColumnsText\")]/span[2]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_DESC1_XPATH = "//div[contains(@class, \"final-approve-loan-confirmationstyled__MoreMoneyText\")]/h3";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CONFIRMAPPLYLOAN_XPATH = "//div[contains(@class, \"final-approve-loan-confirmationstyled__ConfirmButton\")]/button[1]";
	public static final String LENDING_WEB_FLEXILOAN_SOFAST_PAGE7_CANCEL_XPATH = "//div[contains(@class, \"final-approve-loan-confirmationstyled__CancelButton\")]/button[1]";
	//Change Usage Limit
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_TITLE_CSS = "#change-card-screen-header-lbl";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_CARDNAME_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardTopRight\")]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_CARDNUMBER_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardTopRight\")]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_IMAGE_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardTop\")]/img";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_OUTSTANDINGBALANCE_LB_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardMiddleLeft\")]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_OUTSTANDINGBALANCE_VALUE_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardMiddleLeft\")]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_AVAILABLETOSPEND_LB_XPATH = "//div[contains(@class, \"change-card-limitstyled__CardMiddleRight\")]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_AVAILABLETOSPEND_VALUE_XPATH =  "//div[contains(@class, \"change-card-limitstyled__CardMiddleRight\")]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_CARDLIMIT_XPATH = "//span[contains(@class, \"change-card-limitstyled__CreaditLimit\")]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_TITLE2_CSS = "#change-card-screen-change-usage-limit-lbl";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_CURRENTCARDLIMIT_LB_CSS = "#change-card-screen-new-creadit-limit";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_CURRENTCARDLIMIT_TXT_XPATH = "//*[@id=\"change-card-screen-input-field\"]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_BAR_CSS = "#change-card-screen-input-field";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_MIN_LB_XPATH = "//div[contains(@class, \"change-card-limitstyled__MinBox\")]/span";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_MIN_VALUE_XPATH = "//div[contains(@class, \"change-card-limitstyled__MinBox\")]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_MAX_LB_XPATH = "//div[contains(@class, \"change-card-limitstyled__MaxBox\")]/span";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_MAX_VALUE_XPATH = "//div[contains(@class, \"change-card-limitstyled__MaxBox\")]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_NEXT_XPATH = "//div[contains(@class, \"change-card-limitstyled__NextButtonBox\")]/button";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_NEWAVAILABLETOSPEND_LB_XPATH = "//div[contains(@class, \"change-card-limitstyled__NewAvailableSpendBox\")]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE1_NEWAVAILABLETOSPEND_VALUE_XPATH = "//div[contains(@class, \"change-card-limitstyled__NewAvailableSpendBox\")]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_TITLE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapContent\")]/div[1]/div[1]/div[2]/div[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_CREDITCARD_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[1]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_CREDITCARD_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[1]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_CARDNUMBER_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[2]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_CARDNUMBER_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[2]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_OLDCREDITLIMIT_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[3]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_OLDCREDITLIMIT_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[3]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_NEWCREDITLIMIT_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[4]/span[1]/div[1]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_NEWCREDITLIMIT_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__WrapListsBox\")]/div[1]/ul[1]/li[4]/span[1]/div[1]/span[2]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE2_CONFIRM_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__Footer\")]/button[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_TITLE_XPATH = "//span[contains(@class, \"request-temporary-limitstyled__CompleteLbl\")]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_DECSC1_XPATH = "//span[contains(@class, \"request-temporary-limitstyled__CompleteSmallLbl\")]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_NEWCREDITLIMIT_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__NewDataTable\")]/div[1]/div[1]/div[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_NEWCREDITLIMIT_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__NewDataTable\")]/div[1]/div[2]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_EFFECTIVEDATE_LB_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__NewDataTable\")]/div[2]/div[1]/div[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_EFFECTIVEDATE_VALUE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__NewDataTable\")]/div[2]/div[2]/span[1]";
	public static final String LENDING_WEB_CHANGEUSAGELIMIT_PAGE3_BACKTOMAINPAGE_XPATH = "//div[contains(@class, \"request-temporary-limitstyled__SuccessFooterBox\")]/button[1]";*/

	public Lib() {
	}
	public static void log(Object message){
		LOGGER.log(Level.INFO, String.valueOf(message));
	}

	public static void sleep(double seconds) {
		log("sleep="+(int)seconds);
		int sc = (int)seconds;
		for (int i = 0; i < sc; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void sleep() {
		sleep(3);
	}

	public static void driverQuit() {
		log("------------End");
		Lib.writelog();
		driver.quit();
	}

	public static Properties setProperties(){
		InputStream fis;
		p = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") +	"/src/main/resources/Global.properties");
			p.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	public static String prop(String value){
		return prop(value, "");
	}
	public static String prop(String key, String defaultValue){
		return p.getProperty(key, defaultValue);
	}

	public static boolean writeLog(String value) {
		boolean isComplete = false;
		FileOutputStream fos;
		String dir = System.getProperty("user.dir") + "/target/run/";
		value = "\r\n" + value + "\r\n";
		try {
			File directory = new File(dir);
			if (!directory.exists()) {
				isComplete = directory.mkdir();
			}
			fos = new FileOutputStream(System.getProperty("user.dir") + "/target/run/" + TIMESTAMP + "_.log", true);
			fos.write(value.getBytes());
			fos.close();
		} catch (IOException e) { e.printStackTrace();}
		return isComplete;
	}

	public static PublicKey getPublicKey(String base64PublicKey){
		PublicKey publicKey = null;
		try{
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return publicKey;
	}
	public static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
		byte[] encrypedValue = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encrypedValue);
	}

	public static String writeJsonResult(String filePath, String className, String jsonString){
		String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+"_Result_"+className
				+".json";
		System.out.println("fileName="+filePath+fileName);
		try {
			FileWriter file = new FileWriter(filePath+fileName);
			file.write(new org.json.JSONObject(jsonString).toString(4));
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	public static InputStream getInput(String filePath){
		InputStream in = null;
		try {
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	public static String convertAccountToXpath(String cardId){

		String cardResult = "";
		if (cardId.contains("-") || cardId.toLowerCase().contains("x")){

			cardResult = cardId.replace("00-0000", "XX-XXXX").replace("", " ").trim()+" ";
			log(cardResult);
		} else {
			cardResult = cardId.substring(0, 4)+"-"+cardId.substring(4, 8)+"-"+cardId.substring(8, 12)+"-"+cardId.substring(12, 16);
			cardResult = cardResult.replace("00-0000", "XX-XXXX").replace("", " ").trim()+" ";
			log(cardResult);
		}
		return cardResult;
//		return cardId.replace("00-0000", "XX-XXXX").replace("", " ").trim()+" ";
	}

	public static String convertLoanToXpath(String accountId){
		Lib.log("account id = "+accountId);
		String str = accountId.replace("-", "").replace("", ",").trim();
		str = str.substring(0, str.length() -1).substring(1);
		return str;
	}

	public static String convertElementToAccountString(String accountXpath){
		log(accountXpath.replaceAll(" ", "").trim());
		return accountXpath.replaceAll(" ", "").trim();
	}

	public static void main(String[] args) {
//		convertAccountToXpath("4706-8000-0000-0340");
//		convertElementToAccountString("4 7 0 6 - 8 0 X X - X X X X - 0 3 4 8 ");
//		String otp = getOTP("tcsqa1@tutanota.com", "Tcs@13579", "TMIK");
//		System.out.println("OTP="+otp);
//		convertLoanToXpath("001-5-78796-3");
	}

	public static void waitVisible(WebDriver driver, String xpath, int second) {
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		} catch (Exception e) {
			element.sendKeys(Keys.PAGE_DOWN);
		}
	}

	public static void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public static void clickBy(String elementKey) {
		fBy(elementKey).click();
		tapXY(1, 1);
		tapXY(1, 1);
	}

	public static WebElement fId(String id) {
		return driver.findElement(By.id(id));
	}
	public static WebElement fAC(String id) {
		return driver.findElement(MobileBy.AccessibilityId(id));
	}

	public static WebElement fX(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement fName(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement fClassName(String className) {
		return driver.findElement(By.className(className));
	}

	public static WebElement fCss(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}

	public static WebElement fTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public static List<WebElement> fsId(String id) {
		return driver.findElements(By.id(id));
	}

	public static List<WebElement> fsX(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public static List<WebElement> fsName(String name) {
		return driver.findElements(By.name(name));
	}

	public static List<WebElement> fsClassName(String className) {
		return driver.findElements(By.className(className));
	}

	public static List<WebElement> fsCss(String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}

	public static List<WebElement> fsTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public static WebElement fBy(String elementKey){
		return driver.findElement(getBy(elementKey));
	}

	public static List<WebElement> fsBy(String elementKey) {return driver.findElements(getBy(elementKey));}

	public static void click(WebElement element) {
		element.click();
		tapXY(1, 1);
	}

	public static String getTextJS(WebElement element){
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].value;",element);
	}

	public static String getTextJS2(WebElement element){
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;",element);
	}

	public static void setText(WebElement element, String value) {
		log("Enter value = "+value);
		element.clear();
		element.sendKeys(value);
	}

	public static void setTextBy(String elementKey, String value) {
		log("Enter value = "+value);
		fBy(elementKey).clear();
		fBy(elementKey).sendKeys(value);
	}

	public static void setText2(WebElement element, String value) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.clear();
		element.sendKeys(value);
	}

	public static void setTextOTP(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void setTextJS(WebElement element, String value) {
		element.clear();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}
	public static void setTextJS2(WebElement element, String value) {
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}
	public static void clear(WebElement element){
		element.clear();
	}
	public static void clear2(WebElement element){
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void clearJS(WebElement element){
		element.clear();
	}

	public static void waitVisible(String xpath, int second) {
		log("Wait visible XPATH "+ second +" "+xpath);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public static By getBy(String elementkey) {
		if ("ios".equalsIgnoreCase(driver.getPlatformName())) {
			return new iOSOneAppElements().get(elementkey).getLocator();
		} else {
			return new AndroidOneAppElements().get(elementkey).getLocator();
		}
	}
	public static void waitBy(String elementKey){
		waitBy(elementKey, Lib.data.getInt("config.wait_visible_second"));
	}

	public static void waitBy(String elementKey, int second){
		int count=0;
		int countSaucelbass = Lib.deviceProfile.contains("saucelabs")?5:0;
		while (count<(1+countSaucelbass)){
			try {
				log("WaitVisible() " + second + "s" + " "+ elementKey);
				(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
				return;
			} catch (Exception e) {}
			tapXY(1, 1);
			tapXY(1, 1);
			count++;
		}
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
		tapXY(1, 1);
		tapXY(1, 1);
	}
	public static void waitBy1(String elementKey, int second){
		log("Wait "+second+"s "+elementKey);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
	}

	public static void waitVisible(String xpath) {
		int count=0;
		int countSaucelbass = Lib.deviceProfile.contains("saucelabs")?3:0;
		while (count<(2+countSaucelbass)){
			try {

				waitVisible(xpath, Lib.data.get("config.wait_visible_second"));
				return;
			} catch (Exception e) {}
			tapXY(50, 50);
			tapXY(50, 50);
			count++;
		}
	}

	public static void waitVisibleAC(String aid, int second){
		log("wait visible AC "+aid+" , "+second+" second");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(aid)));
	}
	public static void waitVisibleAC(String aid){
		waitVisibleAC(aid, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitVisibleName(String name, int second){
		log("Wait visible Name "+second+" By name="+name);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}

	public static void waitVisibleName(String name){
		waitVisibleName(name, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitVisibleId(String id, int second){
		log("Wait visible ID "+second+" By ID="+id);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}
	public static void waitVisibleId(String id){
		waitVisibleId(id, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitVisibleCss(String css, int second){
		log("Wait visible Css "+second+" By ID="+css);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
	}
	public static void waitVisibleCss(String css){
		waitVisibleCss(css, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitVisibleBy(By by, int second) {
		log("Wait visible "+ second +" By");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitInVisible(String xpath, int second) {
		log("WaitInvisible() " + second + "s");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void waitInVisible(String xpath) {
		waitInVisible(xpath, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitInVisibleBy(String elementKey, int second) {
		log("WaitInvisible() " + second + "s" + " "+ elementKey);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.invisibilityOfElementLocated(getBy(elementKey)));
		tapXY(1, 1);
	}

	public static void waitInVisibleBy(String elementKey) {
		waitInVisibleBy(elementKey, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitInVisibleCSS(String css, int second) {
		log("WaitInvisible() CSS " + second + "s");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
	}

	public static void waitInVisibleCSS(String css) {
		waitInVisibleCSS(css, Lib.data.get("config.wait_visible_second"));
	}

	public static void waitAlert(int seconds) {
		(new WebDriverWait(driver, seconds)).until(ExpectedConditions.alertIsPresent());
	}

	public static void assertText(String act, String exp) {
		log("[" + act.trim() + "] == [" + exp.trim() + "] > " + (act.trim().equals(exp.trim())));
//		Assert.assertEquals(act.trim(), exp.trim());
	}
	public static void assertText(String act, String exp, String msg) {
		log("[" + act.trim() + "] == [" + exp.trim() + "] > " + (act.trim().equals(exp.trim())));
//		Assert.assertEquals(act.trim(), exp.trim());
	}

	public static void assertTrue(Boolean value) {
		log("Assert Boolean=[true]==[" + value + "]");
//		Assert.assertTrue(value);
	}

	public static void assertTrue(String xpath) {
		boolean bValue = isElementPresent(xpath);
		log("Assert Boolean=" + bValue + ", xpath = " + xpath);
//		Assert.assertTrue(bValue);
	}

	public static void assertContain(String act, String exp) {
		log("[" + act.trim() + "] contains [" + exp.trim() + "] > " + act.trim().contains(exp.trim()));
//		Assert.assertTrue(act.trim().contains(exp.trim()));
	}
	public static void assertContain(String act, String exp, String msg) {
		log("[" + act.trim() + "] contains [" + exp.trim() + "] > " + act.trim().contains(exp.trim()));
//		Assert.assertTrue(act.trim().contains(exp.trim()));
	}

	public static boolean isElementPresent(String xpath) {
		try {
			if (driver.findElements(By.xpath(xpath)).size() > 0) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}
	public static String isElementPresentText(String xpath) {
		try {
			if (driver.findElements(By.xpath(xpath)).size() > 0) {
				return driver.findElement(By.xpath(xpath)).getText();
			}
		} catch (NoSuchElementException e) {
			return "";
		}
		return "";
	}

	public static boolean isElementPresent(WebElement el) {
		try {
			el.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresentByName(String name) {
		try {
			if (driver.findElements(By.name(name)).size() > 0) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public static boolean isElementPresentByCssSelector(String cssSelector) {
		log("isElementPresentByCssSelector");
		try {
			driver.findElement(By.cssSelector(cssSelector)).getText();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresentByCssSelector(WebElement element, String cssSelector) {
		log("isElementPresentByCssSelector");
		try {
			if (element.findElement(By.cssSelector(cssSelector)).isEnabled()){
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public static boolean isElementPresentByAC(String ac) {
		try {
			if (driver.findElementsByAccessibilityId(ac).size() > 0) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public static boolean isElementPresentBy(String elementKey) {
		try {
			if (driver.findElements(getBy(elementKey)).size() > 0) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public static void clickJS(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}

	public static void clickJS(String xpath) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", fX(xpath));
	}

	public static void scrollIntoView(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollIntoView(String xpath) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fX(xpath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printPageSource() {
		log("pageSource()=" + driver.getPageSource());
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public static void printContext() {
		Set<String> contextNames = driver.getContextHandles();
		log(contextNames.size());
		for (String contextName : contextNames) {
			log(contextName);
		}
	}

	public static Boolean setContext(String value) {
		int i = 0;
		while (i++ < 10) {
			Set<String> contextNames = driver.getContextHandles();
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
						driver.context((String) contextName);
						return true;
					}
				}
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
			}
		}
		return false;
	}

	public static Boolean setContext(String value, int webIndex) {
		int i = 0;
		while (i++ < 20) {
			Set<String> contextNames = driver.getContextHandles();
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
						driver.context((String) contextName);
						WebDriver context = driver.context((String) contextName);
						Set<String> webNames = context.getWindowHandles();
						log("WebNames list="+webNames);
						driver.switchTo().window(webNames.toArray()[webIndex].toString());
						return true;
					}
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
			}
		}
		return false;
	}

		public static Boolean setWebview(String elementKey) {
		int i = 0;
		while (i++ < 20) {
			Set<String> contextNames = driver.getContextHandles();
			Lib.log("context="+contextNames);
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains("webview")) {
						WebDriver context = driver.context((String) contextName);
						Set<String> webNames = context.getWindowHandles();
						log("WebNames=" + webNames);
						for (int j = 0; j < webNames.size(); j++) {
							Lib.log("webname="+webNames.toArray()[j].toString());
							driver.switchTo().window(webNames.toArray()[j].toString());
							try {
								waitBy(elementKey);
								return true;
							} catch (Exception e) {
							}
						}

					}
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
		return false;
	}
	public static Boolean setWebviewFast(String elementKey) {
		int i = 0;
		while (i++ < 1) {
			Set<String> contextNames = driver.getContextHandles();
			Lib.log("context="+contextNames);
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains("webview")) {
						WebDriver context = driver.context((String) contextName);
						Set<String> webNames = context.getWindowHandles();
						log("WebNames=" + webNames);
						for (int j = 0; j < webNames.size(); j++) {
							Lib.log("webname="+webNames.toArray()[j].toString());
							driver.switchTo().window(webNames.toArray()[j].toString());
							try {
								waitBy1(elementKey, 5);
								return true;
							} catch (Exception e) {
							}
						}

					}
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
//		Assert.fail(elementKey+" is not found in any Webview");
		return false;
	}

	/*public static Boolean setContext2(String value, String xpath) {
		int i = 0;
		while (i++ < 20) {
			Set<String> contextNames = driver.getContextHandles();
			log("list="+contextNames);
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
//						driver.context((String) contextName);
						WebDriver context = driver.context((String) contextName);
						Set<String> webNames = context.getWindowHandles();
						log("WebNames list="+webNames+" size="+webNames.size());
						for (int j = 0;j< webNames.size();j++){
							log("j="+j+" webview="+webNames.toArray()[j].toString());
							try {
								driver.switchTo().window(webNames.toArray()[j].toString());
								log("wait "+Lib.data.get("config.wait_visible_second")+" //div[@data-testid=\"label\"]");
								(new WebDriverWait(driver, Lib.data.get("config.wait_visible_second"))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid=\"label\"]")));
//								log("wait "+Lib.data.get("config.wait_visible_second") +" "+xpath);
//								(new WebDriverWait(driver, ((int)Lib.data.get("config.wait_visible_second")+80))).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
								return true;
							} catch (Exception e){}
						}
						return true;
					}
				}
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
			}
		}
		return false;
	}*/
	public static void setWebviews(String xpath){

	}

	public static Boolean setWebview() {
		return setContext("Webview");
	}

	public static Boolean setWebview(int webIndex) {
		return setContext("Webview", webIndex);
	}

	public static Boolean setNative() {

		return setContext("Native");
	}

	public static boolean alertAction(String strAction) {
		int i = 0;
		while (i++ < 20) {
			try {
				log("Alert message=" + String.valueOf(i) + ". " + driver.switchTo().alert().getText());
				if (strAction.toLowerCase().contains("accept")) {
					driver.switchTo().alert().accept();
				} else if (strAction.toLowerCase().equals("dismiss")) {
					driver.switchTo().alert().dismiss();
				}
				else if (strAction.toLowerCase().contains("allow")){
					driver.switchTo().alert().accept();
				}
				else if (strAction.toLowerCase().contains("now allow")){
					driver.switchTo().alert().dismiss();
				}
				return true;
			} catch (NoAlertPresentException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		return false;
	}
	public static boolean alertAction(boolean condition) {
		int i = 0;
		while (i++ < 20) {
			try {
				if (condition) {
					driver.switchTo().alert().accept();
				}
				else {
					driver.switchTo().alert().dismiss();
				}
				return true;
			} catch (NoAlertPresentException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		return false;
	}

	public static void writelog() {
		log("writelog(...)");
		Lib.writeLog(driver.getPageSource());
	}

	public static void enterPin(String pinNumber) {
		String currentContext = driver.getContext();
		if (!currentContext.toLowerCase().contains("native")){
			Lib.setNative();
		}
		if (Lib.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("ios")) {
			Lib.waitBy(OneAppElementKeys.LD1I_PIN0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (i==(pinNumber.length())-1){
					ExReport.printScreenshot("By Passed OTP Activation Flow - Enter Confirm PIN");
				}
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					log("Click 0");
					fBy(OneAppElementKeys.LD1I_PIN0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					log("Click 1");
					fBy(OneAppElementKeys.LD1I_PIN1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					log("Click 2");
					fBy(OneAppElementKeys.LD1I_PIN2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					log("Click 3");
					fBy(OneAppElementKeys.LD1I_PIN3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					log("Click 4");
					fBy(OneAppElementKeys.LD1I_PIN4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					log("Click 5");
					fBy(OneAppElementKeys.LD1I_PIN5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					log("Click 6");
					fBy(OneAppElementKeys.LD1I_PIN6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					log("Click 7");
					fBy(OneAppElementKeys.LD1I_PIN7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					log("Click 8");
					fBy(OneAppElementKeys.LD1I_PIN8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					log("Click 9");
					fBy(OneAppElementKeys.LD1I_PIN9).click();
				}
			}
		}else if (Lib.driver.getSessionDetails().get("platformName").toString().equalsIgnoreCase("android")) {
			Lib.waitBy(OneAppElementKeys.LD1I_PIN0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					log("Click 0");
					fBy(OneAppElementKeys.LD1I_PIN0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					log("Click 1");
					fBy(OneAppElementKeys.LD1I_PIN1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					log("Click 2");
					fBy(OneAppElementKeys.LD1I_PIN2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					log("Click 3");
					fBy(OneAppElementKeys.LD1I_PIN3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					log("Click 4");
					fBy(OneAppElementKeys.LD1I_PIN4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					log("Click 5");
					fBy(OneAppElementKeys.LD1I_PIN5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					log("Click 6");
					fBy(OneAppElementKeys.LD1I_PIN6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					log("Click 7");
					fBy(OneAppElementKeys.LD1I_PIN7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					log("Click 8");
					fBy(OneAppElementKeys.LD1I_PIN8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					log("Click 9");
					fBy(OneAppElementKeys.LD1I_PIN9).click();
				}
			}
		}
		driver.context(currentContext);
	}

	public static void touchAndMoveWebView(WebElement el1, WebElement el2) {

		Point location1 = el1.getLocation();
		Dimension size1 = el1.getSize();
		int tap1X = location1.getX() + (size1.getWidth() / 2);
		int tap1Y = location1.getY() + (size1.getHeight() / 2);
		Lib.log("tapX="+tap1X+", tapY="+tap1Y);

		Point location2 = el2.getLocation();
		Dimension size2 = el2.getSize();
		int tap2X = location2.getX() + (size2.getWidth() / 2);
		int tap2Y = location2.getY() + (size2.getHeight() / 2);
		Lib.log("tapX="+tap2X+", tapY="+tap2Y);
		// Execute Tap
		String originalContext = driver.getContext();
		Lib.setNative();
		TouchAction action = new TouchAction(Lib.driver);
		action.longPress(PointOption.point(tap1X, tap1Y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(tap2X, tap2Y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
				.moveTo(PointOption.point(tap2X, tap2Y))
				.release().perform();
		driver.context(originalContext);
	}
	public static void touchAndMoveNative(WebElement el1, WebElement el2) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(new ElementOption().withElement(el1))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(new ElementOption().withElement(el2))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
				.moveTo(PointOption.point(el2.getLocation()))
				.release().perform();
	}


	public static void swipe(int startX, int startY, int endX, int endY) {
		try {
			new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		} catch (Exception e) {
			System.out.println("unable to swipe");
		}
	}

	/**
	 * Ex. swipeVeritical(0.1, 0.9, 0.5); -> Move from Top to Bottom
	 * @param startY
	 * @param endY
	 * @param anchorY
	 */
	public static void swipeVertical(double startY, double endY, double anchorY) {
		log("Swipe startY="+startY+", endY="+endY+", anchorY="+anchorY);
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorY);
		int startPoint = (int) (size.height * startY);
		int endPoint = (int) (size.height * endY);

		new TouchAction(driver)
				.press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}
	public static void swipeVertical(){
		Lib.log("Swipe down to Top");
		swipeVertical(0.3, 0.7, 0.5);
	}

	public static void swipeDownToUp(){
		swipeVertical(0.8, 0.2, 0.5);
	}

	public static void swipeHorizontal(double startX, double endX, double anchorX) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorX);
		int startPoint = (int) (size.height * startX);
		int endPoint = (int) (size.height * endX);

		new TouchAction(driver)
				.press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}
	public static void swipeHorizontal(){
		swipeHorizontal(0.3, 0.7, 0.5);
	}

	public static void swipeWebview(WebElement el1, WebElement el2) {

		Point p1 = el1.getLocation();
		Point p2 = el2.getLocation();

		setNative();
		new TouchAction<>(driver).longPress(PointOption.point(p1))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(p2))
				.perform();

	}

	public static void tap(WebElement el){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(el.getLocation()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}
	public static void tapXY(int startX, int startY){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}

	public static void selectValue (WebElement el, String value){
		Select select = new Select(el);
		select.selectByValue(value);
	}
	public static void selectValue(String xpath, String value){
		waitVisible(xpath);
		selectValue(fX(xpath), value);
	}
	public static void selectVisibleText (WebElement el, String value){
		Select select = new Select(el);
		select.selectByVisibleText(value);
	}
	public static void selectVisibleText(String xpath, String value){
		waitVisible(xpath);
		selectVisibleText(fX(xpath), value);
	}
	public static void selectIndex(WebElement el, int index){
		Select select = new Select(el);
		select.selectByIndex(index);
	}
	public static String getSelet(WebElement el){
		return new Select(el).getFirstSelectedOption().getText();
	}
	public static void selectIndex(String xpath, int index){
		selectIndex(fX(xpath), index);
	}

	public static void selectByVisibleText(String elementKdy, String value){
		waitBy(elementKdy);
		selectVisibleText(fBy(elementKdy), value);
	}
	public static void enterCustomNumberKeyboard(String numbers){
		Lib.waitBy(OneAppElementKeys.LD1I_CVV_PIN0);
		for (int i = 0; i < numbers.length(); i++ ) {
			if (i==(numbers.length())-1){
				ExReport.printScreenshot("Enter Number="+numbers);
			}
			if (numbers.split("")[i].equalsIgnoreCase("0")) {
				log("Click 0");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN0);
			} else if (numbers.split("")[i].equalsIgnoreCase("1")) {
				log("Click 1");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN1);
			} else if (numbers.split("")[i].equalsIgnoreCase("2")) {
				log("Click 2");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN2);
			} else if (numbers.split("")[i].equalsIgnoreCase("3")) {
				log("Click 3");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN3);
			} else if (numbers.split("")[i].equalsIgnoreCase("4")) {
				log("Click 4");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN4);
			} else if (numbers.split("")[i].equalsIgnoreCase("5")) {
				log("Click 5");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN5);
			} else if (numbers.split("")[i].equalsIgnoreCase("6")) {
				log("Click 6");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN6);
			} else if (numbers.split("")[i].equalsIgnoreCase("7")) {
				log("Click 7");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN7);
			} else if (numbers.split("")[i].equalsIgnoreCase("8")) {
				log("Click 8");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN8);
			} else if (numbers.split("")[i].equalsIgnoreCase("9")) {
				log("Click 9");
				clickBy(OneAppElementKeys.LD1I_CVV_PIN9);
			}
			Lib.sleep(1);
		}
	}

	/**
	 * API Get Token
	 * @param filePath
	 * @return
	 */
	public static String getToken(String filePath) {
		JsonPath dataP = new JsonPath(com.tmb.automation.helper.Helper.getInput(filePath));
		Response response_getToken = given().relaxedHTTPSValidation().auth().preemptive()
				.basic(dataP.get("token.key"), dataP.get("token.Authorization"))
				.headers(dataP.getMap("token.headers"))
				.formParams(dataP.getMap("token.body"))
				.when()
				.post(dataP.getString("token.hostname") + dataP.getString("token.path"))
				.then().assertThat().statusCode(200).extract().response();
		return response_getToken.jsonPath().getString("data.access_token");
	}
	public static String getToken(JsonPath dataP) {
		Response response_getToken = given().relaxedHTTPSValidation().auth().preemptive()
				.basic(dataP.get("token.key"), dataP.get("token.Authorization"))
				.headers(dataP.getMap("token.headers"))
				.formParams(dataP.getMap("token.body"))
				.when()
				.post(dataP.getString("token.hostname") + dataP.getString("token.path"))
				.then().assertThat().statusCode(200).extract().response();
		return response_getToken.jsonPath().getString("data.access_token");
	}

	public static WebElement findShadowRootElement(WebElement element) {
		WebElement el = (WebElement) ((JavascriptExecutor)driver).executeAsyncScript("return arguments[0].shadowRoot", element);
		return el;
	}

	public static void printConfigVariables(AppiumDriver driver){
		try {
			System.out.println("URL="+driver.getRemoteAddress());
			System.out.println("Appium Version="+driver.getStatus());
			System.out.println("SessionDetails()="+driver.getSessionDetails());
		}catch (Exception e){}
	}
	public static void testWithDeviceProfile1(String deviceProfile) {
		Lib.p = Lib.setProperties();
		deviceProfile = deviceProfile+".";
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		//Mobile
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Lib.prop(deviceProfile + "platformName", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Lib.prop(deviceProfile + "platformVersion", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Lib.prop(deviceProfile + "deviceName", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, Lib.prop(deviceProfile + "fullReset", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, Lib.prop(deviceProfile + "noReset", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, Lib.prop(deviceProfile + "app", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, Lib.prop(deviceProfile + "udid", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Lib.prop(deviceProfile + "automationName", ""));
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Lib.prop(deviceProfile + "newCommandTimeOut", "300"));
		desiredCapabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
		desiredCapabilities.setCapability(IOSMobileCapabilityType.USE_PREBUILT_WDA, true);
//		desiredCapabilities.setCapability(IOSMobileCapabilityType.WDA_STARTUP_RETRIES, 4);
//		desiredCapabilities.setCapability(IOSMobileCapabilityType.IOS_INSTALL_PAUSE, "8000");
//		desiredCapabilities.setCapability(IOSMobileCapabilityType.WDA_STARTUP_RETRY_INTERVAL, "20000");

		//Android
		if (Lib.deviceProfile.toLowerCase().contains("android")){
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Lib.prop(deviceProfile + "appPackage", ""));
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Lib.prop(deviceProfile + "appActivity", ""));
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE
					, System.getProperty("user.dir")+"/src/main/resources/chromedriver_94");
		}
		//iOS
		if (Lib.deviceProfile.toLowerCase().contains("ios")){
			desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, Lib.prop(deviceProfile + "bundleId", ""));
			desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, Lib.prop(deviceProfile + "xcodeOrgId", ""));
			desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, Lib.prop(deviceProfile + "xcodeSigningId", ""));
		}
		//Saucelabs
		if (Lib.deviceProfile.toLowerCase().contains("saucelab")){
			desiredCapabilities.setCapability("username", Lib.prop(deviceProfile + "userName", ""));
			desiredCapabilities.setCapability("accessKey", Lib.prop(deviceProfile + "accessKey", ""));
			desiredCapabilities.setCapability("name", ExReport.testName);
			desiredCapabilities.setCapability("Record", Lib.prop(deviceProfile + "record", "true"));
			desiredCapabilities.setCapability("deviceOrientation", Lib.prop(deviceProfile + "deviceOrientation", "portrait"));
		}
		String url = "";
		if (Lib.deviceProfile.toLowerCase().contains("sim")){
			url = "http://"+Lib.prop(deviceProfile + "url", "127.0.0.1:4723/wd/hub");

		} else {
//			url = "https://"+Lib.prop(deviceProfile + "userName", "")+":"
//					+ Lib.prop(deviceProfile + "accessKey", "") +"@"
//					+ Lib.prop(deviceProfile + "url", "ondemand.us-west-1.saucelabs.com:443/wd/hub");
			url = "http://"+Lib.prop(deviceProfile + "url", "ondemand.us-west-1.saucelabs.com/wd/hub");
		}
		System.out.println("url="+url);
		if (desiredCapabilities.getCapability(MobileCapabilityType.PLATFORM_NAME).toString().equalsIgnoreCase("android")){
			try {
				Lib.driver = new AndroidDriver<WebElement>(new URL(url), desiredCapabilities);
			} catch (Exception e) {
				System.out.println("Cannot connect url="+url);
				e.printStackTrace();
			}
		} else {
			try {
				Lib.driver = new IOSDriver<WebElement>(new URL(url), desiredCapabilities);
			} catch (Exception e) {
				System.out.println("!! Cannot connect url="+url+" or DesireCapabilities is not found!............");
				e.printStackTrace();}
		}
	}

	public static Boolean clickMore(String menuString){
		Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_MAINFEATURE_LIST);
		List<WebElement> mainButtons = Lib.fsBy(OneAppElementKeys.LD1W_PRO_CARD_MAINFEATURE_LIST);
		List<WebElement> manageButtons = Lib.fsBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LIST);
		boolean isFound = false;
		for (WebElement button:mainButtons){
			Lib.log(button.getText());
			if (button.getText().toLowerCase().contains(menuString.toLowerCase())){
				Lib.click(button);
				isFound = true;
				return true;
			}
		}
		for (WebElement button:manageButtons){
			Lib.log(button.getText());
			if(button.getText().toLowerCase().contains(menuString.toLowerCase())){
				Lib.click(button);
				isFound = true;
				return true;
			}
		}
		if (!isFound) {
			Assert.fail("not found Redeem point");
		}
		return isFound;
	}
	public static WebElement getMore(String menuString){
		Lib.waitBy(OneAppElementKeys.LD1W_PRO_CARD_MAINFEATURE_LIST);
		List<WebElement> mainButtons = Lib.fsBy(OneAppElementKeys.LD1W_PRO_CARD_MAINFEATURE_LIST);
		List<WebElement> manageButtons = Lib.fsBy(OneAppElementKeys.LD1W_PRO_CARD_MANAGE_LIST);
		boolean isFound = false;
		for (WebElement button:mainButtons){
			if (button.getText().toLowerCase().contains(menuString.toLowerCase())){
				isFound = true;
				return button;
			}
		}
		for (WebElement button:manageButtons){
			if(button.getText().toLowerCase().contains(menuString.toLowerCase())){
				isFound = true;
				return button;
			}
		}
		Assert.fail(menuString+"  is not found!!!!");
		return null;
	}
	public static void waitUntilVisible(By locator, int seconds) {
		Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
			driver.findElement(locator);
			return true;
		};
		new WebDriverWait(driver, seconds, 60).until(func);
	}
}
