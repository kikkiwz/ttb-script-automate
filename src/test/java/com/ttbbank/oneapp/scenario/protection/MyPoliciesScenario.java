package com.ttbbank.oneapp.scenario.protection;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.FindBy;
import com.ttbbank.oneapp.framework.OneAppElement;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class MyPoliciesScenario<i> extends ActivateAppScenario {


    @Test(groups = "Health Protection My Policies", dependsOnGroups = {"Activate application"}, priority = 1)
    public void healthMyPolicies() throws InterruptedException, IOException {
        int i=0;
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
        String healthProtection = "images/Protection_Health Protection.png";
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies with Health Protection");
        scenario.createNode(Given.class, "Protection_Health Protection").addScreenCaptureFromPath(healthProtection).pass("PASS");

        while(true) {
            try{
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

                Boolean isHavePolicy = context.isElementPresent("//div[@id='product-name-"+i+"']");
                Boolean isNotHavePolicy  = context.isElementPresent("//div[@id='empty-state-not-covered']");
                System.out.println("Is it have Health Coverage? : " + isHavePolicy);
                System.out.println("Policy Sequence: " + i);
                String healthProtectionMyPolicies = "images/Protection_Health Protection My Policies_"+i+".png";
                String healthProtectionPolicyDetails = "images/Protection_Health Protection Policy Details_"+i+".png";
                String healthProtectionPolicyDetailsInsurance = "images/Protection_Health Protection Policy Details_Insurance company_"+i+".png";
                String healthProtectionPolicyDetailsProtection = "images/Protection_Health Protection Policy Details_Protection information_"+i+".png";
                String healthProtectionPolicyDetailsPremium = "images/Protection_Health Protection Policy Details_Premium payment details_"+i+".png";

                if(isNotHavePolicy == true){
                    context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                    context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_EMPTYCOVERAGE);
                    Thread.sleep(1000);
                    takeScreenshot(healthProtectionMyPolicies);
                    break;
                }
                else if(isHavePolicy == true){
                    while(true){
                        Thread.sleep(1000);
                        if(context.isElementPresent("//div[@id='product-name-"+i+"']")){
                            if(i==1 || i==2){
                                context.scrollDown();
                            }
                            else if(i>2){
                                context.scrollDown();
                                context.scrollDown();
                                context.scrollDown();
                            }
                            break;
                        }
                        else{
                            context.scrollDown();
                        }
                    }

                    String healthMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_SUBHEADER).getText();
                    System.out.println("\n  " + healthMyPoliciesSubheader);
                    Thread.sleep(1000);

                    System.out.println("Add name + policy no here");
                    String coverage = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
                    System.out.println("Coverage: " + coverage);
                    String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
                    System.out.println("Beginning of coverage: " + beginningOfCoverage);
                    String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
                    System.out.println("End of coverage: " + endOfCoverage);
                    takeScreenshot(healthProtectionMyPolicies);
                    context.getDriver().findElement(By.xpath("//div[@id='goto-policy-detail-"+i+"']")).click();

                    String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
                    System.out.println(seeMorePolicy);

                    context.getDriver().context("NATIVE_APP");
                    Thread.sleep(3000);
                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_LABEL);
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

                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).click();
                    String INSURANCEDETAILS_COMPANYNAME = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_COMPANYNAME_LABEL).getText();
                    System.out.println("Company name: " + INSURANCEDETAILS_COMPANYNAME);
                    String INSURANCEDETAILS_PHONENUMBER = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_PHONENUMBER_LABEL).getText();
                    System.out.println("Phone number: " + INSURANCEDETAILS_PHONENUMBER);

                    context.getDriver().context("NATIVE_APP");
                    Thread.sleep(3000);
                    takeScreenshot(healthProtectionPolicyDetailsInsurance);
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).click();
                    String INSURANCEDETAILS_MEDICAL = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_MEDICAL_LABEL).getText();
                    System.out.println("Medical treatment limit: " + INSURANCEDETAILS_MEDICAL);
                    String PROTECTIONDETAILS_ROOM = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_ROOM_LABEL).getText();
                    System.out.println("Room expense (per day): " + PROTECTIONDETAILS_ROOM);
                    String PROTECTIONDETAILS_ICUROOM = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_ICUROOM_LABEL).getText();
                    System.out.println("ICU room expense (per day): " + PROTECTIONDETAILS_ICUROOM);
                    String PROTECTIONDETAILS_OUTPATIENT = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_OUTPATIENT_LABEL).getText();
                    System.out.println("Outpatient (per incident): " + PROTECTIONDETAILS_OUTPATIENT);
                    String PROTECTIONDETAILS_INCOME = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_INCOME_LABEL).getText();
                    System.out.println("Income replacement: " + PROTECTIONDETAILS_INCOME);
                    String INSURANCEDETAILS_CANCERCI = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_CANCERCI_LABEL).getText();
                    System.out.println("Cancer And Critical Illness: " + INSURANCEDETAILS_CANCERCI);

                    context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).click();
                    Thread.sleep(3000);
                    takeScreenshot(healthProtectionPolicyDetailsProtection);
                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).getText());
                    String PREMIUMPAYMENT_POLICYYEAR = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_POLICYYEAR_LABEL).getText();
                    System.out.println("Policy year: " + PREMIUMPAYMENT_POLICYYEAR);
