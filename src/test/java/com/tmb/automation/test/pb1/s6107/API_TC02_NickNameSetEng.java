package com.tmb.automation.test.pb1.s6107;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.ExcelBasePB1;
import com.tmb.automation.pages.pb1.transfer.ApiUrl;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC02_NickNameSetEng extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod(groups = { "android", "PB1" })
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1", "TestData_Sheet1", this.getClass().getSimpleName()); 
	}

	@AfterMethod(groups = { "android", "PB1" })
	public void teardown() {
		System.out.println("///////////////After Test Method Print////////////");
	}

	@DataProvider
	public Object[][] getExcelData() throws IOException {
		Object Data[][] = Helper.testadataDataprovider("TestData_pb1", "NickNameSetEng"); 
		return Data; 	}

	@Test(groups = { "android", "PB1" }, dataProvider = "getExcelData", description = "NickNameSetEng")
	public void Test001(String aa1, String bb1, String cc1) throws InterruptedException, IOException, SQLException {
		log("------------Start " + this.getClass().getSimpleName());

//Login-------------------------------------------------------------------------------------
		String Base = map("url");
		String oneappD = map("oneapp-dev");
		String XCorrelationI = map("X-Correlation-ID");
		String grantT = map("grant_type");
		String userN = map("username");
		String passW = map("password");
		String scopE = map("scope");
		String login = ApiUrl.loginApi; // get url from pageobject main file
		String dailyLimit = ApiUrl.dailyLimitApi;
		String accountDetails = ApiUrl.accountDetailsApi;
		String accountList = ApiUrl.accountListApi;
		String ttbApi = ApiUrl.ownttbApi;
		String tdttb = ApiUrl.tdttbApi;
		String ttbConfirmApi = ApiUrl.ownttbConfirmApi;
		String promptApi = ApiUrl.promptApi;
		String promptConfirmApi = ApiUrl.promptConfirmApi;
		String verifyPin = ApiUrl.verifyPinApi;

		System.out.println("////////URL///////////-  " + "\n" + Base);
		System.out.println("///////oneapp-dev//////////// -  " + "\n" + oneappD);
		System.out.println("///////X-Correlation-ID////////////-  " + "\n" + XCorrelationI);
		System.out.println("////////grant_type///////////-  " + "\n" + grantT);
		System.out.println("////////username///////////-  " + "\n" + userN);
		System.out.println("////////password///////////-  " + "\n" + passW);
		System.out.println("////////scope///////////-  " + "\n" + scopE);

		RestAssured.baseURI = Base;
		Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", oneappD)
				.header("X-Correlation-ID", XCorrelationI).multiPart("grant_type", grantT).multiPart("username", userN)
				.multiPart("password", passW).multiPart("scope", scopE).when().post(login).then().assertThat()
				.statusCode(200).extract().response();

		String responseString = response.asString();
		System.out.println("////////////////responseString//////////////////-  " + "\n" + responseString);

		JsonPath js = new JsonPath(responseString); // for parsing Json
		String codeV = js.getString("status.code");
		System.out.println("////////////////code//////////////////-  " + "\n" + codeV);
		String messageV = js.getString("status.message");
		System.out.println("////////////////message//////////////////-   " + "\n" + messageV);
		String access_tokenV = js.getString("data.access_token");
		System.out.println("////////////////access_token//////////////////-  " + "\n" + access_tokenV);

		System.out.println("///////////Login Success/////////////// ");

//Data Input -----------------------------------------------------------------------------------
		String crmId = map("crmId"); // Get data from Excel using map
		String fromAccountNo = map("fromAccountNo");
		String fromAccountType = map("fromAccountType");
		String fromBankCode = map("fromBankCode");
		String fromAccountName = map("fromAccountName");
		String toAccountType = map("toAccountType");
		String amount = map("amount");
		String note = map("note");
		String taxId = map("taxId");
		String senderType = map("senderType");
		String categoryId = map("categoryId");
		String smartFlag = map("smartFlag");

		String toAccountNo = aa1; // Get data from DataProvider

		System.out.println("////////crmId///////////-  " + "\n" + crmId);
		System.out.println("////////fromAccountNo///////////-  " + "\n" + fromAccountNo);
		System.out.println("////////fromAccountType///////////-  " + "\n" + fromAccountType);
		System.out.println("////////fromBankCode///////////-  " + "\n" + fromBankCode);
		System.out.println("////////fromAccountName///////////-  " + "\n" + fromAccountName);
		System.out.println("////////toAccountNo///////////-  " + "\n" + toAccountNo);
		System.out.println("////////toAccountType///////////-  " + "\n" + toAccountType);
		System.out.println("////////amount///////////-  " + "\n" + amount);
		System.out.println("////////note///////////-  " + "\n" + note);
		System.out.println("////////taxId///////////-  " + "\n" + taxId);
		System.out.println("////////senderType///////////-  " + "\n" + senderType);
		System.out.println("////////categoryId///////////-  " + "\n" + categoryId);
		System.out.println("////////smartFlag///////////-  " + "\n" + smartFlag);

//All account lists----------------------------------------------------

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI).auth().oauth2(access_tokenV).when().get(accountList).then()
				.assertThat().statusCode(200).extract().response();

		String responseStringL = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringL);

		JsonPath jsL = new JsonPath(responseStringL); // for parsing Json
		String codeL1 = jsL.getString("status.code");
		String CodeExpectedL1 = "0000";
		System.out.println("///////////AssertCodeV1 ////////////-   " + "\n" + codeL1);
		Assert.assertEquals(CodeExpectedL1, codeL1, "code validated");

		String messageL1 = jsL.getString("status.message");
		String messageexpectedL1 = "success";
		System.out.println("/////////AssertMessageV1///////-  " + "\n" + messageL1);
		Assert.assertEquals(messageL1, messageexpectedL1, "message validated");

		String serviceL1 = jsL.getString("status.service");
		String serviceexpectedL1 = "customers-ex-service";
		System.out.println("////////////////serviceV1//////////////////-  " + "\n" + serviceL1);
		Assert.assertEquals(serviceL1, serviceexpectedL1, "service validated");

		String descriptionL1 = jsL.getString("status.description.en");
		String descriptionexpectedL1 = "success";
		System.out.println("////////////////descriptionV1//////////////////-  " + "\n" + descriptionL1);
		Assert.assertEquals(descriptionL1, descriptionexpectedL1, "description validated");

		ObjectMapper mapper = new ObjectMapper(); //get data mapper using POJO Class
		ResponseAccountListPOJO accountlist = mapper.readValue(responseStringL, new TypeReference<ResponseAccountListPOJO>() { });
		System.out.println("////////////////accountlist//////////////////-  " + "\n" + accountlist);
		
		int arraySize= accountlist.getData().size();
		System.out.println("-------------------arraySize--------- : " +arraySize );
		
		String accountNoL1= null;
		String AcNoL1=null;
		String ProductCodeL1= null;
		String productNameENL1= null;
		String productNameTHL1= null;
		String nickNameENL1= null;
		String nickNameTHL1= null;
		
		for (int i = 0; i<arraySize; i++) {
		System.out.println("/////////////ArrayLoop Count//////////- "+"\n" +i);
		
		accountNoL1=accountlist.getData().get(i).getAccountNumber();
		AcNoL1 = accountNoL1.substring(accountNoL1.length() - 10);
		System.out.println("/////////////AccountNoL1/////////- "+"\n" + AcNoL1);
				
		if (AcNoL1.equals(toAccountNo)) {	
		ProductCodeL1= accountlist.getData().get(i).getProductCode();
		productNameENL1=accountlist.getData().get(i).getProductNameEN();
		productNameTHL1=accountlist.getData().get(i).getProductNameTH();
		nickNameENL1=accountlist.getData().get(i).getAccnicknameEN();
		nickNameTHL1=accountlist.getData().get(i).getAccnicknameTH();
		System.out.println("/////////////ProductCodeL1/////////- "+"\n" + ProductCodeL1);
		System.out.println("/////////////productNameENL1/////////- "+"\n" + productNameENL1);
		System.out.println("/////////////productNameTHL1/////////- "+"\n" + productNameTHL1);
		System.out.println("/////////////nickNameENL1/////////- "+"\n" + nickNameENL1);
		System.out.println("/////////////nickNameTHL1/////////- "+"\n" + nickNameTHL1);
		break;
		} 		}
		
		System.out.println("///////////All account lists Success/////////////// ");
		
