package com.tmb.automation.pages.platform1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomeScreenPage extends AppiumLibrary {
	
	//Welcome Screen
	public final String saBtnSkip = "//android.widget.LinearLayout[@resource-id=\'com.kone.TMB:id/action_bar_root\']";
	public final String siBtnSkip = "";
	
	public final String saLbTitle = "//android.widget.TextView[@resource-id=\'com.kone.TMB:id/text_text\']";
	public final String siLbTitle = "";
	
	public final String saLbDesc1 = "//android.widget.TextView[@resource-id=\'com.kone.TMB:id/text_text_today_title\']";
	public final String siLbDesc1 = "";
	
	public final String saLbDesc2 = "//android.widget.TextView[@resource-id=\'com.kone.TMB:id/text_text_today_body\']";
	public final String siLbDesc2 = "";
	
	public final String saBtnNext = "//android.widget.Button[@resource-id=\'com.kone.TMB:id/set_new_pin\']";
	public final String siBtnNext = "";
	
	public final String siLbPagename = "//XCUIElementTypeOther[@name=\'Welcome Screen\']";
	
	
	public WelcomeScreenPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		alertAction("accept");
	}

}
