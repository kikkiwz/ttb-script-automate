package com.tmb.automation.api.IT4IT;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.SaveProductInfo_editRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_SaveProductInfo_EditScreen {
	
	@Test(description="Get all new Products")
	public void GetAllProduct()
	{


		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";

		// The Below API Running For Access Token----	
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").multiPart("grant_type", "password")
				.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("data.access_token");


		//The Below API running for all new products where we are capturing the first product ID and stores in a variable----
		String response1 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/fetch/product/config/new?page=0&sort-by=last_update_date&order-by=DESC").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("the response is---"+response1);
		JsonPath js= new JsonPath(response1);			
		String product_Id=(js.getString("data.product_config.id").split(",")[0]).replace("[", "").replace("]", "");
		System.out.println("the productid is---"+product_Id);
		

		// The Below API running to edit that particular product by appending the product id in the URL
		String response2 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/fetch/product/config/new/"+product_Id).then().assertThat().statusCode(200).extract().response().asString();

		
		
		// The Below API is used to select the ICON and we are storing the icon id in a variable for future reference.
		String response3 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/products/icon/all").then().assertThat().statusCode(200).extract().response().asString();		
		JsonPath js3= new JsonPath(response3);			
		String icon_id=(js3.getString("data.icon_id").split(",")[0]).replace("[", "");
		
		
		//The below API is running the get first product shortcut id and we store in a variable for future reference.
		String response4 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/get-published-shortcuts").then().assertThat().statusCode(200).extract().response().asString();		
		JsonPath js4= new JsonPath(response4);
		
		//The Below code is used to create a body or Request Payload for final API we are running to move the product from new to edit.
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
		String response5 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").header("Content-Type","application/json" )
				.body(EditRequest).when()
				.post("apis/common/internal/product/config/new").then().assertThat().statusCode(200).extract().response().asString();;		
				System.out.println("The finalresponse is---"+response5);
				JsonPath js5= new JsonPath(response5);
				String ProductSaved = js5.getString("data");
				Assert.assertTrue("Product not Saved Successfully",ProductSaved.equals("Product Saved successfully"));

				//The below API is called to verify that product is present n New able
				String response6 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
						.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
						.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
						.get("apis/common/internal/fetch/product/config/new?page=0&sort-by=last_update_date&order-by=DESC").then().assertThat().statusCode(200).extract().response().asString();
				System.out.println("The response is---"+response6);
				JsonPath js6= new JsonPath(response6);
				String Product_New = js6.getString("data");
				System.out.println("the draft"+Product_New);
				Assert.assertTrue("Product not moved to draft",!Product_New.contains(product_Id));


				// The Below API is triggered to verify that product is present in draft table.
				String response7 = given().relaxedHTTPSValidation().auth().oauth2(accessToken).log().all()
						.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
						.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
						.get("apis/common/internal/fetch/product/config?status=Draft").then().assertThat().statusCode(200).extract().response().asString();
				System.out.println("The response is---"+response7);
				JsonPath js7= new JsonPath(response7);
				String Product_Draft = js7.getString("data");
				System.out.println("the draft"+Product_Draft);
				Assert.assertTrue("Product not moved to draft",Product_Draft.contains(product_Id));


	}


}
