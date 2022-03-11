package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteButtonOpenAccountScenario extends BaseScenario {
    @Test(groups = "Customer Service Delete Button Open Account", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void DeleteButtonOpenAccount() throws InterruptedException {
        testcase01();
    }

    public void testcase01(){
        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            //iOS DEFECT, have to click apply and come back then we can click passbook item.
            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.APPLY_SERVICE_PAGE_BUTTON);
            applyServicePageButton.click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
            documentServicePageButton.click();
        }
//        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebElement passBookServiceButton= ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        passBookServiceButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PASSBOOK_NO_ACC);
        WebElement ARROW_BTN_NO_ACCOUNT_PASSBOOK_SCREEN = ttbTestContext.findElement(OneAppElementKeys.ARROW_BTN_NO_ACCOUNT_PASSBOOK_SCREEN);
        ARROW_BTN_NO_ACCOUNT_PASSBOOK_SCREEN.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON2);
        STATUS_TRACKING_SERVICE_BUTTON.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PASSBOOK_NO_ACC);
        ARROW_BTN_NO_ACCOUNT_PASSBOOK_SCREEN.click();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.3);
        WebElement PASSBOOK_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        Boolean isPass = isElementPresent(PASSBOOK_SERVICE_BUTTON);
        System.err.println(isPass);
        Assert.assertTrue(!isPass);
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_LIST_SCREEN);
//        ttbTestContext.findElement(OneAppElementKeys.TITLE_CASE_1).click();
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.REF_NO_CASE_TRACKING_DETAIL_SCREEN);
    }


    public boolean isElementPresent(WebElement element) {
        try {
            if (element.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
}
