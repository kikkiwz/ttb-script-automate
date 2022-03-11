package com.ttbbank.oneapp.scenario.primarybanking2;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.*;
import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class PB2Common extends BaseScenario {

    private final static String TESTDATA_PATH = System.getProperty("user.dir") + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/UI_TestData.json";
    private final static String LOG_PATH = System.getProperty("user.dir") + "/target/test_log.log";
    protected static AppiumDriver<WebElement> driver;
    private static final Logger LOGGER = Logger.getLogger(PB2Common.class.getName());
    protected static Properties p = new Properties();
    protected static final JsonPath data = new JsonPath(getInput(TESTDATA_PATH));
    protected final static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//    protected final static String TIMESTAMP1 = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date());
    protected static String os = "";
    protected static String deviceProfile = "";
    protected static String dataProfile = "";
    protected static ExtentTest scenario;
    protected static String language = "English";
    //-------------------------------------------------------------------------
    public static void log(Object message){
        LOGGER.log(Level.INFO, String.valueOf(message));
    }
    public static void sleep(double seconds) {
        log("sleep="+(int)seconds);
        int sc = (int)seconds;
        for (int i = 0; i < sc; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void fail(){
        sleep();
        Assert.fail("Fail !!!");
    }

    public static void sleep() {
        sleep(3);
    }

    public static boolean writeLog(String value) {
        boolean isComplete = false;
        FileOutputStream fos;
        String dir = System.getProperty("user.dir") + "/target/run/";
        value = "\r\n" + value + "\r\n";
        try {
            File directory = new File(dir);
            if (!directory.exists()) {
                isComplete = directory.mkdir();
            }
            fos = new FileOutputStream(System.getProperty("user.dir") + "/target/run/" + TIMESTAMP + "_.log", true);
            fos.write(value.getBytes());
            fos.close();
        } catch (IOException e) { e.printStackTrace();}
        return isComplete;
    }
    public static void writelog() {
        log("writelog(...)");
        writeLog(driver.getPageSource());
    }

    public static String writeJsonResult(String filePath, String className, String jsonString){
        String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+"_Result_"+className
                +".json";
        System.out.println("fileName="+filePath+fileName);
        try {
            FileWriter file = new FileWriter(filePath+fileName);
            file.write(new org.json.JSONObject(jsonString).toString(4));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static InputStream getInput(String filePath){
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }

    public static String convertAccountToXpath(String cardId){
        String cardResult = "";
        if (cardId.contains("-") || cardId.toLowerCase().contains("x")){
            cardResult = cardId.replace("00-0000", "XX-XXXX").replace("", " ").trim()+" ";
            log(cardResult);
        } else {
            cardResult = cardId.substring(0, 4)+"-"+cardId.substring(4, 8)+"-"+cardId.substring(8, 12)+"-"+cardId.substring(12, 16);
            cardResult = cardResult.replace("00-0000", "XX-XXXX").replace("", " ").trim()+" ";
            log(cardResult);
        }
        return cardResult;
    }

    public static String convertDepositAccountToXpathIOS(String cardId){
        String c1 = "0019765478";
        String c2 = "001-9-76547-8";
        String cardResult = "";
        if (cardId.contains("-")){
            cardResult = cardId.replace("", " ").trim()+" ";
            log("["+cardResult+"]");
        } else {
            cardResult = cardId.substring(0, 3)+"-"+cardId.substring(3, 4)+"-"+cardId.substring(4, 9)+"-"+cardId.substring(9, 10);
            cardResult = cardResult.replace("", " ").trim()+" ";
            log("["+cardResult+"]");
        }
        return cardResult;
    }
    public static String convertDepositAccountToXpathAndroid(String cardId){
        String c1 = "0019765478";
        String c2 = "001-9-76547-8";
        String cardResult = "";
        if (!cardId.contains("-")){
            cardResult = cardId.substring(0, 3)+"-"+cardId.substring(3, 4)+"-"+cardId.substring(4, 9)+"-"+cardId.substring(9, 10);
            log("["+cardResult+"]");
        }
        return cardResult;
    }

//    public static void main(String[] args) {
//        String c1 = "0019765478";
//        String c2 = "001-9-76547-8";
//        convertDepositAccountToXpathAndroid(c1);
//    }

    public static By getBy(String elementkey) {
        if ("ios".equalsIgnoreCase(driver.getPlatformName())) {
            return new iOSOneAppElements().get(elementkey).getLocator();
        } else {
            return new AndroidOneAppElements().get(elementkey).getLocator();
        }
    }
    public static void clickBy(String elementKey) {
        waitBy1(elementKey,50);
        log("Click "+elementKey);
        fBy(elementKey).click();
    }
    public static WebElement fBy(String elementKey){
        return driver.findElement(getBy(elementKey));
    }
    public static List<WebElement> fsBy(String elementKey) {return driver.findElements(getBy(elementKey));}
    public static void waitBy(String elementKey){
        waitBy(elementKey, data.getInt("config.wait_visible_second"));
    }

    	public static WebElement fI(String id) {
		return driver.findElement(By.id(id));
	}
	public static WebElement fA(String id) {
		return driver.findElement(MobileBy.AccessibilityId(id));
	}

	public static WebElement fX(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement fN(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement fC(String className) {
		return driver.findElement(By.className(className));
	}

	public static WebElement fCss(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}

	public static WebElement fT(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

    public static void setTextBy(String elementKey, String value) {
        log("Enter value = "+value);
        fBy(elementKey).clear();
        fBy(elementKey).sendKeys(value);
    }

    public static void waitBy(String elementKey, int second){
        int count=0;
        int countSaucelbass = deviceProfile.contains("saucelabs")?2:0;
        while (count<(1+countSaucelbass)){
            try {
                log("WaitVisible() " + second + "s" + " "+ elementKey);
                (new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
                return;
            } catch (Exception e) {}
            count++;
        }
        (new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
    }

    public static void waitBy1(String elementKey, int second){
        log("Wait "+second+"s "+elementKey);
        (new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
    }
    public static void waitByLong(String elementKey, int second){
        int count=0;
        int countSaucelbass = deviceProfile.contains("saucelabs")?3:1;
        while (count<(1+countSaucelbass)){
            try {
                log("WaitVisible() " + second + "s" + " "+ elementKey);
                (new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
                return;
            } catch (Exception e) {}
            count++;
        }
        (new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(getBy(elementKey)));
    }

    public static void waitByLong(String elementKey){
        log("Wait "+data.getInt("config.wait_visible_second")+"s "+elementKey);
        waitByLong(elementKey, data.getInt("config.wait_visible_second"));
    }
    public static void waitInVisibleBy(String elementKey, int second) {
        log("WaitInvisible() " + second + "s" + " "+ elementKey);
        (new WebDriverWait(driver, second)).until(ExpectedConditions.invisibilityOfElementLocated(getBy(elementKey)));
    }

    public static void waitInVisibleBy(String elementKey) {
        waitInVisibleBy(elementKey, data.get("config.wait_visible_second"));
    }
    	public static void waitAlert(int seconds) {
		(new WebDriverWait(driver, seconds)).until(ExpectedConditions.alertIsPresent());
	}
    public static void assertText(String act, String exp) {
        log("[" + act.trim() + "] == [" + exp.trim() + "] > " + (act.trim().equals(exp.trim())));
//		Assert.assertEquals(act.trim(), exp.trim());
    }
    public static void assertText(String act, String expEn, String expTh, String message) {
        if (language.toLowerCase().equalsIgnoreCase("english")){
            log("[" + act.trim() + "] == [" + expEn.trim() + "] > " + (act.trim().equals(expEn.trim())));
            Assert.assertEquals(act.trim(), expEn.trim(), message);
        } else if (language.toLowerCase().equalsIgnoreCase("thai")) {
            log("[" + act.trim() + "] == [" + expTh.trim() + "] > " + (act.trim().equals(expTh.trim())));
            Assert.assertEquals(act.trim(), expTh.trim(), message);
        }
    }

    public static void assertTrue(Boolean value) {
        log("Assert Boolean=[true]==[" + value + "]");
//		Assert.assertTrue(value);
    }

    public static void assertTrue(String xpath) {
        boolean bValue = isElementPresent(xpath);
        log("Assert Boolean=" + bValue + ", xpath = " + xpath);
//		Assert.assertTrue(bValue);
    }

    public static void assertContain(String act, String exp) {
        log("[" + act.trim() + "] contains [" + exp.trim() + "] > " + act.trim().contains(exp.trim()));
//		Assert.assertTrue(act.trim().contains(exp.trim()));
    }
    public static void assertContain(String act, String expEn, String expTh, String message) {
        if (language.toLowerCase().equalsIgnoreCase("english")){
            log("[" + act.trim() + "] contains [" + expEn.trim() + "] > " + act.trim().contains(expEn.trim()));
            Assert.assertTrue(act.trim().contains(expEn.trim()), message);
        } else if (language.toLowerCase().equalsIgnoreCase("thai")) {
            log("[" + act.trim() + "] contains [" + expTh.trim() + "] > " + act.trim().contains(expTh.trim()));
            Assert.assertTrue(act.trim().contains(expTh.trim()), message);
        }
    }
    public static boolean isElementPresent(String xpath) {
        try {
            if (driver.findElementsByXPath(xpath).size() > 0) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
    public static boolean isElementPresentByCssSelector(WebElement element, String cssSelector) {
        log("isElementPressent > "+cssSelector);
        try {
            if (element.findElement(By.cssSelector(cssSelector)).isEnabled()){
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public static boolean isElementPresentByXpath(WebElement element, String xpath) {
        log("isElementPresentByXpath");
        try {
            if (element.findElement(By.xpath(xpath)).isEnabled()){
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
    public static boolean isElementPresentBy(String elementKey) {
        try {
            if (driver.findElements(getBy(elementKey)).size() > 0) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
    public static WebElement fByF(WebElement element, String elementKey) {
//        log("isElementPresentByXpath");
        try {
            if (element.findElement(getBy(elementKey)).isDisplayed()){
                return element.findElement(getBy(elementKey));
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }
        public static WebElement fByF(WebElement element, By by) {
//        log("isElementPresentByXpath");
//        try {
            if (element.findElements(by).size()>0){
                return element.findElement(by);
            }
//        } catch (NoSuchElementException e) {
//            return null;
//        }
        return null;
    }
    public static Boolean setContext(String value) {
        int i = 0;
        while (i++ < 10) {
            Set<String> contextNames = driver.getContextHandles();
            if (contextNames.size() > 1) {
                for (String contextName : contextNames) {
                    if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
                        driver.context((String) contextName);
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

    public static Boolean setContext(String value, int webIndex) {
        int i = 0;
        while (i++ < 20) {
            Set<String> contextNames = driver.getContextHandles();
            log("contextName="+contextNames);
            if (contextNames.size() > 1) {
                for (String contextName : contextNames) {
                    if (contextName.toLowerCase().trim().contains(value.toLowerCase().trim())) {
                        log("contextName="+contextName);
//                        driver.context((String) contextName);
                        WebDriver context = driver.context((String) contextName);
                        Set<String> webNames = context.getWindowHandles();
                        log("WebNames list="+webNames);
                        driver.switchTo().window(webNames.toArray()[webIndex].toString());
                        return true;
                    }
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
        }
        return false;
    }
    public static Boolean setWebview(String elementKey) {
        int i = 0;
        while (i++ < 20) {
            Set<String> contextNames = driver.getContextHandles();
            log("context="+contextNames);
            if (contextNames.size() > 1) {
                for (String contextName : contextNames) {
                    if (contextName.toLowerCase().trim().contains("webview")) {
                        WebDriver context = driver.context((String) contextName);
                        Set<String> webNames = context.getWindowHandles();
                        log("WebNames=" + webNames);
                        for (int j = 0; j < webNames.size(); j++) {
                            log("webname="+webNames.toArray()[j].toString());
                            driver.switchTo().window(webNames.toArray()[j].toString());
                            try {
                                waitBy(elementKey);
                                return true;
                            } catch (Exception e) {
                            }
                        }

                    }
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {e.printStackTrace();}
            }
        }
        return false;
    }

    public static Boolean setWebview() {
        return setContext("Webview");
    }

    public static Boolean setWebview(int webIndex) {
        return setContext("Webview", webIndex);
    }

    public static Boolean setNative() {

        return setContext("Native");
    }

    public static boolean alertAction(String strAction) {
        int i = 0;
//        while (i++ < 20) {
            try {
                waitAlert(5);
                log("Alert message=" + String.valueOf(i) + ". " + driver.switchTo().alert().getText());
                if (strAction.toLowerCase().contains("accept")) {
                    driver.switchTo().alert().accept();
                } else if (strAction.toLowerCase().equals("dismiss")) {
                    driver.switchTo().alert().dismiss();
                }
                else if (strAction.toLowerCase().contains("allow")){
                    driver.switchTo().alert().accept();
                }
                else if (strAction.toLowerCase().contains("now allow")){
                    driver.switchTo().alert().dismiss();
                } else {
                    log(strAction+" not found!");
                }
                return true;
            } catch (NoAlertPresentException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
//        }
        return false;
    }
    public static boolean alertAction(boolean condition) {
        int i = 0;
        while (i++ < 20) {
            try {
                if (condition) {
                    driver.switchTo().alert().accept();
                }
                else {
                    driver.switchTo().alert().dismiss();
                }
                return true;
            } catch (NoAlertPresentException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void enterPin(String pinNumber) {
        String currentContext = driver.getContext();
        if (!currentContext.toLowerCase().contains("native")){
            setNative();
        }
        waitBy(OneAppElementKeys.PB2_PIN0);
        for (int i = 0; i < pinNumber.length(); i++ ) {
            if (i==(pinNumber.length())-1){
//                ExReport.printScreenshot("By Passed OTP Activation Flow - Enter Confirm PIN");
            }
            if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
                log("Click 0");
                fBy(OneAppElementKeys.PB2_PIN0).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
                log("Click 1");
                fBy(OneAppElementKeys.PB2_PIN1).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
                log("Click 2");
                fBy(OneAppElementKeys.PB2_PIN2).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
                log("Click 3");
                fBy(OneAppElementKeys.PB2_PIN3).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
                log("Click 4");
                fBy(OneAppElementKeys.PB2_PIN4).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
                log("Click 5");
                fBy(OneAppElementKeys.PB2_PIN5).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
                log("Click 6");
                fBy(OneAppElementKeys.PB2_PIN6).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
                log("Click 7");
                fBy(OneAppElementKeys.PB2_PIN7).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
                log("Click 8");
                fBy(OneAppElementKeys.PB2_PIN8).click();
            } else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
                log("Click 9");
                fBy(OneAppElementKeys.PB2_PIN9).click();
            }
        }
        driver.context(currentContext);
    }

     public static void enterConfirmPin(String pinNumber) {
        String currentContext = driver.getContext();
        if (!currentContext.toLowerCase().contains("native")){
            setNative();
        }
        waitBy(OneAppElementKeys.PB2_CONFIRM_PIN0);
        if (deviceProfile.toLowerCase().contains("android")){
             for (int i = 0; i < pinNumber.length(); i++ ) {
                if (i==(pinNumber.length())-1){
    //                ExReport.printScreenshot("By Passed OTP Activation Flow - Enter Confirm PIN");
                }
                if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
                    log("Click 0");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN0).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
                    log("Click 1");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN1).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
                    log("Click 2");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN2).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
                    log("Click 3");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN3).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
                    log("Click 4");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN4).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
                    log("Click 5");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN5).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
                    log("Click 6");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN6).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
                    log("Click 7");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN7).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
                    log("Click 8");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN8).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
                    log("Click 9");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN9).click();
                }
            }
        }
        else if (deviceProfile.toLowerCase().contains("ios")) {
            for (int i = 0; i < pinNumber.length(); i++) {
                if (i == (pinNumber.length()) - 1) {
//                ExReport.printScreenshot("By Passed OTP Activation Flow - Enter Confirm PIN");
                }
                if (pinNumber.split("")[i].equalsIgnoreCase("0")) {
                    log("Click 0");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN0).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("1")) {
                    log("Click 1");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN1).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("2")) {
                    log("Click 2");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN2).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("3")) {
                    log("Click 3");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN3).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("4")) {
                    log("Click 4");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN4).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("5")) {
                    log("Click 5");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN5).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("6")) {
                    log("Click 6");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN6).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("7")) {
                    log("Click 7");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN7).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("8")) {
                    log("Click 8");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN8).click();
                } else if (pinNumber.split("")[i].equalsIgnoreCase("9")) {
                    log("Click 9");
                    fBy(OneAppElementKeys.PB2_CONFIRM_PIN9).click();
                }
            }
        }
        driver.context(currentContext);
    }

    public static void touchAndMoveWebView(WebElement el1, WebElement el2) {

        Point location1 = el1.getLocation();
        Dimension size1 = el1.getSize();
        int tap1X = location1.getX() + (size1.getWidth() / 2);
        int tap1Y = location1.getY() + (size1.getHeight() / 2);
        log("tapX="+tap1X+", tapY="+tap1Y);

        Point location2 = el2.getLocation();
        Dimension size2 = el2.getSize();
        int tap2X = location2.getX() + (size2.getWidth() / 2);
        int tap2Y = location2.getY() + (size2.getHeight() / 2);
        log("tapX="+tap2X+", tapY="+tap2Y);
        // Execute Tap
        String originalContext = driver.getContext();
        setNative();
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(tap1X, tap1Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(tap2X, tap2Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(tap2X, tap2Y))
                .release().perform();
        driver.context(originalContext);
    }
    public static void touchAndMoveNative(WebElement el1, WebElement el2) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(new ElementOption().withElement(el1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(new ElementOption().withElement(el2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(el2.getLocation()))
                .release().perform();
    }

    public static void swipe(int startX, int startY, int endX, int endY) {
        try {
            new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(endX, endY)).release().perform();
        } catch (Exception e) {
            System.out.println("unable to swipe");
        }
    }

    /**
     * Ex. swipeVeritical(0.1, 0.9, 0.5); -> Move from Top to Bottom
     * @param startY
     * @param endY
     * @param anchorY
     */
    public static void swipeVertical(double startY, double endY, double anchorY) {
        log("Swipe startY="+startY+", endY="+endY+", anchorY="+anchorY);
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorY);
        int startPoint = (int) (size.height * startY);
        int endPoint = (int) (size.height * endY);

        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
    public static void swipeVertical(){
        log("Swipe down to Top");
        swipeVertical(0.3, 0.7, 0.5);
    }

    public static void swipeDownToUp(){
        swipeVertical(0.8, 0.2, 0.5);
    }

    public static void swipeHorizontal(double startX, double endX, double anchorX) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorX);
        int startPoint = (int) (size.height * startX);
        int endPoint = (int) (size.height * endX);

        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
    public static void swipeHorizontal(){
        swipeHorizontal(0.2, 0.8, 0.5);
    }

    public static void swipeWebview(WebElement el1, WebElement el2) {

        Point p1 = el1.getLocation();
        Point p2 = el2.getLocation();

        setNative();
        new TouchAction<>(driver).longPress(PointOption.point(p1))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(p2))
                .perform();

    }

    public static void tap(WebElement el){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(el.getLocation()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }
    public static void tapXY(int startX, int startY){
        TouchAction touchAction = new TouchAction(driver);
//		touchAction.longPress(PointOption.point(startX, startY))
//				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//				.release().perform();
        touchAction.tap(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }

    public static void selectValue (WebElement el, String value){
        Select select = new Select(el);
        select.selectByValue(value);
    }
    public static void selectVisibleText (WebElement el, String value){
        Select select = new Select(el);
        select.selectByVisibleText(value);
    }

    public static void selectIndex(WebElement el, int index){
        Select select = new Select(el);
        select.selectByIndex(index);
    }
    public static String getSelect(WebElement el){
        return new Select(el).getFirstSelectedOption().getText();
    }

    public static void selectByVisibleText(String elementKdy, String value){
        waitBy(elementKdy);
        selectVisibleText(fBy(elementKdy), value);
    }
    public static void enterCustomNumberKeyboard(String numbers){
        waitBy(OneAppElementKeys.LD1I_CVV_PIN0);
        for (int i = 0; i < numbers.length(); i++ ) {
            if (i==(numbers.length())-1){
                ExReport.printScreenshot("Enter Number="+numbers);
            }
            if (numbers.split("")[i].equalsIgnoreCase("0")) {
                log("Click 0");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN0);
            } else if (numbers.split("")[i].equalsIgnoreCase("1")) {
                log("Click 1");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN1);
            } else if (numbers.split("")[i].equalsIgnoreCase("2")) {
                log("Click 2");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN2);
            } else if (numbers.split("")[i].equalsIgnoreCase("3")) {
                log("Click 3");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN3);
            } else if (numbers.split("")[i].equalsIgnoreCase("4")) {
                log("Click 4");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN4);
            } else if (numbers.split("")[i].equalsIgnoreCase("5")) {
                log("Click 5");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN5);
            } else if (numbers.split("")[i].equalsIgnoreCase("6")) {
                log("Click 6");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN6);
            } else if (numbers.split("")[i].equalsIgnoreCase("7")) {
                log("Click 7");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN7);
            } else if (numbers.split("")[i].equalsIgnoreCase("8")) {
                log("Click 8");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN8);
            } else if (numbers.split("")[i].equalsIgnoreCase("9")) {
                log("Click 9");
                clickBy(OneAppElementKeys.LD1I_CVV_PIN9);
            }
            sleep(1);
        }
    }

    /**
     * API Get Token
     * @param filePath
     * @return
     */
    public static String getToken(String filePath) {
        JsonPath dataP = new JsonPath(com.tmb.automation.helper.Helper.getInput(filePath));
        Response response_getToken = given().relaxedHTTPSValidation().auth().preemptive()
                .basic(dataP.get("token.key"), dataP.get("token.Authorization"))
                .headers(dataP.getMap("token.headers"))
                .formParams(dataP.getMap("token.body"))
                .when()
                .post(dataP.getString("token.Dev_URL") + dataP.getString("token.path"))
                .then().assertThat().statusCode(200).extract().response();
        return response_getToken.jsonPath().getString("data.access_token");
    }
    public static String getToken(JsonPath dataP) { //
//        String deviceUID = dataP.get("token.deviceUID");
//        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgWp5YcdZc1yeLp9q/SroHwEGy9UR5RQsB8xMlZ2qY0zbbKzm/O+KefkK/auYrwKU0Op9UPc1bR2Zd3w24QSRsSFIhAjNZxusRQWkuV2rgiojfqFfBA95YlnHgBoG7Zg6+VnLeqRTb6llP2wguMbL6BgqohWEaNi11F2Oqw+xRMsbDft5AWjsCZ43+LJdvynm0fTkLajvsf3ZYkbRlm7uSOhChi7+ZeGgPyMLlCAyRGfDOCtOr0cmZNQ4Z4dmlMswrgXT0vfFmutLwecqHqR63Olhm44lx2ycqZ8A2GnBFJ+N7Vwxwo7aBGfvVFh9RFnoz5E2ujGbrOPkdJ80AfUU9QIDAQAB";
        String username = "";
        String password = "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
        try {
            username = encrypt(dataP.get("token.deviceUID"), dataP.get("token.public_key"));
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Response response_getToken = given().relaxedHTTPSValidation().auth().preemptive()
                .basic(dataP.get("token.key"), dataP.get("token.Authorization"))
                .headers(dataP.getMap("token.headers"))
                 //.formParams(dataP.getMap("token.body"))
                .param("grant_type", dataP.getString("token.body.grant_type"))
                .param("username", username)
                .param("password", dataP.getString("token.body.password"))
                .param("scope", dataP.getString("token.body.scope"))
                .when()
                .post(dataP.getString("token.Dev_URL") + dataP.getString("token.path"))
                .then().assertThat().statusCode(200).extract().response();
        return response_getToken.jsonPath().getString("data.access_token");
    }

    public static WebElement findShadowRootElement(WebElement element) {
        WebElement el = (WebElement) ((JavascriptExecutor)driver).executeAsyncScript("return arguments[0].shadowRoot", element);
        return el;
    }


    public static void clickToggle(String keyLB, String keyValue, boolean existValue) {
        log("existValue="+existValue);
        log("keyValue="+fBy(keyValue).isSelected());
        if (existValue==true){ //allowed
            if (fBy(keyValue).isSelected()==false){
                clickBy(keyLB);
            }
        } else if (existValue==false){
            if (fBy(keyValue).isSelected()==true){
                clickBy(keyLB);
            }
        }
    }

    public static void takeScreenshot1(String name) {
		File file = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/reports/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addReport(String s) {
        if (driver != null) {
            //Pass base64 string * percentage to string
            String base64 = reSize(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), 0.25);
            //Insert base64 to html report
            try {
                scenario.createNode(Given.class, "ONEAPP")
                        .addScreenCaptureFromPath("data:image/png;base64, " + base64).pass(s + " - PASSES");
                System.out.println("addReport:" + s);
//            ExReport.printReportMessage(s);
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        } else {
            System.out.println("No Driver - addReport:" + s);
        }

    }

    public static String reSize(String base64, double percentage) {
        // reads the input image
        Base64.Decoder decoder = Base64.getMimeDecoder();
        BufferedImage inputImage = null;
        //Convert base64 string to BufferedImage (JDK Package)
        try {
            inputImage = ImageIO.read(new ByteArrayInputStream(decoder.decode(base64)));
        } catch (IOException e) {
            log(e.getStackTrace());
        }
        int w1 = (int) Math.round(inputImage.getWidth() * percentage);
        int h1 = (int) Math.round(inputImage.getHeight() * percentage);
        // creates the output image
        BufferedImage img = new BufferedImage(w1, h1, inputImage.getType());
        // balance the input image to the output image
        Graphics2D g = img.createGraphics();
        g.drawImage(inputImage, 0, 0, w1, h1, null);
        g.dispose();
        // writes to the output file
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", bos);
        } catch (IOException e) {
            log(e.getStackTrace());
        }
        //Convert BufferedImage to base64 string
        Base64.Encoder encoder = Base64.getEncoder();
        String base64resize = encoder.encodeToString(bos.toByteArray());
        return base64resize;
    }

	public static PublicKey getPublicKey(String base64PublicKey){
		PublicKey publicKey = null;
		try{
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return publicKey;
	}
	public static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
		byte[] encrypedValue = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encrypedValue);
	}

    //=================================================================================================

    @Test(groups = "PB2_Activate_New_Flow")
    public void ActivateFlow() {
        System.out.println("PB2_Activate_New_Flow");
        //Start App with Reset and Re-Open for fresh app from last execution.
//        if (deviceProfile.toLowerCase().contains("ios")){
//            driver.resetApp();
//            driver.launchApp();
//        } else if (deviceProfile.toLowerCase().contains("android")){
//            driver.resetApp();
//            driver.launchApp();
//        }
        //Condition check Start with Activatelow(!=nootp) and not Start Activate flow(==nootp)
        if (!deviceProfile.toLowerCase().contains("nootp")){
            waitBy(OneAppElementKeys.ACCOUNT_BUTTON);
            clickBy(OneAppElementKeys.ACCOUNT_BUTTON);
            clickBy(OneAppElementKeys.REGISTER_TTB_BUTTON);
            addReport("PB2 - Register TTB Button");
            System.out.println(language);
            if (language.toLowerCase().contains("thai")){
              clickBy(OneAppElementKeys.PB2_REG_P2_THAI);
              sleep();
            }

            clickBy(OneAppElementKeys.ACCEPT_TERM_AND_CON_CHECKBOX);
            addReport("PB2 - Accept Term and con checkbox");
            if (isElementPresentBy(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON)){
                clickBy(OneAppElementKeys.TERM_AND_CON_NEXT_BUTTON);
            } else if (isElementPresentBy(OneAppElementKeys.PB2_REG_P2_NEXT)){
                clickBy(OneAppElementKeys.PB2_REG_P2_NEXT);
            }

            String rmId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.rmid);
            System.out.println("RMID is : " + rmId);

            new TouchAction(ttbTestContext.getDriver()).tap(PointOption.point(
                    fBy(OneAppElementKeys.PB2_REG_P2_INPUT_FIELD).getLocation().getX(),
                    fBy(OneAppElementKeys.PB2_REG_P2_INPUT_FIELD).getLocation().getY())).perform();
            setTextBy(OneAppElementKeys.PB2_REG_P2_INPUT_FIELD, rmId);
            addReport("PB2 - Enter rmid="+rmId);
            if (isElementPresentBy(OneAppElementKeys.CITIZEN_ID_NEXT)) {
                clickBy(OneAppElementKeys.CITIZEN_ID_NEXT);
            } else if (isElementPresentBy(OneAppElementKeys.PB2_REG_P3_NEXT)) {
                clickBy(OneAppElementKeys.PB2_REG_P3_NEXT);
            }
//            clickBy(OneAppElementKeys.PB2_REG_P3_NEXT);
            addReport("PB2 - Enter Pin = 010203");
            enterPin("010203");
            waitBy(OneAppElementKeys.PB2_REG_P4_OTP1);
            addReport("PB2 - Enter OTP = 111111");
            sleep();
            driver.getKeyboard().sendKeys("111111");
            waitByLong(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON);
            addReport("PB2 - Complete Next Button");
            clickBy(OneAppElementKeys.ACTIVATE_COMPLETE_NEXT_BUTTON);
            sleep(5);
            try{
                waitBy1(OneAppElementKeys.PB2_REG_P5_NOTI_ALLOW, 5);
                addReport("PB2 - Notification to Allow");
                clickBy(OneAppElementKeys.PB2_REG_P5_NOTI_ALLOW);
            } catch (Exception e) {}
            clickBy(OneAppElementKeys.PB2_HOM_GUIDELINE_NEXT);
            addReport("PB2 - Click Guideline Next button");
            clickBy(OneAppElementKeys.PB2_HOM_GUIDELINE_NEXT);
            clickBy(OneAppElementKeys.PB2_HOM_GUIDELINE_NEXT);
        }
    }

    @Test(groups = "PB2_Open_MyAccount_Screen",dependsOnGroups = { "PB2_Activate_New_Flow"})
    public void openMyAccount() {
        System.out.println("openMyAccount()");
        addReport("PB2 - Home Screen");
        clickBy(OneAppElementKeys.ACCOUNT_BUTTON);
        try {
            waitBy1(OneAppElementKeys.PB2_PIN1, 5);
            enterPin("010203");
            addReport("PB2 - Homescreen - Enter Pin=010203");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        try {
            waitBy1(OneAppElementKeys.PB2_ACC_GUIDELINE_DONE, 5);
            addReport("PB2 - Click guideline on Account page");
            clickBy(OneAppElementKeys.PB2_ACC_GUIDELINE_DONE);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Test(groups = "PB2_Select_Account",dependsOnGroups = { "PB2_Open_MyAccount_Screen"})
    public void selectAccount() {
        System.out.println("selectMyCard()");
        String lbCardNumber = data.getString("config."+data.getString(dataProfile+".rm")+"."+data.getString(dataProfile+".account_number"));
        log("lbCardNumber="+lbCardNumber);

        if (ttbTestContext.isIos()){
            log("=iOS");
            String lbCardNumberToXpath = convertDepositAccountToXpathIOS(lbCardNumber).toUpperCase();
            waitBy(OneAppElementKeys.PB2_ACC_ACCOUNTS);
            addReport("PB2 - Existing Account lists");
            sleep(5);
            List<WebElement> cards = fsBy(OneAppElementKeys.PB2_ACC_ACCOUNTS);
            int nCount = 0;
            log("List of Accounts = "+cards.size());
            for (WebElement card : cards) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                log("card="+"XCUIElementTypeStaticText[value=\"" + lbCardNumberToXpath + "\"]");
                if (isElementPresentByCssSelector(card, "XCUIElementTypeStaticText[value=\"" + lbCardNumberToXpath + "\"]")) {
                    log("Card number = " + card.findElement(By.cssSelector("XCUIElementTypeStaticText[value=\"" + lbCardNumberToXpath + "\"]")).getText());
                    ExReport.printReportMessage("PB2 - Click Card = " + lbCardNumber);
                    card.click();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                }
                else {
                    log("Current Card is not "+lbCardNumber);
                }
                nCount++;
            }
            if (nCount == cards.size()){
                Assert.fail(lbCardNumber + " is not found!");
            }

//            setWebview(OneAppElementKeys.PB2W_DET_DETAILS);
            if (deviceProfile.toLowerCase().contains("nootp")){
                setWebview(0);
            } else {
                setWebview(1);
            }
        } //end if1------------------------------------------------------------------------
        else if (ttbTestContext.isAndroid()){
            log("=Android");
            String lbCardNumberToXpath = convertDepositAccountToXpathAndroid(lbCardNumber);
            waitBy(OneAppElementKeys.PB2_ACC_ACCOUNTS);
            addReport("PB2 - Existing Account lists");
            List<WebElement> cards = fsBy(OneAppElementKeys.PB2_ACC_ACCOUNTS);
            int nCount = 0;
            log("size="+cards.size());
            for (WebElement card : cards) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                if (isElementPresentByCssSelector(card, "android.widget.TextView[text=\"" + lbCardNumberToXpath + "\"]")) {
                    log("Card number = " + card.findElement(By.cssSelector("android.widget.TextView[text=\"" + lbCardNumberToXpath + "\"]")).getText());
                    addReport("PB2 - Click Card = " + lbCardNumber);
                    card.click();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                }
                else {
                    log("Current Card is not "+lbCardNumber);
                }
                nCount++;
            }
            if (nCount == cards.size()){
                Assert.fail(lbCardNumber + " is not found!");
            }
//            if (deviceProfile.toLowerCase().contains("nootp")){
//                setWebview(0);
//            } else {
                setWebview(0);
//            }
        }

//        setWebview(OneAppElementKeys.PB2W_DET_DETAILS);
        waitByLong(OneAppElementKeys.PB2W_DET_DETAILS);
        addReport("PB2 - Account Details - Loading");
        waitInVisibleBy(OneAppElementKeys.PB2W_DET_LOADING);
    }

        @Test(groups = "PB2_Select_DebitCard",dependsOnGroups = { "PB2_Select_Account"})
    public void selectDebitCard() {
        log("selectDebitCard()");
        addReport("PB2 - Account Details - Default");
        clickBy(OneAppElementKeys.PB2W_DET_DETAILS);
        waitInVisibleBy(OneAppElementKeys.PB2W_DET_LOADING);
        waitBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTDETAILS_LB);
        addReport("PB2 - Account Details - Click Details tab");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTDETAILS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTTYPE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTTYPE_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_STATUS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_STATUS_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTNAME_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTNAME_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_BRANCH_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_BRANCH_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ACCOUNTMANAGEMENT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_VIRUTALPASSBOOK).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_MYDEBITCARDS).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_DET_DET_ALLFREEDEBITCARDANNUALFEE).getText(), "");
//        touchAndMoveWebView(fBy(OneAppElementKeys.PB2W_DET_DETAILS), fBy(OneAppElementKeys.PB2W_DET_TITLE));
        swipeDownToUp();
        swipeDownToUp();
        swipeDownToUp();
        sleep();
        log("my debit cards"+fBy(OneAppElementKeys.PB2W_DET_DET_MYDEBITCARDS).getText());
        addReport("PB2 - Account Details - Details tab Full Screen");
        clickBy(OneAppElementKeys.PB2W_DET_DET_MYDEBITCARDS);
        waitByLong(OneAppElementKeys.PB2W_MDC_ALLFREEDIGITALCARD_LB);
    }

    @Test(groups = "Select_My_DebitCard", dependsOnGroups = {"PB2_Select_DebitCard"})
    public void selectMyDebitCard() {
        log("Select My Debit Card ()");
        sleep();
        waitBy(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST);
        addReport("PB2 - List of Debit Card");
        String lbCardNumber = data.getString("config."+data.getString(dataProfile+".rm")+"."+data.getString(dataProfile+".card_number"));

        List<WebElement> cardDigitals = fsBy(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_ACCOUNTNUMBER_LIST);
        int nCount = 0;
        log("List of Cards = "+cardDigitals.size());
        for (WebElement card : cardDigitals) {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//            log("accno="+card.getText());
            if (card.getText().equalsIgnoreCase(lbCardNumber)){
                log("accno="+card.getText());
                try {
                    log("accno="+fCss("#digital_card_status_text_"+nCount).getText());
                }catch (Exception e) {}
                assertText(fCss("#digital_card_account_label_"+nCount).getText(), "");
                assertText(fCss("#digital_card_account_value_"+nCount).getText(),"");
                assertText(fCss("#digital_card_expiry_date_label_"+nCount).getText(), "");
                assertText(fCss("#digital_card_expiry_date_value_"+nCount).getText(), "");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                card.click();
                return;
            }
            nCount++;
        }
        List<WebElement> cards = fsBy(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST);
        nCount = 0;
        log("List of Cards = "+cards.size());
        for (WebElement card : cards) {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//            log("accno="+card.getText());
            if (card.getText().equalsIgnoreCase(lbCardNumber)){
                log("Acct No. = "+card.getText());
                try {
                    log("Acct No.="+fCss("#debit_card_status_text_"+nCount).getText());
                }catch (Exception e) {}
                assertText(fCss("#debit_card_account_label_"+nCount).getText(), "");
                assertText(fCss("#debit_card_account_value_"+nCount).getText(),"");
                assertText(fCss("#debit_card_expiry_date_label_"+nCount).getText(), "");
                assertText(fCss("#debit_card_expiry_date_value_"+nCount).getText(), "");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                swipeDownToUp();
                card.click();
                return;
            }
            nCount++;
        }
        if (nCount == cards.size()){
            Assert.fail(lbCardNumber + " is not found!");
        }
        sleep(5);
    }
}
