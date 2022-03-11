package com.tmb.automation.test.customerservice.sprint21;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.CustInfoValidation;
import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.Eligibility;
import static com.tmb.automation.api.customerservice.sprint19.TermAndCondition.TermAndConditionByPost;
import static com.tmb.automation.api.customerservice.sprint21.AdvisorInfo.AdvisorInfoUI;
import static com.tmb.automation.api.customerservice.sprint21.BiometricConsent.GetBiometricConsent_ForDEMO;
import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;
import static com.tmb.automation.test.customerservice.sprint23.Demo_NDID_EN.ConvertDate;

public class Demo extends Base {
    public static WebDriver driver;
    JSONObject JsonDataCustInfoValidation = null;
    JSONObject JsonDataEligibility = null;
    JSONObject JsonDataAdvisorInfoUI = null;
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
        JSONObject CustInfoValidationData = (JSONObject)new JSONParser().parse(CustInfoValidation(AccessToken));
        JsonDataCustInfoValidation =  (JSONObject)CustInfoValidationData.get("data");
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(Eligibility(AccessToken));
        JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
        JSONObject AdvisorInfoUI = (JSONObject)new JSONParser().parse(AdvisorInfoUI(AccessToken));
        JsonDataAdvisorInfoUI =  (JSONObject)AdvisorInfoUI.get("data");
    }

    @Test(priority = 0)
    public void TS_ONEAPP_4514_EN_NCBTutorial_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
        MobileElement btnNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']"));
        btnNCB.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_title_tutorial_id']")));

        Thread.sleep(5000);

        MobileElement TutorialNCB = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_title_tutorial_id']");
        String elTutorialNCB = TutorialNCB.getText();
        MobileElement DetailTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_desc_tutorial_id']");
        String elDetailTutorial = DetailTutorial.getText();
        MobileElement BtnStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_btn_start_tutorail_id']");
        String elBtnStart = BtnStart.getText();
        System.err.println("get element : " + elTutorialNCB);
        System.err.println("get element : " + elDetailTutorial);
        System.err.println("get element : " + elBtnStart);


        

        Assert.assertTrue(elTutorialNCB.equals("Request Credit Report"));
        Assert.assertTrue(elDetailTutorial.equals("Credit Report request you can easily do it yourself on ttb app.This is a service from ttb to give you convenient,has service fee 150 baht."));
        BtnStart.click();
       }

    @Test(priority = 1)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']")));
        MobileElement HeaderDeliveryScreen = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']"));
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();

        MobileElement SelectDelivery = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[2]");
        String elSelectDelivery = SelectDelivery.getText();
        MobileElement ByEmail = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[1]");
        String elByEmail = ByEmail.getText();
        MobileElement PeriodByEmail = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[2]");
        String elPeriodByEmail = PeriodByEmail.getText();
        MobileElement ByPost = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[1]");
        String elByPost = ByPost.getText();
        MobileElement PeriodByPost = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[2]");
        String elPeriodByPost = PeriodByPost.getText();
        MobileElement Note1 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[1]/android.view.View[2]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[2]/android.view.View[2]");
        String elNote2 = Note2.getText();
        System.err.println("get element : " + elHeaderDeliveryScreen);
        System.err.println("get element : " + elSelectDelivery);
        System.err.println("get element : " + elProcessRunning);
        System.err.println("get element : " + elByEmail);
        System.err.println("get element : " + elPeriodByEmail);
        System.err.println("get element : " + elByPost);
        System.err.println("get element : " + elPeriodByPost);
        System.err.println("get Note1 : " + elNote1);
        System.err.println("get elNote2 : " + elNote2);


       

        Assert.assertTrue(elHeaderDeliveryScreen.equals("Request Credit Report"));
        Assert.assertTrue(elProcessRunning.equals("1 / 4"));
        Assert.assertTrue(elSelectDelivery.equals("Select delivery method"));
        Assert.assertTrue(elByEmail.equals("by e-mail"));
        Assert.assertTrue(elPeriodByEmail.equals("within 24 hrs"));
        Assert.assertTrue(elByPost.equals("by post"));
        Assert.assertTrue(elPeriodByPost.equals("7 working days"));
        Assert.assertTrue(elNote1.equals("Has service fee 150 baht."));
        Assert.assertTrue(elNote2.equals("Request after 10:45 p.m. will take effect on a next business day."));

        MobileElement SelectByPost = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View"));
        SelectByPost.click();
        Thread.sleep(5000);
        MobileElement Next = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_selected_send_button_next']"));
        Next.click();

    }

    @Test(priority = 2)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_EDIT_POST_PROFILE_title_label']")));
        MobileElement HeaderDeliveryScreen = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_EDIT_POST_PROFILE_title_label']"));
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();
        MobileElement LabelProcess = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]"));
        String elLabelProcess = LabelProcess.getText();
        MobileElement Information = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_information_title_id']"));
        String elInformation = Information.getText();
        MobileElement LabelName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_name_surname_id']"));
        String elLabelName = LabelName.getText();
        MobileElement Name_Surname = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_edit_post_profile_name_surname_desc']"));
        String elName_Surname = Name_Surname.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[6]"));
        String elIDNumber = IDNumber.getText();
        MobileElement IDNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_edit_post_profile_id_number_desc']"));
        String elIDNumberValue = IDNumberValue.getText().replaceAll("-","");
        MobileElement LabelMobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_edit_post_profile_mobile_number_title_id']"));
        String elLabelMobileNumber = LabelMobileNumber.getText();
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_edit_post_profile_mobile_number_desc_id']"));
        String elMobileNumber = MobileNumber.getText().replaceAll("-","");
        MobileElement LabelDeliveryMethod  = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_delivery_method_id']"));
        String elLabelDeliveryMethod = LabelDeliveryMethod.getText();
        MobileElement DeliveryMethod = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_edit_post_profile_delivery_method_desc_id']"));
        String elDeliveryMethod = DeliveryMethod.getText();
        MobileElement LabelAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_delivery_address_title_id']"));
        String elLabelAddress = LabelAddress.getText();
        MobileElement Address = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_delivery_address_desc_id']"));
        String elAddress = Address.getText();
        System.err.println("elHeaderDeliveryScreen : " + elHeaderDeliveryScreen);
        System.err.println("elProcessRunning : " + elProcessRunning);
        System.err.println("elLabelProcess : " + elLabelProcess);
        System.err.println("elInformation : " + elInformation);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elIDNumberValue : " + elIDNumberValue);
        System.err.println("elLabelMobileNumber : " + elLabelMobileNumber);
        System.err.println("elMobileNumber : " + elMobileNumber);
        System.err.println("elLabelDeliveryMethod : " + elLabelDeliveryMethod);
        System.err.println("elDeliveryMethod : " + elDeliveryMethod);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elAddress : " + elAddress);
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("national_id"));
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("delivery_address"));
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("mobile_no"));

       

        Assert.assertTrue(elHeaderDeliveryScreen.equals("Request Credit Report"));
        Assert.assertTrue(elProcessRunning.equals("2 / 4"));
        Assert.assertTrue(elLabelProcess.equals("Delivery method"));
        Assert.assertTrue(elInformation.equals("Please check the accuracy of information"));
        Assert.assertTrue(elLabelName.equals("Name-Surname"));
        Assert.assertTrue(elIDNumber.equals("ID Number"));
        Assert.assertTrue(elLabelMobileNumber.equals("Mobile Number"));
        Assert.assertTrue(elLabelDeliveryMethod.equals("Delivery Method"));
        Assert.assertTrue(elName_Surname.equals(JsonDataCustInfoValidation.get("first_name_en") + " " + JsonDataCustInfoValidation.get("last_name_en")));
        Assert.assertTrue(elIDNumberValue.equals(JsonDataCustInfoValidation.get("national_id")));
        Assert.assertTrue(elMobileNumber.equals(JsonDataCustInfoValidation.get("mobile_no")));
        Assert.assertTrue(elAddress.equals(JsonDataCustInfoValidation.get("delivery_address")));
        Assert.assertTrue(elDeliveryMethod.equals("By post"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_id_number_btn_id']")));
        MobileElement BtnNext = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_id_number_btn_id']"));
        System.err.println("get element : " + BtnNext.getText());
        BtnNext.click();
    }

    @Test(priority = 3)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_terms_and_conditions_title_label']")));
        MobileElement HeaderT_C = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_terms_and_conditions_title_label']"));
        String elHeaderT_C = HeaderT_C.getText();
        MobileElement T_C_detail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View"));
        String elT_C_detail = T_C_detail.getText();
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        MobileElement AcceptT_C = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_checkbox_terms_and_conditions']"));
        String elAcceptT_C = AcceptT_C.getText();
        System.err.println("elT_C_detail" + elHeaderT_C);
        System.err.println("elAcceptT_C" + elAcceptT_C);
        System.err.println("elT_C_detail" + elT_C_detail);
//        JSONObject T_C = (JSONObject)new JSONParser().parse(TermAndConditionByPost("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg=="));
//        JSONObject JsonData =  (JSONObject)T_C.get("data");
//        System.err.println("Print Json Data" + JsonData.get("term_n_condition_en").toString().replace("<br><br>"," "));



        Assert.assertTrue(elHeaderT_C.equals("Terms and Conditions"));
        Assert.assertTrue(elAcceptT_C.equals("I have read and agree to terms and conditions"));
        AcceptT_C.click();
          MobileElement BtnNextT_C = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_btn_next_terms_and_conditions']"));
        BtnNextT_C.click();
    }

    @Test(priority = 4)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_eligible_acouunt_display_title_label']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_eligible_acouunt_display_title_label']"));
        String elHeader = Header.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();
        MobileElement SelectAccToPay = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[2]"));
        String elSelectAccToPay = SelectAccToPay.getText();
        MobileElement LabelSelectAcc = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]"));
        String elLabelSelectAcc = LabelSelectAcc.getText();
        MobileElement AccName = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[1]"));
        String elAccName = AccName.getText();
        MobileElement AccNumber = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[2]"));
        String elAccNumber = AccNumber.getText().replaceAll("-","");
        MobileElement Balance = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[3]"));
        String elBalance = Balance.getText().replaceAll(",","");
        System.err.println("elHeader : " + elHeader);
        System.err.println("elProcessRunning : " + elProcessRunning);
        System.err.println("elSelectAccToPay : " + elSelectAccToPay);
        System.err.println("elLabelSelectAcc : " + elLabelSelectAcc);
        System.err.println("elAccName : " + elAccName);
        System.err.println("elAccNumber : " + elAccNumber);
        System.err.println("elMoney :" + elBalance);

       
        JSONArray Arr_Acc =  (JSONArray)JsonDataEligibility.get("account_list");
        JSONObject Arr_Acc_list = (JSONObject) Arr_Acc.get(0);
        System.err.println("Print Json Data " + Arr_Acc_list.get("accountNumber"));
        Assert.assertTrue(elHeader.equals("Request Credit Report"));
        Assert.assertTrue(elProcessRunning.equals("3 / 4"));
        Assert.assertTrue(elSelectAccToPay.equals("Select account to pay"));
        Assert.assertTrue(elLabelSelectAcc.equals("Select account to pay 150 baht fee"));
        if(Arr_Acc_list.get("accountNickName") != null){
            Assert.assertTrue(elAccName.equals(Arr_Acc_list.get("accountNickName")));
        }else{
            Assert.assertTrue(elAccName.equals(Arr_Acc_list.get("productNameEn")));
        }
        Assert.assertTrue(elAccNumber.substring(6, 10).equals(Arr_Acc_list.get("accountNumber").toString().substring(6, 10)));
        Assert.assertTrue(elBalance.equals(Arr_Acc_list.get("currentBalance")));
        MobileElement SlectAcc = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View"));
        SlectAcc.click();
        MobileElement BtnNext = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_selected_send_button_next']"));
        BtnNext.click();
    }

    @Test(priority = 5)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00006() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_confirmation_title_label']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_confirmation_title_label']"));
        String elHeader = Header.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();
        MobileElement Confirmation = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]"));
        String elConfirmation = Confirmation.getText();
        MobileElement Item = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_item_text_idtitle']"));
        String elItem = Item.getText();
        MobileElement ItemDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_item_text_iddesc']"));
        String elItemDetail = ItemDetail.getText();
        MobileElement LabelDelivery = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_delivery_method_by_email_idtitle']"));
        String elLabelDelivery = LabelDelivery.getText();
        MobileElement DeliveryDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_delivery_method_by_email_iddesc']"));
        String elDeliveryDetail = DeliveryDetail.getText();
        MobileElement LabelAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_address_title_idtitle']"));
        String elLabelAddress = LabelAddress.getText();
        MobileElement Address = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_address_title_iddesc']"));
        String elAddress = Address.getText();
        MobileElement LabelFrom = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_paid_from_title_idtitle']"));
        String elLabelFrom = LabelFrom.getText();
        MobileElement FromDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_paid_from_title_iddesc']"));
        String elFromDetail = FromDetail.getText().replaceAll("-","");
        MobileElement LabelFee = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_service_fee_title_idtitle']"));
        String elLabelFee = LabelFee.getText();
        MobileElement Fee_Amount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_service_fee_title_iddesc']"));
        String elFee_Amount = Fee_Amount.getText();
        MobileElement LabelName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_name_surname_idtitle']"));
        String elLabelName = LabelName.getText();
        MobileElement Name_Surname = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_name_surname_iddesc']"));
        String elName_Surname = Name_Surname.getText();
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        MobileElement LabelIDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_id_number_idtitle']"));
        String elLabelIDNumber = LabelIDNumber.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_id_number_iddesc']"));
        String elIDNumber = IDNumber.getText().replaceAll("-","");
        MobileElement LabelMobileNo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_idtitle']"));
        String elLabelMobileNo = LabelMobileNo.getText();
        MobileElement MobileNo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_iddesc']"));
        String elMobileNo = MobileNo.getText().replaceAll("-","");
        MobileElement LabelEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_email_idtitle']"));
        String elLabelEmail = LabelEmail.getText();
        MobileElement Email = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_email_iddesc']"));
        String elEmail = Email.getText();
