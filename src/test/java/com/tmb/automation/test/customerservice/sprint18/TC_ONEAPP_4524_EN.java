package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint18.DateValidatorUsingDateFormat.isValidFormat;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scroll;


public class TC_ONEAPP_4524_EN extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}

    @Test(priority = 0)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='label_customerservice_case_tracking_title_tutorial']")));

        MobileElement TutorialTitle = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='label_customerservice_case_tracking_title_tutorial']");
        String elTutorialTitle = TutorialTitle.getText();
        MobileElement TutorialDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='label_customerservice_case_tracking_desc_tutorial']");
        String elTutorialDetail = TutorialDetail.getText();
        System.err.println("get TutorialTitle : " + elTutorialTitle);
        System.err.println("get element : " + elTutorialDetail);

        Assert.assertTrue(elTutorialTitle.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elTutorialDetail.equals("Allowing you to track the progress of requesting services Of TTB closely anywhere, anytime."));
    }

    @Test(priority = 1)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnStart = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='button_customerservice_case_tracking_start_tutorial']"));
        btnStart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
//        Assert.assertTrue(elTutorialTitle.equals("Complaint / Request Tracking"));
//        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));
    }

    @Test(priority = 2)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));

        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));

//        Assert.assertTrue(elTutorialTitle.equals("Complaint / Request Tracking"));
//        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));

    }


//    @Test(priority = 0)
//    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00001() throws Exception {
//        OpenService();
//        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
//        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='service-screen-button-passbook']");
//        String elPassBook = PassBook.getText();
//        MobileElement btnCaseStatusTracking = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='service-screen-button-case-status-tracking']");
//        String elbtnCaseStatusTracking = btnCaseStatusTracking.getText();
//        MobileElement btnAST = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='service-screen-button-application-tracking']");
//        String elbtnAST = btnAST.getText();
//
//        if(true){
//            parentReport = extent.createTest("TS_ONEAPP_4524_EN", "TS_ONEAPP_4524_EN");
//        }
//        childReport = parentReport.createNode("TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00001");
//        childReport.log(Status.INFO, "<pre> 1. The system should display Yindee Landing page details as below\n" +
//                "- Button: Application Tracking\n" +
//                "- Button: Case Tracking\n" +
//                "- Button: Virtual Passbook\n" +
//                "2. After Clicking on Case Tracking, the system should display Complaint case status tracking screen </pre>");
//        childReport.log(Status.INFO, "<pre> Actual result : Display Button Virtual Passbook : " + elPassBook
//                + "</br>Display Button Case Tracking : " + elbtnCaseStatusTracking
//                + "</br>Display Button Application Tracking : " + elbtnAST
//                + "</pre>");
//        childReport.pass("1. The system should display Select Account screen Details as below:" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        MobileElement caseStatusTracking = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
//        caseStatusTracking.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
//        childReport.pass("2. After Clicking on Case Tracking, the system should display Complaint case status tracking screen."+ TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//    }

    @Test(priority = 3)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
