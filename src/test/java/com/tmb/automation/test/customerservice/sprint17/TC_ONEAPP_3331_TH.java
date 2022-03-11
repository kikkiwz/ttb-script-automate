package com.tmb.automation.test.customerservice.sprint17;

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

public class TC_ONEAPP_3331_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}
    @Test(priority = 0)
    public void TC_ONEAPP_EN_3331_VPNoAcct_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-no-account-header-label']")));

        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-no-account-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement NoAccount = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='promptpay-no-account-desc-label']");
        String elNoAccount = NoAccount.getText();
        MobileElement OpenAccount = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-no-account-button-footer']");
        String elOpenAccount = OpenAccount.getText();
        System.err.println("get element : " + elPassBook);
        System.err.println("get element : " + elNoAccount);
        System.err.println("get element : " + elOpenAccount);

        
        Assert.assertTrue(elPassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(elNoAccount.equals("คุณยังไม่มีบัญชีเงินฝากกับทีทีบี"));
        Assert.assertTrue(elOpenAccount.equals("เปิดบัญชี"));
    }
}
