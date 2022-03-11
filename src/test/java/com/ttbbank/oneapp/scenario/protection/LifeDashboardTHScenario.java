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
import java.util.Set;

public class LifeDashboardTHScenario extends ActivateAppTHScenario {

    //Customer 4
    @Test(priority = 4, groups = "Life_04_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_04_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_04_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_04_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Life_20_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_20_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_20_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_20_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 36, groups = "Life_36_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_36_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_36_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_36_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 52, groups = "Life_52_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_52_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_52_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_52_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 68, groups = "Life_68_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_68_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_68_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_68_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_68_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_68_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 5
    @Test(priority = 5, groups = "Life_05_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_05_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_05_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_05_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 69, groups = "Life_69_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_69_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_69_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_69_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_69_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_69_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 6
    @Test(priority = 6, groups = "Life_06_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_06_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_06_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_06_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Life_22_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_22_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_22_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_22_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 38, groups = "Life_38_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_38_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_38_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_38_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 54, groups = "Life_54_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_54_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_54_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_54_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 70, groups = "Life_70_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_70_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_70_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_70_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_70_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_70_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 8
    @Test(priority = 8, groups = "Life_08_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_08_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_08_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_08_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Life_24_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_24_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_24_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_24_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 40, groups = "Life_40_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_40_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_40_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_40_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 56, groups = "Life_56_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_56_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_56_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_56_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 72, groups = "Life_72_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_72_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_72_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_72_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_72_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_72_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 10
    @Test(priority = 10, groups = "Life_10_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_10_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_10_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_10_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 26, groups = "Life_26_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_26_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_26_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_26_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 42, groups = "Life_42_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_42_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_42_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_42_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 58, groups = "Life_58_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_58_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_58_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_58_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 74, groups = "Life_74_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_74_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_74_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_74_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_74_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_74_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 12
    @Test(priority = 12, groups = "Life_12_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_12_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_12_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_12_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 28, groups = "Life_28_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_28_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_28_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_28_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 44, groups = "Life_44_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_44_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_44_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_44_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 60, groups = "Life_60_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_60_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_60_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_60_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 76, groups = "Life_76_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_76_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_76_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_76_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_76_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_76_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 14
    @Test(priority = 14, groups = "Life_14_TH_Life Dashboard - Life Coverage Mile stone", dependsOnGroups = {"Activate application with change language"})
    public void Life_14_TH() throws InterruptedException, IOException {

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON).click();

        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Life_14_TH_Life Coverage Mile stone.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_14_TH_Life Dashboard - Life Coverage Mile stone");
        scenario.createNode(Given.class, "Display Life Coverage Mile stone").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 30, groups = "Life_30_TH_Life Dashboard - Calculate General Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_30_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossoflifFromAnyCauseSubheader.equals("กรณีเสียชีวิตทั่วไป"));
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);

        String existingFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAnyCauseText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(existingFromAnyCauseText + ": " + existingFromAnyCause);

        String lossoflifeFromAccident = "images/Life_30_TH_Protection_Loss of Life General Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_30_TH_Life Dashboard - Calculate General Death coverage");
        scenario.createNode(Given.class, "Display General Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 46, groups = "Life_46_TH_Life Dashboard - Calculate Accidental Death coverage", dependsOnGroups = {"Activate application with change language"})
    public void Life_46_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(lossoflifFromAccidentSubheader.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        System.out.println("\n  " + lossoflifFromAccidentSubheader);

        String existingFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(existingFromAccidentText.equals("ความคุ้มครองปัจจุบัน"));
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(existingFromAccidentText + ": " + existingFromAccident);

        String lossoflifeFromAccident = "images/Life_46_TH_Protection_Loss of Life Accidental Death coverage.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_46_TH_Life Dashboard - Calculate Accidental Death coverage");
        scenario.createNode(Given.class, "Display Accidental Death coverage").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 62, groups = "Life_62_TH_Life Dashboard - Death coverage recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Life_62_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String recommendedFromAnyCauseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_TEXT).getText();
        System.out.println(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAnyCauseText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println(recommendedFromAnyCauseText + ": " + recommendedFromAnyCause);

        String recommendedFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_TEXT).getText();
        System.out.println(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedFromAccidentText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println(recommendedFromAccidentText + ": " + recommendedFromAccident);

        String lossoflifeFromAccident = "images/Life_62_TH_Protection_Loss of Life Death coverage recommendation.png";
        takeScreenshot(lossoflifeFromAccident);
        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_62_TH_Life Dashboard - Death coverage recommendation");
        scenario.createNode(Given.class, "Dislplay Death coverage recommendation").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 78, groups = "Life_78_TH_Life Dashboard - Life Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Life_78_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Life_78_TH_Life Policy List tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Life_78_TH_Life Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        String tagFromAnycuseText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMANYCAUSE).getText();
        System.out.println(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        Assert.assertTrue(tagFromAnycuseText.equals("กรณีเสียชีวิต"));
        String tagFromAccidentText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_TAG_LOSSOFLIFEFROMACCIDENT).getText();
        System.out.println(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(tagFromAccidentText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));

        String lossOfLifeCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_TEXT).getText();
        System.out.println(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        Assert.assertTrue(lossOfLifeCoverageText.equals("กรณีเสียชีวิตทั่วไป"));
        String lossOfLifeCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LOSSOFLIFECOVERAGE_LABEL).getText();
        System.out.println(lossOfLifeCoverageText + ": " + lossOfLifeCoverage);

        String publicAccidentsCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        Assert.assertTrue(publicAccidentsCoverageText.equals("กรณีเสียชีวิตจากอุบัติเหตุ"));
        String publicAccidentsCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PUBLICACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(publicAccidentsCoverageText + ": " + publicAccidentsCoverage);;

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Life_78_TH_Life Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Life_78_TH_Life Policy List tab");
        scenario.createNode(Given.class, "Dislplay Life Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Dislplay Life Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

}
