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

import static com.tmb.automation.api.customerservice.sprint18.ApplicationStatusTracking.AST;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenOtherASTEntryPoint;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scroll;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class TC_ONEAPP_4518_EN extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}
    @Test(priority = 0)
    public void TS_ONEAPP_4518_EN_ASTEntryPoint_SIT_00001() throws Exception {
        OpenOtherASTEntryPoint();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_title_tutorial_id']")));

        MobileElement TutorialAST = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_title_tutorial_id']");
        String elTutorialAST = TutorialAST.getText();
        MobileElement DetailTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_desc_tutorial_id']");
        String elDetailTutorial = DetailTutorial.getText();
        MobileElement BtnStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_btn_start_tutorail_id']");
        String elBtnStart = BtnStart.getText();
        System.err.println("get element : " + elTutorialAST);
        System.err.println("get element : " + elDetailTutorial);
        System.err.println("get element : " + elBtnStart);

        Assert.assertTrue(elTutorialAST.equals("Application Tracking"));
        Assert.assertTrue(elDetailTutorial.equals("Allows you to check status of your loan application anywhere anytime."));
        BtnStart.click();

    }

    @Test(priority = 1)
    public void TS_ONEAPP_4518_EN_ASTEntryPoint_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));

        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
        String elASTHeader = ASTHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
        String elSectionInprogress = SectionInprogress.getText();
        System.err.println("get element : " + elSectionInprogress);

          Assert.assertTrue(elASTHeader.equals("Application Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));

    }
}
