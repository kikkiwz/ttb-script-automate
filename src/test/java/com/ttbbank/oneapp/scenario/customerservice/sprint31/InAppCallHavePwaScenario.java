package com.ttbbank.oneapp.scenario.customerservice.sprint31;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class InAppCallHavePwaScenario extends BaseScenario {
    @Test(groups = "Customer Service in app call have pwa", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void inAppCallHavePwa() throws Exception {
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
        String LabelPWA = ttbTestContext.findElement(OneAppElementKeys.LABEL_PWA_NAME).getText();
        String PwaName = ttbTestContext.findElement(OneAppElementKeys.PWA_NAME).getText();
        String ttbReserve = ttbTestContext.findElement(OneAppElementKeys.LABEL_TTB_CONTACT).getText();
        String MobileNumber = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_TTB).getText();
        String OrtherChannels = ttbTestContext.findElement(OneAppElementKeys.LABEL_OTHER_CHANNELS).getText();
        System.err.println("LabelPWA : " + LabelPWA);
        System.err.println("ttbReserve : " + ttbReserve);
        System.err.println("MobileNumber : " + MobileNumber);
        System.err.println("OrtherChannels : " + OrtherChannels);

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

        Assert.assertTrue(LabelPWA.equals("Private Wealth Advisor"));
        Assert.assertTrue(PwaName.equals("Methavee Boonsith"));
        Assert.assertTrue(ttbReserve.equals("ttb reserve line"));
        Assert.assertTrue(MobileNumber.equals("02-010-1428"));
        Assert.assertTrue(OrtherChannels.equals("Get in touch with us"));
    }

    public void TC_ONEAPP_11790_InAppCall_0002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();

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
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_2).click();
        Thread.sleep(5000);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        ttbTestContext.getDriver().context("NATIVE_APP");
//        ttbTestContext.getDriver().navigate().back();
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_3).click();
        Thread.sleep(5000);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_4).click();
        Thread.sleep(5000);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_5).click();
        Thread.sleep(5000);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        ttbTestContext.findElement(OneAppElementKeys.CHANNELS_6).click();
        Thread.sleep(5000);
//        childReport.log(Status.INFO, "<pre>When the Customer press on a Social App Icon, the system will navigate to a deep link.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_TTB_CONTACT);
        Thread.sleep(5000);
    }
}
