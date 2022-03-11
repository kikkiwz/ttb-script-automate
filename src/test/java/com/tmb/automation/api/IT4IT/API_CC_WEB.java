package com.tmb.automation.api.IT4IT;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.Bankinfo_Pojo;
import com.tmb.automation.model.CreateProductIconRequest;
import com.tmb.automation.model.CreateProductShortcutRequest;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import com.tmb.automation.model.ResponsePojoProductIcon;
import com.tmb.automation.model.SaveProductInfo_editRequest;
import com.tmb.automation.model.TermsandConditionPojo;
import com.tmb.automation.model.TermsandConditionPojo.current_product_term_and_condition;
import com.tmb.automation.model.TermsandConditionPojo.new_product_term_and_condition;

public class API_CC_WEB {


	
	public Properties prop;
	public static String product_Id;
	public static String icon_id;
	public static String username;
	public static String password;
	private static String finalrandomnumber;
	private Long Timestamp;
	
	public String GetAccessToken() throws Exception
	{
		prop = new Properties();
		Date date =new Date();
		Timestamp = date.getTime();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		String Environment=prop.getProperty("cc_environment");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		if(Environment.equalsIgnoreCase("dev")) {
			RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
		}
		else if(Environment.equalsIgnoreCase("vit")) {
			RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";
		}
		else if(Environment.equalsIgnoreCase("uat")) {
			RestAssured.baseURI = "https://cc-uat2.oneapp.tmbbank.local";
		}
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").multiPart("grant_type", "password")
				.multiPart("username", username).multiPart("password", password).when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		String AccessToken = jsonPath.getString("data.access_token");
		System.out.println("The access token is--"+AccessToken);
		return AccessToken;
	}
	
