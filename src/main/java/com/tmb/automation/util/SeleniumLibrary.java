package com.tmb.automation.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumLibrary {

	private WebDriver driver;

	public SeleniumLibrary(WebDriver driver)

	{

		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void click(WebElement element) {
		boolean status=element.isDisplayed();
		Assert.assertEquals(status, true, "The elment is not displayed,unabale to perform Click Operation");
		element.click();
		System.out.println("clicked on element" + element);

	}

	public void enter_text(WebElement element, String value) {
		boolean status=element.isDisplayed();
		Assert.assertEquals(status, true, "The elment is not displayed,unabale to perform enter text Operation");
		element.clear();
		element.sendKeys(value);

	}

	public void select_by_value(WebElement element, String value) {

		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select_by_id(WebElement element, int index) {

		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public void select_by_visibletext(WebElement element, String test) {

		Select sel = new Select(element);
		sel.selectByVisibleText(test);

	}

	public void chcekbox(WebElement element) {
		element.click();

	}

	public boolean ischecked(WebElement element) {

		if (element.isSelected()) {

			return true;
		} else {
			return false;
		}
	}

	public String gettextvalue(WebElement element) {
		
		return element.getText();
	}
	
public void clearvalue(WebElement element) {
		
		element.clear();
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

	public boolean isElementPresentBy(String id) {
		try {
			if (driver.findElements(By.id(id)).size() != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void waitVisible(WebElement element, int second) {
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOf(element));
	  
	}
	public void waitclickable(WebElement element, int second) {
		(new WebDriverWait(driver, second)).until(ExpectedConditions.elementToBeClickable(element));
	  
	}

	public WebElement fXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> fsXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	/// ::enter 1 for cuurent opened window or enter 0 for parent window to do
	/// switch operation
	public void Switchwindows(int i) {
		Set<String> wicurrentwindows = driver.getWindowHandles();
		Iterator<String> windowsvalue = wicurrentwindows.iterator();

		if (i == 0) {
			String pwindow = windowsvalue.next();
			String cwindow = windowsvalue.next();
			driver.switchTo().window(pwindow);

		}

		if (i == 1) {
			String pwindow = windowsvalue.next();
			String cwindow = windowsvalue.next();
			driver.switchTo().window(cwindow);
		}

		if (i == 2) {
			String pwindow = windowsvalue.next();
			String cwindow = windowsvalue.next();
			String c2window = windowsvalue.next();
			driver.switchTo().window(c2window);

		}

		driver.manage().window().maximize();

	}

	public void checkElement_multpgae(WebElement element,String message) throws InterruptedException {

		String totalpage_pages = driver.findElement(By.xpath("//span[@class='sc-fcOtbr ejAnCG']")).getText();
		String[] lis = totalpage_pages.split(" ");
		String stringlis = lis[2];
		int phases_Pagecount = Integer.parseInt(stringlis);
		boolean checkvalue=false;

		for (int count = 1; count <= phases_Pagecount; count++) {

			

			if (element.isDisplayed())

			{
				
				checkvalue=true;
				highlightElement(element);
				Thread.sleep(200);
				
				break;
				

				
			}
			
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();

		}
		
		String displaymessage=message+"is not present";
		Assert.assertEquals(checkvalue, true,displaymessage);

		

	}

	public void scrollIntoView(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// e.printStackTrace();
			element.sendKeys(Keys.PAGE_DOWN);
		}
	}

	public void highlightElement( WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid blue'", element);
	}

	public void unhighlightLast( WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='0px'", element);
	}
	
	
	public void  iselementvisible(WebElement Ele)
	{
		
		
		
	}
	
	public void uploadLogo(WebElement element,String logoname)
	{
		
		String path=getUserDir() + "/testdata/logo_Image/"+logoname;
		System.out.println("path is"+path);
		element.sendKeys(path);
	}
	
	public static String getUserDir() {
		return System.getProperty("user.dir");
	}
	
	public void pagescrollbottom()
	{
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		
		executor.executeScript("window.scrollBy(0,2000)");
	}
	
	public void pagescrolltop()
	{
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		
		executor.executeScript("window.scrollBy(1,1000)");
	}


	public static void clickElementPerform(WebDriver driver, WebElement elementId){
		Actions builder = new Actions(driver);
		builder.moveToElement( elementId).click( elementId);
		builder.perform();
	}
}
