package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.TermsandConditionPojo;
import com.tmb.automation.model.TermsandConditionPojo.current_product_term_and_condition;
import com.tmb.automation.model.TermsandConditionPojo.new_product_term_and_condition;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class APIApproveProductTerms_and_conditions {
	
	private static String AccessToken;
	private Long Timestamp;
	
	public String GetAccessToken()
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
        return AccessToken;
	}
	@Test(description="Approve product T&C",priority=1)
	public void Approve_product_TandC()
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
}

