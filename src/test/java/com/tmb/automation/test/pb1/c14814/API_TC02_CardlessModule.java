package com.tmb.automation.test.pb1.c14814;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
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

public class API_TC02_CardlessModule extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Cardless Common Module")
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
		String CommonCardless = ApiUrlCardless.CommonCardless;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------CommonCardless---------- " + CommonCardless);
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("X-Correlation-ID", XCorrelation)
				.auth().oauth2(access_tokenV)
				.when().get(CommonCardless)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " +responseStringC);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////- " + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1);
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+ messageC1);
		Assert.assertEquals(messageC1, messageexpectedC);

		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "common";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS);
		
		String messageD1=jsC.getString("status.description");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD);
		
		JSONObject jo1 = new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		
		for (int i = 0; i < ja1.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja1.getJSONObject(i);
			String id = jo3.getString("id");
			String number_of_devide = jo3.getString("number_of_devide");
			JSONArray ja2 = jo3.getJSONArray("amount_selected");
			System.out.println("////////////////ja2//////////////////-  " + ja2);
			JSONArray ja3 = jo3.getJSONArray("tutorial_screen");
			System.out.println("////////////////ja3//////////////////-  " + ja3);
			
			System.out.println("/////////////id//////////- " + id);
			System.out.println("/////////////number_of_devide//////////- " + number_of_devide);
			Assert.assertEquals(id, "cardless_module");
			Assert.assertEquals(number_of_devide, "100");
			
			for (i = 0; i < ja2.length(); i++) {
				System.out.println("--------Loop : " +(i+1)) ;
				String amount_selected = ja2.getString(i);
				System.out.println("/////////////amount_selected//////////- " + amount_selected);
				Assert.assertNotNull(amount_selected);
			}
			
			for (i = 0; i < ja3.length(); i++) {
				System.out.println("--------Loop : " +(i+1)) ;
				String tutorial_screen = ja3.getString(i);
				System.out.println("/////////////tutorial_screen//////////- " + tutorial_screen);
				Assert.assertNotNull(tutorial_screen);
			}
			
		}
		
		System.out.println("///////////Cardless Module Success/////////////// ");
					
	}
}