//        MobileElement Note = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[12]/android.view.View/android.view.View/android.view.View[3]"));
//        String elNote = Note.getText();
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        System.err.println("elT_C_detail : " + elHeader);
        System.err.println("elProcessRunning : " + elProcessRunning);
        System.err.println("elConfirmation : " + elConfirmation);
        System.err.println("elItem : " + elItem);
        System.err.println("elItemDetail : " + elItemDetail);
        System.err.println("elLabelDelivery : " + elLabelDelivery);
        System.err.println("elDeliveryDetail : " + elDeliveryDetail);
        System.err.println("elLabelFrom : " + elLabelFrom);
        System.err.println("elFromDetail : " + elFromDetail);
        System.err.println("elLabelFee : " + elLabelFee);
        System.err.println("elFee_Amount : " + elFee_Amount);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elLabelIDNumber : " + elLabelIDNumber);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elLabelMobileNo : " + elLabelMobileNo);
        System.err.println("elMobileNo : " + elMobileNo);
        System.err.println("elLabelEmail : " + elLabelEmail);
        System.err.println("elEmail : " + elEmail);
//        System.err.println("elNote : " + elNote);

           
        Assert.assertTrue(elHeader.equals("Request Credit Report"));
        Assert.assertTrue(elProcessRunning.equals("4 / 4"));
        Assert.assertTrue(elConfirmation.equals("Confirmation"));
        Assert.assertTrue(elItem.equals("Item"));
        Assert.assertTrue(elItemDetail.equals("1 credit report"));
        Assert.assertTrue(elLabelDelivery.equals("Delivery Method"));
        Assert.assertTrue(elDeliveryDetail.equals("By post"));
        Assert.assertTrue(elLabelAddress.equals("Delivery Address"));
        Assert.assertTrue(elLabelFrom.equals("Service Fee Paid From"));
        Assert.assertTrue(elLabelFee.equals("Service Fee"));
        Assert.assertTrue(elFee_Amount.equals("150.00"));
        Assert.assertTrue(elLabelName.equals("Name-Surname"));
        Assert.assertTrue(elLabelIDNumber.equals("ID Number"));
        Assert.assertTrue(elLabelMobileNo.equals("Mobile Number"));
        Assert.assertTrue(elLabelEmail.equals("E-mail"));
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("national_id"));
        JSONArray Arr_Acc =  (JSONArray)JsonDataEligibility.get("account_list");
        JSONObject Arr_Acc_list = (JSONObject) Arr_Acc.get(0);

        Assert.assertTrue(elItemDetail.equals("1 credit report"));
            Assert.assertTrue(elDeliveryDetail.equals("By post"));
        Assert.assertTrue(elAddress.equals(JsonDataCustInfoValidation.get("delivery_address")));
        if(Arr_Acc_list.get("accountNickName") != null){
            Assert.assertTrue(elFromDetail.equals(Arr_Acc_list.get("accountNickName") + " " + Arr_Acc_list.get("accountNumber")));
        }else{
            Assert.assertTrue(elFromDetail.equals(Arr_Acc_list.get("productNameEn") + " " + Arr_Acc_list.get("accountNumber")));
        }
        Assert.assertTrue(elName_Surname.equals(JsonDataCustInfoValidation.get("first_name_en") + " " + JsonDataCustInfoValidation.get("last_name_en")));
        Assert.assertTrue(elIDNumber.equals(JsonDataCustInfoValidation.get("national_id")));
        Assert.assertTrue(elMobileNo.equals(JsonDataCustInfoValidation.get("mobile_no")));
        Assert.assertTrue(elEmail.equals(JsonDataCustInfoValidation.get("email")));
