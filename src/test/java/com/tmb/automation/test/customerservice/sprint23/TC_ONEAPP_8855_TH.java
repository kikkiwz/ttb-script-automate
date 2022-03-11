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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.api.customerservice.sprint21.BiometricConsent.GetBiometricConsent_ForDEMO;
import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class TC_ONEAPP_8855_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}
    @BeforeTest
    public void servoice() throws Exception {
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        String body = "{\n" +
                "  \"acceptance\": \"N\",\n" +
                "  \"version\": \"1.00\"\n" +
                "}";
        JSONObject BiometricConsent = (JSONObject) new JSONParser().parse(GetBiometricConsent_ForDEMO(body, AccessToken));
    }

    @org.testng.annotations.Test(priority = 1)
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

        Assert.assertTrue(elTitleDisagreePopup.equals("ไม่ยินยอมข้อกำหนดและเงื่อนไขการเก็บภาพถ่าย"));
        Assert.assertTrue(elDisagreePopupContent.equals("หากไม่ยินยอม คุณจะไม่สามารถสมัครบริการ NDID ได้ คุณต้องการปฏิเสธคำขอนี้หรือไม่"));
        Assert.assertTrue(elBtnConfirmPopup.equals("ยืนยัน"));
        Assert.assertTrue(elBtnCancelPopup.equals("ยกเลิก"));
        BtnCancelPopup.click();
          BtnDisagree.click();
    }

    @org.testng.annotations.Test(priority = 2)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));

             MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        BtnConfirmPopup.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
           }

    @org.testng.annotations.Test(priority = 3)
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
        Assert.assertTrue(elHeader.equals("คำขอยืนยันตัวตน tmb"));
        Assert.assertTrue(elBioConsent.equals("ข้อกำหนดและเงื่อนไขการเก็บภาพถ่าย"));
        Assert.assertTrue(elBtnAgree.equals("ยินยอม"));
        Assert.assertTrue(elBtnDisagree.equals("ไม่ยินยอม"));

            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
             BtnAgree.click();
    }

    @org.testng.annotations.Test(priority = 6)
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

        Assert.assertTrue(elHeader.equals("คำขอยืนยันตัวตน tmb"));
        Assert.assertTrue(elSelfieTip.equals("ข้อแนะนำในการถ่ายภาพยืนยันตัวตน"));
        Assert.assertTrue(elRemoveGlass.equals("ถอดแว่นตา, หน้ากากอนามัย, หมวก"));
        Assert.assertTrue(elGoodLight.equals("อยู่บริเวณที่แสงสว่างเพียงพอ"));
        Assert.assertTrue(elAlignFace.equals("ให้ใบหน้าอยู่ภายในกรอบที่กำหนด"));
        Assert.assertTrue(elBtnContinue.equals("เริ่มต้นถ่ายภาพ"));
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

      
        Assert.assertTrue(elHeader.equals("คำขอยืนยันตัวตน tmb"));
        Assert.assertTrue(elSelfieTip.equals("ข้อแนะนำในการถ่ายภาพยืนยันตัวตน"));
        Assert.assertTrue(elRemoveGlass.equals("ถอดแว่นตา, หน้ากากอนามัย, หมวก"));
        Assert.assertTrue(elGoodLight.equals("อยู่บริเวณที่แสงสว่างเพียงพอ"));
        Assert.assertTrue(elAlignFace.equals("ให้ใบหน้าอยู่ภายในกรอบที่กำหนด"));
        Assert.assertTrue(elBtnContinue.equals("เริ่มต้นถ่ายภาพ"));
    }
}
