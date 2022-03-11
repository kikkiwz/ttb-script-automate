package com.tmb.automation.test.customerservice.sprint17;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenOneApp;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_2710_EN extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 0)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-tutorial-header-label']")));
        MobileElement HeaderText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-header-label']");
        String elHeaderText = HeaderText.getText();
        MobileElement PassBookTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-desc-label']");
        String elPassBookTutorial = PassBookTutorial.getText();
        MobileElement Start = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-button-footer']");
        String elStart = Start.getText();

        
        Assert.assertTrue(elHeaderText.equals("Passbook"));
        Assert.assertTrue(elPassBookTutorial.equals("You can view the passbook at any time, ready to download or share with friends or partners.Free! No additional cost."));
        Assert.assertTrue(elStart.equals("Start"));
    }

    @Test(priority = 1)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_00003() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));

        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-tutorial-header-label']")));
        MobileElement HeaderText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-header-label']");
        String elHeaderText = HeaderText.getText();
        MobileElement PassBookTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-desc-label']");
        String elPassBookTutorial = PassBookTutorial.getText();
        MobileElement Start = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-button-footer']");
        String elStart = Start.getText();

             Assert.assertTrue(elHeaderText.equals("Passbook"));
        Assert.assertTrue(elPassBookTutorial.equals("You can view the passbook at any time, ready to download or share with friends or partners.Free! No additional cost."));
        Assert.assertTrue(elStart.equals("Start"));
    }

    @Test(priority = 2)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_00004() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));

        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-tutorial-button-footer']")));
        MobileElement PassBookTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-desc-label']");
        String elPassBookTutorial = PassBookTutorial.getText();
        MobileElement Start = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-button-footer']");
        String elStart = Start.getText();

              Start.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
    }

    @Test(priority = 3)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_00005() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();

         Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
    }

    @Test(priority = 4)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_01001() throws Exception {
        OpenOneApp();
        Thread.sleep(3000);
        MobileElement service = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='1111']"));
        service.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-tutorial-desc-label']")));

        MobileElement HeaderText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-header-label']");
        String elHeaderText = HeaderText.getText();
        MobileElement PassBookTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-desc-label']");
        String elPassBookTutorial = PassBookTutorial.getText();
        MobileElement Start = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-button-footer']");
        String elStart = Start.getText();

           Assert.assertTrue(elHeaderText.equals("Passbook"));
        Assert.assertTrue(elPassBookTutorial.equals("You can view the passbook at any time, ready to download or share with friends or partners.Free! No additional cost."));
        Assert.assertTrue(elStart.equals("Start"));
    }

    @Test(priority = 5)
    public void TS_ONEAPP_2710_EN_VPSelectAcct_SIT_01003() throws Exception {
        OpenOneApp();
        Thread.sleep(3000);
             MobileElement service = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='1111']"));
        service.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));
        MobileElement AccountName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-name']");
        String elAccountName = AccountName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-no']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-branch-name']");
        String elBranchName = BranchName.getText();
        System.err.println("elAccountName : " + elAccountName);
        System.err.println("AccountNumber : " + AccountNumber);
        System.err.println("BranchName : " + BranchName);
        Assert.assertTrue(elAccountName.equals("นาย ฟาติเมาะห์ เซาะตีงู"));
        Assert.assertTrue(elAccountNumber.equals("100-2-16013-1"));
        Assert.assertTrue(elBranchName.equals("เซ็นทรัลพลาซา พระราม 9"));
    }
}
