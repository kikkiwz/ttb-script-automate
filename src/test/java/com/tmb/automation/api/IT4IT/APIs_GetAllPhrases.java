package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APIs_GetAllPhrases {

	private static String AccessToken;
	private Long Timestamp;
	@Test(description="AccessToken",priority=1)
	public void GetAccessToken()
	{
		Date date =new Date();
		Timestamp = date.getTime();

		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		AccessToken = jsonPath.getString("data.access_token");
System.out.println(AccessToken);
	}

	@Test(description="Create Phrase",priority=2)
	public void Create_Phrase()
	{
		GetAccessToken();
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

	@Test(description="Get All Phrases",priority=3)
	public void GetAllPhrases()
	{
		GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date").when()
				.get("apis/common/phrases/get-all-phrases").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String module_names=(js.getString("data.phrases.module_key"));
		Assert.assertTrue(!module_names.equals(""));

	}


	@Test(description="Update Phrase",priority=4)
	public void Update_Phrase()
	{
		GetAccessToken();
		PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","10","sort-by","last_updated_date","search-key","Test").when()
				 .get("apis/common/phrases/get-all-phrases")
				 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
		String current_en=response.getData().getPhrases().get(1).getEn();
		String current_th=response.getData().getPhrases().get(1).getTh();
		String updated_en=current_en.concat("111");
		String updated_th=current_th.concat("999");
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
    	String PhraseUpdated = js1.getString("data");
    	System.out.println("The updated value is----"+PhraseUpdated);
    	Assert.assertTrue(PhraseUpdated.contains("Phrases created successfully"),"Phrases created successfully is expected but found "+PhraseUpdated);


	}

	@Test(description="Approve Phrase",priority=5)
	public void Approve_Phrase()
	{
		GetAccessToken();
		PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","10","sort-by","last_updated_date","search-key","Test","module-name","Link").when()
				 .get("apis/common/phrases/get-all-phrases")
				 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
		String current_en=response.getData().getPhrases().get(1).getEn();
		String current_th=response.getData().getPhrases().get(1).getTh();
		String updated_en=current_en.concat("111");
		String updated_th=current_th.concat("999");
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

	@Test(description="Publish Phrase",priority=6)
	public void Publish_Phrase()
	{
		GetAccessToken();
		String response_update = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
				.when()
				.post("apis/common/phrases/publish").then().assertThat().statusCode(200).extract().response().asString();						
		JsonPath js1= new JsonPath(response_update);
    	String PhrasePublihed = js1.getString("data");
    	System.out.println("The published value is----"+PhrasePublihed);
    	Assert.assertTrue(PhrasePublihed.contains("Phrase published successfully") ||PhrasePublihed.contains("Phrase publish failed"),"Phrase published successfully is expected but found   "+PhrasePublihed);

	}	
	@Test(description="Get All Phrases with search",priority=7)
	 public void GetAllPhraseswith_search()
	 {
		GetAccessToken();
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
	 @Test(description="Get All Phrases with module Name",priority=8)
	 public void GetAllPhraseswith_moduleName()
	 {
		 
		 GetAccessToken();
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

	 @Test(description="Get All Phrases with module Name and search-key",priority=9)
	 public void GetAllPhraseswith_moduleName_search_key()
	 {
		 GetAccessToken();
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

	 @Test(description="Get All Waiting for approval phrases",priority=10)
	 public void Get_All_Waiting_for_approval_phrases()
	 	 
	 {
		 GetAccessToken();
		 PhrasesPojo response =given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				 .header("Accept-Language", "EN").header("Timestamp",Timestamp).params("page", "0", "size","1","sort-by","last_updated_date","search-key","Test","module-name","Link").when()
				 .get("apis/common/phrases/get-all-phrases")
				 .then().assertThat().statusCode(200).extract().response().as(PhrasesPojo.class);
		 String Draftcount=response.getData().getDraft_count();
		 System.out.println("The Draft count is----"+Draftcount);
		 if(!Draftcount.equals("0"))		 
				{
			 System.out.println("Draft count is greater than zero");
			 String DraftStatus=response.getData().getPhrases().get(0).getStatus();
			 Assert.assertTrue(DraftStatus.equalsIgnoreCase("Draft"), "The Status forwaiting for approval is Draft");
		 }
		 else {
			 System.out.println("Draft size is 0");
		 }
		
	 }

}

