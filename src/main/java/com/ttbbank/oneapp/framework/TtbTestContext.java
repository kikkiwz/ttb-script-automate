package com.ttbbank.oneapp.framework;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class TtbTestContext {

	private final AppiumDriver<WebElement> driver;
	private final WebDriverWait wait;

	private final OneAppElements oneAppElements;

	public TtbTestContext(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 100);

		String platformName = driver.getPlatformName();
		if ("ios".equalsIgnoreCase(platformName)) {
			oneAppElements = new iOSOneAppElements();
		} else {
			oneAppElements = new AndroidOneAppElements();
		}
	}

	public String getPlateFormName() {

		return driver.getCapabilities().getCapability(DeviceProfile.platformName).toString().toLowerCase();
	}

	public WebDriverWait getWaiter() {
		return wait;
	}


	public WebElement findElement(String elementKey) {
		OneAppElement oneAppElement = oneAppElements.get(elementKey);
		By locator = oneAppElement.getLocator();
		waitUntilVisible(locator);
		return driver.findElement(locator);
	}

	public WebElement findElementByAccessibilityId(String elementKey) {
		OneAppElement oneAppElement = new OneAppElement(FindBy.ACCESSIBILITY_ID, elementKey);
		By locator = oneAppElement.getLocator();
		waitUntilVisible(locator);
		return driver.findElement(locator);
	}

	public WebElement findElementByXPATH(String elementKey) {
		OneAppElement oneAppElement = new OneAppElement(FindBy.XPATH, elementKey);
		By locator = oneAppElement.getLocator();
		waitUntilVisible(locator);
		return driver.findElement(locator);
	}

	public List<WebElement> viewElementByXPATH(String elementKey) {
		OneAppElement oneAppElement = new OneAppElement(FindBy.XPATH, elementKey);
		By locator = oneAppElement.getLocator();
		return driver.findElements(locator);
	}

    public List<WebElement> viewElementByAcessibilityId(String elementKey) {
        OneAppElement oneAppElement = new OneAppElement(FindBy.ACCESSIBILITY_ID, elementKey);
        By locator = oneAppElement.getLocator();
        return driver.findElements(locator);
    }

	public List<WebElement> findElements(String elementKey) {
		OneAppElement oneAppElement = oneAppElements.get(elementKey);
		By locator = oneAppElement.getLocator();
		waitUntilVisible(locator);
		return driver.findElements(locator);
	}

	public void waitUntilVisible(String elementKey) {
		OneAppElement oneAppElement = oneAppElements.get(elementKey);
		By locator = oneAppElement.getLocator();
		waitUntilVisible(locator);
	}

	public void waitUntilVisible(By locator) {
		Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
			driver.findElement(locator);
			return true;
		};
		wait.until(func);
	}

	//For normal case
	public WebDriver setContextToWebView(String element, boolean isWebView) {
		Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> driver.getContextHandles().size() > 1;
		wait.until(func);
		WebDriver Context = null;
		Set<String> contextNames = driver.getContextHandles();
		for (String conName : contextNames) {
			if ((!conName.equals("NATIVE_APP") && isWebView) || (conName.equals("NATIVE_APP") && !isWebView)) {
				try {
					System.err.println("conName : " + conName);
					Context = driver.context(conName);
					OneAppElement oneAppElement = oneAppElements.get(element);
					By locator = oneAppElement.getLocator();
					System.out.println(driver.findElement(locator).getText());
					break;
				} catch (Exception e) {
					System.err.println("is not match web view");
				}
			} else {
				System.out.println("is not Web View");
			}
		}
		return Context;
	}

	//for case log out iOS
	public String setContextToWebView(String element, boolean isWebView, ArrayList<String> currentContext) {
		Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> driver.getContextHandles().size() > 1;
		wait.until(func);

		String contextSet = "";
		Set<String> contextNames = new HashSet<String>(driver.getContextHandles());
		contextNames.removeAll(currentContext);
		for (String conName : contextNames) {
			if ((!conName.equals("NATIVE_APP") && isWebView) || (conName.equals("NATIVE_APP") && !isWebView)) {
				try {
					System.err.println("conName : " + conName);
					driver.context(conName);
					contextSet = conName;
					OneAppElement oneAppElement = oneAppElements.get(element);
					By locator = oneAppElement.getLocator();
					System.out.println(driver.findElement(locator).getText());
					break;
				} catch (Exception e) {
					System.err.println("is not match web view");
				}
			} else {
				System.out.println("is not Web View");
			}
		}
		return contextSet;
	}


	public List<WebElement> ViewElement(String elementKey) {
		OneAppElement oneAppElement = oneAppElements.get(elementKey);
		By locator = oneAppElement.getLocator();
		return driver.findElements(locator);
	}

	public void scrollUp() {
		Dimension dimension = driver.manage().window().getSize();
		Double scrollHeightStart = dimension.getHeight() * 0.8;
		int scrollEnd = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollStart = scrollHeightEnd.intValue();

		new TouchAction(driver).longPress(PointOption.point(0, scrollStart))
		.moveTo(PointOption.point(0, scrollEnd)).release()
		.perform();
	}


	public void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		Double scrollHeightStart = dimension.getHeight() * 0.8;
		int scrollStart = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();

		new TouchAction(driver).longPress(PointOption.point(0, scrollStart))
		.moveTo(PointOption.point(0, scrollEnd)).release()
		.perform();
	}

	/**
	 * This method using for swipe up by element supported web view
	 *
	 * @param elementKey Enter your element keys that you want to scroll down into element
	 */

	public void scrollDownToElement(String elementKey) {
		WebElement element = findElement(elementKey);
		setContextToWebView(elementKey, false);
		scrollDown();
		setContextToWebView(elementKey, true);
		driver.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method using for swipe up by element supported web view
	 *
	 * @param elementKey Enter your element keys that you want to scroll down into element
	 */

	public void scrollUpToElement(String elementKey) {
		WebElement element = findElement(elementKey);
		setContextToWebView(elementKey, false);
		scrollUp();
		setContextToWebView(elementKey, true);
		driver.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	/**
	 * This method using for swipe up by element supported web view
	 *
	 * @param elementKey Enter your element keys that you want to swipe right into element
	 */

	public void swipeRightToElement(String elementKey) {
		WebElement element = findElement(elementKey);
		driver.executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(+100%)\";", element);
	}

	/**
	 * This method using for swipe up by element supported web view
	 *
	 * @param elementKey Enter your element keys that you want to swipe left into element
	 */

	public void swipeLeftToElement(String elementKey) {
		WebElement element = findElement(elementKey);
		driver.executeScript("arguments[0].style.cssText = \"position: absolute; transform: translateX(-100%)\";", element);
	}


	/**
	 * This method using for swipe down util your element displayed
	 *
	 * @param elementKey Enter you element keys you want to swipe down for find it
	 */
	public void scrollTillElementIntoDisplay(String elementKey) {
		System.out.println("The size is ---"+ViewElement(elementKey).size());
		if (ViewElement(elementKey).size() == 0) {
			while (ViewElement(elementKey).size() == 0) {
				scrollDown();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (!ViewElement(elementKey).get(0).isDisplayed()) {
				scrollDown();
			}
		}
		else {
			while (!ViewElement(elementKey).get(0).isDisplayed()) {
				System.out.println("Not yet displayed");
				scrollDown();
			}
		}
		return;
	}

	public AppiumDriver getDriver() {
		return driver;
	}


	public boolean isAndroid() {
		//        return "android".equalsIgnoreCase(driver.getPlatformName());
		return "android".equalsIgnoreCase(driver.getCapabilities().getCapability(DeviceProfile.platformName).toString());
	}

	public boolean isIos() {
		//        return "ios".equalsIgnoreCase(driver.getPlatformName());
		return "ios".equalsIgnoreCase(driver.getCapabilities().getCapability(DeviceProfile.platformName).toString());

	}


	/**
	 * This method using for swipe up by element
	 *
	 * @param startElementKey  Enter your element keys that you want to swipe up from element
	 * @param endPercentage    Enter your percentage of end that you want to swipe up
	 * @param anchorPercentage Enter your percentage of anchor that you want to touch
	 */
	//Swipe up by elements
	public void swipeUpByElements(String startElementKey, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		WebElement targetElement = findElement(startElementKey);
		int anchor = (int) (size.width * anchorPercentage);
		int startY = targetElement.getLocation().getY();
		int endpoint = (int) (size.height * endPercentage);
		setContextToWebView(startElementKey, false);
		new TouchAction(driver)
		.press(PointOption.point(anchor, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(anchor, endpoint))
		.release().perform();
	}


	/**
	 * This method use for swipe up and down by using % height of screen
	 *
	 * @param startPercentage  Enter your start point on screen in % height of screen example 0.2 is 20% of screen from left
	 * @param endPercentage    Enter your end point on screen in % height of screen example 0.8 is 80% of screen from left
	 * @param anchorPercentage Enter your point you want to swipe example 0.5 is middle of screen
	 */
	//Vertical Swipe by percentages
	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		getDriver().context("NATIVE_APP");
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);
		new TouchAction(driver)
		.press(PointOption.point(anchor, startPoint))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(anchor, endPoint))
		.release().perform();

	}

	/**
	 * This method use for swipe left or right by using % width of screen
	 *
	 * @param startPercentage  Enter your start point on screen in % width of screen example 0.2 is 20% of screen from left
	 * @param endPercentage    Enter your end point on screen in % width of screen example 0.8 is 80% of screen from left
	 * @param anchorPercentage Enter your point you want to swipe example 0.5 is middle of screen
	 */
	//Horizontal Swipe by percentages
	public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * endPercentage);
		new TouchAction(driver)
		.press(PointOption.point(startPoint, anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(endPoint, anchor))
		.release().perform();
	}

	public void tapCenter() {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height / 2);
		int startPoint = (int) (size.width / 2);
		new TouchAction(driver)
		.longPress(PointOption.point(startPoint, anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.release().perform();
	}

	public void hideKeyboard() {
		if (isIos()) {
			try {
				Thread.sleep(2000);
				driver.findElementByXPath(String.format("//XCUIElementTypeButton[@name='%s']", "Done")).click();
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}

		}
	}

	public void back() {
		driver.navigate().back();
	}

	public boolean isElementPresent(String xpath) {
		try {
			if (driver.findElements(By.xpath(xpath)).size() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
