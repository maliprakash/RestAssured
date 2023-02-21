package com.pojo_03_nested_json_object;

public class Employee {

	// hole payload
	/*
	{
  "id": 1,
  "firstname": "jim",
  "Address": {
    "house": 232,
    "country": "india"
  }
}
=======================================
// in this Employee class 
{
  "id": 1,
  "firstname": "jim",

	 */
	
	private int id;
	private String firstname;
	private Adderess address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Adderess getAddress() {
		return address;
	}
	public void setAddress(Adderess address) {
		this.address = address;
	}
	
	
}
