package com.xmlPayload;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class xmlPostrequest {
	
	@Test
	public void postrequest() {
		
		//https://reqres.in/api/register
		String postPayload = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n"
				+ "<root>\r\n"
				+ "  <name>morpheus</name>\r\n"
				+ "  <job>leader</job>\r\n"
				+ "</root>";
		
		
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/register");
		specBuilder.setContentType(ContentType.XML);
		specBuilder.setBody(postPayload);
		
		RequestSpecification buildRequest = specBuilder.build();
		
					 Response response = RestAssured.given()
							                        .spec(buildRequest)
										           .log()
										           .all()
										           .when()
										           .post();
						           
	 ValidatableResponse validatableresponse = response.then();
	                       
	 String responsebody = validatableresponse.log()
										     .all()
										     .extract()
										     .response() 
										     .asString();
										
	 validatableresponse.contentType(ContentType.XML);
	 
		System.out.println(responsebody);
		

	}
}
