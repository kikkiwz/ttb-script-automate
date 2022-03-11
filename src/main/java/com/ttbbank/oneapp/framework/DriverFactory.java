package com.ttbbank.oneapp.framework;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    private static final String appiumLocalUrl = "http://127.0.0.1:4723/wd/hub";
    private static final String appiumUrl = "http://ondemand.us-west-1.saucelabs.com/wd/hub";
    static String configFile = System.getProperty("user.dir") + "/src/main/resources/Global.properties";
    static Properties prop;


    static {
        readConfig();
        initOneAppConfig();
    }

    public static AppiumDriver createDriver(String deviceProfile) {

        DesiredCapabilities desiredCapabilities = getDesiredCapabilities(deviceProfile);
        String platformName = (String) desiredCapabilities.getCapability("platformName");
        String accessKey = (String) desiredCapabilities.getCapability("accessKey");
        String emulator = (String) desiredCapabilities.getCapability("emulator");
        String url = appiumLocalUrl;
        if (accessKey != null) {
            url = appiumUrl;
        }
        if (emulator != null) {
            BaseScenario.startServer();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                //BaseScenario.startEmulator();
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if ("android".equalsIgnoreCase(platformName)) {
            try {
            	System.out.println("The Desired capabilities are---"+desiredCapabilities+"The url is--"+url);
                return new AndroidDriver<>(new URL(url), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        try {
            return new IOSDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AppiumDriver createDriver(String deviceProfile, String scenarioName) {

        DesiredCapabilities desiredCapabilities = getDesiredCapabilities(deviceProfile);
        desiredCapabilities.setCapability("name", scenarioName);
        String platformName = (String) desiredCapabilities.getCapability("platformName");
        String accessKey = (String) desiredCapabilities.getCapability("accessKey");
        String emulator = (String) desiredCapabilities.getCapability("emulator");
        String url = appiumLocalUrl;
        if (accessKey != null) {
            url = appiumUrl;
        }
        if (emulator != null) {
            BaseScenario.startServer();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
//    			BaseScenario.startEmulator();
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if ("android".equalsIgnoreCase(platformName)) {
            try {
                System.out.println("The Desired capabilities are---" + desiredCapabilities + "The url is--" + url);
                return new AndroidDriver<>(new URL(url), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        try {
            return new IOSDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void initOneAppConfig() {
        OneAppConfig oneAppConfig = OneAppConfig.getInstance();
        oneAppConfig.setProp(prop);
    }

    private static DesiredCapabilities getDesiredCapabilities(String deviceProfileName) {
        String userName = prop.getProperty(deviceProfileName + "." + DeviceProfile.userName);
        String accessKey = prop.getProperty(deviceProfileName + "." + DeviceProfile.accessKey);
        String emulator = prop.getProperty(deviceProfileName + "." + DeviceProfile.emulator);
        String name = prop.getProperty(deviceProfileName + "." + DeviceProfile.name, "Untitle");
        String platformName = prop.getProperty(deviceProfileName + "." + DeviceProfile.platformName);
        String platformVersion = prop.getProperty(deviceProfileName + "." + DeviceProfile.platformVersion);
        String deviceName = prop.getProperty(deviceProfileName + "." + DeviceProfile.deviceName);
        String appPackage = prop.getProperty(deviceProfileName + "." + DeviceProfile.appPackage);
        String noReset = prop.getProperty(deviceProfileName + "." + DeviceProfile.noReset, "true");
        String app = prop.getProperty(deviceProfileName + "." + DeviceProfile.app);


        String deviceId = prop.getProperty(deviceProfileName + "." + DeviceProfile.deviceId);
        String udid = prop.getProperty(deviceProfileName + "." + DeviceProfile.udid);
        String record = prop.getProperty(deviceProfileName + "." + DeviceProfile.record);
        String appActivity = prop.getProperty(deviceProfileName + "." + DeviceProfile.appActivity);
        String automationName = prop.getProperty(deviceProfileName + "." + DeviceProfile.automationName);
        String xcodeOrgId = prop.getProperty(deviceProfileName + "." + DeviceProfile.xcodeOrgId);
        String xcodeSigningId = prop.getProperty(deviceProfileName + "." + DeviceProfile.xcodeSigningId);
        String env = prop.getProperty(deviceProfileName + "." + DeviceProfile.env, "vit");
        String rmid = prop.getProperty(deviceProfileName + "." + DeviceProfile.rmid);
        String citizenId = prop.getProperty(deviceProfileName + "." + DeviceProfile.citizenId);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(DeviceProfile.userName, userName);
        desiredCapabilities.setCapability(DeviceProfile.accessKey, accessKey);
        desiredCapabilities.setCapability(DeviceProfile.name, name);
        desiredCapabilities.setCapability(DeviceProfile.platformName, platformName);
        desiredCapabilities.setCapability(DeviceProfile.platformVersion, platformVersion);
        desiredCapabilities.setCapability(DeviceProfile.deviceName, deviceName);
        desiredCapabilities.setCapability(DeviceProfile.appPackage, appPackage);
        desiredCapabilities.setCapability(DeviceProfile.appActivity, appActivity);
        desiredCapabilities.setCapability(DeviceProfile.noReset, noReset);
        desiredCapabilities.setCapability(DeviceProfile.app, app);
        desiredCapabilities.setCapability(DeviceProfile.deviceId, deviceId);
        desiredCapabilities.setCapability(DeviceProfile.udid, udid);
        desiredCapabilities.setCapability(DeviceProfile.record, Boolean.parseBoolean(record));
        desiredCapabilities.setCapability(DeviceProfile.automationName, automationName);
        desiredCapabilities.setCapability(DeviceProfile.xcodeOrgId, xcodeOrgId);
        desiredCapabilities.setCapability(DeviceProfile.xcodeSigningId, xcodeSigningId);
        desiredCapabilities.setCapability(DeviceProfile.env, env);
        desiredCapabilities.setCapability(DeviceProfile.emulator, emulator);
        desiredCapabilities.setCapability(DeviceProfile.citizenId, citizenId);
        desiredCapabilities.setCapability(DeviceProfile.rmid, rmid);
        desiredCapabilities.setCapability(DeviceProfile.citizenId, citizenId);
        desiredCapabilities.setCapability(DeviceProfile.chromedriverExecutable
                , System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver_96");
		desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//        desiredCapabilities.setCapability(DeviceProfile.browserName, MobileBrowserType.CHROME);
//        desiredCapabilities.setCapability(DeviceProfile.chromedriverExecutable, "src/main/resources/chromedriver_92");
//        desiredCapabilities.setCapability("browserName", "Chrome");
//        desiredCapabilities.setCapability("chromedriverExecutable", "/Users/user/Documents/Automation Testing/automation/automation-testing/src/main/resources/chromedriver_92");


        String oneAppBuild = System.getProperty("oneAppBuild");
        if (oneAppBuild != null) {
            app = "storage:filename=" + oneAppBuild;
            desiredCapabilities.setCapability(DeviceProfile.app, app);
            System.out.println("found app from system property, version is---" + app);

        }
        System.out.println("The app version is---" + app);
        return desiredCapabilities;

    }

    private static void readConfig() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            prop.load(fis);
        } catch (IOException ex) {

        }
    }
}
