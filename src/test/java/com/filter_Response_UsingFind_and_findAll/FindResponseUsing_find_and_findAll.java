package com.filter_Response_UsingFind_and_findAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FindResponseUsing_find_and_findAll {

	String projectPath = System.getProperty("user.dir");
	
	
	
	@Test
	public void response() throws IOException {
		
		                              // this file considered as responseBody
byte[] consideAsResponseFile = Files.readAllBytes(Paths.get(projectPath+"\\target\\JsonFilePayload\\json02.json"));
	
	String strrsponse = new String(consideAsResponseFile);
	
	JsonPath jsonpath = new JsonPath(strrsponse);
	
	
	Object responsearr = jsonpath.get("[0]");	
	System.out.println(responsearr);
		
	Object responsearr1 = jsonpath.get("[0].first_name");	
	System.out.println(responsearr1);
	
	List<Object> allfirstnames = jsonpath.getList("first_name");	
	System.out.println(allfirstnames);
		
	List<String> firstName = jsonpath.getList("findAll{it.gender == 'female'}.first_name");
	System.out.println(firstName);
	
	String gettheemail = jsonpath.getString("find{it.first_name == 'Byron'}.email");
	
	System.out.println("email :" + gettheemail);
	
	String getfnamelname = jsonpath.getString("find{it.first_name == 'Byron' & it.last_name == 'Fields'}.email");
	
	System.out.println(getfnamelname);
	
    String getname = jsonpath.getString("find{it.id == '122' | it.last_name == 'Fields'}.first_name");
	
	System.out.println(getname);
	
	List<Object> firstnameusingfindAll = jsonpath.getList("findAll{it.id == '122' | it.last_name == 'Fields'}.first_name");
		
    System.out.println(firstnameusingfindAll);
		
    List<Object> firstnameusingfindAllandOperator = jsonpath.getList("findAll{it.id == '122' & it.last_name == 'Fields'}.first_name");
	
    System.out.println(firstnameusingfindAllandOperator);
	
    List<Object> firstnameusingnotequalto = jsonpath.getList("findAll{it.id == '122' != it.last_name == 'Fields'}.first_name");
	
    System.out.println(firstnameusingnotequalto);

	List<Object> findfirstnames = jsonpath.getList("findAll{it.id <= 8}.first_name");
	
	System.out.println(findfirstnames);
	
	int arrsize = jsonpath.getInt("size()");

	System.out.println("size of jsonarr response size   " + arrsize);
	
	
	
	}
}
