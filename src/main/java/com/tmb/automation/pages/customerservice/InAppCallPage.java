package com.tmb.automation.pages.customerservice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InAppCallPage {
    public InAppCallPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement textHomePage;

    @AndroidFindBy(xpath = "//*[@resource-id='my_advisor_card_text_title']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement PersonalWealth;

    @AndroidFindBy(xpath = "//*[@resource-id='my_advisor_card_text_title_expertise']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement NamePWA;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_phone_title_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement ttbReserve;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_phone_value_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement MobileNumber;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_phone_icon_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement IconPhone;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_title_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement OrtherChannels;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement Facebook;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement line;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement linkin;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_3']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement ig;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_4']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement youtube;

    @AndroidFindBy(xpath = "//*[@resource-id='cs_contact_ttb_card_social_image_id_5']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement twitter;

    @AndroidFindBy(xpath = "//*[@resource-id='com.samsung.android.dialer:id/digits']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activate\"]")
    public WebElement MobileNumberInphone;

}
