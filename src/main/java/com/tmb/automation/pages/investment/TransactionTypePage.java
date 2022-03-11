package com.tmb.automation.pages.investment;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TransactionTypePage {
    public TransactionTypePage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Title Page
    @AndroidFindBy(id = "popup-title")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Historical Transaction\"])[1]/XCUIElementTypeOther[7]")
    public WebElement titlePage;

    //ListOfType
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Historical Transaction\"])[1]/XCUIElementTypeOther[8]")
    public WebElement allFund;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Historical Transaction\"])[1]/XCUIElementTypeOther[9]")
    public WebElement normalFund;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Historical Transaction\"])[1]/XCUIElementTypeOther[10]")
    public WebElement tsp;

}