package com.tmb.automation.test.pb1.s2757;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.Oracle_DB;
import com.tmb.automation.pages.pb1.transfer.ApiUrl;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC03_OwnTMBActivityLog extends Base {
	
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
		 Object Data[][]=Helper.testadataDataprovider("TestData_pb1", "OwnTMB"); //Excel to get data. 1. Add file name with path in global property. 2. put path name and Sheet name in class
		return Data; 	}
	
	@Test(groups = {"android", "PB1"}, dataProvider="getExcelData", description="Own TMB Transfer Log")
	public void Test001 (String aa1,String bb1,String cc1) throws InterruptedException, IOException, SQLException{
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
		
		String toAccountNo = aa1; //Get data from DataProvider

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

//Receiver Check Remaining Balance ---------------------------------------------------
		HashMap<String, Object> hmC2 =new HashMap<>();
		hmC2.put("accountNo", toAccountNo);
		hmC2.put("accountType", toAccountType);			
		System.out.println("/////////body///////////-  "+"\n" +hmC2);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.body(hmC2)
				.when().post(accountDetails)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC2 =response.asString();
		System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC2);
		
		JsonPath jsC2=new JsonPath(responseStringC2); //for parsing Json
		String codeC2=jsC2.getString("status.code");
		String CodeExpectedC2= "0000";
		Assert.assertEquals(codeC2, CodeExpectedC2, "code validated");
		System.out.println("///////////AssertCodeC2 ////////////-   "+"\n" + codeC2);
		
		String messageC2=jsC2.getString("status.message");
		String messageexpectedC2 = "success";
		Assert.assertEquals(messageC2, messageexpectedC2, "message validated");
		System.out.println("/////////AssertMessageC2///////-  "+"\n" + messageC2);

		String accountNoC2=jsC2.getString("data.accountNo");
		String AcNoC2 = accountNoC2.substring(accountNoC2.length() - 10);
		Assert.assertEquals(AcNoC2, toAccountNo, "accountNo validated");
		System.out.println("/////////////AssertAccountNoC2/////////- "+"\n" + AcNoC2);
		
		String availableBalC2=jsC2.getString("data.accountBalance");
		System.out.println("/////////////AvailableBalC2//////////- "+"\n" + availableBalC2);
		
		System.out.println("///////////Receiver Available Balance Success/////////////// ");
		
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
				.header("X-TRANSFER-TYPE", "0")
				.header("Channel", "mb")
				.header("X-CRMID", crmId)
				.auth().oauth2(access_tokenV)
				.body(hm).when().post(ttbApi)
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
		
		String feeV1=js1.getString("data.fee");
		System.out.println("////////////////FeeV1//////////////////-  "+"\n"  + feeV1);	
	
		System.out.println("///////////SentValidation Success/////////////// ");	
		
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
				.when().post(ttbConfirmApi)
				.then().assertThat().statusCode(200).extract().response();
		
		String ConfirmationString =response.asString();
		System.out.println("//////////Confirmation response///////////////- "+"\n" +ConfirmationString);
		
		JsonPath js2=new JsonPath(ConfirmationString); //for parsing Json
		String codeV2=js2.getString("status.code");
		String CodeExpected2= "0000";
		System.out.println("///////////AssertCodeV2 ////////////-   "+"\n" + codeV2);
		Assert.assertEquals(codeV2, CodeExpected2, "code validated");
		
		String messageV2=js2.getString("status.message");
		String messageexpected2 = "success";
		Assert.assertEquals(messageV2, messageexpected2, "message validated");
		System.out.println("/////////AssertMessageV2///////-  "+"\n" + messageV2);
		
		String serviceV2=js2.getString("status.service");
		String serviceexpected2 = "payment-experience-service";
		Assert.assertEquals(serviceV2, serviceexpected2, "service validated");
		System.out.println("////////////////serviceV2//////////////////-  "+"\n"  + serviceV2);
		
		String descriptionV2=js2.getString("status.description.en");
		String descriptionexpected2 = "success";
		Assert.assertEquals(descriptionV2, descriptionexpected2, "description validated");
		System.out.println("////////////////descriptionV2//////////////////-  "+"\n"  + descriptionV2);

		String accountId2=js2.getString("data.fromAccount.accountNo");
		Assert.assertEquals(accountId2, fromAccountNo, "accountId validated");
		System.out.println("/////////////From Account2//////////- "+"\n" + accountId2);

		String availableBal2=js2.getString("data.fromAccount.availBalance");
		System.out.println("/////////////availableBal2//////////- "+"\n" + availableBal2);

		String toAcNo2=js2.getString("data.toAccount.accountNo");
		System.out.println("/////////////toAcNo2//////////- "+"\n" + toAcNo2);
		Assert.assertEquals(toAcNo2, toAccountNo, "toAccountNo validated");
		
		String transAmo2=js2.getString("data.transactionAmount");
		System.out.println("/////////////transAmo2//////////- "+"\n" + transAmo2);
		Assert.assertEquals(transAmo2, amount, "transamount validated");

		String transRef=js2.getString("data.transactionReference");
		System.out.println("////////////////transref2//////////////////-  "+"\n"  + transRef);
		
		System.out.println("///////////Transfer Confirmation Success/////////////// ");	
		
