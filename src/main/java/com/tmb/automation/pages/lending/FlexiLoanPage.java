package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FlexiLoanPage extends AppiumLibrary {
    public FlexiLoanPage(AppiumDriver<WebElement> driver) {
        super((AppiumDriver<WebElement>) driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Account > Cards > Credit landing page > Credit card
    public String swFL0_Card1_ttb_reserve_infinite = "//*[@id=\"__next\"]/div[2]/div/div[1]/h3";
    public String swFL0_Card2 = "//*[@id=\"__next\"]/div[2]/div/div[2]/h3";
    public String swFL0_Card3 = "//*[@id=\"__next\"]/div[2]/div/div[3]/h3";
    public String swFL0_Card4 = "//*[@id=\"__next\"]/div[2]/div/div[4]/h3";
    public String swFL0_Card5 = "//*[@id=\"__next\"]/div[2]/div/div[5]/h3";
    public String swFL0_Card6 = "//*[@id=\"__next\"]/div[2]/div/div[6]/h3";
    public String swFL0_entryPointToFlexiLoan = "//*[@id=\"__next\"]/div[2]/div/button";


    //Page0 - Enter CRM ID
    public String swFL_Back = "//button[@id=\"refrence-number-back-btn\"]/svg";
    public String swFL0_title = "//h1[@id=\"refrence-number-header-label\"]";
    public String swFL0_enterCRMID = "//div[contains(@class, \"flexi-loan-enter-crm-idstyled\")]";
    public String swFL0_crmid_txt = "//input[@id=\"refrence-number-text-box\"]";
    public String swFL0_next = "//button[@id=\"refrence-number-submit-btn\"]";

    //Page1 - Select Credit Card
    public String swFL1_title = "//div[contains(@class, \"flexi-loan-product-selectionstyled__Text\")]";
    public String swFL1_list_creditCard = "//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1]";
    public String swFL1_list_maximumOffer = "//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[2]";
    public String swFL1_ttbCash2Go = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[1]";
    public String swFL1_ttbFlash = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[2]";
    public String swFL1_ttbReserveSignature = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[3]";
    public String swFL1_ttbSoChilled = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[4]";
    public String swFL1_ttbReserveInfinit = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[5]";
    public String swFL1_ttbAbsolute = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[6]";
    public String swFL1_ttbSoSmart = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[7]";
    public String swFL1_ttbSoFast = "(//div[contains(@class, \"flexi-loan-product-selectionstyled\")]/div[1]/div[1]/div[1])[8]";

    //Page2 - Apply TMB Credit Card
    public String swFL2_title = "//h1[@id=\"refrence-number-header-label\"]"; //สมัคร ทีเอ็มบี เครดิตการ์ด
    public String swFL2_viewStage_btn = "";
    public String swFL2_viewStageName_lb = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/span[2]";
    public String getSwFL2_SelectLimit_lb = "//*[@id=\"flexiloan_c2g_limit_amount_text\"]";
    public String swFL2_SelectLimit_txt = "//*[@id=\"flexiloan_c2g_text_field\"]";
    public String swFL2_installmentMonth = "//*[@id=\"selectBox\"]";
    public String swFL2_Limit = "//*[@id=\"__next\"]/div[1]/div[4]/div[5]/div/div[2]/span";
    public String swFL2_InstallmentPayment = "//*[@id=\"__next\"]/div[1]/div[4]/div[5]/div/div[3]/span";
    public String swFL2_Months = "//*[@id=\"__next\"]/div[1]/div[4]/div[5]/div/div[4]/span";
    public String swFL2_Interest = "//*[@id=\"__next\"]/div[1]/div[4]/div[5]/div/div[5]/span";
    public String swFL2_next = "//button[@id=\"flexiloan_c2g_next_button\"]";

    public String swFL2_applyTMBCreditCard = "//button[@id=\"refrence-number-submit-btn\"]";

    //Page3 - Apply Credit Card
    public String swFL3_title = "//h1[@id=\"flexiloan_credit_card_title\"]";
    public String swFL3_viewStage_btn = "";
    public String swFL3_viewStageName_lb = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/span[2]"; //กรอกข้อมูลสินเชื่อ
    public String swFL3_selectAccountReceive_lb = "";
    public String swFL3_list_AccountNameReceive_chb = "//*[@id=\"flexiloan_c2g_second_page_select_account_to_receive_radio0\"]/span[1]/div[1]/div[1]";
    public String swFL3_creditCardLimit_lb = "//h3[@id=\"flexiloan_credit_card_limit_amount_text']";
    public String swFL3_creditCardLimitAmount_lb = "//h3[@id=\"flexiloan_credit_card_limit_amount_number']";
    public String swFL3_selectPayment_lb = "//h3[@id=\"flexiloan_credit_card_payment_method_text\"]";
    public String swFL3_directdebt_btn = "//*[@id=\"flexiloan_c2g_second_page_payment_method_option_one_text\"]/p";
    public String swFL3_otherChannel_btn = "//*[@id=\"flexiloan_c2g_second_page_payment_method_option_two_text\"]/p";
    public String swFL3_otherChannek_lb = "//*[@id=\"flexiloan_c2g_second_page_account_radio_button0\"]/span";
    public String swFL3_list_AccountNamePayment_chb = "//*[@id=\"flexiloan_c2g_second_page_account_radio_button0\"]/span/div/div";//"//*[@id=\"flexiloan_credit_card_account_radio_button0\"]/span[1]/div[1]/div[1]";
    public String swFL3_dueDate_ddl = "//*[@id=\"selectBox\"]";
    public String swFL3_botAnswer1_1 = "//*[@id=\"flexiloan_c2g_second_page_question_one_radio_choice_one\"]/span";
    public String swFL3_botAnswer1_2 = "//*[@id=\"flexiloan_c2g_second_page_question_one_radio_choice_two\"]/span";
    public String swFL3_botAnswer1_3 = "//*[@id=\"flexiloan_c2g_second_page_question_one_radio_choice_three\"]/span";
    public String swFL3_botAnswer2_1 = "//*[@id=\"flexiloan_c2g_second_page_question_two_radio_choice_one\"]/span";
    public String swFL3_botAnswer2_2 = "//*[@id=\"flexiloan_c2g_second_page_question_two_radio_choice_two\"]/span";
    public String swFL3_botAnswer2_3 = "//*[@id=\"flexiloan_c2g_second_page_question_two_radio_choice_three\"]/span";
    public String swFL3_condition_lb = "//div[contains(@class, \"flexi-loan-credit-card\")]/form/label";
    public String swFL3_debitFull_chb = "//div[contains(@class, \"flexi-loan-credit-card\")]/form/lable[1]/input[1]";
    public String swFL3_debit5Percent_chb = "//div[contains(@class, \"flexi-loan-credit-card\")]/form/lable[1]/input[2]";
    public String swFL3_desc1 = "//h3[@id=\"flexiloan_credit_card_payment_want_more_cash_text\"]";
    public String swFL3_desc2 = "//p[@id=\"flexiloan_credit_card_payment_warning_text\"]";
    public String swFL3_next = "//button[@id=\"flexiloan_c2g_second_page_next_button\"]";

    //page3 - Flash Card
    public String getSwFL2_applyTMBFlashCard = "//*[@id=\"refrence-number-submit-btn\"]";
    public String swFL3_flash_viewStageName_lb = "//div[contains(@class, \"flexi-loan-flash-cardstyled\")]/div[1]/div[1]/div[1]/div[1]/span[2]"; //กรอกข้อมูลสินเชื่อ
    public String swFL3_flash_title2 = "//*[@id=\"flexiloan_flash_card_limit_amount_text\"]";
    public String swFL3_flash_creditCardLimitAmount_lb = "//*[@id=\"flexiloan_flash_card_limit_amount_number\"]";
    public String swFL3_flash_selectPayment_lb = "//h3[@id=\"flexiloan_flash_card_payment_method_text\"]";
    public String swFL3_flash_directdebt_btn = "//*[@id=\"flexiloan_flash_card_payment_method_option_one_text\"]/p";
    public String swFL3_flash_otherChannel_btn = "//*[@id=\"flexiloan_flash_card_payment_method_option_one_text\"]/p";
    public String swFL3_flash_otherChannek_lb = "//*[@id=\"flexiloan_flash_card_payment_method_option_one_text\"]/span";
    public String swFL3_flash_list_AccountNamePayment_chb = "//*[@id=\"flexiloan_flash_card_account_radio_button0\"]/span";
    public String swFL3_flash_botAnswer1_1 = "//*[@id=\"flexiloan_flash_card_question_one_radio_choice_one\"]/span";
    public String swFL3_flash_botAnswer1_2 = "//*[@id=\"flexiloan_flash_card_question_one_radio_choice_two\"]/span";
    public String swFL3_flash_botAnswer1_3 = "//*[@id=\"flexiloan_flash_card_question_one_radio_choice_three\"]/span";
    public String swFL3_flash_botAnswer2_1 = "//*[@id=\"flexiloan_flash_card_question_two_radio_choice_one\"]/span";
    public String swFL3_flash_botAnswer2_2 = "//*[@id=\"flexiloan_flash_card_question_two_radio_choice_two\"]/span";
    public String swFL3_flash_botAnswer2_3 = "//*[@id=\"flexiloan_flash_card_question_two_radio_choice_three\"]/span";
    public String swFL3_flash_condition_lb = "//div[contains(@class, \"flexi-loan-flash-card\")]/form/label";
    public String swFL3_flash_debitFull_chb = "//div[contains(@class, \"flexi-loan-flash-cardstyled__SecondRadioButton\")]/form/label[1]";
    public String swFL3_flash_debit3Percent_chb = "//div[contains(@class, \"flexi-loan-flash-cardstyled__SecondRadioButton\")]/form/label[2]";
    public String swFL3_flash_desc1 = "//*[@id=\"flexiloan_flash_card_payment_want_more_cash_text\"]";
    public String swFL3_flash_desc2 = "//*[@id=\"flexiloan_flash_card_payment_warning_text\"]";
    public String swFL3_flash_next = "//button[@id=\"flexiloan_flash_card_next_button\"]";

    //Page4 - apply Personal cash
    public String swFL4_title = "//div[contains(@class, \"\")]/div[1]/div[1]/div[2]/div[1]";
    public String swFL4_viewStage_btn = "//div[contains(@class, \"personal-informationstyled__ChildWrapper\")]/div[1]/div[1]/svg";
    public String swFL4_stageName = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[1]/span[2]";
    public String swFL4_personalInformation_lb = "//div[contains(@class, \"personal-informationstyled__ChildWrapper\")]/div[2]";//ข้อมูลส่วนตัว
    public String swFL4_remark1 = "//div[contains(@class, \"personal-informationstyled__ChildWrapper\")]/div[3]";
    public String swFL4_fullName_txt = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[1]";
    public String swFL4_birthDate_txt = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[2]";
    public String swFL4_citizenId_txt = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[3]";
    public String swFL4_expiryDate_txt = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[4]";
    public String swFL4_nationality_txt = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[5]";
    public String swFL4_mobileNumber = "(//div[contains(@class, \"personal-informationstyled__MessageBox\")]/label/div/span/span[2]/span)[6]";
    public String swFL4_addressInformation = "//div[contains(@class, \"personal-informationstyled__Title\")]";
//    public String swFL4_contactAddress = "//div[contains(@class, \"personal-informationstyled__TextDescription\")]";
    public String swFL4_contactAddress = "//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div";
//    public String swFL4_edit_btn = "//div[contains(@class, \"personal-informationstyled\"]/div/svg";
    public String swFL4_edit_btn = "//div[contains(@class, \"personal-informationstyled__Button\")]/div[3]/div[2]";
    public String swFL4_next = "//div[contains(@class, \"personal-informationstyled__Button\")]/button[1]";

    //Page5 Edit Address
    public String swFL5_title = "//h1[@id=\"edit-info-header-label\"]";
    public String swFL5_houseNo_txt = "//input[@id=\"edit-info-house-number\"]";
    public String swFL5_roomNo_txt = "//input[@id=\"edit-info-room-number\"]";
    public String swFL5_mandatory_txt = "";
    public String swFL5_floorNo_txt = "//input[@id=\"edit-info-floor-number\"]";
    public String swFL5_moo_txt = "//input[@id=\"edit-info-moo\"]";
    public String swFL5_soi_txt = "//input[@id=\"edit-info-soi\"]";
    public String swFL5_villageBuilding_txt = "//input[@id=\"edit-info-village\"]";
    public String swFL5_street_txt = "//input[@id=\"edit-info-street\"]";
    public String swFL5_zipCode_txt = "//input[@id=\"edit-info-zip\"]";
    public String swFL5_provice_lb = "//input[@id=\"edit-info-province\"]";
    public String swFL5_district_lb = "//input[@id=\"edit-info-district\"]";
    public String swFL5_subDistrict_lb = "//input[@id=\"edit-info-sub-district\"]";
    public String swFL5_saveEnabled = "//button[contains(@class, \"edit-addressstyled__NextButton-sc-1sjut3l-11 bZRHkH\")]";
    public String swFL5_saveDisabled = "//button[contains(@class, \"edit-addressstyled__NextButton-sc-1sjut3l-11 cjiMin\")]";
    public String swFL5_save = "//button[@id=\"edit-info-save-button\"]";

    //Page6 - Working Information
    public String swFL6_title = "//h1[@id=\"ENTER_CVV_SCREEN_HEADER_LABEL\"]";
    public String swFL6_viewStage_btn = "//div[contains(@class, \"working-infostyled__HeaderBox\")]/div/svg";
    public String swFL6_stageName = "//*[@id=\"__next\"]/div[1]/div/div[2]/div/div[1]/span[2]";
    public String swFL6_occupationInfo_lb = "//*[@id=\"__next\"]/div[1]/div/div[3]/h3";
    public String swFL6_workStatus_ddl = "(//*[@id=\"selectBox\"])[1]";
    public String swFL6_occpation_ddl = "(//*[@id=\"selectBox\"])[2]";
    public String swFL6_bussinessType_ddl = "(//*[@id=\"selectBox\"])[3]";
    public String swFL6_businessSubType_ddl = "(//*[@id=\"selectBox\"])[4]";
    public String swFL6_workingPlace_lb = "//div[contains(@class=\"working-infostyled__MiddleLabelBox\")]/h3";
    public String swFL6_officeName_txt = "//*[@id=\"edit-info-office-name\"]";
    public String swFL6_officeAddress_txt = "//*[@id=\"__next\"]/div[1]/div/div[9]/div/div[1]/div"; //value="OHO BURGER"
    public String swFL6_editOfficeAddress_btn = "//*[@id=\"__next\"]/div[1]/div/div[9]/div/div[2]/svg";
    public String swFL6_officePhone_txt = "//*[@id=\"edit-info-phone-number\"]";
    public String swFL6_officePhoneExt_txt = "//*[@id=\"edit-info-extension\"]";
    public String swFL6_incomeInformation_lb = "//div[contains(@class, \"working-infostyled__BottomLabelBox\")]/h3";
    public String swFL6_incomePerMonth_ddl = "(//*[@id=\"selectBox\"])[5]";
    public String swFL6_sourceOfIncome_ddl = "(//*[@id=\"selectBox\"])[6]";
    public String swFL6_countryOfIncome_ddl = "(//*[@id=\"selectBox\"])[7]";
    public String swFL6_statementReceivingInformation_lb = "//div[contains(@class, \"working-infostyled__BottomLabelBox\")]";
    public String swFL6_contactAddress_rdb = "//div[@id=\"edit-info-office-address-radio\"]";
    public String swFL6_contactAddress_lb = "//*[@id=\"One\"]/span";
    public String swFL6_officeAddress_rdb = "//*[@id=\"Two\"]/span";
    public String swFL6_officeAddress_lb = "//*[@id=\"Two\"]/span";
    public String swFL6_applyEStatement_chb = "//*[@id=\"edit-info-check-box\"]";
    public String swFL6_applyEStatement_lb = "//*[@id=\"edit-info-check-box\"]/div/div";
    public String swFL6_next = "//*[@id=\"edit-info-next-button\"]";
    public String swFL6_confirmDesc1 = "//*[@id=\"popup-title\"]";
    public String swFL6_confirmDesc2 = "//*[@id=\"edit-info-popup-info\"]";
    public String swFL6_confirmNext =  "//*[@id=\"edit-info-confirm-button\"]";


    //term & conditions
    public String swFL7_desc1 = "//*[@id=\"lending-terms-condition-title\"]";
    public String swFL7_condition1 = "//*[@id=\"1\"]/span[1]";////*[@id="1"]/span[1]
    public String swFL7_condition2 = "//*[@id=\"2\"]/span[1]";
    public String swFL7_condition3 = "//*[@id=\"3\"]/span[1]";
    public String swFL7_next = "//*[@id=\"lending-terms-condition-button\"]";
    //<button type="button" id="lending-terms-condition-button" aria-label="lending-terms-condition-button" class="sc-ksluoS lTfwQ" disabled="">ถัดไป</button>

    //reveal page
    public String swFL8_title = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div";
    public String swFL8_viewStage_btn = "//*[@id=\"__next\"]/div[2]/div[1]/div/div[1]/span[2]";
    public String swFL8_stageName_lb = "//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]";
    public String swFL8_name_lb = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div/div[2]";
    public String swFL8_idCard_lb = "//*[@id=\"__next\"]/div[2]/div[2]/div[3]/div/div[2]";
    public String swFL8_birthDate_lb = "//*[@id=\"__next\"]/div[2]/div[2]/div[4]/div/div[2]";
    public String swFL8_mobilePhoneNumber_lb = "//*[@id=\"__next\"]/div[2]/div[2]/div[5]/div/div[2]";
    public String swFL8_loanType_lb = "//*[@id=\"__next\"]/div[2]/div[2]/div[6]/div/div[2]";
    public String swFL8_desc1_lb = "//*[@id=\"__next\"]/div[2]/div[3]";
    public String swFL8_desc2_lb = "//*[@id=\"__next\"]/div[2]/div[4]";
    public String swFL8_notAccepted_btn = "//button[contains(@class, \"letter-consentstyled__CancelButton\")]";
    public String swFL8_Accepted_btn = "//button[contains(@class, \"letter-consentstyled__SubmitButton\")]";

    public String swFL8_notAccepted_desc1 = "//*[@id=\"popup-title\"]";
    public String swFL8_notAccepted_desc2 = "//div[contains(@class, \"letter-consentstyled__Content\")]";
    public String swFL8_notAccepted_confirm = "//div[div[contains(@class, \"letter-consentstyled__Content\")]]/button[1]";
    public String swFL8_notAccepted_cancel = "//div[div[contains(@class, \"letter-consentstyled__Content\")]]/button[2]";

    //confirm screen
    public String swFL9_title = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div"; //สมัครบัตรกดเงินสด
    public String swFL9_title2 = "//*[@id=\"__next\"]/div[2]/div[1]/div[1]/div[1]/div[2]"; // ความยินยอมในการเปิดเผย
    public String swFL9_name = "//*[@id=\"__next\"]/div[2]/div[1]/div[2]/div/div[2]"; // ชื่อ
    public String swFL9_idCard = "//*[@id=\"__next\"]/div[2]/div[1]/div[3]/div/div[2]";
    public String swFL9_birthDate = "//*[@id=\"__next\"]/div[2]/div[1]/div[4]/div/div[2]";
    public String swFL9_mobilePhone = "//*[@id=\"__next\"]/div[2]/div[1]/div[5]/div/div[2]";
    public String swFL9_loanType = "//*[@id=\"__next\"]/div[2]/div[1]/div[6]/div/div[2]";
    public String swFL9_refNo = "//*[@id=\"__next\"]/div[2]/div[1]/div[7]/div/div[2]";
    public String swFL9_dateConsent = "//*[@id=\"__next\"]/div[2]/div[1]/div[8]/div/div[2]";
    public String swFL9_channel = "//*[@id=\"__next\"]/div[2]/div[1]/div[9]/div/div[2]";
    public String swFL9_channelConsent = "//*[@id=\"__next\"]/div[2]/div[1]/div[10]/div/div[2]";
    public String swFL9_desc1 = "//*[@id=\"__next\"]/div[2]/div[1]/div[10]/div/div[2]";
    public String swFL9_desc2 = "//*[@id=\"__next\"]/div[2]/div[2]";
    public String swFL9_next = "//button[contains(@class, \"letter-consentstyled__SubmitButton\")]";

    //Loan day 1 = apply flash card - สมัครบัตรกดเงินสด
    public String swFL10_viewStatement_lb = "//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[1]/div/div/span[2]";

    public String swFL10_title1_lb = "//*[@id=\"request_ncb_report_information_title_id\"]"; //บริการรับเงิน
    public String swFL10_title2_lb = "//*[@id=\"al-car-tax-sign-select-payment-type-payment-selection\"]"; //ต้องการรับเงินสด
    public String swFL10_want_chb = "//label[@id=\"rsRb_thai_language_radio_button\"]/span/div";  //checkbox want ต้องการ /div
    public String swFL10_noWant_chb = "//label[@id=\"rsRb_english_language_radio_button\"]/span/div"; //ยังไม่ต้องการตอนนี้  /div
    public String swFL10_next = "//*[@id=\"request_ncb_id_number_btn_id\"]"; //ถัดไป
    public String swFL10_want_creditRecieveTransfer = "//*[@id=\"al-car-tax-sign-select-payment-type-payment-selection\"]"; //ระบุวงเงินที่ต้องการรับโอน
    public String swFL10_want_fullCreditRevieve = "//div[contains(@class, \"personal-informationstyled__CardContainer\")]/div[1]/label[1]/div[1]/div[2]/span[1]"; //เต็มวงงเงินที่ได้รับอนุมัติ
    public String swFL10_want_creditLimit = "//div[contains(@class, \"personal-informationstyled__CardContainer\")]/div[2]/label[1]/div[1]/div[2]/span[1]"; //ระบุวงเงิน
    public String swFL10_want_creditLimit_text = "//*[@id=\"test-id\"]";
    public String swFL10_want_creditLimit_errorMessage = "//div[contains(@class, \"personal-informationstyled__ErrorText\")]";
    public String swFL10_want_payAmountFull = "//div[contains(@clsss, \"personal-informationstyled__RadioGroup\")]/div[1]/label[1]/div[1]/div[2]/span[1]";//ชำระขั้นต่ำหรือเต็มจำนวน
    public String swFL10_want_fee = "//div[contains(@class, \"personal-informationstyled__Detail\")]/div[1]/div[1]/span[2]"; //ค่าธรรมเนียม
    public String swFL10_want_vat = "//div[contains(@class, \"personal-informationstyled__Detail\")]/div[1]/div[2]/span[2]"; // vat
    public String swFL10_want_interestYear = "//div[contains(@class, \"personal-informationstyled__Detail\")]/div[1]/div[3]/span[2]"; // ดอกเบี้ย(รายปี)
    public String swFL10_want_payAmountMonthly = "//div[contains(@clsss, \"personal-informationstyled__RadioGroup\")]/div[2]/label[1]/div[1]/div[2]/span[1]"; //แบ่งชำระรายเดือน
    public String swFL10_want_totalMonth = "//div[contains(@class, \"personal-informationstyled__PaymentDetail\")]/div[1]/div[1]/div[1]/span[1]"; //จำนวนเดือนที่ต้องการผ่อนชำระ
    public String swFL10_want_monthlyPlan = "//div[contains(@class, \"personal-informationstyled__PaymentDetail\")]/div[1]/div[1]/div[1]/select[1]"; //select
    public String swFL10_want_interestSpecial = "//h4[@class, \"personal-informationstyled__PaymentDetail\")]/h4"; //อัตราดอกเบี้ยพิเศษ
    public String swFL10_want_interestMonth1 = "//h4[@class, \"personal-informationstyled__PaymentDetail\")]/div[1]/span[1]"; //เดือนที่ 1
    public String swFL10_want_interestMonth2 = "//h4[@class, \"personal-informationstyled__PaymentDetail\")]/div[2]/span[1]"; // เดือนที่ 2
    public String swFL10_want_interestMonth3 = "//h4[@class, \"personal-informationstyled__PaymentDetail\")]/div[3]/span[1]"; // เดือนที่ 3
    public String swFL10_want_selectTTBAccount = "//*[@id=\"al-car-tax-sign-select-payment-type-payment-selection\"]"; // เลือกบัญชีทีทีบี
    public String swFL10_want_accountAllFree = "//div[contains(@class, \"personal-informationstyled__ContentLabel\")]/form[1]/label[1]"; // บัญชีออลล์ฟรี
    public String swFL10_want_SummaryCredit = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/h4"; // สรุปวงเงิน
    public String swFL10_want_loanLimit = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/div[1]/span[2]"; // วงเงินสินเชื่อ
    public String swFL10_want_totalAmountWant = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/div[2]/span[2]"; // จำนนวนเงินที่ต้องการ
    public String swFL10_want_paymentPlan = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/div[3]/span[2]"; // แผนการชำระเงิน
    public String swFL10_want_installmentTime = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/div[4]/span[2]"; // ระยะเวลาผ่อน
    public String swFL10_want_accountReceived = "//div[contains(@class, \"personal-informationstyled__SummaryCardContainer\")]/div[5]/span[2]"; // บัญชีรับเงิน
    public String swFL10_want_Next = "//*[@id=\"request_ncb_id_number_btn_id\"]"; //ถัดไป

    public String swFL11_applyFlashCard = "//*[@id=\"request_ncb_report_detail_header_label_id\"]"; //สมัครบัตรกดเงินสด
    public String swFL11_desc = "//*[@id=\"__next\"]/div[1]/div[2]/div"; // 1-2  นาท่ีี

    // ต้องการ >
    public String swFL10_understruction_title = "//div[contains(@class, \"personal-informationstyled__Container\")]/div[4]/div[1]/div[2]/div[1]";//บริการนี้ไม่สามารถใช้งานได้ชั่วคราว
    public String swFL10_understruction_desc = "//div[contains(@class, \"personal-informationstyled__Container\")]/div[4]/div[1]/div[2]/div[3]"; //ขออภัยในความไม่สะดวก กรุณาดำเนินการใหม่อีกครั้ง
    public String swFL10_understruction_ok = "//*[@id=\"primaryButton\"]"; //ตกลง
    public String swFL10_underconstraction_close = "//div[contains(@class, \"personal-informationstyled__Container\")]/div[4]/div[1]/div[1]/div[1]/svg";







}
