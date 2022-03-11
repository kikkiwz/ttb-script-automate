package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceScreenProspectScenario extends BaseScenario {

    @Test(groups = "ServiceScreen Prospect Group")
    public void testProspectLeadingToCustomerServiceShouldShowTabDocument() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DOCUMENTS_SERVICE_BUTTON);

        WebElement documentServiceButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENTS_SERVICE_BUTTON);
        WebElement passBookDocumentButton = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        WebElement statementDocumentButton = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        WebElement financialDocumentButton = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        WebElement ncbRepostDocumentButton = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);

        Assert.assertTrue(documentServiceButton.isDisplayed());
        Assert.assertTrue(passBookDocumentButton.isDisplayed());
        Assert.assertTrue(statementDocumentButton.isDisplayed());
        Assert.assertTrue(financialDocumentButton.isDisplayed());
        Assert.assertTrue(ncbRepostDocumentButton.isDisplayed());
    }
}
