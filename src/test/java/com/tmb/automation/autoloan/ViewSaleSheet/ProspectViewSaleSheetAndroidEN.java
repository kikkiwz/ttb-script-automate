package com.tmb.automation.autoloan.ViewSaleSheet;

import com.tmb.automation.autoloan.AllureListener;
import com.tmb.automation.autoloan.AutoloanPage.InputCIDTelPage;
import com.tmb.automation.autoloan.AutoloanPage.LoanInputOTPPage;
import com.tmb.automation.autoloan.AutoloanPage.LoanStatusTrackingPage;
import com.tmb.automation.autoloan.AutoloanPage.ViewSaleSheetPage;
import com.tmb.automation.autoloan.AutoloanUtility;
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
public class ProspectViewSaleSheetAndroidEN extends Base {
    ViewSaleSheetPage viewSaleSheetPage;
    InputCIDTelPage inputCIDTelPage;
    LoanInputOTPPage loanInputOTPPage;
    LoanStatusTrackingPage loanStatusTrackingPage;
    private String token;
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenShot() throws IOException {
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return bytes;
    }

    @BeforeTest
    public void initial() throws InterruptedException, IOException {

        initialize_driver();
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMCIsInRpbWVTdGFtcCI6MTYxNDA3NjQ1Nzk0MywiZGV2aWNlSWQiOiJlMDc5NzBmNy0zN2U3LTQxMmYtYjMyZC03YzlhZGI3NTU1ZTAiLCJsYW5ndWFnZSI6ImVuIn0=");
        String URL = AutoloanUtility.ProspectAppListENURL(token);
        Thread.sleep(3000);
        String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
        System.out.println(filepath);
        System.setProperty("webdriver.chrome.driver", filepath);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        inputCIDTelPage = new InputCIDTelPage(driver);
        loanInputOTPPage = new LoanInputOTPPage(driver);
        loanStatusTrackingPage = new LoanStatusTrackingPage(driver);
        viewSaleSheetPage = new ViewSaleSheetPage(driver);

    }

    @Step("Enter Passport")
    private void EnterValidPassport () throws InterruptedException, IOException{

        Thread.sleep(10000);
        String header = inputCIDTelPage.getHeader().getText();
        Assert.assertEquals(header,"Loan Status");
        Boolean backBTN = inputCIDTelPage.getBackBTN().isDisplayed();
        Assert.assertTrue(backBTN);
        String placeHoler = inputCIDTelPage.getInputCIDPassport().getAttribute("placeholder");
        Assert.assertEquals(placeHoler,"ID card / Passport");
        String cidLabel = inputCIDTelPage.getCIDPassportLabel().getText();
        Assert.assertEquals(cidLabel,"ID card / Passport");
        String telPlaceholder = inputCIDTelPage.getInputTell().getAttribute("placeholder").trim();
        Assert.assertEquals(telPlaceholder,"10 digits");
        String telLabel = inputCIDTelPage.getTelLabel().getText();
        Assert.assertEquals(telLabel,"Mobile Number");
        Assert.assertEquals(inputCIDTelPage.getNote().getText(),"Please specify the mobile phone number which you provide when applying for a loan");
        inputCIDTelPage.getInputCIDPassport().clear();
        inputCIDTelPage.getInputCIDPassport().sendKeys("Z3381991");
        inputCIDTelPage.getInputTell().sendKeys("0946503883");
        Thread.sleep(500);
        takeScreenShot();
        inputCIDTelPage.getNextBTN().click();
    }
    @Step("Enter OTP")
    private void EnterOTP() throws IOException, InterruptedException{
        Thread.sleep(10000);
        Assert.assertEquals(loanInputOTPPage.getHeader().getText().trim(),"Verify OTP");
        Boolean backBTN = loanInputOTPPage.getBackBTN().isDisplayed();
        Assert.assertTrue(backBTN);
        Assert.assertEquals(loanInputOTPPage.getOtpDes().getText(),"Enter OTP sent via mobile number\n"+"086-XXX-X899");
        Boolean otpRef = loanInputOTPPage.getOtpRef().isDisplayed();
        Assert.assertTrue(otpRef);
        Boolean otp1 = loanInputOTPPage.getOtp1().isDisplayed();
        Boolean otp2 = loanInputOTPPage.getOtp2().isDisplayed();
        Boolean otp3 = loanInputOTPPage.getOtp3().isDisplayed();
        Boolean otp4 = loanInputOTPPage.getOtp4().isDisplayed();
        Boolean otp5 = loanInputOTPPage.getOtp5().isDisplayed();
        Boolean otp6 = loanInputOTPPage.getOtp6().isDisplayed();
        Assert.assertTrue(otp1);
        Assert.assertTrue(otp2);
        Assert.assertTrue(otp3);
        Assert.assertTrue(otp4);
        Assert.assertTrue(otp5);
        Assert.assertTrue(otp6);
        Boolean otpAgain = loanInputOTPPage.getOtpAgain().isDisplayed();
        Assert.assertEquals(loanInputOTPPage.getOtpAgain().getText(),"Resend OTP");
        loanInputOTPPage.getOtpAgain();
        loanInputOTPPage.getOtp1().sendKeys("1");
        Thread.sleep(1000);
        loanInputOTPPage.getOtp2().sendKeys("2");
        Thread.sleep(1000);
        loanInputOTPPage.getOtp3().sendKeys("3");
        Thread.sleep(1000);
        loanInputOTPPage.getOtp4().sendKeys("4");
        Thread.sleep(1000);
        loanInputOTPPage.getOtp5().sendKeys("5");
        Thread.sleep(1000);
        loanInputOTPPage.getOtp6().sendKeys("6");
    }

