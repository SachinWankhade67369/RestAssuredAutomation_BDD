package serializationDeserilizationConcept;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


/*
 * JSON Data:
 * Student API
 * 
  {
  		"id" :101,
  		"FirstName" : "Sachin",
  		"LastName" : "Wankhade",
  		"email" : "abc@gmail.com",
  		"programme" : "QA"
  		courses : [
  				"Java",
  				"Selenium"
   				]
   
  }
 
 * 
 */

public class StudentAPITestNoSerialization {

	public HashMap map = new HashMap();
	
	
	//Post Request will create a new Student Record
	@Test(priority = 1)
	public void createNewStudent() {
		
		map.put("id", 101);
		map.put("FirstName", "Sachin");
		map.put("LastName", "Wankhade");
		map.put("email", "abc@gmail.com");
		map.put("programme", "QA");
		
		//for multiple data, we take Arraylist to store it.
		ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Selenium");
		
		map.put("courses", courseList);
		
		given()
			
			.contentType(ContentType.JSON)
			.body(map)
			
	   .when()
	   	
	   		.post("http://localhost:8085/student")
	   		
	   	.then()
	   	
	   		.statusCode(201)
	   		.assertThat()
	   		.body("msg", equalTo("Student added"));
			
		
	}
	
	
	//Get Request to retrive Student details
	@Test(priority = 2)
	public void getStudentRecord() {
		
		given()
		
		.when()
		
			.get("http://localhost:8085/student")
			
		.then()
		
			.statusCode(200)
			.assertThat()
			.body("id", equalTo("101"))
			.log().all();
		
		
		
		
		
		
	}
	
	
}
