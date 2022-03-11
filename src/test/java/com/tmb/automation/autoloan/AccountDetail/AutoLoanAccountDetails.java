package com.tmb.automation.autoloan.AccountDetail;

import com.tmb.automation.autoloan.*;
import com.tmb.automation.autoloan.AutoloanPage.AccountDetailPage;
import com.tmb.automation.common.PhrasesConfigKey;
import com.tmb.automation.common.PhrasesConfigService;
import com.tmb.automation.common.PhrasesConfigServiceMongoDb;
import com.tmb.automation.util.Base;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Listeners(AllureListener.class)
public class AutoLoanAccountDetails extends Base {


    AccountDetailPage accountDetailPage;


    private String token;
    private JsonPath AccDetail;
    private PhrasesConfigService phrasesConfigService = new PhrasesConfigServiceMongoDb();


    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenShot() {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return bytes;
    }

    @BeforeTest
    public void OpeningApplication() throws IOException, InterruptedException {
        initialize_driver();
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNDA3OTk0NDk1OCwiYWNjb3VudE51bWJlciI6IjI2NjAwODI5NCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTgyOTQifQ==");
        String URL = AutoloanUtility.redirectURL(token);
        Thread.sleep(10000);
//		String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
//		System.out.println(filepath);
//		System.setProperty("webdriver.chrome.driver", filepath);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        accountDetailPage = new AccountDetailPage(driver);


    }

