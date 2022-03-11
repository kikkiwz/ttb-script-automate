package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.ProspectAccountSummaryCardScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ProspectAccountSummaryCardRunner extends ProspectAccountSummaryCardScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("Prospect Account Summary Card");
    }
}
