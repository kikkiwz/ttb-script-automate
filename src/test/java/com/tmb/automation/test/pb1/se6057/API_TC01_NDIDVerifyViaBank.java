package com.tmb.automation.test.pb1.se6057;

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

public class API_TC01_NDIDVerifyViaBank extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}
	
	@Test(groups = {"android", "PB1"}, description="VerifyViaNDIDservice")
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
		System.out.println("////////BaseURI///////////-  " + "\n" + BaseURI);
		System.out.println("///////XCorrelation////////////-  " + "\n" + XCorrelation);
		
		String VerifyNDID = ApiUrlEKYC.VerifyNDID;
		System.out.println("////////VerifyNDID///////////-  " +"\n" +VerifyNDID);
		
//ekYC Script ----------------------------------------------------
	
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("X-Citizen-ID", "1234567890123")
				.auth().none()
				.when().get(VerifyNDID)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("VerifyNDID API- " +BaseURI +VerifyNDID);
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
		String messageexpectedS = "accounts-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
//Verify Product Code from Excel ---------------------------------------------------	
		JSONObject jo1 = new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		
		for (int i = 0; i < ja1.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja1.getJSONObject(i);
			String idr = jo3.getString("id");
			String providerr = jo3.getString("provider");
			String industry_coder = jo3.getString("industry_code");
			String company_coder = jo3.getString("company_code");
			String application_coder = jo3.getString("application_code");
			String application_namer = jo3.getString("application_name");
			String descriptionr = jo3.getString("description");
			String description_thr = jo3.getString("description_th");
			String description_enr = jo3.getString("description_en");
			int max_aalr = jo3.getInt("max_aal");
			int max_ialr = jo3.getInt("max_ial");
//			String bank_logor = jo3.getString("bank_logo");
			System.out.println("/////////////id//////////- " + idr);
			System.out.println("/////////////provider//////////- " + providerr);
			System.out.println("/////////////industry_coder//////////- " + industry_coder);
			System.out.println("/////////////company_coder//////////- " + company_coder);
			System.out.println("/////////////application_coder//////////- " + application_coder);
			System.out.println("/////////////application_namer//////////- " + application_namer);
			System.out.println("/////////////descriptionr//////////- " + descriptionr);
			System.out.println("/////////////description_thr//////////- " + description_thr);
			System.out.println("/////////////description_enr//////////- " + description_enr);
			System.out.println("/////////////max_aalr//////////- " + max_aalr);
			System.out.println("/////////////max_ialr//////////- " + max_ialr);
//			System.out.println("/////////////bank_logor//////////- " + bank_logor);
			
			ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
			String ExcelFile = Helper.getProperties("TestData_pb1eKYC_excel_path");
			ArrayList<String> data1 = row.getData(company_coder, "BankList", ExcelFile); // Import data from excel		
			String companyCode = data1.get(0);
			String provider = data1.get(1);
			System.out.println("--------companyCode-------- " + companyCode);
			System.out.println("--------provider-------- " + provider);
			
			Assert.assertEquals(companyCode, company_coder, "Company Code validated");
			Assert.assertEquals(provider, providerr, "Provider validated");	
			
			Assert.assertNotNull(description_thr, "DesTH validated");
			Assert.assertNotNull(description_enr, "DesEN validated");	
			Assert.assertNotNull(idr, "ID validated");
			Assert.assertNotNull(industry_coder, "industry_code validated");
			Assert.assertNotNull(application_coder, "application_code validated");
			Assert.assertNotNull(application_namer, "application_name validated");
			Assert.assertNotNull(descriptionr, "description validated");
			Assert.assertNotNull(max_aalr, "max_aal validated");
			Assert.assertNotNull(max_ialr, "max_ial validated");
//			Assert.assertNotNull(bank_logor, "bank_logo validated");
		}
		
		System.out.println("///////////VerifyViaNDIDservice Success/////////////// ");
					
	}
}
