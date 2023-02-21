package com.concepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Path_01 {

	//@Test
	public void json_01() {
		
		String Json = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		JsonPath jsonpath = new JsonPath(Json);	
		Object firstname = jsonpath.get("name");
		System.out.println(firstname);
		
	}
	
	@Test
	public void json_02() {
		
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
		 specBuilder.setBaseUri("https://reqres.in/api/users/2");

		  RequestSpecification reqBuild = specBuilder.build();
		   
		String response = RestAssured.
		             given()
		            .spec(reqBuild)
		            .when()
		            .get()
		            .then()
		            .log()
		            .all()
		            .extract()
		            .response()
		            .toString();
		 
		JsonPath path = new JsonPath(response);		
        Object resData = path.get("data.id");
        
        System.out.println(resData);
        
             
	}	
}
