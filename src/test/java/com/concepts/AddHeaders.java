package com.concepts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class AddHeaders {
	
	// multiple ways to use Headers in RestAssured
	
	//@Test
	public void getReq_01() {
		
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
			 
		 specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users?").addQueryParam("page", "2");
	
		 specBuilder.addHeader("header","header1");
		 RequestSpecification reqBuild = specBuilder.build();
		   
		 RestAssured.
		             given()
		             .log()
		             .all()
		            .spec(reqBuild)
		            .when()
		            .get()
		            .then()
		            .log()
		            .all()
		            .extract()
		            .response()
		            .toString();
		 
		}
	
	@Test
	public void getReq_02() {
		
		RestAssured
		           .given()
		           .log()
		           .all()
		           .header("header1", "value1")
		           .when()
		           .get();
		
	}@Test
	public void getReq_03() {
		
		RestAssured
		           .given()
		           .log()
		           .all()
		           .header("header","value1","value2","value3","value4")
		           .when()
		           .get();
		
	}
	@Test
	public void getReq_04() {
		
		Header header = new Header("Header1","value1");
		
		RestAssured
		           .given()
		           .log()
		           .all()
		           .header(header)
		           .when()
		           .get();
		
	}
	@Test
	public void getReq_05() {
		
	
		RestAssured
		           .given()
		           .log()
		           .all()
		           .headers("h1","v1","h2","v2","h3","v3")
		           .when()
		           .get();
		
	}
	@Test
	public void getReq_06() {
		
		Map<String,String> headerMap = new HashMap<String,String>();
	    headerMap.put("h1", "v1");
	    headerMap.put("h2", "v2");
	    headerMap.put("h3", "v3");
		
		
		RestAssured
		           .given()
		           .log()
		           .all()
		           .headers(headerMap)
		           .when()
		           .get();
		
	}
	
	@Test
	public void getReq_07() {	
		
	List<Header> allHeaders = new ArrayList<Header>();
		
	Header header1 = new Header("Header1","value1");
	Header header2 = new Header("Header2","value2");	
	
	allHeaders.add(header1);
	allHeaders.add(header2);
	
	
	Headers headers = new Headers(allHeaders);
	
		RestAssured
		           .given()
		           .log()
		           .all()
		           .headers(headers)
		           .when()
		           .get();
		
	}
	
}
