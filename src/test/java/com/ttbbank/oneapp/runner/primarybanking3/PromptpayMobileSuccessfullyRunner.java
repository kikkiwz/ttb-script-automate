package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.normalTransfer.PromptpayMobileSuccessfullyScenario;
import org.testng.annotations.*;

public class PromptpayMobileSuccessfullyRunner extends PromptpayMobileSuccessfullyScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("PromptpayTransferMobileCaseSuccessfully");
    }

    @AfterClass(groups = {"Transfer Promptpay mobile success"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
