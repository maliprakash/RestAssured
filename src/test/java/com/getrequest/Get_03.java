package com.getrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Get_03 {

	@Test
	public void getReq_01() {
		
		 // https://restful-booker.herokuapp.com/booking
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
		 specBuilder.setBaseUri("https://restful-booker.herokuapp.com").setBasePath("/booking");
     
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
		            .asString();
		 
	 JsonPath path = new JsonPath(response);
	 Object zeroindex = path.get("[0]");
	 System.out.println(zeroindex);
	
	
	}
}
