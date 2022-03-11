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

public class HealthDashboardTHScenario extends ActivateAppTHScenario {

    //Customer 4
    @Test(priority = 4, groups = "Health_04_TH_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application with change language"})
    public void Health_04_TH() throws InterruptedException, IOException {

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
        context.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        String healthMed = "images/Health_04_TH_Health_Total Medical Benefits_TH.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        Assert.assertTrue(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        Assert.assertTrue(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        Assert.assertTrue(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        Assert.assertTrue(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        Assert.assertTrue(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_04_TH_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 12, groups = "Health_12_TH_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application with change language"})
    public void Health_12_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthCancer = "images/Health_12_TH__Total Cancer and Critical Illness Benefits_TH.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        Assert.assertTrue(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบันe"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        Assert.assertTrue(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("จ่ายค่ารักษา"));
        Assert.assertTrue(payForTreatmentText.equals("จ่ายค่ารักษา"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_12_TH_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Health_20_TH_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application with change language"})
    public void Health_20_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(1000);
        String healthIncome = "images/Health_20_TH__Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_20_TH_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 28, groups = "Health_28_TH_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Health_28() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String policyTab = "images/Health_28_TH_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_28_TH_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("ความคุ้มครอง"));
        Assert.assertTrue(coverageText.equals("ความคุ้มครอง"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_28_TH_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_28_TH_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 5
    @Test(priority = 5, groups = "Health_05_TH_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application with change language"})
    public void Health_05_TH() throws InterruptedException, IOException {

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
        context.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        String healthMed = "images/Health_05_TH_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        Assert.assertTrue(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        Assert.assertTrue(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        Assert.assertTrue(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        Assert.assertTrue(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        Assert.assertTrue(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_05_TH_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 13, groups = "Health_13_TH_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application with change language"})
    public void Health_13_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthCancer = "images/Health_13_TH_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        Assert.assertTrue(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบันe"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        Assert.assertTrue(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("จ่ายค่ารักษา"));
        Assert.assertTrue(payForTreatmentText.equals("จ่ายค่ารักษา"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_13_TH_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 21, groups = "Health_21_TH_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application with change language"})
    public void Health_21_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(1000);
        String healthIncome = "images/Health_21_TH_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_21_TH_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 29, groups = "Health_29_TH_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Health_29_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String policyTab = "images/Health_29_TH_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_29_TH_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("ความคุ้มครอง"));
        Assert.assertTrue(coverageText.equals("ความคุ้มครอง"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_29_TH_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_29_TH_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 6
    @Test(priority = 6, groups = "Health_06_TH_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application with change language"})
    public void Health_06_TH() throws InterruptedException, IOException {

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
        context.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        String healthMed = "images/Health_06_TH_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        Assert.assertTrue(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        Assert.assertTrue(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        Assert.assertTrue(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        Assert.assertTrue(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        Assert.assertTrue(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_06_TH_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 14, groups = "Health_14_TH_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application with change language"})
    public void Health_14_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthCancer = "images/Health_14_TH_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        Assert.assertTrue(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบันe"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        Assert.assertTrue(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("จ่ายค่ารักษา"));
        Assert.assertTrue(payForTreatmentText.equals("จ่ายค่ารักษา"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_14_TH_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Health_22_TH_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application with change language"})
    public void Health_22_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(1000);
        String healthIncome = "images/Health_22_TH_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_22_TH_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 30, groups = "Health_30_TH_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Health_30_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String policyTab = "images/Health_30_TH_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_30_TH_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("ความคุ้มครอง"));
        Assert.assertTrue(coverageText.equals("ความคุ้มครอง"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_30_TH_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_30_TH_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 8
    @Test(priority = 8, groups = "Health_08_TH_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application with change language"})
    public void Health_08_TH() throws InterruptedException, IOException {

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
        context.setContextToWebView(OneAppElementKeys.PROTECTION_MAININSURANCE_HEADER, true);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON).click();
        String healthMed = "images/Health_08_TH_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        Assert.assertTrue(totalMedSubheaderText.equals("วงเงินค่ารักษาพยาบาลทั้งหมด"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoverageMedText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMed.equals("0"));
        Assert.assertTrue(myExisingCoverageMed.equals("0"));
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageMedText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        Assert.assertTrue(hospitalCoverageText.equals("ค่าห้อง (ต่อวัน)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverage.equals("0"));
        Assert.assertTrue(hospitalCoverage.equals("0"));
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        Assert.assertTrue(icuCoverageText.equals("ค่าห้อง ICU (ต่อวัน)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverage.equals("0"));
        Assert.assertTrue(icuCoverage.equals("0"));
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        Assert.assertTrue(opdCoverageText.equals("ผู้ป่วยนอก (ต่อครั้ง)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverage.equals("0"));
        Assert.assertTrue(opdCoverage.equals("0"));
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        Assert.assertTrue(accidentCoverageText.equals("อุบัติเหตุ (ต่อครั้ง)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverage.equals("0"));
        Assert.assertTrue(accidentCoverage.equals("0"));
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_08_TH_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 16, groups = "Health_16_TH_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application with change language"})
    public void Health_16_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String healthCancer = "images/Health_16_TH_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        Assert.assertTrue(totalCancerSubheaderText.equals("คุ้มครองโรคมะเร็งและโรคร้ายแรง"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบันe"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancer.equals("0"));
        Assert.assertTrue(myExisingCoveragcCancer.equals("0"));
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        Assert.assertTrue(payAfterPositiveText.equals("จ่ายเมื่อตรวจเจอ"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositive.equals("0"));
        Assert.assertTrue(payAfterPositive.equals("0"));
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("จ่ายค่ารักษา"));
        Assert.assertTrue(payForTreatmentText.equals("จ่ายค่ารักษา"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatment.equals("0"));
        Assert.assertTrue(payForTreatment.equals("0"));
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_16_TH_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Health_24_TH_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application with change language"})
    public void Health_24_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(1000);
        String healthIncome = "images/Health_24_TH_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("ชดเชยรายได้ (ต่อวัน)"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("ความคุ้มครองปัจจุบัน"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncome.equals("0"));
        Assert.assertTrue(myExisingCoveragcIncome.equals("0"));
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("ความคุ้มครองที่แนะนำ"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_24_TH_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 32, groups = "Health_32_TH_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Health_32_TH() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String policyTab = "images/Health_32_TH_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_32_TH_Health Policy List.png";
        takeScreenshot(policyCard);

        String emptyCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE).getText();
        System.out.println(emptyCoverageText.equals("คุณยังไม่มีความคุ้มครอง"));
        Assert.assertTrue(emptyCoverageText.equals("คุณยังไม่มีความคุ้มครอง"));
        String emptyCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE).getText();
        System.out.println(emptyCoverageText + ": " + emptyCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE_BUYINSURANCE).click();
        Thread.sleep(3000);
        String buyInsurance = "images/Health_32_TH_Health Policy Detail screen.png";
        takeScreenshot(buyInsurance);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_32_TH_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to insurance store - Health shelf").addScreenCaptureFromPath(buyInsurance).pass("PASS");
        getExtent().flush();
    }
}
