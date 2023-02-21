package com.serilization;
import org.junit.Assert;

import com.deserlization.Deseralize;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class serialization {

	public static void main(String[] args) {
		
	  /*	
	   {
		    "name": "morpheus",
		    "job": "leader"
		}
      */
		
		Person person = new Person();
		person.setName("jhon");
		person.setJob("qa");
		
		System.out.println(person);
	
		
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder.setBaseUri("https://reqres.in");
		specBuilder.setBasePath("/api/users");
		specBuilder.setBody(person);
		specBuilder.setContentType(ContentType.JSON);	
		RequestSpecification reqSecification = specBuilder.build();
		
					Response response = RestAssured.given()
												           .spec(reqSecification)
												           .log()
												           .all()
												           .when()
												           .post();
		
		 ValidatableResponse validatableRes = response.then();
		       
		            String extractRes = validatableRes.log()
		                                              .all()
		                                              .extract()
		                                              .response()
		                                              .asString();

		   
	
	}
}