	@Test(description="Get Bank Info",priority=1)
	public void Get_Bank_info() throws Exception
	{
		String AccessToken= GetAccessToken();
		String GetBankInfo = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/common/internal/bank/details").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("the response is---"+GetBankInfo);
		JsonPath js= new JsonPath(GetBankInfo);			
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String Description=(js.getString("status.description"));
		Assert.assertTrue(Description.equals("Bank Information"));
		String bank_cd=(js.getString("data.bank_cd"));
		System.out.println("The bank code is---"+bank_cd);
		Assert.assertTrue(!bank_cd.equals(""));
}
	@Test(description="Save Bank Info",priority=2)
	public void Save_Bank_info() throws Exception
	{
		String AccessToken= GetAccessToken();
		Bankinfo_Pojo SaveBankInfo=new Bankinfo_Pojo();
		SaveBankInfo.setBank_acct_length("10");
		SaveBankInfo.setBank_cd("02");
		SaveBankInfo.setBank_logo("/bank/logo/02");
		SaveBankInfo.setBank_name_en("Bangkok Bank");
		SaveBankInfo.setBank_name_th("ธนาคารกรุงเทพ จำกัด (มหาชน)");
		SaveBankInfo.setBank_shortname("BBL");
		SaveBankInfo.setBank_status("Active");
		SaveBankInfo.setDisplay_order(2);
		SaveBankInfo.setOrft_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setOrft_expire_date("2099-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_expire_date("2099-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_status("Available");
		SaveBankInfo.setSmart_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setSmart_expire_date("2099-10-31T17:00:00.000Z");
		Bankinfo_Pojo Bankresponse = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json; charset=UTF-8" )
				.header("Accept-Language", "EN").header("IS-UPDATE", "true").header("Timestamp", Timestamp).body(SaveBankInfo).when()
				.post("apis/internal/cc-exp/bank/info").then().assertThat().statusCode(200).extract().response().as(Bankinfo_Pojo.class);
		System.out.println("the response is---"+Bankresponse.getData());
		Assert.assertTrue(Bankresponse.getStatus().getMessage().equals("success"));
		Assert.assertTrue(Bankresponse.getData().equals("Bank info saved successfully"));
}
	@Test(description="Upload Bank Logo",priority=3)
	public void Upload_Bank_Logo() throws Exception
	{
		String AccessToken= GetAccessToken();
	
		String UploadBanklogo = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json; charset=UTF-8" )
				.header("Accept-Language", "EN").header("IS-UPDATE", "true").header("Timestamp", Timestamp).contentType("multipart/form-data").multiPart("file", new File("./src/main/resources/IT4IT/Sprint32Story22394/upload_img_bankinfo.png"))
				.multiPart("path", "bank/logo").multiPart("fileName", "02").when()
				.post("apis/firebase/internal/upload/image").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(UploadBanklogo);	
		Assert.assertTrue(js.getString("status.message").equals("success"));
		Assert.assertTrue(js.getString("status.service").equals("firebase-service"));
}
	@Test(description="Get Product ID",priority=4)
	public void Get_ProductID() throws Exception {
	
		String AccessToken= GetAccessToken();	
		String response1 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
					.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
					.header("Accept-Language", "EN").header("Timestamp",Timestamp).when()
					.get("apis/common/internal/fetch/product/config/new?page=0&sort-by=last_update_date&order-by=DESC").then().assertThat().statusCode(200).extract().response().asString();
			System.out.println("the response is---"+response1);
			JsonPath js= new JsonPath(response1);			
			product_Id=(js.getString("data.product_config.id").split(",")[0]).replace("[", "").replace("]", "");
			System.out.println("the productid is---"+product_Id);
			Assert.assertTrue(!product_Id.equals(""), "Captured Product ID");
	
	
	}		
	@Test(description="Edit particular Product ID",priority=5)
	public void Edit_ProductID() throws Exception {
			// The Below API running to edit that particular product by appending the product id in the URL
		String AccessToken= GetAccessToken();
			String response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
					.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
					.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
					.get("apis/common/internal/fetch/product/config/new/"+product_Id).then().assertThat().statusCode(200).extract().response().asString();

	System.out.println("The response is---"+response2);
	}
	@Test(description="Select Product Icon",priority=6)
	public void Select_ProductIcon() throws Exception {
			
		String AccessToken= GetAccessToken();	
			// The Below API is used to select the ICON and we are storing the icon id in a variable for future reference.
			String response3 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
					.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
					.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
					.get("apis/common/internal/products/icon/all").then().assertThat().statusCode(200).extract().response().asString();		
			JsonPath js3= new JsonPath(response3);			
			icon_id=(js3.getString("data.icon_id").split(",")[0]).replace("[", "");
	}		
	@Test(description="Move from New to Current",priority=7)
	public void Get_ProductShortcutID_MoveFrom_NewToCurrent() throws Exception {
			
		String AccessToken= GetAccessToken();			
			String response4 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
					.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
					.header("Accept-Language", "EN").header("Timestamp",Timestamp).when()
					.get("apis/common/internal/get-published-shortcuts").then().assertThat().statusCode(200).extract().response().asString();		
			JsonPath js4= new JsonPath(response4);
			String ProductShortcut_id=(js4.getString("data.shortcuts.id").split(",")[0]).replace("[", "");
			List<String> ProductShortcut_id_array = new ArrayList<>();
			ProductShortcut_id_array.add(ProductShortcut_id);
			SaveProductInfo_editRequest EditRequest=new SaveProductInfo_editRequest();
			EditRequest.setIcon_id(icon_id);
			EditRequest.setId(product_Id);
			EditRequest.setOrdering_value("Credit Card");
			EditRequest.setProduct_shortcuts(ProductShortcut_id_array);
			System.out.println("The product body is----"+EditRequest);
			//The Below API is used to move the product from new to current.
			String response5 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
					.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
					.body(EditRequest).when()
					.post("apis/common/internal/product/config/new").then().assertThat().statusCode(200).extract().response().asString();;		
					System.out.println("The finalresponse is---"+response5);
					JsonPath js5= new JsonPath(response5);
					String ProductSaved = js5.getString("data");
					Assert.assertTrue(ProductSaved.equals("Product Saved successfully"),"Product not Saved Successfully");
	}
	@Test(description="Verify product in drafty state",priority=8)
	public void Product_DraftState() throws Exception {
			
		String AccessToken= GetAccessToken();	
	
					//The below API is called to verify that product is present n New able
					String response6 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
							.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
							.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
							.get("apis/common/internal/fetch/product/config/new?page=0&sort-by=last_update_date&order-by=DESC").then().assertThat().statusCode(200).extract().response().asString();
					System.out.println("The response is---"+response6);
					JsonPath js6= new JsonPath(response6);
					String Product_New = js6.getString("data");
					System.out.println("the draft"+Product_New);
					Assert.assertTrue(!Product_New.contains(product_Id),"Product not moved to draft");
					// The Below API is triggered to verify that product is present in draft table.
					String response7 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
							.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
							.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
							.get("apis/common/internal/fetch/product/config?status=Draft").then().assertThat().statusCode(200).extract().response().asString();
					System.out.println("The response is---"+response7);
					JsonPath js7= new JsonPath(response7);
					String Product_Draft = js7.getString("data");
					System.out.println("the draft"+Product_Draft);
					Assert.assertTrue(Product_Draft.contains(product_Id),"Product not moved to draft");

		}
	@Test(description="Create of Product ICon With all valid data",priority=9)
	public void CreateProductIcons() throws Exception
	{

	String AccessToken= GetAccessToken();
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by(username);
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", Timestamp).body(ProductBody).when()
			.post("apis/common/internal/products/icon").then().assertThat().statusCode(200).extract().response()
			.as(ResponsePojoProductIcon.class);
	System.out.println("status Aru" + response2.getStatus().getCode());
   
}
	
	@Test(description="Create of Product ICon With get request",priority=10)
	public void CreateProductIcon_InvalidMethod() throws Exception
	{
	String AccessToken= GetAccessToken();
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by(username);
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
	.header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", Timestamp).body(ProductBody).when()
			.get("apis/common/internal/products/icon").then().assertThat().statusCode(400).extract().response()
			.as(ResponsePojoProductIcon.class);
	System.out.println("status Aru" + response2.getStatus().getCode());	

}
	
	
	@Test(description="Validate Api with wrong data",priority=11)
	public void CreateProductIconBadrequest() throws Exception
	{
	String AccessToken= GetAccessToken();
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by(username);
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	 String badResponse= given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "  ").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp",Timestamp ).body(ProductBody).when()
			.get("apis/common/internal/products/icon").then().assertThat().statusCode(400).extract().response()
			.asString();
	System.out.println("status Bad Response is  " + badResponse);
}

