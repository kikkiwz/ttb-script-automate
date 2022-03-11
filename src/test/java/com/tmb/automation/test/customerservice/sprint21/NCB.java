package com.tmb.automation.test.customerservice.sprint21;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.CustInfoValidation;
import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.Eligibility;
import static com.tmb.automation.api.customerservice.sprint19.TermAndCondition.TermAndConditionByPost;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class NCB extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 0)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00001() throws Exception {
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
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']")));
        MobileElement HeaderDeliveryScreen = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']"));
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();

        MobileElement SelectDelivery = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[2]");
        String elSelectDelivery = SelectDelivery.getText();
        MobileElement ByEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[1]");
        String elByEmail = ByEmail.getText();
        MobileElement PeriodByEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[2]");
        String elPeriodByEmail = PeriodByEmail.getText();
        MobileElement ByPost = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[1]");
        String elByPost = ByPost.getText();
        MobileElement PeriodByPost = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[2]");
        String elPeriodByPost = PeriodByPost.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[1]/android.view.View[2]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[2]/android.view.View[2]");
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
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00003() throws Exception {
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
        MobileElement Name_Surname = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]"));
        String elName_Surname = Name_Surname.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]"));
        String elIDNumber = IDNumber.getText().replaceAll("-","");
        MobileElement LabelMobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='idTitle']"));
        String elLabelMobileNumber = LabelMobileNumber.getText();
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[9]"));
        String elMobileNumber = MobileNumber.getText().replaceAll("-","");
        MobileElement LabelDeliveryMethod  = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_delivery_method_id']"));
        String elLabelDeliveryMethod = LabelDeliveryMethod.getText();
        MobileElement DeliveryMethod = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[12]"));
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
        System.err.println("elLabelMobileNumber : " + elLabelMobileNumber);
        System.err.println("elMobileNumber : " + elMobileNumber);
        System.err.println("elLabelDeliveryMethod : " + elLabelDeliveryMethod);
        System.err.println("elDeliveryMethod : " + elDeliveryMethod);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elAddress : " + elAddress);
//        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        MobileElement LabelIDNumber = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[6]"));
        String elLabelIDNumber = LabelIDNumber.getText();
        System.err.println("elLabelIDNumber : " + elLabelIDNumber);
