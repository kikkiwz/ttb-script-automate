package com.ttbbank.oneapp.scenario.customerservice.sprint36.VirtualPassbook_TH;

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
import com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber;
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

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.*;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatAccount;

public class VirtualPassbookTH_Scenario extends BaseScenario {
    TmbServiceResponse<ViewPassbookResponse> response = null;
    TmbServiceResponse<SavingResponse> responseSaving = null;
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service Passbook", dependsOnGroups = {"Activate new flow", "Change language application", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Virtual Passbook multiple account");
        String MutualFundList = "images/VirtualPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(MutualFundList);
        scenario.createNode(Given.class, "Service screen").addScreenCaptureFromPath(MutualFundList).pass("Pass");

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
        String device_id = initToken();
        OneAppClient client = getOneAppClient();

        WebElement virtualPassbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        virtualPassbook.click();
        try{
            System.out.println("aadadadadaddadadddddddd tutorial");
            (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-tutorial-header-label']")));
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elTitleTutorial = titleTutorial.getText();
            System.out.println("elTitleTutorial : " + elTitleTutorial);
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.TUTORIAL_DETAIL_SCREEN_VIRTUAL_PASSBOOK);
            String elTutorialDetail = tutorialDetail.getText();
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elBtnStart = btnStart.getText();
            System.out.println("elBtnStart : " + elBtnStart);

            String result = "";
            result = CheckResults(elTitleTutorial, "หน้าสมุดบัญชี", result);
            result = CheckResults(elTutorialDetail, "หมดยุคสำเนากระดาษ เซฟและแชร์หน้าสมุดบัญชีจากมือถือ ไปใช้ทำธุรกรรมต่างๆ ได้ทันที", result);
            result = CheckResults(elBtnStart, "เริ่มต้นใช้งาน", result);

            Thread.sleep(5000);
            String tutorial = "images/VirtualPassbookTH_TutorialPassBook_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "When customer first time usage. The system navigate to Tutorial Passbook Screen").addScreenCaptureFromPath(tutorial), result);
            btnStart.click();

            Assert.assertTrue(elTitleTutorial.equals("หน้าสมุดบัญชี"));
            Assert.assertTrue(elTutorialDetail.equals("หมดยุคสำเนากระดาษ เซฟและแชร์หน้าสมุดบัญชีจากมือถือ ไปใช้ทำธุรกรรมต่างๆ ได้ทันที"));
            Assert.assertTrue(elBtnStart.equals("เริ่มต้นใช้งาน"));
        }catch (Exception e){
            System.out.println("no tutorial");
            String tutorial = "images/VirtualPassbook_SelectAccount_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to select account screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }

        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("service_type_id", "EPB");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", device_id);
        response = client.get("/apis/customer/viewVirtualPassbook", eqParams, ViewPassbookResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        Map<String, String> eqParamsSaving = new HashMap<>();
        eqParamsSaving.put("", "");
        responseSaving = client.get("/apis/customer/accounts/saving", eqParamsSaving, SavingResponse.class);
        System.out.println("responseSaving : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseSaving));
    }

    @Test(priority = 2, groups = "Customer Service Select account")
    public void TC_ONEAPP_10582_PB_00001() throws Exception {
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-account-list-header-label']")));
        WebElement TitlePassBook = ttbTestContext.findElement(OneAppElementKeys.TITLE_PASSBOOK_SELECT_ACCOUNT_SCREEN);
        String elTitlePassBook = TitlePassBook.getText();
        WebElement labelDepositAccount = ttbTestContext.findElement(OneAppElementKeys.LABEL_ACCOUNT_PASSBOOK);
        String elLabelDepositAccount = labelDepositAccount.getText();
        WebElement accountName1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1_PASSBOOK);
        String elAccountName1 = accountName1.getText();
        WebElement accountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1_PASSBOOK);
        String elAccountNumber1 = accountNumber1.getText().substring(0,13);
        WebElement balance1 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_1_PASSBOOK);
        String elBalance1 = balance1.getText();
        WebElement accountName2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_2_PASSBOOK);
        String elAccountName2 = accountName2.getText();
        WebElement accountNumber2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_2_PASSBOOK);
        String elAccountNumber2 = accountNumber2.getText().substring(0,13);
        WebElement balance2 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_2_PASSBOOK);
        String elBalance2 = balance2.getText();
        WebElement accountName3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3_PASSBOOK);
        String elAccountName3 = accountName3.getText();
        WebElement accountNumber3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_3_PASSBOOK);
        String elAccountNumber3 = accountNumber3.getText().substring(0,13);
        WebElement balance3 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_3_PASSBOOK);
        String elBalance3 = balance3.getText();
        WebElement accountName4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_4_PASSBOOK);
        String elAccountName4 = accountName4.getText();
        WebElement accountNumber4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_4_PASSBOOK);
        String elAccountNumber4 = accountNumber4.getText().substring(0,13);
        WebElement balance4 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_4_PASSBOOK);
        String elBalance4 = balance4.getText();
        WebElement accountName5 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_5_PASSBOOK);
        String elAccountName5 = accountName5.getText();
        WebElement accountNumber5 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_5_PASSBOOK);
        String elAccountNumber5 = accountNumber5.getText().substring(0,13);
        WebElement balance5 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_5_PASSBOOK);
        String elBalance5 = balance5.getText();
        WebElement accountName6 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_6_PASSBOOK);
        String elAccountName6 = accountName6.getText();
        WebElement accountNumber6 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_6_PASSBOOK);
        String elAccountNumber6 = accountNumber6.getText().substring(0,13);
        WebElement balance6 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_6_PASSBOOK);
        String elBalance6 = balance6.getText();
        WebElement accountName7 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_7_PASSBOOK);
        String elAccountName7 = accountName7.getText();
        WebElement accountNumber7 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_7_PASSBOOK);
        String elAccountNumber7 = accountNumber7.getText().substring(0,13);
        WebElement balance7 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_7_PASSBOOK);
        String elBalance7 = balance7.getText();
        WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        String elBtnView = BtnView.getText();

        System.err.println("elTitlePassBook : " + elTitlePassBook);
        System.err.println("elLabelDepositAccount : " + elLabelDepositAccount);
        System.err.println("elAccountName1 : " + elAccountName1);
        System.err.println("elAccountNumber1 : " + elAccountNumber1);
        System.err.println("elBalance1 : " + elBalance1);
        System.err.println("elAccountName2 : " + elAccountName2);
        System.err.println("elAccountNumber2 : " + elAccountNumber2);
        System.err.println("elBalance2 : " + elBalance2);
        System.err.println("elAccountName3 : " + elAccountName3);
        System.err.println("elAccountNumber3 : " + elAccountNumber3);
        System.err.println("elBalance3 : " + elBalance3);
        System.err.println("elAccountName4 : " + elAccountName4);
        System.err.println("elAccountNumber4 : " + elAccountNumber4);
        System.err.println("elBalance4 : " + elBalance4);
        System.err.println("elAccountName5 : " + elAccountName5);
        System.err.println("elAccountNumber5 : " + elAccountNumber5);
        System.err.println("elBalance5 : " + elBalance5);
        System.err.println("elAccountName6 : " + elAccountName6);
        System.err.println("elAccountNumber6 : " + elAccountNumber6);
        System.err.println("elBalance6 : " + elBalance6);
        System.err.println("elAccountName7 : " + elAccountName7);
        System.err.println("elAccountNumber7 : " + elAccountNumber7);
        System.err.println("elBalance7 : " + elBalance7);
        System.err.println("elBtnView : " + elBtnView);

        String fundName1 = (response.getData().virtual_passbook_details.get(0).account_nick_name == null) ? response.getData().virtual_passbook_details.get(0).product_name_th : response.getData().virtual_passbook_details.get(0).account_nick_name;
        String fundName2 = (response.getData().virtual_passbook_details.get(1).account_nick_name == null) ? response.getData().virtual_passbook_details.get(1).product_name_th : response.getData().virtual_passbook_details.get(1).account_nick_name;
        String fundName3 = (response.getData().virtual_passbook_details.get(2).account_nick_name == null) ? response.getData().virtual_passbook_details.get(2).product_name_th : response.getData().virtual_passbook_details.get(2).account_nick_name;
        String fundName4 = (response.getData().virtual_passbook_details.get(3).account_nick_name == null) ? response.getData().virtual_passbook_details.get(3).product_name_th : response.getData().virtual_passbook_details.get(3).account_nick_name;
        String fundName5 = (response.getData().virtual_passbook_details.get(4).account_nick_name == null) ? response.getData().virtual_passbook_details.get(4).product_name_th : response.getData().virtual_passbook_details.get(4).account_nick_name;
        String fundName6 = (response.getData().virtual_passbook_details.get(5).account_nick_name == null) ? response.getData().virtual_passbook_details.get(5).product_name_th : response.getData().virtual_passbook_details.get(5).account_nick_name;
        String fundName7 = (response.getData().virtual_passbook_details.get(6).account_nick_name == null) ? response.getData().virtual_passbook_details.get(6).product_name_th : response.getData().virtual_passbook_details.get(6).account_nick_name;
        String[] arrAccountNumber = {elAccountNumber1, elAccountNumber2, elAccountNumber3, elAccountNumber4, elAccountNumber5, elAccountNumber6, elAccountNumber7};

        String result = "";
        result = CheckResults(elTitlePassBook, "หน้าสมุดบัญชี", result);
        result = CheckResults(elAccountName1, fundName1, result);
        result = CheckResults(elBalance1, response.getData().virtual_passbook_details.get(0).branch_name_th, result);
        result = CheckResults(elAccountName2, fundName2, result);
        result = CheckResults(elBalance2, response.getData().virtual_passbook_details.get(1).branch_name_th, result);
        result = CheckResults(elAccountName3, fundName3, result);
        result = CheckResults(elBalance3, response.getData().virtual_passbook_details.get(2).branch_name_th, result);
        result = CheckResults(elAccountName4, fundName4, result);
        result = CheckResults(elBalance4, response.getData().virtual_passbook_details.get(3).branch_name_th, result);
        result = CheckResults(elAccountName5, fundName5, result);
        result = CheckResults(elBalance5, response.getData().virtual_passbook_details.get(4).branch_name_th, result);
        result = CheckResults(elAccountName6, fundName6, result);
        result = CheckResults(elBalance6, response.getData().virtual_passbook_details.get(5).branch_name_th, result);
        result = CheckResults(elAccountName7, fundName7, result);
        result = CheckResults(elBalance7, response.getData().virtual_passbook_details.get(6).branch_name_th, result);
        result = CheckResults(elBtnView, "ถัดไป", result);
        for(int i = 0; i < responseSaving.getData().deposit_account_lists.size(); i++){
            if(responseSaving.getData().deposit_account_lists.get(i).relationship_code.equals("SECJNT")){
                for(int j = 0; j < arrAccountNumber.length; j++){
                    scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + " this account number isn't " + responseSaving.getData().deposit_account_lists.get(i).relationship_code);
                    result = CheckResultsAccountType(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number,"XXX-X-XX###-#"), arrAccountNumber[j], result);
                }
            }else {
                String accountStatus = responseSaving.getData().deposit_account_lists.get(i).account_status;
                String accountType = responseSaving.getData().deposit_account_lists.get(i).account_type;
                if(accountType.equals("SDA") || accountType.equals("DDA") || accountType.equals("CDA")){
                    if(accountStatus.equals("ACTIVE") || accountStatus.equals("INACTIVE") || accountStatus.equals("OTHER") || accountStatus.equals("DORMANT") || accountStatus.equals("FROZEN")){
                        for(int j = 0; j < arrAccountNumber.length; j++){
                            if(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number,"XXX-X-XX###-#").equals(arrAccountNumber[j])){
                                result = CheckResults(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number,"XXX-X-XX###-#"), arrAccountNumber[j], result);
                                System.err.println("Account Number : " + arrAccountNumber[j] + "\nAccount Type : " + accountType + "\nAccount Status : " + accountStatus);
                                scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + "\nAccount Type : " + accountType + "\nAccount Status : " + accountStatus);
                            }
                        }
                    }
                }
            }
        }

        String BeforeSelectAccount = "images/VirtualPassbook_BeforeSelectAccount_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(BeforeSelectAccount);
        CheckResultsReport(scenario.createNode(Given.class, "Select account list Screen. Before select account, The system display next button disable").addScreenCaptureFromPath(BeforeSelectAccount), result);

        accountName1.click();

        String AfterSelectAccount = "images/VirtualPassbook_AfterSelectAccount_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AfterSelectAccount);
        CheckResultsReport(scenario.createNode(Given.class, "Select account list Screen. After select account, The system display next button enable").addScreenCaptureFromPath(AfterSelectAccount), result);

        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_SELECT_ACC_PASSBOOK_SCREEN).click();

        System.err.println("fundName1 : " + fundName1);
        System.err.println("fundName2 : " + fundName2);
        System.err.println("fundName3 : " + fundName3);
        System.err.println("fundName4 : " + fundName4);
        System.err.println("fundName5 : " + fundName5);
        System.err.println("fundName6 : " + fundName6);
        System.err.println("fundName7 : " + fundName7);
        Assert.assertTrue(elTitlePassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elAccountName1.equals(fundName1));
        Assert.assertTrue(elBalance1.equals(response.getData().virtual_passbook_details.get(0).branch_name_th));
        Assert.assertTrue(elAccountName2.equals(fundName2));
        Assert.assertTrue(elBalance2.equals(response.getData().virtual_passbook_details.get(1).branch_name_th));
        Assert.assertTrue(elAccountName3.equals(fundName3));
        Assert.assertTrue(elBalance3.equals(response.getData().virtual_passbook_details.get(2).branch_name_th));
        Assert.assertTrue(elAccountName4.equals(fundName4));
        Assert.assertTrue(elBalance4.equals(response.getData().virtual_passbook_details.get(3).branch_name_th));
        Assert.assertTrue(elAccountName5.equals(fundName5));
        Assert.assertTrue(elBalance5.equals(response.getData().virtual_passbook_details.get(4).branch_name_th));
        Assert.assertTrue(elAccountName6.equals(fundName6));
        Assert.assertTrue(elBalance6.equals(response.getData().virtual_passbook_details.get(5).branch_name_th));
        Assert.assertTrue(elAccountName7.equals(fundName7));
        Assert.assertTrue(elBalance7.equals(response.getData().virtual_passbook_details.get(6).branch_name_th));
        Assert.assertTrue(elBtnView.equals("ถัดไป"));
        System.err.println("arrAccountNumber : " + Arrays.toString(arrAccountNumber));
        for(int i = 0; i < responseSaving.getData().deposit_account_lists.size(); i++){
            if(responseSaving.getData().deposit_account_lists.get(i).relationship_code.equals("SECJNT")){
                for(int j = 0; j < arrAccountNumber.length; j++){
                    scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + " this account number isn't " + responseSaving.getData().deposit_account_lists.get(i).relationship_code);
                }
            }else {
                String accountStatus = responseSaving.getData().deposit_account_lists.get(i).account_status;
                String accountType = responseSaving.getData().deposit_account_lists.get(i).account_type;
                if(accountType.equals("SDA") || accountType.equals("DDA") || accountType.equals("CDA")){
                    if(accountStatus.equals("ACTIVE") || accountStatus.equals("INACTIVE") || accountStatus.equals("OTHER") || accountStatus.equals("DORMANT") || accountStatus.equals("FROZEN")){
                        for(int j = 0; j < arrAccountNumber.length; j++){
                            if(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number,"XXX-X-XX###-#").equals(arrAccountNumber[j])){
                                Assert.assertTrue(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number,"XXX-X-XX###-#").equals(arrAccountNumber[j]));
                            }
                        }
                    }
                }
            }
        }
    }

    @Test(priority = 3, groups = "Customer Service Virtual Passbook Check radio button")
    public void TC_ONEAPP_10582_PBMF_CheckRadioBtn() throws Exception {
        WebElement virtualPassbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        String elVirtualPassbook = virtualPassbook.getText();

        String result = "";
        result = CheckResults(elVirtualPassbook, "หน้าสมุดบัญชี", result);

        String ClickBackOnSelectAccountScreen = "images/VirtualPassbook_ClickBackOnSelectAccountScreen" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ClickBackOnSelectAccountScreen);
        scenario.createNode(Given.class, "When customer click back button on select account screen. The system navigate to service screen").addScreenCaptureFromPath(ClickBackOnSelectAccountScreen).pass(result);

        virtualPassbook.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NUMBER_1_PASSBOOK);
        WebElement AccountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1_PASSBOOK);
        String elAccountNumber1 = AccountNumber1.getText().substring(0,13);
        String radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1_PASSBOOK).getAttribute("checked");
        String radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2_PASSBOOK).getAttribute("checked");
        String radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3_PASSBOOK).getAttribute("checked");
        String radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4_PASSBOOK).getAttribute("checked");
        String radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5_PASSBOOK).getAttribute("checked");
        String radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6_PASSBOOK).getAttribute("checked");
        String radioAccount7 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_7_PASSBOOK).getAttribute("checked");
        String checkBtnNext = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).getAttribute("disabled");
        System.out.println("radioAccount1 : " + radioAccount1);
        System.out.println("radioAccount2 : " + radioAccount2);
        System.out.println("radioAccount3 : " + radioAccount3);
        System.out.println("radioAccount4 : " + radioAccount4);
        System.out.println("radioAccount5 : " + radioAccount5);
        System.out.println("radioAccount6 : " + radioAccount6);
        System.out.println("radioAccount7 : " + radioAccount7);
        System.out.println("disable : " + checkBtnNext);
        result = "";
        result = CheckResults(elAccountNumber1, FormatNumber.formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "XXX-X-XX###-#"), result);
        result = CheckDisable(radioAccount1, false, result);
        System.out.println("result check disable : " + result);
        result = CheckDisable(radioAccount2, false, result);
        result = CheckDisable(radioAccount3, false, result);
        result = CheckDisable(radioAccount4, false, result);
        result = CheckDisable(radioAccount5, false, result);
        result = CheckDisable(radioAccount6, false, result);
        result = CheckDisable(radioAccount7, false, result);
        result = CheckDisable(checkBtnNext, true, result);
        System.out.println("result check disable 2 : " + result);

        String Statement3 = "images/Statement3" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement3);
        scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(Statement3).pass(result);
        AccountNumber1.click();
        radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1_PASSBOOK).getAttribute("checked");
        radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2_PASSBOOK).getAttribute("checked");
        radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3_PASSBOOK).getAttribute("checked");
        radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4_PASSBOOK).getAttribute("checked");
        radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5_PASSBOOK).getAttribute("checked");
        radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6_PASSBOOK).getAttribute("checked");
        radioAccount7 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_7_PASSBOOK).getAttribute("checked");
        checkBtnNext = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).getAttribute("disabled");
        System.out.println("radioAccount1 : " + radioAccount1);
        System.out.println("radioAccount2 : " + radioAccount2);
        System.out.println("radioAccount3 : " + radioAccount3);
        System.out.println("radioAccount4 : " + radioAccount4);
        System.out.println("radioAccount5 : " + radioAccount5);
        System.out.println("radioAccount6 : " + radioAccount6);
        System.out.println("enable : " + checkBtnNext);
        result = "";
        result = CheckDisable(radioAccount1, true, result);
        result = CheckDisable(radioAccount2, false, result);
        result = CheckDisable(radioAccount3, false, result);
        result = CheckDisable(radioAccount4, false, result);
        result = CheckDisable(radioAccount5, false, result);
        result = CheckDisable(radioAccount6, false, result);
        result = CheckDisable(radioAccount7, false, result);
        result = CheckDisable(checkBtnNext, false, result);
        System.out.println("result check disable 3 : " + result);

        String selectOnly1Account = "images/Statement_selectOnly1Account_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectOnly1Account);
        CheckResultsReport(scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(selectOnly1Account), result);

        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3_PASSBOOK).click();
        result = "";
        radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1_PASSBOOK).getAttribute("checked");
        radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2_PASSBOOK).getAttribute("checked");
        radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3_PASSBOOK).getAttribute("checked");
        radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4_PASSBOOK).getAttribute("checked");
        radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5_PASSBOOK).getAttribute("checked");
        radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6_PASSBOOK).getAttribute("checked");
        radioAccount7 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_7_PASSBOOK).getAttribute("checked");
        checkBtnNext = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).getAttribute("disabled");
        result = CheckDisable(radioAccount1, false, result);
        result = CheckDisable(radioAccount2, false, result);
        result = CheckDisable(radioAccount3, true, result);
        result = CheckDisable(radioAccount4, false, result);
        result = CheckDisable(radioAccount5, false, result);
        result = CheckDisable(radioAccount6, false, result);
        result = CheckDisable(radioAccount7, false, result);
        result = CheckDisable(checkBtnNext, false, result);
        System.out.println("result check disable 4 : " + result);

        String selectOnly1AccountChange = "images/Statement_selectOnly1AccountChange_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectOnly1AccountChange);
        CheckResultsReport(scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(selectOnly1AccountChange), result);

        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1_PASSBOOK).click();
        WebElement BtnNextSelectAccountScreen = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        BtnNextSelectAccountScreen.click();
    }

    @Test(priority = 4, groups = "Customer Service Virtual Passbook SDA DORMANT")
    public void TC_ONEAPP_10582_PBMF_00001() throws Exception {
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
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnShare = BtnShare.getText();
        WebElement BtnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);

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
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elVirtualPassbook, "หน้าสมุดบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Account Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชี", result);
        result = CheckResults(elLabelPortCodeEn, "Account No.", result);
        result = CheckResults(elOfficeAndBranchTh, "สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, response.getData().virtual_passbook_details.get(0).account_name, result);
        result = CheckResults(elPortfolioCodeValue, formatAccount(response.getData().virtual_passbook_details.get(0).account_number, "###-#-#####-#"), result);
        result = CheckResults(elOfficeBranchValue, response.getData().virtual_passbook_details.get(0).branch_name_th, result);
        result = CheckResults(elBtnSave, "บันทึกไฟล์", result);
        result = CheckResults(elBtnShare, "แชร์ไฟล์", result);

        String VirtualPassbook_VirtualPassbook = "images/VirtualPassbook_VirtualPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbook_VirtualPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "Passbook Screen").addScreenCaptureFromPath(VirtualPassbook_VirtualPassbook), result);

        Assert.assertTrue(elVirtualPassbook.equals("หน้าสมุดบัญชี"));
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
        Assert.assertTrue(elBtnSave.equals("บันทึกไฟล์"));
        Assert.assertTrue(elBtnShare.equals("แชร์ไฟล์"));

        BtnBack.click();
    }

    @Test(priority = 5, groups = "Customer Service Virtual Passbook SDA ACTIVE")
    public void TC_ONEAPP_10582_PBMF_0002() throws Exception {
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_2_PASSBOOK).click();
        ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).click();
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
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnShare = BtnShare.getText();
        WebElement BtnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);

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
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elVirtualPassbook, "หน้าสมุดบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Account Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชี", result);
        result = CheckResults(elLabelPortCodeEn, "Account No.", result);
        result = CheckResults(elOfficeAndBranchTh, "สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, response.getData().virtual_passbook_details.get(1).account_name, result);
        result = CheckResults(elPortfolioCodeValue, formatAccount(response.getData().virtual_passbook_details.get(1).account_number, "###-#-#####-#"), result);
        result = CheckResults(elOfficeBranchValue, response.getData().virtual_passbook_details.get(1).branch_name_th, result);
        result = CheckResults(elBtnSave, "บันทึกไฟล์", result);
        result = CheckResults(elBtnShare, "แชร์ไฟล์", result);

        String VirtualPassbook_VirtualPassbook = "images/VirtualPassbook_VirtualPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbook_VirtualPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "Passbook Screen").addScreenCaptureFromPath(VirtualPassbook_VirtualPassbook), result);

        Assert.assertTrue(elVirtualPassbook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersTh.equals("ชื่อบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersEn.equals("Account Name"));
        Assert.assertTrue(elLabelPortCodeTh.equals("เลขที่บัญชี"));
        Assert.assertTrue(elLabelPortCodeEn.equals("Account No."));
        Assert.assertTrue(elOfficeAndBranchTh.equals("สาขา"));
        Assert.assertTrue(elOfficeAndBranchEn.equals("Branch"));
        Assert.assertTrue(elRemark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals(response.getData().virtual_passbook_details.get(1).account_name));
        System.err.println("formatPortFolio : " + formatAccount(response.getData().virtual_passbook_details.get(1).account_number, "###-#-#####-#"));
        Assert.assertTrue(elPortfolioCodeValue.equals(formatAccount(response.getData().virtual_passbook_details.get(1).account_number, "###-#-#####-#")));
        Assert.assertTrue(elOfficeBranchValue.equals(response.getData().virtual_passbook_details.get(1).branch_name_th));
        Assert.assertTrue(elBtnSave.equals("บันทึกไฟล์"));
        Assert.assertTrue(elBtnShare.equals("แชร์ไฟล์"));

        BtnBack.click();
    }

    @Test(priority = 6, groups = "Customer Service Virtual Passbook SDA OTHER")
    public void TC_ONEAPP_10582_PBMF_0003() throws Exception {
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3_PASSBOOK).click();
        ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).click();
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
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnShare = BtnShare.getText();
        WebElement BtnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);

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
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elVirtualPassbook, "หน้าสมุดบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Account Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชี", result);
        result = CheckResults(elLabelPortCodeEn, "Account No.", result);
        result = CheckResults(elOfficeAndBranchTh, "สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, response.getData().virtual_passbook_details.get(2).account_name, result);
        result = CheckResults(elPortfolioCodeValue, formatAccount(response.getData().virtual_passbook_details.get(2).account_number, "###-#-#####-#"), result);
        result = CheckResults(elOfficeBranchValue, response.getData().virtual_passbook_details.get(2).branch_name_th, result);
        result = CheckResults(elBtnSave, "บันทึกไฟล์", result);
        result = CheckResults(elBtnShare, "แชร์ไฟล์", result);

        String VirtualPassbook_VirtualPassbook = "images/VirtualPassbook_VirtualPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbook_VirtualPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "Passbook Screen").addScreenCaptureFromPath(VirtualPassbook_VirtualPassbook), result);

        Assert.assertTrue(elVirtualPassbook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersTh.equals("ชื่อบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersEn.equals("Account Name"));
        Assert.assertTrue(elLabelPortCodeTh.equals("เลขที่บัญชี"));
        Assert.assertTrue(elLabelPortCodeEn.equals("Account No."));
        Assert.assertTrue(elOfficeAndBranchTh.equals("สาขา"));
        Assert.assertTrue(elOfficeAndBranchEn.equals("Branch"));
        Assert.assertTrue(elRemark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals(response.getData().virtual_passbook_details.get(2).account_name));
        System.err.println("formatPortFolio : " + formatAccount(response.getData().virtual_passbook_details.get(2).account_number, "###-#-#####-#"));
        Assert.assertTrue(elPortfolioCodeValue.equals(formatAccount(response.getData().virtual_passbook_details.get(2).account_number, "###-#-#####-#")));
        Assert.assertTrue(elOfficeBranchValue.equals(response.getData().virtual_passbook_details.get(2).branch_name_th));
        Assert.assertTrue(elBtnSave.equals("บันทึกไฟล์"));
        Assert.assertTrue(elBtnShare.equals("แชร์ไฟล์"));

        BtnBack.click();
    }

    @Test(priority = 7, groups = "Customer Service Virtual Passbook DDA ACTIVE")
    public void TC_ONEAPP_10582_PBMF_0004() throws Exception {
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_7_PASSBOOK).click();
        ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST).click();
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
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.SHARE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        String elBtnShare = BtnShare.getText();
        WebElement BtnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);

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
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        String result = "";
        result = CheckResults(elVirtualPassbook, "หน้าสมุดบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersTh, "ชื่อบัญชี", result);
        result = CheckResults(elLabelNameOfUnitholdersEn, "Account Name", result);
        result = CheckResults(elLabelPortCodeTh, "เลขที่บัญชี", result);
        result = CheckResults(elLabelPortCodeEn, "Account No.", result);
        result = CheckResults(elOfficeAndBranchTh, "สาขา", result);
        result = CheckResults(elOfficeAndBranchEn, "Branch", result);
        result = CheckResults(elRemark, "หมายเหตุ:", result);
        result = CheckResults(elRemarkDetail, "- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น", result);
        result = CheckResults(elUnitholderNameValue, response.getData().virtual_passbook_details.get(6).account_name, result);
        result = CheckResults(elPortfolioCodeValue, formatAccount(response.getData().virtual_passbook_details.get(6).account_number, "###-#-#####-#"), result);
        result = CheckResults(elOfficeBranchValue, response.getData().virtual_passbook_details.get(6).branch_name_th, result);
        result = CheckResults(elBtnSave, "บันทึกไฟล์", result);
        result = CheckResults(elBtnShare, "แชร์ไฟล์", result);

        String VirtualPassbook_VirtualPassbook = "images/VirtualPassbook_VirtualPassbook_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbook_VirtualPassbook);
        CheckResultsReport(scenario.createNode(Given.class, "Passbook Screen").addScreenCaptureFromPath(VirtualPassbook_VirtualPassbook), result);

        Assert.assertTrue(elVirtualPassbook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersTh.equals("ชื่อบัญชี"));
        Assert.assertTrue(elLabelNameOfUnitholdersEn.equals("Account Name"));
        Assert.assertTrue(elLabelPortCodeTh.equals("เลขที่บัญชี"));
        Assert.assertTrue(elLabelPortCodeEn.equals("Account No."));
        Assert.assertTrue(elOfficeAndBranchTh.equals("สาขา"));
        Assert.assertTrue(elOfficeAndBranchEn.equals("Branch"));
        Assert.assertTrue(elRemark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์นี้ ใช้เพื่อแสดงหมายเลขบัญชี ชื่อเจ้าของบัญชี และสาขาเจ้าของบัญชี จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals(response.getData().virtual_passbook_details.get(6).account_name));
        System.err.println("formatPortFolio : " + formatAccount(response.getData().virtual_passbook_details.get(6).account_number, "###-#-#####-#"));
        Assert.assertTrue(elPortfolioCodeValue.equals(formatAccount(response.getData().virtual_passbook_details.get(6).account_number, "###-#-#####-#")));
        Assert.assertTrue(elOfficeBranchValue.equals(response.getData().virtual_passbook_details.get(6).branch_name_th));
        Assert.assertTrue(elBtnSave.equals("บันทึกไฟล์"));
        Assert.assertTrue(elBtnShare.equals("แชร์ไฟล์"));

        BtnBack.click();
    }

    @Test(priority = 8, groups = "Customer Service Save And Share")
    public void TC_ONEAPP_10582_PBMF_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement account0 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1_PASSBOOK);
        String elAccount0 = account0.getText();
        String result = "";
        result = CheckResults(elAccount0, formatAccount(responseSaving.getData().deposit_account_lists.get(0).account_number,"XXX-X-XX###-#"), result);

        String VirtualPassbookClickBack = "images/VirtualPassbook_VirtualPassbookClickBack_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickBack);
        scenario.createNode(Given.class, "When customer click Back button, the system navigate to select account screen").addScreenCaptureFromPath(VirtualPassbookClickBack).pass(result);
        account0.click();
        WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
        BtnView.click();
        ttbTestContext.findElement(OneAppElementKeys.SAVE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN).click();
        String TitlePopupSave = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_SAVE_SHARE_MUTUAL_FUND_PASSBOOK_SCREEN).getText();
        String labelPdfSave = ttbTestContext.findElement(OneAppElementKeys.PDF_POPUP_SAVE_SHARE).getText();
        String labelImageSave = ttbTestContext.findElement(OneAppElementKeys.IMAGE_POPUP_SAVE_SHARE).getText();

        result = "";
        result = CheckResults(TitlePopupSave, "เลือกประเภทไฟล์ที่ต้องการบันทึก", result);
        result = CheckResults(labelPdfSave, "ไฟล์ PDF", result);
        result = CheckResults(labelImageSave, "ไฟล์ ภาพ", result);

        String VirtualPassbookClickSave = "images/VirtualPassbook_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickSave);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup save").addScreenCaptureFromPath(VirtualPassbookClickSave), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String VirtualPassbookClickXPopup = "images/VirtualPassbook_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
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
        result = CheckResults(TitlePopupShare, "เลือกประเภทไฟล์ที่ต้องการแชร์", result);
        result = CheckResults(labelPdfShare, "ไฟล์ PDF", result);
        result = CheckResults(labelImageShare, "ไฟล์ ภาพ", result);

        String VirtualPassbookClickShare = "images/VirtualPassbook_VirtualPassbookPopupShare_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickShare);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click Save button, The system display popup share").addScreenCaptureFromPath(VirtualPassbookClickShare), result);

        ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_POPUP_SAVE_SHARE).click();

        String VirtualPassbookClickXPopupShare = "images/VirtualPassbook_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickXPopupShare);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click X, The system close popup share").addScreenCaptureFromPath(VirtualPassbookClickXPopupShare), result);
        System.err.println("TitlePopupShare : " + TitlePopupShare);
        System.err.println("labelPdfShare : " + labelPdfShare);
        System.err.println("labelImageShare : " + labelImageShare);

        Assert.assertTrue(TitlePopupSave.equals("เลือกประเภทไฟล์ที่ต้องการบันทึก"));
        Assert.assertTrue(labelPdfSave.equals("ไฟล์ PDF"));
        Assert.assertTrue(labelImageSave.equals("ไฟล์ ภาพ"));
        Assert.assertTrue(TitlePopupShare.equals("เลือกประเภทไฟล์ที่ต้องการแชร์"));
        Assert.assertTrue(labelPdfShare.equals("ไฟล์ PDF"));
        Assert.assertTrue(labelImageShare.equals("ไฟล์ ภาพ"));
    }

    @Test(priority = 9, groups = "Customer Service Back to service page")
    public void TC_ONEAPP_10584_PBMF_00001() throws Exception {
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_MUTUAL_FUND_PASSBOOK_SCREEN);
        BtnBackToMainMenu.click();
        WebElement Passbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        String elPassbook = Passbook.getText();

        String result = "";
        result = CheckResults(elPassbook, "หน้าสมุดบัญชี", result);

        String VirtualPassbookClickXPopup = "images/VirtualPassbook_VirtualPassbookPopupSave_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(VirtualPassbookClickXPopup);
        CheckResultsReport(scenario.createNode(Given.class, "When customer click X on view virtual passbook screen, The system back to service screen").addScreenCaptureFromPath(VirtualPassbookClickXPopup), result);

        getExtent().flush();
    }
}
