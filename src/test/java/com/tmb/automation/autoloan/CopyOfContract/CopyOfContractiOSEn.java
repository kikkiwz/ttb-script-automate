package com.tmb.automation.autoloan.CopyOfContract;

import com.tmb.automation.autoloan.*;
import com.tmb.automation.autoloan.AutoloanPage.ConfirmCopyOfContractPage;
import com.tmb.automation.autoloan.AutoloanPage.AccountDetailPage;
import com.tmb.automation.autoloan.AutoloanPage.CopyOfContractComplate;
import com.tmb.automation.autoloan.AutoloanPage.CopyOfContractInfoPage;
import com.tmb.automation.autoloan.AutoloanPage.ServiceListPage;
import com.tmb.automation.common.PhrasesConfigKey;
import com.tmb.automation.common.PhrasesConfigService;
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
public class CopyOfContractiOSEn extends Base {


	AccountDetailPage accountDetailPage;
	ServiceListPage serviceListPage;
	CopyOfContractInfoPage copyOfContractInfoPage;
	ConfirmCopyOfContractPage confirmCopyOfContractPage;
	CopyOfContractComplate copyOfContractComplate;
	public JsonPath beAccountDetail;
	public JsonPath getCusProfile;
	private PhrasesConfigService phrasesConfigService = new PhrasesConfigServiceLocal();
	private String token;


	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] takeScreenShot()  {
		byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return bytes;
	}

	@BeforeTest
	public void OpeningApplication() throws IOException, InterruptedException {
		token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNDA3OTk0NDk1OCwiYWNjb3VudE51bWJlciI6IjI2NjAwODI5NCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTgyOTQifQ==");
		initialize_driver();
		String URL= AutoloanUtility.redirectURL(token);
		Thread.sleep(3000);
//		String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
//		System.out.println(filepath);
//		System.setProperty("webdriver.chrome.driver", filepath);
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "iPhone X");
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		accountDetailPage = new AccountDetailPage(driver);
		serviceListPage = new ServiceListPage(driver);
		copyOfContractInfoPage = new CopyOfContractInfoPage(driver);
		confirmCopyOfContractPage = new ConfirmCopyOfContractPage(driver);
		copyOfContractComplate = new CopyOfContractComplate(driver);
	}
	@Step("Check Auto loan header ")
	private void CheckHeaderAccountDetail() throws InterruptedException, IOException{
		Thread.sleep(10000);
	    String Header = accountDetailPage.getHeader().getText();
	    Assert.assertEquals(Header,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_header_autoloan));
	    Boolean ServiceRequest = accountDetailPage.getServiceRequestBTN().isDisplayed();
	    Assert.assertTrue(ServiceRequest);
	    takeScreenShot();
	}
	@Step("Service request list screen")
	private void OpenServiceRequestList() throws InterruptedException {
		accountDetailPage.getServiceRequestBTN().click();
		Thread.sleep(8000);
		String ServiceRequestList = serviceListPage.getServiceList_header().getText();
		Assert.assertEquals(ServiceRequestList,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_title_autoloan_request_list));
		Boolean CopyOfContractBTN = serviceListPage.getCopyOfContact_BTN().isDisplayed();
		Assert.assertTrue(CopyOfContractBTN);
		String CopyOfContractBTNLabel = serviceListPage.getCopyOfContact_BTN().getText();
		Assert.assertEquals(CopyOfContractBTNLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_service_request05));
		Thread.sleep(1500);
		takeScreenShot();
	}

	@Step("Copy of contract Info screen")
	private void OpenCopyOfContractInfoScreen() throws InterruptedException {
		serviceListPage.getCopyOfContact_BTN().click();
		Thread.sleep(3000);
		String CopyOfContractHeader = copyOfContractInfoPage.getHeader().getText();
		Assert.assertEquals(CopyOfContractHeader, phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_title_autoloan_copy_of_contract_information));
		Boolean BackBTN = copyOfContractInfoPage.getBackBTn().isDisplayed();
		String CopyOfContractBody = copyOfContractInfoPage.getBody().getText();
		Assert.assertEquals(CopyOfContractBody,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_copy_of_contract_info));
		Boolean NextBTN = copyOfContractInfoPage.getNextBTn().isDisplayed();
		Assert.assertTrue(NextBTN);
		String NextBTNLabel = copyOfContractInfoPage.getNextBTn().getText();
		Assert.assertEquals(NextBTNLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.button_autoloan_copy_of_contract_info));
		Thread.sleep(1000);
		takeScreenShot();
	}

	@Step("Confirm Copy of Contract Request Screen")
	private void openConfirmCopyOfContract() throws InterruptedException, IOException {
		copyOfContractInfoPage.getNextBTn().click();
		Thread.sleep(3000);
		beAccountDetail = AutoloanUtility.JsonAccountDetail(token);
		String AccountNickNameBE = (beAccountDetail.getString("data.response.hpAccountDetail.nickname"));
		System.err.println(AccountNickNameBE);
		String AccountNickName = confirmCopyOfContractPage.getAccountNickName().getText();
		Assert.assertEquals(AccountNickName,AccountNickNameBE);
		String AccountNickNameLabel = confirmCopyOfContractPage.getAccountNickNameLabel().getText();
		Assert.assertEquals(AccountNickNameLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_account_name));
		String HPAccNOBE = beAccountDetail.getString("data.response.hpAccountDetail.accountno").substring(0,2)+"-"+ beAccountDetail.getString("data.response.hpAccountDetail.accountno").substring(2,9);
		String HPAccNOFE = confirmCopyOfContractPage.getAccountNO().getText();
		Assert.assertEquals(HPAccNOFE,HPAccNOBE);
		String hpAccLabel = confirmCopyOfContractPage.getAccountNoLabel().getText();
		Assert.assertEquals(hpAccLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_copy_of_contract_hire_purchase));
		String licensePlateBE = beAccountDetail.getString("data.response.hpAccountDetail.license")+beAccountDetail.getString("data.response.hpAccountDetail.licenseprovince").trim();
		String licensePlateFE = confirmCopyOfContractPage.getLicensePlate().getText();
		licensePlateBE = licensePlateBE.trim();
		licensePlateFE = licensePlateFE.chars().filter(c->c!=8197).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining()).trim();
		Assert.assertEquals(licensePlateFE,licensePlateBE);
		String licensePlateLabel = confirmCopyOfContractPage.getLicensePlateLabel().getText();
		Assert.assertEquals(licensePlateLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_license_plate));
		String EmailLabel = confirmCopyOfContractPage.getEmailLabel().getText();
		Assert.assertEquals(EmailLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_email));
		getCusProfile = AutoloanUtility.GetCosService(token);
		String EmailFromBE = getCusProfile.getString("data.email_address");
		System.err.println(EmailFromBE);
		String EmailAddress = confirmCopyOfContractPage.getEmailAddress().getAttribute("value");
		Assert.assertEquals(EmailAddress,EmailFromBE);
		Boolean nextBTN = confirmCopyOfContractPage.getNextBTN().isDisplayed();
		Assert.assertTrue(nextBTN);
		String nextBTNLabel = confirmCopyOfContractPage.getNextBTN().getText();
		Assert.assertEquals(nextBTNLabel,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.button_autoloan_copy_of_contract_confirm));
		takeScreenShot();
	}

	@Step("Edit email to invalid")
	private void editEmailInvalid() throws InterruptedException{
		confirmCopyOfContractPage.getEmailAddress().clear();
		confirmCopyOfContractPage.getEmailAddress().sendKeys("testtest");
		Thread.sleep(1000);
		confirmCopyOfContractPage.getNextBTN().click();
		String emptyEmail = confirmCopyOfContractPage.getEmptyEmail().getText();
		Assert.assertEquals(emptyEmail,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_msg_02));
		takeScreenShot();
	}


	@Step("Edit email to empty")
	private void editEmailEmpty() throws InterruptedException {
		confirmCopyOfContractPage.getEmailAddress().click();
		confirmCopyOfContractPage.getEmailAddress().click();
		confirmCopyOfContractPage.getEmailAddress().clear();

//		CCC.getEmailAddress().sendKeys(" ");
		String Print1 = confirmCopyOfContractPage.getEmailAddress().getText();
		String Print2 = confirmCopyOfContractPage.getEmailAddress().getAttribute("placeholder");
		System.err.println(Print1);
		System.err.println("leng"+Print1.length());
		System.err.println(Print2);
		Thread.sleep(4000);
		confirmCopyOfContractPage.getHeader().click();
		confirmCopyOfContractPage.getNextBTN().click();
//		CCC.getEmailAddress().clear();
		String emailPlaceHolder = confirmCopyOfContractPage.getEmailAddress().getAttribute("placeholder");
		Assert.assertEquals(emailPlaceHolder,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_email_placeholder));
		Thread.sleep(1500);
		String emptyEmail = confirmCopyOfContractPage.getEmptyEmail().getText();
		Assert.assertEquals(emptyEmail,phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_msg_01));
		takeScreenShot();
	}

	@Step("Edit Email to valid and confirm")
	private void editEmailToValid() throws InterruptedException{
		confirmCopyOfContractPage.getEmailAddress().clear();
		confirmCopyOfContractPage.getEmailAddress().sendKeys("suphakorn.ratsamee@gmail.com");
		Thread.sleep(1000);
		takeScreenShot();
		confirmCopyOfContractPage.getNextBTN().click();
	}

	@Step("Validate Copy of Contract Complate Screen")
	private void validateCopyOfContractConfirm() throws InterruptedException{
		Thread.sleep(15000);
		Assert.assertEquals(copyOfContractComplate.getComplateHeader().getText(),phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_title_autoloan_copy_of_contract_complete));
		Boolean successIcon = copyOfContractComplate.getSuccessICon().isDisplayed();
		Assert.assertTrue(successIcon);
		Assert.assertEquals(copyOfContractComplate.getBody().getText(),phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_copy_of_contract_complete_description));
		Assert.assertEquals(copyOfContractComplate.getContractReqLable().getText(),phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.lable_autoloan_copy_of_contract_complete_label));
		Assert.assertEquals(copyOfContractComplate.getReqNoLable().getText(),phrasesConfigService.getValueEn(PhrasesConfigKey.AUTO_LOAN_KEY.label_autoloan_copy_of_contract_complete_request_num));
		takeScreenShot();
	}



	@Test(description = "Copy of contract")
	public void CopyOfContract() throws InterruptedException, IOException {
		CheckHeaderAccountDetail();
		OpenServiceRequestList();
		OpenCopyOfContractInfoScreen();
		openConfirmCopyOfContract();
		editEmailInvalid();
		editEmailToValid();
		validateCopyOfContractConfirm();
	}

}
