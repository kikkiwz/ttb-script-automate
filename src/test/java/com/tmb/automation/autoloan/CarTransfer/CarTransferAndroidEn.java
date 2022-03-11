package com.tmb.automation.autoloan.CarTransfer;

import com.tmb.automation.autoloan.*;
import com.tmb.automation.autoloan.AutoloanPage.*;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Listeners(AllureListener.class)
public class CarTransferAndroidEn extends Base {


    AccountDetailPage accountDetailPage;
    ServiceListPage serviceListPage;
    CarTransferInfoPage carTransferInfoPage;
    public JsonPath beAccountDetail;
    public JsonPath getCusProfile;
    private PhrasesConfigService phrasesConfigService = new PhrasesConfigServiceMongoDb();
    private String token;
    ConfirmCarTransferPage confirmCarTransferPage;
    ComplateCopyOfCartransferPage complateCopyOfCartransferPage;


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
        Thread.sleep(3000);
//        String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
//        System.out.println(filepath);
//        System.setProperty("webdriver.chrome.driver", filepath);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        accountDetailPage = new AccountDetailPage(driver);
        serviceListPage = new ServiceListPage(driver);
        carTransferInfoPage = new CarTransferInfoPage(driver);
        confirmCarTransferPage = new ConfirmCarTransferPage(driver);
        complateCopyOfCartransferPage = new ComplateCopyOfCartransferPage(driver);


    }

    @Step("Check Auto loan header ")
    private void CheckHeaderAccountDetail() throws InterruptedException, IOException {
        Thread.sleep(10000);
        String Header = accountDetailPage.getHeader().getText();
        Assert.assertEquals(Header, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_header_autoloan));
        Boolean ServiceRequest = accountDetailPage.getServiceRequestBTN().isDisplayed();
        Assert.assertTrue(ServiceRequest);
        takeScreenShot();
    }

    @Step("Service request list screen")
    private void OpenServiceRequestList() throws InterruptedException {
        accountDetailPage.getServiceRequestBTN().click();
        Thread.sleep(10000);
        String ServiceRequestList = serviceListPage.getServiceList_header().getText();
        Assert.assertEquals(ServiceRequestList, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_lists_for_service_request_header));
        Boolean carTransferBTN = serviceListPage.getCarTransferBTn().isDisplayed();
        Assert.assertTrue(carTransferBTN);
        String CopyOfContractBTNLabel = serviceListPage.getCarTransferBTn().getText();
        Assert.assertEquals(CopyOfContractBTNLabel, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_status_lists_for_service_request_objective_id_03));
        Thread.sleep(1500);
        takeScreenShot();
    }

    @Step("Copy of car transfer info page")
    private void OpenCarTransferInfoScreen() throws InterruptedException {
        serviceListPage.getCarTransferBTn().click();
        Thread.sleep(5000);
        String header = carTransferInfoPage.getHeader().getText();
        Assert.assertEquals(header, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_transfer_transfer_info_title));
        Assert.assertEquals(carTransferInfoPage.getBody().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_transfer_transfer_info_label));
        Boolean nextBTNInfoPage = (carTransferInfoPage.getNextBTN().isDisplayed());
        Assert.assertTrue(nextBTNInfoPage);
        Assert.assertEquals(carTransferInfoPage.getNextBTN().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_transfer_next_button_Old));
        takeScreenShot();
        carTransferInfoPage.getNextBTN().click();
    }

    @Step("Validate copy of car transfer confirm page")
    private void CopyOfCarTransferConfirmPage() throws InterruptedException, IOException {
        Thread.sleep(5000);
        Assert.assertEquals(confirmCarTransferPage.getHeader().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_transfer_confirm_request_title));
        Assert.assertEquals(confirmCarTransferPage.getTransferFormLabel().getText(), phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_car_transfer_request_info));
        beAccountDetail = AutoloanUtility.JsonAccountDetail(token);
        String accNickNameBE = beAccountDetail.getString("data.response.hpAccountDetail.nickname");
        Assert.assertEquals(confirmCarTransferPage.getAccNickName().getText(), accNickNameBE);
        Assert.assertEquals(confirmCarTransferPage.getAccNickNameLabel().getText(), "Account Name");
        String accNameBE = beAccountDetail.getString("data.response.hpAccountDetail.accountno").substring(0, 2) + "-" + beAccountDetail.getString("data.response.hpAccountDetail.accountno").substring(2, 9);
        Assert.assertEquals(confirmCarTransferPage.getAccName().getText(), accNameBE);
        Assert.assertEquals(confirmCarTransferPage.getAccNameLabel().getText(), "Hire Purchase");
        String licensePlateBE = beAccountDetail.getString("data.response.hpAccountDetail.license") + beAccountDetail.getString("data.response.hpAccountDetail.licenseprovince").trim();
        String licensePlateFE = confirmCarTransferPage.getLicensePlate().getText();
        licensePlateBE = licensePlateBE.trim();
        licensePlateFE = licensePlateFE.chars().filter(c -> c != 8197).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()).trim();
        Assert.assertEquals(licensePlateFE, licensePlateBE);
        Assert.assertEquals(confirmCarTransferPage.getLicensePlateLabel().getText(), "License Plate");
        getCusProfile = AutoloanUtility.GetCosService(token);
        String EmailFromBE = getCusProfile.getString("data.email_address");
        Assert.assertEquals(confirmCarTransferPage.getInPutEmail().getAttribute("value"), EmailFromBE);
        Assert.assertEquals(confirmCarTransferPage.getEmailLabel().getText(), "Email Address");
        Assert.assertEquals(confirmCarTransferPage.getDisclaimer().getText(), "Email can be changed for this document request only");
        Boolean nextBTNConfirm = confirmCarTransferPage.getConfirmBTN().isDisplayed();
        Assert.assertTrue(nextBTNConfirm);
        Assert.assertEquals(confirmCarTransferPage.getConfirmBTN().getText(), "Confirm");
        takeScreenShot();
