package com.ttbbank.oneapp.scenario.platform2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangeEmailEmptyScenario extends ChangeEmail {
    String oldEmail = "";

    @Parameters({"citizenId", "pin", "scenarioTestName", "scenarioType"})
    @Test(groups = "verifyChangeEmailMenu", priority = 1)
    public void verifyChangeEmailMenu(String citizenId, String pin,String scenarioTestName,String scenarioType) throws InterruptedException {

        oldEmail = verifyChangeEmailMenu(citizenId, pin);
    }

    @Test(groups = "validateUpdateEmailUnsuccessfulEmpty", priority = 2)
    public void validateUpdateEmailUnsuccessfulEmpty() throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0072";
        validateUpdateEmailUnsuccessfulEmptyFlagN(true,testCaseId);
    }

}