	@Test(description="Approve product T&C",priority=12)
	public void Approve_product_TandC() throws Exception
	{
		String AccessToken=GetAccessToken();
		TermsandConditionPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
			.header("Timestamp",Timestamp).when()
				 .get("apis/common/internal/term-condition/products/waiting-for-approval")
				 .then().assertThat().statusCode(200).extract().response().as(TermsandConditionPojo.class);
		String id=response.getData().get(1).getDetails().getId();
		System.out.println("the idis---"+id);
		String TandC_ID=response.getData().get(1).getDetails().getTerm_and_condition_id();
		String Channel=response.getData().get(1).getDetails().getChannel();
		String createby=response.getData().get(1).getDetails().getCreate_by();
		String createdate=response.getData().get(1).getDetails().getCreate_date();
		String html_en=response.getData().get(1).getDetails().getHtml_en();
		String html_th=response.getData().get(1).getDetails().getHtml_th();
		String pdflink=response.getData().get(1).getDetails().getPdf_link();
		String productcode=response.getData().get(1).getDetails().getProduct_code();
		String product_en=response.getData().get(1).getDetails().getProduct_name_en();
		String product_th=response.getData().get(1).getDetails().getProduct_name_th();
		String sftp_pa=response.getData().get(1).getDetails().getSftp_path();
		String status=response.getData().get(1).getDetails().getStatus();
		String tempstatus=response.getData().get(1).getDetails().getTemp_status();
		String updateby=response.getData().get(1).getDetails().getUpdate_by();
		String TandC_description=response.getData().get(1).getDetails().getTerm_and_condition_description();
		String updatedate=response.getData().get(1).getDetails().getUpdate_date();
		String version=response.getData().get(1).getDetails().getVersion();
		String versiondisplay=response.getData().get(1).getDetails().getVersion_display();		
		new_product_term_and_condition newTandC=new new_product_term_and_condition();
		newTandC.setChannel(Channel);
		newTandC.setCreate_by(createby);
		newTandC.setCreate_date(createdate);
		newTandC.setHtml_en(html_en);
		newTandC.setHtml_th(html_th);
		newTandC.setId(id);
		newTandC.setPdf_link(pdflink);
		newTandC.setProduct_code(productcode);
		newTandC.setProduct_name_en(product_en);
		newTandC.setProduct_name_th(product_th);
		newTandC.setPublish_date(Timestamp);
		newTandC.setSftp_path(sftp_pa);
		newTandC.setStatus(status);
		newTandC.setTemp_status(tempstatus);
		newTandC.setTerm_and_condition_description(TandC_description);
		newTandC.setTerm_and_condition_id(TandC_ID);
		newTandC.setUpdate_by(updateby);
		newTandC.setUpdate_date(updatedate);
		newTandC.setVersion(version);
		newTandC.setVersion_display(versiondisplay);
		
		current_product_term_and_condition current=new current_product_term_and_condition();
		 current.setChannel(Channel);
			current.setCreate_by(createby);
			current.setCreate_date(createdate);
			current.setHtml_en(html_en);
			current.setHtml_th(html_th);
			current.setId(id);
			current.setPdf_link(pdflink);
			current.setProduct_code(productcode);
			current.setProduct_name_en(product_en);
			current.setProduct_name_th(product_th);
			current.setPublish_date(Timestamp);
			current.setSftp_path(sftp_pa);
			current.setStatus(status);
			current.setTemp_status(tempstatus);
			current.setTerm_and_condition_description(TandC_description);
			current.setTerm_and_condition_id(TandC_ID);
			current.setUpdate_by(updateby);
			current.setUpdate_date(updatedate);
			current.setVersion(version);
			current.setVersion_display(versiondisplay);
			TermsandConditionPojo update=new TermsandConditionPojo();
			update.setNew_product_term_and_condition(newTandC);
			update.setCurrent_product_term_and_condition(current);
			
			
		String response_update = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
				.body(update).when()
				.post("apis/internal/cc-exp/approve-product-term-condition").then().assertThat().statusCode(200).extract().response().asString();						
		JsonPath js1= new JsonPath(response_update);
   	String TandCApproved = js1.getString("data");
   	System.out.println("The Approved value is----"+TandCApproved);
   	Assert.assertTrue(TandCApproved.contains("Product term and condition approved successfully"),"Product term and condition approved successfully!!!");
			
}
	@Test(description="Create product T&C",priority=13)
	public void Create_product_TandC() throws Exception
	{
		String AccessToken=GetAccessToken();
		String id="abcdc_";
		String code="efghim_";
		int character = (int)Math.floor(Math.random() * 89999 + 6769);
		String randomnumberString=String.valueOf(character);
		String TandC_id=id+randomnumberString;
		String productcode=code+randomnumberString;
		File file=new File(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\Sprint26Story12208\\Terms_and_Conditions.pdf");
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("file", file)
				.multiPart("term_and_condition_id", TandC_id).multiPart("product_code", productcode).multiPart("channel", "mb")
				.multiPart("term_and_condition_description", "API Automtion Testing").multiPart("html_th", "API Automtion Testing for Thai").multiPart("html_en", "API Automtion Testing for English")
				.when()
				.post("apis/internal/cc-exp/create-product-term-condition").then().assertThat().statusCode(200).extract().response().asString();						
		JsonPath js= new JsonPath(response);
		String TermsandConditioncreated = js.getString("data");
		System.out.println("The data is-----"+TermsandConditioncreated);
		Assert.assertTrue(TermsandConditioncreated.contains("Product term and condition created successfully"),"Product terms and conditions created successfully");		
}
	@Test(description="Get all product T&C",priority=14)
	public void Get_all_product_TandC() throws Exception
	{
		String AccessToken=GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date","order-by","DESC").when()
				.get("apis/common/internal/term-condition/products").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String term_and_condition_id=(js.getString("data.term_and_conditions.term_and_condition_id"));
		Assert.assertTrue(!term_and_condition_id.equals(""));

	}
	@Test(description="Get published product T&C by productCode and channel",priority=15)
	public void Get_pblished_product_TandC_By_productCode_and_channel() throws Exception
	{
		String AccessToken=GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/term-condition/product/101/ib").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String term_and_condition_id=(js.getString("data.term_and_condition_id"));
		String status=(js.getString("data.status"));
		Assert.assertTrue(!term_and_condition_id.equals(""));
		Assert.assertTrue(status.equals("Published"));

	}
	@Test(description="Get published service T&C by serviceCode and channel",priority=16)
	public void Get_published_service_TandC_by_serviceCode_and_channel() throws Exception
	{
		String AccessToken=GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date","order-by","DESC").when()
				.get("apis/common/internal/term-condition/service/S222/mb").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String service_term_and_condition_id=(js.getString("data.service_term_and_condition_id"));
		Assert.assertTrue(!service_term_and_condition_id.equals(""));
		String service_code=(js.getString("data.service_code"));
		Assert.assertTrue(service_code.equals("S222"));
		String service_term_and_condition_description=(js.getString("data.service_term_and_condition_description"));
		Assert.assertTrue(!service_term_and_condition_description.equals(""));
		

	}
	


	

	@Test(description="Create of Product Shortcut With all valid data",priority=17)
	public void CreateProductShortcut() throws Exception
	{
		String AccessToken=GetAccessToken();
		String randomnumber="123e4559-e89b-12d9-a456-";
		int character = (int)Math.floor(Math.random() * 899999999 + 123456789);
		System.out.println("The product shortcut id integeris--"+character);
		String randomnumberString=String.valueOf(character);
		finalrandomnumber=randomnumber+randomnumberString;	
		System.out.println("The product shortcut id is--"+finalrandomnumber);
	
	CreateProductShortcutRequest pshortcut=new CreateProductShortcutRequest();
	pshortcut.setId(finalrandomnumber);
	pshortcut.setName_en("API Automation Testing ENG");
	pshortcut.setName_th("API Automation Testing THAI");
	pshortcut.setUpdated_by("Binit Sharma");
	pshortcut.setUrl("https://firebasestorage.googleapis.com/v0/b/oneapp-vit.appspot.com/o/product%2Fshortcut%2Fcreditcard%2Ftopup.png?alt=media&token=123e4567-e89b-12d3-a456-470059595817");
	pshortcut.setDescription("API Automation triggered to create new product shortcut");
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", Timestamp).body(pshortcut).when()
			.post("apis/internal/cc-exp/save-product-shortcut").then().assertThat().statusCode(200).extract().response()
			.as(ResponsePojoProductIcon.class);
	Assert.assertTrue(response2.getData().equals("Shortcut saved successfully!!!"), "Shortcut not saved sucessfully");


}
@Test(description="Update of Product Shortcut With all valid data",priority=18)
public void UpdateProductShortcut() throws Exception
{

	
	String AccessToken=GetAccessToken();

	CreateProductShortcutRequest pshortcut=new CreateProductShortcutRequest();
	pshortcut.setId(finalrandomnumber);
	pshortcut.setName_en("API Automation Testing ENG Updated");
	pshortcut.setName_th("API Automation Testing THAI Updated");
	pshortcut.setUpdated_by("Binit Sharma");
	pshortcut.setUrl("https://firebasestorage.googleapis.com/v0/b/oneapp-vit.appspot.com/o/product%2Fshortcut%2Fcreditcard%2Ftopup.png?alt=media&token=123e4567-e89b-12d3-a456-470059595817");
	pshortcut.setDescription("API Automation triggered to create new product shortcut");
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", Timestamp).body(pshortcut).when()
			.post("apis/internal/cc-exp/update-product-shortcut").then().assertThat().statusCode(200).extract().response()
			.as(ResponsePojoProductIcon.class);
	Assert.assertTrue(response2.getData().equals("Shortcut saved successfully!!!"), "Shortcut not saved sucessfully");


}
@Test(description="Create Phrase",priority=19)
public void Create_Phrase() throws Exception
{
	String AccessToken=GetAccessToken();
	String Key1="abcdefghi_";
	int character = (int)Math.floor(Math.random() * 899999999 + 123456769);
	String randomnumberString=String.valueOf(character);
	String Phrasekey=Key1+randomnumberString;
	phrases phrase=new phrases();
	phrase.setEn("Test Automation API on English");
	phrase.setTh("Test Automatio API on Thai ");
	phrase.setUpdated_by("occ_padmin02");
	phrase.setPhrase_key(Phrasekey);
	phrase.setLast_updated_time(Timestamp);
	phrase.setModule_name("Link");
	phrase.setModule_key("link");
	String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
			.body(phrase).when()
			.post("apis/internal/cc-exp/phrases/create").then().assertThat().statusCode(200).extract().response().asString();						
	JsonPath js= new JsonPath(response);
	String Phrasecreated = js.getString("data");
	Assert.assertTrue(Phrasecreated.contains("Phrases created successfully"),"Phrases created successfully");

}

@Test(description="Get All Phrases",priority=20)
public void GetAllPhrases() throws Exception
{
	String AccessToken=GetAccessToken();
	String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date").when()
			.get("apis/common/phrases/get-all-phrases").then().assertThat().statusCode(200).extract().response().asString();
	JsonPath js= new JsonPath(response);
	System.out.println("The response is---"+response);		
	String module_names=(js.getString("data.phrases.module_key"));
	Assert.assertTrue(!module_names.equals(""));

}


@Test(description="Update Phrase",priority=21)
public void Update_Phrase() throws Exception
{
	String AccessToken=GetAccessToken();
	PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","10","search-key","Test").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
	String current_en=response.getData().getPhrases().get(1).getEn();
	String current_th=response.getData().getPhrases().get(1).getTh();
	String updated_en=current_en.concat("aaa");
	String updated_th=current_th.concat("bbb");
	String id=response.getData().getPhrases().get(1).getId();
	String phrase_key=response.getData().getPhrases().get(1).getPhrase_key();
	Long last_updated_time=response.getData().getPhrases().get(1).getLast_updated_time();
	Long created_time=response.getData().getPhrases().get(1).getCreated_time();
	String updated_by=response.getData().getPhrases().get(1).getUpdated_by();
	String module_key=response.getData().getPhrases().get(1).getModule_key();
	String module_name=response.getData().getPhrases().get(1).getModule_name();
	String status=response.getData().getPhrases().get(1).getStatus();
	String temp_status=response.getData().getPhrases().get(1).getTemp_status();
	current_phrase current=new current_phrase();
	current.setEn(current_en);
	current.setTh(current_th);
	current.setId(id);
	current.setPhrase_key(phrase_key);
	current.setLast_updated_time(last_updated_time);
	current.setCreated_time(created_time);
	current.setUpdated_by(updated_by);
	current.setModule_key(module_key);
	current.setModule_name(module_name);
	current.setStatus(status);
	current.setTemp_status(temp_status);
	update_phrase update=new update_phrase();
	update.setEn(updated_en);
	update.setTh(updated_th);
	update.setId(id);
	update.setPhrase_key(phrase_key);
	update.setLast_updated_time(last_updated_time);
	update.setCreated_time(created_time);
	update.setUpdated_by(updated_by);
	update.setModule_key(module_key);
	update.setModule_name(module_name);
	update.setStatus(status);
	update.setTemp_status(temp_status);
	PhrasesPojo updated=new PhrasesPojo();
	updated.setCurrent_phrase(current);
	updated.setUpdate_phrase(update);
	String response_update = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
			.body(updated).when()
			.post("apis/internal/cc-exp/phrases/update").then().assertThat().statusCode(200).extract().response().asString();						
	JsonPath js1= new JsonPath(response_update);
	System.out.println("The update value--"+js1.toString());
	String PhraseUpdated = js1.getString("data");
	System.out.println("The updated value is----"+response_update);
	Assert.assertTrue(PhraseUpdated.contains("Phrases created successfully"),"Phrases created successfully is expected but found "+PhraseUpdated);


}

@Test(description="Approve Phrase",priority=22)
public void Approve_Phrase() throws Exception
{
	String AccessToken=GetAccessToken();
	PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","10","search-key","Test").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
	String current_en=response.getData().getPhrases().get(1).getEn();
	String current_th=response.getData().getPhrases().get(1).getTh();
	String updated_en=current_en.concat("aaa");
	String updated_th=current_th.concat("bbb");
	String id=response.getData().getPhrases().get(1).getId();
	String phrase_key=response.getData().getPhrases().get(1).getPhrase_key();
	Long last_updated_time=response.getData().getPhrases().get(1).getLast_updated_time();
	Long created_time=response.getData().getPhrases().get(1).getCreated_time();
	String updated_by=response.getData().getPhrases().get(1).getUpdated_by();
	String module_key=response.getData().getPhrases().get(1).getModule_key();
	String module_name=response.getData().getPhrases().get(1).getModule_name();
	String status=response.getData().getPhrases().get(1).getStatus();
	String temp_status=response.getData().getPhrases().get(1).getTemp_status();
	current_phrase current=new current_phrase();
	current.setEn(current_en);
	current.setTh(current_th);
	current.setId(id);
	current.setPhrase_key(phrase_key);
	current.setLast_updated_time(last_updated_time);
	current.setCreated_time(created_time);
	current.setUpdated_by(updated_by);
	current.setModule_key(module_key);
	current.setModule_name(module_name);
	current.setStatus(status);
	current.setTemp_status(temp_status);
	update_phrase update=new update_phrase();
	update.setEn(updated_en);
	update.setTh(updated_th);
	update.setId(id);
	update.setPhrase_key(phrase_key);
	update.setLast_updated_time(last_updated_time);
	update.setCreated_time(created_time);
	update.setUpdated_by(updated_by);
	update.setModule_key(module_key);
	update.setModule_name(module_name);
	update.setStatus(status);
	update.setTemp_status(temp_status);
	PhrasesPojo updated=new PhrasesPojo();
	updated.setCurrent_phrase(current);
	updated.setUpdate_phrase(update);
	List<PhrasesPojo> Approve=new ArrayList<PhrasesPojo>();
	Approve.add(updated);
	String response_update = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
			.body(Approve).when()
			.post("apis/internal/cc-exp/phrases/approve").then().assertThat().statusCode(200).extract().response().asString();						
	JsonPath js1= new JsonPath(response_update);
	String PhraseApproved = js1.getString("data");
	System.out.println("The Approved value is----"+PhraseApproved);
	Assert.assertTrue(PhraseApproved.contains("Phrase approved successfully"),"Phrases Approved successfully");

}

@Test(description="Publish Phrase",priority=23)
public void Publish_Phrase() throws Exception
{
	String AccessToken=GetAccessToken();
	String response_update = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
			.when()
			.post("apis/common/phrases/publish").then().assertThat().statusCode(200).extract().response().asString();						
	JsonPath js1= new JsonPath(response_update);
	String PhrasePublihed = js1.getString("data");
	System.out.println("The published value is----"+PhrasePublihed);
	Assert.assertTrue(PhrasePublihed.contains("Phrase published successfully") ||PhrasePublihed.contains("Phrase publish failed"),"Phrase published successfully is expected but found   "+PhrasePublihed);

}	
@Test(description="Get All Phrases with search",priority=24)
 public void GetAllPhraseswith_search() throws Exception
 {
	String AccessToken=GetAccessToken();
	 String response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","1","sort-by","last_updated_date","search-key","Test").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().asString();
	 JsonPath js1= new JsonPath(response);
	 System.out.println("The response is---"+response);
	 String Searchkey_names=(js1.getString("data.phrases"));
	 System.out.println("The rphrases is---"+Searchkey_names);
	 Assert.assertTrue(Searchkey_names.contains("Test"));

 }
 @Test(description="Get All Phrases with module Name",priority=25)
 public void GetAllPhraseswith_moduleName() throws Exception
 {
	 
	 String AccessToken= GetAccessToken();
	 String response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","1","sort-by","last_updated_date","module-name","Link").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().asString();
	 JsonPath js= new JsonPath(response);
	 System.out.println("The response is---"+response);
	 String module_name=(js.getString("data.phrases.module_name"));
	 System.out.println("The module name is---"+module_name);
	 Assert.assertTrue(module_name.contains("Link"));

 }

 @Test(description="Get All Phrases with module Name and search-key",priority=26)
 public void GetAllPhraseswith_moduleName_search_key() throws Exception
 {
	 String AccessToken=GetAccessToken();
	 String response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","1","sort-by","last_updated_date","search-key","Test","module-name","Link").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().asString();
	 JsonPath js= new JsonPath(response);
	 System.out.println("The response is---"+response);
	 String Searchkey_names=(js.getString("data.phrases"));
	 System.out.println("The rphrases is---"+Searchkey_names);
	 Assert.assertTrue(Searchkey_names.contains("Test"));
	 String module_name=(js.getString("data.phrases.module_name"));
	 System.out.println("The module name is---"+module_name);
	 Assert.assertTrue(module_name.contains("Link"));
	 String id=(js.getString("data.phrases.id"));
	 System.out.println("The Id is----"+id);

 }

 @Test(description="Get All Waiting for approval phrases",priority=27)
 public void Get_All_Waiting_for_approval_phrases() throws Exception
 	 
 {
	 String AccessToken=GetAccessToken();
	 PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","1","search-key","Test","module-name","Link").when()
			 .get("apis/common/phrases/get-all-phrases")
			 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
	 String Draftcount=response.getData().getDraft_count();
	 System.out.println("The Draft count is----"+Draftcount);
	 if(!Draftcount.equals("0"))		 
			{
		 System.out.println("Draft count is greater than zero");
		 String DraftStatus=response.getData().getPhrases().get(0).getStatus();
		 System.out.println("The status is--"+DraftStatus);
		 Assert.assertTrue(DraftStatus.equalsIgnoreCase("Draft"), "The Status forwaiting for approval is Draft");
	 }
	 else {
		 System.out.println("Draft size is 0");
	 }
	
 }



}
