package com.ttbbank.oneapp.runner.autoloan;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.autoloan.AutoLoanReceiptPayByTTBScenario;
import com.ttbbank.oneapp.scenario.autoloan.AutoLoanReceiptScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class AutoloanReceiptPayByTTBRunner extends AutoLoanReceiptPayByTTBScenario {
    @Parameters({"DeviceProfile"})
    @BeforeTest(alwaysRun = true)
    public void BeforeTest(@Optional String deviceProfile) throws MalformedURLException {

        testWithDeviceProfile(deviceProfile);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/ReceiptTaxInvoice_Pay_By_TTB"+ttbTestContext.getPlateFormName()+".html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("ReceiptTaxInvoicePayByTTB");
        setFeature(feature);
        setExtentReports(extentReports);
    }
}