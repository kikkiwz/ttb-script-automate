package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InvestmentDetailsTestScenario extends MyMutualFundTestScenario {

    @Test(groups = "Manage DCA Test", dependsOnGroups = "Enter Investment Home")
    public void validateInvestmentDetail() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

//        context.waitUntilVisible(OneAppElementKeys.INVE);

        WebElement addDCAButton = context.findElement(OneAppElementKeys.INVESTMENT_INVESTMENT_DETAILS_ADD_DCA_BUTTON);
        addDCAButton.click();

    }


}
