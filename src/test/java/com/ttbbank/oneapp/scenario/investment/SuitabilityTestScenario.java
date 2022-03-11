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

public class SuitabilityTestScenario extends BaseScenario {

    ExtentTest scenario = null;
    String transactionPlan = null;

    public void suitabilityTestScoreIsOne() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement nextQuestionBtn = context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_NEXT_BUTTON);
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION01_NO1_BUTTON).click();
        scenario = getFeature().createNode(Scenario.class, "Suitability Test Score = 1");
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question1.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION02_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question2.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION03_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question3.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION05_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION06_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question6.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question7.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION08_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question8.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION09_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question9.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION10_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question10.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION11_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question11.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION12_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question12.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION13_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question13.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION14_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question14.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION15_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question15.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

    }

    public void suitabilityTestScoreIsTwo() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement nextQuestionBtn = context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_NEXT_BUTTON);
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION01_NO2_BUTTON).click();
        scenario = getFeature().createNode(Scenario.class, "Suitability Test Score = 2");
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question1.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION02_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question2.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION03_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question3.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO1_BUTTON).click();
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1 and 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION05_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION06_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question6.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question7.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION08_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question8.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION09_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question9.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION10_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question10.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION11_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question11.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION12_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question12.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION13_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question13.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION14_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question14.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION15_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question15.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();
    }

    public void suitabilityTestScoreIsThree() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement nextQuestionBtn = context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_NEXT_BUTTON);
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION01_NO3_BUTTON).click();
        scenario = getFeature().createNode(Scenario.class, "Suitability Test Score = 3");
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question1.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION02_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question2.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION03_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question3.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION05_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION06_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question6.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question7.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION08_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question8.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION09_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question9.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION10_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question10.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION11_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question11.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION12_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question12.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION13_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question13.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION14_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question14.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION15_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question15.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

    }

    public void suitabilityTestScoreIsFour() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement nextQuestionBtn = context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_NEXT_BUTTON);
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION01_NO4_BUTTON).click();
        scenario = getFeature().createNode(Scenario.class, "Suitability Test Score = 4");
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question1.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION02_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question2.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION03_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question3.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION05_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION06_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question6.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO3_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question7.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 3").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION08_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question8.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION09_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question9.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION10_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question10.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION11_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question11.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION12_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question12.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION13_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question13.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION14_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question14.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION15_NO2_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question15.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 2").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();
    }

    public void suitabilityTestScoreIsFive() throws IOException {

        TtbTestContext context = getTtbTestContext();

        WebDriver webDriver = context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL, true);

        if (context.isAndroid()) {
            Set<String> webNames = webDriver.getWindowHandles();
            for (String s : webNames) {
                context.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_STEP_ID_LABEL);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        WebElement nextQuestionBtn = context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_NEXT_BUTTON);
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_01_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION01_NO4_BUTTON).click();
        scenario = getFeature().createNode(Scenario.class, "Suitability Test Score = 5");
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question1.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_02_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION02_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question2.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_03_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION03_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question3.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_04_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO1_BUTTON).click();
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO2_BUTTON).click();
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO3_BUTTON).click();
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION04_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question4.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice All").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_05_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION05_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question5.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_06_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION06_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question6.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL).isDisplayed());
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL, false);
        context.scrollDown();
        context.setContextToWebView(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_07_LABEL, true);
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO4_BUTTON).click();
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION07_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question7.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_08_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION08_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question8.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_09_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION09_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question9.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_10_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION10_NO4_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question10.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 4").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_11_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION11_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question11.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_12_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION12_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question12.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_13_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION13_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question13.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_14_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION14_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question14.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL);
        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_QUESTION_NO_15_LABEL).isDisplayed());
        context.findElement(OneAppElementKeys.INVESTMENT_QUESTION_AND_ANSWER_ANSWER_QUESTION15_NO1_BUTTON).click();
        transactionPlan = "images/" + context.getPlateFormName() + "/Suitability Test/Question15.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Selected answer choice 1").addScreenCaptureFromPath(transactionPlan).pass("Display question and answer correctly and able to selected answer");
        nextQuestionBtn.click();
    }
}