    @Step("Check Header TH")
    private void CheckLoanStatusHeader() throws InterruptedException {
        Thread.sleep(3000);
        String LoanStatusHeader = loanStatusTrackingPage.getLoanStatus_Header().getText();
        Assert.assertEquals(LoanStatusHeader, "Loan Status Tracking");
    }

    @Step("Check View Sale Sheet button TH")
    private void CheckViewSaleSheetBTN() throws IOException {
        Boolean ViewSaleSheetBTN = loanStatusTrackingPage.getViewSaleSheet_BTN().isDisplayed();
        String LabelBTN = loanStatusTrackingPage.getViewSaleSheet_BTN().getText();
        Assert.assertTrue(ViewSaleSheetBTN);
        Assert.assertEquals(LabelBTN, "View Sales Sheet");
        takeScreenShot();
    }

    @Step("Open view sale sheet page TH")
    private void OpenViewSaleSheetPage() throws IOException, InterruptedException {
        WebElement ViewSaleSheetBTN = loanStatusTrackingPage.getViewSaleSheet_BTN();
        ViewSaleSheetBTN.click();
        Thread.sleep(3000);
        takeScreenShot();
    }

    @Step("Check View Sale sheet Screen TH")
    private void ViewSaleSheetHeader() throws IOException, InterruptedException {
        Thread.sleep(30000);
        String SaleSheetHeader = viewSaleSheetPage.getHeader().getText();
        Assert.assertEquals(SaleSheetHeader, "Sales Sheet");
        Boolean BackBTN = viewSaleSheetPage.getBackBTN().isDisplayed();
        Assert.assertTrue(BackBTN);
        String EmailLabel = viewSaleSheetPage.getEnterEmail_Label().getText();
        String EmailPlaceHolder = viewSaleSheetPage.getEnterEmail_Input().getAttribute("placeholder");
        Assert.assertEquals(EmailLabel, "Email Address");
        Assert.assertEquals(EmailPlaceHolder, "Specify the email you want to send");
        Boolean SendEmailButton = viewSaleSheetPage.getSendEmail_BTN().isDisplayed();
        Assert.assertTrue(SendEmailButton);
        takeScreenShot();
    }

    @Step("Enter invalid Email TH")
    private void EnterInvalidEmail() throws InterruptedException, IOException {
        viewSaleSheetPage.getEnterEmail_Input().sendKeys("!@#$%^&");
        viewSaleSheetPage.getSendEmail_BTN().click();
        String WarningMSG = viewSaleSheetPage.getEmailIncorrect_Warning().getText();
        Assert.assertEquals(WarningMSG, "Email is a wrong format");
        Thread.sleep(1500);
        takeScreenShot();
    }

    @Step("Enter Valid Email TH")
    private void EnterValidEmail() throws InterruptedException, IOException {
        viewSaleSheetPage.getEnterEmail_Input().clear();
        viewSaleSheetPage.getEnterEmail_Input().sendKeys("tada.s@hotmail.com");
        Boolean SendEmailBTN = viewSaleSheetPage.getSendEmail_BTN().isDisplayed();
        Assert.assertTrue(SendEmailBTN);
        String SendEmailBTNLabel = viewSaleSheetPage.getSendEmail_BTN().getText();
        Assert.assertEquals(SendEmailBTNLabel,"Send Email");
        viewSaleSheetPage.getSendEmail_BTN().click();
        Thread.sleep(1500);
        Boolean SendEmailPopUp = viewSaleSheetPage.getSendEmailSuccess_POPUP().isDisplayed();
        Assert.assertTrue(SendEmailPopUp);
        String PopUpHeader = viewSaleSheetPage.getSendEmailSuccess_POPUP_Header().getText();
        Assert.assertEquals(PopUpHeader, "Email sent");
        String PopUpBody = viewSaleSheetPage.getSendEmailSuccess_POPUP_Body().getText();
        Assert.assertEquals(PopUpBody, "The sales sheet has been sent to the specified email address");
        String PopUpOK = viewSaleSheetPage.getSendEmailSuccess_POPUP_OKBTN().getText();
        Assert.assertEquals(PopUpOK, "OK");
        takeScreenShot();
    }

    @Step("Click OK on Popup TH")
    private void ClickOKPopup() throws InterruptedException, IOException {
        viewSaleSheetPage.getSendEmailSuccess_POPUP_OKBTN().click();
        Thread.sleep(500);
        takeScreenShot();
    }


    @Test(description = "View sale sheet Android TH")
    public void ProspectViewSaleSheetAndroidTH() throws IOException, InterruptedException {
        EnterValidPassport ();
        EnterOTP();
        CheckLoanStatusHeader();
        CheckViewSaleSheetBTN();
        OpenViewSaleSheetPage();
        ViewSaleSheetHeader();
        EnterInvalidEmail();
        EnterValidEmail();
        ClickOKPopup();
    }


}
