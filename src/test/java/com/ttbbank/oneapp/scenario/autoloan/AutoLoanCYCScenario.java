package com.ttbbank.oneapp.scenario.autoloan;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class AutoLoanCYCScenario extends AutoLoanHomeScenario{

    @Test(groups = "CYC", dependsOnGroups = "Enter Loan Home")
    public void CYC() throws InterruptedException, IOException {
        ExtentTest scenario = getFeature().createNode(Scenario.class, "CYC-Crash Your Car");
        TtbTestContext context = getTtbTestContext();
        Thread.sleep(3500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).click();
        Thread.sleep(35000);
        WebDriver webView = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME,true);
        if (context.isAndroid()) {
            Set<String> webNames = webView.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        Boolean productName = context.findElement(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME).isDisplayed();
        Assert.assertTrue(productName);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_PRODUCT_NAME).getText(),"ttb DRIVE");
        Boolean autoLoanEventCard = context.findElement(OneAppElementKeys.AUTO_LOAN_EVENT_CARD_BTN).isDisplayed();
        Assert.assertTrue(autoLoanEventCard);
        context.findElement(OneAppElementKeys.AUTO_LOAN_EVENT_CARD_BTN).click();
        Thread.sleep(5000);
        WebDriver webView2 = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CYC_TOP_MSG2,true);
        if (context.isAndroid()) {
            Set<String> webNames = webView2.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_CYC_TOP_MSG2);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
                Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_TOP_MSG2).getText(), "you have been selected to receive ttb DRIVE cash for your car top up");
        Boolean cycLogo = context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_LOGO).isDisplayed();
        Assert.assertTrue(cycLogo);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_OFFER).getText(),"The bank reserves the right to approve loan amount which are subjected to the bank's terms and conditions.");
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_GET_OFFER_BTN).getText(),"Get Offer Now");
        String CYC_info = "images/CYC_info_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_info);
        scenario.createNode(Given.class, "CYC info screen").addScreenCaptureFromPath(CYC_info).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_GET_OFFER_BTN).click();
        Thread.sleep(5000);
        WebDriver webView3 = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE,true);
        if (context.isAndroid()) {
            Set<String> webNames = webView3.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_CREDIT_AMOUNT_TITLE).getText(),"Cash Your Car Top Up");
        String CYC_Specfic_Amount_info = "images/CYC_Specific_Amount_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Specfic_Amount_info);
        scenario.createNode(Given.class, "CYC Specific amount screen").addScreenCaptureFromPath(CYC_Specfic_Amount_info).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).clear();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).sendKeys("49999");
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT).getText(),"Amount entered must not be less than minimum.");
        Boolean nextBTN = context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN).isEnabled();
        Assert.assertFalse(nextBTN);
        String CYC_Specfic_Amount_less_min_info = "images/CYC_Specific_Amount_Less_Than_Min_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Specfic_Amount_less_min_info);
        scenario.createNode(Given.class, "CYC Specific les than minimum amount Warning").addScreenCaptureFromPath(CYC_Specfic_Amount_less_min_info).pass("Pass");
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).clear();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).sendKeys("2000000");
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT).getText(),"Amount entered must not exceed maximum.");
        Boolean nextBTN2 = context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN).isEnabled();
        Assert.assertFalse(nextBTN2);
        String CYC_Specfic_Amount_More_max_info = "images/CYC_Specific_Amount_More_Than_Max_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Specfic_Amount_More_max_info);
        scenario.createNode(Given.class, "CYC Specific More than Maximum amount Warning").addScreenCaptureFromPath(CYC_Specfic_Amount_More_max_info).pass("Pass");
        Thread.sleep(1500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).clear();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_ENTER_LOAN_AMOUNT).sendKeys("150000");
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_WARNING_ENTER_LOAN_AMOUNT).getText(),"Must be in range of approved amount");
        String CYC_Specfic_Amount_correct_info = "images/CYC_Specific_Correct_Amount_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Specfic_Amount_correct_info);
        scenario.createNode(Given.class, "CYC Specific correct amount").addScreenCaptureFromPath(CYC_Specfic_Amount_correct_info).pass("Pass");
        Thread.sleep(1500);
        context.verticalSwipeByPercentages(0.5,0.2,0.5);
        WebDriver webView4 = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CYC_72_TERM,true);
        if (context.isAndroid()) {
            Set<String> webNames = webView4.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_CYC_72_TERM);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_72_TERM).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_60_TERM).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_48_TERM).click();
        context.verticalSwipeByPercentages(0.6,0.2,0.5);
        WebDriver term36 = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CYC_36_TERM,true);
        if (context.isAndroid()) {
            Set<String> webNames = term36.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_CYC_36_TERM);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_36_TERM).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_24_TERM).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_12_TERM).click();
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_60_TERM).click();
        String CYC_Specfic_Select_60_Term = "images/CYC_Specific_Select_60_term_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Specfic_Select_60_Term);
        scenario.createNode(Given.class, "CYC Specific Select 60 term").addScreenCaptureFromPath(CYC_Specfic_Select_60_Term).pass("Pass");
        Thread.sleep(1500);
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_SPECIFIC_AMOUNT_BTN).click();
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_MSG1).getText(),"Please review and confirm your information for us. We will contact you soon.");
//        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_AMOUNT).getText(), "150,000");
        String CYC_Confirm_Screen = "images/CYC_Comfrim_Screen_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Confirm_Screen);
        scenario.createNode(Given.class, "CYC Confirm Screen").addScreenCaptureFromPath(CYC_Confirm_Screen).pass("Pass");
        Thread.sleep(1500);
        context.verticalSwipeByPercentages(0.5,0.2,0.5);
        WebDriver webView5 = context.setContextToWebView(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN,true);
        if (context.isAndroid()) {
            Set<String> webNames = webView5.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN);
                    break;
                } catch (Exception e) {
                    System.out.println("This webView is't to use");
                }
            }
        }
        context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_CONFIRM_GET_OFFER_BTN).click();
        Boolean successIcon = context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_SUCCESS_ICON).isDisplayed();
        Assert.assertTrue(successIcon);
        Assert.assertEquals(context.findElement(OneAppElementKeys.AUTO_LOAN_CYC_SUCCESS_TOP_MSG1).getText(),"Thank You for Your Interest");
        String CYC_Success_Screen = "images/CYC_Success_Screen_"+context.getPlateFormName()+".png";
        takeScreenshot(CYC_Success_Screen);
        scenario.createNode(Given.class, "CYC Success Screen").addScreenCaptureFromPath(CYC_Success_Screen).pass("Pass");
        Thread.sleep(1500);
    }
}