//		confirmCarTransferPage.getConfirmBTN().click();
    }

    @Step("Edit Email to invalid")
    private void editEmailToInvalid() throws InterruptedException, IOException {
        confirmCarTransferPage.getInPutEmail().clear();
        confirmCarTransferPage.getInPutEmail().sendKeys("Automation.Test");
        Thread.sleep(2000);
        confirmCarTransferPage.getConfirmBTN().click();
        takeScreenShot();
    }

    @Step("Edit Email to blank")
    private void editEmailToBlank() {
        confirmCarTransferPage.getInPutEmail().clear();
        confirmCarTransferPage.getConfirmBTN().click();
        takeScreenShot();
    }

    @Step("Edit Email to valid")
    private void editEmailToValid() throws InterruptedException {
        confirmCarTransferPage.getInPutEmail().clear();
        confirmCarTransferPage.getInPutEmail().sendKeys("supakorn.ratsamee@gmail.com");
        Thread.sleep(2000);
        confirmCarTransferPage.getConfirmBTN().click();
        takeScreenShot();
    }

    @Step("Validate Complate Screen ")
    public void validateComPlateScreen() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals(complateCopyOfCartransferPage.getHeaderComPlateCarTransfer().getText(), "Complete Request");
        Boolean CorrectSymbol = complateCopyOfCartransferPage.getCorrectSymbol().isDisplayed();
        Assert.assertTrue(CorrectSymbol);
        Assert.assertEquals(complateCopyOfCartransferPage.getBodyComPlateOfCarTransfer().getText(), "The document will be sent to your email within 1 business day.");
        Assert.assertEquals(complateCopyOfCartransferPage.getEmail().getText(), "supakorn.ratsamee@gmail.com");
        Boolean backToServiceReqBTN = complateCopyOfCartransferPage.getBackToServiceReq().isDisplayed();
        Assert.assertTrue(backToServiceReqBTN);
        takeScreenShot();
        complateCopyOfCartransferPage.getBackToServiceReq().click();
    }

    @Step("Validate back to service request list")
    private void backToServiceListScreen() throws InterruptedException {
        Thread.sleep(5000);
    }


    @Test(description = "Copy of Car Transfer Positive")
    public void CopyOfCarTransferPositive() throws InterruptedException, IOException {
        CheckHeaderAccountDetail();
        OpenServiceRequestList();
        OpenCarTransferInfoScreen();
        CopyOfCarTransferConfirmPage();
        editEmailToInvalid();
        editEmailToBlank();
        editEmailToValid();
        validateComPlateScreen();
        backToServiceListScreen();

    }

}
