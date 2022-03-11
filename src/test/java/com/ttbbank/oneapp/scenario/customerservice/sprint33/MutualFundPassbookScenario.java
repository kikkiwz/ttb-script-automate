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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;
import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResultsReport;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatPortFolio;

public class MutualFundPassbookScenario extends BaseScenario {
    TmbServiceResponse<ViewPassbookResponse> response = null;
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service Passbook", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        scenario = getFeature().createNode(Scenario.class, "Mutual Fund");
        String ServiceScreen = "images/MutualFundPassbook_ServiceScreen" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ServiceScreen);
        scenario.createNode(Given.class, "Service Screen").addScreenCaptureFromPath(ServiceScreen).pass("Pass");

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
        try{
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

            String tutorial = "images/MutualFundPassbook_TutorialPassBook_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "When customer first time usage. The system navigate to Tutorial Passbook Screen").addScreenCaptureFromPath(tutorial), result);

            btnStart.click();

            Assert.assertTrue(elTitleTutorial.equals("Passbook Cover"));
            Assert.assertTrue(elTutorialDetail.equals("Convenient any transactions with your passbook cover right on your smartphone."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        }catch (Exception e){
            String tutorial = "images/MutualFundPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to select account mutual screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-account-list-header-label']")));
        WebElement TitlePassBook = ttbTestContext.findElement(OneAppElementKeys.TITLE_PASSBOOK_SELECT_ACCOUNT_SCREEN);
        String elTitlePassBook = TitlePassBook.getText();
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_MUTUAL_FUND_SELECT_ACCOUNT_SCREEN, true);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mutual_fund_passbook_account_list_title_label']")));
        WebElement TitleMutualFund = ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL_FUND_SELECT_ACCOUNT_SCREEN);
        String elTitleMutualFund = TitleMutualFund.getText();
        WebElement MutualFund0 = ttbTestContext.findElement(OneAppElementKeys.PORT_NAME_1_PASSBOOK);
        String elMutualFund0 = MutualFund0.getText();
        WebElement MutualFundCode0 = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_1_PASSBOOK);
        String elMutualFundCode0 = MutualFundCode0.getText();
        WebElement MutualFund1 = ttbTestContext.findElement(OneAppElementKeys.PORT_NAME_2_PASSBOOK);
        String elMutualFund1 = MutualFund1.getText();
        WebElement MutualFundCode1 = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_2_PASSBOOK);
        String elMutualFundCode1 = MutualFundCode1.getText();
        WebElement MutualFund2 = ttbTestContext.findElement(OneAppElementKeys.PORT_NAME_3_PASSBOOK);
        String elMutualFund2 = MutualFund2.getText();
        WebElement MutualFundCode2 = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_3_PASSBOOK);
        String elMutualFundCode2 = MutualFundCode2.getText();
        WebElement MutualFund3 = ttbTestContext.findElement(OneAppElementKeys.PORT_NAME_4_PASSBOOK);
        String elMutualFund3 = MutualFund3.getText();
        WebElement MutualFundCode3 = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_4_PASSBOOK);
        String elMutualFundCode3 = MutualFundCode3.getText();
        WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        String elBtnView = BtnView.getText();

        System.err.println("elTitlePassBook : " + elTitlePassBook);
        System.err.println("elTitleMutualFund : " + elTitleMutualFund);
        System.err.println("elMutualFund0 : " + elMutualFund0);
        System.err.println("elMutualFundCode0 : " + elMutualFundCode0);
        System.err.println("elMutualFund1 : " + elMutualFund1);
        System.err.println("elMutualFundCode1 : " + elMutualFundCode1);
        System.err.println("elMutualFund2 : " + elMutualFund2);
        System.err.println("elMutualFundCode2 : " + elMutualFundCode2);
        System.err.println("elMutualFund3 : " + elMutualFund3);
        System.err.println("elMutualFundCode3 : " + elMutualFundCode3);
        System.err.println("elBtnView : " + elBtnView);

        String fundName1 = (response.getData().mutual_fund_details.get(0).account_nickname.equals("")) ? "-" : response.getData().mutual_fund_details.get(0).account_nickname;
        String fundName2 = (response.getData().mutual_fund_details.get(1).account_nickname.equals("")) ? "-" : response.getData().mutual_fund_details.get(1).account_nickname;
        String fundName3 = (response.getData().mutual_fund_details.get(2).account_nickname.equals("")) ? "-" : response.getData().mutual_fund_details.get(2).account_nickname;
        String fundName4 = (response.getData().mutual_fund_details.get(3).account_nickname.equals("")) ? "-" : response.getData().mutual_fund_details.get(3).account_nickname;
        System.err.println("fundName1 : " + fundName1);
        System.err.println("fundName2 : " + fundName2);
        System.err.println("fundName3 : " + fundName3);
        System.err.println("fundName4 : " + fundName4);

        String result = "";
        result = CheckResults(elTitlePassBook, "Passbook Cover", result);
        result = CheckResults(elTitleMutualFund, "Investment Account", result);
        result = CheckResults(elMutualFund0, fundName1, result);
        result = CheckResults(elMutualFundCode0, response.getData().mutual_fund_details.get(0).portfolio_number, result);
        result = CheckResults(elMutualFund1, fundName2, result);
        result = CheckResults(elMutualFundCode1, response.getData().mutual_fund_details.get(1).portfolio_number, result);
        result = CheckResults(elMutualFund2, fundName3, result);
        result = CheckResults(elMutualFundCode2, response.getData().mutual_fund_details.get(2).portfolio_number, result);
        result = CheckResults(elMutualFund3, fundName4, result);
        result = CheckResults(elMutualFundCode3, response.getData().mutual_fund_details.get(3).portfolio_number, result);
        result = CheckResults(elBtnView, "Next", result);

        String MutualFundList = "images/MutualFundPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundList);
        CheckResultsReport(scenario.createNode(Given.class, "Select Mutual Fund list Screen. The system should display all of Mutual Fund sorted by Portfolio Code in ascending order.").addScreenCaptureFromPath(MutualFundList), result);

        MutualFund0.click();
        BtnView.click();

        Assert.assertTrue(elTitlePassBook.equals("Passbook Cover"));
        Assert.assertTrue(elTitleMutualFund.equals("Investment Account"));
        Assert.assertTrue(elMutualFund0.equals(fundName1));
        Assert.assertTrue(elMutualFundCode0.equals(response.getData().mutual_fund_details.get(0).portfolio_number));
        Assert.assertTrue(elMutualFund1.equals(fundName2));
        Assert.assertTrue(elMutualFundCode1.equals(response.getData().mutual_fund_details.get(1).portfolio_number));
        Assert.assertTrue(elMutualFund2.equals(fundName3));
        Assert.assertTrue(elMutualFundCode2.equals(response.getData().mutual_fund_details.get(2).portfolio_number));
        Assert.assertTrue(elMutualFund3.equals(fundName4));
        Assert.assertTrue(elMutualFundCode3.equals(response.getData().mutual_fund_details.get(3).portfolio_number));
        Assert.assertTrue(elBtnView.equals("Next"));
    }

    @Test(priority = 1, groups = "Customer Service Mutual Fund list")
    public void TC_ONEAPP_10581_PBFundList_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-account-list-header-label']")));
        WebElement MutualFundPassbook = ttbTestContext.findElement(OneAppElementKeys.TITLE_SELECT_MUTUAL_FUND_LIST);
        String elMutualFundPassbook = MutualFundPassbook.getText();
        WebElement selectFund = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_NAME_SELECT_MUTUAL_FUND_LIST);
        String elSelectFund = selectFund.getText();
        WebElement PortfolioCode = ttbTestContext.findElement(OneAppElementKeys.PORTFOLIO_CODE_SELECT_MUTUAL_FUND_LIST);
        String elPortfolioCode = PortfolioCode.getText();
        WebElement MutualFund0 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_1);
        String elMutualFund0 = MutualFund0.getText();
        WebElement MutualFundName0 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_1);
        String elMutualFundName0 = MutualFundName0.getText();
        WebElement MutualFund1 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_2);
        String elMutualFund1 = MutualFund1.getText();
        WebElement MutualFundName1 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_2);
        String elMutualFundName1 = MutualFundName1.getText();
        WebElement MutualFund2 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_3);
        String elMutualFund2 = MutualFund2.getText();
        WebElement MutualFundName2 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_3);
        String elMutualFundName2 = MutualFundName2.getText();
        WebElement MutualFund3 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_4);
        String elMutualFund3 = MutualFund3.getText();
        WebElement MutualFundName3 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_4);
        String elMutualFundName3 = MutualFundName3.getText();
        WebElement MutualFund4 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_5);
        String elMutualFund4 = MutualFund4.getText();
        WebElement MutualFundName4 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_5);
        String elMutualFundName4 = MutualFundName4.getText();
        WebElement MutualFund5 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_6);
        String elMutualFund5 = MutualFund5.getText();
        WebElement MutualFundName5 = ttbTestContext.findElement(OneAppElementKeys.FUND_DESCRIPTION_6);
        String elMutualFundName5 = MutualFundName5.getText();
        WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        String elBtnView = BtnView.getText();

        String[] arrFundName1 = {elMutualFund0, elMutualFund1, elMutualFund2, elMutualFund3, elMutualFund4, elMutualFund5};
        ArrayList<String> arrFundName = new ArrayList<String>();
        arrFundName.add(elMutualFund0);
        arrFundName.add(elMutualFund1);
        arrFundName.add(elMutualFund2);
        arrFundName.add(elMutualFund3);
        arrFundName.add(elMutualFund4);
        arrFundName.add(elMutualFund5);
        Collections.sort(arrFundName);

        System.err.println("elMutualFundPassbook : " + elMutualFundPassbook);
        System.err.println("elSelectFund : " + elSelectFund);
        System.err.println("elPortfolioCode : " + elPortfolioCode);
        System.err.println("elMutualFund0 : " + elMutualFund0);
        System.err.println("elMutualFundName0 : " + elMutualFundName0);
        System.err.println("elMutualFund1 : " + elMutualFund1);
        System.err.println("elMutualFundName1 : " + elMutualFundName1);
        System.err.println("elMutualFund2 : " + elMutualFund2);
        System.err.println("elMutualFundName2 : " + elMutualFundName2);
        System.err.println("elMutualFund3 : " + elMutualFund3);
        System.err.println("elMutualFundName3 : " + elMutualFundName3);
        System.err.println("elMutualFund4 : " + elMutualFund4);
        System.err.println("elMutualFundName4 : " + elMutualFundName4);
        System.err.println("elMutualFund5 : " + elMutualFund5);
        System.err.println("elMutualFundName5 : " + elMutualFundName5);
        System.err.println("elBtnView : " + elBtnView);

        String result = "";
        String fundName1 = (response.getData().mutual_fund_details.get(0).account_nickname.equals("")) ? "-" : response.getData().mutual_fund_details.get(0).account_nickname;
        result = CheckResults(elSelectFund, "Please Select a Fund " + fundName1, result);
        result = CheckResults(elPortfolioCode, "Investment account " + response.getData().mutual_fund_details.get(0).portfolio_number, result);
        result = CheckResults(elMutualFund0, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_code, result);
        result = CheckResults(elMutualFundName0, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_name_en, result);
        result = CheckResults(elMutualFund1, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(1).fund_code, result);
        result = CheckResults(elMutualFundName1, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(1).fund_name_en, result);
        result = CheckResults(elMutualFund2, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(2).fund_code, result);
        result = CheckResults(elMutualFundName2, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(2).fund_name_en, result);
        result = CheckResults(elMutualFund3, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(3).fund_code, result);
        result = CheckResults(elMutualFundName3, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(3).fund_name_en, result);
        result = CheckResults(elMutualFund4, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(4).fund_code, result);
        result = CheckResults(elMutualFundName4, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(4).fund_name_en, result);
        result = CheckResults(elMutualFund5, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(5).fund_code, result);
        result = CheckResults(elMutualFundName5, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(5).fund_name_en, result);
        result = CheckResults(elBtnView, "Next", result);
        //Check sorting
        for(int i = 0; i < arrFundName.size(); i++){
            result = CheckResults(arrFundName1[i], arrFundName.get(i), result);
        }

        String MutualFundList = "images/MutualFundPassbook_FundListBeforeSelect_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundList);
        CheckResultsReport(scenario.createNode(Given.class, "Select Mutual Fund list Screen. Before select fund, The system display next button disable").addScreenCaptureFromPath(MutualFundList), result);

        MutualFund0.click();

        String FundListAfterSelect = "images/MutualFundPassbook_FundListAfterSelect_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(FundListAfterSelect);
        CheckResultsReport(scenario.createNode(Given.class, "Select Mutual Fund list Screen. After select fund, The system should be display next button enable").addScreenCaptureFromPath(FundListAfterSelect), result);
        BtnView.click();

