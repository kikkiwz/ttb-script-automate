package com.ttbbank.oneapp.framework;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.utils.ZipDirectory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseScenario {

	private static ExtentReports extent;
	private static ExtentTest feature;
	public TtbTestContext ttbTestContext;
	public AppiumDriver driver;
	private OneAppClient oneAppClient;
	private static AppiumServiceBuilder builder;
	private static AppiumDriverLocalService appiumService;
	protected static Map<String, String> mapData;
	public static ExtentReports extentReports;
	public static ExtentReporter extentReporter;
	public static String fileName;


	@Parameters({"ReportName"})
	@BeforeSuite(alwaysRun = true)
	public void Extentreport(@Optional String ReportName) {
		String reportName  = System.getProperty("reportName");
		if(reportName!=null){
			fileName = System.getProperty("user.dir") + "/reports/" + reportName  + ".html";
		} else {
			fileName = System.getProperty("user.dir") + "/reports/" + ReportName + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
		}
		extentReports = new ExtentReports();
		extentReporter = new ExtentHtmlReporter(fileName);
		extentReports.attachReporter(extentReporter);
		System.out.println("Inside before Suite");
		System.out.println("the report name is: "+fileName);

	}

	public ExtentReports getExtentReports(){
		return extentReports;
	}

	public void Extentreportfeature() {
		feature = extentReports.createTest(this.getClass().getSimpleName());
		setFeature(feature);
		setExtentReports(extentReports);
	}

	public TtbTestContext getTtbTestContext() {
		return ttbTestContext;
	}

	public AppiumDriver getDriver() {
		return driver;
	}

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

	public OneAppClient getOneAppClient() {
		return oneAppClient;
	}

	public void testWithDeviceProfile(String deviceProfile) {
		AppiumDriver driver = DriverFactory.createDriver(deviceProfile);
		String baseUrl = OneAppConfig.getInstance().getConfig(OneAppConfigKeys.BASE_URL);
		oneAppClient = new OneAppClient(baseUrl);
		ttbTestContext = new TtbTestContext(driver);
		ExtentListeners.setDriver(driver);
		//        ExtentListenersPB1.setDriver(driver);
	}
	public void testWithDeviceProfile(String deviceProfile, String scenarioName) {
		AppiumDriver driver = DriverFactory.createDriver(deviceProfile, scenarioName);
		String baseUrl = OneAppConfig.getInstance().getConfig(OneAppConfigKeys.BASE_URL);
		oneAppClient = new OneAppClient(baseUrl);
		if (baseUrl.toLowerCase().contains("saucelabs")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ttbTestContext = new TtbTestContext(driver);
		//        ExtentListeners.setDriver(driver);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws IOException {
		if (getExtent() != null) {
			getExtent().flush();
			System.out.println("The file name is---" + fileName);
			File htmlFile = new File(fileName);
			try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (Exception e) {
				System.err.println("Unable to open the file");
			}
		}
		//        ttbTestContext.getDriver().quit();
		//        stopEmulator();
		stopServer();
	}

	public void takeScreenshot(String name) throws IOException {
		File file = getTtbTestContext().getDriver().getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/reports/" + name));
	}

	public static String map(String key) {
		return mapData.get(key);
	}

	public void Registerttb() {
		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB);
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB).click();
		//ttbTestContext.waitUntilVisible(OneAppElementKeys.CHANGE_LANGUAGE);
		//ttbTestContext.findElement(OneAppElementKeys.CHANGE_LANGUAGE).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.AGGREE_TC);
		ttbTestContext.findElement(OneAppElementKeys.AGGREE_TC).click();
		ttbTestContext.findElement(OneAppElementKeys.TC_NEXT).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.CITIZEN_ID);
		String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
		ttbTestContext.findElement(OneAppElementKeys.CITIZEN_ID).click();
		ttbTestContext.findElement(OneAppElementKeys.CITIZEN_ID).sendKeys(citizenId);
		ttbTestContext.findElement(OneAppElementKeys.CITIZEN_ID_NEXT).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_ENTERPIN);
		enterPin();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.ENTER_OTP_REGISTER);
		if(ttbTestContext.isAndroid()) {
			ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
		}
		if(ttbTestContext.isIos()) {
			List<WebElement> OTP=ttbTestContext.findElements(OneAppElementKeys.ENTER_OTP_REGISTER);
			for(int i=0;i<OTP.size();i++) {
				ttbTestContext.findElements(OneAppElementKeys.ENTER_OTP_REGISTER).get(i).
				sendKeys("1");
			}
		}
		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_SUCCESSFULL);
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_SUCCESSFULL).click();
	}

	public void enterDeviceId() {
		WebElement sauceLabButton = ttbTestContext.findElement(OneAppElementKeys.SAUCELAB_BUTTON);
		sauceLabButton.click();
		String deviceId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.deviceId);
		WebElement deviceIdInput = ttbTestContext.findElement(OneAppElementKeys.DEVICE_ID_INPUT);
		deviceIdInput.sendKeys(deviceId);
		WebElement saveDeviceId = ttbTestContext.findElement(OneAppElementKeys.SAVE_DEVICE_ID_BUTTON);
		saveDeviceId.click();
	}

	//Latest is Android Dev 488,iOS Dev 335
	@Test(groups = "Enter Home Screen Dev Latest")
	public void enterHomeScreenDevLatest() throws InterruptedException {
		if (ttbTestContext.isAndroid()) {
			enterDeviceId();
			WebElement skipIntroButton = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
			skipIntroButton.click();
			skipIntroButton.click();
			skipIntroButton.click();
			WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
			accountButton.click();
			enterPin();
			ttbTestContext.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
			skipIntroButton.click();
			ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
			return;
		}
		//        ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
		//        ttbTestContext.verticalSwipeByPercentages(0.1, 0.8, 0.5);
		enterDeviceId();
		WebElement BTN_ALLOW = ttbTestContext.findElement(OneAppElementKeys.BTN_ALLOW);
		BTN_ALLOW.click();
		Thread.sleep(2000);
		WebElement skipIntroButton = ttbTestContext.findElement(OneAppElementKeys.INTRO_HOME_SCREEN_NEXT_BUTTON);
		skipIntroButton.click();
		skipIntroButton.click();
		skipIntroButton.click();


		WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
		accountButton.click();
		enterPin();
		Thread.sleep(10000);
		//        ttbTestContext.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_SCREEN_BUTTON_DEV);
		ttbTestContext.tapCenter();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);

	}

	@Test(groups = "Enter Home Screen Dev Latest By Investment")
	public void tabAccountDevLatestByInvestment() {

		enterDeviceId();

		WebElement nextIntroButton = ttbTestContext.findElement(OneAppElementKeys.INTRO_HOME_SCREEN_NEXT_BUTTON);
		nextIntroButton.click();
		nextIntroButton.click();
		nextIntroButton.click();

		WebElement accountTab = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_TAB);
		accountTab.click();

		enterPin();

		WebElement accountNextIntroButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_INTRO_SKIP_BUTTON);
		accountNextIntroButton.click();

		ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);

	}


	//Latest is Dev 488
	@Test(groups = "Enter Service Screen Dev Latest")
	public void enterServiceScreenDevLatest() throws InterruptedException {
		WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
		serviceButton.click();
		Thread.sleep(5000);
		ttbTestContext.tapCenter();
		Thread.sleep(2000);
		//ttbTestContext.waitUntilVisible(OneAppElementKeys.DOCUMENTS_SERVICE_BUTTON);

	}

	//Android VIT 472,iOS VIT 299,351
	@Test(groups = "Enter Home Screen VIT Latest")
	public void enterHomeScreenVITLatest() {
		if (ttbTestContext.isAndroid()) {
			enterDeviceId();
			WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
			accountButton.click();
			enterPin();
			ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_HOME_SCREEN_BUTTON);
			return;
		}

		enterDeviceId();

		//support VIT351
		try {
			WebElement nextIntroButton = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HOME_SCREEN_BUTTON);
			nextIntroButton.click();
			nextIntroButton.click();
			nextIntroButton.click();
		} catch (Exception ex) {
		}
		//support VIT299
		try {
			WebElement skipIntroButton = ttbTestContext.findElement(OneAppElementKeys.SKIP_INTRO_HOME_SCREEN_BUTTON);
			skipIntroButton.click();
			skipIntroButton.click();
			skipIntroButton.click();
		} catch (Exception ex) {
		}

		WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
		accountButton.click();
		enterPin();

		//support VIT351
		try {
			WebElement nextIntoAcctButton = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_ACCOUNT_SCREEN_BUTTON);
			nextIntoAcctButton.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}

	//Latest is Vit 472
	@Test(groups = "Enter Card Screen VIT Latest", priority = 1)
	public void enterCardScreenVitLatest() {
		WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
		cardButton.click();
		//        ttbTestContext.waitUntilVisible(OneAppElementKeys.CARD_ITEM_0_HOME_SCREEN_BUTTON);
	}


	public void enterPin() {

		WebElement button0 = ttbTestContext.findElement(OneAppElementKeys.PIN_0_BUTTON);
		WebElement button1 = ttbTestContext.findElement(OneAppElementKeys.PIN_1_BUTTON);
		WebElement button2 = ttbTestContext.findElement(OneAppElementKeys.PIN_2_BUTTON);
		WebElement button3 = ttbTestContext.findElement(OneAppElementKeys.PIN_3_BUTTON);

		button0.click();
		button1.click();

		button0.click();
		button2.click();

		button0.click();
		button3.click();

	}

	public void enterWrongPin() {

		WebElement button0 = ttbTestContext.findElement(OneAppElementKeys.PIN_0_BUTTON);
		WebElement button1 = ttbTestContext.findElement(OneAppElementKeys.PIN_1_BUTTON);
		WebElement button2 = ttbTestContext.findElement(OneAppElementKeys.PIN_2_BUTTON);
		WebElement button3 = ttbTestContext.findElement(OneAppElementKeys.PIN_3_BUTTON);

		button0.click();
		button1.click();

		button1.click();
		button2.click();

		button0.click();
		button3.click();

	}

	/**
	 * This method to support event the application would like to confirm transaction and need to enter PIN
	 */

	public void confirmPin() {

		ttbTestContext.waitUntilVisible(OneAppElementKeys.CONFIRM_PIN_0_BUTTON);
		WebElement button0 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_0_BUTTON);
		WebElement button1 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_1_BUTTON);
		WebElement button2 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_2_BUTTON);
		WebElement button3 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_3_BUTTON);

		button0.click();
		button1.click();

		button0.click();
		button2.click();

		button0.click();
		button3.click();

	}

	public void EnterBypassOTP() throws InterruptedException {
		Thread.sleep(2000);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
		ttbTestContext.verticalSwipeByPercentages(0.78, 0.10, 0.78);
	}

	//AD572 iOS435
	@Test(groups = "Open home screen VIT latest")
	public void OpenHomeScreenVITLatest() {
		if (ttbTestContext.isAndroid()) {
			enterDeviceId();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			return;
		}
		enterDeviceId();
		ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
	}

	@Test(groups = "Open home screen latest dev")
	public void OpenHomeScreenDEVLatest() {
		if (ttbTestContext.isAndroid()) {
			//            enterDeviceId();
			//            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			//            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			//            ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			return;
		}
		enterDeviceId();
		ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
	}

	/////-----------Automation to open Appium and Emulator Automatically Updated by Binit---------------------////


	protected static void log(String message, String level) {
		if (level.equalsIgnoreCase("debug")) {
			Log.logger.debug(message);
		} else {
			Log.logger.debug(message);
		}
	}

	protected static void log(String message) {
		BaseScenario.log(message, "debug");
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

	public static void startEmulator() throws Exception {
		String deviceProfile = Helper.CONFIG_PROFILE + ".";
		log("Start Emulator.....");
		String osName = System.getProperty("os.name");
		if (osName.contains("Mac")) {
			if (getMobileOS().equalsIgnoreCase("ios")) {
				try {
					Runtime.getRuntime().exec("killall -9 Simulator");
					Thread.sleep(3);
					Runtime.getRuntime().exec(Helper.getProperties("mac_simulator_path")
							+ " -CurrentDeviceUDID " + Helper.getProperties(Helper.CONFIG_PROFILE + "." + "udid"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else if (getMobileOS().equalsIgnoreCase("android")) {
				try {
					//kill android emulator
					Runtime.getRuntime().exec(Helper.getProperties("mac_android_sdk_path") + "/platform-tools/adb -e emu kill");//adb -e emu kill
					Thread.sleep(3);
					//start android emulator
					//cd /Users/oneapp-qa/Library/Android/sdk/tools && ./emulator -avd Pixel_3a_API_23 -no-snapshot-save
					Runtime.getRuntime().exec(Helper.getProperties("mac_emulator_bat") + " && exit");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				log("Config.profile=" + Helper.CONFIG_PROFILE + "  is not support");
			}

		} else if (osName.contains("Windows")) {
			try {
				//kill android emulator
				Runtime.getRuntime().exec("adb -e emu kill");
				Thread.sleep(3);
				Runtime.getRuntime().exec("cmd.exe /C start " + Helper.getProperties("windows_emulator_bat") + File.separator + "emulator -avd " + Helper.getProperties(deviceProfile + "emulator") + " -dns-server 8.8.8.8");

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			log("OS is not supported.");
		}
		Thread.sleep(20);
		log("Start Emulator...Done");

	}

	public static void stopEmulator() {
		String deviceProfile = Helper.CONFIG_PROFILE + ".";
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
				Runtime.getRuntime().exec("cmd /c adb -s" + Helper.getProperties(deviceProfile + "emulator") + "emu kill && exit");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

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

	public static AppiumDriverLocalService startServer() {
		log("Start Appium server...");
		Runtime runtime = Runtime.getRuntime();
		String osName = System.getProperty("os.name");
		//		try {
		//			if (osName.contains("Mac")) {
		//				runtime.exec(Helper.getProperties("mac_bin_path")+"/killall -9 node");
		//			}
		//			else if (osName.contains("Windows")) {
		//				runtime.exec("taskkill /F /IM node.exe");
		//			}
		//
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
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
				environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH") + ":"
						+ Helper.getProperties("mac_java_home_path") + "/bin:"
						+ Helper.getProperties("mac_android_sdk_path") + "/tools:"
						+ Helper.getProperties("mac_android_sdk_path") + "/tools/bin:"
						+ Helper.getProperties("mac_android_sdk_path") + "/platform-tools");
				builder.withEnvironment(environment);
			} else if (osName.contains("Windows")) {
				;
			} else {
				Assert.fail("Unspecified OS found, Appium can't run");
			}
			builder.withIPAddress(Helper.getProperties("appium_ip"));
			builder.usingPort(Integer.parseInt(Helper.getProperties("appium_port")));
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, Helper.getProperties("appium_bulder_log_level"));
			appiumService = AppiumDriverLocalService.buildService(builder);
			appiumService.start();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				runtime.exec(Helper.getProperties("mac_bin_path") + "/killall -9 node");
			} else if (osName.contains("Windows")) {
				runtime.exec("taskkill /F /IM node.exe");
			}

			stopService = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		Log.logger.debug("Stop Appium Server...Done!");
		return stopService;
	}

	@Test(groups = "Activate new flow")
	public void NewActivateFlowDev633() {
		if (ttbTestContext.isAndroid()) {
			ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB).click();
			ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
			ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
			String rmId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.rmid);
			System.out.println("RMID is : " + rmId);
			ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
			ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(rmId);
			ttbTestContext.findElement(OneAppElementKeys.CITIZEN_ID_NEXT).click();
			enterPin();
			ttbTestContext.findElement(OneAppElementKeys.OTP_HEADER);
			ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
			ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			return;
		} else {

			ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
			ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
			String rmId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.rmid);
			System.out.println("RMID is : " + rmId);

			new TouchAction(ttbTestContext.getDriver()).tap(PointOption.point(ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).getLocation().getX() * 3,
					ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).getLocation().getY())).perform();

			//            ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
			ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(rmId);
			ttbTestContext.findElement(OneAppElementKeys.ENTER_CID_NEXT_BUTTON).click();
			enterPin();
			ttbTestContext.findElement(OneAppElementKeys.OTP_HEADER);
			try {
				Thread.sleep(3000);
			} catch (Exception e){
				System.err.println("Thread Sleep error");
			}
			ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
			ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_DEV479).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_DEV479).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_DEV479).click();
			return;
		}
	}

	@Test(groups = "Activate new flow with change language")
	public void NewActivateFlowChangeLanguage() {
		if (ttbTestContext.isAndroid()) {
			ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB).click();
			ttbTestContext.findElement(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX).click();
			ttbTestContext.findElement(OneAppElementKeys.CHANGE_LANGUAGE_TC).click();
			ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON).click();
			String rmId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.rmid);
			System.out.println("RMID is : " + rmId);
			ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).click();
			ttbTestContext.findElement(OneAppElementKeys.INPUT_RM_FIELD).sendKeys(rmId);
			ttbTestContext.findElement(OneAppElementKeys.CITIZEN_ID_NEXT).click();
			enterPin();
			ttbTestContext.findElement(OneAppElementKeys.OTP_HEADER);
			ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
			ttbTestContext.findElement(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON).click();
			return;
		}
	}

	public void enableWifiAndroid(boolean enable) throws InterruptedException {
		if (enable) {
			((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
			Thread.sleep(2000);
		} else {
			((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
			Thread.sleep(2000);
		}
	}

	public void enableDataNetWorkAndroid(boolean enable) throws InterruptedException {
		if (enable) {
			((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withDataEnabled().build());
			Thread.sleep(2000);
		} else {
			((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withDataDisabled().build());
			Thread.sleep(2000);
		}
	}

	public void initialContext(String deviceProfile) {
		driver = DriverFactory.createDriver(deviceProfile);
		this.ttbTestContext = new TtbTestContext(driver);
	}

	@Test(groups = "Open home screen latest dev prospect")
	public void OpenHomeScreenDEVLatestProspect() {
		if (ttbTestContext.isIos()) {
			WebElement btnGoHomeProspect = ttbTestContext.findElement(OneAppElementKeys.GO_HOME_PROSPECT);
			btnGoHomeProspect.click();
			WebElement BTN_ALLOW = ttbTestContext.findElement(OneAppElementKeys.BTN_ALLOW);
			BTN_ALLOW.click();
		}
		WebElement sauceLabButton = ttbTestContext.findElement(OneAppElementKeys.SAUCELAB_BUTTON);
		sauceLabButton.click();
		WebElement saveDeviceId = ttbTestContext.findElement(OneAppElementKeys.SAVE_DEVICE_ID_BUTTON);
		saveDeviceId.click();
	}

	public void logOut() {
		WebElement MORE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON);
		MORE_BUTTON.click();
		ttbTestContext.verticalSwipeByPercentages(0.8, 0.2, 0.5);
		WebElement LOGOUT_BUTTON = ttbTestContext.findElement(OneAppElementKeys.LOGOUT_BUTTON);
		LOGOUT_BUTTON.click();
		WebElement CONFIRM_LOGOUT_BUTTON = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_LOGOUT_BUTTON);
		CONFIRM_LOGOUT_BUTTON.click();
	}

	public void registerCrmByPassOTP(String rm) throws InterruptedException {

		WebElement regisBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_REGISTER_TTB);
		regisBT.click();

		WebElement register = ttbTestContext.findElement(OneAppElementKeys.LENDING_REGIS_BUTTON);
		register.click();

		WebElement accept = ttbTestContext.findElement(OneAppElementKeys.REGISTER_ACCEPT_CONDITION);
		accept.click();

		WebElement clickNext = ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_BUTTON);
		Thread.sleep(1000);
		clickNext.click();

		WebElement zitizenID = ttbTestContext.findElement(OneAppElementKeys.REGISTER_CITIZEN_ID);
		Thread.sleep(1000);
		zitizenID.click();
		zitizenID.sendKeys(rm);
		Thread.sleep(1000);

		WebElement imageCitizen = ttbTestContext.findElement(OneAppElementKeys.REGISTER_IMAGE);
		Thread.sleep(1000);
		imageCitizen.click();

		System.out.println("CLICK NEXT");
		WebElement nextBT = ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_BUTTON_CITIZEN);
		Thread.sleep(1000);
		nextBT.click();

		Thread.sleep(1000);
		enterPin();

		WebElement otpInput = ttbTestContext.findElement(OneAppElementKeys.REGISTER_OTP);
		otpInput.click();
		Thread.sleep(1000);
		ttbTestContext.getDriver().getKeyboard().sendKeys("111111");


		WebElement nextCom = ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_COMPLETE);
		Thread.sleep(2000);
		nextCom.click();

		WebElement skipNext = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
		Thread.sleep(1000);
		skipNext.click();
		skipNext.click();
		skipNext.click();
	}

	/**
	 * Enter PIN
	 * Example:
	 * enterPIN("123456");
	 */
	public void enterPIN(String pin) {
		if (pin.toCharArray().length != 6) return;
		for (char pinCh : pin.toCharArray()) {
			switch (pinCh) {
			case '0':
				ttbTestContext.findElement(OneAppElementKeys.PIN_0_BUTTON).click();
				break;
			case '1':
				ttbTestContext.findElement(OneAppElementKeys.PIN_1_BUTTON).click();
				break;
			case '2':
				ttbTestContext.findElement(OneAppElementKeys.PIN_2_BUTTON).click();
				break;
			case '3':
				ttbTestContext.findElement(OneAppElementKeys.PIN_3_BUTTON).click();
				break;
			case '4':
				ttbTestContext.findElement(OneAppElementKeys.PIN_4_BUTTON).click();
				break;
			case '5':
				ttbTestContext.findElement(OneAppElementKeys.PIN_5_BUTTON).click();
				break;
			case '6':
				ttbTestContext.findElement(OneAppElementKeys.PIN_6_BUTTON).click();
				break;
			case '7':
				ttbTestContext.findElement(OneAppElementKeys.PIN_7_BUTTON).click();
				break;
			case '8':
				ttbTestContext.findElement(OneAppElementKeys.PIN_8_BUTTON).click();
				break;
			case '9':
				ttbTestContext.findElement(OneAppElementKeys.PIN_9_BUTTON).click();
				break;
			}
		}
	}

	/**
	 * Confirm PIN
	 * Example:
	 * confirmPIN("123456");
	 */
	public void confirmPIN(String pin) {
		if (pin.toCharArray().length != 6) return;
		for (char pinCh : pin.toCharArray()) {
			switch (pinCh) {
			case '0':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_0_BUTTON).click();
				break;
			case '1':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_1_BUTTON).click();
				break;
			case '2':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_2_BUTTON).click();
				break;
			case '3':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_3_BUTTON).click();
				break;
			case '4':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_4_BUTTON).click();
				break;
			case '5':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_5_BUTTON).click();
				break;
			case '6':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_6_BUTTON).click();
				break;
			case '7':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_7_BUTTON).click();
				break;
			case '8':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_8_BUTTON).click();
				break;
			case '9':
				ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_9_BUTTON).click();
				break;
			}
		}
	}

	/**
	 * Register Ttb Touch
	 * Example:
	 * registerTtbTouch("1212121212121","123456",null);
	 */
	public void registerTtbTouch(String citizenId, String pin, String otp) throws InterruptedException {
		pin = pin == null ? "010203" : pin;
		otp = otp == null ? "111111" : otp;
		ttbTestContext.findElement(OneAppElementKeys.LENDING_REGISTER_TTB).click();
		ttbTestContext.findElement(OneAppElementKeys.LENDING_REGIS_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_ACCEPT_CONDITION).click();
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_CITIZEN_ID).click();
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_CITIZEN_ID).sendKeys(citizenId);
		Thread.sleep(1000);
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_IMAGE).click();
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_BUTTON_CITIZEN).click();
		enterPIN(pin);
		ttbTestContext.findElement(OneAppElementKeys.REGISTER_OTP).click();
		ttbTestContext.getDriver().getKeyboard().sendKeys(otp);
		WebElement nextCom = ttbTestContext.findElement(OneAppElementKeys.REGISTER_NEXT_COMPLETE);
		Thread.sleep(2000);
		nextCom.click();
		WebElement skipNext = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
		skipNext.click();
		skipNext.click();
		skipNext.click();
	}


	public void scrollToBottom() {
		Dimension dim = ttbTestContext.getDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int top = (int) (height * 0.80);
		int bottom = (int) (height * 0.20);
		System.out.println("coordinates :" + x + "  " + top + " " + bottom);
		new TouchAction(ttbTestContext.getDriver()).longPress(PointOption.point(0, top))
		.moveTo(PointOption.point(0, bottom)).release()
		.perform();
		// TouchAction touchAction = new TouchAction(ttbTestContext.getDriver());
		//touchAction.press(PointOption.point(0, top)).moveTo(PointOption.point(0, bottom)).release().perform();
	}

	public void scrollToTop() {
		Dimension dim = ttbTestContext.getDriver().manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int top = (int) (height * 0.80);
		int bottom = (int) (height * 0.20);
		System.out.println("coordinates :" + x + "  " + top + " " + bottom);
		new TouchAction(ttbTestContext.getDriver()).longPress(PointOption.point(0, bottom))
		.moveTo(PointOption.point(0, -top)).release()
		.perform();
		// TouchAction touchAction = new TouchAction(ttbTestContext.getDriver());
		//touchAction.press(PointOption.point(0, top)).moveTo(PointOption.point(0, bottom)).release().perform();
	}

	public void setTtbTestContext(TtbTestContext ttbTestContext) {
		this.ttbTestContext = ttbTestContext;
	}
	public String initToken() {
		JavascriptExecutor js = (JavascriptExecutor) getTtbTestContext().getDriver();
		String localStorage = (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", "deviceData"));
		JSONObject json = new JSONObject(localStorage);
		System.out.println(json.toString());
		String device_id = json.getString("device_id");
		System.out.println(device_id);
		OneAppClient client = getOneAppClient();
		client.initToken(device_id);
		return device_id;
	}

	@Test(groups = "Change language application")
	public void changeLanguage() throws InterruptedException {
		WebElement MORE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON);
		MORE_BUTTON.click();
		ttbTestContext.findElement(OneAppElementKeys.SETTING_BUTTON).click();
		Thread.sleep(4000);
		ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
		ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
		ttbTestContext.findElement(OneAppElementKeys.SETTING_CHANGE_LANGUAGE_MENU).click();
		ttbTestContext.findElement(OneAppElementKeys.CHANGE_LANG_THAI_BUTTON).click();
		ttbTestContext.findElement(OneAppElementKeys.CHANGE_LANG_BACK_BUTTON).click();
		Thread.sleep(3000);
		ttbTestContext.findElement(OneAppElementKeys.SETTING_BACK_BUTTON).click();
		Thread.sleep(3000);
	}
	/**
	 * This method to support event the application would like to confirm transaction and need to enter PIN
	 */

	public void enterPinOnUAT() {

		WebElement button0 = ttbTestContext.findElement(OneAppElementKeys.PIN_0_BUTTON_UAT);
		WebElement button1 = ttbTestContext.findElement(OneAppElementKeys.PIN_1_BUTTON_UAT);
		WebElement button2 = ttbTestContext.findElement(OneAppElementKeys.PIN_2_BUTTON_UAT);
		WebElement button3 = ttbTestContext.findElement(OneAppElementKeys.PIN_3_BUTTON_UAT);

		button0.click();
		button1.click();

		button0.click();
		button2.click();

		button0.click();
		button3.click();

	}

	public void confirmPinOnUAT() {

		ttbTestContext.waitUntilVisible(OneAppElementKeys.CONFIRM_PIN_0_BUTTON_UAT);
		WebElement button0 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_0_BUTTON_UAT);
		WebElement button1 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_1_BUTTON_UAT);
		WebElement button2 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_2_BUTTON_UAT);
		WebElement button3 = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_PIN_3_BUTTON_UAT);

		button0.click();
		button1.click();

		button0.click();
		button2.click();

		button0.click();
		button3.click();

	}



}

