package com.tmb.automation.util;

import static org.testng.Assert.fail;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.itextpdf.text.log.SysoCounter;
import com.tmb.automation.helper.Dataset;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	private static AppiumDriverLocalService appiumService;
	private static AppiumServiceBuilder builder;
	public static WebDriver Browserdriver;
	public static Properties prop;
	protected static Map<String, String> mapData;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public WebDriver driver;
	public ChromeOptions chromeOptions = new ChromeOptions();
	public static WebDriverWait wait;
	public static AppiumDriver<WebElement> appiumDriver;
	public static IOSDriver<WebElement> iOSDriver;
	public static AppiumDriver<MobileElement> appiumDriverMobile;
	public static IOSDriver<MobileElement> iOSDriverMobile;
	public static ExtentReports extent;
	public static ExtentTest feature;
	public static ExtentReports extentReports;
	public static ExtentReporter extentReporter;
	public static String fileName;
	 public void setExtentReports(ExtentReports extent) {
	        this.extent = extent;
	    }

	    public void setFeature(ExtentTest feature) {
	        this.feature = feature;
	    }

	    public ExtentReports getExtent() {
	        return extent;
	    }

	    public ExtentTest getFeature() {
	        return feature;
	    }
@Parameters({"ReportName"})	    
@BeforeSuite
public void Extentreport(@Optional String ReportName) {
	fileName=System.getProperty("user.dir") + "/reports/"+ReportName+"_"+new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".html";	
	extentReports = new ExtentReports(); 
	extentReporter = new ExtentHtmlReporter(fileName);
	extentReports.attachReporter(extentReporter);	
}
public void Extentreportfeature() {
	feature = extentReports.createTest(this.getClass().getSimpleName());
    setFeature(feature);
    setExtentReports(extentReports);
}

@AfterSuite
public void GenerateReport() {
	if (getExtent() != null)
        getExtent().flush();
	System.out.println("The file name is---"+fileName);
	File htmlFile = new File(fileName);
	try {
		Desktop.getDesktop().browse(htmlFile.toURI());
	} catch (Exception e) {
    System.err.println("Unable to open the file");
	}
}


