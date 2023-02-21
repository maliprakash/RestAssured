package com.postrequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_01 {

	//@Test
	public void postReq_01() {
		// payload as string
		
		String reqPaylod = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBasePath("https://reqres.in").setBasePath("/api/users")
	.setBasePath("/api/users")
    .setBody(reqPaylod)
    .setContentType(ContentType.JSON);	
	
	
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
		            
	}
	
	//@Test
	public void postReq_02() throws IOException {
		
		// payload as file
		
		byte[] bytePayload = Files.readAllBytes(Paths.get("target//JsonFilePayload//Json01.json"));
		
		String payload = new String(bytePayload);
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users");
	
	specBuilder.setBody(payload);
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
	
	                 
	}
	//@Test
	public void postReq_03() throws IOException {		
		// java map	
		Map map = new LinkedHashMap();
		map.put("name", "morpheus");
		map.put("job", "leader");
	
		System.out.println(map);
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users");
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

	}
	//@Test
	public void postReq_04() throws IOException {		
		// java list + map
		
		Map map1 = new LinkedHashMap();
		map1.put("name", "morpheus");
		map1.put("job", "leader");
	
		List<Object> arraylist = new ArrayList();
		arraylist.add(map1);
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users")
     .setBody(arraylist)
     .setContentType(ContentType.JSON);	
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
	            
   }
	@Test
	public void postReq_05() throws IOException {		
		// java Collection - list
				
		List<Object> arraylist = new ArrayList();
		arraylist.add("prakash");
		arraylist.add("mali");
		
		//payload   => [prakash, mali]
		System.out.println(arraylist);
		
	RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	
	specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users")
	.setBody(arraylist)
    .setContentType(ContentType.JSON);
	
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
	            
	}	
}
