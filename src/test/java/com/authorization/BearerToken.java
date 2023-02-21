package com.authorization;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {

	@Test
	public void Req_02() {
	     //    https://gorest.co.in/public/v2/users
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in")
	    .basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "jhon");
		payload.put("gender","male");
		payload.put("email", "jhon@1234.com");
		payload.put("status", "Active");
		
		// invalid for demo propose
		String bearerToken = "Bearer af34adaedb1339b3fd8f9768e463";
		
		requestSpec.header("Authorization",bearerToken).
	    contentType(ContentType.JSON).
	//	body(payload.toJSONString());
		body(payload);
		Response response = requestSpec.post();
		
		System.out.println("response status line:" + response.statusLine());
		System.out.println(response.body().asString());
		
	}	
}
