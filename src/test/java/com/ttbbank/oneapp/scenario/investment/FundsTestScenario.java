package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FundsTestScenario extends ManageDCATestScenario {

    @Test(groups = "Funds", dependsOnGroups = "Manage DCA")
    public void fundsTest() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_FUNDS_FUND_NAME_LABEL);

        WebElement fundNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_FUNDS_FUND_NAME_LABEL);
        fundNameLabel.click();

        System.out.println(fundNameLabel.getText());

    }


}
