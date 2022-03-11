package com.tmb.automation.pages.lending;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tmb.automation.helper.Dataset;
import com.tmb.automation.helper.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
//	private static AppiumDriverLocalService appiumService;
//	private static AppiumServiceBuilder builder;
	public static WebDriver Browserdriver;
	public Properties prop;
	protected static Map<String, String> mapData;
	public static AppiumDriver<WebElement> appiumDriver;

	public Base() {
		// TODO Auto-generated constructor stub
	}
	public static AppiumDriver<WebElement> androidCapabilities() {
		String profile = Helper.CONFIG_PROFILE+".";
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, Helper.getProperties(profile + "deviceName"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Helper.getProperties(profile + "platformName"));
		caps.setCapability("app", Helper.getProperties(profile + "app"));
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Helper.getProperties(profile + "appPackage"));
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Helper.getProperties(profile + "appActivity"));
		caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
//		caps.setCapability("nativeWebScreenshot", true);
//		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("chromedriverExecutable",
				Helper.getUserDir() + "/src/main/resources/" + Helper.getProperties(profile + "chromedriver"));
//		caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//		caps.setCapability("showChromedriverLog", true);
//		caps.setCapability("autoWebview", true);
		if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
			String msg = "*Error*ping: cannot resolve "+ Helper.getProperties("appium_ip")+": Unknown host";
			log(msg);
			fail(msg);
		}

//		LendingHelper.writeLog("Capabilities=" + caps);
		try {
			log("http://" + Helper.getProperties("appium_ip") + ":"
					+ Helper.getProperties("appium_port") + "/wd/hub");
			log("Capabilities=" + caps);
			appiumDriver = new AndroidDriver<WebElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
					+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
		} catch (Exception e) {
			Log.logger.debug(">>>>> URL " + Helper.getProperties("appium_url") + " is not formal");
			e.printStackTrace();
		}

		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}
	public static AppiumDriver<WebElement> iOSCapabilities() {
		String profile = Helper.CONFIG_PROFILE+".";
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
		caps.setCapability("deviceName", Helper.getProperties(profile + "deviceName"));
		caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("udid", Helper.getProperties(profile + "udid"));
		caps.setCapability("nativeWebScreenshot", true);
		caps.setCapability("useJSONSource", true);
		caps.setCapability("showXcodeLog", true);
		caps.setCapability("showIOSLog", true);
		if (Helper.getProperties(profile +"app")!=null){
			caps.setCapability("app", Helper.getProperties(profile + "app"));
		}
		if (Helper.getProperties(profile +"bundleId")!=null){
			caps.setCapability("bundleId", Helper.getProperties(profile +"bundleId"));
		}
		if (Helper.getProperties(profile +"xcodeOrgId")!=null){
			caps.setCapability("xcodeOrgId", Helper.getProperties(profile +"xcodeOrgId"));
		}
		if (Helper.getProperties(profile +"xcodeSigningId")!=null){
			caps.setCapability("xcodeSigningId", Helper.getProperties(profile +"xcodeSigningId"));
		}
		caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
		log("Capabilities=" + caps);
//		LendingHelper.writeLog("Capabilities=" + caps);
		if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
			String msg = "*Error*ping: cannot resolve "+ Helper.getProperties("appium_ip")+": Unknown host";
			log(msg);
			fail(msg);
		}
		try {
			appiumDriver = new AppiumDriver<WebElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
					+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
		} catch (Exception e) {
			Log.logger.debug(e.getMessage());
		}
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}
	public static File getfile() throws IOException {

		File scrfile = null;
		if (appiumDriver != null) {
			scrfile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
		} else {
			Log.logger.debug("Driver is not available for take screenshot");
		}
		return scrfile;
	}

	public Map<String, String> getexceldata(String sheetname) {
		Map<String, String> dataMap = null;
		try {
			dataMap = Dataset.setMapData(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataMap;
	}

	protected static void log(String message, String level) {
		if (level.equalsIgnoreCase("debug")) {
			Log.logger.debug(message);
		} else {
			Log.logger.debug(message);
		}
	}

	protected static void log(String message) {
		Base.log(message, "debug");
	}

	protected static void sleep(double seconds) {
		int sc = (int)seconds;
		for (int i = 0; i < sc; i++) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}

	protected static void sleep() {
		Base.sleep(3);
	}

	public static boolean pingHost(String host, int port, int timeout) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port), timeout);
			return true;
		} catch (IOException e) {
			return false; 
		}
	}

	public static DesiredCapabilities resetApp(DesiredCapabilities caps, String devicePlatform) {
		if (devicePlatform.contains("fullReset")) { // uninstall and install client
			caps.setCapability(MobileCapabilityType.FULL_RESET, true);
			caps.setCapability(MobileCapabilityType.NO_RESET, false);
		} else if (devicePlatform.contains("fastReset")) { // clears cache and settings without reinstall
			caps.setCapability(MobileCapabilityType.FULL_RESET, false);
			caps.setCapability(MobileCapabilityType.NO_RESET, false);
		} else { // just start client
			caps.setCapability(MobileCapabilityType.FULL_RESET, false);
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
		}
		return caps;
	}
	
	public static String setMobileOS(String deviceProfile) {
		String osName = "";
		if (deviceProfile.toLowerCase().contains("ios")) {
			Helper.CONFIG_PROFILE = "ios";
		} else if (deviceProfile.toLowerCase().contains("android")) {
			Helper.CONFIG_PROFILE = "android";
		}
		else {
			log("deviceProfile "+deviceProfile+" is not found");
		}
		return osName;
	}
	public static String getMobileOS() {
		String osName = "";
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")) {
			osName = "ios";
		} else if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")) {
			osName = "android";
		} else {
			osName = "Not Found";
		}
		return osName;
	}
	
	public static void driverQuit() {
		log("------------End");
		appiumDriver.quit();
		log("after quit()");
	}
	public static AppiumDriver<WebElement> appiumCapabilities() {
		AppiumDriver<WebElement> driver=null;
		log("profile="+ Helper.CONFIG_PROFILE);
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")) {
			driver=iOSCapabilities();
		} else if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")) {
			driver=androidCapabilities();
		} else {
			Log.logger.debug("config profile is not found!!!");
		}
		return driver;
	}
	
	public static String map(String key) {
		return mapData.get(key);
	}

}
