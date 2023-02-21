package com.getrequest;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Get_02 {
	@Test
	public void get_01() {
		
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
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
										            .toString();
					
		            
		                              validatbleRes.assertThat()
		                                            .statusCode(200)
		                                            .statusLine("HTTP/1.1 200 OK");
		                                            
	}
	@Test
	public void get_02() {
		
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
		 specBuilder.setBaseUri("https://restful-booker.herokuapp.com/");
		 specBuilder.setBasePath("{bookings}");
         specBuilder.addPathParam("bookings","booking");
        
          
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
					
		                              validatbleRes
		                                            .statusCode(200)
		                                            .statusLine("HTTP/1.1 200 OK");
		                              		         
                      
		                                
	}
	
}
