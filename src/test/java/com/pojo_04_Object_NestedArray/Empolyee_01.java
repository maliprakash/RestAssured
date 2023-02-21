package com.pojo_04_Object_NestedArray;

import java.util.List;

public class Empolyee_01 {

 /*
 {
  "id": 1,
  "firstname": "jim",
  "address": [
    {
      "house": 202,
      "country": "india"
    },
    {
      "skill": 202,
      "laptop": "dell"
    }
  ]
}
  */	private int id;
		private String firstname;
    private List<Address01> address;
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

    public List<Address01> getAddress() {
		return address;
	}
	public void setAddress(List<Address01> address) {
		this.address = address;
	}

	
	
	
	
	
}
