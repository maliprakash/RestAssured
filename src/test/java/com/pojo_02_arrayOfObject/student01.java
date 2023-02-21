package com.pojo_02_arrayOfObject;

public class student01 {
	
	private int id;
	private String firstname;
	private String lastname;
	private String address;
	private String gender;
	
	/*
	    // create te below payload using pojo
	[
  {
    "id": 1,
    "firstname": "jim",
    "lastname": "Brown",
    "address": "maharashtra",
    "gender": "male"
  },
  {
    "id": 1,
    "firstname": "jim1",
    "lastname": "Brown1",
    "address": "maharashtra1",
    "gender": "male1"
  }
]
	 */
	
	
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