//                    String PREMIUMPAYMENT_PREMIUM = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PREMIUM_LABEL).getText();
//                    System.out.println("Premium: " + PREMIUMPAYMENT_PREMIUM);
//                    String PREMIUMPAYMENT_LASTPAYMENTDATE = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_LASTPAYMENTDATE_LABEL).getText();
//                    System.out.println("Last payment date: " + PREMIUMPAYMENT_LASTPAYMENTDATE);
                    String PREMIUMPAYMENT_PAYMENTTERM = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTTERM_LABEL).getText();
                    System.out.println("Payment term: " + PREMIUMPAYMENT_PAYMENTTERM);
                    String PREMIUMPAYMENT_PAYMENTMETHOD = context.findElement(OneAppElementKeys.PROTECTION_HEALTH_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTMETHOD_LABEL).getText();
                    System.out.println("Payment method: " + PREMIUMPAYMENT_PAYMENTMETHOD);
                    takeScreenshot(healthProtectionPolicyDetailsPremium);
                    System.out.println("\n");
                    context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
                }
                else{
                    break;
                }

                i++;
                context.getDriver().context("NATIVE_APP");
                context.scrollDown();

                scenario.createNode(Given.class, "Protection_Health Protection My Policies"+i+"").addScreenCaptureFromPath(healthProtectionMyPolicies).pass("PASS");
                scenario.createNode(Given.class, "Protection_Health Protection My Policies_Policy Details"+i+"").addScreenCaptureFromPath(healthProtectionPolicyDetails).pass("PASS");
                scenario.createNode(Given.class, "Protection_Health Protection My Policies_Policy Details_Insurance company"+i+"").addScreenCaptureFromPath(healthProtectionPolicyDetailsInsurance).pass("PASS");
                scenario.createNode(Given.class, "Protection_Health Protection My Policies_Policy Details_Protection information"+i+"").addScreenCaptureFromPath(healthProtectionPolicyDetailsProtection).pass("PASS");
                scenario.createNode(Given.class, "Protection_Health Protection My Policies_Policy Details_Premium payment details"+i+"").addScreenCaptureFromPath(healthProtectionPolicyDetailsPremium).pass("PASS");

            }catch (Exception e){
                System.err.println("\n" + "INFO : " + e);
                break;

            }
        }
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_BACK_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_BACK_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }


    @Test(groups = "Retirement My Policies", dependsOnGroups = {"Activate application"}, priority = 2)
    public void retirementMyPolicies() throws InterruptedException, IOException {
        int i=0;
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
        String retirement = "images/Protection_Retirement.png";
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

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Protection_Retirement").addScreenCaptureFromPath(retirement).pass("PASS");

        while(true) {
            try{
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

                Boolean isHavePolicy = context.isElementPresent("//div[@id='product-name-"+i+"']");
                Boolean isNotHavePolicy  = context.isElementPresent("//div[@id='empty-state-not-covered']");
                System.out.println("Is it have Retirement Coverage? : " + isHavePolicy);
                System.out.println("Policy Sequence: " + i);
                String retirementMyPolicies = "images/Protection_Retirement My Policies_"+i+".png";
                String retirementPolicyDetails = "images/Protection_Retirement Policy Details_"+i+".png";
                String retirementPolicyDetailsInsurance = "images/Protection_Retirement Policy Details_Insurance company_"+i+".png";
                String retirementPolicyDetailsProtection = "images/Protection_Retirement Policy Details_Protection information_"+i+".png";
                String retirementPolicyDetailsPremium = "images/Protection_Retirement Policy Details_Premium payment details_"+i+".png";

                if(isNotHavePolicy == true){
                    context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                    context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_EMPTYCOVERAGE);
                    Thread.sleep(1000);
                    takeScreenshot(retirementMyPolicies);
                    break;
                }
                else if(isHavePolicy == true){
                    System.out.println("Before");
                    while(true){
                        Thread.sleep(1000);
                        if(context.isElementPresent("//div[@id='product-name-"+i+"']")){
                            if(i==1 || i==2){
                                context.scrollDown();
                            }
                            else if(i>2){
                                context.scrollDown();
                                context.scrollDown();
                                context.scrollDown();
                            }
                            break;
                        }
                        else{
                            context.scrollDown();
                        }
                    }

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
                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_LABEL);
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

                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).click();
                    String INSURANCEDETAILS_COMPANYNAME = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_COMPANYNAME_LABEL).getText();
                    System.out.println("Company name: " + INSURANCEDETAILS_COMPANYNAME);
                    String INSURANCEDETAILS_PHONENUMBER = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_PHONENUMBER_LABEL).getText();
                    System.out.println("Phone number: " + INSURANCEDETAILS_PHONENUMBER);

                    context.getDriver().context("NATIVE_APP");
                    Thread.sleep(3000);
                    takeScreenshot(retirementPolicyDetailsInsurance);
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).click();
                    String PROTECTIONDETAILS_FROMEANYCAUSE = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_FROMEANYCAUSE_LABEL).getText();
                    System.out.println("From any cause: " + PROTECTIONDETAILS_FROMEANYCAUSE);
                    String PROTECTIONDETAILS_FROMEACCIDENTS = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_FROMEACCIDENTS_LABEL).getText();
                    System.out.println("From accidents: " + PROTECTIONDETAILS_FROMEACCIDENTS);

                    context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).click();
                    Thread.sleep(3000);
                    takeScreenshot(retirementPolicyDetailsProtection);
                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).getText());
                    String PREMIUMPAYMENT_POLICYYEAR = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_POLICYYEAR_LABEL).getText();
                    System.out.println("Policy year: " + PREMIUMPAYMENT_POLICYYEAR);
                    String PREMIUMPAYMENT_PREMIUM = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_NEXTPAYMENT_LABEL).getText();
                    System.out.println("Next payment date: " + PREMIUMPAYMENT_PREMIUM);
                    String PREMIUMPAYMENT_PAYMENTTERM = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTTERM_LABEL).getText();
                    System.out.println("Payment term: " + PREMIUMPAYMENT_PAYMENTTERM);
                    String PREMIUMPAYMENT_PAYMENTMETHOD = context.findElement(OneAppElementKeys.PROTECTION_RETIREMENT_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTMETHOD_LABEL).getText();
                    System.out.println("Payment method: " + PREMIUMPAYMENT_PAYMENTMETHOD);
                    takeScreenshot(retirementPolicyDetailsPremium);
                    System.out.println("\n");
                    context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
                }
                else{
                    break;
                }
                i++;
                context.getDriver().context("NATIVE_APP");
                context.scrollDown();

                scenario.createNode(Given.class, "Protection_Retirement My Policies"+i+"").addScreenCaptureFromPath(retirementMyPolicies).pass("PASS");
                scenario.createNode(Given.class, "Protection_Retirement My Policies_Policy Details"+i+"").addScreenCaptureFromPath(retirementPolicyDetails).pass("PASS");
                scenario.createNode(Given.class, "Protection_Retirement My Policies_Policy Details_Insurance company"+i+"").addScreenCaptureFromPath(retirementPolicyDetailsInsurance).pass("PASS");
                scenario.createNode(Given.class, "Protection_Retirement My Policies_Policy Details_Protection information"+i+"").addScreenCaptureFromPath(retirementPolicyDetailsProtection).pass("PASS");
                scenario.createNode(Given.class, "Protection_Retirement My Policies_Policy Details_Premium payment details"+i+"").addScreenCaptureFromPath(retirementPolicyDetailsPremium).pass("PASS");

            }catch (Exception e){
                System.err.println("\n" + "INFO : " + e);
                break;

            }
        }
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_BACK_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_BACK_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }


    @Test(groups = "Loss of Life My Policies", dependsOnGroups = {"Activate application"}, priority = 3)
    public void lossOfLifeMyPolicies() throws InterruptedException, IOException {
        int i=0;
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
        String lossOfLife = "images/Protection_Loss of Life.png";
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
        context.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB);
        context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_TAB).click();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Policies Related to Retirement Savings");
        scenario.createNode(Given.class, "Protection_Retirement").addScreenCaptureFromPath(lossOfLife).pass("PASS");

        while(true) {
            try{
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

                Boolean isHavePolicy = context.isElementPresent("//div[@id='product-name-"+i+"']");
                Boolean isNotHavePolicy  = context.isElementPresent("//div[@id='empty-state-not-covered']");
                System.out.println("Is it have Retirement Coverage? : " + isHavePolicy);
                System.out.println("Policy Sequence: " + i);
                String lossOfLifeMyPolicies = "images/Protection_Loss of Life My Policies_"+i+".png";
                String lossOfLifePolicyDetails = "images/Protection_Loss of Life Policy Details_"+i+".png";
                String lossOfLifePolicyDetailsInsurance = "images/Protection_Loss of Life Policy Details_Insurance company_"+i+".png";
                String lossOfLifePolicyDetailsProtection = "images/Protection_Loss of Life Policy Details_Protection information_"+i+".png";
                String lossOfLifePolicyDetailsBeneficiary = "images/Protection_Loss of Life Policy Details_Beneficiary_"+i+".png";
                String lossOfLifePolicyDetailsPremium = "images/Protection_Loss of Life Policy Details_Premium payment details_"+i+".png";

                if(isNotHavePolicy == true){
                    context.waitUntilVisible(OneAppElementKeys.PROTECTION_INSURANCE_HEADER);
                    context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_EMPTYCOVERAGE);
                    Thread.sleep(1000);
                    takeScreenshot(lossOfLifeMyPolicies);
                    break;
                }
                else if(isHavePolicy == true){
                    System.out.println("Before");
                    while(true){
                        Thread.sleep(1000);
                        if(context.isElementPresent("//div[@id='product-name-"+i+"']")){
                            if(i==1 || i==2){
                                context.scrollDown();
                            }
                            else if(i>2){
                                context.scrollDown();
                                context.scrollDown();
                                context.scrollDown();
                            }
                            break;
                        }
                        else{
                            context.scrollDown();
                        }
                    }

                    String lossOfLifeMyPoliciesSubheader = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_SUBHEADER).getText();
                    System.out.println("\n  " + lossOfLifeMyPoliciesSubheader);
                    Thread.sleep(1000);

                    String policyName = context.getDriver().findElement(By.xpath("//div[@id='product-name-"+i+"']")).getText();
                    System.out.println("\n  " + policyName);
                    String policyNumber = context.getDriver().findElement(By.xpath("//p[@id='policy-number-"+i+"']")).getText();
                    System.out.println("Policy NUmber: " + policyNumber);
                    String saving = context.getDriver().findElement(By.xpath("//div[@id='premium-paid-amount-"+i+"']")).getText();
                    System.out.println("Loss of life coverage: " + saving);
                    String publicAccidentsCoverage = context.getDriver().findElement(By.xpath("//div[@id='accidental-death-coverage-"+i+"']")).getText();
                    System.out.println("Public accidents coverage: " + publicAccidentsCoverage);
                    String beginningOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-start-date-"+i+"']")).getText();
                    System.out.println("Beginning of coverage: " + beginningOfCoverage);
                    String endOfCoverage = context.getDriver().findElement(By.xpath("//div[@id='protection-end-date-"+i+"']")).getText();
                    System.out.println("End of coverage: " + endOfCoverage);

                    String seeMorePolicy = "//div[@id='goto-policy-detail-"+i+"']";
                    System.out.println(seeMorePolicy);

                    takeScreenshot(lossOfLifeMyPolicies);
                    context.getDriver().findElement(By.xpath(seeMorePolicy)).click();
                    System.out.println("click");

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

                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_INSURANCEDETAILS_BUTTON).click();
                    String INSURANCEDETAILS_COMPANYNAME = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_COMPANYNAME_LABEL).getText();
                    System.out.println("Company name: " + INSURANCEDETAILS_COMPANYNAME);
                    String INSURANCEDETAILS_PHONENUMBER = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_INSURANCEDETAILS_PHONENUMBER_LABEL).getText();
                    System.out.println("Phone number: " + INSURANCEDETAILS_PHONENUMBER);

                    context.getDriver().context("NATIVE_APP");
                    Thread.sleep(3000);
                    takeScreenshot(lossOfLifePolicyDetailsInsurance);
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).getText());
                    context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PROTECTIONDETAILS_BUTTON).click();
                    String PROTECTIONDETAILS_FROMEANYCAUSE = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_FROMEANYCAUSE_LABEL).getText();
                    System.out.println("From any cause: " + PROTECTIONDETAILS_FROMEANYCAUSE);
                    String PROTECTIONDETAILS_FROMEACCIDENTS = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PROTECTIONDETAILS_FROMEACCIDENTS_LABEL).getText();
                    System.out.println("From accidents: " + PROTECTIONDETAILS_FROMEACCIDENTS);

                    context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_BENEFICIARY_BUTTON).click();
                    Thread.sleep(3000);
                    takeScreenshot(lossOfLifePolicyDetailsProtection);
                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_BENEFICIARY_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_BENEFICIARY_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_BENEFICIARY_BUTTON).getText());
                    String BENEFICIARYDETAILS_NAME = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BENEFICIARYDETAILS_NAME_LABEL).getText();
                    System.out.println("Firstname and lastname: " + BENEFICIARYDETAILS_NAME);
                    String BENEFICIARYDETAILS_RELATIONSHIP = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_BENEFICIARYDETAILS_RELATIONSHIP_LABEL).getText();
                    System.out.println("Relationship: " + BENEFICIARYDETAILS_RELATIONSHIP);
                    takeScreenshot(lossOfLifePolicyDetailsProtection);

                    context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).click();
                    Thread.sleep(3000);
                    takeScreenshot(lossOfLifePolicyDetailsBeneficiary);
                    context.getDriver().context("NATIVE_APP");
                    context.scrollDown();
                    context.scrollDown();

                    contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON, true);
                    Thread.sleep(3000);
                    webNames = contextWebView.getWindowHandles();
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON);
                            break;
                        } catch (Exception e) {
                            System.out.println("The webview is not ready to use");
                        }
                    }

                    System.out.println("\n  " + context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_OPEN_PREMIUMDETAILS_BUTTON).getText());
                    String PREMIUMPAYMENT_POLICYYEAR = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_POLICYYEAR_LABEL).getText();
                    System.out.println("Policy year: " + PREMIUMPAYMENT_POLICYYEAR);
                    String PREMIUMPAYMENT_PREMIUM = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_NEXTPAYMENT_LABEL).getText();
                    System.out.println("Next payment date: " + PREMIUMPAYMENT_PREMIUM);
                    String PREMIUMPAYMENT_PAYMENTTERM = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTTERM_LABEL).getText();
                    System.out.println("Payment term: " + PREMIUMPAYMENT_PAYMENTTERM);
                    String PREMIUMPAYMENT_PAYMENTMETHOD = context.findElement(OneAppElementKeys.PROTECTION_LOSSOFLIFE_MYPOLICIES_POLICYDETAILS_PREMIUMPAYMENT_PAYMENTMETHOD_LABEL).getText();
                    System.out.println("Payment method: " + PREMIUMPAYMENT_PAYMENTMETHOD);
                    takeScreenshot(lossOfLifePolicyDetailsPremium);
                    System.out.println("\n");
                    context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
                }
                else{
                    break;
                }
                i++;
                context.getDriver().context("NATIVE_APP");
                context.scrollDown();

                scenario.createNode(Given.class, "Protection_Loss of Life My Policies"+i+"").addScreenCaptureFromPath(lossOfLifeMyPolicies).pass("PASS");
                scenario.createNode(Given.class, "Protection_Loss of Life My Policies_Policy Details"+i+"").addScreenCaptureFromPath(lossOfLifePolicyDetails).pass("PASS");
                scenario.createNode(Given.class, "Protection_Loss of Life My Policies_Policy Details_Insurance company"+i+"").addScreenCaptureFromPath(lossOfLifePolicyDetailsInsurance).pass("PASS");
                scenario.createNode(Given.class, "Protection_Loss of Life My Policies_Policy Details_Protection information"+i+"").addScreenCaptureFromPath(lossOfLifePolicyDetailsProtection).pass("PASS");
                scenario.createNode(Given.class, "Protection_Loss of Life My Policies_Policy Details_Beneficiary"+i+"").addScreenCaptureFromPath(lossOfLifePolicyDetailsBeneficiary).pass("PASS");
                scenario.createNode(Given.class, "Protection_Loss of Life My Policies_Policy Details_Premium payment details"+i+"").addScreenCaptureFromPath(lossOfLifePolicyDetailsPremium).pass("PASS");

            }catch (Exception e){
                System.err.println("\n" + "INFO : " + e);
                break;

            }
        }
        contextWebView = ttbTestContext.setContextToWebView(OneAppElementKeys.PROTECTION_BACK_BUTTON, true);
        Thread.sleep(3000);
        webNames = contextWebView.getWindowHandles();
        for (String s : webNames) {
            ttbTestContext.getDriver().switchTo().window(s);
            System.out.println("test : " + s);
            try {
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PROTECTION_BACK_BUTTON);
                break;
            } catch (Exception e) {
                System.out.println("The webview is not ready to use");
            }
        }
        context.findElement(OneAppElementKeys.PROTECTION_BACK_BUTTON).click();
        context.getDriver().context("NATIVE_APP");
        getExtent().flush();
    }
}
