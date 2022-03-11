package com.tmb.automation.pages.platform1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoadingPage extends AppiumLibrary {

	
	public final String saImgLoading_logo = "//android.widget.ImageView[@resource-id=\'com.ttbbank.oneapp.vit:id/image_logo_splash\']";
	public final String siImgLoading_logo = "";
	
	public final String saTxtLoading_msg = "//android.widget.TextView[@resource-id=\'com.ttbbank.oneapp.vit:id/txt_loading_status\']";
	public final String siTxtLoading_msg = "";

	
	public LoadingPage(AppiumDriver<WebElement> driver) {
		super((AppiumDriver<WebElement>) driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
//	public void skipSplashScreen() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		if (isElementPresent(saBtnClosePendo)) {
//			Log.logger.debug("click Close Pend button");
//			click(fXpath(saBtnClosePendo));
//		}
//		Log.logger.debug("Before - check close PIN pad");
//		Helper.writeLog(getPageSource());
//		if (isElementPresent("//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']")) {
//			Log.logger.debug("Click close PIN Lock");
//			click(fXpath("//android.widget.ImageButton[@resource-id=\'com.ttbbank.oneapp.vit:id/close_pin_pad\']"));
//		}
//		Log.logger.debug("After - check close PIN pad");
//	}

}
