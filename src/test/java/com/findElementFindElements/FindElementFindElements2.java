package com.findElementFindElements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FindElementFindElements2 {

	@Test
	public void response() throws IOException {
		
byte[] consideAsResponseFile = Files.readAllBytes(Paths.get("C:\\Users\\DELL\\eclipse-workspace\\RApi01\\target\\JsonFilePayload\\json03.json"));
	
	String strrsponse = new String(consideAsResponseFile);
	
	JsonPath jsonpath = new JsonPath(strrsponse);
	
	Object zeroindexdata = jsonpath.get("data[0]");
	
	System.out.println(zeroindexdata);
	
	List<String> firstName = jsonpath.getList("data.findAll{it.gender == 'female'}.first_name");
	System.out.println(firstName);
	
	}
}
