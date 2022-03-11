package com.ttbbank.oneapp.scenario.customerservice.sprint33;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.ViewPassbookResponse;
import com.ttbbank.oneapp.framework.model.customerservice.accountSaving.SavingResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;
import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResultsReport;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatAccount;

public class VirtualPassbookOneAccountScenario extends BaseScenario {
    TmbServiceResponse<ViewPassbookResponse> response = null;
    TmbServiceResponse<SavingResponse> responseSaving = null;
    ExtentTest scenario = null;

    @Test(priority = 0, groups = "Customer Service Passbook", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Virtual Passbook in case one account");
        String MutualFundList = "images/VirtualPassbookOneAccount_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundList);
        scenario.createNode(Given.class, "Service Screen").addScreenCaptureFromPath(MutualFundList).pass("Pass");

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
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("service_type_id", "EPB");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==");
        response = client.get("/apis/customer/viewVirtualPassbook", eqParams, ViewPassbookResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        WebElement virtualPassbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        virtualPassbook.click();
        try {
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elTitleTutorial = titleTutorial.getText();
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.TUTORIAL_DETAIL_SCREEN_VIRTUAL_PASSBOOK);
            String elTutorialDetail = tutorialDetail.getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elBtnStart = btnStart.getText();

            String result = "";
            result = CheckResults(elTitleTutorial, "Passbook Cover", result);
            result = CheckResults(elTutorialDetail, "Convenient any transactions with your passbook cover right on your smartphone.", result);
            result = CheckResults(elBtnStart, "Start", result);

            System.out.println("elTitleTutorial : " + elTitleTutorial);
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            System.out.println("elBtnStart : " + elBtnStart);
            Thread.sleep(5000);
            String tutorial = "images/VirtualPassbookOneAccount_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "If the customer has first time usage, The system navigate to tutorial Passbook Screen").addScreenCaptureFromPath(tutorial), result);
            btnStart.click();

            Assert.assertTrue(elTitleTutorial.equals("Passbook Cover"));
            Assert.assertTrue(elTutorialDetail.equals("Convenient any transactions with your passbook cover right on your smartphone."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        } catch (Exception e){
            String tutorial = "images/VirtualPassbookOneAccount_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already first time usage, The system navigate to select the account screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }
    }

    @Test(priority = 3, groups = "Customer Service Virtual Passbook")
    public void TC_ONEAPP_10582_PBMF_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement VirtualPassbook = ttbTestContext.findElement(OneAppElementKeys.TITLE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elVirtualPassbook = VirtualPassbook.getText();
        WebElement labelNameOfUnitholdersTh = ttbTestContext.findElement(OneAppElementKeys.LABEL_UNITHOLDER_NAME_TH);
        String elLabelNameOfUnitholdersTh = labelNameOfUnitholdersTh.getText();
        WebElement labelNameOfUnitholdersEn = ttbTestContext.findElement(OneAppElementKeys.LABEL_UNITHOLDER_NAME_EN);
        String elLabelNameOfUnitholdersEn = labelNameOfUnitholdersEn.getText();
        WebElement labelPortCodeTh = ttbTestContext.findElement(OneAppElementKeys.LABEL_PORTFOLIO_CODE_TH_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elLabelPortCodeTh = labelPortCodeTh.getText();
        WebElement labelPortCodeEn = ttbTestContext.findElement(OneAppElementKeys.LABEL_PORTFOLIO_CODE_EN_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elLabelPortCodeEn = labelPortCodeEn.getText();
        WebElement OfficeAndBranchTh = ttbTestContext.findElement(OneAppElementKeys.LABEL_BRANCH_TH_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elOfficeAndBranchTh = OfficeAndBranchTh.getText();
        WebElement OfficeAndBranchEn = ttbTestContext.findElement(OneAppElementKeys.LABEL_BRANCH_EN_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elOfficeAndBranchEn = OfficeAndBranchEn.getText();
        WebElement remark = ttbTestContext.findElement(OneAppElementKeys.LABEL_REMARK_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elRemark = remark.getText();
        WebElement remarkDetail = ttbTestContext.findElement(OneAppElementKeys.REMARK_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elRemarkDetail = remarkDetail.getText();
        WebElement UnitholderNameValue = ttbTestContext.findElement(OneAppElementKeys.UNITHOLDER_NAME_VALUE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elUnitholderNameValue = UnitholderNameValue.getText();
        WebElement PortfolioCodeValue = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_VALUE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elPortfolioCodeValue = PortfolioCodeValue.getText();
        WebElement OfficeBranchValue = ttbTestContext.findElement(OneAppElementKeys.BRANCH_VALUE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elOfficeBranchValue = OfficeBranchValue.getText();
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnShare = BtnShare.getText();

        System.err.println("elVirtualPassbook : " + elVirtualPassbook);
        System.err.println("elLabelNameOfUnitholdersTh : " + elLabelNameOfUnitholdersTh);
        System.err.println("elLabelNameOfUnitholdersEn : " + elLabelNameOfUnitholdersEn);
        System.err.println("elLabelPortCodeTh : " + elLabelPortCodeTh);
        System.err.println("elLabelPortCodeEn : " + elLabelPortCodeEn);
        System.err.println("elOfficeAndBranchTh : " + elOfficeAndBranchTh);
        System.err.println("elOfficeAndBranchEn : " + elOfficeAndBranchEn);
        System.err.println("elRemark : " + elRemark);
        System.err.println("elRemarkDetail : " + elRemarkDetail);
        System.err.println("elUnitholderNameValue : " + elUnitholderNameValue);
        System.err.println("elPortfolioCodeValue : " + elPortfolioCodeValue);
        System.err.println("elOfficeBranchValue : " + elOfficeBranchValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elVirtualPassbook, "Passbook Cover", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Account Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชี", result);
        result = CheckResults(elLabelPortCodeEn, "Account No.", result);
        result = CheckResults(elOfficeAndBranchTh, "สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, response.getData().virtual_passbook_details.get(0).account_name, result);
        System.err.println("formatPortFolio : " + formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "###-#-#####-#"));
        result = CheckResults(elPortfolioCodeValue, formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "###-#-#####-#"), result);
        result = CheckResults(elOfficeBranchValue, response.getData().virtual_passbook_details.get(0).branch_name_th, result);
        result = CheckResults(elBtnSave, "Save File", result);
        result = CheckResults(elBtnShare, "Share File", result);

        String ViewVirtualPassbook = "images/VirtualPassbook_VirtualPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ViewVirtualPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "If customer has one account, the system navigate to view virtual passbook screen without going through select account screen.").addScreenCaptureFromPath(ViewVirtualPassbook), result);

        Assert.assertTrue(elVirtualPassbook.equals("Passbook"));
        Assert.assertTrue(elLabelNameOfUnitholdersTh.equals("ชื่อบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersEn.equals("Account Name"));
        Assert.assertTrue(elLabelPortCodeTh.equals("เลขที่บัญชี"));
        Assert.assertTrue(elLabelPortCodeEn.equals("Account No."));
        Assert.assertTrue(elOfficeAndBranchTh.equals("สาขา"));
        Assert.assertTrue(elOfficeAndBranchEn.equals("Branch"));
        Assert.assertTrue(elRemark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals(response.getData().virtual_passbook_details.get(0).account_name));
        System.err.println("formatPortFolio : " + formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "###-#-#####-#"));
        Assert.assertTrue(elPortfolioCodeValue.equals(formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "###-#-#####-#")));
        Assert.assertTrue(elOfficeBranchValue.equals(response.getData().virtual_passbook_details.get(0).branch_name_th));
        Assert.assertTrue(elBtnSave.equals("Save File"));
        Assert.assertTrue(elBtnShare.equals("Share File"));
    }

    @Test(priority = 4, groups = "Customer Service Save And Share")
    public void TC_ONEAPP_10582_PBMF_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN).click();
        WebElement passbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        String elPassbook = passbook.getText();
        String result = "";
        result = CheckResults(elPassbook, "Passbook Cover", result);

        String VirtualPassbookClickBack = "images/VirtualPassbookOneAccount_VirtualPassbookClickBack_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickBack);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Back button, the system navigate to service screen").addScreenCaptureFromPath(VirtualPassbookClickBack), result);
        passbook.click();
        ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN).click();
        String TitlePopupSave = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_SAVE_SHARE_MUTUAL_FUND_PASSBOOK_SCREEN).getText();
        String labelPdfSave = ttbTestContext.findElement(OneAppElementKeys.PDF_POPUP_SAVE_SHARE).getText();
        String labelImageSave = ttbTestContext.findElement(OneAppElementKeys.IMAGE_POPUP_SAVE_SHARE).getText();

        result = "";
        result = CheckResults(TitlePopupSave, "Select file type to save", result);
        result = CheckResults(labelPdfSave, "PDF", result);
        result = CheckResults(labelImageSave, "Image", result);

        String VirtualPassbookClickSave = "images/VirtualPassbookOneAccount_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickSave);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup save").addScreenCaptureFromPath(VirtualPassbookClickSave), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String VirtualPassbookClickXPopup = "images/VirtualPassbookOneAccount_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickXPopup);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click X, The system close popup save").addScreenCaptureFromPath(VirtualPassbookClickXPopup), result);

        System.err.println("TitlePopupSave : " + TitlePopupSave);
        System.err.println("labelPdfSave : " + labelPdfSave);
        System.err.println("labelPdfShare : " + labelImageSave);

        ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN).click();
        String TitlePopupShare = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_SAVE_SHARE_MUTUAL_FUND_PASSBOOK_SCREEN).getText();
        String labelPdfShare = ttbTestContext.findElement(OneAppElementKeys.PDF_POPUP_SAVE_SHARE).getText();
        String labelImageShare = ttbTestContext.findElement(OneAppElementKeys.IMAGE_POPUP_SAVE_SHARE).getText();

        result = "";
        result = CheckResults(TitlePopupShare, "Select file type to share", result);
        result = CheckResults(labelPdfShare, "PDF", result);
        result = CheckResults(labelImageShare, "Image", result);

        String VirtualPassbookClickShare = "images/VirtualPassbookOneAccount_VirtualPassbookPopupShare_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickShare);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup share").addScreenCaptureFromPath(VirtualPassbookClickShare), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String VirtualPassbookClickXPopupShare = "images/VirtualPassbookOneAccount_VirtualPassbookPopupShare_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickXPopupShare);
        scenario.createNode(Given.class, "When customer click X, The system close popup share").addScreenCaptureFromPath(VirtualPassbookClickXPopupShare).pass("Pass");
        System.err.println("TitlePopupShare : " + TitlePopupShare);
        System.err.println("labelPdfShare : " + labelPdfShare);
        System.err.println("labelImageShare : " + labelImageShare);

        Assert.assertTrue(TitlePopupSave.equals("Select file type to save"));
        Assert.assertTrue(labelPdfSave.equals("PDF"));
        Assert.assertTrue(labelImageSave.equals("Image"));
        Assert.assertTrue(TitlePopupShare.equals("Select file type to share"));
        Assert.assertTrue(labelPdfShare.equals("PDF"));
        Assert.assertTrue(labelImageShare.equals("Image"));
    }

    @Test(priority = 5, groups = "Customer Service Back to service page")
    public void TC_ONEAPP_10584_PBMF_00001() throws Exception {
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        BtnBackToMainMenu.click();
        WebElement Passbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        String elPassbook = Passbook.getText();

        String result = "";
        result = CheckResults(elPassbook, "Passbook Cover", result);

        String VirtualPassbookClickXPopup = "images/VirtualPassbookOneAccount_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickXPopup);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click X on view virtual passbook screen, The system back to service screen").addScreenCaptureFromPath(VirtualPassbookClickXPopup), result);

        getExtent().flush();
    }
}
