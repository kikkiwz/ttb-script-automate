package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ApplyMenuProspectDepositScenario extends BaseScenario {
    @Test(groups = "Customer Service Apply Menu Prospect Deposit", dependsOnGroups = {"Enter Home Screen to service screen"})
    public void DeleteButtonHelpCenterApplicationTracking() throws InterruptedException {
        testcase01();
    }

    public void testcase01(){
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            //iOS DEFECT, have to click apply and come back then we can click passbook item.
            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.APPLY_SERVICE_PAGE_BUTTON);
            applyServicePageButton.click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_APPLY_SERVICE_PAGE_BUTTON);
            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
            documentServicePageButton.click();
        }
//        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
        WebElement DEPOSIT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
        DEPOSIT_SERVICE_BUTTON.click();
    }
}
