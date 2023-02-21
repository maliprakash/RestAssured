package com.deleterequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Del_01 {

	@Test
	public void del_01() {
		
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
		
		specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users/2");
		
		RequestSpecification reqBuild = specBuilder.build();
							ValidatableResponse validatableResponse = RestAssured.given()
															           .spec(reqBuild)
															           .log()
															           .all()
															           .when()
															           .delete()
															           .then();
							                       validatableResponse
															           .log()
															           .all()
															           .extract()
															           .response()
															           .asPrettyString();
									
						
							                       validatableResponse.statusCode(204);
							
	}
}
