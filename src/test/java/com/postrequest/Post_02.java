package com.postrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Post_02 {

	//@Test
	public void Post_Req() {
		
		// payload as a string
		
		String payload = "{\r\n"
				+ "  \"firstname\": \"Jim\",\r\n"
				+ "  \"lastname\": \"Brown\",\r\n"
				+ "  \"totalprice\": 111,\r\n"
				+ "  \"depositpaid\": true,\r\n"
				+ "  \"bookingdates\": {\r\n"
				+ "    \"checkin\": \"2018-01-01\",\r\n"
				+ "    \"checkout\": \"2019-01-01\"\r\n"
				+ "  },\r\n"
				+ "  \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}";
				
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder.setBaseUri("https://restful-booker.herokuapp.com").setBasePath("/booking")	
        .setBody(payload)
        .setContentType(ContentType.JSON);
        
        RequestSpecification buildRequest = specBuilder.build();
	
        String responseBody = RestAssured.given()
								                   .spec(buildRequest)
										           .log()
										           .all()
										           .when()
										           .post()
										           .then()
										           .log()
										           .all()
										           .extract()
										           .response()
										           .asString();
								        
	JsonPath jsonpath = new JsonPath(responseBody);
	Object firstname = jsonpath.get("firstname");
	System.out.println(firstname);

	}
	
	@Test
	public void Post_Req01() {
		
		String payload = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
				
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 specBuilder.setBaseUri("https://reqres.in")
	    .setBasePath("/api/users")
        .setBody(payload)
        .setContentType(ContentType.JSON);
        
        RequestSpecification buildRequest = specBuilder.build();
	
        String responseBody = RestAssured.given()
								                   .spec(buildRequest)
										           .log()
										           .all()
										           .when()
										           .post()
										           .then()
										           .log()
										           .all()
										           .extract()
										           .response()
										           .asString();
								        
	JsonPath jsonpath = new JsonPath(responseBody);
	Object firstname = jsonpath.get("firstname");
	System.out.println(firstname);
	
	
	}
	
}
