package com.tmb.automation.test.customerservice.sprint22;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.CustInfoValidation;
import static com.tmb.automation.api.customerservice.sprint19.CustomerInfoValidetion.Eligibility;
import static com.tmb.automation.api.customerservice.sprint21.AdvisorInfo.AdvisorInfoUI;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class LeaveNote_EN extends Base {
    public static WebDriver driver;
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
        JSONObject AdvisorInfoUI = (JSONObject)new JSONParser().parse(AdvisorInfoUI(AccessToken));
        JsonDataAdvisorInfoUI =  (JSONObject)AdvisorInfoUI.get("data");
    }

    @Test(priority = 0)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00001() throws Exception {
        OpenService();
        System.err.println(JsonDataAdvisorInfoUI);
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

    @Test(priority = 1)
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
        System.err.println("asdasda "+ JsonDataAdvisorInfoUI.get("full_name_en"));
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

    @Test(priority = 3)
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

        System.err.println("day of week ตตตตตตต" + dayWeekText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']")));
        MobileElement TextArea = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']"));
        TextArea.click();
        MobileElement BtnSendNote = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_btn_next_id']"));
        String elBtnSendNote = BtnSendNote.getText();
        MobileElement PlaceHolder = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_btn_next_id']"));
        String elPlaceHolder = PlaceHolder.getText();
        System.err.println("elPlaceHolder : " + elPlaceHolder);
        System.err.println("elBtnSendNote" + elBtnSendNote);

              Thread.sleep(1000);
        TextArea.sendKeys("T");
        TextArea.sendKeys("Test create case tracking");
         BtnSendNote.click();
    }
}
