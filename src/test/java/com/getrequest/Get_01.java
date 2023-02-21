package com.getrequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Get_01 {

	//@Test
	public void getReq_01() {
		
	 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
	
     specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users?").addQueryParam("page", "2");
	  RequestSpecification reqBuild = specBuilder.build();
	   
	 RestAssured.
	             given()
	            .spec(reqBuild)
	            .when()
	            .get()
	            .then()
	            .log()
	            .all()
	            .extract()
	            .response()
	            .asPrettyString();
	 
	}
	@Test
	public void getReq_02() {
		
	 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
	 specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users?").addQueryParam("page", "2");

	  RequestSpecification reqBuild = specBuilder.build();
	   
				 Response response = RestAssured.
									             given()
									            .spec(reqBuild)
									            .log()
									            .all()
									            .when()
									            .get();
   ValidatableResponse validatbleRes = response .then();
							            								            		 
	        String extarctRes = validatbleRes   .log()
									            .all()
									            .extract()
									            .response()
									            .asPrettyString();
					            
	                              validatbleRes.assertThat()
	                                            .statusCode(200)
	                                            .statusLine("HTTP/1.1 200 OK");
	                                                                                     
	               JsonPath jsonPath = new JsonPath(extarctRes);  
	               Object pageNo = jsonPath.get("per_page");
	               System.out.println("total_pages :"+ pageNo);
	            // Assert.assertEquals(pageNo,2);
	                            
	}	
}
