package com.ttbbank.oneapp.scenario.customerservice.sprint32;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.*;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.contact_us.ContactUsResponse;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class PwaMyAdvisor3LicenseScenario extends BaseScenario {
    String CaseID = null;
    String TransactionDate = null;
    TmbServiceResponse<ContactUsResponse> response = null;
    @Test(groups = "Customer Service PWA My Advisor 3 License", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.35);
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_service_tab_contact_label_id']")));
        WebElement TAB_CONTACT_TTB = ttbTestContext.findElement(OneAppElementKeys.TAB_CONTACT_TTB);
        TAB_CONTACT_TTB.click();
        Thread.sleep(5000);
        WebElement LabelWealAdvisor = ttbTestContext.findElement(OneAppElementKeys.LABEL_PWA_NAME);
        String elLabelWealAdvisor = LabelWealAdvisor.getText();
        WebElement NameAdvisor = ttbTestContext.findElement(OneAppElementKeys.PWA_NAME);
        String elNameAdvisor = NameAdvisor.getText();
        System.err.println("get element : " + elLabelWealAdvisor);
        System.err.println("get element : " + elNameAdvisor);


        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        response = client.get("/apis/customer/contact-us", eqParams, ContactUsResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
//        if(true){
//            parentReport = extent.createTest("Personal Wealth Advisor", "Personal Wealth Advisor");
//        }
//        childReport = parentReport.createNode("Validate My advisor button");
//        childReport.log(Status.INFO, "<pre>Expected Result : The system should display My advisor button in customer service page.</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : The system should display pop-up message as below : " + TextColor.blueColor(elLabelWealAdvisor)
//                + "</br>Display pop-up message : " + TextColor.blueColor(elNameAdvisor)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display My advisor button in customer service page.</pre>\n" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        Assert.assertTrue(elLabelWealAdvisor.equals("Private Wealth Advisor"));
//        Assert.assertTrue(elNameAdvisor.equals(response.getData().advisor_full_name_en));
        LabelWealAdvisor.click();
    }

    @Test(groups = "PWA My Advisor Detail", dependsOnGroups = {"Customer Service PWA My Advisor 3 License"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_PWA_MY_ADVISOR);
        String elHeader = Header.getText();
        WebElement NameAdvisor = ttbTestContext.findElement(OneAppElementKeys.ADVISOR_NAME);
        String elNameAdvisor = NameAdvisor.getText();
        WebElement Expertise = ttbTestContext.findElement(OneAppElementKeys.EXPERTISE);
        String elExpertise = Expertise.getText();
        WebElement ExpertiseDetail = ttbTestContext.findElement(OneAppElementKeys.EXPERTISE_DETAIL);
        String elExpertiseDetail = ExpertiseDetail.getText();
        WebElement License1 = ttbTestContext.findElement(OneAppElementKeys.LICENSE_1);
        String elLicense1 = License1.getText();
        WebElement License2 = ttbTestContext.findElement(OneAppElementKeys.LICENSE_2);
        String elLicense2 = License2.getText();
        WebElement License2No = ttbTestContext.findElement(OneAppElementKeys.LICENSE_NUMBER_2);
        String elLicense2No = License2No.getText();
        WebElement ShowMore = ttbTestContext.findElement(OneAppElementKeys.SHOW_MORE_BUTTON_PWA);
        String elShowMore = ShowMore.getText();
        WebElement SendEmail = ttbTestContext.findElement(OneAppElementKeys.EMAIL_BUTTON_PWA);
        String elSendEmail = SendEmail.getText();
        WebElement CallAdvisor = ttbTestContext.findElement(OneAppElementKeys.CALL_PHONE_BUTTON_PWA);
        String elCallAdvisor = CallAdvisor.getText();
        WebElement Note1 = ttbTestContext.findElement(OneAppElementKeys.BUSINESS_HOUR);
        String elNote1 = Note1.getText();
        WebElement Note2 = ttbTestContext.findElement(OneAppElementKeys.EXPECT_PUBLIC_HOLIDAY);
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

//        if(false){
//            parentReport = extent.createTest("TS_ONEAPP_4516_EN", "TS_ONEAPP_4516_EN");
//        }
//        childReport = parentReport.createNode("Validate a display of Personal Wealth Advisor screen during business hours\n" +
//                "- Device: Android\n" +
//                "- If Advisor has 4 related licenses\n" +
//                "Click at Show more\n" +
//                "Click at Show less");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system should display Personal Wealth Advisor screen in business hours 08:00- 18:00 as the following details (Check coppyright with Ziplin current version.)\n" +
//                "1.1. Display <. When click < the system should display the previous screen.\n" +
//                "1.2. Display Text title\n" +
//                "1.3. Display Picture\n" +
//                "1.4. Display Name value\n" +
//                "1.5. Display Text title expertise\n" +
//                "1.6. Display Text Expertise\n" +
//                "1.7. Display Icon\n" +
//                "1.8. Display License value correctly based on PWA ID\n" +
//                "1.9. Display License number value correctly based on PWA ID\n" +
//                "1.10. Display Text Show more. When click Show more the system display more information.\n" +
//                "1.11. Display Text Business hours\n" +
//                "1.12. Display Send e-mail button\n" +
//                "1.13. Display Call Advisor button\n" +
//                "1.14. Display Text detail license\n" +
//                "1.15. Display Text Show Less. When click less more the system display less information.</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display My advisor button in customer service page.</pre>\n" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        ShowMore.click();
        WebElement License3 = ttbTestContext.findElement(OneAppElementKeys.LICENSE_3);
        String elLicense3 = License3.getText();
        WebElement License3No = ttbTestContext.findElement(OneAppElementKeys.LICENSE_NUMBER_3);
        String elLicense3No = License3No.getText();
        WebElement PersonalAdviser = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERSONAL_WEALTH_ADVISOR);
        String elPersonalAdviser = PersonalAdviser.getText();
        WebElement AdvisorDetail1 = ttbTestContext.findElement(OneAppElementKeys.ADVISOR_1);
        String elAdvisorDetail1 = AdvisorDetail1.getText();
        WebElement AdvisorDetail2 = ttbTestContext.findElement(OneAppElementKeys.ADVISOR_2);
        String elAdvisorDetail2 = AdvisorDetail2.getText();
        WebElement AdvisorDetail3 = ttbTestContext.findElement(OneAppElementKeys.ADVISOR_3);
        String elAdvisorDetail3 = AdvisorDetail3.getText();
        WebElement ShowLess = ttbTestContext.findElement(OneAppElementKeys.SHOW_MORE_BUTTON_PWA);
        String elShowLess = ShowLess.getText();
        System.err.println("get elLicense3 : " + elLicense3);
        System.err.println("get elLicense3No : " + elLicense3No);
        System.err.println("get elPersonalAdviser : " + elPersonalAdviser);
        System.err.println("get elAdvisorDetail1 : " + elAdvisorDetail1);
        System.err.println("get elAdvisorDetail2 : " + elAdvisorDetail2);
        System.err.println("get elAdvisorDetail3 : " + elAdvisorDetail3);
        System.err.println("get elShowLess : " + elShowLess);
//        childReport.log(Status.INFO, "<pre>Actual result : Display Text title : " + TextColor.blueColor(elHeader)
//                + "</br>Display Name value : " + TextColor.blueColor(elNameAdvisor)
//                + "</br>Display Text title expertise : " + TextColor.blueColor(elExpertise)
//                + "</br>Display Text Expertise : " + TextColor.blueColor(elExpertiseDetail)
//                + "</br>Display License value correctly based on PWA ID : " + TextColor.blueColor(elLicense1)
//                + "</br>Display License value correctly based on PWA ID : " + TextColor.blueColor(elLicense2)
//                + "</br>Display License number value correctly based on PWA ID : " + TextColor.blueColor(elLicense2No)
//                + "</br>Display License value correctly based on PWA ID : " + TextColor.blueColor(elLicense3)
//                + "</br>Display License number value correctly based on PWA ID : " + TextColor.blueColor(elLicense3No)
//                + "</br>Display License value correctly based on PWA ID : " + TextColor.blueColor(elLicense4)
//                + "</br>Display License number value correctly based on PWA ID : " + TextColor.blueColor(elLicense4No)
//                + "</br>Display Text Title Personal Wealth Advisor. : " + TextColor.blueColor(elPersonalAdviser)
//                + "</br>                                                                                    " + TextColor.blueColor(elAdvisorDetail1)
//                + "</br>Display Text Show more. When click Show more the system display more information. : " + TextColor.blueColor(elAdvisorDetail2)
//                + "</br>                                                                                    " + TextColor.blueColor(elAdvisorDetail3)
//                + "</br>Display Send e-mail button : " + TextColor.blueColor(elSendEmail)
//                + "</br>Display Call Advisor button : " + TextColor.blueColor(elCallAdvisor)
//                + "</br>Display Text Show Less. When click less more the system display less information. : " + TextColor.blueColor(elShowLess)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display My advisor button in customer service page.</pre>\n" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        System.err.println("TEST ERROR : " + JsonDataAdvisorInfoUI.get("full_name_en"));

        Assert.assertTrue(elHeader.equals("Private Wealth Advisor"));
        Assert.assertTrue(elExpertise.equals("Expertise"));
        Assert.assertTrue(elExpertiseDetail.equals("investment, financial planning"));
        Assert.assertTrue(elShowMore.equals("Show More"));
        Assert.assertTrue(elSendEmail.equals("Send E-mail"));
        Assert.assertTrue(elPersonalAdviser.equals("Private Wealth Advisor"));
        Assert.assertTrue(elAdvisorDetail1.equals("Provide financial management and portfolio management consulting services, planning services, and recommendations from fund management companies around the world."));
        Assert.assertTrue(elAdvisorDetail2.equals("Proactive portfolio monitoring to avoid customers missing important opportunities."));
        Assert.assertTrue(elAdvisorDetail3.equals("Updates on the economic and investment situation with analysis from a team of experts both in Thailand and abroad. We recommend the right products and services according to different requirements of each customer"));
        Assert.assertTrue(elNote1.equals("Business Hour : Mon-Fri / 8:00-18:00"));
        Assert.assertTrue(elNote2.equals("except public holiday"));
        Assert.assertTrue(elNameAdvisor.equals(response.getData().advisor_full_name_en));
        Assert.assertTrue(elLicense1.equals(response.getData().advisor_license.get(0).license_value_en));
        Assert.assertTrue(elLicense2.equals(response.getData().advisor_license.get(1).license_value_en));
        Assert.assertTrue(elLicense2No.equals("License no. " + response.getData().advisor_license.get(1).license_number));
        Assert.assertTrue(elLicense3.equals(response.getData().advisor_license.get(2).license_value_en));
        Assert.assertTrue(elLicense3No.equals("License no. " + response.getData().advisor_license.get(2).license_number));
        Assert.assertTrue(elNameAdvisor.equals(response.getData().advisor_full_name_en));

        if(response.getData().within_working_hours) {
            Assert.assertTrue(elCallAdvisor.equals("Call Advisor"));
        }else {
            Assert.assertTrue(elCallAdvisor.equals("Leave Note"));
            TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00004();
            TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00005();
            TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00006();
            TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00007();
        }
    }

    @Test(groups = "PWA My Advisor Leave Note", dependsOnGroups = {"PWA My Advisor Detail"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00004() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement CallAdvisor = ttbTestContext.findElement(OneAppElementKeys.CALL_PHONE_BUTTON_PWA);
        CallAdvisor.click();
        WebElement placeholderTextArea = ttbTestContext.findElement(OneAppElementKeys.TEXT_PLEACEHOLDER_LEAVE_NOTE);
        String elPlaceholderTextArea = placeholderTextArea.getText();
        System.err.println("elPlaceholderTextArea : " + elPlaceholderTextArea);
        WebElement BtnClose = ttbTestContext.findElement(OneAppElementKeys.CLOSE_BUTTON_CLOSE_POPUP_LEAVE_NOTE);
        BtnClose.click();
        CallAdvisor.click();
        Thread.sleep(5000);
        WebElement textArea = ttbTestContext.findElement(OneAppElementKeys.TEXT_AREA_LEAVE_NOTE);
//        tap(ttbTestContext.findElement(OneAppElementKeys.TEXT_PLEACEHOLDER_LEAVE_NOTE));
//        ttbTestContext.setContextToWebView(OneAppElementKeys.SEND_MESSAGE_BUTTON_LEAVE_NOTE, true);
//        textArea.click();
//        textArea.click();
//        ttbTestContext.getDriver().getKeyboard().sendKeys("Test Note Krub");
        textArea.sendKeys("Test Note Krub");
        textArea.click();
        ttbTestContext.findElement(OneAppElementKeys.TEXT_AREA_LEAVE_NOTE).click();
        ttbTestContext.findElement(OneAppElementKeys.TEXT_PLEACEHOLDER_LEAVE_NOTE).click();
        ttbTestContext.findElement(OneAppElementKeys.TEXT_PLEACEHOLDER_LEAVE_NOTE).click();
        WebElement BtnSendMessage = ttbTestContext.findElement(OneAppElementKeys.SEND_MESSAGE_BUTTON_LEAVE_NOTE);
        BtnSendMessage.click();
//        if(response.getData().within_working_hours){
//            CallAdvisor.click();
//        }
    }

    @Test(groups = "PWA My Advisor Leave Note Successful", dependsOnGroups = {"PWA My Advisor Leave Note"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00005() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement titleLeaveNoteSuccessful = ttbTestContext.findElement(OneAppElementKeys.TITLE_LEAVE_NOTE_SUCCESSFUL);
        String elTitleLeaveNoteSuccessful = titleLeaveNoteSuccessful.getText();
        WebElement detailLeaveNoteSuccessful = ttbTestContext.findElement(OneAppElementKeys.DETAIL_LEAVE_NOTE_SUCCESSFUL);
        String elDetailLeaveNoteSuccessful = detailLeaveNoteSuccessful.getText();
        WebElement labelTransaction = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_DATE_LEAVE_NOTE_SUCCESSFUL);
        String elLabelTransaction = labelTransaction.getText();
        WebElement transactionValue = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_VALUE_LEAVE_NOTE_SUCCESSFUL);
        String elTransactionValue = transactionValue.getText();
        WebElement labelCaseID = ttbTestContext.findElement(OneAppElementKeys.LABEL_CASE_ID_LEAVE_NOTE_SUCCESSFUL);
        String elLabelCaseID = labelCaseID.getText();
        WebElement caseIdValue = ttbTestContext.findElement(OneAppElementKeys.CASE_ID_VALUE_LEAVE_NOTE_SUCCESSFUL);
        String elCaseIdValue = caseIdValue.getText();
        CaseID = elCaseIdValue.substring(8, 16);
        TransactionDate = elTransactionValue.substring(0, 9);
        System.err.println("elTitleLeaveNoteSuccessful : " + elTitleLeaveNoteSuccessful);
        System.err.println("elDetailLeaveNoteSuccessful : " + elDetailLeaveNoteSuccessful);
        System.err.println("elLabelTransaction : " + elLabelTransaction);
        System.err.println("elTransactionValue : " + elTransactionValue);
        System.err.println("elLabelCaseID : " + elLabelCaseID);
        System.err.println("elCaseIdValue : " + elCaseIdValue);
        System.err.println("CaseID : " + CaseID);
        System.err.println("TransactionDate : " + TransactionDate);
        WebElement BtnBackService = ttbTestContext.findElement(OneAppElementKeys.BACK_SERVICE_PAGE_LEAVE_NOTE_SUCCESSFUL);
        BtnBackService.click();
    }

    @Test(groups = "Check case tracking note PWA", dependsOnGroups = {"PWA My Advisor Leave Note Successful"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00006() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement tabStatusTracking = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        tabStatusTracking.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cs_case_case_tracking_label_id")));
        WebElement caseTracking = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        caseTracking.click();
        try {
            WebElement startTutorial = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING);
            startTutorial.click();
        } catch (Exception e){}
        for(int i = 0; i < 10; i++){
            WebElement caseID = ttbTestContext.findElement(OneAppElementKeys.REF_NO_CASE_TRACKING_LIST_SCREEN_1);
            String elCaseID = caseID.getText().replace("Case ID. ", "");
            if(elCaseID.equals(CaseID)){
                WebElement labelIssue = ttbTestContext.findElement(OneAppElementKeys.LABEL_ISSUE_CASE_TRACKING_LIST_SCREEN_1);
                String elLabelIssue = labelIssue.getText();
                WebElement issueValue = ttbTestContext.findElement(OneAppElementKeys.ISSUE_CASE_TRACKING_LIST_SCREEN_1);
                String elIssueValue = issueValue.getText();
                WebElement status = ttbTestContext.findElement(OneAppElementKeys.STATUS_CASE_TRACKING_LIST_SCREEN_1);
                String elStatus = status.getText();
                System.err.println("elCaseID : " + elCaseID);
                System.err.println("elLabelIssue : " + elLabelIssue);
                System.err.println("elIssueValue : " + elIssueValue);
                System.err.println("elStatus : " + elStatus);
                Assert.assertTrue(elCaseID.equals(CaseID));
                Assert.assertTrue(elLabelIssue.equals("Issue"));
                Assert.assertTrue(elIssueValue.equals("Message to PWA"));
                Assert.assertTrue(elStatus.equals("In progress"));
                labelIssue.click();
                break;
            }else {
                WebElement BackBtn = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN);
                BackBtn.click();
                (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_case_case_tracking_label_id']")));
                WebElement caseTrackingService = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
                caseTrackingService.click();
            }
        }
    }

    @Test(groups = "Case tracking note PWA Detail", dependsOnGroups = {"Check case tracking note PWA"})
    public void TS_ONEAPP_8266_EN_PWA_BUSI_HRS_SIT_00007() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement caseID = ttbTestContext.findElement(OneAppElementKeys.REF_NO_CASE_TRACKING_DETAIL_SCREEN);
        String elCaseID = caseID.getText().replace("Case ID. ", "");
        WebElement labelIssue = ttbTestContext.findElement(OneAppElementKeys.LABEL_ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelIssue = labelIssue.getText();
        WebElement issueValue = ttbTestContext.findElement(OneAppElementKeys.ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elIssueValue = issueValue.getText();
        WebElement productService = ttbTestContext.findElement(OneAppElementKeys.LABEL_PRODUCT_SERVICE_CASE_TRACKING_DETAIL_SCREEN);
        String elProductService = productService.getText();
        WebElement productServiceValue = ttbTestContext.findElement(OneAppElementKeys.PRODUCT_SERVICE_VALUE_CASE_TRACKING_DETAIL_SCREEN);
        String elProductServiceValue = productServiceValue.getText();
        WebElement labelIssueDate = ttbTestContext.findElement(OneAppElementKeys.LABEL_DATE_START_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelIssueDate = labelIssueDate.getText();
        WebElement issueDate = ttbTestContext.findElement(OneAppElementKeys.DATE_START_CASE_TRACKING_DETAIL_SCREEN);
        String elIssueDate = issueDate.getText();
        WebElement labelDateFinish = ttbTestContext.findElement(OneAppElementKeys.LABEL_DATE_FINISH_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelDateFinish = labelDateFinish.getText();
        WebElement DateFinish = ttbTestContext.findElement(OneAppElementKeys.DATE_FINISH_CASE_TRACKING_DETAIL_SCREEN);
        String elDateFinish = DateFinish.getText();
        System.err.println("elCaseID : " + elCaseID);
        System.err.println("elLabelIssue : " + elLabelIssue);
        System.err.println("elIssueValue : " + elIssueValue);
        System.err.println("elProductService : " + elProductService);
        System.err.println("elProductServiceValue : " + elProductServiceValue);
        System.err.println("elLabelIssueDate : " + elLabelIssueDate);
        System.err.println("elIssueDate : " + elIssueDate);
        System.err.println("elLabelDateFinish : " + elLabelDateFinish);
        System.err.println("elDateFinish : " + elDateFinish);
        Assert.assertTrue(elCaseID.equals(CaseID));
        Assert.assertTrue(elLabelIssue.equals("Issue"));
        Assert.assertTrue(elIssueValue.equals("Message to PWA"));
        Assert.assertTrue(elProductService.equals("Product/Service"));
        Assert.assertTrue(elProductServiceValue.equals("Banking Service"));
        Assert.assertTrue(elLabelIssueDate.equals("Issue date"));
        Assert.assertTrue(elIssueDate.equals(TransactionDate));
        Assert.assertTrue(elLabelDateFinish.equals("Expected finish date"));
        Assert.assertTrue(elDateFinish.equals("-"));
    }

//    public static void swipeWebview(WebElement el1, WebElement el2) {
//        Point p1 = el1.getLocation();
//        Point p2 = el2.getLocation();
////        setNative();
//        new TouchAction<>(driver).longPress(PointOption.point(p1))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//                .moveTo(PointOption.point(p2))
//                .perform();
//    }
}
