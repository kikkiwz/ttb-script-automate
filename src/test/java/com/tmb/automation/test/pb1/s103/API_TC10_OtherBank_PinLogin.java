package com.tmb.automation.test.pb1.s103;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.text.DecimalFormat;
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

public class API_TC10_OtherBank_PinLogin extends Base {
	
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
		 Object Data[][]=Helper.testadataDataprovider("TestData_pb1", "OtherBank"); //Excel to get data. 1. Add file name with path in global property. 2. put path name and Sheet name in class
		return Data; 	}
	
	@Test(groups = {"android", "PB1"}, dataProvider="getExcelData", description="Other Bank Pin Login")
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
		String login = ApiUrl.loginApi;
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
		
		String toAccountNo = aa1; //Get data from DataProvider
		String toBankCode = bb1;

		System.out.println("////////crmId///////////-  "+"\n"  +crmId);
		System.out.println("////////fromAccountNo///////////-  "+"\n"  +fromAccountNo);
		System.out.println("////////fromAccountType///////////-  "+"\n" +fromAccountType);
		System.out.println("////////fromAccountName///////////-  "+"\n"  +fromAccountName);
		System.out.println("////////toAccountNo///////////-  "+"\n"  +toAccountNo);
		System.out.println("////////toBankCode///////////-  "+"\n"  +toBankCode);
		System.out.println("////////toAccountType///////////-  "+"\n"  +toAccountType);
		System.out.println("////////amount///////////-  "+"\n"  +amount);
		System.out.println("////////note///////////-  "+"\n"  +note);
		System.out.println("////////taxId///////////-  "+"\n"  +taxId);
		System.out.println("////////fromBankCode///////////-  "+"\n"  +fromBankCode);
		System.out.println("////////senderType///////////-  "+"\n"  +senderType);
		System.out.println("////////categoryId///////////-  "+"\n"  +categoryId);

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
				.when().post(accountDetails)
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
		hm.put("toAccountNo", toAccountNo);
		hm.put("amount", amount);
		hm.put("note", note);
		hm.put("taxId", taxId);
		hm.put("fromBankCode", fromBankCode);
		hm.put("toBankCode", toBankCode);
		hm.put("senderType", senderType);
		hm.put("categoryId", categoryId);
			
		System.out.println("/////////body///////////-  "+"\n" +hm);
		
		//Prompt PROXY-TYPE- Other bank -0. CitizenID-1, Mobile -2, TaxId- 3 //
		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-PROXY-TYPE", "0")
				.header("Channel", "mb")
				.header("X-Correlation-ID", XCorrelationI)
				.header("X-CRMID", crmId)
				.auth().oauth2(access_tokenV)
				.body(hm).when().post(promptApi)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseString1 =response.asString();
		System.out.println("////////////////responseString1//////////////////-  "+"\n" +responseString1);
		
		JsonPath js1=new JsonPath(responseString1); //for parsing Json
		String codeV1=js1.getString("status.code");
		String CodeExpectedV1= "0000";
		Assert.assertEquals(codeV1, CodeExpectedV1, "code validated");
		System.out.println("///////////AssertCodeV1 ////////////-   "+"\n" + codeV1);
		
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
		System.out.println("////////////////AmountSentV1//////////////////-  "+"\n"  + amountV1);
		Double newAmountV1 = Double.parseDouble(amountV1);	
		
		String feeV1=js1.getString("data.fee");
		System.out.println("////////////////FeeV1//////////////////-  "+"\n"  + feeV1);
		
		System.out.println("///////////SendValidation Success/////////////// ");	