//Customer Details Check Remaining Balance ---------------------------------------------------
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
		Double newBalR1 = Double.valueOf(previousBalR1 - transferAmoR1);
		
		DecimalFormat df1 = new DecimalFormat("#.##");
		String remaBalS1 = df1.format(remainingAmoR1); 
		String newBalS1 = df1.format(newBalR1); 
		
		System.out.println("/////////////PreviousBalR1//////////- "+"\n" + previousBalR1);
		System.out.println("/////////////TransferR1//////////- "+"\n" + transferAmoR1);
		System.out.println("////NewBalR1///- "+"\n"+previousBalR1+"- "+transferAmoR1+"= "+newBalS1);
		System.out.println("////NewBalS1///- "+"\n" +newBalS1);
		Assert.assertEquals(newBalS1, remaBalS1, "RemainingBalance Validated");
		
		System.out.println("///////////Remaining Balance Success/////////////// ");			

//Receiver Check Remaining Balance ---------------------------------------------------
		HashMap<String, Object> hmR1 =new HashMap<>();
		hmR1.put("accountNo", toAccountNo);
		hmR1.put("accountType", toAccountType);			
		System.out.println("/////////body///////////-  "+"\n" +hmR1);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelationI)
				.auth().oauth2(access_tokenV)
				.body(hmR1)
				.when().post(accountDetails)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringR1 =response.asString();
		System.out.println("////////////////responseStringR//////////////////-  "+"\n" +responseStringR1);
		
		JsonPath jsR2=new JsonPath(responseStringR1); //for parsing Json
		String codeR2=jsR2.getString("status.code");
		String CodeExpecteR2= "0000";
		Assert.assertEquals(codeR2, CodeExpecteR2, "code validated");
		System.out.println("///////////AssertCodeR2 ////////////-   "+"\n" + codeR2);
		
		String messageR2=jsR2.getString("status.message");
		String messageexpectedR2 = "success";
		Assert.assertEquals(messageR2, messageexpectedR2, "message validated");
		System.out.println("/////////AssertMessageR2///////-  "+"\n" + messageR2);

		String accountNoR2=jsR2.getString("data.accountNo");
		String AcNoR2 = accountNoR2.substring(accountNoR2.length() - 10);
		System.out.println("/////////////AssertAccountNoR2/////////- "+"\n" + AcNoR2);
		Assert.assertEquals(AcNoR2, toAccountNo, "accountNo validated");
		
		String remainingBalR2=jsR2.getString("data.accountBalance");
		Double remainingAmoR2 = Double.parseDouble(remainingBalR2);
		Double previousBalR2 = Double.parseDouble(availableBalC2);
		Double transferAmoR2 = Double.parseDouble(amountV1);
		Double newBalR2 = Double.valueOf(previousBalR2 + transferAmoR2);
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		String previousBalS2=df2.format(previousBalR2); 
		String remaBalS2 = df2.format(remainingAmoR2); 
		String newBalS2 = df2.format(newBalR2); 
		
		System.out.println("/////////////PreviousBalR2//////////- "+"\n" + previousBalS2);
		System.out.println("/////////////TransferR2//////////- "+"\n" + transferAmoR2);
		System.out.println("////NewBalR2///- "+"\n"+previousBalS2+"+ "+transferAmoR2+"= "+newBalS2);
		System.out.println("////NewBalS2///- "+"\n" +newBalS2);
		System.out.println("////remaBalS2///- "+"\n" +remaBalS2);
		Assert.assertEquals(newBalS2, remaBalS2, "RemainingBalance Validated");
		
		System.out.println("///////////Receiver Remaining Balance Success/////////////// ");			

