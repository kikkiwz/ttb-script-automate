package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CompletedDCAScenarioFundFromMyMutual extends ConfirmationDCAScenarioFundFromMyMutual {

    @Test(groups = "Completed DCA", dependsOnGroups = "Confirmation DCA")
    public void completeDCATest() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_COMPLETED_DCA_FUND_NAME_LABEL);

        WebElement backToInvestmentButton = context.findElement(OneAppElementKeys.INVESTMENT_COMPLETED_DCA_GO_BACK_TO_MANAGE_DCA_BUTTON);
        backToInvestmentButton.click();

    }


}
