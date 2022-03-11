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
import java.util.Random;

public class InformationOpenPortExistingTestScenario extends TAndCOpenPortFromMoreTestScenario {

    InformationOpenPortTestScenario informationOpenPortTestScenario = new InformationOpenPortTestScenario();

    public void verifyInformationOpenPort() throws IOException {

        informationOpenPortTestScenario.setTtbTestContext(getTtbTestContext());
        informationOpenPortTestScenario.setExtentReports(getExtent());
        informationOpenPortTestScenario.setFeature(getFeature());
        informationOpenPortTestScenario.validateInformationOpenPort();

    }

    @Test(groups = "Set Nickname One Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void verifyNickNameOneChar() throws InterruptedException, IOException {

        verifyInformationOpenPort();
        informationOpenPortTestScenario.validateNickNameOneChar();


    }

    @Test(groups = "Set Nickname Only Thai Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void verifyNickNameTHChar() throws InterruptedException, IOException {

        verifyInformationOpenPort();
        informationOpenPortTestScenario.validateNickNameTHChar();

    }

    @Test(groups = "Set Nickname Only English Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void verifyNickNameENChar() throws InterruptedException, IOException {

        verifyInformationOpenPort();
        informationOpenPortTestScenario.validateNickNameENChar();

    }

    @Test(groups = "Set Nickname Only Number", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void verifyNickNameNumberChar() throws InterruptedException, IOException {

        verifyInformationOpenPort();
        informationOpenPortTestScenario.validateNickNameNumberChar();

    }

    @Test(groups = "Set Nickname Mix Character", dependsOnGroups = "Terms and Conditions Open Portfolio")
    public void verifyNickNameMixChar() throws InterruptedException, IOException {

        verifyInformationOpenPort();

        informationOpenPortTestScenario.validateNickNameMixChar();



    }

    @Test(groups = "Selected Purpose Of Investment", dependsOnGroups = "Set Nickname Mix Character")
    public void verifyPurposeOfInvestment() throws InterruptedException, IOException {

        informationOpenPortTestScenario.validatePurposeOfInvestment();


    }

    @Test(groups = "Enter Position", dependsOnGroups = "Selected Purpose Of Investment")
    public void verifyPositionThaiChar() throws InterruptedException, IOException {

        informationOpenPortTestScenario.validatePositionThaiChar();

    }


    @Test(groups = "Information Open Port click Next Button", dependsOnGroups = "Enter Position")
    public void verifyNextButton() throws InterruptedException, IOException {

        informationOpenPortTestScenario.validateNextButton();

    }


}
