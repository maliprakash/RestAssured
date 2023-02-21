package com.pojo_02_arrayOfObject;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.pojo_01.student;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class dummy_Api_Req_01 {

	@Test
	public void PostReq_01() {
		

		student01 std = new student01();
		std.setId(1);
		std.setFirstname("jim");
		std.setLastname("Brown");
		std.setGender("male");
		std.setAddress("pune");
		
		student01 std1 = new student01();
		std1.setId(1);
		std1.setFirstname("jim1");
		std1.setLastname("Brown1");
		std1.setGender("male1");
		std1.setAddress("pune");
		
		List<student01> jsonarraypayload = new ArrayList();		
		jsonarraypayload.add(std);
		jsonarraypayload.add(std1);
			
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		specBuilder.setBody(jsonarraypayload)
		           .setContentType(ContentType.JSON);
		
		RestAssured
		          .given()
		          .log()
		          .all()
		          .body(jsonarraypayload)
		          .when()
		          .get()
		          .asPrettyString();
		          

// output
		
		/*
		 [
  {
    "id": 1,
    "firstname": "jim",
    "lastname": "Brown",
    "address": "maharashtra",
    "gender": "male"
  },
  {
    "id": 1,
    "firstname": "jim1",
    "lastname": "Brown1",
    "address": "maharashtra1",
    "gender": "male1"
  }
]
		 */
	}
}
