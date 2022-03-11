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
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class Check_Error_aal_EN extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		ExtentListeners.setDriver(appiumDriverMobile);
	}

    @Test(priority = 0)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_3']"));
        PendingRequest.click();

                MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        Thread.sleep(1000);
        ConfirmPin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        MobileElement TitleSuccessful = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleSuccessful = TitleSuccessful.getText();
        MobileElement TitleDescription = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elTitleDescription = TitleDescription.getText().replace("\n"," ");
        MobileElement Transaction = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[3]"));
        String elTransaction = Transaction.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elBtnConfirm : " + elTitleSuccessful);
        System.err.println("elBtnConfirm : " + elTitleDescription);
        System.err.println("elBtnConfirm : " + elTransaction);
        System.err.println("elBtnConfirm : " + elBtnBackToMainMenu);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleSuccessful.equals("Authentication Successful"));
        Assert.assertTrue(elTitleDescription.equals("ttb already submited your authentication detail, please proceed in requested app. "));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Menu"));

    }
    @AfterClass
    public void teardown() {
    	appiumDriverMobile.quit();
    }
}
