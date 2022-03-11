package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
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


public class TC_ONEAPP_4524_TH extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}
    public static boolean checkdate(String dt1)
    {
        SimpleDateFormat df1=new SimpleDateFormat("dd/mm/yy");
        System.out.println(df1.toPattern());
        df1.setLenient(false);
        try {
            df1.parse(dt1);
        } catch (ParseException e) {

            return false;
        }
        return true;
    }


    @Test(priority = 0)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00003() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
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
       
        Assert.assertTrue(elCaseStatusTrackingHeader.equals("ติดตามสถานะคำขอ/คำร้อง"));
        Assert.assertTrue(elSectionInprogress.equals("กำลังดำเนินการ"));
        Assert.assertTrue(elSectionComplete.equals("ดำเนินการเรียบร้อยเเล้ว"));
    }

    @Test(priority = 1)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00004() throws Exception {
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
     MobileElement btnRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_inprogress_0']"));
        btnRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));
          MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("ติดตามสถานะคำขอ/คำร้อง"));
        Assert.assertTrue(elSectionInprogress.equals("กำลังดำเนินการ"));
        Assert.assertTrue(elCasetype.equals("คำขอ"));
        Assert.assertTrue(elRefNo.equals("รหัสอ้างอิง 00308386"));
        Assert.assertTrue(elIssue.equals("เรื่อง"));
        Assert.assertTrue(elIssueContent.equals("ไม่ได้รับของสมนาคุณประเภทสินค้า / บัตรกำนัล / e coupon หรือ Code สิทธิพิเศษ ตามกำหนดการจัดส่งตามเงื่อนไขของธนาคาร"));
        Assert.assertTrue(elStatusText.equals("อยู่ระหว่างดำเนินการ"));
        Assert.assertTrue(elStatusText.equals("อยู่ระหว่างดำเนินการ"));
    }

    @Test(priority = 2)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
        MobileElement btnRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_inprogress_0']"));
        btnRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='cs_case-status-tracking-title-label-detail']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]");
        String elRefNo = RefNo.getText();
        MobileElement Issue = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]");
        String elIssue = Issue.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement ProductService = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[4]");
        String elProductService = ProductService.getText();
        MobileElement Complaint = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[5]");
        String elComplaint = Complaint.getText();
        MobileElement IssuedDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_label']");
        String elIssuedDate = IssuedDate.getText();
        MobileElement DateStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_issued_date_value']");
        String elDateStart = DateStart.getText();
        MobileElement ExpectedFinishDate = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_label']");
        String elExpectedFinishDate = ExpectedFinishDate.getText();
        MobileElement DateFinish = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='case_status_tracking_detail_expected_date_value']");
        String elDateFinish = DateFinish.getText();
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
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));

              MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("คำขอ/คำร้อง"));
        Assert.assertTrue(elRefNo.equals("รหัสอ้างอิง 00308386"));
        Assert.assertTrue(elIssue.equals("เรื่อง"));
        Assert.assertTrue(elCardTypeDetail.equals("ไม่ได้รับของสมนาคุณประเภทสินค้า / บัตรกำนัล / e coupon หรือ Code สิทธิพิเศษ ตามกำหนดการจัดส่งตามเงื่อนไขของธนาคาร"));
        Assert.assertTrue(elProductService.equals("ประเภทผลิตภัณฑ์/บริการ"));
        Assert.assertTrue(elComplaint.equals("กองทุน"));
        Assert.assertTrue(elIssuedDate.equals("วันที่แจ้ง"));
        Assert.assertTrue(elDateStart.equals("9 มี.ค. 64"));
        Assert.assertTrue(elExpectedFinishDate.equals("วันที่คาดว่าจะแล้วเสร็จ"));
        Assert.assertTrue(elDateFinish.equals("18 มี.ค. 64"));
        Assert.assertTrue(isValidFormat("dd MMMM yy", elDateStart, Locale.ENGLISH));
        Assert.assertTrue(isValidFormat("dd MMMM yy", elDateFinish, Locale.ENGLISH));
    }

    @Test(priority = 3)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00007() throws Exception {
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

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("ติดตามสถานะคำขอ/คำร้อง"));
//        Assert.assertTrue(elSectionInprogress.equals("In Progress"));
//        Assert.assertTrue(elSectionComplete.equals("Done / Resolved"));
        Assert.assertTrue(elCasetype.equals("คำขอ"));
        Assert.assertTrue(elRefNo.equals("รหัสอ้างอิง 00308636"));
        Assert.assertTrue(elIssue.equals("เรื่อง"));
        Assert.assertTrue(elIssueContent.equals("ธนาคารได้ส่งเรื่องออกเอกสารให้คุณเรียบร้อยแล้ว"));
        Assert.assertTrue(elStatusText.equals("ดำเนินการเสร็จเเล้ว"));
    }

    @Test(priority = 4)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00008() throws Exception {
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
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateStart, Locale.ENGLISH));
        System.err.println("check format date : " + isValidFormat("dd MMM yy", elDateFinish, Locale.ENGLISH));

                MobileElement btnBackDetail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackDetail.click();

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("คำขอ/คำร้อง"));
        Assert.assertTrue(elRefNo.equals("รหัสอ้างอิง 00308636"));
        Assert.assertTrue(elIssue.equals("เรื่อง"));
        Assert.assertTrue(elCardTypeDetail.equals("ธนาคารได้ส่งเรื่องออกเอกสารให้คุณเรียบร้อยแล้ว"));
        Assert.assertTrue(elProductService.equals("ประเภทผลิตภัณฑ์/บริการ"));
        Assert.assertTrue(elComplaint.equals("NCB"));
        Assert.assertTrue(elIssuedDate.equals("วันที่แจ้ง"));
        Assert.assertTrue(elDateStart.equals("31 มี.ค. 64"));
        Assert.assertTrue(elExpectedFinishDate.equals("วันที่แล้วเสร็จ"));
        Assert.assertTrue(elDateFinish.equals("31 มี.ค. 64"));
        Assert.assertTrue(isValidFormat("dd MMMM yy", elDateStart, Locale.ENGLISH));
        Assert.assertTrue(isValidFormat("dd MMMM yy", elDateFinish, Locale.ENGLISH));
    }

    @Test(priority = 5)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00013() throws Exception {
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
