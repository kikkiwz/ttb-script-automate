package com.tmb.automation.util;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidLibrary {
	private AppiumDriver<WebElement> driver;
	private static int DEFAULT_WAIT_TIME = 10;
	public AndroidLibrary(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME)), this);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void setText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void waitVisible(WebElement element, int second) {
		Log.logger.debug("WaitVisible "+second+" s");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOf(element));
	}
	public void waitVisible(WebElement element) {
		waitVisible(element, 20);
	}
	
	public void assertText(String act, String exp) {
		Log.logger.debug("["+act.replaceAll("(\\r|\\n|\\t)", "").trim()+"] == ["+exp.replaceAll("(\\r|\\n|\\t)", "").trim()+"] > "+(act.replaceAll("(\\r|\\n|\\t)", "").trim().equalsIgnoreCase(exp.replaceAll("(\\r|\\n|\\t)", "").trim())));
		Assert.assertEquals(act.replaceAll("(\\r|\\n|\\t)", "").trim(), exp.replaceAll("(\\r|\\n|\\t)", "").trim());
	}
	public void assertTrue(String strBoolean) {
		Log.logger.debug("Assert Boolean="+strBoolean);
		Assert.assertTrue(Boolean.parseBoolean(strBoolean));
	}
	
	public void printPageSource() {
		Log.logger.debug(driver.getPageSource());
	}
	
	public void setContextIndex(int index) {
		Set<String> contextNames = driver.getContextHandles();
		int i=0;
		for (String contextName : contextNames) {
			Log.logger.debug(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		    if (i==index) {
				Log.logger.debug("change context to "+(String) contextNames.toArray()[1]);
				driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1
				break;
		    }
		    i++;
		}
	}
	public void setContextIndex(String webViewName) {
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			Log.logger.debug(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		    if (webViewName.contains(contextName)) {
				Log.logger.debug("change context to "+(String) contextNames.toArray()[1]);
				driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1
				break;
		    }
		}
	}
	
}
