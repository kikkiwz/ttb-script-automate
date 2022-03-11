package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CannotOpenPortExistingTestScenario extends MoreActionTestScenario {


    public void validateDisplayCannotProceedToOpenPort(String language, String message) throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_OPEN_PORT_ALTERNATIVE_SCREEN_TITLE_LABEL);

        WebElement closeButton = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_ALTERNATIVE_CLOSE_BUTTON);
        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_ALTERNATIVE_SCREEN_TITLE_LABEL);
        WebElement contentLabel = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_ALTERNATIVE_MESSAGE_AREA_LABEL);

        Assert.assertTrue(closeButton.isDisplayed());
        Assert.assertTrue(screenTitleLabel.isDisplayed());
        Assert.assertTrue(contentLabel.isDisplayed());

        Boolean isTrue = contentLabel.getText().toLowerCase().equals(message.toLowerCase());

    }

    @Parameters({"language"})
    @Test(groups = "Service Hours", dependsOnGroups = "More Menu")
    public void validateDisplayMassageServiceHours(@Optional String language) throws InterruptedException {
        String message = "Please proceed transaction during 06:00 to 22.00 .";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "Age less than 20")
    public void validateDisplayMassageAgeLessThanTwenty(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "No CASA Account")
    public void validateDisplayMassageNoCasaAccount(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "ID Card Expire")
    public void validateDisplayMassageIDCardExpire(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "IAL Level")
    public void validateDisplayMassageIALLevel(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "Risk Level")
    public void validateDisplayMassageRiskLevel(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "Nationality Restricted")
    public void validateDisplayMassageRestrictedNationality(String language) throws InterruptedException {
        String message = "";
        validateDisplayCannotProceedToOpenPort(language, message);
    }

    @Parameters({"language"})
    @Test(groups = "Complete FATCA Form")
    public void validateDisplayMassageCompleteFATCAForm(String language) throws InterruptedException {
        String message = "";

        TtbTestContext context = getTtbTestContext();

        validateDisplayCannotProceedToOpenPort(language, message);

        WebElement completeFATCA = context.findElement(OneAppElementKeys.INVESTMENT_OPEN_PORT_ALTERNATIVE_COMPLETE_FATCA_BUTTON);
        completeFATCA.click();
    }

}
