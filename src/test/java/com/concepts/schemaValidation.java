package com.concepts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class schemaValidation {

	    //@Test
		public void postReq_05() throws IOException {		
			// java Collection - list
					
		String payload = "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
			
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder.setBaseUri("https://restful-booker.herokuapp.com").setBasePath("/booking")
		.setBody(payload)
		.setContentType(ContentType.JSON);	
		RequestSpecification reqSecification = specBuilder.build();
		
		Response response = RestAssured.given()
									           .spec(reqSecification)
									           .log()
									           .all()
									           .when()
									           .post();
		
		ValidatableResponse validatableRes = response.then();
		       
		            String extractRes = validatableRes.log()
		                                              .all()
		                                              .extract()
		                                              .response()
		                                              .asString();
     // in .json file in resource folder then use =  JsonSchemaValidator.matchesJsonSchemaInClasspath         
    // validatableRes.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createBokkingJsonSchema.json"));
     
     // in .json file not in resource folder then use = JsonSchemaValidator.matchesJsonSchema
		         String projectPath = System.getProperty("user.dir");
	validatableRes.body(JsonSchemaValidator.matchesJsonSchema(projectPath+"\\createBokkingJsonSchema_1.json"));	            
		            
  }	
	 @Test
	 public void jsonSchema() {
		 
		 String payload = "{\r\n"
					+ "    \"firstname\" : \"Jim\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}";
		 
		 
	//	 MatcherAssert.assertThat(payload,JsonSchemaValidator.matchesJsonSchemaInClasspath("createBokkingJsonSchema.json"));
	 }	    
}
