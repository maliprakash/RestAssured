package com.authontication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuthontication {
	
	@Test
		public void test01() {
			// Digest auth is more secured over the basic auth
			// digest auth foe incoding and decoding uses Alogorithm 
			
			RequestSpecification  requestSpec = RestAssured.given();
			
			//https://postman-echo.com/basic-auth
			requestSpec.baseUri("http://httpbin.org");
			requestSpec.basePath("/digest-auth/undefined/digestauth/digestauth");
			
			// non preemptive basic auth = if the server will ask the credentials then only restassured passess credentials
			// passes the credentials and non premmetive is defaualt type
			Response response = requestSpec.auth().digest("digestauth","digestauth").get();
			
			System.out.println("Response status :" + response.statusLine());
			
			
			
		}
}
