package com.tmb.automation.pages.platform1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.SeleniumLibrary;

public class Otp_TutanotaPage {
	private static WebDriver driver;

	
	//WebView - Home
	
	public static String swBtnLogin = "//div[text()=\'LOGIN\']";
	
	public static String swLbEmail = "//label[text()=\'Email address\']";
	
	public static String swTxtEmail = "//input[@aria-label=\'Email address\']";
	
	public static String swLbPasswd = "//label[text()=\'Password\']";
	public static String swTxtPasswd = "//input[@aria-label=\'Password\']";
	public static String swBtnSubmit = "//button[@title=\'Log in\']";
	
	// main email panel
	public static String swEmailFirstRow = "//div[@class=\'list-column\']/div[1]/ul/li[1]";
	public static String listwEmailRows = "//div[@class=\'list-column\']/div[1]/ul/li/div/div[2]/div[2]/div";
	
	public static String swLbRef = "(//span[contains(text(), \'Ref:\')])[1]";
	public static String swLbOtpNumber = "(//td[table[tbody[tr[td[p[span[contains(text(), \'Ref:\')]]]]]]]/table[2]/tbody/tr/td)[1]";
	
	public final static String swLbSubjectEmail = "//*[@id=\"mail-viewer\"]/div[1]/div[3]/div/div[1]";
	public static String subjectEmail = "";
	
	
	public final static String swLbTitleEmail_EN = "//*[@id=\"mail-body\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td";
	public static String titleEmail_EN = "";
	
	public final static String swLbContentEmail_EN = "//*[@id=\"mail-body\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td/p";
	public static String contentEmail_EN = "";
	
	public final static String swLbTitleEmail_TH = "//*[@id=\"mail-body\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td";
	public static String titleEmail_TH = "";
	
	public final static String swLbContentEmail_TH = "//*[@id=\"mail-body\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/p";
	public static String contentEmail_TH = "";
	
//	public Otp_TutanotaPage(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);
////		Helper.writeLog(this.getClass().getName()+":\r\n"+driver.getPageSource());
//	}

	public static void main(String args[]) {
	    String otpNumber = getOtpFromEmail("tcs.qa.911@tutanota.com", "Tcs@13579", "GSJK");
	    System.out.println("otp final="+otpNumber);
	}
	
	public static String getOtpFromEmail(String username, String password, String RefNumber) {
		String otpNumber = "";
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver87_mac");
		driver = new ChromeDriver(options);
        try {
            driver.get("https://mail.tutanota.com/login");
            driver.manage().window().maximize();
//            waitVisible(swBtnLogin, 10);
//            driver.findElement(By.xpath(swBtnLogin)).click();
            waitVisible(swLbEmail, 50);
            driver.findElement(By.xpath(swLbEmail)).click();
            driver.findElement(By.xpath(swTxtEmail)).sendKeys(username);
            driver.findElement(By.xpath(swLbPasswd)).click();
            driver.findElement(By.xpath(swTxtPasswd)).sendKeys(password);
            driver.findElement(By.xpath(swBtnSubmit)).click();
            waitVisible(swEmailFirstRow, 150);
            List<WebElement> listElement = driver.findElements(By.xpath(listwEmailRows));
            for (WebElement element:listElement) {
            	scrollIntoView(element);
            	System.out.println("element="+element.getText());
            	if (element.getText().contains("TMB has sent you a verification code to verify your email")) {
            		Log.logger.debug("Click on email topics");;
            		element.click();
            		sleep(1);
            		waitVisible(swLbSubjectEmail, 150);
            		subjectEmail = driver.findElement(By.xpath(swLbSubjectEmail)).getText();
            		waitVisible(swLbTitleEmail_EN, 150);
            		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(swLbTitleEmail_EN)));
            		titleEmail_EN = driver.findElement(By.xpath(swLbTitleEmail_EN)).getText();
            		sleep(1);
            		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(swLbContentEmail_EN)));
            		contentEmail_EN = driver.findElement(By.xpath(swLbContentEmail_EN)).getText();
            		titleEmail_TH = driver.findElement(By.xpath(swLbTitleEmail_TH)).getText();
            		contentEmail_TH = driver.findElement(By.xpath(swLbContentEmail_TH)).getText();
            		String Ref = driver.findElement(By.xpath(swLbRef)).getText();
            		Log.logger.debug("Ref"+Ref);
            		otpNumber = driver.findElement(By.xpath(swLbOtpNumber)).getText();
            		
            		Log.logger.debug("Otp1="+otpNumber);
            		if (Ref==RefNumber.trim()) {
//            			otpNumber = driver.findElement(By.xpath(swLbOtpNumber)).getText();
            			Log.logger.debug("Otp2="+otpNumber);
            			
            		}
            		break;
            	}
            }
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } finally {
            driver.quit();
        }
		
		
		
		return otpNumber;
	}
	
	public static void waitVisible(String xpath, int second) {
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	public static void scrollIntoView(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		} catch (Exception e) {
			element.sendKeys(Keys.PAGE_DOWN);
		}
	}
	protected static void sleep(double seconds) {
//		log("Sleep " + seconds + " seconds");
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

}
