package com.ttbbank.oneapp.scenario.autoloan;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoLoanHomeScenario extends BaseScenario {


    @Test(groups = "Enter Loan Home",dependsOnGroups = "Activate new flow")
    public void enterLoanHome() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.ACCOUNT_TAB).click();
        Thread.sleep(2000);
        context.tapCenter();
        context.findElement(OneAppElementKeys.AUTO_LOAN_MY_ACCOUNT).click();
        Boolean loanAccount = context.findElement(OneAppElementKeys.AUTO_LOAN_1ST_ACCOUNT).isDisplayed();
        Assert.assertTrue(loanAccount);
    }


}
