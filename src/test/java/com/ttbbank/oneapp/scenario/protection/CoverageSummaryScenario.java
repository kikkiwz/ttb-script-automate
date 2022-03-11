package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class CoverageSummaryScenario extends ActivateAppScenario {

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

    @Test(groups = "Retirement Coverage Summary", dependsOnGroups = {"Activate application"}, priority = 2)
    public void retirementCoverageSummary() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_BLUE);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_BLUE);
        Thread.sleep(10000);
        String retirementCoverageSum = "images/Protection_Retirement Coverage Summary.png";
        takeScreenshot(retirementCoverageSum);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RETIREMENTSAVING_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RETIREMENTSAVING_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String retirementSavingSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RETIREMENTSAVING_LABEL).getText();
        System.out.println("\n  " + retirementSavingSubheader);
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println("Your existing monthly retirement income: " + existingMonthlyIncome);
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println("Recommended monthly retirement income: " + recommendedMonthlyIncome);
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println("Coupons from your insurance policies: " + couponsSaving);
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println("Investment and return from investment: " + investmentReturnSaving);
        String retirementSaving = "images/Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        String monthlyRetirementIncomeSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_LABEL).getText();
        System.out.println("\n  " + monthlyRetirementIncomeSubheader);
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println("Coupons from your insurance policies: " + couponsInsurance);
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println("Investment and return from investment: " + investmentReturnIncome);
        String monthlyRetirementIncome = "images/Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Retirement Coverage Summary");
        scenario.createNode(Given.class, "Projected Retirement Savings Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Projected Retirement Savings Include").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        scenario.createNode(Given.class, "Projected Monthly Retirement Income)").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(groups = "Loss of life Coverage Summary", dependsOnGroups = {"Activate application"}, priority = 3)
    public void lossoflifeCoverageSummary() throws InterruptedException, IOException {

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
        Thread.sleep(10000);
        String lossoflifeCoverageSum = "images/Protection_Loss of life Coverage Summary.png";
        takeScreenshot(lossoflifeCoverageSum);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL);
        String lossoflifFromAnyCauseSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMANYCAUSE_LABEL).getText();
        System.out.println("\n  " + lossoflifFromAnyCauseSubheader);
        String existingFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println("Your existing monthly retirement income: " + existingFromAnyCause);
        String recommendedFromAnyCause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ANYCAUSE_LABEL).getText();
        System.out.println("Recommended monthly retirement income: " + recommendedFromAnyCause);
        String lossoflifeFromAnyCause = "images/Protection_Loss of Life from Any Cause.png";
        takeScreenshot(lossoflifeFromAnyCause);
        String lossoflifFromAccidentSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_FROMACCIDENT_LABEL).getText();
        System.out.println("\n  " + lossoflifFromAccidentSubheader);
        String existingFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_EXISTINGCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println("Your existing monthly retirement income: " + existingFromAccident);

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
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
        String recommendedFromAccident = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_COVERAGESUMARY_RECOMMENDEDCOVERAGE_ACCIDENT_LABEL).getText();
        System.out.println("Recommended monthly retirement income: " + recommendedFromAccident);
        String lossoflifeFromAccident = "images/Protection_Loss of Life from Any Cause.png";
        takeScreenshot(lossoflifeFromAccident);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loss of life Coverage Summary");
        scenario.createNode(Given.class, "Loss of life Coverage Summary").addScreenCaptureFromPath(lossoflifeCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Loss of Life from Any Cause").addScreenCaptureFromPath(lossoflifeFromAnyCause).pass("PASS");
        scenario.createNode(Given.class, "Loss of Life from Accidents)").addScreenCaptureFromPath(lossoflifeFromAccident).pass("PASS");
        getExtent().flush();
    }
}