//Verify Product Code from Excel ---------------------------------------------------
		
//		if (!AcNoL1.equals(toAccountNo)) {
//		System.out.println("///////////Account Number not found/////////////// ");
//		}
//		else if (nickNameENL1.equals(nickNameTHL1)) {	
//		System.out.println("/////////////nickName already set/////////- "+ nickNameENL1);		
//		}
//		else {
		ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
		String ExcelFile = Helper.getProperties("TestData_pb1_excel_path");
		ArrayList<String> data1 = row.getData(ProductCodeL1, "ProductTable", ExcelFile); // Type word to file data
		
		String ProductCodeE1= data1.get(0);
		String productNameENE1=data1.get(3);
		String productNameTHE1=data1.get(4);		
		System.out.println("--------ProductCode-------- " +ProductCodeE1 );
		System.out.println("--------ProductNameEng-------- " + productNameENE1);
		System.out.println("--------ProductNameThai-------- " +productNameTHE1 );
		
		Assert.assertEquals(ProductCodeL1, ProductCodeE1, "ProductCode validated");
		Assert.assertEquals(productNameENL1, productNameENE1, "ProductNameEng validated");
		Assert.assertEquals(productNameTHL1, productNameTHE1, "ProductNameThai validated");
		Assert.assertEquals(nickNameENL1, nickNameTHL1, "NickName validated");
//		}
		
		System.out.println("///////////Product Code Success/////////////// ");

	}
}
