package com.tmb.automation.autoloan.oneappnative;

import io.appium.java_client.MobileElement;

public class ReceiptTaxInvoiceCopyScenario extends ServiceRequestListScenario {

    public void enterReceiptTaxInvoiceCopy() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {

            return;
        }
        MobileElement el1 = (MobileElement) getDriver().findElementByAccessibilityId("Receipt / Tax Invoice copy");
        el1.click();
        waitByAccessibilityId("Next");
    }

    public void nextFromInformationScreen() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {

            return;
        }
        MobileElement el1 = (MobileElement) getDriver().findElementByAccessibilityId("Next");
        el1.click();
        waitByAccessibilityId("Next");
    }

    public void nextFromSelectTypeOfReceipt() {
        if ("android".equalsIgnoreCase(getPlatform())) {

            return;
        }
        MobileElement el2 = (MobileElement) getDriver().findElementByAccessibilityId("Next");
        el2.click();
        waitByAccessibilityId("Next");
    }

    public void verifyResult() {
        if ("android".equalsIgnoreCase(getPlatform())) {

            return;
        }

    }
}
