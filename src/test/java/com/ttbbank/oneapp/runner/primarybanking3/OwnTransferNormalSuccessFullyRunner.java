package com.ttbbank.oneapp.runner.primarybanking3;

import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.primarybanking3.normalTransfer.OwnTransferNormalCaseSuccessFullyScenario;
import org.testng.annotations.*;

public class OwnTransferNormalSuccessFullyRunner extends OwnTransferNormalCaseSuccessFullyScenario {

    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("OwnTransferSuccessfully");
    }

//    @AfterMethod(groups = {"Transfer Own TTB"})
//    public void tearDown() {
//        TtbTestContext ttbTestContext = getTtbTestContext();
//        ttbTestContext.getDriver().resetApp();
//    }

    @AfterClass(groups = {"Transfer Own TTB"})
    public void afterClass() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.getDriver().closeApp();
    }
}
