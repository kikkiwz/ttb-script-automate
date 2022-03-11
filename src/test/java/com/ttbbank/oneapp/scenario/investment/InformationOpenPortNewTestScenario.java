package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class InformationOpenPortNewTestScenario extends TAndCOpenPortFromOnBoardingTestScenario {

    public void validateInformationOpenPort() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_SCREEN_TITLE_LABEL, true);

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_SCREEN_TITLE_LABEL);

        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_SCREEN_TITLE_LABEL);
        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        WebElement purposeText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PURPOSE_OF_INVEST_TEXT);
        WebElement occupationText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_OCCUPATION_TEXT);
        WebElement positionText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_POSITION_TEXT);
        WebElement accountRedeemText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_ACCOUNT_REDEEM_TEXT);
//        WebElement accountRedeemRemarkLabel = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_ACCOUNT_REDEEM_REMARK_TEXT);
        WebElement addressText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_ADDRESS_TEXT);
        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_NEXT_BUTTON);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Information Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Information Open Portfolio/Information Open Portfolio";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Information Open Portfolio").addScreenCaptureFromPath(transactionPlan).pass("Information Open Portfolio display correctly");

        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(nicknameText.isDisplayed());
        Assert.assertTrue(purposeText.isDisplayed());
        Assert.assertTrue(occupationText.isDisplayed());
        Assert.assertFalse(occupationText.isEnabled());
        Assert.assertTrue(positionText.isDisplayed());
        Assert.assertTrue(accountRedeemText.isDisplayed());
//        Assert.assertTrue(accountRedeemRemarkLabel.isDisplayed());
        Assert.assertTrue(addressText.isDisplayed());
        Assert.assertFalse(nextButton.isEnabled());


    }

    @Test(groups = "Set Nickname One Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void validateNickNameOneChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateInformationOpenPort();

        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        nicknameText.sendKeys("N");
    }

    @Test(groups = "Set Nickname Only Thai Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void validateNickNameTHChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateInformationOpenPort();

        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        nicknameText.sendKeys("ออโตเมทเปิดบัญชี");
    }

    @Test(groups = "Set Nickname Only English Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void validateNickNameENChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateInformationOpenPort();

        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        nicknameText.sendKeys("Automate Open Port");
    }

    @Test(groups = "Set Nickname Only Number", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void validateNickNameNumberChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateInformationOpenPort();

        Random rnd = new Random();
        int nickNameNumber = rnd.nextInt(999999999);
        String nickNameStr = Integer.toString(nickNameNumber);

        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        nicknameText.sendKeys(nickNameStr);
//        System.err.println(context.getDriver().getPageSource());

    }

    @Test(groups = "Set Nickname Mix Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void validateNickNameMixChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        validateInformationOpenPort();

        WebElement nicknameText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PORT_NICKNAME_TEXT);
        nicknameText.sendKeys("เปิด port existing@1");

    }

    @Test(groups = "Selected Purpose Of Investment", dependsOnGroups = "Set Nickname Mix Character")
    public void validatePurposeOfInvestment() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PURPOSE_OF_INVEST_TEXT, true);

        WebElement purposeText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_PURPOSE_OF_INVEST_TEXT);
        purposeText.click();

        WebElement purposeSelectedValue = context.findElement(OneAppElementKeys.INVESTMENT_PURPOSE_OF_INVESTMENT_BUY_A_CAR_VALUE_LABEL);

        context.scrollTillElementIntoDisplay(OneAppElementKeys.INVESTMENT_PURPOSE_OF_INVESTMENT_BUY_A_CAR_VALUE_LABEL);
        purposeSelectedValue.click();

    }

    @Test(groups = "Enter Position", dependsOnGroups = "Selected Purpose Of Investment")
    public void validatePositionThaiChar() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_POSITION_TEXT, true);

        WebElement positionText = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_POSITION_TEXT);
        positionText.sendKeys("Tester");

        Thread.sleep(1000);
    }


    @Test(groups = "Information Open Port click Next Button", dependsOnGroups = "Enter Position")
    public void validateNextButton() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_NEXT_BUTTON, true);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Information Open Portfolio");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Open Portfolio/Information Open Portfolio";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Information Open Portfolio").addScreenCaptureFromPath(transactionPlan).pass("Information Open Portfolio display correctly");

        WebElement nextButton = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_INFORMATION_NEXT_BUTTON);
        nextButton.click();
    }


}
