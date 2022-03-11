package com.tmb.automation.test.pb1.s4319;

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

public class API_TC02_ErrorFrozenAcTMB extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups = {"android", "PB1"})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1", "TestData_Sheet1", this.getClass().getSimpleName()); //Map for excel to get data. 1. Add file name with path in global property and put first name in class. 2. Sheet name in class. 3. Put same class name in excel first column where need collect data
	}
	@AfterMethod(groups = {"android", "PB1"})
	public void teardown() {
		System.out.println("///////////////After Test Method Print////////////");
	}
	@DataProvider
	public  Object[][] getExcelData() throws IOException 	{
		 Object Data[][]=Helper.testadataDataprovider("TestData_pb1", "OtherTMB"); //Excel to get data. 1. Add file name with path in global property. 2. put path name and Sheet name in class
		return Data; 	}

	@Test(groups = {"android", "PB1"}, dataProvider="getExcelData", description="Transfer to frozen ac")
	public void Test001 (String aa1,String bb1,String cc1) throws InterruptedException, IOException{
		log("------------Start "+this.getClass().getSimpleName());
		
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
		
		System.out.println("////////URL///////////-  " +"\n" +Base);
		System.out.println("///////oneapp-dev//////////// -  " +"\n"  +oneappD);
		System.out.println("///////X-Correlation-ID////////////-  "+"\n"  +XCorrelationI);
		System.out.println("////////grant_type///////////-  "+"\n"  +grantT);
		System.out.println("////////username///////////-  " +"\n" +userN);
		System.out.println("////////password///////////-  "  +"\n" +passW);
		System.out.println("////////scope///////////-  " +"\n" +scopE);

		RestAssured.baseURI = Base;
		Response response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", oneappD)
				.header("X-Correlation-ID", XCorrelationI)
				.multiPart("grant_type", grantT)
				.multiPart("username", userN)
				.multiPart("password", passW)
				.multiPart("scope", scopE)
				.when().post(login)
				.then().assertThat().statusCode(200).extract().response();
						
		String responseString =response.asString();
		System.out.println("////////////////responseString//////////////////-  "+"\n" +responseString);
		
		JsonPath js=new JsonPath(responseString); //for parsing Json
		String codeV=js.getString("status.code");
		System.out.println("////////////////code//////////////////-  "+"\n"  + codeV);
		String messageV=js.getString("status.message");
		System.out.println("////////////////message//////////////////-   "+"\n" + messageV);
		String access_tokenV=js.getString("data.access_token");
		System.out.println("////////////////access_token//////////////////-  "+"\n" + access_tokenV);

		System.out.println("///////////Login Success/////////////// ");

//Data Input -----------------------------------------------------------------------------------
		String crmId = map("crmId"); //Get data from Excel using map
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
		String smartFlag = map("smartFlag");
		
		String toAccountNo = "0177502846"; //Input to account number

		System.out.println("////////crmId///////////-  "+"\n"  +crmId);
		System.out.println("////////fromAccountNo///////////-  "+"\n"  +fromAccountNo);
		System.out.println("////////fromAccountType///////////-  "+"\n" +fromAccountType);
		System.out.println("////////fromAccountName///////////-  "+"\n"  +fromAccountName);
		System.out.println("////////toAccountNo///////////-  "+"\n"  +toAccountNo);
		System.out.println("////////toAccountType///////////-  "+"\n"  +toAccountType);
		System.out.println("////////amount///////////-  "+"\n"  +amount);
		System.out.println("////////note///////////-  "+"\n"  +note);
		System.out.println("////////taxId///////////-  "+"\n"  +taxId);
		System.out.println("////////fromBankCode///////////-  "+"\n"  +fromBankCode);
		System.out.println("////////senderType///////////-  "+"\n"  +senderType);
		System.out.println("////////categoryId///////////-  "+"\n"  +categoryId);
		System.out.println("////////smartFlag///////////-  "+"\n"  +smartFlag);

//Customer Details Check Available Balance ----------------------------------------------------
		HashMap<String, Object> hmC =new HashMap<>();
		hmC.put("accountNo", fromAccountNo);
		hmC.put("accountType", fromAccountType);			
		System.out.println("/////////body///////////-  "+"\n" +hmC);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.body(hmC)
				.when().post("apis/customer/accounts/details")
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);

		String accountNoC1=jsC.getString("data.accountNo");
		String AcNoC1 = accountNoC1.substring(accountNoC1.length() - 10);
		Assert.assertEquals(AcNoC1, fromAccountNo, "accountNo validated");
		System.out.println("/////////////AssertAccountNoC1/////////- "+"\n" + AcNoC1);
		
		String availableBalC1=jsC.getString("data.accountBalance");
		System.out.println("/////////////AvailableBalC1//////////- "+"\n" + availableBalC1);
		
		System.out.println("///////////Check Available Balance Success/////////////// ");
		
