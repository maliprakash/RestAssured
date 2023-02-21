package com.pojo_01;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class dummy_Api_Req {
	
	@Test
	public void req() {
		
		 /* {
		  "id":1;
		  "firstname": "Jim",
		  "lastname": "Brown",
		  "gender":"male",
		  "address":"maharashtra"
		} */

		student std = new student();
		std.setId(1);
		std.setFirstname("jim");
		std.setLastname("Brown");
		std.setGender("male");
		std.setAddress("india");
		
		RestAssured
		          .given()
		          .log()
		          .all()
		          .body(std)
		          .when()
		          .get()
		          .then()
		          .log();
		       
		       
		
		// output 
		//{"id":1,"firstname":"jim","lastname":"Brown","address":"maharashtra","gender":"male"}
		
		/*
		{
  "id": 1,
  "firstname": "jim",
  "lastname": "Brown",
  "address": "maharashtra",
  "gender": "male"
   }
		  */
		
	}
}
