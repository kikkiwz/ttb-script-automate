package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FinancialCertificateScenario extends BaseScenario {
    @Test(groups = "Customer Service Financial Certificate", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void FinancialCertificate() throws InterruptedException {
        testcase01();
        testcase02();
        testcase03();
        testcase04();
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
        WebElement financialCertificateServiceButton = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        financialCertificateServiceButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
        WebElement titleTutorialScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
        String elTitleTutorialScreen = titleTutorialScreen.getText();
        WebElement detailTutorial = ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_STATEMENT_FINANCIAL_CERTIFICATE);
        String elDetailTutorial = detailTutorial.getText();
        WebElement startBtnTutorial = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
        String elStartBtnTutorial = startBtnTutorial.getText();
        System.err.println("elTitleTutorialScreen : " + elTitleTutorialScreen);
        System.err.println("elDetailTutorial : " + elDetailTutorial);
        System.err.println("elStartBtnTutorial : " + elStartBtnTutorial);
        startBtnTutorial.click();
    }

    public void testcase02() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_DETAIL_BULLET_3);
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SERVICE_DETAIL_SCREEN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        WebElement financialCertificateServiceButton = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        financialCertificateServiceButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_DETAIL_BULLET_3);
    }

    public void testcase03() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_SERVICE_DETAIL_FINANCIAL).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR);
        ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR).click();
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.2, 0.5);
        ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_TH).click();
        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_1_FINANCIAL).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_PLEASE_REVIEW);
        WebElement LabelTitle = ttbTestContext.findElement(OneAppElementKeys.LABEL_TITLE_2);
        String elLabelTitle = LabelTitle.getText();
        WebElement TitleValue = ttbTestContext.findElement(OneAppElementKeys.TITLE_VALUE_2);
        String elTitleValue = TitleValue.getText();
        System.err.println("elLabelTitle : " + elLabelTitle);
        System.err.println("elTitleValue : " + elTitleValue);
    }

    public void testcase04() throws InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BUTTON_PROCESS_2_FINANCIAL).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR);
        ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR).click();
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.2, 0.5);
        ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_EN).click();
        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_1_FINANCIAL).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LABEL_PLEASE_REVIEW);
        WebElement DropdownTitle = ttbTestContext.findElement(OneAppElementKeys.DROPDOWN_TITLE);
        String elDropdownTitle = DropdownTitle.getText();
        DropdownTitle.click();
        Thread.sleep(5000);
        WebElement ValueDropDown1 = ttbTestContext.findElement(OneAppElementKeys.ValueDropDown1);
        String elValueDropDown1 = ValueDropDown1.getText();
        WebElement ValueDropDown2 = ttbTestContext.findElement(OneAppElementKeys.ValueDropDown2);
        String elValueDropDown2 = ValueDropDown2.getText();
        System.err.println("elDropdownTitle : " + elDropdownTitle);
        System.err.println("elValueDropDown1 : " + elValueDropDown1);
        System.err.println("elValueDropDown2 : " + elValueDropDown2);
    }
}
