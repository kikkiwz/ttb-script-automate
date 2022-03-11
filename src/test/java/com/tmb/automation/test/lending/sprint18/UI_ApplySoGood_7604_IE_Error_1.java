package com.tmb.automation.test.lending.sprint18;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ApplySoGoodPage;
import com.tmb.automation.pages.lending.CreditLandingPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UI_ApplySoGood_7604_IE_Error_1 extends Base {
    private final String JSONPATH = "LendingResources/json/ApplySoGood.json";
    private Map<String, Object> hashMap = LendingTestLib.convertJsonToMap(JSONPATH);
    @Parameters({"DeviceProfile" })
    @BeforeMethod //(groups = {"ios", "lending", "Sprint15", "1309"})
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
//        mapData = Helper.getExcelData("TestData_lending", "TestData_7604", this.getClass().getSimpleName());
    }

    @AfterMethod //(groups = {"ios", "lending", "Sprint15", "1309"})
    public void teardown() {
        Base.driverQuit();
    }

    @Test //(groups = {"android", "lending", "Sprint15", "3123"})
    public void ADTest001() throws IOException, ParseException {
        log("------------Start " + this.getClass().getSimpleName());

        String pin = hashMap.get("ui_pin").toString();
        String plan = (String) ((JSONObject) (LendingTestLib.getJsonObect(JSONPATH)).get("UI_TestData")).get("InstallmentPlan");
        JSONArray jsonArray = (JSONArray) ((JSONObject) (LendingTestLib.getJsonObect(JSONPATH)).get("UI_TestData")).get("Transactions");
        ArrayList<String> list = new ArrayList<String>();
        if (jsonArray != null) {
            for (int i=0;i<jsonArray.size();i++){
                list.add(jsonArray.get(i).toString());
            }
        }
        LendingTestLib.navToHomeScreen("Accounts", "010203");
        LendingTestLib.navToAccounts("Cards");
        CreditLandingPage cl = new CreditLandingPage(appiumDriver);
        cl.setWebview();
        List<WebElement> cardNumbers = cl.fsXpath(cl.swCL_list_accountNumber);
        log("Click Apply So GooOD");
        cl.waitVisible(cl.swCL_applySoGood1, 100);
        for (int i=0;i<cardNumbers.size();i++){
            log(cardNumbers.get(i).getText());

        }
        cl.clickJS(cl.fX(cl.swCL_applySoGood1));
        //page1 - Term&Condition
        ApplySoGoodPage ld = new ApplySoGoodPage(appiumDriver);
        log("Select checkbox");
        ld.clickJS(cl.fX(ld.swAP1_checkbox1));
        ExtentReport4.printScreenshot("Term&Condition Page");
        log("Click Next button");
        ld.click(ld.fX(ld.swAP1_next));

        //page2 - Select Transaction
        ld.waitVisible("(//*[@id=\"cid\"]/div[1]/div)[2]");
        String cardNameAct = ld.fX(ld.swAP2_cardName).getText();
        String cardNumberAct = ld.fX(ld.swAP2_cardNumber).getText();
        log("cardName="+cardNameAct+"  cardNumber="+cardNumberAct);
        List<WebElement> transactionNames = ld.fsXpath(ld.swAP2_list_transactionNames);
        List<WebElement> transactionValues = ld.fsXpath(ld.swAP2_list_transactionValues);
        ld.click(transactionNames.get(0));
        sleep(1);
        ExtentReport4.printReportMessage("Click Select All");
        ld.click(transactionNames.get(0));
        sleep(1);
        ExtentReport4.printReportMessage("Click Deselect All");
        ld.scrollIntoView(transactionNames.get(transactionNames.size()-1));
        sleep(1);
        ExtentReport4.printReportMessage("scroll to down ");
        ld.scrollIntoView(ld.fX(ld.swAP2_searchBox));
        sleep();

        //------
        double totalValues = 0;
        String totalNames = "";
        for (int i = 0;i<list.size();i++){
            for (int j = 0; j<transactionValues.size();j++){
                if (list.get(i).toLowerCase().contains(transactionNames.get((j+1)).getText().toLowerCase())
                        && list.get(i).toLowerCase().contains(transactionValues.get(j).getText().toLowerCase()) ){
                    ld.click(transactionNames.get((j+1)));
                    totalNames +=transactionNames.get((j+1)).getText()+" "+transactionValues.get(j).getText()+",";
                    totalValues+=Double.parseDouble(transactionValues.get(j).getText().replaceAll(",",""));
                    break;
                }
            }
        }
        log("Totals="+totalValues);
        //------
        ExtentReport4.printReportMessage("TotalValues ="+totalValues);
        ExtentReport4.printReportMessage("TotalNames "+totalNames);
        ld.click(ld.fX(ld.swAP2_next));
        sleep();

        //page3 - Monthlyplan page
        String installPlanAct = "";
        double firstPaymentAct= 0;
        double totalInterestAct = 0;
        double totalAmountAct = 0;
        if (plan.equalsIgnoreCase("0.69% 6 Months")){
            log("0.69% 6 Months");
            ld.clickJS(ld.fX(ld.swAP3_MonthlyPlayment2_chb));
            installPlanAct = ld.fX(ld.swAP3_MonthlyPlayment2_lb).getText();
            firstPaymentAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_monthlyPayments_lb).get(1).getText().replaceAll(",",""));
            totalInterestAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalInterestAmounts_lb).get(1).getText().replaceAll(",",""));
            totalAmountAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalAmounts_lb).get(1).getText().replaceAll(",",""));
            double c4_principle = totalValues;
            double c5_tenor = 6;
            double c6_interestRest = 0.69/100;
            double c7_totalInterest = c4_principle*c5_tenor*c6_interestRest;
            double c8_monthlyPrinciple = c4_principle / c5_tenor;
            double c9_monthlyPriciple2digits = Round2Digits(c8_monthlyPrinciple);
            double c10_Diff = 0;
            double c11_monthlyInterest = c7_totalInterest/c5_tenor;
            double c12_monthlyInterest2digits = Round2Digits(c11_monthlyInterest);
            double c13_firstpayment = Round2Digits(c9_monthlyPriciple2digits+((c8_monthlyPrinciple-c9_monthlyPriciple2digits)*c5_tenor)+ Round2Digits(c12_monthlyInterest2digits));
            double c14_totalAmount = Round2Digits(((Round2Digits(c9_monthlyPriciple2digits+ Round2Digits(c12_monthlyInterest2digits)))*(c5_tenor-1))+c13_firstpayment);
            ld.assertText(String.valueOf(firstPaymentAct), String.valueOf(c13_firstpayment));
            ld.assertText(String.valueOf(totalInterestAct), String.valueOf(Round2Digits(c7_totalInterest)));
            ld.assertText(String.valueOf(totalAmountAct), String.valueOf(c14_totalAmount));
        }
        else if (plan.equalsIgnoreCase("0.69% 10 Months")){
            log("0.69% 10 Months");
            ld.clickJS(ld.fX(ld.swAP3_MonthlyPlayment3_chb));
            installPlanAct = ld.fX(ld.swAP3_MonthlyPlayment3_lb).getText();
            firstPaymentAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_monthlyPayments_lb).get(2).getText().replaceAll(",",""));
            totalInterestAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalInterestAmounts_lb).get(2).getText().replaceAll(",",""));
            totalAmountAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalAmounts_lb).get(2).getText().replaceAll(",",""));
            double c4_principle = totalValues;
            double c5_tenor = 10;
            double c6_interestRest = 0.69/100;
            double c7_totalInterest = c4_principle*c5_tenor*c6_interestRest;
            double c8_monthlyPrinciple = c4_principle / c5_tenor;
            double c9_monthlyPriciple2digits = Round2Digits(c8_monthlyPrinciple);
            double c10_Diff = 0;
            double c11_monthlyInterest = c7_totalInterest/c5_tenor;
            double c12_monthlyInterest2digits = Round2Digits(c11_monthlyInterest);
            double c13_firstpayment = Round2Digits(c9_monthlyPriciple2digits+((c8_monthlyPrinciple-c9_monthlyPriciple2digits)*c5_tenor)+ Round2Digits(c12_monthlyInterest2digits));
            double c14_totalAmount = Round2Digits(((Round2Digits(c9_monthlyPriciple2digits+ Round2Digits(c12_monthlyInterest2digits)))*(c5_tenor-1))+c13_firstpayment);
            ld.assertText(String.valueOf(firstPaymentAct), String.valueOf(c13_firstpayment));
            ld.assertText(String.valueOf(totalInterestAct), String.valueOf(Round2Digits(c7_totalInterest)));
            ld.assertText(String.valueOf(totalAmountAct), String.valueOf(c14_totalAmount));
        }
        else { //if (plan=="0% 3 Months")
            log("0% 3 Months");
            ld.clickJS(ld.fX(ld.swAP3_MonthlyPlayment1_chb));
            installPlanAct = ld.fX(ld.swAP3_MonthlyPlayment1_lb).getText();
            sleep(1);
            firstPaymentAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_monthlyPayments_lb).get(0).getText().replaceAll(",",""));
            totalInterestAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalInterestAmounts_lb).get(0).getText().replaceAll(",",""));
            totalAmountAct = Double.parseDouble(ld.fsXpath(ld.swAP3_list_totalAmounts_lb).get(0).getText().replaceAll(",",""));
            double c4_principle = totalValues;
            double c5_tenor = 3;
            double c6_interestRest = 0;
            double c7_totalInterest = c4_principle*c5_tenor*c6_interestRest;
            double c8_monthlyPrinciple = c4_principle / c5_tenor;
            double c9_monthlyPriciple2digits = Round2Digits(c8_monthlyPrinciple);
            double c10_Diff = 0;
            double c11_monthlyInterest = c7_totalInterest/c5_tenor;
            double c12_monthlyInterest2digits = Round2Digits(c11_monthlyInterest);
            double c13_firstpayment = Round2Digits(c9_monthlyPriciple2digits+((c8_monthlyPrinciple-c9_monthlyPriciple2digits)*c5_tenor)+ Round2Digits(c12_monthlyInterest2digits));
            double c14_totalAmount = Round2Digits(((Round2Digits(c9_monthlyPriciple2digits+ Round2Digits(c12_monthlyInterest2digits)))*(c5_tenor-1))+c13_firstpayment);
            ld.assertText(String.valueOf(firstPaymentAct), String.valueOf(c13_firstpayment));
            ld.assertText(String.valueOf(totalInterestAct), String.valueOf(Round2Digits(c7_totalInterest)));
            ld.assertText(String.valueOf(totalAmountAct), String.valueOf(c14_totalAmount));
        }

        ExtentReport4.printReportMessage("Click Radio button 1 ");

        ld.click(ld.fX(ld.swAP3_next));

        //page4 - Confirm page
        ld.click(ld.swAP4_selectedTransaction_btn);
        String confirmValue = "";
        String cardName = ld.fX(ld.swAP4_creditCard).getText();
        String cardNumber = ld.fX(ld.swAP4_creditNumber).getText();
        String installmentPlan = ld.fX(ld.swAP4_installmentPlan).getText();
        String firstPayment = ld.fX(ld.swAP4_firstPayment).getText();
        String totalInterest = ld.fX(ld.swAP4_TotalInterestPayment).getText();
        String totalAmount = ld.fX(ld.swAP4_TotalAmount).getText();
        List<WebElement> transactionItems = ld.fsXpath(ld.swAP4_list_transactionItems);
        List<WebElement> transactionvalues = ld.fsXpath(ld.swAP4_list_transactionValues);
        List<String> listTransactionItems = new ArrayList<>();

        confirmValue+="Card name="+cardName+","+"</br>";
        confirmValue+="Card number="+cardNumber+","+"</br>";
        confirmValue+="InstallMent Plan="+installmentPlan+","+"</br>";
        confirmValue+="First Payment="+firstPayment+","+"</br>";
        confirmValue+="Total Interest="+totalInterest+","+"</br>";
        confirmValue+="Total Amount="+totalAmount+","+"</br>";
        for (int i=0;i<transactionItems.size();i++){
            confirmValue+="Transaction "+i+" "+transactionItems.get(i).getText() + " " + transactionvalues.get(i).getText()+"</br>";
            listTransactionItems.add(transactionItems.get(i).getText() + " " + transactionvalues.get(i).getText());
        }
        ld.assertText(cardNameAct, cardName);
        ld.assertText(cardNumberAct, cardNumberAct);
        ld.assertText(installPlanAct, installmentPlan);
        ld.assertText(String.valueOf(totalInterestAct).replaceAll(",",""), String.valueOf(totalInterestAct));
        ld.assertText(String.valueOf(firstPayment).replaceAll(",",""), String.valueOf(firstPaymentAct));
        ld.assertText(String.valueOf(totalAmount).replaceAll(",",""), String.valueOf(totalAmountAct));
        for (int i=0; i< transactionvalues.size();i++){
            ld.assertContain(list.get(i), listTransactionItems.get(i));
        }

        ExtentReport4.printReportMessage(confirmValue);

        //Page5 Finish page.
        sleep();
        sleep(50);
        ld.click(ld.swAP4_next);
        sleep(10);
        ld.assertText(ld.fX(ld.swAP5_title).getText(), "so goood failed");//so goood successful
        ld.assertText(ld.fX(ld.swAP5_creditCardNo).getText(), cardName);
//        ld.assertText(ld.fX(ld.swAP5_selectedTransaction).getText(), "");
//        ld.assertText(ld.fX(ld.swAP5_totalInstallmentAmount).getText(), "");
        ld.assertText(ld.fX(ld.swAP5_installmentPlan).getText(), plan);
//        ld.assertText(ld.fX(ld.swAP5_transactionDate).getText(), "");
//        ld.assertText(ld.fX(ld.swAP5_transactionTime).getText(), "");
        ld.writeLog();
        ExtentReport4.printReportMessage("Finish");
    }
    private static double Round2Digits(double value){
        return Math.round(value* 100.0) / 100.0;
    }
}