//        Assert.assertTrue(elNote.equals("Credit report will be sent by post within 7 working days."));
        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2070)).perform();
         ConfirmPin();
    }



    @Test(priority = 6)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00007() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='label_customerservice_request_ncb_title_success_card']")));
        MobileElement Success = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_title_success_card']"));
        String elSuccess = Success.getText();
        MobileElement SuccessDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_title_email_success']"));
        String elSuccessDetail = SuccessDetail.getText();
        MobileElement Request = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_title_request_card']"));
        String elRequest = Request.getText();
        MobileElement Item = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_item_title']"));
        String elItem = Item.getText();
        MobileElement ItemDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_1_credit_report']"));
        String elItemDetail = ItemDetail.getText();
        MobileElement LabelDelivery = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_delivery_title']"));
        String elLabelDelivery = LabelDelivery.getText();
        MobileElement DeliveryDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_delivery_method_by']"));
        String elDeliveryDetail = DeliveryDetail.getText();
        MobileElement LabelAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_address_title_idtitle']"));
        String elLabelAddress = LabelAddress.getText();
        MobileElement Address = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_address_title_iddesc']"));
        String elAddress = Address.getText();
        MobileElement LabelFee = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_service_fee_title_idtitle']"));
        String elLabelFee = LabelFee.getText();
        MobileElement Fee_Amount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_service_fee_title_iddesc']"));
        String elFee_Amount = Fee_Amount.getText();
        MobileElement PayFrom = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_paid_from_title_idtitle']"));
        String elPayFrom = PayFrom.getText();
        MobileElement AccNo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_paid_from_title_iddesc']"));
        String elAccNo = AccNo.getText().replaceAll("-","");
        MobileElement Requester = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_title_requester_card']"));
        String elRequester = Requester.getText();
        MobileElement LabelName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_requester_title']"));
        String elLabelName = LabelName.getText();
        MobileElement Name_Surname = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_requester_desc']"));
        String elName_Surname = Name_Surname.getText();
        MobileElement LabelIDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_id_number_idtitle']"));
        String elLabelIDNumber = LabelIDNumber.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_id_number_iddesc']"));
        String elIDNumber = IDNumber.getText().replaceAll("-","");
        MobileElement LabelMobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_idtitle']"));
        String elLabelMobileNumber = LabelMobileNumber.getText();
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_iddesc']"));
        String elMobileNumber = MobileNumber.getText().replaceAll("-","");
        System.err.println("elSuccess : " + elSuccess);
        System.err.println("elSuccessDetail : " + elSuccessDetail);
        System.err.println("elRequest : " + elRequest);
        System.err.println("elItem : " + elItem);
        System.err.println("elItemDetail : " + elItemDetail);
        System.err.println("elLabelDelivery : " + elLabelDelivery);
        System.err.println("elDeliveryDetail : " + elDeliveryDetail);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elAddress : " + elAddress);
        System.err.println("elLabelFee : " + elLabelFee);
        System.err.println("elFee_Amount : " + elFee_Amount);
        System.err.println("elPayFrom : " + elPayFrom);
        System.err.println("elAccNo : " + elAccNo);
        System.err.println("elRequester : " + elRequester);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elLabelIDNumber : " + elLabelIDNumber);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elLabelMobileNumber : " + elLabelMobileNumber);
        System.err.println("elMobileNumber : " + elMobileNumber);


        Assert.assertTrue(elSuccess.equals("Success"));
        Assert.assertTrue(elSuccessDetail.equals("Credit report will be sent by post within 7 working days."));
        Assert.assertTrue(elRequest.equals("Request Detail"));
        Assert.assertTrue(elItem.equals("Item"));
        Assert.assertTrue(elLabelDelivery.equals("Delivery Method"));
        Assert.assertTrue(elLabelAddress.equals("Delivery Address"));
        Assert.assertTrue(elLabelFee.equals("Service Fee"));
        Assert.assertTrue(elFee_Amount.equals("150.00"));
        Assert.assertTrue(elPayFrom.equals("Paid From"));
        Assert.assertTrue(elRequester.equals("Requester Detail"));
        Assert.assertTrue(elLabelName.equals("Requester"));
        Assert.assertTrue(elLabelIDNumber.equals("ID Number"));
        Assert.assertTrue(elLabelMobileNumber.equals("Mobile Number"));
        //non static
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("national_id"));
        JSONArray Arr_Acc =  (JSONArray)JsonDataEligibility.get("account_list");
        JSONObject Arr_Acc_list = (JSONObject) Arr_Acc.get(0);

        Assert.assertTrue(elItemDetail.equals("1 credit report"));
        Assert.assertTrue(elDeliveryDetail.equals("by post"));
        Assert.assertTrue(elAddress.equals(JsonDataCustInfoValidation.get("delivery_address")));
        Assert.assertTrue(elAccNo.substring(6, 10).equals(Arr_Acc_list.get("accountNumber").toString().substring(6, 10)));
        Assert.assertTrue(elName_Surname.equals(JsonDataCustInfoValidation.get("first_name_en") + " " + JsonDataCustInfoValidation.get("last_name_en")));
        Assert.assertTrue(elIDNumber.equals(JsonDataCustInfoValidation.get("national_id")));
        Assert.assertTrue(elMobileNumber.equals(JsonDataCustInfoValidation.get("mobile_no")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2070)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
    }


    @Test(priority = 7)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00008() throws Exception {
//        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
        MobileElement btnNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']"));
        btnNCB.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_popup_handle_message_label']")));
        MobileElement Popup_Error_PerDay = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elPopup_Error_PerDay = Popup_Error_PerDay.getText();
        MobileElement Popup_Error_Detail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_popup_handle_message_label']"));
        String elPopup_Error_Detail = Popup_Error_Detail.getText();
        System.err.println("elPopup_Error_PerDay : " + elPopup_Error_PerDay);
        System.err.println("elPopup_Error_Detail : " + elPopup_Error_Detail);

    
        Assert.assertTrue(elPopup_Error_PerDay.equals("Cannot Proceed"));
        Assert.assertTrue(elPopup_Error_Detail.equals("Credit Report can be requested via digital channel only 1 time per day."));
        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2070)).perform();
    }

    @Test(priority = 8)
    public void TS_ONEAPP_4514_EN_NCB_SIT_00009() throws Exception {
//        appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image")).click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        MobileElement BtnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        BtnCST.click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
      //   appiumDriverMobile.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Request NCB\").instance(0))");
        Thread.sleep(5000);
        MobileElement Doc_Request = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_completed_0']"));
        String elDoc_Request = Doc_Request.getText();
        MobileElement RefNo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='subjectRefno_completed_0']"));
        String elRefNo = RefNo.getText();
        MobileElement DocType = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='subjectContent_completed_0']"));
        String elDocType = DocType.getText();
        MobileElement RequestNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='content_completed_0']"));
        String elRequestNCB = RequestNCB.getText();
        MobileElement Status_case = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='statusText_completed_0']"));
        String elStatus_case = Status_case.getText();
        System.err.println("elDoc_Request : " + elDoc_Request);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elDocType : " + elDocType);
        System.err.println("elRequestNCB : " + elRequestNCB);
        System.err.println("elStatus : " + elStatus_case);
        Assert.assertTrue(elRequestNCB.equals("Request NCB"));

        Doc_Request.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));
       
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']"));
        String elHeader = Header.getText();
        MobileElement Ref_No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_title_ref_no_label']"));
        String elRef_No = Ref_No.getText();
        MobileElement Doc_type = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issue_type_label']"));
        String elDoc_type = Doc_type.getText();
        MobileElement Cr_NCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issue_value_label']"));
        String elCr_NCB = Cr_NCB.getText();
        MobileElement Detail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View"));
        String elDetail = Detail.getText();
        MobileElement Note = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View/android.view.View"));
        String elNote = Note.getText();
        MobileElement Contact1 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]"));
        String elContact1 = Contact1.getText();
        MobileElement Contact2 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[3]"));
        String elContact2 = Contact2.getText();
        MobileElement Contact3 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[4]"));
        String elContact3 = Contact3.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elRef_No : " + elRef_No);
        System.err.println("elDoc_type : " + elDoc_type);
        System.err.println("elCr_NCB : " + elCr_NCB);
        System.err.println("elNote : " + elNote);
        System.err.println("elContact1 : " + elContact1);
        System.err.println("elContact2 : " + elContact2);
        System.err.println("elContact3 : " + elContact3);
        System.err.println("elDetail : " + elDetail);
        System.err.println("elDetail : " + elDetail.length());
        System.err.println("elDetail : " + elDetail.substring(elDetail.length()-9, elDetail.length()));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        Assert.assertTrue(elRequestNCB.equals("Request NCB"));
        Assert.assertTrue(elDetail.substring(elDetail.length()-9, elDetail.length()).equals(ConvertDate(dtf.format(now) + "T00:00", false, "EN")));
        System.out.println(ConvertDate(dtf.format(now) + "T00:00", false, "EN"));
    }

    @Test(priority = 9)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00001() throws Exception {
        appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image")).click();
        appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image")).click();

        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title']")));
        MobileElement LabelWealAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='my_advisor_card_text_title']"));
        String elLabelWealAdvisor = LabelWealAdvisor.getText();
        MobileElement NameAdvisor = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='my_advisor_card_text_title_expertise']");
        String elNameAdvisor = NameAdvisor.getText();
        System.err.println("get element : " + elLabelWealAdvisor);
        System.err.println("get element : " + elNameAdvisor);

           Assert.assertTrue(elLabelWealAdvisor.equals("Personal Wealth Advisor"));
        Assert.assertTrue(elNameAdvisor.equals("Ms.Akara Watcharapol"));
        LabelWealAdvisor.click();
    }

    @Test(priority = 10)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00002() throws Exception {
        JSONArray Arr_Acc =  (JSONArray)JsonDataAdvisorInfoUI.get("license");
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_navbar_title_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement NameAdvisor = appiumDriverMobile.findElementByXPath("//*[@resource-id='personal_wealth_advisor_full_name_id']");
        String elNameAdvisor = NameAdvisor.getText();
        MobileElement Expertise = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_expertise_title_label_id']"));
        String elExpertise = Expertise.getText();
        MobileElement ExpertiseDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_expertise_value_label_id']"));
        String elExpertiseDetail = ExpertiseDetail.getText();
        MobileElement License1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id0']"));
        String elLicense1 = License1.getText();
//        MobileElement License1No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id0']"));
//        String elLicense1No = License1No.getText();
        MobileElement License2 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id1']"));
        String elLicense2 = License2.getText();
        MobileElement License2No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id1']"));
        String elLicense2No = License2No.getText();
        MobileElement ShowMore = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']"));
        String elShowMore = ShowMore.getText();
        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        String elSendEmail = SendEmail.getText();
        String elCallAdvisor = "";
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        elCallAdvisor = CallAdvisor.getText();
        MobileElement Note1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_footer_label_line_1_id']"));
        String elNote1 = Note1.getText();
        MobileElement Note2 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_footer_label_line_2_id']"));
        String elNote2 = Note2.getText();
        System.err.println("get elHeader : " + elHeader);
        System.err.println("get elNameAdvisor : " + elNameAdvisor);
        System.err.println("get elExpertise : " + elExpertise);
        System.err.println("get elExpertiseDetail : " + elExpertiseDetail);
        System.err.println("get elLicense1 : " + elLicense1);
        System.err.println("get elLicense2 : " + elLicense2);
        System.err.println("get elLicense2No : " + elLicense2No);
        System.err.println("get elShowMore : " + elShowMore);
        System.err.println("get elSendEmail : " + elSendEmail);
        System.err.println("get elCallAdvisor : " + elCallAdvisor);
        System.err.println("get elNote1 : " + elNote1);
        System.err.println("get elNote2 : " + elNote2);
    ShowMore.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id3']")));
        MobileElement License3 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id2']"));
        String elLicense3 = License3.getText();
        MobileElement License3No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id2']"));
        String elLicense3No = License3No.getText();
        MobileElement License4 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id3']"));
        String elLicense4 = License4.getText();
        MobileElement License4No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id3']"));
        String elLicense4No = License4No.getText();
        MobileElement PersonalAdviser = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_desc_title_label_id']"));
        String elPersonalAdviser = PersonalAdviser.getText();
        MobileElement AdvisorDetail1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id0']"));
        String elAdvisorDetail1 = AdvisorDetail1.getText();
        MobileElement AdvisorDetail2 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id1']"));
        String elAdvisorDetail2 = AdvisorDetail2.getText();
        MobileElement AdvisorDetail3 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id2']"));
        String elAdvisorDetail3 = AdvisorDetail3.getText();
        MobileElement ShowLess = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']"));
        String elShowLess = ShowLess.getText();
       
        Assert.assertTrue(elHeader.equals("Personal Wealth Advisor"));
        Assert.assertTrue(elExpertise.equals("Expertise"));
        Assert.assertTrue(elExpertiseDetail.equals("investment, financial planning"));
        Assert.assertTrue(elShowMore.equals("Show More"));
        Assert.assertTrue(elSendEmail.equals("Send e-mail"));
        Assert.assertTrue(elPersonalAdviser.equals("Personal Wealth Advisor"));
        Assert.assertTrue(elAdvisorDetail1.equals("Advise you with regards to portfolio management, tax planning and wealth transfer."));
        Assert.assertTrue(elAdvisorDetail2.equals("Help you monitor market movement and your portfolio so that you won’t miss important opportunity."));
        Assert.assertTrue(elAdvisorDetail3.equals("Recommend products and services that match your objectives, needs, timeframe and your risk appetite."));
        Assert.assertTrue(elNote1.equals("Business Hour : Mon-Fri / 08:00-18:00"));
        Assert.assertTrue(elNote2.equals("except public holiday"));
        Assert.assertTrue(elNameAdvisor.equals(JsonDataAdvisorInfoUI.get("full_name_en")));

        String time = java.time.LocalTime.now().toString().substring(0,2);
        int timeInt = Integer.parseInt(time);
        if(timeInt > 7 && timeInt < 18) {
            Assert.assertTrue(elCallAdvisor.equals("Call Advisor"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("Leave Note"));
        }
        for (int i = 0; i < Arr_Acc.size(); i++) {
            JSONObject License = (JSONObject) Arr_Acc.get(i);
            if (i == 0) {
                Assert.assertTrue(elLicense1.equals(License.get("license_value_en")));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_number"));
            } else if (i == 1) {
                Assert.assertTrue(elLicense2.equals(License.get("license_value_en")));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
                Assert.assertTrue(elLicense2No.equals("License no. " + License.get("license_number")));
                System.err.println("License no. " + License.get("license_number"));
                System.err.println("License no. " + License.get("license_value_en"));

            } else if (i == 2) {
                Assert.assertTrue(elLicense3.equals(License.get("license_value_en")));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
                Assert.assertTrue(elLicense3No.equals("License no. " + License.get("license_number")));
                System.err.println("License no. " + License.get("license_number"));
                System.err.println("License no. " + License.get("license_value_en"));
            } else {
                Assert.assertTrue(elLicense4.equals(License.get("license_value_en")));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
                Assert.assertTrue(elLicense4No.equals("License no. " + License.get("license_number")));
                System.err.println("License no. " + License.get("license_number"));
                System.err.println("License no. " + License.get("license_value_en"));
            }
        }
    }

    @Test(priority = 11)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        Boolean Wealth = (Boolean) JsonDataAdvisorInfoUI.get("within_working_hours");
        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        CallAdvisor.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']")));

        Date date = new Date();
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);
        System.err.println("day of week " + dayWeekText + "    "+ Wealth);
        if(Wealth != true){
            System.err.println("day of week ตตตตตตต" + dayWeekText);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']")));
//            MobileElement Placeholder = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[18]/android.view.View/android.view.View/android.view.View/android.view.View"));
//            String elPlaceholder = Placeholder.getText();
            MobileElement TextArea = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']"));
            TextArea.click();
            MobileElement BtnSendNote = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_btn_next_id']"));
            String elBtnSendNote = BtnSendNote.getText();
            System.err.println("elBtnSendNote" + elBtnSendNote);
     TextArea.sendKeys("T");
             TextArea.sendKeys("Test");
         
            MobileElement BtnX = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_btn_close_id']"));
            BtnX.click();
        }else {
            Activity activity = new Activity("com.samsung.android.dialer", "com.samsung.android.dialer.DialtactsActivity");
            activity.setStopApp(false);
            ((AndroidDriver<MobileElement>) appiumDriverMobile).startActivity(activity);
            MobileElement Mobilenumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.samsung.android.dialer:id/digits']"));
            String elMobilenumber = Mobilenumber.getText();
            System.err.println("License no. uuuuu" + elMobilenumber);
            Thread.sleep(3000);

            Assert.assertTrue(elMobilenumber.equals(JsonDataAdvisorInfoUI.get("advisor_mobile_number")));
            appiumDriverMobile.navigate().back();
            appiumDriverMobile.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']")));
        }

        Thread.sleep(9000);
        SendEmail.click();
       // String activityGmail = appiumDriverMobile.currentActivity();
       // System.err.println("get activityGmail : " + activityGmail);
