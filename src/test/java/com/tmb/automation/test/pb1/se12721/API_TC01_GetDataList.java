package com.tmb.automation.test.pb1.se12721;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.ekyc.ApiUrlEKYC;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_GetDataList extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}

	@Test(groups = { "android", "PB1" }, description = "Get Data List")
	public void Test001() throws InterruptedException, IOException, SQLException {
		log("------------Start " + this.getClass().getSimpleName());

//Login-------------------------------------------------------------------------------------
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////BaseURI///////////-  " + "\n" + BaseURI);
		System.out.println("///////XCorrelation////////////-  " + "\n" + XCorrelation);
		
		String DataList = ApiUrlEKYC.DataList;
		System.out.println("////////DataList///////////-  " + "\n" + DataList);

		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all().header("language", "en")
				.header("X-Correlation-ID", XCorrelation).auth().none().when().get(DataList).then()
				.assertThat().extract().response();
		
		String responseStringC = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringC);
		OpenReport.reportString("DataList API- " +BaseURI +DataList);
		OpenReport.reportAPI(responseStringC);

		JsonPath jsC = new JsonPath(responseStringC); // for parsing Json
		String codeC1 = jsC.getString("status.code");
		String CodeExpectedC1 = "0000";
		System.out.println("///////////AssertCodeC1 ////////////-   " + "\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1 = jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  " + "\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");

		String messageS1 = jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  " + "\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

		String messageD1 = jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  " + "\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");

		JSONObject jo1 = new JSONObject(responseStringC);
		JSONObject ja1 = jo1.getJSONObject("data");
		String s1 = ja1.toString();
		JSONObject jo2 = new JSONObject(s1);
		
		JSONArray ja2 = jo2.getJSONArray("marital_status");
		System.out.println("////////////////marital_status//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
		}

		ja2 = jo2.getJSONArray("country");
		System.out.println("////////////////country//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			String cl_desc2 = jo3.getString("cl_desc2");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			System.out.println("/////////////cl_desc2//////////- " + cl_desc2);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
			Assert.assertNotNull(cl_desc2);
		}
		
		ja2 = jo2.getJSONArray("nationality");
		System.out.println("////////////////nationality//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
		}
		
		ja2 = jo2.getJSONArray("education_code");
		System.out.println("////////////////education_code//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
		}
		
		ja2 = jo2.getJSONArray("occupation");
		System.out.println("////////////////occupation//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
		}
		
		ja2 = jo2.getJSONArray("business_code");
		System.out.println("////////////////business_code//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			String cl_misc1 = jo3.getString("cl_misc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			System.out.println("/////////////cl_misc1//////////- " + cl_misc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
			Assert.assertNotNull(cl_misc1);
		}
		
		ja2 = jo2.getJSONArray("salary_code");
		System.out.println("////////////////salary_code//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
		}
		
		ja2 = jo2.getJSONArray("source_of_income");
		System.out.println("////////////////source_of_income//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String cl_type = jo3.getString("cl_type");
			String cl_code = jo3.getString("cl_code");
			String cl_desc1 = jo3.getString("cl_desc1");
			String cl_desc2 = jo3.getString("cl_desc2");
			System.out.println("/////////////cl_type//////////- " + cl_type);
			System.out.println("/////////////cl_code//////////- " + cl_code);
			System.out.println("/////////////cl_desc1//////////- " + cl_desc1);
			System.out.println("/////////////cl_desc2//////////- " + cl_desc2);
			
			Assert.assertNotNull(cl_type);
			Assert.assertNotNull(cl_code);
			Assert.assertNotNull(cl_desc1);
			Assert.assertNotNull(cl_desc2);
		}
		
		System.out.println("///////////Get Data List Success/////////////// ");
	}

}
