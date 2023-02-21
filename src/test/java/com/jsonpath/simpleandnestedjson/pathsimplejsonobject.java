package com.jsonpath.simpleandnestedjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class pathsimplejsonobject {

	
	 @Test
	 public void get_01() throws IOException {
		 
                //json05.json cosider as json response
			byte[] bytePayload = Files.readAllBytes(Paths.get("target//JsonFilePayload//Json05.json"));
			
			String payload = new String(bytePayload);
		 
		   JsonPath jsonpath = new JsonPath(payload);
		 
		 jsonpath.get();
	 }
		@Test
		public void getReq_02() {
			
		 RequestSpecBuilder specBuilder = new RequestSpecBuilder();
			 
		 specBuilder.setBaseUri("https://reqres.in").setBasePath("/api/users").addQueryParam("page", 2);
     
		  RequestSpecification reqBuild = specBuilder.build();
		   
					 Response response = RestAssured.
										             given()
										            .spec(reqBuild)
										            .log()
										            .all()
										            .when()
										            .get();
	   ValidatableResponse validatbleRes = response .then();
								            								            		 
		        String ResponseBody= validatbleRes   .log()
										            .all()
										            .extract()
										            .response()
										            .asString();
						            
		                              validatbleRes.assertThat()
		                                            .statusCode(200)
		                                            .statusLine("HTTP/1.1 200 OK");
		                                                                                     
		               JsonPath jsonpath = new JsonPath(ResponseBody);  
		         
		             
		            // the value will you recive integer but we use return type string 
		            // in this reason class cast exception is occured
		            //  String totalpageNo = jsonpath.get("total_pages");  
		            //  System.out.println(totalpageNo);
		            
		            // we cant convert string "java" into integer
		            // then we get numberformat exception
		            //  String s = "java";
		            //  System.out.println(Integer.parseInt(s));
		            
		               
		            // here we will not get any exception "123" we will convert into int
		            String no = "123";
		            System.out.println(Integer.parseInt(no));
		            
		           	            
		            // jsonpath.get("$") this will gives us root of the response
		            Object rootjsonresponse = jsonpath.get("$");
		            System.out.println(rootjsonresponse);
		            
		            Object datazeroindex = jsonpath.get("data[0]");
		            System.out.println(datazeroindex);
		           
		            Object datazerofname = jsonpath.get("data[0].first_name");
		            System.out.println(datazerofname);
		            
		         
		            // will get all first_name [George, Janet, Emma, Eve, Charles, Tracey]
		            // because we will not specified data[index] so this reason
		            List<Object> datafirstname = jsonpath.getList("data.first_name");
		            System.out.println(datafirstname);
		            
		            
		            
		            // get the size of the key data[array]
		            int dataarrsize = jsonpath.get("data.size()");
		            System.out.println(dataarrsize);
		         
		            
		            for(int i=0 ; i<dataarrsize ;i++) {
		            	
		            	Object firstname = jsonpath.get("data["+i+"].first_name");
		            	System.out.println("firstname :"+firstname);
		            	Object lastname = jsonpath.get("data["+i+"].last_name");
		            	System.out.println("lastname :"+lastname);
		           
		            }
		    }	
    }

