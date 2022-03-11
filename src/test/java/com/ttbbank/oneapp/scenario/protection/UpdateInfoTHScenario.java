package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class UpdateInfoTHScenario extends ActivateAppTHScenario {

    @Test(priority = 22, groups = "Profile_22_TH_Update Profile for coverage recommendation summary", dependsOnGroups = {"Activate application with change language"})
    public void Profile_22_TH() throws Exception {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='header-text")));
        Thread.sleep(10000);

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER_NEW, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_UPDATE_INFO_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_INSURANCE_UPDATE_INFO_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();

        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_UPDATE_INFO_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_UPDATE_INFO_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String updateInfo = "images/Profile_22_TH_updateInfo.png";
        Thread.sleep(3000);
        takeScreenshot(updateInfo);
        WebElement updateInfoButton = context.findElement(OneAppElementKeys.PROTECTION_INSURANCE_UPDATE_INFO_BUTTON);
        String checkUpdateInfoButton = updateInfoButton.getText();
        System.out.println(checkUpdateInfoButton.equals("อัปเดตข้อมูล"));
        Assert.assertTrue(checkUpdateInfoButton.equals("อัปเดตข้อมูล"));
        updateInfoButton.click();
        Thread.sleep(3000);
        String firstUpdateInfo = "images/Profile_22_TH_firstUpdateInfo.png";
        takeScreenshot(firstUpdateInfo);
        WebElement firstTimeUpdateInfoHeader = context.findElement(OneAppElementKeys.PROTECTION_WELCOMELANDING_UPDATEINFO_HEADER);
        String checkFirstTimeUpdateInfoHeader = firstTimeUpdateInfoHeader.getText();
        System.out.println(checkFirstTimeUpdateInfoHeader.equals("อัปเดตข้อมูลส่วนตัว"));
        Assert.assertTrue(checkFirstTimeUpdateInfoHeader.equals("อัปเดตข้อมูลส่วนตัว"));

        WebElement firstTimeUpdateInfoContent1 = context.findElement(OneAppElementKeys.PROTECTION_WELCOMELANDING_UPDATEINFO_CONTENT1);
        String checkFirstTimeUpdateInfoContent1= firstTimeUpdateInfoContent1.getText();
        System.out.println(checkFirstTimeUpdateInfoContent1.equals("เราได้กำหนดค่าตั้งต้นให้คุณ"));
        Assert.assertTrue(checkFirstTimeUpdateInfoContent1.equals("เราได้กำหนดค่าตั้งต้นให้คุณ"));

        WebElement firstTimeUpdateInfoContent2 = context.findElement(OneAppElementKeys.PROTECTION_WELCOMELANDING_UPDATEINFO_CONTENT2);
        String checkFirstTimeUpdateInfoContent2= firstTimeUpdateInfoContent2.getText();
        System.out.println(checkFirstTimeUpdateInfoContent2.equals("เพื่อให้ได้คำแนะนำที่เหมาะสมที่สุด โปรดอัปเดตข้อมูลของคุณในแต่ละหัวข้อ"));
        Assert.assertTrue(checkFirstTimeUpdateInfoContent2.equals("เพื่อให้ได้คำแนะนำที่เหมาะสมที่สุด โปรดอัปเดตข้อมูลของคุณในแต่ละหัวข้อ"));

        WebElement firstTimeUpdateInfoButton = context.findElement(OneAppElementKeys.PROTECTION_WELCOMELANDING_UPDATEINFO_BUTTON);
        String checkFirstTimeUpdateInfoButton = firstTimeUpdateInfoButton.getText();
        System.out.println(checkFirstTimeUpdateInfoButton.equals("เริ่มต้น"));
        Assert.assertTrue(checkFirstTimeUpdateInfoButton.equals("เริ่มต้น"));
        firstTimeUpdateInfoButton.click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);

        Thread.sleep(3000);
        String updatePersonalInfo = "images/Profile_22_TH_updatePersonalInfo.png";
        takeScreenshot(updatePersonalInfo);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Profile_22_TH_Update Profile for coverage recommendation summary");
        scenario.createNode(Given.class, "Profile_22_TH_Update Info Screen").addScreenCaptureFromPath(updateInfo).pass("PASS");
        scenario.createNode(Given.class, "Profile_22_TH_Can see First visit screens").addScreenCaptureFromPath(firstUpdateInfo).pass("PASS");
        scenario.createNode(Given.class, "Profile_22_TH_Can see default value in Update Profile for coverage recommendation summary screen").addScreenCaptureFromPath(updatePersonalInfo).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 23, groups = "Profile_23_TH_Update Profile for Health coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Profile_23_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
        WebElement HealthCoverageInfoButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_BUTTON);
        HealthCoverageInfoButton.click();
        WebElement editHealthCoverageInfo = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_EDIT_INFO_BUTTON);
        editHealthCoverageInfo.click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT1_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT1_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_ANSWER1_RADIOBUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT1_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT1_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_ANSWER1_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_ANSWER1_TEXTBOX).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"40000");
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_ANSWER1_RADIOBUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT1_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT2_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT2_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_ANSWER2_RADIOBUTTON).click();
        Thread.sleep(1000);
        String updateHealthProfile = "images/Profile_23_TH_Update health profile.png";
        takeScreenshot(updateHealthProfile);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEXT2_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_DONE_BUTTON);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_NEW_AMOUNT_LABEL);
        String healthNewRecommendedValue = "images/Profile_23_TH_Health new recommended value.png";
        takeScreenshot(healthNewRecommendedValue);
        WebElement healthCoverageInfoDoneButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_DONE_BUTTON);
        healthCoverageInfoDoneButton.click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGE_INFO_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String updatePersonalInfo = "images/Profile_23_TH_updatePersonalInfo.png";
        takeScreenshot(updatePersonalInfo);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Profile_23_TH_Update Profile for Health coverage recommendation");
        scenario.createNode(Given.class, "Profile_23_TH_Can update health profile successfully").addScreenCaptureFromPath(updateHealthProfile).pass("PASS");
        scenario.createNode(Given.class, "Profile_23_TH_Can see new recommended value").addScreenCaptureFromPath(healthNewRecommendedValue).pass("PASS");
        scenario.createNode(Given.class, "Profile_23_TH_Can see value in Update Profile for coverage recommendation summary screen").addScreenCaptureFromPath(updatePersonalInfo).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 25, groups = "Profile_25_TH_Update Profile for Wealth coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Profile_25_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_PLANNING_INFO_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_PLANNING_INFO_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_PLANNING_INFO_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        WebElement RetirementPlanningInfoButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_PLANNING_INFO_BUTTON);
        RetirementPlanningInfoButton.click();
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_EDIT_INFO_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_EDIT_INFO_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_EDIT_INFO_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        WebElement editRetirementPlanningInfo = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_EDIT_INFO_BUTTON);
        editRetirementPlanningInfo.click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON1);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER1_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON1).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON2);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER2_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON2).click();

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON3, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON3);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER3_RADIOBUTTON);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON3, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON3);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER3_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER3_TEXTBOX).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "48777");
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER3_RADIOBUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON3).click();

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER4_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON4).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON5, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON5);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER5_RADIOBUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON5, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON5);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER5_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER5_TEXTBOX).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "18001");
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER5_RADIOBUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON5).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON6);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER6_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON6).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON7);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ANSWER7_RADIOBUTTON).click();
        String updateWealthProfile = "images/Update wealth profile.png";
        Thread.sleep(1000);
        takeScreenshot(updateWealthProfile);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_NEXT_BUTTON7).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_DONE_NEW_AMOUNT_BUTTON);
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_DONE_NEW_AMOUNT_LABEL);

        String wealthNewRecommendedValue = "images/Profile_25_TH_Wealth new recommended value.png";
        takeScreenshot(wealthNewRecommendedValue);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_INFO_DONE_NEW_AMOUNT_BUTTON).click();
        Thread.sleep(3000);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_PLANNING_INFO_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        String updatePersonalInfo = "images/Profile_25_TH_updatePersonalInfo1.png";
        takeScreenshot(updatePersonalInfo);
        context.scrollDown();
        String updatePersonalInfo2 = "images/Profile_25_TH_updatePersonalInfo2.png";
        takeScreenshot(updatePersonalInfo2);
        context.scrollDown();
        String updatePersonalInfo3 = "images/Profile_25_TH_updatePersonalInfo3.png";
        takeScreenshot(updatePersonalInfo3);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Profile_25_TH_Update Profile for Wealth coverage recommendation");
        scenario.createNode(Given.class, "Profile_25_TH_Can update wealth profile successfully").addScreenCaptureFromPath(updateWealthProfile).pass("PASS");
        scenario.createNode(Given.class, "Profile_25_TH_Can see new recommended value").addScreenCaptureFromPath(wealthNewRecommendedValue).pass("PASS");
        scenario.createNode(Given.class, "Profile_25_TH_Can see value in Update Profile for coverage recommendation summary screen1").addScreenCaptureFromPath(updatePersonalInfo).pass("PASS");
        scenario.createNode(Given.class, "Profile_25_TH_Can see value in Update Profile for coverage recommendation summary screen2").addScreenCaptureFromPath(updatePersonalInfo2).pass("PASS");
        scenario.createNode(Given.class, "Profile_25_TH_Can see value in Update Profile for coverage recommendation summary screen3").addScreenCaptureFromPath(updatePersonalInfo3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 27, groups = "Profile_27_TH_Update Profile for Life coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Profile_27_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_BUTTON, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        WebElement lossOfLifeInfoButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_BUTTON);
        lossOfLifeInfoButton.click();
        WebElement editRetirementPlanningInfo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_EDIT_INFO_BUTTON);
        editRetirementPlanningInfo.click();

        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON1, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON1);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER1_RADIOBUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON1, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON1);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER1_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER1_TEXTBOX).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "25001");
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER1_RADIOBUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON1).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON2, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON2);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON2);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER2_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON2).click();

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON3, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON3);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER3_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON3).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON4);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER4_RADIOBUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER4_RADIOBUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER4_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON4).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON5);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER5_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON5).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_RADIOBUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_RADIOBUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_RADIOBUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON6, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON6);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_RADIOBUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_TEXTBOX).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "18001");
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER6_RADIOBUTTON).click();
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON6).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON7);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ANSWER7_RADIOBUTTON).click();
        Thread.sleep(1000);
        String updateLifeProfile = "images/Profile_27_TH_Update life profile.png";
        takeScreenshot(updateLifeProfile);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_NEXT_BUTTON7).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_DONE_NEW_AMOUNT_BUTTON);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_DONE_NEW_AMOUNT_LABEL);
        String lifeNewRecommendedValue = "images/Profile_27_TH_Life new recommended value.png";
        takeScreenshot(lifeNewRecommendedValue);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_DONE_NEW_AMOUNT_BUTTON).click();

        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_UPDATE_PERSIONAL_INFO_HEADER);
        Thread.sleep(1000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_INFO_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        String updatePersonalInfo = "images/Profile_27_TH_updatePersonalInfo1.png";
        takeScreenshot(updatePersonalInfo);
        context.scrollDown();
        String updatePersonalInfo2 = "images/Profile_27_TH_updatePersonalInfo2.png";
        takeScreenshot(updatePersonalInfo2);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Profile_27_TH_Update Profile for Life coverage recommendation");
        scenario.createNode(Given.class, "Profile_27_TH_Can update life profile successfully").addScreenCaptureFromPath(updateLifeProfile).pass("PASS");
        scenario.createNode(Given.class, "Profile_27_TH_Can see new recommended value").addScreenCaptureFromPath(lifeNewRecommendedValue).pass("PASS");
        scenario.createNode(Given.class, "Profile_27_TH_Can see value in Update Profile for coverage recommendation summary screen1").addScreenCaptureFromPath(updatePersonalInfo).pass("PASS");
        scenario.createNode(Given.class, "Profile_27_TH_Can see value in Update Profile for coverage recommendation summary screen2").addScreenCaptureFromPath(updatePersonalInfo2).pass("PASS");
        getExtent().flush();
    }
}

