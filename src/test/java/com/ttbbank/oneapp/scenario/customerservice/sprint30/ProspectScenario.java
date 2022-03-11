package com.ttbbank.oneapp.scenario.customerservice.sprint30;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class ProspectScenario extends BaseScenario {
    ArrayList<String> currentContext = new ArrayList<String>();
    @Test(groups = "Customer Service Prospect", dependsOnGroups = {"Enter Service Screen Dev Latest"})
    public void ProspectScenario() throws InterruptedException, IOException {
        testcase01();
        testcase02();
        testcase03();
        testcase04();
        testcase05();
        testcase06();
        testcase07();
        testcase08();
        testcase09();
        testcase10();
        testcase11();
        testcase12();
        testcase13();
        testcase14();
        testcase15();
    }

    public void testcase01() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        } else {
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
        }
        WebElement PassbookServiceButton = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        PassbookServiceButton.click();
        WebElement startBtn = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
        startBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        Thread.sleep(3000);
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK, true);
        ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase02() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        if(ttbTestContext.isIos()){
            ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        }else{
            WebDriver context = null;
            context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(5000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement statementServiceButton = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        statementServiceButton.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        Thread.sleep(3000);
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase03() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON, true);
        WebElement financialServiceButton = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        financialServiceButton.click();
        WebElement startBtn = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
        startBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        Thread.sleep(3000);
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE, true);
        ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase04() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        WebElement NCBServiceServiceButton = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
        NCBServiceServiceButton.click();
        WebElement startBtn = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB);
        startBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        Thread.sleep(3000);
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB, true);
        ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase05() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.STATEMENT_SERVICE_BUTTON, true);
        WebElement TAB_APPLY = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
        TAB_APPLY.click();
        TAB_APPLY.click();
        Thread.sleep(5000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_apply_deposit_label_id']")));
        WebElement DEPOSIT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
        DEPOSIT_SERVICE_BUTTON.click();
        WebElement TitleDepositPage1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_DEPOSIT_PROSPECT);
        String elTitleDepositPage1 = TitleDepositPage1.getText();
        WebElement DepositDetail = ttbTestContext.findElement(OneAppElementKeys.DEPOSIT_DETAIL_PROSPECT);
        String elDepositDetail = DepositDetail.getText();
        WebElement AllFeeAccount = ttbTestContext.findElement(OneAppElementKeys.ALL_FREE_ACCOUNT);
        String elAllFeeAccount = AllFeeAccount.getText();
        WebElement NoFixedAccount = ttbTestContext.findElement(OneAppElementKeys.NO_FIXED_ACCOUNT);
        String elNoFixedAccount = NoFixedAccount.getText();
        WebElement NextBtnPage1 = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_PAGE1);
        String elNextBtnPage1 = NextBtnPage1.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
//        AllFeeAccount.click();
//        NextBtnPage1.click();
//        Thread.sleep(3000);
//        WebElement TitleDepositPage2 = ttbTestContext.findElement(OneAppElementKeys.TITLE_DEPOSIT_PROSPECT);
//        String elTitleDepositPage2 = TitleDepositPage2.getText();
//        WebElement NextBtnPage2 = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_PAGE2);
//        String elNextBtnPage2 = NextBtnPage2.getText();
//        ttbTestContext.horizontalSwipeByPercentage(0.99, 0.01, 0.3);
//        ttbTestContext.horizontalSwipeByPercentage(0.99, 0.01, 0.3);
//        NextBtnPage2.click();
//        Thread.sleep(3000);
//        WebElement TitleDepositPage3 = ttbTestContext.findElement(OneAppElementKeys.TITLE_DEPOSIT_PROSPECT);
//        String elTitleDepositPage3 = TitleDepositPage3.getText();
//        WebElement NextBtnPage3 = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_PAGE3);
//        String elNextBtnPage3 = NextBtnPage3.getText();
//        WebElement StepNo = ttbTestContext.findElement(OneAppElementKeys.STEP_EKYC);
//        String elStepNo = StepNo.getText();
//        WebElement LabelStep = ttbTestContext.findElement(OneAppElementKeys.LABEL_STEP_EKYC);
//        String elLabelStep = LabelStep.getText();
//        WebElement LabelDocumentEkyc = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOCUMENT_EKYC);
//        String elLabelDocumentEkyc = LabelDocumentEkyc.getText();
//        WebElement ThaiCID = ttbTestContext.findElement(OneAppElementKeys.THAI_CID);
//        String elThaiCID = ThaiCID.getText();
//        WebElement MobilePhone = ttbTestContext.findElement(OneAppElementKeys.MOBILE_PHONE_EKYC);
//        String elMobilePhone = MobilePhone.getText();
//        WebElement OtherBackNdid = ttbTestContext.findElement(OneAppElementKeys.OTHER_BANK_NDID);
//        String elOtherBackNdid = OtherBackNdid.getText();
//        WebElement CheckWifi = ttbTestContext.findElement(OneAppElementKeys.CHECK_WIFI_PLEASE);
//        String elCheckWifi = CheckWifi.getText();
        System.err.println("elTitleDepositPage1 : " + elTitleDepositPage1);
        System.err.println("elDepositDetail : " + elDepositDetail);
        System.err.println("elAllFeeAccount : " + elAllFeeAccount);
        System.err.println("elNoFixedAccount : " + elNoFixedAccount);
        System.err.println("elNextBtnPage1 : " + elNextBtnPage1);