    @Step("Check Auto loan header ")
    private void CheckHeaderAccountDetail() throws InterruptedException, IOException, ParseException {
        Thread.sleep(10000);
        String Header = accountDetailPage.getHeader().getText();
        Assert.assertEquals(Header, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_header_autoloan));
        AccDetail = AutoloanUtility.JsonAccountDetail(token);
        String TermPaid = AccDetail.getString("data.response.hpAccountDetail.termspaid");
        int TermPaidBE = Integer.parseInt(TermPaid);
        Assert.assertEquals(accountDetailPage.getTermOfPaid().getText(), TermPaidBE + " " + phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_peroid)+ "\n"+ phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_no_of_total_paid));
        Boolean ProgressBar = accountDetailPage.getProgressBar().isDisplayed();
        Assert.assertTrue(ProgressBar);
        String TotalPaid = AccDetail.getString("data.response.hpAccountDetail.totalterms");
        int TotalPaidBE = Integer.parseInt(TotalPaid);
        Assert.assertEquals(accountDetailPage.getTotalTerm().getText(), TotalPaidBE +" "+ phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_peroid )+"\n"+phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_no_of_total_terms));
        Boolean CarPic = accountDetailPage.getBlueCar().isDisplayed();
        Assert.assertTrue(CarPic);
        Boolean carLogo = accountDetailPage.getCarLogo().isDisplayed();
        Assert.assertTrue(carLogo);
        String accNickNameBE = AccDetail.getString("data.response.hpAccountDetail.nickname");
        Assert.assertEquals(accountDetailPage.getAccountNickname().getText(), accNickNameBE);
        String accNoBE = AccDetail.getString("data.response.hpAccountDetail.accountno").substring(0, 2) + "-" + AccDetail.getString("data.response.hpAccountDetail.accountno").substring(2, 9);
        Assert.assertEquals(accountDetailPage.getAccNo().getText(), accNoBE);
        Assert.assertEquals(accountDetailPage.getHPLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_hire_purchase));
        String BalanceBE = AccDetail.getString("data.response.hpAccountDetail.osbalance");
        String BalanceFE = accountDetailPage.getBalance().getText().replaceAll(",", "").replace("฿", "").trim();
        Assert.assertEquals(BalanceFE, BalanceBE);
        Assert.assertEquals(accountDetailPage.getBalanceLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_balance_remaining));
        Assert.assertEquals(accountDetailPage.getHpDetailLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_hire_purchase_detail));
        String instalmentBE = AccDetail.getString("data.response.hpAccountDetail.installamt");
        String instalmentFE = accountDetailPage.getInstallment().getText().replaceAll(",", "").replace("฿", "").trim();
        Assert.assertEquals(instalmentFE, instalmentBE);
        Assert.assertEquals(accountDetailPage.getInstalmentLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_installment));
        String dueDateBE =  phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_every_date) +" "+ AccDetail.getString("data.response.hpAccountDetail.dueday")+ " " + phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_of_month);
        Assert.assertEquals(accountDetailPage.getDueDate().getText(), dueDateBE);
        String LastPayJson = AccDetail.getString("data.response.hpAccountDetail.lastpaydate");
        SimpleDateFormat textToDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = textToDate.parse(LastPayJson);
        String LastPayBE = new SimpleDateFormat("d MMM yyyy").format(date);
        System.err.println("This is backend Date : " + LastPayBE);
        Assert.assertEquals(accountDetailPage.getLastPay().getText(), LastPayBE);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.err.println(now);
        String nextPayDateJson = AccDetail.getString("data.response.hpAccountDetail.dueday");
        int dateFromBE = Integer.parseInt(nextPayDateJson);//get value from BE
        System.err.println("Today date is : " + now.getDayOfMonth());
        if (dateFromBE >= now.getDayOfMonth()) {
            Date b = new Date(now.getYear() - 1900, now.getMonthValue() - 1, dateFromBE);
            String nextPayDateBE = new SimpleDateFormat("d MMM yyyy").format(b);
            Assert.assertEquals(accountDetailPage.getNextPayDate().getText(), nextPayDateBE);
        } else {
            Date b = new Date(now.getYear() - 1900, now.getMonthValue(), dateFromBE);
            String nextPayDateBE = new SimpleDateFormat("d MMM yyyy").format(b);
            Assert.assertEquals(accountDetailPage.getNextPayDate().getText(), nextPayDateBE);
        }
        Date a = new Date(now.getYear() - 1900, now.getMonthValue(), now.getDayOfMonth());
        System.err.println(a);
        Assert.assertEquals(accountDetailPage.getNextPayLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_next_pay_date));
        Assert.assertEquals(accountDetailPage.getPayBillBTN().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_pay_bill_button));
        Boolean PayBillBTN = accountDetailPage.getPayBillBTN().isEnabled();
        Assert.assertTrue(PayBillBTN);
        Assert.assertEquals(accountDetailPage.getPaymentHisBTN().getText(), "Payment History");
        Assert.assertEquals(accountDetailPage.getCarDetailLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_detail));
        Assert.assertEquals(accountDetailPage.getBrandModel().getText(), AccDetail.getString("data.response.hpAccountDetail.model").trim());
        Assert.assertEquals(accountDetailPage.getBrandModelLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_brand_model));
        Assert.assertEquals(accountDetailPage.getLicensePlate().getText(), AccDetail.getString("data.response.hpAccountDetail.license").trim() + "\n" + AccDetail.getString("data.response.hpAccountDetail.licenseprovince").trim());
        String taxDueJson = AccDetail.getString("data.response.hpAccountDetail.taxduedate");
        Date taxDate = textToDate.parse(taxDueJson);
        String taxDueBE = new SimpleDateFormat("d MMM yyyy").format(taxDate);
        Assert.assertEquals(accountDetailPage.getTaxDueDate().getText(), taxDueBE);
        Assert.assertEquals(accountDetailPage.getTaxDueDateLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_tax_due_date));
        String insuranceJson = AccDetail.getString("data.response.hpAccountDetail.insuranceduedate");
        Date insuranceDate = textToDate.parse(insuranceJson);
        String insuranceDateBE = new SimpleDateFormat("d MMM yyyy").format(insuranceDate);
        Assert.assertEquals(accountDetailPage.getInsuranceDueDate().getText(), insuranceDateBE);
        Assert.assertEquals(accountDetailPage.getInsuranceDueDateLabel().getText(), "Insurance Due Date");
        Boolean ServiceRequest = accountDetailPage.getServiceRequestBTN().isDisplayed();
        Assert.assertTrue(ServiceRequest);
        takeScreenShot();
    }

    @Step("Check payment history")
    private void paymentHistory() throws InterruptedException {
        accountDetailPage.getPaymentHisBTN().click();
        Thread.sleep(5000);

    }

    @Test(description = "Account Detail TestCase")
    public void AccountDetail() throws InterruptedException, IOException, ParseException {
        CheckHeaderAccountDetail();
    }
}

