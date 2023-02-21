package com.authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Oauth2 {
	
	static String accesstoken;
	
	@Test
	public void getAccessToken() {
		
		//https://api-m.sandbox.paypal.com/v1/oauth2/token
	    // dummy credentials for demo
		String clientid = "NmWnInbVi02Gcwa962Ayty4g8_ZyKeW5645647456a4-YYsI6iq";
        String clientsecret = "YI4baOc1xDqrgr4yhgJxbfggjfthybcn4556573547fd_wkF7R";
    

						
	RequestSpecification requestSpec = RestAssured.given();
	requestSpec.baseUri("https://api-m.sandbox.paypal.com");
	requestSpec.basePath("/v1/oauth2/token");
	
	// basic auth
	 Response response = requestSpec.auth().preemptive().basic(clientid,clientsecret ).param("grant", "credentials").post();
	
	String data = response.prettyPrint();
	String status = response.statusLine();
	System.out.println(status);
	
	JsonPath jsonpath = new JsonPath(data);
	
	accesstoken = jsonpath.get("access_token");
	
	System.out.println(accesstoken);
	
	}
	@Test()
	public void getRequest() {
		   // dummy credentials for demo
		Response res = RestAssured.given().auth().oauth2(accesstoken)
											 .queryParam("page","3")
											 .queryParam("page_size","4")
											 .queryParam("total_count_required",true )
											 .get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		res.prettyPrint();
		
	}	
}
