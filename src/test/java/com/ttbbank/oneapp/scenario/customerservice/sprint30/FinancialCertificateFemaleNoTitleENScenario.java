package com.ttbbank.oneapp.scenario.customerservice.sprint30;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.automation.util.TextColor;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.assets_deposit.DepositResponse;
import com.ttbbank.oneapp.framework.model.customerservice.assets_mutualfund.MutualFundResponse;
import com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class FinancialCertificateFemaleNoTitleENScenario extends BaseScenario {
    String firstName = null;
    String middleName = null;
    String lastName = null;
    String accountNameEn1 = null;
    double accountBalance1 = 0;
    String accountNumber1 = null;
    String accountNameEn2 = null;
    double accountBalance2 = 0;
    String accountNumber2 = null;
    String accountNameEn3 = null;
    double accountBalance3 = 0;
    String accountNumber3 = null;
    String objBodyMutualFund = null;
    ArrayList<String> portNumber = new ArrayList<String>();
    double totalBalance_deposit = 0;
    double totalBalance_investment = 0;
    double totalBalance = 0;

    @Test(groups = "Customer Service Financial Certificate no tile en gender female", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void FinancialCertificate() throws Exception {
        TC_Financial_Certificate_0001();
        TC_Financial_Certificate_0002();
        TC_Financial_Certificate_0003();
        TC_Financial_Certificate_0004();
        TC_Financial_Certificate_0005();
        TC_Financial_Certificate_0006();
        TC_Financial_Certificate_0007();
    }

    public void TC_Financial_Certificate_0001() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
        if(ttbTestContext.isAndroid()){
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        WebElement financialCertificateBtnService = ttbTestContext.findElement(OneAppElementKeys.FINANCIAL_CERTIFICATE_SERVICE_BUTTON);
        financialCertificateBtnService.click();
        try {
            String TitleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE).getText();
            String DetailTutorial = ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_STATEMENT_FINANCIAL_CERTIFICATE).getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_FINANCIAL_CERTIFICATE);
            String elBtnStart = btnStart.getText();
            System.out.println("TitleTutorial : " + TitleTutorial);
            System.out.println("DetailTutorial : " + DetailTutorial);
            System.out.println("elBtnStart : " + elBtnStart);
            btnStart.click();
        } catch (Exception e) { }
        String TitleHeader = ttbTestContext.findElement(OneAppElementKeys.TITLE_SERVICE_DETAIL_SCREEN).getText();
        String ServiceDetailFinancial = ttbTestContext.findElement(OneAppElementKeys.LABEL_SERVICE_DETAIL).getText();
        String ServiceDetailTextBullet1 = ttbTestContext.findElement(OneAppElementKeys.SERVICE_DETAIL_BULLET_1).getText();
        String DetailTextBullet1 = ttbTestContext.findElement(OneAppElementKeys.DETAIL_BULLET_1).getText();
        String ServiceDetailTextBullet2 = ttbTestContext.findElement(OneAppElementKeys.SERVICE_DETAIL_BULLET_2).getText();
        String ServiceDetailTextBullet3 = ttbTestContext.findElement(OneAppElementKeys.SERVICE_DETAIL_BULLET_3).getText();
        String ServiceDetailTextBullet4 = ttbTestContext.findElement(OneAppElementKeys.SERVICE_DETAIL_BULLET_4).getText();
        String BtnNextServiceDetailScreen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_SERVICE_DETAIL_FINANCIAL).getText();
        System.err.println("TitleHeader : " + TitleHeader);
        System.err.println("ServiceDetailFinancial : " + ServiceDetailFinancial);
        System.err.println("ServiceDetailTextBullet1 : " + ServiceDetailTextBullet1);
        System.err.println("DetailTextBullet1 : " + DetailTextBullet1);
        System.err.println("ServiceDetailTextBullet2 : " + ServiceDetailTextBullet2);
        System.err.println("ServiceDetailTextBullet3 : " + ServiceDetailTextBullet3);
        System.err.println("ServiceDetailTextBullet4 : " + ServiceDetailTextBullet4);
        System.err.println("BtnNextServiceDetailScreen : " + BtnNextServiceDetailScreen);

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12691_MydocFincertPIN_00001");
        scenario.createNode(Given.class, "Test Step Description : Validate a display of Enter PIN Screen after clicking at Financial Certificate menu in case\n" +
                "- The customer already authenticated");
        scenario.createNode("<pre>Expected Result : The system should display the Service Detail screen.</pre>");
        String serviceDetail = "images/FinancialCertificateFemaleNoTitleEN_serviceDetail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(serviceDetail);
        scenario.createNode(Given.class, "<pre>Actual Result : The system should display the Service Detail screen.</pre>\"").addScreenCaptureFromPath(serviceDetail).pass("Pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "TC_ONEAPP-12692_FinServiceDetails_00001");
        scenario2.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate Service Details screen\n" +
                "- Device: Android</pre>");
        scenario2.createNode(Given.class, "<pre>Expected Result : 1. After the customer press on a Financial Certificate menu or correct the PIN (if not log in yet ), the system will display the Service Detail screen.\n" +
                "2 The Service Detail screen contain the following fields:\n" +
                "- Back Icon :  navigate to the previous screen.\n" +
                "- Text Screen: Financial Certificate\n" +
                "- Text Title: Service Details\n" +
                "- Text Detail_1: To certify for other person\n" +
                "- Text Detail_2: Please prepare name and surname of the person to be certified in English which has  to be the same as in shown the passport\n" +
                "- Text Detail_3: Only personal assets can be certified\n" +
                "- Text Detail_4: E-Financial Certificate is free of charge\n" +
                "- Next button\n" +
                "3. The Customer press the Next button, the system will display a Certificate Detail screen.\n" +
                "*Note \n" +
                "Ref: Copy right in Ziplin</pre>");
        scenario2.createNode(Given.class, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(TitleHeader)
                + "</br>Display Text Title : " + TextColor.blueColor(ServiceDetailFinancial)
                + "</br>Display Text Detail_1 : " + TextColor.blueColor(ServiceDetailTextBullet1)
                + "</br>Display Text Detail_1 : " + TextColor.blueColor(DetailTextBullet1)
                + "</br>Display Text Detail_2 : " + TextColor.blueColor(ServiceDetailTextBullet2)
                + "</br>Display Text Detail_3 : " + TextColor.blueColor(ServiceDetailTextBullet3)
                + "</br>Display Text Detail_4 : " + TextColor.blueColor(ServiceDetailTextBullet4)
                + "</br>Display Next button : " + TextColor.blueColor(BtnNextServiceDetailScreen)
                + "</pre>");
        String serviceDetail2 = "images/FinancialCertificateFemaleNoTitleEN_serviceDetail2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(serviceDetail2);
        scenario2.createNode(Given.class, "The system will display the Service Detail screen").addScreenCaptureFromPath(serviceDetail2).pass("Pass");

        Assert.assertTrue(TitleHeader.equals("Financial Certificate"));
        Assert.assertTrue(ServiceDetailFinancial.equals("Service Details"));
        Assert.assertTrue(ServiceDetailTextBullet1.equals("Requesting certificate for another person"));
        Assert.assertTrue(DetailTextBullet1.equals("Please prepare first name and last name of the person to be certified as in shown their passport."));
        Assert.assertTrue(ServiceDetailTextBullet2.equals("Only personal assets can be certified"));
        Assert.assertTrue(ServiceDetailTextBullet3.equals("E-Financial Certificate is free of charge"));
        Assert.assertTrue(ServiceDetailTextBullet4.equals("Investment value in this financial certificate will be displayed according to the most recent mutual fund price published at the date you request this document."));
        Assert.assertTrue(BtnNextServiceDetailScreen.equals("Next"));

        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_SERVICE_DETAIL_FINANCIAL).click();
    }

    public void TC_Financial_Certificate_0002() throws InterruptedException, IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 40)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customerservice_finalcial_cf_navigation_icon_id\"]")));
        WebElement TitleHeaderProcess1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_1);
        String elTitleHeaderProcess1 = TitleHeaderProcess1.getText();
        String NumberProcess1 = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_1_FINANCIAL).getText();
        String LabelProcess1 = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_1_FINANCIAL).getText();
        String LabelSelectCertificate = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_CERTIFICATE).getText();
        String TypeCertificateOwner = ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_OWNER).getText();
        String TypeCertificateSponsor = ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR).getText();
        String LabelSelectPurpose = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_PURPOSE).getText();
        String ApplyVisa = ttbTestContext.findElement(OneAppElementKeys.APPLY_VISA).getText();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12693_FinCertDetails_00001");
        scenario.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate Details screen\n" +
                "- Android</pre>");
        scenario.createNode(Given.class, "<pre>Expected Result : 1. After the customer press the Next button on Certificate Service screen , the system will display the Certificate Detail screen.\n" +
                "2 The Certificate Detail screen contain the following fields :  \n" +
                "- Back Icon :  navigate to the previous screen.\n" +
                "- Text Screen:  Financial Certificate\n" +
                "- Process Icon\n" +
                "- Text Title Process:  Certificate Details\n" +
                "- Text Select Type:  Select type of certificate\n" +
                "- Owner Button:  To certify account owner\n" +
                "- Sponsor Button:  To sponsor other person\n" +
                "- Text Select Purpose:  Select purpose of use\n" +
                "- Apply Visa Button :  Apply visa\n" +
                "- Text Select Document Language:  Select document language\n" +
                "- EN Button :  English\n" +
                "- TH Button:  Thai\n" +
                "Next Button\n" +
                "Ref: Copy right in Ziplin</pre>");

        String selectTypeFinancial = "images/FinancialCertificateFemaleNoTitleEN_selectTypeFinancial_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectTypeFinancial);
        scenario.createNode(Given.class, "the system will display the Certificate Detail screen").addScreenCaptureFromPath(selectTypeFinancial).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_SELECT_LANGUAGE, true);
        String LabelSelectLanguage = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_LANGUAGE).getText();
        String DocumentEnglish = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_EN).getText();
        String DocumentThai = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_TH).getText();
        String BtnNextFinancial1Screen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_1_FINANCIAL).getText();

        scenario.createNode(Given.class, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(elTitleHeaderProcess1)
                + "</br>Display Text Process Number : " + TextColor.blueColor(NumberProcess1)
                + "</br>Display Text Title Process : " + TextColor.blueColor(LabelProcess1)
                + "</br>Display Text type certificate : " + TextColor.blueColor(LabelSelectCertificate)
                + "</br>Display Owner Button : " + TextColor.blueColor(TypeCertificateOwner)
                + "</br>Display Sponsor Button : " + TextColor.blueColor(TypeCertificateSponsor)
                + "</br>Display Text Select Purpose : " + TextColor.blueColor(LabelSelectPurpose)
                + "</br>Display Apply Visa Button : " + TextColor.blueColor(ApplyVisa)
                + "</br>Display Text Select Document Language : " + TextColor.blueColor(LabelSelectLanguage)
                + "</br>Display EN Button : " + TextColor.blueColor(DocumentEnglish)
                + "</br>Display TH Button : " + TextColor.blueColor(DocumentThai)
                + "</br>Display Next button : " + TextColor.blueColor(BtnNextFinancial1Screen)
                + "</pre>");
        String CertificateDetailScreen = "images/FinancialCertificateFemaleNoTitleEN_CertificateDetailScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateDetailScreen);
        scenario.createNode(Given.class, "the system will display the Certificate Detail screen").addScreenCaptureFromPath(CertificateDetailScreen).pass("Pass");

        Thread.sleep(2000);
        ttbTestContext.verticalSwipeByPercentages(0.4, 0.9, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR, true);
        ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR).click();

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "TC_ONEAPP-12693_FinCertDetails_00002");
        scenario2.createNode(Given.class, "<pre>Test Step Description : Validate selecting type of Financial Certificate in case\n" +
                "- The customer selects To certify account owner\n" +
                "- And selects English for the Document Language\n" +
                "- Device: Android</pre>");
        scenario2.createNode(Given.class, "<pre>Expected Result : 1. The Customer can select only one type of certificate\n" +
                "2. Auto-select apply visa\n" +
                "3. The Customer can select only one language but default in English.\n" +
                "The Customer already selects all of sections, The Next button will enable.</pre>");
        String CertificateDetailScreen2 = "images/FinancialCertificateFemaleNoTitleEN_CertificateDetailScreen2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateDetailScreen2);
        scenario.createNode(Given.class, "The Customer can select only one type of certificate").addScreenCaptureFromPath(CertificateDetailScreen2).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_OWNER).click();
        String CertificateDetailScreen3 = "images/FinancialCertificateFemaleNoTitleEN_CertificateDetailScreen3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateDetailScreen3);
        scenario.createNode(Given.class, "The Customer can select only one type of certificate").addScreenCaptureFromPath(CertificateDetailScreen3).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.TYPE_CERTIFICATE_SPONSOR).click();
        String CertificateDetailScreen4 = "images/FinancialCertificateFemaleNoTitleEN_CertificateDetailScreen4_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateDetailScreen4);
        scenario.createNode(Given.class, "The Customer can select only one type of certificate").addScreenCaptureFromPath(CertificateDetailScreen4).pass("Pass");

        Thread.sleep(2000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.BTN_NEXT_1_FINANCIAL, true);

        String CertificateDetailScreen5 = "images/FinancialCertificateFemaleNoTitleEN_CertificateDetailScreen5_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateDetailScreen5);
        scenario.createNode(Given.class, "The Customer already selects all of sections, The Next button will enable").addScreenCaptureFromPath(CertificateDetailScreen5).pass("Pass");

        System.err.println("elTitleHeaderProcess1 : " + elTitleHeaderProcess1);
        System.err.println("NumberProcess1 : " + NumberProcess1);
        System.err.println("LabelProcess1 : " + LabelProcess1);
        System.err.println("LabelSelectCertificate : " + LabelSelectCertificate);
        System.err.println("TypeCertificateOwner : " + TypeCertificateOwner);
        System.err.println("TypeCertificateSponsor : " + TypeCertificateSponsor);
        System.err.println("LabelSelectPurpose : " + LabelSelectPurpose);
        System.err.println("ApplyVisa : " + ApplyVisa);
        System.err.println("LabelSelectLanguage : " + LabelSelectLanguage);
        System.err.println("DocumentEnglish : " + DocumentEnglish);
        System.err.println("DocumentThai : " + DocumentThai);
        System.err.println("BtnNextFinancial1Screen : " + BtnNextFinancial1Screen);

        Assert.assertTrue(elTitleHeaderProcess1.equals("Financial Certificate"));
        Assert.assertTrue(NumberProcess1.equals("1 / 5"));
        Assert.assertTrue(LabelProcess1.equals("Certificate Details"));
        Assert.assertTrue(LabelSelectCertificate.equals("Select Type of Certificate"));
        Assert.assertTrue(TypeCertificateOwner.equals("To Certify Account Owner"));
        Assert.assertTrue(TypeCertificateSponsor.equals("To Sponsor Other Person"));
        Assert.assertTrue(LabelSelectPurpose.equals("Select Purpose of Use"));
        Assert.assertTrue(ApplyVisa.equals("Apply Visa"));
        Assert.assertTrue(LabelSelectLanguage.equals("Select Document Language"));
        Assert.assertTrue(DocumentEnglish.equals("English"));
        Assert.assertTrue(DocumentThai.equals("Thai"));
        Assert.assertTrue(BtnNextFinancial1Screen.equals("Next"));

        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_1_FINANCIAL).click();
    }

    public void TC_Financial_Certificate_0003() throws IOException, InterruptedException {
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        TmbServiceResponse<DepositResponse> response = client.get("/apis/customer/assets/deposit", eqParams, DepositResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        firstName = response.getData().first_name_en.substring(0,1).toUpperCase() + response.getData().first_name_en.substring(1).toLowerCase();
        middleName = (response.getData().middle_name_en.equals("")) ? " " : " " + response.getData().middle_name_en.substring(0,1).toUpperCase() + response.getData().middle_name_en.substring(1).toLowerCase() + " ";
        lastName = response.getData().last_name_en.substring(0,1).toUpperCase() + response.getData().last_name_en.substring(1).toLowerCase(Locale.ROOT);
        accountNameEn1 = (response.getData().deposit_account_lists.get(0).account_nickname == null) ? response.getData().deposit_account_lists.get(0).account_name_en : response.getData().deposit_account_lists.get(0).account_nickname;
        accountBalance1 = response.getData().deposit_account_lists.get(0).account_balance;
        accountNumber1 = response.getData().deposit_account_lists.get(0).account_number;
        accountNameEn2 = (response.getData().deposit_account_lists.get(1).account_nickname == null) ? response.getData().deposit_account_lists.get(1).account_name_en : response.getData().deposit_account_lists.get(1).account_nickname;
        accountBalance2 = response.getData().deposit_account_lists.get(1).account_balance;
        accountNumber2 = response.getData().deposit_account_lists.get(1).account_number;
        accountNameEn3 = (response.getData().deposit_account_lists.get(2).account_nickname == null) ? response.getData().deposit_account_lists.get(2).account_name_en : response.getData().deposit_account_lists.get(2).account_nickname;
        accountBalance3 = response.getData().deposit_account_lists.get(2).account_balance;
        accountNumber3 = response.getData().deposit_account_lists.get(2).account_number;
//        objBodyMutualFund = FormatNumber.formatJsonMutual(response.getData().mutual_fund_account_lists);
        List portNo = new ArrayList();
        response.getData().mutual_fund_account_lists.forEach(item -> {
            Map maps = new HashMap();
            maps.put("account_number", item);
            portNo.add(maps);
        });
        Map mutual_fund_accounts = new HashMap();
        mutual_fund_accounts.put("mutual_fund_accounts", portNo);
        System.out.println("mutual_fund_accounts : " + new ObjectMapper().writeValueAsString(mutual_fund_accounts));
        objBodyMutualFund = new ObjectMapper().writeValueAsString(mutual_fund_accounts);
//        portNumber = response.getData().mutual_fund_account_lists;
        System.out.println("response2 : " + response.getData().first_name_en);
        System.out.println("response2 : " + response.getData().deposit_account_lists.get(0).account_number);
        System.out.println("response2 : " + response.getData().deposit_account_lists.get(0).account_balance);
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        Thread.sleep(5000);
//        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_2, true);
        String TitleHeaderProcess2 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_2).getText();
        String NumberProcess = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_1_FINANCIAL).getText();
        String LabelProcess2 = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_1_FINANCIAL).getText();
        String LabelPleaseReview = ttbTestContext.findElement(OneAppElementKeys.LABEL_PLEASE_REVIEW).getText();
        String LabelConditionChangeInformation = ttbTestContext.findElement(OneAppElementKeys.LABEL_CONDITION_CHANGE_INFORMATION).getText();
        String LabelTitle = ttbTestContext.findElement(OneAppElementKeys.DROPDOWN_TITLE).getText().trim();
        Select selectTitleOwner = new Select(ttbTestContext.findElement(OneAppElementKeys.DROPDOWN_TITLE));
        String beforeSelectTitle = selectTitleOwner.getFirstSelectedOption().getText();
        selectTitleOwner.selectByValue("Miss.");
        List<WebElement> allOption = selectTitleOwner.getOptions();
        List<String> expectedTitle = null;
        if(response.getData().gender.equals("M")){
            expectedTitle = Arrays.asList("Title", "Master.", "Mr.");
        }else if(response.getData().gender.equals("F")){
            expectedTitle = Arrays.asList("Title", "Miss.", "Mrs.");
        }else {
            expectedTitle = Arrays.asList("Title", "Master.", "Mr.", "Miss.", "Mrs.");
        }
        for(int i = 0; i < allOption.size(); i++){
            System.err.println(i + " : " + allOption.get(i).getText());
            System.err.println("0" + i + " : " + expectedTitle.get(i));
            Assert.assertTrue(allOption.get(i).getText().equals(expectedTitle.get(i)));
        }

        String AfterSelectTitle = selectTitleOwner.getFirstSelectedOption().getText();
        String LabelFirstName = ttbTestContext.findElement(OneAppElementKeys.LABEL_FIRST_NAME_2).getText();
        String FirstNameValue = ttbTestContext.findElement(OneAppElementKeys.FIRST_NAME_VALUE_2).getText();
        String LabelMiddleName = ttbTestContext.findElement(OneAppElementKeys.LABEL_MIDDLE_NAME_2).getText();
        String MiddleNameValue = ttbTestContext.findElement(OneAppElementKeys.MIDDLE_NAME_VALUE_2).getText();
        String LabelLastName = ttbTestContext.findElement(OneAppElementKeys.LABEL_LAST_NAME_2).getText();
        String LastNameValue = ttbTestContext.findElement(OneAppElementKeys.LAST_NAME_VALUE_2).getText();
        String LabelPersonInformation = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERSON_INFORMATION).getText();
        String LabelInformationAppearsPassport = ttbTestContext.findElement(OneAppElementKeys.LABEL_INFORMATION_APPEARS_PASSPORT).getText();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12693_FinCertDetails_00001");
        scenario.createNode(Given.class, "<pre>Test Step Description : Verification On Financial Statement, Display \"Personal Information\"  If the owner doesn’t have an EN title and female gender \n" +
                "The drop-down title will list conditions filter the show by gender [female].</pre>");
        scenario.createNode(Given.class, "<pre>Expected Result : On Financial certificate, Display \"Personal Information\" the owner doesn’t have an EN title and female gender ,\n" +
                "The system shall show drop-down title list condition by gender [female]</pre>");
        scenario.createNode(Given.class, "<pre>The system shall show drop-down title list condition by gender [female]</pre>" + allOption.get(1) + "\n" + allOption.get(2));

        String informationDetail = "images/FinancialCertificateFemaleNoTitleEN_informationDetail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(informationDetail);
        scenario.createNode(Given.class, "On Financial certificate, Display \"Personal Information\" the owner doesn’t have an EN title and female gender").addScreenCaptureFromPath(informationDetail).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.PLACEHOLDER_LAST_NAME, true);

        String PlaceHolderTitle = ttbTestContext.findElement(OneAppElementKeys.PLACEHOLDER_TITLE).getText().trim();
        String PlaceHolderFirstName = ttbTestContext.findElement(OneAppElementKeys.PLACEHOLDER_FIRST_NAME).getText();
        String PlaceHolderMiddleName = ttbTestContext.findElement(OneAppElementKeys.PLACEHOLDER_MIDDLE_NAME).getText();
        String PlaceHolderLastName = ttbTestContext.findElement(OneAppElementKeys.PLACEHOLDER_LAST_NAME).getText();
        Select selectTitle = new Select(ttbTestContext.findElement(OneAppElementKeys.SELECT_TITLE));
        String textTitle = selectTitle.getFirstSelectedOption().getText();
        selectTitle.selectByValue("Master.");
        String textTitleAfter = selectTitle.getFirstSelectedOption().getText();
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.INPUT_FIRST_NAME, true);
        WebElement Input_FirstName = ttbTestContext.findElement(OneAppElementKeys.INPUT_FIRST_NAME);
        WebElement Input_LastName = ttbTestContext.findElement(OneAppElementKeys.INPUT_LAST_NAME);
        Input_FirstName.sendKeys("Hello");
        Input_LastName.sendKeys("World");
        ttbTestContext.getDriver().hideKeyboard();
        String BtnNextFinancial2Screen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_2_FINANCIAL).getText();
        String InputFirstNameValue = ttbTestContext.findElement(OneAppElementKeys.INPUT_FIRST_NAME).getAttribute("value");
        String InputLastNameValue = ttbTestContext.findElement(OneAppElementKeys.INPUT_LAST_NAME).getAttribute("value");

        String informationDetail2 = "images/FinancialCertificateFemaleNoTitleEN_informationDetail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(informationDetail2);
        scenario.createNode(Given.class, "Input information sponsor").addScreenCaptureFromPath(informationDetail2).pass("Pass");

        System.err.println("TitleHeaderProcess2 : " + TitleHeaderProcess2);
        System.err.println("NumberProcess2 : " + NumberProcess);
        System.err.println("LabelProcess2 : " + LabelProcess2);
        System.err.println("LabelPleaseReview : " + LabelPleaseReview);
        System.err.println("LabelConditionChangeInformation : " + LabelConditionChangeInformation);
        System.err.println("LabelTitle : " + LabelTitle);
        System.err.println("beforeSelectTitle : " + beforeSelectTitle);
        System.err.println("AfterSelectTitle : " + AfterSelectTitle);
        System.err.println("LabelFirstName : " + LabelFirstName);
        System.err.println("FirstNameValue : " + FirstNameValue);
        System.err.println("LabelMiddleName : " + LabelMiddleName);
        System.err.println("MiddleNameValue : " + MiddleNameValue);
        System.err.println("LabelLastName : " + LabelLastName);
        System.err.println("LastNameValue : " + LastNameValue);
        System.err.println("LabelPersonInformation : " + LabelPersonInformation);
        System.err.println("LabelInformationAppearsPassport : " + LabelInformationAppearsPassport);
        System.err.println("PlaceHolderTitle : " + PlaceHolderTitle.trim());
        System.err.println("PlaceHolderFirstName : " + PlaceHolderFirstName);
        System.err.println("PlaceHolderMiddleName : " + PlaceHolderMiddleName);
        System.err.println("PlaceHolderLastName : " + PlaceHolderLastName);
        System.err.println("BtnNextFinancial2Screen : " + BtnNextFinancial2Screen);
        System.err.println("InputFirstNameValue : " + InputFirstNameValue);
        System.err.println("InputLastNameValue : " + InputLastNameValue);

        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_2_FINANCIAL).click();
        String middleName = (response.getData().middle_name_en.equals("")) ? "-" : response.getData().middle_name_en;
        System.out.println("first_name_en : " + response.getData().first_name_en);
        System.out.println("middleName : " + middleName);
        System.out.println("last_name_en : " + response.getData().last_name_en);

        Assert.assertTrue(TitleHeaderProcess2.equals("Financial Certificate"));
        Assert.assertTrue(NumberProcess.equals("2 / 5"));
        Assert.assertTrue(LabelProcess2.equals("Personal Information"));
        Assert.assertTrue(LabelPleaseReview.equals("Please Review The Asset Owner Information"));
        Assert.assertTrue(LabelConditionChangeInformation.equals("If you need to edit the asset owner\n" +
                "information, go to “Other Services” Tab > Edit\n" +
                "Profile"));
        Assert.assertTrue(beforeSelectTitle.equals("Title"));
        Assert.assertTrue(AfterSelectTitle.equals("Miss."));
        Assert.assertTrue(LabelFirstName.equals("First name"));
        Assert.assertTrue(FirstNameValue.equals(response.getData().first_name_en));
        Assert.assertTrue(LabelMiddleName.equals("Middle name"));
        Assert.assertTrue(MiddleNameValue.equals(middleName));
        Assert.assertTrue(LabelLastName.equals("Last name"));
        Assert.assertTrue(LastNameValue.equals(response.getData().last_name_en));
        Assert.assertTrue(LabelPersonInformation.equals("Information of The Person to be Certified"));
        Assert.assertTrue(LabelInformationAppearsPassport.equals("The information must be in  English as appears in the passport."));
        System.out.println("textTitle : " + textTitle);
        Assert.assertTrue(textTitle.equals("Title"));
        Assert.assertTrue(textTitleAfter.equals("Master."));
        Assert.assertTrue(PlaceHolderTitle.equals("Title"));
        Assert.assertTrue(PlaceHolderFirstName.equals("First name"));
        Assert.assertTrue(PlaceHolderMiddleName.equals("Middle name (optional)"));
        Assert.assertTrue(PlaceHolderLastName.equals("Last name"));
        Assert.assertTrue(InputFirstNameValue.equals("Hello"));
        Assert.assertTrue(InputLastNameValue.equals("World"));
        Assert.assertTrue(BtnNextFinancial2Screen.equals("Next"));
    }

    @Test(priority = 3)
    public void TC_Financial_Certificate_0004() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        String TitleHeaderProcess3 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_3).getText();
        String NumberProcess3 = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_3_FINANCIAL).getText();
        String LabelProcess3 = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_3_FINANCIAL).getText();
        String LabelAssetTypeToUse = ttbTestContext.findElement(OneAppElementKeys.LABEL_ASSET_TYPE_TO_USE).getText();
        String DepositValue = ttbTestContext.findElement(OneAppElementKeys.LABEL_DEPOSIT).getText();
        String MutualFundValue = ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL).getText();
        String BtnNextFinancial3Screen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_3_FINANCIAL).getText();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12695_FinCertValue_00002");
        scenario.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate - Certificate Value screen in case\n" +
                "- Deposit and MF accounts\n" +
                "- Device: Android</pre>");
        scenario.createNode(Given.class, "<pre>Expected Result : 1. After the customer press on a Next button on Personal info screen, the system should display the Certificate Value screen.\n" +
                "- Don't auto check box if the customer have Deposit and MF accounts\n" +
                "- The customer can check box more than one.\n" +
                "- If the customer already check box, The Next button will enable.</pre>");
        scenario.createNode(Given.class, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(TitleHeaderProcess3)
                + "</br>Display Text Process Number : " + TextColor.blueColor(NumberProcess3)
                + "</br>Display Text Title Process : " + TextColor.blueColor(LabelProcess3)
                + "</br>Display Text Asset type to use: " + TextColor.blueColor(LabelAssetTypeToUse)
                + "</br>Display Text Deposit Value : " + TextColor.blueColor(DepositValue)
                + "</br>Display Text Mutual Fund Value : " + TextColor.blueColor(MutualFundValue)
                + "</br>Display Next button : " + TextColor.blueColor(BtnNextFinancial3Screen)
                + "</pre>");
        String CertificateValueScreen = "images/CertificateValueScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen);
        scenario.createNode(Given.class, "The system should display the Certificate Value screen").addScreenCaptureFromPath(CertificateValueScreen).pass("Pass");

        ttbTestContext.findElement(OneAppElementKeys.LABEL_DEPOSIT).click();
        String CertificateValueScreen2 = "images/CertificateValueScreen2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen2);
        scenario.createNode(Given.class, "Select Deposit").addScreenCaptureFromPath(CertificateValueScreen2).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL).click();
        String CertificateValueScreen3 = "images/CertificateValueScreen3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen3);
        scenario.createNode(Given.class, "Select Mutual fund").addScreenCaptureFromPath(CertificateValueScreen3).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.LABEL_DEPOSIT).click();
        String CertificateValueScreen4 = "images/CertificateValueScreen4_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen4);
        scenario.createNode(Given.class, "Is not select Deposit").addScreenCaptureFromPath(CertificateValueScreen4).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL).click();
        String CertificateValueScreen5 = "images/CertificateValueScreen5_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen5);
        scenario.createNode(Given.class, "Is not select Mutual fund").addScreenCaptureFromPath(CertificateValueScreen5).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.LABEL_DEPOSIT).click();
        String CertificateValueScreen6 = "images/CertificateValueScreen6_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen6);
        scenario.createNode(Given.class, "Select Deposit").addScreenCaptureFromPath(CertificateValueScreen6).pass("Pass");
        ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL).click();
        String CertificateValueScreen7 = "images/CertificateValueScreen7_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CertificateValueScreen7);
        scenario.createNode(Given.class, "Select Mutual fund").addScreenCaptureFromPath(CertificateValueScreen7).pass("Pass");
        System.err.println("TitleHeaderProcess3 : " + TitleHeaderProcess3);
        System.err.println("NumberProcess3 : " + NumberProcess3);
        System.err.println("LabelProcess3 : " + LabelProcess3);
        System.err.println("LabelAssetTypeToUse : " + LabelAssetTypeToUse);
        System.err.println("DepositValue : " + DepositValue);
        System.err.println("MutualFundValue : " + MutualFundValue);
        System.err.println("BtnNextFinancial3Screen : " + BtnNextFinancial3Screen);
        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_3_FINANCIAL).click();

        Assert.assertTrue(TitleHeaderProcess3.equals("Financial Certificate"));
        Assert.assertTrue(NumberProcess3.equals("3 / 5"));
        Assert.assertTrue(LabelProcess3.equals("Certificate Value"));
        Assert.assertTrue(LabelAssetTypeToUse.equals("Asset Type to Use as Certificate Value"));
        Assert.assertTrue(DepositValue.equals("Deposit Value"));
        Assert.assertTrue(MutualFundValue.equals("Investment Value"));
        Assert.assertTrue(BtnNextFinancial3Screen.equals("Next"));
    }

    @Test(priority = 4)
    public void TC_Financial_Certificate_0005() throws Exception {
        OneAppClient client = getOneAppClient();
        System.err.println("dung : " + objBodyMutualFund);
        TmbServiceResponse<MutualFundResponse> response = client.post("/apis/customer/assets/mutualfund", objBodyMutualFund, MutualFundResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        System.out.println("response : " + response.getData().mutual_fund_details.get(1).account_number);
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_4, true);
        String TitleHeaderProcess4 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_4).getText();
        String NumberProcess4 = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_4).getText();
        String LabelProcess4 = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_4).getText();
        String LabelSelectDeposit = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_DEPOSIT).getText();
        String ConditionSelectDeposit = ttbTestContext.findElement(OneAppElementKeys.CONDITION_SELECT_DEPOSIT).getText();
        String AccountName1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1_FINANCIAL).getText();
        String AccountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1_FINANCIAL).getText();
        String Balance1 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_1_FINANCIAL).getText();
        String AccountName2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_2_FINANCIAL).getText();
        String AccountNumber2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_2_FINANCIAL).getText();
        String Balance2 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_2_FINANCIAL).getText();
        String AccountName3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_3_FINANCIAL).getText();
        String AccountNumber3 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_3_FINANCIAL).getText();
        String Balance3 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_3_FINANCIAL).getText();
