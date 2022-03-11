package com.tmb.automation.test.customerservice.sprint17;

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

public class TC_ONEAPP_2711_EN extends Base{
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 0)
    public void TS_ONEAPP_2711_EN_VPOneAcct_SIT_00001() throws Exception {
        //OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='0']")));
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='0']"));
        selectAccount.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']")));
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]")));
        MobileElement TextHeader = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]");
        String elTextHeader = TextHeader.getText();
        System.err.println("get element : " + elTextHeader);
        MobileElement AccountName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-name']");
        String elAccountName = AccountName.getText();
        System.err.println("get element : " + elAccountName);
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-no']");
        String elAccountNumber = AccountNumber.getText();
        System.err.println("get element : " + elAccountNumber);
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-branch-name']");
        String elBranchName = BranchName.getText();
        System.err.println("get element : " + elBranchName);
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-product-name-label']");
        String elProductName = ProductName.getText();
        System.err.println("get element : " + elProductName);
        MobileElement Note = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[12]");
        String elNote = Note.getText();
        System.err.println("get element : " + elNote);
        MobileElement textInNote = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[13]");
        String eltextInNote = textInNote.getText();
        System.err.println("get element : " + eltextInNote);
        MobileElement textInNote2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[14]");
        String eltextInNote2 = textInNote2.getText();
        System.err.println("get element : " + eltextInNote2);
        MobileElement btnBackMain = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-back-to-main-button']");
        String elbtnBackMain = btnBackMain.getText();
        MobileElement btnImage = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']");
        String elbtnImage = btnImage.getText();
        MobileElement btnPDFfile = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']");
        String elbtnPDFfile = btnPDFfile.getText();
              Assert.assertTrue(elTextHeader.equals("Passbook"));
        Assert.assertTrue(elAccountNumber.equals("001-3-64385-3"));
        Assert.assertTrue(elAccountName.equals("นาย ฟาติเมาะห์ เซาะตีงู"));
        Assert.assertTrue(elBranchName.equals("พหลโยธิน"));
        Assert.assertTrue(elProductName.equals("บัญชีฝากประจำทั่วไป 6 เดือน"));
        Assert.assertTrue(elNote.equals("หมายเหตุ:"));
        Assert.assertTrue(eltextInNote.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์ (E-Passbook)นี้ ใช้เพื่อแสดงหมายเลขบัญชี สาขา และ ชื่อเจ้าของบัญชีเงินฝาก จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(eltextInNote2.equals("- เพื่อความถูกต้องของการทำรายการ โปรดตรวจสอบชื่อเจ้าของบัญชีที่แสดงในระบบระหว่างการทำธุรกรรมทางการเงินทุกครั้ง"));
        Assert.assertTrue(elbtnBackMain.equals("Back to main page"));
        Assert.assertTrue(elbtnImage.equals("Image"));
        Assert.assertTrue(elbtnPDFfile.equals("PDF File"));

    }

    @Test(priority = 1)
    public void TS_ONEAPP_2711_EN_VPOneAcct_SIT_00002() throws Exception {
          MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='0']")));
        MobileElement PassbooklistTitleLabel = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String elPassbooklistTitleLabel = PassbooklistTitleLabel.getText();
         Assert.assertTrue(elPassbooklistTitleLabel.equals("Please select an account"));
    }
}
