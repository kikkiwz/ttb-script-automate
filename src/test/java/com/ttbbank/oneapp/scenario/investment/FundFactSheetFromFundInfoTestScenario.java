package com.ttbbank.oneapp.scenario.investment;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundFactSheetFromFundInfoTestScenario extends FundInformationFromSearchFundTestScenario {

    @Test(groups = "Fund Fact Sheet", dependsOnGroups = {"Funds Information"})
    public void verifyFundFactSheet() throws IOException, InterruptedException {

        FundFactSheetTestScenario fundFactSheetTestScenario = new FundFactSheetTestScenario();
        fundFactSheetTestScenario.setTtbTestContext(getTtbTestContext());
        fundFactSheetTestScenario.setExtentReports(getExtent());
        fundFactSheetTestScenario.setFeature(getFeature());
        fundFactSheetTestScenario.validateFundFactSheet();
        fundFactSheetTestScenario.verifyClickBuyButton();

    }

}
