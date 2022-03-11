package com.tmb.automation.pages.customerservice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PWAPage {
    public PWAPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_navbar_title_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement HeaderPWA;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_full_name_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement NamePWA;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_expertise_title_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement Expertise;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_expertise_value_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement ExpertiseValue;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_label_id0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License1;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_label_id1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License2;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_label_id2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License3;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_label_id3']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License4;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License1No;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License2No;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License3No;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id3']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement License4No;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_desc_title_label_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement PersonalAdviser;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_bullet_desc_id0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement AdvisorDetail1;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_bullet_desc_id1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement AdvisorDetail2;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_bullet_desc_id2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement AdvisorDetail3;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement BtnShow;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement BtnSendMail;

    @AndroidFindBy(xpath = "//*[@resource-id='personal_wealth_advisor_button_call_phone_id']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement BtnCall;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement BtnBack;
}
