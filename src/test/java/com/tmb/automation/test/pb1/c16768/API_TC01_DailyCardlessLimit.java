package com.tmb.automation.test.pb1.c16768;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.cardless.API_Login;
import com.tmb.automation.pages.pb1.cardless.ApiUrlCardless;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_DailyCardlessLimit extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Daily Cardless Limit")
	public void Test001 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		
		System.out.println("----------BaseURI---------- " + BaseURI);
		System.out.println("----------XCorrelation---------- " + XCorrelation);
		
		String CRM = ApiUrlCardless.CRM;
		String GenerateCode = ApiUrlCardless.GenerateCode;
		String DeviceID = ApiUrlCardless.DeviceID;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------GenerateCode---------- " + GenerateCode);
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		String account_number = "0012768321";
		String account_name ="ZZZ4972";
		String customer_name = "NAME TEST";
		String account_type = "SDA";
		String mobile_number = "0817315935";
		String transaction_date = "2021-01-01 15:35:06";
		String transaction_type = "Withdraw";
		String amount = "20001.00";
		String language = "EN";
		String channel_id = "02";
		
		HashMap<String, String> hmC = new HashMap<>();
		hmC.put("account_number", account_number);
		hmC.put("account_name", account_name);
		hmC.put("customer_name", customer_name);
		hmC.put("account_type", account_type);
		hmC.put("mobile_number", mobile_number);
		hmC.put("transaction_date", transaction_date);
		hmC.put("transaction_type", transaction_type);
		hmC.put("amount", amount);
		hmC.put("language", language);
		hmC.put("channel_id", channel_id);
		System.out.println("/////////body///////////-  " + "\n" + hmC);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("Device-Model", "AndroidPhone")
				.header("App-Version", "1.0")
				.header("OS-Version", "Android 11.0")
				.header("Channel", "MB")
				.header("Timestamp", "1625738794")
				.header("X-Real-IP", "10.10.188.123")
				.header("device-os-type", "Android")
				.header("device-os-version", "10")
				.header("Device-Id", DeviceID)
				.header("flow-name", "Cardless Screen")
				.auth().oauth2(access_tokenV)
				.body(hmC).when().post(GenerateCode).then().assertThat().statusCode(400).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " +responseStringC);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "cardless_0002";
		System.out.println("///////////AssertCodeC1 ////////////- " + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1);
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "Insufficient Cardless Limit Funds ";
		System.out.println("/////////AssertMessageC1///////-  "+ messageC1);
		Assert.assertEquals(messageC1, messageexpectedC);

		String messageS1=jsC.getString("status.service");
		String messageexpectedS1 = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+ messageS1);
		Assert.assertEquals(messageS1, messageexpectedS1);
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "Your withdrawal amount is exceed the daily withdrawal limit.";
		System.out.println("/////////AssertmessageD1///////-  "+ messageD1);
		Assert.assertEquals(messageD1, messageexpectedD);

		String messageD2=jsC.getString("status.description.th");
		String messageexpectedD2 = "จำนวนเงินที่ถอนของคุณเกินกำหนดวงเงินจำกัดการถอนรายวัน";
		System.out.println("/////////AssertmessageD2///////-  "+ messageD2);
		Assert.assertEquals(messageD2, messageexpectedD2);
		
		System.out.println("///////////Daily Cardless Limit Success/////////////// ");
	}
}
