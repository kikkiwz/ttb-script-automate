package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class MoreActionTestScenario extends MyMutualFundTestScenario {


    public void validateMoreAction() throws InterruptedException, IOException {

        TtbTestContext context = getTtbTestContext();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_MORE_CLOSE_BUTTON, true);


        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_MORE_MORE_ACTION_LABEL);

        String[] expectResultKey = new String[15];
        expectResultKey[1] = "Transaction";
        expectResultKey[2] = "ทำรายการอื่นๆ";
        expectResultKey[3] = "Switch";
        expectResultKey[4] = "สับเปลี่ยน";
        expectResultKey[5] = "Manage DCA Plans";
        expectResultKey[6] = "จัดการDCA";
        expectResultKey[7] = "Open an Account";
        expectResultKey[8] = "เปิดบัญลงทุน";
        expectResultKey[9] = "Settings / information";
        expectResultKey[10] = "จัดการข้อมูล";
        expectResultKey[11] = "Suitability test";
        expectResultKey[12] = "แบบประเมินความเสี่ยง";
        expectResultKey[13] = "TAX document";
        expectResultKey[14] = "ดาวน์โหลดเอกสารภาษี";

        boolean isEN = true;

        WebElement moreCloseButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_CLOSE_BUTTON);
        WebElement moreActionLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_MORE_ACTION_LABEL);

        WebElement moreSwitchButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SWITCH_BUTTON);
        WebElement moreSwitchLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SWITCH_LABEL);

        WebElement moreManageDCAButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_MANAGE_DCA_BUTTON);
        WebElement moreManageDCALabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_MANAGE_DCA_LABEL);

        WebElement moreOpenPortButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_OPEN_PORTFOLIO_BUTTON);
        WebElement moreOpenPortLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_OPEN_PORTFOLIO_LABEL);

        WebElement moreSettingLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SETTING_LABEL);

        WebElement moreSuiteTestButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SUITABILITY_TEST_BUTTON);
        WebElement moreSuiteTestLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SUITABILITY_TEST_LABEL);

        WebElement moreTaxDocButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_DOWNLOAD_TAX_DOC_BUTTON);
        WebElement moreTaxDocLabel = context.findElement(OneAppElementKeys.INVESTMENT_MORE_DOWNLOAD_TAX_DOC_LABEL);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "More Action");
        String transactionPlan = "images/" + context.getPlateFormName() + "/More Action/More Action.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "More Action Page").addScreenCaptureFromPath(transactionPlan).pass("pass");

        Assert.assertTrue(moreCloseButton.isDisplayed());
        Assert.assertTrue(moreActionLabel.isDisplayed());

        Assert.assertTrue(moreSwitchButton.isDisplayed());
        Assert.assertTrue(moreSwitchLabel.isDisplayed());

        Assert.assertTrue(moreManageDCAButton.isDisplayed());
        Assert.assertTrue(moreManageDCALabel.isDisplayed());

        Assert.assertTrue(moreOpenPortButton.isDisplayed());
        Assert.assertTrue(moreOpenPortLabel.isDisplayed());

        Assert.assertTrue(moreSettingLabel.isDisplayed());

        Assert.assertTrue(moreSuiteTestButton.isDisplayed());
        Assert.assertTrue(moreSuiteTestLabel.isDisplayed());

        Assert.assertTrue(moreTaxDocButton.isDisplayed());
        Assert.assertTrue(moreTaxDocLabel.isDisplayed());


        if (isEN) {
            Assert.assertTrue(moreActionLabel.getText().toLowerCase().equals(expectResultKey[1].toLowerCase()));
            Assert.assertTrue(moreSwitchLabel.getText().toLowerCase().equals(expectResultKey[3].toLowerCase()));
            Assert.assertTrue(moreManageDCALabel.getText().toLowerCase().equals(expectResultKey[5].toLowerCase()));
            Assert.assertTrue(moreOpenPortLabel.getText().toLowerCase().equals(expectResultKey[7].toLowerCase()));
            Assert.assertTrue(moreSettingLabel.getText().toLowerCase().equals(expectResultKey[9].toLowerCase()));
            Assert.assertTrue(moreSuiteTestLabel.getText().toLowerCase().equals(expectResultKey[11].toLowerCase()));
            Assert.assertTrue(moreTaxDocLabel.getText().toLowerCase().equals(expectResultKey[13].toLowerCase()));
        } else {
            Assert.assertTrue(moreActionLabel.getText().toLowerCase().equals(expectResultKey[2].toLowerCase()));
            Assert.assertTrue(moreSwitchLabel.getText().toLowerCase().equals(expectResultKey[4].toLowerCase()));
            Assert.assertTrue(moreManageDCALabel.getText().toLowerCase().equals(expectResultKey[6].toLowerCase()));
            Assert.assertTrue(moreOpenPortLabel.getText().toLowerCase().equals(expectResultKey[8].toLowerCase()));
            Assert.assertTrue(moreSettingLabel.getText().toLowerCase().equals(expectResultKey[10].toLowerCase()));
            Assert.assertTrue(moreSuiteTestLabel.getText().toLowerCase().equals(expectResultKey[12].toLowerCase()));
            Assert.assertTrue(moreTaxDocLabel.getText().toLowerCase().equals(expectResultKey[14].toLowerCase()));
        }

    }

    @Test(groups = "More Menu", dependsOnGroups = "My Mutual Fund Menu", priority = 1)
    public void validateMoreDisplaySuccess() throws InterruptedException, IOException {
        TtbTestContext context = getTtbTestContext();
        validateMoreAction();
    }

    @Parameters({"moreMenuItem"})
    @Test(groups = "More Menu", dependsOnGroups = "My Mutual Fund Menu", priority = 2)
    public void validateClickAction(String menuItem) {

        TtbTestContext context = getTtbTestContext();

        WebElement menuItemButton = null;

        switch (menuItem) {
            case "switch":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SWITCH_BUTTON);
                break;
            case "manangedca":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_MANAGE_DCA_BUTTON);
                break;
            case "openPort":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_OPEN_PORTFOLIO_BUTTON);
                break;
            case "suitTest":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_SUITABILITY_TEST_BUTTON);
                break;
            case "taxDoc":
                menuItemButton = context.findElement(OneAppElementKeys.INVESTMENT_MORE_DOWNLOAD_TAX_DOC_BUTTON);
                break;
        }
        menuItemButton.click();

    }


}
