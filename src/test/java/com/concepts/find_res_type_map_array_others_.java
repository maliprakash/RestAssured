package com.concepts;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class find_res_type_map_array_others_ {

	// verify the hole response body is map(json object) or list(json array)
	//@Test
		public void getReq_01() {
			
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
			 
		 specBuilder.setBaseUri("https://reqres.in/api/users?page=2");

		  RequestSpecification reqBuild = specBuilder.build();
		  
		 RestAssured.
		             given()
		            .spec(reqBuild)
		            .when()
		            .get()
		            .then() // "" and $  => specified hole reponse
		            .body("",Matchers.instanceOf(Map.class))
		            .log()
		            .all()
		            .extract()
		            .response()
		            .toString();
		 
		}	
	
	// verify the nested filed in json response is map(json object) or list(json array)
		@Test
			public void getReq_02() {
				
			 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
				 
			 specBuilder.setBaseUri("https://reqres.in/api/users?page=2");

			 RequestSpecification reqBuild = specBuilder.build();
			  
			 RestAssured.
			             given()
			            .spec(reqBuild)
			            .when()
			            .get()
			            .then() // if we verify nested then use key
			            .body("data",Matchers.instanceOf(List.class))
			            .log()
			            .all()
			            .extract()
			            .response()
			            .toString();
			 
			}	
		// verify the nested filed in json response is map(json object) or list(json array)
				@Test
					public void getReq_03() {
						
					 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
						 
					 specBuilder.setBaseUri("https://reqres.in/api/users?page=2");

					  RequestSpecification reqBuild = specBuilder.build();
					  
					 RestAssured.
					             given()
					            .spec(reqBuild)
					            .when()
					            .get()
					            .then() // if we verify specific then use key
					            .body("total",Matchers.instanceOf(int.class))
					            .log()
					            .all()
					            .extract()
					            .response()
					            .toString();
					 
					}	
	
              }
