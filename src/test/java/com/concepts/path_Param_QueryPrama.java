package com.concepts;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class path_Param_QueryPrama {
	//@Test
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
										            .asPrettyString();
					
		            
		                              validatbleRes.assertThat()
		                                            .statusCode(200)
		                                            .statusLine("HTTP/1.1 200 OK");
		                                            
	}
	@Test
	public void get_02() {
		
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		 
		 specBuilder.setBaseUri("https://restful-booker.herokuapp.com").setBasePath("/booking");
		 
		  RequestSpecification reqBuild = specBuilder.build();
		   
					 Response response = RestAssured.
										             given()
										             .log()
											         .all()
										            .spec(reqBuild)
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
		                              		         
		                               /* 
		                       		    long timeInMilisecond = response.getTime();
		                                long timeInSecond = response.timeIn(TimeUnit.SECONDS);
		                                long timeinMinutes = response.getTimeIn(TimeUnit.MINUTES);
		                                System.out.println(timeInSecond);
		                                System.out.println(timeInMilisecond);
		                                System.out.println(timeinMinutes);
		                               */ 
		                          	                                
	}
	
}
