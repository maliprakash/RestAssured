package com.concepts;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateResTime {
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
	                           
	                              // verify response time = expect less than 5 seconds
	                           validatbleRes.time(Matchers.lessThan(5000L));
	                           validatbleRes.time(Matchers.greaterThan(2000L));
	                         
                       
	                           // get response time
	                           long timeInMilisecond = response.getTime();
                               long timeInSecond = response.timeIn(TimeUnit.SECONDS);
                               long timeinMinutes = response.getTimeIn(TimeUnit.MINUTES);
                               
                              
                               System.out.println(timeInMilisecond);
                               System.out.println(timeInSecond);
                               System.out.println(timeinMinutes);
                               
	}	
}
