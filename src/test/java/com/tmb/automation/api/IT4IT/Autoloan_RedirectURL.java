package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.ResponsePojo;
import com.tmb.automation.model.StatusPojo;
import com.tmb.automation.util.Base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Autoloan_RedirectURL extends Base {

	
	public WebDriver driver;
	@Test
	public void redirectURL() throws IOException {
	
	RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
	String response1 = given().relaxedHTTPSValidation().auth().preemptive()
			.basic("touch-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "client_credentials")
			.multiPart("username", "001100000000000000000000125858")
			.multiPart("data", "eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxMjQzMjc4OTExOCwiYWNjb3VudE51bWJlciI6IjI2NjE1MTc3NyIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTE3NzcifQ==")
			.multiPart("scope", "auto-loan").when()
			.post("apis/auth/token").then().assertThat().extract().response().asString();

	
	System.out.println("response is"+response1);
	JsonPath jsonPath = new JsonPath(response1);
	String AccessToken = jsonPath.getString("data.access_token");
	System.out.println("AccessToken is"+AccessToken);
	
	
	String body="{\r\n" + 
			"        \"keep_session_deep_link_url\": \"tmbtouch:\\\\keepalive\",\r\n" + 
			"        \"close_deep_link_url\": \"tmbtouch:\\\\close\"\r\n" + 
			"}";
	
	
	RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
	Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
			.header("Content-Type","application/json" )
			.header("Timestamp", "786").body(body).when()
			.post("apis/redirect/auto-loan").then().assertThat().extract().response();
	System.out.println("REsponse header"+response.getHeaders());
String URL=	response.getHeader("Location");
System.out.println("URL is"+URL);

	




String filepath = System.getProperty("user.dir") + "/src/main/resources/"+"chromedriver_87"+".exe";

System.out.println(filepath);
System.setProperty("webdriver.chrome.driver", filepath);
Map<String, String> mobileEmulation = new HashMap<>();
mobileEmulation.put("deviceName", "Nexus 5");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

 driver = new ChromeDriver(chromeOptions);
//driver = initializeDriver("chromedriver_87");

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(URL);

	}
	
	
	
@Test(description="Check Auto loan header and back button")
private void CheckHeader() throws InterruptedException, IOException{
    String Header = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[2]/h1")).getText();
    Assert.assertEquals(Header,"Auto Loan");
    Boolean BackBTN = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[1]")).isDisplayed();
    Assert.assertTrue(BackBTN);
}

    @Test(description="Check Auto loan header and back button")
    private void ProgressBar() throws InterruptedException, IOException {
   
	
	
	
	
	
	
	}
	
	
	
	
}
