package com.concepts;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqSpec_ResSpec {
	@Test
		public void getReq_01() {
		
		  //for request inputs
		  RequestSpecBuilder specBuilder = new RequestSpecBuilder(); 
		  specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users?").addQueryParam("page", 2);
		  RequestSpecification reqBuild = specBuilder.build();
		  
		  //for response validation
		  ResponseSpecification resSpec = RestAssured.expect();		  
		  resSpec .statusCode(200)
				  .contentType(ContentType.JSON)
				  .time(Matchers.lessThan(9000L));
		  		  
		 RestAssured.
		             given()
		            .spec(reqBuild)
		            .when()
		            .get()
		            .then()
		            .spec(resSpec)
		            .log()
		            .all()
		            .extract()
		            .response()
		            .asPrettyString();
		 
		}
}