//        String AccountName4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_4_FINANCIAL).getText();
//        String AccountNumber4 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_4_FINANCIAL).getText();
//        String Balance4 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_4_FINANCIAL).getText();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12697_FinAcct_00003");
        scenario.createNode(Given.class, "<pre>Test Step Description : Validate sorting of Deposit accounts on Financial Certificate - Select Accounts screen\n" +
                "- Device: Android</pre>");
        scenario.createNode(Given.class, "<pre>Expected Result : 1. The system display Select Accounts screen containing as below:\n" +
                "- Back Icon :  navigate to the previous screen.\n" +
                "- Process Icon \n" +
                "- Text Title Process: Display Select Accounts\n" +
                "- Text Select deposit account: Display Select deposit account to certify\n" +
                "- Text Detail_1: Display You can select up to 3 accounts\n" +
                "- Account Nickname: Display value from AIP\n" +
                "- Account Value: Display value from AIP\n" +
                "- Account Number: Display value from AIP\n" +
                "2. The system display deposit accounts sorted by balance (descending)</pre>");
        String selectAccount = "images/selectAccount_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectAccount);
        scenario.createNode(Given.class, "The system display deposit accounts sorted by balance (descending)").addScreenCaptureFromPath(selectAccount).pass("Pass");

        ExtentTest scenario2 = getFeature().createNode(Scenario.class, "TC_ONEAPP-12697_FinAcct_00004");
        scenario2.createNode(Given.class, "<pre>Test Step Description : Validate sorting of MF accounts on Financial Certificate - Select Accounts screen\n" +
                "- Device: Android</pre>");
        scenario2.createNode(Given.class, "<pre>Expected Result : 1. The system display Select Accounts screen containing as below:\n" +
                "- Back Icon :  navigate to the previous screen.\n" +
                "- Process Icon \n" +
                "- Text Title Process: Display Select Accounts\n" +
                "- Text Select deposit account: Display Select deposit account to certify\n" +
                "- Text Detail_1: Display You can select up to 3 accounts\n" +
                "- Account Nickname: Display value from AIP\n" +
                "- Account Value: Display value from AIP\n" +
                "- Account Number: Display value from AIP\n" +
                "- Text Select MF: Display Select Mutual Fund Portfolio to certify\n" +
                "- Text Detail_2: Display You can select up to 3 portfolios\n" +
                "- Text Detail_3: Display Mutual fund value in this financial certificate will be displayed according to the most recent mutual fund price published at the date you request this document.\n" +
                "- Portfolio Code: Display value from AIP\n" +
                "- MF Portfolio Value: Display value from AIP\n" +
                "- Next Button\n" +
                "2. The system display MF accounts sorted by Portfolio Code (ascending)</pre>");
        String selectAccount2 = "images/selectAccount2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectAccount2);
        scenario2.createNode(Given.class, "The system display deposit accounts sorted by balance (descending)").addScreenCaptureFromPath(selectAccount2).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_SELECT_MUTUAL_FUND, true);
        String LabelSelectMutualFund = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_MUTUAL_FUND).getText();
        String ConditionSelectMutualFund = ttbTestContext.findElement(OneAppElementKeys.CONDITION_SELECT_MUTUAL_FUND).getText();
        String MessageBoxSelectMutualFund = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_SELECT_MUTUAL_FUND).getText();
        String PortNumber1 = ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_1_FINANCIAL).getText();
        String BalancePort1 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_PORT_1_FINANCIAL).getText();
        String PortNumber2 = ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_2_FINANCIAL).getText();
        String BalancePort2 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_PORT_2_FINANCIAL).getText();
        String PortNumber3 = ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_3_FINANCIAL).getText();
        String BalancePort3 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_PORT_3_FINANCIAL).getText();
        String PortNumber4 = ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_4_FINANCIAL).getText();
        String BalancePort4 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_PORT_4_FINANCIAL).getText();
        String BtnNextFinancial4Screen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_4_FINANCIAL).getText();

        scenario2.createNode(Given.class, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(TitleHeaderProcess4)
                + "</br>Display Text Process Number : " + TextColor.blueColor(NumberProcess4)
                + "</br>Display Text Title Process : " + TextColor.blueColor(LabelProcess4)
                + "</br>Display Text Select deposit account : " + TextColor.blueColor(LabelSelectDeposit)
                + "</br>Display Text Detail_1 : " + TextColor.blueColor(ConditionSelectDeposit)
                + "</br>Display Account Nickname 1 : " + TextColor.blueColor(AccountName1)
                + "</br>Display Account Number 1 : " + TextColor.blueColor(AccountNumber1)
                + "</br>Display Account Value 1 : " + TextColor.blueColor(Balance1)
                + "</br>Display Account Nickname 2 : " + TextColor.blueColor(AccountName2)
                + "</br>Display Account Number 2 : " + TextColor.blueColor(AccountNumber2)
                + "</br>Display Account Value 2 : " + TextColor.blueColor(Balance2)
                + "</br>Display Account Nickname 3 : " + TextColor.blueColor(AccountName3)
                + "</br>Display Account Number 3 : " + TextColor.blueColor(AccountNumber3)
                + "</br>Display Account Value 3 : " + TextColor.blueColor(Balance3)
                + "</br>Display Text Select MF : " + TextColor.blueColor(LabelSelectMutualFund)
                + "</br>Display Text Detail_2 : " + TextColor.blueColor(ConditionSelectMutualFund)
                + "</br>Display Text Detail_3 : " + TextColor.blueColor(MessageBoxSelectMutualFund)
                + "</br>Display Portfolio Code 1 : " + TextColor.blueColor(PortNumber1)
                + "</br>Display MF Portfolio Value 1 : " + TextColor.blueColor(BalancePort1)
                + "</br>Display Portfolio Code 2 : " + TextColor.blueColor(PortNumber2)
                + "</br>Display MF Portfolio Value 2 : " + TextColor.blueColor(BalancePort2)
                + "</br>Display Portfolio Code 3 : " + TextColor.blueColor(PortNumber3)
                + "</br>Display MF Portfolio Value 3 : " + TextColor.blueColor(BalancePort3)
                + "</br>Display Portfolio Code 4 : " + TextColor.blueColor(PortNumber4)
                + "</br>Display MF Portfolio Value 4 : " + TextColor.blueColor(BalancePort4)
                + "</br>Display Next button : " + TextColor.blueColor(BtnNextFinancial4Screen)
                + "</pre>");
        String selectAccount3 = "images/selectAccount3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectAccount3);
        scenario2.createNode(Given.class, "The system display MF accounts sorted by Portfolio Code (descending)").addScreenCaptureFromPath(selectAccount3).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.4, 0.9, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.4, 0.9, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_NUMBER_1_FINANCIAL, true);
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1_FINANCIAL).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_2_FINANCIAL).click();
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_3_FINANCIAL).click();
        totalBalance_deposit = Double.parseDouble(Balance1.replaceAll(",","")) + Double.parseDouble(Balance2.replaceAll(",","")) + Double.parseDouble(Balance3.replaceAll(",",""));
        totalBalance_investment = Double.parseDouble(BalancePort1.replaceAll(",","")) + Double.parseDouble(BalancePort2.replaceAll(",","")) + Double.parseDouble(BalancePort3.replaceAll(",",""));
        totalBalance = totalBalance_deposit + totalBalance_investment;

        ExtentTest scenario3 = getFeature().createNode(Scenario.class, "TC_ONEAPP-12697_FinAcct_00002");
        scenario3.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate - Certificate Value screen in case\n" +
                "- Deposit and MF accounts\n" +
                "- Device: Android</pre>");
        scenario3.createNode(Given.class, "<pre>Expected Result : 1. After the customer press the Next button on Certificate Value screen, the system should display the Select Accounts screen.\n" +
                "2. The system allow the customer to select up to 3 Deposit accounts and up to 3 MF accounts.</pre>");
        String selectAccount4 = "images/selectAccount4_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectAccount4);
        scenario3.createNode(Given.class, "The system allow the customer to select up to 3 Deposit accounts").addScreenCaptureFromPath(selectAccount4).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.PORT_NUMBER_1_FINANCIAL, true);
        ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_1_FINANCIAL).click();
        ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_2_FINANCIAL).click();
        ttbTestContext.findElement(OneAppElementKeys.PORT_NUMBER_3_FINANCIAL).click();

        ExtentTest scenario4 = getFeature().createNode(Scenario.class, "TC_ONEAPP-12697_FinAcct_00001");
        scenario4.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate - Select Accounts screen\n" +
                "- Select an account from Deposit or MF\n" +
                "- Device: Android</pre>");
        scenario4.createNode(Given.class, "<pre>Expected Result : 1. After the customer press the Next button on Certificate Value screen, the system should display the Select Accounts screen.\n" +
                "2. The system allow the customer to select one account from Deposit or MF and enable Next botton.</pre>");
        String selectAccount6 = "images/selectAccount6_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(selectAccount6);
        scenario4.createNode(Given.class, "The system allow the customer to select one account from Deposit or MF and enable Next botton").addScreenCaptureFromPath(selectAccount6).pass("Pass");

        System.err.println("TitleHeaderProcess4 : " + TitleHeaderProcess4);
        System.err.println("NumberProcess4 : " + NumberProcess4);
        System.err.println("LabelProcess4 : " + LabelProcess4);
        System.err.println("LabelSelectDeposit : " + LabelSelectDeposit);
        System.err.println("ConditionSelectDeposit : " + ConditionSelectDeposit);
        System.err.println("AccountName1 : " + AccountName1);
        System.err.println("AccountNumber1 : " + AccountNumber1);
        System.err.println("Balance1 : " + Balance1);
        System.err.println("AccountName2 : " + AccountName2);
        System.err.println("AccountNumber2 : " + AccountNumber2);
        System.err.println("Balance2 : " + Balance2);
        System.err.println("AccountName3 : " + AccountName3);
        System.err.println("AccountNumber3 : " + AccountNumber3);
        System.err.println("Balance3 : " + Balance3);
