package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ConfirmationDCAScenarioFundFromMyMutual extends SetDCAPlanScenarioFundFromMyMutual {

    @Test(groups = "Confirmation DCA", dependsOnGroups = "Set DCA Plan")
    public void confirmationDCATest() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_CONFIRM_DCA_FUND_NAME_LABEL);


        //Accept Risk Condition
        WebElement confirmRiskCheckbox01 = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_DCA_RISK_CONDITION_NO1_CHECKBOX);
        confirmRiskCheckbox01.click();
        WebElement confirmRiskCheckbox02 = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_DCA_RISK_CONDITION_NO2_CHECKBOX);
        confirmRiskCheckbox02.click();
        WebElement confirmRiskCheckbox03 = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_DCA_RISK_CONDITION_NO3_CHECKBOX);
        confirmRiskCheckbox03.click();


        WebElement confirmNextButton = context.findElement(OneAppElementKeys.INVESTMENT_CONFIRM_DCA_CONFIRM_BUTTON);
        confirmNextButton.click();

            confirmPin();

    }


}
