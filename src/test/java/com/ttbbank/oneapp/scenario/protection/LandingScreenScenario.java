package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class LandingScreenScenario extends ActivateAppScenario {

    //Customer 4
    @Test(priority = 4, groups = "Landing_04_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_04_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_04_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_04_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_04_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_04_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_04_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_04_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_04_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_04_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Landing_20_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_20_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_20_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_20_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_20_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_20_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_20_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_20_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_20_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 6
    @Test(priority = 6, groups = "Landing_06_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_06_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_06_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_06_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_06_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_06_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_06_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_06_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_06_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_06_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Landing_22_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_22_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_22_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_22_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_22_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_22_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_22_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_22_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_22_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 8
    @Test(priority = 8, groups = "Landing_08_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_08_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_08_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_08_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_08_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_08_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_08_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_08_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_08_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_08_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Landing_24_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_24_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_24_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_24_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_24_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_24_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_24_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_24_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_24_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 10
    @Test(priority = 10, groups = "Landing_10_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_10_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_10_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_10_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_10_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_10_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_10_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_10_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_10_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_10_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Landing_26_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_26_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_26_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_26_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_26_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_26_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_26_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_26_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_26_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 12
    @Test(priority = 12, groups = "Landing_12_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_12_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_12_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_12_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_12_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_12_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_12_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_12_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_12_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_12_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 28, groups = "Landing_28_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_28_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_28_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_28_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_28_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_28_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_28_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_28_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_28_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 14
    @Test(priority = 14, groups = "Landing_14_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_14_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_14_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_14_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_14_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_14_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_14_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_14_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_14_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_14_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 28, groups = "Landing_30_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_30_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_30_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_30_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_30_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_30_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_30_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_30_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_30_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

    //Customer 16
    @Test(priority = 16, groups = "Landing_16_EN_Landing screen - Life and Health Summary", dependsOnGroups = {"Activate application"})
    public void Landing_16_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.findElement(OneAppElementKeys.PROTECTION_RENEWEXISTING_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_PREMIUMCASHFLOW_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_BUYINSURANCE_MENU);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU);

        SimpleDateFormat format= new SimpleDateFormat("DD MMM YY", Locale.getDefault());
        String getDateFromDevice = format.format(new Date());
        System.out.println(getDateFromDevice);

        context.getDriver().context("NATIVE_APP");
        String getDateFromApp = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_ASOFDATE_LABEL).getText();
        System.out.println(getDateFromApp);
        String[] parts = getDateFromApp.split("OF ");
        String part2 = parts[1];
        System.out.println(part2);
        Assert.assertTrue(getDateFromApp.equals(getDateFromDevice));

        String shortcuts = "images/Life_16_EN_Life and Health card and shortcuts.png";
        takeScreenshot(shortcuts);

        context.scrollDown();
        Thread.sleep(5000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthDashborad = "images/Life_16_EN_Health Dashborad section.png";
        takeScreenshot(healthDashborad);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_LABEL);
        String currentMed = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_MED_LABEL).getText();
        Assert.assertEquals(currentMed, "0");
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_MED_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_CURRENT_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_HEALTH_RECOMMEND_CI_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreHealthDashborad = "images/Life_16_EN_Click More details to see Health Dashboard.png";
        takeScreenshot(moreHealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String wealthDashborad = "images/Life_16_EN_Wealth Dashborad section.png";
        takeScreenshot(wealthDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_LABEL);
        String currentWealth = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_CURRENT_LABEL).getText();
        Assert.assertEquals(currentWealth, "0");
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_WEALTH_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreWealthDashborad = "images/Life_16_EN_Click More details to see Wealth Dashboard.png";
        takeScreenshot(moreWealthDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        Thread.sleep(5000);
        String lifeDashborad = "images/Life_16_EN_Lealth Dashborad section.png";
        takeScreenshot(lifeDashborad);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_LABEL);
        String currentLife = context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_CURRENT_LABEL).getText();
        Assert.assertEquals(currentLife, "0");
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_LIFE_RECOMMEND_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();
        Thread.sleep(4000);
        String moreLifeDashborad = "images/Life_16_EN_Click More details to see Life Dashboard.png";
        takeScreenshot(moreLifeDashborad);

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_16_EN_Landing screen - Life and Health Summary");
        scenario.createNode(Given.class, "Able to see Life and Health card and shortcuts (Pay Bill, Cash Flow, Insurance store, and More").addScreenCaptureFromPath(shortcuts).pass("PASS");
        scenario.createNode(Given.class, "Health Dashborad section is correct").addScreenCaptureFromPath(healthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Health Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Wealth Dashborad section is correct").addScreenCaptureFromPath(wealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Wealth Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        scenario.createNode(Given.class, "Life Dashborad section is correct").addScreenCaptureFromPath(lifeDashborad).pass("PASS");
        scenario.createNode(Given.class, "Can click More details to see Life Dashboard screen").addScreenCaptureFromPath(moreHealthDashborad).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 32, groups = "Landing_32_EN_Landing screen - Other insurance Summary", dependsOnGroups = {"Activate application"})
    public void Landing_32_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_MENU).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_LABEL).getText();
        String insuranceStore = "images/Life_32_EN_Click on Insurance Store icon.png";
        takeScreenshot(insuranceStore);
        context.findElement(OneAppElementKeys.PROTECTION_OTHERINSURANCESERVICE_SUBMENU_HEALTHCARECARD).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String insuranceStore2 = "images/Life_32_EN_Click on Insurance Store icon2.png";
        takeScreenshot(insuranceStore2);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_SELECTINSURANCEPLAN_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        Thread.sleep(3000);
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.horizontalSwipeByPercentage(0.5, 0.1, 0.3);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTTYPE_TAB).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String productTypeTab = "images/Life_32_EN_Click Product Type in Navigation Tab.png";
        takeScreenshot(productTypeTab);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_PRODUCTGUARD_BUTTON).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(5000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL);
        String productTypeDetails = "images/Life_32_EN_Click See Policy Detail link.png";
        takeScreenshot(productTypeDetails);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON);
        Thread.sleep(2000);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMECONSENT_BUTTON).click();
        String goToTopButton = "images/Life_32_EN_Click Go to Top button.png";
        takeScreenshot(goToTopButton);
        context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_CHROMEBACKTOTOP_BUTTON).click();
        Thread.sleep(2000);
        System.out.println(context.findElement(OneAppElementKeys.PROTECTION_LANDINGSCREEN_OTHERINSURANCE_HOME_HEADER_LABEL).getText());
        String goToTopContent = "images/Life_32_EN_Scroll up to the Top of screen.png";
        takeScreenshot(goToTopContent);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_32_EN_Landing screen - Other insurance Summary");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store").addScreenCaptureFromPath(insuranceStore).pass("PASS");
        scenario.createNode(Given.class, "Can click on Insurance Store icon or description, then system navigate customer to Insurance Store2").addScreenCaptureFromPath(insuranceStore2).pass("PASS");
        scenario.createNode(Given.class, "Can click Product Type in Navigation Tab, then system will display filtered product which customer selected: Car or Home").addScreenCaptureFromPath(productTypeTab).pass("PASS");
        scenario.createNode(Given.class, "Click See Policy Detail link, then system navigate customer to Policy Details").addScreenCaptureFromPath(productTypeDetails).pass("PASS");
        scenario.createNode(Given.class, "Can click Go to Top button").addScreenCaptureFromPath(goToTopButton).pass("PASS");
        scenario.createNode(Given.class, "System scroll up to the Top of screen").addScreenCaptureFromPath(goToTopContent).pass("PASS");
        getExtent().flush();
    }

}