//        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
//        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case-status-tracking-label-head']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
        String elSectionInprogress = SectionInprogress.getText();
        MobileElement SectionComplete = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]");
        String elSectionComplete = SectionComplete.getText();
        System.err.println("get element : " + elCaseStatusTrackingHeader);
        System.err.println("get element : " + elSectionInprogress);
        System.err.println("get element : " + elSectionComplete);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
         Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));
        Assert.assertTrue(elSectionComplete.equals("Done / Resolved"));
    }

    @Test(priority = 4)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00004() throws Exception {
        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case-status-tracking-label-head']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
        String elSectionInprogress = SectionInprogress.getText();
        MobileElement SectionComplete = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]");
        String elSectionComplete = SectionComplete.getText();
        MobileElement Casetype = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_inprogress_0']");
        String elCasetype = Casetype.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='subjectRefno_inprogress_0']");
        String elRefNo = RefNo.getText();
        MobileElement Issue = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='subjectContent_inprogress_0']");
        String elIssue = Issue.getText();
        MobileElement IssueContent = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='content_inprogress_0']");
        String elIssueContent = IssueContent.getText();
        MobileElement StatusText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='statusText_inprogress_0']");
        String elStatusText = StatusText.getText();
        System.err.println("get elCaseStatusTrackingHeader : " + elCaseStatusTrackingHeader);
        System.err.println("get elSectionInprogress : " + elSectionInprogress);
        System.err.println("get elSectionComplete : " + elSectionComplete);
        System.err.println("get elCasetype : " + elCasetype);
        System.err.println("get elRefNo : " + elRefNo);
        System.err.println("get elIssue : " + elIssue);
        System.err.println("get elIssueContent : " + elIssueContent);
        System.err.println("get elStatusText : " + elStatusText);
  //     scroll();
         MobileElement btnRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_inprogress_0']"));
        btnRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));
         MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));
        Assert.assertTrue(elSectionComplete.equals("Done / Resolved"));
        Assert.assertTrue(elCasetype.equals("Request"));
        Assert.assertTrue(elRefNo.equals("Ref.no. 00308386"));
        Assert.assertTrue(elIssue.equals("Issue"));
        Assert.assertTrue(elIssueContent.equals("The product / gift voucher / e coupon or code was not received according to the delivery schedule according to the Bank's conditions"));
        Assert.assertTrue(elStatusText.equals("In Progress"));
    }

    @Test(priority = 5)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
        MobileElement btnRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_inprogress_0']"));
        btnRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='cs_case-status-tracking-title-label-detail']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_title_ref_no_label']");
        String elRefNo = RefNo.getText();
        MobileElement Issue = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issue_type_label']");
        String elIssue = Issue.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issue_value_label']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement ProductService = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_product_or_service_type_label']");
        String elProductService = ProductService.getText();
        MobileElement Complaint = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_product_or_service_value_label']");
        String elComplaint = Complaint.getText();
        MobileElement IssuedDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_label']");
        String elIssuedDate = IssuedDate.getText();
        MobileElement DateStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_value']");
        String elDateStart = DateStart.getText();
        MobileElement ExpectedFinishDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_label']");
        String elExpectedFinishDate = ExpectedFinishDate.getText();
        MobileElement DateFinish = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_value']");
        String elDateFinish = DateFinish.getText();
        MobileElement HelpCenter = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='cs_case-status-tracking-detail-button-helper']");
        String elHelpCenter = HelpCenter.getText();
        System.err.println("get elCaseStatusTrackingHeader : " + elCaseStatusTrackingHeader);
        System.err.println("get elRefNo : " + elRefNo);
        System.err.println("get elIssue : " + elIssue);
        System.err.println("get elIssue : " + elCardTypeDetail);
        System.err.println("get elProductService : " + elProductService);
        System.err.println("get elComplaint : " + elComplaint);
        System.err.println("get elIssuedDate : " + elIssuedDate);
        System.err.println("get elDateStart : " + elDateStart);
        System.err.println("get elExpectedFinishDate : " + elExpectedFinishDate);
        System.err.println("get elDateFinish : " + elDateFinish);
        System.err.println("get elDateFinish : " + elHelpCenter);
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));

               MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();
      
        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elRefNo.equals("Ref.no. 00308386"));
        Assert.assertTrue(elIssue.equals("Issue"));
        Assert.assertTrue(elCardTypeDetail.equals("The product / gift voucher / e coupon or code was not received according to the delivery schedule according to the Bank's conditions"));
        Assert.assertTrue(elProductService.equals("Product/Service"));
        Assert.assertTrue(elComplaint.equals("Mutual Fund"));
        Assert.assertTrue(elIssuedDate.equals("Issued date"));
        Assert.assertTrue(elDateStart.equals("09 Mar 21"));
        Assert.assertTrue(elExpectedFinishDate.equals("Expected finish date"));
        Assert.assertTrue(elDateFinish.equals("18 Mar 21"));
//        Assert.assertTrue(elHelpCenter.equals("Help Center"));
        Assert.assertTrue(isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        Assert.assertTrue(isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));
    }

    @Test(priority = 6)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00007() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
        scroll();

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case-status-tracking-label-head']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
        String elSectionInprogress = SectionInprogress.getText();
        MobileElement SectionComplete = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]");
        String elSectionComplete = SectionComplete.getText();
        MobileElement Casetype = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_completed_0']");
        String elCasetype = Casetype.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='subjectRefno_completed_0']");
        String elRefNo = RefNo.getText();
        MobileElement Issue = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='subjectContent_completed_0']");
        String elIssue = Issue.getText();
        MobileElement IssueContent = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='content_completed_0']");
        String elIssueContent = IssueContent.getText();
        MobileElement StatusText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='statusText_completed_0']");
        String elStatusText = StatusText.getText();
        System.err.println("get elCaseStatusTrackingHeader : " + elCaseStatusTrackingHeader);
        System.err.println("get elSectionInprogress : " + elSectionInprogress);
        System.err.println("get elSectionComplete : " + elSectionComplete);
        System.err.println("get elCasetype : " + elCasetype);
        System.err.println("get elRefNo : " + elRefNo);
        System.err.println("get elIssue : " + elIssue);
        System.err.println("get elIssueContent : " + elIssueContent);
        System.err.println("get elStatusText : " + elStatusText);

       //        MobileElement btnRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_0']"));
        Casetype.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));
      
        MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
