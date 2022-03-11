package com.tmb.automation.test.pb1.se6055;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.ExcelBasePB1;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.ekyc.ApiUrlEKYC;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_VerifyMethod extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}
	
	@Test(groups = {"android", "PB1"}, description="Verify Method")
	public void Test001 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
//Login-------------------------------------------------------------------------------------
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////BaseURI///////////-  " +"\n" +BaseURI);
		System.out.println("///////XCorrelation////////////-  "+"\n"  +XCorrelation);
		
		String VerifyMethod = ApiUrlEKYC.CommonEKYC;
		System.out.println("////////VerifyMethod///////////-  " +"\n" +VerifyMethod);
		
//ekYC Script ----------------------------------------------------
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.when().get(VerifyMethod)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("VerifyMethod API- " +BaseURI +VerifyMethod);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		
		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "mobile";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
//Verify Product Code from Excel ---------------------------------------------------	
			
		JSONObject jo1 = new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		String s1 = ja1.get(0).toString();
		JSONObject jo2 = new JSONObject(s1);
		JSONArray ja2 = jo2.getJSONArray("verify_method");
		System.out.println("////////////////ja2//////////////////-  " + ja2);
		
		for (int i = 0; i < ja2.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja2.getJSONObject(i);
			String ChannelR = jo3.getString("channel");
			String DescTHR = jo3.getString("descTH");
			String DescENR = jo3.getString("descEN");
			System.out.println("/////////////ChannelR//////////- " + ChannelR);
			System.out.println("/////////////DescTHR//////////- " + DescTHR);
			System.out.println("/////////////DescENR//////////- " + DescENR);

			ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
			String ExcelFile = Helper.getProperties("TestData_pb1eKYC_excel_path");
			ArrayList<String> data1 = row.getData(ChannelR, "VerifyMethod", ExcelFile); // Import data from excel		
			String channele1 = data1.get(0);
			String descTHe1 = data1.get(1);
			String descENe1 = data1.get(2);
			System.out.println("--------channel-------- " + channele1);
			System.out.println("--------descTH-------- " + descTHe1);
			System.out.println("--------descEN-------- " + descENe1);
			
			Assert.assertEquals(ChannelR, channele1, "Title Code validated");
			Assert.assertEquals(DescTHR, descTHe1, "Title DesTH validated");
			Assert.assertEquals(DescENR, descENe1, "Title DesEN validated");			
		}
		
		System.out.println("///////////Verify Method Success/////////////// ");				
	}
}
