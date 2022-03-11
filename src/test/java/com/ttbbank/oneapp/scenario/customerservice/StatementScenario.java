package com.ttbbank.oneapp.scenario.customerservice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.accountSaving.SavingResponse;
import com.ttbbank.oneapp.framework.model.customerservice.deposit.DepositResponse;
import com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber;
import com.ttbbank.oneapp.framework.utils.customerservice.SelectElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.*;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatAccount;

//import static com.ttbbank.oneapp.framework.utils.customerservice.SelectElement.selectByText;

public class StatementScenario extends BaseScenario {
    TmbServiceResponse<DepositResponse> response = null;
    TmbServiceResponse<SavingResponse> responseSaving = null;
    ExtentTest scenario = null;

    @Test(groups = "Customer Service Statement", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void Statement() throws InterruptedException, IOException {
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
        scenario = getFeature().createNode(Scenario.class, "Statement");
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        } else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        Map<String, String> eqParamsSaving = new HashMap<>();
        eqParamsSaving.put("", "");
        OneAppClient client = getOneAppClient();
        responseSaving = client.get("/apis/customer/accounts/saving", eqParamsSaving, SavingResponse.class);
        System.out.println("responseSaving : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseSaving));
        WebElement statementServiceButton = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        statementServiceButton.click();
    }

    public void testcase02() throws InterruptedException, IOException {
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        response = client.get("/apis/customer/accounts/deposit", eqParams, DepositResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        System.out.println("response2 : " + response.getData().deposit_account_lists.get(0).account_name_en);
        System.out.println("response2 : " + FormatNumber.formatAccount(response.getData().deposit_account_lists.get(0).account_number, "XXX-X-XX###-#"));
        System.out.println("response2 : " + response.getData().deposit_account_lists.get(0).account_balance);
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        String format = decimalFormat.format(response.getData().deposit_account_lists.get(0).account_balance);
        System.out.println("balance format " + format);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        System.out.println(twoPlaces.format(response.getData().deposit_account_lists.get(0).account_balance));

        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1);
        WebElement TitleSelectAccScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_SELECT_ACCOUNT_SCREEN);
        String elTitleSelectAccScreen = TitleSelectAccScreen.getText();
        System.err.println("elTitleSelectAccScreen : " + elTitleSelectAccScreen);
        WebElement LabelSelectAcc = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_ACCOUNT);
        String elLabelSelectAcc = LabelSelectAcc.getText();
        WebElement AccountName1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1);
        String elAccountName1 = AccountName1.getText();
        WebElement AccountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1);
        String elAccountNumber1 = AccountNumber1.getText();
        WebElement Balance1 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_1);
        String elBalance1 = Balance1.getText();
        WebElement AccountName2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_2);
        String elAccountName2 = AccountName2.getText();
        WebElement AccountNumber2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_2);
        String elAccountNumber2 = AccountNumber2.getText();
        WebElement Balance2 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_2);
        String elBalance2 = Balance2.getText();
        WebElement AccountName3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3);
        String elAccountName3 = AccountName3.getText();
        WebElement AccountNumber3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_3);
        String elAccountNumber3 = AccountNumber3.getText();
        WebElement Balance3 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_3);
        String elBalance3 = Balance3.getText();
        WebElement AccountName4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_4);
        String elAccountName4 = AccountName4.getText();
        WebElement AccountNumber4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_4);
        String elAccountNumber4 = AccountNumber4.getText();
        WebElement Balance4 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_4);
        String elBalance4 = Balance4.getText();
        WebElement AccountName5 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_5);
        String elAccountName5 = AccountName5.getText();
        WebElement AccountNumber5 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_5);
        String elAccountNumber5 = AccountNumber5.getText();
        WebElement Balance5 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_5);
        String elBalance5 = Balance5.getText();
        WebElement AccountName6 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_6);
        String elAccountName6 = AccountName6.getText();
        WebElement AccountNumber6 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_6);
        String elAccountNumber6 = AccountNumber6.getText();
        WebElement Balance6 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_6);
        String elBalance6 = Balance6.getText();
        WebElement BtnNextSelectAccountScreen = ttbTestContext.findElement(OneAppElementKeys.BtnNextSelectAccountScreen);
        String elBtnNextSelectAccountScreen = BtnNextSelectAccountScreen.getText();
        WebElement BtnArrowBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SELECT_ACC_SCREEN);

        String[] arrAccountNumber = {elAccountNumber1, elAccountNumber2, elAccountNumber3, elAccountNumber4, elAccountNumber5, elAccountNumber6};

        System.err.println("elLabelSelectAcc : " + elLabelSelectAcc);
        System.err.println("elAccountName1 : " + elAccountName1);
        System.err.println("elAccountNumber1 : " + elAccountNumber1);
        System.err.println("elBalance1 : " + elBalance1);
        System.err.println("elAccountName2 : " + elAccountName2);
        System.err.println("elAccountNumber2 : " + elAccountNumber2);
        System.err.println("elBalance2 : " + elBalance2);
        System.err.println("elAccountName3 : " + elAccountName3);
        System.err.println("elAccountNumber3 : " + elAccountNumber3);
        System.err.println("elBalance3 : " + elBalance3);
        System.err.println("elBtnNextSelectAccountScreen : " + elBtnNextSelectAccountScreen);

        String result = "";
        result = CheckResults(elTitleSelectAccScreen, "Statement", result);
        result = CheckResults(elLabelSelectAcc, "Select an Account", result);
        result = CheckResults(elAccountName1, (response.getData().deposit_account_lists.get(0).account_nickname == null) ? response.getData().deposit_account_lists.get(0).account_name_en : response.getData().deposit_account_lists.get(0).account_nickname, result);
        result = CheckResults(elAccountNumber1, FormatNumber.formatAccount(response.getData().deposit_account_lists.get(0).account_number, "XXX-X-XX###-#"), result);
        result = CheckResults(elBalance1, FormatNumber.formatBalance(response.getData().deposit_account_lists.get(0).account_balance), result);
        result = CheckResults(elAccountName2, (response.getData().deposit_account_lists.get(1).account_nickname == null) ? response.getData().deposit_account_lists.get(1).account_name_en : response.getData().deposit_account_lists.get(1).account_nickname, result);
        result = CheckResults(elAccountNumber2, FormatNumber.formatAccount(response.getData().deposit_account_lists.get(1).account_number, "XXX-X-XX###-#"), result);
        result = CheckResults(elBalance2, FormatNumber.formatBalance(response.getData().deposit_account_lists.get(1).account_balance), result);
        result = CheckResults(elAccountName3, (response.getData().deposit_account_lists.get(2).account_nickname == null) ? response.getData().deposit_account_lists.get(2).account_name_en : response.getData().deposit_account_lists.get(2).account_nickname, result);
        result = CheckResults(elAccountNumber3, FormatNumber.formatAccount(response.getData().deposit_account_lists.get(2).account_number, "XXX-X-XX###-#"), result);
        result = CheckResults(elBalance3, FormatNumber.formatBalance(response.getData().deposit_account_lists.get(2).account_balance), result);
        result = CheckResults(elBtnNextSelectAccountScreen, "Next", result);

        for (int i = 0; i < responseSaving.getData().deposit_account_lists.size(); i++) {
            if (responseSaving.getData().deposit_account_lists.get(i).relationship_code.equals("SECJNT")) {
                for (int j = 0; j < arrAccountNumber.length; j++) {
                    scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + " this account number isn't " + responseSaving.getData().deposit_account_lists.get(i).relationship_code);
                    result = CheckResultsAccountType(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number, "XXX-X-XX###-#"), arrAccountNumber[j], result);
                }
            } else {
                String accountStatus = responseSaving.getData().deposit_account_lists.get(i).account_status;
                String accountType = responseSaving.getData().deposit_account_lists.get(i).account_type;
                if (accountType.equals("SDA") || accountType.equals("DDA") || accountType.equals("CDA")) {
                    if (accountStatus.equals("ACTIVE") || accountStatus.equals("INACTIVE") || accountStatus.equals("OTHER") || accountStatus.equals("DORMANT") || accountStatus.equals("FROZEN")) {
                        for (int j = 0; j < arrAccountNumber.length; j++) {
                            if (formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number, "XXX-X-XX###-#").equals(arrAccountNumber[j])) {
                                result = CheckResults(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number, "XXX-X-XX###-#"), arrAccountNumber[j], result);
                                System.err.println("Account Number : " + arrAccountNumber[j] + "\nAccount Type : " + accountType + "\nAccount Status : " + accountStatus);
                                scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + "\nAccount Type : " + accountType + "\nAccount Status : " + accountStatus);
                            }
                        }
                    }
                }
            }
        }

        scenario.createNode(Given.class, "Verification The system show \"Select an account\" screen correctly.").pass(result);
        String BeforeSelectAccount = "images/statement_BeforeSelectAccount" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(BeforeSelectAccount);
        scenario.createNode(Given.class, "Select account screen. Before select account, The system display Next Button disable").addScreenCaptureFromPath(BeforeSelectAccount).pass(result);

        String str = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1).getAttribute("checked");

        System.out.println("str before : " + str);
        AccountName1.click();
        str = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1).getAttribute("checked");
        System.out.println("str after : " + str);
        String AfterSelectAccount = "images/statement_AfterSelectAccount" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AfterSelectAccount);
        scenario.createNode(Given.class, "Select account screen. After select account, The system display Next Button enable").addScreenCaptureFromPath(AfterSelectAccount).pass(result);
        Thread.sleep(2000);
        BtnArrowBack.click();

        Assert.assertTrue(elTitleSelectAccScreen.equals("Statement"));
        Assert.assertTrue(elLabelSelectAcc.equals("Select an Account"));
        Assert.assertTrue(elAccountName1.equals((response.getData().deposit_account_lists.get(0).account_nickname == null) ? response.getData().deposit_account_lists.get(0).account_name_en : response.getData().deposit_account_lists.get(0).account_nickname));
        Assert.assertTrue(elBalance1.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(0).account_balance)));
        Assert.assertTrue(elAccountName2.equals((response.getData().deposit_account_lists.get(1).account_nickname == null) ? response.getData().deposit_account_lists.get(1).account_name_en : response.getData().deposit_account_lists.get(1).account_nickname));
        Assert.assertTrue(elBalance2.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(1).account_balance)));
        Assert.assertTrue(elAccountName3.equals((response.getData().deposit_account_lists.get(2).account_nickname == null) ? response.getData().deposit_account_lists.get(2).account_name_en : response.getData().deposit_account_lists.get(2).account_nickname));
        Assert.assertTrue(elBalance3.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(2).account_balance)));
        Assert.assertTrue(elAccountName4.equals((response.getData().deposit_account_lists.get(3).account_nickname == null) ? response.getData().deposit_account_lists.get(3).account_name_en : response.getData().deposit_account_lists.get(3).account_nickname));
        Assert.assertTrue(elBalance4.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(3).account_balance)));
        Assert.assertTrue(elAccountName5.equals((response.getData().deposit_account_lists.get(4).account_nickname == null) ? response.getData().deposit_account_lists.get(4).account_name_en : response.getData().deposit_account_lists.get(4).account_nickname));
        Assert.assertTrue(elBalance5.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(4).account_balance)));
        Assert.assertTrue(elAccountName6.equals((response.getData().deposit_account_lists.get(5).account_nickname == null) ? response.getData().deposit_account_lists.get(5).account_name_en : response.getData().deposit_account_lists.get(5).account_nickname));
        Assert.assertTrue(elBalance6.equals(FormatNumber.formatBalance(response.getData().deposit_account_lists.get(5).account_balance)));
        Assert.assertTrue(elBtnNextSelectAccountScreen.equals("Next"));

        for (int i = 0; i < responseSaving.getData().deposit_account_lists.size(); i++) {
            if (responseSaving.getData().deposit_account_lists.get(i).relationship_code.equals("SECJNT")) {
                for (int j = 0; j < arrAccountNumber.length; j++) {
                    scenario.createNode(Given.class, "Account Number : " + arrAccountNumber[j] + " this account number isn't " + responseSaving.getData().deposit_account_lists.get(i).relationship_code);
                }
            } else {
                String accountStatus = responseSaving.getData().deposit_account_lists.get(i).account_status;
                String accountType = responseSaving.getData().deposit_account_lists.get(i).account_type;
                if (accountType.equals("SDA") || accountType.equals("DDA") || accountType.equals("CDA")) {
                    if (accountStatus.equals("ACTIVE") || accountStatus.equals("INACTIVE") || accountStatus.equals("OTHER") || accountStatus.equals("DORMANT") || accountStatus.equals("FROZEN")) {
                        for (int j = 0; j < arrAccountNumber.length; j++) {
                            if (formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number, "XXX-X-XX###-#").equals(arrAccountNumber[j])) {
                                Assert.assertTrue(formatAccount(responseSaving.getData().deposit_account_lists.get(i).account_number, "XXX-X-XX###-#").equals(arrAccountNumber[j]));
                            }
                        }
                    }
                }
            }
        }
    }

    public void testcase03() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        WebElement statementServiceButton = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        String elStatementServiceButton = statementServiceButton.getText();

        String result = "";
        result = CheckResults(elStatementServiceButton, "Statement", result);

        String ClickBackOnSelectAccountScreen = "images/Statement_ClickBackOnSelectAccountScreen" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ClickBackOnSelectAccountScreen);
        scenario.createNode(Given.class, "When customer click back button on select account screen. The system navigate to service screen").addScreenCaptureFromPath(ClickBackOnSelectAccountScreen).pass(result);

        statementServiceButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NUMBER_1);
        WebElement AccountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1);
        String elAccountNumber1 = AccountNumber1.getText();
        String radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1).getAttribute("checked");
        String radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2).getAttribute("checked");
        String radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3).getAttribute("checked");
        String radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4).getAttribute("checked");
        String radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5).getAttribute("checked");
        String radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6).getAttribute("checked");
        String checkBtnNext = ttbTestContext.findElement(OneAppElementKeys.BtnNextSelectAccountScreen).getAttribute("disabled");
        System.out.println("radioAccount1 : " + radioAccount1);
        System.out.println("radioAccount2 : " + radioAccount2);
        System.out.println("radioAccount3 : " + radioAccount3);
        System.out.println("radioAccount4 : " + radioAccount4);
        System.out.println("radioAccount5 : " + radioAccount5);
        System.out.println("radioAccount6 : " + radioAccount6);
        System.out.println("disable : " + checkBtnNext);
        result = "";
        result = CheckResults(elAccountNumber1, FormatNumber.formatAccount(response.getData().deposit_account_lists.get(0).account_number, "XXX-X-XX###-#"), result);
        result = CheckDisable(radioAccount1, false, result);
        System.out.println("result check disable : " + result);
        result = CheckDisable(radioAccount2, false, result);
        result = CheckDisable(radioAccount3, false, result);
        result = CheckDisable(radioAccount4, false, result);
        result = CheckDisable(radioAccount5, false, result);
        result = CheckDisable(radioAccount6, false, result);
        result = CheckDisable(checkBtnNext, true, result);
        System.out.println("result check disable 2 : " + result);

        String Statement3 = "images/Statement3" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement3);
        scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(Statement3).pass(result);
        AccountNumber1.click();
        radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1).getAttribute("checked");
        radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2).getAttribute("checked");
        radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3).getAttribute("checked");
        radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4).getAttribute("checked");
        radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5).getAttribute("checked");
        radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6).getAttribute("checked");
        checkBtnNext = ttbTestContext.findElement(OneAppElementKeys.BtnNextSelectAccountScreen).getAttribute("disabled");
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
        result = CheckDisable(checkBtnNext, false, result);
        System.out.println("result check disable 3 : " + result);

        String selectOnly1Account = "images/Statement_selectOnly1Account_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectOnly1Account);
        scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(selectOnly1Account).pass(result);

        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3).click();
        result = "";
        radioAccount1 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_1).getAttribute("checked");
        radioAccount2 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_2).getAttribute("checked");
        radioAccount3 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_3).getAttribute("checked");
        radioAccount4 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_4).getAttribute("checked");
        radioAccount5 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_5).getAttribute("checked");
        radioAccount6 = ttbTestContext.findElement(OneAppElementKeys.RADIO_CHECKBOX_DEPOSIT_6).getAttribute("checked");
        result = CheckDisable(radioAccount1, false, result);
        result = CheckDisable(radioAccount2, false, result);
        result = CheckDisable(radioAccount3, true, result);
        result = CheckDisable(radioAccount4, false, result);
        result = CheckDisable(radioAccount5, false, result);
        result = CheckDisable(radioAccount6, false, result);
        result = CheckDisable(checkBtnNext, false, result);
        System.out.println("result check disable 4 : " + result);

        String selectOnly1AccountChange = "images/Statement_selectOnly1AccountChange_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectOnly1AccountChange);
        scenario.createNode(Given.class, "if customer click statement menu again, The system navigate to select account screen and system isn't select account").addScreenCaptureFromPath(selectOnly1AccountChange).pass(result);

        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1).click();
        WebElement BtnNextSelectAccountScreen = ttbTestContext.findElement(OneAppElementKeys.BtnNextSelectAccountScreen);
        BtnNextSelectAccountScreen.click();
    }


    public void testcase04() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PERIOD_TO);
        WebElement TitleStatementScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_STATEMENT_SCREEN);
        String elTitleStatementScreen = TitleStatementScreen.getText();
        WebElement LabelStatementDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_STATEMENT_DETAIL);
        String elLabelStatementDetail = LabelStatementDetail.getText();
        WebElement StatementDetail = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_DETAIL);
        String elStatementDetail = StatementDetail.getText();
        WebElement LabelDocLanguage = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOC_LANGUAGE);
        String elLabelDocLanguage = LabelDocLanguage.getText();
        WebElement RadioBtnTH = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH);
        String elRadioBtnTH = RadioBtnTH.getText();
        WebElement RadioBtnEN = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_EN);
        String elRadioBtnEN = RadioBtnEN.getText();
        WebElement LabelStatementVersion = ttbTestContext.findElement(OneAppElementKeys.LABEL_STATEMENT_VERSION);
        String elLabelStatementVersion = LabelStatementVersion.getText();
        WebElement RadioBtnCondensedStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_CONDENSED_STATEMENT);
        String elRadioBtnCondensedStatement = RadioBtnCondensedStatement.getText();
        WebElement RadioBtnDetailStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT);
        String elRadioBtnDetailStatement = RadioBtnDetailStatement.getText();
        WebElement LabelTransactionPeriod = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_PERIOD);
        String elLabelTransactionPeriod = LabelTransactionPeriod.getText();
        WebElement ConditionSelectPeriod = ttbTestContext.findElement(OneAppElementKeys.CONDITION_SELECT_PERIOD);
        String elConditionSelectPeriod = ConditionSelectPeriod.getText();
        WebElement LabelPeriodFrom = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERIOD_FROM);
        String elLabelPeriodFrom = LabelPeriodFrom.getText();
        Select SelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        String elSelectedFrom = SelectedFrom.getFirstSelectedOption().getText();
        WebElement LabelPeriodTo = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERIOD_TO);
        String elLabelPeriodTo = LabelPeriodTo.getText();
        Select SelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        String elSelectedTo = SelectedTo.getFirstSelectedOption().getText();
        WebElement BtnGenerateStatement = ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT);
        String elBtnGenerateStatement = BtnGenerateStatement.getText();

        System.err.println("elTitleStatementScreen : " + elTitleStatementScreen);
        System.err.println("elLabelStatementDetail : " + elLabelStatementDetail);
        System.err.println("elStatementDetail : " + elStatementDetail);
        System.err.println("elLabelDocLanguage : " + elLabelDocLanguage);
        System.err.println("elRadioBtnTH : " + elRadioBtnTH);
        System.err.println("elRadioBtnEN : " + elRadioBtnEN);
        System.err.println("elLabelStatementVersion : " + elLabelStatementVersion);
        System.err.println("elRadioBtnCondensedStatement : " + elRadioBtnCondensedStatement);
        System.err.println("elRadioBtnDetailStatement : " + elRadioBtnDetailStatement);
        System.err.println("elLabelTransactionPeriod : " + elLabelTransactionPeriod);
        System.err.println("elConditionSelectPeriod : " + elConditionSelectPeriod);
        System.err.println("elLabelPeriodFrom : " + elLabelPeriodFrom);
        System.err.println("elSelectedFrom : " + elSelectedFrom);
        System.err.println("elLabelPeriodTo : " + elLabelPeriodTo);
        System.err.println("elSelectedFrom : " + elSelectedTo);
        System.err.println("elBtnGenerateStatement : " + elBtnGenerateStatement);

        SelectElement SelectTextFrom = new SelectElement(SelectedTo, 6, false);
        SelectElement SelectTextTo = new SelectElement(SelectedTo, 1, false);

        String result = "";
        result = CheckResults(elTitleStatementScreen, "Statement", result);
        result = CheckResults(elLabelStatementDetail, "Statement Format", result);
        result = CheckResults(elStatementDetail, "Please select the statement option below to generate your statement.", result);
        result = CheckResults(elLabelDocLanguage, "Document language", result);
        result = CheckResults(elRadioBtnTH, "Thai", result);
        result = CheckResults(elRadioBtnEN, "English", result);
        result = CheckResults(elLabelStatementVersion, "Statement Version", result);
        result = CheckResults(elRadioBtnCondensedStatement, "Condensed Statement", result);
        result = CheckResults(elRadioBtnDetailStatement, "Detailed Statement (Including Note)", result);
        result = CheckResults(elLabelTransactionPeriod, "Transaction Period", result);
        result = CheckResults(elConditionSelectPeriod, "Maximum 6 months per request", result);
        result = CheckResults(elLabelPeriodFrom, "From", result);
        result = CheckResults(elLabelPeriodTo, "To", result);
        result = CheckResults(elBtnGenerateStatement, "Generate Statement", result);
        result = CheckResults(elSelectedFrom, SelectTextFrom.SelectText(), result);
        result = CheckResults(elSelectedTo, SelectTextTo.SelectText(), result);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification Statement Details screen.");
        scenario.createNode(Given.class, "After customer select account and click Next button on \"Select an Account\" screen, The system will display \"Statement details\" screen correctly.").pass(result);
        String StatementDetailsScreen = "images/Statement_StatementDetailsScreen" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(StatementDetailsScreen);
        scenario.createNode(Given.class, "Statement Details screen").addScreenCaptureFromPath(StatementDetailsScreen).pass(result);

        Assert.assertTrue(elTitleStatementScreen.equals("Statement"));
        Assert.assertTrue(elLabelStatementDetail.equals("Statement Format"));
        Assert.assertTrue(elStatementDetail.equals("Please select the statement option below to generate your statement."));
        Assert.assertTrue(elLabelDocLanguage.equals("Document language"));
        Assert.assertTrue(elRadioBtnTH.equals("Thai"));
        Assert.assertTrue(elRadioBtnEN.equals("English"));
        Assert.assertTrue(elLabelStatementVersion.equals("Statement Version"));
        Assert.assertTrue(elRadioBtnCondensedStatement.equals("Condensed Statement"));
        Assert.assertTrue(elRadioBtnDetailStatement.equals("Detailed Statement (Including Note)"));
        Assert.assertTrue(elLabelTransactionPeriod.equals("Transaction Period"));
        Assert.assertTrue(elConditionSelectPeriod.equals("Maximum 6 months per request"));
        Assert.assertTrue(elLabelPeriodFrom.equals("From"));
        Assert.assertTrue(elLabelPeriodTo.equals("To"));
        Assert.assertTrue(elBtnGenerateStatement.equals("Generate Statement"));
        System.err.println("SelectTextFrom date : " + SelectTextFrom.SelectText());
        System.err.println("SelectTextTo : " + SelectTextTo.SelectText());
        Assert.assertTrue(elSelectedFrom.equals(SelectTextFrom.SelectText()));
        Assert.assertTrue(elSelectedTo.equals(SelectTextTo.SelectText()));

        new SelectElement(SelectedTo, 24, true);
    }

    public void testcase05() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification on \"Select an Account\" screen  when customer select account and press Next button to \"statement detail\" screen\n" +
                "and back to \"Select an Account\" screen again\n" +
                "The system show default \"Select an Account\" screen");
        scenario.createNode(Given.class, "On \"Statement Details\" screen when customer click back icon. The system back to \"Select an Account\" screen.");
        String Statement5 = "images/Statement5" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement5);
        scenario.createNode(Given.class, "Statement Details screen").addScreenCaptureFromPath(Statement5).pass("pass");
        WebElement BtnArrowBackStatementDetail = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_STATEMENT_SCREEN);
        BtnArrowBackStatementDetail.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_NAME_1);

        WebElement AccountName1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1);
        String elAccountNumber1 = AccountName1.getText();
        String result = "";
        result = CheckResults(elAccountNumber1, FormatNumber.formatAccount(response.getData().deposit_account_lists.get(0).account_number, "XXX-X-XX###-#"), result);

        String Statement6 = "images/Statement6" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement6);
        scenario.createNode(Given.class, "The system back to select an Account screen and show default \"Select an Account\" screen").addScreenCaptureFromPath(Statement6).pass(result);

        AccountName1.click();
        WebElement BtnNextSelectAccountScreen = ttbTestContext.findElement(OneAppElementKeys.BtnNextSelectAccountScreen);
        BtnNextSelectAccountScreen.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PERIOD_TO);

        String selectedOption = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM)).getFirstSelectedOption().getText();
        String selectedOption2 = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO)).getFirstSelectedOption().getText();

        String RadioBtnTH = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).getAttribute("checked");
        String RadioBtnEN = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_EN).getAttribute("checked");
        String RadioBtnCondensedStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_CONDENSED_STATEMENT).getAttribute("checked");
        String RadioBtnDetailStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).getAttribute("checked");

        System.err.println("RadioBtnTH : " + RadioBtnTH);
        System.err.println("RadioBtnEN : " + RadioBtnEN);
        System.err.println("RadioBtnCondensedStatement : " + RadioBtnCondensedStatement);
        System.err.println("RadioBtnDetailStatement : " + RadioBtnDetailStatement);
        result = "";
        result = CheckDisable(RadioBtnTH, false, result);
        result = CheckDisable(RadioBtnEN, true, result);
        result = CheckDisable(RadioBtnCondensedStatement, true, result);
        result = CheckDisable(RadioBtnDetailStatement, false, result);
        System.err.println("result adadada : " + result);
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).click();
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).click();

        RadioBtnTH = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).getAttribute("checked");
        RadioBtnEN = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_EN).getAttribute("checked");
        RadioBtnCondensedStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_CONDENSED_STATEMENT).getAttribute("checked");
        RadioBtnDetailStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).getAttribute("checked");
        result = "";
        result = CheckDisable(RadioBtnTH, true, result);
        result = CheckDisable(RadioBtnEN, false, result);
        result = CheckDisable(RadioBtnCondensedStatement, false, result);
        result = CheckDisable(RadioBtnDetailStatement, true, result);
        System.err.println("result dddddd : " + result);

        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_EN).click();
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_CONDENSED_STATEMENT).click();

        RadioBtnTH = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).getAttribute("checked");
        RadioBtnEN = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_EN).getAttribute("checked");
        RadioBtnCondensedStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_CONDENSED_STATEMENT).getAttribute("checked");
        RadioBtnDetailStatement = ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).getAttribute("checked");
        result = "";
        result = CheckDisable(RadioBtnTH, false, result);
        result = CheckDisable(RadioBtnEN, true, result);
        result = CheckDisable(RadioBtnCondensedStatement, true, result);
        result = CheckDisable(RadioBtnDetailStatement, false, result);
        System.err.println("result dddddd : " + result);

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "Verify default period from and period to");
        scenario2.createNode(Given.class, "When customer navigate to statement detail again").pass("pass");
        String Statement7 = "images/Statement7" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement7);
        scenario2.createNode(Given.class, "Transection period show default 6 months from present").addScreenCaptureFromPath(Statement7).pass("pass");

        System.err.println("selectedOption : " + selectedOption);
        System.err.println("selectedOption2 : " + selectedOption2);
    }

    public void testcase06() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verify transaction period if customer select period to < period from");
        scenario.createNode(Given.class, "Display \"Statement Details\" screen  \n" +
                "In Transection period  when customer select 'To Month Year value' < 'From Month Year valus'. The system will automatic display 'To Month Year  = 'From Month Year value.").pass("pass");
        String Statement8 = "images/Statement8" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement8);
        scenario.createNode(Given.class, "Statement Details screen").addScreenCaptureFromPath(Statement8).pass("pass");
        Select SelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select SelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        new SelectElement(SelectedTo, 10, true);
        System.err.println("SelectedFrom = SelectedTo " + SelectedFrom.getFirstSelectedOption().getText() + " = " + SelectedTo.getFirstSelectedOption().getText());
        Assert.assertTrue(SelectedFrom.getFirstSelectedOption().getText().equals(SelectedTo.getFirstSelectedOption().getText()));
        String Statement10 = "images/Statement10" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement10);
        scenario.createNode(Given.class, "The system display period to = period from").addScreenCaptureFromPath(Statement10).pass("pass");
        Select afterSelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select afterSelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        String elAfterSelectedFrom = afterSelectedFrom.getFirstSelectedOption().getText();
        String elAfterSelectedTo = afterSelectedTo.getFirstSelectedOption().getText();

        Assert.assertTrue(elAfterSelectedFrom.equals(elAfterSelectedTo));
    }

    public void testcase07() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verify transaction period if customer select period from > period to");
        scenario.createNode(Given.class, "Display \"Statement Details\" screen  \n" +
                "In Transection period  when customer select 'From Month Year value' > 'To Month Year valus'. The system will automatic display 'To Month Year  = 'From Month Year value.").pass("pass");
        String Statement11 = "images/Statement11" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement11);
        scenario.createNode(Given.class, "Statement Details screen").addScreenCaptureFromPath(Statement11).pass("pass");
        Select SelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select SelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        new SelectElement(SelectedFrom, 1, true);
        System.err.println("SelectedFrom = SelectedTo " + SelectedFrom.getFirstSelectedOption().getText() + " = " + SelectedTo.getFirstSelectedOption().getText());
        Assert.assertTrue(SelectedFrom.getFirstSelectedOption().getText().equals(SelectedTo.getFirstSelectedOption().getText()));

        String Statement13 = "images/Statement13" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement13);
        scenario.createNode(Given.class, "The system display period to = period from ").addScreenCaptureFromPath(Statement13).pass("pass");
        Select afterSelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select afterSelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        String elAfterSelectedFrom = afterSelectedFrom.getFirstSelectedOption().getText();
        String elAfterSelectedTo = afterSelectedTo.getFirstSelectedOption().getText();

        Assert.assertTrue(elAfterSelectedFrom.equals(elAfterSelectedTo));
    }

    public void testcase08() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification on \"Statement details\" screen show defaults selection\n" +
                "-Document Language : English\n" +
                "-Statement Version : Condensed Statement \n" +
                "-Transaction Period : 6 months from present");
        String Statement14 = "images/Statement14" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement14);
        scenario.createNode(Given.class, "Statement Details screen").addScreenCaptureFromPath(Statement14).pass("pass");

        Select SelectedFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select SelectedTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        new SelectElement(SelectedFrom, 16, true);
        System.err.println("SelectedFrom = SelectedTo " + SelectedFrom.getFirstSelectedOption().getText() + " = " + SelectedTo.getFirstSelectedOption().getText());

        String Statement16 = "images/Statement16" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement16);
        scenario.createNode(Given.class, "Customer select exceed 6 months").addScreenCaptureFromPath(Statement16).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT).click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OneAppElementKeys.TITLE_POPUP)));
        WebElement TitlePopup = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP);
        String elTitlePopup = TitlePopup.getText();
        WebElement MessageExceeds = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_EXCEEDS);
        String elMessageExceeds = MessageExceeds.getText();
        WebElement BtnOkPopup = ttbTestContext.findElement(OneAppElementKeys.BTN_OK_POPUP);
        String elBtnOkPopup = BtnOkPopup.getText();
        System.err.println("elTitlePopup : " + elTitlePopup);
        System.err.println("elMessageExceeds : " + elMessageExceeds);
        System.err.println("elBtnOkPopup : " + elBtnOkPopup);
        Assert.assertTrue(elTitlePopup.equals("You request exceeds 6 months"));
        Assert.assertTrue(elMessageExceeds.equals("You can have maximum 6 months transaction per request."));
        Assert.assertTrue(elBtnOkPopup.equals("OK"));

        String Statement17 = "images/Statement17" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement17);
        scenario.createNode(Given.class, "After click generate statement, The system display popup error exceed 6 months").addScreenCaptureFromPath(Statement17).pass("pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "'Verification  Display  Alert pop-up. when customer click Ok button on alert pop-up.\n" +
                "Alert pop-up will clos and display show \"Statement details\" screen");
        String Statement18 = "images/Statement18" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement18);
        scenario2.createNode(Given.class, "Pop up exceed 6 months").addScreenCaptureFromPath(Statement18).pass("pass");
        BtnOkPopup.click();

        String Statement19 = "images/Statement19" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement19);
        scenario2.createNode(Given.class, "After customer click Ok button on alert pop-up, Alert pop-up will clos and display show Statement details screen").addScreenCaptureFromPath(Statement19).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT).click();
        Thread.sleep(3000);
        ExtentTest scenario3 = getFeature().createNode(Scenario.class, "Verification  Display  Alert pop-up. when customer click X button on alert pop-up.\n" +
                "Alert pop-up will clos and display show \"Statement details\" screen");
        String Statement20 = "images/Statement20" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement20);
        scenario3.createNode(Given.class, "Pop up exceed 6 months").addScreenCaptureFromPath(Statement20).pass("pass");
        Thread.sleep(3000);
        WebElement btnX = ttbTestContext.findElement(OneAppElementKeys.BTN_X_POPUP);
        btnX.click();
        String Statement27 = "images/Statement20" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement27);
        scenario3.createNode(Given.class, "After customer click X button on alert pop-up, Alert pop-up will clos and display show Statement details screen").addScreenCaptureFromPath(Statement27).pass("pass");

        Assert.assertTrue(elTitlePopup.equals("You request exceeds 6 months"));
        Assert.assertTrue(elMessageExceeds.equals("You can have maximum 6 months transaction per request."));
        Assert.assertTrue(elBtnOkPopup.equals("OK"));
    }

    public void testcase09() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        Select selectFrom = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_FROM));
        Select selectTo = new Select(ttbTestContext.findElement(OneAppElementKeys.PERIOD_TO));
        new SelectElement(selectFrom, 24, true);
        new SelectElement(selectTo, 24, true);

        String selectedFromOption = selectFrom.getFirstSelectedOption().getText();
        String selectedToOption = selectTo.getFirstSelectedOption().getText();
        System.err.println("selectedFromOption 312 : " + selectedFromOption);
        System.err.println("selectedToOption 321 : " + selectedToOption);
        Thread.sleep(2000);
        ExtentTest scenario = getFeature().createNode(Scenario.class, "<p>Display \"Statement Details\" screen \n" +
                "In Transection period \n" +
                "From Month Year value' will show maximum past 2 years.</p>");
        String Statement27 = "images/Statement27" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement27);
        scenario.createNode(Given.class, "'From Month Year value' will show maximum past 2 years.").addScreenCaptureFromPath(Statement27).pass("pass");
        new SelectElement(selectFrom, 1, true);
        new SelectElement(selectTo, 3, true);

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "'Verification on \"Statement details\" screen, when customer click Generate Statement Button.\n" +
                "The system will navigate to \"statement preview\" screen.\n" +
                "(use default selection\n" +
                "-Document Language : English\n" +
                "-Statement Version : Condensed Statement \n" +
                "-Transaction Period : 6 months from present )");
        String Statement28 = "images/Statement28" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement28);
        scenario2.createNode(Given.class, "Display \"Statement Details\" screen.").addScreenCaptureFromPath(Statement28).pass("pass");

        WebElement BtnGenerateStatement = ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT);
        BtnGenerateStatement.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PREVIEW_STATEMENT_SCREEN);

        String Statement29 = "images/Statement28" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement29);
        scenario2.createNode(Given.class, "Display \"Statement Details\" screen. When customer click Generate Statement Button. The system will display \"Statement Preview\" screen.").addScreenCaptureFromPath(Statement29).pass("pass");
    }

    public void testcase10() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        Thread.sleep(15000);
        WebElement TitlePreviewStatementScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_PREVIEW_STATEMENT_SCREEN);
        String elTitlePreviewStatementScreen = TitlePreviewStatementScreen.getText();
        WebElement BtnClose = ttbTestContext.findElement(OneAppElementKeys.BTN_CLOSE);
        WebElement BtnSave = ttbTestContext.findElement(OneAppElementKeys.BTN_SAVE);
        String elBtnSave = BtnSave.getText();
        WebElement BtnShare = ttbTestContext.findElement(OneAppElementKeys.BTN_SHARE);
        String elBtnShare = BtnShare.getText();

        System.err.println("elTitlePreviewStatementScreen : " + elTitlePreviewStatementScreen);
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "'Verification on \"Statement details\" screen, when customer click Generate Statement Button.\n" +
                "The system will navigate to \"statement preview\" screen.\n" +
                "(use default selection\n" +
                "-Document Language : English\n" +
                "-Statement Version : Condensed Statement \n" +
                "-Transaction Period : 6 months from present )");
        String Statement29 = "images/Statement29" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement29);
        scenario.createNode(Given.class, "Display \"Statement Details\" screen. When customer click Generate Statement Button. The system will display \"Statement Preview\" screen.").addScreenCaptureFromPath(Statement29).pass("pass");

        Assert.assertTrue(elTitlePreviewStatementScreen.equals("Statement"));
        Assert.assertTrue(elBtnSave.equals("Share File"));
        Assert.assertTrue(elBtnShare.equals("Save File"));
    }

    public void testcase11() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification Customer click Generated Statement button  and Then click back  to \"statement details\" screen again.\n" +
                "The system will show select data default.");
        String Statement30 = "images/Statement30" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement30);
        scenario.createNode(Given.class, "Statement Preview screen.").addScreenCaptureFromPath(Statement30).pass("pass");
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_PREVIEW_STATEMENT_SCREEN).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.RADIO_BTN_EN);

        String Statement31 = "images/Statement31" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement31);
        scenario.createNode(Given.class, "Customer click back icon to \"Statement Details\" again. On \"Statement Details\"  screen show select data default.\n" +
                "- Document Language : select English button.\n" +
                "- Statement Version : select Condensed Statement  button.\n" +
                "- Transection period show default 6 months from present").addScreenCaptureFromPath(Statement31).pass("pass");
    }

    public void testcase12() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification on \"Statement Previews\" screen  when customer click back icon to display \"statement details\" screen and customer change data selection and click generate statement button. The system will display \"Statement Preview\" screen and show update data on Statement preview.");
        String Statement32 = "images/Statement32" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement32);
        scenario.createNode(Given.class, "Statement Detail screen.").addScreenCaptureFromPath(Statement32).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).click();

        String Statement33 = "images/Statement33" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement33);
        scenario.createNode(Given.class, "Customer change data selection").addScreenCaptureFromPath(Statement33).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT).click();
        Thread.sleep(7000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PREVIEW_STATEMENT_SCREEN);

        String Statement34 = "images/Statement34" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement34);
        scenario.createNode(Given.class, "The system will display update data on Statement preview screen").addScreenCaptureFromPath(Statement34).pass("pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "Verification on \"Statement Preview\"  screen  when  customer press  Close  button.\n" +
                "The system will navigate to  Service Page (Document tab) screen");
        String Statement35 = "images/Statement35" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement35);
        scenario2.createNode(Given.class, "Statement Preview screen.").addScreenCaptureFromPath(Statement35).pass("pass");
    }

    public void testcase13() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification on \"Statement Previews\" screen  when customer click back icon to display \"statement details\" screen and customer change data selection and click generate statement button. The system will display \"Statement Preview\" screen and show update data on Statement preview.");
        String Statement32 = "images/Statement32" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement32);
        scenario.createNode(Given.class, "Statement Detail screen.").addScreenCaptureFromPath(Statement32).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_PREVIEW_STATEMENT_SCREEN).click();
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).click();
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_TH).click();

        String Statement33 = "images/Statement33" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement33);
        scenario.createNode(Given.class, "Customer change data selection").addScreenCaptureFromPath(Statement33).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT).click();
        Thread.sleep(7000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PREVIEW_STATEMENT_SCREEN);

        String Statement34 = "images/Statement34" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement34);
        scenario.createNode(Given.class, "The system will display update data on Statement preview screen").addScreenCaptureFromPath(Statement34).pass("pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "Verification on \"Statement Preview\"  screen  when  customer press  Close  button.\n" +
                "The system will navigate to  Service Page (Document tab) screen");
        String Statement35 = "images/Statement35" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement35);
        scenario2.createNode(Given.class, "Statement Preview screen.").addScreenCaptureFromPath(Statement35).pass("pass");
    }

    public void testcase14() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Verification on \"Statement Previews\" screen  when customer click back icon to display \"statement details\" screen and customer change data selection and click generate statement button. The system will display \"Statement Preview\" screen and show update data on Statement preview.");
        String Statement32 = "images/Statement32" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement32);
        scenario.createNode(Given.class, "Statement Detail screen.").addScreenCaptureFromPath(Statement32).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_PREVIEW_STATEMENT_SCREEN).click();
        ttbTestContext.findElement(OneAppElementKeys.RADIO_BTN_DETAIL_STATEMENT).click();

        String Statement33 = "images/Statement33" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement33);
        scenario.createNode(Given.class, "Customer change data selection").addScreenCaptureFromPath(Statement33).pass("pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_GENERATE_STATEMENT).click();
        Thread.sleep(7000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.TITLE_PREVIEW_STATEMENT_SCREEN);

        String Statement34 = "images/Statement34" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement34);
        scenario.createNode(Given.class, "The system will display update data on Statement preview screen").addScreenCaptureFromPath(Statement34).pass("pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "Verification on \"Statement Preview\"  screen  when  customer press  Close  button.\n" +
                "The system will navigate to  Service Page (Document tab) screen");
        String Statement35 = "images/Statement35" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement35);
        scenario2.createNode(Given.class, "Statement Preview screen.").addScreenCaptureFromPath(Statement35).pass("pass");
    }

    public void testcase15() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.BTN_CLOSE).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "Verification on \"Statement Preview\"  screen  when  customer press  Close  button.\n" +
                "The system will navigate to  Service Page (Document tab) screen");
        String Statement36 = "images/Statement37" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Statement36);
        scenario2.createNode(Given.class, "The system will navigate to  Service Page (Document tab) screen").addScreenCaptureFromPath(Statement36).pass("pass");
        getExtent().flush();
    }


}
