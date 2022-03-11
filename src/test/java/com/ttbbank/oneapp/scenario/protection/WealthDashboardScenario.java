package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class WealthDashboardScenario extends ActivateAppScenario {

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
    @Test(priority = 4, groups = "Wealth_04_EN_Wealth Dashboard - Display Current Retirement Planning value", dependsOnGroups = {"Activate application"})
    public void Wealth_04_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String retirement = "images/Wealth_04_EN_Protection_Retirement.png";
        Thread.sleep(1000);
        takeScreenshot(retirement);

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
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String retirementCoverageSum = "images/Wealth_04_EN_Protection_Retirement Coverage Summary.png";
        takeScreenshot(retirementCoverageSum);
        context.getDriver().context("NATIVE_APP");
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
        System.out.println(retirementSavingSubheader.equals("Projected Retirement Savings"));
        Assert.assertTrue(retirementSavingSubheader.equals("Projected Retirement Savings"));


        String existingMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_TEXT).getText();
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println(existingMonthlyIncomeText + ": " + existingMonthlyIncome);
        System.out.println(existingMonthlyIncomeText.equals("Your existing retirement savings"));
        Assert.assertTrue(existingMonthlyIncomeText.equals("Your existing retirement savings"));

        String recommendedMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_TEXT).getText();
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println(recommendedMonthlyIncomeText + ": " + recommendedMonthlyIncome);
        System.out.println(recommendedMonthlyIncomeText.equals("Recommended retirement savings"));
        Assert.assertTrue(recommendedMonthlyIncomeText.equals("Recommended retirement savings"));

        String couponsSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_TEXT).getText();
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println(couponsSavingText + ": " + couponsSaving);
        System.out.println(couponsSavingText.equals("Coupons from your insurance policies"));
        Assert.assertTrue(couponsSavingText.equals("Coupons from your insurance policies"));

        String investmentReturnSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_TEXT).getText();
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnSavingText + ": " + investmentReturnSaving);
        System.out.println(investmentReturnSavingText.equals("Investment and return from investment"));
        Assert.assertTrue(investmentReturnSavingText.equals("Investment and return from investment"));

        String retirementSaving = "images/Wealth_04_EN_Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_04_EN_Display Retirement plan recommendation");
        scenario.createNode(Given.class, "Retirement Coverage").addScreenCaptureFromPath(retirement).pass("PASS");
        scenario.createNode(Given.class, "Retirement Coverage Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Display Current Retirement Planning value").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 12, groups = "Wealth_12_EN_Wealth Dashboard - Display Retirement plan recommendation", dependsOnGroups = {"Activate application"})
    public void Wealth_12_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_YEAR);

        String monthlyRetirementIncomeSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT).getText();
        String monthlyRetirementIncomeSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_LABEL).getText();
        System.out.println("\n  " + monthlyRetirementIncomeSubheaderText + ": " + monthlyRetirementIncomeSubheader);
        System.out.println(monthlyRetirementIncomeSubheaderText.equals("Projected Monthly Retirement Income"));
        Assert.assertTrue(monthlyRetirementIncomeSubheaderText.equals("Projected Monthly Retirement Income"));

        String couponsInsuranceText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_TEXT).getText();
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println(couponsInsuranceText + ": " + couponsInsurance);
        System.out.println(couponsInsuranceText.equals("Coupons from your insurance policies"));
        Assert.assertTrue(couponsInsuranceText.equals("Coupons from your insurance policies"));

        String investmentReturnIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_TEXT).getText();
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnIncomeText + ": " + investmentReturnIncome);
        System.out.println(investmentReturnIncomeText.equals("Investment and return from investment"));
        Assert.assertTrue(investmentReturnIncomeText.equals("Investment and return from investment"));

        String monthlyRetirementIncome = "images/Wealth_12_EN_Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_12_EN_Retirement plan recommendation");
        scenario.createNode(Given.class, "Display Retirement plan recommendation").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");

        getExtent().flush();
    }

    @Test(priority = 20, groups = "Wealth_20_EN_Wealth Dashboard - Dislplay Wealth Policy List tab", dependsOnGroups = {"Activate application"})
    public void Wealth_20_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Wealth_20_EN_Wealth Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Wealth_20_EN_Wealth Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_TAG_RETIREMENT);

        String retirementSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_TEXT).getText();
        System.out.println(retirementSavingText.equals("Retirement savings"));
        Assert.assertTrue(retirementSavingText.equals("Retirement savings"));
        String retirementSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_LABEL).getText();
        System.out.println(retirementSavingText + ": " + retirementSaving);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("Beginning of coverage"));
        Assert.assertTrue(beginOfCoverageText.equals("Beginning of coverage"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("End of coverage"));
        Assert.assertTrue(endOfCoverageText.equals("End of coverage"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Wealth_20_EN_Wealth Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_20_EN_Wealth Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer ุ
    @Test(priority = 6, groups = "Wealth_06_EN_Wealth Dashboard - Display Current Retirement Planning value", dependsOnGroups = {"Activate application"})
    public void Wealth_06_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String retirement = "images/Wealth_06_EN_Protection_Retirement.png";
        Thread.sleep(1000);
        takeScreenshot(retirement);

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
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_TEXT);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_YOURRETIREMENT_BLUECIRCLE);
        Thread.sleep(10000);
        String retirementCoverageSum = "images/Wealth_06_EN_Protection_Retirement Coverage Summary.png";
        takeScreenshot(retirementCoverageSum);
        context.getDriver().context("NATIVE_APP");
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
        System.out.println(retirementSavingSubheader.equals("Projected Retirement Savings"));
        Assert.assertTrue(retirementSavingSubheader.equals("Projected Retirement Savings"));


        String existingMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_TEXT).getText();
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println(existingMonthlyIncomeText + ": " + existingMonthlyIncome);
        System.out.println(existingMonthlyIncomeText.equals("Your existing retirement savings"));
        Assert.assertTrue(existingMonthlyIncomeText.equals("Your existing retirement savings"));

        String recommendedMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_TEXT).getText();
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println(recommendedMonthlyIncomeText + ": " + recommendedMonthlyIncome);
        System.out.println(recommendedMonthlyIncomeText.equals("Recommended retirement savings"));
        Assert.assertTrue(recommendedMonthlyIncomeText.equals("Recommended retirement savings"));

        String couponsSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_TEXT).getText();
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println(couponsSavingText + ": " + couponsSaving);
        System.out.println(couponsSavingText.equals("Coupons from your insurance policies"));
        Assert.assertTrue(couponsSavingText.equals("Coupons from your insurance policies"));

        String investmentReturnSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_TEXT).getText();
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnSavingText + ": " + investmentReturnSaving);
        System.out.println(investmentReturnSavingText.equals("Investment and return from investment"));
        Assert.assertTrue(investmentReturnSavingText.equals("Investment and return from investment"));

        String retirementSaving = "images/Wealth_06_EN_Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_06_EN_Display Retirement plan recommendation");
        scenario.createNode(Given.class, "Retirement Coverage").addScreenCaptureFromPath(retirement).pass("PASS");
        scenario.createNode(Given.class, "Retirement Coverage Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Display Current Retirement Planning value").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 14, groups = "Wealth_14_EN_Wealth Dashboard - Display Retirement plan recommendation", dependsOnGroups = {"Activate application"})
    public void Wealth_14_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_YEAR);

        String monthlyRetirementIncomeSubheaderText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_TEXT).getText();
        String monthlyRetirementIncomeSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_LABEL).getText();
        System.out.println("\n  " + monthlyRetirementIncomeSubheaderText + ": " + monthlyRetirementIncomeSubheader);
        System.out.println(monthlyRetirementIncomeSubheaderText.equals("Projected Monthly Retirement Income"));
        Assert.assertTrue(monthlyRetirementIncomeSubheaderText.equals("Projected Monthly Retirement Income"));

        String couponsInsuranceText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_TEXT).getText();
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println(couponsInsuranceText + ": " + couponsInsurance);
        System.out.println(couponsInsuranceText.equals("Coupons from your insurance policies"));
        Assert.assertTrue(couponsInsuranceText.equals("Coupons from your insurance policies"));

        String investmentReturnIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_TEXT).getText();
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnIncomeText + ": " + investmentReturnIncome);
        System.out.println(investmentReturnIncomeText.equals("Investment and return from investment"));
        Assert.assertTrue(investmentReturnIncomeText.equals("Investment and return from investment"));

        String monthlyRetirementIncome = "images/Wealth_14_EN_Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_14_EN_Retirement plan recommendation");
        scenario.createNode(Given.class, "Display Retirement plan recommendation").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");

        getExtent().flush();
    }

    @Test(priority = 22, groups = "Wealth_22_EN_Wealth Dashboard - Dislplay Wealth Policy List tab", dependsOnGroups = {"Activate application"})
    public void Wealth_22_EN() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.scrollUpToElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.getDriver().context("NATIVE_APP");
        context.scrollUp();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyTab = "images/Wealth_22_EN_Wealth Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Wealth_22_EN_Wealth Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_TAG_RETIREMENT);

        String retirementSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_TEXT).getText();
        System.out.println(retirementSavingText.equals("Retirement savings"));
        Assert.assertTrue(retirementSavingText.equals("Retirement savings"));
        String retirementSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_LABEL).getText();
        System.out.println(retirementSavingText + ": " + retirementSaving);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("Beginning of coverage"));
        Assert.assertTrue(beginOfCoverageText.equals("Beginning of coverage"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("End of coverage"));
        Assert.assertTrue(endOfCoverageText.equals("End of coverage"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Wealth_22_EN_Wealth Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_22_EN_Wealth Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }
}
