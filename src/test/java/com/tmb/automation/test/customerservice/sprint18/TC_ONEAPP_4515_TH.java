package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;

import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.util.Base;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_4515_TH extends  Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}
	

    @Test(priority = 0)
    public void TC_ONEAPP_4524_TH_CaseTracking_SIT_00003() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-application-tracking']")));
        MobileElement btnAST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-application-tracking']"));
        btnAST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_title_label_for_no_eligible_id']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_title_label_for_no_eligible_id']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_no_eligible_id']");
        String elSectionInprogress = SectionInprogress.getText();
        System.err.println("get element : " + elCaseStatusTrackingHeader);
        System.err.println("get element : " + elSectionInprogress);

        Assert.assertTrue(elCaseStatusTrackingHeader.equals("ติดตามสถานะการสมัคร"));
        Assert.assertTrue(elSectionInprogress.equals("คุณไม่มียังไม่มีรายการสมัครใช้ผลิตภัณฑ์และบริการของทีทีบี"));
    }
}
