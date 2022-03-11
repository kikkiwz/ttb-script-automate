package com.ttbbank.oneapp.framework.utils.pb1;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class PB1Method extends BaseScenario{
	
	public void ActiveOneAppPB1() throws InterruptedException {
        System.out.println("Activation Start... ");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
        ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_REGISTER_TTB);
        ttbTestContext.findElement(OneAppElementKeys.PB1_REGISTER_TTB).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_ACCEPT_T_AND_C).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_T_AND_C_NEXT).click();
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        System.out.println("citizenId is-- : " + citizenId);
        ttbTestContext.findElement(OneAppElementKeys.PB1_INPUT_CID).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_INPUT_CID).sendKeys(citizenId);
        ttbTestContext.findElement(OneAppElementKeys.PB1_ENTER_CID_NEXT).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_ENTER_PIN_TITLE);
        String PinTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_ENTER_PIN_TITLE).getText();
        System.out.println("PinTitle-- " + PinTitle);
        enterPin();
        Thread.sleep(4000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_OTP_HEADER);
        System.out.println("OTP Ref-- " + ttbTestContext.findElement(OneAppElementKeys.PB1_OTP_REF).getText());
        ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
        ttbTestContext.findElement(OneAppElementKeys.PB1_ACTIVATE_NEXT_EN).click();
        if (ttbTestContext.isIos()) {
            try {
                ttbTestContext.findElement(OneAppElementKeys.PB1_KEYPAD_ALLOW).click();
            } catch (Exception e) {
                System.out.println("KeyPad Already Accepted");
            }
        }
        ttbTestContext.findElement(OneAppElementKeys.PB1_HOME_INTRO_NEXT).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_HOME_INTRO_NEXT).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_HOME_INTRO_NEXT).click();
        return;
    }

    public void ThaiLanguage() throws InterruptedException {
    	ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		String Language = ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).getText();
		System.out.println("--Language-- " +Language);
		if (Language.equals("ตั้งค่า")) {
			System.out.println("---Thai Language set Already--- ");
			ttbTestContext.findElement(OneAppElementKeys.PB1_HOME).click();
		} else {
		ttbTestContext.findElement(OneAppElementKeys.PB1_MORE).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_SETTING).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_PERSONAL_INFORMATION);
		Thread.sleep(2000);
		if (ttbTestContext.isAndroid()) {
			scrollToBottom();
			Thread.sleep(1000);
			scrollToBottom();
			Thread.sleep(1000);
			scrollToBottom();
			ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE).click();
		} else {
			ttbTestContext.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value='Language']")).click();
			JavascriptExecutor js = (JavascriptExecutor) ttbTestContext.getDriver();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		}
		Thread.sleep(2000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE_TH).click();
		Thread.sleep(5000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE_BACK).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_SETTING_BACK).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_HOME).click();
		System.out.println("--Language changed to Thai--");
		}
	}
    
    public void EnglishLanguage() throws InterruptedException {
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		String Language = ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).getText();
		System.out.println("--Language-- " +Language);
		if (Language.equals("Withdraw")) {
			System.out.println("---English Language set Already--- ");
			ttbTestContext.findElement(OneAppElementKeys.PB1_HOME).click();
		} else {
		ttbTestContext.findElement(OneAppElementKeys.PB1_MORE).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_SETTING).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_PERSONAL_INFORMATION);
		Thread.sleep(2000);
		if (ttbTestContext.isAndroid()) {
			scrollToBottom();
			Thread.sleep(1000);
			scrollToBottom();
			Thread.sleep(1000);
			scrollToBottom();
			ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE).click();
		} else {
			ttbTestContext.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value='ภาษา']")).click();
			JavascriptExecutor js = (JavascriptExecutor) ttbTestContext.getDriver();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		}
		Thread.sleep(2000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE_EN).click();
		Thread.sleep(5000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_LANGUAGE_BACK).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_SETTING_BACK).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_HOME).click();
		System.out.println("--Language changed to English--");
		}
	}
    
    
}
