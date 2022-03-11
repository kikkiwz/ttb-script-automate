package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteButtonHelpCenterScenario extends BaseScenario {
    @Test(groups = "Customer Service Delete Button Help Center Case Tracking", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void DeleteButtonHelpCenter() throws InterruptedException {
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
        WebElement TabStatusTracking = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TabStatusTracking.click();
        WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        STATUS_TRACKING_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_LIST_SCREEN);
        ttbTestContext.findElement(OneAppElementKeys.TITLE_CASE_1).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.REF_NO_CASE_TRACKING_DETAIL_SCREEN);
    }
}
