package com.tmb.automation.test.customerservice.sprint17;

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

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_2713_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 0)
    public void TS_ONEAPP_2713_EN_VPSelectAcct_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='1']"));
        selectAccount.click();
        Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));
        MobileElement btnImage = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-detail-button-gen-image']"));
        String elbtnImage = btnImage.getText();
        btnImage.click();
        MobileElement titleSaveImage = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]");
        String eltitleSaveImage = titleSaveImage.getText();
        MobileElement titleImage = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[1]");
        String eltitleImage = titleImage.getText();
        MobileElement btnSave = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[1]");
        String elbtnSave = btnSave.getText();
        MobileElement btnShare = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]");
        String elbtnShare = btnShare.getText();

      
//        childReport.log(Status.INFO, "<pre> actual result : Display Title : " + TextColor.blueColor(elPassBook) + "</br>Display Text Information : " + TextColor.blueColor(eltitlePassbook)
//                + "</br>Display Account Nick Name : " + TextColor.blueColor(elAccountNickName)
//                + "</br> Display Account Number : " + TextColor.blueColor(elAccountNumber)
//                + "</br> Display Branch Name : " + TextColor.blueColor(elBranchName)
//                + "</br> Display Account Type : " + account_type
//                + "</br> Display Account Status : " + account_status + "</pre>");
           Assert.assertTrue(eltitleSaveImage.equals("ไฟล์ ภาพ"));
        Assert.assertTrue(eltitleSaveImage.equals("Save & Share"));
        Assert.assertTrue(eltitleImage.equals("IMAGE"));
        Assert.assertTrue(elbtnSave.equals("Save"));
        Assert.assertTrue(elbtnShare.equals("Share"));
    }

    @Test(priority = 1)
    public void TS_ONEAPP_2713_EN_VPSelectAcct_SIT_00002() throws Exception {
        MobileElement btnX = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.widget.Button");
        btnX.click();
        MobileElement btnPDF = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-detail-button-gen-pdf']"));
        String elbtnPDF = btnPDF.getText();
        btnPDF.click();
        MobileElement titleSaveImage = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]");
        String eltitleSaveImage = titleSaveImage.getText();
        MobileElement titleImage = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[1]");
        String eltitleImage = titleImage.getText();
        MobileElement btnSave = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[1]");
        String elbtnSave = btnSave.getText();
        MobileElement btnShare = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]");
        String elbtnShare = btnShare.getText();
        Assert.assertTrue(eltitleSaveImage.equals("ไฟล์ PDF"));
        Assert.assertTrue(eltitleSaveImage.equals("Save & Share"));
        Assert.assertTrue(eltitleImage.equals("PDF"));
        Assert.assertTrue(elbtnSave.equals("Save"));
        Assert.assertTrue(elbtnShare.equals("Share"));
    }
}
