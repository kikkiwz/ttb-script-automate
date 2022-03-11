package com.tmb.automation.test.customerservice.sprint25;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

import java.util.List;

public class MutualFund_TH extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		ExtentListeners.setDriver(appiumDriverMobile);
	}
    @Test(priority = 0)
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
    	Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        MobileElement discover = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout"));
        discover.click();
        Thread.sleep(5000);
        List<MobileElement> skip=appiumDriverMobile.findElements(By.id("com.ttbbank.oneapp.vit:id/skipIntro"));
		if(skip.size()==1) {
			skip.get(1).click();
		}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
        MobileElement TitlePassBook = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elTitlePassBook = TitlePassBook.getText();
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        MobileElement TitleMutualFund = appiumDriverMobile.findElementByXPath("//*[@resource-id='mutual_fund_passbook_account_list_title_label']");
        String elTitleMutualFund = TitleMutualFund.getText();
        MobileElement MutualFund0 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.view.View/android.view.View[2]");
        String elMutualFund0 = MutualFund0.getText();
        MobileElement MutualFundCode0 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[8]/android.view.View/android.view.View[3]");
        String elMutualFundCode0 = MutualFundCode0.getText();
        MobileElement MutualFund1 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[9]/android.view.View/android.view.View[2]");
        String elMutualFund1 = MutualFund1.getText();
        MobileElement MutualFundCode1 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[9]/android.view.View/android.view.View[3]");
        String elMutualFundCode1 = MutualFundCode1.getText();
        MobileElement BtnView = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-input-button-footer']");
        String elBtnView = BtnView.getText();

        System.err.println("elTitlePassBook : " + elTitlePassBook);
        System.err.println("elTitleMutualFund : " + elTitleMutualFund);
        System.err.println("elMutualFund0 : " + elMutualFund0);
        System.err.println("elMutualFundCode0 : " + elMutualFundCode0);
        System.err.println("elMutualFund1 : " + elMutualFund1);
        System.err.println("elMutualFundCode1 : " + elMutualFundCode1);
        System.err.println("elBtnView : " + elBtnView);

                Assert.assertTrue(elTitlePassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elTitleMutualFund.equals("หน้าสมุดบัญชีกองทุนรวม"));
        Assert.assertTrue(elMutualFund0.equals("Test Nickname"));
        Assert.assertTrue(elMutualFundCode0.equals("PT01829798"));
        Assert.assertTrue(elMutualFund1.equals("-"));
        Assert.assertTrue(elMutualFundCode1.equals("PT01829800"));
        Assert.assertTrue(elBtnView.equals("เรียกดู"));
        MutualFund1.click();
        BtnView.click();
    }

    @Test(priority = 1)
    public void TC_ONEAPP_10581_PBFundList_01001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-header-label']")));
        MobileElement MutualFundPassbook = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elMutualFundPassbook = MutualFundPassbook.getText();
        MobileElement selectFund = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]");
        String elselectFund = selectFund.getText();
        MobileElement PortfolioCode = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]");
        String elPortfolioCode = PortfolioCode.getText();
        MobileElement MutualFund0 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_0']");
        String elMutualFund0 = MutualFund0.getText();
        MobileElement MutualFundName0 = appiumDriverMobile.findElementByXPath("//*[@resource-id='description_0']");
        String elMutualFundName0 = MutualFundName0.getText();
        MobileElement MutualFund1 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_1']");
        String elMutualFund1 = MutualFund1.getText();
        MobileElement MutualFundName1 = appiumDriverMobile.findElementByXPath("//*[@resource-id='description_1']");
        String elMutualFundName1 = MutualFundName1.getText();
        MobileElement MutualFund2 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_2']");
        String elMutualFund2 = MutualFund2.getText();
        MobileElement MutualFundName2 = appiumDriverMobile.findElementByXPath("//*[@resource-id='description_2']");
        String elMutualFundName2 = MutualFundName2.getText();
        MobileElement MutualFund3 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_3']");
        String elMutualFund3 = MutualFund3.getText();
        MobileElement MutualFundName3 = appiumDriverMobile.findElementByXPath("//*[@resource-id='description_3']");
        String elMutualFundName3 = MutualFundName3.getText();
        MobileElement BtnView = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-input-button-footer']");
        String elBtnView = BtnView.getText();

        System.err.println("elMutualFundPassbook : " + elMutualFundPassbook);
        System.err.println("elselectFund : " + elselectFund);
        System.err.println("elPortfolioCode : " + elPortfolioCode);
        System.err.println("elMutualFund0 : " + elMutualFund0);
        System.err.println("elMutualFundName0 : " + elMutualFundName0);
        System.err.println("elMutualFund1 : " + elMutualFund1);
        System.err.println("elMutualFundName1 : " + elMutualFundName1);
        System.err.println("elMutualFund1 : " + elMutualFund2);
        System.err.println("elMutualFundName1 : " + elMutualFundName2);
        System.err.println("elBtnView : " + elBtnView);

       
        Assert.assertTrue(elMutualFundPassbook.equals("หน้าสมุดบัญชีกองทุนรวม"));
        Assert.assertTrue(elselectFund.equals("กรุณาเลือกกองทุนจาก -"));
        Assert.assertTrue(elPortfolioCode.equals("เลขที่พอร์ทการลงทุน : PT01829800"));
        Assert.assertTrue(elMutualFund0.equals("MODEL1"));
        Assert.assertTrue(elMutualFundName0.equals("สมาร์ทพอร์ตโมเดล 1"));
        Assert.assertTrue(elMutualFund1.equals("MODEL2"));
        Assert.assertTrue(elMutualFundName1.equals("สมาร์ทพอร์ตโมเดล 2"));
        Assert.assertTrue(elMutualFund2.equals("MODEL3"));
        Assert.assertTrue(elMutualFundName2.equals("สมาร์ทพอร์ตโมเดล 3"));
        Assert.assertTrue(elMutualFund3.equals("TESCHINAA"));
        Assert.assertTrue(elMutualFundName3.equals("กองทุนเปิดธนชาต อีสท์สปริง China A Active"));
        Assert.assertTrue(elBtnView.equals("เรียกดู"));

        MutualFund0.click();
        BtnView.click();
    }

    @Test(priority = 2)
    public void TC_ONEAPP_10582_PBMF_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));
        MobileElement MutualFundPassbook = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_title_label']");
        String elMutualFundPassbook = MutualFundPassbook.getText();
        MobileElement NameOfUnitholders = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]");
        String elNameOfUnitholders = NameOfUnitholders.getText();
        MobileElement UnitholderName = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]");
        String elUnitholderName = UnitholderName.getText();
        MobileElement MutualFundName = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[4]");
        String elMutualFundName = MutualFundName.getText();
        MobileElement FundName = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[5]");
        String elFundName = FundName.getText();
        MobileElement PortNo = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[7]");
        String elPortNo = PortNo.getText();
        MobileElement PortfolioCode = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[8]");
        String elPortfolioCode = PortfolioCode.getText();
        MobileElement OfficeAndBranch = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[10]");
        String elOfficeAndBranch = OfficeAndBranch.getText();
        MobileElement OfficeBranch = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[11]");
        String elOfficeBranch = OfficeBranch.getText();
        MobileElement remark = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[14]");
        String elremark = remark.getText();
        MobileElement RemarkDetail = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[15]");
        String elRemarkDetail = RemarkDetail.getText();
        MobileElement UnitholderNameValue = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-name']");
        String elUnitholderNameValue = UnitholderNameValue.getText();
        MobileElement FundNameValue = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_fund_name_id']");
        String elFundNameValue = FundNameValue.getText();
        MobileElement PortfolioCodeValue = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-no']");
        String elPortfolioCodeValue = PortfolioCodeValue.getText();
        MobileElement OfficeBranchValue = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-branch-name']");
        String elOfficeBranchValue = OfficeBranchValue.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-back-to-main-button']");
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        MobileElement BtnSave = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']");
        String elBtnSave = BtnSave.getText();
        MobileElement BtnShare = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']");
        String elBtnShare = BtnShare.getText();
        MobileElement BtnBack = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image");

        System.err.println("elMutualFundPassbook : " + elMutualFundPassbook);
        System.err.println("elNameOfUnitholders : " + elNameOfUnitholders);
        System.err.println("elUnitholderName : " + elUnitholderName);
        System.err.println("elMutualFundName : " + elMutualFundName);
        System.err.println("elFundName : " + elFundName);
        System.err.println("elPortNo : " + elPortNo);
        System.err.println("elPortfolioCode : " + elPortfolioCode);
        System.err.println("elOfficeAndBranch : " + elOfficeAndBranch);
        System.err.println("elOfficeBranch : " + elOfficeBranch);
        System.err.println("elremark : " + elremark);
        System.err.println("elRemarkDetail : " + elRemarkDetail);
        System.err.println("elUnitholderNameValue : " + elUnitholderNameValue);
        System.err.println("elFundNameValue : " + elFundNameValue);
        System.err.println("elPortfolioCodeValue : " + elPortfolioCodeValue);
        System.err.println("elOfficeBranchValue : " + elOfficeBranchValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);
        System.err.println("elBtnSave : " + elBtnSave);
        System.err.println("elBtnShare : " + elBtnShare);

        
        Assert.assertTrue(elMutualFundPassbook.equals("หน้าสมุดบัญชีกองทุนรวม"));
        Assert.assertTrue(elNameOfUnitholders.equals("ชื่อผู้ถือหน่วยลงทุน"));
        Assert.assertTrue(elUnitholderName.equals("Unitholder Name"));
        Assert.assertTrue(elMutualFundName.equals("ชื่อกองทุน"));
        Assert.assertTrue(elFundName.equals("Fund Name"));
        Assert.assertTrue(elPortNo.equals("เลขที่พอร์ทการลงทุน"));
        Assert.assertTrue(elPortfolioCode.equals("Portfolio Code"));
        Assert.assertTrue(elOfficeAndBranch.equals("สำนักงาน / สาขา"));
        Assert.assertTrue(elOfficeBranch.equals("Office / Branch"));
        Assert.assertTrue(elremark.equals("หมายเหตุ:"));
        Assert.assertTrue(elRemarkDetail.equals("หน้าสมุดบัญชีกองทุนแบบอิเล็กทรอนิกส์ (E-Passbook) นี้ ใช้เพื่อแสดงชื่อผู้ถือหน่วยลงทุน ชื่อกองทุน เลขที่พอร์ตการลงทุน และ สาขาหรือช่องทางที่เปิดบัญชีกองทุนจากระบบของ ธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(elUnitholderNameValue.equals("เอ็มไอบีเอ็มไอบี เทสเอ็มเอฟ"));
        Assert.assertTrue(elFundNameValue.equals("สมาร์ทพอร์ตโมเดล 1"));
        Assert.assertTrue(elPortfolioCodeValue.equals("PT000000000001829800"));
        Assert.assertTrue(elOfficeBranchValue.equals("touch application"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("กลับหน้าหลัก"));
        Assert.assertTrue(elBtnSave.equals("บันทึกไฟล์"));
        Assert.assertTrue(elBtnShare.equals("แชร์ไฟล์"));

        BtnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-header-label']")));
    
    }

    @Test(priority = 3)
    public void TC_ONEAPP_10582_PBMF_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        MobileElement BtnView = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-input-button-footer']");
        MobileElement MutualFund0 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_0']");
        MutualFund0.click();
        BtnView.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-back-to-main-button']");
        BtnBackToMainMenu.click();
    
    }

    @Test(priority = 4)
    public void TC_ONEAPP_10584_PBMF_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        MobileElement MutualFund1 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[9]/android.view.View/android.view.View[2]");
        MobileElement BtnView = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-input-button-footer']");
        MutualFund1.click();
        BtnView.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-header-label']")));
        MobileElement MutualFund0 = appiumDriverMobile.findElementByXPath("//*[@resource-id='label_0']");
        MutualFund0.click();
        BtnView.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));
        MobileElement BtnSave = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']");
        BtnSave.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement TitlePopupSave = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_popup_title_id']");
        String elTitlePopupSave = TitlePopupSave.getText();
        MobileElement BtnPDF = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View");
        String elBtnPDF = BtnPDF.getText();
        MobileElement BtnImage = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View");
        String elBtnImage = BtnImage.getText();

        System.err.println("elTitlePopupSave : " + elTitlePopupSave);
        System.err.println("elBtnPDF : " + elBtnPDF);
        System.err.println("elBtnImage : " + elBtnImage);

        Assert.assertTrue(elTitlePopupSave.equals("เลือกประเภทไฟล์ที่ต้องการบันทึก"));
        Assert.assertTrue(elBtnPDF.equals("ไฟล์ PDF"));
        Assert.assertTrue(elBtnImage.equals("ไฟล์ ภาพ"));

        MobileElement BtnX = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_popup_close_button_id']");
        BtnX.click();
        
    }

    @Test(priority = 5)
    public void TC_ONEAPP_10584_PBMF_00002() throws Exception {
        appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']").click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement BtnImage = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View");
        BtnImage.click();
        Thread.sleep(7000);


    }

    @Test(priority = 6)
    public void TC_ONEAPP_10584_PBMF_00003() throws Exception {
        appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']").click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement BtnPDF = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View");
        BtnPDF.click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='android:id/button1']")));
		/*
		 * String activity = appiumDriverMobile.currentActivity();
		 * System.err.println("elTitlePopupSave : " + activity);
		 */
        MobileElement BtnSavePDF = appiumDriverMobile.findElementByXPath("//*[@resource-id='android:id/button1']");
        BtnSavePDF.click();
        Thread.sleep(2000);
 
    }

    @Test(priority = 7)
    public void TC_ONEAPP_10585_PBMF_00001() throws Exception {
        appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']").click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement TitlePopupShare = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_popup_title_id']");
        String elTitlePopupShare = TitlePopupShare.getText();
        MobileElement BtnPDF = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View");
        String elBtnPDF = BtnPDF.getText();
        MobileElement BtnImage = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View");
        String elBtnImage = BtnImage.getText();

        System.err.println("elTitlePopupShare : " + elTitlePopupShare);
        System.err.println("elBtnPDF : " + elBtnPDF);
        System.err.println("elBtnImage : " + elBtnImage);
        Assert.assertTrue(elTitlePopupShare.equals("เลือกประเภทไฟล์ที่ต้องการแชร์"));
        Assert.assertTrue(elBtnPDF.equals("ไฟล์ PDF"));
        Assert.assertTrue(elBtnImage.equals("ไฟล์ ภาพ"));

        MobileElement BtnX = appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_detail_popup_close_button_id']");
        BtnX.click();
       
    }

    @Test(priority = 8)
    public void TC_ONEAPP_10585_PBMFShare_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));
        appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement BtnImage = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View");
        BtnImage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView[1]")));
		/*
		 * String activity = appiumDriverMobile.currentActivity();
		 * System.err.println("elTitlePopupSave : " + activity);
		 */


        MobileElement SelectLine = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView[1]");
        SelectLine.click();
        Thread.sleep(3000);
 

        appiumDriverMobile.findElementByXPath("//*[@resource-id='jp.naver.line.android:id/send_balloon_image']").click();
        Thread.sleep(3000);
 

        appiumDriverMobile.navigate().back();
        Thread.sleep(1000);
        appiumDriverMobile.navigate().back();
        Thread.sleep(2000);
  
    }

    @Test(priority = 9)
    public void TC_ONEAPP_10585_PBMFShare_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));
        appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_popup_title_id']")));
        MobileElement BtnPDF = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View");
        BtnPDF.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[4]")));
        MobileElement SelectGmail = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[4]");
        SelectGmail.click();
       // String activity = appiumDriverMobile.currentActivity();
       // System.err.println("elTitlePopupSave : " + activity);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText")));
        MobileElement InputEmail = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText");
        InputEmail.sendKeys("kampanart.p@tcs.com");
        MobileElement SendEmail = appiumDriverMobile.findElementByXPath("//*[@resource-id='com.google.android.gm:id/send']");
        SendEmail.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_detail_title_label']")));

    }
    @AfterClass
    public void teardown() {
    	appiumDriverMobile.quit();
    }
 
}
