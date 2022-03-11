package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;


public class ContactExpertScenario extends BaseScenario {

    @Test(groups = "Health Protection Contact an Expert", dependsOnGroups = {"Activate new flow"}, priority = 1)
    public void healthContactExpert() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
      
        WebElement expandMenuButton = context.findElement(OneAppElementKeys.PROTECTION_EXPAND_MENU);
        expandMenuButton.click();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER_OLD);
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON_OLD);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON_OLD).click();
        Thread.sleep(1000);
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER_OLD);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_CONTACTEXPERT_BUTTON_OLD);
        Thread.sleep(1000);
        String contact = "images/Protection_Health Protection Contact an Expert.png";
        takeScreenshot(contact);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_CONTACTEXPERT_BUTTON_OLD).click();
        Thread.sleep(5000);
        String dial = "images/Protection_Health Protection Contact an Expert Dialer.png";
        takeScreenshot(dial);

        while(true) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout"));
                break;
            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health Protection Contact an Expert");
        scenario.createNode(Given.class, "Health Protection Contact an Expert").addScreenCaptureFromPath(contact).pass("PASS");
        scenario.createNode(Given.class, "Health Protection Contact an Expert Dialer").addScreenCaptureFromPath(dial).pass("PASS");
        getExtent().flush();
    }

    @Test(groups = "Retirement Contact an Expert", dependsOnGroups = {"Activate new flow"}, priority = 2)
    public void retirementContactExpert() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER_OLD);
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON_OLD);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON_OLD).click();
        Thread.sleep(3000);
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_HEADER_OLD);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_CONTACTEXPERT_BUTTON_OLD);
        context.scrollDown();
        Thread.sleep(1000);
        String contact = "images/Protection_Retirement Contact an Expert.png";
        takeScreenshot(contact);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_CONTACTEXPERT_BUTTON_OLD).click();
        Thread.sleep(5000);
        String dial = "images/Protection_Retirement Contact an Expert Dialer.png";
        takeScreenshot(dial);

        while(true) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout"));
                break;
            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Retirement Contact an Expert");
        scenario.createNode(Given.class, "Retirement Contact an Expert").addScreenCaptureFromPath(contact).pass("PASS");
        scenario.createNode(Given.class, "Retirement Contact an Expert Dialer").addScreenCaptureFromPath(dial).pass("PASS");
        getExtent().flush();
    }

    @Test(groups = "Loss of Life Contact an Expert", dependsOnGroups = {"Activate new flow"}, priority = 3)
    public void lossOfLifeContactExpert() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebElement insuranceButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_MENU);
        insuranceButton.click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER_OLD);
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON_OLD);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON_OLD).click();
        Thread.sleep(3000);
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_HEADER_OLD);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_CONTACTEXPERT_BUTTON_OLD);
        Thread.sleep(1000);
        String contact = "images/Protection_Loss of Life Contact an Expert.png";
        takeScreenshot(contact);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_CONTACTEXPERT_BUTTON_OLD).click();
        Thread.sleep(5000);
        String dial = "images/Protection_Loss of Life Contact an Expert Dialer.png";
        takeScreenshot(dial);

        while(true) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout"));
                break;
            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loss of Life Contact an Expert");
        scenario.createNode(Given.class, "Loss of Life Contact an Expert").addScreenCaptureFromPath(contact).pass("PASS");
        scenario.createNode(Given.class, "Loss of Life Contact an Expert Dialer").addScreenCaptureFromPath(dial).pass("PASS");
        getExtent().flush();
    }
}
