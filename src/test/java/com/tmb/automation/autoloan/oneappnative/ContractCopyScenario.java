package com.tmb.automation.autoloan.oneappnative;

import io.appium.java_client.MobileElement;

public class ContractCopyScenario extends ServiceRequestListScenario {

    public void enterContractCopy() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            Thread.sleep(3000);
            MobileElement el1 = (MobileElement) getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.ListView[1]/android.view.View[5]/android.widget.TextView");
            el1.click();

            Thread.sleep(3000);
            return;
        }
        waitByByXPath("(//XCUIElementTypeOther[@name=\"Service Request\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]");
        MobileElement el1 = (MobileElement) getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Contract copy\"]");
        el1.click();
        waitByAccessibilityId("Next");
    }

    public void nextContractCopy() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            MobileElement el2 = (MobileElement) getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button");
            el2.click();
            Thread.sleep(3000);
            return;
        }
        waitByAccessibilityId("Next");
        MobileElement el2 = (MobileElement) getDriver().findElementByAccessibilityId("Next");
        el2.click();
        waitByAccessibilityId("Confirm");
    }

    public void confirmContractCopy() {
        if ("android".equalsIgnoreCase(getPlatform())) {
            MobileElement el3 = (MobileElement) getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[5]/android.widget.Button");
            el3.click();
            return;
        }
        MobileElement el3 = (MobileElement) getDriver().findElementByAccessibilityId("Confirm");
        el3.click();

    }

    public void verifyResult() {
        if ("android".equalsIgnoreCase(getPlatform())) {

            return;
        }
        waitByAccessibilityId("checked");
    }
}
