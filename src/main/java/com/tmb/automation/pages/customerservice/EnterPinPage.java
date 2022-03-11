package com.tmb.automation.pages.customerservice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EnterPinPage {
    public EnterPinPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_00")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"0\"]")
    public WebElement Pin00;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_01")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1\"]")
    public WebElement Pin01;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_02")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2\"]")
    public WebElement Pin02;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_03")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"3\"]")
    public WebElement Pin03;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_04")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"4\"]")
    public WebElement Pin04;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_05")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"5\"]")
    public WebElement Pin05;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_06")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"6\"]")
    public WebElement Pin06;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_07")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"7\"]")
    public WebElement Pin07;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_08")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"8\"]")
    public WebElement Pin08;

    @AndroidFindBy(id = "com.ttbbank.oneapp.vit:id/key_09")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"9\"]")
    public WebElement Pin09;
}
