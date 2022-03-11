package com.ttbbank.oneapp.scenario.customerservice.sprint31;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.customerservice.InAppCallPage;
import com.tmb.automation.test.customerservice.sprint17.Base;
import com.tmb.automation.util.TextColor;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenOneApp;
import static com.tmb.automation.test.customerservice.sprint17.Base.scrollLeftAndRight;

public class inAppCallScenario extends BaseScenario {
    @Test(groups = "Customer Service in app call", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void inAppCall() throws Exception {
        TC_ONEAPP_11790_InAppCall_0001();
        TC_ONEAPP_11790_InAppCall_0002();
    }
    public void TC_ONEAPP_11790_InAppCall_0001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.35);
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_service_tab_contact_label_id']")));
        WebElement TAB_CONTACT_TTB = ttbTestContext.findElement(OneAppElementKeys.TAB_CONTACT_TTB);
        TAB_CONTACT_TTB.click();
        Thread.sleep(5000);
        String elttbReserve = ttbTestContext.findElement(OneAppElementKeys.LABEL_TTB_CONTACT).getText();
        String elMobileNumber = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_TTB).getText();
        String elOrtherChannels = ttbTestContext.findElement(OneAppElementKeys.LABEL_OTHER_CHANNELS).getText();
        System.err.println("elttbReserve : " + elttbReserve);
        System.err.println("elMobileNumber : " + elMobileNumber);
        System.err.println("elOrtherChannels : " + elOrtherChannels);

//        if(true){
//            parentReport = extent.createTest("TC_ONEAPP-11790", "TC_ONEAPP-11790");
//        }
//
//        childReport = parentReport.createNode("TC_ONEAPP-11790_InAppCall_0001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of In App Call screen in case \n" +
//                "- The customer has wealth flag PB or WB and a PWA\n" +
//                "- Device: Android\n" +
//                "- Press on a Contact Bank button\n" +
//                "- Press on Call Button</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system should display the In App Call screen consisting of \n" +
//                "- Text screen\t\n" +
//                "- Text Detail\t\n" +
//                "- Contact Menu\n" +
//                "- My Advisor menu\t\n" +
//                "- Text Title\n" +
//                "- Call Button : 020101428\n" +
//                "- Text Other Channels\n" +
//                "- Social App Icon\n" +
//                "2. When the Customer press on a Call button, the system will navigate to the dial pad and show the number 020101428  (Write activity log)</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display ttb reserve line : " + TextColor.blueColor(elttbReserve)
//                + "</br>Display Mobile number : " + TextColor.blueColor(elMobileNumber)
//                + "</br>Display Other Channels : " + TextColor.blueColor(elOrtherChannels)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display the In App Call screen consisting</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

//        childReport.log(Status.INFO, "<pre>When the Customer press on a Call button, the system will navigate to the dial pad and show the number 020101428  (Write activity log)</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//        childReport = parentReport.createNode("TC_ONEAPP-11790_InAppCall_0001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of In App Call screen in case \n" +
//                "- Recommended other entry points flow\n" +
//                "- Device: Android\n" +
//                "- Press on the Help menu</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : The system should display a Contact ttb screen follow the In app call flow.</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display a Contact ttb screen follow the In app call flow.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        Assert.assertTrue(elttbReserve.equals("ttb contact center"));
        Assert.assertTrue(elMobileNumber.equals("1428"));
        Assert.assertTrue(elOrtherChannels.equals("Get in touch with us"));
    }

    public void TC_ONEAPP_11790_InAppCall_0002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.err.println("url 1 : " + ttbTestContext.getDriver().getCurrentUrl());

//        childReport = parentReport.createNode("TC_ONEAPP-11795_InAppCall_00001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of Social App Icons\n" +
//                "- Deep link for social media\n" +
//                "- Device: Android\n" +
//                "- Press on a Social App Icon</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system should display Social App Icons that be sent from Back-End\n" +
//                "2. When the Customer press on a Social App Icon, the system will navigate to a deep link.\n" +
//                "Link social media:\n" +
//                "FB: https://www.facebook.com/ttbbankofficial\n" +
//                "Line: https://line.me/R/ti/p/@ttbbankofficial\n" +
//                "Linkedin: https://www.linkedin.com/company/ttbbankofficial\n" +
//                "IG: https://www.instagram.com/ttbbankofficial\n" +
//                "YT: https://www.youtube.com/c/ttbbankofficial\n" +
//                "TW: https://twitter.com/ttbbankofficial</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display the In App Call screen consisting</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_1).click();
        Thread.sleep(5000);
//        String url1 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 1 : " + ttbTestContext.getDriver().getCurrentUrl());
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_2).click();
        Thread.sleep(5000);
        String url2 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 2 : " + url2);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        ttbTestContext.getDriver().context("NATIVE_APP");
//        ttbTestContext.getDriver().navigate().back();
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_3).click();
        Thread.sleep(5000);
        String url3 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 3 : " + url3);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_4).click();
        Thread.sleep(5000);
        String url4 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 4 : " + url4);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_5).click();
        Thread.sleep(5000);
        String url5 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 5 : " + url5);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_6).click();
        Thread.sleep(5000);
        String url6 = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url 6 : " + url6);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        String url7 = ttbTestContext.getDriver().getCurrentUrl();
        Thread.sleep(5000);
        System.err.println("url 7 : " + url7);
    }
}
