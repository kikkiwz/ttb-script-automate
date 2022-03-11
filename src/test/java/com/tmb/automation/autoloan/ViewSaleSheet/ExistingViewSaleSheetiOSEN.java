package com.tmb.automation.autoloan.ViewSaleSheet;

import com.tmb.automation.autoloan.*;
import com.tmb.automation.autoloan.AutoloanPage.LoanStatusTrackingPage;
import com.tmb.automation.autoloan.AutoloanPage.ViewSaleSheetPage;
import com.tmb.automation.common.PhrasesConfigKey;
import com.tmb.automation.common.PhrasesConfigService;
import com.tmb.automation.util.Base;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
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
public class ExistingViewSaleSheetiOSEN extends Base {


    LoanStatusTrackingPage loanStatusTrackingPage;
    ViewSaleSheetPage viewSaleSheetPage;
    private String token;
    private PhrasesConfigService phrasesConfigService = new PhrasesConfigServiceLocal();


    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenShot()  {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return bytes;
    }

    @BeforeTest
    public void initial() throws InterruptedException, IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNjE0MzEzNDk4NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        initialize_driver();
        String URL = AutoloanUtility.ExistingAppListENURL(token);
        Thread.sleep(3000);
//        String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
//        System.out.println(filepath);
//        System.setProperty("webdriver.chrome.driver", filepath);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        loanStatusTrackingPage = new LoanStatusTrackingPage(driver);
        viewSaleSheetPage = new ViewSaleSheetPage(driver);

    }

    @Step("Check Header EN ")
    private void CheckLoanStatusHeader() throws InterruptedException {
        Thread.sleep(15000);
        String LoanStatusHeader = loanStatusTrackingPage.getLoanStatus_Header().getText();
        Assert.assertEquals(LoanStatusHeader, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_title_autoloan_status_tracking_list) );
    }

    @Step("Check View Sale Sheet button")
    private void CheckViewSaleSheetBTN() throws IOException {
        Boolean ViewSaleSheetBTN = loanStatusTrackingPage.getViewSaleSheet_BTN().isDisplayed();
        String LabelBTN = loanStatusTrackingPage.getViewSaleSheet_BTN().getText();
        Assert.assertTrue(ViewSaleSheetBTN);
        Assert.assertEquals(LabelBTN, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.button_autoloan_view_sales_sheet));
        takeScreenShot();
    }

    @Step("Open view sale sheet page EN")
    private void OpenViewSaleSheetPage() throws IOException, InterruptedException {
        WebElement ViewSaleSheetBTN = loanStatusTrackingPage.getViewSaleSheet_BTN();
        ViewSaleSheetBTN.click();
        Thread.sleep(3000);
        takeScreenShot();
    }

    @Step("Check View Sale sheet Screen EN")
    private void ViewSaleSheetHeader() throws IOException, InterruptedException {
        Thread.sleep(35000);
        String SaleSheetHeader = viewSaleSheetPage.getHeader().getText();
        Assert.assertEquals(SaleSheetHeader, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_sale_sheet));
        Boolean BackBTN = viewSaleSheetPage.getBackBTN().isDisplayed();
        Assert.assertTrue(BackBTN);
        String EmailLabel = viewSaleSheetPage.getEnterEmail_Label().getText();
        String EmailPlaceHolder = viewSaleSheetPage.getEnterEmail_Input().getAttribute("placeholder");
        Assert.assertEquals(EmailLabel, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_sale_sheet_email));
        Assert.assertEquals(EmailPlaceHolder, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_email_placeholder));
        Boolean SendEmailButton = viewSaleSheetPage.getSendEmail_BTN().isDisplayed();
        Assert.assertTrue(SendEmailButton);
        takeScreenShot();
    }

    @Step("Enter invalid Email EN")
    private void EnterInvalidEmail() throws InterruptedException, IOException {
        viewSaleSheetPage.getEnterEmail_Input().sendKeys("!@#$%^&");
        viewSaleSheetPage.getSendEmail_BTN().click();
        String WarningMSG = viewSaleSheetPage.getEmailIncorrect_Warning().getText();
        Assert.assertEquals(WarningMSG, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_sales_sheet_msg_02));
        Thread.sleep(1500);
        takeScreenShot();
    }

    @Step("Enter Valid Email EN")
    private void EnterValidEmail() throws InterruptedException, IOException {
        viewSaleSheetPage.getEnterEmail_Input().clear();
        viewSaleSheetPage.getEnterEmail_Input().sendKeys("tada.s@hotmail.com");
        Boolean SendEmailBTN = viewSaleSheetPage.getSendEmail_BTN().isDisplayed();
        Assert.assertTrue(SendEmailBTN);
        String SendEmailBTNLabel = viewSaleSheetPage.getSendEmail_BTN().getText();
        Assert.assertEquals(SendEmailBTNLabel, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.button_autoloan_send_email));
        viewSaleSheetPage.getSendEmail_BTN().click();
        Thread.sleep(1500);
        Boolean SendEmailPopUp = viewSaleSheetPage.getSendEmailSuccess_POPUP().isDisplayed();
        Assert.assertTrue(SendEmailPopUp);
        String PopUpHeader = viewSaleSheetPage.getSendEmailSuccess_POPUP_Header().getText();
        Assert.assertEquals(PopUpHeader.trim(),  phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_email_sent));
        String PopUpBody = viewSaleSheetPage.getSendEmailSuccess_POPUP_Body().getText();
        Assert.assertEquals(PopUpBody,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_sales_sheet_msg_03) );
        String PopUpOK = viewSaleSheetPage.getSendEmailSuccess_POPUP_OKBTN().getText();
        Assert.assertEquals(PopUpOK, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.button_autoloan_calculate_close_account_ok));
        takeScreenShot();
    }

    @Step("Click OK on Popup EN")
    private void ClickOKPopup() throws InterruptedException, IOException {
        viewSaleSheetPage.getSendEmailSuccess_POPUP_OKBTN().click();
        Thread.sleep(500);
        takeScreenShot();
    }


    @Test(description = "View sale sheet Android EN")
    public void ViewSaleSheetAndroidTH() throws IOException, InterruptedException {
        CheckLoanStatusHeader();
        CheckViewSaleSheetBTN();
        OpenViewSaleSheetPage();
        ViewSaleSheetHeader();
        EnterInvalidEmail();
        EnterValidEmail();
        ClickOKPopup();
    }


}
