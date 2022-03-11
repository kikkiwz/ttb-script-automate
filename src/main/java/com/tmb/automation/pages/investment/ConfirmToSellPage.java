package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmToSellPage {
    public ConfirmToSellPage(WebDriver driver) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


    //Title
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm to sell\"]")
    public MobileElement backIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm to sell\"]")
    public MobileElement screenTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[2]")
    public MobileElement cardInformation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Fund\"]")
    public MobileElement fundLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TESCHINAA\"]")
    public MobileElement fundShortName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PT000000000001829800\"]")
    public MobileElement portfolioCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amount\"]")
    public MobileElement totalLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1,000.00 baht\"]")
    public MobileElement totalValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Redemption fee\"]")
    public MobileElement frontEndFreeLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Free of charge\"]")
    public MobileElement FrontEndFreeValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Transaction order date\"]")
    public MobileElement transactionOrderDate;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"09 Jun 21\"])[1]")
    public MobileElement transactionOrderDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Effective transaction date\"]")
    public MobileElement effectiveDateLb;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"09 Jun 21\"])[2]")
    public MobileElement effectiveDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cash settlement date\"]")
    public MobileElement cashSettlementDate;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"09 Jun 21\"])[3]")
    public MobileElement cashSettlementDateValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Receiving account\"]")
    public MobileElement receivingAccountLb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"110-2-41636-7\"]")
    public MobileElement receivingAccountValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.widget.CheckBox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"I acknowledge and understand the investment policy in fund fact sheet.\"]")
    public MobileElement riskAcceptance;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
    public MobileElement confirmationBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    public MobileElement cancellationBtn;

    //bottom sheet after click
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View/android.widget.Button")
    public MobileElement closeBnt;

    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Do you want to cancel your transaction ?\"]")
    public MobileElement confirmationQuetionLb;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
    public MobileElement yesBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"No\"]")
    public MobileElement noBtn;

}