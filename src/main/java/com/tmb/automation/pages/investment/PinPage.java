package com.tmb.automation.pages.investment;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PinPage {

    public PinPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_00")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[10]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[11]")
    public WebElement number0Btn;

    //    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_01")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
//    @iOSXCUITFindBy(id = "btn1")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[1]")
    public WebElement number1Btn;

    //    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_02")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
//    @iOSXCUITFindBy(id = "btn2")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[2]")
    public WebElement number2Btn;

    //    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_03")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")

//    @iOSXCUITFindBy(id = "btn3")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btn1\"])[3]")
    public WebElement number3Btn;

}
