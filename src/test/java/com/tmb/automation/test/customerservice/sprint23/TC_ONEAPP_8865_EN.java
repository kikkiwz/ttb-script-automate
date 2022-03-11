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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.tmb.automation.api.customerservice.sprint21.BiometricConsent.GetBiometricConsent_ForDEMO;
import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class TC_ONEAPP_8865_EN extends Base {
    JSONObject JsonDataNdidEligibile = null;
    JSONObject JsonDataNdidUserData = null;
    @Parameters({"DeviceProfile" })
   	@BeforeClass
   	public void BeforeTest(String deviceProfile) {
   		Helper.CONFIG_PROFILE = deviceProfile;		
   		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
   		ExtentListeners.setDriver(appiumDriverMobile);
   	}
    //    JSONObject JsonDataBiometricConsent = null;
    @BeforeTest
    public void servoice() throws Exception {
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONObject NdidUserData = (JSONObject) new JSONParser().parse(NdidUserData(AccessToken));
        JsonDataNdidUserData =  (JSONObject)NdidUserData.get("data");
        System.err.println(JsonDataNdidUserData.get("date_of_birth").toString());
        int year = Integer.parseInt(JsonDataNdidUserData.get("date_of_birth").toString().substring(0,4)) + 543;
        System.err.println(year);
        String yearth = year + JsonDataNdidUserData.get("date_of_birth").toString().substring(4,10) + "T00:00";
        System.err.println(yearth);
        System.err.println(ConvertDate(yearth,false, "TH"));
        String body = "{\n" +
                "  \"acceptance\": \"N\",\n" +
                "  \"version\": \"1.00\"\n" +
                "}";
        JSONObject BiometricConsent = (JSONObject) new JSONParser().parse(GetBiometricConsent_ForDEMO(body, AccessToken));
    }


    public static String ConvertDate(String Date_Expiry, Boolean Format, String timezone)  throws IOException {
        DateTimeFormatter newFormatter = null;
        if(Format){
            if(timezone.equals("TH")){
                int year = Integer.parseInt(Date_Expiry.substring(0,4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4,16);
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy, HH:mm น.", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            }else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM uu, HH:mm a", Locale.ENGLISH);
            }
        }else {
            if(timezone.equals("TH")){
                int year = Integer.parseInt(Date_Expiry.substring(0,4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4,10) + "T00:00";
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            }else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
            }
        }
        LocalDateTime dateTime = LocalDateTime.parse(Date_Expiry);
        String contactDate = dateTime.format(newFormatter);
        return contactDate;
    }

    @Test(priority = 8)
    public void TC_ONEAPP_8865_NDID_Review_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_0']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_th_id']")));

        
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement PersonalDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_personal_detail_id']"));
        String elPersonalDetail = PersonalDetail.getText();
        MobileElement Edit = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_edit_id']"));
        String elEdit = Edit.getText();
        MobileElement NameTH = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_desc_th_id']"));
        String elNameTH = NameTH.getText();
        MobileElement NameTHValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_th_id']"));
        String elNameTHValue = NameTHValue.getText();
        MobileElement SurnameTH = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_desc_th_id']"));
        String elSurnameTH = SurnameTH.getText();
        MobileElement SurnameTHValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_value_th_id']"));
        String elSurnameTHValue = SurnameTHValue.getText();
        MobileElement NameEN = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_desc_en_id']"));
        String elNameEN = NameEN.getText();
        MobileElement NameENValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_en_id']"));
        String elNameENValue = NameENValue.getText();
        MobileElement SurnameEN = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_desc_en_id']"));
        String elSurnameEN = SurnameEN.getText();
        MobileElement SurnameENValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_value_en_id']"));
        String elSurnameENValue = SurnameENValue.getText();
        MobileElement DateOfBirth = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_date_of_birth_desc_id']"));
        String elDateOfBirth = DateOfBirth.getText();
        MobileElement DateOfBirthValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_date_of_birth_value_id']"));
        String elDateOfBirthValue = DateOfBirthValue.getText();
        MobileElement Nationality = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_nationality_desc_id']"));
        String elNationality = Nationality.getText();
        MobileElement NationalityValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_nationality_value_id']"));
        String elNationalityValue = NationalityValue.getText();
        MobileElement Status_data = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_status_desc_id']"));
        String elStatus = Status_data.getText();
        MobileElement StatusValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_status_value_id']"));
        String elStatusValue = StatusValue.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_idcard_desc_id']"));
        String elIDNumber = IDNumber.getText();
        MobileElement IDNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_idcard_value_id']"));
        String elIDNumberValue = IDNumberValue.getText().replace("-","");
        MobileElement Email = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_email_desc_id']"));
        String elEmail = Email.getText();
        MobileElement EmailValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_email_value_id']"));
        String elEmailValue = EmailValue.getText();
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_mobile_desc_id']"));
        String elMobileNumber = MobileNumber.getText();
        MobileElement MobileNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_mobile_value_id']"));
        String elMobileNumberValue = MobileNumberValue.getText().replace("-","");
        MobileElement RegisterAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_registered_address_desc_id']"));
        String elRegisterAddress = RegisterAddress.getText();
        MobileElement ContactAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_contact_address_desc_id']"));
        String elContactAddress = ContactAddress.getText();
        MobileElement ContactAddressValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_contact_address_value_id']"));
        String elContactAddressValue = ContactAddressValue.getText();
        System.err.println("elBtnReject : " + elHeader);
        System.err.println("elelPersonalDetail : " + elPersonalDetail);
        System.err.println("elEdit : " + elEdit);
        System.err.println("elNameTH : " + elNameTH + "     " + elNameTHValue);
        System.err.println("elSurnameTH : " + elSurnameTH + "     " + elSurnameTHValue);
        System.err.println("elNameEN : " + elNameEN + "     " + elNameENValue);
        System.err.println("elSurnameTH : " + elSurnameEN + "     " + elSurnameENValue);
        System.err.println("elDateOfBirth : " + elDateOfBirth + "     " + elDateOfBirthValue);
        System.err.println("elNationality : " + elNationality + "     " + elNationalityValue);
        System.err.println("elStatus : " + elStatus + "     " + elStatusValue);
        System.err.println("elIDNumber : " + elIDNumber + "     " + elIDNumberValue);
        System.err.println("elEmail : " + elEmail + "     " + elEmailValue);
        System.err.println("elMobileNumber : " + elMobileNumber + "     " + elMobileNumberValue);
        System.err.println("elContactAddress : " + elContactAddress + "     " + elContactAddressValue);
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
     
        MobileElement OccupationDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_occupation_detail_id']"));
        String elOccupationDetail = OccupationDetail.getText();
        System.err.println("elOccupationDetail : " + elOccupationDetail);
        MobileElement Occupation = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_occupation_desc_id']"));
        String elOccupation = Occupation.getText();
        System.err.println("elOccupation : " + elOccupation);
        MobileElement OccupationValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_occupation_value_id']"));
        String elOccupationValue = OccupationValue.getText();
        System.err.println("elOccupationValue : " + elOccupationValue);
        MobileElement CompanyName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_name_desc_id']"));
        String elCompanyName = CompanyName.getText();
        System.err.println("elCompanyName : " + elCompanyName);
        MobileElement CompanyNameValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_name_value_id']"));
        String elCompanyNameValue = CompanyNameValue.getText();
        System.err.println("elCompanyNameValue : " + elCompanyNameValue);
        MobileElement CompanyAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_address_desc_id']"));
        String elCompanyAddress = CompanyAddress.getText();
        System.err.println("elCompanyAddress : " + elCompanyAddress);
        MobileElement TitleIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_income_detail_id']"));
        String elTitleIncome = TitleIncome.getText();
        System.err.println("elTitleIncome : " + elTitleIncome);
        MobileElement PersonalIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_personal_income_desc_id']"));
        String elPersonalIncome = PersonalIncome.getText();
        System.err.println("elPersonalIncome : " + elPersonalIncome);
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        MobileElement SourceIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_source_income_desc_id']"));
        String elSourceIncome = SourceIncome.getText();
        System.err.println("elSourceIncome : " + elSourceIncome);
        MobileElement SourceIncomeValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_aource_income_value_id']"));
        String elSourceIncomeValue = SourceIncomeValue.getText();
        System.err.println("elSourceIncomeValue : " + elSourceIncomeValue);
        MobileElement CountryIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_country_income_desc_id']"));
        String elCountryIncome = CountryIncome.getText();
        System.err.println("elCountryIncome : " + elCountryIncome);
        MobileElement CountryIncomeValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_country_income_value_id']"));
        String elCountryIncomeValue = CountryIncomeValue.getText();
        System.err.println("elCountryIncomeValue : " + elCountryIncomeValue);
        MobileElement CheckboxValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_checkbox_value_id']"));
        String elCheckboxValue = CheckboxValue.getText();
        System.err.println("elCheckboxValue : " + elCheckboxValue);
        MobileElement ReadMoreValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_readmore_value_id']"));
        String elReadMoreValue = ReadMoreValue.getText();
        System.err.println("elReadMoreValue : " + elReadMoreValue);
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_confirm_value_id']"));
        String elBtnConfirm = BtnConfirm.getText();
        System.err.println("elBtnConfirm : " + elBtnConfirm);


     
        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elPersonalDetail.equals("Personal Detail"));
        Assert.assertTrue(elEdit.equals("Edit"));
        Assert.assertTrue(elNameTH.equals("Name (TH)"));
        Assert.assertTrue(elSurnameTH.equals("Surname (TH)"));
        Assert.assertTrue(elNameEN.equals("Name (EN)"));
        Assert.assertTrue(elSurnameEN.equals("Surname (EN)"));
        Assert.assertTrue(elDateOfBirth.equals("Date of birth"));
        Assert.assertTrue(elNationality.equals("Nationality"));
        Assert.assertTrue(elStatus.equals("Status"));
        Assert.assertTrue(elIDNumber.equals("ID card number"));
        Assert.assertTrue(elEmail.equals("Email"));
        Assert.assertTrue(elMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elRegisterAddress.equals("Registered Address"));
        Assert.assertTrue(elContactAddress.equals("Contact Address"));
        Assert.assertTrue(elOccupationDetail.equals("Occupation Detail"));
        Assert.assertTrue(elOccupation.equals("Occupation"));
        Assert.assertTrue(elCompanyName.equals("Company Name"));
        Assert.assertTrue(elCompanyAddress.equals("Company Address"));
        Assert.assertTrue(elTitleIncome.equals("Income Detail"));
        Assert.assertTrue(elPersonalIncome.equals("Personal Income"));
        Assert.assertTrue(elSourceIncome.equals("Source of Income"));
        Assert.assertTrue(elCountryIncome.equals("Country of Income"));
        Assert.assertTrue(elCheckboxValue.equals("I hereby agree to the Bank to disclose my personal data above to other organizations requesting information for the purpose of identity authentication. You can check the rights of the data subject at the Privacy Policy at http://www.ttbbank.com"));
        Assert.assertTrue(elReadMoreValue.equals("Read More"));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elNameTHValue.equals(JsonDataNdidUserData.get("first_name_th")));
        Assert.assertTrue(elSurnameTHValue.equals(JsonDataNdidUserData.get("last_name_th")));
        Assert.assertTrue(elNameENValue.equals(JsonDataNdidUserData.get("first_name_en")));
        Assert.assertTrue(elSurnameENValue.equals(JsonDataNdidUserData.get("last_name_en")));
        System.err.println(ConvertDate(JsonDataNdidUserData.get("date_of_birth").toString(),false, "TH"));
        Assert.assertTrue(elDateOfBirthValue.equals(ConvertDate(JsonDataNdidUserData.get("date_of_birth").toString(),false, "TH")));
        Assert.assertTrue(elNationalityValue.equals(JsonDataNdidUserData.get("nationality")));
        Assert.assertTrue(elStatusValue.equals(JsonDataNdidUserData.get("marital_status")));
        Assert.assertTrue(elIDNumberValue.equals(JsonDataNdidUserData.get("citizen_id")));
        Assert.assertTrue(elEmailValue.equals(JsonDataNdidUserData.get("email")));
        Assert.assertTrue(elMobileNumberValue.equals(JsonDataNdidUserData.get("mobile_no")));
        Assert.assertTrue(elContactAddressValue.equals(JsonDataNdidUserData.get("contact_address")));
        Assert.assertTrue(elOccupationValue.equals(JsonDataNdidUserData.get("occupation")));
        Assert.assertTrue(elCompanyNameValue.equals(JsonDataNdidUserData.get("company_name")));
        Assert.assertTrue(elSourceIncomeValue.equals(JsonDataNdidUserData.get("source_of_income")));
        Assert.assertTrue(elCountryIncomeValue.equals(JsonDataNdidUserData.get("country_of_income")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
    }
}
