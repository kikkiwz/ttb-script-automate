package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class PolicyDetailsScenario extends ActivateAppScenario {

    //Customer 4
    @Test(priority = 4, groups = "Policy_Details_04_EN_Health product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_04_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        String healthProtection = "images/Policy_Details_04_EN_Health Protection.png";
        Thread.sleep(1000);
        takeScreenshot(healthProtection);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_04_EN_Policies with Life product");
        scenario.createNode(Given.class, "Policy_Details_04_EN_Life product").addScreenCaptureFromPath(healthProtection).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String healthProtectionMyPolicies = "images/Policy_Details_04_EN_Health Protection My Policies_" + tmp + ".png";
        String healthProtectionPolicyDetails = "images/Policy_Details_04_EN_Health Protection Policy Details_" + tmp + ".png";
        String healthPolicyDetailsInsurance = "images/Policy_Details_04_EN_Loss of Life Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String healthMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + healthMyPoliciesSubheader);
        Thread.sleep(1000);

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String coverage = context.getDriver().findElement(By.xpath("//*[@id='premium-paid-amount-" + i + "']")).getText();
        System.out.println("Coverage: " + coverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);
        takeScreenshot(healthProtectionMyPolicies);
        context.getDriver().findElement(By.xpath("//div[@id='goto-policy-detail-" + i + "']")).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(healthProtectionPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(healthPolicyDetailsInsurance);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        scenario.createNode(Given.class, "Policy_Details_04_EN_Health Protection My Policies " + tmp + "").addScreenCaptureFromPath(healthProtectionMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_04_EN_Health Protection My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(healthProtectionPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_04_EN_Loss of Life My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(healthPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 11, groups = "Policy_Details_11_EN_Health product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_11_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        String healthProtection = "images/Policy_Details_11_EN_Health Protection.png";
        Thread.sleep(1000);
        takeScreenshot(healthProtection);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_11_EN_Policies Health Protection");
        scenario.createNode(Given.class, "Policy_Details_11_EN_Health Protection").addScreenCaptureFromPath(healthProtection).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp=i+1;
        String healthProtectionMyPolicies = "images/Policy_Details_11_EN_Health Protection My Policies_" + tmp + ".png";
        String healthProtectionPolicyDetails = "images/Policy_Details_11_EN_Health Protection Policy Details_" + tmp + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String healthMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + healthMyPoliciesSubheader);
        Thread.sleep(1000);

        String coverage = context.getDriver().findElement(By.xpath("//*[@id='premium-paid-amount-" + i + "']")).getText();
        System.out.println("Coverage: " + coverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);
        takeScreenshot(healthProtectionMyPolicies);
        context.getDriver().findElement(By.xpath("//div[@id='goto-policy-detail-" + i + "']")).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(healthProtectionPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        scenario.createNode(Given.class, "Policy_Details_11_EN_Health Protection My Policies " + tmp + "").addScreenCaptureFromPath(healthProtectionMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_11_EN_Health Protection My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(healthProtectionPolicyDetails).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 18, groups = "Policy_Details_18_EN_Wealth product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_18_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String retirement = "images/Policy_Details_18_EN_Retirement.png";
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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_18_EN_Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Policy_Details_18_EN_Retirement").addScreenCaptureFromPath(retirement).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String retirementMyPolicies = "images/Policy_Details_18_EN_Retirement My Policies_"+ tmp +".png";
        String retirementPolicyDetails = "images/Policy_Details_18_EN_Retirement Policy Details_"+ tmp +".png";
        String retirementPolicyDetailsInsurance = "images/Policy_Details_18_EN_Retirement Policy Details_Pay Insurance Premium_"+ tmp +".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String retirementMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + retirementMyPoliciesSubheader);
        Thread.sleep(1000);

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
        System.out.println("Retirement savings: " + saving);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
        System.out.println(seeMorePolicy);

        takeScreenshot(retirementMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(retirementPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(retirementPolicyDetailsInsurance);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Policy_Details_18_EN_Retirement My Policies " + tmp + "").addScreenCaptureFromPath(retirementMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_18_EN_Retirement My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_18_EN_Retirement My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 25, groups = "Policy_Details_25_EN_Wealth product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_25_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String retirement = "images/Policy_Details_25_EN_Retirement.png";
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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_25_EN_Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Policy_Details_25_EN_Retirement").addScreenCaptureFromPath(retirement).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String retirementMyPolicies = "images/Policy_Details_25_EN_Retirement My Policies_"+ tmp +".png";
        String retirementPolicyDetails = "images/Policy_Details_25_EN_Retirement Policy Details_"+ tmp +".png";
        String retirementPolicyDetailsInsurance = "images/Policy_Details_25_EN_Retirement Policy Details_Pay Insurance Premium_"+ tmp +".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String retirementMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + retirementMyPoliciesSubheader);
        Thread.sleep(1000);

        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
        System.out.println("Retirement savings: " + saving);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
        System.out.println(seeMorePolicy);

        takeScreenshot(retirementMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(retirementPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Policy_Details_25_EN_Retirement My Policies " + tmp + "").addScreenCaptureFromPath(retirementMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_25_EN_Retirement My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_25_EN_Retirement My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 32, groups = "Policy_Details_32_EN_Life product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_32_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_32_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with Life product");
        scenario.createNode(Given.class, "Protection_Life").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 4;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_32_EN_Loss of Life My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_32_EN_Loss of Life Policy Details_" + tmp + ".png";
        String lossOfLifePolicyDetailsInsurance = "images/Policy_Details_32_EN_Loss of Life Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");// 0932154377
            }
        }
        Thread.sleep(5000);
        takeScreenshot(lossOfLifePolicyDetailsInsurance);

        scenario.createNode(Given.class, "Policy_Details_32_Loss of Life My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_32_Loss of Life My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_32_Loss of Life My Policies_Pay Insurance Premium " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetailsInsurance).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 39, groups = "Policy_Details_39_EN_Life product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_39_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_39_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with Life product");
        scenario.createNode(Given.class, "Protection_Life").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 0;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_39_EN_Loss of Life My Policies_" + i + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_39_EN_Loss of Life Policy Details_" + i + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);

        scenario.createNode(Given.class, "Policy_Details_39_Loss of Life My Policies " + tmp + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_39_Loss of Life My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 46, groups = "Policy_Details_46_EN_UL product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_46_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_46_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with UL product");
        scenario.createNode(Given.class, "Protection_UL").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 9;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_46_EN_UL product My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_46_EN_UL product Policy Details_" + tmp + ".png";
        String lossOfLifePolicyDetailsInsurance = "images/Policy_Details_46_EN_UL product Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(lossOfLifePolicyDetailsInsurance);

        scenario.createNode(Given.class, "Protection_UL product My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Protection_UL product My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Protection_UL product My Policies_Pay Insurance Premium " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetailsInsurance).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 53, groups = "Policy_Details_53_EN_UL product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_53_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_53_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with UL product");
        scenario.createNode(Given.class, "Protection_UL").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 9;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_53_EN_UL product My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_53_EN_UL product Policy Details_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);

        scenario.createNode(Given.class, "Protection_UL product My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Protection_UL product My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }


    //Customer 6
    @Test(priority = 6, groups = "Policy_Details_06_EN_Health product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_06_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        String healthProtection = "images/Policy_Details_06_EN_Health Protection.png";
        Thread.sleep(1000);
        takeScreenshot(healthProtection);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_06_EN_Policies with Life product");
        scenario.createNode(Given.class, "Policy_Details_06_EN_Life product").addScreenCaptureFromPath(healthProtection).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String healthProtectionMyPolicies = "images/Policy_Details_06_EN_Health Protection My Policies_" + tmp + ".png";
        String healthProtectionPolicyDetails = "images/Policy_Details_06_EN_Health Protection Policy Details_" + tmp + ".png";
        String healthPolicyDetailsInsurance = "images/Policy_Details_06_EN_Loss of Life Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String healthMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + healthMyPoliciesSubheader);
        Thread.sleep(1000);

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String coverage = context.getDriver().findElement(By.xpath("//*[@id='premium-paid-amount-" + i + "']")).getText();
        System.out.println("Coverage: " + coverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);
        takeScreenshot(healthProtectionMyPolicies);
        context.getDriver().findElement(By.xpath("//div[@id='goto-policy-detail-" + i + "']")).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(healthProtectionPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(healthPolicyDetailsInsurance);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        scenario.createNode(Given.class, "Policy_Details_06_EN_Health Protection My Policies " + tmp + "").addScreenCaptureFromPath(healthProtectionMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_06_EN_Health Protection My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(healthProtectionPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_06_EN_Loss of Life My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(healthPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();

    }

    @Test(priority = 13, groups = "Policy_Details_13_EN_Health product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_13_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_HEALTH_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        String healthProtection = "images/Policy_Details_13_EN_Health Protection.png";
        Thread.sleep(1000);
        takeScreenshot(healthProtection);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_13_EN_Policies Health Protection");
        scenario.createNode(Given.class, "Policy_Details_13_EN_Health Protection").addScreenCaptureFromPath(healthProtection).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp=i+1;
        String healthProtectionMyPolicies = "images/Policy_Details_13_EN_Health Protection My Policies_" + tmp + ".png";
        String healthProtectionPolicyDetails = "images/Policy_Details_13_EN_Health Protection Policy Details_" + tmp + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String healthMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + healthMyPoliciesSubheader);
        Thread.sleep(1000);

        String coverage = context.getDriver().findElement(By.xpath("//*[@id='premium-paid-amount-" + i + "']")).getText();
        System.out.println("Coverage: " + coverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);
        takeScreenshot(healthProtectionMyPolicies);
        context.getDriver().findElement(By.xpath("//div[@id='goto-policy-detail-" + i + "']")).click();

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(healthProtectionPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();

        scenario.createNode(Given.class, "Policy_Details_13_EN_Health Protection My Policies " + tmp + "").addScreenCaptureFromPath(healthProtectionMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_13_EN_Health Protection My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(healthProtectionPolicyDetails).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 20, groups = "Policy_Details_20_EN_Wealth product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_20_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        String retirement = "images/Policy_Details_20_EN_Retirement.png";
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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_20_EN_Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Policy_Details_20_EN_Retirement").addScreenCaptureFromPath(retirement).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String retirementMyPolicies = "images/Policy_Details_20_EN_Retirement My Policies_"+ tmp +".png";
        String retirementPolicyDetails = "images/Policy_Details_20_EN_Retirement Policy Details_"+ tmp +".png";
        String retirementPolicyDetailsInsurance = "images/Policy_Details_20_EN_Retirement Policy Details_Pay Insurance Premium_"+ tmp +".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String retirementMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + retirementMyPoliciesSubheader);
        Thread.sleep(1000);

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
        System.out.println("Retirement savings: " + saving);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
        System.out.println(seeMorePolicy);

        takeScreenshot(retirementMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(retirementPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(retirementPolicyDetailsInsurance);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Policy_Details_20_EN_Retirement My Policies " + tmp + "").addScreenCaptureFromPath(retirementMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_20_EN_Retirement My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_20_EN_Retirement My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 27, groups = "Policy_Details_27_EN_Wealth product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_27_EN() throws InterruptedException, IOException {

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
        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_RETIREMENT_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String retirement = "images/Policy_Details_27_EN_Retirement.png";
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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB);
        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_TAB).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_27_EN_Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Policy_Details_27_EN_Retirement").addScreenCaptureFromPath(retirement).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        int i = 0;
        System.out.println("Policy Sequence: " + i);
        int tmp = i+1;
        String retirementMyPolicies = "images/Policy_Details_27_EN_Retirement My Policies_"+ tmp +".png";
        String retirementPolicyDetails = "images/Policy_Details_27_EN_Retirement Policy Details_"+ tmp +".png";
        String retirementPolicyDetailsInsurance = "images/Policy_Details_27_EN_Retirement Policy Details_Pay Insurance Premium_"+ tmp +".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String retirementMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + retirementMyPoliciesSubheader);
        Thread.sleep(1000);

        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
        System.out.println("Retirement savings: " + saving);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
        System.out.println(seeMorePolicy);

        takeScreenshot(retirementMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNumber = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNumber);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(retirementPolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT);

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");

        scenario.createNode(Given.class, "Policy_Details_27_EN_Retirement My Policies " + tmp + "").addScreenCaptureFromPath(retirementMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_27_EN_Retirement My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_27_EN_Retirement My Policies_Pay Insurance Premium " + tmp + "").addScreenCaptureFromPath(retirementPolicyDetailsInsurance).pass("PASS");
        getExtent().flush();
    }

    @Test(priority = 34, groups = "Policy_Details_34_EN_Life product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_34_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_34_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with Life product");
        scenario.createNode(Given.class, "Protection_Life").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 4;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_34_EN_Loss of Life My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_34_EN_Loss of Life Policy Details_" + tmp + ".png";
        String lossOfLifePolicyDetailsInsurance = "images/Policy_Details_34_EN_Loss of Life Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(lossOfLifePolicyDetailsInsurance);

        scenario.createNode(Given.class, "Policy_Details_34_EN_Loss of Life My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_34_EN_Loss of Life My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_34_EN_Loss of Life My Policies_Pay Insurance Premium " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetailsInsurance).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 41, groups = "Policy_Details_41_EN_Life product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_41_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_41_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policy_Details_41_Policies with Life product");
        scenario.createNode(Given.class, "Policy_Details_41_Life").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 0;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_41_EN_Loss of Life My Policies_" + i + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_41_EN_Loss of Life Policy Details_" + i + ".png";

        context.isElementPresent("//div[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);

        scenario.createNode(Given.class, "Policy_Details_41_Loss of Life My Policies " + tmp + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_41_Loss of Life My Policies_Policy Details " + tmp + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 48, groups = "Policy_Details_48_EN_UL product and renewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_48_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_48_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with UL product");
        scenario.createNode(Given.class, "Protection_UL").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 9;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_48_EN_UL product My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_48_EN_UL product Policy Details_" + tmp + ".png";
        String lossOfLifePolicyDetailsInsurance = "images/Policy_Details_48_EN_UL product Policy Details_Pay Insurance Premium_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String renewCard = context.getDriver().findElement(By.xpath("//*[@id='tag-payment-due-"+i+"']")).getText();
        System.out.println("Renew Card: " + renewCard);
        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
//        String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-" + i + "']")).getText();
//        System.out.println("Loss of life coverage: " + saving);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYMENT_DUE);

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT).click();
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PAYPREMIUMDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        Thread.sleep(5000);
        takeScreenshot(lossOfLifePolicyDetailsInsurance);

        scenario.createNode(Given.class, "Policy_Details_48_UL product My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_48_UL product My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_48_UL product My Policies_Pay Insurance Premium " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetailsInsurance).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

    @Test(priority = 55, groups = "Policy_Details_55_EN_UL product and unrenewable", dependsOnGroups = {"Activate application"})
    public void Policy_Details_55_EN() throws InterruptedException, IOException {

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

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_SEEMOREDETAILS_BUTTON);
        context.getDriver().context("NATIVE_APP");
        context.scrollDown();
        context.scrollDown();
        String lossOfLife = "images/Policy_Details_55_EN_Loss of Life.png";
        Thread.sleep(1000);
        takeScreenshot(lossOfLife);

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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        Thread.sleep(3000);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with UL product");
        scenario.createNode(Given.class, "Protection_UL").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        int i = 9;
        System.out.println("Policy Sequence: " + i);

        int tmp=i+1;
        String lossOfLifeMyPolicies = "images/Policy_Details_55_EN_UL product My Policies_" + tmp + ".png";
        String lossOfLifePolicyDetails = "images/Policy_Details_55_EN_UL product Policy Details_" + tmp + ".png";

        context.isElementPresent("//*[@id='product-name-" + i + "']");
        String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
        System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
        System.out.println("//*[@id=" + '"' +"product-name-" + i + '"' +"]" );
        System.out.println(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_SEQUENCE );
        Thread.sleep(1000);
        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        String policyName = context.getDriver().findElement(By.xpath("//*[@id='product-name-" + i + "']")).getText();
        System.out.println("\n  " + policyName);
        String policyNumber = context.getDriver().findElement(By.xpath("//*[@id='policy-number-" + i + "']")).getText();
        System.out.println("Policy Number: " + policyNumber);
        String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//*[@id='accidental-death-coverage-" + i + "']")).getText();
        System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
        String beginningOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-start-date-" + i + "']")).getText();
        System.out.println("Beginning of coverage: " + beginningOfCoverage);
        String endOfCoverage = context.getDriver().findElement(By.xpath("//*[@id='protection-end-date-" + i + "']")).getText();
        System.out.println("End of coverage: " + endOfCoverage);

        String seeMorePolicy = "//*[@id='goto-policy-detail-" + i + "']";
        System.out.println(seeMorePolicy);

        Thread.sleep(3000);
        takeScreenshot(lossOfLifeMyPolicies);
        context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
        System.out.println("click");

        context.getDriver().context("NATIVE_APP");
        Thread.sleep(3000);
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICY_HEADER);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }

        System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_LABEL).getText());
        String policyNo = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_POLICYNUMBER_LABEL).getText();
        System.out.println("Policy number: " + policyNo);
        String policydetailsBeginningOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BEGINNINGOFCOVERAGE_LABEL).getText();
        System.out.println("Beginning of coverage: " + policydetailsBeginningOfCoverage);
        String policydetailsEndOfCoverage = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_ENDOFCOVERAGE_LABEL).getText();
        System.out.println("End of coverage: " + policydetailsEndOfCoverage);
        String policydetailsStatus = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_LABEL).getText();
        System.out.println("Status: " + policydetailsStatus);
        takeScreenshot(lossOfLifePolicyDetails);

        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_STATUS_BILLPAYMENT_DISABLE);

        scenario.createNode(Given.class, "Policy_Details_55_UL product My Policies " + i + "").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
        scenario.createNode(Given.class, "Policy_Details_55_UL product My Policies_Policy Details " + i + "").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");

        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }

}