//        System.err.println("elTitleDepositPage2 : " + elTitleDepositPage2);
//        System.err.println("elNextBtnPage2 : " + elNextBtnPage2);
//        System.err.println("elTitleDepositPage3 : " + elTitleDepositPage3);
//        System.err.println("elNextBtnPage3 : " + elNextBtnPage3);
//        System.err.println("elStepNo : " + elStepNo);
//        System.err.println("elLabelStep : " + elLabelStep);
//        System.err.println("elThaiCID : " + elThaiCID);
//        System.err.println("elLabelDocumentEkyc : " + elLabelDocumentEkyc);
//        System.err.println("elMobilePhone : " + elMobilePhone);
//        System.err.println("elOtherBackNdid : " + elOtherBackNdid);
//        System.err.println("elCheckWifi : " + elCheckWifi);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_DEPOSIT_PROSPECT_PAGE3).click();
//        Thread.sleep(3000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_DEPOSIT_PROSPECT_PAGE2).click();
//        ttbTestContext.findElement(OneAppElementKeys.NO_FIXED_ACCOUNT).click();
//        ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_PAGE1).click();
//        Thread.sleep(3000);
//        ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_PAGE2).click();
//        Thread.sleep(3000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_DEPOSIT_PROSPECT_PAGE3).click();
//        Thread.sleep(3000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_DEPOSIT_PROSPECT_PAGE2).click();
//        Thread.sleep(3000);
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_DEPOSIT_PROSPECT_PAGE1).click();
    }

    public void testcase06() throws InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
//        Thread.sleep(5000);
//        (new WebDriverWait(ttbTestContext.getDriver(), 40)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cs_apply_card_label_id\"]")));
        WebElement CARD_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.CARD_SERVICE_BUTTON);
        CARD_SERVICE_BUTTON.click();
        WebElement TitleCard = ttbTestContext.findElement(OneAppElementKeys.TITLE_CARD_PROSPECT);
        String elTitleCard = TitleCard.getText();
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_CARD_PROSPECT);
        String elCloseBtn = CloseBtn.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        System.err.println("elTitleCard : " + elTitleCard);
        System.err.println("elCloseBtn : " + elCloseBtn);
        CloseBtn.click();
//        ttbTestContext.findElement(OneAppElementKeys.CARD_SERVICE_BUTTON).click();
//        Thread.sleep(5000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_CARD_PROSPECT).click();
    }

    public void testcase07() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement INVESTMENT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.INVESTMENT_SERVICE_BUTTON);
        INVESTMENT_SERVICE_BUTTON.click();
        WebElement TitleInvestment = ttbTestContext.findElement(OneAppElementKeys.TITLE_INVESTMENT_PROSPECT);
        String elTitleInvestment = TitleInvestment.getText();
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_INVESTMENT_PROSPECT);
        String elCloseBtn = CloseBtn.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        System.err.println("elTitleInvestment : " + elTitleInvestment);
        System.err.println("elCloseBtn : " + elCloseBtn);
        CloseBtn.click();
