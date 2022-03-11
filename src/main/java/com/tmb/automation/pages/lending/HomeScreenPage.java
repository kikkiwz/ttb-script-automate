package com.tmb.automation.pages.lending;

import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeScreenPage extends AppiumLibrary {
	//Homescreen
	public final String swImgHS_Robot = "//img[@id='home-screen-robot-image']";
	public final String siHS_Home_btn = "//XCUIElementTypeButton[@name=\'Home\']";
	public final String saHS_Home_btn = "(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[1]";

	public final String siHS_Account_btn = "//XCUIElementTypeButton[@name=\'Account\']";
	public final String saHS_Account_btn = "(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[2]";

	public final String siHS_Service_btn = "//XCUIElementTypeButton[@name=\'Service\']";
	public final String saHS_Service_btn = "(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[3]";

	public final String siHS_Discovery_btn = "//XCUIElementTypeButton[@name=\'More\']";
	public final String saHS_Discovery_btn = "(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[4]";

	public final String saBtnHS_Pin1 = "//android.widget.TextView[contains(@resource-id, \'key_01\')]";
	public final String siBtnHS_Pin1 = "//XCUIElementTypeButton[@label=\'1\']";

	public HomeScreenPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
