package com.tmb.automation.pages.customerservice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.ttbbank.oneapp.vit:id/quick_action_button_ic']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activate\"]")
    public WebElement textHomePage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Account\"]")
    public WebElement Account;

    @AndroidFindBy(xpath = "//*[@resource-id='2020']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[21]")
    public WebElement Service;

    @AndroidFindBy(xpath = "//*[@resource-id='00']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    public WebElement waitServiceScreen;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Service\"]")
    public WebElement Discover;

    @AndroidFindBy(xpath = "//*[@resource-id='com.ttbbank.oneapp.vit:id/skipIntro']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Service\"]")
    public WebElement Skip;
}