//        ttbTestContext.findElement(OneAppElementKeys.INVESTMENT_SERVICE_BUTTON).click();
//        Thread.sleep(5000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_INVESTMENT_PROSPECT).click();
    }

    public void testcase08() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement INVESTMENT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PERSONAL_LOAN_SERVICE_BUTTON);
        INVESTMENT_SERVICE_BUTTON.click();
        Thread.sleep(3000);
        WebElement TitlePersonalLoan = ttbTestContext.findElement(OneAppElementKeys.TITLE_PERSONAL_LOAN_PROSPECT);
        String elTitlePersonalLoan = TitlePersonalLoan.getText();
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_PERSONAL_LOAN_PROSPECT);
        String elCloseBtn = CloseBtn.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        System.err.println("elTitlePersonalLoan : " + elTitlePersonalLoan);
        System.err.println("elCloseBtn : " + elCloseBtn);
        CloseBtn.click();
//        ttbTestContext.findElement(OneAppElementKeys.PERSONAL_LOAN_SERVICE_BUTTON).click();
//        Thread.sleep(5000);
//        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_PERSONAL_LOAN_PROSPECT).click();
    }

    public void testcase09() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement AUTO_LOAN_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.AUTO_LOAN_SERVICE_BUTTON);
        AUTO_LOAN_SERVICE_BUTTON.click();
        Thread.sleep(3000);
        WebElement TitleAutoLoan = ttbTestContext.findElement(OneAppElementKeys.TITLE_AUTO_LOAN_PROSPECT);
        String elTitleAutoLoan = TitleAutoLoan.getText();
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_AUTO_LOAN_PROSPECT);
        String elCloseBtn = CloseBtn.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        System.err.println("elTitlePersonalLoan : " + elTitleAutoLoan);
        System.err.println("elCloseBtn : " + elCloseBtn);
        CloseBtn.click();
    }

    public void testcase10() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement INSURANCE_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.INSURANCE_SERVICE_BUTTON);
        INSURANCE_SERVICE_BUTTON.click();
        Thread.sleep(3000);
        WebElement TitleInsurance = ttbTestContext.findElement(OneAppElementKeys.TITLE_INSURANCE_PROSPECT);
        String elTitleInsurance = TitleInsurance.getText();
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_INSURANCE_PROSPECT);
        String elCloseBtn = CloseBtn.getText();
        WebElement ApplyBtn = ttbTestContext.findElement(OneAppElementKeys.APPLY_BUTTON_INSURANCE);
        String elApplyBtn = ApplyBtn.getText();
        String url = ttbTestContext.getDriver().getCurrentUrl();
        System.err.println("url = " + url);
        System.err.println("elTitleInsurance : " + elTitleInsurance);
        System.err.println("elCloseBtn : " + elCloseBtn);
        System.err.println("elApplyBtn : " + elApplyBtn);
        CloseBtn.click();
        ttbTestContext.findElement(OneAppElementKeys.INSURANCE_SERVICE_BUTTON).click();
        Thread.sleep(5000);
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_INSURANCE_PROSPECT).click();
        ttbTestContext.findElement(OneAppElementKeys.INSURANCE_SERVICE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.APPLY_BUTTON_INSURANCE).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.APPLY_BUTTON_INSURANCE, true);
        ttbTestContext.findElement(OneAppElementKeys.APPLY_BUTTON_INSURANCE).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtnBottomSheet = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtnBottomSheet.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase11() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.INSURANCE_SERVICE_BUTTON, true);
        WebElement TAB_STATUS_TRACKING = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TAB_STATUS_TRACKING.click();
        TAB_STATUS_TRACKING.click();
        Thread.sleep(5000);
        WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        STATUS_TRACKING_SERVICE_BUTTON.click();
        STATUS_TRACKING_SERVICE_BUTTON.click();
        WebElement startBtn = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING);
        startBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING, true);
        ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase12() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.APPLICATION_TRACKING_SERVICE_BUTTON, true);
        WebElement APPLICATION_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_SERVICE_BUTTON);
        APPLICATION_TRACKING_SERVICE_BUTTON.click();
        WebElement startBtn = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_APP_TRACKING);
        startBtn.click();
        WebElement TitleAppTrackingProspect = ttbTestContext.findElement(OneAppElementKeys.TITLE_INPUT_DATA_SCREEN_APP_TRACKING_PROSPECT);
        String elTitleAppTrackingProspect = TitleAppTrackingProspect.getText();
        WebElement LabelInformation = ttbTestContext.findElement(OneAppElementKeys.LABEL_INFORMATION);
        String elLabelInformation = LabelInformation.getText();
        WebElement LabelCID = ttbTestContext.findElement(OneAppElementKeys.LABEL_CID_APP_TRACKING_PROSPECT);
        String elLabelCID = LabelCID.getText();
        WebElement LabelWithoutSpace = ttbTestContext.findElement(OneAppElementKeys.LABEL_WITHOUT_SPACE);
        String elLabelWithoutSpace = LabelWithoutSpace.getText();
        WebElement LabelMobileNo = ttbTestContext.findElement(OneAppElementKeys.LABEL_MOBILE_NO);
        String elLabelMobileNo = LabelMobileNo.getText();
        WebElement LabelConditionInputMobileNo = ttbTestContext.findElement(OneAppElementKeys.LABEL_CONDITION_INPUT_MOBILE_NO);
        String elLabelConditionInputMobileNo = LabelConditionInputMobileNo.getText();
        WebElement BackBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_INPUT_DATA_SCREEN_APP_TRACKING_PROSPECT);
        BackBtn.click();
        System.err.println("elTitleAppTrackingProspect : " + elTitleAppTrackingProspect);
        System.err.println("elLabelInformation : " + elLabelInformation);
        System.err.println("elLabelCID : " + elLabelCID);
        System.err.println("elLabelWithoutSpace : " + elLabelWithoutSpace);
        System.err.println("elLabelMobileNo : " + elLabelMobileNo);
        System.err.println("elLabelConditionInputMobileNo : " + elLabelConditionInputMobileNo);
    }

    public void testcase13() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        TAB_OTHER_SERVICE.click();
        WebElement PROMPT_PAY_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON);
        PROMPT_PAY_SERVICE_BUTTON.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON, true);
        ttbTestContext.findElement(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase14(){
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.PROMPT_PAY_SERVICE_BUTTON, true);
        WebElement NDID_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        NDID_SERVICE_BUTTON.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.NDID_SERVICE_BUTTON, true);
        ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }

    public void testcase15() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.PERSONAL_INFORMATION_SERVICE_BUTTON, true);
        WebElement PERSONAL_INFORMATION_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.PERSONAL_INFORMATION_SERVICE_BUTTON);
        PERSONAL_INFORMATION_SERVICE_BUTTON.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement BottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_TITLE);
        String elBottomSheetTitle = BottomSheetTitle.getText();
        WebElement BottomSheetBody = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_BODY);
        String elBottomSheetBody = BottomSheetBody.getText();
        WebElement RegisterBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_REGISTER_BUTTON);
        String elRegisterBtn = RegisterBtn.getText();
        RegisterBtn.click();
        WebElement TitleRegisterTTB = ttbTestContext.findElement(OneAppElementKeys.TITLE_REGISTER_TTB);
        String elTitleRegisterTTB = TitleRegisterTTB.getText();
        WebElement backBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_REGISTER_BUTTON);
        backBtn.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.PERSONAL_INFORMATION_SERVICE_BUTTON, true);
        ttbTestContext.findElement(OneAppElementKeys.PERSONAL_INFORMATION_SERVICE_BUTTON).click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.BOTTOM_SHEET_TITLE, false);
        WebElement CloseBtn = ttbTestContext.findElement(OneAppElementKeys.BOTTOM_SHEET_CLOSE_BUTTON);
        CloseBtn.click();
        System.err.println("elBottomSheetTitle : " + elBottomSheetTitle);
        System.err.println("elBottomSheetBody : " + elBottomSheetBody);
        System.err.println("elRegisterBtn : " + elRegisterBtn);
        System.err.println("elTitleRegisterTTB : " + elTitleRegisterTTB);
    }
}
