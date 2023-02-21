package com.authorization;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiKeyAuthontication {
	// api key is unic string of characters api key generates the server
	// api goes to the as a query parameter and allow them to access the API
	// the client ten sends the key alongwith each request to th sever, and the server uses it to identify 
	// the user and authorize their access to the resources
	// api key 10d843c80fg5876f6724c30fb55b6eb17a3b2f10e03
	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	String ExpectHoleResponseType_JsonObject = "";  
	String ExpectHoleResponseType_JSONArray = "";
	
	
	
//	@Test 
	public void apikey() {
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q","delhi").queryParam("appidkey","2f75210d843c80fg5876f6724c30fb55b6ebae1d0");
	
		Response response = requestSpec.get();		
		System.out.println(response.statusLine());
		
	}
	@Test
	public void apiKey1() {
	        
		
		String apiKey = "appidkey";
		String apiValue ="2f75210d843gigfth87675t868c8024c30fb55b6ebae1d0";
		
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder
		          .setBaseUri("https://api.openweathermap.org")
		          .setBasePath("/data/2.5/weather")
		          .addQueryParam("q","delhi")
		          .addQueryParam(apiKey,apiValue)
		          .setContentType(ContentType.JSON);   
		
   RequestSpecification buildRequest = specBuilder.build();
		
   // given inputs
   Response response = RestAssured.given()
		                                               .spec(buildRequest)
									                   .log()
									                   .all()
						  // action	get	                   
									                   .when()
									                   .get();
		                   
                          // get rsponse
  ValidatableResponse validatableResponse = response.then();								                  
       String responseBody = validatableResponse.log()
									            .all()
						                        .extract()
						                        .response()
						                        .asPrettyString();
						
          
              // validate response points   
                      validatableResponse.statusCode(200)
                                         .statusLine("HTTP/1.1 200 OK")
                                         .contentType(ContentType.JSON)   // validate response content type
                                         .body( ExpectHoleResponseType_JsonObject,Matchers.instanceOf(Map.class))// validate hole response body is json object or json array... 
                                         .time(Matchers.lessThan(9000L)); //response time expect lessthan 7 seconds                                        
		                                                                  //  1 second = 1000 miliseconds
                              
                // validate actual response body                              
                  JsonPath path = new JsonPath(responseBody);
                             
                               
	}
}
