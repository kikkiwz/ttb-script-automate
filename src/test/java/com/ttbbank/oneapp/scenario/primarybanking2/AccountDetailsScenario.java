package com.ttbbank.oneapp.scenario.primarybanking2;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountDetailsScenario extends BaseScenario {

    @Test(groups = "Account Details", dependsOnGroups = {"Enter Home Screen Dev Latest"})
    public void accountDetails() throws InterruptedException {

        TtbTestContext ttbTestContext = getTtbTestContext();
        //ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_TESTTTTT);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_BUTTON);
        WebElement accountDetailsButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountDetailsButton.click();

        WebElement cell0TableCell = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST);
        cell0TableCell.click();

        WebElement statementButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_BUTTON);
        Actions builder = new Actions(ttbTestContext.getDriver());
        builder.moveToElement(statementButton).click(statementButton);
        builder.perform();

        WebElement selectThaiLanguageRadioButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_TH_RADIO_BUTTON);
        selectThaiLanguageRadioButton.click();

        WebElement selectCondensedStatementRadioButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_CONDENSED_STATEMENT_RADIO_BUTTON);
        selectCondensedStatementRadioButton.click();

        WebElement selectTransactionPeriodFromButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON);
        selectTransactionPeriodFromButton.click();

        WebElement selectTransactionPeriodDoneButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON);
        selectTransactionPeriodDoneButton.click();

        WebElement generateStatementButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON);
        generateStatementButton.click();

        WebElement statementPageNumberLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL);
        Assert.assertTrue(statementPageNumberLabel.isDisplayed());

        WebElement statementSaveFileButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON);
        Assert.assertTrue(statementSaveFileButton.isDisplayed());

        WebElement statementShareFileButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON);
        Assert.assertTrue(statementShareFileButton.isDisplayed());
        statementShareFileButton.click();

    }
}