//Verify Activity log in Oracle DB --------------------------------------------------		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/application.properties");
		prop.load(fis);
		
		String url = prop.getProperty("transfer.datasource.url");
		String host = prop.getProperty("transfer.datasource.host");
		String port = prop.getProperty("transfer.datasource.port");
		String sid = prop.getProperty("transfer.datasource.sid");
		String username = prop.getProperty("transfer.datasource.username");
		String password = prop.getProperty("transfer.datasource.password");
		
		System.out.println("-------------url--------" + url);
		System.out.println("-------------host--------" + host);
		System.out.println("-------------port--------" + port);
		System.out.println("-------------sid--------" + sid);
		System.out.println("-------------username--------" + username);
		System.out.println("-------------password--------" + password);
		
		String query = "SELECT * FROM CRMADM.FIN_ACTIVITY_INFORMATION WHERE fin_txn_ref_id ='" +transRef+"'"; 		
		System.out.println("-------------query--------" + query);
		
		Oracle_DB db = new Oracle_DB();
		ResultSet result1 = db.crmDB(url, host, port, sid, username, password, query);
		while (result1.next()) {
			String crmDB= result1.getString("CRM_ID");
			System.out.println("-------------CRM_ID--------" +crmDB );
			Assert.assertEquals(crmId, crmDB, "crmDB validated");
			
			String tranRefDB= result1.getString("FIN_TXN_REF_ID");
			System.out.println("-------------FIN_TXN_REF_ID--------" +tranRefDB );
			Assert.assertEquals(transRef, tranRefDB, "FIN_TXN_REF_ID validated");
			
			System.out.println("-------------FIN_TXN_DATE--------" + result1.getString("FIN_TXN_DATE"));

			String activityTypeDB= result1.getString("ACTIVITY_TYPE_ID");
			System.out.println("-------------ACTIVITY_TYPE_ID--------" +activityTypeDB );
			Assert.assertEquals("023", activityTypeDB, "ACTIVITY_TYPE_ID");
			
			System.out.println("-------------TXN_CD--------" + result1.getString("TXN_CD"));		
			System.out.println("-------------CHANNEL_ID --------" + result1.getString("CHANNEL_ID"));			
			
			String fromAcDB= result1.getString("FROM_ACCT_ID");
			System.out.println("-------------FROM_ACCT_ID --------" +fromAcDB );
			Assert.assertEquals(fromAccountNo, fromAcDB, "FROM_ACCT_ID validated");	
			
			System.out.println("-------------FROM_ACCT_NAME--------" + result1.getString("FROM_ACCT_NAME"));
			System.out.println("-------------FROM_ACCT_NICKNAME--------" + result1.getString("FROM_ACCT_NICKNAME"));
			
			String toAcDB= result1.getString("TO_ACCT_ID");
			System.out.println("-------------TO_ACCT_ID --------" +toAcDB );
			Assert.assertEquals(toAccountNo, toAcDB, "TO_ACCT_ID validated");	
			
			System.out.println("-------------TO_ACCT_NAME--------" + result1.getString("TO_ACCT_NAME"));
			System.out.println("-------------TO_ACCT_NICKNAME--------" + result1.getString("TO_ACCT_NICKNAME"));
			System.out.println("-------------TO_BANK_ACCT_CD--------" + result1.getString("TO_BANK_ACCT_CD"));
			
			String transAmountDB= result1.getString("FIN_TXN_AMOUNT");
			System.out.println("-------------FIN_TXN_AMOUNT --------" +transAmountDB );
			Assert.assertEquals(amount, transAmountDB, "FIN_TXN_AMOUNT validated");
			
			System.out.println("-------------FIN_TXN_FEE--------" + result1.getString("FIN_TXN_FEE"));
			
			String transBalDB= result1.getString("FIN_TXN_BALANCE");
			Double transBalDB1 = Double.parseDouble(transBalDB);
			String transBalDB2 = df2.format(transBalDB1); 
			System.out.println("-------------FIN_TXN_BALANCE --------" +transBalDB2 );
			Assert.assertEquals(remaBalS1, transBalDB2, "FIN_TXN_BALANCE validated");
			
			System.out.println("-------------FIN_TXN_MEMO  --------" + result1.getString("FIN_TXN_MEMO"));
			System.out.println("-------------BILLER_COMM_CODE --------" + result1.getString("BILLER_COMM_CODE"));
			
			String smartFlagDB= result1.getString("SMART_FLAG");
			System.out.println("-------------SMART_FLAG --------" +smartFlagDB );
			Assert.assertEquals("N", smartFlagDB, "SMART_FLAG validated");
			
			System.out.println("-------------CREATE_DATE--------" + result1.getString("CREATE_DATE"));
			System.out.println("-------------ACTIVITY_REF_ID--------" + result1.getString("ACTIVITY_REF_ID"));
			System.out.println("-------------TD_TAX_AMOUNT--------" + result1.getString("TD_TAX_AMOUNT"));
			System.out.println("-------------TD_PENALTY_AMOUNT--------" + result1.getString("TD_PENALTY_AMOUNT"));
			System.out.println("-------------TD_NET_AMOUNT--------" + result1.getString("TD_NET_AMOUNT"));
			
			String idTypeDB= result1.getString("ANY_ID_TYPE");
			System.out.println("-------------ANY_ID_TYPE --------" +idTypeDB );

			String idValueDB= result1.getString("ANY_ID_VALUE");
			System.out.println("-------------ANY_ID_VALUE --------" +idValueDB );	
			
			String activityTypeNewDB= result1.getString("ACTIVITY_TYPE_ID_NEW");
			System.out.println("-------------ACTIVITY_TYPE_ID_NEW--------" +activityTypeNewDB );
			Assert.assertEquals("100400100", activityTypeNewDB, "ACTIVITY_TYPE_ID_NEW");
			
			System.out.println("///////////Activity Log Success/////////////// ");	
		}
	}
	
}
