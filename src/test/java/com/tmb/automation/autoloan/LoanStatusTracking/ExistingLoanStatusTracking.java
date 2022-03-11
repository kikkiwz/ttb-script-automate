package com.tmb.automation.autoloan.LoanStatusTracking;

import com.tmb.automation.autoloan.*;
import com.tmb.automation.autoloan.AutoloanPage.LoanStatusTrackingPage;
import com.tmb.automation.common.PhrasesConfigKey;
import com.tmb.automation.common.PhrasesConfigService;
import com.tmb.automation.util.Base;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(AllureListener.class)
public class ExistingLoanStatusTracking extends Base {


    LoanStatusTrackingPage loanStatusTrackingPage;

    private String token;
    public JSONObject beApplicationsList, beApplicationDetail;
    private PhrasesConfigService phrasesConfigService = new PhrasesConfigServiceLocal();

    String id = "";

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenShot() {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return bytes;
    }

    @BeforeTest
    public void initial() throws InterruptedException, IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNjE0MzEzNDk4NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        initialize_driver();
        String URL = AutoloanUtility.ExistingAppListENURL(token);
        String[] x = URL.split("&_id=");
        id = x[1].replace("&lng=en", "");
        System.err.println("This ID:" + id);
        Thread.sleep(3000);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        loanStatusTrackingPage = new LoanStatusTrackingPage(driver);

    }

    @Step("Check Header EN ")
    private void CheckLoanStatusHeader() throws InterruptedException {
        Thread.sleep(15000);
        String LoanStatusHeader = loanStatusTrackingPage.getLoanStatus_Header().getText();
        Assert.assertEquals(LoanStatusHeader, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_title_autoloan_status_tracking_list));
    }

    @Step("Check Body and View Sale sheet BTN")
    private void checkBodyAndViewSaleSheetBTN() {
        beApplicationsList = AutoloanUtility.getLoanStatusApplicationsList(token, id);
        System.err.println("This from BE : " + beApplicationsList);
        JSONArray allLoanlist = (beApplicationsList.getJSONObject("data").getJSONArray("WSRecord"));
        System.err.println("This is all list from back end: " + allLoanlist);
        int arraySize = (allLoanlist.length());
        System.err.println("This Array size " + arraySize);
        for (int i = 0; i < arraySize; i++) {
            JSONObject List = allLoanlist.getJSONObject(i);
            String AppNo = List.optString("AppNo");
            String carBrand = List.optString("CarBrand");
            String carFamily = List.optString("CarFamily");
            System.err.println("This app no :" + i + AppNo);
            System.err.println("This car brand :" + i + carBrand);
            switch (i) {
                case 0:
                    Assert.assertEquals(loanStatusTrackingPage.getViewLoanStatusBTN0().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_tracking_hp_application_number)+" " + AppNo + "\n" + carBrand + " " + carFamily);
                    break;
                case 1:
                    Assert.assertEquals(loanStatusTrackingPage.getViewLoanStatusBTN1().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_tracking_hp_application_number)+" " + AppNo + "\n" + carBrand + " " + carFamily);
                    break;
                case 2:
                    Assert.assertEquals(loanStatusTrackingPage.getViewLoanStatusBTN2().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_tracking_hp_application_number)+" " + AppNo + "\n" + carBrand + " " + carFamily);
                    break;
                case 3:
                    Assert.assertEquals(loanStatusTrackingPage.getViewLoanStatusBTN3().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_tracking_hp_application_number)+" " + AppNo + "\n" + carBrand + " " + carFamily);
                    break;
                case 4:
                    Assert.assertEquals(loanStatusTrackingPage.getViewLoanStatusBTN4().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_tracking_hp_application_number)+" " + AppNo + "\n" + carBrand + " " + carFamily);
                    break;
            }
        }
        Boolean viewSalesheetBTN = loanStatusTrackingPage.getViewSaleSheet_BTN().isDisplayed();
        Assert.assertTrue(viewSalesheetBTN);
        takeScreenShot();
    }

    @Step("Open and check detail of loan status")
    private void openAndCheckDetailOfLoan() throws InterruptedException {
        loanStatusTrackingPage.getViewLoanStatusBTN0().click();
        Thread.sleep(5000);
        beApplicationDetail = AutoloanUtility.getLoanStatusDetail(token , id);
        JSONArray loanDetail = beApplicationDetail.getJSONObject("data").getJSONArray("WSRecord");
        JSONObject detail = loanDetail.getJSONObject(0);
        String appNo = detail.optString("AppNo");
        String carBrand = detail.optString("CarBrand");
        String carFamily = detail.optString("CarFamily");
        takeScreenShot();
//        Assert.assertEquals();


    }

    @Test(description = "Validate loan status tracking")
    public void validateLoanStatusTracking() throws InterruptedException {
        CheckLoanStatusHeader();
        checkBodyAndViewSaleSheetBTN();
        openAndCheckDetailOfLoan();
    }
}
