package com.tmb.automation.util;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import com.tmb.automation.pages.lending.ActivateCardPage;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumLibrary {
	private AppiumDriver<WebElement> driver;
	private static int DEFAULT_WAIT_TIME = 10;

	public AppiumLibrary(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME)), this);

	}

	public WebElement fId(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement fX(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public String fXPresent(String xpath) {
		return isElementPresentText(xpath);
	}
//	public WebElement fXpath(String xpathIOS, String xpathAndroid) {
//		WebElement el = null;
//		if (Base.getMobileOS().equalsIgnoreCase("ios")) {
//			el = driver.findElement(By.xpath(xpathIOS));
//		} else if (Base.getMobileOS().equalsIgnoreCase("android")) {
//			el = driver.findElement(By.xpath(xpathAndroid));
//		} else {
//			Log.logger.debug("Config.profile is not found!");
//		}
//		return el;
////		return driver.findElement(By.xpath(xpath));
//	}

	public WebElement fName(String name) {
		return driver.findElement(By.name(name));
	}

	public WebElement fClassName(String className) {
		return driver.findElement(By.className(className));
	}

	public WebElement fCss(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}

	public WebElement fTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public List<WebElement> fsId(String id) {
		return driver.findElements(By.id(id));
	}

	public List<WebElement> fsXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public List<WebElement> fsName(String name) {
		return driver.findElements(By.name(name));
	}

	public List<WebElement> fsClassName(String className) {
		return driver.findElements(By.className(className));
	}

	public List<WebElement> fsCss(String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}

	public List<WebElement> fsTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public void click(WebElement element) {
		element.click();
	}

	public void click(String xpath) {
		waitVisible(xpath,Integer.parseInt(Helper.getProperties("wait_visible_second")));
		fX(xpath).click();
	}

	public void setText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void setText2(WebElement element, String value) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.clear();
		element.sendKeys(value);
	}

	public void setTextOTP(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void setTextJS(WebElement element, String value) {
		element.clear();
		driver.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}


	public Boolean waitVisible(String xpath, int second) {
		Log.logger.debug("Wait visible "+ second +" "+xpath);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return true;
	}

	public Boolean waitVisible(String xpath) {
		return waitVisible(xpath, Integer.parseInt(Helper.getProperties("wait_visible_second")));
	}

	public Boolean waitInVisible(String xpath, int second) {
		Log.logger.debug("Waitvisible() " + second + "s");
		(new WebDriverWait(driver, second)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		return true;
	}

	public Boolean waitInVisible(String xpath) {
		return waitInVisible(xpath, Integer.parseInt(Helper.getProperties("wait_visible_second")));
	}

	public void waitAlert(int seconds) {
		(new WebDriverWait(driver, seconds)).until(ExpectedConditions.alertIsPresent());
	}

	public void assertText(String act, String exp) {
		Log.logger.debug("[" + act.trim() + "] == [" + exp.trim() + "] > " + (act.trim().equals(exp.trim())));
//		Assert.assertEquals(act.trim(), exp.trim());
	}
	public void assertText(String act, String exp, String msg) {
		Log.logger.debug("[" + act.trim() + "] == [" + exp.trim() + "] > " + (act.trim().equals(exp.trim())));
//		Assert.assertEquals(act.trim(), exp.trim());
	}

	public void assertTrue(Boolean value) {
		Log.logger.debug("Assert Boolean=[true]==[" + value + "]");
//		Assert.assertTrue(value);
	}

	public void assertTrue(String xpath) {
		Boolean bValue = isElementPresent(xpath);
		Log.logger.debug("Assert Boolean=" + bValue + ", xpath = " + xpath);
		Assert.assertTrue(bValue);
	}

	public void assertContain(String act, String exp) {
		Log.logger.debug("[" + act.trim() + "] contains [" + exp.trim() + "] > " + act.trim().contains(exp.trim()));
//		Assert.assertTrue(act.trim().contains(exp.trim()));
	}
	public void assertContain(String act, String exp, String msg) {
		Log.logger.debug("[" + act.trim() + "] contains [" + exp.trim() + "] > " + act.trim().contains(exp.trim()));
//		Assert.assertTrue(act.trim().contains(exp.trim()));
	}

	public boolean isElementPresent(String xpath) {
		try {
			if (driver.findElements(By.xpath(xpath)).size() > 0) {
				return true;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}
	public String isElementPresentText(String xpath) {
		try {
			if (driver.findElements(By.xpath(xpath)).size() > 0) {
				return driver.findElement(By.xpath(xpath)).getText();
			}
		} catch (NoSuchElementException e) {
			return "";
		}
		return "";
	}

	public void clickJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void clickJS(String xpath) {
		waitVisible(xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fX(xpath));
	}

	public void scrollIntoView(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollIntoView(String xpath) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fX(xpath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String printPageSource() {
		Log.logger.debug("pageSource()=" + driver.getPageSource());
		return driver.getPageSource();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void printContext() {
		Set<String> contextNames = driver.getContextHandles();
		Log.logger.debug(contextNames.size());
		for (String contextName : contextNames) {
			Log.logger.debug(contextName);
		}
	}

//	public void setContext(int index) {
//		Set<String> contextNames = driver.getContextHandles();
//		int i=0;
//		for (String contextName : contextNames) {
//			Log.logger.debug(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
//		    if (i==index) {
//				Log.logger.debug("change context to "+(String) contextNames.toArray()[1]);
//				driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1
//				break;
//		    }
//		    i++;
//		}
//	}
	public Boolean setContext(String value) {
		int i = 0;
		while (i++ < 10) {
			Set<String> contextNames = driver.getContextHandles();
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
						driver.context((String) contextName);
						System.out.println("");
						return true;
					}
				}
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
			}
		}
		return false;
	}
	public Boolean setContext(String value, int webIndex) {
		int i = 0;
		while (i++ < 10) {
			Set<String> contextNames = driver.getContextHandles();
			Log.logger.debug("list="+contextNames);
			if (contextNames.size() > 1) {
				for (String contextName : contextNames) {
					if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
						driver.context((String) contextName);
						WebDriver context = driver.context((String) contextName);
						Set<String> webNames = context.getWindowHandles();
						Log.logger.debug("WebNames list="+webNames);
						driver.switchTo().window(webNames.toArray()[webIndex].toString());
						System.out.println("");
						return true;
					}
				}
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(".");
			}
		}
		return false;
	}

	public Boolean setWebview() {
		return setContext("Webview");
	}

	public Boolean setWebview(int webIndex) {
		return setContext("Webview", webIndex);
	}

	public Boolean setNative() {
		return setContext("Native");
	}

	public void alertAction(String strAction) {
		int i = 0;
		while (i++ < 10) {
			try {
				Log.logger.debug("Alert message=" + String.valueOf(i) + ". " + driver.switchTo().alert().getText());
				if (strAction.equals("accept")) {
					Log.logger.debug("click Alert=accepted");
					driver.switchTo().alert().accept();
				} else if (strAction.equals("dismiss")) {
					Log.logger.debug("Click Alert=dismiss");
					driver.switchTo().alert().dismiss();
				}
			} catch (NoAlertPresentException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}
	public void writeLog() {
		Log.logger.debug("writeLog(...)");
		Helper.writeLog(driver.getPageSource());
	}

	public void EnterPin(String pinNumber) {
		ActivateCardPage la = new ActivateCardPage(driver);

		if (Base.getMobileOS().equalsIgnoreCase("ios")) {
			la.waitVisible(la.siBtnHS_Pin0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(la.siBtnHS_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(la.siBtnHS_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(la.siBtnHS_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(la.siBtnHS_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(la.siBtnHS_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(la.siBtnHS_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(la.siBtnHS_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(la.siBtnHS_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(la.siBtnHS_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(la.siBtnHS_Pin9).click();
				}
			}
		}else if (Base.getMobileOS().equalsIgnoreCase("android")) {
			la.waitVisible(la.saBtnHS_Pin0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(la.saBtnHS_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(la.saBtnHS_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(la.saBtnHS_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(la.saBtnHS_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(la.saBtnHS_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(la.saBtnHS_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(la.saBtnHS_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(la.saBtnHS_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(la.saBtnHS_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(la.saBtnHS_Pin9).click();
				}
			}
		}
	}

	public void EnterConfirmPin(String pinNumber) {
		ActivateCardPage la = new ActivateCardPage(driver);
		if (Base.getMobileOS().equalsIgnoreCase("ios")) {
			la.waitVisible(la.siBtnCF_Pin0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(la.siBtnCF_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(la.siBtnCF_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(la.siBtnCF_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(la.siBtnCF_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(la.siBtnCF_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(la.siBtnCF_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(la.siBtnCF_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(la.siBtnCF_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(la.siBtnCF_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(la.siBtnCF_Pin9).click();
				}
			}
		}else if (Base.getMobileOS().equalsIgnoreCase("android")) {
			la.waitVisible(la.saBtnCF_Pin0);
			for (int i = 0; i < pinNumber.length(); i++ ) {
				if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
					Log.logger.debug("Click 0");
					fX(la.saBtnCF_Pin0).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
					Log.logger.debug("Click 1");
					fX(la.saBtnCF_Pin1).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
					Log.logger.debug("Click 2");
					fX(la.saBtnCF_Pin2).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
					Log.logger.debug("Click 3");
					fX(la.saBtnCF_Pin3).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
					Log.logger.debug("Click 4");
					fX(la.saBtnCF_Pin4).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
					Log.logger.debug("Click 5");
					fX(la.saBtnCF_Pin5).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
					Log.logger.debug("Click 6");
					fX(la.saBtnCF_Pin6).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
					Log.logger.debug("Click 7");
					fX(la.saBtnCF_Pin7).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
					Log.logger.debug("Click 8");
					fX(la.saBtnCF_Pin8).click();
				} else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
					Log.logger.debug("Click 9");
					fX(la.saBtnCF_Pin9).click();
				}
			}
		}
	}

	public void touchAndMove(WebElement el1, WebElement el2) {
		String originalContext = driver.getContext();
		driver.context("NATIVE_APP");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(new ElementOption().withElement(el1))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(new ElementOption().withElement(el2))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
				.moveTo(PointOption.point(el2.getLocation()))
				.release().perform();
		driver.context(originalContext);
	}

	public static void SwipeScreen(WebElement el, WebDriver driver) throws InterruptedException {
		WebElement Panel = el;
		Dimension dimension = Panel.getSize();

		int Anchor = Panel.getSize().getHeight()/2;

		Double ScreenWidthStart = dimension.getWidth() * 0.8;
		int scrollStart = ScreenWidthStart.intValue();

		Double ScreenWidthEnd = dimension.getWidth() * 0.2;
		int scrollEnd = ScreenWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver)
				.press(PointOption.point(scrollStart, Anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(scrollEnd, Anchor))
				.release().perform();

		Thread.sleep(3000);
	}

	public void swipe(int startX, int startY, int endX, int endY) {
		try {
			new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		} catch (Exception e) {
			System.out.println("unable to swipe");
		}
	}
	public void tab(WebElement el){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(el.getLocation()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}
	public void tabXY(int startX, int startY){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.release().perform();
	}

	public void selectValue (WebElement el, String value){
		Select select = new Select(el);
		select.selectByValue(value);
	}
	public void selectValue(String xpath, String value){
		selectValue(fX(xpath), value);
	}
	public void selectIndex(WebElement el, int index){
		Select select = new Select((el));
		select.selectByIndex(index);
	}
	public void selectIndex(String xpath, int index){
		selectIndex(fX(xpath), index);
	}
}