//        System.err.println("AccountName4 : " + AccountName4);
//        System.err.println("AccountNumber4 : " + AccountNumber4);
//        System.err.println("Balance4 : " + Balance4);
        System.err.println("LabelSelectMutualFund : " + LabelSelectMutualFund);
        System.err.println("ConditionSelectMutualFund : " + ConditionSelectMutualFund);
        System.err.println("MessageBoxSelectMutualFund : " + MessageBoxSelectMutualFund);
        System.err.println("PortNumber1 : " + PortNumber1);
        System.err.println("BalancePort1 : " + BalancePort1);
        System.err.println("PortNumber2 : " + PortNumber2);
        System.err.println("BalancePort2 : " + BalancePort2);
        System.err.println("PortNumber3 : " + PortNumber3);
        System.err.println("BalancePort3 : " + BalancePort3);
        System.err.println("PortNumber4 : " + PortNumber4);
        System.err.println("BalancePort4 : " + BalancePort4);
        System.err.println("BtnNextFinancial4Screen : " + BtnNextFinancial4Screen);
        System.err.println("FormatNumber.formatBalance(accountBalance1) : " + FormatNumber.formatBalance(accountBalance1));
        System.err.println("FormatNumber.formatBalance(accountBalance2) : " + FormatNumber.formatBalance(accountBalance2));
        System.err.println("FormatNumber.formatBalance(accountBalance3) : " + FormatNumber.formatBalance(accountBalance3));

        Assert.assertTrue(TitleHeaderProcess4.equals("Financial Certificate"));
        Assert.assertTrue(NumberProcess4.equals("4 / 5"));
        Assert.assertTrue(LabelProcess4.equals("Select Accounts"));
        Assert.assertTrue(LabelSelectDeposit.equals("Select Deposit Account to Certify"));
        Assert.assertTrue(ConditionSelectDeposit.equals("You can select up to 3 accounts."));
        Assert.assertTrue(AccountName1.equals(accountNameEn1));
        Assert.assertTrue(AccountNumber1.equals(FormatNumber.formatAccount(accountNumber1, "XXX-X-XX###-#")));
        Assert.assertTrue(Balance1.equals(FormatNumber.formatBalance(accountBalance1)));
        Assert.assertTrue(AccountName2.equals(accountNameEn2));
        Assert.assertTrue(AccountNumber2.equals(FormatNumber.formatAccount(accountNumber2, "XXX-X-XX###-#")));
        Assert.assertTrue(Balance2.equals(FormatNumber.formatBalance(accountBalance2)));
        Assert.assertTrue(AccountName3.equals(accountNameEn3));
        Assert.assertTrue(AccountNumber3.equals(FormatNumber.formatAccount(accountNumber3, "XXX-X-XX###-#")));
        Assert.assertTrue(Balance3.equals(FormatNumber.formatBalance(accountBalance3)));
        Assert.assertTrue(LabelSelectMutualFund.equals("Select Mutual Fund Portfolio to Certify"));
        Assert.assertTrue(ConditionSelectMutualFund.equals("You can select up to 3 portfolios."));
        Assert.assertTrue(MessageBoxSelectMutualFund.equals("Investment value in this financial certificate will be displayed according to the most recent mutual fund price published at the date you request this document."));
        Assert.assertTrue(PortNumber1.equals(response.getData().mutual_fund_details.get(0).account_number));
        Assert.assertTrue(BalancePort1.equals(FormatNumber.formatBalance(Double.parseDouble(response.getData().mutual_fund_details.get(0).account_balance))));
        Assert.assertTrue(PortNumber2.equals(response.getData().mutual_fund_details.get(1).account_number));
        Assert.assertTrue(BalancePort2.equals(FormatNumber.formatBalance(Double.parseDouble(response.getData().mutual_fund_details.get(1).account_balance))));
        Assert.assertTrue(PortNumber3.equals(response.getData().mutual_fund_details.get(2).account_number));
        Assert.assertTrue(BalancePort3.equals(FormatNumber.formatBalance(Double.parseDouble(response.getData().mutual_fund_details.get(2).account_balance))));
        Assert.assertTrue(PortNumber4.equals(response.getData().mutual_fund_details.get(3).account_number));
        Assert.assertTrue(BalancePort4.equals(FormatNumber.formatBalance(Double.parseDouble(response.getData().mutual_fund_details.get(3).account_balance))));
        Assert.assertTrue(BtnNextFinancial4Screen.equals("Next"));
        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_4_FINANCIAL).click();
    }

    @Test(priority = 5)
    public void TC_Financial_Certificate_0006() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        String TitleHeaderProcess5 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_5).getText();
        String NumberProcess5 = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_5_FINANCIAL).getText();
        String LabelProcess5 = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_5_FINANCIAL).getText();
        String LabelFinancialCertificateDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_FINANCIAL_CERTIFICATE_DETAIL).getText();
        String LabelCertificateType = ttbTestContext.findElement(OneAppElementKeys.LABEL_CERTIFICATE_TYPE).getText();
        String CertificateTypeValue = ttbTestContext.findElement(OneAppElementKeys.CERTIFICATE_TYPE_VALUE).getText();
        String LabelPurpose = ttbTestContext.findElement(OneAppElementKeys.LABEL_PURPOSE).getText();
        String PurposeValue = ttbTestContext.findElement(OneAppElementKeys.PURPOSE_VALUE).getText();
        String LabelAssetOwner = ttbTestContext.findElement(OneAppElementKeys.LABEL_ASSET_OWNER).getText();
        String AssetOwnerValue = ttbTestContext.findElement(OneAppElementKeys.ASSET_OWNER_VALUE).getText();
        String LabelCertifyPerson = ttbTestContext.findElement(OneAppElementKeys.LABEL_CERTIFY_PERSON).getText();
        String CertifyPersonValue = ttbTestContext.findElement(OneAppElementKeys.CERTIFY_PERSON_VALUE).getText();
        String LabelDocLanguage = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOCUMENT_LANGUAGE).getText();
        String DocLanguageValue = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_LANGUAGE_VALUE).getText();
        String LabelAssetDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_ASSET_DETAIL).getText();
        String LabelDepositValue = ttbTestContext.findElement(OneAppElementKeys.LABEL_DEPOSIT_VALUE).getText();
        String TotalBalanceDeposit = ttbTestContext.findElement(OneAppElementKeys.DEPOSIT_VALUE).getText();
        String LabelInvestmentValue = ttbTestContext.findElement(OneAppElementKeys.LABEL_INVESTMENT_VALUE).getText();
        String TotalBalanceInvestmentValue = ttbTestContext.findElement(OneAppElementKeys.INVESTMENT_VALUE).getText();

        ExtentTest scenario = getFeature().createNode(Scenario.class, "TC_ONEAPP-12698_FinInfo_00004");
        scenario.createNode(Given.class, "<pre>Test Step Description : Validate a display of Financial Certificate - Information Review screen if\n" +
                "- Fin Cert. Type = To sponsor other person\n" +
                "- Document Language = Thai\n" +
                "- Device: Android</pre>");
        scenario.createNode(Given.class, "<pre>Expected Result : 1. After the customer press the Next button on Select Accounts screen, the system should display the Information Review screen  containing the following section\n" +
                "- Section#1- Financial Certificate Details\n" +
                "If the customer select “To sponsor other person”, the system show Certify Person.\n" +
                "- Section#2- Asset Detail\n" +
                "If the customer doesn’t select “Investment”, the system won’t show investment value information.\n" +
                "2. The system display information in Thai</pre>");
        String InformationReviewScreen = "images/InformationReviewScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(InformationReviewScreen);
        scenario.createNode(Given.class, "The system should display the Information Review screen").addScreenCaptureFromPath(InformationReviewScreen).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_TOTAL_ASSETS, true);
        String LabelTotalAsset = ttbTestContext.findElement(OneAppElementKeys.LABEL_TOTAL_ASSETS).getText();
        String TotalBalanceAssetValue = ttbTestContext.findElement(OneAppElementKeys.TOTAL_ASSETS_VALUE).getText();
        String LabelServiceFee = ttbTestContext.findElement(OneAppElementKeys.LABEL_SERVICE_FEE).getText();
        String LabelFeeEN = ttbTestContext.findElement(OneAppElementKeys.LABEL_FEE_EN).getText();
        String FeeENValue = ttbTestContext.findElement(OneAppElementKeys.FEE_EN_VALUE).getText();
        String LabelFeeTH = ttbTestContext.findElement(OneAppElementKeys.LABEL_FEE_TH).getText();
        String FeeTHValue = ttbTestContext.findElement(OneAppElementKeys.FEE_TH_VALUE).getText();
        String BtnNextFinancial5Screen = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_5_FINANCIAL).getText();

        scenario.createNode(Given.class, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(TitleHeaderProcess5)
                + "</br>Display Text Process Number : " + TextColor.blueColor(NumberProcess5)
                + "</br>Display Text Title Process : " + TextColor.blueColor(LabelProcess5)
                + "</br>Display Text Financial Cer Details : " + TextColor.blueColor(LabelFinancialCertificateDetail)
                + "</br>Display Text Certificate Type : " + TextColor.blueColor(LabelCertificateType)
                + "</br>Display Certificate Type : " + TextColor.blueColor(CertificateTypeValue)
                + "</br>Display Text Purpose : " + TextColor.blueColor(LabelPurpose)
                + "</br>Display Purpose : " + TextColor.blueColor(PurposeValue)
                + "</br>Display Text Asset label : " + TextColor.blueColor(LabelAssetOwner)
                + "</br>Display Asset : " + TextColor.blueColor(AssetOwnerValue)
                + "</br>Display Text Certify Person : " + TextColor.blueColor(LabelCertifyPerson)
                + "</br>Display Certify Person : " + TextColor.blueColor(CertifyPersonValue)
                + "</br>Display Text Language : " + TextColor.blueColor(LabelDocLanguage)
                + "</br>Display Language : " + TextColor.blueColor(DocLanguageValue)
                + "</br>Display Text Asset Details : " + TextColor.blueColor(LabelAssetDetail)
                + "</br>Display Text Deposit value : " + TextColor.blueColor(LabelDepositValue)
                + "</br>Display Deposit Value : " + TextColor.blueColor(TotalBalanceDeposit)
                + "</br>Display Text Investment Value : " + TextColor.blueColor(LabelInvestmentValue)
                + "</br>Display Investment Value : " + TextColor.blueColor(TotalBalanceInvestmentValue)
                + "</br>Display Text Total Assets : " + TextColor.blueColor(LabelTotalAsset)
                + "</br>Display Total Assets : " + TextColor.blueColor(TotalBalanceAssetValue)
                + "</br>Display Text Service Fee : " + TextColor.blueColor(LabelServiceFee)
                + "</br>Display Text EN Version : " + TextColor.blueColor(LabelFeeEN)
                + "</br>Display EN Version : " + TextColor.blueColor(FeeENValue)
                + "</br>Display Text TH Version : " + TextColor.blueColor(LabelFeeTH)
                + "</br>Display TH Version : " + TextColor.blueColor(FeeTHValue)
                + "</br>Display Next button : " + TextColor.blueColor(BtnNextFinancial5Screen)
                + "</pre>");
        String InformationReviewScreen2 = "images/InformationReviewScreen2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(InformationReviewScreen2);
        scenario.createNode(Given.class, "The system should display the Information Review screen").addScreenCaptureFromPath(InformationReviewScreen2).pass("Pass");

        System.err.println("TitleHeaderProcess5 : " + TitleHeaderProcess5);
        System.err.println("NumberProcess5 : " + NumberProcess5);
        System.err.println("LabelProcess5 : " + LabelProcess5);
        System.err.println("Text Financial Certificate Details : " + LabelFinancialCertificateDetail);
        System.err.println("Text Certificate Type : " + LabelCertificateType);
        System.err.println("Certificate Type value : " + CertificateTypeValue);
        System.err.println("LabelPurpose : " + LabelPurpose);
        System.err.println("PurposeValue : " + PurposeValue);
        System.err.println("LabelAssetOwner : " + LabelAssetOwner);
        System.err.println("AssetOwnerValue : " + AssetOwnerValue);
        System.err.println("LabelCertifyPerson : " + LabelCertifyPerson);
        System.err.println("CertifyPersonValue : " + CertifyPersonValue);
        System.err.println("LabelDocLanguage : " + LabelDocLanguage);
        System.err.println("DocLanguageValue : " + DocLanguageValue);
        System.err.println("LabelAssetDetail : " + LabelAssetDetail);
        System.err.println("LabelDepositValue : " + LabelDepositValue);
        System.err.println("TotalBalanceDeposit : " + TotalBalanceDeposit);
        System.err.println("LabelInvestmentValue : " + LabelInvestmentValue);
        System.err.println("TotalBalanceInvestmentValue : " + TotalBalanceInvestmentValue);
        System.err.println("LabelTotalAsset : " + LabelTotalAsset);
        System.err.println("TotalBalanceAssetValue : " + TotalBalanceAssetValue);
        System.err.println("LabelServiceFee : " + LabelServiceFee);
        System.err.println("LabelFeeEN : " + LabelFeeEN);
        System.err.println("FeeENValue : " + FeeENValue);
        System.err.println("LabelFeeTH : " + LabelFeeTH);
        System.err.println("FeeTHValue : " + FeeTHValue);
        System.err.println("BtnNextFinancial5Screen : " + BtnNextFinancial5Screen);

        ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_5_FINANCIAL).click();

        Assert.assertTrue(TitleHeaderProcess5.equals("Financial Certificate"));
        Assert.assertTrue(NumberProcess5.equals("5 / 5"));
        Assert.assertTrue(LabelProcess5.equals("Information Review"));
        Assert.assertTrue(LabelFinancialCertificateDetail.equals("Financial Certificate Details"));
        Assert.assertTrue(LabelCertificateType.equals("Certificate type"));
        Assert.assertTrue(CertificateTypeValue.equals("to sponsor other person"));
        Assert.assertTrue(LabelPurpose.equals("Purpose of use"));
        Assert.assertTrue(PurposeValue.equals("Apply for Visa"));
        Assert.assertTrue(LabelAssetOwner.equals("Asset owner"));
        System.out .println(AssetOwnerValue + " = " + firstName + middleName + lastName);
        Assert.assertTrue(AssetOwnerValue.equals("Miss. " + firstName + middleName + lastName));
        Assert.assertTrue(LabelCertifyPerson.equals("Certify person"));
        Assert.assertTrue(CertifyPersonValue.equals("Master. Hello World"));
        Assert.assertTrue(LabelDocLanguage.equals("Document language"));
        Assert.assertTrue(DocLanguageValue.equals("English"));
        Assert.assertTrue(LabelAssetDetail.equals("Asset Details"));
        Assert.assertTrue(LabelDepositValue.equals("Deposit value"));
        Assert.assertTrue(TotalBalanceDeposit.equals(FormatNumber.formatBalance(totalBalance_deposit)));
        Assert.assertTrue(LabelInvestmentValue.equals("Investment value"));
        System.out .println("totalBalance_investment = " + FormatNumber.formatBalance(totalBalance_investment));
        Assert.assertTrue(TotalBalanceInvestmentValue.equals(FormatNumber.formatBalance(totalBalance_investment)));
        Assert.assertTrue(LabelTotalAsset.equals("Total assets"));
        Assert.assertTrue(TotalBalanceAssetValue.equals(FormatNumber.formatBalance(totalBalance)));
        Assert.assertTrue(LabelServiceFee.equals("Service Fee"));
        Assert.assertTrue(LabelFeeEN.equals("Financial certificate (EN)"));
        Assert.assertTrue(FeeENValue.equals("Free"));
        Assert.assertTrue(LabelFeeTH.equals("Financial certificate (TH)"));
        Assert.assertTrue(FeeTHValue.equals("Free"));
        Assert.assertTrue(BtnNextFinancial5Screen.equals("Confirm"));
    }

    @Test(priority = 6)
    public void TC_Financial_Certificate_0007() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        String TitleHeaderProcess6 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CERTIFICATE_DETAIL_SCREEN_6).getText();
        String BtnClose = ttbTestContext.findElement(OneAppElementKeys.BTN_CLOSE_FINANCIAL).getText();
        String BtnSave = ttbTestContext.findElement(OneAppElementKeys.BTN_SAVE_FINANCIAL).getText();
        String BtnShare = ttbTestContext.findElement(OneAppElementKeys.BTN_SHARE_FINANCIAL).getText();

        System.err.println("TitleHeaderProcess6 : " + TitleHeaderProcess6);
        System.err.println("BtnSave : " + BtnSave);
        System.err.println("BtnShare : " + BtnShare);
        Assert.assertTrue(TitleHeaderProcess6.equals("Financial Certificate"));
        Assert.assertTrue(BtnSave.equals("Save File"));
        Assert.assertTrue(BtnShare.equals("Share File"));
        getExtent().flush();
    }
}
