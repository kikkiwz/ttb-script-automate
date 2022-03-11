package com.tmb.automation.autoloan.oneappnative;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.util.Scrolling;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.function.Function;

public class NativeBase {
    private static String appiumUrl = "http://127.0.0.1:4723/wd/hub";

    private static AppiumDriver<WebElement> driver;
    private static WebDriverWait wait;
    private static String platform;


    public static AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    public static String getPlatform() {
        return platform;
    }

    public static void init(String platform) throws MalformedURLException {
        NativeBase.platform = platform;
        driver = initDriver(platform);
        wait = new WebDriverWait(driver, 300, 300);
        
        System.out.println("The driver is---"+driver);
        if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
        	System.out.println("Executing on sauceLab on android");	
        	try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	List<WebElement> skip=driver.findElements(By.id("com.ttbbank.oneapp.vit:id/skipIntro"));
        	 System.out.println("The Skip into  is---"+skip);
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
        else  if(driver.getCapabilities().toString().contains("accessKey") && Helper.CONFIG_PROFILE.contains("Saucelabios")) {
        	System.out.println("Executing on sauceLab on ios");	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"))).isDisplayed();			
		WebElement skipid=(MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"));
		skipid.click();
		System.out.println("Skip ID is clicked");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")));
      	MobileElement Enterid=(MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
		Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
		System.out.println("Device ID is entered");
		WebElement savedeviceID=(MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]"));
		savedeviceID.click();
		
        }
    }


    public static void waitById(String id) {
        Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
            driver.findElementById(id);
            return true;
        };
        wait.until(func);
    }

    public static void waitByAccessibilityId(String accessibilityId) {
        Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
            getDriver().findElementByAccessibilityId(accessibilityId);
            return true;
        };
        wait.until(func);
    }

    public static void waitByByXPath(String xPath) {
        Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver -> {
            getDriver().findElement(By.xpath(xPath));
            return true;
        };
        wait.until(func);
    }

    public static void waitByElementId(String iD){
        Function<? super WebDriver, ?> func = (Function<WebDriver, Object>) webDriver ->{
            driver.findElementById(iD);
            return true;
        };
        wait.until(func);
    }

    public static void takeScreenshot(String name) throws IOException {
        File file = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/reports/" + name));
    }

    private static AppiumDriver<WebElement> getAppiumDriverAndroid() throws MalformedURLException {
    	AppiumDriver<WebElement> appiumDriver;
    	 String profile = Helper.CONFIG_PROFILE+".";
    	 String Environment=System.getProperty("Environment");
    		if (profile.trim().isEmpty()) {
    			Log.logger.debug("profile is empty");
    		}
    	if(!Helper.CONFIG_PROFILE.contains("SaucelabAndroid")) {
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "BEV5T18B22001532");
        caps.setCapability("appPackage", "com.ttbbank.oneapp.vit");
        caps.setCapability("appActivity", "com.ttbbank.oneapp.presentation.splash.SplashActivity");
        caps.setCapability("noReset", "true");
        caps.setCapability("udid", "BEV5T18B22001532");
        caps.setCapability("chromedriverExecutable",
                Helper.getUserDir() + "/src/main/resources/chromedriver_mac_m1");
        appiumDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
        
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
   		appiumDriver=new AndroidDriver<WebElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);				
   	
       }
    	return appiumDriver;
    	
    }

    private static AppiumDriver<WebElement> getAppiumDriverIOS() throws MalformedURLException {
    	 String profile = Helper.CONFIG_PROFILE+".";
    	 String Environment=System.getProperty("Environment");
    	 AppiumDriver<WebElement> appiumDriver ;
 		if (profile.trim().isEmpty()) {
 			Log.logger.debug("profile is empty");
 		}
 		if(!Helper.CONFIG_PROFILE.contains("Saucelabios")) {
 		
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "14.3");
        caps.setCapability("deviceName", "iPhone 12 Pro Max");
        caps.setCapability("app", "/Users/USER/Downloads/OneApp 2.app");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("noReset", "true");
        caps.setCapability("udid", "7850D285-E174-4D69-AB1A-C11764EDB96A");
       appiumDriver = new IOSDriver<>(new URL(appiumUrl), caps);
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
	    appiumDriver=new IOSDriver<WebElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
	     
 		}
 		return appiumDriver;
    }
       public static AppiumDriver<WebElement> initDriver(String platform) throws MalformedURLException {
        if ("android".equalsIgnoreCase(platform))
        	
        	return getAppiumDriverAndroid();
        
        else 
        	
        return getAppiumDriverIOS();
        

		
            
    }

    private void enterPinIOS(AppiumDriver<WebElement> driver, String pin) {
        String BUTTON_0 = "//XCUIElementTypeStaticText[@name=\"0\"]";
        String BUTTON_1 = "//XCUIElementTypeStaticText[@name=\"1\"]";
        String BUTTON_2 = "//XCUIElementTypeStaticText[@name=\"2\"]";
        String BUTTON_3 = "//XCUIElementTypeStaticText[@name=\"3\"]";
        MobileElement button0 = (MobileElement) driver.findElementByXPath(BUTTON_0);
        MobileElement button1 = (MobileElement) driver.findElementByXPath(BUTTON_1);
        MobileElement button2 = (MobileElement) driver.findElementByXPath(BUTTON_2);
        MobileElement button3 = (MobileElement) driver.findElementByXPath(BUTTON_3);

        button0.click();
        button1.click();
        button0.click();
        button2.click();
        button0.click();
        button3.click();
    }

    private void enterPinAndroid(AppiumDriver<WebElement> driver, String pin) {
        MobileElement b0 = (MobileElement) driver.findElementById("com.ttbbank.oneapp.vit:id/key_00");
        MobileElement b1 = (MobileElement) driver.findElementById("com.ttbbank.oneapp.vit:id/key_01");
        MobileElement b2 = (MobileElement) driver.findElementById("com.ttbbank.oneapp.vit:id/key_02");
        MobileElement b3 = (MobileElement) driver.findElementById("com.ttbbank.oneapp.vit:id/key_03");

        b0.click();
        b1.click();
        b0.click();
        b2.click();
        b0.click();
        b3.click();
    }


    public void enterPin(AppiumDriver<WebElement> driver, String platform, String pin) {
        if (platform.equalsIgnoreCase("android")) enterPinAndroid(driver, pin);
        else
            enterPinIOS(driver, pin);
    }


}