//        Activity gmail = new Activity("com.google.android.gm", "com.google.android.gm.ComposeActivityGmailExternal");
//        gmail.setStopApp(false);
//        ((AndroidDriver<MobileElement>) appiumDriverMobile).startActivity(gmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.google.android.gm:id/spinner_account_address']")));
        MobileElement EmailFrom = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/spinner_account_address']"));
        String elEmailFrom = EmailFrom.getText();
        System.err.println("get elEmailFrom : " + elEmailFrom);
        MobileElement EmailTo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/peoplekit_chip']"));
        String elEmailTo = EmailTo.getText();
        System.err.println("get elEmail : " + elEmailTo);
        MobileElement EmailCC = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup[@resource-id='com.google.android.gm:id/peoplekit_autocomplete_chip_group']/android.widget.RelativeLayout/android.widget.Button[@resource-id='com.google.android.gm:id/peoplekit_chip']"));
        String elEmailCC = EmailCC.getText();
        MobileElement Subject = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/subject']"));
        String elSubject = Subject.getText();
        MobileElement TextAreaEmail = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.EditText"));

        System.err.println("get EmailCC : " + elEmailCC);


         Thread.sleep(2000);
        TextAreaEmail.sendKeys("Test");
       
        MobileElement Send = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/send']"));
        Send.click();
        Assert.assertTrue(elEmailFrom.equals("projectmib2904@gmail.com"));
        Assert.assertTrue(elEmailTo.equals(JsonDataAdvisorInfoUI.get("advisor_email")));
        Assert.assertTrue(elEmailCC.equals(JsonDataAdvisorInfoUI.get("supervisor_email")));
        Assert.assertTrue(elSubject.equals("Investment Consultant (Ref.no. )"));
    }

