package com.pojo_04_Object_NestedArray;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class PostRequest {

	@Test
	public void P_01() {
		
		
		Empolyee_01 emp01 = new Empolyee_01();
		emp01.setId(1);
		emp01.setFirstname("jhon");
		
		
		Address01 add = new Address01();
		add.setHouse(111);
		add.setCountry("india");
		
		
		Address01 add1 = new Address01();
		add.setHouse(112);
		add.setCountry("America");
		
		
		List<Address01> addr = new ArrayList<Address01>();
		
		addr.add(add);
		addr.add(add1);
		
		emp01.setAddress(addr);
		
		RestAssured
        .given()
        .log()
        .all()
        .body(emp01)
        .when()
        .post();
		
		//output
		/*{
  "id": 1,
  "firstname": "prakash",
  "address": [
    {
      "house": 111,
      "country": "india"
    },
    {
      "house": 112,
      "country": "America"
    }
  ]
}
 */
		
	}
	
}
