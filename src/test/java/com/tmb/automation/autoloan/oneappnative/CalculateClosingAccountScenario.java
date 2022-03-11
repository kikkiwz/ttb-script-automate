package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;

import java.io.IOException;

public class CalculateClosingAccountScenario extends ServiceRequestListScenario {
    @Test(groups = "Closing Account" ,dependsOnGroups = "serviceRequest")
    public void closingAccount() throws InterruptedException, IOException {
        ExtentTest  scenario = feature.createNode(Scenario.class, "ClosingAccount");
        Thread.sleep(3000);
        enterClosingAccount();
        String ClosingAccount = "image/closing_account_screen"+getPlatform()+".png";
        Thread.sleep(3000);
        takeScreenshot(ClosingAccount);
        scenario.createNode(Given.class,"Open Close Account service").addScreenCaptureFromPath(ClosingAccount).pass("pass");
        openTapCalculateCloseAccount();
        String calulatetap = "image/calculate_tep"+getPlatform()+".png";
        Thread.sleep(3000);
        takeScreenshot(calulatetap);
        scenario.createNode(Given.class,"Calculate for close account").addScreenCaptureFromPath(calulatetap).pass("pass");
        openCalendar();
        String calendar = "image/calendar"+getPlatform()+"png";
        takeScreenshot(calendar);
        scenario.createNode(Given.class,"Calendar is displaying").addScreenCaptureFromPath(calendar).pass("pass");
        selectCalInvalidDate();
        Thread.sleep(3000);
        String PopupinvalidDate = "image/Popup_warning_invalid_date"+getPlatform()+".png";
        takeScreenshot(PopupinvalidDate);
        scenario.createNode(Given.class,"Waring popup is displaying").addScreenCaptureFromPath(PopupinvalidDate).pass("pass");
        closeWarningPopupInvalidDate();
        String warningMassage = "image/Warning_invalid_Date"+getPlatform()+".png";
        takeScreenshot(warningMassage);
        scenario.createNode(Given.class,"Warning Message for select invalid date is displaying").addScreenCaptureFromPath(warningMassage).pass("pass");
        openCalendar();
        Thread.sleep(3000);
        String CalendarOpen = "image/calendar_open"+getPlatform()+".png";
        takeScreenshot(CalendarOpen);
        scenario.createNode(Given.class,"Open calendar").addScreenCaptureFromPath(CalendarOpen).pass("pass");
        selectCalValidDate();
        Thread.sleep(3000);
        String ValidDate = "image/valid_date"+getPlatform()+".png";
        takeScreenshot(ValidDate);
        scenario.createNode(Given.class,"Select valid date and Calculate for close account correctly").addScreenCaptureFromPath(ValidDate).pass("pass");
        extent.flush();

    }
}
