package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PinAfterConfirmPage {

    public PinAfterConfirmPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_00")
//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/pin_key_0")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[10]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[11]")
    public MobileElement number0Btn;

//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_01")
//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/pin_key_1")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[1]")
    public MobileElement number1Btn;

//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_02")
//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/pin_key_2")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[2]")
    public MobileElement number2Btn;

//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_03")
//    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/pin_key_3")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[3]")
    public MobileElement number3Btn;
    
}
