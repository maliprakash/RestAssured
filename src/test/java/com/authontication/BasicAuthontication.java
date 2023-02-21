package com.authontication;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthontication {

	//@Test
	public void test01() {
		// base auth incode and decode using base64
		RequestSpecification  requestSpec = RestAssured.given();
		
		//https://postman-echo.com/basic-auth
		requestSpec.baseUri("https://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		// non preemptive basic auth = if the server will ask the credentials then only restassured will
		// passes the credentials and nonpremmetive is defaualt type
		Response response = requestSpec.auth().basic("postman","password").get();
		
		System.out.println("Response status :" + response.statusLine());
		
		
	}
	
	
	//@Test
	public void test02() {
		
		RequestSpecification  requestSpec = RestAssured.given();
		
		//https://postman-echo.com/basic-auth
		requestSpec.baseUri("https://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		// preemptive basic auth we are implicitlly passess the auth credentials 
		// server withought asking any credentials , inbuilt the credentials with request and passes
		Response response = requestSpec.auth().preemptive().basic("postman","password").get();
		
		System.out.println("Response status :" + response.statusLine());
		
		
	}
	
	//@Test
	public void test03() {
		  String userName = "postman" , password = "password";
		  
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBaseUri("https://postman-echo.com") 
		           .setBasePath("/basic-auth");
		          
		RequestSpecification buildRequest = specBuilder.build();
		buildRequest.auth().basic(userName,password);
	
		RestAssured.given()
		           .spec(buildRequest)
		           .log()
		           .all()
		           .when()
		           .get()
		           .then()
		           .log()
		           .all()
		           .extract()
		           .response()
		           .asPrettyString();
						
	}
	/*@Test
	public void test04() {
		String credentials = "postman:password";	
	       byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());	
	       String encodedCredentialsString = new String(encodedCredentials);
	       
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBaseUri("https://postman-echo.com") 
		           .setBasePath("/basic-auth")
		           .addHeader("Authorization", encodedCredentialsString);
		RequestSpecification buildRequest = specBuilder.build();
		
		RestAssured.given()
		           .spec(buildRequest)
		           .log()
		           .all()
		           .when()
		           .get()
		           .then()
		           .log()
		           .all()
		           .extract()
		           .response()
		           .asPrettyString();
		
				
	}*/
		
 // @Test
	public void basic_01() {
	
			String credentials = "maliprakash7784@gmail.com : Mali@7784";	
	       byte[] encodedcredentials = Base64.encodeBase64(credentials.getBytes());
		
	       String encodedcredentialsString = new String(encodedcredentials);
	       
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBaseUri("https://bookstore.toolsqa.com/BookStore/v1/Books");			
		specBuilder.setContentType(ContentType.JSON);
		specBuilder.addHeader("Authorization","Basic "+encodedcredentialsString);
		RequestSpecification buildrequest = specBuilder.build();
		
		String response = RestAssured.given()
							           .spec(buildrequest)
							          .log()
							          .all()
							          .when()
							          .get()
							          .then()
							          .log()
							          .all()
							          .extract()
							          .response()
							          .asString();
							          
			System.out.println(response);				           
		           
		        
	}
	//@Test
	public void basic_02() {
		// bearere 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
			String credentials = "maliprakash7784@gmail.com : Mali@7784";	
	       byte[] encodedcredentials = Base64.encodeBase64(credentials.getBytes());
		
	       String encodedcredentialsString = new String(encodedcredentials);
	       
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBaseUri("https://bookstore.toolsqa.com").setBasePath("/swagger/None#/BookStore/BookStoreV1BookGet");
		specBuilder.setContentType(ContentType.JSON);
	    specBuilder.addHeader("Authorization","Basic "+encodedcredentialsString);
		RequestSpecification buildrequest = specBuilder.build();
	
		String response = RestAssured.given()
							           .spec(buildrequest)
							          .log()
							          .all()
							          .when()
							          .get()
							          .then()
							          .log()
							          .all()
							          .extract()
							          .response()
							          .asPrettyString();
							          
			System.out.println(response);				           
		           
		        
	}
	@Test
	public void basic_03() {
		// bearere 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
			String credentials = "maliprakash7784@gmail.com : Mali@7784";	
	       byte[] encodedcredentials = Base64.encodeBase64(credentials.getBytes());
		
	       String encodedcredentialsString = new String(encodedcredentials);
	       
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBaseUri("https://bookstore.toolsqa.com").setBasePath("/swagger/None#/BookStore/BookStoreV1BookGet");
	
		specBuilder.setContentType(ContentType.JSON);
	//	specBuilder.addHeader("Authorization","Basic "+encodedcredentialsString);
		RequestSpecification buildrequest = specBuilder.build();
	
		String response = RestAssured.given()
							           .spec(buildrequest)
							          .log()
							          .all()
							          .when()
							          .get()
							          .then()
							          .log()
							          .all()
							          .extract()
							          .response()
							          .asPrettyString();
							          
			System.out.println(response);				           
		           
		        
	}
	}

