package com.tmb.automation.test.customerservice.sprint22;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.tmb.automation.api.customerservice.sprint21.AdvisorInfo.AdvisorInfoUI;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class DemoSP22THNolicense extends Base {
    static public AndroidDriver<MobileElement> driver, tempDrv;
    @Parameters({"DeviceProfile" })
   	@BeforeClass
   	public void BeforeTest(String deviceProfile) {
   		Helper.CONFIG_PROFILE = deviceProfile;		
   		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
   		ExtentListeners.setDriver(appiumDriverMobile);
   	}

    @Test(priority = 0)
    public void TS_ONEAPP_8266_TH_PWA_BUSI_HRS_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title']")));
        MobileElement LabelWealAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='my_advisor_card_text_title']"));
        String elLabelWealAdvisor = LabelWealAdvisor.getText();
        MobileElement NameAdvisor = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='my_advisor_card_text_title_expertise']");
        String elNameAdvisor = NameAdvisor.getText();
        System.err.println("get element : " + elLabelWealAdvisor);
        System.err.println("get element : " + elNameAdvisor);

       
        Assert.assertTrue(elLabelWealAdvisor.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(elNameAdvisor.equals("อักขระ วัชรพล"));
        LabelWealAdvisor.click();
    }

    @Test(priority = 1)
    public void TS_ONEAPP_8266_TH_PWA_BUSI_HRS_SIT_00002() throws Exception {
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(AdvisorInfoUI("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg=="));
        JSONObject JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
        JSONArray Arr_Acc =  (JSONArray)JsonDataEligibility.get("license");
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
        System.err.println("get elShowMore : " + elShowMore);
        System.err.println("get elSendEmail : " + elSendEmail);
        System.err.println("get elCallAdvisor : " + elCallAdvisor);
        System.err.println("get elNote1 : " + elNote1);
        System.err.println("get elNote2 : " + elNote2);

             ShowMore.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id1']")));
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
       

        Assert.assertTrue(elHeader.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(elExpertise.equals("ความเชี่ยวชาญ"));
        Assert.assertTrue(elExpertiseDetail.equals("การลงทุน, การวางแผนการเงิน"));
        Assert.assertTrue(elShowMore.equals("แสดงเพิ่มขึ้น"));
        Assert.assertTrue(elSendEmail.equals("ส่งอีเมล"));
        Assert.assertTrue(elPersonalAdviser.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(elAdvisorDetail1.equals("ให้คำปรึกษาด้านการบริหารจัดการพอร์ตการลงทุน รวมถึงการเงินของคุณ เช่น ด้านภาษี การจัดการมรดก"));
        Assert.assertTrue(elAdvisorDetail2.equals("ติดตามความเคลื่อนไหวของตลาดและพอร์ตการลงทุนของคุณอย่างใกล้ชิด เพื่อไม่ให้คุณพลาดโอกาสสำคัญ"));
        Assert.assertTrue(elAdvisorDetail3.equals("แนะนำผลิตภัณฑ์และบริการที่เหมาะสมกับวัตถุประสงค์ ความต้องการ ระยะเวลาการลงทุน และความเสี่ยงที่คุณยอมรับได้"));
        Assert.assertTrue(elNote1.equals("เวลาทำการ : จันทร์-ศุกร์ / 08:00-18:00 น."));
        Assert.assertTrue(elNote2.equals("เว้นวันนักขัตฤกษ์"));
        Assert.assertTrue(JsonDataEligibility.get("full_name_th").equals(" "+ elNameAdvisor));

        String time = java.time.LocalTime.now().toString().substring(0,2);
        int timeInt = Integer.parseInt(time);
        if(timeInt > 7 && timeInt < 18) {
            Assert.assertTrue(elCallAdvisor.equals("โทรติดต่อ"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("ให้ติดต่อกลับ"));
        }
    }

    @Test(priority = 3)
    public void TS_ONEAPP_8266_TH_PWA_BUSI_HRS_SIT_00004() throws Exception {
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(AdvisorInfoUI("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg=="));
        JSONObject JsonDataEligibility =  (JSONObject)EligibilityACC.get("data");
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 30);
        Boolean Wealth = (Boolean) JsonDataEligibility.get("within_working_hours");
        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        CallAdvisor.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']")));

        Date date=new Date();
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

//        String EmailTo = elEmail[0];
//        String EmailCC = elEmail[1];
//        System.err.println("get EmailTo : " + EmailTo);
        System.err.println("get EmailCC : " + elEmailCC);

      Thread.sleep(2000);
        TextAreaEmail.sendKeys("Test");

//        MobileElement Send = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/send']"));
//        Send.click();
        Assert.assertTrue(elEmailFrom.equals("projectmib2904@gmail.com"));
        Assert.assertTrue(elEmailTo.equals(JsonDataEligibility.get("advisor_email")));
        Assert.assertTrue(elEmailCC.equals(JsonDataEligibility.get("supervisor_email")));
        Assert.assertTrue(elSubject.equals("ปรึกษาการลงทุน (Ref.no. )"));
    }
}