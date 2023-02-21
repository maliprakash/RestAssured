package com.pojo_03_nested_json_object;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UsePayload {
	/*{
		  "id": 1,
		  "firstname": "jim",
		  "Address": {
		    "house": 232,
		    "country": "india"
		  }
		}*/
	
	Employee emp ;
	Adderess adress ; 
	
	@Test
	public void emp_01() {
		//
	    emp= new Employee();
		emp.setId(1);
		emp.setFirstname("jim");
		
		//
		adress = new Adderess();
		adress.setHouse(202);
		adress.setCountry("india");
		
		//
		emp.setAddress(adress);
		
		RestAssured
        .given()
        .log()
        .all()
        .body(emp)
        .when()
        .post();

		//output 
		
	/*	{
			  "id": 1,
			  "firstname": "jim",
			  "address": {
			    "house": 202,
			    "country": "india"
			  }
			}
		*/
				
	}
}