//Transfer and Validation -------------------------------------------------------------------
		HashMap<String, Object> hm =new HashMap<>();
		hm.put("fromAccountNo", fromAccountNo);
		hm.put("fromAccountType", fromAccountType);
		hm.put("fromAccountName", fromAccountName);
		hm.put("bankCode", fromBankCode);
		hm.put("toAccountNo", toAccountNo);
		hm.put("toAccountType", toAccountType);
		hm.put("amount", amount);
		hm.put("note", note);
		hm.put("taxId", taxId);
		hm.put("senderType", senderType);
		hm.put("categoryId", categoryId);
		hm.put("smartFlag", smartFlag);
		
		System.out.println("/////////body///////////-  "+"\n" +hm);
		
		//Prompt PROXY-TYPE- Other TMB-1, Other bank-0. CitizenID-1, Mobile -2, TaxId- 3 //
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.header("X-TRANSFER-TYPE", "1")
				.header("Channel", "mb")
				.header("X-CRMID", crmId)
				.auth().oauth2(access_tokenV)
				.body(hm).when().post("apis/payment/transfer/validate")
				.then().assertThat().statusCode(200).extract().response();
		
		String responseString1 =response.asString();
		System.out.println("////////////////responseString1//////////////////-  "+"\n" +responseString1);
		
		JsonPath js1=new JsonPath(responseString1); //for parsing Json
		String codeV1=js1.getString("status.code");
		String CodeExpectedV1= "0000";
		System.out.println("///////////AssertCodeV1 ////////////-   "+"\n" + codeV1);
		Assert.assertEquals(codeV1, CodeExpectedV1, "code validated");
		
		String messageV1=js1.getString("status.message");
		String messageexpected = "success";
		Assert.assertEquals(messageV1, messageexpected, "message validated");
		System.out.println("/////////AssertMessageV1///////-  "+"\n" + messageV1);
		
		String serviceV1=js1.getString("status.service");
		String serviceexpectedV1 = "payment-experience-service";
		Assert.assertEquals(serviceV1, serviceexpectedV1, "service validated");
		System.out.println("////////////////serviceV1//////////////////-  "+"\n"  + serviceV1);
		
		String descriptionV1=js1.getString("status.description.en");
		String descriptionexpected = "success";
		Assert.assertEquals(descriptionV1, descriptionexpected, "description validated");
		System.out.println("////////////////descriptionV1//////////////////-  "+"\n"  + descriptionV1);

		String cacheKeyV1=js1.getString("data.cacheKey");
		String result[] = cacheKeyV1.split("_");
		Assert.assertEquals("TRANSFER", result[0]);
		Assert.assertEquals(crmId, result[1], "CacheKey/CrmID Validated");
		System.out.println("////////////////cacheKey1//////////////////-   "+"\n"  + cacheKeyV1);

		String amountV1=js1.getString("data.amount");
		Assert.assertEquals(amountV1, amount, "sentAmount validated");
		System.out.println("////////////////AmountSentV1//////////////////-  "+"\n"  + amountV1);		
	
		System.out.println("///////////SentValidation Success/////////////// ");	
		
