package com.deserlization;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostReq {
	                      //convert json response into java object it is also known as deserialization      
	String desclass ;
	
	@Test
	public void postReq_03() throws IOException {		
		// java map
		
		Map map = new LinkedHashMap();
		map.put("name", "jhon");
		map.put("job", "QA");
	
		System.out.println(map);
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBaseUri("https://reqres.in");
	specBuilder.setBasePath("/api/users");
	specBuilder.setBody(map);
	specBuilder.setContentType(ContentType.JSON);	
	RequestSpecification reqSecification = specBuilder.build();
	
				Response response = RestAssured.given()
											           .spec(reqSecification)
											           .log()
											           .all()
											           .when()
											           .post();
	
	 ValidatableResponse validatableRes = response.then();
	       
	            String extractRes = validatableRes.log()
	                                              .all()
	                                              .extract()
	                                              .response()
	                                              .asString();

	      ResponseBody responseBody = response.getBody();
	      
	      // desearlization responsebody 
	      	
	      //Deseralize desclass = responseBody .as(Deseralize.class);
	      
	      Deseralize dclass = responseBody.as(Deseralize.class);
	  
	      System.out.println("-------------------------------------------------------------------------------------------");
	      
	      System.out.println("student id " + dclass.getId());
	      System.out.println("student name "+ dclass.getName());
	      System.out.println("job  "+ dclass.getJob());
          System.out.println("createdAt " + dclass.createdAt);
          
	}
}