//Check Daily Limit ----------------------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.when().get(dailyLimit)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringD =response.asString();
		System.out.println("////////////////responseStringD//////////////////-  "+"\n" +responseStringD);
		
		JsonPath jsD=new JsonPath(responseStringD); //for parsing Json
		String codeD1=jsD.getString("status.code");
		String CodeExpectedD1= "0000";
		System.out.println("///////////AssertCodeD1 ////////////-   "+"\n" + codeD1);
		Assert.assertEquals(codeD1, CodeExpectedD1, "code validated");
		
		String messageD1=jsD.getString("status.message");
		String messageexpectedD1 = "success";
		System.out.println("/////////AssertMessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD1, "message validated");

		String maxLimitD1=jsD.getString("data.current_max_limit");
		System.out.println("/////////////MaxDailyLimitD1/////////- "+"\n" + maxLimitD1);
		
		String dailyLimitUseD1=jsD.getString("data.current_daily_usg_amount");
		System.out.println("/////////////dailyLimitUseD1//////////- "+"\n" + dailyLimitUseD1);
		
		String flagD1=jsD.getString("data.pin_free_flag");
		System.out.println("/////////////flagD1//////////- "+"\n" + flagD1);

		String tranLimitD1=jsD.getString("data.pin_free_transaction_limit");
		System.out.println("/////////////tranLimitD1//////////- "+"\n" + tranLimitD1);
		
		String txnCountD1=jsD.getString("data.pin_free_txn_count");
		System.out.println("/////////////flagD1//////////- "+"\n" + txnCountD1);	
		
		System.out.println("/////////////Daily Limit Success/////////");
		
//Login with Pin ------------------------------------------------------------------------------
		String PinP1 = ApiUrl.PinUser;
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
		
// Transfer Confirmation ------------------------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.header("app-version", "1.0")
				.header("Channel", "mb")
				.header("X-TRANSFER-ID", cacheKeyV1)
				.header("device-id", userN)
				.header("device-model", "test")
				.header("os-version", "test")
				.auth().oauth2(access_tokenV)
				.when().post(promptConfirmApi)
				.then().assertThat().statusCode(200).extract().response();

		String ConfirmationString =response.asString();
		System.out.println("//////////Confirmation response Under Daily Limit////////////- "+"\n" +ConfirmationString);

		JsonPath js2=new JsonPath(ConfirmationString); //for parsing Json
		String codeV2=js2.getString("status.code");
		String CodeExpected2= "0000";
		System.out.println("///////////AssertCodeV2 ////////////-   "+"\n" + codeV2);
		Assert.assertEquals(codeV2, CodeExpected2, "code validated");
	
		String messageV2=js2.getString("status.message");
		String messageexpected2 = "success";
		System.out.println("/////////AssertMessageV2///////-  "+"\n" + messageV2);
		Assert.assertEquals(messageV2, messageexpected2, "message validated");

		String serviceV2=js2.getString("status.service");
		String serviceexpected2 = "payment-experience-service";
		System.out.println("////////////////serviceV2//////////////////-  "+"\n"  + serviceV2);
		Assert.assertEquals(serviceV2, serviceexpected2, "service validated");
		
		String descriptionV2=js2.getString("status.description.en");
		String descriptionexpected2 = "success";
		System.out.println("////////////////descriptionV2//////////////////-  "+"\n"  + descriptionV2);
		Assert.assertEquals(descriptionV2, descriptionexpected2, "description validated");
		
		String accountId2=js2.getString("data.sender.accountId");
		Assert.assertEquals(accountId2, fromAccountNo, "accountId validated");
		System.out.println("/////////////From Account2//////////- "+"\n" + accountId2);

		String accountType2=js2.getString("data.sender.accountType");
		Assert.assertEquals(accountType2, fromAccountType, "accountId validated");
		System.out.println("/////////////From Account Type2//////////- "+"\n" + accountType2);

		String accountLength2 =js2.getString("data.sender.accountLength");
		Assert.assertEquals(accountLength2, "10", "accountLength validated");
		System.out.println("///////////accountLength2/////////- "+"\n" + accountLength2);

		String proxyType2=js2.getString("data.receiver.proxyType");
		Assert.assertEquals(proxyType2, "00", "proxyType validated");
		System.out.println("/////////////ProxyType2//////////- "+"\n" + proxyType2);
		
		String toAccount2=js2.getString("data.receiver.proxyValue");
		Assert.assertEquals(toAccount2, toAccountNo, "toAccount validated");
		System.out.println("/////////////To Account2//////////- "+"\n" + toAccount2);

		String fee2=js2.getString("data.fee");
		System.out.println("////////////////FeeV1//////////////////-  "+"\n"  + fee2);
		
		String amount2=js2.getString("data.amount");
		System.out.println("/////////////Amount2//////////- "+"\n" + amount2);

		System.out.println("///////////Transfer Confirmation Success/////////////// ");	

//Customer Details Check Remaining Balance -------------------------------------------------		
		HashMap<String, Object> hmR =new HashMap<>();
		hmR.put("accountNo", fromAccountNo);
		hmR.put("accountType", fromAccountType);			
		System.out.println("/////////body///////////-  "+"\n" +hmR);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.body(hmR)
				.when().post(accountDetails)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringR =response.asString();
		System.out.println("////////////////responseStringR//////////////////-  "+"\n" +responseStringR);
		
		JsonPath jsR=new JsonPath(responseStringR); //for parsing Json
		String codeR1=jsR.getString("status.code");
		String CodeExpecteR= "0000";
		Assert.assertEquals(codeR1, CodeExpecteR, "code validated");
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeR1);
		
		String messageR1=jsR.getString("status.message");
		String messageexpectedR = "success";
		Assert.assertEquals(messageC1, messageexpectedR, "message validated");
		System.out.println("/////////AssertMessageR1///////-  "+"\n" + messageR1);

		String accountNoR1=jsR.getString("data.accountNo");
		String AcNoR1 = accountNoR1.substring(accountNoR1.length() - 10);
		Assert.assertEquals(AcNoR1, fromAccountNo, "accountNo validated");
		System.out.println("/////////////AssertAccountNoR1/////////- "+"\n" + AcNoR1);
		
		String remainingBalR1=jsR.getString("data.accountBalance");
		Double remainingAmoR1 = Double.parseDouble(remainingBalR1);
		Double previousBalR1 = Double.parseDouble(availableBalC1);
		Double transferAmoR1 = Double.parseDouble(amountV1);
		Double feeAmoR1 = Double.parseDouble(feeV1);
		Double newBalR1 = Double.valueOf(previousBalR1 - transferAmoR1 - feeAmoR1);
		
		DecimalFormat df1 = new DecimalFormat("#.##");
		String remaBalS1 = df1.format(remainingAmoR1); 
		String newBalS1 = df1.format(newBalR1); 
		
		System.out.println("/////////////PreviousBalR1//////////- "+"\n" + previousBalR1);
		System.out.println("/////////////TransferR1//////////- "+"\n" + transferAmoR1);
		System.out.println("/////////////FeeR1//////////- "+"\n" + feeAmoR1);
		System.out.println("////NewBalR1///- "+"\n"+previousBalR1+"-"+transferAmoR1+"-"+feeAmoR1+"= "+newBalS1);
		System.out.println("////NewBalR1///- "+"\n" +newBalS1);
		Assert.assertEquals(newBalS1, remaBalS1, "RemainingBalance Validated");

		System.out.println("///////////Remaining Balance Success/////////////// ");		
		
