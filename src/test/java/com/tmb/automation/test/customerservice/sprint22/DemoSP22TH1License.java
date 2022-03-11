package com.tmb.automation.test.customerservice.sprint22;


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

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;

import static com.tmb.automation.api.customerservice.sprint21.AdvisorInfo.AdvisorInfoUI;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class DemoSP22TH1License extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}


    @Test(priority = 0)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title_expertise']")));
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
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00002() throws Exception {
        JSONObject EligibilityACC = (JSONObject)new JSONParser().parse(AdvisorInfoUI("SE122WLK6k7WpkFjUTgUdQ4D0fG4lZxBU4PG92K0HsvBd+JqkA/CRXZBMDoKLTZx/vo3IMzATCsrHD2nPbG+aUfoCUceik3D4Nqkv69l9q3BvX0DHp+62yNRL0jqJzCAoNeFTsY4jWeGkhEG5IJ4FNcVoP7HEX97s5MWPh+pvtHIVBn4mfLrZ1+EVFfkhbXUXMBzjRJNm8htQS+Yv8ZDp4WcKu47OxwYH8vuPxZHgQqsnnjThhDvbBD0chTqnLwcL5oms4h/822JnjSoG4c0xPbokOp0myyXu6Oq/JxLhgM0kxVXSNOoSH5igyJ4ZIaQkow90GRyLN8v1z+tt4rILg=="));
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
        MobileElement License1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_label_id0']"));
        String elLicense1 = License1.getText();
        MobileElement License1No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id0']"));
        String elLicense1No = License1No.getText();
        MobileElement ShowMore = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']"));
        String elShowMore = ShowMore.getText();
        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        String elSendEmail = SendEmail.getText();
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        String elCallAdvisor = CallAdvisor.getText();
        MobileElement Note1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_footer_label_line_1_id']"));
        String elNote1 = Note1.getText();
        MobileElement Note2 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_footer_label_line_2_id']"));
        String elNote2 = Note2.getText();
        System.err.println("get elHeader : " + elHeader);
        System.err.println("get elNameAdvisor : " + elNameAdvisor);
        System.err.println("get elExpertise : " + elExpertise);
        System.err.println("get elExpertiseDetail : " + elExpertiseDetail);
        System.err.println("get elLicense1 : " + elLicense1);
        System.err.println("get elLicense1No : " + elLicense1No);
        System.err.println("get elShowMore : " + elShowMore);
        System.err.println("get elSendEmail : " + elSendEmail);
        System.err.println("get elCallAdvisor : " + elCallAdvisor);
        System.err.println("get elNote1 : " + elNote1);
        System.err.println("get elNote2 : " + elNote2);

        Assert.assertTrue(elHeader.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(elExpertise.equals("ความเชี่ยวชาญ"));
        Assert.assertTrue(elExpertiseDetail.equals("การลงทุน, การวางแผนการเงิน"));
        Assert.assertTrue(elShowMore.equals("แสดงเพิ่มขึ้น"));
        Assert.assertTrue(elSendEmail.equals("ส่งอีเมล"));

        String time = java.time.LocalTime.now().toString().substring(0,2);
        int timeInt = Integer.parseInt(time);
        if(timeInt > 7 && timeInt < 18) {
            Assert.assertTrue(elCallAdvisor.equals("โทรติดต่อ"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("ให้ติดต่อกลับ"));
        }
        Assert.assertTrue(elNote1.equals("เวลาทำการ : จันทร์-ศุกร์ / 08:00-18:00 น."));
        Assert.assertTrue(elNote2.equals("เว้นวันนักขัตฤกษ์"));


        Assert.assertTrue(JsonDataEligibility.get("full_name_th").equals(" "+ elNameAdvisor));
        for(int i = 0; i < Arr_Acc.size(); i++){
            JSONObject License =  (JSONObject)Arr_Acc.get(i);
            if(i == 0){
                Assert.assertTrue(elLicense1.equals(License.get("license_value_th")));
                System.err.println("License no. " + License.get("license_value_th"));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
                Assert.assertTrue(elLicense1No.equals(License.get("license_number")));
            }
        }

    }

    @Test(priority = 2)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement ShowMore = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']"));
        String elShowMore = ShowMore.getText();
        ShowMore.click();
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
        MobileElement License1No = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_item_certificate_desc_id0']"));
        String elLicense1No = License1No.getText();
        MobileElement PersonalAdviser = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_desc_title_label_id']"));
        String elPersonalAdviser = PersonalAdviser.getText();
        MobileElement AdvisorDetail1 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id0']"));
        String elAdvisorDetail1 = AdvisorDetail1.getText();
        MobileElement AdvisorDetail2 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id1']"));
        String elAdvisorDetail2 = AdvisorDetail2.getText();
        MobileElement AdvisorDetail3 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_bullet_desc_id2']"));
        String elAdvisorDetail3 = AdvisorDetail3.getText();
        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        String elSendEmail = SendEmail.getText();
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        String elCallAdvisor = CallAdvisor.getText();
        System.err.println("get elHeader : " + elHeader);
        System.err.println("get elNameAdvisor : " + elNameAdvisor);
        System.err.println("get elExpertise : " + elExpertise);
        System.err.println("get elExpertiseDetail : " + elExpertiseDetail);
        System.err.println("get elLicense1 : " + elLicense1);
        System.err.println("get elLicense1No : " + elLicense1No);
        System.err.println("get elPersonalAdviser : " + elPersonalAdviser);
        System.err.println("get elAdvisorDetail1 : " + elAdvisorDetail1);
        System.err.println("get elAdvisorDetail2 : " + elAdvisorDetail2);
        System.err.println("get elAdvisorDetail3 : " + elAdvisorDetail3);
        System.err.println("get elShowMore : " + elShowMore);
        System.err.println("get elSendEmail : " + elSendEmail);
        System.err.println("get elCallAdvisor : " + elCallAdvisor);

        JSONObject EligibilityACC = (JSONObject) new JSONParser().parse(AdvisorInfoUI("SE122WLK6k7WpkFjUTgUdQ4D0fG4lZxBU4PG92K0HsvBd+JqkA/CRXZBMDoKLTZx/vo3IMzATCsrHD2nPbG+aUfoCUceik3D4Nqkv69l9q3BvX0DHp+62yNRL0jqJzCAoNeFTsY4jWeGkhEG5IJ4FNcVoP7HEX97s5MWPh+pvtHIVBn4mfLrZ1+EVFfkhbXUXMBzjRJNm8htQS+Yv8ZDp4WcKu47OxwYH8vuPxZHgQqsnnjThhDvbBD0chTqnLwcL5oms4h/822JnjSoG4c0xPbokOp0myyXu6Oq/JxLhgM0kxVXSNOoSH5igyJ4ZIaQkow90GRyLN8v1z+tt4rILg=="));
        JSONObject JsonDataEligibility = (JSONObject) EligibilityACC.get("data");
        JSONArray Arr_Acc = (JSONArray) JsonDataEligibility.get("license");

        for (int i = 0; i < Arr_Acc.size(); i++) {
            JSONObject License = (JSONObject) Arr_Acc.get(i);
            if (i == 0) {
                Assert.assertTrue(elLicense1.equals(License.get("license_value_th")));
//                Assert.assertTrue(elNameAdvisor.equals(License.get("license_value_th"));
                Assert.assertTrue(elLicense1No.equals(License.get("license_number")));
            }
        }

        System.err.println("License no. " + JsonDataEligibility.get("full_name_th"));
        Assert.assertTrue(elHeader.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(JsonDataEligibility.get("full_name_th").equals(" "+ elNameAdvisor));
        Assert.assertTrue(elExpertise.equals("ความเชี่ยวชาญ"));
        Assert.assertTrue(elExpertiseDetail.equals("การลงทุน, การวางแผนการเงิน"));
        Assert.assertTrue(elShowMore.equals("แสดงเพิ่มขึ้น"));
        Assert.assertTrue(elSendEmail.equals("ส่งอีเมล"));
        String time = java.time.LocalTime.now().toString().substring(0,2);
        int timeInt = Integer.parseInt(time);
        if(timeInt > 7 && timeInt < 18) {
            Assert.assertTrue(elCallAdvisor.equals("โทรติดต่อ"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("ให้ติดต่อกลับ"));
        }
        Assert.assertTrue(elPersonalAdviser.equals("ที่ปรึกษาการเงินส่วนตัว"));
        Assert.assertTrue(elAdvisorDetail1.equals("ให้คำปรึกษาด้านการบริหารจัดการพอร์ตการลงทุน รวมถึงการเงินของคุณ เช่น ด้านภาษี การจัดการมรดก"));
        Assert.assertTrue(elAdvisorDetail2.equals("ติดตามความเคลื่อนไหวของตลาดและพอร์ตการลงทุนของคุณอย่างใกล้ชิด เพื่อไม่ให้คุณพลาดโอกาสสำคัญ"));
        Assert.assertTrue(elAdvisorDetail3.equals("แนะนำผลิตภัณฑ์และบริการที่เหมาะสมกับวัตถุประสงค์ ความต้องการ ระยะเวลาการลงทุน และความเสี่ยงที่คุณยอมรับได้"));


    }

    @Test(priority = 4)
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement ShowMore = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_show_more_less_id']"));
        String elShowMore = ShowMore.getText();
        ShowMore.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_navbar_title_id']")));

        MobileElement SendEmail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_email_and_note_id']"));
        String elSendEmail = SendEmail.getText();
        MobileElement CallAdvisor = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_button_call_phone_id']"));
        String elCallAdvisor = CallAdvisor.getText();
        CallAdvisor.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']")));
        MobileElement Placeholder = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[11]/android.view.View/android.view.View/android.view.View/android.view.View"));
        String elPlaceholder = Placeholder.getText();
        MobileElement TextArea = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_text_area_id']"));
        TextArea.sendKeys("Test");
        MobileElement BtnSendNote = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='personal_wealth_advisor_popup_btn_next_id']"));
        String elBtnSendNote = BtnSendNote.getText();

//        TouchAction clickMore = new TouchAction(appiumDriverMobile);
//        Thread.sleep(2000);
//        clickMore.tap(PointOption.point(273,2201)).perform();
//        Thread.sleep(2000);
//        MobileElement EmailFrom = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/spinner_account_address']"));
//        String elEmailFrom = EmailFrom.getText();
//        MobileElement Email = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/peoplekit_chip']"));
//        String [] elEmail = Email.getText().split(",");
//        String EmailTo = elEmail[0];
//        String EmailCC = elEmail[1];
        System.err.println("get elShowMore : " + elShowMore);
        System.err.println("get elSendEmail : " + elSendEmail);
        System.err.println("get elCallAdvisor : " + elCallAdvisor);
        System.err.println("get elPlaceholder : " + elPlaceholder);
        System.err.println("get elBtnSendNote : " + elBtnSendNote);
//        System.err.println("get elEmailFrom : " + elEmailFrom);
//        System.err.println("get elEmail : " + elEmail);
//        System.err.println("get EmailTo : " + EmailTo);
//        System.err.println("get EmailCC : " + EmailCC);

        JSONObject EligibilityACC = (JSONObject) new JSONParser().parse(AdvisorInfoUI("SE122WLK6k7WpkFjUTgUdQ4D0fG4lZxBU4PG92K0HsvBd+JqkA/CRXZBMDoKLTZx/vo3IMzATCsrHD2nPbG+aUfoCUceik3D4Nqkv69l9q3BvX0DHp+62yNRL0jqJzCAoNeFTsY4jWeGkhEG5IJ4FNcVoP7HEX97s5MWPh+pvtHIVBn4mfLrZ1+EVFfkhbXUXMBzjRJNm8htQS+Yv8ZDp4WcKu47OxwYH8vuPxZHgQqsnnjThhDvbBD0chTqnLwcL5oms4h/822JnjSoG4c0xPbokOp0myyXu6Oq/JxLhgM0kxVXSNOoSH5igyJ4ZIaQkow90GRyLN8v1z+tt4rILg=="));
        JSONObject JsonDataEligibility = (JSONObject) EligibilityACC.get("data");
        JSONArray Arr_Acc = (JSONArray) JsonDataEligibility.get("license");


        Assert.assertTrue(elShowMore.equals("แสดงน้อยลง"));
        Assert.assertTrue(elSendEmail.equals("ส่งอีเมล"));
        String time = java.time.LocalTime.now().toString().substring(0,2);
        int timeInt = Integer.parseInt(time);
        if(timeInt > 7 && timeInt < 18) {
            Assert.assertTrue(elCallAdvisor.equals("โทรติดต่อ"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("ให้ติดต่อกลับ"));
        }

    }
}
