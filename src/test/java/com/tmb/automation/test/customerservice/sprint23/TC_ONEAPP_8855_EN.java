package com.tmb.automation.test.customerservice.sprint23;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class TC_ONEAPP_8855_EN extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 1)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_1']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        MobileElement BtnDisagree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_disagree_id']"));
        BtnDisagree.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));
        MobileElement TitleDisagreePopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elTitleDisagreePopup = TitleDisagreePopup.getText();
        MobileElement DisagreePopupContent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']"));
        String elDisagreePopupContent = DisagreePopupContent.getText();
        System.err.println("elTitleDisagreePopup : " + elTitleDisagreePopup);
        System.err.println("elDisagreePopupContent : " + elDisagreePopupContent);
        MobileElement BtnCancelPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        String elBtnCancelPopup = BtnCancelPopup.getText();
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        String elBtnConfirmPopup = BtnConfirmPopup.getText();
        System.err.println("elBtnCanclePopup : " + elBtnCancelPopup);
        System.err.println("elBtnConfirmPopup : " + elBtnConfirmPopup);

       
        Assert.assertTrue(elTitleDisagreePopup.equals("Disagree Biometric Consent?"));
        Assert.assertTrue(elDisagreePopupContent.equals("If you disagree biometric consent you will not be able to authenticate this request. Please confirm if you would like to reject."));
        Assert.assertTrue(elBtnConfirmPopup.equals("Confirm"));
        Assert.assertTrue(elBtnCancelPopup.equals("Cancel"));
        BtnCancelPopup.click();
           BtnDisagree.click();
    }

    @Test(priority = 2)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        BtnConfirmPopup.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
         }

    @Test(priority = 3)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_1']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement BioConsent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_header_id']"));
        String elBioConsent = BioConsent.getText();
        MobileElement BioConsentContent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']"));
        String elBioConsentContent = BioConsentContent.getText();
        MobileElement BtnAgree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_agree_id']"));
        String elBtnAgree = BtnAgree.getText();
        MobileElement BtnDisagree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_disagree_id']"));
        String elBtnDisagree = BtnDisagree.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elBioConsent : " + elBioConsent);
        System.err.println("elBioConsentContent : " + elBioConsentContent);
        System.err.println("elBtnAgree : " + elBtnAgree);
        System.err.println("elBtnDisagree : " + elBtnDisagree);
        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elBioConsent.equals("Biometric Consent"));
        Assert.assertTrue(elBtnAgree.equals("Agree"));
        Assert.assertTrue(elBtnDisagree.equals("Disagree"));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
           BtnAgree.click();
    }

    @Test(priority = 6)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01008() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']"));
        String elHeader = Header.getText();
        MobileElement SelfieTip = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_header_label_id']"));
        String elSelfieTip = SelfieTip.getText();
        MobileElement RemoveGlass = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_remove_glass_label_id']"));
        String elRemoveGlass = RemoveGlass.getText();
        MobileElement GoodLight = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_good_light_label_id']"));
        String elGoodLight = GoodLight.getText();
        MobileElement AlignFace = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_align_face_label_id']"));
        String elAlignFace = AlignFace.getText();
        MobileElement BtnContinue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_button_continue_id']"));
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);

        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glasses / mask / cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));
    }

    @Test(priority = 7)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack2 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));

        
        MobileElement BtnProcess = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProcess.click();
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']"));
        String elHeader = Header.getText();
        MobileElement SelfieTip = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_header_label_id']"));
        String elSelfieTip = SelfieTip.getText();
        MobileElement RemoveGlass = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_remove_glass_label_id']"));
        String elRemoveGlass = RemoveGlass.getText();
        MobileElement GoodLight = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_good_light_label_id']"));
        String elGoodLight = GoodLight.getText();
        MobileElement AlignFace = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_align_face_label_id']"));
        String elAlignFace = AlignFace.getText();
        MobileElement BtnContinue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_button_continue_id']"));
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);

            Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glasses / mask / cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));
    }
}
