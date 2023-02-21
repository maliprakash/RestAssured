package com.concepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class filter_Response_Using_Find_And_Findall_Methods {

	// filetr the response in json object
	@Test
	public void getReq_02() {
		
	 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
	 specBuilder.setBaseUri("https://reqres.in/api/users?page=2");

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
									            .toString();
					            
	                              validatbleRes.assertThat()
	                                            .statusCode(200)
	                                            .statusLine("HTTP/1.1 200 OK");
	                                                                                     
	               JsonPath jsonPath = new JsonPath(extarctRes);  
	               Object pageNo = jsonPath.get("per_page");
	               System.out.println("total_pages :"+ pageNo);
	            // Assert.assertEquals(pageNo,2);
	                            
	}	
}
