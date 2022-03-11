package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ManageDCATestScenario extends MyMutualFundTestScenario {

    @Test(groups = "Manage DCA", dependsOnGroups = "My Mutual Fund")
    public void manageDCATest() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_MANAGE_DCA_FUND_NAME_LABEL);

        WebElement addDCAButton = context.findElement(OneAppElementKeys.INVESTMENT_MANAGE_DCA_ADD_DCA_PLAN_BUTTON);
        addDCAButton.click();


    }


}
