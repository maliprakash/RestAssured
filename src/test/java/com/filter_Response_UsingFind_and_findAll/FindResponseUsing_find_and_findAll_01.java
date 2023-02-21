package com.filter_Response_UsingFind_and_findAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FindResponseUsing_find_and_findAll_01 {

	@Test
	public void response() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		
byte[] consideAsResponseFile = Files.readAllBytes(Paths.get(projectPath+"\\target\\JsonFilePayload\\json03.json"));
	
	String strrsponse = new String(consideAsResponseFile);
	
	JsonPath jsonpath = new JsonPath(strrsponse);
	
	Object zeroindexdata = jsonpath.get("data[0]");
	
	System.out.println(zeroindexdata);
	
	List<String> firstName = jsonpath.getList("data.findAll{it.gender == 'female'}.first_name");
	System.out.println(firstName);
	
	}
}
