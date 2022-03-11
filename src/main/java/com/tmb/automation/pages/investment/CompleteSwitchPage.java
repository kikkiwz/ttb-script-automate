package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CompleteSwitchPage {


    public CompleteSwitchPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"checked\"]")
    public MobileElement completeIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[3]")
    public MobileElement titleLb;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[4]")
    public MobileElement transactionOrderdateTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Source fund\"]")
    public MobileElement sourceFundLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TMB50\"]")
    public MobileElement sourceFundValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[7]")
    public MobileElement portCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Target fund\"]")
    public MobileElement targerFundLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[9]")
    public MobileElement targetFundValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amount\"]")
    public MobileElement totalLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[11]")
    public MobileElement totalValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[12]")
    public MobileElement transactionOrderDateLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[13]")
    public MobileElement transactionOrderDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[14]")
    public MobileElement effectiveTransactionDateLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[15]")
    public MobileElement effectiveTransactionDateValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back to investment page\"]")
    public MobileElement backToInvestmentBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pending order\"]")
    public MobileElement pendingOrderBtn;

}