public void takeScreenshot(String name,WebDriver driver) throws IOException {
    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/reports/" + name));
}
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String version=prop.getProperty("version");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			String filepath = System.getProperty("user.dir") + "/src/main/resources/"+version+".exe";
			System.out.println(filepath);
			System.setProperty("webdriver.chrome.driver", filepath);
			Browserdriver = new ChromeDriver();
			// execute in chrome driver
		} else if (browserName.equals("firefox")) {
			Browserdriver = new FirefoxDriver();
			// firefox code
		} else if (browserName.equals("IE")) {
			// IE code
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return Browserdriver;
	}
	

	public static AppiumDriverLocalService startServer() {
		log("Start Appium server...");
		Runtime runtime = Runtime.getRuntime();
		String osName = System.getProperty("os.name");
		try {
			if (osName.contains("Mac")) {
				runtime.exec(Helper.getProperties("mac_bin_path")+"/killall -9 node");
			} else if (osName.contains("Windows")) {
				runtime.exec("taskkill /F /IM node.exe");
			}
			sleep();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {
			builder = new AppiumServiceBuilder();
			if (osName.toLowerCase().contains("mac")) {
				// Path where the node is installed
				builder.usingDriverExecutable(new File(Helper.getProperties("appium_ios_node_path")));
				// Path where the Appium is installed
				builder.withAppiumJS(new File(Helper.getProperties("appium_ios_main_path")));
				// The XCUITest driver requires that a path to the carthage binary is in the
				// PATH variable
				HashMap<String, String> environment = new HashMap<>();
				environment.put("JAVA_HOME", Helper.getProperties("mac_java_home_path"));
				environment.put("ANDROID_HOME", Helper.getProperties("mac_android_sdk_path"));
				environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH")+":"
						+ Helper.getProperties("mac_java_home_path") + "/bin:"
						+ Helper.getProperties("mac_android_sdk_path") + "/tools:"
						+ Helper.getProperties("mac_android_sdk_path") + "/tools/bin:"
						+ Helper.getProperties("mac_android_sdk_path") + "/platform-tools");
				//				log("environment="+environment);
				builder.withEnvironment(environment);
			} else if (osName.contains("Windows")) {
				;
			} else {
				Assert.fail("Unspecified OS found, Appium can't run");
			}
			builder.withIPAddress(Helper.getProperties("appium_ip"));
			builder.usingPort(Integer.parseInt(Helper.getProperties("appium_port")));
			//			builder.withLogFile(new File("./target/appiumn_log_"
			//					+new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+".log"));
			//			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, Helper.getProperties("appium_bulder_log_level"));
			appiumService = AppiumDriverLocalService.buildService(builder);
			//			Log.logger.debug("Start Appium Server at http://" + Helper.getProperties("appium_ip")
			//					+ Helper.getProperties("appium_port") + "/wd/hub");
			appiumService.start();
		} else {
			Log.logger.debug("Appium server at http://" + Helper.getProperties("appium_ip") + ":"
					+ Helper.getProperties("appium_port") + "/wd/hub is already started!");
		}
		log("Start Appium server...End");
		return appiumService;
	}



	public static Boolean stopServer() {
		//		Log.logger.debug("Stop Appium Server...");
		Boolean stopService = false;
		String osName = System.getProperty("os.name");
		try {
			appiumService.stop();
		} catch (Exception e) {
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			if (osName.contains("Mac")) {
				runtime.exec( Helper.getProperties("mac_bin_path") + "/killall -9 node");
			} else if (osName.contains("Windows")) {
				runtime.exec("taskkill /F /IM node.exe");
			}
			sleep();
			stopService = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		Log.logger.debug("Stop Appium Server...Done!");
		return stopService;
	}

	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() {
		String profile = Helper.CONFIG_PROFILE+".";
		log("Start Emulator.....");
		String osName = System.getProperty("os.name");

		if (osName.contains("Mac")) {
			if (getMobileOS().equalsIgnoreCase("ios")) {
				try {
					Runtime.getRuntime().exec("killall -9 Simulator");
					sleep(3);
					Runtime.getRuntime().exec(Helper.getProperties("mac_simulator_path")
							+" -CurrentDeviceUDID "+Helper.getProperties(Helper.CONFIG_PROFILE +"." + "udid"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else if (getMobileOS().equalsIgnoreCase("android")) {
				try {
					//kill android emulator
					Runtime.getRuntime().exec(Helper.getProperties("mac_android_sdk_path") + "/platform-tools/adb -e emu kill");//adb -e emu kill
					sleep(3);
					//start android emulator
					//cd /Users/oneapp-qa/Library/Android/sdk/tools && ./emulator -avd Pixel_3a_API_23 -no-snapshot-save
					Runtime.getRuntime().exec(Helper.getProperties("mac_emulator_bat") + " && exit");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				log("Config.profile="+Helper.CONFIG_PROFILE+"  is not support");
			}

		}else if (osName.contains("Windows")) {
			try {
				//kill android emulator
				Runtime.getRuntime().exec("adb -e emu kill");
				sleep(3);
				Runtime.getRuntime().exec("cmd.exe /C start "+Helper.getProperties("windows_emulator_bat")+File.separator+"emulator -avd " +Helper.getProperties(profile + "emulator")+" -dns-server 8.8.8.8" );

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			log("OS is not supported.");
		}
		sleep(20);
		log("Start Emulator...Done");
	}

	public static void stopEmulator() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Mac")) {
			if (getMobileOS().equalsIgnoreCase("ios")) {
				try {
					Runtime.getRuntime().exec("killall -9 Simulator");
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else if (getMobileOS().equalsIgnoreCase("android")) {
				try {
					Runtime.getRuntime().exec(Helper.getProperties("mac_android_sdk_path") + "/platform-tools/adb -e emu kill && exit");
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} else if (osName.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("cmd /c adb -s emulator-5554 emu kill && exit");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		sleep();
	}

	/**
	 * Android
	 * 
	 * @return
	 */

	public static AppiumDriver<WebElement> androidCapabilities() {
		String profile = Helper.CONFIG_PROFILE+".";
		String Environment=System.getProperty("Environment");
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		if(!Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, Helper.getProperties(profile + "deviceName"));
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Helper.getProperties(profile + "platformName"));
			// caps.setCapability("app", Helper.getProperties(profile + "app"));// Helper.getUserDir()+"/src/main/resources/"+
			//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Helper.getProperties(profile + "appPackage"));
			//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Helper.getProperties(profile + "appActivity"));
			caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
			caps.setCapability("nativeWebScreenshot", true);
			//caps.setCapability("chromedriverExecutable",Helper.getUserDir() + "/src/main/resources/" + Helper.getProperties(profile + "chromedriver"));
			if (Helper.getProperties(profile +"app")!=null){
				caps.setCapability("app", Helper.getProperties(profile + "app"));
			}
			if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
				String msg = "*Error*ping: cannot resolve "+Helper.getProperties("appium_ip")+": Unknown host";
				log(msg);
				fail(msg);
			}
			log("Capabilities=" + caps);
			Helper.writeLog("Capabilities=" + caps);
			try {
				appiumDriver = new AndroidDriver<WebElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
						+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
			} catch (Exception e) {
				Log.logger.debug(">>>>> URL " + Helper.getProperties("appium_url") + " is not formal");
				e.printStackTrace();
			}
		}
		else {
			
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("username",Helper.getProperties(profile + "username"));
			caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
			caps.setCapability("name",Helper.getProperties(profile + "name") +" on "+ Environment+ " Environment");
			caps.setCapability("Record", true);
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			caps.setCapability(CapabilityType.BROWSER_NAME, "");
			if(Environment.equalsIgnoreCase("vit")) {
				System.out.println("Sauce lab execution on VIT Environment");
			caps.setCapability("app",Helper.getProperties(profile + "app_vit"));
			}
			else if(Environment.equalsIgnoreCase("Dev")) {
				System.out.println("Sauce lab execution on DEV Environment");
				caps.setCapability("app",Helper.getProperties(profile + "app_dev"));
			}
			caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
			caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
			try {
				appiumDriver=new AndroidDriver<WebElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				

		}

		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}

	public static AppiumDriver<MobileElement> androidCapabilitiesMobileElement() {
		String Environment=System.getProperty("Environment");
		
		String profile = Helper.CONFIG_PROFILE+".";
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		if(!Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, Helper.getProperties(profile + "deviceName"));
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Helper.getProperties(profile + "platformName"));
			caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
			caps.setCapability("nativeWebScreenshot", true);
			caps.setCapability("chromedriverExecutable",Helper.getUserDir() + "/src/main/resources/" + Helper.getProperties(profile + "chromedriver"));
			if (Helper.getProperties(profile +"app")!=null){
				caps.setCapability("app", Helper.getProperties(profile + "app"));
			}
			if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
				String msg = "*Error*ping: cannot resolve "+Helper.getProperties("appium_ip")+": Unknown host";
				log(msg);
				fail(msg);
			}
			log("Capabilities=" + caps);
			Helper.writeLog("Capabilities=" + caps);
			try {
				appiumDriverMobile = new AndroidDriver<MobileElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
						+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
			} catch (Exception e) {
				Log.logger.debug(">>>>> URL " + Helper.getProperties("appium_url") + " is not formal");
				e.printStackTrace();
			}
		}
		else {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("username",Helper.getProperties(profile + "username"));
			caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
			caps.setCapability("name",Helper.getProperties(profile + "name") +" on "+ Environment+ " Environment" );
			caps.setCapability("Record", true);
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			caps.setCapability(CapabilityType.BROWSER_NAME, "");
			if(Environment.equalsIgnoreCase("vit")) {
				System.out.println("Sauce lab execution on VIT Environment");
			caps.setCapability("app",Helper.getProperties(profile + "app_vit"));
			}
			else if(Environment.equalsIgnoreCase("Dev")) {
				System.out.println("Sauce lab execution on DEV Environment");
				caps.setCapability("app",Helper.getProperties(profile + "app_dev"));
			}
			caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
			caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
			try {
				appiumDriverMobile=new AndroidDriver<MobileElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}				
		}
		appiumDriverMobile.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(appiumDriverMobile, 100);
		return appiumDriverMobile;
	}



	/**
	 * IOS
	 * 
	 * @return
	 * @throws IOException
	 */
	public static AppiumDriver<MobileElement> iOSCapabilitiesMobileElement() {
		String profile = Helper.CONFIG_PROFILE+".";
		String Environment=System.getProperty("Environment");
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		if(!Helper.CONFIG_PROFILE.contains("Saucelabios")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName", Helper.getProperties(profile + "deviceName"));
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			// caps.setCapability("app", Helper.getProperties(profile + "app"));
			caps.setCapability("automationName", "XCUITest");
			caps.setCapability("udid", Helper.getProperties(profile + "udid"));
			caps.setCapability("nativeWebScreenshot", true);
			caps.setCapability("useJSONSource", true);
			caps.setCapability("showXcodeLog", true);
			caps.setCapability("showIOSLog", true);
			caps.setCapability("newCommandTimeout", "120");
			caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
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
			log("Capabilities=" + caps);
			// Helper.writeLog("Capabilities=" + caps);
			if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
				String msg = "*Error*ping: cannot resolve "+Helper.getProperties("appium_ip")+": Unknown host";
				log(msg);
				fail(msg);
			}
			try {
				appiumDriverMobile = new AppiumDriver<MobileElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
						+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
			} catch (Exception e) {
				Log.logger.debug(e.getMessage());
			}
		}
		else {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("username",Helper.getProperties(profile + "username"));
			caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
			caps.setCapability("name",Helper.getProperties(profile + "name") +" on "+ Environment+ " Environment" );
			caps.setCapability("Record", true);
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			caps.setCapability(CapabilityType.BROWSER_NAME, "");
			if(Environment.equalsIgnoreCase("vit")) {
				System.out.println("Sauce lab execution on VIT Environment");
			caps.setCapability("app",Helper.getProperties(profile + "app_vit"));
			}
			else if(Environment.equalsIgnoreCase("Dev")) {
				System.out.println("Sauce lab execution on DEV Environment");
				caps.setCapability("app",Helper.getProperties(profile + "app_dev"));
			}
			caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
			caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
			try {
				appiumDriverMobile=new IOSDriver<MobileElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		appiumDriverMobile.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(appiumDriverMobile, 100);
		return appiumDriverMobile;
	}
	public static AppiumDriver<WebElement> iOSCapabilities() {
		String Environment=System.getProperty("Environment");
		String profile = Helper.CONFIG_PROFILE+".";
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		if(!Helper.CONFIG_PROFILE.contains("Saucelabios")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName", Helper.getProperties(profile + "deviceName"));
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			// caps.setCapability("app", Helper.getProperties(profile + "app"));
			caps.setCapability("automationName", "XCUITest");
			caps.setCapability("udid", Helper.getProperties(profile + "udid"));
			caps.setCapability("nativeWebScreenshot", true);
			caps.setCapability("useJSONSource", true);
			caps.setCapability("showXcodeLog", true);
			caps.setCapability("showIOSLog", true);
			caps.setCapability("newCommandTimeout", "120");
			caps = resetApp(caps, Helper.getProperties(profile + "resetApp"));
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
			log("Capabilities=" + caps);
			// Helper.writeLog("Capabilities=" + caps);
			if (!pingHost(Helper.getProperties("appium_ip"), Integer.parseInt(Helper.getProperties("appium_port")), 10)) {
				String msg = "*Error*ping: cannot resolve "+Helper.getProperties("appium_ip")+": Unknown host";
				log(msg);
				fail(msg);
			}
			try {
				appiumDriver = new AppiumDriver<WebElement>(new URL("http://" + Helper.getProperties("appium_ip") + ":"
						+ Helper.getProperties("appium_port") + "/wd/hub"), caps);
			} catch (Exception e) {
				Log.logger.debug(e.getMessage());
			}
		}
		else {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability("username",Helper.getProperties(profile + "username"));
			caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
			caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
			caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
			caps.setCapability("name",Helper.getProperties(profile + "name") +" on "+ Environment+ " Environment" );
			caps.setCapability("Record", true);
			caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
			caps.setCapability(CapabilityType.BROWSER_NAME, "");
			if(Environment.equalsIgnoreCase("vit")) {
				System.out.println("Sauce lab execution on VIT Environment");
			caps.setCapability("app",Helper.getProperties(profile + "app_vit"));
			}
			else if(Environment.equalsIgnoreCase("Dev")) {
				System.out.println("Sauce lab execution on DEV Environment");
				caps.setCapability("app",Helper.getProperties(profile + "app_dev"));
			}
			caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
			caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
			try {
				appiumDriver=new IOSDriver<WebElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}



	public static void getScreenshot(WebDriver driver) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Log.logger.debug(Helper.getUserDir() + "/reports/" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
				+ ".png");
		FileUtils.copyFile(scrfile, new File(Helper.getUserDir() + "/reports/"
				+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png"));
	}

	public static File getfile() throws IOException {

		File scrfile = null;
		if (Browserdriver != null) {
			scrfile = ((TakesScreenshot) Browserdriver).getScreenshotAs(OutputType.FILE);
		} else if (appiumDriver != null) {
			scrfile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
		} else if (iOSDriver != null) {
			scrfile = ((TakesScreenshot) iOSDriver).getScreenshotAs(OutputType.FILE);
		} else {
			Log.logger.debug("Driver is not available for take screenshot");
		}
		//		Log.logger.debug("screenshot file" + scrfile);
		return scrfile;
		// FileUtils.copyFile(scrfile, new
		// File("C:\\Users\\Admin\\Desktop\\report"+s+".png"));
	}


	//	@DataProvider(name = "test1")
	//	public Object[][] createData1() {
	//		return new Object[][] { { "First-Value" }, { "Second-Value" } };
	//	}

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
		} 
		else if (deviceProfile.toLowerCase().contains("android")) {
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
		appiumDriverMobile.quit();
	}
	public static void driverWebElementQuit() {
		log("------------End");
		appiumDriver.quit();
	}
	public static AppiumDriver<MobileElement> appiumCapabilitiesMobileElement()  {
		AppiumDriver<MobileElement> driver=null;		
		log("profile="+Helper.CONFIG_PROFILE);
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")) {			
			driver=iOSCapabilitiesMobileElement();
			WebDriverWait wait = new WebDriverWait(driver, 300, 300);
			if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("Saucelabios")) {
				System.out.println("Executing on sauceLab on ios");	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"))).isDisplayed();			
				WebElement skipid=driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"));
				skipid.click();
				System.out.println("Skip ID is clicked");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")));
				WebElement Enterid=driver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
				Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
				System.out.println("Device ID is entered");
				WebElement savedeviceID=driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]"));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				savedeviceID.click();
			}

		} 

		else if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")) {
			driver=androidCapabilitiesMobileElement();
			WebDriverWait wait = new WebDriverWait(driver,60, 300);
			if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
				System.out.println("Executing on sauceLab on android");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				List<MobileElement> skip=driver.findElements(By.id("com.ttbbank.oneapp.vit:id/skipIntro"));
				if(skip.size()==0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();			
				WebElement skipid=driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip'])"));
				skipid.click();
				System.out.println("Skip ID is clicked");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']")));
				WebElement Enterid=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']"));
				Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
				System.out.println("Device ID is entered");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement savedeviceID=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/button_ok']"));
				savedeviceID.click();
				}
				else {
					System.out.println("Intro is present Skiped");
					skip.get(0).click();
				}
			}

		}

		else {
			Log.logger.debug("config profile is not found!!!");
		}

		return driver;

	}
	public static AppiumDriver<WebElement> appiumCapabilities()  {
		AppiumDriver<WebElement> driver=null;

		log("profile="+Helper.CONFIG_PROFILE);
		if (Helper.CONFIG_PROFILE.toLowerCase().contains("ios")) {			
			driver=iOSCapabilities();
			WebDriverWait wait = new WebDriverWait(driver, 300, 300);
			if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("Saucelabios")) {
				System.out.println("Executing on sauceLab on ios");	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"))).isDisplayed();			
				WebElement skipid=driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"));
				skipid.click();
				System.out.println("Skip ID is clicked");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")));
				WebElement Enterid=driver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
				Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
				System.out.println("Device ID is entered");
				WebElement savedeviceID=driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]"));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				savedeviceID.click();
			}

		} 

		else if (Helper.CONFIG_PROFILE.toLowerCase().contains("android")) {
			driver=androidCapabilities();
			WebDriverWait wait = new WebDriverWait(driver, 60, 300);
			if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
				System.out.println("Executing on sauceLab on android");	
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				List<WebElement> skip=driver.findElements(By.id("com.ttbbank.oneapp.vit:id/skipIntro"));
				if(skip.size()==0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();			
				WebElement skipid=driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip'])"));
				skipid.click();
				System.out.println("Skip ID is clicked");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']")));
				WebElement Enterid=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']"));
				Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
				System.out.println("Device ID is entered");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement savedeviceID=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/button_ok']"));
				savedeviceID.click();
				}
				else {
					System.out.println("Intro is present Skiped");
					skip.get(0).click();
				}
			}

		}

		else {
			Log.logger.debug("config profile is not found!!!");
		}

		return driver;

	}


	public static String map(String key) {
		return mapData.get(key);
	}

	//AutoploanDriver
	public WebDriver initialize_driver() {

		WebDriverManager.chromedriver().setup();
		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	//End autoloan driver


	public static AppiumDriver<WebElement> SaucelabandroidCapabilities() {
		String profile = Helper.CONFIG_PROFILE+".";
		if (profile.trim().isEmpty()) {
			Log.logger.debug("profile is empty");
		}
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("username",Helper.getProperties(profile + "username"));
		caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
		caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
		caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
		caps.setCapability("name",Helper.getProperties(profile + "name"));
		caps.setCapability("Record", true);
		caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
		caps.setCapability(CapabilityType.BROWSER_NAME, "");
		caps.setCapability("app",Helper.getProperties(profile + "app"));
		caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
		caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
		try {
			appiumDriver=new AndroidDriver<WebElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return appiumDriver;

	}

}