//Login with Pin ------------------------------------------------------------------------------
		String PinP1 = "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
		String DeviceIDP1= userN;
		
		HashMap<String, Object> hmP1 =new HashMap<>();
		hmP1.put("pin", PinP1);
		hmP1.put("ref_id", cacheKeyV1); //cacheKey take from validate transfer
		hmP1.put("module", "transfer");	
		
		System.out.println("/////////body///////////-  "+"\n" +hmP1);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", "devops-1234")
				.header("deviceID", DeviceIDP1)
				.auth().oauth2(access_tokenV)
				.body(hmP1)
				.when().post(verifyPin)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringP1 =response.asString();
		System.out.println("////////////////responseStringP1//////////////////-  "+"\n" +responseStringP1);
		
		JsonPath jsP1=new JsonPath(responseStringP1); //for parsing Json
		String codeP1=jsP1.getString("status.code");
		String CodeExpectedP1= "0000";
		System.out.println("///////////AssertCodeP1 ////////////-   "+"\n" + codeP1);
		Assert.assertEquals(codeP1, CodeExpectedP1, "code validated");
		
		String messageP1=jsP1.getString("status.message");
		String messageexpectedP1 = "success";
		System.out.println("/////////AssertMessageP1///////-  "+"\n" + messageP1);
		Assert.assertEquals(messageP1, messageexpectedP1, "message validated");
	
		System.out.println("/////////////Verify Pin Success/////////");
		
// Transfer Confirmation -----------------------------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.header("X-TRANSFER-ID", cacheKeyV1)
				.header("Channel", "mb")
				.header("app-version", "1.0")
				.header("device-id", userN)
				.header("device-model", "test")
				.header("os-version", "test")
				.auth().oauth2(access_tokenV)
				.when().post("apis/payment/transfer/confirm")
				.then().assertThat().statusCode(400).extract().response();
		
		String ConfirmationString =response.asString();
		System.out.println("//////////Confirmation response///////////////- "+"\n" +ConfirmationString);
		
		JsonPath js2=new JsonPath(ConfirmationString); //for parsing Json
		String codeV2=js2.getString("status.code");
		String CodeExpected2= "cbs_8009";
		Assert.assertEquals(codeV2, CodeExpected2, "code validated");
		System.out.println("///////////AssertCodeV2 ////////////-   "+"\n" + codeV2);
		
		String messageV2=js2.getString("status.message");
		String messageexpected2 = "cr denied - frzn acct nbr                                  ";
		System.out.println("/////////AssertMessageV2///////-  "+"\n" + messageV2);
		Assert.assertEquals(messageV2, messageexpected2, "message validated");
		
		String serviceV2=js2.getString("status.service");
		String serviceexpected2 = "payment-experience-service";
		System.out.println("////////////////serviceV2//////////////////-  "+"\n"  + serviceV2);
		Assert.assertEquals(serviceV2, serviceexpected2, "service validated");

		String descriptionV2=js2.getString("status.description.en");
		String descriptionexpected2 = "Unable to proceed/ Please check your destination account number again  or change destination account number.";
		System.out.println("////////////////descriptionEN2//////////////////-  "+"\n"  + descriptionV2);
		Assert.assertEquals(descriptionV2, descriptionexpected2, "descriptionEn validated");

		String descriptionV2a=js2.getString("status.description.th");
		String descriptionexpected2a = "ไม่สามารถทำรายการได้ เนื่องจากบัญชีปลายทางอาจถูกปิด / ล๊อค / หรือถูกอายัด กรุณาตรวจสอบบัญชีปลายทางอีกครั้ง  หรือเปลี่ยนหมายเลขบัญชีปลายทาง";
		System.out.println("////////////////descriptionTH2//////////////////-  "+"\n"  + descriptionV2a);
		Assert.assertEquals(descriptionV2a, descriptionexpected2a, "descriptionTh validated");

		String accountId2=js2.getString("data.fromAccountNo");
		System.out.println("/////////////From Account2//////////- "+"\n" + accountId2);
		Assert.assertEquals(accountId2, fromAccountNo, "accountId validated");

		String toAcNo2=js2.getString("data.toAccountNo");
		System.out.println("/////////////toAcNo2//////////- "+"\n" + toAcNo2);
		Assert.assertEquals(toAcNo2, toAccountNo, "toAccountNo validated");
				
		String transAmo2=js2.getString("data.amount");
		System.out.println("/////////////transAmo2//////////- "+"\n" + transAmo2);
		Assert.assertEquals(transAmo2, amount, "transamount validated");	
		
		System.out.println("///////////Transfer Confirmation Success/////////////// ");		
}

}