//        MobileElement Note = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[6]"));
//        String elNote = Note.getText();  for By E-mail
//        System.err.println("elNote : " + elNote);

        JSONObject CustInfoValidationData = (JSONObject)new JSONParser().parse(CustInfoValidation("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonData =  (JSONObject)CustInfoValidationData.get("data");
        System.err.println("Print Json Data" + JsonData.get("national_id"));
        System.err.println("Print Json Data" + JsonData.get("delivery_address"));
        System.err.println("Print Json Data" + JsonData.get("mobile_no"));



       
        Assert.assertTrue(elHeaderDeliveryScreen.equals("Request Credit Report"));
        Assert.assertTrue(elProcessRunning.equals("2 / 4"));
        Assert.assertTrue(elLabelProcess.equals("Delivery method"));
        Assert.assertTrue(elInformation.equals("Please check the accuracy of information"));
        Assert.assertTrue(elLabelName.equals("Name-Surname"));
        Assert.assertTrue(elLabelIDNumber.equals("ID Number"));
        Assert.assertTrue(elLabelMobileNumber.equals("Mobile Number"));
        Assert.assertTrue(elLabelDeliveryMethod.equals("Delivery Method"));
        Assert.assertTrue(elName_Surname.equals(JsonData.get("first_name_en") + " " + JsonData.get("last_name_en")));
        Assert.assertTrue(elIDNumber.equals(JsonData.get("national_id")));
        Assert.assertTrue(elMobileNumber.equals(JsonData.get("mobile_no")));
        Assert.assertTrue(elAddress.equals(JsonData.get("delivery_address")));
        Assert.assertTrue(elDeliveryMethod.equals("By post"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_id_number_btn_id']")));
        MobileElement BtnNext = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_id_number_btn_id']"));
        System.err.println("get element : " + BtnNext.getText());
//        Thread.sleep(5000);
        BtnNext.click();
    }

    @Test(priority = 3)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00004() throws Exception {
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
        JSONObject T_C = (JSONObject)new JSONParser().parse(TermAndConditionByPost("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonData =  (JSONObject)T_C.get("data");
        System.err.println("Print Json Data" + JsonData.get("term_n_condition_en").toString().replace("<br><br>"," "));


       
        Assert.assertTrue(elHeaderT_C.equals("Terms and Conditions"));
        Assert.assertTrue(elAcceptT_C.equals("I have read and agree to terms and conditions"));
        AcceptT_C.click();
         MobileElement BtnNextT_C = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_btn_next_terms_and_conditions']"));
        BtnNextT_C.click();
    }

    @Test(priority = 4)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00005() throws Exception {
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



        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(Eligibility("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
        JSONArray Arr_Acc =  (JSONArray)JsonDataEligibility.get("account_list");
        JSONObject Arr_Acc_list = (JSONObject) Arr_Acc.get(0);
        System.err.println("EligibilityACC " + EligibilityACC);
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
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00006() throws Exception {
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
//        Assert.assertTrue(elLabelMobileNumber.equals("Mobile Number"));
        //non static
        JSONObject CustInfoValidationData = (JSONObject)new JSONParser().parse(CustInfoValidation("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonDataCustInfoValidation =  (JSONObject)CustInfoValidationData.get("data");
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("national_id"));
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(Eligibility("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
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
//        Assert.assertTrue(elAccNo.substring(6, 10).equals(Arr_Acc_list.get("accountNumber").toString().substring(6, 10)));
//        Assert.assertTrue(elName_Surname.equals(JsonDataCustInfoValidation.get("first_name_en") + " " + JsonDataCustInfoValidation.get("last_name_en")));
//        Assert.assertTrue(elIDNumber.equals(JsonDataCustInfoValidation.get("national_id")));
//        Assert.assertTrue(elMobileNumber.equals(JsonDataCustInfoValidation.get("mobile_no")));
//        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_id_number_iddesc']"));
//        String elIDNumber = IDNumber.getText().replaceAll("-","");
//        MobileElement LabelMobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_idtitle']"));
//        String elLabelMobileNumber = LabelMobileNumber.getText();
//        System.err.println("elIDNumber :" + elIDNumber);
//        System.err.println("elLabelMobileNumber :" + elLabelMobileNumber);
//        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_iddecs']"));
//        String elMobileNumber = MobileNumber.getText();
//        MobileElement LabelEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_email_idtitle']"));
//        String elLabelEmail = LabelEmail.getText();
//        MobileElement Email = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_email_iddesc']"));
//        String elEmail = Email.getText();
//        System.err.println("elMobileNumber :" + elMobileNumber);
//        System.err.println("elNote :" + elLabelEmail);
//        System.err.println("elNote :" + elEmail);
//        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2070)).perform();
          ConfirmPin();
    }



    @Test(priority = 6)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00007() throws Exception {
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
        JSONObject CustInfoValidationData = (JSONObject)new JSONParser().parse(CustInfoValidation("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonDataCustInfoValidation =  (JSONObject)CustInfoValidationData.get("data");
        System.err.println("Print Json Data" + JsonDataCustInfoValidation.get("national_id"));
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(Eligibility("D4X0AeqgFz8rAOexWr0yBeYfYfSqPNdLJvccbjluXWmEOBAlDminWDP42WXwbNMMkPTQldz6GjEEWrpOZUj+3amPp5WYVFsD6ThlnDfaibfWlxhQfxy9dz8BEMeS07nW5YRbiFYsT16VQQdbCki5C2Rbsxiewt4d+k0pxlG7Iy7ycCU/+g6hcmO2jMtU9CXTnce4Sf3z8H0Ml3kisuQfgevXIy/xnwH9h+HiQHnhOcCTVjr0U3CKFdQVUFlZqf66HF7nio73icf4/kHQy8up3E/mOd/xNauQk/Zbwce5cQL4AWg2KdM0eOOb/RWcaeXIzM98FVxrMvukYetJCoXjKw=="));
        JSONObject JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
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
//        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='label_customerservice_request_ncb_mobile_number_iddecs']"));
//        String elMobileNumber = MobileNumber.getText();
//        MobileElement Note = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[14]/android.view.View/android.view.View/android.view.View[3]']"));
//        String elNote = Note.getText();
//        System.err.println("elMobileNumber :" + elMobileNumber);
//        System.err.println("elNote :" + elNote);
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2070)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
    }


    @Test(priority = 7)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00008() throws Exception {
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
}
