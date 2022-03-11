package com.tmb.automation.test.customerservice.sprint23;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_9805_EN extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 1)
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement ViewDetailBtn = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_navbar_btn_view_detail_id']"));
        ViewDetailBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_header_pending_request_id']")));
        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        BtnDeregister.click();
        MobileElement TitlePopupDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elTitlePopupDeregister = TitlePopupDeregister.getText();
        MobileElement PopupDeregisterDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_popup_handle_message_label']"));
        String elPopupDeregisterDetail = PopupDeregisterDetail.getText();
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        String elBtnConfirm = BtnConfirm.getText();
        MobileElement BtnCancel = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        String elBtnCancel = BtnCancel.getText();

        System.err.println("elTitlePopupDeregister : " + elTitlePopupDeregister);
        System.err.println("elPopupDeregisterDetail : " + elPopupDeregisterDetail);
        System.err.println("elBtnConfirm : " + elBtnConfirm);
        System.err.println("elBtnCancel : " + elBtnCancel);
        Assert.assertTrue(elTitlePopupDeregister.equals("Do you want to deregister NDID service?"));
        Assert.assertTrue(elPopupDeregisterDetail.equals("After the deregistration, you would not be able to use ttb as an IdP for authentication anymore."));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elBtnCancel.equals("Cancel"));
    }

    @Test(priority = 2)
    @Step("in case click cancel")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnCancel = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        BtnCancel.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']")));

        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        String elBtnDeregister = BtnDeregister.getText();
        Assert.assertTrue(elBtnDeregister.equals("Deregister NDID Service"));

        BtnDeregister.click();
    }

    @org.testng.annotations.Test(priority = 3)
    @Step("in case click X")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
            MobileElement BtnX = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_popup_handle_button_close']"));
        BtnX.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']")));

        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        String elBtnDeregister = BtnDeregister.getText();
        Assert.assertTrue(elBtnDeregister.equals("Deregister NDID Service"));

        BtnDeregister.click();
    }

    @org.testng.annotations.Test(priority = 4)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        BtnConfirm.click();
        Thread.sleep(3000);
           Thread.sleep(3000);
        ConfirmPin();
         }

    @org.testng.annotations.Test(priority = 5)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));

        MobileElement TitleNDIDDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleNDIDDeregister = TitleNDIDDeregister.getText();
        MobileElement NDIDDeregisterDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elNDIDDeregisterDetail = NDIDDeregisterDetail.getText().replace("\n"," ");
        MobileElement Transaction = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[3]"));
        String elTransaction = Transaction.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elTitleNDIDDeregister : " + elTitleNDIDDeregister);
        System.err.println("elNDIDDeregisterDetail : " + elNDIDDeregisterDetail);
        System.err.println("elTransaction : " + elTransaction);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleNDIDDeregister.equals("NDID Deregistration Successful"));
        Assert.assertTrue(elNDIDDeregisterDetail.equals("You can register NDID service again anytime."));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Service Page"));


              BtnBackToMainMenu.click();
      
    }

    @Test(priority = 6)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00006() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_error_ial_label_title_id']")));

        MobileElement TitleNDIDError = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_title_id']"));
        String elTitleNDIDError = TitleNDIDError.getText();
        MobileElement NDIDErrorDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_desc_id']"));
        String elNDIDErrorDetail = NDIDErrorDetail.getText();
        MobileElement ContactError = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_footer_id']"));
        String elContactError = ContactError.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_btn_back_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elTitleNDIDError : " + elTitleNDIDError);
        System.err.println("elNDIDErrorDetail : " + elNDIDErrorDetail);
        System.err.println("elContactError : " + elContactError);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

      

        Assert.assertTrue(elTitleNDIDError.equals("You cannot verify your identity via the National Digital ID Platform (NDID)"));
        Assert.assertTrue(elNDIDErrorDetail.equals("Please bring your ID card to ttb branch and take photo to complete the Know Your Customer (KYC) process and apply NDID service."));
        Assert.assertTrue(elContactError.equals("Contact ttb contact center 1428 for more information"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Menu"));

        BtnBackToMainMenu.click();
    }
}
