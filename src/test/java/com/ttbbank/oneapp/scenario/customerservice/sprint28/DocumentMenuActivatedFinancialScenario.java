package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DocumentMenuActivatedFinancialScenario extends BaseScenario {
    @Test(groups = "Customer Service Document Menu Activated Financial", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void DeleteButtonHelpCenterApplicationTracking() throws InterruptedException {
        testcase01();
    }

    public void testcase01(){
        TtbTestContext ttbTestContext = getTtbTestContext();
//        if(ttbTestContext.isIos()){
//            //iOS DEFECT, have to click apply and come back then we can click passbook item.
//            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.APPLY_SERVICE_PAGE_BUTTON);
//            applyServicePageButton.click();
//            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_APPLY_SERVICE_PAGE_BUTTON);
//            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
//            documentServicePageButton.click();
//        }
//        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        WebElement FINANCIAL_CERTIFICATE_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        FINANCIAL_CERTIFICATE_SERVICE_BUTTON.click();
    }
}
