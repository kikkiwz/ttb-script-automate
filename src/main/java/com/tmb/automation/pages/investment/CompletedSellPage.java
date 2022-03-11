package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompletedSellPage {
    public CompletedSellPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    //title
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"checked\"]")
    public MobileElement completedIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Already received redeem transaction.\"]")
    public MobileElement titleLb;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[4]")
    public MobileElement transactionOrderDateTime;

    //Box Massage
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]")
    public MobileElement infomationBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Fund\"]")
    public MobileElement fundLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[6]")
    public MobileElement fundShortName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[7]")
    public MobileElement amoutLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[8]")
    public MobileElement amoutValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[9]")
    public MobileElement transactionOrderDateLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[10]")
    public MobileElement transactionOrderDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[11]")
    public MobileElement effectiveTransactonDateLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[12]")
    public MobileElement effectiveTransactionDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[13]")
    public MobileElement cashSettlementDateLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[14]")
    public MobileElement cashSettlementDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[15]")
    public MobileElement receivingAccountLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ONEAPP\"]/XCUIElementTypeOther[16]")
    public MobileElement receivingAccountValue;

    //ActionButton
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back to investment page\"]")
    public MobileElement backtoMyInvestmentScreenBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pending order\"]")
    public MobileElement pendingOrderBtn;

    //complete card

}