//Check Daily Limit ----------------------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.when().get(dailyLimit)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringP =response.asString();
		System.out.println("////////////////responseStringD//////////////////-  "+"\n" +responseStringP);
		
		JsonPath jsPF=new JsonPath(responseStringP); //for parsing Json
		String codePF1=jsPF.getString("status.code");
		String CodeExpectedPF1= "0000";
		System.out.println("///////////AssertCodePF1 ////////////-   "+"\n" + codePF1);
		Assert.assertEquals(codePF1, CodeExpectedPF1, "code validated");
		
		String messagePF1=jsPF.getString("status.message");
		String messageexpectedPF1 = "success";
		System.out.println("/////////AssertMessagePF1///////-  "+"\n" + messagePF1);
		Assert.assertEquals(messagePF1, messageexpectedPF1, "message validated");
		
		String dailyLimitUsePF1=jsPF.getString("data.current_daily_usg_amount");
		System.out.println("/////////////dailyLimitUsePF1//////////- "+"\n" + dailyLimitUsePF1);
		
		Double dailyLimitUseV2 = Double.parseDouble(dailyLimitUseD1);
		Double dailyLimitRemPF1 = Double.valueOf(dailyLimitUseV2 + newAmountV1);	
		DecimalFormat df2 = new DecimalFormat("#.##");
		String remaBalS2 = df2.format(dailyLimitRemPF1); 		
		Assert.assertEquals(dailyLimitUsePF1, remaBalS2, "Remaining Daily Limit validated");	
		
		String txnCountPF1=jsPF.getString("data.pin_free_txn_count");
		System.out.println("/////////////txnCountPF1//////////- "+"\n" + txnCountPF1);	
		int txnCountPF2 = Integer.parseInt(txnCountPF1);
		int oldtxnCountV1 = Integer.parseInt(txnCountD1);
		Assert.assertEquals(txnCountPF2, oldtxnCountV1, "Remaining transaction Count validated");
		System.out.println("/////////////txnCountD1//////////- "+"\n" + txnCountD1);	
		
		System.out.println("/////////////Verify PinFree Remaining Count/////////");	
}
}


