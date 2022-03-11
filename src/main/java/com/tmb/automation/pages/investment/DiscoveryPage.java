package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DiscoveryPage {

    public DiscoveryPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

//    @AndroidFindBy(id = "44")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[8]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[8]/XCUIElementTypeOther[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[8]")
    public WebElement investmentItem;

    //tutorial
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
    public MobileElement tutorialSkipBtn;

}