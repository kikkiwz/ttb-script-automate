package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
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

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_4522_TH extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}


    @Test(priority = 0)
    public void TC_ONEAPP_4524_EN_CaseTracking_SIT_00003() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(com.tmb.automation.test.customerservice.sprint17.Base.driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
        MobileElement btnCST = com.tmb.automation.test.customerservice.sprint17.Base.driver.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='cs_case-status-tracking-title-label-no-eligible-id']")));

        MobileElement CaseStatusTrackingHeader = (MobileElement) com.tmb.automation.test.customerservice.sprint17.Base.driver.findElementByXPath("//*[@resource-id='cs_case-status-tracking-title-label-no-eligible-id']");
        String elCaseStatusTrackingHeader = CaseStatusTrackingHeader.getText();
        MobileElement NoEligibleACC = (MobileElement) com.tmb.automation.test.customerservice.sprint17.Base.driver.findElementByXPath("//*[@resource='cs_case-status-tracking-label-no-eligible-id']");
        String elNoEligibleACC = NoEligibleACC.getText();
        System.err.println("get element : " + elCaseStatusTrackingHeader);
        System.err.println("get element : " + elNoEligibleACC);     
        Assert.assertTrue(elCaseStatusTrackingHeader.equals("ติดตามสถานะคำขอ/คำร้อง"));
        Assert.assertTrue(elNoEligibleACC.equals("คุณไม่มีคำขอ/คำร้อง"));
    }
}
