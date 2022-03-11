package com.tmb.automation.test.pb1.s2329;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.transfer.ApiUrl;
import com.tmb.automation.util.Base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC05_IncompleteTranCitizen extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod(groups = { "android", "PB1" })
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1", "TestData_Sheet1", this.getClass().getSimpleName()); //Map for excel to get data. 1. Add file name with path in global property and put first name in class. 2. Sheet name in class. 3. Put same class name in excel first column where need collect data
	}

	@AfterMethod(groups = { "android", "PB1" })
	public void teardown() {
		System.out.println("///////////////After Test Method Print////////////");
	}

	@DataProvider
	public Object[][] getExcelData() throws IOException {
		Object Data[][]=Helper.testadataDataprovider("TestData_pb1", "Citizen"); //Excel to get data. 1. Add file name with path in global property. 2. put path name and Sheet name in class
		return Data; 	}

	@Test(groups = { "android", "PB1" }, dataProvider = "getExcelData", description = "IncompleteTransaction")
	public void Test001(String aa1, String bb1, String cc1) throws InterruptedException, IOException {
		log("------------Start " + this.getClass().getSimpleName());

//Login-------------------------------------------------------------------------------------
		String Base = map("url");
		String oneappD = map("oneapp-dev");
		String XCorrelationI = map("X-Correlation-ID");
		String grantT = map("grant_type");
		String userN = map("username");
		String passW = map("password");
		String scopE = map("scope");
		String login = ApiUrl.loginApi; //get url from pageobject main file
		String dailyLimit = ApiUrl.dailyLimitApi;
		String accountDetails = ApiUrl.accountDetailsApi;
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
				.header("X-Correlation-ID", XCorrelationI).multiPart("grant_type", grantT)
				.multiPart("username", userN)
				.multiPart("password", passW).multiPart("scope", scopE).when()
				.post(login).then()
				.assertThat().statusCode(200).extract().response();

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
		String fromAccountName = map("fromAccountName");
		String toAccountType = map("toAccountType");
		String amount = map("amount");
		String note = map("note");
		String taxId = map("taxId");
		String fromBankCode = map("fromBankCode");
		String senderType = map("senderType");
		String categoryId = map("categoryId");

		String toAccountNo = aa1; // Get data from DataProvider

		System.out.println("////////crmId///////////-  " + "\n" + crmId);
		System.out.println("////////fromAccountNo///////////-  " + "\n" + fromAccountNo);
		System.out.println("////////fromAccountType///////////-  " + "\n" + fromAccountType);
		System.out.println("////////fromAccountName///////////-  " + "\n" + fromAccountName);
		System.out.println("////////toAccountNo///////////-  " + "\n" + toAccountNo);
		System.out.println("////////toAccountType///////////-  " + "\n" + toAccountType);
		System.out.println("////////amount///////////-  " + "\n" + amount);
		System.out.println("////////note///////////-  " + "\n" + note);
		System.out.println("////////taxId///////////-  " + "\n" + taxId);
		System.out.println("////////fromBankCode///////////-  " + "\n" + fromBankCode);
		System.out.println("////////senderType///////////-  " + "\n" + senderType);
		System.out.println("////////categoryId///////////-  " + "\n" + categoryId);


//Transfer and Validation -------------------------------------------------------------------
		long aa2 = Long.parseLong(aa1) - 1;
		toAccountNo = String.valueOf(aa2);
		System.out.println("/////////to wrong citizen id///////////-  " + "\n" + toAccountNo);

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("fromAccountNo", fromAccountNo);
		hm.put("fromAccountType", fromAccountType);
		hm.put("fromAccountName", fromAccountName);
		hm.put("toAccountNo", toAccountNo);
		hm.put("amount", amount);
		hm.put("note", note);
		hm.put("taxId", taxId);
		hm.put("fromBankCode", fromBankCode);
		hm.put("senderType", senderType);
		hm.put("categoryId", categoryId);

		System.out.println("/////////body///////////-  " + "\n" + hm);

		// Prompt PROXY-TYPE- Other bank -0. CitizenID-1, Mobile -2, TaxId- 3 //
		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-PROXY-TYPE", "1").header("Channel", "mb").header("X-Correlation-ID", XCorrelationI)
				.header("X-CRMID", crmId).auth().oauth2(access_tokenV).body(hm).when()
				.post(promptApi)
				.then().assertThat().statusCode(400).extract().response();

		String responseString1 = response.asString();
		System.out.println("////////////////responseString1//////////////////-  " + "\n" + responseString1);

		JsonPath js1 = new JsonPath(responseString1); // for parsing Json
		String codeV1 = js1.getString("status.code");
		String CodeExpectedV1 = "ppgw_b247048";
		Assert.assertEquals(codeV1, CodeExpectedV1, "code validated");
		System.out.println("///////////AssertCodeV1 ////////////-   " + "\n" + codeV1);

		String messageV1 = js1.getString("status.message");
		String messageexpected = "transaction not allowed,proxy is not registration on mpp";
		Assert.assertEquals(messageV1, messageexpected, "message validated");
		System.out.println("/////////AssertMessageV1///////-  " + "\n" + messageV1);

		String serviceV1 = js1.getString("status.service");
		String serviceexpectedV1 = "payment-experience-service";
		Assert.assertEquals(serviceV1, serviceexpectedV1, "service validated");
		System.out.println("////////////////serviceV1//////////////////-  " + "\n" + serviceV1);

		String regex = "(.{1})(.{4})(.{5})(.{2})(.{1})$";
		String replacment = "$1-$2-$3-$4-$5";
		String toAccountNoV1 = toAccountNo.replaceAll(regex, replacment);

		String descriptionV1 = js1.getString("status.description.en");
		String descriptionEnExpected = "The no. " + toAccountNoV1
				+ " is not registered to PromptPay. Please contact your recipient to register their PromptPay.";
		System.out.println("////////////////description EN V1//////////////////-  " + "\n" + descriptionV1);
		Assert.assertEquals(descriptionV1, descriptionEnExpected, "description En validated");

		String descriptionV1a = js1.getString("status.description.th");
		String descriptionThExpected = "หมายเลข " + toAccountNoV1
				+ " ที่คุณใส่ยังไม่ได้ลงทะเบียนพร้อมเพย์ กรุณาติดต่อผู้รับเงินปลายทางให้ลงทะเบียนก่อน";
		System.out.println("////////////////description Th V1//////////////////-  " + "\n" + descriptionV1a);
		Assert.assertEquals(descriptionV1a, descriptionThExpected, "description Th validated");

		System.out.println("///////////SendValidation Success/////////////// ");

	}

}
