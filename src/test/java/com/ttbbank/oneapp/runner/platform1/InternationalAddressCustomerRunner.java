package com.ttbbank.oneapp.runner.platform1;

import com.ttbbank.oneapp.scenario.platform1.InternationalAddressCusotomerScenario;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class InternationalAddressCustomerRunner extends InternationalAddressCusotomerScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) {
        initialContext(deviceProfile);
        createReport("International Address Customer");
    }

    @AfterMethod(groups = {"International Address Group"})
    public void afterMethod(ITestResult result) {
        handleAfterMethod(result);
    }

    @AfterClass(groups = {"International Address Group"})
    public void afterClass() {
        getExtent().flush();
    }

}