//    @Test(priority = 11)
//    public void TS_ONEAPP_4514_EN_NCB_SIT_00009() throws Exception {
//        appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image")).click();
////        OpenService();
//        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title']")));
//        MobileElement BtnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
//        BtnCST.click();
//        if(true){
//            parentReport = extent.createTest("Validate Case Tracking after create NCB Payment and PWA", "Validate after NCB Payment, then system will create case status tracking for NCB Request");
//        }
//        childReport = parentReport.createNode("Expected Result : Then system will create case status tracking for NCB Request");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
////        appiumDriverMobile.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Request NCB\").instance(0))");
//        childReport.log(Status.INFO, "<pre>The system should display Card as create request NCB transaction</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        MobileElement Doc_Request = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='title_inprogress_0']"));
//        String elDoc_Request = Doc_Request.getText();
//        MobileElement RefNo = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='subjectRefno_inprogress_0']"));
//        String elRefNo = RefNo.getText();
//        MobileElement DocType = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='subjectContent_inprogress_0']"));
//        String elDocType = DocType.getText();
//        MobileElement RequestNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='content_inprogress_0']"));
//        String elRequestNCB = RequestNCB.getText();
//        MobileElement Status_case = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='content_inprogress_0']"));
//        String elStatus_case = Status_case.getText();
//        System.err.println("elDoc_Request : " + elDoc_Request);
//        System.err.println("elRefNo : " + elRefNo);
//        System.err.println("elDocType : " + elDocType);
//        System.err.println("elRequestNCB : " + elRequestNCB);
//        System.err.println("elStatus : " + elStatus_case);
//        Assert.assertTrue(elRequestNCB.equals("Send email to PWA"));
//
//        Doc_Request.click();
//        childReport.log(Status.INFO, "<pre>After on the card then system will display request NCB detail</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']")));
//        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-detail']"));
//        String elHeader = Header.getText();
//        MobileElement Ref_No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_title_ref_no_label']"));
//        String elRef_No = Ref_No.getText();
//        MobileElement Issue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issue_type_label']"));
//        String elIssue = Issue.getText();
//        MobileElement IssueDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issue_value_label']"));
//        String elIssueDetail = IssueDetail.getText();
//        MobileElement ProductService = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_product_or_service_type_label']"));
//        String elProductService = ProductService.getText();
//        MobileElement ProductServiceDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_product_or_service_value_label']"));
//        String elProductServiceDetail = ProductServiceDetail.getText();
//        MobileElement IssueDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issued_date_label']"));
//        String elIssueDate = IssueDate.getText();
//        MobileElement IssueDateValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_issued_date_value']"));
//        String elIssueDateValue = IssueDateValue.getText();
//        MobileElement ExpectDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_expected_date_label']"));
//        String elExpectDate = ExpectDate.getText();
//        MobileElement ExpectDateValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='case_status_tracking_detail_expected_date_value']"));
//        String elExpectDateValue = ExpectDateValue.getText();
//        MobileElement HelpCenter = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='cs_case-status-tracking-detail-button-helper']"));
//        String elHelpCenter = HelpCenter.getText();
//        System.err.println("elHeader : " + elHeader);
//        System.err.println("elRef_No : " + elRef_No);
//        System.err.println("elIssue : " + elIssue);
//        System.err.println("elIssueDetail : " + elIssueDetail);
//        System.err.println("elProductService : " + elProductService);
//        System.err.println("elProductServiceDetail : " + elProductServiceDetail);
//        System.err.println("elIssueDate : " + elIssueDate);
//        System.err.println("elIssueDateValue : " + elIssueDateValue);
//        System.err.println("elExpectDate : " + elExpectDate);
//        System.err.println("elExpectDateValue : " + elExpectDateValue);
//        System.err.println("elHelpCenter : " + elHelpCenter);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
//        System.out.println(ConvertDate(dtf.format(now) + "T00:00", false, "EN"));
//        Assert.assertTrue(elIssueDetail.equals("Send email to PWA"));
//        Assert.assertTrue(elIssueDateValue.equals(ConvertDate(dtf.format(now) + "T00:00", false, "EN")));
////        TS_ONEAPP_4514_EN_NCB_SIT_00010();
//    }

}
