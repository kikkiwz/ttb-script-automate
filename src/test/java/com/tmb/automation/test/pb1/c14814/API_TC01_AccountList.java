package com.tmb.automation.test.pb1.c14814;

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
import com.tmb.automation.pages.pb1.cardless.API_Login;
import com.tmb.automation.pages.pb1.cardless.ApiUrlCardless;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_AccountList extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Account List")
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
		String AccountList = ApiUrlCardless.AccountList;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------AccountList---------- " + AccountList);
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("X-Correlation-ID", XCorrelation)
				.auth().oauth2(access_tokenV)
				.when().get(AccountList)
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
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS);
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD);
		
//Verify Product Code from Excel ---------------------------------------------------	

		JSONObject jo1 = new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		
		for (int i = 0; i < ja1.length(); i++) {
			System.out.println("--------Loop : " +(i+1)) ;
			JSONObject jo3 = ja1.getJSONObject(i);
			String product_coder = jo3.getString("product_code");
			String product_name_enr = jo3.getString("product_name_Eng");
			String product_name_thr = jo3.getString("product_name_TH");
			String allow_cardless_withdraw_flagr = jo3.getString("allow_cardless_withdraw_flag");
			
			System.out.println("/////////////product_coder//////////- " + product_coder);
			System.out.println("/////////////product_name_enr//////////- " + product_name_enr);
			System.out.println("/////////////product_name_thr//////////- " + product_name_thr);
			System.out.println("/////////////allow_cardless_withdraw_flagr//////////- " + allow_cardless_withdraw_flagr);
		
			ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
			String ExcelFile = Helper.getProperties("TestData_pb1_Cardless_excel_path"); //global property excel file path
			try {
			ArrayList<String> data1 = row.getData(product_coder, "ProductList", ExcelFile); // Import data from excel
			String product_code = data1.get(0);
			String product_name_en = data1.get(2);
			String product_name_th = data1.get(3);
			String allow_cardless_withdraw_flag = data1.get(4);
			System.out.println("--------product_code-------- " + product_code);
			System.out.println("--------product_name_en-------- " + product_name_en);
			System.out.println("--------product_name_th-------- " + product_name_th);
			System.out.println("--------allow_cardless_withdraw_flag-------- " + allow_cardless_withdraw_flag);
			
			Assert.assertEquals(product_code, product_coder);
			Assert.assertEquals(product_name_en, product_name_enr);	
			Assert.assertEquals(product_name_th, product_name_thr);
			Assert.assertEquals("1", allow_cardless_withdraw_flagr);	
		} 
			catch (Exception e) {
				System.out.println("--------product_coder is not Cardless Withdrawal-------- " +product_coder);
				System.out.println("--------product_name_enr is not Cardless Withdrawal-------- " +product_name_enr);
				System.out.println("--------product_name_thr is not Cardless Withdrawal-------- " +product_name_thr);
				Assert.assertEquals("0", allow_cardless_withdraw_flagr);
			}
		}
		
		System.out.println("///////////Account List Success/////////////// ");
	}
}
