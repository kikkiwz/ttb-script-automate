package com.ttbbank.oneapp.scenario.investment;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class IntroductionToInvestmentScenario extends AccountScenario {

    public void validateIntroductionToInvestment() throws IOException, InterruptedException {

        TtbTestContext context = getTtbTestContext();

        Thread.sleep(6000);

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_WHY_INVEST_WITH_TTB_LABEL, true);

        if (ttbTestContext.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_WHY_INVEST_WITH_TTB_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }


        WebElement screenTitle = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_SCREEN_TITLE_LABEL);
        WebElement iconImage = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_WHY_INVEST_WITH_TTB_LABEL);
        WebElement whyInvestWithTTBLabel = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_WHY_INVEST_WITH_TTB_LABEL);
        WebElement contentBullet1Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_CONTENT_BULL1_LABEL);
        WebElement contentBullet2Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_CONTENT_BULL2_LABEL);
        WebElement contentBullet3Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_CONTENT_BULL3_LABEL);
        WebElement contentBullet4Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_CONTENT_BULL4_LABEL);
        WebElement contentBullet5Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_CONTENT_BULL5_LABEL);
        WebElement ourOfferLabel = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_OUR_OFFER_LABEL);
        WebElement ourOfferParagraph1Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_OUR_OFFER_PARAGRAPH1_LABEL);
        WebElement searchFundButton = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_SEARCH_FUND_BUTTON);
        WebElement ourOfferParagraph2Label = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_OUR_OFFER_PARAGRAPH2_LABEL);
        WebElement knowTTBSmartPortButton = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_KNOW_TTB_SMART_PORT_BUTTON);

        context.scrollDown();

        Assert.assertTrue(screenTitle.isDisplayed());
        Assert.assertTrue(iconImage.isDisplayed());
        Assert.assertTrue(whyInvestWithTTBLabel.isDisplayed());
        Assert.assertTrue(contentBullet1Label.isDisplayed());
        Assert.assertTrue(contentBullet2Label.isDisplayed());
        Assert.assertTrue(contentBullet3Label.isDisplayed());
        Assert.assertTrue(contentBullet4Label.isDisplayed());
        Assert.assertTrue(contentBullet5Label.isDisplayed());
        Assert.assertTrue(ourOfferLabel.isDisplayed());
        Assert.assertTrue(ourOfferParagraph1Label.isDisplayed());
        Assert.assertTrue(searchFundButton.isDisplayed());
        Assert.assertTrue(ourOfferParagraph2Label.isDisplayed());
        Assert.assertTrue(knowTTBSmartPortButton.isDisplayed());

    }

    @Test(groups = "Introduction to Investment click search fund", dependsOnGroups = "Click Start Investing With ttb")
    public void verifyClickSearchFund() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();

        validateIntroductionToInvestment();

        WebElement searchFundButton = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_SEARCH_FUND_BUTTON);
        searchFundButton.click();

        Thread.sleep(6000);

    }

    @Test(groups = "Introduction to Investment click know ttb smart port", dependsOnGroups = "Click Start Investing With ttb")
    public void verifyClickKnowTTBSmartPort() throws IOException, InterruptedException {
        TtbTestContext context = getTtbTestContext();

        validateIntroductionToInvestment();

        WebElement knowTTBSmartPortButton = context.findElement(OneAppElementKeys.INVESTMENT_INTRODUCTION_TO_INVEST_KNOW_TTB_SMART_PORT_BUTTON);
        knowTTBSmartPortButton.click();

        Thread.sleep(6000);


    }

}
