package com.tmb.automation.pages.investment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TTBSmartPortPage {
    public TTBSmartPortPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Investment\"]")
    public MobileElement investmentTile;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"al-arrow-left\"]")
    public MobileElement backBtn;

    //Card My Mutual Fund
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Image")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[5]")
    public MobileElement smartPortIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[14]")
    public MobileElement ttbSmartLbl;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[15]")
    public MobileElement assetValueLb;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[16]")
    public MobileElement assetValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.TextView[4]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[17]")
    public MobileElement getAssetValueReturn;

    @AndroidFindBy(xpath = "//*[@resource-id='profit-button-label']")
    @iOSXCUITFindBy(id = "profit-button-label")
    public MobileElement annualReturnBtn;


    //Action Button
    @AndroidFindBy(xpath = "//*[@resource-id='my-mutual-fund-screen-buy-btn_mutual_fund']")
    @iOSXCUITFindBy(xpath = "my-mutual-fund-screen-buy-btn_mutual_fund")
    public MobileElement buyBtn;

    @AndroidFindBy(xpath = "//*[@resource-id='my-mutual-fund-screen-sell-btn_mutual_fund']")
    @iOSXCUITFindBy(xpath = "my-mutual-fund-screen-sell-btn_mutual_fund")
    public MobileElement sellBtn;

    @AndroidFindBy(xpath = "//*[@resource-id='my-mutual-fund-screen-activity-btn_mutual_fund']")
    @iOSXCUITFindBy(xpath = "my-mutual-fund-screen-activity-btn_mutual_fund")
    public MobileElement activityBtn;

    @AndroidFindBy(xpath = "//*[@resource-id='my-mutual-fund-screen-more-btn_mutual_fund']")
    @iOSXCUITFindBy(xpath = "my-mutual-fund-screen-more-btn_mutual_fund")
    public MobileElement moreBtn;


    //List of Fund

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[24]")
    public MobileElement fundCodeModel1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[25]")
    public MobileElement investmentValueModel1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[26]")
    public MobileElement portFolioNoModel1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[27]")
    public MobileElement unrealizedProfitValueModel1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[28]")
    public  MobileElement navDateModel1;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[29]")
    public MobileElement fundCodeModel2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[30]")
    public MobileElement investmentValueModel2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[31]")
    public MobileElement portFolioNoModel2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.view.View/android.view.View[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[32]")
    public MobileElement unrealizedProfitValueModel2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[33]")
    public  MobileElement navDateModel2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[3]/android.view.View/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[34]")
    public MobileElement getFundCodeModel3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[35]")
    public MobileElement investmentValueModel3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[36]")
    public MobileElement portFolioNoModel3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[3]/android.view.View/android.view.View[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[37]")
    public MobileElement unrealizedProfitValueModel3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[4]/android.view.View[3]/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Investment\"])[1]/XCUIElementTypeOther[38]")
    public  MobileElement navDateModel3;


}