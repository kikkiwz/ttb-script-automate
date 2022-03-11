package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class HealthDashboardScenario extends ActivateAppScenario {

    @Test(groups = "Health Protection Coverage Summary", dependsOnGroups = {"Activate application"}, priority = 1)
    public void healthCoverageSummary() throws InterruptedException, IOException {

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
        String healthMed = "images/Protection_Health_Total Medical Benefits.png";
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println("My existing coverage: " + myExisingCoverageMed);
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println("Recommended coverage: " + recommendedCoverageMed);
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println("Hospital room & Board: " + hospitalCoverage);
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println("ICU room expense: " + icuCoverage);
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println("OPD (per incident): " + opdCoverage);
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println("Accidents (per incident): " + accidentCoverage);
        takeScreenshot(healthMed);

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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
        String healthCancer = "images/Protection_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println("My existing coverage: " + myExisingCoveragcCancer);
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println("Recommended coverage: " + recommendedCoverageCancer);
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println("Pay after positive diagnosis: " + payAfterPositive);
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println("Pay for treatment: " + payForTreatment);
        takeScreenshot(healthCancer);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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
        String healthIncome = "images/Protection_Income Replacement (per day).png";
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println("My existing coverage: " + myExisingCoveragcIncome);
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println("Recommended coverage: " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health Protection Coverage Summary");
        scenario.createNode(Given.class, "Health_Total Medical Benefits").addScreenCaptureFromPath(healthMed).pass("PASS");
        scenario.createNode(Given.class, "Total Cancer and Critical Illness Benefits").addScreenCaptureFromPath(healthCancer).pass("PASS");
        scenario.createNode(Given.class, "Income Replacement (per day)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    //Customer 4
    @Test(priority = 4, groups = "Health_04_EN_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application"})
    public void Health_04() throws InterruptedException, IOException {

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
        String healthMed = "images/Health_04_EN_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("Total Medical Benefits"));
        Assert.assertTrue(totalMedSubheaderText.equals("Total Medical Benefits"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoverageMedText.equals("My existing coverage"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageMedText.equals("Recommended coverage"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("Room expense (per day)"));
        Assert.assertTrue(hospitalCoverageText.equals("Room expense (per day)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ICU room expense (per day)"));
        Assert.assertTrue(icuCoverageText.equals("ICU room expense (per day)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("Outpatient (per incident)"));
        Assert.assertTrue(opdCoverageText.equals("Outpatient (per incident)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("Accident (per incident)"));
        Assert.assertTrue(accidentCoverageText.equals("Accident (per incident)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_04_EN_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 12, groups = "Health_12_EN_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application"})
    public void Health_12() throws InterruptedException, IOException {

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

        String healthCancer = "images/Health_12_EN_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("My existing coverage"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("Recommended coverage"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("Pay after positive diagnosis"));
        Assert.assertTrue(payAfterPositiveText.equals("Pay after positive diagnosis"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("Pay for treatment"));
        Assert.assertTrue(payForTreatmentText.equals("Pay for treatment"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_12_EN_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Health_20_EN_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application"})
    public void Health_20() throws InterruptedException, IOException {

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
        String healthIncome = "images/Health_20_EN_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("My existing coverage"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("Recommended coverage"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_20_EN_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 28, groups = "Health_28_EN_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application"})
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
        String policyTab = "images/Health_28_EN_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_28_EN_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("Coverage"));
        Assert.assertTrue(coverageText.equals("Coverage"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("Beginning of coverage"));
        Assert.assertTrue(beginOfCoverageText.equals("Beginning of coverage"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("End of coverage"));
        Assert.assertTrue(endOfCoverageText.equals("End of coverage"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_28_EN_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_28_EN_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 5
    @Test(priority = 5, groups = "Health_05_EN_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application"})
    public void Health_05() throws InterruptedException, IOException {

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
        String healthMed = "images/Health_05_EN_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("Total Medical Benefits"));
        Assert.assertTrue(totalMedSubheaderText.equals("Total Medical Benefits"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoverageMedText.equals("My existing coverage"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageMedText.equals("Recommended coverage"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("Room expense (per day)"));
        Assert.assertTrue(hospitalCoverageText.equals("Room expense (per day)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ICU room expense (per day)"));
        Assert.assertTrue(icuCoverageText.equals("ICU room expense (per day)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("Outpatient (per incident)"));
        Assert.assertTrue(opdCoverageText.equals("Outpatient (per incident)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("Accident (per incident)"));
        Assert.assertTrue(accidentCoverageText.equals("Accident (per incident)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_05_EN_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 13, groups = "Health_13_EN_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application"})
    public void Health_13() throws InterruptedException, IOException {

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

        String healthCancer = "images/Health_13_EN_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("My existing coverage"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("Recommended coverage"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("Pay after positive diagnosis"));
        Assert.assertTrue(payAfterPositiveText.equals("Pay after positive diagnosis"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("Pay for treatment"));
        Assert.assertTrue(payForTreatmentText.equals("Pay for treatment"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_13_EN_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 21, groups = "Health_21_EN_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application"})
    public void Health_21() throws InterruptedException, IOException {

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
        String healthIncome = "images/Health_21_EN_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("My existing coverage"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("Recommended coverage"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_21_EN_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 29, groups = "Health_29_EN_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application"})
    public void Health_29() throws InterruptedException, IOException {

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
        String policyTab = "images/Health_29_EN_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_29_EN_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("Coverage"));
        Assert.assertTrue(coverageText.equals("Coverage"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("Beginning of coverage"));
        Assert.assertTrue(beginOfCoverageText.equals("Beginning of coverage"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("End of coverage"));
        Assert.assertTrue(endOfCoverageText.equals("End of coverage"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_29_EN_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_29_EN_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 6
    @Test(priority = 6, groups = "Health_06_EN_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application"})
    public void Health_06() throws InterruptedException, IOException {

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
        String healthMed = "images/Health_06_EN_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("Total Medical Benefits"));
        Assert.assertTrue(totalMedSubheaderText.equals("Total Medical Benefits"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoverageMedText.equals("My existing coverage"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageMedText.equals("Recommended coverage"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("Room expense (per day)"));
        Assert.assertTrue(hospitalCoverageText.equals("Room expense (per day)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ICU room expense (per day)"));
        Assert.assertTrue(icuCoverageText.equals("ICU room expense (per day)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("Outpatient (per incident)"));
        Assert.assertTrue(opdCoverageText.equals("Outpatient (per incident)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("Accident (per incident)"));
        Assert.assertTrue(accidentCoverageText.equals("Accident (per incident)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_06_EN_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 14, groups = "Health_14_EN_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application"})
    public void Health_14() throws InterruptedException, IOException {

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

        String healthCancer = "images/Health_14_EN_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("My existing coverage"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("Recommended coverage"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("Pay after positive diagnosis"));
        Assert.assertTrue(payAfterPositiveText.equals("Pay after positive diagnosis"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("Pay for treatment"));
        Assert.assertTrue(payForTreatmentText.equals("Pay for treatment"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_14_EN_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Health_22_EN_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application"})
    public void Health_22() throws InterruptedException, IOException {

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
        String healthIncome = "images/Health_22_EN_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("My existing coverage"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("Recommended coverage"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_22_EN_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 30, groups = "Health_30_EN_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application"})
    public void Health_30() throws InterruptedException, IOException {

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
        String policyTab = "images/Health_30_EN_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_30_EN_Health Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_CI);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_MED);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_TAG_INCOME);

        String coverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_TEXT).getText();
        System.out.println(coverageText.equals("Coverage"));
        Assert.assertTrue(coverageText.equals("Coverage"));
        String coverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_COVERAGE_LABEL).getText();
        System.out.println(coverageText + ": " + coverage);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("Beginning of coverage"));
        Assert.assertTrue(beginOfCoverageText.equals("Beginning of coverage"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("End of coverage"));
        Assert.assertTrue(endOfCoverageText.equals("End of coverage"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Health_30_EN_Health Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_28_EN_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 8
    @Test(priority = 8, groups = "Health_08_EN_Health Dashboard - Display Medical Expense value", dependsOnGroups = {"Activate application"})
    public void Health_08() throws InterruptedException, IOException {

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
        String healthMed = "images/Health_06_EN_Health_Total Medical Benefits.png";

        String totalMedSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println(totalMedSubheaderText.equals("Total Medical Benefits"));
        Assert.assertTrue(totalMedSubheaderText.equals("Total Medical Benefits"));
        String totalMedSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALMEDICAL_LABEL).getText();
        System.out.println("\n  " + totalMedSubheader);

        String myExisingCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_TEXT).getText();
        System.out.println(myExisingCoverageMedText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoverageMedText.equals("My existing coverage"));
        String myExisingCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_MED_LABEL).getText();
        System.out.println(myExisingCoverageMed.equals("0"));
        Assert.assertTrue(myExisingCoverageMed.equals("0"));
        System.out.println(myExisingCoverageMedText + ": " + myExisingCoverageMed);

        String recommendedCoverageMedText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_TEXT).getText();
        System.out.println(recommendedCoverageMedText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageMedText.equals("Recommended coverage"));
        String recommendedCoverageMed = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_MED_LABEL).getText();
        System.out.println(recommendedCoverageMedText + ": " + recommendedCoverageMed);

        String hospitalCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_TEXT).getText();
        System.out.println(hospitalCoverageText.equals("Room expense (per day)"));
        Assert.assertTrue(hospitalCoverageText.equals("Room expense (per day)"));
        String hospitalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_HOSPITALCOVERAGE_LABEL).getText();
        System.out.println(hospitalCoverage.equals("0"));
        Assert.assertTrue(hospitalCoverage.equals("0"));
        System.out.println(hospitalCoverageText + ": " + hospitalCoverage);

        String icuCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_TEXT).getText();
        System.out.println(icuCoverageText.equals("ICU room expense (per day)"));
        Assert.assertTrue(icuCoverageText.equals("ICU room expense (per day)"));
        String icuCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ICUCOVERAGE_LABEL).getText();
        System.out.println(icuCoverage.equals("0"));
        Assert.assertTrue(icuCoverage.equals("0"));
        System.out.println(icuCoverageText + ": " + icuCoverage);

        String opdCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_TEXT).getText();
        System.out.println(opdCoverageText.equals("Outpatient (per incident)"));
        Assert.assertTrue(opdCoverageText.equals("Outpatient (per incident)"));
        String opdCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_OPDCOVERAGE_LABEL).getText();
        System.out.println(opdCoverage.equals("0"));
        Assert.assertTrue(opdCoverage.equals("0"));
        System.out.println(opdCoverageText + ": " + opdCoverage);

        String accidentCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_TEXT).getText();
        System.out.println(accidentCoverageText.equals("Accident (per incident)"));
        Assert.assertTrue(accidentCoverageText.equals("Accident (per incident)"));
        String accidentCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_ACCIDENTSCOVERAGE_LABEL).getText();
        System.out.println(accidentCoverage.equals("0"));
        Assert.assertTrue(accidentCoverage.equals("0"));
        System.out.println(accidentCoverageText + ": " + accidentCoverage);
        takeScreenshot(healthMed);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_06_EN_Health Dashboard - Medical Expense Dashboard");
        scenario.createNode(Given.class, "Display Medical Expense value").addScreenCaptureFromPath(healthMed).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 16, groups = "Health_16_EN_Health Dashboard - Display CI Expense Value", dependsOnGroups = {"Activate application"})
    public void Health_16() throws InterruptedException, IOException {

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

        String healthCancer = "images/Health_14_EN_Total Cancer and Critical Illness Benefits.png";
        String totalCancerSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(totalCancerSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String totalCancerSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println("\n  " + totalCancerSubheader);

        String myExisingCoveragcCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_TEXT).getText();
        System.out.println(myExisingCoveragcCancerText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcCancerText.equals("My existing coverage"));
        String myExisingCoveragcCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_CANCER_LABEL).getText();
        System.out.println(myExisingCoveragcCancer.equals("0"));
        Assert.assertTrue(myExisingCoveragcCancer.equals("0"));
        System.out.println(myExisingCoveragcCancerText + ": " + myExisingCoveragcCancer);

        String recommendedCoverageCancerText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_TEXT).getText();
        System.out.println(recommendedCoverageCancerText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageCancerText.equals("Recommended coverage"));
        String recommendedCoverageCancer = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_CANCER_LABEL).getText();
        System.out.println(recommendedCoverageCancerText + ": " + recommendedCoverageCancer);

        String payAfterPositiveText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_TEXT).getText();
        System.out.println(payAfterPositiveText.equals("Pay after positive diagnosis"));
        Assert.assertTrue(payAfterPositiveText.equals("Pay after positive diagnosis"));
        String payAfterPositive = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYAFTERPOSITIVE_LABEL).getText();
        System.out.println(payAfterPositive.equals("0"));
        Assert.assertTrue(payAfterPositive.equals("0"));
        System.out.println(payAfterPositiveText + ": " + payAfterPositive);

        String payForTreatmentText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_TEXT).getText();
        System.out.println(payForTreatmentText.equals("Pay for treatment"));
        Assert.assertTrue(payForTreatmentText.equals("Pay for treatment"));
        String payForTreatment = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_PAYFORTREATMENT_LABEL).getText();
        System.out.println(payForTreatment.equals("0"));
        Assert.assertTrue(payForTreatment.equals("0"));
        System.out.println(payForTreatmentText +": " + payForTreatment);
        takeScreenshot(healthCancer);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_14_EN_Health Dashboard - CI Expense Dashboard");
        scenario.createNode(Given.class, "Display CI Expense Value").addScreenCaptureFromPath(healthCancer).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Health_24_EN_Health Dashboard - Hospital Benefit MEB", dependsOnGroups = {"Activate application"})
    public void Health_24() throws InterruptedException, IOException {

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
        String healthIncome = "images/Health_22_EN_Income Replacement (per day).png";
        String incomeReplacementSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_TOTALCANCER_LABEL).getText();
        System.out.println(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        Assert.assertTrue(incomeReplacementSubheaderText.equals("Total Cancer and Critical Illness Benefits"));
        String incomeReplacementSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_INCOMEREPLACEEMENT_LABEL).getText();
        System.out.println("\n  " + incomeReplacementSubheader);

        String myExisingCoveragcIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_TEXT).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("My existing coverage"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("My existing coverage"));
        String myExisingCoveragcIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_EXISTINGCOVERAGE_INCOME_LABEL).getText();
        System.out.println(myExisingCoveragcIncomeText.equals("0"));
        Assert.assertTrue(myExisingCoveragcIncomeText.equals("0"));
        System.out.println(myExisingCoveragcIncomeText + ": " + myExisingCoveragcIncome);

        String recommendedCoverageIncomeText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_TEXT).getText();
        System.out.println(recommendedCoverageIncomeText.equals("Recommended coverage"));
        Assert.assertTrue(recommendedCoverageIncomeText.equals("Recommended coverage"));
        String recommendedCoverageIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_COVERAGESUMARY_RECOMMENDEDCOVERAGE_INCOME_LABEL).getText();
        System.out.println(recommendedCoverageIncomeText + ": " + recommendedCoverageIncome);
        takeScreenshot(healthIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_22_EN_Health Dashboard - Hospital Benefit (MEB)");
        scenario.createNode(Given.class, "Display Hospital Benefit (MEB)").addScreenCaptureFromPath(healthIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 32, groups = "Health_32_EN_Health Dashboard - Dislplay Health Policy List tab", dependsOnGroups = {"Activate application"})
    public void Health_32() throws InterruptedException, IOException {

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
        String policyTab = "images/Health_32_EN_Health Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Health_32_EN_Health Policy List.png";
        takeScreenshot(policyCard);

        String emptyCoverageText = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE).getText();
        System.out.println(emptyCoverageText.equals("You have no protection"));
        Assert.assertTrue(emptyCoverageText.equals("You have no protection"));
        String emptyCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE).getText();
        System.out.println(emptyCoverageText + ": " + emptyCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE_BUYINSURANCE).click();
        Thread.sleep(3000);
        String buyInsurance = "images/Health_32_EN_Health Policy Detail screen.png";
        takeScreenshot(buyInsurance);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health_32_EN_Health Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to insurance store - Health shelf").addScreenCaptureFromPath(buyInsurance).pass("PASS");
        getExtent().flush();
    }

}
