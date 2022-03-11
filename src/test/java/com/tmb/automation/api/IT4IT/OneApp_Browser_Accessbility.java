package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Document;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class OneApp_Browser_Accessbility {
	
	
	private Long Timestamp;
	
	public String GetAccessToken()
	{
		String AccessToken;
		String refresh_token;
		Date date =new Date();
		Timestamp = date.getTime();
		RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "OP/uNQVCrV4zpbfBjn+W374BmGF8jMUMMhdROj5L23ydatPGwfKLr2dSy3fP70GA3CHel3fu3yGMmaU7/a7vSGcx3xeFsLLBlCDWYB4ksAMccAL2kg63I0xv5B0jO8pFOzm/jct2YTAoJgWjZhjXsK2t9TiEez6j1TwgcFodwgZ4oh2XmY7vfTcPHqEKS4OyDKCCcLkNZOLuAFe4nA1qiahwpxQGN0EDiV4XX1vZVanfZ75MALt4qaZAv5iYl9eMcH+tFPqhTD/T7nrH6gy6w/akx0f/Kywg0wqIkXYl5Umbsh1hRlZgb+HWilLPsfiROkoy+VHSzBM2mv/SD9q+CQ==")
				.multiPart("password", "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==")
				.multiPart("scope", "mobile").when()
				.post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		AccessToken = jsonPath.getString("data.access_token");
		refresh_token=jsonPath.getString("data.refresh_token");
		String finalrequest="window.webview.sendAccessTokenToWeb('"+AccessToken+"','"+refresh_token+"',JSON.stringify({url:'creadit-card/enter-account-id',redirection : true,action:'creadit-card/enter-account-id'}))";
         System.out.println(AccessToken);
         return finalrequest;
	}
	@Test
	public void Launch_Application() throws InterruptedException, Exception {
		
		String finalrequest=GetAccessToken();
		System.out.println("the final request is--"+finalrequest);
		String filepath = System.getProperty("user.dir") + "/src/main/resources/chromedriver_91.exe";
		System.out.println(filepath);
		System.setProperty("webdriver.chrome.driver", filepath);
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Moto G4");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-debugging-port=9222");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		WebDriver driver = new ChromeDriver(options);		
		driver.get("https://oneapp-dev1.tau2904.com/credit-card/credit-landing");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		Thread.sleep(3000);
		StringSelection stringSelection = new StringSelection(finalrequest);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		Thread.sleep(10000);
		String secondrequest="window.webview.sendCardData(JSON.stringify({accountId:'0000000050077680143010176',productName:'so good'}))";
		StringSelection stringSelection2 = new StringSelection(secondrequest);
		Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard2.setContents(stringSelection2, stringSelection2);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		Thread.sleep(13000);
		Runtime.getRuntime().exec("cmd.exe /C start lighthouse "+driver.getCurrentUrl()+ " --port=9222 --output=html --output-path=./ttbhomepage.html --view");
		//driver.findElement(By.xpath("//button[text()='CC']")).click();
		Thread.sleep(15000);
//		Runtime.getRuntime().exec("cmd.exe /C start lighthouse "+driver.getCurrentUrl()+ " --port=9222 --output=html --output-path=./ttbhomepage.html --view");
		//driver.quit();
		
}
	
	
}

