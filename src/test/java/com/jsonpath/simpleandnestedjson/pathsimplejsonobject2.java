package com.jsonpath.simpleandnestedjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class pathsimplejsonobject2 {
	
	 @Test
	 public void get_02() throws IOException {
		 
            //json05.json cosider as json response
			byte[] bytePayload = Files.readAllBytes(Paths.get("target//JsonFilePayload//Json05.json"));
			
			String payload = new String(bytePayload);
		 
		    JsonPath jsonpath = new JsonPath(payload);
		 		   
		   // we are not mentioned address[index] explicitly then we will get all the city names
		   Object data1 = jsonpath.get("[0].address.city");		   
		   System.out.println(data1);
		   
		   // here i mentioned explicitly address[0](index) then we will get only 1 index city value
		   Object data2 = jsonpath.get("[0].address[0].city");		   
		   System.out.println(data2);
		   
		   //
		   Object data3 = jsonpath.get("address.city");		   
		   System.out.println(data3);
		   
		 
	           for(int i=0 ; i<1 ; i++) {			   
			   Object data4 = jsonpath.get("["+i+"]");		   
			   System.out.println(data4);
		  
	   }	       
	 }
}