//        Assert.assertTrue(elMutualFundPassbook.equals("Mutual Fund Passbook"));
        Assert.assertTrue(elSelectFund.equals("Please Select a Fund " + fundName1));
        Assert.assertTrue(elPortfolioCode.equals("Investment account " + response.getData().mutual_fund_details.get(0).portfolio_number));
        Assert.assertTrue(elMutualFund0.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_code));
        Assert.assertTrue(elMutualFundName0.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_name_en));
        Assert.assertTrue(elMutualFund1.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(1).fund_code));
        Assert.assertTrue(elMutualFundName1.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(1).fund_name_en));
        Assert.assertTrue(elMutualFund2.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(2).fund_code));
        Assert.assertTrue(elMutualFundName2.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(2).fund_name_en));
        Assert.assertTrue(elMutualFund3.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(3).fund_code));
        Assert.assertTrue(elMutualFundName3.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(3).fund_name_en));
        Assert.assertTrue(elMutualFund4.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(4).fund_code));
        Assert.assertTrue(elMutualFundName4.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(4).fund_name_en));
        Assert.assertTrue(elMutualFund5.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(5).fund_code));
        Assert.assertTrue(elMutualFundName5.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(5).fund_name_en));
        Assert.assertTrue(elBtnView.equals("Next"));
        //Check sorting
        for(int i = 0; i < arrFundName.size(); i++){
            Assert.assertTrue(arrFundName1[i].equals(arrFundName.get(i)));
        }
    }

    @Test(priority = 2, groups = "Customer Service Mutual Fund Passbook")
    public void TC_ONEAPP_10582_PBMF_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement MutualFundPassbook = ttbTestContext.findElement(OneAppElementKeys.TITLE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elMutualFundPassbook = MutualFundPassbook.getText();
        WebElement labelNameOfUnitholdersTh = ttbTestContext.findElement(OneAppElementKeys.LABEL_UNITHOLDER_NAME_TH);
        String elLabelNameOfUnitholdersTh = labelNameOfUnitholdersTh.getText();
        WebElement labelNameOfUnitholdersEn = ttbTestContext.findElement(OneAppElementKeys.LABEL_UNITHOLDER_NAME_EN);
        String elLabelNameOfUnitholdersEn = labelNameOfUnitholdersEn.getText();
        WebElement labelMutualFundNameTh = ttbTestContext.findElement(OneAppElementKeys.LABEL_FUND_NAME_TH_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elLabelMutualFundNameTh = labelMutualFundNameTh.getText();
        WebElement labelMutualFundNameEn = ttbTestContext.findElement(OneAppElementKeys.LABEL_FUND_NAME_EN_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elLabelMutualFundNameEn = labelMutualFundNameEn.getText();
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
        WebElement FundNameValue = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_VALUE_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elFundNameValue = FundNameValue.getText();
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
        WebElement BtnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);

        System.err.println("elMutualFundPassbook : " + elMutualFundPassbook);
        System.err.println("elLabelNameOfUnitholdersTh : " + elLabelNameOfUnitholdersTh);
        System.err.println("elLabelNameOfUnitholdersEn : " + elLabelNameOfUnitholdersEn);
        System.err.println("elLabelMutualFundNameTh : " + elLabelMutualFundNameTh);
        System.err.println("elLabelMutualFundNameEn : " + elLabelMutualFundNameEn);
        System.err.println("elLabelPortCodeTh : " + elLabelPortCodeTh);
        System.err.println("elLabelPortCodeEn : " + elLabelPortCodeEn);
        System.err.println("elOfficeAndBranchTh : " + elOfficeAndBranchTh);
        System.err.println("elOfficeAndBranchEn : " + elOfficeAndBranchEn);
        System.err.println("elRemark : " + elRemark);
        System.err.println("elRemarkDetail : " + elRemarkDetail);
        System.err.println("elUnitholderNameValue : " + elUnitholderNameValue);
        System.err.println("elFundNameValue : " + elFundNameValue);
        System.err.println("elPortfolioCodeValue : " + elPortfolioCodeValue);
        System.err.println("elOfficeBranchValue : " + elOfficeBranchValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elMutualFundPassbook, "Mutual Fund Passbook Cover", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อผู้ถือหน่วยลงทุน", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Unitholder Name", result);
        result = CheckResults(elLabelMutualFundNameTh, "ชื่อกองทุน", result);
        result = CheckResults(elLabelMutualFundNameEn, "Fund Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชีลงทุน", result);
        result = CheckResults(elLabelPortCodeEn, "Portfolio Code", result);
        result = CheckResults(elOfficeAndBranchTh, "สำนักงาน / สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Office / Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีกองทุนแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงชื่อผู้ถือหน่วยลงทุน ชื่อกองทุน เลขที่บัญชีลงทุน และสาขา หรือช่องทางที่เปิดบัญชีกองทุน จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, "NAME TEST", result);
        result = CheckResults(elFundNameValue, response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_name_en, result);
        System.err.println("formatPortFolio : " + formatPortFolio(response.getData().mutual_fund_details.get(0).portfolio_number));
        result = CheckResults(elPortfolioCodeValue, formatPortFolio(response.getData().mutual_fund_details.get(0).portfolio_number), result);
        result = CheckResults(elOfficeBranchValue, "มวกเหล็ก", result);
        result = CheckResults(elBtnSave, "Save File", result);
        result = CheckResults(elBtnShare, "Share File", result);

        String MutualFundPassbook_MutualFundPassbook = "images/MutualFundPassbook_MutualFundPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbook_MutualFundPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "Mutual Fund Passbook Screen").addScreenCaptureFromPath(MutualFundPassbook_MutualFundPassbook), result);

        Assert.assertTrue(elMutualFundPassbook.equals("Mutual Fund Passbook Cover"));
        Assert.assertTrue(elLabelNameOfUnitholdersTh.equals("ชื่อผู้ถือหน่วยลงทุน"));
        Assert.assertTrue(elLabelNameOfUnitholdersEn.equals("Unitholder Name"));
        Assert.assertTrue(elLabelMutualFundNameTh.equals("ชื่อกองทุน"));
        Assert.assertTrue(elLabelMutualFundNameEn.equals("Fund Name"));
        Assert.assertTrue(elLabelPortCodeTh.equals("เลขที่บัญชีลงทุน"));
        Assert.assertTrue(elLabelPortCodeEn.equals("Portfolio Code"));
        Assert.assertTrue(elOfficeAndBranchTh.equals("สำนักงาน / สาขา"));
        Assert.assertTrue(elOfficeAndBranchEn.equals("Office / Branch"));
        Assert.assertTrue(elRemark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("- หน้าสมุดบัญชีกองทุนแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงชื่อผู้ถือหน่วยลงทุน ชื่อกองทุน เลขที่บัญชีลงทุน และสาขา หรือช่องทางที่เปิดบัญชีกองทุน จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals("NAME TEST"));
        Assert.assertTrue(elFundNameValue.equals(response.getData().mutual_fund_details.get(0).mutual_fund_details.get(0).fund_name_en));
        System.err.println("formatPortFolio : " + formatPortFolio(response.getData().mutual_fund_details.get(0).portfolio_number));
        Assert.assertTrue(elPortfolioCodeValue.equals(formatPortFolio(response.getData().mutual_fund_details.get(0).portfolio_number)));
        Assert.assertTrue(elOfficeBranchValue.equals("มวกเหล็ก"));
        Assert.assertTrue(elBtnSave.equals("Save File"));
        Assert.assertTrue(elBtnShare.equals("Share File"));

        BtnBack.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-header-label']")));
//        childReport.log(Status.INFO, "<pre>if the customer press on Back icon, navigate to the previous screen.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
    }

    @Test(priority = 3, groups = "Customer Service Save And Share")
    public void TC_ONEAPP_10582_PBMF_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();

        String MutualFundPassbookClickBack = "images/MutualFundPassbook_MutualFundPassbookClickBack_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookClickBack);
        scenario.createNode(Given.class, "When customer click Back button, the system navigate to fund list screen").addScreenCaptureFromPath(MutualFundPassbookClickBack).pass("Pass");
        WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        WebElement MutualFund0 = ttbTestContext.findElement(OneAppElementKeys.FUND_NAME_1);
        MutualFund0.click();
        BtnView.click();

        String MutualFundPassbookAgain = "images/MutualFundPassbook_MutualFundPassbookAgain_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookAgain);
        scenario.createNode(Given.class, "Mutual Fund Passbook Screen").addScreenCaptureFromPath(MutualFundPassbookAgain).pass("Pass");

        ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN).click();
        String TitlePopupSave = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_SAVE_SHARE_MUTUAL_FUND_PASSBOOK_SCREEN).getText();
        String labelPdfSave = ttbTestContext.findElement(OneAppElementKeys.PDF_POPUP_SAVE_SHARE).getText();
        String labelImageSave = ttbTestContext.findElement(OneAppElementKeys.IMAGE_POPUP_SAVE_SHARE).getText();

        String result = "";
        result = CheckResults(TitlePopupSave, "Select file type to save", result);
        result = CheckResults(labelPdfSave, "PDF", result);
        result = CheckResults(labelImageSave, "Image", result);

        String MutualFundPassbookClickSave = "images/MutualFundPassbook_MutualFundPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookClickSave);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup save").addScreenCaptureFromPath(MutualFundPassbookClickSave), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String MutualFundPassbookClickXPopup = "images/MutualFundPassbook_ClickXPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookClickXPopup);
        scenario.createNode(Given.class, "When customer click X, The system close popup save").addScreenCaptureFromPath(MutualFundPassbookClickXPopup).pass("Pass");

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

        String MutualFundPassbookClickShare = "images/MutualFundPassbook_MutualFundPassbookPopupShare_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookClickShare);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup share").addScreenCaptureFromPath(MutualFundPassbookClickShare), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String MutualFundPassbookClickXPopupShare = "images/MutualFundPassbook_ClickXPopupShare_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundPassbookClickXPopupShare);
        scenario.createNode(Given.class, "When customer click X, The system close popup share").addScreenCaptureFromPath(MutualFundPassbookClickXPopupShare).pass("Pass");
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

    @Test(priority = 4, groups = "Customer Service Back to service page")
    public void TC_ONEAPP_10584_PBMF_00001() throws Exception {
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        BtnBackToMainMenu.click();
        WebElement Passbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        String elPassbook = Passbook.getText();

        String result = "";
        result = CheckResults(elPassbook, "Passbook Cover", result);

        String BackToService = "images/MutualFundPassbook_BackToService_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(BackToService);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Back To Service Page button, The system navigate to service screen").addScreenCaptureFromPath(BackToService), result);
        getExtent().flush();
    }
}
