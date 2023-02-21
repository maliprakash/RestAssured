package com.putrequest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Put_01 {

	@Test
	public void Put_01() {
		
		String reqPaylod = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
			
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	specBuilder.setBaseUri("https://reqres.in")
			   .setBasePath("/api/users/2")
			   .setBody(reqPaylod)
			   .setContentType(ContentType.JSON);	
				
	RequestSpecification reqSecification = specBuilder.build();
	
	Response response = RestAssured.given()
								           .spec(reqSecification)
								           .log()
								           .all()
								           .when()
								           .put();
	
	ValidatableResponse validatableResponse = response.then();
	       
	            String extractRes = validatableResponse.log()
			                                              .all()
			                                              .extract()
			                                              .response()
			                                              .asString();
	
	           
	                
	}
}