//        Assert.assertTrue(elSectionInprogress.equals("In Progress"));
//        Assert.assertTrue(elSectionComplete.equals("Done / Resolved"));
        Assert.assertTrue(elCasetype.equals("Request"));
        Assert.assertTrue(elRefNo.equals("Ref.no. 00308636"));
        Assert.assertTrue(elIssue.equals("Issue"));
        Assert.assertTrue(elIssueContent.equals("null"));
        Assert.assertTrue(elStatusText.equals("Done"));
    }

    @Test(priority = 7)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00008() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
        scroll();
        MobileElement btnRequest = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_completed_0']");
        btnRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));


        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='cs_case-status-tracking-title-label-detail']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_title_ref_no_label']");
        String elRefNo = RefNo.getText();
        MobileElement Issue = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issue_type_label']");
        String elIssue = Issue.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issue_value_label']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement ProductService = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_product_or_service_type_label']");
        String elProductService = ProductService.getText();
        MobileElement Complaint = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_product_or_service_value_label']");
        String elComplaint = Complaint.getText();
        MobileElement IssuedDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_label']");
        String elIssuedDate = IssuedDate.getText();
        MobileElement DateStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_value']");
        String elDateStart = DateStart.getText();
        MobileElement ExpectedFinishDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_label']");
        String elExpectedFinishDate = ExpectedFinishDate.getText();
        MobileElement DateFinish = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_value']");
        String elDateFinish = DateFinish.getText();
        MobileElement HelpCenter = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='cs_case-status-tracking-detail-button-helper']");
        String elHelpCenter = HelpCenter.getText();
        System.err.println("get elCaseStatusTrackingHeader : " + elCaseStatusTrackingHeader);
        System.err.println("get elRefNo : " + elRefNo);
        System.err.println("get elIssue : " + elIssue);
        System.err.println("get elIssue : " + elCardTypeDetail);
        System.err.println("get elProductService : " + elProductService);
        System.err.println("get elComplaint : " + elComplaint);
        System.err.println("get elIssuedDate : " + elIssuedDate);
        System.err.println("get elDateStart : " + elDateStart);
        System.err.println("get elExpectedFinishDate : " + elExpectedFinishDate);
        System.err.println("get elDateFinish : " + elDateFinish);
        System.err.println("get elHelpCenter : " + elHelpCenter);
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));
        MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elRefNo.equals("Ref.no. 00308636"));
        Assert.assertTrue(elIssue.equals("Issue"));
        Assert.assertTrue(elCardTypeDetail.equals("null"));
        Assert.assertTrue(elProductService.equals("Product/Service"));
        Assert.assertTrue(elComplaint.equals("Banking Service"));
        Assert.assertTrue(elIssuedDate.equals("Issued date"));
        Assert.assertTrue(elDateStart.equals("31 Mar 21"));
        Assert.assertTrue(elExpectedFinishDate.equals("Finish Date"));
        Assert.assertTrue(elDateFinish.equals("31 Mar 21"));
//        Assert.assertTrue(elHelpCenter.equals("Help Center"));
        Assert.assertTrue(isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        Assert.assertTrue(isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));
    }

    @Test(priority = 8)
    public static void TC_ONEAPP_4524_EN_CaseTracking_SIT_00013() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));

     //        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
//        Assert.assertTrue(elRefNo.equals("Ref.no. 00308295"));
//        Assert.assertTrue(elIssue.equals("Issue"));
//        Assert.assertTrue(elCardTypeDetail.equals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
//        Assert.assertTrue(elProductService.equals("Product/Service"));
    }

//    @Test(priority = 6)
//    public void TC_ONEAPP_4524_EN_CaseTracking_SIT_00011() throws Exception {
//        OpenService();
//        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
//        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
//        btnCST.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
//
//        if(true){
//            parentReport = extent.createTest("TS_ONEAPP_4524_EN", "TS_ONEAPP_4524_EN");
//        }
//        childReport = parentReport.createNode("TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00001");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system should display Completed case cards correctly.\n" +
//                "2. The system should not display In Progress case card section.</pre>");
//        childReport.pass("<pre>Actual result : Display Completed case cards correctly</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
////        Assert.assertTrue(elCaseStatusTrackingHeader.equals("Complaint/Request Tracking"));
////        Assert.assertTrue(elRefNo.equals("Ref.no. 00308295"));
////        Assert.assertTrue(elIssue.equals("Issue"));
////        Assert.assertTrue(elCardTypeDetail.equals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
////        Assert.assertTrue(elProductService.equals("Product/Service"));
//    }


}
