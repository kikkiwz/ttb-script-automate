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

public class WealthDashboardTHScenario extends ActivateAppTHScenario {

    //Customer 4
    @Test(priority = 4, groups = "Wealth_04_TH_Wealth Dashboard - Display Current Retirement Planning value", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_04_TH() throws InterruptedException, IOException {

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
        String retirement = "images/Wealth_04_TH_Protection_Retirement.png";
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
        String retirementCoverageSum = "images/Wealth_04_TH_Protection_Retirement Coverage Summary.png";
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
        System.out.println(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));


        String existingMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_TEXT).getText();
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println(existingMonthlyIncomeText + ": " + existingMonthlyIncome);
        System.out.println(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));
        Assert.assertTrue(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));

        String recommendedMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_TEXT).getText();
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println(recommendedMonthlyIncomeText + ": " + recommendedMonthlyIncome);
        System.out.println(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));
        Assert.assertTrue(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));

        String couponsSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_TEXT).getText();
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println(couponsSavingText + ": " + couponsSaving);
        System.out.println(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_TEXT).getText();
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnSavingText + ": " + investmentReturnSaving);
        System.out.println(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));

        String retirementSaving = "images/Wealth_04_TH_Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_04_TH_Display Retirement plan recommendation");
        scenario.createNode(Given.class, "Retirement Coverage").addScreenCaptureFromPath(retirement).pass("PASS");
        scenario.createNode(Given.class, "Retirement Coverage Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Display Current Retirement Planning value").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 12, groups = "Wealth_12_TH_Wealth Dashboard - Display Retirement plan recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_12_TH() throws InterruptedException, IOException {

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
        System.out.println(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));
        Assert.assertTrue(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));

        String couponsInsuranceText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_TEXT).getText();
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println(couponsInsuranceText + ": " + couponsInsurance);
        System.out.println(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_TEXT).getText();
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnIncomeText + ": " + investmentReturnIncome);
        System.out.println(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));

        String monthlyRetirementIncome = "images/Wealth_12_TH_Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_12_TH_Retirement plan recommendation");
        scenario.createNode(Given.class, "Display Retirement plan recommendation").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Wealth_20_TH_Wealth Dashboard - Dislplay Wealth Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_20_TH() throws InterruptedException, IOException {

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

        String policyTab = "images/Wealth_20_TH_Wealth Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Wealth_20_TH_Wealth Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_TAG_RETIREMENT);

        String retirementSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_TEXT).getText();
        System.out.println(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        String retirementSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_LABEL).getText();
        System.out.println(retirementSavingText + ": " + retirementSaving);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Wealth_20_TH_Wealth Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_20_TH_Wealth Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 5
    @Test(priority = 5, groups = "Wealth_05_TH_Wealth Dashboard - Display Current Retirement Planning value", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_05_TH() throws InterruptedException, IOException {

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
        String retirement = "images/Wealth_05_TH_Protection_Retirement.png";
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
        String retirementCoverageSum = "images/Wealth_05_TH_Protection_Retirement Coverage Summary.png";
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
        System.out.println(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));


        String existingMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_TEXT).getText();
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println(existingMonthlyIncomeText + ": " + existingMonthlyIncome);
        System.out.println(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));
        Assert.assertTrue(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));

        String recommendedMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_TEXT).getText();
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println(recommendedMonthlyIncomeText + ": " + recommendedMonthlyIncome);
        System.out.println(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));
        Assert.assertTrue(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));

        String couponsSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_TEXT).getText();
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println(couponsSavingText + ": " + couponsSaving);
        System.out.println(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_TEXT).getText();
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnSavingText + ": " + investmentReturnSaving);
        System.out.println(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));

        String retirementSaving = "images/Wealth_05_TH_Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_05_TH_Display Retirement plan recommendation");
        scenario.createNode(Given.class, "Retirement Coverage").addScreenCaptureFromPath(retirement).pass("PASS");
        scenario.createNode(Given.class, "Retirement Coverage Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Display Current Retirement Planning value").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 13, groups = "Wealth_13_TH_Wealth Dashboard - Display Retirement plan re commendation", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_13_TH() throws InterruptedException, IOException {

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
        System.out.println(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));
        Assert.assertTrue(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));

        String couponsInsuranceText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_TEXT).getText();
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println(couponsInsuranceText + ": " + couponsInsurance);
        System.out.println(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_TEXT).getText();
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnIncomeText + ": " + investmentReturnIncome);
        System.out.println(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));

        String monthlyRetirementIncome = "images/Wealth_13_TH_Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_13_TH_Retirement plan recommendation");
        scenario.createNode(Given.class, "Display Retirement plan recommendation").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 21, groups = "Wealth_21_TH_Wealth Dashboard - Dislplay Wealth Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_21_TH() throws InterruptedException, IOException {

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

        String policyTab = "images/Wealth_21_TH_Wealth Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Wealth_21_TH_Wealth Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_TAG_RETIREMENT);

        String retirementSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_TEXT).getText();
        System.out.println(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        String retirementSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_LABEL).getText();
        System.out.println(retirementSavingText + ": " + retirementSaving);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Wealth_21_TH_Wealth Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_21_TH_Wealth Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }

    //Customer 6
    @Test(priority = 6, groups = "Wealth_06_TH_Wealth Dashboard - Display Current Retirement Planning value", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_06_TH() throws InterruptedException, IOException {

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
        String retirement = "images/Wealth_06_TH_Protection_Retirement.png";
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
        String retirementCoverageSum = "images/Wealth_06_TH_Protection_Retirement Coverage Summary.png";
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
        System.out.println(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingSubheader.equals("คาดการณ์เงินใช้หลังเกษียณ"));


        String existingMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_TEXT).getText();
        String existingMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_EXISTINGCOVERAGE_SAVING_LABEL).getText();
        System.out.println(existingMonthlyIncomeText + ": " + existingMonthlyIncome);
        System.out.println(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));
        Assert.assertTrue(existingMonthlyIncomeText.equals("เงินรายเดือนที่ได้"));

        String recommendedMonthlyIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_TEXT).getText();
        String recommendedMonthlyIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_RECOMMENDEDCOVERAGE_SAVING_LABEL).getText();
        System.out.println(recommendedMonthlyIncomeText + ": " + recommendedMonthlyIncome);
        System.out.println(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));
        Assert.assertTrue(recommendedMonthlyIncomeText.equals("เงินรายเดือนที่แนะนำ"));

        String couponsSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_TEXT).getText();
        String couponsSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_COUPONS_LABEL).getText();
        System.out.println(couponsSavingText + ": " + couponsSaving);
        System.out.println(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsSavingText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_TEXT).getText();
        String investmentReturnSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_SAVING_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnSavingText + ": " + investmentReturnSaving);
        System.out.println(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnSavingText.equals("เงินลงทุนและผลตอบแทน"));

        String retirementSaving = "images/Wealth_06_TH_Protection_Projected Retirement Savings.png";
        takeScreenshot(retirementSaving);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_06_TH_Display Retirement plan recommendation");
        scenario.createNode(Given.class, "Retirement Coverage").addScreenCaptureFromPath(retirement).pass("PASS");
        scenario.createNode(Given.class, "Retirement Coverage Summary").addScreenCaptureFromPath(retirementCoverageSum).pass("PASS");
        scenario.createNode(Given.class, "Display Current Retirement Planning value").addScreenCaptureFromPath(retirementSaving).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 14, groups = "Wealth_14_TH_Wealth Dashboard - Display Retirement plan recommendation", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_14_TH() throws InterruptedException, IOException {

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
        System.out.println(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));
        Assert.assertTrue(monthlyRetirementIncomeSubheaderText.equals("คาดการณ์เงินรายเดือน"));

        String couponsInsuranceText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_TEXT).getText();
        String couponsInsurance = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_COUPONS_LABEL).getText();
        System.out.println(couponsInsuranceText + ": " + couponsInsurance);
        System.out.println(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));
        Assert.assertTrue(couponsInsuranceText.equals("เงินคืนจากกรมธรรม์"));

        String investmentReturnIncomeText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_TEXT).getText();
        String investmentReturnIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_COVERAGESUMARY_MONTHLYINCOME_INVESTMENT_LABEL).getText();
        System.out.println(investmentReturnIncomeText + ": " + investmentReturnIncome);
        System.out.println(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));
        Assert.assertTrue(investmentReturnIncomeText.equals("เงินลงทุนและผลตอบแทน"));

        String monthlyRetirementIncome = "images/Wealth_06_TH_Protection_Projected Monthly Retirement Income.png";
        takeScreenshot(monthlyRetirementIncome);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_06_TH_Retirement plan recommendation");
        scenario.createNode(Given.class, "Display Retirement plan recommendation").addScreenCaptureFromPath(monthlyRetirementIncome).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Wealth_22_TH_Wealth Dashboard - Dislplay Wealth Policy List tab", dependsOnGroups = {"Activate application with change language"})
    public void Wealth_22_TH() throws InterruptedException, IOException {

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

        String policyTab = "images/Wealth_06_TH_Wealth Policy tab.png";
        takeScreenshot(policyTab);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();
        Thread.sleep(1000);
        String policyCard = "images/Wealth_06_TH_Wealth Policy List.png";
        takeScreenshot(policyCard);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_TAG_RETIREMENT);

        String retirementSavingText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_TEXT).getText();
        System.out.println(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        Assert.assertTrue(retirementSavingText.equals("เงินใช้หลังเกษียณ"));
        String retirementSaving = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_RETIREMENT_SAVING_LABEL).getText();
        System.out.println(retirementSavingText + ": " + retirementSaving);

        String beginOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_TEXT).getText();
        System.out.println(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        Assert.assertTrue(beginOfCoverageText.equals("วันเริ่มต้นความคุ้มครอง"));
        String beginOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println(beginOfCoverageText + ": " + beginOfCoverage);

        String endOfCoverageText = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_TEXT).getText();
        System.out.println(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        Assert.assertTrue(endOfCoverageText.equals("วันสิ้นสุดความคุ้มครอง"));
        String endOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println(endOfCoverageText + ": " + endOfCoverage);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_SEEPOLICYDETAILS_BUTTON).click();
        Thread.sleep(3000);
        String seePolicyDetails = "images/Wealth_06_TH_Wealth Policy Detail screen.png";
        takeScreenshot(seePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Wealth_06_TH_Wealth Policy List tab");
        scenario.createNode(Given.class, "Dislplay Health Policy tab").addScreenCaptureFromPath(policyTab).pass("PASS");
        scenario.createNode(Given.class, "Dislplay Health Policy List tab").addScreenCaptureFromPath(policyCard).pass("PASS");
        scenario.createNode(Given.class, "Can click link to Policy Detail screen").addScreenCaptureFromPath(seePolicyDetails).pass("PASS");
        getExtent().flush();
    }
}
