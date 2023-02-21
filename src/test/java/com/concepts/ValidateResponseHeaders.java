package com.concepts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeaders {
	@Test
	public void getReq_02() {
		
	 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	// https://reqres.in/api/users?page=2
	 specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users?").addQueryParam("page","2");
	
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
									            .asString();
					            
	                              validatbleRes.assertThat()
	                                            .statusCode(200)
	                                            .statusLine("HTTP/1.1 200 OK")
	                                            .header("Content-Type","application/json; charset=utf-8");                
	                                            // validate header
	                     
	                      
	                     // get single header
	                      String contentType = response.header("Content-Type");
	                      System.out.println(contentType);
	               
	                      System.out.println("==========================================================");
	                              
	                   // get list of the headers
	                     Headers headres = response.headers();	                   
	                     System.out.println("list of the headres : " + headres);
	             
	                     System.out.println("==========================================================");
	                     
	                   // size of the response headers
	                     int noOfHeadres = headres.size();
	                     System.out.println(noOfHeadres);
	                  
	}	
}
