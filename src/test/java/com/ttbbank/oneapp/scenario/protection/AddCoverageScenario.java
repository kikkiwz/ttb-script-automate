package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import scala.Int;
import scala.collection.generic.BitOperations;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Set;
import java.time.Duration;

public class AddCoverageScenario extends ActivateAppScenario {

    @Test(groups = "Health Protection Add Coverage", dependsOnGroups = {"Activate application"}, priority = 1)
    public void healthAddCoverage() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        Thread.sleep(3000);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot = "images/Protection_healthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Health Protection Add Coverage");
        String screenShot2 = "images/Protection_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Health Protection Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(groups = "Retirement Add Coverage", dependsOnGroups = {"Activate application"}, priority = 2)
    public void retirementAddCoverage() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber + 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot = "images/Protection_retirementAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Retirement Add Coverage");
        String screenShot2 = "images/Protection_retirementAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        Thread.sleep(5000);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Retirement Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Retirement Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(groups = "Loss of life Add Coverage", dependsOnGroups = {"Activate application"}, priority = 3)
    public void lossOfLifeAddCoverage() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber + 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        Thread.sleep(5000);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber + 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot = "images/Protection_lossoflifeAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Loss of Life Add Coverage");
        String screenShot2 = "images/Protection_lossoflifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        Thread.sleep(5000);
        scenario.createNode(Given.class, "Loss of Life Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Loss of Life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 1, groups = "Add_Coverage_01_Health coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_01() throws Exception {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        Thread.sleep(3000);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot = "images/Add_Coverage_01_healthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_01_Health Protection Add Coverage");
        String screenShot2 = "images/Add_Coverage_01_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot3 = "images/Add_Coverage_01_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_01_Health Protection Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_01_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_01_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 9, groups = "Add_Coverage_09_Health coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_09() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_09_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_09_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_09_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_09_healthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_09_Health Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_09_Health Protection Add Coverage_Input new cancer coverage value less than current").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_09_Health Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 17, groups = "Add_Coverage_17_Health coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_17() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_17_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot2 = "images/Add_Coverage_17_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_17_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_17_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_17_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_17_Health Protection Add Coverage Medical Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_17_Health Protection Add Coverage Cancer Before Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_17_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot3).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_17_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot4).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 25, groups = "Add_Coverage_25_Wealth coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_25() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_25_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_25_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_25_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_25_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_25_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 33, groups = "Add_Coverage_33_Wealth coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_33() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_33_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_33_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_33_wealthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot2);
        scenario.createNode(Given.class, "Add_Coverage_33_Wealth Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_33_Wealth Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 41, groups = "Add_Coverage_41_Wealth coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_41() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_41_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_41_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_41_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_41_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_41_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 49, groups = "Add_Coverage_49_Life coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_49() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_49_lifeAddCoverage_anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_49_lifeAddCoverage_accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_49_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_49_lifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_49_lifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_49_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_49_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_49_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_49_Loss of life Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 57, groups = "Add_Coverage_57_Life coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_57() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_57_lifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_57_lifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);

        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_57_Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_57_lifeAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_57_Life Add Coverage_Input new anycause coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_57_Life Add Coverage_Input new accidents coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_57_Life Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 65, groups = "Add_Coverage_65_Life coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_65() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber + 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_65_LifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber + 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_65_LifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_65_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_65_LifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_65_LifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_65_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_65_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_65_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_65_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 6, groups = "Add_Coverage_06_Health coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_06() throws Exception {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        Thread.sleep(3000);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot = "images/Add_Coverage_06_healthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_06_Health Protection Add Coverage");
        String screenShot2 = "images/Add_Coverage_06_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot3 = "images/Add_Coverage_06_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_06_Health Protection Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_06_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_06_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 14, groups = "Add_Coverage_14_Health coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_14() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_14_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_14_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_14_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_14_healthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_14_Health Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_14_Health Protection Add Coverage_Input new cancer coverage value less than current").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_14_Health Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 22, groups = "Add_Coverage_22_Health coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_22() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_22_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot2 = "images/Add_Coverage_22_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_22_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_22_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_22_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_22_Health Protection Add Coverage Medical Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_22_Health Protection Add Coverage Cancer Before Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_22_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot3).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_22_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot4).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 30, groups = "Add_Coverage_30_Wealth coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_30() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_30_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_30_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_30_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_30_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_30_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 38, groups = "Add_Coverage_38_Wealth coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_38() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_38_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_38_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_38_wealthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot2);
        scenario.createNode(Given.class, "Add_Coverage_38_Wealth Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_38_Wealth Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 46, groups = "Add_Coverage_46_Wealth coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_46() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_46_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_46_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_46_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_46_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_46_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 54, groups = "Add_Coverage_54_Life coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_54() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_54_lifeAddCoverage_anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_54_lifeAddCoverage_accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_54_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_54_lifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_54_lifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_54_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_54_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_54_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_54_Loss of life Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 62, groups = "Add_Coverage_62_Life coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_62() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_62_lifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_62_lifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);

        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_62_Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_62_lifeAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_62_Life Add Coverage_Input new anycause coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_62_Life Add Coverage_Input new accidents coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_62_Life Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 70, groups = "Add_Coverage_65_Life coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_70() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber + 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_70_LifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber + 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_70_LifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_70_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_70_LifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_70_LifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_70_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_70_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_70_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_70_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 8, groups = "Add_Coverage_08_Health coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_08() throws Exception {

        TtbTestContext context = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"header-text\"]")));
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        Thread.sleep(3000);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot = "images/Add_Coverage_08_healthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_08_Health Protection Add Coverage");
        String screenShot2 = "images/Add_Coverage_08_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot3 = "images/Add_Coverage_08_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_08_Health Protection Add Coverage Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_08_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_08_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 16, groups = "Add_Coverage_16_Health coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_16() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }
        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_16_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_16_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_16_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_16_healthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_16_Health Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_16_Health Protection Add Coverage_Input new cancer coverage value less than current").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_16_Health Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 24, groups = "Add_Coverage_24_Health coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_24() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(2000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MOREDETAILS_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_PROTECTION_HEADER);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
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
                System.out.println("This webview is't to use");
            }
        }
        String existingMedicalCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_EXISTINGVALUE).getText();
        double existingMedicalCoverageNumber = Double.parseDouble(existingMedicalCoverage.replaceAll(",", ""));
        double newMedicalCoverageAmount = existingMedicalCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_MEDICAL_TEXTBOX).sendKeys(String.valueOf(newMedicalCoverageAmount),"Done");
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_24_healthAddCoverage_medical.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_CANCER_EXISTINGVALUE).click();
        String screenShot2 = "images/Add_Coverage_24_healthAddCoverage_cancer.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_24_Health Protection Add Coverage");
        String screenShot3 = "images/Add_Coverage_24_healthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_24_healthAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_24_Health Protection Add Coverage Medical Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_24_Health Protection Add Coverage Cancer Before Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_24_Health Protection Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot3).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_24_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot4).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 32, groups = "Add_Coverage_32_Wealth coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_32() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber - 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_32_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_32_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_32_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_32_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_32_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 40, groups = "Add_Coverage_40_Wealth coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_40() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingRetirementIncome = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingRetirementIncomeNumber = Double.parseDouble(existingRetirementIncome.replaceAll(",", ""));
        double newRetirementIncomeAmount = existingRetirementIncomeNumber - 1000;
        DecimalFormat formatIncome = new DecimalFormat("#");
        String tmpNewIncomeNumber = formatIncome.format(newRetirementIncomeAmount);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(tmpNewIncomeNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_40_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");
        context.hideKeyboard();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_40_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_40_wealthAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot2);
        scenario.createNode(Given.class, "Add_Coverage_40_Wealth Protection Add Coverage_Input new medical coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_40_Wealth Protection Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 48, groups = "Add_Coverage_48_Wealth coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_48() throws Exception {

        TtbTestContext context = getTtbTestContext();
        Thread.sleep(5000);
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(10000);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }

        String existingCancerCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_EXISTINGVALUE).getText();
        double existingCancerCoverageNumber = Double.parseDouble(existingCancerCoverage.replaceAll(",", ""));
        double newCancerCoverageAmount = existingCancerCoverageNumber + 1000;
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_INCOME_TEXTBOX).sendKeys(String.valueOf(newCancerCoverageAmount));
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_48_wealthAddCoverage.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_48_Wealth Add Coverage");
        String screenShot2 = "images/Add_Coverage_48_wealthAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_SELECTCOVERAGE_COMPARE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Add_Coverage_48_Wealth Can see new coverage correctly").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_48_Wealth Can click link to go to insurance store").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 56, groups = "Add_Coverage_56_Life coverage - new coverage less than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_56() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while(System.currentTimeMillis() < end_time) {
            context.back();
            try{
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            }catch (Exception e){
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_56_lifeAddCoverage_anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_56_lifeAddCoverage_accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_56_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_56_lifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_56_lifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_56_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_56_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_56_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_56_Loss of life Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 64, groups = "Add_Coverage_64_Life coverage - input new coverage value less than current coverage value", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_64() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber - 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_64_lifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber - 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_64_lifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);

        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        System.out.println("isEnable? : " + button.isEnabled());
        System.out.println("isDisplay? : " + button.isDisplayed());
        System.out.println("getText : " + button.getText());
        System.out.println("getAttribute : " + button.getAttribute("class"));
        String nextButton = button.getAttribute("class");
        System.out.println(nextButton.equalsIgnoreCase("disable"));
        Assert.assertTrue(nextButton.equalsIgnoreCase("disable"));
        System.out.println("Element is Disbaled – Assert passed");

        context.getDriver().context("NATIVE_APP");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_64_Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_64_lifeAddCoverage cannot go to next step.png";
        Thread.sleep(10000);
        takeScreenshot(screenShot3);
        scenario.createNode(Given.class, "Add_Coverage_64_Life Add Coverage_Input new anycause coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_64_Life Add Coverage_Input new accidents coverage value less than current").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_64_Life Add Coverage_Cannot go to next step").addScreenCaptureFromPath(screenShot2).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 72, groups = "Add_Coverage_72_Life coverage - new coverage more than recommended coverage", dependsOnGroups = {"Activate application"})
    public void Add_Coverage_72() throws Exception {

        TtbTestContext context = getTtbTestContext();
        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time) {
            context.back();
            try {
                context.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]"));
                break;

            } catch (Exception e) {
                System.out.println("\n" + "INFO : " + e);
            }
        }

        WebDriver contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_INSURANCE_HEADER, true);
        Thread.sleep(3000);
        Set<String> webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MOREDETAILS_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_ADDCOVERAGE_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAnycause = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_EXISTINGVALUE).getText();
        double existingLossoflifeAnycauseNumber = Double.parseDouble(existingLossoflifeAnycause.replaceAll(",", ""));
        double newLossoflifeAnycauseAmount = existingLossoflifeAnycauseNumber + 1000;
        DecimalFormat formatAnycause = new DecimalFormat("#");
        String tmpNewAnycauseNumber = formatAnycause.format(newLossoflifeAnycauseAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ANYCAUSE_TEXTBOX).sendKeys(tmpNewAnycauseNumber);
        context.hideKeyboard();
        String screenShot = "images/Add_Coverage_72_LifeAddCoverage_Anycause.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE);
                break;
            } catch (Exception e) {
                System.out.println("This webview is't to use");
            }
        }
        String existingLossoflifeAccidents = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_EXISTINGVALUE).getText();
        double existingLossoflifeAccidentsNumber = Double.parseDouble(existingLossoflifeAccidents.replaceAll(",", ""));
        double newLossoflifeAccidentsAmount = existingLossoflifeAccidentsNumber + 1000;
        DecimalFormat formatAccident = new DecimalFormat("#");
        String tmpNewAccidentNumber = formatAccident.format(newLossoflifeAccidentsAmount);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_ACCIDENTS_TEXTBOX).sendKeys(tmpNewAccidentNumber);
        context.hideKeyboard();
        String screenShot2 = "images/Add_Coverage_72_LifeAddCoverage_Accidents.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot2);
        WebElement tmpButton = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON);
        String nextButton = tmpButton.getAttribute("class");
        System.out.println(nextButton.equals("orange"));
        Assert.assertTrue(nextButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_NEXT_BUTTON).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Add_Coverage_72_Loss of Life Add Coverage");
        String screenShot3 = "images/Add_Coverage_72_LifeAddCoverage confirmed.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot3);
        WebElement button = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON);
        String compareButton = button.getAttribute("class");
        System.out.println(compareButton.equals("orange"));
        Assert.assertTrue(compareButton.equals("orange"));
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SELECTCOVERAGE_COMPARE_BUTTON).click();
        String screenShot4 = "images/Add_Coverage_72_LifeAddCoverage Click link to go to insurance store.png";
        Thread.sleep(5000);
        takeScreenshot(screenShot4);
        context.getDriver().context("NATIVE_APP");
        scenario.createNode(Given.class, "Add_Coverage_72_Loss of life Add Coverage Anycause Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_72_Loss of life Add Coverage Accidents Before Confirmed").addScreenCaptureFromPath(screenShot).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_72_Loss of life Add Coverage After Confirmed").addScreenCaptureFromPath(screenShot2).pass("PASS");
        scenario.createNode(Given.class, "Add_Coverage_72_Can click link to go to insurance store").addScreenCaptureFromPath(screenShot3).pass("PASS");
        getExtent().flush();
    }
}
